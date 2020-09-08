

// -----( B2B Java Code Template v1.2
// -----( CREATED: Mon Sep 23 16:32:09 EDT 2002
// -----( ON-HOST: b2bdev

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<B2B-START-IMPORTS>> ---
import com.ibm.as400.access.*;
import com.wm.util.*;
import com.wm.app.b2b.server.*;
import java.sql.*;
// --- <<B2B-END-IMPORTS>> ---

public final class AS400Connectivity

	extends Service{
	// ---( internal utility methods )---

	final static AS400Connectivity _instance = new AS400Connectivity();

	static AS400Connectivity _newInstance() { return new AS400Connectivity(); }

	static AS400Connectivity _cast(Object o) { return (AS400Connectivity)o; }

	// ---( server methods )---




	public static final void callAS400Program (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(callAS400Program)>> ---
		// @sigtype java 3.5
		// [i] field:0:required host
		// [i] field:0:required id
		// [i] field:0:required password
		// [i] field:0:required program
		String host    = "";
		String id      = "";
		String pw 	   = "";
		String program = "";
		
		IDataCursor cursor = pipeline.getCursor();
		IData programParams[] = null;
		IDataCursor progParmsCursor = null;
		String    data 		  = null;
		String    sizeStr 	  = null;
		int       size 		  = 0;
		RPGParameter[] rpgParameters = null;
		AS400 as400 = null;
		As400RPGCall call	  = null; 
		RPGParameter returnRPGParameters[] = null; 
		
		
		if (cursor.last("host")) {
			host = (String) cursor.getValue();
		}
		if (cursor.last("id")) {
			id = (String) cursor.getValue();
		} 
		if (cursor.last("password")) {
			pw = (String) cursor.getValue();
		} 
		if (cursor.last("program")) {
			program = (String) cursor.getValue();
		}
		
		if (cursor.last("ProgramParameters")) {
			programParams = (IData[]) cursor.getValue();
		}
		
		if (programParams != null) {
			rpgParameters = new RPGParameter[programParams.length];
		
			for (int i=0; i<programParams.length; i++) {
				data = null;
				size = 0;
		
			 	progParmsCursor = programParams[i].getCursor(); 
				progParmsCursor.last("data");
				data = (String) progParmsCursor.getValue();
				progParmsCursor.last("returnedDataSize");
				sizeStr = (String) progParmsCursor.getValue();
				if (!(sizeStr.equals("")) && (sizeStr != null)) {
					size = Integer.parseInt(sizeStr);
				}
				rpgParameters[i] = new RPGParameter(data, size);
			}
		}
		
		
		as400 = new AS400(host, id, pw);
		call = new As400RPGCall(as400);
		
		//rpgParameters = null;
		try {
				if (rpgParameters == null) {
			        call.callRPGProgram(program);
				}
				else {
		        	returnRPGParameters = call.callRPGProgram(program, rpgParameters);
				}
		}
		catch (Exception e) {
		        Debug.log(0, "Error calling RPG program: " + e.toString());
		}
		 
		
		try {  // REMOVE
		
		
		IData returnProgramParams[] = null;
		
		if (returnRPGParameters != null) {
			returnProgramParams = new IData[returnRPGParameters.length];
			for (int i=0; i<returnRPGParameters.length; i++) {
				data = null;
				size = 0;
		
				data = returnRPGParameters[i].data.trim();
				size = returnRPGParameters[i].numberReturnBytes;
		Debug.log(0, data);
		
				// Create a new webMethods RPGProgramParameter record.
				Values wmRPGProgramParameter = new Values();
				wmRPGProgramParameter.put("data", data);
				wmRPGProgramParameter.put("returnedDataSize", size); 
		
				returnProgramParams[i] = wmRPGProgramParameter;	
			}
		}
		cursor.last();
		cursor.insertAfter("OutputProgramParameters", returnProgramParams);
		
		} catch (Exception e) { System.out.println ("Error = " + e.toString()); }
		
		// --- <<B2B-END>> ---

                
	}



	public static final void callRPG (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(callRPG)>> ---
		// @sigtype java 3.5
		// [i] object:0:required As400RPGCallerConnection
		// [i] field:0:required program
		// [o] field:0:required callRPGException
		String program = "";
		com.ibm.as400.access.Trace.setTraceOn(true);
		com.ibm.as400.access.Trace.setTraceDiagnosticOn(true);
		com.ibm.as400.access.Trace.setTraceInformationOn(true);
		com.ibm.as400.access.Trace.setTraceWarningOn(true);
		com.ibm.as400.access.Trace.setTraceErrorOn(true);
		com.ibm.as400.access.Trace.setTraceDatastreamOn(true);
		IDataCursor cursor = pipeline.getCursor();
		IData programParams[] = null;
		IDataCursor progParmsCursor = null;
		String    data 		  = null;
		String    sizeStr 	  = null;
		String    outException = "";
		int       size 		  = 0;
		RPGParameter[] rpgParameters = null;
		As400RPGCaller caller = null; 
		RPGParameter returnRPGParameters[] = null; 
		try {
		Values outFilePath = doInvoke("Server","getServerRoot",null);
		String serverRoot  = (String)outFilePath.get("serverRoot");
		//Debug.log(0,serverRoot);
		com.ibm.as400.access.Trace.setFileName(serverRoot+"/logs/as400.log");
		}
		catch (Exception e) {
		Debug.log(0, e.toString());
		}
		
		// RETRIEVE INPUT PARAMETERS
		if (cursor.last("As400RPGCallerConnection")) {
			caller = (As400RPGCaller) cursor.getValue();
		}
		else {
			outException = outException +"\n" +  "Error calling RPG: missing input: 'As400RPGCallerConnection'.";
		}
		
		if (cursor.last("program")) {
			program = (String) cursor.getValue();
		}
		else {
			outException = outException +"\n" +  "Error calling RPG: missing input: 'program'.";
		}
		
		if (cursor.last("ProgramParameters")) {
			programParams = (IData[]) cursor.getValue();
		}
		
		
		// Convert the input parameters IData to RPGParameters
		if (programParams != null) {
			rpgParameters = new RPGParameter[programParams.length];
		
			for (int i=0; i<programParams.length; i++) {
				data = null;
				size = 0;
		
			 	progParmsCursor = programParams[i].getCursor(); 
				if (progParmsCursor.last("data")) {
					data = (String) progParmsCursor.getValue();
				}
				else {
					data = "";
				}
		
				if (progParmsCursor.last("returnedDataSize")) {
					sizeStr = (String) progParmsCursor.getValue();
				}
				else {
					sizeStr = "";
				}
		
				if (sizeStr != null) {
					if (!sizeStr.equals("")) {
						size = Integer.parseInt(sizeStr);
					}
				}
		
				rpgParameters[i] = new RPGParameter(data, size);
			}
		}
		
		
		// CALL RPG PROGRAM
		try {
				if (rpgParameters == null) {
			        caller.callRPGProgram(program);
				}
				else {
		        	returnRPGParameters = caller.callRPGProgram(program, rpgParameters);
				}
		}
		catch (Exception e) {
				outException = outException +"\n" + "Error calling RPG prgram: " + e.toString();
		        Debug.log(0, outException);
		}
		 
		
		// Convert the return params to an IData
		IData returnProgramParams[] = null;
		if (returnRPGParameters != null) {
			returnProgramParams = new IData[returnRPGParameters.length];
			for (int i=0; i<returnRPGParameters.length; i++) {
				data = null;
				size = 0;
		
				data = returnRPGParameters[i].data.trim();
				size = returnRPGParameters[i].numberReturnBytes;
		//Debug.log(0, data);
		
				// Create a new webMethods RPGProgramParameter record.
				Values wmRPGProgramParameter = new Values();
				wmRPGProgramParameter.put("data", data);
				wmRPGProgramParameter.put("returnedDataSize", size); 
		
				returnProgramParams[i] = wmRPGProgramParameter;	
			}
		}
		
		// RETURN THE OUTPUT PARAMETERS
		cursor.last();
		cursor.insertAfter("OutputProgramParameters", returnProgramParams);
		
		// RETURN ANY EXCEPTIONS
		if (!outException.equals("")) {
			cursor.last();
			cursor.insertAfter("callRPGException", outException);
		}
		// --- <<B2B-END>> ---

                
	}



	public static final void closeRPGCallerConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(closeRPGCallerConnection)>> ---
		// @sigtype java 3.5
		// [i] object:0:required As400RPGCallerConnection
		// [o] field:0:required closeRPGCallerConnectionException
		String program = "";
		
		IDataCursor cursor = pipeline.getCursor();
		IData programParams[] = null;
		IDataCursor progParmsCursor = null;
		String    data 		  = null;
		String    sizeStr 	  = null;
		String    outException = "";
		int       size 		  = 0;
		RPGParameter[] rpgParameters = null;
		As400RPGCaller caller = null; 
		RPGParameter returnRPGParameters[] = null; 
		
		// RETRIEVE INPUT PARAMETERS
		if (cursor.last("As400RPGCallerConnection")) {
			caller = (As400RPGCaller) cursor.getValue();
		}
		else {
			outException = outException +"\n" +  "Error calling RPG: missing input: 'As400RPGCallerConnection'.";
		}
		
		// CLOSE CONNECTION
		caller.disconnect();
		
		
		// RETURN ANY EXCEPTIONS
		if (!outException.equals("")) {
			cursor.last();
			cursor.insertAfter("closeRPGCallerConnectionException", outException);
		}
		// --- <<B2B-END>> ---

                
	}


    public static final Values dbConnectionPoolJDE (Values in)
    {
        Values out = in;
		// --- <<B2B-START(dbConnectionPoolJDE)>> ---
		// @sigtype java 3.0
		// [i] field:0:required sqlStatement
		// [i] field:0:optional returnType {"Values","ResultSet"}
		// [o] record:1:required resultSet
		/****************************************************************************
		Service 	dbConnectJDE()
		
		Input:  	sqlStatement	= SQL String for Insert, Update, and Insert
		
		Returns:	resultSet	 	= A Values object containing the resultset 
		
		Comments:	Uses DBConnectionManager and DBConnectionPool classes in B2B31/Lib/Classes.
		
		Date:                      	Description of the change.
		06/12/00   	Tom Coons       Initial creation
					Tony Foltz
		10/06/00	Tony Foltz		Add support for ResultSet return type.
		13/11/00    Samuel Bordat   Authorize the command Delete
		****************************************************************************/ 
		
			Connection connection 		= null;
		    ASDBConnectionManager poolManager 	= null;
		    String sqlStatement 		= in.getString("sqlStatement");
			String returnType 			= in.getString("returnType"); 
			String tempSQL	 			= "";
			Values resultSet 			= null;
			String action  	 			= null;
			ResultSet rs	 			= null;
			String sqlType   			= "SELECT";
			long connectionWaitLimit 	= 25000;   // In milliseconds.
			int changeRowCount			= 0;
			boolean socketError 		= false;
		
			if (returnType == null) {
				returnType = "VALUES";
			}
		//Debug.log(0, "SQL= " + sqlStatement);
		
					tempSQL = sqlStatement.trim().toUpperCase();
		
					if (tempSQL.startsWith("INSERT")) {
		//Debug.log(0, "INSERT =" + sqlStatement);
						sqlType = "INSERT";
					}
					else if (tempSQL.startsWith("UPDATE")){
		//Debug.log(0, "UPDATE");
						sqlType = "UPDATE";	  	
					}
					else if(tempSQL.startsWith("DELETE")){
						  sqlType = "DELETE";
		  		    }
		
		    try	{
					action = "registering driver";
		            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
		
					action = "getting poolManager";
		            poolManager = ASDBConnectionManager.getInstance();
		
					action = "getting a connection";
		            connection = poolManager.getConnection(connectionWaitLimit);
		
					action = "creating a Statement";
		            Statement statement = connection.createStatement();
		
					action = "executing the query";
					action = action + ": " + sqlStatement;
		
					connection.setAutoCommit(false);			
					if ((sqlType.equals("UPDATE")) || (sqlType.equals("INSERT"))|| (sqlType.equals("DELETE")) ){
						action = "executing UPDATE";
			   			changeRowCount = statement.executeUpdate(sqlStatement);
						out.put("changeRowCount", changeRowCount);
			
						connection.commit();
					}
					else {
			            rs = statement.executeQuery(sqlStatement);
						resultSet = new Values();				
		
						if (returnType.toUpperCase().equals("RESULTSET")) {
							resultSet.put(rs);
							resultSet.put(action);
							out.put("resultSet", resultSet);
						}
						else {
							Values results[] = null;
							action = "converting ResultSet to Values object";
							JDBCConnection.toValues(rs, out);	
							results = out.getValuesArray("results");
							resultSet.put("results", results);
							out.put("resultSet", results);
							out.remove("results");
						}
		
					}
		    }
		    catch (Exception e) {
				Debug.log(0, "Error = " + e.toString());
				Debug.log(0, "sqlStatement = " + sqlStatement);	
				try	{
					connection.rollback();
					Values error = new Values();
		        	error.put("msgType", "error");
					error.put("message", "Exception within dbConnect.Exception, while "+action+". " + e.toString());     
					out.put("error", error);
					out = doInvoke("util.Logging", "logMessageLXKJDE", error); 
				}
				catch (Exception x)	{
				}
				// Close the connection if the "No more data to read from socket" SQLException is encountered.
				String mesg = e.getMessage().trim();
				Debug.log(0, "mesg = " + mesg);
				if ((mesg.equals("No more data to read from socket")) 
					|| (mesg.equals("Io exception: No more data to read from socket"))
					|| (mesg.equals("Io exception: There is no process to read data written to a pipe."))) {
					Debug.log(0, "Invalid connection . . . closing.");
					try {
						connection.close();
					}
					catch (Exception a) {
						Debug.log(0, "Error closing connection: " + a.toString());
					}
					socketError = true;								
				}
		
		    }
			finally {
				if (poolManager != null) {
					action = "releasing the poolManager";
					poolManager.release();
					poolManager.freeConnection(connection);
					
				}
		
				if (socketError) {
					try {
						out.put("sqlStatement", sqlStatement);
						out.put("returnType", returnType);
						doInvoke("DB", "dbConnect", out); 
					}
					catch (Exception e) {
						Debug.log(0, "Error re-calling dbConnect.");			
					}
				}
			}
		// --- <<B2B-END>> ---
        return out;
                
	}



	public static final void openRPGCallerConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<B2B-START(openRPGCallerConnection)>> ---
		// @sigtype java 3.5
		// [i] field:0:required host
		// [i] field:0:required id
		// [i] field:0:required password
		// [o] object:0:required As400RPGCallerConnection
		// [o] field:0:required openRPGCallerConnectionException
		String host    = "";
		String id      = "";
		String pw 	   = "";
		String program = "";
		
		IDataCursor cursor = pipeline.getCursor();
		String    data 		  = null;
		String    sizeStr 	  = null;
		String    outException = "";
		int       size 		  = 0;
		As400RPGCaller caller	  = null; 
		
		
		// RETRIEVE INPUT PARAMETERS
		if (cursor.last("host")) {
			host = (String) cursor.getValue();
		}
		if (cursor.last("id")) { 
			id = (String) cursor.getValue();
		} 
		if (cursor.last("password")) {
			pw = (String) cursor.getValue();
		} 
		
		// CREATE THE AS400RPGCALLER 
		try {
			caller = new As400RPGCaller(host, id, pw); 
		}
		catch (Exception creationException) {
			outException = outException + "Exception instantiating an As400RPGCaller(): " + creationException.toString();
			Debug.log(0, outException );	
		}
		
		// RETURN THE CONNECTION
		cursor.last();
		cursor.insertAfter("As400RPGCallerConnection", caller);
		
		// RETURN ANY EXCEPTIONS
		if (!outException.equals("")) {
			cursor.last();
			cursor.insertAfter("openRPGCallerConnectionException", outException);
		}
		// --- <<B2B-END>> ---

                
	}
}

