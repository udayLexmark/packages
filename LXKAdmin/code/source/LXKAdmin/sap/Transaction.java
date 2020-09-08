package LXKAdmin.sap;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-09 09:49:48 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.net.HttpHeader;
// --- <<IS-END-IMPORTS>> ---

public final class Transaction

{
	// ---( internal utility methods )---

	final static Transaction _instance = new Transaction();

	static Transaction _newInstance() { return new Transaction(); }

	static Transaction _cast(Object o) { return (Transaction)o; }

	// ---( server methods )---




	public static final void setResponse (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setResponse)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required content-type
		// [i] field:0:required filename
		// [i] object:0:required content
		IDataCursor idc = pipeline.getCursor();
		
		String contentType = IDataUtil.getString(idc, "content-type");
		String filename = IDataUtil.getString(idc, "filename");
		byte[] content = (byte[])IDataUtil.get(idc, "content");
		
		HttpHeader hdr = Service.getHttpResponseHeader((Values)pipeline);
		if(hdr != null) {
			hdr.addField("Content-Type", contentType);
			hdr.addField("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		//System.out.println("attachment; filename=\"" + filename + "\"");
		} 
		else{
		   //System.out.println("Http Header is null !!!!!!!!!! ");
		}
		Service.setResponse((Values)pipeline, content);
		
		idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

