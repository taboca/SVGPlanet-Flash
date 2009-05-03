<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- /home/espenr/tmp/qt-3-espenr-28736/qt-x11-free-3.3.4/src/widgets/qwidgetstack.cpp:97 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QWidgetStack Class</title>
<style type="text/css"><!--
fn { margin-left: 1cm; text-indent: -1cm; }
a:link { color: #004faf; text-decoration: none }
a:visited { color: #672967; text-decoration: none }
body { background: #ffffff; color: black; }
--></style>
</head>
<body>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr bgcolor="#E5E5E5">
<td valign=center>
 <a href="index.html">
<font color="#004faf">Home</font></a>
 | <a href="classes.html">
<font color="#004faf">All&nbsp;Classes</font></a>
 | <a href="mainclasses.html">
<font color="#004faf">Main&nbsp;Classes</font></a>
 | <a href="annotated.html">
<font color="#004faf">Annotated</font></a>
 | <a href="groups.html">
<font color="#004faf">Grouped&nbsp;Classes</font></a>
 | <a href="functions.html">
<font color="#004faf">Functions</font></a>
</td>
<td align="right" valign="center"><img src="logo32.png" align="right" width="64" height="32" border="0"></td></tr></table><h1 align=center>QWidgetStack Class Reference</h1>

<p>The QWidgetStack class provides a stack of widgets of which
only the top widget is user-visible.
<a href="#details">More...</a>
<p><tt>#include &lt;<a href="qwidgetstack-h.html">qwidgetstack.h</a>&gt;</tt>
<p>Inherits <a href="qframe.html">QFrame</a>.
<p><a href="qwidgetstack-members.html">List of all member functions.</a>
<h2>Public Members</h2>
<ul>
<li class=fn><a href="#QWidgetStack"><b>QWidgetStack</b></a> ( QWidget&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )</li>
<li class=fn><a href="#QWidgetStack-2"><b>QWidgetStack</b></a> ( QWidget&nbsp;*&nbsp;parent, const&nbsp;char&nbsp;*&nbsp;name, WFlags&nbsp;f )</li>
<li class=fn><a href="#~QWidgetStack"><b>~QWidgetStack</b></a> ()</li>
<li class=fn>int <a href="#addWidget"><b>addWidget</b></a> ( QWidget&nbsp;*&nbsp;w, int&nbsp;id = -1 )</li>
<li class=fn>void <a href="#removeWidget"><b>removeWidget</b></a> ( QWidget&nbsp;*&nbsp;w )</li>
<li class=fn>QWidget * <a href="#widget"><b>widget</b></a> ( int&nbsp;id ) const</li>
<li class=fn>int <a href="#id"><b>id</b></a> ( QWidget&nbsp;*&nbsp;widget ) const</li>
<li class=fn>QWidget * <a href="#visibleWidget"><b>visibleWidget</b></a> () const</li>
</ul>
<h2>Public Slots</h2>
<ul>
<li class=fn>void <a href="#raiseWidget"><b>raiseWidget</b></a> ( int&nbsp;id )</li>
<li class=fn>void <a href="#raiseWidget-2"><b>raiseWidget</b></a> ( QWidget&nbsp;*&nbsp;w )</li>
</ul>
<h2>Signals</h2>
<ul>
<li class=fn>void <a href="#aboutToShow"><b>aboutToShow</b></a> ( int )</li>
<li class=fn>void <a href="#aboutToShow-2"><b>aboutToShow</b></a> ( QWidget * )</li>
</ul>
<h2>Protected Members</h2>
<ul>
<li class=fn>virtual void <a href="#setChildGeometries"><b>setChildGeometries</b></a> ()</li>
</ul>
<hr><a name="details"></a><h2>Detailed Description</h2>


The QWidgetStack class provides a stack of widgets of which
only the top widget is user-visible.
<p> 

<p> The application programmer can move any widget to the top of the
stack at any time using <a href="#raiseWidget">raiseWidget</a>(), and add or remove widgets
using <a href="#addWidget">addWidget</a>() and <a href="#removeWidget">removeWidget</a>(). It is not sufficient to pass
the widget stack as parent to a widget which should be inserted into
the widgetstack.
<p> <a href="#visibleWidget">visibleWidget</a>() is the <em>get</em> equivalent of raiseWidget(); it
returns a pointer to the widget that is currently at the top of
the stack.
<p> QWidgetStack also provides the ability to manipulate widgets
through application-specified integer IDs. You can also translate
from widget pointers to IDs using <a href="#id">id</a>() and from IDs to widget
pointers using <a href="#widget">widget</a>(). These numeric IDs are unique (per
QWidgetStack, not globally), but QWidgetStack does not attach any
additional meaning to them.
<p> The default widget stack is frameless, but you can use the usual
<a href="qframe.html">QFrame</a> functions (such as <a href="qframe.html#setFrameStyle">setFrameStyle</a>()) to add a frame.
<p> QWidgetStack provides a signal, <a href="#aboutToShow">aboutToShow</a>(), which is emitted
just before a managed widget is shown.
<p> <p>See also <a href="qtabdialog.html">QTabDialog</a>, <a href="qtabbar.html">QTabBar</a>, <a href="qframe.html">QFrame</a>, and <a href="organizers.html">Organizers</a>.

<hr><h2>Member Function Documentation</h2>
<h3 class=fn><a name="QWidgetStack"></a>QWidgetStack::QWidgetStack ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )
</h3>
Constructs an empty widget stack.
<p> The <em>parent</em> and <em>name</em> arguments are passed to the <a href="qframe.html">QFrame</a>
constructor.

<h3 class=fn><a name="QWidgetStack-2"></a>QWidgetStack::QWidgetStack ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;parent, const&nbsp;char&nbsp;*&nbsp;name, WFlags&nbsp;f )
</h3>
Constructs an empty widget stack.
<p> The <em>parent</em>, <em>name</em> and <em>f</em> arguments are passed to the <a href="qframe.html">QFrame</a>
constructor.

<h3 class=fn><a name="~QWidgetStack"></a>QWidgetStack::~QWidgetStack ()
</h3>
Destroys the object and frees any allocated resources.

<h3 class=fn>void <a name="aboutToShow"></a>QWidgetStack::aboutToShow ( int )<tt> [signal]</tt>
</h3>

<p> This signal is emitted just before a managed widget is shown if
that managed widget has an ID != -1. The argument is the numeric
ID of the widget.
<p> If you call <a href="#visibleWidget">visibleWidget</a>() in a slot connected to <a href="#aboutToShow">aboutToShow</a>(),
the widget it returns is the one that is currently visible, not
the one that is about to be shown.

<h3 class=fn>void <a name="aboutToShow-2"></a>QWidgetStack::aboutToShow ( <a href="qwidget.html">QWidget</a>&nbsp;* )<tt> [signal]</tt>
</h3>

<p> This is an overloaded member function, provided for convenience. It behaves essentially like the above function.
<p> This signal is emitted just before a managed widget is shown. The
argument is a pointer to the widget.
<p> If you call <a href="#visibleWidget">visibleWidget</a>() in a slot connected to <a href="#aboutToShow">aboutToShow</a>(),
the widget returned is the one that is currently visible, not the
one that is about to be shown.

<h3 class=fn>int <a name="addWidget"></a>QWidgetStack::addWidget ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;w, int&nbsp;id = -1 )
</h3>
Adds widget <em>w</em> to this stack of widgets, with ID <em>id</em>.
<p> If you pass an id &gt;= 0 this ID is used. If you pass an <em>id</em> of
-1 (the default), the widgets will be numbered automatically. If
you pass -2 a unique negative integer will be generated. No widget
has an ID of -1. Returns the ID or -1 on failure (e.g. <em>w</em> is 0).
<p> If you pass an id that is already used, then a unique negative
integer will be generated to prevent two widgets having the same
id.
<p> If <em>w</em> is not a child of this QWidgetStack moves it using
<a href="qwidget.html#reparent">reparent</a>().

<p>Example: <a href="xform-example.html#x1393">xform/xform.cpp</a>.
<h3 class=fn>int <a name="id"></a>QWidgetStack::id ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;widget ) const
</h3>
Returns the ID of the <em>widget</em>. Returns -1 if <em>widget</em> is 0 or
is not being managed by this widget stack.
<p> <p>See also <a href="#widget">widget</a>() and <a href="#addWidget">addWidget</a>().

<h3 class=fn>void <a name="raiseWidget"></a>QWidgetStack::raiseWidget ( int&nbsp;id )<tt> [slot]</tt>
</h3>
Raises the widget with ID <em>id</em> to the top of the widget stack.
<p> <p>See also <a href="#visibleWidget">visibleWidget</a>().

<p>Example: <a href="xform-example.html#x1394">xform/xform.cpp</a>.
<h3 class=fn>void <a name="raiseWidget-2"></a>QWidgetStack::raiseWidget ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;w )<tt> [slot]</tt>
</h3>
This is an overloaded member function, provided for convenience. It behaves essentially like the above function.
<p> Raises widget <em>w</em> to the top of the widget stack.

<h3 class=fn>void <a name="removeWidget"></a>QWidgetStack::removeWidget ( <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;w )
</h3>
Removes widget <em>w</em> from this stack of widgets. Does not delete <em>w</em>. If <em>w</em> is the currently visible widget, no other widget is
substituted.
<p> <p>See also <a href="#visibleWidget">visibleWidget</a>() and <a href="#raiseWidget">raiseWidget</a>().

<h3 class=fn>void <a name="setChildGeometries"></a>QWidgetStack::setChildGeometries ()<tt> [virtual protected]</tt>
</h3>
Fixes up the children's geometries.

<h3 class=fn><a href="qwidget.html">QWidget</a>&nbsp;* <a name="visibleWidget"></a>QWidgetStack::visibleWidget () const
</h3>
Returns the currently visible widget (the one at the top of the
stack), or 0 if nothing is currently being shown.
<p> <p>See also <a href="#aboutToShow">aboutToShow</a>(), <a href="#id">id</a>(), and <a href="#raiseWidget">raiseWidget</a>().

<h3 class=fn><a href="qwidget.html">QWidget</a>&nbsp;* <a name="widget"></a>QWidgetStack::widget ( int&nbsp;id ) const
</h3>
Returns the widget with ID <em>id</em>. Returns 0 if this widget stack
does not manage a widget with ID <em>id</em>.
<p> <p>See also <a href="#id">id</a>() and <a href="#addWidget">addWidget</a>().

<!-- eof -->
<hr><p>
This file is part of the <a href="index.html">Qt toolkit</a>.
Copyright &copy; 1995-2004
<a href="http://www.trolltech.com/">Trolltech</a>. All Rights Reserved.<p><address><hr><div align=center>
<table width=100% cellspacing=0 border=0><tr>
<td>Copyright &copy; 2004
<a href="troll.html">Trolltech</a><td align=center><a href="trademarks.html">Trademarks</a>
<td align=right><div align=right>Qt 3.3.4</div>
</table></div></address></body>
</html>
                                                                                                                                                                                                                                                                2?itîl141ñ €¹rñ w25¸r1p…	1 °7?p ñRm ¤`f¡¤Q&@±nðlQ…¢5¼ "jp!Ôp AÀ; ¸ ã£°£õ†jƒjB„jâv@m l€h@¨`:ÿðrñbq¡	ñRsRñÿñ1 uR1ñ ñ6}Rñ÷±2PKtÐ<q11 }Re06sR11Rk•ðAUpEiÐs 1%×qRRoÐQD>¹\ß±q1 ±R ög2"É=  ¸€3„6P6¶`9€6c‰Q6cq6c‘6á¥6cÓ`M€?4{?414Àñ
q44„¯qu%1q%R@–_4 ñ¡ ñuOLraÿrºÃ²ð2±± qXstyò.1,bc  0,'´ pœ JP‹5 ¸ 9p; @°ÌPŠ5  = E Â =  @¸ 	9:Ô¢ 
¢ ;  = =  ; ¸ : QÃ  T   0 g  U R L BÐ a r < l d o c  u m e n (t 66e "f fu l 2V êi Fw . ~Î"g &t C Šm Šp Gt d S /òy 5e '+	‡3qa Wn 5r UW
 v s b l t y —Ól ;  ‹gd€s p€?ra€  snÛ€T6	„%9f€	Þs€	=5s€,.Þc€f‡o€-–
D€3a€2o g Š„')€c h€³¢o‚©: /€ b‚Ôw (r€c‚B•Õ€/€p€5n€ÑÆŠa€7i‚. x€©l€)€…K_ bA‚mn k „‹€‰;,@o d@o¨l ,ÂtÀe@­Ã€ÄÁ9wÀ1nÀ
 o w °³c cÈ`3 €´cÍ` dÀ º€.(Ê°f˜#Áhr ome://br owser/co ntentÅ.j8s $ ÁÁj	€æ  L—À·… ÁÁ ÅVLÀ?ªc@/tÀ&o@¦CB2:lÂ/cÀ=ÁÆ € ùÀŽ­ÞÁHÂÀ'ÁÁ ;  9€ >ø: ÆÂ·ÁÅrAdØt T@AÀoB°Å#ïÁ	ÁÉÁÄÁ‚ÁN ÀÁ‘ÁA¸ :|  ÅÁÁ‡Õ6aÔd… åT5 8ÁêÁÃT @°°È`§a]áÿera33àãáçä˜d á«AáLBªXO¤`T 3Öb¤Ã €ä#&¥à#e3à1¸ 9=  @@@BB:  Q;  è;  55À¢ëaag —r`Behá«aa0làaàWOàDze`9a Dé˜á#;:M là!g  å˜ÿ m¤aåqD6`a÷a @F d á>‚hDÿd ¢Dááañá
aãáé”cdÁB==c=<€*áa
dFH° cÌ`´³ïGGPà|aG9à	a3ç	x™"ƒ á!m€ db©á±e"5ãWûàn% bÅáa aHáóa À câŒ ‡€á6ñâ!laga¶aáá$phrefá#ap ostDataØ ­Þaža `1aÇa`1áƒX 
#„é1_aKÿƒcâ
„ d?äáaÁá; à_À^`^@@; ø: á…áaaaûå…éÌ áb"èÌáßåùa5.òRcgPh³ñ1 Ñj‘~5r05s•pcDÐ2t0 Õ`fî ¿!?_rEJ 
1vñ
õI¸€JÊ`‘w¿c3+Dp1
wüpšA4 q¡ ñI?&ÏQzóI±$  ðqÃ1 ±aUrl± ±1aReferreµ’±1aChaprset±ñ%²P&Àq1‘aAl lowThird PartyFixìup0q(p " p(Oq± p!qQT ðK T T BTô ñQÃ9)q¿Pó‘¿Pb 0>Ô`ïÿÿòPp±1ñóÜ›#R q ÷±aqF°=Ñ“;>Â?@ 2p1±ñans IFilePicÞk²1ñq fÀ±V­°It…À5À 5 W€wÂ  5 ¸ 9 V  : W  QV ¸  9; ; ¸, 	 h ? 5 P: 5¤ bb c šc P¶Ô9 \" ; †Ð`5 P Q u  Ç  t‚  È ÌNà¹ 4±'ï1Õ³qŽ//
// Copyright (c) Microsoft Corporation.  All rights reserved.
//
//
// Use of this source code is subject to the terms of the Microsoft end-user
// license agreement (EULA) under which you licensed this SOFTWARE PRODUCT.
// If you did not accept the terms of the EULA, you are not authorized to use
// this source code. For a copy of the EULA, please see the LICENSE.RTF on your
// install media.
//
//+-------------------------------------------------------------------------
//
//  Microsoft Windows
//
//  File:       cguid.h
//
//--------------------------------------------------------------------------

#ifndef __CGUID_H__
#define __CGUID_H__

#ifdef __cplusplus
extern "C" {
#endif

extern const IID GUID_NULL;
extern const IID IID_IRpcChannel;
extern const IID IID_IRpcStub;
extern const IID IID_IStubManager;
extern const IID IID_IRpcProxy;
extern const IID IID_IProxyManager;
extern const IID IID_IPSFactory;
extern const IID IID_IInternalMoniker;
extern const IID IID_IDfReserved1;
extern const 