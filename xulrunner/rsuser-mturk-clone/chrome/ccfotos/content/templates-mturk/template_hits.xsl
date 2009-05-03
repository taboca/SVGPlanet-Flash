<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" indent="yes"/>

<xsl:template match="/">

  <xsl:for-each select="/keys/list/image">
      <xsl:value-of select="."/>
      <xsl:value-of select="@src"/>
  </xsl:for-each>

</xsl:template>
  
</xsl:stylesheet>