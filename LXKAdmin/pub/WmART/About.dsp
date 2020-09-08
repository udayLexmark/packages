%comment%----- Displays adapter type deployment data -----%endcomment%

<HTML>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <meta http-equiv="Expires" CONTENT="-1">
    <title>About</title>
    <link rel="stylesheet" TYPE="text/css" HREF="../webMethods.css"></link>
    <SCRIPT SRC="../webMethods.js.txt"></SCRIPT>
</head>


%invoke wm.art.admin:getAdapterTypeOnlineHelp%
%onerror%
%endinvoke%
<BODY onLoad="setNavigation('About.dsp', '%value helpsys%', 'foo');">
    %invoke wm.art.admin:retrieveAdapterTypeData%
    <table width="100%">  
    <tr>
       <td class="menusection-Adapters" colspan=5>Adapters &gt; %value displayName% &gt; About</td>
    </tr>
    <tr>
    <td colspan=2>
        <ul>
        <li><a href="ListResources.dsp?adapterTypeName=%value -urlencode adapterTypeName%&dspName=.LISTRESOURCES">Return to %value displayName% Connections
        </a></ul>
    </td>
    </tr>
    <tr>
        <td class="heading" colspan=5>About %value displayName%</td>
    </tr>        
    
    <tr>
        <td class="heading" colspan=5>Copyright</td>
    </tr>
    %ifvar THIRDPARTYCOPYRIGHTURL -isnull%
      %ifvar vendorName equals('webMethods')%
      <tr>
      <script>writeTD('row');</script>
      <img src="/WmRoot/images/wmlogo.gif" border=0></td>
      <script>writeTD('rowdata-l');swapRows();</script>
      <p>
      webMethods Business Integrator, webMethods Workflow, webMethods Integration Server, webMethods Enterprise Server, 
      webMethods Enterprise Integrator, webMethods Mainframe, webMethods Developer, webMethods Trading Networks, 
      webMethods Manager, webMethods Monitor, webMethods Administrator, webMethods RosettaNet Module, webMethods EDI Module, 
      webMethods Chem eStandards Module, webMethods Installer, and the webMethods logo are trademarks of webMethods, Inc. 
      <br><br>
      "webMethods" is a registered trademark of webMethods, Inc.
      <br><br>
      All other marks are the property of their respective owners.
      <br><br>
	  <font style="font-family: trebuchet ms;">Copyright &copy; 1996 - 2008 Software AG, Darmstadt, Germany and/or Software AG USA, Inc., Reston, VA, United States of America, and/or their suppliers. All rights reserved.</font>
      </td>
      %else%
      <script>writeTD('row');</script>
      Copyright
      <script>writeTD('rowdata-l');swapRows();</script>
       %comment% 
        The adapter is not a webMethods adapter and 
        they didn't provide any copyright information.
       %end%
      </td>
      %endif%
    %else%
    <script>writeTD('row');</script>
    Copyright
    <script>writeTD('rowdata-l');swapRows();</script>
    %value THIRDPARTYCOPYRIGHTURL%
    %endif% 
    </td>
    <tr>
    <script>writeTD('row');</script>
    Description</td>
    <script>writeTD('rowdata-l');swapRows();</script>          
    %value description%</td>
    </tr>
    <tr>
    <script>writeTD('row');</script>
    Adapter Version</td>
    <script>writeTD('rowdata-l');swapRows();</script>          
    %value adapterVersion%
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="%value RELEASENOTEURL%">Release Notes</a></td>
    </tr>
    <tr>
    <script>writeTD('row');</script>Updates</td>
    <script>writeTD('rowdata-l');swapRows();</script>
    %ifvar installedUpdates%
       %loop installedUpdates%
          %value%<br>
       %endloop%
    %else%
       None
    %endif%
    </td>
    </tr>
    <tr>
    <script>writeTD('row');</script>
    JCA Spec Version</td>
    <script>writeTD('rowdata-l');swapRows();</script>          
    %value jcaSpecVersion%</td>
    </tr>
    <tr>
    <script>writeTD('row');</script>
    Vendor Name</td>
    <script>writeTD('rowdata-l');swapRows();</script>          
    %value vendorName%</td>
    </tr>
    %endinvoke%
   </table>    
</body>
</HTML>
