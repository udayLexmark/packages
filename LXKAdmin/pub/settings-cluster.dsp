<html>
  <head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <meta http-equiv="Expires" content="-1">
    <title>Integration Server Settings</title>
    <style> 
        .noshow { display: none; }
    </style>
    <link rel="stylesheet" type="text/css" href="webMethods.css">
    <script src="webMethods.js.txt"></script>
    <script language="JavaScript">
        function verifyNonblankField(fld, name) 
        {       
            if (isblank(fld.value)) {
                alert(name + " is required.");
                return false;
            } else {
                return true;
            }
        }

        function verifyPositiveIntegerField(fld, name)
        {
            if (isblank(fld.value)) {
                alert(name + " is required.");
                return false;
            }
            else if (!isNum(fld.value) || parseInt(fld.value) <= 0) {
                alert(name + " must be a positive integer.");
                return false;
            }
            else {
                return true;
            }
        }

        function verifyNonnegativeIntegerField(fld, name)
        {
            if (isblank(fld.value)) {
                alert(name + " is required.");
                return false;
            }
            else if (!isNum(fld.value) || parseInt(fld.value) < 0) {
                alert(name + " must be a non-negative integer.");
                return false;
            }
            else {
                return true;
            }
        }

        function validate()
        {
            var valid = true;
            if(document.cluster.clusterAware.value == "true") {
                valid = verifyNonblankField(document.cluster.clusterName, "Cluster Name") &&
                        verifyPositiveIntegerField(document.cluster.clusterSessTimeout, "Session Timeout")  &&
                        verifyNonblankField(document.cluster.tsaURLsTA, "Terracotta Server Array URLs")
            }   
            if (valid) {
                document.forms[0].submit();
            }
        }
    </script>
  </head>


    <BODY onLoad="setNavigation('settings-cluster.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Settings_ClusterScrn');">


    <TABLE WIDTH="100%">
      <TR>
        <TD class="breadcrumb" colspan="2">
          Settings &gt;
          Cluster
          %ifvar doc equals('edit')%
            &gt; Edit
          %endif%
        </TD>
      </TR>

  %ifvar action equals('update')%
    %invoke wm.server.cluster:setSettings%
      %ifvar message%
        <tr><td colspan="2">&nbsp;</td></tr>
        <TR><TD colspan=2 class="message">%value message encode(html)%</TD></TR>
      %endif%
    %endinvoke%
  %endif%

  %invoke wm.server.query:getClusterSettings%

  %comment% If 'message' is present, display it only when the Enable Clustering link is clicked. %endcomment%
  %ifvar action equals('change')%
    %ifvar clusterAware equals('true')%
      %ifvar message%
        <tr><td colspan="2">&nbsp;</td></tr>
        <TR><TD colspan=2 class="message">%value message encode(html)%</TD></TR>
      %endif%
    %endif%
  %endif%

      %invoke wm.server.query:getClusterError%
      %ifvar error equals('true')%
      <tr><td colspan="3">&nbsp;</td></tr>
          <TR>
              <TD class="message" colspan="3">
              Unable to create or join the cluster. Check the clustering configuration and Error Logs for more information.
              </TD>
          </TR>
        <tr><td colspan="3">&nbsp;</td></tr>    
        %endif%
        %endinvoke%
  
    

     <tr>
        <td>
          <table class="tableView width50">
            <TR>
                <TD colspan=2 class="heading">General</TD>
            </TR>
            <TR>
                  <TD class="oddrow" width="50%">Clustering Status</TD>
                  %ifvar ../doc equals('edit')%
                      <TD class="oddrowdata-l">
                      %ifvar clusterAware equals('true')%
                        <IMG SRC="images/enabled.gif"> Enabled %ifvar pendingRestart equals('true')% (pending restart) %endif%
                      %else%
                        Disabled %ifvar pendingRestart equals('true')% (pending restart) %endif%
                      %endif%</TD>
                  %else%
                      <TD class="oddrowdata-l">
                      %ifvar clusterAware equals('true')%
                        <IMG SRC="images/enabled.gif"> Enabled %ifvar pendingRestart equals('true')% (pending restart) %endif%
                      %else%
                        Disabled %ifvar pendingRestart equals('true')% (pending restart) %endif%
                      %endif%
                      </TD>
                %endif%
            </TR>

          %ifvar ../doc equals('edit')%
            <FORM NAME="cluster" METHOD="POST" ACTION="settings-cluster.dsp">
            <INPUT TYPE="hidden" NAME="action" VALUE="update">
            <INPUT TYPE="hidden" NAME="cluster-action" VALUE="cluster-action">
            <INPUT TYPE="hidden" NAME="clusterAware" VALUE="%value clusterAware encode(htmlattr)%">
          %endif%

            %ifvar clusterAware equals('true')%
                <TR>
                      <TD class="evenrow">Cluster Name</TD>
                     
                      <TD class="evenrowdata-l"><script>writeEditNullable("%value ../doc encode(javascript)%", "clusterName", "%value clusterName encode(html_javascript)%");</script></TD>
                    
                </TR>
                <TR>
                      <TD class="oddrow">Session Timeout</TD>
                   
                      <TD class="oddrowdata-l"><script>writeEditNullable("%value ../doc encode(javascript)%", "clusterSessTimeout", "%value clusterSessTimeout encode(html_javascript)%");</script> minutes</TD>
                      
                </TR>

                <TR>
                    <TD class="evenrow">Action On Startup Error</TD>
                     
                        <TD class="evenrow-l">
                            %ifvar actionOnStartupError equals('standalone)% Start as Stand-Alone Integration Server %endif%
                            %ifvar actionOnStartupError equals('shutdown)% Shut Down Integration Server %endif%
                            %ifvar actionOnStartupError equals('quiesce)% Enter Quiesce Mode on Stand-Alone Integration Server %endif%
                        </TD>
                      
                </TR>

                %comment% Start edit fields. %endcomment%
               
                 <TR id="terracotta">
                   <TD class="oddrow">Terracotta Server Array URLs</TD>
                   <TD id="tsaURLs" class="oddrow-l">%value tsaURLs encode(html)%</TD>
                 </TR>  
              
      %endif%

     

      </table>
      
          <table class="tableView width50">

            %comment% Only show cluster hosts when not in 'edit' mode. %endcomment%
            %ifvar doc equals('edit')% %else%
               <TR>
                  <TD class="heading" colspan="14">Cluster Hosts</TD>
               </TR>
               %ifvar hosts%
                 <TR>
                   <TD class="oddcol">Name</TD>
                   <TD class="oddcol">Address</TD>
                   <TD class="oddcol">Server Start Time</TD>
                   <TD class="oddcol">Server Up Time</TD>
                   <TD class="oddcol">Total Memory (KB)</TD>
                   <TD class="oddcol">Free Memory (KB)</TD>
                   <TD class="oddcol">Used Memory (KB)</TD>
                   <TD class="oddcol">Current Server Threads</TD>
                   <TD class="oddcol">Max Server Threads</TD>
                   <TD class="oddcol">Current System Threads</TD>
                   <TD class="oddcol">Max System Threads</TD>
                   <TD class="oddcol">Total Requests</TD>
                   <TD class="oddcol">Average Duration (ms)</TD>
                 </TR>
               %loop hosts%
               <TR>
                  <script>writeTD("rowdata");</script>%value server encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value hostAddress encode(html)%</TD>
                  <script>writeTDnowrap("rowdata");</script>%value startTime encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value uptime encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value totalMem encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value freeMem encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value usedMem encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value svrT encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value svrTMax encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value sysT encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value sysTMax encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value reqTotal encode(html)%</TD>
                  <script>writeTD("rowdata");</script>%value reqAvg encode(html)%</TD>
               </TR> 
               %endloop%
               %else%
               <TR>
                 <TD class="oddrow-l" colspan=3>No Cluster Hosts</TD>
               </TR>
               %endif%
              %endif%
           %endinvoke%
      </table>
    </td>
  </tr>  
</table>
</body>
</html>
