package LXKWMAMSupport;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-02-24 16:40:28 EST
// -----( ON-HOST: dashrsagis01.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.pcbsys.nirvana.client.*;
// --- <<IS-END-IMPORTS>> ---

public final class universalMessaging

{
	// ---( internal utility methods )---

	final static universalMessaging _instance = new universalMessaging();

	static universalMessaging _newInstance() { return new universalMessaging(); }

	static universalMessaging _cast(Object o) { return (universalMessaging)o; }

	// ---( server methods )---




	public static final void ping (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ping)>> ---
		// @sigtype java 3.5
		// [i] field:0:required umHost
		// [o] field:0:required outMessage
		// [o] field:0:required error
		IDataCursor pipelineCursor_get = pipeline.getCursor();
		String umHost = IDataUtil.getString( pipelineCursor_get, "umHost" );
		pipelineCursor_get.destroy();
		String outMessage;
		String error = null;
		nSession session = null;
		outMessage = "***************UM Server : " + umHost + "***************" + "\n";
		try {
			session = connect(umHost);
			disconnect(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			error = e.toString();
		} finally {
			if (session != null) {
				disconnect(session);
			}
		}
		IDataCursor pipelineCursor_put = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_put,"outMessage", outMessage);
		IDataUtil.put(pipelineCursor_put,"error", error);
		pipelineCursor_put.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	// Shared method to create connection with UM
	public static nSession connect(String rnames) throws Exception  
	{
				nSessionAttributes sessionAttributes=new nSessionAttributes(rnames);
				nSession connectionObject = nSessionFactory.create(sessionAttributes);
				connectionObject.init();
				return connectionObject;
	}
	
	// Shared method to disconnect connection with UM
	public static void disconnect(nSession connectionObject)
	{
	            connectionObject.close();
	            connectionObject = null;
	}
	
		
	// --- <<IS-END-SHARED>> ---
}

