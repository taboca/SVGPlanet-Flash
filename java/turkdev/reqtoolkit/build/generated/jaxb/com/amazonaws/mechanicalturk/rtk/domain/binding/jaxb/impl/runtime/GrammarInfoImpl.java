cpp_quote("/*******************************************************************************/" )
cpp_quote("/*                                                                             */" )
cpp_quote("/*    Copyright © Microsoft Corporation.  All rights reserved.                 */" )
cpp_quote("/*                                                                             */" )
           /*    WBEMPROV.IDL                                                             */
           /*                                                                             */
cpp_quote("/*    This IDL file defines the interfaces that WBEM providers need in         */" )
cpp_quote("/*    addition to the client interfaces defined in WBEMCLI.IDL                 */" )
cpp_quote("/*                                                                             */" )
cpp_quote("/*******************************************************************************/" )

import "objidl.idl";
import "oleidl.idl";
import "oaidl.idl";
import "wbemcli.idl";


typedef VARIANT WBEM_VARIANT;
typedef [string] WCHAR* WBEM_WSTR;
typedef [string] const WCHAR* WBEM_CWSTR;

typedef [v1_enum] enum tag_WBEM_PROVIDER_REQUIREMENTS_TYPE
{
    WBEM_REQUIREMENTS_START_POSTFILTER = 0,
    WBEM_REQUIREMENTS_STOP_POSTFILTER = 1,
    WBEM_REQUIREMENTS_RECHECK_SUBSCRIPTIONS = 2
} WBEM_PROVIDER_REQUIREMENTS_TYPE;

[uuid(092df710-7010-11d1-ad90-00c04fd8fdff)]
library WbemProviders_v1
{
    interface IWbemPropertyProvider;
    interface IWbemUnboundObjectSink;
    interface IWbemEventProvider;
    interface IWbemEventProviderQuerySink;
    interface IWbemEventProviderSecurity;
    interface IWbemEventConsumerProvider;

    interface IWbemProviderInitSink;
    interface IWbemProviderInit;
    interface IWbemHiPerfProvider;

	interface IWbemDecoupledRegistrar ;

    /////////////////////////////////////////////////////////////////
    //

    [uuid(cb8555cc-9128-11d1-ad9b-00c04fd8fdff)]
    coclass WbemAdministrativeLocator
    {
        interface IWbemLocator;
    };

	// this assumes that the transport has verified that
	// the user has access.  Unlike the Administrative locator,
	// it increases the count of external connections

    [uuid(cd184336-9128-11d1-ad9b-00c04fd8fdff)]
    coclass WbemAuthenticatedLocator
    {
        interface IWbemLocator;
    };

	// this is used by providers who dont know if a user
	// has access or not.

    [uuid(443E7B79-DE31-11d2-B340-00104BCC4B4A)]
    coclass WbemUnauthenticatedLocator
    {
        interface IWbemLocator;
    };

	// this is used by providers that do not wish to be instantiated
	// by winmgmt, rather the provider registers it's participation 
	// in servicing client requests as and when desired. This is 
	// primarily used by providers that act on the part of application
	// hosts and that export management information only when they are activated
	// via some application scenario. 

    [uuid(4cfc7932-0f9d-4bef-9c32-8ea2a6b56fcb)]
    coclass WbemDecoupledRegistrar
    {
        interface IWbemDecoupledRegistrar ;
    };

    [uuid(f5f75737-2843-4f22-933d-c76a97cda62f)]
    coclass WbemDecoupledBasicEventProvider
    {
        interface IWbemDecoupledBasicEventProvider ;
    };


};

#define OPTIONAL in, unique

[restricted, object, uuid(e246107b-b06e-11d0-ad61-00c04fd8fdff)]
interface IWbemUnboundObjectSink : IUnknown
{
    HRESULT IndicateToConsumer(
        [in] IWbemClassObject* pLogicalConsumer,
        [in] long lNumObjects,
        [in, size_is(lNumObjects)] IWbemClassObject** apObjects);
};


/////////////////////////////////////////////////////////////////
//
//

[restricted, object, uuid(CE61E841-65BC-11d0-B6BD-00AA003240C7)]

interface IWbemPropertyProvider : IUnknown
{
    HRESULT GetProperty(
        [in] long lFlags,
        [in] const BSTR strLocale,
        [in] const BSTR strClassMapping,
        [in] const BSTR strInstMapping,
        [in] const BSTR strPropMapping,
        [out] VARIANT* pvValue
        );
        
    HRESULT PutProperty(
        [in] long lFlags,
        [in] const BSTR strLocale,
        [in] const BSTR strClassMapping,
        [in] const BSTR strInstMapping,
        [in] const BSTR strPropMapping,
        [in] const VARIANT* pvValue
        );        
};

[restricted, object, uuid(e245105b-b06e-11d0-ad61-00c04fd8fdff)]
interface IWbemEventProvider : IUnknown
{
    HRESULT ProvideEvents(
                [in] IWbemObjectSink* pSink,
                [in] long lFlags
            );
};

[restricted, object, uuid(580acaf8-fa1c-11d0-ad72-00c04fd8fdff)]
interface IWbemEventProviderQuerySink : IUnknown
{
    HRESULT NewQuery(
                [in] unsigned long dwId,
                [in] WBEM_WSTR wszQueryLanguage,
                [in] WBEM_WSTR wszQuery
            );
    HRESULT CancelQuery(
                [in] unsigned long dwId);
};

[restricted, object, uuid(631f7d96-d993-11d2-b339-00105a1f4aaf)]
interface IWbemEventProviderSecurity : IUnknown
{
    HRESULT AccessCheck(
                [in] WBEM_CWSTR wszQueryLanguage,
                [in] WBEM_CWSTR wszQuery,
                [in] long lSidLength,
                [in, size_is(lSidLength), unique] const BYTE* pSid);
};

[restricted, object, uuid(631f7d97-d993-11d2-b339-00105a1f4aaf)]
interface IWbemProviderIdentity : IUnknown
{
    HRESULT SetRegistrationObject(
                [in] long lFlags,
                [in] IWbemClassObject* pProvReg);
};


[restricted, object, uuid(e246107a-b06e-11d0-ad61-00c04fd8fdff)]
interface IWbemEventConsumerProvider : IUnknown
{
     HRESULT FindConsumer(
                [in] IWbemClassObject* pLogicalConsumer,
                [out] IWbemUnboundObjectSink** ppConsumer);
};

typedef enum tag_WBEM_EXTRA_RETURN_CODES
{
    WBEM_S_INITIALIZED = 0,
    WBEM_S_LIMITED_SERVICE = 0x43001,
    WBEM_S_INDIRECTLY_UPDATED,
    WBEM_S_SUBJECT_TO_SDS,
    

    WBEM_E_RETRY_LATER = 0x80043001,
    WBEM_E_RESOURCE_CONTENTION,
} WBEM_EXTRA_RETURN_CODES;

typedef enum tag_WBEM_PROVIDER_FLAGS
{
    WBEM_FLAG_OWNER_UPDATE = 0x10000,
} WBEM_PROVIDER_FLAGS;



[object, uuid(1be41571-91dd-11d1-aeb2-00c04fb68820)]

interface IWbemProviderInitSink : IUnknown
{
    HRESULT SetStatus(
        [in] LONG lStatus,
        [in] LONG 