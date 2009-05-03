}/{$package.dir}/{@name}.html">
            <xsl:apply-templates select="." mode="class.details"/>
        </redirect:write>
    </xsl:for-each>
</xsl:template>

<xsl:template name="index.html">
<HTML>
    <HEAD><TITLE>Audit Results.</TITLE></HEAD>
    <FRAMESET cols="20%,80%">
        <FRAMESET rows="30%,70%">
            <FRAME src="overview-frame.html" name="packageListFrame"/>
            <FRAME src="allclasses-frame.html" name="classListFrame"/>
        </FRAMESET>
        <FRAME src="overview-summary.html" name="classFrame"/>
    </FRAMESET>
    <noframes>
        <H2>Frame Alert</H2>
        <P>
        This document is designed to be viewed using the frames feature. If you see this message, you are using a non-frame-capable web client.
        </P>
    </noframes>
</HTML>
</xsl:template>


<!-- this is the stylesheet css to use for nearly everything -->
<xsl:template name="stylesheet.css">
    .bannercell {
      border: 0px;
      padding: 0px;
    }
    body {
      margin-left: 10;
      margin-right: 10;
      font:normal 80% arial,helvetica,sanserif;
      background-color:#FFFFFF;
      color:#000000;
    }
    .a td {
      background: #efefef;
    }
    .b td {
      background: #fff;
    }
    th, td {
      text-align: left;
      vertical-align: top;
    }
    th {
      font-weight:bold;
      background: #ccc;
      color: black;
    }
    table, th, td {
      font-size:100%;
      border: none
    }
    table.log tr td, tr th {

    }
    h2 {
      font-weight:bold;
      font-size:140%;
      margin-bottom: 5;
    }
    h3 {
      font-size:100%;
      font-weight:bold;
      background: #525D76;
      color: white;
      text-decoration: none;
      padding: 5px;
      margin-right: 2px;
      margin-left: 2px;
      margin-bottom: 0;
    }
</xsl:template>


<!-- print the violations of the class -->
<xsl:template match="class" mode="class.details">
    <xsl:variable name="package.name" select="@package"/>
    <HTML>
        <HEAD>
            <xsl:call-template name="create.stylesheet.link">
                <xsl:with-param name="package.name" select="$package.name"/>
            </xsl:call-template>
        </HEAD>
        <BODY>
            <xsl:call-template name="pageHeader"/>
            <H3>Class <xsl:if test="not($package.name = '')"><xsl:value-of select="$package.name"/>.</xsl:if><xsl:value-of select="@name"/></H3>

            <table class="log" border="0" cellpadding="5" cellspacing="2" width="100%">
                <xsl:call-template name="class.audit.header"/>
                <xsl:apply-templates select="." mode="print.audit"/>
            </table>

            <H3>Violations</H3>
            <table class="log" border="0" cellpadding="5" cellspacing="2" width="100%">
                <xsl:call-template name="violation.audit.header"/>
                <xsl:apply-templates select="./violation" mode="print.audit">
                    <xsl:sort data-type="number" select="@line"/>
                </xsl:apply-templates>
            </table>
            <xsl:call-template name="pageFooter"/>
        </BODY>
    </HTML>
</xsl:template>


<!-- list of classes in a package -->
<xsl:template name="classes.list">
    <xsl:param name="name"/>
    <HTML>
        <HEAD>
            <xsl:call-template name="create.stylesheet.link">
                <xsl:with-param name="package.name" select="$name"/>
            </xsl:call-template>
        </HEAD>
        <BODY>
            <table width="100%">
                <tr>
                    <td nowrap="nowrap">
                        <H2><a href="package-summary.html" target="classFrame"><xsl:value-of select="$name"/></a></H2>
                    </td>
                </tr>
            </table>

            <h2>Classes</h2>
            <TABLE WIDTH="100%">
                <xsl:apply-templates select="/classes/class[./@package = $name]" mode="classes.list">
                    <xsl:sort select="@name"/>
                </xsl:apply-templates>
            </TABLE>
        </BODY>
    </HTML>
</xsl:template>
<!-- the class to list -->
<xsl:template match="class" mode="classes.list">
    <tr>
        <td nowrap="nowrap">
            <!-- @bug naming to fix for inner classes -->
            <a href="{@name}.html" target="classFrame"><xsl:value-of select="@name"/></a>
        </td>
    </tr>
</xsl:template>


<!--
    Creates an all-classes.html file that contains a link to all package-summary.html
    on each class.
-->
<xsl:template match="classes" mode="all.classes">
    <html>
        <head>
            <xsl:call-template name="create.stylesheet.link">
                <xsl:with-param name="package.name"/>
            </xsl:call-template>
        </head>
        <body>
            <h2>Classes</h2>
            <table width="100%">
                <xsl:apply-templates select=".//class" mode="all.classes">
                    <xsl:sort select="@name"/>
                </xsl:apply-templates>
            </table>
        </body>
    </html>
</xsl:template>

<xsl:template match="class" mode="all.classes">
    <!-- (ancestor::package)[last()] is buggy in MSXML3 ? -->
    <xsl:variable name="package.name" select="@package"/>
    <tr>
        <td nowrap="nowrap">
            <a target="classFrame">
                <xsl:attribute name="href">
                    <xsl:if test="not($package.name='')">
                        <xsl:value-of select="translate($package.name,'.','/')"/><xsl:text>/</xsl:text>
                    </xsl:if><xsl:value-of select="@name"/><xsl:text>.html</xsl:text>
                </xsl:attribute>
                <xsl:value-of select="@name"/>
            </a>
        </td>
    </tr>
</xsl:template>


<!--
    Creates an html file that contains a link to all package-summary.html files on
    each package existing on testsuites.
    @bug there will be a problem here, I don't know yet how to handle unnamed package :(
-->
<xsl:template match="classes" mode="all.packages">
    <html>
        <head>
            <xsl:call-template name="create.stylesheet.link">
                <xsl:with-param name="package.name"/>
            </xsl:call-template>
        </head>
        <body>
            <h2><a href="overview-summary.html" target="classFrame">Home</a></h2>
            <h2>Packages</h2>
                <table width="100%">
                    <xsl:apply-templates select="class[not(./@package = preceding-sibling::class/@package)]" mode="all.packages">
                        <xsl:sort select="@package"