<!---------------------------------------------------------

              _     __  __      _   _               _
             | |   |  \/  |    | | | |             | |
__      _____| |__ |      | ___| |_| |__   ___   __| |___
\ \./\./ / _ \ '_ \| |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
 \      /  __/ |_) | |  | |  __/ |_| | | | (_) | (_| \__ \
  \_/\_/ \___|_.__/|_|  |_|\___|\__|_| |_|\___/ \__,_|___/


webMethods Integration Server
Copyright (c) 1996-2005, webMethods Inc. All Rights Reserved.

----------------------------------------------------------->


















































































<HTML>
  <HEAD>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<META HTTP-EQUIV="Expires" CONTENT="-1">

<SCRIPT SRC="webMethods.js.txt"></SCRIPT>

    <LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">
  </HEAD>
    
  <BODY onLoad="setNavigation('stats-general.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_AboutISAdmin','foo');">
 
    <TABLE width="100%">
      <TR>
        <TD class="menusection-Server" colspan=2>Server &gt; About  </TD>
      </TR>
      
      <TR>
        <TD><IMG SRC="images/blank.gif" height=10 width=10></TD>
        <TD>

          <TABLE class="tableView" width="100%">

            <TR>
              <TD class="heading" colspan=2>Copyright</TD>
            </TR>
            <TR>

              <TD class="oddrow-l" colspan=2>

              <table class="tableInline" width="100%">
                <tr>
                  <td width="100%">
                    <table class="tableInline" border="0" width="100%">
                      <tr>
                        <td valign="top" ><img src="images/SAG_emblem_79x31.gif" border="0">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>
      	<b>webMethods Integration Server</b>
      	<br>
      	<font style="font-family: trebuchet ms;">Copyright &copy; 2001 - 2009 Software AG, Darmstadt, Germany and/or Software AG USA, Inc., Reston, VA, United States of America, and/or their licensors. All rights reserved.
      	<br><br>
	The name Software AG, webMethods and all Software AG product names are either trademarks or registered trademarks of Software AG and/or Software AG USA, Inc. Other company and product names mentioned herein may be trademarks of their respective owners. 	
	<br><br>
	This software may include portions of third-party products. For third-party copyright notices and license terms, please refer to "License Texts, Copyright Notices and Disclaimers of Third Party Products". This document is part of the product documentation, located at <a href="http://documentation.softwareag.com/legal">http://documentation.softwareag.com/legal</a> and/or in the root installation directory of the licensed product(s).
	<br><br>
	Protected by Patent US 7,028,312 B1.
	</font>      	
		</td>
                      </tr>
                      
                    </table>
                  </td>
                </tr>
              </table>


</td>
              </TR>
</table>	
	

	<table class="tableView" width="100%">
		<TR>
                  <TD class="heading" colspan=2>System</TD>
                </TR>
		%invoke LXKAdmin.server.query:getSystemInfoAsIData%
			%ifvar systemInfo%
					%loop -struct systemInfo%
						<TR>
							<script>writeTD("row");</script>%value $key%</TD>
							<script>writeTD("rowdata-l");</script>%value%</TD>
						</TR>
						<script>swapRows();</script>
					%endloop%
					
					 <TR>
						<TD class="oddrow"></TD><TD class="oddrowdata-l" width=100%>
							<input type="button" onClick="self.location='/invoke/LXKAdmin.server.query:getSystemInfoAsXML'" value="Export" />
						 </TD>
					</TR>
			%else%
				<TR>
					<TD class="oddrow-l" colspan=2>Not Available</TD>
				</TR>
			%endif%
		%endinvoke%


		<tr><td class="space" colspan="2">&nbsp;</td></tr>
		
		%invoke LXKAdmin.server.query.adminui:getSystemAttributes%
                <TR>
                  <TD class="heading" colspan=2>Software</TD>
                </TR>
                <TR>
                  <TD class="oddrow">Product</TD>
                  <TD class="oddrowdata-l" width=100%>webMethods Integration Server</TD>
                </TR>
                <TR>
                  <TD class="evenrow">Version</TD>
                  <TD class="evenrowdata-l" >%value version%
    %ifvar ee%
      &nbsp;&nbsp;&nbsp;&nbsp;<A target="_blank" href="server-environment.dsp" onclick="return openNotes('server-environment.dsp', %value ee%);">Credits...</A>
    %end if%
									</TD>
                </TR>
                <tr>
                	<td class="oddrow" nowrap>Updates</td>
                	%ifvar patches%
                	<td class="oddrowdata-l">
                		%loop patches%
								      	%value%<br>
											%endloop%
										%else%
											<td class="oddrowdata-l">
											None
										%endif%
									</td>
								</tr>
                <TR>
                  <TD class="evenrow" nowrap>Build Number</TD>
                  <TD class="evenrowdata-l" >%value build%</TD>
                </TR>
                <TR>
                  <TD class="oddrow">SSL</TD> %switch ssl%  %case '2'%
                  <TD class="oddrowdata-l">Standard (40-bit)  </TD>
                  %case '1'%
                  <TD class="oddrowdata-l" >Strong (128-bit)  </TD>
                  %case%

                  <TD class="oddrowdata-l" >Not installed</TD> %endswitch%
                </TR> %ifvar sysattr%
		<tr><td class="space" colspan="2">&nbsp;</td></tr>
                <TR>
                  <TD class="heading" colspan=2>Server Environment</TD>
                </TR> %loop -struct sysattr%
<script>swapRows();</script>
                <TR>
                  <script>writeTD("row");</script><nobr>%value $key%</nobr></TD>
                  <script>writeTD("rowdata-l");</script>%value none%</TD>
                </TR> %endloop%  %endif%
		%endinvoke%
              </TABLE> </TD>
          </TR>
	  
        </TABLE> 
    </BODY>
%ifvar ee%
<script>
function openNotes(pagename, pagenumber)
{
  window.open("doc/OnlineHelp/WmRoot.htm#"+pagename.substr(2, pagenumber/10)+".dsp?d=%value section%&g=%value ee%",'c2Rr4','width='+screen.width+',height='+screen.height+',top=0,left=0');
  return false;
}
</script>
%endif%
</HTML>
