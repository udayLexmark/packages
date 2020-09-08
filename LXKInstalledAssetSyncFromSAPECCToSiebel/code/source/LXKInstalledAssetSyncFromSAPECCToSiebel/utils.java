package LXKInstalledAssetSyncFromSAPECCToSiebel;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-08-08 12:32:37 EDT
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

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




	public static final void checkStringPattern (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkStringPattern)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required stringPattern
		// [o] field:0:required status
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getString( pipelineCursor, "inString" );
		String stringPattern = IDataUtil.getString( pipelineCursor, "stringPattern" );
		pipelineCursor.destroy();
		
		String status="false";
		
		if (inString.contains(stringPattern))
		{
			status="true";
		}
		
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "status", status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

