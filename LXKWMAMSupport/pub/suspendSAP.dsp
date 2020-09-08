<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title style="color:blue">Suspended SAP Components</title>
</HEAD>
<BODY>
<h3 style="color:blue">Suspended SAP Components</h3>
%invoke LXKWMAMSupport.monitorSAPClient.utils:suspendAll%

<TABLE>
<TR><TD>%value outMsg%</TD></TR>
<TR><TD>%value Schedulers%</TD></TR>
</TABLE>

</BODY>
</HTML>