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
// dvdnav.idl : IDL source for dvdnav.dll
//

// This file will be processed by the MIDL tool to
// produce the type library (dvdnav.tlb) and marshalling code.
		
		import "unknwn.idl";
		import "dvdcom.idl";
		import "dvdata.idl";

//byteProgramType in ProgramSearch
cpp_quote("#define	DVD_PROGRAM_PREVIOUS 0")
cpp_quote("#define	DVD_PROGRAM_NEXT 1")
cpp_quote("#define	DVD_PROGRAM_TOP 2")

//byteMenuId in MenuCall
cpp_quote("#define	DVD_MENU_TITLE 0")
cpp_quote("#define	DVD_MENU_ROOT 1")
cpp_quote("#define	DVD_MENU_SUBPICTURE 2")
cpp_quote("#define	DVD_MENU_AUDIO 3")
cpp_quote("#define	DVD_MENU_ANGLE 4")
cpp_quote("#define	DVD_MENU_PTT 5")

//no in GetSParameter & SetSParameter
cpp_quote("#define	SPRM_M_LCD 0")
cpp_quote("#define	SPRM_ASTN 1")
cpp_quote("#define	SPRM_SPSTN 2")
cpp_quote("#define	SPRM_AGLN 3")
cpp_quote("#define	SPRM_TTN 4")
cpp_quote("#define	SPRM_VTS_TTN 5")
cpp_quote("#define	SPRM_TT_PGCN 6")
cpp_quote("#define	SPRM_PTTN 7")
cpp_quote("#define	SPRM_HL_BTNN 8")
cpp_quote("#define	SPRM_NV_TMR 9")
cpp_quote("#define	SPRM_NV_TMR_PGCN 10")
cpp_quote("#define	SPRM_P_AMXMD 11")
cpp_quote("#define	SPRM_CTY_CD 12")
cpp_quote("#define	SPRM_PTL_LVL 13")
cpp_quote("#define	SPRM_P_CFG_VIDEO 14")
cpp_quote("#define	SPRM_P_CFG_AUDIO 15")
cpp_quote("#define	SPRM_INI_LCD_AST 16")
cpp_quote("#define	SPRM_INI_LCD_EXT_AST 17")
cpp_quote("#define	SPRM_INI_LCD_SPST 18")
cpp_quote("#define	SPRM_INI_LCD_EXT_SPST 19")
cpp_quote("#define	SPRM_REGION 20")


//Scan capabilities bits
//GetScanCaps bit masks definition
cpp_quote("#ifndef _DVD_SCANCAPS_DEFINED_")
cpp_quote("#define _DVD_SCANCAPS_DEFINED_")
cpp_quote("#define DVD_SCANCAP_FORWARD_SCAN		0x1")
cpp_quote("#define DVD_SCANCAP_FORWARD_SLOW		0x2")
cpp_quote("#define DVD_SCANCAP_FORWARD_SINGLE	0x4")
cpp_quote("#define DVD_SCANCAP_BACKWARD_SCAN	0x8")
cpp_quote("#define DVD_SCANCAP_BACKWARD_SLOW	0x10")
cpp_quote("#define DVD_SCANCAP_BACKWARD_SINGLE	0x20")
cpp_quote("#endif")

typedef struct 
{
	UINT8 userData[9+64*3];
} DVDUserGOPData;


typedef	enum 
{
	DVD_STOPPED,
	DVD_PAUSED,
	DVD_STILLED,
	DVD_NORMAL_PLAY,
	DVD_FORWARD_SCAN,
	DVD_FORWARD_SLOW,
	DVD_FORWARD_SINGLE,
	DVD_BACKWARD_SCAN,
	DVD_BACKWARD_SLOW,
	DVD_BACKWARD_SINGLE
} EDDVDPlaybackState;



	interface IDVDVideoVolume;

	[
		object,
		uuid(07C89F52-C72E-11D0-A985-00A0C9050598),
		helpstring("IDVDUserOperation Interface"),
		pointer_default(unique)
	]
	interface IDVDUserOperation : IUnknown
	{
		import "oaidl.idl";
		HRESULT TitlePlay(BYTE byteTitleNumber);
		HRESULT PartPlay(BYTE byteTitleNumber, USHORT uhPartOfTheTitle);
		HRESULT TimePlay(BYTE byteTitleNumber, UINT uiBCDTime);
		HRESULT Stop();
		HRESULT GoUp();
		HRESULT TimeSearch(UINT uiBCDTime);
		HRESULT PTTSearch(USHORT uhPartOfTheTitle);
		HRESULT ProgramSearch(BYTE byteProgramType);
		HRESULT ForwardScan(double dblSpeed);
		HRESULT BackwardScan(double dblSpeed);
		HRESULT MenuCall(BYTE byteMenu_ID);
		HRESULT Resume();
		HRESULT ButtonSelect(BYTE byteDirection);
		HRESULT ButtonActivate();
		HRESULT ButtonSelectAndActivate(BYTE byteButtonNumber);
		HRESULT StillOff();
		HRESULT Pause(BOOL bOnOff);
		HRESULT MenuLanguageSelect(USHORT uhLanguageCode);
		HRESULT ChangeAudioStream(BYTE byteStreamNumber);
		HRESULT ChangeSubpictureStream (BYTE streamNumber, BOOL bDisplayFlag);
		HRESULT ChangeAngle(BYTE byteAngleNumber);
		HRESULT ParentalLevelSelect(BYTE byteLevel);
		HRESULT ParentalCountrySelect(USHORT uhCountryCode);
		HRESULT KaraokeAudioModePresentationChange(USHORT  uhKaraokeMode);
		HRESULT VideoPresentationModeChange(USHORT uhVideoMode);
	};


	[
		object,
		uuid(07C89F53-C72E-11D0-A985-00A0C9050598),
		helpstring("IDVDNavigationManager Interface"),
		pointer_default(unique)
	]
	interface IDVDNavigationManager : IUnknown
	{
		HRESULT SetVolume(IDVDVideoVolume *pVolume);

		//added for M3
		HRESULT GetSParameter(UINT8 no, UINT16 *pValue);
		HRESULT GetGParameter(UINT8 no, UINT16 *pValue, BOOL *pbCounterMode);
		HRESULT SetSParameter(UINT8 no, UINT16 wValue);
		HRESULT GetScanCaps(UINT16 *pMask);
		HRESULT GetPlaybackState(EDDVDPlaybackState *peState);

		//added for M4
		HRESULT UseRenderer(WCHAR *pszRendererName); //to be optionally called before SetVolume

		//added for M4 mouse over
		HRESULT ButtonSelectDirect(BYTE byteButtonNumber);

	};


typedef enum
{
	InsufficientParentalLevel,
	FatalNavigationError
} EDVDNavException;

typedef enum
{
	InitialAccess,
	TitlePartTimePlay,
	MenuCallToVmgmDom,
	MenuCallToVtsmDom
} EDVDSParamEvent;


	[
		object,
		uuid(212CD034-45B4-11d5-84F2-00C04F68EB0F),
		helpstring("IDVDNavigatorSink Interface"),
		pointer_default(unique)
	]
	interface IDVDNavigatorSink : IUnknown
	{
		HRESULT OnSPRMChange(UINT8 no, UINT16 wValue);
		HRESULT OnGPRMChange(UINT8 no, UINT16 wValue, BOOL bCounter);
		HRESULT OnNewProgramChain(IDVDProgramChain *pChain);
		HRESULT OnNewProgram(UINT8 progNo);
		HRESULT OnNewCell(UINT8 cellNo);
		HRESULT OnGOPUserData(DVDUserGOPData *pData);
		HRESULT OnUOPChange(UINT32 newUOPMask);
		HRESULT OnPlaybackStateChange(EDDVDPlaybackState eState);
		HRESULT OnDiskReadError(DWORD osCode);
		HRESULT ConfirmTemporaryParentalLevel(UINT8 requestedLevel);
		HRESULT OnNavigationException(EDVDNavException excCode);
		HRESULT InitializeSystemParameters(EDVDSParamEvent eventCode);
	};

[
	uuid(07C89F51-C72E-11D0-A985-00A0C9050598),
	version(1.0),
	helpstring("dvdnav 1.0 Type Library")
]
library DVDNAVLib
{
	importlib("stdole32.tlb");

	[
		uuid(07C89F56-C72E-11D0-A985-00A0C9050598),
		helpstring("DVDNavigationManager Class")
	]
	coclass DVDNavigationManager
	{
		[default] interface IDVDUserOperation;
		interface IDVDNavigationManager;
	};

};
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ich Visual Studio depends. 
					As a result, Visual Studio smart device functionality might be impaired.</FONT></P>
			<P class="labelproc"><FONT face="Arial"><B>To resolve this issue</B> </FONT>
			<P><FONT face="Arial">Repair-installing Visual Studio fixes the problem.</FONT></P>
			<P>&nbsp;</P>
		</DIV>
		<H1><FONT face="Arial"><A name="SourceCode" size="5"></A>4. Source Code Control 
				Integration</FONT></H1>
		<H1><FONT face="Arial">4.1. Product Installation </FONT>
		</H1>
		<br>
		<H1><FONT face="Arial"><A name="crystalReport"></A>5. Crystal Reports</FONT></H1>
		<DIV class="indent" id="DIV1"><p><font face="Arial">For additional information concerning 
					Crystal Reports for Visual Studio 2005, please visit us at: <a href="http://www.businessobjects.com/products/reporting/crystalreports/net/vsnet.asp">
						http://www.businessobjects.com/products/reporting/crystalreports/net/vsnet.asp</a></font></p>
			<P>&nbsp;</P>
		</DIV>
		</FONT>
	</BODY>
</HTML>
                        .\" DO NOT MODIFY THIS FILE!  It was generated by help2man 1.33.
.TH SDIFF "1" "April 2004" "diffutils 2.8.7" "User Commands"
.SH NAME
sdiff \- side-by-side merge of file differences
.SH SYNOPSIS
.B sdiff
[\fIOPTION\fR]... \fIFILE1 FILE2\fR
.SH DESCRIPTION
Side-by-side merge of file differences.
.TP
\fB\-o\fR FILE  \fB\-\-output\fR=\fIFILE\fR
Operate interactively, sending output to FILE.
.TP
\fB\-i\fR  \fB\-\-ignore\-case\fR
Consider upper- and lower-case to be the same.
.TP
\fB\-E\fR  \fB\-\-ignore\-tab\-expansion\fR
Ignore changes due to tab expansion.
.TP
\fB\-b\fR  \fB\-\-ignore\-space\-change\fR
Ignore changes in the amount of white space.
.TP
\fB\-W\fR  \fB\-\-ignore\-all\-space\fR
Ignore all white space.
.TP
\fB\-B\fR  \fB\-\-ignore\-blank\-lines\fR
Ignore changes whose lines are all blank.
.TP
\fB\-I\fR RE  \fB\-\-ignore\-matching\-lines\fR=\fIRE\fR
Ignore changes whose lines all match RE.
.TP
\fB\-\-strip\-trailing\-cr\fR
Strip trailing carriage return on input.
.TP
\fB\-a\fR  \fB\-\-text\fR
Treat all files as text.
.TP
\fB\-w\fR NUM  \fB\-\-width\fR=\fINUM\fR
Output at most NUM (default 130) print columns.
.TP
\fB\-l\fR  \fB\-\-left\-column\fR
Output only the left column of common lines.
.TP
\fB\-s\fR  \fB\-\-suppress\-common\-lines\fR
Do not output common lines.
.TP
\fB\-t\fR  \fB\-\-expand\-tabs\fR
Expand tabs to spaces in output.
.TP
\fB\-\-tabsize\fR=\fINUM\fR
Tab stops are every NUM (default 8) print columns.
.TP
\fB\-d\fR  \fB\-\-minimal\fR
Try hard to find a smaller set of changes.
.TP
\fB\-H\fR  \fB\-\-speed\-large\-files\fR
Assume large files and many scattered small changes.
.TP
\fB\-\-diff\-program\fR=\fIPROGRAM\fR
Use PROGRAM to compare files.
.TP
\fB\-v\fR  \fB\-\-version\fR
Output version info.
.TP
\fB\-\-help\fR
Output this help.
.PP
If a FILE is `-', read standard input.
Exit status is 0 if inputs are the same, 1 if different, 2 if trouble.
.SH AUTHOR
Written by Thomas Lord.
.SH "REPORTING BUGS"
Report bugs to <bug-gnu-utils@gnu.org>.
.SH COPYRIGHT
Copyright \(co 2004 Free Software Foundation, Inc.
.br
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
.SH "SEE ALSO"
The full documentation for
.B sdiff
is maintained as a Texinfo manual.  If the
.B info
and
.B sdiff
programs are properly installed at your site, the command
.IP
.B info diff
.PP
should give you access to the complete manual.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          