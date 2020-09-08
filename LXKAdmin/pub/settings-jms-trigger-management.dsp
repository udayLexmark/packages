<html>

<head>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <meta http-equiv="Expires" content="-1">
  <link rel="stylesheet" type="text/css" href="webMethods.css">
  <script src="webMethods.js.txt"></script>
  
  <script language ="javascript">

  var hideStandard = "true";
  var hideSOAP = "true";

  /**
   *
   */     
  function changeTriggerState() {
    return confirm("Would you like to make this change across the entire cluster?");  
  }
  
  /**
   *
   */     
  function popUp(URL) {
    day = new Date();
    id = day.getTime();
    eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=200,height=200,left = 540,top = 412');");
  }
  
  /**
   *
   */ 
  function toggle(parent, id, imgID) {
    
    var set = 'none';
    var imgElem = document.getElementById(imgID);
    var name = parent.getAttribute('name');
    
    if(name == 'StandardHeader') {
      if (hideStandard == "true") {
        set = 'table-row';
        hideStandard = "false";
        imgElem.src = 'images/expanded.gif'
      }else {
        hideStandard = "true";
        imgElem.src = 'images/collapsed.gif'
      }
    }else {
     if (hideSOAP == "true") {
        set = 'table-row';
        hideSOAP = "false";
        imgElem.src = 'images/expanded.gif'
      }else {
        hideSOAP = "true";
        imgElem.src = 'images/collapsed.gif'
      }
    }
		
		var elements = getElements("TR", id);
		for ( var i = 0; i < elements.length; i++) {
      var element = elements[i];
      element.style.cssText = "display:"+set;
    }
  }
  
  /**
   *
   */ 
  function open(id, imgID) {
      
    var imgElem = document.getElementById(imgID);
    set = 'table-row';
    imgElem.src = 'images/expanded.gif'
		var elements = getElements("TR", id);
		for ( var i = 0; i < elements.length; i++) {
      var element = elements[i];
      element.style.cssText = "display:"+set;
    }
  }
  
  /**
   *
   */     
  function getElements(tag, name) {
    var elem = document.getElementsByTagName(tag);
    var arr = new Array();
    for(i=0, idx=0; i<elem.length; i++) {
      att = elem[i].getAttribute("name");
      if(att == name) {
        arr[idx++] = elem[i];
      }
    }
    return arr;
  }
  
   /**
    *
    */
   function loadDocument() {
     setNavigation('settings-broker.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Settings_Msging_JMS_TriggerMgmt');
  
     // when you return to this page from editState we need to open the trigger type that was being edited
     if ("standard" == '%value type%') {
       open('Standard', 'StandardImg');
       hideStandard = "false";
     }else if ("soap" == '%value type%') {
       open('SOAP', 'SOAPImg');
       hideSOAP = "false";
     }else if ("all" == '%value type%') {
       open('Standard', 'StandardImg');
       hideStandard = "false";
       open('SOAP', 'SOAPImg');
       hideSOAP = "false";
     }
   }     
   
    /**
     *
     */
    function refreshDSP() {
      if (hideStandard == "false" && hideSOAP == "false") {
        window.location = "settings-jms-trigger-management.dsp?type=all";
      }else if (hideStandard == "false") {
        window.location = "settings-jms-trigger-management.dsp?type=standard";
      }else if (hideSOAP == "false") {
        window.location = "settings-jms-trigger-management.dsp?type=soap";
      }
    }

    
  </script>
  
</head>

<body onLoad="loadDocument();">
  <table width="100%">
    <tr>
      <td class="menusection-Settings" colspan="2">Settings &gt; Messaging &gt; JMS Trigger Management</td>
    </tr>

    <!-- Enable/Disable Logic -->

    %switch action%
    
    <!-- Stop/Suspend/Enable Trigger Logic -->
    
    %case 'suspendTrigger'%
      %invoke wm.server.jms:suspendJMSTriggers%
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td class="message" colspan=2>%value message%</td>
        </tr>
      %onerror%
         <td class="message" colspan=2>%value errorMessage%</td>
      %endinvoke%  
      %rename triggerName editedTriggerName%
    
    %case 'enableTrigger'%
      %invoke wm.server.jms:enableJMSTriggers%
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td class="message" colspan=2>%value message%</td>
        </tr>
      %onerror%
         <td class="message" colspan=2>%value errorMessage%</td>
      %endinvoke%
      %rename triggerName editedTriggerName%
      
    %case 'disableTrigger'%
      %invoke wm.server.jms:disableJMSTriggers%
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td class="message" colspan=2>%value message%</td>
        </tr>
      %onerror%
         <td class="message" colspan=2>%value errorMessage%</td>
      %endinvoke%
      %rename triggerName editedTriggerName%

    <!-- Set Global Trigger Settings -->
    
    %case 'setSettings'%
      %invoke wm.server.jms:setSettings%
        <tr>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td class="message" colspan=2>%value message%</td>
        </tr>
      %endinvoke%  
    %end%
    
    %invoke LXKAdmin.server.query:getConnectionAliasReport%
    %invoke LXKAdmin.server.query:getJMSTriggerReport%
    
<!-- Navigation Menu -->
    
    <tr>
      <td colspan="2">
        <ul>
          <li><a href="settings-messaging.dsp">Return to Messaging</a></li>
          <li><a href="javascript:refreshDSP();">Refresh Page</a></li>          
        </ul>
      </td>
    </tr>
    
    <tr>
      <td Width=20><img src="images/blank.gif" height=10 width=20></td>

      <td>
        
<!-- Global JMS Trigger Controls -->
        
        <table width="100%">
        
          <tr>
            <td class="heading" colspan=4>Global JMS Trigger Controls</td>
          </tr>
          
           <tr>
            <td class="oddcol" width="20%">Thread Pool Throttle</td>
            <td class="oddrow-l" width="30%">%value settings/threadPoolMaxThreads% (%value settings/threadPoolThrottle%% of Server Thread Pool)</td>
            <td class="oddcol" width="20%">Processing Throttle</td>
            <td class="oddrow-l" width="30%">%value settings/processingThrottle%%</td>
          </tr> 
          
          <tr>
            <td>&nbsp;</td>
          </tr>
        
        </table>  

<!-- Individual Standard JMS Trigger Controls  -->
        
        <table width="100%">  
        
          <tr name="StandardHeader" onClick="toggle(this, 'Standard', 'StandardImg');">
            <td class="heading" colspan=7>
              <img id='StandardImg' src="images/collapsed.gif" border="0"><a name="StandardAnchor">&nbsp;Individual Standard JMS Trigger Controls </a>
            </td>
          </tr>
   
          <tr name="Standard" style="display: none;">
            <td class="oddcol-l">Trigger Name</td>
            <td class="oddcol-l">Connection Alias Name</td>
            <td class="oddcol-l" nowrap>Destination(s)</td>
            <td class="oddcol-l">Processing Mode</td>
            <td class="oddcol-l">Maximum Threads</td>
            <td class="oddcol-l">Current Threads</td>
            <td class="oddcol">Enabled&nbsp;&nbsp;</td>
          </tr> 
          
            <script>resetRows();</script>
            %loop triggerDataList%
          
              %ifvar trigger/jmsTriggerType equals('0')%
         
                <tr name="Standard" style="display: none;">
                  <script>writeTD("row-l");</script>%value node_nsName%</td>
                  <script>writeTD("row-l");</script>%value trigger/aliasName%</td>
                  <script>writeTD("row-l");</script>%value trigger/destinationsString%</td>
                  <script>writeTD("row-l");</script>%value trigger/processingModeLocalizedString%</td>
                  <script>writeTD("row-l");</script>%value trigger/maxThreadsString%</td>
                  <script>writeTD("row-l");</script>%value trigger/currentThreadsLocalizedString%</td>
                  <script>writeTD("rowdata");</script>

                  %switch trigger/state%
                    %case '0'%
                    
                      %ifvar trigger/currentThreads equals('-1')%
                        <img style="width: 13px; height: 13px;" alt="active" border="0" src="images/yellow_check.gif">Yes<br>
                      %else%
                        <img style="width: 13px; height: 13px;" alt="active" border="0" src="images/green_check.gif">Yes<br>
                      %endif%
                    
                    %case '1'%
                      No
                    %case '2'%
                        <img style="width: 13px; height: 13px;" alt="suspended" border="0" src="images/yellow_check.gif">Suspended<br>
                  %end%
                
                  </td>
                </tr>
		
                <script>swapRows();</script>
		
		<!-- Error Message --> 
                %ifvar trigger/lastError%
                <tr name="Standard" style="display: none;">
                  <script>writeTDspan("row-l", 8);</script>
                    <font color="red">%value trigger/lastError%</font><br> 
                  </td>
                </tr>
		<script>swapRows();</script>
              %endif%
		
              %endif%
            %endloop%
          
          <tr>
            <td>&nbsp;</td>
          </tr>
		
	         <!-- Individual SOAP JMS Trigger Controls  -->
		    %invoke LXKAdmin.server.query:getSetting%
			  %ifvar watt.server.enablePG equals(false)%
			     <tr name="SOAPHeader" onClick="toggle(this, 'SOAP', 'SOAPImg');" style="display:none">
				<td class="heading" colspan=7>
			        <img id='SOAPImg' src="images/collapsed.gif" border="0"><a name="SOAPAnchor">&nbsp;Individual SOAP JMS Trigger Controls </a>
			    </td>
			  </tr>
			  %else%
			    <tr name="SOAPHeader" onClick="toggle(this, 'SOAP', 'SOAPImg');">
			    <td class="heading" colspan=7>
			      <img id='SOAPImg' src="images/collapsed.gif" border="0"><a name="SOAPAnchor">&nbsp;Individual SOAP JMS Trigger Controls </a>
			    </td>
			  </tr>
			  %endif%

		    %endinvoke% 
		    <tr name="SOAP" style="display: none;">
		      <td class="oddcol-l">Trigger Name</td>
		      <td class="oddcol-l">Connection Alias Name</td>
		      <td class="oddcol-l" nowrap>Destination(s)</td>
		      <td class="oddcol-l">Processing Mode</td>
		      <td class="oddcol-l">Maximum Threads</td>
		      <td class="oddcol-l">Current Threads</td>
		      <td class="oddcol">Enabled&nbsp;&nbsp;</td>
		    </tr> 
		  
		    <script>resetRows();</script>
		    %loop triggerDataList%
		  
		    %ifvar trigger/jmsTriggerType equals('1')%
		 
        <tr name="SOAP" style="display: none;">
        %ifvar trigger/wseAlias -notempty%
          <script>writeTD("row-l");</script>
          WS Endpoint Trigger: %value trigger/wseAlias%<br>
          </td>
        %else%
          <script>writeTD("row-l");</script>%value node_nsName%</td>
        %endif%

			  <script>writeTD("row-l");</script>%value trigger/aliasName%</td>
			  <script>writeTD("row-l");</script>%value trigger/destinationsString%</td>
			  <script>writeTD("row-l");</script>%value trigger/processingModeLocalizedString%</td>
			  <script>writeTD("row-l");</script>%value trigger/maxThreadsString%</td>
			  <script>writeTD("row-l");</script>%value trigger/currentThreadsLocalizedString%</td>
			  <script>writeTD("rowdata");</script>

			  %switch trigger/state%
			    %case '0'%
			    
			      %ifvar trigger/currentThreads equals('-1')%
				  <img style="width: 13px; height: 13px;" alt="active" border="0" src="images/yellow_check.gif">Yes<br>
			      %else%
				  <img style="width: 13px; height: 13px;" alt="active" border="0" src="images/green_check.gif">Yes<br>
			      %endif%
			    
			    %case '1'%
			      No
			    %case '2'%
				<img style="width: 13px; height: 13px;" alt="suspended" border="0" src="images/yellow_check.gif">Suspended<br>
			  %end%
			
			  </td>
			</tr>
		      
			<script>swapRows();</script>
			
			
			<!-- Error Message --> 
			%ifvar trigger/lastError%
			<tr name="SOAP" style="display: none;">
			  <script>writeTDspan("row-l", 8);</script>
			    <font color="red">%value trigger/lastError%</font><br> 
			  </td>
			</tr>
			<script>swapRows();</script>
			%endif%

		      %endif%
		      
		    %endloop%
        </table>  
      </td>
    </tr>
    
   %onerror%
   
   <tr>
     <td class="message" colspan=2>%value errorService%<br>%value error%<br>%value errorMessage%<br></td>
   </tr>
                  
   %endinvoke%
                
   %onerror%
   
   <tr>
     <td class="message" colspan=2>%value errorService%<br>%value error%<br>%value errorMessage%<br></td>
   </tr>
                  
   %endinvoke%
  </table>
</body>
</html>