

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 06:46:48 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import recordToNVP;
import java.util.*;
import com.wm.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class Record

	extends Service
{
	// ---( internal utility methods )---

	final static Record _instance = new Record();

	static Record _newInstance() { return new Record(); }

	static Record _cast(Object o) { return (Record)o; }

	// ---( server methods )---




	public static final void NVPtoRecordStructure (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(NVPtoRecordStructure)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional inputString
		// [i] field:0:required fieldDelimiter
		// [i] field:0:required keyValueSeparator
		// [o] record:0:required nameValuePairs
		// [o] field:0:required errorMessage
		IDataCursor cursor 	= pipeline.getCursor();
		String inputString 	= null;
		String fieldDelimiter = null;
		String keyValueSeparator = null;
		String errorMessage = ""; 
		
		 if (cursor.last("inputString")) {
			inputString = (String) cursor.getValue();
		}
		
		cursor.last("fieldDelimiter");
		fieldDelimiter = (String) cursor.getValue();
		
		cursor.last("keyValueSeparator");
		keyValueSeparator = (String) cursor.getValue();
		
		if ((inputString == null) || (inputString == "")) {
			errorMessage = "'inputString' was null";
			cursor.last();
			cursor.insertAfter("errorMessage",errorMessage);
			return;
		}
		if ((fieldDelimiter == null) || (fieldDelimiter == "")) {
			Debug.log(0, "fieldDelimiter was null");
			fieldDelimiter="\n";
		}
		
		if ((keyValueSeparator == null) || (keyValueSeparator == "")) {
			Debug.log(0, "keyValueSeparator was null");
			keyValueSeparator="=";
		}
		
		
		Values valuesOut = new Values();
		int delimiterIndex = 0;
		String name = "";
		String value = "";
		
		int fromIndex = 0;
		int indexPtr = 0;
		int delimiterLength = fieldDelimiter.length();
		int keyValueSeparatorLength = keyValueSeparator.length();
		String thisField = "";
		
		//indexPtr = inputString.indexOf(fieldDelimiter, fromIndex);
		boolean done = false;
		//while (indexPtr >= 0) {
		while (!done) {
			if (indexPtr == inputString.length()-1) {
				done = true;
			}
			else {
			    indexPtr = inputString.indexOf(fieldDelimiter, fromIndex);
				if (indexPtr < 0) {
					indexPtr = inputString.length();
					done = true;
				}
				thisField = inputString.substring(fromIndex, indexPtr);	
				fromIndex = indexPtr + delimiterLength;
		
				delimiterIndex = thisField.indexOf(keyValueSeparator);
				if (delimiterIndex > 0) {
					name = thisField.substring(0,delimiterIndex);
					value = thisField.substring(delimiterIndex+keyValueSeparatorLength, thisField.length());
				}
				else {
					name = thisField.substring(0,thisField.length());
					value = "";
				}
				valuesOut.put(name, value);
			}
		}
		
		cursor.last();
		cursor.insertAfter("nameValuePairs",valuesOut);
		
		if ((errorMessage != null) && (errorMessage != "")) {
			cursor.last();
			cursor.insertAfter("errorMessage",errorMessage);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void nvpRecordToNVPString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(nvpRecordToNVPString)>> ---
		// @sigtype java 3.5
		// [i] record:0:required nameValuePairs
		// [i] field:0:required fieldDelimiter
		// [i] field:0:required keyValueSeparator
		// [o] field:0:required nvpOutputString
		// [o] field:0:required errorMessage
		IDataCursor cursor 		 = pipeline.getCursor();
		IDataCursor nvpCursor 	 = null;
		IData nameValuePairs 	 = null;
		String fieldDelimiter 	 = null;
		String keyValueSeparator = null;
		String errorMessage 	 = "";
		String name         	 = "";
		String value			 = "";
		String outputString 	 = ""; 
		
		
		cursor.last("nameValuePairs");
		nameValuePairs    = (IData) cursor.getValue();
		
		cursor.last("fieldDelimiter");
		fieldDelimiter    = (String) cursor.getValue();
		
		cursor.last("keyValueSeparator");
		keyValueSeparator = (String) cursor.getValue();
		
		if (nameValuePairs == null) {
			Debug.log(0, "nameValuePairs was null");
		}
		
		nvpCursor 	 = nameValuePairs.getCursor();
		nvpCursor.first();
		
		name  		 = nvpCursor.getKey();
		value 		 = (String) nvpCursor.getValue();
		outputString = outputString + name + keyValueSeparator + value;
		
		while (nvpCursor.next()) {
			outputString = outputString + fieldDelimiter;
			name  		 = nvpCursor.getKey();
			value 		 = (String) nvpCursor.getValue();
			outputString = outputString + name + keyValueSeparator + value;
		}
		
		cursor.last();
		cursor.insertAfter("nvpOutputString",outputString);
		// --- <<IS-END>> ---

                
	}



	public static final void recordToNVP (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(recordToNVP)>> ---
		// @sigtype java 3.5
		// [i] record:0:required inRecord
		IDataCursor cursor = pipeline.getCursor();
		Object inObject = null;
		Class inClass = null;
		IData inRecord = null;
		IData returnRecord = null;
		IDataCursor returnCursor = null; 
		String key = "";
		String value = "";
		
		if (cursor.last("inRecord")) { 
			try {
				inRecord = (IData) cursor.getValue();
				recordToNVP recordToNVP = new recordToNVP();
				returnRecord = recordToNVP.parseObject(inRecord, "");
			}
			catch (Exception e) {
				Debug.log(0, "Error reading inRecord:" + e.toString());
			}
		}
		else {
			Debug.log(0, "inRecord was null");
		}
		
		// Output String Vector
		/*
		returnCursor = returnRecord.getCursor();
		while(returnCursor.next()) {
				key = returnCursor.getKey();
				value = (String) returnCursor.getValue();
				Debug.log(0, key + " = " + value);
		}
		*/
		
		cursor.last();
		cursor.insertAfter("nvpRecord", returnRecord);
		// --- <<IS-END>> ---

                
	}



	public static final void removeNULLFrom1DRecord (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeNULLFrom1DRecord)>> ---
		// @sigtype java 3.5
		// [i] record:0:required inputRecord
		// [o] record:0:required outputRecord
		// [o] field:0:required error
		IDataCursor cursor = pipeline.getCursor();
		IDataCursor lineCursor = null;
		IData inputRecord = null;
		String errorString = "";
		String thisValue = "";
		
		if (cursor.last("inputRecord")) {
			inputRecord = (IData) cursor.getValue();
		}
		else {
			errorString = "Error retrieving inputRecord: missing";
			cursor.last();
			cursor.insertAfter("error", errorString);
		//	ServiceException newServiceException = new ServiceException(errorString);
		//	throw(newServiceException);
			return;
		}
		
		lineCursor = inputRecord.getCursor();
		
		while (lineCursor.next()) {
			thisValue = (String) lineCursor.getValue();
			if (thisValue == null) {
				lineCursor.setValue("");
			}
		}
		
		cursor.last();
		cursor.insertAfter("outputRecord", inputRecord);
		// --- <<IS-END>> ---

                
	}
}

