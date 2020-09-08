package AS400Connectivity;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 01:55:07 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import ASDBConnectionManager;
import com.wm.util.*;
import com.wm.app.b2b.server.*;
import java.sql.*;
// --- <<IS-END-IMPORTS>> ---

public final class ConnectionPool

	extends Service
{
	// ---( internal utility methods )---

	final static ConnectionPool _instance = new ConnectionPool();

	static ConnectionPool _newInstance() { return new ConnectionPool(); }

	static ConnectionPool _cast(Object o) { return (ConnectionPool)o; }

	// ---( server methods )---



    public static final Values dbConnectionPoolJDE (Values in)
    {
        Values out = in;
		// --- <<IS-START(dbConnectionPoolJDE)>> ---
		// @sigtype java 3.0
		// [i] field:0:required sqlStatement
		// [i] field:0:optional returnType {&quot;Values&quot;,&quot;ResultSet&quot;}
		// [o] record:1:required resultSet
		// [o] record:0:required error
		// [o] - field:0:required message
		// [o] - field:0:required msgType
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
		Debug.log(0, "got here 1");
			Connection connection 		= null;
		Debug.log(0, "got here 2");
		    ASDBConnectionManager poolManager 	= null;
		Debug.log(0, "got here 3");
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
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void reload (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(reload)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional propertiesFile
		// [o] field:0:required status
		/****************************************************************************
		Service 	reload()
		
		Input:  	
		Returns:	
		Comments:	Uses DBConnectionManager.
		
		Date:                      	Description of the change.
		12/16/02	Tony Foltz		Creation.
		****************************************************************************/ 
		 
		Connection 			connection	 = null;
		ASDBConnectionManager poolManager  = null;
		String 				action  	 = null;
		String				propertiesFile = null;
		
		IDataCursor cursor = pipeline.getCursor();
		if (cursor.first("propertiesFile")) {
			propertiesFile = (String) cursor.getValue();
		}
		
		try	{
			action = "getting poolManager";
			poolManager = ASDBConnectionManager.getInstance();
		
			if (poolManager == null) {
				Debug.log(0, "getConnection: Error = PoolManager was null: " + poolManager );
			}
			else {
				action = "reloading the poolManager";
				if ((propertiesFile != null) && (propertiesFile != "")) {
					poolManager.reload(propertiesFile);
				}
				else {
					poolManager.reload();
				} 
			}
			cursor.insertAfter("status", "Successful");
		}
		catch (Exception e) {
			Debug.log(0, "returnConnection: Error = " + e.toString() + ";" + action);
			try	{
				Values error = new Values();
		       	error.put("msgType", "error");
				error.put("message", "Exception within returnConnection, while "+action+". " + e.toString());     
				cursor.insertAfter("error", error);
			}
			catch (Exception x)	{
			}
		}
		// --- <<IS-END>> ---

                
	}
}

