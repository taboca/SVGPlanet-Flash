    }
    else {
      this._state = this._processComplexElement(elementInfo, attributes);
    }
  },

  // In the endElement handler, we decrement the stack and look
  // for cleanup/transition functions to execute. The second part
  // of the state transition works as above in startElement, but
  // the state we're looking for is prefixed with an underscore
  // to distinguish endElement events from startElement events.
  endElement:  function FP_endElement(uri, localName, qName) {
    var elementInfo = this._handlerStack[this._depth];
    //LOG("</" + localName + ">");
    if (elementInfo && !elementInfo.isWrapper)
      this._closeComplexElement(elementInfo);
  
    // cut down xml:base context
    if (this._xmlBaseStack.length == this._depth + 1)
      this._xmlBaseStack = this._xmlBaseStack.slice(0, this._depth);

    // our new state is whatever is at the top of the stack now
    if (this._stack.length > 0)
      this._state = this._stack[this._stack.length - 1][1];
    this._handlerStack = this._handlerStack.slice(0, this._depth);
    --this._depth;
  },

  // Buffer up character data. The buffer is cleared with every
  // opening element.
  characters: function FP_characters(data) {
    this._buf += data;
  },
  // TODO: It would be nice to check new prefixes here, and if they
  // don't conflict with the ones we've defined, throw them in a 
  // dictionary to check.
  startPrefixMapping: function FP_startPrefixMapping(prefix, uri) {
    // Thanks for QNames in content, W3C
    // This will even be a perf hit for every single feed
    // http://www.w3.org/WAI/PF/GUI/
    if (prefix && uri == WAIROLE_NS) 
      this._waiPrefixes[prefix] = WAIROLE_NS;
  },
  
  endPrefixMapping: function FP_endPrefixMapping(prefix) {
    if (prefix)
      delete this._waiPrefixes[prefix];
  },
  
  processingInstruction: function FP_processingInstruction(target, data) {
    if (target == "xml-stylesheet") {
      var hrefAttribute = data.match(/href=[\"\'](.*?)[\"\']/);
      if (hrefAttribute && hrefAttribute.length == 2) 
        this._result.stylesheet = gIoService.newURI(hrefAttribute[1], null,
                                                    this._result.uri);
    }
  },

  // end of nsISAXContentHandler

  // Handle our more complicated elements--those that contain
  // attributes and child elements.
  _processComplexElement:
  function FP__processComplexElement(elementInfo, attributes) {
    var obj, key, prefix;

    // If the container is an entry/item, it'll need to have its 
    // more esoteric properties put in the 'fields' property bag.
    if (elementInfo.containerClass == Cc[ENTRY_CONTRACTID]) {
      obj = elementInfo.containerClass.createInstance(Ci.nsIFeedEntry);
      obj.baseURI = this._xmlBaseStack[this._xmlBaseStack.length - 1];
      this._mapAttributes(obj.fields, attributes);
    }
    else if (elementInfo.containerClass) {
      obj = elementInfo.containerClass.createInstance(Ci.nsIFeedElementBase);
      obj.baseURI = this._xmlBaseStack[this._xmlBaseStack.length - 1];
      obj.attributes = attributes; // just set the SAX attributes
    }
    else {
      obj = Cc[BAG_CONTRACTID].createInstance(Ci.nsIWritablePropertyBag2);
      this._mapAttributes(obj, attributes);
    }

    // We should have a container/propertyBag that's had its
    // attributes processed. Now we need to attach it to its
    // container.
    var newProp;

    // First we'll see what's on top of the stack.
    var container = this._stack[this._stack.length - 1][0];

    // Check to see if it has the property
    var prop;
    try {
      prop = container.getProperty(elementInfo.fieldName);
    }
    catch(e) {
    }
    
    if (elementInfo.isArray) {
      if (!prop) {
        container.setPropertyAsInterface(elementInfo.fieldName,
                                         Cc[ARRAY_CONTRACTID].
                                         createInstance(Ci.nsIMutableArray));
      }

      newProp = container.getProperty(elementInfo.fieldName);
      // XXX This QI should not be necessary, but XPConnect seems to fly
      // off the handle in the browser, and loses track of the interface
      // on large files. Bug 335638.
      newProp.QueryInterface(Ci.nsIMutableArray);
      newProp.appendElement(obj,false);
      
      // If new object is an nsIFeedContainer, we want to deal with
      // its member nsIPropertyBag instead.
      if (isIFeedContainer(obj))
        newProp = obj.fields; 

    }
    else {
      // If it doesn't, set it.
      if (!prop) {
        container.setPropertyAsInterface(elementInfo.fieldName,obj);
      }
      newProp = container.getProperty(elementInfo.fieldName);
    }
    
    // make our new state name, and push the property onto the stack
    var newState = "IN_" + elementInfo.fieldName.toUpperCase();
    this._stack.push([newProp, newState, obj]);
    return newState;
  },

  // Sometimes we need reconcile the element content with the object
  // model for a given feed. We use helper functions to do the
  // munging, but we need to identify array types here, so the munging
  // happens only to the last element of an array.
  _closeComplexElement: function FP__closeComplexElement(elementInfo) {
    var stateTuple = this._stack.pop();
    var container = stateTuple[0];
    var containerParent = stateTuple[2];
    var element = null;
    var isArray = isIArray(container);

    // If it's an array and we have to post-process,
    // grab the last element
    if (isArray)
      element = container.queryElementAt(container.length - 1, Ci.nsISupports);
    else
      element = container;

    // Run the post-processing function if there is one.
    if (elementInfo.closeFunc)
      element = elementInfo.closeFunc(this._buf, element);

    // If an nsIFeedContainer was on top of the stack,
    // we need to normalize it
    if (elementInfo.containerClass == Cc[ENTRY_CONTRACTID])
      containerParent.normalize();

    // If it's an array, re-set the last element
    if (isArray)
      container.replaceElementAt(element, container.length - 1, false);
  },
  
  _prefixForNS: function FP_prefixForNS(uri) {
    if (!uri)
      return "";
    var prefix = gNamespaces[uri];
    if (prefix)
      return prefix + ":";
    if (uri.toLowerCase().indexOf("http://backend.userland.com") == 0)
      return "";
    else
      return null;
  },

  _mapAttributes: function FP__mapAttributes(bag, attributes) {
    // Cycle through the attributes, and set our properties using the
    // prefix:localNames we find in our namespace dictionary.
    for (var i = 0; i < attributes.length; ++i) {
      var key = this._prefixForNS(attributes.getURI(i)) + attributes.getLocalName(i);
      var val = attributes.getValue(i);
      bag.setPropertyAsAString(key, val);
    }
  },

  // Only for RSS2esque formats
  _findRSSVersion: function FP__findRSSVersion(attributes) {
    var versionAttr = trimString(attributes.getValueFromName("", "version"));
    var versions = { "0.91":"rss091",
                     "0.92":"rss092",
                     "0.93":"rss093",
                     "0.94":"rss094" }
    if (versions[versionAttr])
      return versions[versionAttr];
    if (versionAttr.substr(0,2) != "2.")
      return "rssUnknown";
    return "rss2";
  },

  // unknown element values are returned here. See startElement above
  // for how this works.
  returnFromExtHandler:
  function FP_returnExt(uri, localName, chars, attributes) {
    --this._depth;

    // take control of the SAX events
    this._reader.contentHandler = this;
    if (localName == null && chars == null)
      return;

    // we don't take random elements inside rdf:RDF
    if (this._state == "IN_RDF")
      return;
    
    // Grab the top of the stack
    var top = this._stack[this._stack.length - 1];
    if (!top) 
      return;

    var container = top[0];
    // Grab the last element if it's an array
    if (isIArray(container)) {
      var contract = this._handlerStack[this._depth].containerClass;
      // check if it's something specific, but not an entry
      if (contract && contract != Cc[ENTRY_CONTRACTID]) {
        var el = container.queryElementAt(container.length - 1, 
                                          Ci.nsIFeedElementBase);
        // XXX there must be a way to flatten these interfaces
        if (contract == Cc[PERSON_CONTRACTID]) 
          el.QueryInterface(Ci.nsIFeedPerson);
        else
          return; // don't know about this interface

        var propName = localName;
        var prefix = gNamespaces[uri];

        // synonyms
        if ((uri == "" || 
             prefix &&
             ((prefix.indexOf("atom") > -1) ||
              (prefix.indexOf("rss") > -1))) && 
            (propName == "url" || propName == "href"))
          propName = "uri";
        
        try {
          if (el[propName] !== "undefined") {
            var propValue = chars;
            // convert URI-bearing values to an nsIURI
            if (propName == "uri") {
              var base = this._xmlBaseStack[this._xmlBaseStack.length - 1];
              propValue = strToURI(chars, base);
            }
            el[propName] = propValue;
          }
        }
        catch(e) {
          // ignore XPConnect errors
        }
        // the rest of the function deals with entry- and feed-level stuff
        return; 
      } 
      else {
        container = container.queryElementAt(container.length - 1, 
                                             Ci.nsIWritablePropertyBag2);
      }
    }
    
    // Make the buffer our new property
    var propName = this._prefixForNS(uri) + localName;

    // But, it could be something containing HTML. If so,
    // we need to know about that.
    if (this._textConstructs[propName] != null &&
        this._handlerStack[this._depth].containerClass !== null) {
      var newProp = Cc[TEXTCONSTRUCT_CONTRACTID].
                    createInstance(Ci.nsIFeedTextConstruct);
      newProp.text = chars;
      // Look up the default type in our table
      var type = this._textConstructs[propName];
      var typeAttribute = attributes.getValueFromName("","type");
      if (this._result.version == "atom" && typeAttribute != null) {
        type = typeAttribute;
      }
      else if (this._result.version == "atom03" && typeAttribute != null) {
        if (typeAttribute.toLowerCase().indexOf("xhtml") >= 0) {
          type = "xhtml";
        }
        else if (typeAttribute.toLowerCase().indexOf("html") >= 0) {
          type = "html";
        }
        else if (typeAttribute.toLowerCase().indexOf("text") >= 0) {
          type = "text";
        }
      }
      
      // If it's rss feed-level description, it's not supposed to have html
      if (this._result.version.indexOf("rss") >= 0 &&
          this._handlerStack[this._depth].containerClass != ENTRY_CONTRACTID) {
        type = "text";
      }
      newProp.type = type;
      newProp.base = this._xmlBaseStack[this._xmlBaseStack.length - 1];
      container.setPropertyAsInterface(propName, newProp);
    }
    else {
      container.setPropertyAsAString(propName, chars);
    }
  },

  // Sometimes, we'll hand off SAX handling duties to an XHTMLHandler
  // (see above) that will scrape out non-XHTML stuff, normalize
  // namespaces, and remove the wrapper div from Atom 1.0. When the
  // XHTMLHandler is done, it'll callback here.
  returnFromXHTMLHandler:
  function FP_returnFromXHTMLHandler(chars, uri, localName, qName) {
    // retake control of the SAX content events
    this._reader.contentHandler = this;

    // Grab the top of the stack
    var top = this._stack[this._stack.length - 1];
    if (!top) 
      return;
    var container = top[0];

    // Assign the property
    var newProp =  newProp = Cc[TEXTCONSTRUCT_CONTRACTID].
                   createInstance(Ci.nsIFeedTextConstruct);
    newProp.text = chars;
    newProp.type = "xhtml";
    newProp.base = this._xmlBaseStack[this._xmlBaseStack.length - 1];
    container.setPropertyAsInterface(this._prefixForNS(uri) + localName,
                                     newProp);
    
    // XHTML will cause us to peek too far. The XHTML handler will
    // send us an end element to call. RFC4287-valid feeds allow a
    // more graceful way to handle this. Unfortunately, we can't count
    // on compliance at this point.
    this.endElement(uri, localName, qName);
  },

  // XPCOM stuff
  classDescription: FP_CLASSNAME,
  classID: FP_CLASSID,
  contractID: FP_CONTRACTID,
  QueryInterface: XPCOMUtils.generateQI(
    [Ci.nsIFeedProcessor, Ci.nsISAXContentHandler, Ci.nsISAXErrorHandler,
     Ci.nsIStreamListener, Ci.nsIRequestObserver]
  )
}

var components = [FeedProcessor, FeedRe