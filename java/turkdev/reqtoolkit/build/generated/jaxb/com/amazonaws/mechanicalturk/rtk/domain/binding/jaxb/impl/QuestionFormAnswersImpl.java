readme.txt
[!if APP_TYPE_DLG]
dlgroot.h
dlgroot.cpp
dialog.h
dialog.cpp
[!else]
root.h
root.cpp
[!endif]

stdafx.h
stdafx.cpp

[!if !APP_TYPE_DLG]
frame.h
frame.cpp
[!if DOCVIEW]
doc.h
doc.cpp
view.h
view.cpp
[!else]
wndview.h
wndview.cpp
[!endif]
[!endif]

[!if HAS_SUFFIX]
root.reg
[!endif]

[!if APP_TYPE_DLG]
[!if STANDARDSHELL_UI_MODEL]
dlgres.h
dlgall.rc
root.rc2
[!endif]
[!if AYGSHELL_UI_MODEL]
dlgresayg.h
dlgallayg.rc
rootayg.rc2
[!endif]
[!if POCKETPC2003_UI_MODEL]
dlgresppc.h
dlgallppc.rc
rootppc.rc2
[!endif]
[!if SMARTPHONE2003_UI_MODEL]
dlgressp.h
dlgallsp.rc
rootsp.rc2
[!endif]
[!else]
[!if STANDARDSHELL_UI_MODEL]
resource.h
root.rc
root.rc2
[!endif]
[!if AYGSHELL_UI_MODEL]
resourceayg.h
rootayg.rc
rootayg.rc2
[!endif]
[!if POCKETPC2003_UI_MODEL]
resourceppc.h
rootppc.rc
rootppc.rc2
[!endif]
[!if SMARTPHONE2003_UI_MODEL]
resourcesp.h
rootsp.rc
rootsp.rc2
[!endif]
[!endif]

[!if APP_TYPE_SDI || APP_TYPE_SDI_DOCLIST]
[!if DOCVIEW]
CopyOnly | doc.ico
[!endif]
[!endif]

CopyOnly | root.ico

[!if !POCKETPC2003_UI_MODEL]
[!if !APP_TYPE_DLG]
[!if CMD_BAR_MENUNBUTTON]
[!if DOCVIEW]
[!if PRINTING]
CopyOnly | tba__.bmp
[!else]
CopyOnly | tbah_.bmp
[!endif]
[!else]
CopyOnly | tbnd_.bmp
[!endif]
[!endif]
[!endif]
[!else]
[!if !APP_TYPE_DLG]
[!if CMD_BAR_MENUNBUTTON]
[!if APP_TYPE_SDI_DOCLIST]
CopyOnly | tba_rap.bmp
[!else]
CopyOnly | tbnd_.bmp
[!endif]
[!endif]
[!endif]
[!endif]
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          !<arch>
/               1127463553              0       1648      `
   S  j  �  �  P  P  $  $  �  �        p  p  �  �  �  �  *  *  �  �  �  �  j  j  �  �  �  �      6  6  n  n  �  �  >  >  �  �  x  x  �  �      t  t  �  �  B  B  �  �      N  N  �  �      �  �  �  �   L   L   �   �  !  !  !�  !�  !�  !�  "N  "N  (  (  �  �__IMPORT_DESCRIPTOR_msvcr80d __NULL_IMPORT_DESCRIPTOR msvcr80d_NULL_THUNK_DATA __CxxFrameHandler3 __imp___CxxFrameHandler3 _CrtDbgReportW __imp__CrtDbgReportW _CrtGetReportHook __imp__CrtGetReportHook _CrtSetReportFile __imp__CrtSetReportFile _CrtSetReportHook __imp__CrtSetReportHook _CrtSetReportMode __imp__CrtSetReportMode __imp__gmtime64_s _gmtime64_s __imp__i64toa_s _i64toa_s __imp__i64tow_s _i64tow_s __imp__invalid_parameter _invalid_parameter __imp__itoa_s _itoa_s __imp__itow_s _itow_s __imp__ltoa_s _ltoa_s __imp__ltow_s _ltow_s __imp__localtime64_s _localtime64_s __imp__mktime64 _mktime64 __imp__strtoi64 _strtoi64 __imp__strtoui64 _strtoui64 __imp__time64 _time64 __imp__wmakepath_s _wmakepath_s __imp__wsplitpath_s _wsplitpath_s __imp__ui64toa_s _ui64toa_s __imp__ui64tow_s _ui64tow_s __imp__ultoa_s _ultoa_s __imp__ultow_s _ultow_s __imp__wcstoi64 _wcstoi64 __imp__wcstoui64 _wcstoui64 __imp_calloc calloc __imp_memcpy_s memcpy_s __imp_memmove_s memmove_s __imp_strcat_s strcat_s __imp_strcpy_s strcpy_s __imp_strncpy_s strncpy_s __imp_wcscat_s wcscat_s __imp_wcscpy_s wcscpy_s __imp_wcsftime wcsftime __imp_wcsncpy_s wcsncpy_s __imp_wcsnlen wcsnlen ??__C@YAXPAX0IHP6AX00@ZP6AX0@Z@Z __imp_??__C@YAXPAX0IHP6AX00@ZP6AX0@Z@Z ??__D@YAXPAX0IHP6AX00@ZP6AX0@Z@Z __imp_??__D@YAXPAX0IHP6AX00@ZP6AX0@Z@Z /               1127463553              0       1658      `
+   j  �  �  P  $  �     p  �  �  *  �  �  j  �  �    6  n  �  >  �  x  �    t  �  B  �    N  �    �  �  L   �   !  �!  �!  N"  (  �  S   * +     	    * +     	  
                        ! " # $ % & ' ( ) 
                        ! " # $ % & ' ( )  ??__C@YAXPAX0IHP6AX00@ZP6AX0@Z@Z ??__D@YAXPAX0IHP6AX00@ZP6AX0@Z@Z _CrtDbgReportW _CrtGetReportHook _CrtSetReportFile _CrtSetReportHook _CrtSetReportMode __CxxFrameHandler3 __IMPORT_DESCRIPTOR_msvcr80d __NULL_IMPORT_DESCRIPTOR __imp_??__C@YAXPAX0IHP6AX00@ZP6AX0@Z@Z __imp_??__D@YAXPAX0IHP6AX00@ZP6AX0@Z@Z __imp__CrtDbgReportW __imp__CrtGetReportHook __imp__CrtSetReportFile __imp__CrtSetReportHook __imp__CrtSetReportMode __imp___CxxFrameHandler3 __imp__gmtime64_s __imp__i64toa_s __imp__i64tow_s __imp__invalid_parameter __imp__itoa_s __imp__itow_s __imp__localtime64_s __imp__ltoa_s __imp__ltow_s __imp__mktime64 __imp__strtoi64 __imp__strtoui64 __imp__time64 __imp__ui64toa_s __imp__ui64tow_s __imp__ultoa_s __imp__ultow_s __imp__wcstoi64 __imp__wcstoui64 __imp__wmakepath_s __imp__wsplitpath_s __imp_calloc __imp_memcpy_s __imp_memmove_s __imp_strcat_s __imp_strcpy_s __imp_strncpy_s __imp_wcscat_s __imp_wcscpy_s __imp_wcsftime __imp_wcsncpy_s __imp_wcsnlen _gmtime64_s _i64toa_s _i64tow_s _invalid_parameter _itoa_s _itow_s _localtime64_s _ltoa_s _ltow_s _mktime64 _strtoi64 _strtoui64 _time64 _ui64toa_s _ui64tow_s _ultoa_s _ultow_s _wcstoi64 _wcstoui64 _wmakepath_s _wsplitpath_s calloc memcpy_s memmove_s strcat_s strcpy_s strncpy_s wcscat_s wcscpy_s wcsftime wcsncpy_s wcsnlen msvcr80d_NULL_THUNK_DATA msvcr80d.dll/   1127463553              0       499       `
f ��3C        .debug$S        C   �               @ B.idata$2           �   �          @ 0�.idata$6             �           @  �    	     msvcr80d.dll(              '�Microsoft (R) LINK                           "        "       " msvcr80d.dll  @comp.id'�{ ��                  .idata$2@  �   h .idata$6        .idata$4@  �    h .idata$5@  �    h     !                :            T   __IMPORT_DESCRIPTOR_msvcr80d __NULL_IMPORT_DESCRIPTOR msvcr80d_NULL_THUNK_DATA 
msvcr80d.dll/   1127463553              0       252       `
f ��3C�         .debug$S        C   d               @ B.idata$3           �               @ 0�    	     msvcr80d.dll(              '�Microsoft (R) LINK                     @comp.id'�{ ��                     __NULL_IMPORT_DESCRIPTOR msvcr80d.dll/   1127463553              0       281       `
f ��3C�         .debug$S        C   �               @ B.idata$5           �               @ 0�.idata$4           �               @ 0�    	     msvcr80d.dll(              '�Microsoft (R) LINK         @comp.id'�{ ��                     msvcr80d_NULL_THUNK_DATA 
msvcr80d.dll/   1127463553              0       66        `
  ��  f��3C.      ??__C@YAXPAX0IHP6AX00@ZP6AX0@Z@Z msvcr80d.dll msvcr80d.dll/   1127463553              0       66        `
  ��  f��3C.     ??__D@YAXPAX0IHP6AX00@ZP6AX0@Z@Z msvcr80d.dll msvcr80d.dll/   1127463553              0       48        `
  ��  f��3C     _CrtDbgReportW msvcr80d.dll msvcr80d.dll/   1127463553              0       51        `
  ��  f��3C     _CrtGetReportHook msvcr80d.dll 
msvcr80d.dll/   1127463553              0       51        `
  ��  f��3C     _CrtSetReportFile msvcr80d.dll 
msvcr80d.dll/   1127463553              0       51        `
  ��  f��3C     _CrtSetReportHook msvcr80d.dll 
msvcr80d.dll/   1127463553              0       51        `
  ��  f��3C     _CrtSetReportMode msvcr80d.dll 
msvcr80d.dll/   1127463553              0       52        `
  ��  f��3C      __CxxFrameHandler3 msvcr80d.dll msvcr80d.dll/   1127463553              0       45        `
  ��  f��3C     _gmtime64_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C   	  _i64toa_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C   
  _i64tow_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       52        `
  ��  f��3C      _invalid_parameter msvcr80d.dll msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C     _itoa_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C     _itow_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       48        `
  ��  f��3C     _localtime64_s msvcr80d.dll msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C     _ltoa_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C     _ltow_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C     _mktime64 msvcr80d.dll 
msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C     _strtoi64 msvcr80d.dll 
msvcr80d.dll/   1127463553              0       44        `
  ��  f��3C     _strtoui64 msvcr80d.dll msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C     _time64 msvcr80d.dll 
msvcr80d.dll/   1127463553              0       44        `
  ��  f��3C     _ui64toa_s msvcr80d.dll msvcr80d.dll/   1127463553              0       44        `
  ��  f��3C     _ui64tow_s msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C     _ultoa_s msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C     _ultow_s msvcr80d.dll msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C     _wcstoi64 msvcr80d.dll 
msvcr80d.dll/   1127463553              0       44        `
  ��  f��3C     _wcstoui64 msvcr80d.dll msvcr80d.dll/   1127463553              0       46        `
  ��  f��3C     _wmakepath_s msvcr80d.dll msvcr80d.dll/   1127463553              0       47        `
  ��  f��3C     _wsplitpath_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       40        `
  ��  f��3C     calloc msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C     memcpy_s msvcr80d.dll msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C     memmove_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C      strcat_s msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C   !  strcpy_s msvcr80d.dll msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C   "  strncpy_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C   #  wcscat_s msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C   $  wcscpy_s msvcr80d.dll msvcr80d.dll/   1127463553              0       42        `
  ��  f��3C   %  wcsftime msvcr80d.dll msvcr80d.dll/   1127463553              0       43        `
  ��  f��3C   &  wcsncpy_s msvcr80d.dll 
msvcr80d.dll/   1127463553              0       41        `
  ��  f��3C   '  wcsnlen msvcr80d.dll 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  