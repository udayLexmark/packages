package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-05 01:45:21 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class system

{
	// ---( internal utility methods )---

	final static system _instance = new system();

	static system _newInstance() { return new system(); }

	static system _cast(Object o) { return (system)o; }

	// ---( server methods )---




	public static final void setProperty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(setProperty)>> ---
		// @sigtype java 3.5
		// [i] field:0:required property
		// [i] field:0:required value
		IDataCursor cursor = pipeline.getCursor();
		
		String property;
		
		if (cursor.first("property"))
		{
		  property = (String)cursor.getValue();
		  if (cursor.first("value"))
		  {
		    System.setProperty(property, (String)cursor.getValue());
		  }
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

