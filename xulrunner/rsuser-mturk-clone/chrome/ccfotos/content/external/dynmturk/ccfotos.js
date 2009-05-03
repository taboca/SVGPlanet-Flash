  
  ////
  /// Copyright (C) 2007 CCfotos and Taboca Inc. 
  // 
	var searchControl;
	var siteSearch;


        var searchResult = { call:function() {

                document.getElementById("imagesearch").innerHTML="";
                for(var i=0;i<siteSearch.results.length;i++) {

                        var ele = siteSearch.results[i];

                        if(ele.unescapedUrl.indexOf("index.html")>-1) {

                           var URLFile = ele.unescapedUrl;
                           var newTemp = URLFile.split("index.html");
                           URLFile=newTemp[0];

                           var toImage = "test.jpg";

                          var str="<"+"img style='margin:.5em' border='0' src='"+URLFile+toImage+"' width='140' />";


                                  document.getElementById("imagesearch").innerHTML+="<"+"p>"+"<"+"a title='"+ele.content+"' href='"+URLFile+"'>"+str+ "<"+"/a"+"<"+"/p>";
                    }
                }      
         } }


    function OnLoad() {
    
      checkFocus();
    
    
      searchControl = new GSearchControl();
	  siteSearch = new GwebSearch();
 	  siteSearch.setUserDefinedLabel("ccfotos");
	  siteSearch.setUserDefinedClassSuffix("siteSearch");
	  siteSearch.setSiteRestriction("ccfotos.taboca.com.br");
	  searchControl.setResultSetSize(siteSearch.SMALL_RESULTSET);
      searchControl.addSearcher(siteSearch);

      var drawOptions = new GdrawOptions();
      drawOptions.setDrawMode(GSearchControl.DRAW_MODE_TABBED);
      searchControl.draw(document.getElementById("searchcontrol"),drawOptions);
      
      var searchString = "flores";
      
      try {
 	     var listTags = document.getElementById("tags").innerHTML;  
 	     var trySplit = listTags.split(",");
    	 if(trySplit&&trySplit.length>1) {
    	 	searchString=trySplit[0];
    	 }   
   	     var trySplit = listTags.split(" ");
    	 if(trySplit&&trySplit.length>1) {
    	 	searchString=trySplit[0];
    	 }   
      } catch(i) {
	      searchString = document.getElementById("tags").innerHTML;  
      }

 
  	    searchControl.execute(searchString);  
 		searchControl.setSearchCompleteCallback(searchResult,searchResult.call);

		/* This fixes the images to 738 pixels */ 
		
		try { 
	     varProbeImagesize = parseInt(document.getElementById("mainImage").offsetWidth);
	     if(varProbeImagesize>770) {
	     
	       document.getElementById("mainImage").setAttribute("width","738");
	     
	     } 
	     
	    } catch (i) {} 

    }

	function exec(tt) {
	      searchControl.execute(tt);
	}
	
	function openPromo() {
	
		document.getElementById("promopanel").style.display="block";
		
	}
	
	function closePromo() {
	
		document.getElementById("promopanel").style.display="none";
		document.getElementById("headerpromo").innerHTML="Obrigado por participar da promoção";
	
	}
	
  function openSend() {
  
    document.getElementById("formContainer").style.display="block";
    document.getElementById("imageContainer").style.display="none";
  
  
    document.forms[1].myLink.value=document.location;
  
    document.getElementById("toimg").innerHTML="<"+"img src='"+document.getElementById("mainImage").src+"' width='320' style='padding:4px;border:1px solid black;margin:4px '/>"; 
  
  }
  
  function kickEvent(str) {
  
    document.getElementById("formContainer").style.display="none";
    document.getElementById("imageContainer").style.display="none";
    document.getElementById("resultsContainer").style.display="block";

  } 


////
/// openFocus implementation beta
//

    function openFocus() {
       
       document.getElementById("preFocus").style.display="block";
       
       if(createdImage) {
        document.getElementById("imageContainer").removeChild(createdImage);
        
             var curImg = document.getElementById("mainImage");
           
            if(curImg.filters) {
                curImg.filters.alpha.opacity = 100;
            } else {
                curImg.style.opacity=1;
            }
            
       }
       
        createPointers();
        document.onmousedown = initMark;
        document.onmousemove = pointerUpdate;

    }

    function dd(v) { 
    
        document.getElementById("dump").innerHTML+=v+"<br />";
        
   }
   
   function initMark() {


  
         createDragPointers();
  
        document.onmousemove = dragUpdate;
        document.onmouseup = dragEnd;
           

   }
   
   var createdImage = null;
   
   function dragEnd(e) {
            
            document.getElementById("preFocus").style.display="none";

            var curImg = document.getElementById("mainImage");
            
            var im = document.createElement("img");
            im.setAttribute("width","300");
            im.src=curImg.src;
            
            var bs = document.createElement("div");
         
            bs.style.position="absolute";
            bs.style.top  = elementPointerX.style.top;
            bs.style.left = elementPointerY.style.left;
            bs.style.height = parseInt(parseInt(dragPointerX.style.top)-parseInt(elementPointerX.style.top))+"px";
            bs.style.width  = parseInt(parseInt(dragPointerY.style.left)-parseInt(elementPointerY.style.left))+"px";
            bs.style.border="1px solid white"; 
           
            str="rect("+elementPointerX.style.top+","+dragPointerY.style.left+","+dragPointerX.style.top+","+elementPointerY.style.left+")";
            im.style.overflow="hidden";
            im.style.position="absolute";
            im.style.clip=str;
            
            im.style.border="1px solid white";
            im.style.top="0px";
            im.style.left="0px";
            
            if(curImg.filters) {
                curImg.filters.alpha.opacity = 100;
            } else {
                curImg.style.opacity=1;
            }
            
            createdImage = im;
            
            document.getElementById("imageContainer").appendChild(im);
            document.getElementById("imageContainer").appendChild(bs);

            elementPointerX.style.display="none";
            elementPointerY.style.display="none";
            dragPointerX.style.display="none";
            dragPointerY.style.display="none";
            
           document.onmousemove=null;
           document.onmousedown=null;
           document.onmouseup=null;
           
           document.getElementById("infoFocus").style.display="block";
           

            var electedLocation = null;
            
            try { 
               
               electedLocation = document.location;
            
               if(electedLocation) {
                     electedLocation=electedLocation.toString();
                     
                     var value = electedLocation.split("?f=");
                     if(value) {
                         if(value.length>1) {
                         electedLocation = value[0];
                         }
                     }
               }
               
             } catch(i) {  } 
           
           document.getElementById("infoFocusURL").value=electedLocation+"?f="+str;
           
           addEntry(null,electedLocation+"?f="+str);
            
   }


    var currentURL = null;
    var currentLocation = null;
       
   function addEntry(imageURL,formLocation) {
   
    currentLocation = formLocation;
   
    document.getElementById("editArea").style.display="block";
    document.getElementById("editComments").style.display="block";
    document.getElementById("editComments").value="";
    
    
   
   }
   
   var ccc=0;
   
   function continueEntry() {
   
      var formValue = document.createElement("input");

      formValue.setAttribute("type","text");
      formValue.setAttribute("name","entry"+ccc);
      formValue.setAttribute("value",currentLocation);
      
      document.getElementById("repoForm").appendChild(formValue);

      var formValue = document.createElement("input");
      var commentValue= document.getElementById("editComments").value;
 
      formValue.setAttribute("type","text");
      formValue.setAttribute("name","comment"+ccc);
      formValue.setAttribute("value",commentValue);

      document.getElementById("repoForm").appendChild(formValue);
      
      ccc++;
      
   }
   
   function dragUpdate(e) {
   
            var pageX = null;
            var pageY = null;
            var scrollY = null; var scrollX = null;
    
          if(document.all) {
                e = event;
            
                recX = e.clientX;
                recY = e.clientY;

                scrollY = document.body.scrollTop;
                scrollX = document.body.scrollLeft;
                pageX = e.clientX+document.body.scrollLeft;
                pageY = e.clientY+document.body.scrollTop;
                
        } else {
                recX = e.clientX;
                recY = e.clientY;

                scrollY = window.scrollY;
                scrollX = window.scrollX;

                pageX = e.clientX+window.scrollX;
                pageY = e.clientY+window.scrollY;
        }
        var container = document.getElementById("imageContainer");
        if( pageX > container.offsetLeft && pageX <container.offsetLeft+container.offsetWidth  ) {
            dragPointerY.style.left= e.clientX + scrollX - container.offsetLeft +"px"; 
        }
        if( pageY > container.offsetTop && pageY < container.offsetTop+container.offsetHeight) {
            dragPointerX.style.top= e.clientY + scrollY- container.offsetTop +"px"; 
        }
   }
    
    var recX = 0;
    var recY = 0;
    var elementPointerX = null;
    var elementPointerY = null;
    
    var dragPointerX = null;
    var dragPointerY = null;
    
    function pointerUpdate(e) {
    
            var pageX = null;
            var pageY = null;
            var scrollY = null; var scrollX = null;
      

          if(document.all) {
            
      
            e = event;
            
                recX = e.clientX;
                recY = e.clientY;

                scrollY = document.body.scrollTop;
                scrollX = document.body.scrollLeft;
                pageX = e.clientX+document.body.scrollLeft;
                pageY = e.clientY+document.body.scrollTop;
                
        } else {
                recX = e.clientX;
                recY = e.clientY;

                scrollY = window.scrollY;
                scrollX = window.scrollX;

                pageX = e.clientX+window.scrollX;
                pageY = e.clientY+window.scrollY;
        }


    
        var container = document.getElementById("imageContainer");

        if( pageX > container.offsetLeft && pageX <container.offsetLeft+container.offsetWidth  ) {
        
     
            elementPointerY.style.left= e.clientX + scrollX - container.offsetLeft +"px"; 
            
        }
        if( pageY > container.offsetTop && pageY < container.offsetTop+container.offsetHeight) {
        
            elementPointerX.style.top= e.clientY + scrollY- container.offsetTop +"px"; 
        
        }
        
    

    }

    function createPointers() {

        if(elementPointerX==null) {
        
        elementPointerX = document.createElement("div");
        var imageWidth = document.getElementById("mainImage").offsetWidth;

        elementPointerX.style.position="absolute";
        elementPointerX.style.top="200px";
        elementPointerX.style.left="0px";
        elementPointerX.style.width=imageWidth+"px";
        elementPointerX.style.height="1px";
        elementPointerX.style.padding="0";
        elementPointerX.style.borderTop="1px solid white";

        document.getElementById("imageContainer").appendChild(elementPointerX);

        elementPointerY= document.createElement("div");

        var imageHeight = document.getElementById("mainImage").offsetHeight;

        elementPointerY.style.position="absolute";
        elementPointerY.style.top="0px";
        elementPointerY.style.left="300px";
        elementPointerY.style.height=imageHeight+"px";
        elementPointerY.style.width="1px";
        elementPointerY.style.borderLeft="1px solid black";
        elementPointerY.style.borderRight="1px solid white";

        document.getElementById("imageContainer").appendChild(elementPointerY);

 
        } else {
        
            elementPointerX.style.display="block";
            elementPointerY.style.display="block";
            
            }
    }


    function createDragPointers() {

        if(dragPointerX==null) {
        
        dragPointerX = document.createElement("div");
        var imageWidth = document.getElementById("mainImage").offsetWidth;

        dragPointerX.style.position="absolute";
        dragPointerX.style.top="200px";
        dragPointerX.style.left="0px";
        dragPointerX.style.width=imageWidth+"px";
        dragPointerX.style.height="1px";
        dragPointerX.style.borderTop="1px solid black";

        document.getElementById("imageContainer").appendChild(dragPointerX);

        dragPointerY    = document.createElement("div");

        var imageHeight = document.getElementById("mainImage").offsetHeight;

        dragPointerY.style.position="absolute";
        dragPointerY.style.top="0px";
        dragPointerY.style.left="300px";
        dragPointerY.style.height=imageHeight+"px";
        dragPointerY.style.width="1px";
        dragPointerY.style.borderLeft="1px solid black";
        dragPointerY.style.borderRight="1px solid white";

        document.getElementById("imageContainer").appendChild(dragPointerY);

        } else {
        
            dragPointerX.style.display="block";
            dragPointerY.style.display="block";

        }
        
    }


function checkFocus() {

    try {
    
        if(document.location.search) {
        
            var value = document.location.search.split("?f=");
            var clipValue = value[1];
           
           if(clipValue) {
                var curImg = document.getElementById("mainImage");
                
                var im = document.createElement("img");
                im.src=curImg.src;
 
                str=clipValue;
                im.style.overflow="hidden";
                im.style.position="absolute";
                im.style.clip=str;
                
                im.style.top="0px";
                im.style.left="0px";
                
                if(curImg.filters) {
                    curImg.filters.alpha.opacity = 30;
                } else {
                    curImg.style.opacity=.3;
                }
               document.getElementById("imageContainer").appendChild(im);
                
                createdImage = im;

           }
           
        
        }
    } catch (i) {
    
    }

}