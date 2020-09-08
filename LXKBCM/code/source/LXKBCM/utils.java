package LXKBCM;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-09-14 14:43:31 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.text.*;
import com.wm.util.Debug;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void createStrFromStrList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createStrFromStrList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required inList
		// [o] field:0:required outStr
		// Srinivas Akula - to read the string array into a comma separated string for SQL inclause
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String[] inList = IDataUtil.getStringArray( pipelineCursor, "inList" );
			if(inList != null)
			{
			String outStr = "";
			StringBuilder arTostr = new StringBuilder();
			for(int i=0; i<inList.length; i++)
			{
				inList[i] = "'"+inList[i].trim()+"'";
				//inList[i] = "'"+inList[i]+"'";
				if(i !=0)
				{
					arTostr.append(",");
					arTostr.append(inList[i]);
				}
				else
				{
					arTostr.append(inList[i]);
				}
			}
			pipelineCursor.insertAfter("outStr",arTostr.toString());
			}
		
		pipelineCursor.destroy();
		
		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//private static final String zeroes = "0000000000";   
	// --- <<IS-END-SHARED>> ---
}

