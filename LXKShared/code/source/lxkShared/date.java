package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-03-02 10:24:08 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class date

{
	// ---( internal utility methods )---

	final static date _instance = new date();

	static date _newInstance() { return new date(); }

	static date _cast(Object o) { return (date)o; }

	// ---( server methods )---




	public static final void SubtractBusinessDaysToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SubtractBusinessDaysToDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [i] field:0:required BusinessDaySubtract
		// [o] field:0:required newDate
		IDataCursor cursor = pipeline.getCursor();
		String pattern = null;
		String dateString = null;
		int numDays = 0;
		int BusinessdayOfTheWeek = 0;
		int calendarDays = 0;
		int BusinessDaySubtract = 0;
		int deliveryDay =0;
		double deliveryWeeks = 0;
		//all variables initialized
		
		if (cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  pattern = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'pattern'");
		}
		
		if (cursor.first("BusinessDaySubtract"))
		{
			try
			{
				BusinessDaySubtract = Integer.parseInt((String)cursor.getValue());
			}
			catch (Exception e)
			{
				throw new ServiceException("Input 'BusinessDaySubtract' is not a valid integer");
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		    
		Date fromDate; 
		try
		{
		  fromDate = dateFormat.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + "' cannot be parsed with pattern '" + pattern + "'");
		}
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);    
		//calendar.add(GregorianCalendar.DAY_OF_MONTH, numDays); 
		/* operation starts here */
		BusinessdayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 ;
		calendarDays = BusinessDaySubtract;
		
		if (BusinessDaySubtract < BusinessdayOfTheWeek ) /* deilvery date falls in same week */
		{calendar.add(GregorianCalendar.DAY_OF_MONTH, -BusinessDaySubtract);}
		
		else {
			if( BusinessdayOfTheWeek == 0 )
			{ 
			calendarDays = BusinessDaySubtract + 1;
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
			else if( BusinessdayOfTheWeek == 6 )
			{
			
			calendarDays = BusinessDaySubtract;
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
			else
			{
			calendarDays = BusinessDaySubtract + 2;
			BusinessDaySubtract = BusinessDaySubtract - BusinessdayOfTheWeek ;
		
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
		  } /* check for weekends and add date */
		
		String newDateString = dateFormat.format(calendar.getTime());
		if (cursor.first("newDate"))
		{
		  cursor.setValue(newDateString);
		}
		else
		{
		  cursor.insertAfter("newDate", newDateString);
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void SubtractBusinessDaysToDate_1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(SubtractBusinessDaysToDate_1)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [i] field:0:required BusinessDaySubtract
		// [o] field:0:required newDate
		IDataCursor cursor = pipeline.getCursor();
		String pattern = null;
		String dateString = null;
		int numDays = 0;
		int BusinessdayOfTheWeek = 0;
		int calendarDays = 0;
		int BusinessDaySubtract = 0;
		int deliveryDay =0;
		double deliveryWeeks = 0;
		//all variables initialized
		
		if (cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  pattern = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'pattern'");
		}
		
		if (cursor.first("BusinessDaySubtract"))
		{
			try
			{
				BusinessDaySubtract = Integer.parseInt((String)cursor.getValue());
			}
			catch (Exception e)
			{
				throw new ServiceException("Input 'BusinessDaySubtract' is not a valid integer");
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		    
		Date fromDate; 
		try
		{
		  fromDate = dateFormat.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + "' cannot be parsed with pattern '" + pattern + "'");
		}
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);    
		//calendar.add(GregorianCalendar.DAY_OF_MONTH, numDays); 
		/* operation starts here */
		BusinessdayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 ;
		calendarDays = BusinessDaySubtract;
		
		if (BusinessDaySubtract < BusinessdayOfTheWeek ) /* deilvery date falls in same week */
		{calendar.add(GregorianCalendar.DAY_OF_MONTH, -BusinessDaySubtract);}
		
		else {
			if( BusinessdayOfTheWeek == 0 )
			{ 
			calendarDays = BusinessDaySubtract + 1;
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
			else if( BusinessdayOfTheWeek == 6 )
			{
			
			calendarDays = BusinessDaySubtract;
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
			else
			{
			calendarDays = BusinessDaySubtract + 2;
			BusinessDaySubtract = BusinessDaySubtract - BusinessdayOfTheWeek ;
		
			deliveryWeeks = Math.floor(BusinessDaySubtract / 5);
			calendarDays += deliveryWeeks * 2;
			calendar.add(GregorianCalendar.DAY_OF_MONTH, -calendarDays);
			}
		  } /* check for weekends and add date */
		
		String newDateString = dateFormat.format(calendar.getTime());
		if (cursor.first("newDate"))
		{
		  cursor.setValue(newDateString);
		}
		else
		{
		  cursor.insertAfter("newDate", newDateString);
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void addBusinessDaysToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addBusinessDaysToDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [i] field:0:required businessDaysLeftForDelivery
		// [o] field:0:required newDate
		IDataCursor cursor = pipeline.getCursor();
		String pattern = null;
		String dateString = null;
		int numDays = 0;
		int dayOfTheWeek = 0;
		int calendarDays = 0;
		int businessDaysLeftForDelivery = 0;
		int deliveryDay =0;
		double deliveryWeeks = 0;
		//all variables initialized
		
		if (cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  pattern = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'pattern'");
		}
		
		if (cursor.first("businessDaysLeftForDelivery"))
		{
			try
			{
				businessDaysLeftForDelivery = Integer.parseInt((String)cursor.getValue());
			}
			catch (Exception e)
			{
				throw new ServiceException("Input 'businessDaysLeftForDelivery' is not a valid integer");
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		    
		Date fromDate; 
		try
		{
		  fromDate = dateFormat.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + "' cannot be parsed with pattern '" + pattern + "'");
		}
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);    
		//calendar.add(GregorianCalendar.DAY_OF_MONTH, numDays); 
		/* operation starts here */
		dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
		calendarDays = businessDaysLeftForDelivery;
		deliveryDay = dayOfTheWeek + businessDaysLeftForDelivery;
		
		if (deliveryDay < 7) /* deilvery date falls in same week */
		{calendar.add(GregorianCalendar.DAY_OF_MONTH, businessDaysLeftForDelivery);}
		
		
		else if ( dayOfTheWeek == 7 ) /* code for handling If start date is saturday */
		{
		        businessDaysLeftForDelivery -= 7 - dayOfTheWeek;
		      calendarDays += 1;
		        deliveryWeeks = Math.floor(businessDaysLeftForDelivery / 5);
		       calendarDays += deliveryWeeks * 2;
		calendar.add(GregorianCalendar.DAY_OF_MONTH, calendarDays);
		  }
		else {
		        businessDaysLeftForDelivery -= 7 - dayOfTheWeek;
		      calendarDays += 2;
		        deliveryWeeks = Math.floor(businessDaysLeftForDelivery / 5);
		       calendarDays += deliveryWeeks * 2;
		calendar.add(GregorianCalendar.DAY_OF_MONTH, calendarDays);
		  } /* check for weekends and add date */
		
		String newDateString = dateFormat.format(calendar.getTime());
		if (cursor.first("newDate"))
		{
		  cursor.setValue(newDateString);
		}
		else
		{
		  cursor.insertAfter("newDate", newDateString);
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void addDaysToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addDaysToDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [i] field:0:required numDays
		// [o] field:0:required newDate
		IDataCursor cursor = pipeline.getCursor();
		
		String pattern = null;
		String dateString = null;
		int numDays = 0;
		
		if (cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  pattern = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'pattern'");
		}
		
		if (cursor.first("numDays"))
		{
			try
			{
				numDays = Integer.parseInt((String)cursor.getValue());
			}
			catch (Exception e)
			{
				throw new ServiceException("Input 'numDays' is not a valid integer");
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		    
		Date fromDate; 
		try
		{
		  fromDate = dateFormat.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + "' cannot be parsed with pattern '" + pattern + "'");
		}
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);    
		calendar.add(GregorianCalendar.DAY_OF_MONTH, numDays); 
		String newDateString = dateFormat.format(calendar.getTime());
		if (cursor.first("newDate"))
		{
		  cursor.setValue(newDateString);
		}
		else
		{
		  cursor.insertAfter("newDate", newDateString);
		}
		
		cursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void addIntervalToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addIntervalToDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required dateIn
		// [i] field:0:required datePattern
		// [i] field:0:optional years
		// [i] field:0:optional months
		// [i] field:0:optional days
		// [i] field:0:optional hours
		// [i] field:0:optional minutes
		// [i] field:0:optional seconds
		// [i] field:0:optional milliseconds
		// [o] field:0:required dateOut
		// [o] field:0:required yearsOut
		// [o] field:0:required monthsOut
		// [o] field:0:required daysOut
		// [o] field:0:required hoursOut
		// [o] field:0:required minutesOut
		// [o] field:0:required secondsOut
		// [o] field:0:required millisecondsOut
		/*
			DateTime Adjustment Utility
			Author:  Crowe Chizek
			Date:    08/13/04
			- Takes a date and modifies it depending on the inputs passed.
		    -      To decrement an interval use a negative integer.
		    - Uses the date format parameters from java.text.SimpleDateFormat.
		*/
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	dateIn = IDataUtil.getString( pipelineCursor, "dateIn" );
		String	datePattern = IDataUtil.getString( pipelineCursor, "datePattern" );
		String	years = IDataUtil.getString( pipelineCursor, "years" );
		String	months = IDataUtil.getString( pipelineCursor, "months" );
		String	days = IDataUtil.getString( pipelineCursor, "days" );
		String	hours = IDataUtil.getString( pipelineCursor, "hours" );
		String	minutes = IDataUtil.getString( pipelineCursor, "minutes" );
		String	seconds = IDataUtil.getString( pipelineCursor, "seconds" );
		String	milliseconds = IDataUtil.getString( pipelineCursor, "milliseconds" );
		pipelineCursor.destroy();
		
		// prepare output variables
		String dateOut = null;
		String yearsOut = null;
		String monthsOut = null;
		String daysOut = null;
		String hoursOut = null;
		String minutesOut = null;
		String secondsOut = null;
		String millisecondsOut = null;
		
		// if date and pattern are valid values
		if (dateIn != null && !dateIn.equals(EMPTY_STRING) && datePattern != null && !datePattern.equals(EMPTY_STRING)) {
			try {
				// Prepare date passed in
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(sdf.parse(dateIn));
				
				// Modify date with the values passed in
				if (years != null && !years.equals(EMPTY_STRING) && Integer.parseInt(years) != 0) {
					gc.add(GregorianCalendar.YEAR,Integer.parseInt(years));
				}
				if (months != null && !months.equals(EMPTY_STRING) && Integer.parseInt(months) != 0) {
					gc.add(GregorianCalendar.MONTH,Integer.parseInt(months));
				}
				if (days != null && !days.equals(EMPTY_STRING) && Integer.parseInt(days) != 0) {
					gc.add(GregorianCalendar.DAY_OF_YEAR,Integer.parseInt(days));
				}
				if (hours != null && !hours.equals(EMPTY_STRING) && Integer.parseInt(hours) != 0) {
					gc.add(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(hours));
				}
				if (minutes != null && !minutes.equals(EMPTY_STRING) && Integer.parseInt(minutes) != 0) {
					gc.add(GregorianCalendar.MINUTE,Integer.parseInt(minutes));
				}
				if (seconds != null && !seconds.equals(EMPTY_STRING) && Integer.parseInt(seconds) != 0) {
					gc.add(GregorianCalendar.SECOND,Integer.parseInt(seconds));
				}
				if (milliseconds != null && !milliseconds.equals(EMPTY_STRING) && Integer.parseInt(milliseconds) != 0) {
					gc.add(GregorianCalendar.MILLISECOND,Integer.parseInt(milliseconds));
				}
				
				// Set output values
				dateOut = sdf.format(gc.getTime());
				yearsOut = String.valueOf(gc.get(GregorianCalendar.YEAR));
				monthsOut = String.valueOf(gc.get(GregorianCalendar.MONTH)+1);
				daysOut = String.valueOf(gc.get(GregorianCalendar.DAY_OF_MONTH));
				hoursOut = String.valueOf(gc.get(GregorianCalendar.HOUR_OF_DAY));
				minutesOut = String.valueOf(gc.get(GregorianCalendar.MINUTE));
				secondsOut = String.valueOf(gc.get(GregorianCalendar.SECOND));
				millisecondsOut = String.valueOf(gc.get(GregorianCalendar.MILLISECOND));
			} catch (NumberFormatException nfe) {
				StringBuffer sb = new StringBuffer("Years, Months, Days, Hours, Minutes, Seconds, and Milliseconds must be integers: ");
				sb.append(nfe.toString());
				throw new ServiceException (sb.toString());
			} catch (ParseException pe) {
				StringBuffer sb = new StringBuffer("Input Date must be a valid date that follows the format specified in date pattern: ");
				sb.append(pe.toString());
				throw new ServiceException (sb.toString());
			}
		} else {
			throw new ServiceException ("Required parameters dateIn and/or datePattern were not specified.");
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "dateOut", dateOut );
		IDataUtil.put( pipelineCursor_1, "yearsOut", yearsOut );
		IDataUtil.put( pipelineCursor_1, "monthsOut", monthsOut );
		IDataUtil.put( pipelineCursor_1, "daysOut", daysOut );
		IDataUtil.put( pipelineCursor_1, "hoursOut", hoursOut );
		IDataUtil.put( pipelineCursor_1, "minutesOut", minutesOut );
		IDataUtil.put( pipelineCursor_1, "secondsOut", secondsOut );
		IDataUtil.put( pipelineCursor_1, "millisecondsOut", millisecondsOut );
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



	public static final void compareDates (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareDates)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required dateString1
		// [i] field:0:required dateFormat1
		// [i] field:0:required dateString2
		// [i] field:0:required dateFormat2
		// [i] field:0:required currentHour
		// [o] field:0:required result
		/*
			DateTime Comparison Utility
			Author:  Crowe Chizek
			Date:    12/17/03
			- Compares 2 dates and returns the result as shown below
		    -      If dateString1 > dateString2, result = 1
		    -      If dateString1 = dateString2, result = 0
		    -      If dateString1 < dateString2, result = -1
		    -
			- Uses the date format parameters from java.text.SimpleDateFormat.
		*/ 
		
		IDataCursor idcPipeline = pipeline.getCursor();
			String ds1 = "";
			String ds2 = "";
			String df1 = "";
			String df2 = "";
			if (idcPipeline.first("dateString1"))
				ds1 = (String)idcPipeline.getValue();
			
			if (idcPipeline.first("dateString2"))
				ds2 = (String)idcPipeline.getValue();
		
			if (idcPipeline.first("dateFormat1"))
				df1 = (String)idcPipeline.getValue();
		
			if (idcPipeline.first("dateFormat2"))
				df2 = (String)idcPipeline.getValue();
		
			if (df1.equals("") || df2.equals(""))
				throw new ServiceException("Date formats must be specified");
		
			if (ds1.equals("") || ds2.equals(""))
				throw new ServiceException("Dates cannot be null");
		
			SimpleDateFormat sdf1 = new SimpleDateFormat(df1);
			SimpleDateFormat sdf2 = new SimpleDateFormat(df2);
			Date d1 = null;
			Date d2 = null;
			try
			{
				d1 = sdf1.parse(ds1);
				d2 = sdf2.parse(ds2);
			}
			catch (Exception e)
			{
				throw new ServiceException(e.toString());
			}
		
			boolean isafter = d1.after(d2);
			boolean isbefore = d2.after(d1);
			if (isafter)
			{
				idcPipeline.insertAfter("result", "1");
			}
		    else if (isbefore)
			{
				idcPipeline.insertAfter("result", "-1");
			}
			else //dates are equal
			{
		        String hour;
		        if (idcPipeline.first("currentHour"))
		           hour = (String)idcPipeline.getValue();
		        else
		           hour = "00";
		        int intHour = Integer.parseInt(hour);
		        if(intHour > 10)
				   idcPipeline.insertAfter("result", "1");
		        else
					idcPipeline.insertAfter("result", "0");
			}
		
			idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void convertEpochTimeDateTime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertEpochTimeDateTime)>> ---
		// @sigtype java 3.5
		// [i] field:0:required epochDate
		// [o] field:0:required date
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		
		try{
		String epochDate = IDataUtil.getString( pipelineCursor, "epochDate" );
		
		Date date1 = new Date(Long.parseLong(epochDate));
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		
		
		String date = format.format(date1);
		
		IDataUtil.put(pipelineCursor, "date", date);
		}
		catch(Exception e){
			System.out.println("Error while parsing date");
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void convertTimeZone (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertTimeZone)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:optional pattern
		// [i] field:0:optional timeZone
		// [i] field:0:optional newTimeZone
		// [o] field:0:required newDate
		GregorianCalendar today = new GregorianCalendar();
		
		IDataCursor cursor = pipeline.getCursor();
		
		String dateFormat = "MM/dd/yyyy hh:mm:ss.SSS a";
		String dateString = null;
		
		TimeZone currentZone = TimeZone.getDefault();
		TimeZone newZone = currentZone;
		
		if(cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  dateFormat = (String)cursor.getValue();
		}
		
		if (cursor.first("timeZone"))
		{
		  currentZone = TimeZone.getTimeZone((String)cursor.getValue());
		}
		
		if (cursor.first("newTimeZone"))
		{
		  newZone = TimeZone.getTimeZone((String)cursor.getValue());
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date;
		try
		{
		  sdf.setTimeZone(currentZone);
		  date = sdf.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + 
		                             "' cannot be parsed using the format '" + dateFormat + "'");
		}
		
		GregorianCalendar currCal = new GregorianCalendar(currentZone);
		currCal.setTime(date);
		GregorianCalendar newCal = new GregorianCalendar(newZone);
		newCal.setTime(currCal.getTime());
		sdf.setTimeZone(newZone);
		IDataUtil.put(cursor, "newDate", sdf.format(newCal.getTime()));
		//IDataUtil.put(cursor, "timeZone", currCal.getTimeZone().getID());
		//IDataUtil.put(cursor, "newTimeZone", newCal.getTimeZone().getID());
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void dateToJulianDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dateToJulianDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required year
		// [i] field:0:required month
		// [i] field:0:required day
		// [o] field:0:required julianDate
	IDataCursor idcPipeline = pipeline.getCursor();
	idcPipeline.first("year");
	int i = Integer.parseInt((String) idcPipeline.getValue());  
	idcPipeline.first("month");
	String m = (String) idcPipeline.getValue();
	idcPipeline.delete();
	idcPipeline.first("day");
	String d = (String) idcPipeline.getValue();
	idcPipeline.delete();

		if (m.length() == 1)
			m = "0" + m;

		if (d.length() == 1)
			d = "0" + d;

	int j = Integer.parseInt(m);
	int k = Integer.parseInt(d);

	        GregorianCalendar gregoriancalendar = new GregorianCalendar(i, j - 1, k);
        String s = String.valueOf(gregoriancalendar.get(6));
        if(s.length() == 1)
            s = "00" + s;
        else
        if(s.length() == 2)
            s = "0" + s;
        String s1 = String.valueOf(i - 1900) + s;

		if (s1.length() < 6) {
			int diff = (6-s1.length());
				for (i = 0; i < diff; i++) {
					s1 = "0" + s1;
				}
		}

	idcPipeline.insertAfter("month",m);
	idcPipeline.insertAfter("day",d);
	idcPipeline.insertAfter("julianDate",s1);
		// --- <<IS-END>> ---

                
	}



	public static final void stringToDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required dateString
		// [i] field:0:required pattern
		// [o] object:0:required date
	IDataCursor cursor = pipeline.getCursor(); 

	String dateFormat = "yyyy-MM-dd HH:mm:ss"; 
	String dateString = null; 

	if(cursor.first("dateString")) 
	{ 
		dateString = (String)cursor.getValue(); 
	} 
	else 
	{ 
		throw new ServiceException("Missing input 'date'"); 
	} 

	if (cursor.first("pattern")) 
	{ 
		dateFormat = (String)cursor.getValue(); 
	} 


	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); 
	Date date; 
	try 
	{ 
		date = sdf.parse(dateString); 
		IDataUtil.put(cursor, "date", date); 
	} 
	catch (ParseException pe) 
	{ 
		throw new ServiceException("Date '" + dateString + 
			"' cannot be parsed using the format '" + dateFormat + "'"); 
	} 
	finally 
	{ 
		cursor.destroy(); 
	}
		// --- <<IS-END>> ---

                
	}



	public static final void stringToSqlDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToSqlDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateString
		// [i] field:0:required pattern
		// [o] object:0:required date
		IDataCursor cursor = pipeline.getCursor();
		
		String dateFormat = "MM/dd/yyyy";
		String dateString = null;
		
		if(cursor.first("dateString"))
			{
				dateString = (String)cursor.getValue();
			}
		else
			{ 
				throw new ServiceException("Missing input 'date'"); 
			}
		if(cursor.first("pattern")){
			dateFormat = (String)cursor.getValue();
		}
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			java.util.Date date = sdf.parse(dateString);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
			IDataUtil.put(cursor, "date", sqlDate);
		}
		catch (ParseException pe){
			throw new ServiceException("Date '"+dateString+"' cannot be parsed using the format '"+dateFormat+"'");
		}
		finally{
			cursor.destroy();
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void substractDaysFromDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(substractDaysFromDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required date
		// [i] field:0:required pattern
		// [i] field:0:required numDays
		// [o] field:0:required newDate
		IDataCursor cursor = pipeline.getCursor();
		
		String pattern = null;
		String dateString = null;
		int numDays = 0;
		
		if (cursor.first("date"))
		{
		  dateString = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'date'");
		}
		
		if (cursor.first("pattern"))
		{
		  pattern = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'pattern'");
		}
		
		if (cursor.first("numDays"))
		{
			try
			{
				numDays = Integer.parseInt((String)cursor.getValue());
			}
			catch (Exception e)
			{
				throw new ServiceException("Input 'numDays' is not a valid integer");
			}
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		    
		Date fromDate; 
		try
		{
		  fromDate = dateFormat.parse(dateString);
		}
		catch (ParseException pe)
		{
		  throw new ServiceException("Date '" + dateString + "' cannot be parsed with pattern '" + pattern + "'");
		}
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);    
		calendar.add(GregorianCalendar.DAY_OF_MONTH, -numDays); 
		String newDateString = dateFormat.format(calendar.getTime());
		if (cursor.first("newDate"))
		{
		  cursor.setValue(newDateString);
		}
		else
		{
		  cursor.insertAfter("newDate", newDateString);
		}
		
		cursor.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static final String EMPTY_STRING = "";
	// --- <<IS-END-SHARED>> ---
}

