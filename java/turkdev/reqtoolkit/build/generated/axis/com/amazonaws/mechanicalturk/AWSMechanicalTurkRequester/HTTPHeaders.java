="XMLReaderAdapter()"><!-- --></A><H3>
XMLReaderAdapter</H3>
<PRE>
public <B>XMLReaderAdapter</B>()
                 throws <A HREF="../../../../org/xml/sax/SAXException.html" title="class in org.xml.sax">SAXException</A></PRE>
<DL>
<DD>Create a new adapter.

 <p>Use the "org.xml.sax.driver" property to locate the SAX2
 driver to embed.</p>
<P>

<DT><B>Throws:</B>
<DD><CODE><A HREF="../../../../org/xml/sax/SAXException.html" title="class in org.xml.sax">SAXException</A></CODE> - If the embedded driver
            cannot be instantiated or if the
            org.xml.sax.driver property is not specified.</DL>
<HR>

<A NAME="XMLReaderAdapter(org.xml.sax.XMLReader)"><!-- --></A><H3>
XMLReaderAdapter</H3>
<PRE>
public <B>XMLReaderAdapter</B>(<A HREF="../../../../org/xml/sax/XMLReader.html" title="interface in org.xml.sax">XMLReader</A>&nbsp;xmlReader)</PRE>
<DL>
<DD>Create a new adapter.

 <p>Create a new adapter, wrapped around a SAX2 XMLReader.
 The adapter will make the XMLReader act like a SAX1
 Parser.</p>
<P>
<DT><B>Parameters:</B><DD><CODE>xmlReader</CODE> - The SAX2 XMLReader to wrap.
<DT><B>Throws:</B>
<DD><CODE>java.lang.NullPointerException</CODE> - If the argument is null.</DL>

<!-- ============ METHOD DETAIL ========== -->

<A NAME="method_detail"><!-- --></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
<TR BGCOLOR="#CCCCFF" CLASS="TableHeadingColor">
<TD COLSPAN=1><FONT SIZE="+2">
<B>Method Detail</B></FONT></TD>
</TR>
</TABLE>

<A NAME="setLocale(java.util.Locale)"><!-- --></A><H3>
setLocale</H3>
<PRE>
public void <B>setLocale</B>(java.util.Locale&nbsp;locale)
               throws <A HREF="../../../../org/xml/sax/SAXException.html" title="class in org.xml.sax">SAXException</A></PRE>
<DL>
<DD>Set the locale for error reporting.

 <p>This is not supported in SAX2, and will always throw
 an exception.</p>
<P>
<DD><DL>
<DT><B>Specified by:</B><DD><CODE><A HREF="../../../../org/xml/sax/Parser.html#setLocale(java.util.Locale)">setLocale</A></CODE> in interface <CODE><A HREF="../../../../org/xml/sax/Parser.html" title="interface in org.xml.sax">Parser</A></CODE></DL>
</DD>
<DD><DL>
<DT><B>Parameters:</B><DD><CODE>locale</CODE> - the locale for error reporting.
<DT><B>Throws:</B>
<DD><CODE><A HREF="../../../../org/xml/sax/SAXException.html" title="class in org.xml.sax">SAXException</A></CODE> - Thrown unless overridden.<DT><B>See Also:</B><DD><A HREF="../../../../org/xml/sax/Parser.html#setLocale(java.util.Locale)"><CODE>Parser.setLocale(java.util.Locale)</CODE></A></DL>
</DD>
</DL>
<HR>

<A NAME="setEntityResolver(org.xml.sax.EntityResolver)"><!-- --></A><H3>
setEntityResolver</H3>
<PRE>
public void <B>setEntityResolver</B>(<A HREF="../../../../org/xml/sax/EntityResolver.html" title="interface in org.xml.sax">EntityResolver</A>&nbsp;resolver)</PRE>
<DL>
<DD>Register the entity resolver.
<P>
<DD><DL>
<DT><B>Specified by:</B><DD><CODE><A HREF="../../../../org/xml/sax/Parser.html#setEntityResolver(org.xml.sax.EntityResolver)">setEntityResolver</A></CODE> in interface <CODE><A HREF="../../../../org/xml/sax/Parser.html" title="interface in org.xml.sax">Parser</A></CODE></DL>
</DD>
<DD><DL>
<DT><B>Parameters:</B><DD><CODE>resolver</CODE> - The new resolver.<DT><B>See Also:</B><DD><A HREF="../../../../org/xml/sax/Parser.html#setEntityResolver(org.xml.sax.EntityResolver)"><CODE>Parser.setEntityResolver(org.xml.sax.EntityResolver)</CODE></A></DL>
</DD>
</DL>
<HR>

<A NAME="setDTDHandler(org.xml.sax.DTDHandler)"><!-- --></A><H3>
setDTDHandler</H3>
<PRE>
public void <B>setDTDHandler</B>(<A HREF="../../../../org/xml/sax/DTDHandler.html" title="interface in org.xml.sax">DTDHandler</A>&nbsp;handler)</PRE>
<DL>
<DD>Register the DTD event handler.
<P>
<DD><DL>
<DT><B>Specified by:</B><DD><CODE><A HREF="../../../../org/xml/sax/Parser.html#setDTDHandler(org.xml.sax.DTDHandler)">setDTDHandler</A></CODE> in interface <CODE><A HREF="../../../../org/xml/sax/Parser.html" title="interface in org.xml.sax">Parser</A></CODE></DL>
</DD>
<DD><DL>
<DT><B>Parameters:</B><DD><CODE>handler</CODE> - The new DTD event handler.<DT><B>See Also:</B><DD><A HREF="../../../../org/xml/sax/Parser.html#setDTDHandler(org.xml.sax.DTDHandler)"><CODE>Parser.setDTDHandler(org.xml.sax.DTDHandler)</CODE></A></DL>
</DD>
</DL>
<HR>

<A NAME="setDocumentHandler(org.xml.sax.DocumentHandler)"><!-- --></A><H3>
setDocumentHandler</H3>
<PRE>
public void <B>setDocumentHandler</B>(<A HREF="../../../../org/xml/sax/DocumentHandler.html" title="interface in org.xml.sax">DocumentHandler</A>&nbsp;handler)</PRE>
<DL>
<DD>Register the SAX1 document event handler.

 <p>Note that the SAX1 doc