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

cpp_quote("#if ( _MSC_VER >= 800 )")
cpp_quote("#pragma warning(disable:4201)")
cpp_quote("#endif")

#ifndef DO_NO_IMPORTS
import "unknwn.idl";
import "wtypes.idl";
import "prsht.idl";
#endif

cpp_quote("")
cpp_quote("EXTERN_C const CLSID CLSID_CNetCfg;")
cpp_quote("")

cpp_quote("#define NETCFG_E_ALREADY_INITIALIZED                 MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA020)")
cpp_quote("#define NETCFG_E_NOT_INITIALIZED                     MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA021)")
cpp_quote("#define NETCFG_E_IN_USE                              MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA022)")
cpp_quote("#define NETCFG_E_NO_WRITE_LOCK                       MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA024)")
cpp_quote("#define NETCFG_E_NEED_REBOOT                         MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA025)")
cpp_quote("#define NETCFG_E_ACTIVE_RAS_CONNECTIONS              MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA026)")
// THe network adapter does not exists in the system (Eisa and Mca)
cpp_quote("#define NETCFG_E_ADAPTER_NOT_FOUND                   MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA027)")
// The component was removed and cannot be added until the system is rebooted
cpp_quote("#define NETCFG_E_COMPONENT_REMOVED_PENDING_REBOOT    MAKE_HRESULT(SEVERITY_ERROR, FACILITY_ITF, 0xA028)")

cpp_quote("#define NETCFG_S_REBOOT                              MAKE_HRESULT(SEVERITY_SUCCESS, FACILITY_ITF, 0xA020)")
cpp_quote("#define NETCFG_S_DISABLE_QUERY                       MAKE_HRESULT(SEVERITY_SUCCESS, FACILITY_ITF, 0xA022)")
cpp_quote("#define NETCFG_S_STILL_REFERENCED                    MAKE_HRESULT(SEVERITY_SUCCESS, FACILITY_ITF, 0xA023)")
cpp_quote("#define NETCFG_S_CAUSED_SETUP_CHANGE                 MAKE_HRESULT(SEVERITY_SUCCESS, FACILITY_ITF, 0xA024)")

cpp_quote("")

cpp_quote("#define NETCFG_CLIENT_CID_MS_MSClient        TEXT(\"ms_msclient\")")
cpp_quote("#define NETCFG_SERVICE_CID_MS_SERVER         TEXT(\"ms_server\")")
cpp_quote("#define NETCFG_SERVICE_CID_MS_NETBIOS        TEXT(\"ms_netbios\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_APPLETALK        TEXT(\"ms_appletalk\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_NETBEUI          TEXT(\"ms_netbeui\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_NETMON           TEXT(\"ms_netmon\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_NWIPX            TEXT(\"ms_nwipx\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_NWSPX            TEXT(\"ms_nwspx\")")
cpp_quote("#define NETCFG_TRANS_CID_MS_TCPIP            TEXT(\"ms_tcpip\")")

// Reserved GUIDS for Microsoft use
//
// C0E8AE90-306E-11D1-AACF-00805FC1270E     IID_IEnumNetCfgBindingInterface
// C0E8AE91-306E-11D1-AACF-00805FC1270E     IID_IEnumNetCfgBindingPath
// C0E8AE92-306E-11D1-AACF-00805FC1270E     IID_IEnumNetCfgComponent
// C0E8AE93-306E-11D1-AACF-00805FC1270E     IID_INetCfg
// C0E8AE94-306E-11D1-AACF-00805FC1270E     IID_INetCfgBindingInterface
// C0E8AE95-306E-11D1-AACF-00805FC1270E     IID_INetCfgProperties
// C0E8AE96-306E-11D1-AACF-00805FC1270E     IID_INetCfgBindingPath
// C0E8AE97-306E-11D1-AACF-00805FC1270E     IID_INetCfgClass
// C0E8AE98-306E-11D1-AACF-00805FC1270E     (open)
// C0E8AE99-306E-11D1-AACF-00805FC1270E     IID_INetCfgComponent
// C0E8AE9A-306E-11D1-AACF-00805FC1270E     (open)
// C0E8AE9B-306E-11D1-AACF-00805FC1270E     (open)
// C0E8AE9C-306E-11D1-AACF-00805FC1270E     (open)

// C0E8AE9D-306E-11D1-AACF-00805FC1270E     IID_INetCfgClassSetup
// C0E8AE9E-306E-11D1-AACF-00805FC1270E     IID_INetCfgComponentBindings
// C0E8AE9F-306E-11D1-AACF-00805FC1270E     IID_INetCfgLock
// C0E8AEA0-306E-11D1-AACF-00805FC1270E
// C0E8AEA1-306E-11D1-AACF-00805FC1270E
// C0E8AEA2-306E-11D1-AACF-00805FC1270E
// C0E8AEA3-306E-11D1-AACF-00805FC1270E
// C0E8AEA4-306E-11D1-AACF-00805FC1270E
// C0E8AEA5-306E-11D1-AACF-00805FC1270E
// C0E8AEA6-306E-11D1-AACF-00805FC1270E
// C0E8AEA7-306E-11D1-AACF-00805FC1270E
// C0E8AEA8-306E-11D1-AACF-00805FC1270E
// C0E8AEA9-306E-11D1-AACF-00805FC1270E
// ...
// C0E8B266-306E-11D1-AACF-00805FC1270E
// C0E8B267-306E-11D1-AACF-00805FC1270E
// C0E8B268-306E-11D1-AACF-00805FC1270E


interface IEnumNetCfgBindingInterface;
interface IEnumNetCfgBindingPath;
interface IEnumNetCfgComponent;
interface INetCfg;
interface INetCfgProperties;
interface INetCfgLock;
interface INetCfgBindingInterface;
interface INetCfgBindingPath;
interface INetCfgComponentBindings;
interface INetCfgBindingPath;
interface INetCfgClass;
interface INetCfgComponent;
interface INetCfgIdentification;
interface INetCfgClassSetup;


//+---------------------------------------------------------------------------
// IEnumNetCfgBindingInterface -
[
    local,
    object,
    uuid(C0E8AE90-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface IEnumNetCfgBindingInterface : IUnknown
{
    HRESULT Next (
        [in] ULONG celt,
        [out, size_is(celt), length_is(*pceltFetched)]
        INetCfgBindingInterface** rgelt,
        [out] ULONG* pceltFetched);

    HRESULT Skip (
        [in] ULONG celt);

    HRESULT Reset ();

    HRESULT Clone (
        [out] IEnumNetCfgBindingInterface** ppenum);
};


//+---------------------------------------------------------------------------
// IEnumNetCfgBindingPath -
[
    local,
    object,
    uuid(C0E8AE91-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface IEnumNetCfgBindingPath : IUnknown
{
    HRESULT Next (
        [in] ULONG celt,
        [out, size_is(celt), length_is(*pceltFetched)]
        INetCfgBindingPath** rgelt,
        [out] ULONG* pceltFetched);

    HRESULT Skip (
        [in] ULONG celt);

    HRESULT Reset ();

    HRESULT Clone (
        [out] IEnumNetCfgBindingPath** ppenum);
};


//+---------------------------------------------------------------------------
// IEnumNetCfgComponent -
[
    local,
    object,
    uuid(C0E8AE92-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface IEnumNetCfgComponent : IUnknown
{
    HRESULT Next (
        [in] ULONG celt,
        [out, size_is(celt), length_is(*pceltFetched)]
        INetCfgComponent** rgelt,
        [out] ULONG* pceltFetched);

    HRESULT Skip (
        [in] ULONG celt);

    HRESULT Reset ();

    HRESULT Clone (
        [out] IEnumNetCfgComponent** ppenum);
};


//+---------------------------------------------------------------------------
// INetCfg -
[
    local,
    object,
    uuid(C0E8AE93-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfg : IUnknown
{
    HRESULT Initialize (
        [in] PVOID pvReserved);

    HRESULT Uninitialize ();

    HRESULT Apply ();

    HRESULT Cancel ();

    HRESULT EnumComponents (
        [in] const GUID* pguidClass,
        [out] IEnumNetCfgComponent** ppenumComponent);

    HRESULT FindComponent (
        [in, string] LPCWSTR pszwInfId,
        [out] INetCfgComponent** pComponent);

    HRESULT QueryNetCfgClass (
        [in] const GUID* pguidClass,
        [in] REFIID riid,
        [out, iid_is(riid)] void** ppvObject);
};


//+---------------------------------------------------------------------------
// INetCfgLock -
[
    local,
    object,
    uuid(C0E8AE9F-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgLock : IUnknown
{
    HRESULT AcquireWriteLock (
        [in] DWORD cmsTimeout,
        [in, string] LPCWSTR pszwClientDescription,
        [out, string] LPWSTR* ppszwClientDescription);

    HRESULT ReleaseWriteLock ();

    HRESULT IsWriteLocked (
        [out, string] LPWSTR* ppszwClientDescription);
};


//+---------------------------------------------------------------------------
// INetCfgBindingInterface -
[
    local,
    object,
    uuid(C0E8AE94-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgBindingInterface : IUnknown
{
    HRESULT GetName (
        [out, string] LPWSTR* ppszwInterfaceName);

    HRESULT GetUpperComponent (
        [out] INetCfgComponent** ppnccItem);

    HRESULT GetLowerComponent (
        [out] INetCfgComponent** ppnccItem);

};


//+---------------------------------------------------------------------------
// INetCfgBindingPath -
[
    local,
    object,
    uuid(C0E8AE96-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgBindingPath : IUnknown
{
    HRESULT IsSamePathAs (
        [in] INetCfgBindingPath* pPath);

    HRESULT IsSubPathOf (
        [in] INetCfgBindingPath* pPath);

    HRESULT IsEnabled ();

    HRESULT Enable (
        [in] BOOL fEnable);

    HRESULT GetPathToken(
        [out, string] LPWSTR* ppszwPathToken);

    HRESULT GetOwner (
        [out] INetCfgComponent** ppComponent);

    HRESULT GetDepth (
        [out] ULONG* pcInterfaces);

    HRESULT EnumBindingInterfaces (
        [out] IEnumNetCfgBindingInterface** ppenumInterface);
};


//+---------------------------------------------------------------------------
// INetCfgClass -
[
    local,
    object,
    uuid(C0E8AE97-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgClass : IUnknown
{
    HRESULT FindComponent (
        [in, string] LPCWSTR pszwInfId,
        [out] INetCfgComponent** ppnccItem);

    HRESULT EnumComponents (
        [out] IEnumNetCfgComponent** ppenumComponent);
};


//+---------------------------------------------------------------------------
// INetCfgClassSetup -
[
    local,
    object,
    uuid(C0E8AE9D-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgClassSetup : IUnknown
{
    typedef enum tagOBO_TOKEN_TYPE
    {
        OBO_USER        = 1,
        OBO_COMPONENT   = 2,
        OBO_SOFTWARE    = 3,
    } OBO_TOKEN_TYPE;

    typedef struct tagOBO_TOKEN
    {
        OBO_TOKEN_TYPE  Type;

        // Type == OBO_COMPONENT
        //
        INetCfgComponent*   pncc;

        // Type == OBO_SOFTWARE
        //
        LPCWSTR             pszwManufacturer;
        LPCWSTR             pszwProduct;
        LPCWSTR             pszwDisplayName;

        // The following fields must be initialized to zero
        // by users of OBO_TOKEN.
        //
        BOOL    fRegistered;
    } OBO_TOKEN;

    HRESULT SelectAndInstall (
        [in]  HWND                  hwndParent,
        [in]  OBO_TOKEN*            pOboToken,
        [out] INetCfgComponent**    ppnccItem);

    HRESULT Install (
        [in, string] LPCWSTR            pszwInfId,
        [in]         OBO_TOKEN*         pOboToken,
        [in]         DWORD              dwSetupFlags,
        [in]         DWORD              dwUpgradeFromBuildNo,
        [in, string] LPCWSTR            pszwAnswerFile,
        [in, string] LPCWSTR            pszwAnswerSections,
        [out]        INetCfgComponent** ppnccItem);

    HRESULT DeInstall (
        [in]  INetCfgComponent* pComponent,
        [in]  OBO_TOKEN*        pOboToken,
        [out] LPWSTR*           pmszwRefs);
};


//+---------------------------------------------------------------------------
// INetCfgComponent -
[
    local,
    object,
    uuid(C0E8AE99-306E-11D1-AACF-00805FC1270E),
    pointer_default(unique)
]
interface INetCfgComponent : IUnknown
{
    typedef enum tagCOMPONENT_CHARACTERISTICS
    {
        NCF_VIRTUAL                     = 0x00000001,
        NCF_SOFTWARE_ENUMERATED         = 0x00000002,
        NCF_PHYSICAL                    = 0x00000004,
        NCF_HIDDEN                      = 0x00000008,
        NCF_NO_SERVICE               