package LXKWMAMSupport.Atlas;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-06-27 08:20:12 EDT
// -----( ON-HOST: dlxksb2b1e.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.*;
import java.text.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class Meterreas

{
	// ---( internal utility methods )---

	final static Meterreas _instance = new Meterreas();

	static Meterreas _newInstance() { return new Meterreas(); }

	static Meterreas _cast(Object o) { return (Meterreas)o; }

	// ---( server methods )---




	public static final void addTimeStampToQuery (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addTimeStampToQuery)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required query
		// [i] field:0:required startTime
		// [i] field:0:required endTime
		// [o] field:0:required query
		// [o] field:0:required querydesc
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object query = IDataUtil.get( pipelineCursor, "query" ); 
		String startTime = IDataUtil.getString( pipelineCursor, "startTime");  
		String endTime =  IDataUtil.getString( pipelineCursor, "endTime" ); 
		pipelineCursor.destroy();
		com.wm.app.tn.db.SimpleDocQuery sdq=null ;
		try{
			sdq = (com.wm.app.tn.db.SimpleDocQuery) query;
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date fromDate = sdf.parse(startTime);
			long fromDateTimeInMs = fromDate.getTime();
			
			java.util.Date toDate = sdf.parse(endTime);
			long toDateTimeInMs = toDate.getTime();
		
			sdq.setTimeInterval(new java.sql.Timestamp(fromDateTimeInMs),new java.sql.Timestamp(toDateTimeInMs));
			
		}catch(Exception e){
			IDataUtil.put( pipelineCursor, "output", "In Exception");
			e.printStackTrace();
		}finally{
		}
		IDataCursor pipelineCursor_1 = pipeline.getCursor(); 
		IDataUtil.put( pipelineCursor_1, "query", sdq ); 
		IDataUtil.put( pipelineCursor_1, "queryDesc", sdq.toString() ); 
		pipelineCursor_1.destroy(); 
		// --- <<IS-END>> ---

                
	}



	public static final void calculateDateDifference (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calculateDateDifference)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required startDateTime
		// [i] field:0:required endDateTime
		// [i] field:0:required startDateFormat
		// [i] field:0:required endDateFormat
		// [o] field:0:required dateDifferenceMillis
		// [o] field:0:required dateDifferenceSec
		// [o] field:0:required dateDifferenceMin
		// [o] field:0:required dateDifferenceHr
		// [o] field:0:required dateDifferenceDay
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	startDateTime = "";
		String	endDateTime = "";
		String startDateFormat = "";
		String endDateFormat = "";
		if (pipelineCursor.first("startDateTime"))
		{
			startDateTime = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("endDateTime"))
		{
			endDateTime = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("startDateFormat"))
		{
			startDateFormat = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("endDateFormat"))
		{
			endDateFormat = (String) pipelineCursor.getValue();
		}
		
		if (startDateTime.equals("") || endDateTime.equals(""))
			throw new ServiceException("Dates cannot be null");
		if (startDateFormat.equals("") || endDateFormat.equals(""))
			throw new ServiceException("Date formats cannot be null");
		
		pipelineCursor.destroy();
		
		try {
				SimpleDateFormat sdf = new SimpleDateFormat(startDateFormat);
				Date sdt = sdf.parse(startDateTime);
				SimpleDateFormat edf = new SimpleDateFormat(endDateFormat);
				Date edt = edf.parse(endDateTime);
				long  timediff = edt.getTime() - sdt.getTime();
				
			
				String displayTimeMillis = Long.toString(timediff);
				String displayTimeSec = Long.toString(timediff/1000);
				String displayTimeMin = Long.toString(timediff/60000);
				String displayTimeHr = Long.toString(timediff/3600000);
				String displayTimeDay = Long.toString(timediff/86400000);
		
				// pipeline
				IDataCursor pipelineCursor_1 = pipeline.getCursor();
				pipelineCursor_1.last();
				pipelineCursor_1.insertAfter( "dateDifferenceMillis", displayTimeMillis);
				pipelineCursor_1.insertAfter( "dateDifferenceSec", displayTimeSec);
				pipelineCursor_1.insertAfter( "dateDifferenceMin", displayTimeMin);
				pipelineCursor_1.insertAfter( "dateDifferenceHr", displayTimeHr);
				pipelineCursor_1.insertAfter( "dateDifferenceDay", displayTimeDay);
			
		
				pipelineCursor_1.destroy();
			} catch (ParseException e) {
				throw new ServiceException("Error parsing the date time: " + e);
			}
		// --- <<IS-END>> ---

                
	}



	public static final void convertMilliToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertMilliToDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required milliSeconds
		// [o] field:0:required timeFormatted
		IDataCursor idc = pipeline.getCursor();
		  int milliSeconds = Integer.parseInt(IDataUtil.getString(idc,"milliSeconds"));
		  int remMilliSecs;
		
		
		  int hours = milliSeconds/(1000*60*60);
		  remMilliSecs = milliSeconds%(1000*60*60);
		  int minutes = remMilliSecs/(1000*60);
		  remMilliSecs = remMilliSecs%(1000*60);
		  int seconds = remMilliSecs/1000;
		String timeFormatted = hours+":"+minutes+":"+seconds;
		
		  IDataUtil.put(idc,"timeFormatted",timeFormatted);
		
		  idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

