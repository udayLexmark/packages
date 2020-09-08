package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-04 08:02:03 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class log

{
	// ---( internal utility methods )---

	final static log _instance = new log();

	static log _newInstance() { return new log(); }

	static log _cast(Object o) { return (log)o; }

	// ---( server methods )---




	public static final void throwError (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(throwError)>> ---
		// @sigtype java 3.5
		// [i] field:0:required error
		IDataCursor cursor = pipeline.getCursor();
		String error = null;
		
		if (cursor.first("error"))
		{
		  error = (String)cursor.getValue();
		}
		
		cursor.destroy();
		throw new ServiceException(error);
		// --- <<IS-END>> ---

                
	}
}

