package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 04:45:45 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class error

	extends Service
{
	// ---( internal utility methods )---

	final static error _instance = new error();

	static error _newInstance() { return new error(); }

	static error _cast(Object o) { return (error)o; }

	// ---( server methods )---




	public static final void throwServiceException (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(throwServiceException)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required errorMessage
		// pipeline
		IDataHashCursor pipelineCursor = pipeline.getHashCursor();
		pipelineCursor.first( "errorMessage" );
		String	errorMessage = (String) pipelineCursor.getValue();
		pipelineCursor.destroy();
		
		//Service.throwError (errorMessage);
		throw new ServiceException (errorMessage);
		// --- <<IS-END>> ---

                
	}
}

