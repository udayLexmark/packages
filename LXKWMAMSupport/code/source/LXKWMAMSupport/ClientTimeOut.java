package LXKWMAMSupport;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-12-27 04:09:20 EST
// -----( ON-HOST: lxkswmis3.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import COM.activesw.api.client.BrokerClient;
// --- <<IS-END-IMPORTS>> ---

public final class ClientTimeOut

{
	// ---( internal utility methods )---

	final static ClientTimeOut _instance = new ClientTimeOut();

	static ClientTimeOut _newInstance() { return new ClientTimeOut(); }

	static ClientTimeOut _cast(Object o) { return (ClientTimeOut)o; }

	// ---( server methods )---




	public static final void ModifyClientTimeout (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ModifyClientTimeout)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		BrokerClient.setDefaultClientTimeout(180000); // sets the timeout to 180s.
		// --- <<IS-END>> ---

                
	}
}

