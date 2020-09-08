package LXKAdmin;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2009-09-18 09:23:30 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import COM.activesw.api.client.*;
// --- <<IS-END-IMPORTS>> ---

public final class Broker

{
	// ---( internal utility methods )---

	final static Broker _instance = new Broker();

	static Broker _newInstance() { return new Broker(); }

	static Broker _cast(Object o) { return (Broker)o; }

	// ---( server methods )---




	public static final void connectBroker (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(connectBroker)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required brokerHost
		// [i] field:0:required brokerName
		// [o] object:0:required brokerInstance
		// [o] field:0:required errorMessage
		IDataCursor pipelineCursor = pipeline.getCursor();
		String brokerHost = IDataUtil.getString(pipelineCursor,"brokerHost");
		String brokerName = IDataUtil.getString(pipelineCursor,"brokerName");
		String clientGroup = "admin";
		String appName = "LXKAdminBrokerClient";
		
		pipelineCursor.destroy();
		
		BrokerAdminClient brokerAdminClient = null;
		String errorMsg = "";
		try {
			brokerAdminClient = new BrokerAdminClient(brokerHost,brokerName,null,clientGroup,appName,null);
		}catch(Exception e){
			errorMsg = e.getMessage();
		}
		
		IDataCursor pipelineCursor1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor1,"brokerInstance",brokerAdminClient);
		IDataUtil.put(pipelineCursor1,"errorMessage",errorMsg);
		// --- <<IS-END>> ---

                
	}



	public static final void getClientInfo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getClientInfo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required brokerHost
		// [i] field:0:required brokerName
		// [i] field:0:required clientName
		// [o] field:0:required errorMessage
		// [o] field:0:required queueLength
		// [o] field:0:required lastQueued
		// [o] field:0:required lastRetrieved
		// [o] field:0:required filter
		IDataCursor pipelineCursor = pipeline.getCursor();
		String brokerHost = IDataUtil.getString(pipelineCursor,"brokerHost");
		String brokerName = IDataUtil.getString(pipelineCursor,"brokerName");
		String clientName = IDataUtil.getString(pipelineCursor,"clientName");
		String clientGroup = "admin";
		String appName = "LXKAdminBrokerClient";
		
		pipelineCursor.destroy();
		
		BrokerAdminClient brokerAdminClient = null;
		BrokerEvent clientInfo = null;
		String errorMsg = "";
		String queueLength ="";
		String lastQueued ="";
		String lastRetrieved="";
		String filterString="";
		BrokerFilterDescriptor[] filterDescriptor  = null;
		BrokerClientQueueBrowser browser = null;
		String clientId = "";
		try {
			brokerAdminClient = new BrokerAdminClient(brokerHost,brokerName,null,clientGroup,"LXKAdminBrokerClient",null);
			clientInfo = brokerAdminClient.getClientStatsById(clientName);
			queueLength = clientInfo.getField("queueLength").value.toString();
			lastQueued = clientInfo.getField("lastEventQueueTime").value.toString();
			lastRetrieved = clientInfo.getField("lastEventRetrieveTime").value.toString();
		
			browser= brokerAdminClient.createClientQueueBrowser(clientName);
			BrokerClientQueueBrowserInfo browserInfo = browser.getBrowserInfo();
		
			BrokerClientQueueBrowserInfo [] queueBrowsers = brokerAdminClient.getClientQueueBrowsers(clientName);
			
			//filterDescriptor=browser.getFilters();
		/*
			if(queueBrowsers != null){
				errorMsg = String.valueOf(queueBrowsers.length);
			}
		*/	
			//filterString = queueBrowsers[0].clientId;
			
		}catch(Exception e){
			errorMsg = "in catch: "+e.getMessage();
		}finally{
		try{
			browser.closeQueueBrowser();
			brokerAdminClient.destroy();
		}catch(Exception e){
			errorMsg = "in finally: "+e.getMessage();
		}
		}
		
		
		IDataCursor pipelineCursor1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor1,"errorMessage",errorMsg);
		IDataUtil.put(pipelineCursor1,"queueLength",queueLength);
		IDataUtil.put(pipelineCursor1,"lastQueued",lastQueued);
		IDataUtil.put(pipelineCursor1,"lastRetrieved",lastRetrieved);
		IDataUtil.put(pipelineCursor1,"filter",filterString);
		// --- <<IS-END>> ---

                
	}
}

