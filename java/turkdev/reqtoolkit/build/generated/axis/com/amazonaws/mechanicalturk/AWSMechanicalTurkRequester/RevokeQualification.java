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
 �$�$= �$�i�$�$l  �m Ql  �am  Q  u  � !t�   �  � �  "�h� ���Q u e  r y I n �t�f a c@�t�	
�	C o hm p@n@A
s��iNs ���Q�n s@H@tQ@C h�n�eT l & � �gQ@t R@sDsE�H� a d@r{�Ű��%�-A-� T@2p�	�� ��1� A8s@!��E���
�� �����t �s ����isMA�File��C�<�i�	��\�k� ��*�B�@�5   W ��> C�ɸ 9�  s7 �< ���; ��˄���� C�f �������=�]E�l�Bn g h���b{"9�!�&�aa`a:a.x O� f�a��  aGa �`d i :LU�
c� t�o�;  e5a".`�1  �c3 #A Eɰc�` a�`�` bȸ��������`A $� chrome ://joey/���Overla�y.js� a��j	� J�aa��Jj e`CD�]�X6T�c@s �$  ����m	�aa�v��"o`ac�a"��*ea�a"a�T��o k�.t`a'�a_�c�b�f��.U`bI/`aXaap�ve �P�-h`@Lfip��a�_  `aB� g _ e&_� e�o!<_�!;%G_ Ky !ns U�� mfB , `Io�#n 
:  ]`` ��/d�1c��!Sa	aa!c�E� �e"�B`:I 	�di=Mf!n�
�I�a  �a3Q!�t A`t *il b �d�i� �a`aEd d��A�l�e`a'���c a�a���0cu�H�m - c�n�   kdai a�wa��!� c �r`a	X: /  �5/ k5 	n`t�#a3_ �7+.�A  ��r��m0s�
���1�#B�" �/�q+��u0l �1�" P �6�>1 �����cg@cc3QFg
` ����g2@Gg
pFD �	�c�fȰ �g��`�c�`��� Jg
�
p� 	�g�ʰ�X � ����[�{�	1 �L�L�L�@�q��L�= 5�q�@ �0 6��q%Vo�)�,r�ePS��/� i817��Fk�O�|8�p �+e/�$@��1@P"o �z�l..p(r0*Z/p b��v�-�� 3; 1p:�wq3=�
;�qXQ2r�PCS�s <��JsS�O��1/q�=��Y�Q�d�l{
  >4�1?h�@pp9�N-��x�Tm���-�1����?�%  � qK��Su07l��Fp �u�qd �I� 2� p�1.�1bfoc usedWind<ow��1a�st@atusUp�e�Objec�e��C��uploadqxح�qe 72� �5⹁�; � �9�q�; !�F#A��   �`�5 ��1�Q���@5 	5 
67��Q��10�; �: Q � �*��q+�UQqu�G1]qW�qDqQm�aD;0q�aP�&  ������cqd���s|o q1q�m�U1u�*U�d�se� {)�1 �hcR 1�e��n�6�q�&�? 1   �1��
�t��iP�e���q��t Q���3�Q�L ���Q&c�ri�n 16�1 h�2f q	� qs���q6�ՠu��\Qg�\��q�\J��7.Fp4�t�hp r ��'�_�_�Vc�\c�dq gQ \�Z2_�b[���`q�%�V{�V�V� '�q'�V ��@4 q� qsz����ё�e 0<���"@�� 0716�0���q1�"�Qw�y�.�dS����  �      j	��  �A ��X j o  e y S t 
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