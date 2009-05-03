nPinTypeUnknown,             /* Unknown PIN type                    */
    WwanPinTypeNone,                /* no PIN is needed                    */
    WwanPinTypeSubsidyLock,         /* subsidy unlock code                 */
    WwanPinTypePin,                 /* awaiting PIN entry                  */
    WwanPinTypePuk,                 /* awaiting PUK entry                  */
    WwanPinTypePin2,                /* awaiting PIN2 entry                 */
    WwanPinTypePuk2,                /* awaiting PUK2 entry                 */
    WwanPinTypeNetworkPassword,     /* awaiting network password           */
    WwanPinTypeDevicePassword,      /* awaiting device password            */
    WwanPinTypeMax
}
WWAN_PIN_TYPE;


typedef enum _WWAN_PIN_FORMAT
{
    WwanPinFormatUnknown,           /* format of needed pin is unknown     */
    WwanPinFormatNumeric,           /* allow characters 0-9,*,#            */
    WwanPinFormatAlphaNumeric,      /* allow characters a-z, A-Z, 0-9,*,#  */
    WwanPinFormatMax
}
WWAN_PIN_FORMAT;


typedef struct _WWAN_PIN_STATE
{
    WWAN_PIN_TYPE   PinType;            /* A WWAN_SIM_FLAG value           */
    WWAN_PIN_FORMAT PinFormat;          /* Numeric, aplhanumeric, etc.     */
    ULONG           PinLengthMin;       /* Minimum number of characters    */
    ULONG           PinLengthMax;       /* Maximum number of characters    */
    ULONG           AttemptsRemaining;  /* # of attempts remaining         */
}
WWAN_PIN_STATE;


typedef enum _WWAN_PIN_ACTION
{
    WwanPinActionUnknown,
    WwanPinActionSend,
    WwanPinActionEnable,
    WwanPinActionDisable,
    WwanPinActionChange,
    WwanPinActionCancel,
    WwanPinActionMax
}
WWAN_PIN_ACTION;


typedef struct _WWAN_SET_PIN
{
    WWAN_PIN_ACTION PinAction;              /* A WWAN_PIN_ACTION value     */
    WWAN_PIN_TYPE   PinType;                /* A WWAN_PIN_TYPE value       */
    WCHAR           Pin[WWAN_PIN_LEN];      /* Null-term'd PIN             */
    WCHAR           NewPin[WWAN_PIN_LEN];   /* Null-term'd new PIN/PUK     */
}
WWAN_SET_PIN;


typedef enum _WWAN_PROVIDER_STATE
{
    WwanProviderStateUnknown,
    WwanProviderStateForbidden,
    WwanProviderStateAvailable,
    WwanProviderStatePreferred,
    WwanProviderStateCurrent,
    WwanProviderStateMax
}
WWAN_PROVIDER_STATE;


typedef struct _WWAN_PROVIDER
{
    ULONG   ProviderId;             /* Provider ID                         */
    WWAN_PROVIDER_STATE State;      /* WWAN_PROVIDER_STATE_ value          */
    WCHAR   Name[WWAN_PROVIDERNAME_LEN]; /* Null-term'd provider name str  */
}
WWAN_PROVIDER;


typedef struct _WWAN_PROVIDER_LIST
{
    ULONG   ProviderCount;          /* Number of providers in the array    */
    ULONG   ProviderListSize;       /* Size and offset to an array of      */
    ULONG   ProviderListOffset;     /* WWAN_PROVIDER entries               */
}
WWAN_PROVIDER_LIST;


typedef enum _WWAN_REGISTER_MODE
{
    WwanRegisterModeUnknown,
    WwanRegisterModeReregister,     /* Reregister to the registered        */
                                    /* operator using current mode         */
    WwanRegisterModeAutomatic,      /* Turn on transceiver, camp on best   */
                                    /* available network, packet attach    */
    WwanRegisterModeManual,         /* Turn on transceiver, use numeric    */
                                    /* code to camp, packet attach         */
    WwanRegisterModeDeregister,     /* Transceiver is on, but device is    */
                                    /* detached and deregistered           */
    WwanRegisterModeRadioOff,       /* Transceiver is off, device is       */
                                    /* detached and deregistered           */
    WwanRegisterModeMax
}
WWAN_REGISTER_MODE;


typedef enum _WWAN_REGISTER_STATE
{
    WwanRegisterStateUnknown,       /* Registration state unknown          */
    WwanRegisterStateDeregistered,  /* Not registered, not searching       */
    WwanRegisterStateSearching,     /* Searching for a provider            */
    WwanRegisterStateHome,          /* Device is on a home provider        */
    WwanRegisterStateRoaming,       /* Device is on roaming provider       */
    WwanRegisterStateDenied,        /* Registration denied, emergency      */
    WwanRegisterStateMax            /* may still be made                   */
}
WWAN_REGISTER_STATE;


typedef struct _WWAN_REGISTRATION
{
    WWAN_REGISTER_MODE   RegisterMode;  /* WWAN_REGISER_MODE value         */
    WWAN_REGISTER_STATE  RegisterState; /* WWAN_REGISER_STATE value        */
    WWAN_PROVIDER        Provider;      /* WWAN_PROVIDER structure         */
}
WWAN_REGISTRATION;


typedef enum _WWAN_ATTACH_STATE
{
    WwanAttachStateUnknown,
    WwanAttachStateDetached,            /* Device is likely unregistered   */
    WwanAttachStateSearching,           /* Automatic after registered      */
    WwanAttachStateAttached,            /* Packet attached                 */
    WwanAttachStateDenied,              /* Packet service unavailable      */
    WwanAttachStateMax
}
WWAN_ATTACH_STATE;


typedef struct _WWAN_PACKET_SERVICE
{
    WWAN_ATTACH_STATE   AttachState;    /* Attach state, ignored for CDMA  */
    ULONG               DataClass;      /* WWAN_DATA_CLASS_ flags          */
}
WWAN_PACKET_SERVICE;


typedef struct _WWAN_SIGNAL_STATE
{
    ULONG Rssi;                         /* Decibels (db)                   */
    ULONG RssiInterval;        /* Suggested interval in seconds   */
    ULONG RssiThreshold;       /* Suggested +/- threshold in db   */
}
WWAN_SIGNAL_STATE;


typedef enum _WWAN_CONTEXT_AUTHENTICATION
{
    WwanContextAuthenticationUnknown,   /* Ignore user/pwd fields          */
    WwanContextAuthenticationNone,      /* Ignore user/pwd fields          */
    WwanContextAuthenticationChap,      /* Use CHAP authentication         */
    WwanContextAuthenticationPap,       /* Use PAP authentication          */
    WwanContextAuthenticationEap,       /* Use EAP authentication          */
    WwanContextAuthenticationMax
}
WWAN_CONTEXT_AUTHENTICATION;


typedef enum _WWAN_ACTIVATION_STATE
{
    WwanActivationStateUnknown,
    WwanActivationStateActivated,
    WwanActivationStateDeactivated,
    WwanActivationStateMax
}
WWAN_ACTIVATION_STATE;


typedef struct _WWAN_CONTEXT
{
    ULONG   ProviderId;                     /* Provider owns the access str*/
    WWAN_ACTIVATION_STATE ActivationState;  /* Activation state            */
    WCHAR   AccessString[WWAN_ACCESSSTRING_LEN]; /* Null-term'd access str */
    WWAN_CONTEXT_AUTHENTICATION AuthenticationType; /* Authentication type */
    WCHAR   UserName[WWAN_USERNAME_LEN];    /* Null-term'd username        */
    WCHAR   Password[WWAN_PASSWORD_LEN];    /* Null-term'd password        */
}
WWAN_CONTEXT;


typedef struct _WWAN_CONTEXT_LIST
{
    ULONG   ContextCount;               /* Number of contexts in the list  */
    ULONG   ContextListSize;            /* Size and offset to an array of  */
    ULONG   ContextListOffset;          /* WWAN_CONTEXT                    */
}
WWAN_CONTEXT_LIST;


typedef struct _WWAN_VENDOR_SPECIFIC
{
    ULONG_PTR   AppId;                  /* 0 reserved for ALL              */
    ULONG       DataSize;               /* Size and offset to the vendor   */
    ULONG       DataOffset;             /* specific data                   */
}
WWAN_VENDOR_SPECIFIC;


/*-----------------------------------------------------------------------
    notification codes
  -----------------------------------------------------------------------*/
#define NDIS_WW_READY_STATE                 0x00001000
#define NDIS_WW_PIN_STATE                   0x00001001
#define NDIS_WW_REGISTER_STATE              0x00001002
#define NDIS_WW_PACKET_SERVICE              0x00001003
#define NDIS_WW_SIGNAL_STATE                0x00001004
#define NDIS_WW_ACTIVATION_STATE            0x00001005
#define NDIS_WW_LOCATION_INFO               0x00001006
#define NDIS_WW_VENDOR_SPECIFIC             0x00001007


/*-----------------------------------------------------------------------
    oids
  -----------------------------------------------------------------------*/
#define OID_WW_NEGOTIATE_VERSION            0x0e010100
#define OID_WW_DEVICE_CAPS                  0x0e010101
#define OID_WW_INITIALIZE                   0x0e010102
#define OID_WW_SHUTDOWN                     0x0e010103
#define OID_WW_GET_READY_STATE              0x0e010104
#define OID_WW_GET_PIN_STATE                0x0e010105
#define OID_WW_SET_PIN                      0x0e010106
#define OID_WW_GET_PREFERRED_PROVIDERS      0x0e010107
#define OID_WW_SET_PREFERRED_PROVIDERS      0x0e010108
#define OID_WW_GET_VISIBLE_PROVIDERS        0x0e010109
#define OID_WW_GET_REGISTER_STATE           0x0e01010a
#define OID_WW_SET_REGISTER_STATE           0x0e01010b
#define OID_WW_GET_PACKET_SERVICE           0x0e01010c
#define OID_WW_SET_SIGNAL_SUGGESTION        0x0e01010d
#define OID_WW_GET_SIGNAL_STATE             0x0e01010e
#define OID_WW_GET_PROVISIONED_CONTEXTS     0x0e01010f
#define OID_WW_SET_PROVISIONED_CONTEXTS     0x0e010110
#define OID_WW_GET_ACTIVATION_STATE         0x0e010111
#define OID_WW_SET_ACTIVATION_STATE         0x0e010112
#define OID_WW_GET_LOCATION_INFO            0x0e010113
#define OID_WW_SET_LOCATION_INFO            0x0e010114
#define OID_WW_VENDOR_SPECIFIC              0x0e010115


/*-----------------------------------------------------------------------
    ndis status codes
  -----------------------------------------------------------------------*/
#define NDIS_STATUS_WW_ASYNC_RESPONSE       0x40020000

/* already defined in ddk/inc/ndis.h */
#ifdef NDIS_STATUS_WW_INDICATION
#undef NDIS_STATUS_WW_INDICATION
#endif

#define NDIS_STATUS_WW_INDICATION           0x40020001

#define NDIS_STATUS_WW_UNKNOWN_VERSION      0xC0020001
#define NDIS_STATUS_WW_DEVICE_BUSY          0xC0020002
#define NDIS_STATUS_WW_INVALID_CAPABILITIES 0xC0020003


/*-----------------------------------------------------------------------
    guids for status & oids
  -----------------------------------------------------------------------*/
extern const GUID GUID_NDIS_GEN_SUPPORTED_LIST;
extern const GUID GUID_NDIS_STATUS_WW_ASYNC_RESPONSE;
extern const GUID GUID_NDIS_STATUS_WW_INDICATION;
extern const GUID GUID_NDIS_WW_NEGOTIATE_VERSION;
extern const GUID GUID_NDIS_WW_DEVICE_CAPS;
extern const GUID GUID_NDIS_WW_INITIALIZE;
extern const GUID GUID_NDIS_WW_SHUTDOWN;
extern const GUID GUID_NDIS_WW_GET_READY_STATE;
extern const GUID GUID_NDIS_WW_GET_PIN_STATE;
extern const GUID GUID_NDIS_WW_SET_PIN;
extern const GUID GUID_NDIS_WW_GET_PREFERRED_PROVIDERS;
extern const GUID GUID_NDIS_WW_SET_PREFERRED_PROVIDERS;
extern const GUID GUID_NDIS_WW_GET_VISIBLE_PROVIDERS;
extern const GUID GUID_NDIS_WW_GET_REGISTER_STATE;
extern const GUID GUID_NDIS_WW_SET_REGISTER_STATE;
extern const GUID GUID_NDIS_WW_GET_PACKET_SERVICE;
extern const GUID GUID_NDIS_WW_SET_SIGNAL_SUGGESTION;
extern const GUID GUID_NDIS_WW_GET_SIGNAL_STATE;
extern const GUID GUID_NDIS_WW_GET_PROVISIONED_CONTEXTS;
extern const GUID GUID_NDIS_WW_SET_PROVISIONED_CONTEXTS;
extern const GUID GUID_NDIS_WW_GET_ACTIVATION_STATE;
extern const GUID GUID_NDIS_WW_SET_ACTIVATION_STATE;
extern const GUID GUID_NDIS_WW_GET_LOCATION_INFO;
extern const GUID GUID_NDIS_WW_SET_LOCATION_INFO;
extern const GUID GUID_NDIS_WW_VENDOR_SPECIFIC;


#ifdef __cplusplus
}
#endif


#endif /* __NDISWWAN_H__ */
                               	Pj@j_âÖ‡˝ˇˇâÖ`˝ˇˇçÖ\˝ˇˇW3€Pâù\˝ˇˇËô˝ˇãç‹˝ˇˇÉƒçÖ‡˝ˇˇPˇ6ˇvËÔˇˇÖ¿å±˛ˇˇãç‹˝ˇˇh  çÖ‰˝ˇˇPhƒm	Pˇ6Ëº˘ˇˇ;√}Pˇ6âùú˝ˇˇâΩ†˝ˇˇhç	PçÖú˝ˇˇÈ\ˇˇˇjçÖ‰˝ˇˇPˇvËÓA˝ˇ;√çç‰˝ˇˇ}!Qˇvâù‘˝ˇˇPâΩÿ˝ˇˇh¿å	PçÖ‘˝ˇˇÈ(˛ˇˇjXQˇvâÖê˝ˇˇhhå	PPçÖå˝ˇˇWPâùå˝ˇˇË∫ò˝ˇÉƒˇ6Ëb.˝ˇ;√|=ˇµ‡˝ˇˇãç‹˝ˇˇˇ6ˇvË7˚ˇˇ;√ç√   ˇ6âùÃ˝ˇˇPâΩ–˝ˇˇhå	PçÖÃ˝ˇˇÈÜ   ã»Å·ˇˇ  ;œt!É˘tPˇ6âùƒ˝ˇˇâΩ»˝ˇˇhhOPçÖƒ˝ˇˇÎYjXˇ6âÖ∏˝ˇˇh∏ã	PPçÖ¥˝ˇˇWPâù¥˝ˇˇËò˝ˇãç‹˝ˇˇÉƒSâô8  ˇ6ËêÙˇˇ;√}8Pˇ6âù§˝ˇˇâΩ®˝ˇˇhhã	PçÖ§˝ˇˇjWPË‡ó˝ˇÉƒçÖ‰˝ˇˇPˇ