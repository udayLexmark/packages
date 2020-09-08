package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 04:48:15 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSService;
// --- <<IS-END-IMPORTS>> ---

public final class flow

{
	// ---( internal utility methods )---

	final static flow _instance = new flow();

	static flow _newInstance() { return new flow(); }

	static flow _cast(Object o) { return (flow)o; }

	// ---( server methods )---




	public static final void getServiceName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServiceName)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required serviceName
		// This service will return the calling service's name
		// Use this service to retrieve the name of your current flow service
		
		// NOTE: This service will not work when running in debug/trace mode (through Developer),
		//       it will return: "wm.server.flow:stepFlow"
		
		NSService service = Service.getCallingService();
		if (service != null) {
			IDataCursor pipelineCursor = pipeline.getCursor();
			IDataUtil.put( pipelineCursor, GETSERVICENAME_OUTPUTPARM_SERVICENAME, service.toString() );
			pipelineCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static final String GETSERVICENAME_OUTPUTPARM_SERVICENAME = "serviceName";
	// --- <<IS-END-SHARED>> ---
}

