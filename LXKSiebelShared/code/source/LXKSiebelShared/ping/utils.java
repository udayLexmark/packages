package LXKSiebelShared.ping;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-01-15 22:02:33 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void getSiebelStatusAndTimeStamp (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSiebelStatusAndTimeStamp)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required siebelStatus
		// [o] field:0:required timeStamp
		IDataCursor pipelineCursor = pipeline.getCursor();
		pipelineCursor.insertAfter("siebelStatus", status);
		pipelineCursor.insertAfter("timeStamp", outTime); 
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void updateSiebelStatusAndTimeStamp (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(updateSiebelStatusAndTimeStamp)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required updatedStatus
		// [i] field:0:required updatedTimeStamp
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	newStatus = IDataUtil.getString(pipelineCursor , "updatedStatus" );
			String	newTimeStamp = IDataUtil.getString(pipelineCursor , "updatedTimeStamp" );
		try
		{
				updateSiebelEnvVariables(newStatus,newTimeStamp);
		}
		catch (Exception e)
		{
		throw new ServiceException(e.getMessage());
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static String status="UP"; 
	public  static  String  outTime;
	
	static
	{
	try
	 {
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = new Date();
	outTime = dateFormat.format(date);
	 }
	catch(Exception e)
	 {
	}
	 }
	
	public synchronized static void updateSiebelEnvVariables(String siebelStatus,String timeStamp) throws ServiceException
	 {		
	                if (siebelStatus!= null) 
	                  {
				      status = siebelStatus;
	                             }
	                     else
	                      {
	                       throw new ServiceException("Missing input 'updatedStatus'");
	                           }
	
			if (timeStamp != null)
	                    {
	                       Date date;
	                 try
	                   {
	                       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	                       date = sdf.parse(timeStamp);
	                        outTime=  sdf.format(date); 
				       }
	                catch (ParseException e)
	                        {
	                     throw new ServiceException("updatedTimeStamp="  + timeStamp + 
	                              " cannot be parsed using the format  MM/dd/yyyy HH:mm:ss");
	                           }
	                      
		          
	               }
	                else 
	                 {
	                    try
	                        {
	              DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	              Date date = new Date();
	              outTime = dateFormat.format(date);
	                                    }
	                       catch(Exception e)
	                           {
	                               throw new ServiceException(e.getMessage());
	                                                                                     
	                                  }
	                 }
	}
	// --- <<IS-END-SHARED>> ---
}

