package LXKWMAMSupport.serverMonitor;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-09-24 01:15:06 EDT
// -----( ON-HOST: tlxkswmis2.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.*;
import com.wm.app.tn.profile.ID.*;
import com.wm.app.b2b.server.dispatcher.trigger.*;
import com.wm.app.b2b.server.dispatcher.trigger.TriggerFacade.*;
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



	public static final void fetchTriggerlist (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(fetchTriggerlist)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:1:required triggerNames
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[] triggerNames = TriggerManagementUtil.getTriggerList();
		IDataUtil.put( pipelineCursor, "triggerNames", triggerNames );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

