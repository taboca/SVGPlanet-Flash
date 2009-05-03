/* 
 * Copyright (C) 2007 Marcio dos Santos Galli, Taboca Inc 
 * All Rights Reserved
 * Contact marciog@taboca.com 
 */



/* 
 * fs level function to pre populate all the Workspace Taboca RsUser Form documents with Ids in its title
 * This can be used if you want to have a public documents quickly with title as numbers. 
 */
function fs_runIdPopulate() {

	var fieldName = document.getElementById("templatefield_nm").value;
    
	for(var i=0;i<arrayForms.length;i++) {

        arrayForms[i][fieldName].value = i;

	}

}


/* 
 * Basic structure of the new form style ( 0.0.3 rsuser ) 
 * -----
 * enctype="multipart/form-data"
 * name = xmlfd ( this is the xml envelope ) 
 * -----
 * The following is an example..
 * 
 * <fd>
    <ap nm="panela-en-gloria">
	<ev id="0" nm="newImage">
		<ar nm="author" vl="Sergio"/>
		<ar nm="title" vl="Titulo com espacos"/>
		<fl nm="photo" vl="src"/>
		<ar nm="from" vl="Ribeirao Preto"/>
		<ar nm="license" vl="cc"/>
		<ar nm="keywords" vl="pao manteiga acucar"/>
		<ar nm="ingredients" vl="Pao Manteiga Acucar"/>
		<ar nm="description" vl="Descricao da receita"/>
		<ar nm="tag" vl="pao"/>
	</ev>
    </ap>
  </fd>
 * Attachments: 
 * ---
 * See the above <fl /> node. The name vl attribute has to match with the name of the 
 * file input element. Example:  
 * 
 *      File: <input type="file" name="src"><br>
 * 
 */ 

function startup() {

	fs_loadHelp();

}


function fs_loadHelp() {

	document.getElementById("helpBrowser").setAttribute("src","templates-help/"+document.getElementById("templatepath").value+".html");
}



function fs_editCloneAll() {

	watchName = (document.commandDispatcher.focusedElement.getAttribute("refname"));
	toValue = document.commandDispatcher.focusedElement.value;

	for(var i=0;i<arrayForms.length;i++) {

		for( var keyValue in arrayForms[i] ) { 

			var currElement = arrayForms[i][keyValue];


			if(currElement.getAttribute("refname")==watchName) {

				currElement.value = toValue;
				
	
			}

		}

	}
}


var imageUploadState = 0;
var arrayForms = []; /* This is the array of forms */
var arrayReferenceTurkHits = []; /* Used by the mturk stuff, to add hits to each entry */
var arrayControls = [];
var arrayFiles = [];
var gGlobalTemplateDoc = null; /* This is the doc so that we load the XML template info */

/* Local Form creation Strategy 
   -----
   1) We create a form with elements based on the above XML information. 
   1.1) ( meta-data info ) We need an additional information so that we tell how the UI form is created 
   ----
   2.1) ( Meta-data info)  We need to mark which is the name of the image to match the vl attribute in the fl element. 
   ---- 
   3) Generation
   3.1) we populate the XML, attach the image, put the right filename, and upload. 

  */

// not in use
function fs_publishOnly() {

	alert("Will generate all the site now. Dont press twice");

		var ref="http://www.remotestage.com/panela/fotofu-publish.jsp";
		req = new XMLHttpRequest();
		req.open('GET', ref, false); 
		req.send(null);
}

function fs_openTemplateDoc(refTemplateLocalPath) {
		req = new XMLHttpRequest();
		req.open('GET', refTemplateLocalPath, false); 
		req.send(null);
		return req.responseXML;
}

function formatXML(currentForm) {

	// uses gGlobalTemplateDoc ;

	var serialXML=new XMLSerializer();

	// We remove the special Authoring attributes / Normalizing to the server 0.0.3
      // specification. In the future, we need to fix the local template to have a contextual layer
      // layer of abstraction in the DOM tree, for example we want the DOM tree to be visible in multiple formats. 
      // This could be done via namespaces maybe. 

	var normalDoc = null;
	var clonedSerializer=new XMLSerializer();
	clonedSerializedText = clonedSerializer.serializeToString(gGlobalTemplateDoc)

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

function putFile(file,arrayForm,arrayControl) {

	// This were the old values - , title, description, extra, tags, location, author

	var is = null;

	is = Components.classes["@mozilla.org/network/file-input-stream;1"]
			   .createInstance( Components.interfaces.nsIFileInputStream );
	
	is.init( file,0x01, 00004, null);

	try {

		//var ref="http://ribeirao.remotestage.net:9980/remotestage/flow.jsp";
		var ref="http://www.taboca.com/remotestage/flow.jsp";

		var boundaryString = '123456789';
		var boundary = '--' + boundaryString;
		req = new XMLHttpRequest();

		var xmlSerializedEnvelope = formatXML(arrayForm);


		var requestBody = [boundary,'Content-Disposition: form-data; name="xmlfd"','',xmlSerializedEnvelope,'',boundary,'Content-Disposition: form-data; name="'+arrayControl["keyfilename"]+'"; filename="test.jpg"','Content-Type: image/jpeg','',''].join('\r\n');

		req.open('POST', ref, true); 

		req.onreadystatechange = function (evt) {
			if (req.readyState == 4) {
			
				alert(req.responseText);
				is.close();
				fs_continuePublish();

			}
		}

		req.setRequestHeader('Content-Type','multipart/form-data; charset=UTF-8; boundary='+boundaryString);


		var objmulti = Components.classes["@mozilla.org/io/multiplex-input-stream;1"].
      	      createInstance(Components.interfaces.nsIMultiplexInputStream);
 
		var obj1 = Components.classes["@mozilla.org/io/string-input-stream;1"].
		            createInstance(Components.interfaces.nsIStringInputStream);

		obj1.setData(requestBody, requestBody.length);

		/* 
 		 * We do this because the string has to be encoded as utf-8 raw 
		 * as we send this directly using an input Stream ( nsIVariant value passed to the send ) 
		 */

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
		alert(e);
	}

}

function fs_willPublishImages() {

	alert("Não clique novamente. Vc pode voltar na aba [Area de Trabalho] para verificar o progresso.");

	fs_publishImages();

}


function fs_publishImages() {

	var i=imageUploadState;
	
	try {
			var file=arrayFiles[i];
			arrayControls[i]["infoarea"].style.backgroundColor="#ffdddd";	
			arrayControls[i]["infoarea"].innerHTML="Publishing....";
	
			putFile(file,arrayForms[i],arrayControls[i]);

	} catch (i) {

	}

}

function fs_continuePublish() {

	arrayControls[imageUploadState]["infoarea"].style.backgroundColor="#ddffdd";	
	arrayControls[imageUploadState]["infoarea"].innerHTML="Published!";
	
 imageUploadState++;
 fs_publishImages();

}



/* 
 *  This opens a given folder where the user can select files. 
 *  For each file, it has to create a structure that will populate arrays of objects. 
 */

function fs_setFolder() {

 document.getElementById("previewBrowser").setAttribute("src","blank.html");


 var bytesFile = null;
 var bytesSize = null;
 var obj2 = null;
 var is = null;

 var win;
 var wm = Components.classes["@mozilla.org/appshell/window-mediator;1"]
                     .getService(Components.interfaces.nsIWindowMediator);
 win = wm.getMostRecentWindow("navigator:browser");
 if(!win) win = window.opener;

  const nsIFilePicker = Components.interfaces.nsIFilePicker;
  const nsIFile = Components.interfaces.nsIFile;
  var fp = Components.classes["@mozilla.org/filepicker;1"].createInstance(nsIFilePicker);
  var refLocalFile = Components.classes["@mozilla.org/file/local;1"].createInstance(nsIFile );

  fp.init(window, null, nsIFilePicker.modeOpenMultiple);

  const nsILocalFile = Components.interfaces.nsILocalFile;

  fp.appendFilters(nsIFilePicker.filterAll);

  var returnFilePickerValue=fp.show();

  if (returnFilePickerValue == nsIFilePicker.returnOK) {

	gGlobalTemplateDoc = fs_openTemplateDoc("templates/"+document.getElementById("templatepath").value+".xml");

	pDoc = document.getElementById("previewBrowser").contentDocument;

 	var e_table = pDoc.createElement("table"); 
	pDoc.body.appendChild(e_table);

	entries =(fp.files);
      while(entries.hasMoreElements()) {

		var entry = entries.getNext();
		entry.QueryInterface(Components.interfaces.nsIFile);

		generateForm(e_table,"file:///"+entry.path);
		arrayFiles.push(entry);
	
      } 

  }
}

function generateForm(elRef,refPath) {


	pDoc = document.getElementById("previewBrowser").contentDocument;


	var e_tr = pDoc.createElement("tr");

	var e_td = pDoc.createElement("td");
	e_tr.appendChild(e_td);

 	var newImageEl = pDoc.createElement("img"); 
	newImageEl.setAttribute("src",refPath);
	newImageEl.setAttribute("width","320");
	//newImageEl.setAttribute("height","240");

	e_td.appendChild(newImageEl);

	var e_td = pDoc.createElement("td");
	e_td.setAttribute("valign","top");
	e_tr.appendChild(e_td);

	/* 
       * Now we process the XML DOM info and generate the UI 
       */

	var dd_ar = gGlobalTemplateDoc.getElementsByTagName("ar");

	var strHelpArea = "<"+"div style='color:black;background-color:yellow;padding:.3em;margin:.3em;-moz-border-radius:4px; border:1px solid black'>";

	for(var i=0;i<dd_ar.length;i++) {
		var elQuestion = dd_ar.item(i);
		if(elQuestion.hasAttribute("help")) {
			strHelpArea += elQuestion.getAttribute("help")+" - ";
		}
	}

	strHelpArea+="</"+"div>";
	
	e_td.innerHTML=strHelpArea;

	/* Now we format one element for each item that has an ui: mark */ 
	
	
	var newFormItem = [];
	var newControlItem = [];

	var e_controlElement= pDoc.createElement("div");
	e_controlElement.setAttribute("style","color:black;margin:2px;padding:2px");
	e_td.appendChild(e_controlElement);

	newControlItem["infoarea"] = (e_controlElement);

	/* Collect the AR items */

	var dd_ar = gGlobalTemplateDoc.getElementsByTagName("ar");

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

				} 
				if(valueAttribute=="textarea") {
					var e_element= pDoc.createElement("textarea");
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

	var dd_fl = gGlobalTemplateDoc.getElementsByTagName("fl");

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

	arrayForms.push(newFormItem);

	arrayControls.push(newControlItem);

}


