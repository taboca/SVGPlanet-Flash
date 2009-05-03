/* 
 * From the Minimo Homebase 
 * This should eb kept as MPL 
 */


function bmProcessor() {


  this.xmlRef=document.implementation.createDocument("","",null);               
  this.xslRef=document.implementation.createDocument("http://www.w3.org/1999/XSL/Transform","stylesheet",null);

	this.xmlUrl="";
	this.xslUrl="";

  this.callback = null;

  var myThis=this;
  var omega=function thisScopeFunction2() { myThis.xslLoaded(); }
  this.xslRef.addEventListener("load",omega,false);                             

  var myThis=this;
  var gamma=function thisScopeFunction3() { myThis.xmlLoaded(); }
  this.xmlRef.addEventListener("load",gamma,false);                             

  this.xmlLoadedState=false;
  this.xslLoadedState=false;

}

bmProcessor.prototype.xmlSet = function (urlstr) {

    this.xmlUrl=urlstr;

}                                                                               



bmProcessor.prototype.xmlSetDocument = function (docReference) {

	this.xmlLoadedState = true;
    this.xmlRef = docReference;

}         

bmProcessor.prototype.xslSet = function (urlstr) {
    this.xslUrl=urlstr;
}                                                                               

bmProcessor.prototype.xmlLoaded = function () {
	this.xmlLoadedState=true;
	this.apply();
}

bmProcessor.prototype.xslLoaded = function () {
	this.xslLoadedState=true;
	this.apply();
}

bmProcessor.prototype.setTargetDocument = function (targetDoc) {
	this.targetDocument=targetDoc;
}

bmProcessor.prototype.setTargetElement = function (targetEle) {
	this.targetElement=targetEle;
}

bmProcessor.prototype.apply = function () {


    if(this.xmlLoadedState&&this.xslLoadedState) {	
        var xsltProcessor = new XSLTProcessor();
        var htmlFragment=null;

        try {

          xsltProcessor.importStylesheet(this.xslRef);
         // htmlFragment = xsltProcessor.transformToFragment(this.xmlRef, this.targetDocument);
          htmlDocument = xsltProcessor.transformToDocument(this.xmlRef);

        } catch (e) {
        }

     //   this.targetElement.appendChild(htmlDocument);
	
	  this.callback(htmlDocument);

    }    
}

bmProcessor.prototype.run = function () {

	try {
		this.xslRef.load(this.xslUrl);                                          
		//this.xmlRef.load(this.xmlUrl);                                          
	}  catch (i) { alert(i) }
}
