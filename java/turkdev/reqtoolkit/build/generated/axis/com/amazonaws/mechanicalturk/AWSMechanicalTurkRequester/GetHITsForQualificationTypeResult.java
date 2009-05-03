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
/*

 MAIN.CPP

 A simple TAPI dialer. 

 A dialog is presented allowing the user to 
 key in a phone number which is then dialed 
 using the TAPI function tapiRequestMakeCall.

*/

#include <windows.h>
#include <astdtapi.h>
#include <Aygshell.h>
#include "resource.h"

#define BUFSIZE		256

// Macro to simplify determining the number of elements in an array 
// (do *not* use this macro for pointers)
#define ARRAY_LENGTH(x) (sizeof(x)/sizeof((x)[0]))

// function declarations
BOOL ConfirmNumber(void);
BOOL DialNumber(void);
BOOL CALLBACK DialogProc(const HWND hDlg, const UINT uiMessage, 
						 const WPARAM wParam, const LPARAM lParam);

// globals variable declarations
HINSTANCE		ghInstance;
static TCHAR	gszDefaultNum[] = TEXT("+1 (425) 882-8080");
LPTSTR			gpszPhoneNum = gszDefaultNum;

// Purpose: Determine at runtime if the app is running on a smartphone device
static BOOL IsSmartphone() 
{
    TCHAR tszPlatform[64];

    if (TRUE == SystemParametersInfo(SPI_GETPLATFORMTYPE,
         sizeof(tszPlatform)/sizeof(*tszPlatform),tszPlatform,0))
    {
        if (0 == _tcsicmp(TEXT("Smartphone"), tszPlatform)) 
        {
            return TRUE;
        }
    }
    return FALSE;   
}
// ***************************************************************************
// Function Name: WinMain
//
// Purpose: Main entry point into the HelloTAPI program
//
// Arguments: Standard WinMain arguments
//
// Return Values: 0
//
// Description:
//	Our WinMain function essentialy just pops up a Dialog box to request a
//	phone number to dial.  Then, based on the return value of that Dialog box,
//	it (a) does nothing, (b) confirms, then dials the number, (c) dials.

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, 
				   LPTSTR lpCmdLine, int nShowCmd)
{
	// flag
	int iTryDial = 1;

	// store the hInstance
	ghInstance = hInstance;

	// Create the dialog box. 
    // The dialog box is modal so control will not be returned to this 
    // function until the callback function (DialogPrc) has been invoked 
    // and has called EndDialog.
    //
    // Note the use of the MAKEINTRESOURCE macro to set the high-order 
    // word of the resource identifier to zero as it is passed to DialogBox 
	iTryDial = DialogBox(ghInstance, MAKEINTRESOURCE(IDD_DIALOG1), 0, (DLGPROC)DialogProc);

    // switch on the value set in DialogProc and do the 
    // appropriate action. 
	switch (iTryDial) 
    {
		case 0: // cancel
			// do nothing
			break;
		case 1: // confirm, then dial
			if (ConfirmNumber()) 
            {
				if (!DialNumber()) 
                {
					MessageBox(NULL, TEXT("Doh!!!"), TEXT("Phone Call Failed"), MB_OK);
				}
			}
			break;
		case 2: // dial now
			if (!DialNumber()) 
            {
				MessageBox(NULL, TEXT("Doh!!!"), TEXT("Phone Call Failed"), MB_OK);
			}
			break;
		default: // error
			MessageBox(NULL, TEXT("An error has occurred while initializing the dialog box."),
					   TEXT("Error!!!"), MB_OK);
			break;
	}

	return 0;
}

// ***************************************************************************
// Function Name: DialogProc
// 
// Purpose: Message Handler for HelloTAPI Dialog Box
//
// Arguments: Standard Dialog Procedure Arguments
//
// Return Values:
//	Returns a number between -1 and 2, inclusive, indicating the following:
//	   -1	An error occurred while initializing the Dialog
//		0	Cancel was pressed
//		1	Confirm, then Dial
//		2	Dial Immediately
//
// Side Effects:
//	Sets gpszPhoneNum to point to either a copy of the number entered, or
//	to the default number.
//	
// Description:
//	Dialog Procedure for the main HelloMAPI Dialog.  Accepts a phone number as
//	input and copies it to a global variable.  Demonstrates use of SoftKey menus
//	as well (user can Dial or Cancel).

BOOL CALLBACK DialogProc(const HWND hDlg, const UINT uiMessage, 
						 const WPARAM wParam, const LPARAM lParam)
{
	BOOL	bProcessedMsg = true;
	int		iDial = 1;
	DWORD	dwFlags = 0;

	
	switch(uiMessage)
	{
		case WM_INITDIALOG:
            // This is a standard message received before the dialog
            // box is displayed so initialise and set up the resources.

            // Specify that the dialog box should stretch full screen
			SHINITDLGINFO shidi;
			
			ZeroMemory(&shidi, sizeof(shidi));
            
			dwFlags = SHIDIF_SIZEDLGFULLSCREEN;

			if (!IsSmartphone())
			{
				dwFlags |= SHIDIF_DONEBUTTON;
			}
			shidi.dwMask = SHIDIM_FLAGS;
            shidi.dwFlags = dwFlags;
            shidi.hDlg = hDlg;
            
			// Set up the menu bar
			SHMENUBARINFO shmbi;
			ZeroMemory(&shmbi, sizeof(shmbi));
            shmbi.cbSize = sizeof(shmbi);
            shmbi.hwndParent = hDlg;
            shmbi.nToolBarId = IDR_HELLOMAPI_APPMENUBAR;
            shmbi.hInstRes = ghInstance;
			

			// If we could not initialize the dialog box, return an error
			if (!(SHInitDialog(&shidi) && SHCreateMenuBar(&shmbi))) 
            {
				EndDialog(hDlg, -1);
			}
            else
			// set the title bar 
            {
                TCHAR sz[160]; 
                LoadString(ghInstance, IDS_HELLOMAPI_TITLE, sz, ARRAY_LENGTH(sz)); 
                SetWindowText(hDlg, sz); 
            } 
			break;

		case WM_COMMAND:
            // An event has occured in the dialog box
            // The low-order word of wParam specifies the identifier 
            // of the menu item, control, or accelerator.
			switch (LOWORD(wParam)) 
            {
				case IDM_HELLOMAPI_DIALNOW:
					// Increment iDial, so that EndDialog returns 2
					// This is because we want to distinguish between confirm
					// and no confirm.  Fall through the case.
					++iDial;
				case IDM_HELLOMAPI_CONFIRM:
					// malloc space for the phone number
					gpszPhoneNum = (LPTSTR) malloc(BUFSIZE * sizeof(TCHAR));
					if (!gpszPhoneNum) 
                    {
						gpszPhoneNum = gszDefaultNum;
						EndDialog(hDlg, -1);
                        break;
					}

					// get the number - set to default if empty
					if (!GetDlgItemText(hDlg, IDC_PHONENUM, gpszPhoneNum, 
										BUFSIZE - 1)) 
                    {
						free(gpszPhoneNum);
						gpszPhoneNum = gszDefaultNum;
					}

					EndDialog(hDlg, iDial); 
					break;
				case IDM_HELLOMAPI_CANCEL:
				case IDOK:
					// do nothing
					EndDialog(hDlg, 0);
					break;
			}
			break;

		default:
			// nothing was processed
			bProcessedMsg = false;
			break;
	}

	return bProcessedMsg;
}

// ***************************************************************************
// Function Name: ConfirmNumber
// 
// Purpose: 
//	Give the user one last chance to confirm that the number they entered
//	is indeed the one they want to dial.
//
// Arguments: None
//
// Return Values:
//	TRUE if ok to Dial, FALSE if not ok
//
// Description:
//	Pops up a YESNO Message box allowing the user to confirm the number
//	to be dialed.

BOOL ConfirmNumber(void)
{
	int				iResult;
	TCHAR			szTemp[BUFSIZE];
	TCHAR			szConfirmString[BUFSIZE];

	// sanity check
	ASSERT(gpszPhoneNum && *gpszPhoneNum);

	// Create Confirmation String. MessageBox requires a 0 terminated string.
    LoadString(ghInstance, IDS_HELLOMAPI_AREYOUSURE, szTemp, ARRAY_LENGTH(szTemp));
    StringCchPrintf(szConfirmString, BUFSIZE, TEXT("%s %s?"), szTemp, gpszPhoneNum);
    

	// Confirm the number to be dialed.
    LoadString(ghInstance, IDS_HELLOMAPI_DIALCONFIRMATION, szTemp, ARRAY_LENGTH(szTemp));
	iResult = MessageBox(NULL, szConfirmString, szTemp, MB_YESNO);

	// Dial the number?
	return (IDYES == iResult);
}

// ***************************************************************************
// Function Name: DialNumber
//
// Purpose: Attempt to dial a phone number with tapiRequestMakeCall
//
// Arguments: none
//
// Return Values:
//	TRUE if dial attempt was successful, FALSE otherwise
//	Note: even a busy signal is considered a successful dial
//
// Description:
//	Essentially all this function does is tries to make a phone call.
//	If the call is not successful, one might be interested in the return
//	value of tapiRequestMakeCall, but in this program we are content just to
//	return whether the call was successful or not.

BOOL DialNumber(void)
{
	LONG lResult;
	lResult = tapiRequestMakeCall(gpszPhoneNum, NULL, NULL, NULL);
	return (0 == lResult);
}
                                                                                                                                                                                                                                                     	               	  "      ÿÿ   /   >   „   “   %ÿÿÿÿÿÿÿÿ×  € RSOP_IEToolbarButtonLink  Locale  Association  policySetting f                
  €   h     €   ÿÿ ref:RSOP_IEAKPolicySetting  toolbarButton f              
  €   ½     €   ÿÿ ref:RSOP_IEToolbarButton           €    êÔÊÊÆø       '               	  
      +   S   c   Š      Ä   Õ   ü     2  :  l  |  ®  Á  è  ú  !  /  UUõÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿÿW € RSOP_IEProxySettings  Locale  enableProxy               
  €   J    boolean  ftpProxyServer               
  €   ‚    string  gopherProxyServer               
  €   ¼    string  httpProxyServer               
  €   ô    string  proxyOverride               
  €   *   string  rsopID                 
  €   d    €   ÿÿ string  rsopPrecedence               
  €   ¦    €   ÿÿ uint32  secureProxyServer               
  €   à   string  socksProxyServer    	            
  €      string  useSameProxy     
          
  €   N   boolean           €   R S O P _ I E P r o x y S