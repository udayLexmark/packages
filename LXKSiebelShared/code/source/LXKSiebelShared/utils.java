package LXKSiebelShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-10-16 18:10:16 EDT
// -----( ON-HOST: dashrwmis001

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void processSiebelHTTPHeaderLine (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(processSiebelHTTPHeaderLine)>> ---
		// @sigtype java 3.5
		// [i] record:0:required headertemp
		// [i] - record:0:required linestemp
		// [i] - field:0:required status
		// [i] - field:0:required statusMessage
		// [o] record:0:required header
		// [o] - record:0:required lines
		// pipeline
				IDataCursor pipelineCursor = pipeline.getCursor();
				
					// headertemp
					IData	headertemp = IDataUtil.getIData( pipelineCursor, "headertemp" );
					if ( headertemp != null)
					{
						IDataCursor headertempCursor = headertemp.getCursor();
				
							// i.linestemp
							IData	linestemp = IDataUtil.getIData( headertempCursor, "linestemp" );
							if ( linestemp != null)
							{
								IDataCursor linetempCursor = linestemp.getCursor();
								IData	header = IDataFactory.create();
								IDataCursor headerCursor = header.getCursor();
							
								IData	lines = IDataFactory.create();
								IDataCursor linesCursor = lines.getCursor();
								while( linetempCursor.next() )
								{						
									IDataUtil.put( linesCursor, convertFirstCharToUpper(linetempCursor.getKey()), linetempCursor.getValue().toString() );
								}
								IDataUtil.put( headerCursor, "lines", lines );
								IDataUtil.put( pipelineCursor, "header", header );
								IDataUtil.put( headerCursor, "status", IDataUtil.getString( headertempCursor, "status" ) );
								IDataUtil.put( headerCursor, "statusMessage", IDataUtil.getString( headertempCursor, "statusMessage" ) );
								
								linetempCursor.destroy();
								headerCursor.destroy();
							}
						headertempCursor.destroy();
					}
				pipelineCursor.destroy();		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	// Srinivas Akula
	public static String convertFirstCharToUpper(String in)
	{
		String out = Character.toUpperCase(in.charAt(0)) + in.substring(1);
		return out;
	}
	// --- <<IS-END-SHARED>> ---
}

