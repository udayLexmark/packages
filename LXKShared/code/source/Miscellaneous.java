

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 05:31:43 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.*;
import com.wm.util.*;
import java.sql.*;
import FileZip.*;
import DBConnection;
import com.wm.lang.ns.NSName;
import com.wm.util.Debug;
import com.wm.app.b2b.client.*;
import java.io.ByteArrayInputStream;
import java.util.*;
import ClassDetails;
import java.io.FileInputStream;
// --- <<IS-END-IMPORTS>> ---

public final class Miscellaneous

	extends Service
{
	// ---( internal utility methods )---

	final static Miscellaneous _instance = new Miscellaneous();

	static Miscellaneous _newInstance() { return new Miscellaneous(); }

	static Miscellaneous _cast(Object o) { return (Miscellaneous)o; }

	// ---( server methods )---




	public static final void getClassDetails (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getClassDetails)>> ---
		// @sigtype java 3.5
		// [i] field:0:required className
		// [o] field:0:required classDetails
		// [o] field:0:required error
		IDataCursor cursor = pipeline.getCursor();
		String className = "";
		String classDetails = "";
		
		if (cursor.last("className")) {
			className = (String) cursor.getValue();
		}
		else {
			cursor.last();
			cursor.insertAfter("error", "Missing input parameter: className");
			return;
		} 
		
		try {
			classDetails = ClassDetails.getClassDetails(className);
		}
		catch (Exception e) {
			cursor.last();
			cursor.insertAfter("error", e.toString());
			return;
		}
		
		cursor.last();
		cursor.insertAfter("classDetails", classDetails);
		 
		// --- <<IS-END>> ---

                
	}



	public static final void getJVMMemoryStats (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getJVMMemoryStats)>> ---
		// @sigtype java 3.5
		// [o] field:0:required totalMemoryInBytes
		// [o] field:0:required freeMemoryInBytes
		long totalMemory = 0;
		long freeMemory  = 0;
		
		
		Runtime thisRuntime = Runtime.getRuntime();
		
		totalMemory = thisRuntime.totalMemory();
		freeMemory  = thisRuntime.freeMemory();
		
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.last();
		cursor.insertAfter("totalMemoryInBytes", Long.toString(totalMemory)); 
		cursor.insertAfter("freeMemoryInBytes", Long.toString(freeMemory));
		// --- <<IS-END>> ---

                
	}


    public static final Values getSessionID (Values in)
    {
        Values out = in;
		// --- <<IS-START(getSessionID)>> ---
		// @sigtype java 3.0
		// [o] field:0:required sessionID
		/****************************************************************************
		Service 	getSessionID()
		
		Input:  	
		
		Returns:	
		
		Comments:	
		Date:                      	Description of the change.
		09/12/00   	Tony Foltz      Initial creation
		****************************************************************************/ 
			
		Session sessionInstance = getSession();
		
		String sessionID = sessionInstance.getSessionID();
		 
		out.put("sessionID", sessionID);
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values invokeGarbageCollector (Values in)
    {
        Values out = in;
		// --- <<IS-START(invokeGarbageCollector)>> ---
		// @sigtype java 3.0
		System.gc();
		// --- <<IS-END>> ---
        return out;
                
	}
}

