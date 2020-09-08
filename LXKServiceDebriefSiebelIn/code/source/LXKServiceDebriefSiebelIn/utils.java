package LXKServiceDebriefSiebelIn;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-04-12 14:30:02 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void stringFormatter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringFormatter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required outString
		/* *************************************************
		This service takes a string and converts it into a format accepted by Siebel 
		Picklists. The first letter of every word in the string should be capital and
		the remained should be small case.
		************************************************** */
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		pipelineCursor.destroy();
		
		
		String outString = ""; 
		
		if(inString != null){
		
			String token = new String();
			String temptoken = new String();
		
			StringTokenizer stknzr = new StringTokenizer(inString, " ", true);
		
			while (stknzr.hasMoreElements()){
				token = stknzr.nextToken();
				if (token.equalsIgnoreCase(" ")){
					outString += " ";
				}else{
		    	    temptoken = token.substring(0,1);
			    	temptoken = temptoken.toUpperCase();
					temptoken += (token.substring(1,token.length())).toLowerCase();
					outString += temptoken;
				}//end of if
			}//end of while
		}//end of if
		
		outString = outString.trim();
		
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outString", outString );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

