<html>
	<head></head>
	<title style="color:blue">Reprocess failed webMethods services</title>
	<body>
		<br></br>
		<form name = "ReprocessFailedSrvc" action = "../../invoke/LXKWMAMSupport.ReprocessServices:ReprocessFailedServices" method = "post">
			<table bgcolor="#DBDBDB" width="60%" cellspacing="2" cellpadding="2" align="center" valign="top">
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><b>Service Name</b></td>
					<td>
						<input type = "text" name = "ReprocessServiceName" value="" size="100">
					</td>
				</tr>
				<tr>
					<td><b>Range</b></td>
					<td>
						<select name="ReprocessDateRange">
							<option value="Today">Today</option>
							<option value="Yesterday">Yesterday</option>
							<option value="In the last 7 days">In the last 7 days</option>
							<option value="Last week">Last week</option>
							<option value="This week">This week</option>
							<option value="Last month">Last month</option>
							<option value="This month">This month</option>
							<option value="Year to date">Year to date</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><b>Delay (in Sec)</b></td>
					<td>
						<select name="ReprocessDelay">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="10">10</option>
						</select>
					</td>
				</tr>
				<tr><td></td></tr>
				<td colspan=2 align="center">
					<input type = "Submit" Value="Submit">
				</td>
			</table>
		</form>
	</body>
</html>
