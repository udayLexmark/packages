<html>
  <head>
    <title>WmSAP - Transactions</title>
    <meta http-equiv="Pragma" content="no-cache"></meta>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></meta>
    <meta http-equiv="Expires" content="-1"></meta>
    <link rel="stylesheet" type="text/css" href="../webMethods.css"></link>
    <link rel="stylesheet" type="text/css" href="../package.css"></link>
    <script type="text/javascript" src="../webMethods.js.txt"></script>
  </head>
  <body onLoad="setNavigation('/WmSAP/transactions.dsp?adapterTypeName=WmSAP', '/WmSAP/doc/OnlineHelp/wwhelp/wwhimpl/js/html/wwhelp.htm?context=Help&topic=IS_TS_TID', 'foo');">
    <table width="100%">
      <tr>
	<td class="menusection-Adapters" colspan="2">Adapters &gt; SAP
	  Adapter &gt; Transactions &gt; TID %value $tid%</td>
      </tr>
      <tr>
	<td colspan="2">
	  <ul>
	    <li><a href="transactions.dsp?adapterTypeName=WmSAP&amp;$action=List&amp;$sortKey=%value $sortKey%&amp;$dir=%value $dir%&amp;senderFC=%value senderFC%&amp;receiverFC=%value receiverFC%&amp;msgTypeFC=%value msgTypeFC%&amp;stateFC=%value stateFC%&amp;tidFC=%value tidFC%&amp;startDateFC=%value startDateFC%&amp;endDateFC=%value endDateFC%&amp">Return to Transaction List</a></li>
	  </ul>
	</td>
      </tr>
      <tr>
	<td class="padding">&nbsp;</td>
	<td>
	  <form method="get" action="transactions.dsp">
	    %invoke LXKAdmin.sap.Transaction:getTransaction%
	    <table class="tableView">
	      <tbody id="tbodyNode">
		<!-- %loop auditLog% -->
		<tr>
		  <td class="oddrowdata-l">%value message%</td>
		</tr>
		<!-- %endloop% -->
	      </tbody>
	    </table>
	    %endinvoke%
	    <script>swapColor('tbodyNode', false);</script>
	  </form>
	</td>
      </tr>
    </table>
  </body>
</html>
