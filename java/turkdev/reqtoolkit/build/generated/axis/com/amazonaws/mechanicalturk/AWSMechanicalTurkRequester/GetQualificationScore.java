e);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetRetransmitMode
                              (OUT smiLPUINT32 nRetransmitMode);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetRetransmitMode
                              (IN smiUINT32 nRetransmitMode);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetTimeout
                              (IN HSNMP_ENTITY hEntity,
                              OUT smiLPTIMETICKS nPolicyTimeout,
                              OUT smiLPTIMETICKS nActualTimeout);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetTimeout
                              (IN HSNMP_ENTITY hEntity,
                              IN smiTIMETICKS nPolicyTimeout);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetRetry
                              (IN HSNMP_ENTITY hEntity,
                              OUT smiLPUINT32 nPolicyRetry,
                              OUT smiLPUINT32 nActualRetry);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetRetry
                              (IN HSNMP_ENTITY hEntity,
                              IN smiUINT32 nPolicyRetry);

/* Following Local Database Functions added in v2.0 */
SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetVendorInfo
                              (OUT smiLPVENDORINFO vendorInfo);

/* Communications Functions */
SNMPAPI_STATUS SNMPAPI_CALL   SnmpStartup
                              (OUT smiLPUINT32 nMajorVersion,
                              OUT smiLPUINT32 nMinorVersion,
                              OUT smiLPUINT32 nLevel,
                              OUT smiLPUINT32 nTranslateMode,
                              OUT smiLPUINT32 nRetransmitMode);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpCleanup
                              (void);

HSNMP_SESSION  SNMPAPI_CALL   SnmpOpen
                              (IN HWND hWnd,
                              IN UINT wMsg);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpClose
                              (IN HSNMP_SESSION session);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSendMsg
                              (IN HSNMP_SESSION session,
                              IN HSNMP_ENTITY srcEntity,
                              IN HSNMP_ENTITY dstEntity,
                              IN HSNMP_CONTEXT context,
                              IN HSNMP_PDU PDU);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpRecvMsg
                              (IN HSNMP_SESSION session,
                              OUT LPHSNMP_ENTITY srcEntity,
                              OUT LPHSNMP_ENTITY dstEntity,
                              OUT LPHSNMP_CONTEXT  context,
                              OUT LPHSNMP_PDU PDU);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpRegister
                              (IN HSNMP_SESSION session,
                              IN HSNMP_ENTITY srcEntity,
                              IN HSNMP_ENTITY dstEntity,
                              IN HSNMP_CONTEXT context,
                              IN smiLPCOID notification,
                              IN smiUINT32 state);

/* Following Communications Functions added in v2.0 */
HSNMP_SESSION  SNMPAPI_CALL   SnmpCreateSession
                              (IN HWND hWnd,
                              IN UINT wMsg,
                              IN SNMPAPI_CALLBACK fCallBack,
                              IN LPVOID lpClientData);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpListen
                              (IN HSNMP_ENTITY hEntity,
                              IN SNMPAPI_STATUS lStatus);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpCancelMsg
                              (IN HSNMP_SESSION session,
                              IN smiINT32 reqId);

/* Extensions to Communications Functions */
SNMPAPI_STATUS SNMPAPI_CALL SnmpStartupEx 
                            (OUT smiLPUINT32 nMajorVersion,
                             OUT smiLPUINT32 nMinorVersion,
                             OUT smiLPUINT32 nLevel,
                             OUT smiLPUINT32 nTranslateMode,
                             OUT smiLPUINT32 nRetransmitMode);
typedef SNMPAPI_STATUS (__stdcall * PFNSNMPSTARTUPEX)(  smiLPUINT32,
                                                        smiLPUINT32,
                                                        smiLPUINT32,
                                                        smiLPUINT32,
                                                        smiLPUINT32);
SNMPAPI_STATUS SNMPAPI_CALL SnmpCleanupEx 
                            (void);
typedef SNMPAPI_STATUS (__stdcall * PFNSNMPCLEANUPEX)(void);

/* Entity/Context Functions */
HSNMP_ENTITY   SNMPAPI_CALL   SnmpStrToEntity
                              (IN HSNMP_SESSION session,
                              IN LPCSTR string);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpEntityToStr
                              (IN HSNMP_ENTITY entity,
                              IN smiUINT32 size,
                              OUT LPSTR string);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpFreeEntity
                              (IN HSNMP_ENTITY entity);

HSNMP_CONTEXT  SNMPAPI_CALL   SnmpStrToContext
                              (IN HSNMP_SESSION session,
                              IN smiLPCOCTETS string);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpContextToStr
                              (IN HSNMP_CONTEXT context,
                              OUT smiLPOCTETS string);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpFreeContext
                              (IN HSNMP_CONTEXT context);

/* Following Entity/Context Functions added in v2.0 */
SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetPort
                              (IN HSNMP_ENTITY hEntity,
                              IN UINT nPort);

/* PDU Functions */
HSNMP_PDU      SNMPAPI_CALL   SnmpCreatePdu
                              (IN HSNMP_SESSION session,
                              IN smiINT PDU_type,
                              IN smiINT32 request_id,
                              IN smiINT error_status,
                              IN smiINT error_index,
                              IN HSNMP_VBL varbindlist);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetPduData
                              (IN HSNMP_PDU PDU,
                              OUT smiLPINT PDU_type,
                              OUT smiLPINT32 request_id,
                              OUT smiLPINT error_status,
                              OUT smiLPINT error_index,
                              OUT LPHSNMP_VBL varbindlist);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetPduData
                              (IN HSNMP_PDU PDU,
                              IN const smiINT FAR *PDU_type,
                              IN const smiINT32 FAR *request_id,
                              IN const smiINT FAR *non_repeaters,
                              IN const smiINT FAR *max_repetitions,
                              IN const HSNMP_VBL FAR *varbindlist);

HSNMP_PDU      SNMPAPI_CALL   SnmpDuplicatePdu
                              (IN HSNMP_SESSION session,
                              IN HSNMP_PDU PDU);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpFreePdu
                              (IN HSNMP_PDU PDU);

/* Variable-Binding Functions */
HSNMP_VBL      SNMPAPI_CALL   SnmpCreateVbl
                              (IN HSNMP_SESSION session,
                              IN smiLPCOID name,
                              IN smiLPCVALUE value);

HSNMP_VBL      SNMPAPI_CALL   SnmpDuplicateVbl
                              (IN HSNMP_SESSION session,
                              IN HSNMP_VBL vbl);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpFreeVbl
                              (IN HSNMP_VBL vbl);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpCountVbl
                              (IN HSNMP_VBL vbl);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetVb
                              (IN HSNMP_VBL vbl,
                              IN smiUINT32 index,
                              OUT smiLPOID name,
                              OUT smiLPVALUE value);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpSetVb
                              (IN HSNMP_VBL vbl,
                              IN smiUINT32 index,
                              IN smiLPCOID name,
                              IN smiLPCVALUE value);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpDeleteVb
                              (IN HSNMP_VBL vbl,
                              IN smiUINT32 index);

/* Utility Functions */
SNMPAPI_STATUS SNMPAPI_CALL   SnmpGetLastError
                              (IN HSNMP_SESSION session);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpStrToOid
                              (IN LPCSTR string,
                              OUT smiLPOID dstOID);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpOidToStr
                              (IN smiLPCOID srcOID,
                              IN smiUINT32 size,
                              OUT LPSTR string);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpOidCopy
                              (IN smiLPCOID srcOID,
                              OUT smiLPOID dstOID);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpOidCompare
                              (IN smiLPCOID xOID,
                              IN smiLPCOID yOID,
                              IN smiUINT32 maxlen,
                              OUT smiLPINT result);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpEncodeMsg
                              (IN HSNMP_SESSION session,
                              IN HSNMP_ENTITY srcEntity,
                              IN HSNMP_ENTITY dstEntity,
                              IN HSNMP_CONTEXT context,
                              IN HSNMP_PDU pdu,
                              OUT smiLPOCTETS msgBufDesc);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpDecodeMsg
                              (IN HSNMP_SESSION session,
                              OUT LPHSNMP_ENTITY srcEntity,
                              OUT LPHSNMP_ENTITY dstEntity,
                              OUT LPHSNMP_CONTEXT context,
                              OUT LPHSNMP_PDU pdu,
                              IN smiLPCOCTETS msgBufDesc);

SNMPAPI_STATUS SNMPAPI_CALL   SnmpFreeDescriptor
                              (IN smiUINT32 syntax,
                              IN smiLPOPAQUE descriptor);

#ifdef __cplusplus
}
#endif

#endif         /* _INC_WINSNMP */

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ������������~���y���t���p���m�|�7qK�=���=���=���<���<���;���<���<���<���<���;���"{��^hv�OTZ�        }���y���u���p���k�}�f�w�`�s�Z�m�T�h�O�b�J�]�E�Y�A{U�=wQ�9sN�7qK�����������������������������|���z���x���u���"{��[ft�OTZ�                        A���������������������������������������������������������������������������}���y���w���u���"{��Zer�OTZ�                        A���������������������������������������������������������������������������}���z���x���u���"{��Xcp�OTZ�                        A���A���A���A���@���A���@���?���?���?���?���?���>���>���=���=���=���<���=���<���;���<���<���"{��Xcp�OTZ�    �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  �  (                                                 ����x^I�w^H�v\F�tZF�sXD�qVB�pUA�nT?�mR=�kP<�jO;�        yaP�yaP�{dR�~hU��jY��p]��sa��xe��{i��}j��}j����έ��cJ5�    �����r_���o������������¦��ɬ��γ��Թ��ؾ��¦���s^��¯�dI6�    ·������������������������}���z���y���x���w���w�¦���{f�dJ6�        ���c�����������������������������������������s^���o�eK6�    v9�o2�l3�h2�c3�]3�W3�R3�L3�H4�֮��֮�������s^�fK7�     |>���������������������������������L4�����֮���������fL8�    +�E���������������������o8�]4�[}_�Q3�֮��֮������έ��fL8�    8�N�����v;�n9�b5�����>�G�g:�����W3�����֮������Ӵ��hM8�    F�W���������Q�W��Ė�W�Z�!p:�l�o�����]3�֮��֮������׻��gM9�    S�`����������ƚ�W�Z�&|9�'g1���������b3�����֮�������¯�hM9�    ^�f������ē�d�i�4�A�o�s�W�`�:�F�����h2�֮��֮�������ȷ�/*++

Copyright (c) Microsoft Corporation. All rights reserved.

Module Name:

    wsipv6ok.h
    
Abstract:

    This module contains defines used to flag usage of IPv6 incompatible
    defines, stuctures and functions.  They cause *cryptic* compile time
    error messages to be generated.  Currently, this header is only
    included from winsock2.h.

    NOTE: The compile time flag, IPV6STRICT, must be defined.

--*/

#ifndef _WSIPV6OK_
#define _WSIPV6OK_

#pragma once

#ifdef IPV6STRICT

//
// prevent substitutions in these headers by including them first.
//
#i