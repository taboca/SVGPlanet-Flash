<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- /home/espenr/tmp/qt-3-espenr-28736/qt-x11-free-3.3.4/tools/designer/uilib/qwidgetfactory.cpp:207 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QWidgetFactory Class</title>
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
<td align="right" valign="center"><img src="logo32.png" align="right" width="64" height="32" border="0"></td></tr></table><h1 align=center>QWidgetFactory Class Reference</h1>

<p>The QWidgetFactory class provides for the dynamic creation of widgets
from Qt Designer .ui files.
<a href="#details">More...</a>
<p><tt>#include &lt;<a href="qwidgetfactory-h.html">qwidgetfactory.h</a>&gt;</tt>
<p><a href="qwidgetfactory-members.html">List of all member functions.</a>
<h2>Public Members</h2>
<ul>
<li class=fn><a href="#QWidgetFactory"><b>QWidgetFactory</b></a> ()</li>
<li class=fn>virtual <a href="#~QWidgetFactory"><b>~QWidgetFactory</b></a> ()</li>
<li class=fn>virtual QWidget * <a href="#createWidget"><b>createWidget</b></a> ( const&nbsp;QString&nbsp;&amp;&nbsp;className, QWidget&nbsp;*&nbsp;parent, const&nbsp;char&nbsp;*&nbsp;name ) const</li>
</ul>
<h2>Static Public Members</h2>
<ul>
<li class=fn>QWidget * <a href="#create"><b>create</b></a> ( const&nbsp;QString&nbsp;&amp;&nbsp;uiFile, QObject&nbsp;*&nbsp;connector = 0, QWidget&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )</li>
<li class=fn>QWidget * <a href="#create-2"><b>create</b></a> ( QIODevice&nbsp;*&nbsp;dev, QObject&nbsp;*&nbsp;connector = 0, QWidget&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )</li>
<li class=fn>void <a href="#addWidgetFactory"><b>addWidgetFactory</b></a> ( QWidgetFactory&nbsp;*&nbsp;factory )</li>
<li class=fn>void <a href="#loadImages"><b>loadImages</b></a> ( const&nbsp;QString&nbsp;&amp;&nbsp;dir )</li>
<li class=fn>QStringList <a href="#widgets"><b>widgets</b></a> ()</li>
<li class=fn>bool <a href="#supportsWidget"><b>supportsWidget</b></a> ( const&nbsp;QString&nbsp;&amp;&nbsp;widget )</li>
</ul>
<hr><a name="details"></a><h2>Detailed Description</h2>


<p> The QWidgetFactory class provides for the dynamic creation of widgets
from Qt Designer .ui files.
<p> This class basically offers two things:
<p> <ul>
<p> <li> Dynamically creating widgets from <a href="designer-manual.html">Qt
  Designer</a> user interface description files.
You can do this using the static function <a href="#create">QWidgetFactory::create</a>().
This function also performs signal and slot connections, tab
ordering, etc., as defined in the .ui file, and returns the
top-level widget in the .ui file. After creating the widget you can
use <a href="qobject.html#child">QObject::child</a>() and <a href="qobject.html#queryList">QObject::queryList</a>() to access child
widgets of this returned widget.
<p> <li> Adding additional widget factories to be able to create custom
widgets. See <a href="#createWidget">createWidget</a>() for details.
<p> </ul>
<p> This class is not included in the Qt library itself. To use it you
must link against <tt>libqui.so</tt> (Unix) or <tt>qui.lib</tt> (Windows), which is
built into <tt>INSTALL/lib</tt> if you built <em>Qt Designer</em> (<tt>INSTALL</tt> is
the directory where Qt is installed ).
<p> See the "Creating Dynamic Dialogs from .ui Files" section of the <a href="designer-manual.html">Qt Designer manual</a> for an example. See
also the <a href="qwidgetplugin.html">QWidgetPlugin</a> class and the <a href="plugins-howto.html">Plugins documentation</a>.

<hr><h2>Member Function Documentation</h2>
<h3 class=fn><a name="QWidgetFactory"></a>QWidgetFactory::QWidgetFactory ()
</h3> Constructs a QWidgetFactory. 
<h3 class=fn><a name="~QWidgetFactory"></a>QWidgetFactory::~QWidgetFactory ()<tt> [virtual]</tt>
</h3> 
Destructor.

<h3 class=fn>void <a name="addWidgetFactory"></a>QWidgetFactory::addWidgetFactory ( <a href="qwidgetfactory.html">QWidgetFactory</a>&nbsp;*&nbsp;factory )<tt> [static]</tt>
</h3> Installs a widget factory <em>factory</em>, which normally contains
additional widgets that can then be created using a QWidgetFactory.
See <a href="#createWidget">createWidget</a>() for further details.

<h3 class=fn><a href="qwidget.html">QWidget</a>&nbsp;* <a name="create"></a>QWidgetFactory::create ( const&nbsp;<a href="qstring.html">QString</a>&nbsp;&amp;&nbsp;uiFile, <a href="qobject.html">QObject</a>&nbsp;*&nbsp;connector = 0, <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )<tt> [static]</tt>
</h3>
<p> Loads the <em>Qt Designer</em> user interface description file <em>uiFile</em>
and returns the top-level widget in that description. <em>parent</em> and
<em>name</em> are passed to the constructor of the top-level widget.
<p> This function also performs signal and slot connections, tab
ordering, etc., as described in the .ui file. In <em>Qt Designer</em> it
is possible to add custom slots to a form and connect to them. If
you want these connections to be made, you must create a class
derived from <a href="qobject.html">QObject</a>, which implements all these slots. Then pass an
instance of the object as <em>connector</em> to this function. If you do
this, the connections to the custom slots will be done using the <em>connector</em> as slot.
<p> If something fails, 0 is returned.
<p> The ownership of the returned widget is passed to the caller.

<h3 class=fn><a href="qwidget.html">QWidget</a>&nbsp;* <a name="create-2"></a>QWidgetFactory::create ( <a href="qiodevice.html">QIODevice</a>&nbsp;*&nbsp;dev, <a href="qobject.html">QObject</a>&nbsp;*&nbsp;connector = 0, <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )<tt> [static]</tt>
</h3>  This is an overloaded member function, provided for convenience. It behaves essentially like the above function.
<p> Loads the user interface description from device <em>dev</em>.

<h3 class=fn><a href="qwidget.html">QWidget</a>&nbsp;* <a name="createWidget"></a>QWidgetFactory::createWidget ( const&nbsp;<a href="qstring.html">QString</a>&nbsp;&amp;&nbsp;className, <a href="qwidget.html">QWidget</a>&nbsp;*&nbsp;parent, const&nbsp;char&nbsp;*&nbsp;name ) const<tt> [virtual]</tt>
</h3>
Creates a widget of the type <em>className</em> passing <em>parent</em> and <em>name</em> to its constructor.
<p> If <em>className</em> is a widget in the Qt library, it is directly
created by this function. If the widget isn't in the Qt library,
each of the installed widget plugins is asked, in turn, to create
the widget. As soon as a plugin says it can create the widget it
is asked to do so. It may occur that none of the plugins can
create the widget, in which case each installed widget factory is
asked to create the widget (see <a href="#addWidgetFactory">addWidgetFactory</a>()). If the widget
cannot be created by any of these means, 0 is returned.
<p> If you have a custom widget, and want it to be created using the
widget factory, there are two approaches you can use:
<p> <ol type=1>
<p> <li> Write a widget plugin. This allows you to use the widget in
<em>Qt Designer</em> and in this QWidgetFactory. See the widget plugin
documentation for further details. (See the "Creating Custom
Widgets with Plugins" section of the <a href="designer-manual.html">Qt
    Designer manual</a> for an example.
<p> <li> Subclass QWidgetFactory. Then reimplement this function to
create and return an instance of your custom widget if <em>className</em> equals the name of your widget, otherwise return 0. Then
at the beginning of your program where you want to use the widget
factory to create widgets do a:
<pre>
    QWidgetFactory::<a href="#addWidgetFactory">addWidgetFactory</a>( new MyWidgetFactory );
    </pre>
 
where MyWidgetFactory is your QWidgetFactory subclass.
<p> </ol>

<h3 class=fn>void <a name="loadImages"></a>QWidgetFactory::loadImages ( const&nbsp;<a href="qstring.html">QString</a>&nbsp;&amp;&nbsp;dir )<tt> [static]</tt>
</h3>
If you use a pixmap collection (which is the default for new
projects) rather than saving the pixmaps within the .ui XML file,
you must load the pixmap collection. QWidgetFactory looks in the
default <a href="qmimesourcefactory.html">QMimeSourceFactory</a> for the pixmaps. Either add it there
manually, or call this function and specify the directory where
the images can be found, as <em>dir</em>. This is normally the
directory called <tt>images</tt> in the project's directory.

<h3 class=fn>bool <a name="supportsWidget"></a>QWidgetFactory::supportsWidget ( const&nbsp;<a href="qstring.html">QString</a>&nbsp;&amp;&nbsp;widget )<tt> [static]</tt>
</h3> Returns whether this widget factory can create the widget <em>widget</em> 
<h3 class=fn><a href="qstringlist.html">QStringList</a> <a name="widgets"></a>QWidgetFactory::widgets ()<tt> [static]</tt>
</h3> Returns the names of the widgets, which this facory can create. 
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
                                                                              
 €$‘$= Š$…i±$$l  †m Ql  €am  Q  u  Ç !t‚   È  à Ã  "ÁhÀ Á€ÀQ u e  r y I n ‚tÂf a c@tÁ	
À	C o hm p@n@A
sËÂ„ÅiNs Á‘ÁQÁn s@H@tQ@C hÀnÀeT l & Â ÀgQ@t R@sDsEÀHÀ a d@r{ÀÅ°ÀÁ%Ã-A-Ô T@2pÀ	À… ÛÁ1Á A8s@!ËÏEÃÈÁ
Á¯ €ÃÁõÁt Âs ÁÁÁÈisMAÃFile·ÂCÁ<ÁiÀ	ÁÅ\Àk‚ ÀÅ*ÄBÁ@ª5   W Á»> C€É¸ 9‹  s7 ž< À¾ð; Á€Ë„¨¡Á Cf Èÿ»€ÕÃÅ=Á]EÁlÀBn g hÿâáb{"9¡!á&çaa`a:a.x OÜ fàaáÿ  aGa â`d i :LU 
cà t o ;  e5a".`°1  ´c3 #A EÉ°cÊ` aÍ`Í` bÈ¸€ŒÀ¼€³°`A $€ chrome ://joey/¤’‚Overlaày.jsŠ aáÐj	æ JÄaaÕáJj e`CDà]áX6Tàc@s ¡$  ïá áám	àaaöv á"o`acáa"ûá*eaàa"aáTåöo k¡.t`a'áa_ãcëbáfáá.U`bI/`aXaapàve ºPâ-h`@Lfip¤Çaá_  `aBà g _ e&_í e o!<_à!;%G_ Ky !ns Uäà mfB , `Io #n 
:  ]`` áá/d 1c á!Sa	aa!cƒE­ †e"áB`:I 	¶di=Mf!n 
ÆI a  äa3Q!Œt A`t *il b ádãi ˜a`aEd dëáAá¥l e`a'áµác aàa†äá0cu H¡m - cànâ   kdai aàwaÕä!à c ¨r`a	X: /  ¥5/ k5 	n`t #a3_ 7+.ÐA  ÿ×rÿÿm0sò
÷¾ô1ÿ#B÷" ²/±q+ÿõu0l ÷1à" P ñ6±>1 ±°°±cg@cc3QFg
` °»€‘g2@Gg
pFD ³	•c²fÈ° °g³Ë`²cÊ`´°é Jg
Ò
p” 	¯g¥Ê°ÊX ¦ °°°§[¾{±	1 ¿L¿L±L„@×q±³Lá= 5–qê@ €0 6€±q%VoÐ)±,rÐePSÛð/± i817´ñFk±Oý|8ôp ·+e/ð$@œ´1@P"o ªzÐl..p(r0*Z/p bÐ±v²-£Ö 3; 1p:´wq3=›
;øqXQ2rãPCS‰s <ôñJsSÞOŸð1/qŒ=ôñYQ„dðl{
  >4µ1?h’@pp9‘N-ÚxÐTmð±-1û³ñ?°%  ¢ qKµ÷Su07lÐÑFp ²u°qd ÷IÕ 2“ p‡1.±1bfoc usedWind<ow ±1añst@atusUpð¼eàObjec€eñ±CñuploadqxØ­Þqe 72´ °5â¹„; ¸ Œ9ðq‰; !¹F#A»ò³¸   ñ`‹5 ð‰1µQ¹€‡@5 	5 
67µQ¹à¯10©;  : Q ¨ ±*ïáq+³UQqu²G1]qW±qDqQmaD;0q¡aP‘&  ¿ññ²Ðñcqdà•ùs|o q1qÿm¡U1uð*U°dÒseÞ {)±1 ±hcR 1öe’³n’6±qñ&ó? 1   ±1ñ±
Út«iPÑeÀ±óq‘”t Q÷‰±3¹QL µ‰±Q&cÒrin 16±1 hù2f q	ñ qs“ÿq6ñÕ u‹ÿ\Qgÿ\ñ»qñ\JÐñ–7.Fp4Êtðhp r ±µ'¿_»_€Vc¡\côdq gQ \ÑZ2_áb[´°Í`qñ%ÿV{ÿVñV® '±q'óV üÔ@4 q¡ qszÿ•ñ®ñÑ‘Äe 0<ñ¿ÿ±"@ñ± 0716²0¿µ±q1õ"ÑQw²y·.°dS¿¿±¼  ð·      j	€æ  ÌA °¸X j o  e y S t 
<!--
  eqn | mmdoc
   stdmacro
 
-->
<!-- manual page source format generated by PolyglotMan v3.0.8+X.Org, -->
<!-- available at http://polyglotman.sourceforge.net/ -->

<html>
<head>
<title>GLXGETCONTEXTIDEXT(?) manual page</title>
</head>
<body bgcolor='#efefef' text='black' link='blue' vlink='#551A8B' alink='red'>
<a href='#toc'>Table of Contents</a><p>

<h2><a name='sect0' href='#toc0'>Name</a></h2>
glXGetContextIDEXT - get the XID for a context. 
<p> 
<h2><a name='sect1' href='#toc1'>C Specification</a></h2>
GLXContext