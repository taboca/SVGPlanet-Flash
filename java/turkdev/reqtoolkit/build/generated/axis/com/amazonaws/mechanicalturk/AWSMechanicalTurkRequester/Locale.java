<html>
   <head>
      <title>Creating an application with the UILoader</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script language="JavaScript" src="../../_sharedassets/pages.js"></script>
   </head>
   <body>
<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
   <td width="100%" align="left"><p><b>Using ActionScript 3.0 Components</b>&nbsp;<img src="../../_sharedassets/fp_spacer.gif" align="texttop"></p></td>
   <td rowspan="4">
      <a href="00000482.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
   </td>
   <td rowspan="4">&nbsp;&nbsp;</td>
   <td rowspan="4">
      <a href="00000484.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
   </td>
   </tr>
   <tr>
     <td align="left">&nbsp;</td>
   </tr>
   <tr>
     <td align="left"><a href="00000419.html">Using the UI Components</a> &gt;
<a href="00000480.html">Using the UILoader</a> &gt;
Creating an application with the UILoader
</td>
   </tr>
   <tr>
      <td align="left">&nbsp;</td>
   </tr>
   <tr>
      <td colspan="4"><img src="../../_sharedassets/shim.gif" height="4" width="1"></td>
   </tr>
   <tr>
      <td colspan="4"><img src="../../_sharedassets/pixel.gif" height="1" width="100%"></td>
   </tr>
   <tr>
      <td colspan="4"><img src="../../_sharedassets/shim.gif" height="11" width="1"></td>
   </tr>
</table>
<h1>Creating an application with the UILoader</h1>
<p>The following procedure explains how to add a UILoader component to an application while authoring. In this example, the loader loads a GIF image of a logo.</p>
<h4><a href="" onClick="return toggleProcedure('1')" onFocus="this.blur()"><img src="../../_sharedassets/expand.gif" ID="expander1" class="expander">To create an application with the UILoader component:</a></h4>
<div class="procedure" id="procedure1">
<ol>
  <li>Create a new Flash file (ActionScript 3.0) document.</li>
  <li>Drag a UILoader component from the Components panel to the Stage.</li>
  <li>In the Property inspector, enter the instance name <strong>aUI</strong>.</li>
  <li>Select the loader on the Stage and in the Component inspector, and enter <strong>http://www.helpexamples.com/images/logo.gif</strong> for the <code>source</code> parameter.</li>
</ol>
</div>
<p>This example creates a UILoader component using ActionScript and loads a JPEG image of a flower. When the <code>complete</code> event occurs, it displays the number of bytes loaded in the Output panel.</p>
<h4><a href="" onClick="return toggleProcedure('2')" onFocus="this.blur()"><img src="../../_sharedassets/expand.gif" ID="expander2" class="expander">To create a UILoader component instance using ActionScript:</a></h4>
<div class="procedure" id="procedure2">
<ol>
  <li>Create a new Flash file (ActionScript 3.0) document.</li>
  <li>Drag the UILoader component from the Components panel to the Library panel.</li>
  <li>Open the Actions panel, select Frame 1 in the main Timeline, and enter the following ActionScript code:

<div class="listing">
<pre>
import fl.containers.UILoader;

var aLoader:UILoader = new UILoader();
aLoader.source = &quot;http://www.flash-mx.com/images/image1.jpg&quot;;
aLoader.scaleContent = false;
addChild(aLoader);

aLoader.addEventListener(Event.COMPLETE, completeHandler);
function completeHandler(event:Event) {
    trace(&quot;Number of bytes loaded: &quot; + aLoader.bytesLoaded);
}
</pre>
</div>  </li>
  <li>Select Control &gt; Test Mo