<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<svg
   xmlns:dc="http://purl.org/dc/elements/1.1/"
   xmlns:cc="http://web.resource.org/cc/"
   xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
   xmlns:svg="http://www.w3.org/2000/svg"
   xmlns="http://www.w3.org/2000/svg"
   xmlns:xlink="http://www.w3.org/1999/xlink"
   xmlns:sodipodi="http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd"
   xmlns:inkscape="http://www.inkscape.org/namespaces/inkscape"
   contentScriptType="text/ecmascript"
   width="400"
   zoomAndPan="magnify"
   contentStyleType="text/css"
   height="400"
   viewBox="0 0 400.0 400.0"
   preserveAspectRatio="xMidYMid meet"
   version="1.0" 
   id="svg2079"
   sodipodi:version="0.32"
   inkscape:version="0.44.1"
   sodipodi:docname="base-quadrado.svg"
   sodipodi:docbase="C:\cygwin\home\ivaldo\taboca-firefox\src\theme\svg\biblioteca">
  <metadata
     id="metadata2119">
    <rdf:RDF>
      <cc:Work
         rdf:about="">
        <dc:format>image/svg+xml</dc:format>
        <dc:type
           rdf:resource="http://purl.org/dc/dcmitype/StillImage" />
      </cc:Work>
    </rdf:RDF>
  </metadata>
  <sodipodi:namedview
     inkscape:window-height="573"
     inkscape:window-width="878"
     inkscape:pageshadow="2"
     inkscape:pageopacity="0.0"
     guidetolerance="10.0"
     gridtolerance="10.0"
     objecttolerance="10.0"
     borderopacity="1.0"
     bordercolor="#666666"
     pagecolor="#ffffff"
     id="base"
     inkscape:zoom="0.945"
     inkscape:cx="200"
     inkscape:cy="200"
     inkscape:window-x="44"
     inkscape:window-y="44"
     inkscape:current-layer="svg2079" />
  <defs
     id="defs2081">
    <filter
       x="0"
       y="0"
       width="450"
       filterUnits="userSpaceOnUse"
       xlink:type="simple"
       xlink:actuate="onLoad"
       id="MyFilter"
       height="400"
       xlink:show="other">
      <feGaussianBlur
         stdDeviation="14"
         in="SourceAlpha"
         result="blur"
         id="feGaussianBlur2084" />
      <feOffset
         dx="14"
         dy="14"
         in="blur"
         result="offsetBlur"
         id="feOffset2086" />
      <feSpecularLighting
         specularConstant=".2"
         specularExponent="20"
         result="specOut"
         in="blur"
         surfaceScale="5"
         lighting-color="#bbbbbb"
         id="feSpecularLighting2088">
        <fePointLight
           x="-5000"
           y="-10000"
           z="20000"
           id="fePointLight2090" />
      </feSpecularLighting>
      <feComposite
         in2="SourceAlpha"
         operator="in"
         in="specOut"
         result="specOut"
         id="feComposite2092" />
      <feComposite
         result="litPaint"
         in="SourceGraphic"
         k1="0"
         k2="1"
         k3="1"
         k4="0"
         in2="specOut"
         operator="arithmetic"
         id="feComposite2094" />
      <feMerge
         id="feMerge2096">
        <feMergeNode
           in="offsetBlur"
           id="feMergeNode2098" />
        <feMergeNode
           in="litPaint"
           id="feMergeNode2100" />
      </feMerge>
    </filter>
    <radialGradient
       gradientTransform=""
       id="radial0"
       gradientUnits="objectBoundingBox"
       spreadMethod="repeat"
       xlink:show="other"
       xlink:type="simple"
       r="50%"
       cx="50%"
       fx="50%"
       cy="50%"
       fy="50%"
       xlink:actuate="onLoad">
      <stop
         style="stop-color:#ff6600;stop-opacity:1;"
         offset="33%"
         id="stop2103" />
    </radialGradient>
    <radialGradient
       gradientTransform=""
       id="radial1"
       gradientUnits="objectBoundingBox"
       spreadMethod="pad"
       xlink:show="other"
       xlink:type="simple"
       r="111%"
       cx="7%"
       fx="111%"
       cy="97%"
       fy="111%"
       xlink:actuate="onLoad">
      <stop
         style="stop-color:#ffffff;stop-opacity:1;"
         offset="0%"
         id="stop2106" />
      <stop
         style="stop-color:#cccccc;stop-opacity:1;"
         offset="61%"
         id="stop2108" />
    </radialGradient>
  </defs>
</svg>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            �s��Ӟ;���H� �W�v���⚓5�}P�9�,-�0�q�>|�Vt���� 8�og������N��C�	���0�i���b��0D^B9[o���n98|�0��Tsw����7��b$�`b�jx)�7��1�+��2Ad�T�{^�#���n��6�8��2�	���5�쇈"��+	"yG�%V}�
�D#K�p���w� �����W�A��kc������6ڴ��g����T�P�AKVW�H�_$�B?WS�,O��3/�w��TUY7�D��d����PO{ޛ;    IEND�B`�                                                                                                                                                                                                      ublic License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

@namespace url("http://www.mozilla.org/keymaster/gatekeeper/there.is.only.xul");

.up {
  list-style-image: url("chrome://global/skin/spinbtn-up.gif")
}

.up:hover:active {
  list-style-image: url("chrome://global/skin/spinbtn-up-act.gif")
}

.down {
  list-style-image: url("chrome://global/skin/spinbtn-dn.gif")
}

.down:hover:active {
  list-style-image: url("chrome://global/skin/spinbtn-dn-act.gif")
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                          P848O72279457P5SR03O2R6855N6 ��&MON3Q899R9OQ5PNQO8P4SS94465499567 ��   &                                  drr�  #    � K��  �                                                                                                                                 ���tM�UON3Q65S50P86SP5PP32N179RNP390721MTZsWG1zVm5FdzYHvVpFcUYFNLSxaQB6/r3grIPN2E+c+XI7PMVCLDD4Xr+3ZYh9ubnVJN03vWnpJpmIifbbzgerCiIzegQJBoc=�4��sM�-O4045S0PQ3ORN051Q6P2Q8NN82Q920S4RjZ2amhFMUyQBtaTFlcgZNNID096F8aBRiXdujyzkDGTdceojI5hOqvXGmDwFBZ+wC39cxRu87sJf/ofA0MXzz9yFuUBFc4fgpRxgDZshRW+XJFbGghlAbh1Qu6oGkJjP17erSMvUa9y8w==�4��rM�-O35455230Q4O6Q8807122100RQPS2236Vk4zYzRZajf+MgeXgtTuER5nbQNzD+CmrrIZAm4MY4PAS1b72uplepJf3y3zAwoRvVh05zxN80IL24wF/cw22TiLNviIX9DXEs1/BqlaFPPTF1xDt3khwWACQWyBzw/fFiyiivmOf+69j9E=�4��qM�-O1890115024P1403NS84SP108PQ75RSSd2ZHUnNzQzF/FnGJ9p+CaPIPmIMD24+ZLZMprOpS/wNO0yVdEtHDcD1eX4rZMKE6Ba3uuA+twVB+ekijkVUdyaillqGr4ySsjSts2Nt7IEW9Pt1JwNdb5FJd2DNTX/YVb1lYbWMyWYta7REd�0��pM�%N5Q14535S79PP1844S01SO9O937R5P2PNmZycmVoUHWUlQZG+jw0H6mYIkJGtTGHSNrUDMvMeQc/ik6yka2vuD14lfTxLBh3F28FXBEHqwQnahMseAgpyKVUFr15eROS7SAEYv0YwK4t9Z/B75ynLW8XgJJOaT6xVmh1F+/zYH+2drs�  2
&  � r�� � ���d �� � � � � � � � � � � � � �                                                                                    &MON131994QP99P446O281P44NN67O36N1 �k&MON2QS8SS1PP40P3441198P73304269NP ��&MON31366Q970331539N728N0017O6618N �Q&MON1380591N3R2PR731SO0S12OPSQ0SQ4 ��� L                                  � &                                  &MON09SQ8836QQ6S��            )         �     �  	   �     �     �     �     �     �     �     �     �     �          
                    #     (     -  	   3  	   =     G  	   N     X     ^     g     l     q     y     �  4  �     �  
   �     �     �  
   �     �     �                               &     ,  	   4     >     F     O     X  
   `     k     x     �     �     �     �     �  	   �  
   �     �                                   	                                             
                                                        alert animation appli