

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-07-16 04:30:51 EDT
// -----( ON-HOST: dlexrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSService;
import com.wm.lang.ns.NSName;
import com.wm.util.Debug;
import com.wm.app.b2b.server.*;
import com.wm.app.b2b.client.*;
// --- <<IS-END-IMPORTS>> ---

public final class Flow

	extends Service
{
	// ---( internal utility methods )---

	final static Flow _instance = new Flow();

	static Flow _newInstance() { return new Flow(); }

	static Flow _cast(Object o) { return (Flow)o; }

	// ---( server methods )---




	public static final void getCallingServiceName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getCallingServiceName)>> ---
		// @sigtype java 3.5
		// [o] field:0:required serviceName
 String strCallingServiceName;
 try {
 NSService callingService = Service.getCallingService();
 
 if (callingService!=null) 
 strCallingServiceName = callingService.toString(); 
 	 
 else 
	 strCallingServiceName = "No calling Service found";
 
 IDataCursor pipelineCursor = pipeline.getCursor();
 pipelineCursor.insertAfter("serviceName", strCallingServiceName);
 pipelineCursor.destroy();
 
 } // end of try
 catch (Exception  ex) {
	 throw new ServiceException(ex);
 }
		// --- <<IS-END>> ---

                
	}


    public static final Values invokeAndCatchErrors (Values in)
    {
        Values out = in;
		// --- <<IS-START(invokeAndCatchErrors)>> ---
		// @sigtype java 3.0
		// [i] field:0:required serviceToInvoke
		// [i] field:0:optional newThread {"true","false"}
		// [o] field:0:optional invokeError
		// [o] field:0:optional errorMessage
		/****************************************************************************
		Service 	invokeAndCatchErrors()
		
		Input:  	service 		= The service name used to invoke the service
					newThread		= Boolean flag: true if for a threaded process
		
		Returns:	invokeError		= error, if needed
			
		****************************************************************************/
			String serviceToInvoke = in.getString("serviceToInvoke");
			String newThread       = in.getString("newThread");
		
			String user   = "Administrator"; 
			String intfce = "";
			String srv    = "";
		 
			if (newThread == null) {
				newThread = "false";
			}
		
			try {
				if (newThread.equals("false")) {
					out = doInvoke( NSName.create(serviceToInvoke), in);
				}
				else {	
					int index  = serviceToInvoke.indexOf(":");
					int length = serviceToInvoke.length();
					srv    = serviceToInvoke.substring(index + 1, length);
					intfce = serviceToInvoke.substring(0, index);
					srv    = srv.trim();
					intfce = intfce.trim();
					doThreadInvoke(intfce, srv, in);
				}
			}
		    catch(Exception e) {
				out.put("invokeError", e.toString());
				out.put("errorMessage", e.getLocalizedMessage());
			}
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void invokeServiceAndCatchErrors (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invokeServiceAndCatchErrors)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required serviceToInvoke
		// [i] field:0:optional newThread {"true","false"}
		// [o] field:0:optional invokeError
		// [o] field:0:optional errorMessage
		IDataCursor idc = pipeline.getCursor();
		
		String serviceToInvoke = null;
		String newThread = null;
		
		
			if (idc.last("serviceToInvoke")) 
				serviceToInvoke = (String) idc.getValue();
			else
				throw new ServiceException("Missing Service: Please pass the Service to be invoked");
		
			if (idc.last("newThread")) 
				newThread = (String) idc.getValue();
		
			if (newThread == null) 
				newThread = "false";
		
			String intfce = "";
			String srv = "";
		
		
			IData out = pipeline;
		
			IDataFactory iDataFactory = new IDataFactory();
			IData newPipelineIData = iDataFactory.create();
		
			IDataCursor newPipelineCursor = newPipelineIData.getCursor();
			newPipelineCursor.last();
			//newPipelineCursor.insertAfter("NewPipelineIdata", pipeline);
			
			IDataUtil.copy(pipeline,newPipelineIData);
		
		
			//com.wm.util.Debug.log(4,"??? EDIFRAMEWORK ??? Iam in the Invoke and Catch errors. The service is"+serviceToInvoke);
			try
			{
				int index  = serviceToInvoke.indexOf(":");
				int length = serviceToInvoke.length();
				srv = serviceToInvoke.substring(index + 1, length);
				intfce = serviceToInvoke.substring(0, index);
				srv = srv.trim();
				intfce = intfce.trim();
				if (newThread.equals("false")) 
				{ 
					//out = doInvoke(NSName.create(serviceToInvoke), pipeline);
					out = doInvoke(intfce, srv,  pipeline);
				}
				else
				{
					//com.wm.util.Debug.log(4,"??? EDIFRAMEWORK ??? srv is "+srv);
					//com.wm.util.Debug.log(4,"??? EDIFRAMEWORK ??? intfce is "+intfce);
		
					doThreadInvoke(intfce, srv, newPipelineIData, 0);
					//doThreadInvoke(intfce, srv, IDataFactory.create(), 0);
				}
			}
			catch(Exception e) 
			{
				idc.last();
				idc.insertAfter("invokeError", e.toString());
				idc.insertAfter("errorMessage", e.getLocalizedMessage());
				//com.wm.util.Debug.log(4,"??? EDIFRAMEWORK ??? Invoke and Catch Error: "+e.toString()+"; Message: "+e.getLocalizedMessage());
				e.printStackTrace();
			}
		newPipelineCursor.destroy();
		
		idc.destroy();
		// --- <<IS-END>> ---

                
	}


    public static final Values sleep (Values in)
    {
        Values out = in;
		// --- <<IS-START(sleep)>> ---
		// @sigtype java 3.0
		// [i] field:0:required sleepTimeInMilliseconds
		// [o] field:0:optional invokeError
		// [o] field:0:optional errorMessage
		/****************************************************************************
		Service 	sleep()
		
		Input:  	sleepTime 		= The sleep time in milliseconds.
		
		****************************************************************************/
			int sleepTime = in.getInt("sleepTimeInMilliseconds");
		
			try {
				Thread.sleep(sleepTime);
			}
		    catch(Exception e) {
				out.put("invokeError", e.toString());
				out.put("errorMessage", e.getLocalizedMessage());
			}
		// --- <<IS-END>> ---
        return out;
                
	}
}

