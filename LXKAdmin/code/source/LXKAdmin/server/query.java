package LXKAdmin.server;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-09 09:50:06 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class query

{
	// ---( internal utility methods )---

	final static query _instance = new query();

	static query _newInstance() { return new query(); }

	static query _cast(Object o) { return (query)o; }

	// ---( server methods )---




	public static final void getNohup (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getNohup)>> ---
		// @sigtype java 3.5
				StringBuffer stringbuffer = new StringBuffer();
				String sf = "bin" + File.separator + "nohup.out";
		        String s1 = "nohup.out file not found.";
				int i = 0; 
				try
		        {
					File file = new File(sf);
		            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
		            String s;
		            while((s = bufferedreader.readLine()) != null) 
		                i++;
		            bufferedreader.close();
		        }
		        catch(Exception exception)
		        {
		            Service.throwError(exception);
		        }
				if (i>0)
				{
					int x = 0;
					int c = 0;
					//Max Size
					int t = 16000;
					if (i<t)
					{
						x = 1;
					}
					else
					{
						x = i - t;
					}
		
				try
		        {
		 			File file2 = new File(sf);
		            BufferedReader bufferedreader2 = new BufferedReader(new FileReader(file2));
		            String s;
		
		            while((s = bufferedreader2.readLine()) != null) 
					{
		                c++;
						if (c>=x)
						stringbuffer.append(s).append("\n");
					}
		            bufferedreader2.close();
		        }
		        catch(Exception exception)
		        {
		            Service.throwError(exception);
		        }
				s1 = stringbuffer.toString();
		
				}
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		if(s1 != null)
			IDataUtil.put( pipelineCursor, "found", "true" );
			else
			IDataUtil.put( pipelineCursor, "found", "false" );
		
		IDataUtil.put( pipelineCursor, "logText", s1 );
		IDataUtil.put( pipelineCursor, "i", ""+i );
		IDataUtil.put( pipelineCursor, "log", "nohup" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getNohupBuffer (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getNohupBuffer)>> ---
		// @sigtype java 3.5
				StringBuffer stringbuffer = new StringBuffer();
				String sf = "bin" + File.separator + "nohup.out";
		        String s1 = "nohup.out file not found.";
				int i = 0; 
				try
		        {
					File file = new File(sf);
		            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
		            String s;
		            while((s = bufferedreader.readLine()) != null) 
		                i++;
		            bufferedreader.close();
		        }
		        catch(Exception exception)
		        {
		            Service.throwError(exception);
		        }
				if (i>0)
				{
					int x = 0;
					int c = 0;
					//Max Size
					int t = 200;
					if (i<t)
					{
						x = 1;
					}
					else
					{
						x = i - t;
					}
		
				try
		        {
		 			File file2 = new File(sf);
		            BufferedReader bufferedreader2 = new BufferedReader(new FileReader(file2));
		            String s;
		
		            while((s = bufferedreader2.readLine()) != null) 
					{
		                c++;
						if (c>=x)
						stringbuffer.append(s).append("\n");
					}
		            bufferedreader2.close();
		        }
		        catch(Exception exception)
		        {
		            Service.throwError(exception);
		        }
				s1 = stringbuffer.toString();
		
				}
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		if(s1 != null)
			IDataUtil.put( pipelineCursor, "found", "true" );
			else
			IDataUtil.put( pipelineCursor, "found", "false" );
		
		IDataUtil.put( pipelineCursor, "logText", s1 );
		IDataUtil.put( pipelineCursor, "i", ""+i );
		IDataUtil.put( pipelineCursor, "log", "nohup" );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

