package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 04:50:20 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class http

{
	// ---( internal utility methods )---

	final static http _instance = new http();

	static http _newInstance() { return new http(); }

	static http _cast(Object o) { return (http)o; }

	// ---( server methods )---




	public static final void createURL (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createURL)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required protocol
		// [i] field:0:required host
		// [i] field:0:required port
		// [i] field:0:required location
		// [o] field:0:required url
		IDataCursor cursor = pipeline.getCursor();
		
		String protocol = null;
		String host = null;
		int port = -1;
		String location = null;
		
		if (cursor.first("protocol"))
		{
		  protocol = (String)cursor.getValue();
		}
		
		if (cursor.first("host"))
		{
		  host = (String)cursor.getValue();
		}
		
		if (cursor.first("location"))
		{
		  location = (String)cursor.getValue();
		}
		
		if (cursor.first("port"))
		{
		  port = Integer.parseInt((String)cursor.getValue());
		}
		
		IDataUtil.put(cursor, "url", getURL(protocol, host, port, location));
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static String getURL(String protocol, String host, int port, String location)
	{
	  if (protocol == null || host == null || location == null)
	  {
	    return null;
	  }
	
	  if (port < 0)
	  {
	    if ("http".equalsIgnoreCase(protocol))
	    {
	      port = 80;
	    }
	    else
	    {
	      port = 443;
	    }
	  }
	
	  StringBuffer buffer = new StringBuffer();
	  buffer.append(protocol);
	  buffer.append("://");
	  buffer.append(host);
	  buffer.append(":");
	  buffer.append(port);
	  if (!location.startsWith("/"))
	  {
	    buffer.append("/");
	  }
	  buffer.append(location);
	  return buffer.toString();
	}
	// --- <<IS-END-SHARED>> ---
}

