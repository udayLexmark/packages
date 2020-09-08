package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-02-26 07:09:17 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.Session;
import com.wm.app.b2b.server.User;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void doThreadInvoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(doThreadInvoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required serviceName
		// [i] record:0:required serviceInputs
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		String serviceName = IDataUtil.getString( pipelineCursor_1, "serviceName" );
		IData serviceInputs = IDataUtil.getIData( pipelineCursor_1, "serviceInputs" );
		pipelineCursor_1.destroy();
		
		try
		{
			NSName functionalServerServiceName = NSName.create(serviceName);
			Service.doThreadInvoke(functionalServerServiceName, serviceInputs);
		}
		catch (Exception e)
		{
			throw new ServiceException("Unable to invoke service due to: " + e);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void doThreadInvokeWithDeepClone (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(doThreadInvokeWithDeepClone)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required serviceName
		// [i] record:0:required serviceInputs
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		String serviceName = IDataUtil.getString( pipelineCursor_1, "serviceName" );
		IData serviceInputs = IDataUtil.getIData( pipelineCursor_1, "serviceInputs" );
		pipelineCursor_1.destroy();
		
		try
		{
			NSName functionalServerServiceName = NSName.create(serviceName);
			Service.doThreadInvoke(functionalServerServiceName, IDataUtil.deepClone(serviceInputs));
		}
		catch (Exception e)
		{
			throw new ServiceException("Unable to invoke service due to: " + e);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void generateEnterpriseDocumentId (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generateEnterpriseDocumentId)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required enterpriseDocumentId
		IDataCursor cursor = pipeline.getCursor();
		String uniqueId = "";
		
		// Get Server Name
		com.wm.app.b2b.server.ServerAPI api = new com.wm.app.b2b.server.ServerAPI();
		String serverName = api.getServerName();
		// Remove domain name
		if (serverName != null)
		{
			if (serverName.indexOf('.') != -1)
			{
				serverName = serverName.substring(0, serverName.indexOf('.'));
			}
		}
		else
		{
			serverName = "";
		}
		
		// Create Timestamp
		java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
		String dateTimeStamp = Integer.toString(calendar.get(java.util.Calendar.YEAR)) 
							+	Integer.toString(calendar.get(java.util.Calendar.MONTH)+1) 
							+	Integer.toString(calendar.get(java.util.Calendar.DAY_OF_MONTH))
							+	Integer.toString(calendar.get(java.util.Calendar.HOUR))
							+	Integer.toString(calendar.get(java.util.Calendar.MINUTE))
							+	Integer.toString(calendar.get(java.util.Calendar.SECOND))
							+	Integer.toString(calendar.get(java.util.Calendar.MILLISECOND))
		;
		
		// Build the unique identifier
		// serverName.port.dateTimeStamp.counter
		uniqueId = serverName +"."+ Integer.toString(api.getCurrentPort()) +"."+ dateTimeStamp +"."+Integer.toString(getNextCounterValue());
		
		cursor.last();
		cursor.insertAfter("enterpriseDocumentId", uniqueId);
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getCounterValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getCounterValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required counterValue
		// pipeline
		IDataCursor cursor = pipeline.getCursor();
		String counterValue = Integer.toString(getNextCounterValue());
		cursor.insertAfter("counterValue", counterValue);
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getTimeDiffMillis (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getTimeDiffMillis)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional startTime
		// [o] field:0:required timeDiff
		long currentTime = System.currentTimeMillis();
		//Use 0 when no startTime is specified.
		long startTime = 0;
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("startTime"))
		{
		  startTime = Long.parseLong((String)cursor.getValue());
		}
		
		String timeDiff = String.valueOf(currentTime - startTime);
		
		if (cursor.first("timeDiff"))
		{
		  cursor.setValue(timeDiff);
		}
		else
		{
		  cursor.insertAfter("timeDiff", timeDiff);
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getUserID (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getUserID)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required username
		//Get the current session
		Session currentSession = Service.getSession();
		
		//Get current user
		User user = currentSession.getUser();
		
		//Assign the username value to strUsername
		String strUsername = user.getName();
		
		//insert the username into the pipeline
		IDataCursor idcPipeline = pipeline.getCursor();
		idcPipeline.insertAfter("username", strUsername);
		// --- <<IS-END>> ---

                
	}



	public static final void invoke (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invoke)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		
		IDataHashCursor pipelineCursor =  pipeline.getHashCursor(); 
		String serviceName = null; 
		if (pipelineCursor.first("serviceName")) 
		{ 
		        serviceName = (String)pipelineCursor.getValue(); 
		} 
		else 
		{ 
		        throw new ServiceException("service cannot be null"); 
		} 
		pipelineCursor.destroy(); 
		
		try 
		{ 
		        //Split the interface and service from serviceName 
		        if (serviceName.indexOf(":") == -1) 
		        { 
		                throw new ServiceException("Service name must be in the format <interface>:<service>"); 
		        } 
		        String ifc = serviceName.substring(0, serviceName.indexOf(":")); 
		        String service = serviceName.substring(serviceName.indexOf(":") + 1, serviceName.length()); 
		
		        //Invoke service 
		        Service.doInvoke(ifc,service,pipeline); 
		    
		} 
		
		catch(Exception e) 
		{ 
		        throw new ServiceException(e.getMessage()); 
		} 
		
		
		 
		// --- <<IS-END>> ---

                
	}



	public static final void replaceObjectIfNull (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(replaceObjectIfNull)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required value
		// [i] object:0:required replaceWithValue
		// [o] object:0:required value
		IDataCursor cursor = pipeline.getCursor();
		Object inputValue       = null;
		Object replaceWithValue = null;
		
		if (cursor.last("value")) 
		{	
			inputValue = cursor.getValue();
		}
		
		if (inputValue == null) {
			if (cursor.last("replaceWithValue"))
			{
				cursor.last();
				cursor.insertAfter("value", cursor.getValue());
			}
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void returnHashTableValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(returnHashTableValue)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inHashTable
		// [i] field:0:required inKey
		// [o] field:0:required outValue
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			Hashtable	inHashTable = (Hashtable) IDataUtil.get( pipelineCursor, "inHashTable" );
			String	inKey = IDataUtil.getString( pipelineCursor, "inKey" );
		pipelineCursor.destroy();
		
		String outValue = "";
		try {
			outValue = inHashTable.get(inKey).toString();
			}
		catch (Exception e) {
			outValue = "";
			}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outValue", outValue );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void setNull (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setNull)>> ---
		// @sigtype java 3.5
		// [o] object:0:required output
		IDataCursor idc = pipeline.getCursor();
		IDataUtil.put(idc, "output", null);
		idc.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void sleep (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(sleep)>> ---
		// @sigtype java 3.5
		// [i] field:0:required sleepTime
		IDataCursor cursor = pipeline.getCursor();
		
		int numSecs = 0;
		if (cursor.first("sleepTime"))
		{
		  numSecs = Integer.parseInt((String)cursor.getValue());
		}
		
		try
		{
		  Thread.currentThread().sleep(numSecs*1000);
		}
		catch (InterruptedException ie)
		{
		  throw new ServiceException(ie);
		}
		finally
		{
		  cursor.destroy();
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void stringToObject (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToObject)>> ---
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required object
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	string = IDataUtil.getString( pipelineCursor, "string");
		Object object = string;
		pipelineCursor.insertAfter("object",object);
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static int count = 0;
	        public static synchronized int getNextCounterValue()
	                {
	                        count++;
	                        if (count == 1000)
	                                {
	                                        count = 1;
	                                }
	                        return (count);
	                }
	// --- <<IS-END-SHARED>> ---
}

