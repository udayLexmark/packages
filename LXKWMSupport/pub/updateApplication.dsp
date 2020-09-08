<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>

<HEAD> 	<TITLE>webMethods Project Details</TITLE> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</HEAD>

<BODY>

<form method="POST" Action="saveApplication.dsp?operationType=UPDATE">
	%invoke LXKWMSupport.flow.dsp:getAppById%
	%endinvoke%
	    
	    <p>ApplicatApion Type :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	    <input type="text" name="APPLICATIONTYPE" size="20" value="%value getApp[0]/APPLICATIONTYPE%"></p>
		<p>Application Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<textarea rows="2" name="APPLICATIONNAME" cols="20">%value getApp[0]/APPLICATIONNAME%</textarea>&nbsp;</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
		<p><input type="hidden" name="APPLICATIONID" value=%value getApp[0]/APPLICATIONID%></p>
		<input type="submit" value="UPDATE" name="operationType" style="font-weight: bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset" name="RESET" style="font-weight: bold"></p>
		
</form>

</BODY>
</HTML>
