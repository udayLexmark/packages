package LXKWMAMSupport.brokerMonitor;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-07-21 05:36:47 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.*;
import com.wm.app.tn.profile.ID.*;
import com.wm.app.b2b.server.dispatcher.trigger.*;
import COM.activesw.api.client.*;
import com.wm.data.IDataUtil;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void BrokerCheck (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(BrokerCheck)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required broker_host
		// [o] field:0:required usedSpace
		// [o] field:0:required totalSpace
		IDataCursor idc = pipeline.getCursor();
		String broker_host = IDataUtil.getString(idc,"broker_host");
		BrokerEvent e;
		BrokerServerClient c;
		try {
		/* Create a Broker Server client */
		c = new BrokerServerClient(broker_host, null);
		/* Get the BrokerEvent containing the storage statistics */
		e = c.getStorageStats();
		/* get the runtime storage information stored in session struct */
		BrokerEvent[] sessions = e.getStructSeqFieldAsEvents("sessions", 0, -1);
		String space=sessions[1].toString();
		IDataUtil.put(idc,"space",space);
		BrokerEvent p=new BrokerEvent(sessions[1]); 
		/* get runtime storage value in use */
		long totalspace=p.getLongField("current_kbytes_reserved");
		long usedspace=p.getLongField("current_kbytes_inuse");
		String usedSpace=String.valueOf(usedspace);
		String totalSpace=String.valueOf(totalspace);
		IDataUtil.put(idc,"usedSpace",usedSpace);
		IDataUtil.put(idc,"totalSpace",totalSpace);
		
		}
		 catch (BrokerException ex) {
		System.out.println("Error getting usage statistics\n"+ex);
		return;
		}
		idc.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

