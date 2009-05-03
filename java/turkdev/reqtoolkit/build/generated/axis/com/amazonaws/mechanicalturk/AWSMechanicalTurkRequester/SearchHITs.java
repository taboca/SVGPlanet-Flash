_VCR_SETTUNER_CHANNEL_UP             0x00020000L
#define MCI_VCR_SETTUNER_CHANNEL_DOWN           0x00040000L
#define MCI_VCR_SETTUNER_CHANNEL_SEEK_UP        0x00080000L
#define MCI_VCR_SETTUNER_CHANNEL_SEEK_DOWN      0x00100000L
#define MCI_VCR_SETTUNER_NUMBER                 0x00200000L

/* flags for dwFlags parameter of MCI_SET command message */
#define MCI_VCR_SET_TIME_MODE                   0x00010000L
#define MCI_VCR_SET_POWER                       0x00020000L
#define MCI_VCR_SET_RECORD_FORMAT               0x00040000L
#define MCI_VCR_SET_COUNTER_FORMAT              0x00080000L
#define MCI_VCR_SET_INDEX                       0x00100000L
#define MCI_VCR_SET_ASSEMBLE_RECORD             0x00200000L
#define MCI_VCR_SET_TRACKING                    0x00400000L
#define MCI_VCR_SET_SPEED                       0x00800000L
#define MCI_VCR_SET_TAPE_LENGTH                 0x01000000L
#define MCI_VCR_SET_COUNTER_VALUE               0x02000000L
#define MCI_VCR_SET_CLOCK                       0x04000000L
#define MCI_VCR_SET_PAUSE_TIMEOUT               0x08000000L
#define MCI_VCR_SET_PREROLL_DURATION            0x10000000L
#define MCI_VCR_SET_POSTROLL_DURATION           0x20000000L

/* flags for dwItem parameter of MCI_SETTIMECODE commmand message */
#define MCI_VCR_SETTIMECODE_RECORD              0x00010000L

/* flags for dwItem field of MCI_STATUS_PARMS parameter block */
#define MCI_VCR_STATUS_FRAME_RATE               0x00004001L /* Frame rate   */
#define MCI_VCR_STATUS_SPEED                    0x00004002L /* Speed        */
#define MCI_VCR_STATUS_MEDIA_TYPE               0x00004003L
#define MCI_VCR_STATUS_RECORD_FORMAT            0x00004004L
#define MCI_VCR_STATUS_PLAY_FORMAT              0x00004005L
#define MCI_VCR_STATUS_AUDIO_SOURCE             0x00004006L
#define MCI_VCR_STATUS_AUDIO_SOURCE_NUMBER      0x00004007L
#define MCI_VCR_STATUS_VIDEO_SOURCE             0x00004008L
#define MCI_VCR_STATUS_VIDEO_SOURCE_NUMBER      0x00004009L
#define MCI_VCR_STATUS_AUDIO_MONITOR            0x0000400AL
#define MCI_VCR_STATUS_AUDIO_MONITOR_NUMBER     0x0000400BL
#define MCI_VCR_STATUS_VIDEO_MONITOR            0x0000400CL
#define MCI_VCR_STATUS_VIDEO_MONITOR_NUMBER     0x0000400DL
#define MCI_VCR_STATUS_INDEX_ON                 0x0000400EL
#define MCI_VCR_STATUS_INDEX                    0x0000400FL
#define MCI_VCR_STATUS_COUNTER_FORMAT           0x00004010L
#define MCI_VCR_STATUS_COUNTER_RESOLUTION       0x00004011L
#define MCI_VCR_STATUS_TIMECODE_TYPE            0x00004012L
#define MCI_VCR_STATUS_COUNTER_VALUE            0x00004013L
#define MCI_VCR_STATUS_TUNER_CHANNEL            0x00004014L
#define MCI_VCR_STATUS_WRITE_PROTECTED          0x00004015L
#define MCI_VCR_STATUS_TIMECODE_RECORD          0x00004016L
#define MCI_VCR_STATUS_VIDEO_RECORD             0x00004017L
#define MCI_VCR_STATUS_AUDIO_RECORD             0x00004018L
#define MCI_VCR_STATUS_TIME_TYPE                0x00004019L
#define MCI_VCR_STATUS_TIME_MODE                0x0000401AL
#define MCI_VCR_STATUS_POWER_ON                 0x0000401BL
#define MCI_VCR_STATUS_CLOCK                    0x0000401CL
#define MCI_VCR_STATUS_ASSEMBLE_RECORD          0x0000401DL
#define MCI_VCR_STATUS_TIMECODE_PRESENT         0x0000401EL
#define MCI_VCR_STATUS_NUMBER_OF_VIDEO_TRACKS   0x0000401FL
#define MCI_VCR_STATUS_NUMBER_OF_AUDIO_TRACKS   0x00004020L
#define MCI_VCR_STATUS_CLOCK_ID                 0x00004021L
#define MCI_VCR_STATUS_PAUSE_TIMEOUT            0x00004022L
#define MCI_VCR_STATUS_PREROLL_DURATION         0x00004023L
#define MCI_VCR_STATUS_POSTROLL_DURATION        0x00004024L
#define MCI_VCR_STATUS_VIDEO                    0x00004025L
#define MCI_VCR_STATUS_AUDIO                    0x00004026L

#define MCI_VCR_STATUS_NUMBER                   0x00080000L

/* flags for dwFlags parameter of MCI_ESCAPE command message */
#define MCI_VCR_ESCAPE_STRING                   0x00000100L

/* flags for dwFlags parameter of MCI_LIST command message */
#define MCI_VCR_LIST_VIDEO_SOURCE               0x00010000L
#define MCI_VCR_LIST_AUDIO_SOURCE               0x00020000L
#define MCI_VCR_LIST_COUNT                      0x00040000L
#define MCI_VCR_LIST_NUMBER                     0x00080000L

/* flags for dwFlags parameter of MCI_MARK command message */
#define MCI_VCR_MARK_WRITE                      0x00010000L
#define MCI_VCR_MARK_ERASE                      0x00020000L

/* flags for dwFlags parameter for MCI_SETAUDIO command message */
#define MCI_VCR_SETAUDIO_RECORD                 0x00010000L
#define MCI_VCR_SETAUDIO_SOURCE                 0x00020000L
#define MCI_VCR_SETAUDIO_MONITOR                0x00040000L
#define MCI_VCR_SETAUDIO_TO                     0x00200000L
#define MCI_VCR_SETAUDIO_NUMBER                 0x00400000L

/* flags for dwFlags parameter for MCI_SETVIDEO command message */
#define MCI_VCR_SETVIDEO_RECORD                 0x00010000L
#define MCI_VCR_SETVIDEO_SOURCE                 0x00020000L
#define MCI_VCR_SETVIDEO_MONITOR                0x00040000L
#define MCI_VCR_SETVIDEO_TO                     0x00100000L
#define MCI_VCR_SETVIDEO_NUMBER                 0x00200000L

/* The following is the function digitalvideo drivers must use 
 * to signal when a frame marked by the SIGNAL command has been rendered:
 *
 *  SEND_VCRSIGNAL(dwFlags, dwCallback, hDriver, wDeviceID, dwUser, dwPos )
 *
 * The following is a description of the parameters:
 *
 *  dwFlags    - the dwFlags parameter passed when the signal was set
 *  dwCallback - the dwCallback value from the MCI_VCR_SIGNAL_PARMS struct
 *               used to set the signal
 *  hDriver    - the handle assigned to the driver by MMSYSTEM when the 
 *               device was opened
 *  wDeviceID  - the device ID
 *  dwUser     - the dwUserParm value from the MCI_VCR_SIGNAL_PARMS struct
 *               used to set the signal
 *  dwPos      - the position at which the signal was sent, in the current
 *               time format.
 *
 * The window indicated by the handle in the dwCallback field is notified 
 * by means of a Windows message with the following form:
 *
 * msg    = MM_MCISIGNAL
 * wParam = wDeviceID of the sending driver 
 * lParam = the uservalue specified or the position the signal was sent
 *          at; the latter if the MCI_VCR_SIGNAL_POSITION flag was set 
 *          in the dwFlags parameter when the signal was created.
 */

#define SEND_VCRSIGNAL(dwFlags, dwCallback, hDriver, wDeviceID, dwUser, dwPos ) \
  DriverCallback( (dwCallback), DCB_WINDOW, (HANDLE)(wDeviceID), MM_MCISIGNAL,\
  hDriver, ((dwFlags) & MCI_VCR_SIGNAL_POSITION) ? (dwPos):(dwUser),\
  ((dwFlags) & MCI_VCR_SIGNAL_POSITION) ? (dwUser):(dwPos))

/* Window message for signal notification */
#define MM_MCISIGNAL                            0x3CB

/* flags for dwFlags parameter of MCI_SIGNAL command message */
#define MCI_VCR_SIGNAL_AT                       0x00010000L
#define MCI_VCR_SIGNAL_EVERY                    0x00020000L
#define MCI_VCR_SIGNAL_USERVAL                  0x00040000L
#define MCI_VCR_SIGNAL_CANCEL                   0x00080000L
#define MCI_VCR_SIGNAL_POSITION                 0x00100000L

/* flags for dwFlags parameter of MCI_STEP command message */
#define MCI_VCR_STEP_FRAMES                     0x00010000L
#define MCI_VCR_STEP_REVERSE                    0x00020000L

/* flags for dwFlags parameter of MCI_FREEZE command message */
#define MCI_VCR_FREEZE_INPUT                    0x00010000L
#define MCI_VCR_FREEZE_OUTPUT                   0x00020000L
#define MCI_VCR_FREEZE_FIELD                    0x00040000L
#define MCI_VCR_FREEZE_FRAME                    0x00080000L

/* flags for dwFlags parameter of MCI_UNFREEZE command message */
#define MCI_VCR_UNFREEZE_INPUT                  0x00010000L
#define MCI_VCR_UNFREEZE_OUTPUT                 0x00020000L

/* string resource values for vcr media types */
#define MCI_VCR_MEDIA_8MM                       (MCI_VCR_OFFSET + 1)
#define MCI_VCR_MEDIA_HI8                       (MCI_VCR_OFFSET + 2)
#define MCI_VCR_MEDIA_VHS                       (MCI_VCR_OFFSET + 3)
#define MCI_VCR_MEDIA_SVHS                      (MCI_VCR_OFFSET + 4)
#define MCI_VCR_MEDIA_BETA                      (MCI_VCR_OFFSET + 5)
#define MCI_VCR_MEDIA_EDBETA                    (MCI_VCR_OFFSET + 6)
#define MCI_VCR_MEDIA_OTHER                     (MCI_VCR_OFFSET + 7)

/* string resource values for vcr play/record formats */
#define MCI_VCR_FORMAT_SP                       (MCI_VCR_OFFSET + 8)
#define MCI_VCR_FORMAT_LP                       (MCI_VCR_OFFSET + 9)
#define MCI_VCR_FORMAT_EP                       (MCI_VCR_OFFSET + 10)
#define MCI_VCR_FORMAT_OTHER                    (MCI_VCR_OFFSET + 11)

/* string resource values for timecode types */
#define MCI_VCR_TIME_TIMECODE                   (MCI_VCR_OFFSET + 12)
#define MCI_VCR_TIME_COUNTER                    (MCI_VCR_OFFSET + 13)
#define MCI_VCR_TIME_DETECT                     (MCI_VCR_OFFSET + 14)

/* string resource values for src types */
#define MCI_VCR_SRC_TYPE_TUNER                  (MCI_VCR_OFFSET + 15)
#define MCI_VCR_SRC_TYPE_LINE                   (MCI_VCR_OFFSET + 16)
#define MCI_VCR_SRC_TYPE_SVIDEO                 (MCI_VCR_OFFSET + 17)
#define MCI_VCR_SRC_TYPE_RGB                    (MCI_VCR_OFFSET + 18)
#define MCI_VCR_SRC_TYPE_AUX                    (MCI_VCR_OFFSET + 19)
#define MCI_VCR_SRC_TYPE_GENERIC                (MCI_VCR_OFFSET + 20)
#define MCI_VCR_SRC_TYPE_MUTE                   (MCI_VCR_OFFSET + 21)
#define MCI_VCR_SRC_TYPE_OUTPUT                 (MCI_VCR_OFFSET + 22)

/* string resource values for vcr counters */
#define MCI_VCR_INDEX_TIMECODE                  (MCI_VCR_OFFSET + 23)         
#define MCI_VCR_INDEX_COUNTER                   (MCI_VCR_OFFSET + 24)   
#define MCI_VCR_INDEX_DATE                      (MCI_VCR_OFFSET + 25)
#define MCI_VCR_INDEX_TIME                      (MCI_VCR_OFFSET + 26)

/* string resources for timecode type and counter resolution */
#define MCI_VCR_COUNTER_RES_SECONDS             (MCI_VCR_OFFSET + 27)            
#define MCI_VCR_COUNTER_RES_FRAMES              (MCI_VCR_OFFSET + 28)

#define MCI_VCR_TIMECODE_TYPE_SMPTE             (MCI_VCR_OFFSET + 29)
#define MCI_VCR_TIMECODE_TYPE_SMPTE_DROP        (MCI_VCR_OFFSET + 30)
#define MCI_VCR_TIMECODE_TYPE_OTHER             (MCI_VCR_OFFSET + 31)
#define MCI_VCR_TIMECODE_TYPE_NONE              (MCI_VCR_OFFSET + 32)

#define MCI_VCR_PLUS                            (MCI_VCR_OFFSET + 33)
#define MCI_VCR_MINUS                           (MCI_VCR_OFFSET + 34)
#define MCI_VCR_RESET                           (MCI_VCR_OFFSET + 35)

#ifndef RC_INVOKED

/* parameter block for MCI_SEEK command message */
typedef struct tagMCI_VCR_SEEK_PARMS {
    DWORD   dwCallback;
    DWORD   dwTo;
    DWORD   dwMark;
    DWORD   dwAt;
} MCI_VCR_SEEK_PARMS;
typedef MCI_VCR_SEEK_PARMS FAR *LPMCI_VCR_SEEK_PARMS;

/* parameter block for MCI_SET command message */
typedef struct tagMCI_VCR_SET_PARMS {
    DWORD   dwCallback;
    DWORD   dwTimeFormat;
    DWORD   dwAudio;
    DWORD   dwTimeMode;
    DWORD   dwRecordFormat;
    DWORD   dwCounterFormat;
    DWORD   dwIndex;
    DWORD   dwTracking;
    DWORD   dwSpeed;
    DWORD   dwLength;
    DWORD   dwCounter;
    DWORD   dwClock;
    DWORD   dwPauseTimeout;
    DWORD   dwPrerollDuration;
    DWORD   dwPostrollDuration;
} MCI_VCR_SET_PARMS;
typedef MCI_VCR_SET_PARMS FAR *LPMCI_VCR_SET_PARMS;

/* parameter block for MCI_VCR_SETTUNER command message */
typedef struct tagMCI_VCR_SETTUNER_PARMS {
    DWORD   dwCallback;
    DWORD   dwChannel;
    DWORD   dwNumber;
} MCI_VCR_SETTUNER_PARMS;
typedef MCI_VCR_SETTUNER_PARMS FAR *LPMCI_VCR_SETTUNER_PARMS;

/* parameter block for MCI_ESCAPE command message */
typedef struct tagMCI_VCR_ESCAPE_PARMS {
    DWORD   dwCallback;
    LPCSTR  lpstrCommand;
} MCI_VCR_ESCAPE_PARMS;
typedef MCI_VCR_ESCAPE_PARMS FAR *LPMCI_VCR_ESCAPE_PARMS;

/* parameter block for MCI_LIST command message */
typedef struct tagMCI_VCR_LIST_PARMS {
    DWORD   dwCallback;
    DWORD   dwReturn;
    DWORD   dwNumber;
} MCI_VCR_LIST_PARMS;
typedef MCI_VCR_LIST_PARMS FAR *LPMCI_VCR_LIST_PARMS;

/* parameter block for MCI_RECORD command message */
typedef struct tagMCI_VCR_RECORD_PARMS {
    DWORD   dwCallback;
    DWORD   dwFrom;
    DWORD 