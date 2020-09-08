

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 05:25:25 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class Math

	extends Service
{
	// ---( internal utility methods )---

	final static Math _instance = new Math();

	static Math _newInstance() { return new Math(); }

	static Math _cast(Object o) { return (Math)o; }

	// ---( server methods )---




	public static final void hexNumberStringToIntegerString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hexNumberStringToIntegerString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required hexString
		// [o] field:0:required integerString
		IDataCursor cursor 	= pipeline.getCursor();
		String hexString 	= null;
		String outputString = "";
		
		cursor.last("hexString");
		hexString = (String) cursor.getValue();
		
		StringTokenizer tokenizer = new StringTokenizer(hexString);
		
		String thisHexString = "";
		String asciiString = "";
		String thisValue;
		while (tokenizer.hasMoreElements()) {
			thisHexString = tokenizer.nextToken();
		
			int intValue = Integer.parseInt(thisHexString, 16);
		
			thisValue = Integer.toString(intValue); 
		
			outputString = outputString + " " + thisValue;   
		}
		
		//outputString = outputString.trim();
		cursor.last();
		cursor.insertAfter("integerString",outputString);
		// --- <<IS-END>> ---

                
	}



	public static final void multiplyFloatsToLong (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(multiplyFloatsToLong)>> ---
		// @sigtype java 3.5
		// [i] field:0:required num1
		// [i] field:0:required num2
		// [o] field:0:required value
		IDataCursor cursor = pipeline.getCursor();
		
		cursor.last("num1");
		float num1 = Float.parseFloat((String) cursor.getValue());
		
		cursor.last("num2");
		float num2 = Float.parseFloat((String) cursor.getValue());
		
		
		float fltout = num1 * num2;
		
		Float fltObj = new Float(fltout);
		
		Long lngObj = new Long(fltObj.longValue());
		
		cursor.last();
		cursor.insertAfter("value", lngObj.toString());
		
		// --- <<IS-END>> ---

                
	}
}

