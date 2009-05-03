////
/// Pink Search Customization 
//  by Marcio Galli / Taboca Inc. 
//


var gPrefBackground = "chrome://pinksearch/skin/suggestion-1.jpg";

function pinkSearchCheckFirstTime() {

	var prefService = Components.classes["@mozilla.org/preferences-service;1"].getService(Components.interfaces.nsIPrefBranch);

	try
		{
		installed = prefService.getBoolPref("extensions.pinksearch.installed");
		
		    if(!installed) {

                pinkSearchOpenSidebar();

		    }
		    		    

		}
	catch(e) { }
	
}

function pinkSearchStartup() {

        pinkSearchCheckFirstTime();

}

function pinkSearchOpenSidebar() {

    setTimeout("toggleSidebar('viewfssSidebar')",1000);
    
}

addEventListener("load", pinkSearchStartup, false);
