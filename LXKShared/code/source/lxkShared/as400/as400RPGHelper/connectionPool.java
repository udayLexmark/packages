package lxkShared.as400.as400RPGHelper;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-04-01 10:09:23 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.ibm.as400.rpg.util.AS400RPGHelper;
// --- <<IS-END-IMPORTS>> ---

public final class connectionPool

{
	// ---( internal utility methods )---

	final static connectionPool _instance = new connectionPool();

	static connectionPool _newInstance() { return new connectionPool(); }

	static connectionPool _cast(Object o) { return (connectionPool)o; }

	// ---( server methods )---




	public static final void getConnectionPoolProperties (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getConnectionPoolProperties)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required cleanupInterval
		// [o] field:0:required maxConnections
		// [o] field:0:required maxInactivity
		// [o] field:0:required maxLifetime
		// [o] field:0:required maxUseCount
		// [o] field:0:required maxUseTime
		// [o] field:0:required threadUsed
		// [o] field:0:required runMaintenance
		// [o] field:1:required activeConnections
	IDataCursor pipelineCursor = pipeline.getCursor();
	IDataUtil.put( pipelineCursor, "cleanupInterval", String.valueOf(AS400RPGHelper.getPoolCleanupInterval()) );
	IDataUtil.put( pipelineCursor, "maxConnections", String.valueOf(AS400RPGHelper.getPoolMaxConnections()) );
	IDataUtil.put( pipelineCursor, "maxInactivity", String.valueOf(AS400RPGHelper.getPoolMaxInactivity()) );
	IDataUtil.put( pipelineCursor, "maxLifetime", String.valueOf(AS400RPGHelper.getPoolMaxLifetime()) );
	IDataUtil.put( pipelineCursor, "maxUseCount", String.valueOf(AS400RPGHelper.getPoolMaxUseCount()) );
	IDataUtil.put( pipelineCursor, "maxUseTime", String.valueOf(AS400RPGHelper.getPoolMaxUseTime()) );
	IDataUtil.put( pipelineCursor, "threadUsed", String.valueOf(AS400RPGHelper.getPoolThreadUsed()) );
	IDataUtil.put( pipelineCursor, "runMaintenance", String.valueOf(AS400RPGHelper.getPoolRunMaintenance()) );
	
	String[] connections = AS400RPGHelper.getActiveConnectionCount();
	if (connections != null && connections.length > 0) {
		IDataUtil.put( pipelineCursor, "activeConnections", connections );
    }
	pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void resetConnections (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(resetConnections)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required connectionIdentifiers
		// [i] - field:0:required systemName
		// [i] - field:0:required userId
	// get a cursor to the pipeline
	IDataCursor pipelineCursor = pipeline.getCursor();

	// retrieve connectionIdentifiers from the pipeline
	IData[]	connectionIdentifiers = IDataUtil.getIDataArray( pipelineCursor, "connectionIdentifiers" );

	// check to see if we received identifiers
	if ( connectionIdentifiers != null && connectionIdentifiers.length > 0)
	{
		String systemName = null;
		String userId = null;
		// we have values, let's reset the connections for each pair
		for ( int i = 0; i < connectionIdentifiers.length; i++ )
		{
			// get the values from the current document in the list
			IDataCursor connectionIdentifiersCursor = connectionIdentifiers[i].getCursor();
			systemName = IDataUtil.getString( connectionIdentifiersCursor, "systemName" );
			userId = IDataUtil.getString( connectionIdentifiersCursor, "userId" );
			connectionIdentifiersCursor.destroy();

			// make sure we have a valid value for each part of the pair
			if (systemName != null && !systemName.equals(EMPTY_STRING) && userId != null && !userId.equals(EMPTY_STRING)) {
				AS400RPGHelper.resetConnections(systemName,userId);
			}
		}
	} else {
		// we didn't receive any identifiers, reset ALL connections
		AS400RPGHelper.resetConnections();
	}
	pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void setConnectionPoolProperties (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setConnectionPoolProperties)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required cleanupInterval
		// [i] field:0:required maxConnections
		// [i] field:0:required maxInactivity
		// [i] field:0:required maxLifetime
		// [i] field:0:required maxUseCount
		// [i] field:0:required maxUseTime
		// [i] field:0:required threadUsed
		// [i] field:0:required runMaintenance
	// retrieve values from pipeline
	IDataCursor pipelineCursor = pipeline.getCursor();
	String	cleanupInterval = IDataUtil.getString( pipelineCursor, "cleanupInterval" );
	String	maxConnections = IDataUtil.getString( pipelineCursor, "maxConnections" );
	String	maxInactivity = IDataUtil.getString( pipelineCursor, "maxInactivity" );
	String	maxLifetime = IDataUtil.getString( pipelineCursor, "maxLifetime" );
	String	maxUseCount = IDataUtil.getString( pipelineCursor, "maxUseCount" );
	String	maxUseTime = IDataUtil.getString( pipelineCursor, "maxUseTime" );
	String	threadUsed = IDataUtil.getString( pipelineCursor, "threadUsed" );
	String	runMaintenance = IDataUtil.getString( pipelineCursor, "runMaintenance" );
	pipelineCursor.destroy();

	// initialize objects to store values temporarily
	Long	cleanupIntervalObj = null;
	Integer	maxConnectionsObj = null;
	Long	maxInactivityObj = null;
	Long	maxLifetimeObj = null;
	Integer	maxUseCountObj = null;
	Long	maxUseTimeObj = null;
	Boolean	threadUsedObj = null;
	Boolean	runMaintenanceObj = null;

	// parse the input into the correct format
	if (cleanupInterval != null) {
		try {
			cleanupIntervalObj = new Long(cleanupInterval);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("cleanupInterval must be a number");
		}
	}
	if (maxConnections != null) {
		try {
			maxConnectionsObj = new Integer(maxConnections);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("maxConnections must be a number");
		}
	}
	if (maxInactivity != null) {
		try {
			maxInactivityObj = new Long(maxInactivity);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("maxInactivity must be a number");
		}
	}
	if (maxLifetime != null) {
		try {
			maxLifetimeObj = new Long(maxLifetime);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("maxLifetime must be a number");
		}
	}
	if (maxUseCount != null) {
		try {
			maxUseCountObj = new Integer(maxUseCount);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("maxUseCount must be a number");
		}
	}
	if (maxUseTime != null) {
		try {
			maxUseTimeObj = new Long(maxUseTime);
		}
		catch (NumberFormatException nfe) {
			throw new ServiceException("maxUseTime must be a number");
		}
	}
	if (threadUsed != null) {
		if ( !threadUsed.equalsIgnoreCase(TRUE) && !threadUsed.equalsIgnoreCase(FALSE) ) {
			throw new ServiceException("threadUsed must be either true or false");
		}
		threadUsedObj = new Boolean(threadUsed);
	}
	if (runMaintenance != null) {
		if ( !runMaintenance.equalsIgnoreCase(TRUE) && !runMaintenance.equalsIgnoreCase(FALSE) ) {
			throw new ServiceException("runMaintenance must be either true or false");
		}
		runMaintenanceObj = new Boolean(runMaintenance);
	}

	// set the appropriate values based upon what was passed in
	if (cleanupIntervalObj != null) {
		AS400RPGHelper.setPoolCleanupInterval(cleanupIntervalObj.longValue());
	}
	if (maxConnectionsObj != null) {
		AS400RPGHelper.setPoolMaxConnections(maxConnectionsObj.intValue());
	}
	if (maxInactivityObj != null) {
		AS400RPGHelper.setPoolMaxInactivity(maxInactivityObj.longValue());
	}
	if (maxLifetimeObj != null) {
		AS400RPGHelper.setPoolMaxLifetime(maxLifetimeObj.longValue());
	}
	if (maxUseCountObj != null) {
		AS400RPGHelper.setPoolMaxUseCount(maxUseCountObj.intValue());
	}
	if (maxUseTimeObj != null) {
		AS400RPGHelper.setPoolMaxUseTime(maxUseTimeObj.longValue());
	}
	if (runMaintenanceObj != null) {
		AS400RPGHelper.setPoolRunMaintenance(runMaintenanceObj.booleanValue());
	}
	if (threadUsedObj != null) {
		try {
			AS400RPGHelper.setPoolThreadUsed(threadUsedObj.booleanValue());
		}
		catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//*************************************************************************************
	//* MISC CONSTANTS
	//*************************************************************************************
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String EMPTY_STRING = "";
	// --- <<IS-END-SHARED>> ---
}

