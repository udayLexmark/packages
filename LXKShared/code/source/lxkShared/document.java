package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 04:41:09 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class document

{
	// ---( internal utility methods )---

	final static document _instance = new document();

	static document _newInstance() { return new document(); }

	static document _cast(Object o) { return (document)o; }

	// ---( server methods )---




	public static final void copyDocument (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(copyDocument)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required inputDocument
		// [o] record:0:required documentCopy
		IDataCursor cursor = pipeline.getCursor();
		IData inputDoc       = null;
		IData docCopy		 = null;
		
		try 
		{
			if (cursor.last("inputDocument")) 
			{	
				inputDoc = (IData) cursor.getValue();
			}
		
			if (inputDoc != null) 
			{
				docCopy = IDataFactory.create();
				docCopy = IDataUtil.deepClone(inputDoc);
			}
		}
		catch (Exception e)
		{
			throw(new ServiceException(e.toString()));
		}
		
		
		cursor.last();
		cursor.insertAfter("documentCopy", docCopy);
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

