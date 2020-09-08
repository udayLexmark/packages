<HTML>
  <HEAD>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">
    <SCRIPT SRC="webMethods.js.txt"></SCRIPT>

    <TITLE>Integration Server -- Port Access Management</TITLE>
    <SCRIPT SRC="ports.js"></SCRIPT>
    
%invoke wm.server.net.listeners:ListenerAdmin%

  %ifvar configURL%
    <script>
        if(is_csrf_guard_enabled && needToInsertToken) {
			document.location.replace("%value configURL%?listenerKey=%value listenerKey encode(url)%&pkg=%value pkg encode(url)%&ssl=%value ssl encode(url)%%ifvar listenerType%&listenerType=%value listenerType encode(url)%%endif%%ifvar mode%&mode=%value mode encode(url)%%endif%%ifvar listening%&listening=%value listening encode(url)%%endif%%ifvar portName%&portName=%value portName encode(url)%%endif%&"+_csrfTokenNm_+"="+_csrfTokenVal_);
        } else {
			document.location.replace("%value configURL%?listenerKey=%value listenerKey encode(url)%&pkg=%value pkg encode(url)%&ssl=%value ssl encode(url)%%ifvar listenerType%&listenerType=%value listenerType encode(url)%%endif%%ifvar mode%&mode=%value mode encode(url)%%endif%%ifvar listening%&listening=%value listening encode(url)%%endif%%ifvar portName%&portName=%value portName encode(url)%%endif%");
        }
    </script>
  %endif%

  %ifvar message%
    <script>
        if(is_csrf_guard_enabled && needToInsertToken) {
			document.location.replace("security-ports.dsp?message2=%value message encode(url)%&"+_csrfTokenNm_+"="+_csrfTokenVal_);
        } else {
			document.location.replace("security-ports.dsp?message2=%value message encode(url)%");
        }
    </script>
  %endif%


%endinvoke%

  </HEAD>

  <BODY onLoad="setNavigation('security-ports.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Security_PortsScrn');">
    <TABLE width="100%">
      <TR>
        <TD class="breadcrumb" colspan="2"> Security &gt; Ports  </TD>
      </TR>
        %ifvar message2%
      <tr><td colspan="2">&nbsp;</td></tr>
          <TR><TD class="message" colspan="2">%value message2 encode(html)%</TD></TR>
        %endif%


      <TR>
        <TD>
          <TABLE class="tableView" width="100%">
            %invoke wm.server.ports:listListeners%
            <TR>
              <TD class="heading" colspan="11">Port List</TD>
            </TR>

            <TR>
              <TD class="oddcol">Port</TD>
              <TD class="oddcol">Alias</TD>
              <TD class="oddcol">Protocol</TD>
              <TD class="oddcol">Type</TD>
              <TD class="oddcol">Package</TD>
              <TD class="oddcol">Enabled</TD>
              <TD class="oddcol">Description</TD>
            </TR>

            %loop listeners%
            %invoke wm.server.quiesce:isDisableQuiescePort%
            <TR>
              
              <script>writeTD("rowdata");</script>
                %ifvar protocol equals('Email')%
                  
                    %value encode(html) user%@%value host encode(html)%
                  
                %else%
                  %ifvar listenerType equals('regularinternal')%
                    
				    %value proxyHost encode(html)%:%value port encode(html)%
                    
                  %else%
					
             %value port encode(html)%
                   
                  %endif%
                %endif%
              </TD>

           
              <script>writeTD("rowdata");</script>%value portAlias encode(html)%</TD>

            
              <script>writeTD("rowdata");</script>
                    		%value protocol encode(html)% </TD>

            
              <script>writeTD("rowdata");</script>
                          %ifvar listenerType%
                            %switch listenerType%
                              %case 'revinvokeinternal'%
                                Enterprise Gateway Registration
                              %case 'regularinternal'%
                                Registration Internal
                              %case 'revinvoke'%
                               Enterprise Gateway External
                              %case 'Regular'%
                                %ifvar primary equals('true')%
                                  <b> Primary</b>
                                %else%
                                  Regular
                                %endif%
                              %case 'Diagnostic'%
                                Diagnostic
                              %case%
                                %value listenerType encode(html)%
                              %endswitch%
                          %else%
                            Regular
                          %endif%</TD>

             
              <script>writeTD("rowdata");</script>%value pkg encode(html)%</TD>

            
              <script>writeTD("rowdata");</script>

                %ifvar primary equals('true')%
                  %ifvar listening equals('true')%
                    <b>Yes</b>
                  %else%
                    <b>&nbsp;&nbsp;&nbsp;No</b>
                  %endif%
                %else%
                  %ifvar listening equals('true')%
                    <b>Yes</b></a>
                  %else%
                    <b>No</b></a>
                  %endif%
                %endif%
              </TD>
 
      
              <script>writeTD("rowdata");</script>
                    		%value portDescription encode(html)% </TD>

            </TR>
            <script>swapRows();</script>
            %endinvoke%
            %endloop%

            %endinvoke%
          </TABLE>
        </TD>
      </TR>
    </TABLE>

    <form name="listeners" action="security-ports.dsp" method="POST">
    <input type="hidden" name="listenerKey">
    <input type="hidden" name="portName">
    <input type="hidden" name="factoryKey">
    <input type="hidden" name="operation">
    <input type="hidden" name="mode">
    <input type="hidden" name="listening">
    <input type="hidden" name="pkg">
    </form>

    <form name="addListener" action="security-ports.dsp" method="POST">
    <input type="hidden" name="operation" value="create">
    <input type="hidden" name="action" value="edit">
    </form>

  </BODY>
</HTML>

