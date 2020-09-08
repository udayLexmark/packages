
<HTML>
   <HEAD>

      <meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
      <META HTTP-EQUIV="Expires" CONTENT="-1">


      <TITLE>IS Service Statistics
      </TITLE>
      <LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">
      <!--<META http-equiv="refresh" content="90">-->

   <SCRIPT src="webMethods.js.txt"></SCRIPT>
   </HEAD>
   <BODY onLoad="setNavigation('stats-services.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Server_ServiceUsageScrn');">
         <TABLE width="100%">
            <TR>
               <TD class="menusection-Server" colspan=14>Server &gt; Service Usage</TD>
            </TR>

      %ifvar action equals('resetcache')%
        %invoke wm.server.cache.adminui:resetCache%
      <tr><td colspan="2">&nbsp;</td></tr>
            <TR><TD class="message" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Server cache cleared</TD></TR>
        %endinvoke%
      %endif%

             <TR>
              <TD colspan=2>
                <UL>
                  %comment% <LI><A HREF="stats-services.dsp?action=resetcache">Reset Server Cache</A></LI> %endcomment%
				  <LI><input type="checkbox" id="ssot" align="right" onclick="executeAction(this)" %ifvar checked% checked %endif%>Show running services on top</LI>
                </UL>

              </TD>
            </TR>

            %invoke LXKAdmin.server.query:getServiceStats%
            <TR>
               <TD><IMG SRC="images/blank.gif" WIDTH=10 HEIGHT=10></TD>
               <TD>
                  <TABLE class="tableView" width="100%" id="servicecon" border=0>
                     <TR>
                        <TD CLASS="heading" COLSPAN=5>Service
                     <TR>


                        <TD CLASS=oddcol-l>Name (instances currently running)</td>
                        <TD CLASS=oddcol>Count</td>
                        <TD CLASS=oddcol nowrap>Last Ran</td>

                        <TD CLASS=oddcol>Cached</td>
                        <TD CLASS=oddcol>Prefetched</td>



                     </TR> %ifvar SvcStats%
                     <script>resetRows();</script>

                     %loop SvcStats%
                     <TR id="%ifvar sRunning equals('&nbsp;')%%value $index%%else%%value $index%run%endif%">

                        <script>writeTD('rowdata-l');</script>
                            <nobr><A href="service-info.dsp?service=%value ifc%:%value svc%"> %value ifc%:%value svc%</A> %ifvar equals('&nbsp;') sRunning%%else%(%value sRunning%)%endif%</nobr></TD>
                        <script>writeTD('rowdata');</script>
                            %value none sAccessTotal%</TD>


                        <script>writeTD('rowdata');</script>
                           <nobr>%value none sAccessLast%</nobr></TD>

                        <script>writeTD('rowdata');</script>
                            %ifvar equals('N') isCached%-%else%<IMG SRC="images/green_check.gif" height=13 width=13>%endif%</TD>
                        <script>writeTD('rowdata');</script>
              %ifvar equals('N') isPrefetched%-%else%<IMG SRC="images/green_check.gif" height=13 width=13>%endif%</TD>
                     </TR><script>swapRows();</script>%endloop%
 %else%
                     <TR>
                        <TD CLASS="evenrow-l" colspan=5>No services</TD>

                     </TR>
%endif%
                  </TABLE> </TD>

               </TR>
               <TR>
               <TD>
                  <IMG SRC="images/blank.gif" WIDTH=10 HEIGHT=10>
               </TD>
               <TD>
                  <IMG SRC="images/blank.gif" WIDTH=10 HEIGHT=10>

                  <TABLE class="tableView" width="100%">
                     <TR>
                        <TD CLASS="heading" COLSPAN=9>Cache and Prefetch Information</TD>
                     <TR>
                        <TD CLASS=oddcol>Name</TD>
                        <TD CLASS=oddcol>Last Cache Hit</TD>
                        <TD CLASS=oddcol >Cache Hits</TD>
                        <TD CLASS=oddcol nowrap>Cache Hits/<BR>Total Count</TD>
                        <TD CLASS=oddcol>Cache Entries</TD>
                        <TD CLASS=oddcol>Cache Expires</TD>
                        <TD CLASS=oddcol>Last Prefetch</TD>
                        <TD CLASS=oddcol>Total Prefetches</TD>
                        <TD CLASS=oddcol>Recent Prefetch</TD>

                     </TR>
                     <script>resetRows();</script>
                     <script>var count=0;</script>
                     %loop SvcStats%
                       %ifvar isCached equals('Y')%<TR>

                       <script>count++;</script>
                        <script>writeTD('rowdata-l');</script>
                           <A href="service-info.dsp?service=%value ifc%:%value svc%"> %value ifc%:%value svc%</A></TD>
                        <script>writeTD('rowdata');</script>
                           %ifvar cHitLast equals('&nbsp;')%-%else%%value cHitLast%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cHitTotal equals('&nbsp;')%-%else%%value cHitTotal%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cHitRatio equals('&nbsp;')%-%else%%value cHitRatio%%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cEntries equals('&nbsp;')%-%else%%value cEntries%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cExpires equals('&nbsp;')%-%else%%value cExpires%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cPrefetchLast equals('&nbsp;')%-%else%%value cPrefetchLast%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cPrefetchTotal equals('&nbsp;')%-%else%%value cPrefetchTotal%%endif%</TD>
                        <script>writeTD('rowdata');</script>
                            %ifvar cPrefetched equals('&nbsp;')%-%else%%value cPrefetched%%endif%</TD>
                        </TR><script>swapRows();</script>
                      %endif%
                     %endloop%
                     <script>
                     if (count == 0)
                      {
                        document.write("<TR>");
                        document.write("<TD CLASS='evenrow-l' colspan=9>No Services Cached</TD>");
                        document.write("</TR>");
                      }
                     </script>
                  </TABLE></TD>
            </TR>
         </TABLE> %endinvoke%
   </BODY>
</HTML>


<script>
var stateChanged = false;
var originalURL;
var tempURL = window.location+"";
var index=tempURL.indexOf("?");
if(index!=-1){
	originalURL = tempURL.substring(0,index);
} else {
	originalURL = tempURL ;
}

function showRunningServicesOnTop(){

stateChanged=false;
var replaceCount = 2;
var table = document.getElementById('servicecon');
var rows = table.rows;
for(var i=2;i<rows.length;i++){
	if(rows[i].id.indexOf("run") != -1){
	if(firefox){
		var a = rows[replaceCount].innerHTML;
		rows[replaceCount].innerHTML= rows[i].innerHTML;
		rows[i].innerHTML=a;
	} else {
		rows[replaceCount].swapNode(rows[i]);	
	}
	replaceCount++;
	}
}
if(replaceCount==2){
	return;
}
stateChanged = true;
resetRows();

for(var i=2;i<rows.length;i++){
	var cells = rows[i].cells;
	cells[0].className=row+"rowdata-l";
	for(var j = 1;j<cells.length;j++){
		cells[j].className=row+"rowdata";
	}
	swapRows();
}
}

function executeAction(checkbox){
	if(checkbox.checked){
		showRunningServicesOnTop();
	} else if(stateChanged){
		window.location.href=originalURL;
	}
}

function refreshPage(){
	var checkBox = document.getElementById("ssot");
	var url = originalURL;
	if(checkBox.checked){
		url=url+"?checked=true";
	}
	window.location.href=url;
}

%ifvar checked% showRunningServicesOnTop(); %endif%

window.setInterval("refreshPage()",90*1000);

var firefox = false;
if(navigator.userAgent.indexOf("Firefox")!=-1){
	firefox = true;
}
</script>
