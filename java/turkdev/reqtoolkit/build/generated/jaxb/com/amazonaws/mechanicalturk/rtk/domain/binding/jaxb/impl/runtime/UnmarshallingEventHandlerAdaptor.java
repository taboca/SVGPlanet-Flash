GIF89a  ї     џ Нџ1џџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџџ!љ   ,        0   "ThaA  ;                                                                                                                                                                                                       * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
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

/**
 * Root idl declarations to be used by all.
 * @status FROZEN
 */

%{C++

#include "nscore.h"
#include "prtime.h"

/*
 * Forward declarations for new string types
 */
class nsAString;
class nsACString;

/* 
 * Start commenting out the C++ versions of the below in the output header
 */
#if 0
%}

typedef boolean             PRBool   ;
typedef octet               PRUint8  ;
typedef unsigned short      PRUint16 ;
typedef unsigned short      PRUnichar;
typedef unsigned long       PRUint32 ;
typedef unsigned long long  PRUint64 ;
typedef unsigned long long  PRTime   ;
typedef short               PRInt16  ;
typedef long                PRInt32  ;
typedef long long           PRInt64  ;

typedef unsigned long       nsrefcnt ;
typedef unsigned long       nsresult ;

// XXX need this built into xpidl compiler so that it's really size_t or PRSize
// and it's scriptable:
typedef unsigned long       size_t;

[ptr]         native voidPtr(void);
[ptr]         native charPtr(char);
[ptr]         native unicharPtr(PRUnichar);

[ref, nsid]   native nsIDRef(nsID);
[ref, nsid]   native nsIIDRef(nsIID);
[ref, nsid]   native nsCIDRef(nsCID);

[ptr, nsid]   native nsIDPtr(nsID);
[ptr, nsid]   native nsIIDPtr(nsIID);
[ptr, nsid]   native nsCIDPtr(nsCID);

// NOTE: Be careful in using the following 3 types. The *Ref and *Ptr variants 
// are more commonly used (and better supported). Those variants require 
// nsMemory alloc'd copies when used as 'out' params while these types do not. 
// However, currently these types can not be used for 'in' params. And, methods 
// that use them as 'out' params *must* be declared [notxpcom] (with an explicit 
// return type of nsresult). This makes such methods implicitly not scriptable.
// Use of these types in methods without a [notxpcom] declaration will cause
// the xpidl compiler to raise an error.
// See: http://bugzilla.mozilla.org/show_bug.cgi?id=93792

[nsid]        native nsIID(nsIID);
[nsid]        native nsID(nsID);
[nsid]        native nsCID(nsCID);

[ptr]         native nsQIResult(void);

[ref, domstring] native DOMString(ignored);
[ref, domstring] native DOMStringRef(ignored);
[ptr, domstring] native DOMStringPtr(ignored);

[ref, utf8string] native AUTF8String(ignored);
[ref, utf8string] native AUTF8StringRef(igPNG

   IHDR         ѓџa   sBIT|d   	pHYs    вн~ќ   tEXtSoftware Macromedia Fireworks 8Еhвx