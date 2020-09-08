package LXKWMAMSupport;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-01-29 06:38:20 EST
// -----( ON-HOST: dlexrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class admin

{
	// ---( internal utility methods )---

	final static admin _instance = new admin();

	static admin _newInstance() { return new admin(); }

	static admin _cast(Object o) { return (admin)o; }

	// ---( server methods )---




	public static final void ErrorString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ErrorString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required InString
		// [o] field:0:required KeyWord
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	InString = IDataUtil.getString( pipelineCursor, "InString" );
		
		
		try
		{
		String KeyWord = " ";
		
		int i = InString.indexOf("invalid number");
		int j=  InString.indexOf("Match Error");
		int k = InString.indexOf("Cleanse Error");
		int l = InString.indexOf("Trillium");
		 
		 
		if(i>=0)
		{KeyWord = "invalid number";
		}
		else if(j>=0)
		{KeyWord = "Match Error";
		}
		else if(k>=0)
		{KeyWord = "Cleanse Error";
		}
		else if(l>=0)
		{KeyWord = "Trillium";
		}
		
		
		pipelineCursor.destroy();
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "KeyWord", KeyWord );
		pipelineCursor_1.destroy();
		
		}
		
		catch (Exception e)
		{}
		// --- <<IS-END>> ---

                
	}



	public static final void appendNewlineToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendNewlineToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inStr = IDataUtil.getString( pipelineCursor, "inString" );
		
		char [] data = {'\n'};
		String newLine = new String(data);
		String outStr = inStr + newLine;
		
		IDataUtil.put( pipelineCursor, "outString", outStr );
		pipelineCursor.destroy();
			  
		// --- <<IS-END>> ---

                
	}



	public static final void writeToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [i] field:0:required data
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	filename = IDataUtil.getString( pipelineCursor, "fileName" );
			String	message = IDataUtil.getString( pipelineCursor, "data" );
		pipelineCursor.destroy();
		
		BufferedWriter bw = null;
		
		try 
		{
			bw = new BufferedWriter(new FileWriter(filename, true));
			
			bw.write(message);
			bw.newLine();
			bw.flush();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		} 
		finally 
		{                       // always close the file
			if (bw != null) 
			try 
			{
				bw.close();
			} 
			catch (IOException ioe2) 
			{
				// just ignore it
			}
		} // end try/catch/finally
		// --- <<IS-END>> ---

                
	}
}

