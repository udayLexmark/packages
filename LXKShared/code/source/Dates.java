

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-11-10 12:51:23 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
// --- <<IS-END-IMPORTS>> ---

public final class Dates

	extends Service
{
	// ---( internal utility methods )---

	final static Dates _instance = new Dates();

	static Dates _newInstance() { return new Dates(); }

	static Dates _cast(Object o) { return (Dates)o; }

	// ---( server methods )---




	public static final void dateReformat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dateReformat)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateTime
		// [i] field:0:optional year
		// [i] field:0:optional month
		// [i] field:0:optional dayOfMonth
		// [i] field:0:optional hour
		// [i] field:0:optional minute
		// [i] field:0:optional second
		// [i] field:0:required patternIn
		// [i] field:0:required patternOut
		// [o] field:0:optional dateTimeOut
		// [o] field:0:optional yearOut
		// [o] field:0:optional monthOut
		// [o] field:0:optional dayOfMonthOut
		// [o] field:0:optional hourOut
		// [o] field:0:optional minuteOut
		// [o] field:0:optional secondOut
		// [o] field:0:optional millisecondsSinceEpochOut
		// [o] field:0:optional dateReformatException
		/*
			DateTime Reformat Utility
			Author:  Tony Foltz
			Date:    12/11/01
			- Converts a date/time stamp from one format to another.
		    - The date/time stamp can be inputted as either a dateTime/pattern combination,
			  or the individual date components.
			- The desired pattern is given in the patternOut parameter.
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/ 
		
		String patternIn	= "";
		String patternOut	= "";
		String dateTime		= ""; 
		String yearStr 		= "";
		String monthStr 	= "";
		String dayOfMonthStr= "";
		String hourStr 		= "00";
		String minuteStr 	= "00";
		String secondStr 	= "00";
		String dateTimeOut  = "";
		int year 		= 0;
		int month 		= 0;
		int dayOfMonth 	= 0;
		int hour 		= 0;
		int minute 		= 0;
		int second 		= 0;
		long fromDateMillis = 0;
		TimeZone fromTimeZone = null;
		Calendar fromCalendar = null;
		Date inDate 		  = null;
		Date fromDate 		  = null;
		Date outDate 		  = null;
		SimpleDateFormat dateFormatIn  = null;
		SimpleDateFormat dateFormatOut = null;
		
		
		
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.last("patternIn")) {
			patternIn = (String) cursor.getValue();
		}
		if (cursor.last("patternOut")) {
			patternOut = (String) cursor.getValue();
		}
		if (cursor.last("dateTime")) {
			dateTime = (String) cursor.getValue();
		}
		if (cursor.last("year")) {
			yearStr = (String) cursor.getValue();
		}
		if (cursor.last("month")) {
			monthStr = (String) cursor.getValue();
		}
		if (cursor.last("dayOfMonth")) {
			dayOfMonthStr = (String) cursor.getValue();
		}
		if (cursor.last("hour")) {
			hourStr = (String) cursor.getValue();
		}
		if (cursor.last("minute")) {
			minuteStr = (String) cursor.getValue();
		}
		if (cursor.last("second")) {
			secondStr = (String) cursor.getValue();
		} 
		
		fromCalendar = Calendar.getInstance();
		
		try {
		
		if (dateTime != "") {
			// Create a date object.
			if (patternIn.toUpperCase().equals("MILLIS")) {
				inDate = new Date(Long.parseLong(dateTime));
			}
			else {
				// Read in as pattern if available
				if (patternIn != "") {
					dateFormatIn = new SimpleDateFormat(patternIn);
					dateFormatIn.setLenient(false);
				}
				else {
					dateFormatIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
				// Parse the inputted dateTime
				inDate = dateFormatIn.parse(dateTime);
			}
			
		
			//Format dateTimeOut
			// Read in as pattern if available
			if (patternOut != "") {
				dateFormatOut = new SimpleDateFormat(patternOut);
			}
			else {
				dateFormatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		
			//Copy the time to the output Calendar.
			fromCalendar.setTime(inDate);
		}
		
		dateFormatOut.setCalendar(fromCalendar);
		outDate = fromCalendar.getTime();
		dateTimeOut = dateFormatOut.format(outDate);
		
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(2);
		numberFormat.setGroupingUsed(false);
		
		cursor.last();
		cursor.insertAfter("dateTimeOut", dateTimeOut);
		cursor.insertAfter("yearOut", numberFormat.format(fromCalendar.get(Calendar.YEAR)));
		cursor.insertAfter("monthOut", numberFormat.format(fromCalendar.get(Calendar.MONTH)+1)); 
		cursor.insertAfter("dayOfMonthOut", numberFormat.format(fromCalendar.get(Calendar.DATE)));
		cursor.insertAfter("hourOut", numberFormat.format(fromCalendar.get(Calendar.HOUR_OF_DAY))); 
		cursor.insertAfter("minuteOut", numberFormat.format(fromCalendar.get(Calendar.MINUTE))); 
		cursor.insertAfter("secondOut", numberFormat.format(fromCalendar.get(Calendar.SECOND)));
		cursor.insertAfter("millisecondsSinceEpochOut", Long.toString(fromCalendar.getTime().getTime()));
		 
		}
		catch (Exception e) {
			cursor.last();
			cursor.insertAfter("dateReformatException", "Error reformating date: " + e.toString());
		}
		// --- <<IS-END>> ---

                
	}



	public static final void dateToMilliseconds (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dateToMilliseconds)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateTime
		// [i] field:0:optional year
		// [i] field:0:optional month
		// [i] field:0:optional dayOfMonth
		// [i] field:0:optional hour
		// [i] field:0:optional minute
		// [i] field:0:optional second
		// [i] field:0:required patternIn
		// [o] field:0:required dateTimeInMillis
		// [o] field:0:optional dateReformatException
		/*
			DateTime Reformat Utility
			Author:  Tony Foltz
			Date:    1/12/04
			- Converts a date/time stamp to milliseconds.
			- The input pattern is given in the patternIn parameter.
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/ 
		
		String patternIn	= "";
		String dateTime		= ""; 
		String yearStr 		= "";
		String monthStr 	= "";
		String dayOfMonthStr= "";
		String hourStr 		= "00";
		String minuteStr 	= "00";
		String secondStr 	= "00";
		String dateTimeOut  = "";
		int year 		= 0;
		int month 		= 0;
		int dayOfMonth 	= 0;
		int hour 		= 0;
		int minute 		= 0;
		int second 		= 0;
		long fromDateMillis = 0;
		TimeZone fromTimeZone = null;
		Calendar fromCalendar = null;
		Date inDate 		  = null;
		Date fromDate 		  = null;
		Date outDate 		  = null;
		SimpleDateFormat dateFormatIn  = null;
		SimpleDateFormat dateFormatOut = null;
		
		
		
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.last("patternIn")) {
			patternIn = (String) cursor.getValue();
		}
		if (cursor.last("dateTime")) {
			dateTime = (String) cursor.getValue();
		}
		if (cursor.last("year")) {
			yearStr = (String) cursor.getValue();
		}
		if (cursor.last("month")) {
			monthStr = (String) cursor.getValue();
		}
		if (cursor.last("dayOfMonth")) {
			dayOfMonthStr = (String) cursor.getValue();
		}
		if (cursor.last("hour")) {
			hourStr = (String) cursor.getValue();
		}
		if (cursor.last("minute")) {
			minuteStr = (String) cursor.getValue();
		}
		if (cursor.last("second")) {
			secondStr = (String) cursor.getValue();
		}
		
		fromCalendar = Calendar.getInstance();
		
		try {
		
		if (dateTime != "") {
			// Read in as pattern if available
			if (patternIn != "") {
				dateFormatIn = new SimpleDateFormat(patternIn);
				dateFormatIn.setLenient(false);
			}
			else {
				dateFormatIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			//Format dateTimeOut
			// Read in as pattern if available
		/*
			if (patternOut != "") {
				dateFormatOut = new SimpleDateFormat(patternOut);
			}
			else {
				dateFormatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		*/
			// Parse the inputted dateTime
			inDate = dateFormatIn.parse(dateTime);
			fromCalendar.setTime(inDate);
		}
		
		dateFormatOut.setCalendar(fromCalendar);
		outDate = fromCalendar.getTime();
		dateTimeOut = dateFormatOut.format(outDate);
		
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(2);
		numberFormat.setGroupingUsed(false);
		
		cursor.last();
		cursor.insertAfter("dateTimeInMillis", Long.toString(fromDateMillis));
		}
		catch (Exception e) {
			cursor.last();
			cursor.insertAfter("dateReformatException", "Error reformating date: " + e.toString());
		}
		// --- <<IS-END>> ---

                
	}



	public static final void dateToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dateToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required dateObject
		// [i] field:0:required dateFormat
		// [o] field:0:required dateString
		/*
			DateTime Validation Utility
			Author:  Vineet Gupta
			Date:    11/10/11
			- Convert Date Object to Date String
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/ 
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			java.util.Date	DateObj = (java.util.Date) IDataUtil.get( pipelineCursor, "dateObject" );
			String	DateFmt = IDataUtil.getString( pipelineCursor, "dateFormat" );
		pipelineCursor.destroy();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFmt);
		String dateString = dateFormat.format(DateObj);
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "dateString", dateString );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void timeZone_to_timeZone (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(timeZone_to_timeZone)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateTime
		// [i] field:0:required pattern
		// [i] field:0:optional year
		// [i] field:0:optional month
		// [i] field:0:optional dayOfMonth
		// [i] field:0:optional hour
		// [i] field:0:optional minute
		// [i] field:0:optional second
		// [i] field:0:required timeZoneFrom
		// [i] field:0:required timeZoneTo
		// [o] field:0:optional dateTimeOut
		// [o] field:0:optional yearOut
		// [o] field:0:optional monthOut
		// [o] field:0:optional dayOfMonthOut
		// [o] field:0:optional hourOut
		// [o] field:0:optional minuteOut
		// [o] field:0:optional secondOut
		/*
			Date Timezone Conversion Utility
			Author:  Tony Foltz
			Date:    12/7/01
			- Converts a date/time stamp from one timezone to another, while taking daylight   
			  savings time into account.
		    - The date/time stamp can be inputted as either a dateTime or the individual
		      date components.  A pattern can be given, which applies to both the input and
			  and output dateTime parameters.
			- If one of the inputted timeZones are left blank or set to "LOCAL", 
		      the systems local setting is used.
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/
		
		String pattern		= "";
		String dateTime		= ""; 
		String yearStr 		= "";
		String monthStr 	= "";
		String dayOfMonthStr= "";
		String hourStr 		= "00";
		String minuteStr 	= "00";
		String secondStr 	= "00";
		String timeZoneFrom = "";
		String timeZoneTo   = "";
		String dateTimeOut  = "";
		int year 		= 0;
		int month 		= 0;
		int dayOfMonth 	= 0;
		int hour 		= 0;
		int minute 		= 0;
		int second 		= 0;
		long fromDateMillis = 0;
		TimeZone fromTimeZone = null;
		TimeZone toTimeZone   = null;
		Calendar fromCalendar = null;
		Calendar toCalendar   = null;
		Date inDate 		  = null;
		Date fromDate 		  = null;
		Date toDate 		  = null;
		Date outDate 		  = null;
		SimpleDateFormat dateFormatIn  = null;
		SimpleDateFormat dateFormatOut = null;
		
		
		
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.last("pattern")) {
			pattern = (String) cursor.getValue();
		}
		if (cursor.last("dateTime")) {
			dateTime = (String) cursor.getValue();
		}
		if (cursor.last("year")) {
			yearStr = (String) cursor.getValue();
		}
		if (cursor.last("month")) {
			monthStr = (String) cursor.getValue();
		}
		if (cursor.last("dayOfMonth")) {
			dayOfMonthStr = (String) cursor.getValue();
		}
		if (cursor.last("hour")) {
			hourStr = (String) cursor.getValue();
		}
		if (cursor.last("minute")) {
			minuteStr = (String) cursor.getValue();
		}
		if (cursor.last("second")) {
			secondStr = (String) cursor.getValue();
		}
		if (cursor.last("timeZoneFrom")) {
			timeZoneFrom = (String) cursor.getValue();
		}
		if (cursor.last("timeZoneTo")) {
			timeZoneTo = (String) cursor.getValue();
		}
		
		// Set fromCalendar
		if ((timeZoneFrom != "") && !(timeZoneFrom.toUpperCase().trim().equals("LOCAL"))){ // Not LOCAL
			fromTimeZone = TimeZone.getTimeZone(timeZoneFrom);
			fromCalendar = Calendar.getInstance(fromTimeZone);
		}
		else {
			fromCalendar = Calendar.getInstance();
		}
		
		// Set toCalendar
		if ((timeZoneTo != "") && !(timeZoneTo.toUpperCase().trim().equals("LOCAL"))){  // Not LOCAL
			toTimeZone = TimeZone.getTimeZone(timeZoneTo);
			toCalendar = Calendar.getInstance(toTimeZone);
		}
		else {
			toCalendar = Calendar.getInstance();
		}
		
		if (dateTime != "") {
			// Read in as pattern if available
			if (pattern != "") {
				dateFormatIn = new SimpleDateFormat(pattern);
			}
			else {
				dateFormatIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		
			// Parse the inputted dateTime
			try {
				inDate = dateFormatIn.parse(dateTime);
			}
			catch (Exception e) {
				Debug.log(0, e.toString());
			}
			fromCalendar.setTime(inDate);
		}
		else {
			year 		= Integer.parseInt(yearStr);
			month 		= Integer.parseInt(monthStr);
			dayOfMonth 	= Integer.parseInt(dayOfMonthStr);
			hour 		= Integer.parseInt(hourStr);
			minute 		= Integer.parseInt(minuteStr);
			second 		= Integer.parseInt(secondStr);
		
			fromCalendar.set(year, month-1, dayOfMonth, hour, minute, second);
		}
		
		
		fromDate = fromCalendar.getTime();
		fromDateMillis = fromDate.getTime();
		
		toDate = new Date(fromDateMillis);
		
		toCalendar.setTime(toDate);
		
		
		//Format dateTimeOut
			// Read in as pattern if available
			if (pattern != "") {
				dateFormatOut = new SimpleDateFormat(pattern);
			}
			else {
				dateFormatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		
		dateFormatOut.setCalendar(toCalendar);
		outDate = toCalendar.getTime();
		dateTimeOut = dateFormatOut.format(outDate);
		
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumIntegerDigits(2);
		numberFormat.setGroupingUsed(false);
		
		cursor.last();
		cursor.insertAfter("dateTimeOut", dateTimeOut);
		cursor.insertAfter("yearOut", numberFormat.format(toCalendar.get(Calendar.YEAR)));
		cursor.insertAfter("monthOut", numberFormat.format(toCalendar.get(Calendar.MONTH)+1)); 
		cursor.insertAfter("dayOfMonthOut", numberFormat.format(toCalendar.get(Calendar.DATE)));
		cursor.insertAfter("hourOut", numberFormat.format(toCalendar.get(Calendar.HOUR_OF_DAY))); 
		cursor.insertAfter("minuteOut", numberFormat.format(toCalendar.get(Calendar.MINUTE))); 
		cursor.insertAfter("secondOut", numberFormat.format(toCalendar.get(Calendar.SECOND)));
		
		// --- <<IS-END>> ---

                
	}



	public static final void validateDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(validateDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateTime
		// [i] field:0:required patternIn
		// [i] field:0:optional year
		// [i] field:0:optional month
		// [i] field:0:optional dayOfMonth
		// [i] field:0:optional hour
		// [i] field:0:optional minute
		// [i] field:0:optional second
		// [o] field:0:required valid
		// [o] field:0:optional dateValidateException
		/*
			DateTime Validation Utility
			Author:  Tony Foltz
			Date:    07/12/02
			- Validates a date/time stamp.
		    - The date/time stamp can be inputted as either a dateTime/pattern combination,
			  or the individual date components.
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/ 
		
		String patternIn	= "";
		String dateTime		= ""; 
		String yearStr 		= "";
		String monthStr 	= "";
		String dayOfMonthStr= "";
		String hourStr 		= "00";
		String minuteStr 	= "00";
		String secondStr 	= "00";
		int year 		= 0;
		int month 		= 0;
		int dayOfMonth 	= 0;
		int hour 		= 0;
		int minute 		= 0;
		int second 		= 0;
		long fromDateMillis = 0;
		TimeZone fromTimeZone = null;
		Calendar fromCalendar = null;
		Date inDate 		  = null;
		Date fromDate 		  = null;
		Date outDate 		  = null;
		SimpleDateFormat dateFormatIn  = null;
		
		
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.last("patternIn")) {
			patternIn = (String) cursor.getValue();
		}
		if (cursor.last("dateTime")) {
			dateTime = (String) cursor.getValue();
		}
		if (cursor.last("year")) {
			yearStr = (String) cursor.getValue();
		}
		if (cursor.last("month")) {
			monthStr = (String) cursor.getValue();
		}
		if (cursor.last("dayOfMonth")) {
			dayOfMonthStr = (String) cursor.getValue();
		}
		if (cursor.last("hour")) {
			hourStr = (String) cursor.getValue();
		}
		if (cursor.last("minute")) {
			minuteStr = (String) cursor.getValue();
		}
		if (cursor.last("second")) {
			secondStr = (String) cursor.getValue();
		}
		
		
		try {
		
		if (dateTime != "") {
			// Read in as pattern if available
			if (patternIn != "") {
				dateFormatIn = new SimpleDateFormat(patternIn);
				dateFormatIn.setLenient(false);
			}
			else {
				dateFormatIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			dateFormatIn.parse(dateTime);
		}
		
		cursor.last();
		cursor.insertAfter("valid", "true");
		}
		catch (Exception e) {
			cursor.last();
			cursor.insertAfter("valid", "false");
			cursor.insertAfter("dateValidateException", e.toString());
		}
		// --- <<IS-END>> ---

                
	}
}

