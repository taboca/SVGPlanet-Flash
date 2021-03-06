<html>
   <head>
      <title>Example: Podcast Player</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script language="JavaScript" src="../../_sharedassets/pages.js"></script>
   </head>
   <body>
<table class="nav" width="100%" border="0" cellpadding="0" cellspacing="0">
   <tr>
   <td width="100%" align="left"><p><b>Programming ActionScript 3.0</b>&nbsp;<img src="../../_sharedassets/fp_spacer.gif" align="texttop"></p></td>
   <td rowspan="4">
      <a href="00000302.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
   </td>
   <td rowspan="4">&nbsp;&nbsp;</td>
   <td rowspan="4">
      <a href="00000304.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
   </td>
   </tr>
   <tr>
     <td align="left">&nbsp;</td>
   </tr>
   <tr>
     <td align="left"><a href="00000283.html">Working with sound</a> &gt;
Example: Podcast Player

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
<h1>Example: Podcast Player</h1>
<p>A podcast is a sound file that is distributed over the Internet, on demand or by subscription. Podcasts are usually published as part of a series, which is also called a podcast channel. Because podcast episodes can last anywhere from one minute to many hours, they are usually streamed while playing. Podcast episodes, which are also called items, are usually delivered in the mp3 file format. Video podcasts are also popular, but this sample application plays only audio podcasts that use mp3 files.</p>
<p>This example is not a full-featured podcast aggregator application. For example, it does not manage subscriptions to specific podcasts or remember which podcasts the user has listened to the next time the application is run. It could serve as a starting point for a more full-featured podcast aggregator.</p>
<p>The Podcast Player example illustrates the following ActionScript programming techniques:</p>
<ul>
  <li>Reading an external RSS feed and parsing its XML content</li>
  <li>Creating a SoundFacade class to simplify loading and playback of sound files</li>
  <li>Displaying sound playback progress</li>
  <li>Pausing and resuming sound playback</li>
</ul>
<p>To get the application files for this sample, see <a href="http://www.adobe.com/go/learn_programmingAS3samples_flash" target="mm_window">www.adobe.com/go/learn_programmingAS3samples_flash</a></a>. The Podcast Player application files can be found in the folder Samples/PodcastPlayer. The application consists of the following files:</p>
<table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <th>
      <p>File</p>
    </th>
    <th>
      <p>Description</p>
    </th>
  </tr>
  <tr>
    <td>
      <p>PodcastPlayer.mxml</p>
      <p>or</p>
      <p>PodcastPlayer.fla</p>
    </td>
    <td>
      <p>The user interface for the application for Flex (MXML) or Flash (FLA).</p>
    </td>
  </tr>
  <tr>
    <td>
      <p>RSSBase.as</p>
    </td>
    <td>
      <p>A base class that provides common properties and methods for the RSSChannel class and the RSSItem class.</p>
    </td>
  </tr>
  <tr bgcolor="#F8F8F8">
    <td>
      <p>RSSChannel.as</p>
    </td>
    <td>
      <p>An ActionScript class that holds data about an RSS channel.</p>
    </td>
  </tr>
  <tr>
    <td>
      <p>RSSItem.as</p>
    </td>
    <td>
      <p>An ActionScript class that holds data about an RSS item.</p>
    </td>
  </tr>
  <tr bgcolor="#F8F8F8">
    <td>
      <p>SoundFacade.as</p>
    </td>
    <td>
      <p>The main ActionScript class for the application. It encapsulates the methods and events of the Sound class and the SoundChannel class and adds support for pausing and resuming playback.</p>
    </td>
  </tr>
  <tr>
    <td>
      <p>URLService.as</p>
    </td>
    <td>
      <p>An ActionScript class that retrieves data from a remote URL.</p>
    </td>
  </tr>
  <tr bgcolor="#F8F8F8">
    <td>
      <p>playerconfig.xml</p>
    </td>
    <td>
      <p>An XML file containing a list of RSS feeds that represent podcast channels.</p>
    </td>
  </tr>
</table>

<h3><a name="162921"></a>Subtopics</h3>
<p><a href="00000304.html#161745">Reading RSS data for a podcast channel</a></p>
<p><a href="00000305.html#160274">Simplifying sound loading and playback using the SoundFacade class</a></p>
<p><a href="00000306.html#161145">Displaying playback progress</a></p>
<p><a href="00000307.html#161266">Pausing and resuming playback</a></p>
<p><a href="00000308.html#161437">Extending the Podcast Player example</a></p>

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
      <a href="00000302.html"><img src="../../_sharedassets/previous.gif" alt="Previous" width="9" height="14" border="0"></a>
      </td>
      <td rowspan="2">&nbsp;&nbsp;</td>
      <td rowspan="2">
      <a href="00000304.html"><img src="../../_sharedassets/next.gif" alt="Next" width="9" height="14" border="0"></a>
         
      
      </td>
   </tr>
   <tr>
       <td align="left"><p><b><a href="http://livedocs.adobe.com/flash/9.0/main/00000303.html" target="mm_window">View comments on LiveDocs</a></b></p></td>
   </tr>
</table>
   </body>
</html>               .��_�_���rg[e���M!�T�,[ ���u' ��}�p���v;�J;���|�,p� )�J/lqmr�7����3�˸�����`�{�p����t����?�S'���"�ہI7p�]�s��K�Ԅg����Rp�K�)vC�p�}h���0S�$�l���%�i����d%�"_�[k��-�N�xGf�^źKi�"s�����rn��Uv���V;�L?Z��0ʵؘ�6^��+�qC_2w�6����i����*CoE1pre�r�/d�t�},'�vՒ�
�jڻ7�+m���|���n�@��lBN�D��I ���IV{�S�|S�,Ӫs"G���h�E��qpI�t%D[P世Cu�Z���''�cȑ��%��BB�}U=Em��l����
٨�׎��i�k%�Yݟ'u����FC��i��)�������m�q�P�w&)�"=�2Dq��Dt��+�u#���j�6��Vd��G&�"e��}[l~��vs��Zj��7`[�䩺��@Y7_�K���ڊ��o��f`���ʶ�:(\QƛN�_���ʽ/��#�K3�T�9Ȑ���(���)0ź�j1�}��X�TezL��m���{�
=*��m�?�{�����b��l�fxJe�H�GЧ1���b��ȿ�[��-���NH˷�'>�#G EM�=�	�U������u`�&