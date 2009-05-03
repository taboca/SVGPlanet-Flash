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
/*++

THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF
ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
PARTICULAR PURPOSE.

Module Name:

    winnetwk.h

Abstract:

    Standard WINNET Header File for WIN32

Notes:

        
--*/

// @CESYSGEN IF CE_MODULES_REDIR

#ifndef _WINNETWK_
#define _WINNETWK_


#ifdef __cplusplus
extern "C" {
#endif

//
// Network types
//

#define     WNNC_NET_MSNET      0x00010000
#define     WNNC_NET_LANMAN     0x00020000
#define     WNNC_NET_NETWARE    0x00030000
#define     WNNC_NET_VINES      0x00040000
#define     WNNC_NET_10NET      0x00050000
#define     WNNC_NET_LOCUS      0x00060000
#define     WNNC_NET_SUN_PC_NFS 0x00070000
#define     WNNC_NET_LANSTEP    0x00080000
#define     WNNC_NET_9TILES     0x00090000
#define     WNNC_NET_LANTASTIC  0x000A0000
#define     WNNC_NET_AS400      0x000B0000
#define     WNNC_NET_FTP_NFS    0x000C0000
#define     WNNC_NET_PATHWORKS  0x000D0000
#define     WNNC_NET_LIFENET    0x000E0000
#define     WNNC_NET_POWERLAN   0x000F0000
#define     WNNC_NET_BWNFS		0x00100000
#define     WNNC_NET_COGENT		0x00110000
#define     WNNC_NET_FARALLON	0x00120000
#define     WNNC_NET_APPLETALK	0x00130000
#define     WNNC_NET_INTERGRAPH	0x00140000


//
//  Network Resources.
//

#define RESOURCE_CONNECTED      0x00000001
#define RESOURCE_GLOBALNET      0x00000002
#define RESOURCE_REMEMBERED     0x00000003
#if(WINVER >= 0x0400)
#define RESOURCE_RECENT         0x00000004
#define RESOURCE_CONTEXT        0x00000005
#endif /* WINVER >= 0x0400 */

#define RESOURCETYPE_ANY        0x00000000
#define RESOURCETYPE_DISK       0x00000001
#define RESOURCETYPE_PRINT      0x00000002
#if(WINVER >= 0x0400)
#define RESOURCETYPE_RESERVED   0x00000008
#endif /* WINVER >= 0x0400 */
#define RESOURCETYPE_UNKNOWN    0xFFFFFFFF

#define RESOURCEUSAGE_CONNECTABLE   0x00000001
#define RESOURCEUSAGE_CONTAINER     0x00000002
#if(WINVER >= 0x0400)
#define RESOURCEUSAGE_NOLOCALDEVICE 0x00000004
#define RESOURCEUSAGE_SIBLING       0x00000008
#define RESOURCEUSAGE_ALL           (RESOURCEUSAGE_CONNECTABLE | RESOURCEUSAGE_CONTAINER)
#endif /* WINVER >= 0x0400 */
#define RESOURCEUSAGE_RESERVED      0x80000000

#define RESOURCEDISPLAYTYPE_GENERIC        0x00000000
#define RESOURCEDISPLAYTYPE_DOMAIN         0x00000001
#define RESOURCEDISPLAYTYPE_SERVER         0x00000002
#define RESOURCEDISPLAYTYPE_SHARE          0x00000003
#define RESOURCEDISPLAYTYPE_FILE           0x00000004
#define RESOURCEDISPLAYTYPE_GROUP          0x00000005
#if(WINVER >= 0x0400)
#define RESOURCEDISPLAYTYPE_NETWORK        0x00000006
#define RESOURCEDISPLAYTYPE_ROOT           0x00000007
#define RESOURCEDISPLAYTYPE_SHAREADMIN     0x00000008
#define RESOURCEDISPLAYTYPE_DIRECTORY      0x00000009
#endif /* WINVER >= 0x0400 */
#define RESOURCEDISPLAYTYPE_TREE           0x0000000A

typedef struct  _NETRESOURCEA {
    DWORD    dwScope;
    DWORD    dwType;
    DWORD    dwDisplayType;
    DWORD    dwUsage;
    LPSTR    lpLocalName;
    LPSTR    lpRemoteName;
    LPSTR    lpComment ;
    LPSTR    lpProvider;
}NETRESOURCEA, *LPNETRESOURCEA;
typedef struct  _NETRESOURCEW {
    DWORD    dwScope;
    DWORD    dwType;
    DWORD    dwDisplayType;
    DWORD    dwUsage;
    LPWSTR   lpLocalName;
    LPWSTR   lpRemoteName;
    LPWSTR   lpComment ;
    LPWSTR   lpProvider;
}NETRESOURCEW, *LPNETRESOURCEW;
#ifdef UNICODE
typedef NETRESOURCEW NETRESOURCE;
typedef LPNETRESOURCEW LPNETRESOURCE;
#else
typedef NETRESOURCEA NETRESOURCE;
typedef LPNETRESOURCEA LPNETRESOURCE;
#endif // UNICODE


//
//  Network Connections.
// 

#define NETPROPERTY_PERSISTENT       1

#define CONNECT_UPDATE_PROFILE      0x00000001
#define CONNECT_UPDATE_RECENT       0x00000002
#define CONNECT_TEMPORARY           0x00000004
#define CONNECT_INTERACTIVE         0x00000008
#define CONNECT_PROMPT              0x00000010
#define CONNECT_NEED_DRIVE          0x00000020
#if(WINVER >= 0x0400)
#define CONNECT_REFCOUNT            0x00000040
#define CONNECT_REDIRECT            0x00000080
#define CONNECT_LOCALDRIVE          0x00000100
#define CONNECT_CURRENT_MEDIA       0x00000200
#endif /* WINVER >= 0x0400 */

DWORD APIENTRY
WNetAddConnection3A(
     HWND           hwndOwner,
     LPNETRESOURCEA lpNetResource,
     LPCSTR       lpPassword,
     LPCSTR       lpUserName,
     DWORD          dwFlags
    );
DWORD APIENTRY
WNetAddConnection3W(
     HWND           hwndOwner,
     LPNETRESOURCEW lpNetResource,
     LPCWSTR       lpPassword,
     LPCWSTR       lpUserName,
     DWORD          dwFlags
    );
#ifdef UNICODE
#define WNetAddConnection3  WNetAddConnection3W
#else
#define WNetAddConnection3  WNetAddConnection3A
#endif // !UNICODE

DWORD APIENTRY
WNetCancelConnection2A(
     LPCSTR lpName,
     DWORD    dwFlags,
     BOOL     fForce
    );
DWORD APIENTRY
WNetCancelConnection2W(
     LPCWSTR lpName,
     DWORD    dwFlags,
     BOOL     fForce
    );
#ifdef UNICODE
#define WNetCancelConnection2  WNetCancelConnection2W
#else
#define WNetCancelConnection2  WNetCancelConnection2A
#endif // !UNICODE

DWORD APIENTRY
WNetGetConnectionA(
     LPCSTR lpLocalName,
     LPSTR  lpRemoteName,
     LPDWORD  lpnLength
    );
DWORD APIENTRY
WNetGetConnectionW(
     LPCWSTR lpLocalName,
     LPWSTR  lpRemoteName,
     LPDWORD  lpnLength
    );
#ifdef UNICODE
#define WNetGetConnection  WNetGetConnectionW
#else
#define WNetGetConnection  WNetGetConnectionA
#endif // !UNICODE


//
//  Network Connection Dialogs.
//


DWORD APIENTRY
WNetDisconnectDialog(
    HWND  hwnd,
    DWORD dwType
    );

#if(WINVER >= 0x0400)
typedef struct _CONNECTDLGSTRUCTA{
    DWORD cbStructure;       /* size of this structure in bytes */
    HWND hwndOwner;          /* owner window for the dialog */
    LPNETRESOURCEA lpConnRes;/* Requested Resource info    */
    DWORD dwFlags;           /* flags (see below) */
    DWORD dwDevNum;          /* number of devices connected to */
} CONNECTDLGSTRUCTA, FAR *LPCONNECTDLGSTRUCTA;
typedef struct _CONNECTDLGSTRUCTW{
    DWORD cbStructure;       /* size of this structure in bytes */
    HWND hwndOwner;          /* owner window for the dialog */
    LPNETRESOURCEW lpConnRes;/* Requested Resource info    */
    DWORD dwFlags;           /* flags (see below) */
    DWORD dwDevNum;          /* number of devices connected to */
} CONNECTDLGSTRUCTW, FAR *LPCONNECTDLGSTRUCTW;
#ifdef UNICODE
typedef CONNECTDLGSTRUCTW CONNECTDLGSTRUCT;
typedef LPCONNECTDLGSTRUCTW LPCONNECTDLGSTRUCT;
#else
typedef CONNECTDLGSTRUCTA CONNECTDLGSTRUCT;
typedef LPCONNECTDLGSTRUCTA LPCONNECTDLGSTRUCT;
#endif // UNICODE

#define CONNDLG_RO_PATH     0x00000001 /* Resource path should be read-only    */
#define CONNDLG_CONN_POINT  0x00000002 /* Netware -style movable connection point enabled */
#define CONNDLG_USE_MRU     0x00000004 /* Use MRU combobox  */
#define CONNDLG_HIDE_BOX    0x00000008 /* Hide persistent connect checkbox  */

/*
 * NOTE:  Set at most ONE of the below flags.  If neither flag is set,
 *        then the persistence is set to whatever the user chose during
 *        a previous connection
 */
#define CONNDLG_PERSIST     0x00000010 /* Force persistent connection */
#define CONNDLG_NOT_PERSIST 0x00000020 /* Force connection NOT persistent */

DWORD APIENTRY
WNetConnectionDialog1A(
    LPCONNECTDLGSTRUCTA lpConnDlgStruct
    );
DWORD APIENTRY
WNetConnectionDialog1W(
    LPCONNECTDLGSTRUCTW lpConnDlgStruct
    );
#ifdef UNICODE
#define WNetConnectionDialog1  WNetConnectionDialog1W
#else
#define WNetConnectionDialog1  WNetConnectionDialog1A
#endif // !UNICODE

typedef struct _DISCDLGSTRUCTA{
    DWORD           cbStructure;      /* size of this structure in bytes */
    HWND            hwndOwner;        /* owner window for the dialog */
    LPSTR           lpLocalName;      /* local device name */
    LPSTR           lpRemoteName;  