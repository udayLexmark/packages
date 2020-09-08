package lxkShared.tn;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-05 01:47:20 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.tn.doc.BizDocEnvelope;
import com.wm.app.tn.db.*;
// --- <<IS-END-IMPORTS>> ---

public final class doc

{
	// ---( internal utility methods )---

	final static doc _instance = new doc();

	static doc _newInstance() { return new doc(); }

	static doc _cast(Object o) { return (doc)o; }

	// ---( server methods )---




	public static final void checkUnique (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkUnique)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required checkType {&quot;Document ID only&quot;,&quot;Document ID and sender&quot;,&quot;Document ID, sender and receiver&quot;,&quot;Document ID, sender and document type&quot;}
		// [o] field:0:required unique {&quot;true&quot;,&quot;false&quot;}
		// [o] field:0:required match
		IDataCursor cursor = pipeline.getCursor();
		
		int uniquenessType = 3;
		String checkType = null;
		
		if (!cursor.first("bizdoc"))
		{
		  throw new ServiceException("Missing input 'bizdoc'");
		}
		
		BizDocEnvelope doc = (BizDocEnvelope)cursor.getValue();
		
		if (cursor.first("checkType"))
		{
		  checkType = (String)cursor.getValue();  
		}
		else
		{
		  throw new ServiceException("Missing input 'checkType'");
		}
		
		String nativeID = doc.getDocumentId();
		String otherID = null;
		if("Document ID only".equalsIgnoreCase(checkType))
		{
		   uniquenessType = 0;
		}
		else if("Document ID and sender".equalsIgnoreCase(checkType))
		{
		  uniquenessType = 1;
		}
		else if("Document ID, sender and receiver".equalsIgnoreCase(checkType))
		{
		  uniquenessType = 2;
		  otherID = doc.getReceiverId();
		}
		else if("Document ID, sender and document type".equalsIgnoreCase(checkType))
		{
		  uniquenessType = 3;
		  otherID = doc.getDocType().getId();
		}
		else
		{
		  throw new ServiceException("Invalid value for 'checkType'");
		}
		
		int match = 0;
		
		try
		{
		  match = BizDocStore.checkUnique(uniquenessType, doc.getInternalId(), 
		                                  doc.getDocumentId(), doc.getSenderId(), 
		                                  otherID);
		}
		catch (DatastoreException dse)
		{
		  throw new ServiceException(dse);
		}
		
		IDataUtil.put(cursor, "match", String.valueOf(match));
		if (match > 0)
		{
		  IDataUtil.put(cursor, "unique", "false");
		}
		else
		{
		  IDataUtil.put(cursor, "unique", "true");
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

