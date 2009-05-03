<html>
   <head>
      <title>Display gift details</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script language="JavaScript" src="../../_sharedassets/pages.js"></script>
   </head>
   <body>
<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
   <td width="100%" align="left"><p><b>Using ActionScript 2.0 Components</b>&nbsp;<img src="../../_sharedassets/fp_spacer.gif" align="texttop"></p></td>
   <td rowspan="4">
      <a href="00002416.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
   </td>
   <td rowspan="4">&nbsp;&nbsp;</td>
   <td rowspan="4">
      <a href="00002418.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
   </td>
   </tr>
   <tr>
     <td align="left">&nbsp;</td>
   </tr>
   <tr>
     <td align="left"><a href="00002403.html">Creating an Application with Components</a> &gt;
Display gift details

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
<h1>Display gift details</h1>
<p>A pop-up window appears in the application when a user clicks a product in the Gift Ideas section. The pop-up window contains component instances that display information about the product, including a text description, an image, and the price. To make this pop-up window, you will create a movie clip symbol and add instances of the Loader, TextArea, Label, NumericStepper, and Button components. The product detail window for Bouquet of Flowers Extreme looks like this:</p>
<p><img src="images/fym_gift.png" alt="Bouquet of Flowers product detail window" border="0"></p>
<p></p>
<p>You will later add ActionScript that dynamically creates an instance of this movie clip for each product. These movie clip instances will be displayed in the Window component, which you added to the library earlier. The component instances will be populated with elements from the external XML file.</p>
<ol>
  <li>Drag an instance of the Window component from the Components panel to the library. 
    <p>The Window component symbol is now added to the library. Later in the tutorial, you will create instances of the Window component using ActionScript.</p>
  </li>
  <li>In the Library panel (Window&#160;&gt; Library), click the options menu on the right side of the title bar and select New Symbol. </li>
  <li>In the Create New Symbol dialog box, enter <strong>ProductForm</strong> for Name and select Movie Clip for Type. </li>
  <li>Click the Advanced button. Under Linkage, select Export for ActionScript, leave Export in First Frame selected, and click OK. A document window for the new symbol opens in symbol-editing mode.
    <p>For movie clip symbols that are in the library but not on the Stage, you must select Export for ActionScript so that you can manipulate them using ActionScript. (Exporting in first frame means that the movie clip is available as soon as the first frame loads.) Later in the tutorial you will add ActionScript that will generate an instance of the movie clip dynamically each time a user clicks a product in the Gift Ideas section.</p>
  </li>
  <li>In the Timeline for the new symbol, select Layer 1 and rename it <strong>Components</strong>.</li>
  <li>Drag an instance of the Loader component from the Components panel onto the Stage. Enter <strong>5</strong>, <strong>5</strong> for the <em>x</em>, <em>y</em> coordinates respectively. Enter <strong>image_ldr</strong> for the instance name. Click the Parameters tab in the Property inspector. Select <code>false</code> for <code>autoLoad</code> and <code>false</code> for <code>scaleContent</code>.
    <p>The Loader component instance will be used to display an image of the product. The <code>false</code> setting for <code>autoLoad</code> specifies that the image will not load automatically. The <code>false</code> setting for <code>scaleContent</code> specifies that the image will not be scaled. Later in the tutorial you will add code that loads the image dynamically, based on the product that the user selects in the Gift Ideas section.</p>
  </li>
  <li>Drag an instance of the TextArea component from the Components panel onto the Stage. Place it next to the Loader component. Enter <strong>125</strong>, <strong>5</strong> for the <em>x</em>, <em>y</em> coordinates respectively. Enter <strong>description_ta</strong> for the instance name. Set the Width to <strong>200</strong> and Height to <strong>130</strong>. Click the Parameters tab in the Property inspector. For editable, select <code>false</code>. For <code>html</code>, select <code>true</code>. For <code>wordWrap</code>, select <code>true</code>.
    <p>The TextArea component instance is used to display a text description of the selected product. The selected settings specify that the text cannot be edited by a user, that it can be formatted with HMTL tags, and that lines will wrap to fit the size of the text area.</p>
  </li>
  <li>Drag an instance of the Label component from the Components panel onto the Stage. Place it below the Loader component. Set the <em>x</em>, <em>y</em> coordinates to <strong>5</strong>, <strong>145</strong>. Enter <strong>price_lbl</strong> for the instance name. Click the Parameters tab in the Property inspector. For <code>autoSize</code>, select <code>left</code>. For <code>html</code>, select <code>true</code>.
    <p>The Label component instance will display the price of the product and the price qualifier (the quantity of products indicated by the specified price, such as &quot;each&quot; or &quot;one dozen.&quot;)</p>
  </li>
  <li>Drag an instance of the NumericStepper component from the Components panel onto the Stage. Place it below the TextArea component. Set the <em>x</em>, <em>y</em> coordinates to <strong>135</strong>, <strong>145</strong>. Enter <strong>quantity_ns</strong> for the instance name. Click the Parameters tab in the Property inspector. For <code>minimum</code>, enter <strong>1</strong>. 
    <p>Setting <code>minimum</code> to 1 specifies that the user must select at least one of the products in order to add the item to the cart. </p>
  </li>
  <li>Drag an instance of the Button component from the Components panel onto the Stage. Place it beside the NumericStepper component. Set the <em>x</em>, <em>y</em> coordinates to <strong>225</strong>, <strong>145</strong>. Enter <strong>addToCart_button</strong> for the instance name. Click the Parameters tab in the Property inspector. For <code>label</code>, enter <strong>Add To Cart</strong>.</li>
</ol>

<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
      <td colspan="4"><img src="../../_sharedassets/shim.gif" height="6" width="1"></td>
   </tr>
   <tr>
      <td colspan="4"><img src="../../_sharedassets/pixel.gif" height="1" width="100%"></td>
   </tr>
   <tr>
      <td colspan="4"><img src="../../_sharedassets/shim.gif" height="4" width="1"></td>
   </tr>
   <tr>
      <td width="100%" align="left"><p>&nbsp;</p></td>
      <td rowspan="2">
      <a href="00002416.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
      </td>
      <td rowspan="2">&nbsp;&nbsp;</td>
      <td rowspan="2">
      <a href="00002418.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
      </td>
   </tr>
   <tr>
       <td align="left"><p><b><a href="http://livedocs.adobe.com/flash/9.0/main/00002417.html" target="mm_window">View comments on LiveDocs</a></b></p></td>
   </tr>
</table>
   </body>
</html>                                                                                                             ﻿<html>
   <head>
      <title>Creating an Application with Components</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script language="JavaScript" src="../../_sharedassets/pages.js"></script>
   </head>
   <body>
<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
   <td width="100%" align="left"><p><b>Using ActionScript 2.0 Components</b>&nbsp;<img src="../../_sharedassets/FlashPro.gif" alt="Flash Professional only" align="texttop"></p></td>
   <td rowspan="4">
      <a href="00002402.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
   </td>
   <td rowspan="4">&nbsp;&nbsp;</td>
   <td rowspan="4">
      <a href="00002404.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
   </td>
   </tr>
   <tr>
     <td align="left">&nbsp;</td>
   </tr>
   <tr>
     <td align="left">Creating an Application with Components


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
<h1>Creating an Application with Components</h1>
<p>Components are prebuilt Flash elements that you can use when creating Fla