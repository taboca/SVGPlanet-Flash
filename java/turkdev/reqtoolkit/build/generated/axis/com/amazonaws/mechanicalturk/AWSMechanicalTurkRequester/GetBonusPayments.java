//
// Copyright (c) Microsoft Corporation.  All rights reserved.
//
//
// Use of this source code is subject to the terms of the Microsoft end-user
// license agreement (EULA) under which you licensed this SOFTWARE PRODUCT.
// If you did not accept the terms of the EULA, you are not authorized to use
// this source code. For a copy of the EULA, please see the LICENSE.RTF on your
// install media.
//

cpp_quote("//")
cpp_quote("// Copyright (c) Microsoft Corporation.  All rights reserved.")
cpp_quote("//")
cpp_quote("//")
cpp_quote("// Use of this source code is subject to the terms of the Microsoft end-user")
cpp_quote("// license agreement (EULA) under which you licensed this SOFTWARE PRODUCT.")
cpp_quote("// If you did not accept the terms of the EULA, you are not authorized to use")
cpp_quote("// this source code. For a copy of the EULA, please see the LICENSE.RTF on your")
cpp_quote("// install media.")
cpp_quote("//")

//+---------------------------------------------------------------------------
//
//
//  Contents:   async moniker interfaces
//
//  Classes:
//
//  Functions:
//
//
//----------------------------------------------------------------------------

cpp_quote("")
cpp_quote("#pragma comment(lib,\"uuid.lib\")")
cpp_quote("")
cpp_quote("//---------------------------------------------------------------------------=")
cpp_quote("// URL Moniker Interfaces.")
cpp_quote("")

typedef unsigned long HANDLE_PTR;

import "objidl.idl";
import "oleidl.idl";
import "servprov.idl";
import "msxml2.idl";

interface IPersistMoniker;
interface IBindProtocol;
interface IBinding;
interface IBindStatusCallback;
interface IBindStatusCallbackMsg;
interface IAuthenticate;
interface IWindowForBindingUI;
interface ICodeInstall;
interface IHttpNegotiate;
interface IHttpNegotiate2;

cpp_quote("// Side-by-Side clsid")
cpp_quote("EXTERN_C const IID CLSID_SBS_StdURLMoniker;  ")
cpp_quote("EXTERN_C const IID CLSID_SBS_HttpProtocol;   ")
cpp_quote("EXTERN_C const IID CLSID_SBS_FtpProtocol;    ")
cpp_quote("EXTERN_C const IID CLSID_SBS_GopherProtocol; ")
cpp_quote("EXTERN_C const IID CLSID_SBS_HttpSProtocol;  ")
cpp_quote("EXTERN_C const IID CLSID_SBS_FileProtocol;   ")
cpp_quote("EXTERN_C const IID CLSID_SBS_MkProtocol;     ")
cpp_quote("EXTERN_C const IID CLSID_SBS_UrlMkBindCtx;   ")
cpp_quote("EXTERN_C const IID CLSID_SBS_SoftDistExt;  ")
cpp_quote("EXTERN_C const IID CLSID_SBS_StdEncodingFilterFac; ")
cpp_quote("EXTERN_C const IID CLSID_SBS_DeCompMimeFilter;     ")
cpp_quote("EXTERN_C const IID CLSID_SBS_CdlProtocol;          ")
cpp_quote("EXTERN_C const IID CLSID_SBS_ClassInstallFilter;   ")
cpp_quote("EXTERN_C const IID CLSID_SBS_InternetSecurityManager;  ")
cpp_quote("EXTERN_C const IID CLSID_SBS_InternetZoneManager;  ")
cpp_quote("// END Side-by-Side clsid")


cpp_quote("// These are for backwards compatibility with previous URLMON versions")
cpp_quote("#define BINDF_DONTUSECACHE BINDF_GETNEWESTVERSION")
cpp_quote("#define BINDF_DONTPUTINCACHE BINDF_NOWRITECACHE")
cpp_quote("#define BINDF_NOCOPYDATA BINDF_PULLDATA")
cpp_quote("#define INVALID_P_ROOT_SECURITY_ID ((BYTE*)-1)")

cpp_quote("#define PI_DOCFILECLSIDLOOKUP PI_CLSIDLOOKUP")

cpp_quote("EXTERN_C const IID IID_IAsyncMoniker;    ")
cpp_quote("EXTERN_C const IID CLSID_StdURLMoniker;  ")
cpp_quote("EXTERN_C const IID CLSID_HttpProtocol;   ")
cpp_quote("EXTERN_C const IID CLSID_FtpProtocol;    ")
cpp_quote("EXTERN_C const IID CLSID_GopherProtocol; ")
cpp_quote("EXTERN_C const IID CLSID_HttpSProtocol;  ")
cpp_quote("EXTERN_C const IID CLSID_FileProtocol;   ")
cpp_quote("EXTERN_C const IID CLSID_MkProtocol;     ")
cpp_quote("EXTERN_C const IID CLSID_StdURLProtocol; ")
cpp_quote("EXTERN_C const IID CLSID_UrlMkBindCtx;   ")
cpp_quote("EXTERN_C const IID CLSID_StdEncodingFilterFac; ")
cpp_quote("EXTERN_C const IID CLSID_DeCompMimeFilter;     ")
cpp_quote("EXTERN_C const IID CLSID_CdlProtocol;          ")
cpp_quote("EXTERN_C const IID CLSID_ClassInstallFilter;   ")
cpp_quote("EXTERN_C const IID IID_IAsyncBindCtx;    ")

// Class Store types

//
// Platform/Architecture Definition
//
    typedef struct tagCSPLATFORM
    {
        DWORD dwPlatformId;     // This is the OS Platform
        DWORD dwVersionHi;      // Major Version of OS
        DWORD dwVersionLo;      // Minor Version of OS
        DWORD dwProcessorArch;  // This is the Processor Architecure
    } CSPLATFORM;

//
// Query Context Structure
// This contains a list of attributes used to look up a class implementation
//
    typedef struct tagQUERYCONTEXT {
          DWORD      dwContext;         // Execution context
          CSPLATFORM Platform;          // Client Platform/Architecture
          LCID       Locale;            // Locale ID
          DWORD      dwVersionHi;       // Low Version number
          DWORD      dwVersionLo;       // Hi Version number
    } QUERYCONTEXT;


//
// Class Specifier structure
// All means of mapping to a Class ID
// (Union of CLSID, File Extension, ProgId, MimeType, File Ext)
//

    typedef [v1_enum] enum tagTYSPEC {
        TYSPEC_CLSID,
        TYSPEC_FILEEXT,
        TYSPEC_MIMETYPE,
        TYSPEC_FILENAME,
        TYSPEC_PROGID,
        TYSPEC_PACKAGENAME,
        TYSPEC_OBJECTID
    } TYSPEC;

    typedef union switch(DWORD tyspec)
        {
        case TYSPEC_CLSID:
            CLSID   clsid;
        case TYSPEC_FILEEXT:
            LPOLESTR pFileExt;
        case TYSPEC_MIMETYPE:
            LPOLESTR pMimeType;
        case TYSPEC_PROGID:
            LPOLESTR pProgId;
        case TYSPEC_FILENAME:
            LPOLESTR pFileName;
        case TYSPEC_PACKAGENAME:
            struct {
            LPOLESTR pPackageName;
            GUID     PolicyId;
            } ByName;
        case TYSPEC_OBJECTID:
            struct {
            GUID     ObjectId;
            GUID     PolicyId;
            } ByObjectId;
    } uCLSSPEC;

#pragma midl_echo(" ")
#pragma midl_echo("#define SZ_URLCONTEXT           OLESTR(\"URL Context\")")
#pragma midl_echo("#define SZ_ASYNC_CALLEE         OLESTR(\"AsyncCallee\")")

#pragma midl_echo("#define MKSYS_URLMONIKER         6            ")
#pragma midl_echo("#define URL_MK_LEGACY            0            ")
#pragma midl_echo("#define URL_MK_UNIFORM           1            ")
#pragma midl_echo("#define URL_MK_NO_CANONICALIZE   2            ")
#pragma midl_echo(" ")
#pragma midl_echo("STDAPI CreateURLMoniker(LPMONIKER pMkCtx, LPCWSTR szURL, LPMONIKER FAR * ppmk);             ")
#pragma midl_echo("STDAPI CreateURLMonikerEx(LPMONIKER pMkCtx, LPCWSTR szURL, LPMONIKER FAR * ppmk, DWORD dwFlags);             ")
#pragma midl_echo("STDAPI GetClassURL(LPCWSTR szURL, CLSID *pClsID);                                           ")
#pragma midl_echo("STDAPI CreateAsyncBindCtx(DWORD reserved, IBindStatusCallback *pBSCb,                       ")
#pragma midl_echo("                                IEnumFORMATETC *pEFetc, IBindCtx **ppBC);                   ")

#pragma midl_echo("STDAPI CreateAsyncBindCtxEx(IBindCtx *pbc, DWORD dwOptions, IBindStatusCallback *pBSCb, IEnumFORMATETC *pEnum,   ")
#pragma midl_echo("                            IBindCtx **ppBC, DWORD reserved);                                                     ")

#pragma midl_echo("STDAPI MkParseDisplayNameEx(IBindCtx *pbc, LPCWSTR szDisplayName, ULONG *pchEaten,          ")
#pragma midl_echo("                                LPMONIKER *ppmk);                                           ")
#pragma midl_echo("STDAPI RegisterBindStatusCallback(LPBC pBC, IBindStatusCallback *pBSCb,                     ")
#pragma midl_echo("                                IBindStatusCallback**  ppBSCBPrev, DWORD dwReserved);       ")
#pragma midl_echo("STDAPI RevokeBindStatusCallback(LPBC pBC, IBindStatusCallback *pBSCb);                      ")

#pragma midl_echo("STDAPI GetClassFileOrMime(LPBC pBC, LPCWSTR szFilename, LPVOID pBuffer, DWORD cbSize, LPCWSTR szMime, DWORD dwReserved, CLSID *pclsid); ")
#pragma midl_echo("STDAPI IsValidURL(LPBC pBC, LPCWSTR szURL, DWORD dwReserved);                               ")


#pragma midl_echo("STDAPI CoGetClassObjectFromURL( REFCLSID rCLASSID,")
#pragma midl_echo("            LPCWSTR szCODE, DWORD dwFileVersionMS, ")
#pragma midl_echo("            DWORD dwFileVersionLS, LPCWSTR szTYPE,")
#pragma midl_echo("            LPBINDCTX pBindCtx, DWORD dwClsContext,")
#pragma midl_echo("            LPVOID pvReserved, REFIID riid, LPVOID * ppv);")

#pragma midl_echo("STDAPI FaultInIEFeature( HWND hWnd,")
#pragma midl_echo("            uCLSSPEC *pClassSpec,")
#pragma midl_echo("            QUERYCONTEXT *pQuery, DWORD dwFlags);                                           ")

#pragma midl_echo("STDAPI GetComponentIDFromCLSSPEC(uCLSSPEC *pClassspec,")
#pragma midl_echo("             LPSTR * ppszComponentID);                                                      ")

#pragma midl_echo("// flags for FaultInIEFeature")
#pragma midl_echo("#define FIEF_FLAG_FORCE_JITUI               0x1     // force JIT ui even if")
#pragma midl_echo("                                                 // previoulsy rejected by ")
#pragma midl_echo("                                                 // user in this session or")
#pragma midl_echo("                                                 // marked as Never Ask Again")
#pragma midl_echo("#define FIEF_FLAG_PEEK                      0x2     // just peek, don't faultin")
#pragma midl_echo("#define FIEF_FLAG_SKIP_INSTALLED_VERSION_CHECK        0x4     // force JIT without checking local version")



#pragma midl_echo(" ")
#pragma midl_echo("//helper apis                                                                               ")
#pragma midl_echo("STDAPI IsAsyncMoniker(IMoniker* pmk);                                                       ")
#pragma midl_echo("STDAPI CreateURLBinding(LPCWSTR lpszUrl, IBindCtx *pbc, IBinding **ppBdg);                  ")
#pragma midl_echo(" ")
#pragma midl_echo("STDAPI RegisterMediaTypes(UINT ctypes, const LPCSTR* rgszTypes, CLIPFORMAT* rgcfTypes);            ")
#pragma midl_echo("STDAPI FindMediaType(LPCSTR rgszTypes, CLIPFORMAT* rgcfTypes);                                       ")
#pragma midl_echo("STDAPI CreateFormatEnumerator( UINT cfmtetc, FORMATETC* rgfmtetc, IEnumFORMATETC** ppenumfmtetc); ")
#pragma midl_echo("STDAPI RegisterFormatEnumerator(LPBC pBC, IEnumFORMATETC *pEFetc, DWORD reserved);          ")
#pragma midl_echo("STDAPI RevokeFormatEnumerator(LPBC pBC, IEnumFORMATETC *pEFetc);                            ")
#pragma midl_echo("STDAPI RegisterMediaTypeClass(LPBC pBC,UINT ctypes, const LPCSTR* rgszTypes, CLSID *rgclsID, DWORD reserved);    ")
#pragma midl_echo("STDAPI FindMediaTypeClass(LPBC pBC, LPCSTR szType, CLSID *pclsID, DWORD reserved);                          ")
#pragma midl_echo("STDAPI UrlMkSetSessionOption(DWORD dwOption, LPVOID pBuffer, DWORD dwBufferLength, DWORD dwReserved);       ")
#pragma midl_echo("STDAPI UrlMkGetSessionOption(DWORD dwOption, LPVOID pBuffer, DWORD dwBufferLength, DWORD *pdwBufferLength, DWORD dwReserved);       ")

#pragma midl_echo("STDAPI FindMimeFromData(                                                                                                                  ")
#pragma midl_echo("                        LPBC pBC,                           // bind context - can be NULL                                                 ")
#pragma midl_echo("                        LPCWSTR pwzUrl,                     // url - can be null                                                          ")
#pragma midl_echo("                        LPVOID pBuffer,                     // buffer with data to sniff - can be null (pwzUrl must be valid)             ")
#pragma midl_echo("                        DWORD cbSize,                       // size of buffer                                                             ")
#pragma midl_echo("                        LPCWSTR pwzMimeProposed,            // proposed mime if - can be null                                             ")
#pragma midl_echo("                        DWORD dwMimeFlags,                  // will be defined                                                            ")
#pragma midl_echo("                        LPWSTR *ppwzMimeOut,                // the suggested mime                                                         ")
#pragma midl_echo("                        DWORD dwReserved);                  // must be 0                      