//
// Copyright (c) Microsoft Corporation.  All rights reserved.
//
//
// This source code is licensed under Microsoft Shared Source License
// Version 1.0 for Windows CE.
// For a copy of the license visit http://go.microsoft.com/fwlink/?LinkId=3223.
//
// BthAPI.idl : IDL source for BthAPI.dll
//

cpp_quote("//")
cpp_quote("// Copyright (C) Microsoft Corporation, All rights reserved.")
cpp_quote("//")

// This file will be processed by the MIDL tool to
// produce the type library (bthapi.tlb) and marshalling code.

import "oaidl.idl";
import "ocidl.idl";

cpp_quote("#ifndef __BTHSDPDEF_H__")
#include "bthsdpdef.h"
cpp_quote("#define __BTHSDPDEF_H__")
cpp_quote("#endif")

interface ISdpNodeContainer;
interface ISdpRecord;

#define CASE_FROM_TYPE(_type, _specifictype) (((_type) << 16) | (_specifictype))

struct SdpString {
   [size_is(length)] CHAR *val;
   ULONG length;
};

typedef struct SdpString SdpString;

typedef [switch_type(unsigned long)] union NodeDataUnion {
    // the nil type contains no data, so no storage is necessary

    // 16 byte integers
    [case(CASE_FROM_TYPE(SDP_TYPE_INT, SDP_ST_INT128))] SDP_LARGE_INTEGER_16 int128;
    [case(CASE_FROM_TYPE(SDP_TYPE_UINT, SDP_ST_UINT128))] SDP_ULARGE_INTEGER_16 uint128;

    // UUID 
    [case(CASE_FROM_TYPE(SDP_TYPE_UUID, SDP_ST_UUID128))] GUID uuid128;
    [case(CASE_FROM_TYPE(SDP_TYPE_UUID, SDP_ST_UUID32))] ULONG uuid32;
    [case(CASE_FROM_TYPE(SDP_TYPE_UUID, SDP_ST_UUID16))] USHORT uuid16;

    // 8 byte integers
    [case(CASE_FROM_TYPE(SDP_TYPE_INT, SDP_ST_INT64))] LONGLONG int64;
    [case(CASE_FROM_TYPE(SDP_TYPE_UINT, SDP_ST_UINT64))] ULONGLONG uint64;

    // 4 byte integers
    [case(CASE_FROM_TYPE(SDP_TYPE_INT, SDP_ST_INT32))] LONG int32;
    [case(CASE_FROM_TYPE(SDP_TYPE_UINT, SDP_ST_UINT32))] ULONG uint32;

    // 2 byte integers
    [case(CASE_FROM_TYPE(SDP_TYPE_INT, SDP_ST_INT16))] SHORT int16;
    [case(CASE_FROM_TYPE(SDP_TYPE_UINT, SDP_ST_UINT16))] USHORT uint16;

    // 1 bytes integers
    [case(CASE_FROM_TYPE(SDP_TYPE_INT, SDP_ST_INT8))] CHAR int8;
    [case(CASE_FROM_TYPE(SDP_TYPE_UINT, SDP_ST_UINT8))] UCHAR uint8;

    // Boolean
    [case(CASE_FROM_TYPE(SDP_TYPE_BOOLEAN, SDP_ST_NONE))] UCHAR booleanVal;

    // string 
    [case(CASE_FROM_TYPE(SDP_TYPE_STRING, SDP_ST_NONE))] SdpString str;

    // URL
    [case(CASE_FROM_TYPE(SDP_TYPE_URL, SDP_ST_NONE))] SdpString url;

    // Sequence 
    // Alt list
    [case(CASE_FROM_TYPE(SDP_TYPE_CONTAINER, SDP_ST_NONE))] ISdpNodeContainer *container;

    // Nil
    [case(CASE_FROM_TYPE(SDP_TYPE_NIL, SDP_ST_NONE))] ;

} NodeDataUnion;

typedef struct NodeData {
    USHORT type;
    USHORT specificType;
	[switch_is(CASE_FROM_TYPE(type, specificType))] NodeDataUnion u;
} NodeData;

enum BthDeviceStringType 
{
	BthDeviceStringTypeFriendlyName,
	BthDeviceStringTypeDeviceName,
   BthDeviceStringTypeDisplay,
   BthDeviceStringTypeClass,
   BthDeviceStringTypeAddress
};

cpp_quote("#ifndef __BTHDEVICEINFO_DEFINED__")
cpp_quote("#define __BTHDEVICEINFO_DEFINED__")
#include <PSHPACK1.H>
typedef struct _BthDeviceInfo {
    ULONGLONG  btAddress;                                  // bt_addr of remote device.
    ULONG      cod;                                        // class of device.
    ULONGLONG  lmpSuppor