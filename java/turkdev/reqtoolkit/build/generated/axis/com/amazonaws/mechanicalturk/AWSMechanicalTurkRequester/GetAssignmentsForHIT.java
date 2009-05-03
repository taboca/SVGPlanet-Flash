ssible_get_accKeyboardShortcut_Proxy( 
    IAccessible * This,
    /* [optional][in] */ VARIANT varChild,
    /* [retval][out] */ BSTR *pszKeyboardShortcut);


void __RPC_STUB IAccessible_get_accKeyboardShortcut_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_get_accFocus_Proxy( 
    IAccessible * This,
    /* [retval][out] */ VARIANT *pvarChild);


void __RPC_STUB IAccessible_get_accFocus_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_get_accSelection_Proxy( 
    IAccessible * This,
    /* [retval][out] */ VARIANT *pvarChildren);


void __RPC_STUB IAccessible_get_accSelection_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propget][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_get_accDefaultAction_Proxy( 
    IAccessible * This,
    /* [optional][in] */ VARIANT varChild,
    /* [retval][out] */ BSTR *pszDefaultAction);


void __RPC_STUB IAccessible_get_accDefaultAction_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_accSelect_Proxy( 
    IAccessible * This,
    /* [in] */ long flagsSelect,
    /* [optional][in] */ VARIANT varChild);


void __RPC_STUB IAccessible_accSelect_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_accLocation_Proxy( 
    IAccessible * This,
    /* [out] */ long *pxLeft,
    /* [out] */ long *pyTop,
    /* [out] */ long *pcxWidth,
    /* [out] */ long *pcyHeight,
    /* [optional][in] */ VARIANT varChild);


void __RPC_STUB IAccessible_accLocation_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_accNavigate_Proxy( 
    IAccessible * This,
    /* [in] */ long navDir,
    /* [optional][in] */ VARIANT varStart,
    /* [retval][out] */ VARIANT *pvarEndUpAt);


void __RPC_STUB IAccessible_accNavigate_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_accHitTest_Proxy( 
    IAccessible * This,
    /* [in] */ long xLeft,
    /* [in] */ long yTop,
    /* [retval][out] */ VARIANT *pvarChild);


void __RPC_STUB IAccessible_accHitTest_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_accDoDefaultAction_Proxy( 
    IAccessible * This,
    /* [optional][in] */ VARIANT varChild);


void __RPC_STUB IAccessible_accDoDefaultAction_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_put_accName_Proxy( 
    IAccessible * This,
    /* [optional][in] */ VARIANT varChild,
    /* [in] */ BSTR szName);


void __RPC_STUB IAccessible_put_accName_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);


/* [id][propput][hidden] */ HRESULT STDMETHODCALLTYPE IAccessible_put_accValue_Proxy( 
    IAccessible * This,
    /* [optional][in] */ VARIANT varChild,
    /* [in] */ BSTR szValue);


void __RPC_STUB IAccessible_put_accValue_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IAccessible_INTERFACE_DEFINED__ */


#ifndef __IAccessibleHandler_INTERFACE_DEFINED__
#define __IAccessibleHandler_INTERFACE_DEFINED__

/* interface IAccessibleHandler */
/* [unique][oleautomation][hidden][uuid][object] */ 

typedef /* [unique] */ IAccessibleHandler *LPACCESSIBLEHANDLER;


EXTERN_C const IID IID_IAccessibleHandler;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("03022430-ABC4-11d0-BDE2-00AA001A1953")
    IAccessibleHandler : public IUnknown
    {
    public:
        virtual HRESULT STDMETHODCALLTYPE AccessibleObjectFromID( 
            /* [in] */ long hwnd,
            /* [in] */ long lObjectID,
            /* [out] */ LPACCESSIBLE *pIAccessible) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IAccessibleHandlerVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE *QueryInterface )( 
            IAccessibleHandler * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void **ppvObject);
        
        ULONG ( STDMETHODCALLTYPE *AddRef )( 
            IAccessibleHandler * This);
        
        ULONG ( STDMETHODCALLTYPE *Release )( 
            IAccessibleHandler * This);
        
        HRESULT ( STDMETHODCALLTYPE *AccessibleObjectFromID )( 
            IAccessibleHandler * This,
            /* [in] */ long hwnd,
            /* [in] */ long lObjectID,
            /* [out] */ LPACCESSIBLE *pIAccessible);
        
        END_INTERFACE
    } IAccessibleHandlerVtbl;

    interface IAccessibleHandler
    {
        CONST_VTBL struct IAccessibleHandlerVtbl *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IAccessibleHandler_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IAccessibleHandler_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IAccessibleHandler_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IAccessibleHandler_AccessibleObjectFromID(This,hwnd,lObjectID,pIAccessible)	\
    (This)->lpVtbl -> AccessibleObjectFromID(This,hwnd,lObjectID,pIAccessible)

#endif /* COBJMACROS */


#endif 	/* C style interface */



HRESULT STDMETHODCALLTYPE IAccessibleHandler_AccessibleObjectFromID_Proxy( 
    IAccessibleHandler * This,
    /* [in] */ long hwnd,
    /* [in] */ long lObjectID,
    /* [out] */ LPACCESSIBLE *pIAccessible);


void __RPC_STUB IAccessibleHandler_AccessibleObjectFromID_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IAccessibleHandler_INTERFACE_DEFINED__ */


/* interface __MIDL_itf_oleacc_0116 */
/* [local] */ 

typedef 
enum AnnoScope
    {	ANNO_THIS	= 0,
	ANNO_CONTAINER	= 1
    } 	AnnoScope;

typedef GUID MSAAPROPID;



extern RPC_IF_HANDLE __MIDL_itf_oleacc_0116_v0_0_c_ifspec;
extern RPC_IF_HANDLE __MIDL_itf_oleacc_0116_v0_0_s_ifspec;

#ifndef __IAccIdentity_INTERFACE_DEFINED__
#define __IAccIdentity_INTERFACE_DEFINED__

/* interface IAccIdentity */
/* [unique][uuid][object] */ 


EXTERN_C const IID IID_IAccIdentity;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("7852b78d-1cfd-41c1-a615-9c0c85960b5f")
    IAccIdentity : public IUnknown
    {
    public:
        virtual HRESULT STDMETHODCALLTYPE GetIdentityString( 
            /* [in] */ DWORD dwIDChild,
            /* [size_is][size_is][out] */ BYTE **ppIDString,
            /* [out] */ DWORD *pdwIDStringLen) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IAccIdentityVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE *QueryInterface )( 
            IAccIdentity * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void **ppvObject);
        
        ULONG ( STDMETHODCALLTYPE *AddRef )( 
            IAccIdentity * This);
        
        ULONG ( STDMETHODCALLTYPE *Release )( 
            IAccIdentity * This);
        
        HRESULT ( STDMETHODCALLTYPE *GetIdentityString )( 
            IAccIdentity * This,
            /* [in] */ DWORD dwIDChild,
            /* [size_is][size_is][out] */ BYTE **ppIDString,
            /* [out] */ DWORD *pdwIDStringLen);
        
        END_INTERFACE
    } IAccIdentityVtbl;

    interface IAccIdentity
    {
        CONST_VTBL struct IAccIdentityVtbl *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IAccIdentity_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IAccIdentity_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IAccIdentity_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IAccIdentity_GetIdentityString(This,dwIDChild,ppIDString,pdwIDStringLen)	\
    (This)->lpVtbl -> GetIdentityString(This,dwIDChild,ppIDString,pdwIDStringLen)

#endif /* COBJMACROS */


#endif 	/* C style interface */



HRESULT STDMETHODCALLTYPE IAccIdentity_GetIdentityString_Proxy( 
    IAccIdentity * This,
    /* [in] */ DWORD dwIDChild,
    /* [size_is][size_is][out] */ BYTE **ppIDString,
    /* [out] */ DWORD *pdwIDStringLen);


void __RPC_STUB IAccIdentity_GetIdentityString_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IAccIdentity_INTERFACE_DEFINED__ */


#ifndef __IAccPropServer_INTERFACE_DEFINED__
#define __IAccPropServer_INTERFACE_DEFINED__

/* interface IAccPropServer */
/* [unique][uuid][object] */ 


EXTERN_C const IID IID_IAccPropServer;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("76c0dbbb-15e0-4e7b-b61b-20eeea2001e0")
    IAccPropServer : public IUnknown
    {
    public:
        virtual HRESULT STDMETHODCALLTYPE GetPropValue( 
            /* [size_is][in] */ const BYTE *pIDString,
            /* [in] */ DWORD dwIDStringLen,
            /* [in] */ MSAAPROPID idProp,
            /* [out] */ VARIANT *pvarValue,
            /* [out] */ BOOL *pfHasProp) = 0;
        
    };
    
#else 	/* C style interface */

    typedef struct IAccPropServerVtbl
    {
        BEGIN_INTERFACE
        
        HRESULT ( STDMETHODCALLTYPE *QueryInterface )( 
            IAccPropServer * This,
            /* [in] */ REFIID riid,
            /* [iid_is][out] */ void **ppvObject);
        
        ULONG ( STDMETHODCALLTYPE *AddRef )( 
            IAccPropServer * This);
        
        ULONG ( STDMETHODCALLTYPE *Release )( 
            IAccPropServer * This);
        
        HRESULT ( STDMETHODCALLTYPE *GetPropValue )( 
            IAccPropServer * This,
            /* [size_is][in] */ const BYTE *pIDString,
            /* [in] */ DWORD dwIDStringLen,
            /* [in] */ MSAAPROPID idProp,
            /* [out] */ VARIANT *pvarValue,
            /* [out] */ BOOL *pfHasProp);
        
        END_INTERFACE
    } IAccPropServerVtbl;

    interface IAccPropServer
    {
        CONST_VTBL struct IAccPropServerVtbl *lpVtbl;
    };

    

#ifdef COBJMACROS


#define IAccPropServer_QueryInterface(This,riid,ppvObject)	\
    (This)->lpVtbl -> QueryInterface(This,riid,ppvObject)

#define IAccPropServer_AddRef(This)	\
    (This)->lpVtbl -> AddRef(This)

#define IAccPropServer_Release(This)	\
    (This)->lpVtbl -> Release(This)


#define IAccPropServer_GetPropValue(This,pIDString,dwIDStringLen,idProp,pvarValue,pfHasProp)	\
    (This)->lpVtbl -> GetPropValue(This,pIDString,dwIDStringLen,idProp,pvarValue,pfHasProp)

#endif /* COBJMACROS */


#endif 	/* C style interface */



HRESULT STDMETHODCALLTYPE IAccPropServer_GetPropValue_Proxy( 
    IAccPropServer * This,
    /* [size_is][in] */ const BYTE *pIDString,
    /* [in] */ DWORD dwIDStringLen,
    /* [in] */ MSAAPROPID idProp,
    /* [out] */ VARIANT *pvarValue,
    /* [out] */ BOOL *pfHasProp);


void __RPC_STUB IAccPropServer_GetPropValue_Stub(
    IRpcStubBuffer *This,
    IRpcChannelBuffer *_pRpcChannelBuffer,
    PRPC_MESSAGE _pRpcMessage,
    DWORD *_pdwStubPhase);



#endif 	/* __IAccPropServer_INTERFACE_DEFINED__ */


#ifndef __IAccPropServices_INTERFACE_DEFINED__
#define __IAccPropServices_INTERFACE_DEFINED__

/* interface IAccPropServices */
/* [unique][uuid][object] */ 


EXTERN_C const IID IID_IAccPropServices;

#if defined(__cplusplus) && !defined(CINTERFACE)
    
    MIDL_INTERFACE("6e26e776-04f0-495d-80e4-3330352e3169")
    IAcc