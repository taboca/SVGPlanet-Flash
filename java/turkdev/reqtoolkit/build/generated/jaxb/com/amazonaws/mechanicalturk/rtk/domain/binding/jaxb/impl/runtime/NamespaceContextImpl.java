OO.widget.TextNode(dataObjd1e309, 
            root, false);
            
            
            
            var dataObjd1e310 = 
            { label: "Lukke eller genstarte Version Cue-serveren",
            href:"WS5864511A-E4E2-488f-96AD-6CB45155FF6B.html",
            target:"content"};
            var d1e310 = 
            new YAHOO.widget.TextNode(dataObjd1e310, 
            d1e309, false);
            
            
            
            var dataObjd1e311 = 
            { label: "genveje. Se tastaturgenveje"};
            var d1e311 = 
            new YAHOO.widget.TextNode(dataObjd1e311, 
            root, false);
            
            
            
            var dataObjd1e312 = 
            { label: "GPS-data (Global Positioning System)"};
            var d1e312 = 
            new YAHOO.widget.TextNode(dataObjd1e312, 
            root, false);
            
            
            
            var dataObjd1e313 = 
            { label: "Om panelet Metadata",
            href:"WSfd1234e1c4b69f30ea53e41001031ab64-734a.html",
            target:"content"};
            var d1e313 = 
            new YAHOO.widget.TextNode(dataObjd1e313, 
            d1e312, false);
            
            
            
            var dataObjd1e314 = 
            { label: "GPS-oplysninger i filer"};
            var d1e314 = 
            new YAHOO.widget.TextNode(dataObjd1e314, 
            root, false);
            
            
            
            var dataObjd1e315 = 
            { label: "Om panelet Metadata",
            href:"WSfd1234e1c4b69f30ea53e41001031ab64-734a.html",
            target:"content"};
            var d1e315 = 
            new YAHOO.widget.TextNode(dataObjd1e315, 
            d1e314, false);
            
         
            <!--[CDATA[
                tree.draw();
                }
                // ]]-->
        </script>
        
		</head>

    <body id="nav_body" onload="top.pageload(); treeInit();">
        <!-- BEGIN TABS -->
        <ul id="tabsRow">
            <li><a href="toc.html" id="tab_toc" class="tabOff"><script type="text/javascript">document.write(terms_AHV_CONTENTS_TAB);</script></a> |</li>
            <li><span class="highlight"><script type="text/javascript">document.write(terms_AHV_INDEX_TAB);</script></span></li>
        </ul>
        <!-- END TABS -->

        <!-- BEGIN NAV WRAPPER -->
        <div id="nav_wrapper">
            <!-- BEGIN INDEX CONTENT -->
            <div id="nav_content"><h2 class="hide">Indeks</h2><div class="letterList"><a href="index_1.html">Symboler |</a> <a href="index_2.html">A</a> <a href="index_3.html">B</a> <a href="index_4.html">C</a> <a href="index_5.html">D</a> <a href="index_6.html">E</a> <a href="index_7.html">F</a> <span class="highlight">G</span> <a href="index_9.html">H</a> <a href="index_10.html">I</a> <a href="index_11.html">K</a> <a href="index_12.html">L</a> <a href="index_13.html">M</a> <a href="index_14.html">N</a> <a href="index_15.html">O</a> <a href="index_16.html">P</a> <a href="index_17.html">R</a> <a href="index_18.html">S</a> <a href="index_19.html">T</a> <a href="index_20.html">U</a> <a href="index_21.html">V</a> <a href="index_22.html">W</a> <a href="index_23.html">X</a> <a href="index_24.html">Æ</a> <a href="index_25.html">Å</a> </div><div id="tree"></div></div>
            <!-- END INDEX CONTENT -->
        </div>
        <!-- END NAV WRAPPER -->
    </body>
		
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    //
// Copyright (c) Microsoft Corporation.  All rights reserved.
//
//
// Use of this source code is subject to the terms of the Microsoft end-user
// license agreement (EULA) under which you licensed this SOFTWARE PRODUCT.
// If you did not accept the terms of the EULA, you are not authorized to use
// this source code. For a copy of the EULA, please see the LICENSE.RTF on your
// install media.
//
//==========================================================================;
//
//  THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY
//  KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
//  IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR
//  PURPOSE.
//
//
//--------------------------------------------------------------------------;

#ifndef __PULLPIN_H__
#define __PULLPIN_H__

//
// CPullPin
//
// object supporting pulling data from an IAsyncReader interface.
// Given a start/stop position, calls a pure Receive method with each
// IMediaSample received.
//
// This is essentially for use in a MemInputPin when it finds itself
// connected to an IAsyncReader pin instead of a pushing pin.
//

class CPullPin : public CAMThread
{
    IAsyncReader*       m_pReader;
    REFERENCE_TIME      m_tStart;
    REFERENCE_TIME      m_tStop;
    REFERENCE_TIME      m_tDuration;
    BOOL                m_bSync;

    enum ThreadMsg {
	TM_Pause,       // stop pulling and wait for next message
	TM_Start,       // start pulling
	TM_Exit,        // stop and exit
    };

    ThreadMsg m_State;

    // override pure thread proc from CAMThread
    DWORD ThreadProc(void);

    // running pull method (check m_bSync)
    void Process(void);

    // clean up any cancelled i/o after a flush
    void CleanupCancelled(void);

    // suspend thread from pulling, eg during seek
    HRESULT PauseThread();

    // start thread pulling - create thread if necy
    HRESULT StartThread();

    // stop and close thread
    HRESULT StopThread();

    // called from ProcessAsync to queue and collect requests
    HRESULT QueueSample(
		REFERENCE_TIME& tCurrent,
		REFERENCE_TIME tAlignStop,
		BOOL bDiscontinuity);

    HRESULT CollectAndDeliver(
		REFERENCE_TIME tStart,
		REFERENCE_TIME tStop);

    HRESULT DeliverSample(
		IMediaSample* pSample,
		REFERENCE_TIME tStart,
		REFERENCE_TIME tStop);

protected:
    IMemAllocator *     m_pAlloc;

public:
    CPullPin();
    virtual ~CPullPin();

    // returns S_OK if successfully connected to an IAsyncReader interface
    // from this object
    // Optional allocator should be proposed as a preferred allocator if
    // necessary
    // bSync is TRUE if we are to use sync reads instead of the
    // async methods.
    HRESULT Connect(IUnknown* pUnk, IMemAllocator* pAlloc, BOOL bSync);

    // disconnect any connection made in Connect
    HRESULT Disconnect();

    // agree an allocator using RequestAllocator - optional
    // props param specifies your requirements (non-zero fields).
    // returns an error code if fail to match requirements.
    // optional IMemAllocator interface is offered as a preferred allocator
    // but no error occurs if it can't be met.
    virtual HRESULT DecideAllocator(
		IMemAllocator* pAlloc,
		ALLOCATOR_PROPERTIES * pProps);

    // set start and stop position. if active, will start immediately at
    // the new position. Default is 0 to duration
    HRESULT Seek(REFERENCE_TIME tStart, REFERENCE_TIME tStop);

    // return the total duration
    HRESULT Duration(REFERENCE_TIME* ptDuration);

    // start pulling data
    HRESULT Active(void);

    // stop pulling data
    HRESULT Inactive(void);

    // helper functions
    LONGLONG AlignDown(LONGLONG ll, LONG lAlign) {
	// aligning downwards is just truncation
	return ll & ~(lAlign-1);
    };

    LONGLONG AlignUp(LONGLONG ll, LONG lAlign) {
	// align up: round up to next boundary
	return (ll + (lAlign -1)) & ~(lAlign -1);
    };

    // GetReader returns the (addrefed) IAsyncReader interface
    // for SyncRead etc
    IAsyncReader* GetReader() {
	m_pReader->AddRef();
	return m_pReader;
    };

    // -- pure --

    // override this to handle data arrival
    // return value other than S_OK will stop data
    virtual HRESULT Receive(IMediaSample*) PURE;

    // override this to handle end-of-stream
    virtual HRESULT EndOfStream(void) PURE;

    // called on runtime errors that will have caused pulling
    // to stop
    // these errors are all returned from the upstream filter, who
    // will have already reported any errors to the filtergraph.
    virtual void OnError(HRESULT hr) PURE;

    // flush this pin and all downstream
    virtual HRESULT BeginFlush() PURE;
    virtual HRESULT EndFlush() PURE;

};

#endif //__PULLPIN_H__
                                                                                                                                                                                                �0   �0   �0   �0   �0   �0   �0   �0   �0   0 �   ds                                            ���� 1    (1 �   �t                    ����@1    H1 �   �t                    ����`1 �   �t                    �����1    �1 �   u                    �����1 �   <u                    �����1    �1 �   du                    �����1�����1 �   �u                    ����2     2 �   �u                    ����H2    @2 �   �u                    �����2 �   $v                    �����2 �   Lv                    �����2 �   tv                    �����2     3    3   @3   _3   g3   r3   z3   �3   �3	   �3	   �3 �   �v                            ���� 4     4   @4   `4   4   �4   �4   �4   �4   �4	   �4	   �4 �   $w                            ���� 5    .5   95   D5 �   �w                        ����p5 �   �w                    �����5�����5   �5   �5   �5 �   x                        �����5�����5 �   dx                    ���� 6    6    6    6     6    (6    06    86    @6   H6	   P6 �   �x                            �����6    �6�����6   �6   �6   �6   �6   �6   �6 �	   y                            �����6�����6���� 7   7   7   7    7   (7   07   87   @7   H7 �   �y                            �����7   