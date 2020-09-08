package LXKAdmin.server;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-09 09:49:57 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class admin

{
	// ---( internal utility methods )---

	final static admin _instance = new admin();

	static admin _newInstance() { return new admin(); }

	static admin _cast(Object o) { return (admin)o; }

	// ---( server methods )---




	public static final void getCurrentUser (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getCurrentUser)>> ---
		// @sigtype java 3.5
		//String cUser = Service.getUser(Service.getSession()).toString();
		String cUser = Service.getUser().toString();
		IDataCursor idc = pipeline.getCursor();
		idc.last();
		idc.insertAfter("currentUser", cUser);
		idc.destroy(); 
		// --- <<IS-END>> ---

                
	}
}

