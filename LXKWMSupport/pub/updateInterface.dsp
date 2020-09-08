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
	%invoke LXKWMSupport.flow.dsp:getInterfcaeDetails%
	%endinvoke%
	%loop getInterfaceDetails%
	<tr>
		<TD>%value PROJECTNAME%</TD>
		<TD><textarea name= "INTERFACENAME">%value INTERFACENAME%</textarea></TD>
		<TD> <textarea name="INTERFACETYPE" >%value INTERFACETYPE%</textarea> </TD>
		<TD> <textarea name="DESCRIPTION" >%value DESCRIPTION%</textarea> </TD>
		%invoke LXKWMSupport.flow.dsp:getAppNames%
		<TD> <SELECT NAME="SRCAPPLID">
			 %loop getApps%
			        %ifvar APPLICATIONID vequals(../SRCAPPLID)%
			            <OPTION VALUE=%value APPLICATIONID% selected>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
			        %else%
					<OPTION VALUE=%value APPLICATIONID%>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
				%endifvar%
			%endloop%  
		    </SELECT> </TD>
		<TD> <SELECT NAME="TGTAPPLID">
			%loop getApps%
			         %ifvar APPLICATIONID vequals(../TGTAPPLID)%
				   	<OPTION VALUE=%value APPLICATIONID% selected>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
				 %else%
				 	<OPTION VALUE=%value APPLICATIONID%>%value APPLICATIONID% - %value APPLICATIONNAME%</OPTION>
				 %endifvar%
			%endloop%  
		    </SELECT> </TD></TD>
		%endinvoke%
		
		<TD> <textarea name="DOCUMENTNAME" >%value DOCUMENTNAME%</textarea> </TD>
		<TD> <textarea name="SERVICENAME" >%value SERVICENAME% </textarea></TD>
		<TD> <textarea name="TRIGGERNAME" >%value TRIGGERNAME% </textarea></TD>
		<TD> <textarea name="ADAPTERTYPE" >%value ADAPTERTYPE% </textarea></TD>
		<TD> <textarea name="ADAPTERCONNECTION" >%value ADAPTERCONNECTION%</textarea></TD>
		<TD> <textarea name="MONITORINGNOTES" wrap="hard" rows="4" style="scroll">%value MONITORINGNOTES%</textarea></TD>
		<TD> <textarea name="DISTRIBUTIONLIST">%value DISTRIBUTIONLIST% </textarea> </TD>
		<TD> <textarea name="SERVER" >%value SERVER%</textarea></TD>
		<TD> <textarea name="PORT" >%value PORT%</textarea></TD>
		<TD> <textarea name="SUPPORTCONTACTLIST" >%value SUPPORTCONTACTLIST%</textarea></TD>
	</tr>
		<INPUT TYPE="HIDDEN" NAME="PROJECTID" VALUE="%value PROJECTID%">
		<INPUT TYPE="HIDDEN" NAME="INTERFACEID" VALUE="%value INTERFACEID%">
		<INPUT TYPE="HIDDEN" NAME="operationType" VALUE="UPDATE">
		
		
		
	%endloop%
	
		
</table>
	
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="submit" value="UPDATE" name="B1" style="padding-right: 30px; background-color: #C0C0C0">
	
	
	
	
	
</FORM>
 

</BODY>
</HTML>
