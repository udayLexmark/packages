<HTML>
<HEAD>

<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<META HTTP-EQUIV="Expires" CONTENT="-1">


<LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">
<SCRIPT SRC="webMethods.js.txt"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
  function confirmDelete (alias) {
    var msg = "OK to delete remote server '"+alias+"' from configuration?";
    if (confirm (msg)) {
        document.deleteform.alias.value = alias;
            document.deleteform.submit();
          return false;
    } else return false;
  }
  function test (alias)
  {
    document.testform.alias.value = alias;
      document.testform.submit();
    return false;
  }

</SCRIPT>
</HEAD>
<BODY onLoad="setNavigation('settings-remote.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Settings_RemoteServersScrn');">
<TABLE width="100%">
<TR>
    <TD class="menusection-Settings" colspan="2">
    Settings &gt;
    Remote Servers </TD>
</TR>


%ifvar action%
%switch action%
%case 'add'%
  %invoke wm.server.remote:addServer%
        %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
          <TR><TD class="message" colspan="2">%value message%</TD></TR>
        %endif%
  %endif%
%case 'edit'%
  %invoke wm.server.remote:addServer%
        %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
          <TR><TD class="message" colspan="2">%value message%</TD></TR>
        %endif%
  %endif%
%case 'test'%
  %invoke wm.server.remote:testAlias%
        %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
          <TR><TD class="message" colspan="2">%value message%</TD></TR>
        %endif%
  %endif%
%case 'delete'%
  %invoke wm.server.remote:deleteServer%
        %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
          <TR><TD class="message" colspan="2">%value message%</TD></TR>
        %endif%
  %endif%
%endswitch%
%endif%
<TR>
    <TD><IMG SRC="images/blank.gif" height=10 width=10></TD>
    <TD>
    <TABLE class="tableView" width=100%>

    <TR>
        <TD class="heading" colspan=10>Remote Servers List</TD>
    </TR>
%invoke LXKAdmin.server.query:serverList%
<TR>
   <TD class="oddcol-l">Alias</TD>
   <TD class="oddcol">Host</TD>
   <TD class="oddcol">Port</TD>
   <TD class="oddcol">User</TD>
   <TD class="oddcol">SSL</TD>
   <TD class="oddcol">Execute ACL</TD>
   <TD class="oddcol">KeepAlive Conns</TD>
   <TD class="oddcol">Timeout</TD>
</TR>

%loop -struct servers%
%scope #$key%
<TR>
    <script>writeTD("rowdata-l");</script>

        %value alias%

    </TD>
    <script>writeTD("rowdata");</script>%value host%</TD>
    <script>writeTD("rowdata");</script>%value port%</TD>
    <script>writeTD("rowdata");</script>%value user%</TD>
    <script>writeTD("rowdata");</script>
      %ifvar ssl equals('yes')%
        <IMG SRC="images/green_check.gif" height=13 width=13>Yes
      %else%
        No
      %endif%
    </TD>
    <script>writeTD("rowdata");</script>
      %ifvar acl%
        %ifvar acl equals('')%
          &lt;none&gt;
        %else%
          %value acl%
        %endif%
      %else%
        &lt;none&gt;
      %endif%</TD>
    <script>writeTD("rowdata");</script>%value keepalive%</TD>
    <script>writeTD("rowdata");</script>
      %ifvar timeout equals('-1')%&nbsp;%else%%value timeout%%endif%</TD>
</TR>

    <script>swapRows();</script>
%endscope%
%endloop%
%endinvoke%
</TABLE>
</TD>
</TR>
</TABLE>

<FORM name="deleteform" action="settings-remote.dsp" method="POST">
  <INPUT type="hidden" name="action" value="delete">
  <INPUT type="hidden" name="alias">
</FORM>

<FORM name="testform" action="settings-remote.dsp" method="POST">
  <INPUT type="hidden" name="action" value="test">
  <INPUT type="hidden" name="alias">
</FORM>

</BODY>
</HTML>
