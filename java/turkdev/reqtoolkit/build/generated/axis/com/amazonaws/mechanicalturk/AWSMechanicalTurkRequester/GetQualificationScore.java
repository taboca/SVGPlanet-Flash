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

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           é¡öˇâªñˇÉ∑ëˇ~≥ãˇyØáˇt´Çˇp©Äˇm•|ˇ7qKˇ=°Ôˇ=üÔˇ=üÓˇ<ûÓˇ<ùÓˇ;úÓˇ<úÓˇ<õÓˇ<öÌˇ<öÌˇ;ôÓˇ"{“ˇ^hvˇOTZˇ        }πèˇyµäˇu∞Üˇp¨Åˇk¶}ˇf°wˇ`õsˇZïmˇTèhˇOäbˇJÖ]ˇEÄYˇA{Uˇ=wQˇ9sNˇ7qKˇôŸ˚ˇï◊˚ˇê’˚ˇå‘˚ˇá“˚ˇÑ—˚ˇÄœ˚ˇ|Œ˚ˇzŒ˚ˇxÕ˚ˇuÃ˚ˇ"{“ˇ[ftˇOTZˇ                        A¥ÛˇæÂ˚ˇæÂ˚ˇº‰˚ˇ∫„˚ˇ∑„˚ˇ≥·˚ˇ∞‡˚ˇ´ﬂ˚ˇß›˚ˇ£€˚ˇû⁄˚ˇôŸ˚ˇï÷˚ˇë’˚ˇç‘˚ˇà“˚ˇÑ—˚ˇÄœ˚ˇ}Œ˚ˇyŒ˚ˇwÕ˚ˇuÃ˚ˇ"{“ˇZerˇOTZˇ                        A¥ÛˇæÂ˚ˇæÂ˚ˇº‰˚ˇπ„˚ˇ∑‚˚ˇ≤·˚ˇØ‡˚ˇ´ﬁ˚ˇßﬁ˚ˇ£€˚ˇû⁄˚ˇôŸ˚ˇï◊˚ˇê’˚ˇå‘˚ˇà“˚ˇÑ—˚ˇÄ–˚ˇ}Œ˚ˇzŒ˚ˇxÕ˚ˇuÃ˚ˇ"{“ˇXcpˇOTZˇ                        A¥ÛˇA¥ÛˇA≥ÛˇA≤Ûˇ@±ÛˇA∞Úˇ@ÆÚˇ?≠Úˇ?´Òˇ?™Òˇ?©ˇ?ßˇ>•ˇ>§ˇ=£Ôˇ=°Ôˇ=üÔˇ<üÔˇ=ùÔˇ<úÓˇ;õÌˇ<öÓˇ<òÌˇ"{“ˇXcpˇOTZˇ    ¯  ¯  ‡  ‡  ‡  ‡  ‡  ‡        ¯  ¯  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  ¯  ¯  ¯  (                                                 œ¡∂Åx^Iˇw^Hˇv\FˇtZFˇsXDˇqVBˇpUAˇnT?ˇmR=ˇkP<ˇjO;ˇ        yaPˇyaPˇ{dRˇ~hUˇÇjYˇáp]ˇåsaˇêxeˇì{iˇñ}jˇñ}jˇ∂óˇŒ≠îˇcJ5ˇ    œ¡∂Åär_ˇ°Öoˇ∂óˇπõÉˇΩ†âˇ¬¶èˇ…¨óˇŒ≥üˇ‘π¶ˇÿæ´ˇ¬¶èˇés^ˇ€¬ØˇdI6ˇ    ¬∑ØÄ´ûîˇ®öèˇ•óãˇ°íÜˇùéÇˇôâ}ˇñÜzˇïÖyˇîÑxˇìÉwˇìÉwˇ¬¶èˇñ{fˇdJ6ˇ        ﬁ◊“cÆüîˇÍﬁ÷ˇ¸Èˇ˚ÓÂˇ˚Î‡ˇ˙Ë›ˇ˙Ê◊ˇ˙‚”ˇ˙ﬂŒˇ˘›Àˇés^ˇ°ÖoˇeK6ˇ    v9ˇo2ˇl3ˇh2ˇc3ˇ]3ˇW3ˇR3ˇL3ˇH4ˇ÷Æêˇ÷Æêˇ˘›Ãˇés^ˇfK7ˇ     |>ˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇL4ˇ˚Á€ˇ÷Æêˇ˘ﬂ–ˇ∂óˇfL8ˇ    +ÑEˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇÖ©áˇo8ˇ]4ˇ[}_ˇQ3ˇ÷Æêˇ÷Æêˇ˙‰’ˇŒ≠îˇfL8ˇ    8éNˇãΩêˇv;ˇn9ˇb5ˇãΩêˇ>íGˇg:ˇü≥°ˇW3ˇ˝Èˇ÷Æêˇ˚Ë‹ˇ”¥õˇhM8ˇ    FòWˇˇˇˇˇãΩêˇQûWˇëƒñˇW¢Zˇ!p:ˇlõoˇﬂÈﬂˇ]3ˇ÷Æêˇ÷Æêˇ¸Î·ˇ◊ª¶ˇgM9ˇ    S¢`ˇˇˇˇˇœ›œˇñ∆öˇW¢Zˇ&|9ˇ'g1ˇ¿—¿ˇˇˇˇˇb3ˇ˝ˆÚˇ÷Æêˇ˝ÔÊˇ€¬ØˇhM9ˇ    ^™fˇÂÏÂˇçƒìˇd¨iˇ4âAˇo•sˇW†`ˇ:àFˇ÷‚÷ˇh2ˇ÷Æêˇ÷Æêˇ˝ÒÍˇﬁ»∑ˇ/*++

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