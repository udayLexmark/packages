package LXKWMAMSupport;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-07-09 11:41:10 EDT
// -----( ON-HOST: dlxksb2b1e.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class NonAtlas

{
	// ---( internal utility methods )---

	final static NonAtlas _instance = new NonAtlas();

	static NonAtlas _newInstance() { return new NonAtlas(); }

	static NonAtlas _cast(Object o) { return (NonAtlas)o; }

	// ---( server methods )---




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

