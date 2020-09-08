

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-02-26 07:10:38 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class string

	extends Service
{
	// ---( internal utility methods )---

	final static string _instance = new string();

	static string _newInstance() { return new string(); }

	static string _cast(Object o) { return (string)o; }

	// ---( server methods )---




	public static final void ASCIItoHexString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ASCIItoHexString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required asciiString
		// [o] field:0:required hexString
		IDataCursor cursor 	= pipeline.getCursor();
		String asciiString 	= null;
		
		cursor.last("asciiString");
		asciiString = (String) cursor.getValue();
		
		char thisChar;
		Character thisCharacter = null;
		String hexString = null;
		String outputString = "";
		int tempInt = 0;
		for (int i=0; i<asciiString.length(); i++) {
			thisChar = asciiString.charAt(i);
			tempInt = (int) thisChar;	
			hexString = Integer.toHexString(tempInt);
			outputString = outputString + hexString + " ";
		}
		
		outputString = outputString.trim().toUpperCase();
		
		cursor.last();
		cursor.insertAfter("hexString",outputString);
		// --- <<IS-END>> ---

                
	}



	public static final void hexStringToASCII (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(hexStringToASCII)>> ---
		// @sigtype java 3.5
		// [i] field:0:required hexString
		// [o] field:0:required asciiString
		IDataCursor cursor 	= pipeline.getCursor();
		String hexString 	= null;
		String outputString = "";
		
		cursor.last("hexString");
		hexString = (String) cursor.getValue();
		
		StringTokenizer tokenizer = new StringTokenizer(hexString);
		
		String thisHexString = "";
		String asciiString = "";
		char thisChar;
		while (tokenizer.hasMoreElements()) {
			thisHexString = tokenizer.nextToken();
			Integer thisInteger = Integer.valueOf(thisHexString, 16);
		//	Debug.log(0, "thisInteger= " + thisInteger.toString());
			thisChar = (char) thisInteger.intValue();
		//	Debug.log(0, "thisChar= " + thisChar);
			outputString = outputString + thisChar;   
		}
		
		//outputString = outputString.trim();
		cursor.last();
		cursor.insertAfter("asciiString",outputString);
		// --- <<IS-END>> ---

                
	}



	public static final void isNumeric (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isNumeric)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required isNumeric {"true","false"}
		IDataCursor cursor 	= pipeline.getCursor();
		String string1 	= null;
		
		cursor.last("inString");
		string1 = (String) cursor.getValue();
		
		
		try {
			Integer.parseInt(string1);
			cursor.last();
			cursor.insertAfter("isNumeric","true");
		}
		catch (NumberFormatException numE) { 
			cursor.last();
			cursor.insertAfter("isNumeric","false");
		}
		 
		// --- <<IS-END>> ---

                
	}


    public static final Values lastIndexOf (Values in)
    {
        Values out = in;
		// --- <<IS-START(lastIndexOf)>> ---
		// @sigtype java 3.0
		// [i] field:0:required inputString
		// [i] field:0:required lengthOfString
		// [i] field:0:required indexParameter
		// [o] field:0:required index
		String file = in.getString("inputString");
		String input = in.getString("indexParameter");
		Integer intLength = new Integer (in.getString("lengthOfString"));
		int index = 0;
		int eofLength = 0;
		
			try
			{	
				eofLength =	intLength.intValue();
				index = file.lastIndexOf(input, eofLength);
				out.put("index", index);					
			}
			catch ( Exception e)
			{
				
			}
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void objToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(objToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required myObj
		// [o] field:0:required myStr
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			Object	myObj = IDataUtil.get( pipelineCursor, "myObj" );
			String myStr = null;
		
			//myStr = Object.toString(myObj);
			if (myObj != null)
			{
				myStr = myObj.toString();
			}
			
			IDataUtil.put( pipelineCursor, "myStr", myStr );
			
		pipelineCursor.destroy();
		 
		// --- <<IS-END>> ---

                
	}



	public static final void pullB2BCoreFromException (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(pullB2BCoreFromException)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputMessage
		// [o] field:0:required outputMessage
		IDataCursor cursor = pipeline.getCursor();
		String inputMessage = "";
		String outputMessage = "";
		
		if (cursor.last("inputMessage")) {
			inputMessage = (String) cursor.getValue();
			inputMessage = inputMessage.trim();
		}
		else {
			Debug.log(0, "pullB2BCoreFromException: input missing.");
		}
		
		if (inputMessage.startsWith("[B2BCORE")) {
			int rightBracketIndex = inputMessage.indexOf("]");
			outputMessage = inputMessage.substring(rightBracketIndex + 1);
			outputMessage = outputMessage.trim();
		}
		else {
			outputMessage = inputMessage;
		}
		
		cursor.last();
		cursor.insertAfter("outputMessage", outputMessage);
		
		//[B2BCORE.0064.9005] 530 Login incorrect.
		// --- <<IS-END>> ---

                
	}



	public static final void removeNonAlphaNumericChars (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeNonAlphaNumericChars)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		IDataCursor cursor 		= pipeline.getCursor();
		String 	inString 		= "";
		String 	outString 		= "";
		int 	inLength 		= 0;
		char 	thisChar	 	= 'a';
		
		if (cursor.last("inputString")) {
			inString = (String) cursor.getValue();
		}
		else {
			return;
		}
		
		inLength = inString.length();
		
		for (int i=0; i<inLength; i++) {
			thisChar = inString.charAt(i);
			if (Character.isLetterOrDigit(thisChar)) {
				outString = outString.concat(String.valueOf(thisChar));
			}
		}
		
		cursor.last();
		cursor.insertAfter("outputString", outString);
		// --- <<IS-END>> ---

                
	}


    public static final Values startsWith (Values in)
    {
        Values out = in;
		// --- <<IS-START(startsWith)>> ---
		// @sigtype java 3.0
		// [i] field:0:required inputString
		// [i] field:0:required checkParameter
		// [o] field:0:required comparison
		String record = in.getString("inputString");
		String checkValue = in.getString("checkParameter");
		String comparison = "";
		boolean test = false;
		
			try
			{
				test = record.startsWith(checkValue);
				if (test == false) {
					comparison = "false";
				}
				else {
					comparison = "true";
				}
				out.put("comparison", comparison);					
			}
			catch ( Exception e)
			{
				
			}
		
		
		
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void strListToLowerCase (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(strListToLowerCase)>> ---
		// @sigtype java 3.5
		// [i] field:1:required uprStrList
		// [o] field:1:required lwrStrList
		     
		IDataCursor idc = pipeline.getCursor();
		String [] uprStrList = IDataUtil.getStringArray(idc, "uprStrList");
		idc.destroy();
		
		String [] lwrStrList = new String [uprStrList.length];
		for(int i=0; i <uprStrList.length; i++ ){
			lwrStrList[i] = uprStrList[i].toLowerCase();
		}
		
		IDataCursor idc1 = pipeline.getCursor();
		IDataUtil.put(idc1, "lwrStrList", lwrStrList);
		idc1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void strListToUpperCase (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(strListToUpperCase)>> ---
		// @sigtype java 3.5
		// [i] field:1:required lwrStrList
		// [o] field:1:required uprStrList
		IDataCursor idc = pipeline.getCursor();
		String [] lwrStrList = IDataUtil.getStringArray(idc, "lwrStrList");
		idc.destroy();
		
		String [] uprStrList = new String [lwrStrList.length];
		for(int i=0; i <lwrStrList.length; i++ ){
			uprStrList[i] = lwrStrList[i].toUpperCase();
		}
		
		IDataCursor idc1 = pipeline.getCursor();
		IDataUtil.put(idc1, "uprStrList", uprStrList);
		idc1.destroy();		
		// --- <<IS-END>> ---

                
	}



	public static final void stringComparison (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringComparison)>> ---
		// @sigtype java 3.5
		// [i] field:0:required string1
		// [i] field:0:required string2
		// [o] field:0:required same {"true","false"}
		IDataCursor cursor 	= pipeline.getCursor();
		String string1 	= null;
		String string2 	= null;
		
		cursor.last("string1");
		string1 = (String) cursor.getValue();
		
		cursor.last("string2");
		string2 = (String) cursor.getValue();
		
		int equality = string1.compareTo(string2);
		
		if (equality == 0) {  //Same
			cursor.last();
			cursor.insertAfter("same","true");
		}
		else {
			cursor.last();
			cursor.insertAfter("same","false");
		}
		// --- <<IS-END>> ---

                
	}
}

