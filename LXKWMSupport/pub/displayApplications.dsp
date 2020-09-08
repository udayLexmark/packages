<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Interface Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>

<BODY>
<form name="form1">

%invoke Server:getServerDomainNamePort%
%endinvoke%

%invoke LXKWMSupport.flow.dsp:getAllApps%
%endinvoke%



	<table border="1" width="100%" id="table1" cellspacing="0" bgcolor=#FFFF99>
		<tr bgcolor=#99FFFF>
		       	<th>Application Id</th>
			<th>Application Type</th>
			<th>Application Name</th>
			<th></th>
			<th></th>
		</tr>
		%loop applicationList%
		
			<tr>
			<td>%value APPLICATIONID%</td>
			<td>%value APPLICATIONTYPE%</td>
			<td>%value APPLICATIONNAME%</td>
			<td><a href="http://%value ../serverNamePort%/LXKWMSupport/saveApplication.dsp?APPLICATIONID=%value APPLICATIONID%&APPLICATIONNAME=%value APPLICATIONNAME%&operationType=DELETE">DELETE</a></td>
			<td><a href="http://%value ../serverNamePort%/LXKWMSupport/updateApplication.dsp?APPLICATIONID=%value APPLICATIONID%&operationType=UPDATE">UPDATE</a></td>
			</tr>
		%endloop%	
		
	</table>
	<br>
	<br>
	<br>
		
</form>
<form name="form2" Action="addApplication.dsp">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp&nbsp
<input type="submit" value="Add Application" name="Add" style="font-weight: bold">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</form		
</BODY>
</HTML>
