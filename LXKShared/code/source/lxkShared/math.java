package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-06-24 04:05:00 EDT
// -----( ON-HOST: dashrwmis002.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class math

{
	// ---( internal utility methods )---

	final static math _instance = new math();

	static math _newInstance() { return new math(); }

	static math _cast(Object o) { return (math)o; }

	// ---( server methods )---




	public static final void calculateSquareRoot (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calculateSquareRoot)>> ---
		// @sigtype java 3.5
		// [i] field:0:required number
		// [o] field:0:required squareRootNumber
		IDataCursor idcPipeline = pipeline.getCursor(); 
		if (!idcPipeline.first("number")) 
		{ 
		throw new ServiceException("input number was null!"); 
		} 
		String strNumber = (String) idcPipeline.getValue(); 
		double sqrRootNum = Math.sqrt(Double.parseDouble(strNumber)); 
		idcPipeline.insertAfter("squareRootNumber", Double.toString(sqrRootNum)); 
		idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void checkForExponential (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkForExponential)>> ---
		// @sigtype java 3.5
		// [i] field:0:required InputString
		// [o] field:0:required OutputString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	InputValue = IDataUtil.getString( pipelineCursor, "InputString" );
		CharSequence cs1 = "E" ;
		 boolean retval = InputValue.contains(cs1);
		 IDataUtil.put( pipelineCursor, "OutputString",  retval);
		 
		// --- <<IS-END>> ---

                
	}



	public static final void checkOddEven (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkOddEven)>> ---
		// @sigtype java 3.5
		// [i] field:0:required num
		// [o] field:0:required output
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	num = IDataUtil.getString( pipelineCursor, "num" );		
		pipelineCursor.destroy();
		String output =null;
		int number = new Integer(num).intValue();
		if(number % 2==0)
			output="EVEN";
		else
			output="ODD";
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "output", output);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void convertExponentialtoLong (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertExponentialtoLong)>> ---
		// @sigtype java 3.5
		// [i] field:0:required Input
		// [o] field:0:required Output
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	InputValue = IDataUtil.getString( pipelineCursor, "Input" );
		//String OutputValue = null;
		Double InDecimalDoub = Double.parseDouble(InputValue);
		long l = (new Double(InDecimalDoub)).longValue();
		IDataUtil.put( pipelineCursor, "Output",  l);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void formatDecimal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(formatDecimal)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required InDecimal
		// [i] field:0:required FormatType
		// [o] field:0:required OutDecimal
		// pipeline
		// pass the decimal format type (eg: #0.00) to format the InDecimal value. 
		
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	InDecimal = IDataUtil.getString( pipelineCursor, "InDecimal" );
			String	FormatType = IDataUtil.getString( pipelineCursor, "FormatType" );
			String OutDecimal = null;
		
			//Double InDecimalDoub = Double.valueOf(InDecimal).doubleValue();
			Double InDecimalDoub = Double.parseDouble(InDecimal);
		
			NumberFormat nf = new DecimalFormat(FormatType);
			OutDecimal = nf.format(InDecimalDoub);
			
			IDataUtil.put( pipelineCursor, "OutDecimal", OutDecimal );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void numericShift (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(numericShift)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional numericValue
		// [i] field:0:required shiftBy
		// [i] field:0:required shiftDirection {"right","left"}
		// [o] field:0:required NewNumericValue
		
			
			IDataCursor idcPipeline = pipeline.getCursor();
		String input = null;
		int place = 0;
		String direction = "right";
		
			if (idcPipeline.first("numericValue"))
			{
				input = (String) idcPipeline.getValue();
				
		
			}
		
			if (idcPipeline.first("shiftBy"))
			{		
					
					place = Integer.parseInt((String) idcPipeline.getValue());
					
			}
			
		
			if (idcPipeline.first("shiftDirection"))
			{
				direction = (String) idcPipeline.getValue();
			}
			
		
			String inNum =null;
			String neg = "false";
			String output = null;
			int decIndex = 0;
			int newDecIndex = 0;
			String shiftNum = null;
			int numDiff = 0;
		
		
		
		//Check for null and/or neg. numericValue
		//Rahul's comment:  here the value of the input variable is checked if it has entered as null
		//making the null input to 0 so that no exception is thrown
		     if (input==null)
					input="0";
			if (input != null) {
				int check = input.indexOf('-');
				if (input.indexOf('-') >= 0) {
					neg = "true";
					inNum = input.substring(1);		
				}
				else {
					inNum = input;
						
				}
			
		
			
		//Check for existing decimal
				decIndex = inNum.indexOf('.');
		
					if (decIndex < 0) {
						decIndex = inNum.length();
						shiftNum = inNum;
					} else {
						int ssIndex = (decIndex+1);
						shiftNum = (inNum.substring(0,decIndex)+inNum.substring(ssIndex));
					}
					
		
		//Get new Decimal Index
		
		//		int dirFlag = direction.indexOf('f');
				if (direction.indexOf('f') < 0) {
					newDecIndex = (decIndex+place);
					} else {
					newDecIndex = (decIndex-place);
				}
		
		//Check newDecIndex for -
				
		//Shift Decimal
		
			//Space fill with 0 if req.
				int numLength = shiftNum.length();
					if (newDecIndex > numLength) {
						numDiff = (newDecIndex-numLength);
							for (int i = 0; i != numDiff; i++) {
								shiftNum = (shiftNum+"0");
							}
						output = shiftNum;
					}
						else if (newDecIndex < 0) {
								String newDecIndexCheck = Integer.toString(newDecIndex);
								String newDecAdd = newDecIndexCheck.substring(1);
								numDiff = Integer.parseInt(newDecAdd);
									for (int i = 0; i != numDiff; i++) {
										shiftNum = ("0"+shiftNum);
									}
							output = "0."+shiftNum;
							
					} else {
						String num_1 = shiftNum.substring(0,newDecIndex);
						String num_2 = shiftNum.substring(newDecIndex);
						output = (num_1+"."+num_2);
		
					}		
				}
		
		
				
		
		
					
		/*else {
								//throw new ServiceException("numericValue can not be null");
								//ServiceException e=new ServiceException("numericValue can not be null");
								//throw e;
								input="0";
			}*/
		
			if (output.indexOf('.') == 0) {
				output = "0"+output;
			}
		
			if (output.indexOf('.') == output.length()-1) {
				output = output.substring(0,(output.length()-1));
			}
			if (neg.indexOf('r') > 0) {
					output = ("-"+output);
			}		
		
		
			idcPipeline.insertAfter("NewNumericValue",output);
		
		// --- <<IS-END>> ---

                
	}



	public static final void round (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(round)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required number
		// [i] field:0:optional precision
		// [o] field:0:required newNumber
		IDataCursor cursor = pipeline.getCursor();
		
		double number = 0;
		int precision = 2;
		
		if (cursor.first("number"))
		{
		  number = Double.parseDouble((String)cursor.getValue());
		}
		else
		{
		  throw new ServiceException("Missing input 'number'");
		}
		
		if (cursor.first("precision"))
		{
		  precision = Integer.parseInt((String)cursor.getValue());
		}
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(precision);
		nf.setMinimumFractionDigits(precision);
		
		IDataUtil.put(cursor, "newNumber", nf.format(number));
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

