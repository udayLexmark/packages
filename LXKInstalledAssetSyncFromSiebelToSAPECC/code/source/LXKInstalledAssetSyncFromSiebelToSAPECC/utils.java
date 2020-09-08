package LXKInstalledAssetSyncFromSiebelToSAPECC;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-02-04 22:37:06 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.regex.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void replaceStringValues (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(replaceStringValues)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional inputString
		// [i] record:1:optional checkValues
		// [i] - field:0:required checkValue
		// [i] - field:0:required replace
		// [o] field:0:required outputString
		// [o] field:0:required error
		IDataCursor cursor  = pipeline.getCursor();
		String inputValue =null;
		String replaceValue =null;
		String itemCheckValue = null;
		boolean process =true;
		IData[] checkReplaceValues  = null;
		IDataCursor itemCursor  = null;
		IData checkReplaceValuesItem = null;
		String output = null;
		int size=0;
		
		// Retrieve the input value.
		
		try
		{
		if (cursor.last("inputString")) 
		    {	
			inputValue = (String) cursor.getValue();
		      }
		
		if (inputValue == null)
		   {
		   process=false;
		
		   }
		
		
		if (cursor.last("checkValues"))
		{
			checkReplaceValues = (IData[]) cursor.getValue();
		
		       
		}
		
		else
		
		{
		
		process = false;
		
		}
		
		
		if(process==true)
		{
		   for (int i=0;i<checkReplaceValues.length;i++)
		       {
		       checkReplaceValuesItem = checkReplaceValues[i];
			itemCursor = checkReplaceValuesItem.getCursor();
			if (itemCursor.last("checkValue")) 
			{
				itemCheckValue = (String) itemCursor.getValue();
			}
			else 
			{
				itemCheckValue = null;
			}
		
		          if (itemCursor.last("replace")) 
			{
				replaceValue = (String) itemCursor.getValue();
			}
			else 
			{
				replaceValue = null;
			}
		
		 if(itemCheckValue == null || replaceValue == null)
		  {
		output=inputValue;
		}
		
		else
		{
		Pattern pattern = Pattern.compile(itemCheckValue);
		Matcher matcher = pattern.matcher(inputValue);
		output = matcher.replaceAll(replaceValue); 
		inputValue=output;
		}
		     }//i
		
		   
		}//process
		
		
		if(process == false || output == null)
		{
		output=inputValue;
		}
		
		
		              }//try
		 catch(Exception e)
		{
		cursor.insertAfter("error", e.getMessage());
		cursor.last();
		cursor.destroy();
		}
		
		cursor.last();
		cursor.insertAfter("outputString", output);
		cursor.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

