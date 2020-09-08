<HTML>
    <HEAD>
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <META HTTP-EQUIV="Expires" CONTENT="-1">
        <LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">
    </HEAD>

    <script>
        function launchHelp() {
            if (parent.menu != null){
                window.open(parent.menu.document.forms["urlsaver"].helpURL.value, 'help', "directories=no,location=yes,menubar=yes,scrollbars=yes,status=yes,toolbar=yes,resizable=yes", true);
            }
        }
        
	function logIEout() {
	  if (confirm("OK to logout?")) {
	     document.execCommand("ClearAuthenticationCache"); 
	    return true;
	  } else {
	    return false;
	  }
	} 
	   
        function loadPage(url) {
            window.location.replace(url);
        }
    
        %ifvar message%
            %ifvar norefresh%
            %else%
                setTimeout("loadPage('top.dsp')", 30000);
            %endif%
        %endif%
    </script>

    <BODY class="topbar" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0">
         
        <table border=0 cellspacing=0 cellpadding=0 height=47 width=100%>
            <tr>
                <td>
                    <TABLE height=14 width=100% CELLSPACING=0 BORDER=0>
                        <TR>
                            <TD nowrap class="toptitle" width="100%">
                                %value $host%
                                ::
                                Integration Server
                                %ifvar text%
                                    ::
                                    %value text%
                                %endif%
                            </TD>
                        </TR>
                    </TABLE>
                </td>
            </tr>
      
            <tr height=100%>
                <td>
                    <TABLE width=100% height=33 CELLSPACING=0 BORDER=0>                    
                        <TR>
                            %ifvar adapter%
                            %else%
                                %invoke wm.server.query:isSafeMode%
                                    %ifvar isSafeMode equals('true')%
                                        %ifvar isSane equals('false')%
                                            <TD width=75% class="keymessage">
                                                <center>
                                                    SERVER IS RUNNING IN SAFE MODE. Master password sanity check failed -- invalid master password provided. 
                                                </center>
                                            </TD>
                                        %else%
                                            <TD width=50% class="keymessage">
                                                <center>
                                                    SERVER IS RUNNING IN SAFE MODE
                                                </center>
                                            </TD>
                                        %endif%
                                    %endif%
                                %endinvoke%

                                %invoke wm.server.query:getLicenseSettings%
                                    %ifvar keyExpired%
                                        <TD width=100%>
                                            <center>
                                                %comment% <A class="keymessage" HREF="settings-license-edit.dsp" TARGET="body">
                                                    License Key is Expired or Invalid.
                                                </A> %endcomment%
                                            </center>
                                        </TD>
                                    %else%
                                        %ifvar keyExpiresIn%
                                            <TD width=100%>
                                                <center>
                                                    &nbsp;
                                                    %comment% <A class="keymessage" HREF="settings-license-edit.dsp" TARGET="body">
                                                        %ifvar keyExpiresIn equals('0')%
                                                            License Key expires today.
                                                        %else%
                                                            License Key expires in about %value keyExpiresIn% days
                                                        %endif%
                                                    </A> %endcomment%
                                                </center>
                                            </TD>
                                        %else%
                                            <TD nowrap width=100% class="topmenu">&nbsp;</TD>
                                        %endif%
                                    %endif%
                                %endinvoke%
                            %endif%

                            <TD nowrap valign="bottom" class="topmenu">
							<A target='_top' href='/invoke/wm.server/disconnect?sessionid=%value sessionid%'
               onclick="return logIEout();" >Log Off</A> |
			   
							<A target='body' href='server-environment.dsp'>About</A>
                                    |
                                    <A target='body' onclick="launchHelp();return false;" href='#'>Help</A>&nbsp; 
			        
				 %invoke wm.server:getSessionID% 
				   %ifvar sessionid not  equals('null')%				  
				   %endif%  
				   
                                %ifvar adapter%
				   
                                    <A href='javascript:window.parent.close();'>Close Window</A>
                
                                    %ifvar adapter equals('SAP')%
                                        | <a  target="body" href="/SAP/sapAbout_aboutPage.dsp">About</a>
                                    %endif%
                                    %ifvar help%
                                        | <A target='adapter-body' onclick="launchHelp();return false;" href='#'>Help</A>
                                    %endif%
                               %else%
                                    %comment% <A target='body' href='server-shutdown.dsp%ifvar css%?css=%value css%%endif%'>
                                        Shut Down and Restart
                                    </A>
					 | %endcomment%                                    
                                   
				    
                                %endif%
				 %end%
                                 
				
                            </TD>
                        </TR>
    
                        <TR>
                        </TR>
                    </TABLE>
                </td>
            </tr>
        </table>
    </BODY>
</HTML>