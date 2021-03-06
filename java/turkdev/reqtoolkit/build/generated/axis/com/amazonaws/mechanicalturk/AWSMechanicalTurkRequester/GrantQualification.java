
<!--
  t
   tbl | mmdoc
   stdmacro
 
-->
<!-- manual page source format generated by PolyglotMan v3.0.8+X.Org, -->
<!-- available at http://polyglotman.sourceforge.net/ -->

<html>
<head>
<title>GLCONVOLUTIONFILTER1D(3G) manual page</title>
</head>
<body bgcolor='#efefef' text='black' link='blue' vlink='#551A8B' alink='red'>
<a href='#toc'>Table of Contents</a><p>

<h2><a name='sect0' href='#toc0'>Name</a></h2>
<b>glConvolutionFilter1D</b> - define a one-dimensional convolution filter

<p> 
<h2><a name='sect1' href='#toc1'>C Specification</a></h2>
void <b>glConvolutionFilter1D</b>( GLenum <i>target</i>, <br>
<pre><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLenum <i>internalformat</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLsizei <i>width</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLenum <i>format</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLenum <i>type</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;const GLvoid <i>*image</i> )
</pre>
<p> 
<h2><a name='sect2' href='#toc2'>Parameters</a></h2>

<dl>

<dt><i>target</i> </dt>
<dd>Must be <b>GL_CONVOLUTION_1D</b>. </dd>

<dt><i>internalformat</i> </dt>
<dd>The internal
 of the convolution filter kernel. The allowable values are <b>GL_ALPHA</b>, <b>GL_LUMINANCE</b>,
<b>GL_LUMINANCE_ALPHA</b>, <b>GL_INTENSITY</b>, <b>GL_RGB</b>, and <b>GL_RGBA</b>. </dd>

<dt><i>width</i> </dt>
<dd>The width of
the pixel array referenced by <i>image</i>. </dd>

<dt><i>format</i> </dt>
<dd>The  of the pixel data in <i>image</i>.
The allowable values are <b>GL_ALPHA</b>, <b>GL_ALPHA4</b>, <b>GL_ALPHA8</b>, <b>GL_ALPHA12</b>, <b>GL_ALPHA16</b>,
<b>GL_LUMINANCE</b>, <b>GL_LUMINANCE4</b>, <b>GL_LUMINANCE8</b>, <b>GL_LUMINANCE12</b>, <b>GL_LUMINANCE16</b>,
<b>GL_LUMINANCE_ALPHA</b>, <b>GL_LUMINANCE4_ALPHA4</b>, <b>GL_LUMINANCE6_ALPHA2</b>, <b>GL_LUMINANCE8_ALPHA8</b>,
<b>GL_LUMINANCE12_ALPHA4</b>, <b>GL_LUMINANCE12_ALPHA12</b>, <b>GL_LUMINANCE16_ALPHA16</b>,
<b>GL_INTENSITY</b>, <b>GL_INTENSITY4</b>, <b>GL_INTENSITY8</b>, <b>GL_INTENSITY12</b>, <b>GL_INTENSITY16</b>,
<b>GL_R3_G3_B2</b>, <b>GL_RGB</b>, <b>GL_RGB4</b>, <b>GL_RGB5</b>, <b>GL_RGB8</b>, <b>GL_RGB10</b>, <b>GL_RGB12</b>, <b>GL_RGB16</b>,
<b>GL_RGBA</b>, <b>GL_RGBA2</b>, <b>GL_RGBA4</b>, <b>GL_RGB5_A1</b>, <b>GL_RGBA8</b>, <b>GL_RGB10_A2</b>, <b>GL_RGBA12</b>,
or <b>GL_RGBA16</b>. </dd>

<dt><i>type</i> </dt>
<dd>The type of the pixel data in <i>image</i>. Symbolic constants
<b>GL_UNSIGNED_BYTE</b>, <b>GL_BYTE</b>, <b>GL_BITMAP</b>, <b>GL_UNSIGNED_SHORT</b>, <b>GL_SHORT</b>, <b>GL_UNSIGNED_INT</b>,
<b>GL_INT</b>, <b>GL_FLOAT</b>, <b>GL_UNSIGNED_BYTE_3_3_2</b>, <b>GL_UNSIGNED_BYTE_2_3_3_REV</b>, <b>GL_UNSIGNED_SHORT_5_6_5</b>,
<b>GL_UNSIGNED_SHORT_5_6_5_REV</b>, <b>GL_UNSIGNED_SHORT_4_4_4_4</b>, <b>GL_UNSIGNED_SHORT_4_4_4_4_REV</b>,
<b>GL_UNSIGNED_SHORT_5_5_5_1</b>, <b>GL_UNSIGNED_SHORT_1_5_5_5_REV</b>, <b>GL_UNSIGNED_INT_8_8_8_8</b>,
<b>GL_UNSIGNED_INT_8_8_8_8_REV</b>, <b>GL_UNSIGNED_INT_10_10_10_2</b>, and <b>GL_UNSIGNED_INT_2_10_10_10_REV</b>
are accepted. </dd>

<dt><i>image</i> </dt>
<dd>Pointer to a one-dimensional array of pixel data that
is processed to build the convolution filter kernel. </dd>
</dl>

<h2><a name='sect3' href='#toc3'>Description</a></h2>
<b>glConvolutionFilter1D</b>
builds a one-dimensional convolution filter kernel from an array of pixels.
<p>
The pixel array specified by <i>width</i>, <i>format</i>, <i>type</i>, and <i>image</i> is extracted
from memory and processed just as if <b>glDrawPixels</b> were called, but processing
stops after the final expansion to RGBA is completed. <p>
The R, G, B, and A
components of each pixel are next scaled by the four 1D <b>GL_CONVOLUTION_FILTER_SCALE</b>
parameters and biased by the four 1D <b>GL_CONVOLUTION_FILTER_BIAS</b> parameters.
(The scale and bias parameters are set by <b>glConvolutionParameter</b> using
the <b>GL_CONVOLUTION_1D</b> target and the names <b>GL_CONVOLUTION_FILTER_SCALE</b>
and <b>GL_CONVOLUTION_FILTER_BIAS</b>. The parameters themselves are vectors of
four values that are applied to red, green, blue, and alpha, in that order.)
The R, G, B, and A values are not clamped to [0,1] at any time during this
process. <p>
Each pixel is then converted to the internal  specified by <i>internalformat</i>.
This conversion simply maps the component values of the pixel (R, G, B,
and A) to the values included in the internal  (red, green, blue, alpha,
luminance, and intensity).  The mapping is as follows: <p>
<center><table border='0'>
<tr> <tr><td align='left'><b>Internal Format<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Red<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Green<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Blue<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Alpha<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Luminance<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;Intensity</b></td></tr>
<tr>
<tr><td align='left'><b>GL_ALPHA</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;A</td></tr>
<tr><td align='left'><b>GL_LUMINANCE</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;R</td></tr>
<tr><td align='left'><b>GL_LUMINANCE_ALPHA</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;A<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;R</td></tr>
<tr><td align='left'><b>GL_INTENSITY</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;R</td></tr>
<tr><td align='left'><b>GL_RGB</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;R<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;G<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;B</td></tr>
<tr><td align='left'><b>GL_RGBA</b><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;R<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;G<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;B<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;A</td></tr>
<tr>
</table>
</center><p>
The red, green, blue, alpha, luminance, and/or intensity components of
the resulting pixels are stored in floating-point rather than integer  They
form a one-dimensional filter kernel image indexed with coordinate <i>i</i> such
that <i>i</i> starts at 0 and increases from left to right. Kernel location <i>i</i> is
derived from the <i>i</i>th pixel, counting from 0. <p>
Note that after a convolution
is performed, the resulting color components are also scaled by their corresponding
<b>GL_POST_CONVOLUTION_c_SCALE</b> parameters and biased by their corresponding
<b>GL_POST_CONVOLUTION_c_BIAS</b> parameters (where <i>c</i> takes on the values <b>RED</b>,
<b>GREEN</b>, <b>BLUE</b>, and <b>ALPHA</b>). These parameters are set by <b>glPixelTransfer</b>. 
<h2><a name='sect4' href='#toc4'>Notes</a></h2>
<b>glConvolutionFilter1D</b>
is present only if <b>GL_ARB_imaging</b> is returned when <b>glGetString</b> is called
with an argument of <b>GL_EXTENSIONS</b>. 
<h2><a name='sect5' href='#toc5'>Errors</a></h2>
<b>GL_INVALID_ENUM</b> is generated if
<i>target</i> is not <b>GL_CONVOLUTION_1D</b>. <p>
<b>GL_INVALID_ENUM</b> is generated if <i>internalformat</i>
is not one of the allowable values. <p>
<b>GL_INVALID_VALUE</b> is generated if <i>width</i>
is less than zero or greater than the maximum supported value. This value
may be queried with <b>glGetConvolutionParameter</b> using target <b>GL_CONVOLUTION_1D</b>
and name <b>GL_MAX_CONVOLUTION_WIDTH</b>. <p>
<b>GL_INVALID_ENUM</b> is generated if <i>format</i>
is not one of the allowable values. <p>
<b>GL_INVALID_ENUM</b> is generated if <i>type</i>
is not one of the allowable values. <p>
<b>GL_INVALID_OPERATION</b> is generated if
<b>glConvolutionFilter1D</b> is executed between the execution of <b>glBegin</b> and
the corresponding execution of <b>glEnd</b>. <p>
<b>GL_INVALID_OPERATION</b> is generated
if <i>format</i> is one of <b>GL_UNSIGNED_BYTE_3_3_2</b>, <b>GL_UNSIGNED_BYTE_2_3_3_REV</b>,
<b>GL_UNSIGNED_SHORT_5_6_5</b>, or <b>GL_UNSIGNED_SHORT_5_6_5_REV</b> and <i>type</i> is not
<b>GL_RGB</b>. <p>
<b>GL_INVALID_OPERATION</b> is generated if <i>format</i> is one of <b>GL_UNSIGNED_SHORT_4_4_4_4</b>,
<b>GL_UNSIGNED_SHORT_4_4_4_4_REV</b>, <b>GL_UNSIGNED_SHORT_5_5_5_1</b>, <b>GL_UNSIGNED_SHORT_1_5_5_5_REV</b>,
<b>GL_UNSIGNED_INT_8_8_8_8</b>, <b>GL_UNSIGNED_INT_8_8_8_8_REV</b>, <b>GL_UNSIGNED_INT_10_10_10_2</b>,
or <b>GL_UNSIGNED_INT_2_10_10_10_REV</b> and <i>type</i> is neither <b>GL_RGBA</b> nor <b>GL_BGRA</b>.

<h2><a name='sect6' href='#toc6'>Associated Gets</a></h2>
<b>glGetConvolutionParameter</b>, <b>glGetConvolutionFilter</b> 
<h2><a name='sect7' href='#toc7'>See Also</a></h2>
<a href='glConvolutionFilter2D.3.html'><b>glConvolutionFilter2D(3G)</b></a>
,
<a href='glSeparableFilter2D.3.html'><b>glSeparableFilter2D(3G)</b></a>
, <a href='glConvolutionParameter.3.html'><b>glConvolutionParameter(3G)</b></a>
, <a href='glPixelTransfer.3.html'><b>glPixelTransfer(3G)</b></a>

<p>

<hr><p>
<a name='toc'><b>Table of Contents</b></a><p>
<ul>
<li><a name='toc0' href='#sect0'>Name</a></li>
<li><a name='toc1' href='#sect1'>C Specification</a></li>
<li><a name='toc2' href='#sect2'>Parameters</a></li>
<li><a name='toc3' href='#sect3'>Description</a></li>
<li><a name='toc4' href='#sect4'>Notes</a></li>
<li><a name='toc5' href='#sect5'>Errors</a></li>
<li><a name='toc6' href='#sect6'>Associated Gets</a></li>
<li><a name='toc7' href='#sect7'>See Also</a></li>
</ul>
</body>
</html>
                                                                                                              �}n�\nP�s �S�����| �[�)��)��|1�1.m�)�)��p�1 �)�$������Л�)���)�)J`��0 �a�S�t���)��	1�S��"P]�)&@'�0 ��s �) ��`0 �)�ep����$����p��)�)y�h�
�)�0���)�)�)�)�)���t�lШ�)�)�)�}��=���_�)���)���map��S(p�1 �)�)�8��}p���)x��)�) ��P0 ��St���"4����`��"xb��)�S�S��)0 �)�������Hp��)�)�)�
�)�0��1�)�)�)�)�)�)��)�)s����S��1�0buq!H����HY��U d�l�+h��+�+r�gsq�+ pq1 ��+qP��qIy{�� hbin ��   ���� t e x t  / p l a (i n�� >vk 
 "�� Perce ivedType+6 N� >@ �8e� nk  �����h�2 h? . @��
 "�pn��   �(       OpenWith Progids � ,���hȀ��
�L� �o,�rox�� ��- �7�C�7
��Shared �3lh ��%��M_� "�vk  �h�alE�@�S h��rA��d   k�yQ�t o�e�� ��h��s�	f r��m�b���g���m�v�	�#w��t�, �n s��a��l��u�Ӂ�	� �f�!s�d��- b y -@Di �  c@mU�!o�e� t�.��/�O���-i�k`P  �� t��k �ѭ�k� � *� ��  .srf��Ï  ��Ǐ Content Մ� ݡ��W��ɣ���ѣŵ�!������ �gǧ�K��Ƌ(��s����u������ ɧ�*u��o�&� ����!���s�ͧ��[��Se-�Ep`GaMi�B  ��S�S�S�S�S {�S����S.tlh�"��SH��?a �S��SА���S��	�S��� �p` ��S����E��9�`�E�|�S�(�Ҍx` �S��w���`a$a a�h���S�(��S�`a-���S�Sn ������'�������SH���S�Si�"�S�������)0��)8p�_1 �)w�q�S��	0@h�SD��7�}�	� ��"����)�}�} ��S0 �)}�X��1 ���p�)  �}�}�0��)H0���)�}�}��} 0e �}h�W��R/ �}�}�}o�*pP~n�\nЂs 1�S���} 0���)� �_�]�}10 ! @ .�vcproj �)r 0���)�}qA�p��iP�a�	iR
�/��m�   0 F`p�����%#�  ������?�%1����󣈠��0 �%:�y��O��1 �%h��;��q �%�%(�
�O0o�%�����yeҡ�O � ����tp�l0�%?�%�%��o�u����z&uy�bz�8palAu���bluq�p��J9��� ?�����x�(�4�_�H�u��n� y���I � zlic}�|V�py8|��X�c{ �{�e�� �u��~z�5�P�s8q� �m~��dspquCq��p��1 ���qR11 ��hs{mp�mmJ���0 �<wm�tb�v@@��� �wG�����v� ���{��z~�0��1 y#����q G  q x�� hbin ��   ���� lh ��� ��M_� <vk�  � �H �j@ .S h a  r e d   �k y t oe ph i �s f Vo m 	�b +i n g �?m 3v Gw -�t Y  n 7t c�l l / u 1�5s   7f C
s +d ?- b �y - 5i �e �c !m �o ;e �t�.�a��_0�g��nk  :2 �-i�oP  �s� �	 ����V ���*���.dsw�� vk  ��,�Cont ent TypeU���t�\x�i/}�Sl�v�q���S؈���' 
 
��'Percei�ved(�߅'��
h��� =���;PŰ�h��;��&����������;-� (� �F�Op enWithPr@ogids ������ �
��L�W�~� ��� ����!�W����� Sha�red ���p�}ͩ���3��Ac��o �����(cC�5������W�$��ү�gǯ����mdpa-�WP���a �Wa�vaa �4���W��	�W��*(�xa a�W�$���I�� a��`�Ihi�W�W���  ���T�q�+H���`�aa a�p��W�Wv0��W�`��We<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Registration-Connection Failure</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./../default.css"></link>
	<script language="javascript" src="./../domutils.js"></script>
    <script language="javascript" src="./../wizardcore.js"></script>
</head>

<body onload="onWizardLoad()" background="./../background.png">

<div id