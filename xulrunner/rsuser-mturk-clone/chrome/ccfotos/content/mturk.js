

/* 


Future of updates

 Deal with state forms; Forms and their filled instances. A collection of Directories where each directoy is an item with : files.xml, file attachments and some relationship. HAs a concept of meta.info action tags elements in the directories - not recursive for now. For each of the existant can create Wizard Forms in transient and persistant stages ( disk passes ). Can also [1] Transform in Publishin Operations ( Send to Mturk ), create Annotation Structures on it; [3] compbine Annotation to make formal Normaliztion Stage [4] and publish or do it again. IT's possible to recursiverlly interact on elements, filter, make them simpler. 

 Wizard editing collection visualization is a sort of event model. Passes on elemements can execute queries to the Web, and when action response, processing can affect existing Store Elements ( annotation ) adn may kick events to Wisual Elements ( Wizard Editing Layer );  Each pass has certain unique IDs. 

*/
    var par_uri_sandboxexternal = "http://workersandbox.mturk.com/mturk/externalSubmit";
  var otherSubmit = "http://www.mturk.com/mturk/externalSubmit";

/* 
 * Copyright (C) 2007 Marcio dos Santos Galli, Taboca Inc 
 * All Rights Reserved
 * Contact marciog@taboca.com 
 */



function mturk_populateFixTitle() {

	watchName = "title";
    
	for(var i=0;i<tt_arrayForms.length;i++) {

		for( var keyValue in tt_arrayForms[i] ) { 

			var currElement = tt_arrayForms[i][keyValue];

			if(currElement.getAttribute("refname")==watchName) {
            
                currElement.value=leftTrim(currElement.value);
                currElement.value=rightTrim(currElement.value);

				currElement.value = currElement.value.replace(/\./g,"");
				currElement.value = currElement.value.replace(/\'/g,"");
				currElement.value = currElement.value.replace(/\,/g,"");
				currElement.value = currElement.value.replace(/\,/g,"");
    			currElement.value = currElement.value.replace(/\?/g,"");
				currElement.value = currElement.value.replace(/\!/g,"");
			
				currElement.value = currElement.value.toLowerCase();
	
                var firstChar = currElement.value.substring(0,1);
                var endString = currElement.value.substring(1,currElement.value.length);
                var newFirst = firstChar.toUpperCase();
                currElement.value = newFirst + endString;

			}

		}

	}
}

function mturk_populateFixDescription() {

	watchName = "description";
    
	for(var i=0;i<tt_arrayForms.length;i++) {

		for( var keyValue in tt_arrayForms[i] ) { 

			var currElement = tt_arrayForms[i][keyValue];

			if(currElement.getAttribute("refname")==watchName) {

                currElement.value=leftTrim(currElement.value);
//                currElement.value=returnTrim(currElement.value);
  //              currElement.value=rightTrim(currElement.value);
    //            currElement.value=returnTrim(currElement.value);
                			
	//			currElement.value = currElement.value.toLowerCase();
	
                var firstChar = currElement.value.substring(0,1);
                var endString = currElement.value.substring(1,currElement.value.length);
                var newFirst = firstChar.toUpperCase();
                currElement.value = newFirst + endString;

			}
		}
	}
}

function leftTrim(sString)
{
    while (sString.substring(0,1) == ' ')
    {
    sString = sString.substring(1, sString.length);
    }
    return sString;
}

function rightTrim(sString)
{
    while (sString.substring(sString.length-1, sString.length) == ' ')
    {
    sString = sString.substring(0,sString.length-1);
    }
    return sString;
}

function returnTrim(sString)
{
    while (sString.substring(sString.length-1, sString.length) == '\n')
    {
    sString = sString.substring(0,sString.length-1);
    }
    return sString;
}

function dotTrim(sString)
{
    while (sString.substring(sString.length-1, sString.length) == '.')
    {
    sString = sString.substring(0,sString.length-1);
    }
    return sString;
}

/* 
 * Frontstage JS API version 0.1 
 * Mturk Service to Dispose a Hit by ID 
 */

function mturk_disposeHitsById(hitId) {

	var par_service   = "AWSMechanicalTurkRequester";
	var par_operation = "DisposeHIT";
	var par_utcFull   = encodeURIComponent( mturk_getUTCFull() );

	var par_signature = mturk_getEncodedSignature(par_service,par_operation);
	
	var par_uri       = "http://mechanicalturk.amazonaws.com/onca/xml";
	var par_uri       = "http://mechanicalturk.sandbox.amazonaws.com/onca/xml";
	var par_uri       = "http://mechanicalturk.sandbox.amazonaws.com/";
   
	var par_others    = "&HITId="+hitId;

	var req_full = par_uri + "?Service=" + par_service + "&Operation=" + par_operation + "&AWSAccessKeyId=" + turk_access_key + "&Timestamp="+par_utcFull + "&Signature="+par_signature+ par_others; 
    
    return req_full;
    
}



////
/// Turk For Each Hit in list Dispose it. 
//

var disposedCounter = 0;
var req_dispose = null;

function mturk_disposeHitsInList() {

	if(disposedCounter<tt_arrayChecked.length) {
		if(tt_arrayChecked[disposedCounter].checked) {
			tt_arrayHitId[disposedCounter].style.backgroundColor="orange";
			req_dispose = new XMLHttpRequest();
			ref = mturk_disposeHitsById(tt_arrayHitId[disposedCounter].value);
			req_dispose.open('GET', ref, true); 
			req_dispose.onreadystatechange = function (evt) {
				if (req_dispose.readyState == 4) {
					mturk_disposeHitsInList_continueLoading();
				}
			}
			req_dispose.send(null);
		} else {
			disposedCounter++;
			mturk_disposeHitsInList();	
		}
	}
}

var tt_arrayDisposeTicket = new Array();


function mturk_disposeHitsInList_continueLoading() {
	var respDoc = (req_dispose.responseXML);
	serialXML=new XMLSerializer(); 
	tt_arrayDisposeTicket[disposedCounter].value=serialXML.serializeToString(respDoc);
	tt_arrayDisposeTicket[disposedCounter].style.backgroundColor="green";
	disposedCounter++;
	mturk_disposeHitsInList();	
}



/* 
 * 
 */
 



function mturk_fixHitKeys() {



    try {
    
        g_keylist_base = document.getElementById("baseUrlforKeys").value;
        
        var keysDoc = document.getElementById("keysBrowser").contentDocument;
        
        var imageElements = keysDoc.getElementsByTagName("image");
        for( var i=0; i < imageElements.length ; i++ ) {
            
            var currentElement = imageElements.item(i);
            var previousValue = currentElement.getAttribute("href");
         
            currentElement.setAttribute("href", g_keylist_base + previousValue);     
        
        }
        
    } catch (i) { alert(i) } 
    
}


/* Global Variables / Account */

var turk_access_key = "0DGQMYR21FJAPQK95T02";
var turk_access_secret = "Lc0KWlIp+Vi+zmBFbVNGRKrQLgMdEPds6JhL2o6j";

var g_keylist_base = null; 

function mturk_prepareHits() {


        var testLoad=new bmProcessor();
       // testLoad.xmlSet(document.getElementById("hitskey").value);
       
        testLoad.xmlSetDocument(document.getElementById("keysBrowser").contentDocument);
       
        testLoad.xslSet(document.getElementById("hitstemplate").value);
        testLoad.callback = mturk_prepareHits_callback;
        testLoad.setTargetDocument(document.getElementById("hitsBrowser").contentDocument);
        testLoad.setTargetElement(document.getElementById("hitsBrowser").contentDocument.firstChild);
        testLoad.run();

}


/*
&Title=Location%20and%20Photograph%20Identification
&Description=Select%20the%20image%20that%20best%20represents...
&Reward.1.Amount=0.02
&Reward.1.CurrencyCode=USD
&Question=[URL-encoded question data]
&AssignmentDurationInSeconds=600
&AutoApprovalDelayInSeconds=2000
&LifetimeInSeconds=60
&Keywords=location,%20photograph,%20image,%20identification,%20opinion
*/


gQuestionsDocument = null;

function mturk_prepareHits_callback(doc) {


    gQuestionsDocument = doc; 
    
    serialXML=new XMLSerializer();

    textXML=serialXML.serializeToString(gQuestionsDocument);

    document.getElementById("hitsBrowser").contentDocument.getElementById("dumparea").value=textXML;
 
    
}

function mturk_formatCreateHitParameters(itemQuestionForm) {

/*

the Question element suppors URI encoded of a serialized XML 
that can be: 
http://docs.amazonwebservices.com/AWSMechanicalTurkRequester/2007-06-21/ApiReference_QuestionFormDataStructureArticle.html

or 

http://docs.amazonwebservices.com/AWSMechanicalTurkRequester/2007-06-21/


*/


  var values=[document.getElementById("hitsseriesprefix").value,
            'Please provide a description for the given image - a short Title first and its Content. ',
            'Description, label, translation, review, interpretation, subject, information details.',
            '0.02',
            'USD',
            '#questionformitem',
            '600',
            '2000',
            '86400',
            '1'];
            
  var titles = [
                'Title',
                'Description',
                'Keywords',
                'Reward.1.Amount',
                'Reward.1.CurrencyCode',
                'Question',
                'AssignmentDurationInSeconds',
                'AutoApprovalDelayInSeconds',
                'LifetimeInSeconds',
                'MaxAssignments'
                ];
           
  var resultEncodedParams = ""; 
  
  for(var i=0;i<values.length;i++) {
  
    var encodedValue = encodeURIComponent(values[i]);
    
    if(values[i]=="#questionformitem") {
        encodedValue = encodeURIComponent(itemQuestionForm);
    }
    
    resultEncodedParams += "&"+titles[i]+"="+encodedValue;
    

  } 
    document.getElementById("hitsUploadBrowser").contentDocument.getElementById("dumparea").value+=(resultEncodedParams);
    
    return resultEncodedParams;
    
}

/* 
 * 
 */

var mturkHitsCounter = 0;
var mturkXMLDoc = null;
var questionItems = null;


function mturk_pushHits() {

   questionItems = gQuestionsDocument.getElementsByTagName("item");

   if( mturkHitsCounter < questionItems.length ) {
    
         
         var el = questionItems[mturkHitsCounter];
           
         var ss = el.firstChild.nodeValue;

         var valParams = mturk_formatCreateHitParameters(ss);
 
         mturk_createHits(valParams);
         
    } else {

               questionItems = gQuestionsDocument.getElementsByTagName("item");
               
               for(i=0;i<questionItems.length;i++) {
               
                    var elItem = questionItems.item(i);
                    
                    elItem.removeChild(elItem.firstChild);
                    
               }
               
               var serialXML=new XMLSerializer();
               var returnedContent=serialXML.serializeToString(gQuestionsDocument);

               document.getElementById("hitsStageBrowser").contentDocument.getElementById("dumparea").value=returnedContent;

    }

}



function mturk_loadHitKeys() {

	document.getElementById("keysBrowser").setAttribute("src",document.getElementById("hitskey").value);

}

function mturk_loadHitJob() {


     var documentString = document.getElementById("hitsStageBrowser").contentDocument.getElementById("dumparea").value;

     var myParser = new DOMParser();
     var refDoc = myParser.parseFromString(documentString,"text/xml");




     var itemList = refDoc.getElementsByTagName("item");
     
    for(i=0;i<itemList.length;i++) {

        var elItem = itemList.item(i);      
        var hitRef = elItem.getAttribute("refhit");
        var imageRef = elItem.getAttribute("refimage");
        
        document.getElementById("hitAndImages").contentDocument.getElementById("dumparea").value+="\n>> Hit: "+hitRef+" and Image:"+imageRef+"\n";
              
        arrayHitImages[hitRef]=imageRef;
        arrayImagesSequenced[i]=imageRef;
        arrayHitImagesLinear[i]=imageRef;
                   
    }

}


function mturk_createHits(parsPackage) {

	var par_service   = "AWSMechanicalTurkRequester";
	var par_operation = "CreateHIT";
	var par_utcFull   = encodeURIComponent( mturk_getUTCFull() );

	var par_signature = mturk_getEncodedSignature(par_service,par_operation);
	
	var par_uri       = "http://mechanicalturk.amazonaws.com/onca/xml";
    var par_uri ="http://mechanicalturk.sandbox.amazonaws.com/onca/xml";
    var par_uri ="http://mechanicalturk.sandbox.amazonaws.com/";
    var par_uri_sandboxexternal = "http://workersandbox.mturk.com/mturk/externalSubmit";
    
    
	var par_others    = parsPackage;

	var req_full = par_uri + "?Service=" + par_service + "&Operation=" + par_operation + "&AWSAccessKeyId=" + turk_access_key + "&Timestamp="+par_utcFull + "&Signature="+par_signature+ par_others; 
    
        try {
	
	        if(document.getElementById("amazonConnectionEnabled").checked) {
	       
                mturkXMLDoc = document.implementation.createDocument("","",null);   
                mturkXMLDoc.addEventListener("load",mturk_createHitsLoaded,false);                             
netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");
netscape.security.PrivilegeManager.enablePrivilege("UniversalConnect");
                mturkXMLDoc.load(req_full);
                
            } else {
            
                mturk_createdHitsSimulated();
            
            }

    } catch(i) { alert(i) }
    
}

function mturk_createdHitsSimulated() {

    var hitRandomValue = Math.random();
    var el = questionItems[mturkHitsCounter];
              
    el.setAttribute("refhit",hitRandomValue);            
    mturkHitsCounter++;
    mturk_pushHits();
    
}


/* This is a hash map so we find the images from the hit reference */

var arrayHitImages = new Array();
var arrayImagesSequenced = new Array();
var arrayHitImagesLinear= new Array();

function mturk_createHitsLoaded() {

    try { 
    
        var serialXML=new XMLSerializer();
        var returnedContent=serialXML.serializeToString(mturkXMLDoc);


        document.getElementById("hitsTry").contentDocument.getElementById("dumparea").value+="\n=======\n"+returnedContent;

        var hitIds = mturkXMLDoc.getElementsByTagName("HITId");
    
        if(hitIds.length>0) {
        
            document.getElementById("hitsTry").contentDocument.getElementById("dumparea").value+="\nHit="+hitIds.item(0).firstChild.nodeValue+"\n";
            var el = questionItems[mturkHitsCounter];
            el.setAttribute("refhit",hitIds.item(0).firstChild.nodeValue);
            
        }

    mturkHitsCounter++;
    
    mturk_pushHits();

    } catch (i) { alert(i); }
}


function mturk_getEncodedSignature(service,operation) {

	var defaultService = "AWSMechanicalTurkRequester"; // default is the amazon mturk... 

	if(service) {
		defaultService = service;
	}

	var myCryptor = Components.classes["@mozilla.org/security/hash;1"].createInstance(Components.interfaces.nsICryptoHash);
	
	myCryptor.init(myCryptor.SHA1); 

	var utcFull = mturk_getUTCFull();
	var comboThree = defaultService + operation + utcFull;
	var stringToPass = comboThree;
	var req_signature = (b64_hmac_sha1(turk_access_secret,stringToPass));

	var resultSignature = encodeURIComponent(req_signature);

	return resultSignature+"%3D"; // WTF is this 3d? 
	
	

}

function mturk_getUTCFull() {
	d = new Date();
	// UTC format is 2000-01-16T12:00:00Z
	utcYear    = d.getUTCFullYear();
	utcMonth   = d.getUTCMonth();
	utcDate    = d.getUTCDate();
	utcHour    = d.getUTCHours();
	utcMinutes = d.getUTCMinutes();
	utcSeconds = d.getUTCSeconds();
	utcMonth++;
	// removed the "Z";
	if(utcDate.toString().length<2) {
		// we add one ore zero..
		utcDate="0"+utcDate;
	}
	if(utcMonth.toString().length<2) {
		// we add one ore zero..
		utcMonth="0"+utcMonth;
	}
	if(utcHour.toString().length<2) {
		// we add one ore zero..
		utcHour="0"+utcHour;
	}
	if(utcMinutes.toString().length<2) {
		// we add one ore zero..
		utcMinutes ="0"+utcMinutes ;
	}
	if(utcSeconds.toString().length<2) {
		// we add one ore zero..
		utcSeconds ="0"+utcSeconds ;
	}
	utcFull = (utcYear+"-"+utcMonth+"-"+utcDate+"T"+utcHour+":"+utcMinutes+":"+utcSeconds);

	utcFull+=".000Z";
	return utcFull;
}


////
/// get hits 
//


function turk_getHits() {


	var par_service   = "AWSMechanicalTurkRequester";
	var par_operation = "SearchHITs";
	var par_utcFull   = encodeURIComponent( mturk_getUTCFull() );

	var par_signature = mturk_getEncodedSignature(par_service,par_operation);
	
	var par_uri       = "http://mechanicalturk.amazonaws.com/onca/xml";
	var par_uri       = "http://mechanicalturk.sandbox.amazonaws.com/onca/xml";
	var par_uri       = "http://mechanicalturk.sandbox.amazonaws.com/";

    var par_additional = "&SortProperty=CreationTime&SortDirection=Descending&PageSize=100";
        
	var req_full = par_uri + "?Service=" + par_service + "&Operation=" + par_operation + "&AWSAccessKeyId=" + turk_access_key + "&Timestamp="+par_utcFull + "&Signature="+par_signature+par_additional; 

	document.getElementById('previewBrowserGetHits').setAttribute('src',req_full);

}

////
/// gen turk in formats of rsuser
//

turk_gGlobalTemplateDoc = null;

function turk_processHits() {

	var srcDoc = document.getElementById("previewBrowserGetHits").contentDocument;

    document.getElementById("stageBrowser").setAttribute("src","blank.html");

	turk_gGlobalTemplateDoc = turk_openTemplateDoc("templates/"+document.getElementById("templatePath2").value+".xml");

	pDoc = document.getElementById("stageBrowser").contentDocument;

 	var e_table = pDoc.createElement("table"); 
 	
	pDoc.body.appendChild(e_table);

	var listHits = srcDoc.getElementsByTagName("HIT");

    var validCounter = 0;
    
	for(var i=0;i<listHits.length;i++) {


		
		var probeHit = listHits.item(i);

		var hitId = probeHit.childNodes.item(0).firstChild.nodeValue;

		var title = probeHit.childNodes.item(3).firstChild.nodeValue;

		var urlsrc = probeHit.childNodes.item(12).firstChild.nodeValue;

		if(title.indexOf(document.getElementById("labelTitle").value)>-1) {
		
			//tabgen_createEl(pDocTable,hitId,title,urlsrc);
			turk_generateForm(e_table,urlsrc,hitId,title,validCounter);
			validCounter++;
		    //alert(hitId);
		    
		}
	}
  
}


function turk_openTemplateDoc(refTemplateLocalPath) {
		var req = new XMLHttpRequest();
		req.open('GET', refTemplateLocalPath, false); 
		req.send(null);
		return req.responseXML;
}

var tt_arrayChecked=new Array();

var tt_arrayForms = []; /* This is the array of forms */
var tt_arrayControls = [];
var tt_arrayFiles = [];
var tt_arrayHitId = [];

function turk_generateForm(elRef,refPath,hitId,titleInfo,ii) {


	pDoc = document.getElementById("stageBrowser").contentDocument;

	var e_tr = pDoc.createElement("tr");

	var e_td = pDoc.createElement("td");
	e_tr.appendChild(e_td);

 	var newImageEl = pDoc.createElement("img"); 
 	
 	    // 4000
    if(document.getElementById("useHitHash").checked) {  	    
    	newImageEl.setAttribute("src",arrayHitImages[hitId]);
    } else {
	    newImageEl.setAttribute("src",arrayHitImagesLinear[ii]);
    }
    
	newImageEl.setAttribute("width","320");
    
    arrayImagesSequenced[ii] = newImageEl;
    
	e_td.appendChild(newImageEl);

	var e_td = pDoc.createElement("td");
	e_td.setAttribute("valign","top");
	e_tr.appendChild(e_td);
	
	


	/* 
       * Now we process the XML DOM info and generate the UI 
       */

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
    
    /* Add the hit id reference control information */
    
    var e_input= pDoc.createElement("input");
	tt_arrayHitId.push(e_input);

	e_input.setAttribute("type","text");
	e_td.appendChild(e_input);

	e_input.setAttribute("value",hitId);
	e_input.setAttribute("size",30);

	var e_br1  = pDoc.createElement("br");
	e_td.appendChild(e_br1);
	
	/* Add the dispose area - used with mturk dispose */
	
    var e_input= pDoc.createElement("input");
	tt_arrayDisposeTicket.push(e_input);

	e_input.setAttribute("type","text");
	e_td.appendChild(e_input);

	e_input.setAttribute("value","not disposed");;

	var e_br1  = pDoc.createElement("br");
	e_td.appendChild(e_br1);
	
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

}



/* 
 * Amazon populate mapper
 */ 
 /* 
 * fs level function to pre populate all the Workspace Taboca RsUser Form documents with Ids in its title
 * This can be used if you want to have a public documents quickly with title as numbers. 
 */
function mturk_populateFieldTitle() {


    turk_assignment_retrieve();



}

var assignCounter = 0;

function turk_assignment_retrieve() {



	if(assignCounter < tt_arrayChecked.length) {


		if(tt_arrayChecked[assignCounter].checked) {

			tt_arrayHitId[assignCounter].style.backgroundColor="blue";

			req = new XMLHttpRequest();
		
			ref = turk_getAssignmentRequest(tt_arrayHitId[assignCounter].value);
			
			req.open('GET', ref, true); 
		
			req.onreadystatechange = function (evt) {
				if (req.readyState == 4) {
					turk_continueLoading();
				}
			}
			req.send(null);
		} else {
		
			assignCounter++;
			turk_assignment_retrieve();	
		}
	}
}

var req = null;

function turk_continueLoading() {

	var respDoc = (req.responseXML);
	var listPossible = respDoc.getElementsByTagName("Answer");

	/*
		serialXML=new XMLSerializer();
		alert(serialXML.serializeToString(respDoc));
	*/

	for(var i=0;i<listPossible.length;i++) {

		var elText=listPossible.item(i);
		var rawStr=elText.firstChild.nodeValue;
		var parser = new DOMParser();
		var doc = parser.parseFromString(rawStr, "text/xml");

		freetextNodes = doc.getElementsByTagName("FreeText");

		for(var j=0;j<freetextNodes.length;j++) {

			var strContent = freetextNodes.item(j).firstChild.nodeValue;
			// This documet has strict order. Answer 1 is the title, 2 is the description.	
			
			if(j==0) {
                try {
                    tt_arrayForms[assignCounter]["title"].value = strContent;
    				// arrayTitles[assignCounter].value = strContent;
				} catch(i) { alert(i) }
			}
			
			if(j==1) {
                tt_arrayForms[assignCounter]["description"].value = strContent;
				//arrayDescription[assignCounter].value = strContent;
			}
			
		}
		
	}

	tt_arrayHitId[assignCounter].style.backgroundColor="yellow";
	assignCounter++;
	turk_assignment_retrieve();	

}


function turk_getAssignmentRequest(hitId) {

	var par_service   = "AWSMechanicalTurkRequester";
	var par_operation = "GetAssignmentsForHIT";
	var par_utcFull   = encodeURIComponent( mturk_getUTCFull() );

	var par_signature = mturk_getEncodedSignature(par_service,par_operation);
	
	var par_uri       = "http://mechanicalturk.amazonaws.com/onca/xml";
    var par_uri = "http://mechanicalturk.sandbox.amazonaws.com/onca/xml";
    var par_uri = "http://mechanicalturk.sandbox.amazonaws.com/";
    
    var par_additional = "&HITId="+hitId;
        
	var req_full = par_uri + "?Service=" + par_service + "&Operation=" + par_operation + "&AWSAccessKeyId=" + turk_access_key + "&Timestamp="+par_utcFull + "&Signature="+par_signature+par_additional; 

	return req_full;
	
}


 
function mu_willPublishImages() {

	alert("Não clique novamente. ");

    mu_imageUploadState = 0;
	mu_publishImages();

}

var mu_imageUploadState = 0;

function mu_publishImages() {

	var i=mu_imageUploadState;
	
	try {
			tt_arrayControls[mu_imageUploadState]["infoarea"].style.backgroundColor="#ccddff";	
			tt_arrayControls[mu_imageUploadState]["infoarea"].innerHTML="Downloading image as file....";

    	    downloadImage(arrayImagesSequenced[mu_imageUploadState].src); // getMediaCallback will be called soon...
    	    
           // arrayImagesSequenced[mu_imageUploadState].src="";


	} catch (i) {

        alert(i);
        
	}

}



function mu_postImageandForm() {

    var fileHandler = g_uploadFile;
    
	var i=mu_imageUploadState;
	
	try {

			tt_arrayControls[i]["infoarea"].style.backgroundColor="#ffdddd";	
			
			tt_arrayControls[i]["infoarea"].innerHTML="Publishing....";
	
	        /* Assumes the image was downloaded in the globel g_uploadFile handle */
	        
			//mu_putFile(refName,tt_arrayForms[i],tt_arrayControls[i]);
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



function mu_putFile2(file,arrayForm,arrayControl) {



	try {


	var is = null;

	is = Components.classes["@mozilla.org/network/file-input-stream;1"]
			   .createInstance( Components.interfaces.nsIFileInputStream );
	
	is.init( file,0x01, 00004, null);


		//var ref="http://ribeirao.remotestage.net:9980/remotestage/flow.jsp";
		var ref="http://www.taboca.com/remotestage/flow.jsp";

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


function mu_putFile(filename,arrayForm,arrayControl) {



	try {

		//var ref="http://ribeirao.remotestage.net:9980/emotestage/flow.jsp";
		var ref="http://www.taboca.com/remotestage/flow.jsp";

		var boundaryString = '123456789';
		var boundary = '--' + boundaryString;
		req = new XMLHttpRequest();

		var xmlSerializedEnvelope = mu_formatXML(arrayForm);


		var requestBody = [boundary,'Content-Disposition: form-data; name="xmlfd"','',xmlSerializedEnvelope,'',boundary,'Content-Disposition: form-data; name="'+arrayControl["keyfilename"]+'"; filename="test.jpg"','Content-Type: image/jpeg','',''].join('\r\n');

		req.open('POST', ref, true); 

		req.onreadystatechange = function (evt) {
			if (req.readyState == 4) {
				
				alert(req.responseText);
				
				mu_continuePublish();

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
	
			
			
			
    // the IO service
	var ioService = Components.classes["@mozilla.org/network/io-service;1"]
                              .getService(Components.interfaces.nsIIOService);

    // create an nsIURI

    var uri = ioService.newURI(filename, null, null);
	
    // get a channel for that nsIURI
    var channel = ioService.newChannelFromURI(uri);

  
    var is = channel.open();
     



var obj = Components.classes["@mozilla.org/binaryinputstream;1"].
            createInstance(Components.interfaces.nsIBinaryInputStream);


obj.setInputStream(is);


    
			
		var image = Components.classes["@mozilla.org/network/buffered-input-stream;1"].
	            createInstance(Components.interfaces.nsIBufferedInputStream);

		image.init(obj,obj.available());

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

/* 
 * Download service 
 */
 
 //Builds a three char string representing the specified number
function createNumber(number) {
	var Stringa;
	if (number <= 9) { 
		Stringa = "00" + number;
	} else if (number <= 99 && number >= 10) { 
		Stringa = "0" + number;
	} else {
		Stringa = number;
	}
	return Stringa;
}

function downloadImage(refImage) {

 
 try {

      localTarget = Components.classes["@mozilla.org/file/directory_service;1"]
                            .getService(Components.interfaces.nsIProperties)
                            .get("TmpD", Components.interfaces.nsIFile);

      localTarget.append("joeymedia.jpg");

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
    
    } catch (i) { alert("info"+i) } 
    
}

var g_uploadFileContentType=null;
var g_uploadFile=nmull;



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


