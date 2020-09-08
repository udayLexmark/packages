package LXKCustomerContact;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2013-06-25 07:47:03 EDT
// -----( ON-HOST: dlexrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void getEntryDN (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getEntryDN)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required ldapSearchResults
		// [o] field:0:required entryDN
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		IData ldapSearchResults = IDataUtil.getIData( pipelineCursor, "ldapSearchResults" );
		
		if (ldapSearchResults != null)
		{
		 IDataCursor ldapSearchResultsCursor = ldapSearchResults.getCursor();
		 if ( ldapSearchResultsCursor.first() )
		 {
			String key = ldapSearchResultsCursor.getKey();
		
			IData uid = IDataUtil.getIData(ldapSearchResultsCursor,ldapSearchResultsCursor.getKey());
			IDataCursor uidCursor = uid.getCursor();
			if(uidCursor.first())
			{
				//pipelineCursor.insertAfter("myKey",uidCursor.getKey());
				pipelineCursor.insertAfter("entryDN",uidCursor.getValue());
			}
			uidCursor.destroy();		
		  }
		 ldapSearchResultsCursor.destroy();
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

