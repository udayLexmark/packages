%comment%----- Lists Polling Notifications -----%endcomment%

<HTML>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <meta http-equiv="Expires" CONTENT="-1">
    <TITLE>Polling Notifications</title>
    <link rel="stylesheet" TYPE="text/css" HREF="../webMethods.css"></link>
    <script src="../connectionfilter.js.txt"></script>
    <SCRIPT LANGUAGE="JavaScript">
      function doSelect(action,aliasName)
      {
      		var s1 = null;
      		if(action =='enableNotification')
      		{
		         s1 = "OK to enable the `"+aliasName+"' Notification?\n\n";
      		} 
      		else if(action =='disableNotification')
      		{
		         s1 = "OK to disable the `"+aliasName+"' Notification?\n\n";
      		} 
      		else if(action =='suspendNotification')
      		{
		         s1 = "OK to suspend operations for the `"+aliasName+"' Notification?\n\n";
      		} 
      		else if(action =='resumeNotification')
      		{
		         s1 = "OK to resume operations for the `"+aliasName+"' Notification?\n\n";
      		} 
      		else if(action =='forceDisable')
      		{
		         s1 = "OK to force the `"+aliasName+"' Notification to disabled status?\n\n";
      		} 
      		else if(action =='forceSuspend')
      		{
		         s1 = "OK to force the `"+aliasName+"' Notification to suspended status?\n\n";
      		} 
      		if(s1 == null)
      		{
      			alert("Script Error!");
      			return false;
      		}
      		else
      		{
	      		if(confirm (s1))
	      		{
	      			return(action);
	      		}
	      		else
	      		{
	      			return false;
	      		}
      		}
      }
    </SCRIPT>
    
    <SCRIPT SRC="../webMethods.js.txt"></SCRIPT>
</head>
%invoke wm.art.admin:getAdapterTypeOnlineHelp%
%onerror%
%endinvoke%
%invoke wm.art.admin:retrieveAdapterTypeData%
%onerror%
%endinvoke%
<BODY onLoad="setNavigation('ListPollingNotifications.dsp', '%value helpsys%', 'foo');showHideFilterCriteria('searchNotificationName');">
<form name="form" action="ListPollingNotifications.dsp" method="POST">    
<table width="100%">  
    <tr>
       	<td class="menusection-Adapters" colspan=5>Adapters &gt; %value displayName% &gt; Polling Notifications</TD>
    </tr>
        
    %comment%
    -- If we arrive at this page because of an enable/disable request, or an edit save, the
    -- action field will be set, we perform the requested action before refreshing the page.
    %endcomment%
      
    %ifvar action%
        %switch action%
        %case 'enableNotification'%
            %invoke wm.art.admin:setNotificationStatus%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'disableNotification'%
            %invoke wm.art.admin:setNotificationStatus%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'edit'%
            %invoke wm.art.admin:setNotificationSchedule%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
            %invoke wm.art.admin:setNotificationClusterSettings%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%            
        %case 'forceDisable'%
            %invoke wm.art.admin:forceNotificationDisable%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'forceSuspend'%
            %invoke wm.art.admin:forceNotificationSuspend%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'suspendNotification'%
            %invoke wm.art.admin:setNotificationStatus%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'resumeNotification'%
            %invoke wm.art.admin:setNotificationStatus%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'suspendAllEnabled'%
            %invoke wm.art.admin:suspendAllPollingNotifications%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %case 'enableAllSuspended'%
            %invoke wm.art.admin:resumeAllPollingNotifications%
            %onerror%
                <TR><TD class="message" colspan=5>
                <PRE>
                %ifvar localizedMessage% %value localizedMessage%
                %else% %value errorMessage%
                %endif%
                </PRE>
            %endinvoke%
        %endswitch%
    %endif%

    %comment% When we arrive here, we start generating the tabvular list of notifications %endcomment%  
    <TR>
        <td>
            <ul>
    		    <li id="showfew" name="showfew"><a href="javascript:showFilterPanel(true)">Filter Polling Notifications</a></li>
                <li style="display:none" id="showall" name="showall"><a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&dspName=.LISTPOLLINGNOTIFICATIONS">Show All Polling Notifications</a></li>
            	<DIV id="filterContainer" name="filterContainer" style="display:none;padding-top=2mm;">
	                     <br>
	                      <table>
	    			<tr valign="top">
	    			<td>
	                        	<span>Filter criteria</span><br>
	                        	<input id="searchNotificationName" name="searchNotificationName" value="%value -urldecode searchNotificationName%" onkeydown="return processKey(event)" />
	    			</td>
	    			<td>
	                         	<br>
                     		<input id="submitButton" name="Submit" type="submit" value="Submit" width="15" height="15" onClick="validateSearchCriteria('searchNotificationName');return false;"/>                                                             
	                         	</br>
	                        </td> 
	                      </tr>
	                   </table>
	              </br>  
                </DIV>
            </ul>    
	    </td>
    </TR>
        %comment% Get list of notifications that match our type %endcomment%
    %invoke wm.art.admin:retrievePollingNotifications%
    <tr>
        <td colspan=8 align="right">
        	<label style="color:#666666;font-weight:bold;text-align:inherit;">%value pageLabel%</label>
        </td>
    </tr>
    <TR>
        <td class="heading" colspan=5>%value displayName% Polling Notifications</td>
    </tr>
    <tr>
        <td class="oddcol-l">Notification Name<a id="ascNN" href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=NN&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" style="float: middle" src="images/arrow_up.gif" width="15" height="15"></a>
            <a id="desNN" href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=NN&DES=true&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" src="images/arrow_down.gif" style="float: middle" width="15" height="16"></a></td>
        <td class="oddcol-l">Package Name<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=PN&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" src="images/arrow_up.gif" align="baseline" width="15" height="15"></a>
            <a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=PN&DES=true&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" src="images/arrow_down.gif" align="baseline" width="15" height="15"></a></td>        
        <td class="oddcol">State<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=State&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" src="images/arrow_up.gif" align="baseline" width="15" height="15"></a>
            <a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&sort=State&DES=true&dspName=.LISTPOLLINGNOTIFICATIONS"><img border="0" src="images/arrow_down.gif" align="baseline" width="15" height="15"></a></td>
        <td class="oddcol">Edit Schedule</td>
        <td class="oddcol">View Schedule</td>    
    </tr>


    %comment% if we have notifications, loop over response, constructing output table %end%
    %ifvar notificationDataList -notempty%
        %loop notificationDataList%
            <tr>
            <script>writeTD('rowdata-l');</script>
            %value notificationNodeName% </td>
            <script>writeTD('rowdata-l');</script>
            %value packageName% </td>
            <script>writeTD('rowdata-l');</script>
            %switch notificationEnabled%
	            %case 'yes'%
	              	<img src="/WmRoot/images/green_check.gif" height=13 width=13 border=0>Enabled
	            %case 'no'%
	              	Disabled
	            %case 'unsched'%
	              	Disabled
	            %case 'pending'% 
				Pending Disable
	            %case 'pendingSuspend'% 
	              	Pending Suspend
	            %case 'suspended'%
	              	Suspended
            %endswitch%</TD>

            <script>writeTD('rowdata');</script>
            %ifvar notificationEnabled equals('yes')%
                <img src="/LXKAdmin/WmART/icons/disabled_edit.gif" alt="Edit" border=0>
            %else%
                %ifvar notificationEnabled equals('pending')%
                    <img src="/LXKAdmin/WmART/icons/disabled_edit.gif" alt="Edit" border=0>
                %else%
                    <img src="/LXKAdmin/WmART/icons/config_edit.gif" alt="Edit" border=0>
                %endif%
            %endif%
     
            </td>

            <script>writeTD('rowdata');</script>
            %ifvar notificationEnabled equals('unsched')%
                <img src="/LXKAdmin/WmART/icons/view-disabled.gif" alt="View" border=0>
            %else%
                <a href="/LXKAdmin/WmART/PollingNotificationDetails.dsp?readOnly=true&adapterTypeName=%value -urlencode ../adapterTypeName%&notificationNodeName=%value -urlencode notificationNodeName%&searchNotificationName=%value -urlencode searchNotificationName%&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">
                <img src="/WmRoot/icons/file.gif" alt="View" border=0>         
            %endif%   
            </a></td>
            </tr>
        %endloop%
    %else%
        <TR><TD class="message" colspan=5>No Polling Notifications found</TD></TR>
    %endif%
    %onerror% 
            %ifvar localizedMessage%
                <tr><td class="message">Error encountered <pre>%value localizedMessage%</pre></td></tr>
            %else%
                %ifvar error%
                    <tr><td class="message">Error encountered <pre>%value errorMessage%</pre></td></tr>
                %endif%
            %endif%
    %endinvoke%
    
</table>  
	<div class="oddrowdata" id="goContainer" name="goContainer" style="display:none;padding-top=2mm;">
        	%ifvar pStart equals('1')%
			<label style="color:#666666;font-weight:bold;text-align:inherit;">
			Page (1-<script>writeTD('rowdata-l');</script>%value pageSize% )</td></label>
		%else%		
        		<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&prev=true&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">« Previous</a>&nbsp;<label style="color:#666666;font-weight:bold;text-align:inherit;">Page (1-
				<script>writeTD('rowdata-l');</script>%value pageSize% )</label></td>
		%endif%	
			<input type="text" name="pageNumber" value="%value pStart%" size="1" onkeypress="return isNumberKey(this.form,event);">&nbsp;<input type="submit" name="Go" value="Go" onClick="jumpToPage(this);return false;">
		%ifvar pStart vequals(pageSize)%			
				<!-- Next -->
		%else%
			<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&prev=false&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">Next »</a>
		%endif%		
	</div>
      
	<div class="oddrowdata" id="paginationContainer" name="paginationContainer" style="display:;padding-top=2mm;">
	%ifvar pStart equals('1')%
	%else%
		<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&prev=true&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">« Previous</a>              
	%endif%
	       %loop totalNosOfPages%
		%ifvar totalNosOfPages -notempty%           		
			<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&pageNumber=%value -urlencode totalNosOfPages%&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">
			%ifvar totalNosOfPages vequals(/pStart)% 
			<a><label style="color:#666666;font-weight:bold;">%value totalNosOfPages%</label>
			%else%
			%ifvar totalNosOfPages equals('...')%
				</a><a href="javascript:showHidePageCriteria()">%value totalNosOfPages%</a>
	         	%else%
			%value totalNosOfPages%<a>
			%endif%
		%endif%	
		%else%
		%value pStart%
	%endif%	
        %endloop%							
		%ifvar pStart vequals(pageSize)%			
						
		%else%
			<a href="/LXKAdmin/WmART/ListPollingNotifications.dsp?adapterTypeName=%value -urlencode adapterTypeName%&searchNotificationName=%value -urlencode searchNotificationName%&prev=false&dspName=.LISTPOLLINGNOTIFICATIONDETAILS">Next »</a>
		%endif%	
	</div>
    	<input type="hidden" name="adapterTypeName" value="%value adapterTypeName%">
    	<input type="hidden" name="searchNotificationName" value="%value searchNotificationName%">     	
    	<input type="hidden" name="pStart" value="%value pStart%">
    	<input type="hidden" name="totalNosOfPages" value="%value totalNosOfPages%">
    	<input type="hidden" name="pageNumber" value="%value pageNumber%">
    	<input type="hidden" value="" name="sortCriteria">
    	<input type="hidden" name="pageSize" value="%value pageSize%">
    	<input type="hidden" value="%value pageLabel%" name="pageLabel">
     </form>	
</body>
</HTML>
