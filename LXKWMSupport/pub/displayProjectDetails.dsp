<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Interface Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>

<BODY>
<form name="form1">

%invoke Server:getServerDomainNamePort%
%endinvoke%

%invoke LXKWMSupport.flow.dsp:getAllProjects%
%endinvoke%

	<table border="1" width="100%" id="table1" cellspacing="0" bgcolor=#FFFF99>
		<tr bgcolor=#99FFFF>
		       	<th>Project Id</th>
			<th>Project Name</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
		%loop projectList%
		
			<tr>
			<td>%value PROJECTID%</td>
			<td><a href="http://%value ../serverNamePort%/LXKWMSupport/getInterfacesDetails.dsp?PROJECTID=%value PROJECTID%">%value PROJECTNAME%</a></td>
			<td>%value DESCRIPTION%</td>
			<td><a href="http://%value ../serverNamePort%/LXKWMSupport/saveProject.dsp?projectId=%value PROJECTID%&projectName=%value PROJECTNAME%&operationType=DELETE">DELETE</a></td>
			<td><a href="http://%value ../serverNamePort%/LXKWMSupport/updateProject.dsp?projectId=%value PROJECTID%&operationType=UPDATE">UPDATE</a></td>
			</tr>
		%endloop%	
		
	</table>
	<br>
	<br>
	<br>
		
</form>
<form name="form2" Action="addProject.dsp">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp&nbsp
<input type="submit" value="Add Project" name="Add" style="font-weight: bold">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</form		
</BODY>
</HTML>
