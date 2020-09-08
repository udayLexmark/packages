package Database;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 02:14:36 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.sql.*;
import com.wm.util.*;
import com.wm.app.b2b.server.*;
import SYBDBConnectionManager;
// --- <<IS-END-IMPORTS>> ---

public final class ConnectionPool

	extends Service
{
	// ---( internal utility methods )---

	final static ConnectionPool _instance = new ConnectionPool();

	static ConnectionPool _newInstance() { return new ConnectionPool(); }

	static ConnectionPool _cast(Object o) { return (ConnectionPool)o; }

	// ---( server methods )---



    public static final Values dbExecuteGenericSQL (Values in)
    {
        Values out = in;
		// --- <<IS-START(dbExecuteGenericSQL)>> ---
		// @sigtype java 3.0
		// [i] field:0:required sqlStatement
		// [o] record:1:optional resultSet
		// [o] - record:0:required resultSet
		// [o] -- record:1:required resultSet
		// [o] field:0:optional rowCount
		// [o] field:0:optional errors
		/****************************************************************************
		Service 	dbConnect()
		
		Input:  	sqlStatement	= SQL String for Insert, Update, and Insert
		
		Returns:	resultSet	 	= A Values object containing the resultset 
		
		Comments:	Uses DBConnectionManager and DBConnectionPool classes in B2B__/lib/classes.
		
		Date:                      	Description of the change.
		06/12/00   	Tom Coons       Initial creation
					Tony Foltz
		****************************************************************************/ 
		
			Connection connection = null;
		    
		SYBDBConnectionManager poolManager = null;
		//DBConnectionManager poolManager = null;
			Statement statement = null;
		    String sqlStatement = in.getString("sqlStatement");
			String tempSQL	 = "";
			Values resultSet = null;
			String action  	 = null;
			ResultSet rs	 = null;
			String sqlType   = "SELECT";
			int					rowsUpdated	 = 0;
			long 				connectionWaitLimit = 25000;   // In milliseconds.
			boolean				resultSetReturned  = false;   
			int tries = 0;
			int maxTries = 5;
			boolean success = false;
			Vector				resultsArrayVector = new Vector();
		    try	{
					tempSQL = sqlStatement.trim().toUpperCase();
			
					if (tempSQL.startsWith("INSERT")) {
						sqlType = "INSERT";
					}
					else if (tempSQL.startsWith("UPDATE")){
						sqlType = "UPDATE";
					}
					else if (tempSQL.startsWith("DELETE")){
						sqlType = "UPDATE";
					}
		
		
					//action = "registering driver";
		           // Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		
					action = "getting poolManager";
		            poolManager = SYBDBConnectionManager.getInstance();
		
					if (poolManager == null) {
						Debug.log(0, "Error = Pool Manager" + poolManager );
					}
		
					action = "getting a connection";
			        connection = poolManager.getConnection(connectionWaitLimit);
					//connection.setAutoCommit(false);
		
					// Attempt up to maxTries connections
			
			while ((!success) && (tries < maxTries)) {
						tries++;
		
						try {
							action = "creating a Statement";
							statement = connection.createStatement();
						}
						catch (Exception sqlException) {
								if (tries != maxTries) {
									Debug.log(0, "Possible network error, attempt (" +tries+" of "+ (maxTries-1) +") to replace the connection (statement)." 
										+ "\n Exception=" + sqlException.toString());
									action = "replacing the connection (statement)";
									try {
										tries++;
										//connection = poolManager.replaceConnection(connection);
										action = "creating a Statement";
										statement = connection.createStatement();
									} catch (Exception replaceException) {
									Debug.log(0, "bogus");
									}
					
								}
								else {
									throw(sqlException);
								}
						}
		
					action = "executing the query";
					action = action + ": " + sqlStatement;
		}
					if (connection.getAutoCommit() == true) {
						connection.setAutoCommit(false);			
					}
			
		       		resultSetReturned = statement.execute( sqlStatement );
					rowsUpdated = statement.getUpdateCount();
					while ((resultSetReturned) || (rowsUpdated != -1)) {
				        if (resultSetReturned) {
		    	   	        rs = statement.getResultSet();
							action = "converting ResultSet to Values object";
							JDBCConnection.toValues(rs, out);	
							Values[] resultValuesArray = out.getValuesArray("results");
							resultsArrayVector.add(resultValuesArray);
		        	   	}
						else if (rowsUpdated >=0) {
							out.put("rowCount", rowsUpdated);
		        	   	} 
						resultSetReturned = statement.getMoreResults();
						rowsUpdated = statement.getUpdateCount();
					}
		
					// Convert resultsArrayVector into Values[]
					resultsArrayVector.trimToSize();
					Values[] outputResultsArray = new Values[resultsArrayVector.size()];
					// Loop through each resultSet returned
					for (int i=0; i<resultsArrayVector.size(); i++) {
						Values tempValues = new Values();
						Values tempArray[] = (Values[]) resultsArrayVector.elementAt(i);
						// Add individual resultSets to a Values object
						for (int j=0; j<tempArray.length; j++) {
							tempValues.put("resultSet", tempArray);
						}
						// Add the Values object to the resultSet[]
						outputResultsArray[i] = tempValues;
					}
		
					if (outputResultsArray.length > 0) {
						out.put("resultSet", outputResultsArray);
					}
		
					// Pipeline Cleanup
					IDataCursor cursor = out.getCursor();
					if (cursor.last("results")) {
						cursor.delete();
					}
					if (cursor.last("$rowCount")) {
						cursor.delete();
					}
		
		
					connection.commit();
		
		     
			}    
		catch (Exception e) {
				Debug.log(0, "dbExecuteSQL Error = " + e.toString() + ";" + action);
				try	{
					connection.rollback();
					Values error = new Values();
		        	error.put("msgType", "error");
					error.put("message", "Exception within dbConnect.Exception, while "+action+". " + e.toString());     
					out.put("errors", error);
					out = doInvoke("util.Logging", "logMessage", error); 
				}
				catch (Exception x)	{}
		}
		   finally {
				if (poolManager != null) {
					action = "releasing the poolManager";
					poolManager.release();
					poolManager.freeConnection(connection);
				
			}
		}
		// --- <<IS-END>> ---
        return out;
                
	}
}

