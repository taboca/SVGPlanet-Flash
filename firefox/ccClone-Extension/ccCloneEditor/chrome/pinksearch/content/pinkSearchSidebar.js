////
/// Copyright (C) 2007 Marcio Galli - Taboca Inc and pinktheme.com
//


var gWin = null;

function OnLoad() {

    try {
        var wm = Components.classes["@mozilla.org/appshell/window-mediator;1"]
                          .getService(Components.interfaces.nsIWindowMediator);
        
        gWin = wm.getMostRecentWindow("navigator:browser");
    } catch (i) {
    }
    

}
////
/// debug
//
function dump(str) {
            var cs = Components.classes["@mozilla.org/consoleservice;1"]
                               .getService(Components.interfaces.nsIConsoleService);

            cs.logStringMessage("ccp: " + str);
}

////
/// High level function
//
function ccp_postLoop() {

    mu_willPublishImages();
    

}

function ccp_launchLogin() {

   gWin.gBrowser.selectedTab = gWin.gBrowser.addTab('chrome://pinksearch/content/login.html');

}

function ccp_grabWindow() {



}

function ccp_attackDom() {

    try {

        var doc =  document.commandDispatcher.focusedWindow.document;
        
        var newElement = doc.createElement("div");
        newElement.setAttribute("style","border:1px solid red;width:100px;height:100px");
        doc.body.appendChild(newElement); 

        var divElements = doc.getElementsByTagName("div");
        
        
        for(var i=0;i<divElements.length;i++) {
        
            var cur = divElements[i];
            
            tt_arrayIMG[i] = searchLinearNode("IMG",cur);
            tt_arrayP[i]   = searchLinearNode("P",cur);
            tt_arrayH2[i]  = searchLinearNode("H2",cur);
            
        }

        ccp_createTable();

    } catch(i) {
     dump(i);
    }
    
}

function searchLinearNode(tagNameRef,parentNode) {

    var refNode=parentNode.firstChild;
    
    while(refNode) {
    
        if(refNode.nodeType==1) {
        
            if(refNode.nodeName==tagNameRef) {
                return refNode;
            }
        
        }
        refNode=refNode.nextSibling;
        
    }
    return null;

}



////
/// Options to the ccPhotos app
//
var tt_arrayChecked=new Array();

var tt_arrayForms = []; 
var tt_arrayControls = [];
var tt_arrayFiles = [];
var tt_arrayHitId = [];

var tt_arrayIMG = [];
var tt_arrayP = [];
var tt_arrayH2 = [];

var turk_gGlobalTemplateDoc = null;

var arrayImagesSequenced = new Array();


function ccp_createTable() {

    try { 
    
        gWin.gBrowser.selectedTab = gWin.gBrowser.addTab('chrome://pinksearch/content/blank.html');

        setTimeout("ccp_createDelayedTable()",3000);

    } catch(i) { dump(i) }

}

function ccp_createDelayedTable() {

    try { 

	    turk_gGlobalTemplateDoc = turk_openTemplateDoc("chrome://pinksearch/content/templates/ccphotos-mturk.xml");

	    pDoc = gWin.gBrowser.selectedBrowser.contentDocument;

 	    var e_table = pDoc.createElement("table"); 
     	
	    pDoc.body.appendChild(e_table);

        var validCounter = 0;
        
	    for(var i=0;i<tt_arrayIMG.length;i++) {
    		
		    var title  = tt_arrayH2[i].firstChild.nodeValue;
            var desc   = tt_arrayP[i].firstChild.nodeValue;
		    var urlsrc = tt_arrayIMG[i].getAttribute("src");

			    turk_generateForm(e_table,urlsrc,validCounter);
			    validCounter++;
    		
	    }
   } catch (i) { dump("delayedTable: "+i) }
   	
}



function turk_openTemplateDoc(refTemplateLocalPath) {

try { 
		var req = new XMLHttpRequest();
		req.open('GET', refTemplateLocalPath, false); 
		req.send(null);
		return req.responseXML;
} catch(i) { dump("open template: "+i) }

}



function turk_generateForm(elRef,refPath,ii) {

	pDoc = gWin.gBrowser.selectedBrowser.contentDocument;

	var e_tr = pDoc.createElement("tr");

	var e_td = pDoc.createElement("td");
	e_tr.appendChild(e_td);

 	var newImageEl = pDoc.createElement("img"); 
 	
    newImageEl.setAttribute("src",refPath);

	newImageEl.setAttribute("width","320");
    
    arrayImagesSequenced[ii] = newImageEl;
    
	e_td.appendChild(newImageEl);

	var e_td = pDoc.createElement("td");
	e_td.setAttribute("valign","top");
	e_tr.appendChild(e_td);
	

	var dd_ar = turk_gGlobalTemplateDoc.getElementsByTagName("ar");

	var strHelpArea = "<"+"div style='color:black;background-color:yellow;padding:.3em;margin:.3em;-moz-border-radius:4px; border:1px solid black'>";

	for(var i=0;i<dd_ar.length;i++) {
		var elQuestion = dd_ar.item(i);
		if(elQuestion.hasAttribute("help")) {
			strHelpArea += elQuestion.getAttribute("help")+" - ";
		}
	}

	strHelpArea+="</"+"div>";
	
	e_td.innerHTML=strHelpArea;

    /* An element to mark if this element is to be uploaded or not */
	
	var e_element= pDoc.createElement("input");
	e_element.setAttribute("type","checkbox");
    e_element.setAttribute("checked","true");
    tt_arrayChecked[ii]=e_element;
    e_td.appendChild(e_element);	
    
  
	
	/* Now we format one element for each item that has an ui: mark */ 
	
	var newFormItem = [];
	var newControlItem = [];

	var e_controlElement= pDoc.createElement("div");
	e_controlElement.setAttribute("style","color:black;margin:2px;padding:2px");
	e_td.appendChild(e_controlElement);

	newControlItem["infoarea"] = (e_controlElement);

	/* Collect the AR items */

	var dd_ar = turk_gGlobalTemplateDoc.getElementsByTagName("ar");

	for(var i=0;i<dd_ar.length;i++) {
		var elQuestion = dd_ar.item(i);
		if(elQuestion.hasAttribute("wiz")) {

			var wizAttribute = elQuestion.getAttribute("wiz").split(":");
			var nmAttribute = elQuestion.getAttribute("nm");
			var commandAttribute = wizAttribute[0];	
			var valueAttribute = wizAttribute[1];	
		
			if(commandAttribute=="ui") { 

				if(valueAttribute=="textfield") {
					var e_element= pDoc.createElement("input");
					e_element.setAttribute("type","text");
					e_element.setAttribute("size","60");

				} 
				if(valueAttribute=="textarea") {
					var e_element= pDoc.createElement("textarea");
					e_element.setAttribute("cols","40");
					e_element.setAttribute("rows","20");
				} 
		
				if(valueAttribute=="hiddenfield") {
					var e_element= pDoc.createElement("input");
					e_element.setAttribute("type","text");
					e_element.setAttribute("disabled","true");

				} 

				e_td.appendChild(e_element);	
		
				var e_br  = pDoc.createElement("br");
				e_td.appendChild(e_br);

				newFormItem.push(e_element);
				elRef.appendChild(e_tr);

				newFormItem[nmAttribute] = (e_element);
				e_element.setAttribute("refname",nmAttribute );
			} 
		}
	}

	var dd_fl = turk_gGlobalTemplateDoc.getElementsByTagName("fl");

	for(var i=0;i<dd_fl.length;i++) {
		var elQuestion = dd_fl.item(i);
		if(elQuestion.hasAttribute("wiz")) {

			var wizAttribute = elQuestion.getAttribute("wiz").split(":");
			var nmAttribute = elQuestion.getAttribute("vl");
			var commandAttribute = wizAttribute[0];	
			var valueAttribute = wizAttribute[1];	
		
			if(commandAttribute=="keyfile") { 

				newControlItem["keyfilename"] = nmAttribute;
				 
			} 
		}
	}


	/* pack in to the arrays */

	tt_arrayForms.push(newFormItem);

	tt_arrayControls.push(newControlItem);


    ccp_fillTitleDescription();
    
}

function ccp_fillTitleDescription() {

    for(var i=0;i<tt_arrayForms.length;i++) {
    
        tt_arrayForms[i]["title"].value = tt_arrayH2[i].firstChild.nodeValue;
        tt_arrayForms[i]["description"].value = tt_arrayP[i].firstChild.nodeValue;

    }
    
}






/////
//// The publishing part. 
///
//

var mu_imageUploadState = 0;
var g_uploadFile=null;

function mu_willPublishImages() {

	dump("nao clique novamente..");

    mu_imageUploadState = 0;
	mu_publishImages();

}


function mu_publishImages() {

	var i=mu_imageUploadState;
	
	try {
			tt_arrayControls[mu_imageUploadState]["infoarea"].style.backgroundColor="#ccddff";	
			tt_arrayControls[mu_imageUploadState]["infoarea"].innerHTML="Downloading image as file....";

    	    downloadImage(arrayImagesSequenced[mu_imageUploadState].src); // getMediaCallback will be called soon...
    	    

	} catch (i) {

        dump(i);
        
	}

}


function mu_postImageandForm() {

    var fileHandler = g_uploadFile;
    
	var i=mu_imageUploadState;
	
	try {

			tt_arrayControls[i]["infoarea"].style.backgroundColor="#ffdddd";	
			
			tt_arrayControls[i]["infoarea"].innerHTML="Publishing....";
	
            mu_putFile2(fileHandler,tt_arrayForms[i],tt_arrayControls[i]);

	} catch (i) {

	}

}

function mu_continuePublish() {

	tt_arrayControls[mu_imageUploadState]["infoarea"].style.backgroundColor="#ddffdd";	
	tt_arrayControls[mu_imageUploadState]["infoarea"].innerHTML="Published!";
	
     mu_imageUploadState++;
     mu_publishImages();

}



function mu_formatXML(currentForm) {

	// uses gGlobalTemplateDoc ;

	var serialXML=new XMLSerializer();

	// We remove the special Authoring attributes / Normalizing to the server 0.0.3
      // specification. In the future, we need to fix the local template to have a contextual layer
      // layer of abstraction in the DOM tree, for example we want the DOM tree to be visible in multiple formats. 
      // This could be done via namespaces maybe. 

	var normalDoc = null;
	var clonedSerializer=new XMLSerializer();
	clonedSerializedText = clonedSerializer.serializeToString(turk_gGlobalTemplateDoc)

	var clonedParser = new DOMParser();
	normalDoc = clonedParser.parseFromString(clonedSerializedText ,"text/xml");
	
	var dd_ar = normalDoc.getElementsByTagName("ar");

	for(var i=0;i<dd_ar.length;i++) {

		var elQuestion = dd_ar.item(i);

		if(elQuestion.hasAttribute("help")) {
			elQuestion.removeAttribute("help");
		}
		if(elQuestion.hasAttribute("wiz")) {
			elQuestion.removeAttribute("wiz");
		}

		if(elQuestion.hasAttribute("fill")) {
			var refId = elQuestion.getAttribute("fill");
			
			// it does not have to be in the XML the refId....
			
			currentForm[elQuestion.getAttribute("nm")].value=document.getElementById(refId).value;
			elQuestion.removeAttribute("fill");

		}
	
		elQuestion.setAttribute("vl",currentForm[elQuestion.getAttribute("nm")].value);

	}

	var dd_ar = normalDoc.getElementsByTagName("fl");

	for(var i=0;i<dd_ar.length;i++) {
		var elQuestion = dd_ar.item(i);
		if(elQuestion.hasAttribute("wiz")) {
			elQuestion.removeAttribute("wiz");
		}
	}

	return (serialXML.serializeToString(normalDoc));

}




function downloadImage(refImage) {

 
 try {

      localTarget = Components.classes["@mozilla.org/file/directory_service;1"]
                            .getService(Components.interfaces.nsIProperties)
                            .get("TmpD", Components.interfaces.nsIFile);

      localTarget.append("mturkmedia.jpg");

      localTarget.createUnique(Components.interfaces.nsIFile.NORMAL_FILE_TYPE, 0664);
      
      

	var uri = Components.classes["@mozilla.org/network/standard-url;1"]
	                             .createInstance(Components.interfaces.nsIURI);
	uri.spec = refImage;

	var referer = null;


	var progressPersist = Components.classes['@mozilla.org/embedding/browser/nsWebBrowserPersist;1'].createInstance(Components.interfaces.nsIWebBrowserPersist);

	var flags = Components.interfaces.nsIWebBrowserPersist.PERSIST_FLAGS_AUTODETECT_APPLY_CONVERSION | Components.interfaces.nsIWebBrowserPersist.PERSIST_FLAGS_REPLACE_EXISTING_FILES | Components.interfaces.nsIWebBrowserPersist.PERSIST_FLAGS_BYPASS_CACHE;
	progressPersist.persistFlags = flags;

	var tr = Components.classes["@mozilla.org/transfer;1"].createInstance(Components.interfaces.nsITransfer);
	
	
	var ioService = Components.classes["@mozilla.org/network/io-service;1"].getService(Components.interfaces.nsIIOService);
	var fileURI =  ioService.newFileURI(localTarget);
	
	tr.init(uri,fileURI, "", null, null, null, progressPersist);

	progressPersist.saveURI(uri, null, referer, null, null, localTarget);

    g_uploadFile = localTarget;
    
    
    /* Big bug */
    
    setTimeout("mu_postImageandForm()",8000);
    
    } catch (i) { dump("info"+i) } 
    
}



function mu_putFile2(file,arrayForm,arrayControl) {

	try {

	var is = null;

	is = Components.classes["@mozilla.org/network/file-input-stream;1"]
			   .createInstance( Components.interfaces.nsIFileInputStream );
	
	is.init( file,0x01, 00004, null);

		var ref="http://www.remotestage.com/remotestage/flow.jsp";

		var boundaryString = '123456789';
		var boundary = '--' + boundaryString;
		req = new XMLHttpRequest();

		var xmlSerializedEnvelope = mu_formatXML(arrayForm);

		var requestBody = [boundary,'Content-Disposition: form-data; name="xmlfd"','',xmlSerializedEnvelope,'',boundary,'Content-Disposition: form-data; name="'+arrayControl["keyfilename"]+'"; filename="test.jpg"','Content-Type: image/jpeg','',''].join('\r\n');

		req.open('POST', ref, true); 

		req.onreadystatechange = function (evt) {
			if (req.readyState == 4) {
				mu_continuePublish();
			}
		}

		req.setRequestHeader('Content-Type','multipart/form-data; charset=UTF-8; boundary='+boundaryString);

		var objmulti = Components.classes["@mozilla.org/io/multiplex-input-stream;1"].
      	      createInstance(Components.interfaces.nsIMultiplexInputStream);
 
		var obj1 = Components.classes["@mozilla.org/io/string-input-stream;1"].
		            createInstance(Components.interfaces.nsIStringInputStream);

		obj1.setData(requestBody, requestBody.length);

		var converter =
		Components.classes["@mozilla.org/intl/scriptableunicodeconverter"]	
					.createInstance(Components.interfaces.nsIScriptableUnicodeConverter);

		converter.charset = "UTF-8";
	
		var obj1New = converter.convertToInputStream(requestBody.toString());
	

		var image = Components.classes["@mozilla.org/network/buffered-input-stream;1"].
	            createInstance(Components.interfaces.nsIBufferedInputStream);

		image.init(is,is.available());

		var obj3 = Components.classes["@mozilla.org/io/string-input-stream;1"].
		            createInstance(Components.interfaces.nsIStringInputStream);

		obj3.setData('\r\n--123456789--\r\n', 17);


		objmulti.appendStream(obj1New );
		objmulti.appendStream(image);
		objmulti.appendStream(obj3);

		req.send(objmulti);


	} catch (e) {
		dump("putFile:"+e);
	}

}


function mu_editCloneAll() {

	watchName = (document.commandDispatcher.focusedElement.getAttribute("refname"));
	toValue = document.commandDispatcher.focusedElement.value;

	for(var i=0;i<tt_arrayForms.length;i++) {

		for( var keyValue in tt_arrayForms[i] ) { 

			var currElement = tt_arrayForms[i][keyValue];

			if(currElement.getAttribute("refname")==watchName) {
				currElement.value = toValue;
	
			}

		}

	}
}



