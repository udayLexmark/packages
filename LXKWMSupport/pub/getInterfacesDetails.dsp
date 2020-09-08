<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Interface Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>
<BODY>

%invoke Server:getServerDomainNamePort%
%endinvoke%

<FORM NAME="tableForm" ACTION="http://%value serverNamePort%/LXKWMSupport/addInterface.dsp?operationType=ADD">

<INPUT TYPE="HIDDEN" NAME="PROJID" VALUE="%value PROJECTID%">
			

<table border="1" width="100%" id="table1" height="122" bgcolor=#FFFF99 cellspacing="0">
	<tr bgcolor=#99FFFF>
		<th>Project Name</th>
		<th>Interface Name</th>
		<th>Interface Type</th>
		<th>Interfcae Description                               </th>
		<th>Source Application</th>
		<th>Target Application</th>
		<th>Document Name</th>
		<th>Service Name</th>
		<th>Trigger Name</th>
		<th>Adapter Type</th>
		<th>Adapter Connection</th>
		<th>Monitoring Notes</th>
		<th>Distribution List</th>
		<th>Server</th>
		<th>Port</th>
		<th>Support Contact List</th>
		<th></th>
		<th></th>
	</tr>
	%invoke LXKWMSupport.flow.dsp:getAllInterfaceDetails%
	%endinvoke%
	%loop getInterfaceOutput%
	<tr>
		<TD>%value PROJECTNAME%</TD>
		<TD>%value INTERFACENAME%</TD>
		<TD> %value INTERFACETYPE% </TD>
		<TD> %value DESCRIPTION% </TD>
		<TD> %value SRCAPPNAME% </TD>
		<TD> %value TGTAPPNAME% </TD>
		<TD> %value DOCUMENTNAME% </TD>
		<TD> %value SERVICENAME% </TD>
		<TD> %value TRIGGERNAME% </TD>
		<TD> %value ADAPTERTYPE% </TD>
		<TD> %value ADAPTERCONNECTION% </TD>
		<TD> <textarea name="MONITORINGNOTES" wrap="hard" rows="4" style="scroll">%value MONITORINGNOTES%</textarea></TD>
		<TD> %value DISTRIBUTIONLIST% </TD>
		<TD> %value SERVER% </TD>
		<TD> %value PORT% </TD>
		<TD> %value SUPPORTCONTACTLIST% </TD>
		<td><a href="http://%value ../serverNamePort%/LXKWMSupport/deleteInterface.dsp?PROJECTID=%value PROJECTID%&INTERFACEID=%value INTERFACEID%&INTERFACENAME=%value INTERFACENAME%&operationType=DELETE">DELETE</a></td>
		<td><a href="http://%value ../serverNamePort%/LXKWMSupport/updateInterface.dsp?PROJECTID=%value PROJECTID%&INTERFACEID=%value INTERFACEID%&SRCAPPID=%value SRCAPPID%&TGTAPPID=%value TGTAPPID%&operationType=UPDATE">UPDATE</a></td>
		
	</tr>
	 	
	 	
	%endloop%
	
</table>
	
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="submit" value="Add Interface" name="h1" style="padding-right: 30px; background-color: #C0C0C0">
	
</FORM>

<FORM NAME="Application" ACTION="http://%value serverNamePort%/LXKWMSupport/displayApplications.dsp">

        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
	
	
	
    	<input type="submit" value="Add Application" name="h2" style="padding-right: 20px; background-color: #C0C0C0">
	
</FORM>

</BODY>
</HTML>
