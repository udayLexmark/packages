<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Interface Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>
<BODY>

<FORM NAME="tableForm" ACTION="results.dsp">

<table border="1" width="97%" id="table1" height="122" bgcolor=#FFFF99 cellspacing="0">
	<tr bgcolor=#99FFFF>
		<th>Project Name</th>
		<th>Interface Name</th>
		<th>Interface Type</th>
		<th>Description</th>
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
	</tr>
	<tr>
		%invoke LXKWMSupport.flow.dsp:getAllProjects%
		<TD><SELECT NAME="PROJECTID">
			%loop projectList%
			       %ifvar PROJECTID vequals(../PROJID)%
					<OPTION VALUE=%value PROJECTID% selected>%value PROJECTID% - %value PROJECTNAME%</OPTION>
				%else%
					<OPTION VALUE=%value PROJECTID%>%value PROJECTID% - %value PROJECTNAME%</OPTION>
				%endifvar%
			%endloop%  
		    </SELECT></TD>
		<TD><textarea name="INTERFACENAME"></textarea></TD>
		<TD><textarea name="INTERFACETYPE"></textarea></TD>
		<TD><textarea name="DESCRIPTION"></textarea></TD>
		%invoke LXKWMSupport.flow.dsp:getAppNames%
		<TD> <SELECT NAME="SRCAPPLID">
			 %loop getApps%
				<OPTION VALUE=%value APPLICATIONID%>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
			 %endloop%
		    </SELECT></TD>
		<TD> <SELECT NAME="TGTAPPLID">
			 %loop getApps%
				<OPTION VALUE=%value APPLICATIONID%>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
				 %endloop%  
		    </SELECT> </TD>
		%endinvoke%
		<TD> <textarea name="DOCUMENTNAME"></textarea> </TD>
		<TD> <textarea name="SERVICENAME"></textarea></TD>
		<TD> <textarea name="TRIGGERNAME"></textarea></TD>
		<TD> <textarea name="ADAPTERTYPE"></textarea></TD>
		<TD> <textarea name="ADAPTERCONNECTION"></textarea></TD>
		<TD> <textarea name="MONITORINGNOTES" wrap="hard" rows="4" style="scroll"></textarea></TD>
		<TD> <textarea name="DISTRIBUTIONLIST"></textarea></TD>
		<TD> <textarea name="SERVER"></textarea></TD>
		<TD> <textarea name="PORT"></textarea></TD>
		<TD> <textarea name="SUPPORTCONTACTLIST"></textarea></TD>
		
	</tr>
		<INPUT TYPE="HIDDEN" NAME="PROJECTID" VALUE="%value PROJECTID%">
		<INPUT TYPE="HIDDEN" NAME="INTERFACEID" VALUE="%value INTERFACEID%">
		<INPUT TYPE="HIDDEN" NAME="operationType" VALUE="ADD">

	
		
</table>
	
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="submit" value="ADD" name="B1" style="padding-right: 30px; background-color: #C0C0C0">
	
</FORM>
</BODY>
</HTML>
