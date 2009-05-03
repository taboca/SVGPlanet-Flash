<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Quicken Loans</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" media="all" href="base.css" />
	<script language="JavaScript" type="text/javascript" src="global.js"></script>
</head>

<body>

	<!-- this is the code that determines the order of the selectable tags at the top of the page -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="26">
  <tr valign="bottom" align="left" bgcolor="#C0CBD6"> 
    <td>
      <table border="0" cellspacing="0" cellpadding="0" vspace="0" height="18">
        <tr bgcolor="#C0CBD6" valign="bottom"> 
		  <td><img src="tabtablebottomleft.gif" width="9" height="9" border="0" alt=""></td>
		  <td width="129" height="18"><P STYLE="color: 093f61; font-family: tahoma; margin-left: 6px; margin-bottom: 2px; font-size: x-small"><b>Quicken Loans</b></font></td>
          <td colspan="3"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><img src="clearpixel.gif" width="82" height="18"></font></td>
		  <td colspan="3"><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><img src="overview_sel.gif" width="82" height="18"></font></td>
          <td colspan="3"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><A HREF="23b1.htm"><img src="application.gif" width="82" height="18" border="0"></a></font></td>
          <td colspan="3"><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><A HREF="23b2.htm"><img src="about.gif" width="82" height="18" border="0"></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- this ends the tab code -->


	<div id="wrapper">
		<div id="logo">
			<img src="ql_logo.gif" alt="Quicken Loans" width="157" height="44" />
			<p>America's Home Loan Experts<sup>SM</sup></p>
		</div>
		<div id="message">
			<h1>Quicken Users:</h1>
			<p>Quicken Loans can help you free<br />up thousands a year with a<br />better mortgage.</p>
		</div>
		<div id="content">
			<img src="overview_header.gif" class="header" alt="Get Mortgage Interest Rates - Quick and Easy" width="469" height="31" />
			<p class="pitch">Call us today to get <strong>your great mortgage rate</strong> and payment options. Or, get rates and payments online with our interactive rate calculator. It's quick &amp; easy, and there's no obligation!</p>
			
			<table id="mortgage_rates_display" cellpadding="0" cellspacing="0">
				<tr>
					<th class="top_left_corner">Mortgage Rate Hotline</th>
					<th class="top_right_corner">Get Mortgage Rates Online</th>		
				</tr>
				<tr>
					<td class="left_display_cell">
						<p id="hotline">Let our home loan experts answer all of your questions, give you a custom mortgage rate quote and approve your loan right over the phone.</p>
					</td>
					<td class="right_display_cell">
						<form id="super_widget" method="post" name="super_widget" onsubmit="sendform(); return false">
							<select name="purpose" onchange="toggleFormDisplay(this.value)">
								<option value="loan purpose">Select Loan Purpose</option>
								<option value="refinance">Refinance</option>
								<option value="purchase">Purchase</option>
							</select>
							
							<div id="refinance" class="show">
							<dl>
								<dt>
									<label for="loan_amount">Desired Loan Amount</label>
								</dt>
								<dd><input name="loan_amount" size="15" type="text" value="" /></dd>
								
								<dt><label for="loan_payment">Current Monthly Payment</label></dt>
								<dd><input name="loan_payment" size="15" type="text" value="" /></dd>							
							</dl>						
							</div>
							
							<div id="purchase" class="hide">
							<dl>
								<dt><label for="purch_price">Expected Purchase Price</label></dt>
								<dd><input name="purch_price" size="15" type="text" value="" /></dd>
								
								<dt><label for="down_payment">Expected Down Payment</label></dt>
								<dd><input name="down_payment" size="15" type="text" value="" /></dd>							
							</dl>
							</div>
							
							<select name="state"> 
								<option value="" selected="selected">Choose A State</option>													
								<option value="al">Alabama</option>
								<option value="ak">Alaska</option>
								<option value="az">Arizona</option>
								<option value="ar">Arkansas</option>
								<option value="ca">California</option>
								<option value="co">Colorado</option>
								<option value="ct">Connecticut</option>
								<option value="dc">District of Columbia</option>
								<option value="de">Delaware</option>
								<option value="fl">Florida</option>
								<option value="ga">Georgia</option>
								<option value="hi">Hawaii</option>
								<option value="id">Idaho</option>
								<option value="il">Illinois</option>
								<option value="in">Indiana</option>
								<option value="ia">Iowa</option>
								<option value="ks">Kansas</option>
								<option value="ky">Kentucky</option>
								<option value="la">Louisiana</option>
								<option value="me">Maine</option>
								<option value="md">Maryland</option>
								<option value="ma">Massachusetts</option>
								<option value="mi">Michigan</option>
								<option value="mn">Minnesota</option>
								<option value="ms">Mississippi</option>
								<option value="mo">Missouri</option>
								<option value="mt">Montana</option>
								<option value="ne">Nebraska</option>
								<option value="nv">Nevada</option>
								<option value="nh">New Hampshire</option>
								<option value="nj">New Jersey</option>
								<option value="nm">New Mexico</option>
								<option value="ny">New York</option>
								<option value="nc">North Carolina</option>
								<option value="nd">North Dakota</option>
								<option value="oh">Ohio</option>
								<option value="ok">Oklahoma</option>
								<option value="or">Oregon</option>
								<option value="pa">Pennsylvania</option>
								<option value="ri">Rhode Island</option>
								<option value="sc">South Carolina</option>
								<option value="sd">South Dakota</option>
								<option value="tn">Tennessee</option>
								<option value="tx">Texas</option>
								<option value="ut">Utah</option>
								<option value="vt">Vermont</option>
								<option value="va">Virginia</option>
								<option value="wa">Washington</option>
								<op