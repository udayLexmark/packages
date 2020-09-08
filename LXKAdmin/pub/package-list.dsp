<HTML>
   <HEAD>
    <meta http-equiv="Pragma" content="no-cache">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <META HTTP-EQUIV="Expires" CONTENT="-1">
    <TITLE>Integration Server Packages
    </TITLE>
    <LINK REL="stylesheet" TYPE="text/css" HREF="webMethods.css">

	<script src="packagefilter.js.txt"></script>

    <SCRIPT LANGUAGE="JavaScript">

      function confirmDelete (pkg, safe)
      {
        if(pkg == "WmRoot")
        {
            alert("'WmRoot' cannot be deleted");
            return false;
        }
        var s1 = "OK to Delete the '"+pkg+"' package?\n\n";
        var s2 = "Package will be sent to the salvage directory\n";

        if(safe == "true")
        {
          return confirm(s1+s2);
        }
        else
        {
          return confirm(s1);
        }
      }
      function confirmReload (pkg,pkgType)
      {
         if(pkg == "WmRoot")
         {
            alert("'WmRoot' cannot be reloaded");
            return false;
         }
         var s1 = "OK to reload the `"+pkg+"' package?\n\n";
         var s2 = "Reloading a package may cause sessions currently using\n";

         var s3 = "services in that package to fail.\n";
         var doReload;
         doReload = confirm (s1+s2+s3);
         if(doReload)
         {
            var sNativeWarning = "Warning: This package contains native code\n";
            var sNativeWarning2 = "libraries.  You must restart the server\n";

            var sNativeWarning3 = "to reload Java services.\n";
            if(pkgType == "2")
            alert(sNativeWarning+sNativeWarning2+sNativeWarning3);
         }
         return doReload;
      }
      function confirmDisable (pkg)
      {
         if(pkg == "WmRoot")
         {
            alert("'WmRoot' cannot be disabled");
            return false;
         }
         var s1 = "OK to disable the `"+pkg+"' package?\n\n";
         var s2 = "Disabling a package causes all its services to be \n";
         var s3 = "unloaded and marked unavailable for use.\n";
         return confirm (s1+s2+s3);
      }
      function confirmEnable (pkg)
      {
         var s1 = "OK to enable the `"+pkg+"' package?\n\n";
         var s2 = "Enabling a package causes all its services to be \n";
         var s3 = "loaded and marked available for use.\n";
         return confirm (s1+s2+s3);
      }

      </SCRIPT>
      <SCRIPT src="webMethods.js.txt"></SCRIPT>
   </HEAD>
   <BODY onLoad="setNavigation('package-list.dsp', '/WmRoot/doc/OnlineHelp/wwhelp.htm?context=is_help&topic=IS_Packages_MngmtScrn');">
      <DIV class="position">
         <TABLE WIDTH="100%">
            <TR>
               <TD class="menusection-Packages" colspan=2>Packages &gt; Management</TD>
            </TR>


    %ifvar action%
      %switch action%
        %case 'archive'%
          %invoke LXKAdmin.server.packages.adminui:packageRelease%
              %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
                  <TR><TD class="message" colspan=2>%value  message%</TD></TR>
              %endif%
          %onerror%
              %ifvar errorMessage%
      <tr><td colspan="2">&nbsp;</td></tr>
                  <TR><TD class="message" colspan=2>%value  errorMessage%</TD></TR>
              %endif%
          %endinvoke%
        %case 'backup'%
          %invoke LXKAdmin.server.packages.adminui:backup%
            %ifvar message%
      <tr><td colspan="2">&nbsp;</td></tr>
              <TR><TD class="message" colspan="2">%value none message%</TD></TR>
            %endif%
          %endinvoke%
      %endswitch%
    %endif action%

            %invoke LXKAdmin.server.packages:packageList%
            <TR>
                <TD colspan=2>
                    <UL>
                        <li id="showfew" name="showfew"><a href="javascript:showFilterPanel(true)">Filter Packages</a></li>
                        <!-- <li style="display:none" id="showall" name="showall"><a href="javascript:showFilterPanel()">Show All Packages</a></li>-->
                        <li style="display:none" id="showall" name="showall"><a href="package-list.dsp">Show All Packages</a></li>

                        <DIV id="filterContainer" name="filterContainer" style="display:none;padding-top=2mm;">
                        <br>
                        <table>
						<tr valign="top">
						<td>
                        <span >Filter criteria</span><br>
                        <input type="text" id="pfilter" name="pfilter" onKeyPress="filterPackages(event)"/>
						</td>

						<td>

						<table><tr><td>
						<IMG SRC="images/blank.gif" height=10 width=10>
						<input type="radio" id="enablep" name="enablep" onclick="setFlag('enabled')"/>
						<span id="enabletitle" name="enabletitle">Include Enabled Packages</span>

						</td></tr><tr><td>

						<IMG SRC="images/blank.gif" height=10 width=10>
						<input type="radio" id="enablep" name="enablep" onclick="setFlag('disabled')"/>
						<span id="disabletitle" name="disabletitle">Include Disabled Packages</span>

						</td></tr><tr><td>

						<IMG SRC="images/blank.gif" height=10 width=10>
						<input type="radio" id="enablep" name="enablep" checked onclick="setFlag('both')"/>
						<span id="enabletitle" name="enabletitle">Include Both</span>

						</td></tr></table>

						</td> <td>

						<IMG SRC="images/blank.gif" height=10 width=10>
						<input type="checkbox" id="nested" name="nested" />
                        <span id="nesttitle" name="nesttitle">Filter on result</span>
						</td> <td>
						<IMG SRC="images/blank.gif" height=10 width=10>
						<input type="checkbox" id="exclude" name="exclude" />
                        <span id="excludetitle" name="excludetitle">Exclude from result</span>
						</td> <td>
                        <IMG SRC="images/blank.gif" height=10 width=10>
                        <input type="Button" id="submit" name="submit" value="Submit" onclick="filterPackagesInternal()"/>
                        </td> </tr></table>
                        </DIV>
                    </UL>
                </TD>
            </TR>
            <TR>
	    	<TD id="result" colspan="2" align="right"></TD>
	    </TR>
            <TR>
            <TD>
            <IMG SRC="images/blank.gif" height=10 width=10></TD>
            <TD>
            <TABLE class="tableView" WIDTH=100% id="head" name="head">
            <TR>
                <TD CLASS="heading" COLSPAN=8>Package List</TD>
            </TR>
            <TR>
               <TD CLASS="oddcol-l">Package Name</TD>
               <TD CLASS="oddcol">Home</TD>
               <TD CLASS="oddcol">Reload</TD>
               <TD CLASS="oddcol">Enabled</TD>
               <TD CLASS="oddcol">Loaded</TD>
               <TD CLASS="oddcol">Archive</TD>
               <TD CLASS="oddcol">Safe Delete</TD>
               <TD CLASS="oddcol">Delete</TD>
            </TR>
            <script>resetRows();</script>
            %loop packages%
            <TR >
               <script>writeTD('rowdata-l');</script>
               			<A HREF="package-info.dsp?package=%value name%">%value name%</A>
               </TD>
               <script>writeTD('rowdata');</script>
               		%ifvar enabled equals('true')%
										<IMG SRC="icons/icon_home.gif" border="0"
										alt="Home Page for Package">
									%else%
										<IMG SRC="icons/icon_home.gif" border="0"
										alt="Home Page for Package">
									%endif%
							 </TD>
               <script>writeTD('rowdata');</script>
                  <IMG SRC="icons/icon_reload.gif" border="0"
                  alt="Reload Package"></TD>
               <script>writeTD('rowdata');</script>
                  %ifvar enabled equals('true')%
                  <IMG SRC="images/green_check.gif" border="0"
                  height=13 width=13>Yes%else%
        	<IMG border="0" SRC="images/blank.gif" height=13 width=13>No %endif%</TD>
               <script>writeTD('rowdata');</script>

                  %ifvar loaderr equals('0')%
                    %ifvar enabled equals('false')%
                      <IMG SRC="images/blank.gif" height=13 width=13
                      alt="Disabled"> No
                    %else%
                        %ifvar loadwarning equals('0')%
                              <IMG SRC="images/green_check.gif" height=13 width=13
                              alt="Loaded"> Yes
                          %else%
                              <IMG SRC="images/yellow_check.gif" height=13 width=13
                              alt="Warnings during load."> <font color="red"> Warnings </font>
                          %endif%
                    %endif%
                  %else%
                    %ifvar loadok equals('0')%
                      <IMG SRC="images/blank.gif" height=13 width=13
                      alt="Load Errors"> No
                    %else%
                      <IMG SRC="images/yellow_check.gif" height=13 width=13
                      alt="Error during load."> <font color="red">Partial</font>
                    %endif%
                  %endif%
               </TD>
         <script>writeTD('rowdata');</script>
                  <A class="imagelink"  HREF="package-archive.dsp?package=%value name%&archive=true">
                     <IMG src="images/archive_package.gif" border=0 width=43 height=16></A></TD>
         </td>
               <script>writeTD('rowdata');</script>
                  <IMG src="images/safe_delete.gif" border=0 width=43 height=16></TD>
               <script>writeTD('rowdata');swapRows();</script>
                  <IMG SRC="icons/delete.gif" alt="Delete this Package" border="0"></TD>
            </TR> %endloop%
            </TABLE></TD></TR>
         </TABLE> %endinvoke%

         
         %ifvar pfilter -notempty%
         <script>
         	
         	showFilterPanel();

         	var pfilter = document.getElementById("pfilter");
         	pfilter.value="%value pfilter%"

         	%ifvar regex -notempty%
         	var regex = document.getElementById("regex");
         	pfilter.checked=true;
         	%endif%

         	%ifvar exclude -notempty%
		var excludeFromResult = document.getElementById("exclude");
		excludeFromResult.checked=true;
         	%endif%

		filterPackagesInternal();

         </script>
          %endif%

      </DIV>
   </BODY>
</HTML>
