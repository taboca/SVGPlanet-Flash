<?xml version="1.0" encoding="utf-8"?>
<doc>
	<assembly>
		<name>Microsoft.VisualStudio.VSHelp</name>
	</assembly>
	<members>
		<member name="N:Microsoft.VisualStudio.VSHelp">
			<summary>VSHelp contains the objects and members for Visual Studio Help Integration.</summary>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.DExploreAppObj">
			<summary>Co class to create a Microsoft Document Explorer instance.</summary>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass">
			<summary>Co class to create an instance of Document Explorer.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.#ctor">
			<summary>Creates a DExploreAppObj80 object.</summary>
		</member>
		<member name="E:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.OnCollectionChanged">
			<summary>Called when the Help collection changes.</summary>
		</member>
		<member name="E:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.OnFilterChanged">
			<summary>Called when the Help collection filter changes.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.add_OnCollectionChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnCollectionChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.add_OnFilterChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnFilterChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.CanShowFilterUI">
			<summary>Not currently implemented.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.CanSyncContents(System.String)">
			<summary>Determines if a URL can be synchronized to or not.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.Close">
			<summary>Closes the Document Explorer window and all of its pages.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.Contents">
			<summary>Selects the Contents navigation window and opens it if it is closed.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFrom_OLD_Help(System.String,System.UInt32)">
			<summary>Provides support for .chm and .hlp files.</summary>
			<param name="bstrFile"> </param>
			<param name="Id"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFromF1Keyword(System.String)">
			<summary>Displays help for F1 and from dialog boxes.</summary>
			<param name="pszKeyword"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFromId(System.String,System.UInt32)">
			<summary>Finds and displays the first topic defined by the supplied F1 keyword and context help ID.</summary>
			<param name="bstrFile"> </param>
			<param name="Id"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFromKeyword(System.String)">
			<summary>Performs a lookup by using the K-keyword index.</summary>
			<param name="pszKeyword"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFromURL(System.String)">
			<summary>Displays a help topic specified by a URL in Document Explorer.</summary>
			<param name="pszURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.DisplayTopicFromURLEx(System.String,Microsoft.VisualStudio.VSHelp.IVsHelpTopicShowEvents)">
			<summary>Displays a help topic in Document Explorer and triggers a specified event after the topic has been loaded.</summary>
			<param name="pIVsHelpTopicShowEvents"> </param>
			<param name="pszURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.FilterUI">
			<summary>Displays the user interface to create, edit, or delete filters.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.GetNextTopic(System.String)">
			<summary>Given a URL returns the next URL in the table of contents.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.GetObject(System.String,System.String)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="bstrMoniker"> </param>
			<param name="bstrOptions"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.GetPrevTopic(System.String)">
			<summary>Given a URL returns the previous URL in the table of contents.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.Index">
			<summary>Selects the Index window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.IndexResults">
			<summary>Selects the Index Results window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.remove_OnCollectionChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnCollectionChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.remove_OnFilterChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnFilterChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.Search">
			<summary>Selects the Search dialog box.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.SearchResults">
			<summary>Selects the Search Results window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.SetCollection(System.String,System.String)">
			<summary>Loads a Help collection into Document Explorer.</summary>
			<param name="bstrCollection"> </param>
			<param name="bstrFilter"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.SyncContents(System.String)">
			<summary>Synchronizes the table of contents to the supplied URL.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.DExploreAppObjClass.SyncIndex(System.String,System.Int32)">
			<summary>Looks up the topic specifies by the K-keyword but does not display the topic in Document Explorer.</summary>
			<param name="bstrKeyword"> </param>
			<param name="fShow"> </param>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.Help">
			<summary>Dual interface used to provide F1 Help from a modal or non-modal dialog box.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.CanShowFilterUI">
			<summary>Do not use.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.CanSyncContents(System.String)">
			<summary>Determines if a URL can be synchronized to or not.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.Close">
			<summary>Closes the Microsoft Document Explorer window and all of its pages.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.Contents">
			<summary>Selects the Contents navigation window and opens it if it is closed.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFrom_OLD_Help(System.String,System.UInt32)">
			<summary>Provides support for .chm and .hlp files.</summary>
			<param name="bstrFile"> </param>
			<param name="Id"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFromF1Keyword(System.String)">
			<summary>Provides F1 Help for a modal or non-modal dialog box.</summary>
			<param name="pszKeyword">F1 keyword provided for the dialog box.</param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFromId(System.String,System.UInt32)">
			<summary>Finds and displays the first topic defined by the supplied F1 keyword and context help ID.</summary>
			<param name="bstrFile"> </param>
			<param name="Id"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFromKeyword(System.String)">
			<summary>Performs a lookup by using the K-keyword index.</summary>
			<param name="pszKeyword"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFromURL(System.String)">
			<summary>Displays a help topic specified by the URL in Document Explorer.</summary>
			<param name="pszURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.DisplayTopicFromURLEx(System.String,Microsoft.VisualStudio.VSHelp.IVsHelpTopicShowEvents)">
			<summary>Displays a help topic in Document Explorer and triggers a specified event after the topic has been loaded.</summary>
			<param name="pIVsHelpTopicShowEvents"> </param>
			<param name="pszURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.FilterUI">
			<summary>Displays the user interface to create, edit, or delete filters.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.GetNextTopic(System.String)">
			<summary>Given a URL returns the next URL in the table of contents.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.GetObject(System.String,System.String)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="bstrMoniker"> </param>
			<param name="bstrOptions"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.GetPrevTopic(System.String)">
			<summary>Given a URL returns the previous URL in the table of contents.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.Index">
			<summary>Selects the Index window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.IndexResults">
			<summary>Selects the Index Results window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.Search">
			<summary>Selects the Search dialog box.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.SearchResults">
			<summary>Selects the Search Results window.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.SetCollection(System.String,System.String)">
			<summary>Loads a Help collection into Document Explorer.</summary>
			<param name="bstrCollection"> </param>
			<param name="bstrFilter"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.SyncContents(System.String)">
			<summary>Synchronizes the table of contents to the supplied URL.</summary>
			<param name="bstrURL"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.Help.SyncIndex(System.String,System.Int32)">
			<summary>Looks up the topic specifies by the K-keyword but does not display the topic in Document Explorer, unless specified.</summary>
			<param name="bstrKeyword"> </param>
			<param name="fShow"> </param>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpEvents">
			<summary>Supports filter and collection change events.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents.OnCollectionChanged(System.String,System.String)">
			<summary>Called when the Help collection changes.</summary>
			<param name="bstrNewFilter">String containing the name of the filter to be applied to the Help collection.</param>
			<param name="bstrNewCollection">String containing the name of the new collection.</param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents.OnFilterChanged(System.String)">
			<summary>Called when the filter applied to the Help collection changes.</summary>
			<param name="bstrNewFilter">String containing the name of the filter to be applied to the Help collection.</param>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event">
			<summary>Supports filter and collection change events.</summary>
		</member>
		<member name="E:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.OnCollectionChanged">
			<summary>Called when the Help collection changes.</summary>
		</member>
		<member name="E:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.OnFilterChanged">
			<summary>Called when the filter applied to the Help collection changes.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.add_OnCollectionChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnCollectionChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.add_OnFilterChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnFilterChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.remove_OnCollectionChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnCollectionChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_Event.remove_OnFilterChanged(Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnFilterChangedEventHandler)">
			<summary>Microsoft Internal Use Only.</summary>
			<param name="A_1"> </param>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnCollectionChangedEventHandler">
			<summary>Microsoft Internal Use Only.</summary>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpEvents_OnFilterChangedEventHandler">
			<summary>Microsoft Internal Use Only.</summary>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpOwner">
			<summary>Provides information about the Help owner.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpOwner.BringHelpToTop(System.Int32)">
			<summary>Brings the external Help viewer to the foreground.</summary>
			<param name="hwndHelpApp">Handle to the Help window.</param>
		</member>
		<member name="P:Microsoft.VisualStudio.VSHelp.IVsHelpOwner.AutomationObject">
			<summary>Returns an external window DTE object.</summary>
			<returns>Returns a <see cref="T:EnvDTE80.DTE2"></see> object.</returns>
		</member>
		<member name="T:Microsoft.VisualStudio.VSHelp.IVsHelpTopicShowEvents">
			<summary>Provides support for help topic show events.</summary>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpTopicShowEvents.OnBeforeTopicShow(System.String,System.Object)">
			<summary>Called before the help topic is displayed.</summary>
			<param name="pWB">Web browser object.</param>
			<param name="bstrURL">String containing the URL of the help topic.</param>
		</member>
		<member name="M:Microsoft.VisualStudio.VSHelp.IVsHelpTopicShowEvents.OnTopicShowComplete(System.String,System.Object)">
			<summary>Called after the help topic is displayed.</summary>
			<param name="pWB">Web browser object.</param>
			<param name="bstrURL">String containing the URL of the help topic.</param>
		</member>
	</members>
</doc>                                                                   m a r c i o \ D e s k t o p \ T a b o c a   C C F o t o s   2 \ c h r o m e \ p i p p k i . m a n i f e s t         �   0       L           g�����