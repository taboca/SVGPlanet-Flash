
<!--
  te
   tbl|eqn | mmdoc
   stdmacro
 
-->
<!-- manual page source format generated by PolyglotMan v3.0.8+X.Org, -->
<!-- available at http://polyglotman.sourceforge.net/ -->

<html>
<head>
<title>GLCOPYTEXIMAGE1D(3G) manual page</title>
</head>
<body bgcolor='#efefef' text='black' link='blue' vlink='#551A8B' alink='red'>
<a href='#toc'>Table of Contents</a><p>

<h2><a name='sect0' href='#toc0'>Name</a></h2>
<b>glCopyTexImage1D</b> - copy pixels into a 1D texture image 
<p> 
<h2><a name='sect1' href='#toc1'>C Specification</a></h2>
void
<b>glCopyTexImage1D</b>( GLenum <i>target</i>, <br>
<pre><tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLint <i>level</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLenum <i>internalformat</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLint <i>x</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLint <i>y</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLsizei <i>width</i>,
<tt>&#32;</tt>&nbsp;<tt>&#32;</tt>&nbsp;GLint <i>border</i> )
</pre>
<p> <font size='-1'><b>eqn not supported</b></font>

<h2><a name='sect2' href='#toc2'>Parameters</a></h2>

<dl>

<dt><i>target</i> </dt>
<dd>Specifies the target texture. Must be
<b>GL_TEXTURE_1D</b>. </dd>

<dt><i>level</i> </dt>
<dd>Specifies the level-of-detail number. Level 0 is the base
image level. Level <i>n</i> is the <i>n</i>th mipmap reduction image. </dd>

<dt><i>internalformat</i> </dt>
<dd>Specifies
the internal  of the texture. Must be one of the following symbolic constants:
<b>GL_ALPHA</b>, <b>GL_ALPHA4</b>, <b>GL_ALPHA8</b>, <b>GL_ALPHA12</b>, <b>GL_ALPHA16</b>, <b>GL_LUMINANCE</b>, <b>GL_LUMINANCE4</b>,
<b>GL_LUMINANCE8</b>, <b>GL_LUMINANCE12</b>, <b>GL_LUMINANCE16</b>, <b>GL_LUMINANCE_ALPHA</b>, <b>GL_LUMINANCE4_ALPHA4</b>,
<b>GL_LUMINANCE6_ALPHA2</b>, <b>GL_LUMINANCE8_ALPHA8</b>, <b>GL_LUMINANCE12_ALPHA4</b>, <b>GL_LUMINANCE12_ALPHA12</b>,
<b>GL_LUMINANCE16_ALPHA16</b>, <b>GL_INTENSITY</b>, <b>GL_INTENSITY4</b>, <b>GL_INTENSITY8</b>, <b>GL_INTENSITY12</b>,
<b>GL_INTENSITY16</b>, <b>GL_RGB</b>, <b>GL_R3_G3_B2</b>, <b>GL_RGB4</b>,  <b>GL_RGB5</b>, <b>GL_RGB8</b>, <b>GL_RGB10</b>,
<b>GL_RGB12</b>, <b>GL_RGB16</b>, <b>GL_RGBA</b>, <b>GL_RGBA2</b>, <b>GL_RGBA4</b>, <b>GL_RGB5_A1</b>, <b>GL_RGBA8</b>,
<b>GL_RGB10_A2</b>, <b>GL_RGBA12</b>, or <b>GL_RGBA16</b>. </dd>

<dt><i>x</i>, <i>y</i> </dt>
<dd>Specify the window coordinates
of the left corner of the row of pixels to be copied. </dd>

<dt><i>width</i> </dt>
<dd>Specifies the
width of the texture image. Must be 0 or $2 sup n ~+~ 2*$<i>border</i> for some
integer $n$. The height of the texture image is 1. </dd>

<dt><i>border</i> </dt>
<dd>Specifies the width
of the border. Must be either 0 or 1. </dd>
</dl>

<h2><a name='sect3' href='#toc3'>Description</a></h2>
<b>glCopyTexImage1D</b> defines
a one-dimensional texture image with pixels from the current <b>GL_READ_BUFFER</b>.
<p>
The screen-aligned pixel row with left corner at $("x", "y")$ and with a
length of $"width"~+~2~*~"border"$  defines the texture array at the mipmap
level specified by <i>level</i>. <i>internalformat</i> specifies the internal  of the
texture array. <p>
The pixels in the row are processed exactly as if <b>glCopyPixels</b>
had been called, but the process stops just before final conversion. At
this point all pixel component values are clamped to the range [0,&nbsp;1] and
then converted to the texture's internal  for storage in the texel array.
<p>
Pixel ordering is such that lower $x$ screen coordinates correspond to
 lower texture coordinates. <p>
If any of the pixels within the specified row
of the current <b>GL_READ_BUFFER</b> are outside the window associated with the
current rendering context, then the values obtained for those pixels are
undefined. 
<h2><a name='sect4' href='#toc4'>Notes</a></h2>
<b>glCopyTexImage1D</b> is available only if the GL version is
1.1 or greater. <p>
Texturing has no effect in color index mode. <p>
1, 2, 3, and
4 are not accepted values for <i>internalformat</i>. <p>
An image with 0 width indicates
a NULL texture.  <p>
When the <b>GL_ARB_imaging</b> extension is supported, the RGBA
components copied from the framebuffer may be processed by the imaging
pipeline.  See <b>glTexImage1D</b> for specific details. 
<h2><a name='sect5' href='#toc5'>Errors</a></h2>
<b>GL_INVALID_ENUM</b> is
generated if <i>target</i> is not one of the allowable values. <p>
<b>GL_INVALID_VALUE</b>
is generated if <i>level</i> is less than 0. <p>
<b>GL_INVALID_VALUE</b> may be generated
if <i>level</i> is greater than $log sub 2 max$, where $max$ is the returned value
of <b>GL_MAX_TEXTURE_SIZE</b>. <p>
<b>GL_INVALID_VALUE</b> is generated if <i>internalformat</i>
is not an allowable value.   <p>
<b>GL_INVALID_VALUE</b> is generated if <i>width</i> is less
than 0 or greater than  2 + <b>GL_MAX_TEXTURE_SIZE</b>, or if it cannot be represented
as $2 sup n ~+~ 2~*~("border")$  for some integer value of <i>n</i>. <p>
<b>GL_INVALID_VALUE</b>
is generated if <i>border</i> is not 0 or 1. <p>
<b>GL_INVALID_OPERATION</b> is generated
if <b>glCopyTexImage1D</b> is executed between the execution of <b>glBegin</b> and the
corresponding execution of <b>glEnd</b>. 
<h2><a name='sect6' href='#toc6'>Associated Gets</a></h2>
<b>glGetTexImage</b> <br>
<b>glIsEnabled</b> with argument <b>GL_TEXTURE_1D</b> 
<h2><a name='sect7' href='#toc7'>See Also</a></h2>
<a href='glCopyPixels.3.html'><b>glCopyPixels(3G)</b></a>
, <a href='glCopyTexImage2D.3.html'><b>glCopyTexImage2D(3G)</b></a>
,
<a href='glCopyTexSubImage1D.3.html'><b>glCopyTexSubImage1D(3G)</b></a>
, <a href='glCopyTexSubImage2D.3.html'><b>glCopyTexSubImage2D(3G)</b></a>
, <a href='glPixelStore.3.html'><b>glPixelStore(3G)</b></a>
, <a href='glPixelTransfer.3.html'><b>glPixelTransfer(3G)</b></a>
,
<a href='glTexEnv.3.html'><b>glTexEnv(3G)</b></a>
, <a href='glTexGen.3.html'><b>glTexGen(3G)</b></a>
, <a href='glTexImage1D.3.html'><b>glTexImage1D(3G)</b></a>
, <a href='glTexImage2D.3.html'><b>glTexImage2D(3G)</b></a>
, <a href='glTexSubImage1D.3.html'><b>glTexSubImage1D(3G)</b></a>
,
<a href='glTexSubImage2D.3.html'><b>glTexSubImage2D(3G)</b></a>
, <br>
<a href='glTexParameter.3.html'><b>glTexParameter(3G)</b></a>
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                �C�L�C ��t#�8 u�l�C ;A,tP�D����5H�C �9���YY�E��L�C �H�C ���C �� ��C ��C    3�_^[��2�8tSV�<0|<9,0�A8u�^[�<;u���p����8u���V�t$����   �F���C ;At;؉C tP譻��Y�F���C ;At;܉C tP萻��Y�F���C ;At;��C tP�s���Y�F���C ;At;�C tP�V���Y�F���C ;At;�C tP�9���Y�F ���C ;A t;�C tP����Y�v$���C ;p$t;5��C tV� ���Y^�U��QSV3�95(�C Wu)95,�C u!�5H�C �5L�C ���C ̉C �5H�C ��  j0j�;�����;�YY�i  j踼����;�Y�}�uS藺��Y�L  �795(�C �x  j荼��;�Y�H�C uS�l���W�f���Y�̉0�5��C �CPjVj�K  ���CPjVj�K  ��CPjVj�|K  ��CPjVj�lK  ��@��CPjVj�YK  ��C PjPVj�IK  ��C$PjQVj�9K  ��C(PjVj �)K  ��@��C)PjVj �K  ��C*PjTVj �K  ��C+PjUVj ��J  ��C,PjVVj ��J  ��@��C-PjWVj ��J  ��C.PjRVj ��J  ��C/PjSVj �J  ��0�tS����S�P����u��H�����3�@�}�C����0|��9��0�@�8 u��*��;u���~�����> u���jY�̉C ���%H�