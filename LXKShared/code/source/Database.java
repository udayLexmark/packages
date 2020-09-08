

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 02:20:27 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import DBConnection;
import com.wm.util.*;
import java.sql.*;
import com.wm.app.b2b.server.JDBCConnection;
import java.util.Vector;
// --- <<IS-END-IMPORTS>> ---

public final class Database

	extends Service
{
	// ---( internal utility methods )---

	final static Database _instance = new Database();

	static Database _newInstance() { return new Database(); }

	static Database _cast(Object o) { return (Database)o; }

	// ---( server methods )---




	public static final void DBConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(DBConnection)>> ---
		// @sigtype java 3.5
		// [i] field:0:required sqlStatement
		// [i] field:0:required driver
		// [i] field:0:required dataSource
		// [i] field:0:required userid
		// [i] field:0:required password
		// [o] record:1:required resultSet
		// [o] field:0:required rowCount
		String driver     	   = "";
		String dataSource 	   = "";
		String userid      	   = "";
		String password    	   = ""; 
		String query      	   = "";
		String output 	       = "";
		ResultSet rs 	       = null;
		DBConnection dbConnect = null;
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.first("driver");
		driver = (String) cursor.getValue();
		
		cursor.first("dataSource");
		dataSource = (String) cursor.getValue();
		
		cursor.first("userid");
		userid = (String) cursor.getValue();
		
		cursor.first("password");
		password = (String) cursor.getValue();
		
		cursor.first("sqlStatement");
		query = (String) cursor.getValue();
		
		try {
			dbConnect = new DBConnection(driver, dataSource, userid, password);
		
			rs = dbConnect.executeQuery(query);
		
			Values temp    = new Values();
			Values resultSet = new Values();
			Values results[] = null;
		
			JDBCConnection.toValues(rs, temp);	
			results = temp.getValuesArray("results");
			resultSet.put("results", results);
		
			cursor.insertAfter("rowCount", temp.getString("rowCount"));
			cursor.insertAfter("resultSet",results);
		
			dbConnect.closeConnection();
		}
		catch (Exception e) {
			Debug.log(0, "Exception = " + e.toString());
		}
		// --- <<IS-END>> ---

                
	}



	public static final void closeDBConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeDBConnection)>> ---
		// @sigtype java 3.5
		// [i] object:0:required dbConnection
		// [o] field:0:optional errors
		DBConnection dbConnect = null;
		String 		 errorList = "";
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("dbConnection")) {
			dbConnect = (DBConnection) cursor.getValue();
		
			try {
				dbConnect.closeConnection();
			}
			catch (Exception e) {
				Debug.log(0, "Error closing DB connection: Exception = " + e.toString());
				errorList = errorList + "Error closing DB connection: Exception = " + e.toString();
				if (errorList != "") {
					cursor.insertAfter("errors", errorList);
					Debug.log(0, "errorList = " + errorList);
				}
			}
		
			cursor.delete();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void getSIDFromURL (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSIDFromURL)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dbURL
		// [o] field:0:required SID
		IDataCursor cursor = pipeline.getCursor();
		String dbURL = "";
		String SID   = "";
		
		
		if (cursor.last("dbURL")) {
			dbURL = (String) cursor.getValue();
		}
		
		int lastColon = dbURL.lastIndexOf(":");
		
		SID = dbURL.substring(lastColon+1);
		
		cursor.insertAfter("SID", SID);
		// --- <<IS-END>> ---

                
	}



	public static final void openDBConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(openDBConnection)>> ---
		// @sigtype java 3.5
		// [i] field:0:required driver
		// [i] field:0:required dataSource
		// [i] field:0:required userID
		// [i] field:0:required password
		// [o] object:0:required dbConnection
		// [o] field:0:optional errors
		DBConnection dbConnect = null;
		String driver    = "";
		String dataSrc   = "";
		String uid	     = "";
		String pw        = "";
		String errorList = "";
		
		IDataCursor cursor = pipeline.getCursor();
		
		try {
			// DRIVER
			if (cursor.last("driver")) {
				driver = (String) cursor.getValue();
			}
			else {
				Exception ex = new Exception("Input parameter 'driver' not found");
				errorList = errorList + ex.toString() + "\n";
				throw (ex);
			}
		
			// DATASOURCE
			if (cursor.last("dataSource")) {
				dataSrc = (String) cursor.getValue();
			}
			else {
				Exception ex = new Exception("Input parameter 'dataSource' not found");
				errorList = errorList + ex.toString() + "\n";
				throw (ex);
			}
		
			// USERID
			if (cursor.last("userID")) {
				uid = (String) cursor.getValue();
			}
			else {
				Exception ex = new Exception("Input parameter 'userID' not found");
				errorList = errorList + ex.toString() + "\n";
				throw (ex);
			}
		
			// PASSWORD
			if (cursor.last("password")) {
				pw = (String) cursor.getValue();
			}
			else {
				Exception ex = new Exception("Input parameter 'password' not found");
				errorList = errorList + ex.toString() + "\n";
				throw (ex);
			}
		}
		catch (Exception e) {
			Debug.log(0, "Error getting DB Connection parameters: " + e.toString());
			errorList = errorList + "Error getting DB Connection parameters: " + e.toString() + "\n";
			try {
				cursor.insertAfter("errors", errorList);
			}
			catch (Exception ea) {
				Debug.log(0, "Error writing DB Connection (" + dataSrc + ") to pipeline: Exception = " + ea.toString());
			}
			return;
		}
		
		
		try {
			dbConnect = new DBConnection(driver, dataSrc, uid, pw);
			if (dbConnect == null) {
				Debug.log(0, "it was null");
			}
		}
		catch (Exception e) {
			Debug.log(0, "Error opening DB Connection: Exception = " + e.toString());
			errorList = errorList + "Error opening DB Connection: Exception =  " + e.toString() + "\n";
		}
		
		try {
			cursor.insertAfter("dbConnection", dbConnect);
			if (errorList != "") {
				cursor.insertAfter("errors", errorList);
				Debug.log(0, "errorList = " + errorList);
			}
		}
		catch (Exception e) {
			Debug.log(0, "Error writing DB Connection (" + dataSrc + ") to pipeline: Exception = " + e.toString());
		}
		// --- <<IS-END>> ---

                
	}



	public static final void queryDBConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(queryDBConnection)>> ---
		// @sigtype java 3.5
		// [i] field:0:required sqlStatement
		// [i] object:0:required dbConnection
		// [o] record:1:required resultSet
		// [o] field:0:required rowCount
		// [o] field:0:optional errors
		DBConnection dbConnect  = null;
		ResultSet rs 			= null;
		String output 			= "";
		String query   			= "";
		String errorList		= "";
		
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.first("sqlStatement");
		query = (String) cursor.getValue();
		
		if (cursor.first("dbConnection")) {
			dbConnect = (DBConnection) cursor.getValue();
		}
		else {
			Exception ex = new Exception("Input parameter DBConnection not found.");
			errorList = errorList + ex.toString() + "\n";
		}
		
		try {
			rs = dbConnect.executeQuery(query);
		
			Values temp    = new Values();
			Values resultSet = new Values();
			Values results[] = null;
		
			JDBCConnection.toValues(rs, temp);	
			results = temp.getValuesArray("results");
			resultSet.put("results", results);
		
			cursor.insertAfter("rowCount", temp.getString("rowCount"));
			cursor.insertAfter("resultSet",results);
		}
		catch (Exception e) {
			Debug.log(0, "Exception = " + e.toString());
			Debug.log(0, "Query = " + query);
			errorList = errorList + e.toString() + "\n";
		}
		
		if (errorList != "") {
			cursor.insertAfter("errors", errorList);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void queryDBConnectionAS400 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(queryDBConnectionAS400)>> ---
		// @sigtype java 3.5
		// [i] field:0:required sqlStatement
		// [i] object:0:required dbConnection
		// [o] record:1:required resultSet
		// [o] field:0:required rowCount
		// [o] field:0:optional errors
		DBConnection dbConnect  = null;
		ResultSet rs 			= null;
		String output 			= "";
		String query   			= "";
		String errorList		= "";
		
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.first("sqlStatement");
		query = (String) cursor.getValue();
		
		if (cursor.first("dbConnection")) {
			dbConnect = (DBConnection) cursor.getValue();
		}
		else {
			Exception ex = new Exception("Input parameter DBConnection not found.");
			errorList = errorList + ex.toString() + "\n";
		} 
		
		try {
			rs = dbConnect.executeQuery(query);
		
		    //  Read Query Results Into a Vector  //
		   	byte[] tempColValue = null;
			ResultSetMetaData theMetaData  = rs.getMetaData( );       // Holds Result info.
		    int	columnCount  	= theMetaData.getColumnCount();  // # of Columns in result.
		   	String colValue 	= "";
			String colType		= "";
			String colName		= "";
			Vector tempVector 	= new Vector();
		
			while (rs.next()) {
				Values resultsRow = new Values();
				for (int i=1; i<=columnCount; i++) {
		            colType = theMetaData.getColumnTypeName(i);
		            colName = theMetaData.getColumnName(i);
		            if (colType.compareTo("CHAR() FOR BIT DATA") == 0) {
		       	       	tempColValue = rs.getBytes(i);
		                com.ibm.as400.access.CharConverter conv = new com.ibm.as400.access.CharConverter();
		                colValue = conv.byteArrayToString(tempColValue);
		            }
					else {
						colValue = rs.getString(i);
					}
					resultsRow.put(colName, colValue);
			    }
				tempVector.addElement(resultsRow);
			}
		
			Values results[] 	= new Values[tempVector.size()];
			for (int x=0; x<tempVector.size(); x++) {
				results[x] = (Values) tempVector.elementAt(x);	
			}
		
		
			// Convert ResultSet to Values
			Values temp    = new Values();
			Values resultSet = new Values();
		
			resultSet.put("results", results);
		
			cursor.insertAfter("rowCount", temp.getString("rowCount"));
			cursor.insertAfter("resultSet",results);
		}
		catch (Exception e) {
			Debug.log(0, "Exception = " + e.toString());
			Debug.log(0, "Query = " + query);
			errorList = errorList + e.toString() + "\n";
		}
		
		if (errorList != "") {
			cursor.insertAfter("errors", errorList);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void updateDBConnection (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(updateDBConnection)>> ---
		// @sigtype java 3.5
		// [i] field:0:required sqlStatement
		// [i] object:0:required dbConnection
		// [o] field:0:required rowsUpdated
		// [o] field:0:optional errors
		DBConnection dbConnect  = null;
		int	   rows				= 0;
		String output 			= "";
		String query   			= "";
		String errorList		= "";
		
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.first("sqlStatement");
		query = (String) cursor.getValue();
		
		if (cursor.first("dbConnection")) {
			dbConnect = (DBConnection) cursor.getValue();
		}
		else {
			Exception ex = new Exception("Input parameter DBConnection not found.");
			errorList = errorList + ex.toString() + "\n";
		}
		
		try {
			dbConnect.setAutoCommit(true); 
			rows = dbConnect.executeUpdate(query);
			cursor.insertAfter("rowsUpdated", Integer.toString(rows));
		}
		catch (Exception e) {
			Debug.log(0, "Exception = " + e.toString());
			Debug.log(0, "Query = " + query);
			errorList = errorList + e.toString() + "\n";
		}
		
		if (errorList != "") {
			cursor.insertAfter("errors", errorList);
		}
		// --- <<IS-END>> ---

                
	}
}

