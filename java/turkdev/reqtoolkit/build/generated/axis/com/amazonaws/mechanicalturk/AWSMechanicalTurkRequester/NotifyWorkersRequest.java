), <a href="#close">close</a>(),
<a href="#flush">flush</a>(), <a href="#size">size</a>(), <a href="#at">at</a>(), <a href="#atEnd">atEnd</a>(), <a href="#readBlock">readBlock</a>(), <a href="#writeBlock">writeBlock</a>(),
<a href="#getch">getch</a>(), <a href="#putch">putch</a>(), <a href="#ungetch">ungetch</a>() and <a href="#readLine">readLine</a>() describes the
differences in detail.
<p> <b>Warning:</b> QSocket is not suitable for use in threads. If you need
to uses sockets in threads use the lower-level <a href="qsocketdevice.html">QSocketDevice</a> class.
<p> <p>See also <a href="qsocketdevice.html">QSocketDevice</a>, <a href="qhostaddress.html">QHostAddress</a>, <a href="qsocketnotifier.html">QSocketNotifier</a>, and <a href="io.html">Input/Output and Networking</a>.

<hr><h2>Member Type Documentation</h2>
<h3 class=fn><a name="Error-enum"></a>QSocket::Error</h3>

<p> This enum specifies the possible errors:
<ul>
<li><tt>QSocket::ErrConnectionRefused</tt> - if the connection was refused
<li><tt>QSocket::ErrHostNotFound</tt> - if the host was not found
<li><tt>QSocket::ErrSocketRead</tt> - if a read from the socket failed
</ul>
<h3 class=fn><a name="State-enum"></a>QSocket::State</h3>

<p> This enum defines the connection states:
<ul>
<li><tt>QSocket::Idle</tt> - if there is no connection
<li><tt>QSocket::HostLookup</tt> - during a DNS lookup
<li><tt>QSocket::Connecting</tt> - during TCP connection establishment
<li><tt>QSocket::Connected</tt> - when there is an operational connection
<li><tt>QSocket::Closing</tt> - if the socket is closing down, but is not yet closed.
</ul>
<hr><h2>Member Function Documentation</h2>
<h3 class=fn><a name="QSocket"></a>QSocket::QSocket ( <a href="qobject.html">QObject</a>&nbsp;*&nbsp;parent = 0, const&nbsp;char&nbsp;*&nbsp;name = 0 )
</h3>
Creates a QSocket object in <a href="#State-enum">QSocket::Idle</a> state.
<p> The <em>parent</em> and <em>name</em> arguments are passed on to the <a href="qobject.html">QObject</a>
constructor.

<h3 class=fn><a name="~QSocket"></a>QSocket::~QSocket ()<tt> [virtual]</tt>
</h3>
Destroys the socket. Closes the connection if necessary.
<p> <p>See also <a href="#close">close</a>().

<h3 class=fn><a href="qhostaddress.html">QHostAddress</a> <a name="address"></a>QSocket::address () const
</h3>
Returns the host address of this socket. (This is normally the
main IP address of the host, but can be e.g. 127.0.0.1 for
connections to localhost.)

<h3 class=fn><a href="qiodevice.html#Offset">Offset</a> <a name="at"></a>QSocket::at () const<tt> [virtual]</tt>
</h3>
Returns the current read index. Since QSocket is a sequential
device, the current read index is always zero.

<p>Reimplemented from <a href="qiodevice.html#at">QIODevice</a>.
<h3 class=fn>bool <a name="at-2"></a>QSocket::at ( <a href="qiodevice.html#Offset">Offset</a>&nbsp;index )<tt> [virtual]</tt>
</h3>
This is an overloaded member function, provided for convenience. It behaves essentially like the above function.
<p> Moves the read index forward to <em>index</em> and returns TRUE if the
operation was successful; otherwise returns FALSE. Moving the
index forward means skipping incoming data.

<p>Reimplemented from <a href="qiodevice.html#at-2">QIODevice</a>.
<h3 class=fn>bool <a name="atEnd"></a>QSocket::atEnd () const<tt> [virtual]</tt>
</h3>
Returns TRUE if there is no more data to read; otherwise returns FALSE.

<p>Reimplemented from <a href="qiodevice.html#atEnd">QIODevice</a>.
<h3 class=fn>Q_ULONG <a name="bytesAvailable"></a>QSocket::bytesAvailable () const
</h3>
Returns the number of incoming bytes that can be read, i.e. the
size of the input buffer. Equivalent to <a href="#size">size</a>().
<p> <p>See also <a href="#bytesToWrite">bytesToWrite</a>().

<p>Example: <a href="networkprotocol-example.html#x736">network/networkprotocol/nntp.cpp</a>.
<h3 class=fn>Q_ULONG <a name="bytesToWrite"></a>QSocket::bytesToWrite () const
</h3>
Returns the number of bytes that are waiting to be written, i.e.
the size of the output buffer.
<p> <p>See also <a href="#bytesAvailable">bytesAvailable</a>() and <a href="#clearPendingData">clearPendingData</a>().

<h3 class=fn>void <a name="bytesWritten"></a>QSocket::bytesWritten ( int&nbsp;nbytes )<tt> [signal]</tt>
</h3>

<p> This signal is emitted when data has been written to the network.
The <em>nbytes</em> parameter specifies how many bytes were written.
<p> The <a href="#bytesToWrite">bytesToWrite</a>() function is often used in the same context; it
indicates how many buffered bytes there are left to write.
<p> <p>See also <a href="#writeBlock">writeBlock</a>() and <a href="#bytesToWrite">bytesToWrite</a>().

<h3 class=fn>bool <a name="canReadLine"></a>QSocket::canReadLine () const
</h3>
Returns TRUE if it's possible to read an entire line of text from
this socket at this time; otherwise returns FALSE.
<p> Note that if the peer closes the connection unexpectedly, this
function returns FALSE. This means that loops such as this won't
work:
<p> <pre>
        while( !socket-&gt;canReadLine() ) // WRONG
            ;
    </pre>
 
<p> <p>See also <a href="#readLine">readLine</a>().

<p>Examples: <a href="clientserver-example.html#x854">network/clientserver/client/client.cpp</a>, <a href="httpd-example.html#x786">network/httpd/httpd.cpp</a>, <a href="mail-example.html#x768">network/mail/smtp.cpp</a>, and <a href="networkprotocol-example.html#x737">network/networkprotocol/nntp.cpp</a>.
<h3 class=fn>void <a name="clearPendingData"></a>QSocket::clearPendingData ()
</h3>
Deletes the data that is waiting to be written. This is useful if you want
to close the socket without waiting for all the data to be written.
<p> <p>See also <a href="#bytesToWrite">bytesToWrite</a>(), <a href="#close">close</a>(), and <a href="#delayedCloseFinished">delayedCloseFinished</a>().

<h3 class=fn>void <a name="close"></a>QSocket::close ()<tt> [virtual]</tt>
</h3>
Closes the socket.
<p> The read buffer is cleared.
<p> If the output buffer is empty, the state is set to <a href="#State-enum">QSocket::Idle</a> and the connection is terminated immediately. If the
output buffer still contains data to be written, QSocket goes into
the <a href="#State-enum">QSocket::Closing</a> state and the rest of the data will be
written. When all of the outgoing data have been written, the
state is set to <a href="#State-enum">QSocket::Idle</a> and the connection is terminated.
At this point, the <a href="#delayedCloseFinished">delayedCloseFinished</a>() signal is emitted.
<p> If you don't want that the data of the output buffer is written, call
<a href="#clearPendingData">clearPendingData</a>() before you call <a href="#close">close</a>().
<p> <p>See also <a href="#state">state</a>(), <a href="#bytesToWrite">bytesToWrite</a>(), and <a href="#clearPendingData">clearPendingData</a>().

<p>Examples: <a href="clientserver-example.html#x855">network/clientserver/client/client.cpp</a>, <a href="httpd-example.html#x787">network/httpd/httpd.cpp</a>, and <a href="networkprotocol-example.html#x738">network/networkprotocol/nntp.cpp</a>.
<p>Reimplemented from <a href="qiodevice.html#close">QIODevice</a>.
<h3 class=fn>void <a name="connectToHost"></a>QSocket::connectToHost ( const&nbsp;<a href="qstring.html">QString</a>&nbsp;&amp;&nbsp;host, Q_UINT16&nbsp;port )<tt> [virtual]</tt>
</h3>
Attempts to make a connection to <em>host</em> on the specified <em>port</em>
and return immediately.
<p> Any connection or pending connection is closed immediately, and
QSocket goes into the <a href="#State-enum">HostLookup</a> state. When the lookup
succeeds, it emits <a href="#hostFound">hostFound</a>(), starts a TCP connection and goes
into the <a href="#State-enum">Connecting</a> state. Finally, when the connection
succeeds, it emits <a href="#connected">connected</a>() and goes into the <a href="#State-enum">Connected</a>
state. If there is an error at any point, it emits <a href="#error">error</a>().
<p> <em>host</em> may be an IP address in string form, or it may be a DNS
name. QSocket will do a normal DNS lookup if required. Note that
<em>port</em> is in native byte order, unlike some other libraries.
<p> <p>See also <a href="#state">state</a>().

<p>Examples: <a href="clientserver-example.html#x856">network/clientserver/client/client.cpp</a>, <a href="mail-example.html#x769">network/mail/smtp.cpp</a>, and <a href="networkprotocol-example.html#x739">network/networkprotocol/nntp.cpp</a>.
<h3 class=fn>void <a name="connected"></a>QSocket::connected ()<tt> [signal]</tt>
</h3>

<p> This signal is emitted after <a href="#connectToHost">connectToHost</a>() has been called and a
connection has been successfully established.
<p> <p>See also <a href="#connectToHost">connectToHost</a>() and <a href="#connectionClosed">connectionClosed</a>().

<p>Examples: <a href="clientserver-example.html#x857">network/clientserver/client/client.cpp</a>, <a href="mai