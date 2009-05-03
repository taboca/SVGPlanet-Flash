State,
        LPVOID pvReserved
        );


DWORD
WINAPI
SetDot1xSuppHeldPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppHeldPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
GetDot1xSuppHeldPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppHeldPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
SetDot1xSuppAuthPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppAuthPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
GetDot1xSuppAuthPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppAuthPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
SetDot1xSuppStartPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppStartPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
GetDot1xSuppStartPeriod (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppStartPeriod,
        LPVOID pvReserved
        );

DWORD
WINAPI
SetDot1xSuppMaxStart (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppMaxStart,
        LPVOID pvReserved
        );

DWORD
WINAPI
GetDot1xSuppMaxStart (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PULONG puDot1xSuppMaxStart,
        LPVOID pvReserved
        );


typedef struct _DOT1X_SUPP_STATS {
    ULONG udot1xSuppEapolFramesRx;
    ULONG udot1xSuppEapolFramesTx;
    ULONG udot1xSuppEapolStartFramesTx;
    ULONG udot1xSuppEapolLogoffFramesTx;
    ULONG udot1xSuppEapolRespIdFramesTx;
    ULONG udot1xSuppEapolRespFramesTx;
    ULONG udot1xSuppEapolReqIdFramesRx;
    ULONG udot1xSuppEapolReqFramesRx;
    ULONG udot1xSuppInvalidEapolFramesRx;
    ULONG udot1xSuppEapLengthErrorFramesRx;
    ULONG udot1xSuppLastEapolFrameVersion;
    DOT1X_MAC_ADDRESS udot1xSuppLastEapolFrameSource;
} DOT1X_SUPP_STATS, *PDOT1X_SUPP_STATS;

DWORD
WINAPI
GetDot1xSuppStats (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PDOT1X_SUPP_STATS pDot1xSuppStats,
        LPVOID pvReserved
        );


// APIs:
// Authenticator Configuration

#define FIELD_AUTH_AUTHENTICATOR_PAE_STATE          0x80000000
#define FIELD_AUTH_BACKEND_AUTHENTICATION_STATE     0x40000000
#define FIELD_AUTH_ADMIN_CONTROLLED_DIRECTIONS      0x20000000
#define FIELD_AUTH_OPER_CONTROLLED_DIRECTIONS       0x10000000
#define FIELD_AUTH_AUTH_CONTROLLED_PORT_CONTROL     0x08000000
#define FIELD_AUTH_AUTH_CONTROLLED_PORT_STATUS      0x04000000
#define FIELD_AUTH_RE_AUTH_MAX                      0x02000000
#define FIELD_AUTH_QUIET_PERIOD                     0x01000000
#define FIELD_AUTH_TX_PERIOD                        0x00800000
#define FIELD_AUTH_SUPP_TIME_OUT                    0x00400000
#define FIELD_AUTH_SERVER_TIME_OUT                  0x00200000
#define FIELD_AUTH_MAX_REQ                          0x00100000
#define FIELD_AUTH_RE_AUTH_PERIOD                   0x00080000
#define FIELD_AUTH_RE_AUTH_ENABLED                  0x00040000
#define FIELD_AUTH_KEY_TRANSMISSION_ENABLED         0x00020000


typedef struct _AUTHENTICATOR_CONFIGURATION
{
    DOT1X_AUTH_PAE_STATE AuthenticatorPAEState;
    DOT1X_AUTH_BACKEND_AUTH_STATE BackendAuthenticationState;
    DOT1X_PAE_CONTROLLED_DIRECTIONS AdminControlledDirections;
    DOT1X_PAE_CONTROLLED_DIRECTIONS OperControlledDirections;
    DOT1X_PAE_CONTROLLED_PORT_CONTROL AuthControlledPortControl;
    DOT1X_PAE_CONTROLLED_PORT_STATUS AuthControlledPortStatus;
    DWORD reAuthMax;
    DWORD quietPeriod;
    DWORD txPeriod;
    DWORD suppTimeout;
    DWORD serverTimeout;
    DWORD maxReq;
    DWORD reAuthPeriod;
    DWORD reAuthEnabled;
    BOOL KeyTransmissionEnabled;
} AUTHENTICATOR_CONFIGURATION, *PAUTHENTICATOR_CONFIGURATION;

DWORD
WINAPI
ReadAuthenticatorConfiguration (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PAUTHENTICATOR_CONFIGURATION pAuthenticatorConfiguration,
        LPVOID pvReserved
        );

DWORD
WINAPI
SetAuthenticatorConfiguration (
        HANDLE hPortHandle,
        DWORD dwVersion,
        DWORD dwFields,
        PAUTHENTICATOR_CONFIGURATION pAuthenticatorConfiguration,
        LPVOID pvReserved
        );


DWORD
WINAPI
Reauthenticate (
        HANDLE hPortHandle,
        DWORD dwVersion,
        LPVOID pvReserved
        );


DWORD
WINAPI
ReadAuthenticatorStatistics (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PDOT1X_AUTH_STATS_ENTRY pAuthenticatorStatistics,
        LPVOID pvReserved
        );


// Authenticator Diagnostics

DWORD
WINAPI
ReadAuthenticatorDiagnostics (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PDOT1X_AUTH_DIAG_ENTRY pAuthenticatorDiagnostics,
        LPVOID pvReserved
        );


// Authenticator Session Statistics

DWORD
WINAPI
ReadAuthenticatorSessionStatistics (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PDOT1X_AUTH_SESSION_STATS pAuthenticatorSessionStatistics,
        LPVOID pvReserved
        );


typedef struct _SUPPLICANT_STATUS {
    ULONG SupplicantPAEState;
    ULONG heldPeriod;
    ULONG authPeriod;
    ULONG startPeriod;
    ULONG maxStart;
} SUPPLICANT_STATUS, *PSUPPLICANT_STATUS;

DWORD
WINAPI
ReadSupplicantStatus (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PSUPPLICANT_STATUS pSupplicantStatistics,
        LPVOID pvReserved
        );

typedef struct _SUPPLICANT_CONFIGURATION
{
    ULONG SupplicantPAEState;
    DWORD heldPeriod;
    DWORD authPeriod;
    DWORD startPeriod;
    DWORD maxStart;
} SUPPLICANT_CONFIGURATION, *PSUPPLICANT_CONFIGURATION;


#define FIELD_SUPP_HELD_PERIOD      0x80000000
#define FIELD_SUPP_AUTH_PERIOD      0x40000000
#define FIELD_SUPP_START_PERIOD     0x20000000
#define FIELD_SUPP_MAX_START        0x10000000

DWORD
WINAPI
SetSupplicantConfiguration (
        HANDLE hPortHandle,
        DWORD dwVersion,
        DWORD dwFields,
        PSUPPLICANT_CONFIGURATION pSupplicantConfiguration,
        LPVOID pvReserved
        );


DWORD
WINAPI
ReadSupplicantConfiguration (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PSUPPLICANT_CONFIGURATION pSupplicantConfiguration,
        LPVOID pvReserved
        );


DWORD
WINAPI
ReadSupplicantStatistics (
        HANDLE hPortHandle,
        DWORD dwVersion,
        PDOT1X_SUPP_STATS pSupplicantStatistics,
        LPVOID pvReserved
        );


typedef struct _DOT1X_PORT_CONFIGURATION {
    ULONG PortNumber;
    ULONG ProtocolVersion;
    ULONG PAECapabilities;
} DOT1X_PORT_CONFIGURATION, *PDOT1X_PORT_CONFIGURATION;


typedef struct _SYSTEM_CONFIGURATION {
    DWORD SystemAuthControl;
} SYSTEM_CONFIGURATION, *PSYSTEM_CONFIGURATION;

#define FIELD_SYSTEM_AUTH_CONTROL      0x80000000

DWORD
WINAPI
ReadSystemConfiguration (
        HANDLE hSystemHandle,
        DWORD dwVersion,
        PSYSTEM_CONFIGURATION pSystemConfiguration,
        PDOT1X_PORT_CONFIGURATION pTempPortConfiguration,
        DWORD dwPreferredNumPorts,
        PDOT1X_PORT_CONFIGURATION *ppPortConfiguration,
        LPDWORD pdwNumPorts,
        LPDWORD pdwTotalNumPorts,
        LPDWORD pdwResumeHandle,
        LPVOID pvReserved
        );

DWORD
WINAPI
SetSystemConfiguration (
        HANDLE hSystemHandle,
        DWORD dwVersion,
        DWORD dwFields,
        PSYSTEM_CONFIGURATION pSystemConfiguration,
        LPVOID pvReserved
        );

DWORD
WINAPI
InitializePort (
        HANDLE hPortHandle,
        DWORD dwVersion,
        LPVOID pvReserved
        );




typedef struct _DOT1X_INTERFACE {
    GUID gInterfaceId;
    LPWSTR pszDescription;
} DOT1X_INTERFACE, *PDOT1X_INTERFACE;

DWORD
WINAPI
EnumDot1xInterfaces (
        LPWSTR pServerName,
        DWORD dwVersion,
        PDOT1X_INTERFACE pTempDot1xInterfaces,
        DWORD dwPreferredNumInterfaces,
        PDOT1X_INTERFACE * ppDot1xInterfaces,
        LPDWORD pdwNumInterfaces,
        LPDWORD pdwTotalNumInterfaces,
        LPDWORD pdwResumeHandle,
        LPVOID pvReserved
        );

typedef struct _DOT1X_PORT {
    GUID gInterfaceId;
    DOT1X_MAC_ADDRESS PeerMacAddress;
    PDOT1X_BLOB pPortIdentifier;
    DWORD_PTR PortNumber;
    DWORD dwFlags;
} DOT1X_PORT, *PDOT1X_PORT;

#define DOT1X_ENUM_PORT_SETTINGS    0x80000000
#define DOT1X_ENUM_ACTIVE_PORTS     0x40000000

DWORD
WINAPI
EnumDot1xPorts (
        LPWSTR pServerName,
        DWORD dwVersion,
        DWORD dwFlags,
        LPGUID pGuid,
        PDOT1X_PORT pTemplateDot1xPort,
        DWORD dwPreferredNumPorts,
        PDOT1X_PORT * ppDot1xPorts,
        LPDWORD pdwNumPorts,
        LPDWORD pdwTotalNumPorts,
        LPDWORD pdwResumeHandle,
        LPVOID pvReserved
        );


#define DOT1X_HANDLE_PORT           0x80000000
#define DOT1X_HANDLE_SYSTEM         0x40000000

#define DOT1X_SETTINGS              0x20000000
#define DOT1X_STATUS                0x10000000

#define DOT1X_MODE_AUTHENTICATOR    0x08000000
#define DOT1X_MODE_SUPPLICANT       0x04000000


DWORD
WINAPI
OpenDot1xHandle (
        LPWSTR pServerName,
        DWORD dwVersion,
        DWORD dwFlags,
        PDOT1X_PORT pPort,
        DWORD dwDesiredAccess,
        DWORD dwSharedMode,
        LPVOID pvReserved,
        PHANDLE phHandle
        );

DWORD
WINAPI
CloseDot1xHandle (
        HANDLE hHandle
        );


// Legacy interop APIs


typedef struct _DOT1X_ALLOWED_NON8021X {
    DOT1X_MAC_ADDRESS   MacAddress;
} DOT1X_A