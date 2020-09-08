<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Project Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>

<BODY>
                
<form method="POST" Action="saveProject.dsp?operationType=UPDATE">
	
	%invoke LXKWMSupport.flow.dsp:getProjectDetails%
	%endinvoke%
	    
	    <p>Project Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="projectName" size="20" value="%value projects[0]/PROJECTNAME%"></p>
		<p>Project Description:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea rows="2" name="description" cols="20">%value projects[0]/DESCRIPTION%</textarea>&nbsp;</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
		<p><input type="hidden" name="projectId" value=%value projects[0]/PROJECTID%></p>
		<input type="submit" value="UPDATE" name="operationType" style="font-weight: bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset" name="RESET" style="font-weight: bold"></p>
		
</form>

</BODY>
</HTML>
