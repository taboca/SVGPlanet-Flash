tr>
   <tr>
       <td align="left"><p><b><a href="http://livedocs.adobe.com/flash/9.0/main/00000307.html" target="mm_window">View comments on LiveDocs</a></b></p></td>
   </tr>
</table>
   </body>
</html>                                                                                                                                                                                                                                                                                                             {
	window.clearTimeout(sTid53458);
	play_state53458='stop';
    }
    if (command == 'km_play') {
	if (play_state53458=="pause"){
	    sTid53458=setTimeout("inc53458();", 1000);
	}
	play_state53458="play"
	km_trackingManager53458.registerNormalTracking(km_pid53458,110,km_currVAdId53458);
    }
    if (command == 'km_stop') {
	window.clearTimeout(sTid53458);
	play_state53458="stop";
	km_sendtime53458();
	km_trackingManager53458.registerNormalTracking(km_pid53458,113,km_currVAdId53458);
    }
    if (command == "km_pause"){
	if (play_state53458=="play"){
	    window.clearTimeout(sTid53458);
	    play_state53458="pause";
	}else if(play_state53458=="pause"){
	    sTid53458=setTimeout("inc53458();", 1000);
	    play_state53458="play";
	}
	km_trackingManager53458.registerNormalTracking(km_pid53458,111,km_currVAdId53458);
    }
    if (command == 'km_mute') {
	km_trackingManager53458.registerNormalTracking(km_pid53458,112,km_currVAdId53458);
    }
    if (command == 'km_unmute'){
	km_trackingManager53458.registerNormalTracking(km_pid53458,114,km_currVAdId53458);

    }
    if (command == 'km_replay'){
	km_trackingManager53458.registerNormalTracking(km_pid53458,118,km_currVAdId53458);

    }
    if (command == 'km_ff'){
	km_trackingManager53458.registerNormalTracking(km_pid53458,119,km_currVAdId53458);

    }
    if (command == 'km_rw'){
	km_trackingManager53458.registerNormalTracking(km_pid53458,120,km_currVAdId53458);

    }
    if (command == 'km_add'){
	var add_clk_no=parseInt(args);
	add_clk_no += 300;
	km_trackingManager53458.registerNormalTracking(km_pid53458,add_clk_no,ad_id53458);
    }
    if (command.indexOf('km_tab')>-1){
	km_sendIntTime53458();
	if (parseInt(args)==1){ad_id53458=base_ad_id53458+parseInt(command.substr(6,1));}else{ad_id53458=base_ad_id53458+parseInt(args);}
	km_trackingManager53458.registerNormalTracking(km_pid53458,11,ad_id53458);
	window.clearTimeout(sTid53458);
    }
    if (command == 'km_fullscreen'){
	window.clearTimeout(sTid53458);
	km_currVAdId53458=parseInt(args);
	if(km_fsUrlArr53458[km_currVAdId53458-1]!=km_fs.URL){km_fs.URL=km_fsUrlArr53458[km_currVAdId53458-1];}
	km_fs.controls.play();
	checkPlaying53458();
	km_trackingManager53458.registerNormalTracking(km_pid53458,116,km_currVAdId53458);
    }
    /*

    km_floaterFunctions53458(command,args);

   */

    km_expandingFunctions53458(command,args);

 

    if (command == 'km_offsetFix'){
	km_rz_id53458=setInterval(self.km_resize53458,500);
    }
    if (command == 'km_setCurrVInfo'){
	var sArg=args.split('|');
	km_currVAdId53458=sArg[0];
	km_currVLen53458=sArg[1];
	if (go_fs53458=='true'){if((km_fsUrlArr53458.length>(km_currVAdId53458))&&