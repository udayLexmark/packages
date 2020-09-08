package LXKWMAMSupport.monitorSAPClient;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-10-18 16:03:23 EDT
// -----( ON-HOST: plexrwmis007.lex.lexmark.com

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




	public static final void checkTriggerStatus (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkTriggerStatus)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required triggerName
		// [o] field:0:required processingState
		// [o] field:0:required retrievalState
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	triggerName = IDataUtil.getString( pipelineCursor, "triggerName" );
		TriggerFacade Trigger=new TriggerFacade(triggerName);
		TriggerFacade.TriggerRunTimeStatus triggerRT = Trigger.getTriggerRunTimeStatus();
		String processingState = triggerRT.getProcessingState();
		String retrievalState = triggerRT.getRetrievalState();
		IDataUtil.put( pipelineCursor, "processingState", processingState );
		IDataUtil.put( pipelineCursor, "retrievalState", retrievalState );
		pipelineCursor.destroy(); 
		// --- <<IS-END>> ---

                
	}
}

