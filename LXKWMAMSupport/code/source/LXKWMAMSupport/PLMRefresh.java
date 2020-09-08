package LXKWMAMSupport;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-02-22 06:58:06 EST
// -----( ON-HOST: qashrwmis003.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class PLMRefresh

{
	// ---( internal utility methods )---

	final static PLMRefresh _instance = new PLMRefresh();

	static PLMRefresh _newInstance() { return new PLMRefresh(); }

	static PLMRefresh _cast(Object o) { return (PLMRefresh)o; }

	// ---( server methods )---




	public static final void writeTextDataToExistingFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeTextDataToExistingFile)>> ---
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
					bw = new BufferedWriter(new FileWriter(filename));
					
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
				}
		// --- <<IS-END>> ---

                
	}
}

