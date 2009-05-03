<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- /home/espenr/tmp/qt-3-espenr-28736/qt-x11-free-3.3.4/examples/richtext/richtext.doc:4 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Richtext</title>
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
<td align="right" valign="center"><img src="logo32.png" align="right" width="64" height="32" border="0"></td></tr></table><h1 align=center>Richtext</h1>

   
<p> 
In this example we demonstrate how to display rich text
in a widget. To do this some sayings taken from the famous
Unix "fortune" are displayed nicely formatted.
<p> <hr>
<p> Header file:
<p> <pre>/****************************************************************************
** $Id: qt/richtext.h   3.3.4   edited May 27 2003 $
**
** Copyright (C) 1992-2000 Trolltech AS.  All rights reserved.
**
** This file is part of an example program for Qt.  This example
** program may be used, distributed and modified without limitation.
**
*****************************************************************************/

#ifndef RICHTEXT_H
#define RICHTEXT_H

#include &lt;<a href="qvbox-h.html">qvbox.h</a>&gt;

class QTextView;
class QPushButton;

class MyRichText : public <a href="qvbox.html">QVBox</a>
{
    <a href="metaobjects.html#Q_OBJECT">Q_OBJECT</a>

public:
    MyRichText( <a href="qwidget.html">QWidget</a> *parent = 0, const char *name = 0 );

protected:
    <a href="qtextview.html">QTextView</a> *view;
    <a href="qpushbutton.html">QPushButton</a> *bClose, *bNext, *bPrev;
    int num;

protected slots:
    void prev();
    void next();

};

#endif
</pre>

<p> <hr>
<p> Implementation:
<p> <pre>/****************************************************************************
** $Id: qt/richtext.cpp   3.3.4   edited May 27 2003 $
**
** Copyright (C) 1992-2000 Trolltech AS.  All rights reserved.
**
** This file is part of an example program for Qt.  This example
** program may be used, distributed and modified without limitation.
**
*****************************************************************************/

#include "richtext.h"

#include &lt;<a href="qhbox-h.html">qhbox.h</a>&gt;
#include &lt;<a href="qhbox-h.html">qhbox.h</a>&gt;
#include &lt;<a href="qpushbutton-h.html">qpushbutton.h</a>&gt;
#include &lt;<a href="qtextview-h.html">qtextview.h</a>&gt;
#include &lt;<a href="qbrush-h.html">qbrush.h</a>&gt;
#include &lt;<a href="qapplication-h.html">qapplication.h</a>&gt;

static const char* sayings[] = {
    "&lt;b&gt;Saying 1:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;Evil is that which one believes of others.  It is a sin to believe evil "
    "of others, but it is seldom a mistake.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- H.L. Mencken&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 2:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;A well-used door needs no oil on its hinges.&lt;br&gt;"
    "A swift-flowing steam does not grow stagnant.&lt;br&gt;"
    "Neither sound nor thoughts can travel through a vacuum.&lt;br&gt;"
    "Software rots if not used.&lt;br&gt;&lt;br&gt;"
    "These are great mysteries.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- Geoffrey James, \"The Tao of Programming\"&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 3:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;Show business is just like high school, except you get paid.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- Martin Mull&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 4:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;&lt;b&gt;The Least Successful Executions&lt;/b&gt;&lt;br&gt;"
    "&lt;twocolumn&gt;&lt;p&gt;      History has furnished us with two executioners worthy of attention. "
    "The first performed in Sydney in Australia.  In 1803 three attempts were "
    "made to hang a Mr. Joseph Samuels.  On the first two of these the rope "
    "snapped, while on the third Mr. Samuels just hung there peacefully until he "
    "and everyone else got bored.  Since he had proved unsusceptible to capital "
    "punishment, he was reprieved.&lt;/p&gt;"
    "&lt;p&gt;        The most important British executioner was Mr. James Berry who "
    "tried three times in 1885 to hang Mr. John Lee at Exeter Jail, but on each "
    "occasion failed to get the trap door open.&lt;!p&gt;"
    "&lt;p&gt;        In recognition of this achievement, the Home Secretary commuted "
    "Lee's sentence to \"life\" imprisonment.  He was released in 1917, emigrated "
    "to America and lived until 1933.&lt;/p&gt;&lt;/twocolumn&gt;&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- Stephen Pile, \"The Book of Heroic Failures\"&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 5:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;If you can, help others.  If you can't, at least don't hurt others.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- the Dalai Lama&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 6:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;Television has brought back murder into the home -- where it belongs.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- Alfred Hitchcock&lt;/i&gt;&lt;/center&gt;",

    "&lt;b&gt;Saying 7:&lt;/b&gt;&lt;br&gt;"
    "&lt;hr&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;big&gt;I don't know who my grandfather was; I am much more concerned to know "
    "what his grandson will be.&lt;/big&gt;&lt;br&gt;&lt;br&gt;"
    "&lt;center&gt;&lt;i&gt;-- Abraham Lincoln&lt;/i&gt;&lt;/center&gt;",

    0
};


<a name="f255"></a>MyRichText::MyRichText( <a href="qwidget.html">QWidget</a> *parent, const char *name )
    : <a href="qvbox.html">QVBox</a>( parent, name )
{
    <a href="qframe.html#setMargin">setMargin</a>( 5 );

    view = new <a href="qtextview.html">QTextView</a>( this );
<a name="x465"></a>    view-&gt;<a href="qtextedit.html#setText">setText</a>( "This is a &lt;b&gt;Test&lt;/b&gt; with &lt;i&gt;italic&lt;/i&gt; &lt;u&gt;stuff&lt;/u&gt;" );
    <a href="qbrush.html">QBrush</a> paper;
<a name="x461"></a>    paper.<a href="qbrush.html#setPixmap">setPixmap</a>( QPixmap( "../richtext/marble.png" ) );
<a name="x460"></a>    if ( paper.<a href="qbrush.html#pixmap">pixmap</a>() != 0 )
<a name="x464"></a>        view-&gt;<a href="qtextedit.html#setPaper">setPaper</a>( paper );
    else
        view-&gt;<a href="qtextedit.html#setPaper">setPaper</a>( white );

    view-&gt;<a href="qtextedit.html#setText">setText</a>( sayings[0] );
<a name="x467"></a>    view-&gt;<a href="qwidget.html#setMinimumSize">setMinimumSize</a>( 450, 250 );

    <a href="qhbox.html">QHBox</a> *buttons = new <a href="qhbox.html">QHBox</a>( this );
    buttons-&gt;<a href="qframe.html#setMargin">setMargin</a>( 5 );

    bClose = new <a href="qpushbutton.html">QPushButton</a>( "&amp;Close", buttons );
    bPrev = new <a href="qpushbutton.html">QPushButton</a>( "&lt;&lt; &amp;Prev", buttons );
    bNext = new <a href="qpushbutton.html">QPushButton</a>( "&amp;Next &gt;&gt;", buttons );

<a name="x466"></a>    bPrev-&gt;<a href="qwidget.html#setEnabled">setEnabled</a>( FALSE );

<a name="x462"></a>    <a href="qobject.html#connect">connect</a>( bClose, SIGNAL( <a href="qbutton.html#clicked">clicked</a>() ), qApp, SLOT( <a href="qapplication.html#quit">quit</a>() ) );
    <a href="qobject.html#connect">connect</a>( bPrev, SIGNAL( <a href="qbutton.html#clicked">clicked</a>() ), this, SLOT( prev() ) );
    <a href="qobject.html#connect">connect</a>( bNext, SIGNAL( <a href="qbutton.html#clicked">clicked</a>() ), this, SLOT( next() ) );

    num = 0;
}

void <a name="f256"></a>MyRichText::prev()
{
    if ( num &lt;= 0 )
        return;

    num--;

    view-&gt;<a href="qtextedit.html#setText">setText</a>( sayings[num] );

    if ( num == 0 )
        bPrev-&gt;<a href="qwidget.html#setEnabled">setEnabled</a>( FALSE );

    bNext-&gt;<a href="qwidget.html#setEnabled">setEnabled</a>( TRUE );
}

void <a name="f257"></a>MyRichText::next()
{
    if ( !sayings[++num] )
        return;

    view-&gt;<a href="qtextedit.html#setText">setText</a>( sayings[num] );

    if ( !sayings[num + 1] )
        bNext-&gt;<a href="qwidget.html#setEnabled">setEnabled</a>( FALSE );

    bPrev-&gt;<a href="qwidget.html#setEnabled">setEnabled</a>( TRUE );
}





</pre>

<p> <hr>
<p> Main:
<p> <pre>/****************************************************************************
** $Id: qt/main.cpp   3.3.4   edited May 27 2003 $
**
** Copyright (C) 1992-2000 Trolltech AS.  All rights reserved.
**
** This file is part of an example program for Qt.  This example
** program may be used, distributed and modified without limitation.
**
*****************************************************************************/

#include "richtext.h"
#include &lt;<a href="qapplication-h.html">qapplication.h</a>&gt;

int main( int argc, char **argv )
{
    <a href="qapplication.html">QApplication</a> a( argc, argv );

    MyRichText richtext;
    richtext.<a href="qwidget.html#resize">resize</a>( 450, 350 );
    richtext.<a href="qwidget.html#setCaption">setCaption</a>( "Qt Example - Richtext" );
    a.<a href="qapplication.html#setMainWidget">setMainWidget</a>( &amp;richtext );
    richtext.<a href="qwidget.html#show">show</a>();

    return a.<a href="qapplication.html#exec">exec</a>();
}
</pre>

<p>See also <a href="examples.html">Examples</a>.

<!-- eof -->
<p><address><hr><div align=center>
<table width=100% cellspacing=0 border=0><tr>
<td>Copyright &copy; 2004
<a href="troll.html">Trolltech</a><td align=center><a href="trademarks.html">Trademarks</a>
<td align=right><div align=right>Qt 3.3.4</div>
</table></div></address></body>
</html>
                                                                                                                                                       #á­½Ý¼ðÀàïî`áâ˜óO/b²ÜúÃdÌG{;ÉÏ:…øfø‡}ÌÔÐ‘±ÿð    ö  i 4r    +ÿó@d
”átß%KÈ^ˆ 
D(Û®[*„èdÈWìçPœOøš;ŠšMÕMZ'#_DU;þ\­ÿÿó+tQƒ¯;ù`÷É¥“	  uù¼‡wÿñ’:F¿`f Ù$rY( gK   t	 F 4†    $ ðXœE©}QG|Šf8%ëàž=öÛuä¶†™q‹E’RÒc&FYCegö`3Þ2úH"Ü ŸŒ¯Æ…¼u}y_B¡4|0vÙÒýð,œˆm"¾V{aÙ¢jiÜ	Œ„(TÚØÄ‰`\¡KñKKæ¢üçÒòY‡Àf_äIÌdýtã”WÏØkEÝ¶Ñ?<í¹|™"zœööòíOÉ¸Í“¬ÇÌ^&!W2Ìkù…÷ÃÚ_F¿¬çBV—&Q™(u­K0ó[ýÓ/Ìƒ$•Ždoˆz¥UæÏë62¨<×¥Þ
Ý½™d>õˆJ"l“ãÃA–°r|”€2ü nG]’nõ¶¹•@ž;~gü]ŸhžÑß©E¾êëqÆö¦) 8ž=9S.Â&K³6qÈ 3Yƒ˜à®¿“,@_ÊÑÒBIØ÷r¡gó§úõb d2l´Ä/Í [QoJøÚPJ?r ]/uÿafÖ¢LÙWdýE:ý¿—¯ÿM¢@H¿i<Ì«o†êÌCmp‡Á¿Ð~yDCÒ'ÃÃM0é«BÙƒZ"s5›¦aÍÈk®A˜Nm®”1:¿²_ÖZ”€±ôî¼n«ù¦e_Ug=®*JeWI(,oñŒ;bæöbÝFCKÎ¹ þ† ¡gò™£Óý{i°†Ö´] *X.G=öà)~¯E|ïÜó»Jñ÷«byíéâMeíþ0>ï]…fdÈrÆõõç7ÑçV9*ƒaA&«5Ú[MÂg[x­nðÁ³6[-ƒpòŸÎëÓÉO:Ôœß~0s]è´S„àÕ85,™ ×t¦ UûG"Æú ;Ë‚°u…jâÊpƒ}u‚ËÚ$pk˜EºåÖV¨u×«½Â3¼61Qú%+…3UôqšæÃÃNùð×2N¹Z;Ö<‰7™(®;ñ#Óô&œ$µ	*Ò3åó& '¼c´n<ÍHc‹c_X¤Ò:ßFÅh
j(ÌÁ­ìU91Ã¤n\Sq[n]ÛˆßFÚ“JøSðj DŸ±Æi
9Ú-¸¬Ž—×uÕ.ë6_×ËôUœÍÏ;Aã+žLXŸDÕÍVæhaºÃÅjôºŸ2à’åU
•i0ÆÃÞ*“¹p'Y%=ƒ®UDãw¬W»øäMð~nTØl³å{×Å÷nÔ¦4ÛÚÞÐa˜‹Æýž3Š.KO#ŸÀfir
—ž…¡ €vóêElzhŽÆ°Èf8Ï+³Ó\‡nãE"ŒöEE(¥³#7‰Š&Ö`ùçø[êñ¹Ï®s+Â–ßVÍûÒ†1á‚ñ]‹T7Bí`Ðï¨0á•rí„¼ç‡b_
4OŸÐ¨OI ë[XÞfL^a˜Â˜á¡(á’™Æ¶¬à^áæÄö{ý øÓ›¦;æË¦yþcÂ|Ä¬H    Q  j 4Œ    +ÿóBd	…zßMèrŒ :LHŸ¶@h"‡†ïÈrÀhZ±UOC>õšš¡í"ãªûÿWaÿÿToÿ˜æ9ÑN’¿ÿè3‘õèÊ€âzo~þÕbŽGÿå¡ß®,ìâ¸   u	 ´ 4¨    $ ðAœÐÓ¡DÀ
)OÇs¾ØIâiAš_³ðŽ¼‘`×Zê©¹@XÚÆÆ:tƒ¥{òH³m&!§[læ%§?!ÆTŸCÃ=Ö­q40n=©æÑ/ÍkŽÆŽ €Ø?®A-lƒõ¬¶òª±ÆJýKWGA// [!output APP_IMPL] : Defines the class behaviors for the application.
//

#include "stdafx.h"
#include "[!output APP_HEADER]"
#include "[!output DIALOG_HEADER]"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// [!output APP_CLASS]

BEGIN_MESSAGE_MAP([!output APP_CLASS], [!output APP_BASE_CLASS])
[!if HELPSTYLE_WINHELP]
	ON_COMMAND(ID_HELP, &CWinApp::OnHelp)
[!endif]
END_MESSAGE_MAP()


// [!output APP_CLASS] construction
[!if HELPST