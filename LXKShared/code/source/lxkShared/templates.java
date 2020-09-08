package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-05 01:45:58 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class templates

{
	// ---( internal utility methods )---

	final static templates _instance = new templates();

	static templates _newInstance() { return new templates(); }

	static templates _cast(Object o) { return (templates)o; }

	// ---( server methods )---




	public static final void javaService (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(javaService)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		String category = null;
		String code = null;
		String action = null;
		String serviceName = "lxkShared.templates:javaTemplate"; //put your actual java service name here
		
		try {
			action = "About to div 100/0";
			//Put your code here
		  }
		catch (Exception ex) {
		    throw new ServiceException (ex);
		}
		finally 
		{
			IDataCursor parentPipelineCursor = pipeline.getCursor();
			IData errorInfo = IDataUtil.getIData( parentPipelineCursor, "errorInfo" );
			IDataCursor errorInfoCursor = errorInfo.getCursor();
			errorInfoCursor.last("serviceName");
			errorInfoCursor.setValue(serviceName);
			//only if action was updated inside the try block, overwrite the 
			//original action that may have been set by the parent
			if (action != null) 
			{	
				errorInfoCursor.last("action");
				errorInfoCursor.setValue(action);
			}
			//only if category was updated inside the try block, overwrite the 
			//original category that may have been set by the parent
			if (category != null) 
			{
				errorInfoCursor.last("code");
				errorInfoCursor.setValue(code);
			}
			//only if code was updated inside the try block, overwrite the 
			//original code that may have been set by the parent
			if (code != null)
			{
				errorInfoCursor.last("category");
				errorInfoCursor.setValue(category);
			}
			errorInfoCursor.destroy();
			parentPipelineCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}
}

