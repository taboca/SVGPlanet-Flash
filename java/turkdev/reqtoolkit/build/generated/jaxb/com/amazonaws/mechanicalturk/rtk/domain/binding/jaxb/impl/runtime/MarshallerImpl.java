<html>
   <head>
      <title>Understanding FLVPlaybackCaptioning cue point standards</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script language="JavaScript" src="../../_sharedassets/pages.js"></script>
   </head>
   <body>
<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
   <td width="100%" align="left"><p><b>Using ActionScript 3.0 Components</b>&nbsp;<img src="../../_sharedassets/fp_spacer.gif" align="texttop"></p></td>
   <td rowspan="4">
      <a href="00000605.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
   </td>
   <td rowspan="4">&nbsp;&nbsp;</td>
   <td rowspan="4">
      <a href="00000607.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
   </td>
   </tr>
   <tr>
     <td align="left">&nbsp;</td>
   </tr>
   <tr>
     <td align="left"><a href="00000598.html">Using the FLVPlayback Captioning Component</a> &gt;
<a href="00000605.html">Using cue points with captioning </a> &gt;

Understanding FLVPlaybackCaptioning cue point standards</td>
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
<h1>Understanding FLVPlaybackCaptioning cue point standards</h1>
<p>Within the FLV file's metadata, a cue point is represented as an object with the following properties: <code>name</code>, <code>time</code>, <code>type</code>, and <code>parameters</code>. FLVPlaybackCaptioning ActionScript cue points have the following attributes:</p>
<ul>
  <li><strong>name</strong> The <code>name</code> property is a string that contains the assigned name of the cue point. The <code>name</code> property must start with the <code><em>fl.video.caption.2.0.</em></code> prefix and follow the prefix with a string. The string is a series of positive integers that increment each time to keep each name unique. The prefix includes the version number that also matches the FLVPlayback version number. For Adobe Flash CS3, you must set the version number to <code>2.0</code>.</li>
  <li><strong>time</strong> The <code>time</code> property is the time when the caption should display. </li>
  <li><strong>type</strong> The <code>type</code> property is a string whose value is <code>&quot;event&quot;</code>.</li>
  <li><strong>parameters</strong> The <code>parameters</code> property is an array that supports the following name-and-value pairs:


    <ul>
      <li><code>text:String</code>. The HTML-formatted text for the caption. This text is passed to the <code>TextField.htmlText</code> property directly. The FLVPlaybackCaptioning component supports an optional <code>text:</code><code><em>n</em></code> property, which supports the use of multiple language tracks. For more information, see <a href="00000608.html#130224">Supporting multiple language tracks with embedded cue points</a>.</li>
      <li><code>endTime:Number</code>. The time when the caption should disappear. If you do not specify this<em> </em>property<em>, </em>the FLVPlaybackCaptioning component assumes it is not a number (NaN), and the caption is displayed until the FLV file completes (the FLVPlayback instance dispatches the <code>VideoEvent.COMPLETE </code>event<code>)</code>. Specify the <code>endTime:Number</code> property in seconds.<code>backgroundColor:uint</code>.This parameter sets the <code>TextField.backgroundColor</code>. This property is optional.</li>
      <li><code>backgroundColorAlpha:Boolean</code>. If the backgroundColor has an alpha of 0%, then the parameter sets <code>TextField.background</code> = <code>!backgroundColor</code>. This property is optional.</li>
      <li><code>wrapOption:Boolean</code>. This parameter sets the TextField.wordWrap. This property is optional.</li>
    </ul>
  </li>
</ul>

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
      <a href="00000605.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
      </td>
      <td rowspan="2">&nbsp;&nbsp;</td>
      <td rowspan="2">
      <a href="00000607.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
      </td>
   </tr>
   <tr>
       <td align="left"><p><b><a href="http://livedocs.adobe.com/flash/9.0/main/00000606.html" target="mm_window">View comments on LiveDocs</a></b></p></td>
   </tr>
</table>
   </body>
</html>                                                                                                                                                                                                                                                                                                                                                        S~1\Temp\joeymedia-371.jpg"/>
    <NC:DownloadState NC:parseType="Integer">-1</NC:DownloadState>
    <NC:ProgressPercent NC:parseType="Integer">0</NC:ProgressPercent>
  </RDF:Description>
  <RDF:Description RDF:about="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-10.jpg"
                   NC:Name="joeymedia-10.jpg"
                   NC:Transferred="0KB of  0KB">
    <NC:URL RDF:resource="http://ccphotos.taboca.com/mturk/testmarcio/ccphotos-maringa-kids-toys/31/test.jpg"/>
    <NC:File RDF:resource="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-10.jpg"/>
    <NC:DateEnded NC:parseType="Date">Mon Jun 11 21:27:30 E. South America Standard Time 2007 +828125</NC:DateEnded>
    <NC:DownloadState NC:parseType="Integer">3</NC:DownloadState>
    <NC:ProgressPercent NC:parseType="Integer">0</NC:ProgressPercent>
  </RDF:Description>
  <RDF:Description RDF:about="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-51.jpg"
                   NC:Name="joeymedia-51.jpg"
                   NC:Transferred="0KB of  0KB">
    <NC:File RDF:resource="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-51.jpg"/>
    <NC:URL RDF:resource="http://ccphotos.taboca.com/mturk/testmarcio/ccphotos-beach-architecture-details/24/test.jpg"/>
    <NC:DateEnded NC:parseType="Date">Tue Jun 12 03:52:49 E. South America Standard Time 2007 +812500</NC:DateEnded>
    <NC:DownloadState NC:parseType="Integer">3</NC:DownloadState>
    <NC:ProgressPercent NC:parseType="Integer">0</NC:ProgressPercent>
  </RDF:Description>
  <RDF:Description RDF:about="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-279.jpg"
                   NC:Name="joeymedia-279.jpg"
                   NC:Transferred="0KB of  0KB">
    <NC:URL RDF:resource="http://ccphotos.taboca.com/mturk/testmarcio/ccphotos-everton-train-old-station/2/test.jpg"/>
    <NC:File RDF:resource="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-279.jpg"/>
    <NC:DateEnded NC:parseType="Date">Fri Jun 15 12:29:36 E. South America Standard Time 2007 +281250</NC:DateEnded>
    <NC:DownloadState NC:parseType="Integer">3</NC:DownloadState>
    <NC:ProgressPercent NC:parseType="Integer">0</NC:ProgressPercent>
  </RDF:Description>
  <RDF:Description RDF:about="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-286.jpg"
                   NC:Name="joeymedia-286.jpg"
                   NC:Transferred="0KB of  0KB">
    <NC:URL RDF:resource="http://ccphotos.taboca.com/mturk/testmarcio/ccphotos-everton-train-old-station/13/test.jpg"/>
    <NC:File RDF:resource="C:\DOCUME~1\marcio\LOCALS~1\Temp\joeymedia-286.jpg"/>
    <NC:DateEnded NC:parseType="Date">Fri Jun 15GIF89a? ? �� hhh���|}}���WXX�������������������暚�&u������ʒ�������𔩼������e��W�˱����샃�c�������ㄜ�[��{�ڋ�����������-]����sstL����������꽽�#[е����������������Tz����ϕ�������5b�l�֚�����c�������Jt����������3}������Ҽ��U|���������ܛ��#U���⭭������ę����������ґ��������e����̹�������穩�;h����Mέ��������u��~��vMX���;�������������������������������޾����܆T_������^���倮������������������������n����@��j���ݴ��������Am����������r����Ώ����ɞ�������۾��������R�&W����u��a�s����񬫯F�˘��)Z����[�����0_�l�������������������������������������������������������������������������������������������������������������������������������������������̄~������������������������A~Ї�����__`���������������m��y�ŷ�������䇨����������To����nno���O��������xxxU��"p�������!�  � ,    ? ?  � �	H����*\Ȱ�Ç#J�H��ŋ3j�ȱ�Ǐ�� )�ɑ$%�D'>�C!�P"D4 ���@{�J�h�C��� �D�"H�**��T�ҥ�1g�0dg��x�ԏ�M�B�J5�]�h%���K�2Q����=�Z4�a���Օ���S�v�^ź�k�O_c	_"Y�ͱ'�/� i� ˗5���u�J @�����aN#��Ι3�ʦ��nO�o�Q�ࡉ��%*�ͳhվfhK�{U���G�>��`���+V�V���O>�� &`��
�(M4l$��{��_}��д -��c�&�&���`&�.\����q�~��9"�Bb>#��C#
���
������S�B��#�<~��0AC�(JЈ1���NB�<�g��;z�2]~��2b*�	$0����K~�馆pf�+�Tӊ+�C���'�~�"��r�1�
70����(+\��
8'2��z:�����K�3�rM��*_����(���"�5�"�.�d���i/������c�ò����
Ri���̙�
���2�7�d����ҭ+��N���"'MF�~�A�s�QE���Ko��f�/��j)�f>�)�����O�[�~�2��,�Pl�7x�
r O�����M���J���L�5�����0F#3̈́��193�
i���%�8K>C=n�}&�t.;�.P/����0���
�"J��#�+�p4���2Z6.�]��?����]��s���/>���0��H&�L(��M>8#��.����ܷIy���Y�0j�ߚ��i���.cD�������L:B���^��1,�����?B����'7+A��2�X�d�1�<��^���g�=�
�Q����8`��+�,�"X�F��%�xcx��!���C��2�5�}�0�Y �`6� j�;���ࡁQ�$؊Q� &��g(�
Ԡ8�a<��z�@4���A�G�� &Da�����H@��HESX1�4 ��.� �(A	H��26A(!�ȐD0�p�� i�������Op A&�@�)��Fp�0�@�b&0�ٸ�I��K�	h��N����&� L���4�"��RD�eX�<�%&dB�`�&�"_�P_1iLck�4FV�2PAFh+P�T�X�
h� �L��$��
��p��\������>�@�}��(7���l�� *�6���@��*�8GI1gh`"�@+&A	��8܉r�@jDR@��Y8�#��KT!B+&��D#��5R  ���PDl�� t؂��Q�%�P��]�¥�FNa�2�+#�20
xA����J�`�=(1�(���`UU`�k`u!Q�1.�	) ao0���"Ti��?�!:��9�Z�Jpa�H���W��4!Q�@1
P����}�C(�R��@�`�/��}h�pȄ�@  0�, �hӁ�]\��8�i����E����MA � �� T��P�>�LD��(<Z��(��^ ]��`��Œ2QF���^%� 1d��:� ��	'LA�ER�{��#���/�{�J����^4��4L��B��`�p`�\�0:N���}��B�bGc_p��! ��F0�)ک�