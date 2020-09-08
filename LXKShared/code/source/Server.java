

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 07:41:23 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.*;
import java.io.*;
// --- <<IS-END-IMPORTS>> ---

public final class Server

	extends Service
{
	// ---( internal utility methods )---

	final static Server _instance = new Server();

	static Server _newInstance() { return new Server(); }

	static Server _cast(Object o) { return (Server)o; }

	// ---( server methods )---




	public static final void getAllSystemProperties (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getAllSystemProperties)>> ---
		// @sigtype java 3.5
		// [o] record:0:required properties
		/***********************************************
		Retrieves a list of system properties/settings.  These include java settings, as well
		as webMethods server settings.
		Created:  2/20/2002  - Tony Foltz
		************************************************/
		Properties properties = System.getProperties();
		Enumeration propEnum = properties.propertyNames();
		String key = "";
		String value ="";
		
		Values output = new Values();
		
		//Debug.log(0, "\nSystem Properties \n ---------------" + properties.toString());
		while (propEnum.hasMoreElements()) {
			key = (String) propEnum.nextElement();
			value = properties.getProperty(key);
		//	Debug.log(0, key + " = " + value);
			output.put(key, value);
		}
		
		IDataCursor cursor 	= pipeline.getCursor();
		cursor.last();
		cursor.insertAfter("properties",output);
		// --- <<IS-END>> ---

                
	}



	public static final void getSerFunType (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSerFunType)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor cursor=pipeline.getCursor();
		String serverName = checkNull(IDataUtil.getString(cursor, "serverName"));
		String funcType=null; 
		if (serverName.equals("dlxksb2b1e"))
		  {
		 	funcType = "DEVELOPMENT";
		  }
		else
		if (serverName.equals("l2frwmsandbox"))
		  {
		 	funcType = "DEVELOPMENT";
		  }
		else
		if (serverName.equals("l2frwmdev"))
		  {
		 	funcType = "DEVELOPMENT";
		  }
		else
		if (serverName.equals("tlxksb2b1e"))
		  {
		 	funcType = "TEST";
		  }
		else
		if (serverName.equals("l2frwmqua"))
		  {
		 	funcType = "TEST";
		  }
		else
		if (serverName.equals("lxksb2b1e"))
		  {
		 	funcType = "PRODUCTION";
		  }
		else
		if (serverName.equals("lxksb2b3e"))
		  {
		 	funcType = "PRODUCTION";
		  }
		else
		if (serverName.equals("lxksb2b4e"))
		  {
		 	funcType = "PRODUCTION";
		  }
		else
		if (serverName.equals("l2frwmisprd1"))
		  {
		 	funcType = "PRODUCTION";
		  }
		else
		if (serverName.equals("l2frwmisprd2"))
		  {
		 	funcType = "PRODUCTION";
		  }
		else
		funcType = "No Server FunctionalType found";
		
		IDataUtil.put(cursor, "functionalType", funcType);
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}


    public static final Values getServerDomainName_hardcode (Values in)
    {
        Values out = in;
		// --- <<IS-START(getServerDomainName_hardcode)>> ---
		// @sigtype java 3.0
		// [o] field:0:required serverName
		com.wm.app.b2b.server.ServerAPI api = new com.wm.app.b2b.server.ServerAPI();
		String serverName = api.getServerName();
		
		//Debug.log(0, serverName); 
		
		// Parse name (i.e. vipertest.lex.lexmark.com -> vipertest)
		int dotSpot = serverName.indexOf('.');
		
		if (dotSpot == -1) {   // i.e. B2B3
			serverName = serverName + ".lex.lexmark.com";
			if (serverName == "b2bqna") {
				serverName = serverName + ".lex1.lexmark.com";
			}
		}
		
		
		
		out.put("serverName", serverName);
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void getServerInfo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerInfo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required fullServerInfo
		// [o] field:0:required serverDomainName
		// [o] field:0:required serverName
		// [o] field:0:required portNumber
		// [o] field:0:required environmentID
		//Get functional type
		IData 	output = IDataFactory.create();
		try{
			output = Service.doInvoke( "Server", "getServerFunctionalType", null);
		}catch( Exception e){}
		IDataCursor outputCursor = output.getCursor();
			String	functionalType = IDataUtil.getString( outputCursor, "functionalType" );
		outputCursor.destroy();
		
		//get server info
		com.wm.app.b2b.server.ServerAPI api = new com.wm.app.b2b.server.ServerAPI();
		String serverDomainName = api.getServerName();
		int iPortNumber = api.getCurrentPort();
		String serverName = serverDomainName;
		String portNumber = Integer.toString(iPortNumber);
		
		//if PortNumber was not found, return NA
		if (iPortNumber < 0)
			portNumber = "NA";
		
		// Parse name (i.e. vipertest.lex.lexmark.com -> vipertest)
		int dotSpot = serverDomainName.indexOf('.');
		if (dotSpot != -1)
			serverName = serverDomainName.substring(0, dotSpot);
		
		// put output into the pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "fullServerInfo", serverDomainName + ":" + portNumber);
		IDataUtil.put( pipelineCursor, "serverDomainName", serverDomainName );
		IDataUtil.put( pipelineCursor, "serverName", serverName);
		IDataUtil.put( pipelineCursor, "portNumber", portNumber);
		IDataUtil.put( pipelineCursor, "environmentID", functionalType);
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}


    public static final Values getServerName (Values in)
    {
        Values out = in;
		// --- <<IS-START(getServerName)>> ---
		// @sigtype java 3.0
		// [o] field:0:required serverName
		com.wm.app.b2b.server.ServerAPI api = new com.wm.app.b2b.server.ServerAPI();
		String serverName = api.getServerName();
		
		// Parse name (i.e. vipertest.lex.lexmark.com -> vipertest)
		int dotSpot = serverName.indexOf('.');
		
		if (dotSpot != -1) {
			serverName = serverName.substring(0, dotSpot);	
		}
		
		out.put("serverName", serverName);
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void getServerPort (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerPort)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required port
		com.wm.app.b2b.server.ServerAPI api = new com.wm.app.b2b.server.ServerAPI();
		int portNumber = api.getCurrentPort();
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "port", Integer.toString(portNumber));
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getServerRoot (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerRoot)>> ---
		// @sigtype java 3.5
		// [o] field:0:required serverRoot
		/***********************************************
		Retrieves the webMethods server root.
		Created:  8/20/2002  - Tony Foltz
		************************************************/
		
		String serverRoot = System.getProperty("user.dir");
		
		// Set a default if nothing returned
		if ((serverRoot == null) || (serverRoot.equals(""))) {
			serverRoot = "/b2b40";
		}
		
		IDataCursor cursor 	= pipeline.getCursor();
		cursor.last();
		cursor.insertAfter("serverRoot", serverRoot);
		// --- <<IS-END>> ---

                
	}



	public static final void getSystemProperty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSystemProperty)>> ---
		// @sigtype java 3.5
		// [i] field:0:required property
		// [o] field:0:required propertyValue
		/***********************************************
		Retrieves a system property. 
		Created:  8/28/2002  - Tony Foltz
		************************************************/
		IDataCursor cursor 			 = pipeline.getCursor();
		String 		retrieveProperty = "";
		String 		propertyValue    = "";
		
		if (cursor.last("property")) {
			retrieveProperty = (String) cursor.getValue();
			propertyValue = System.getProperty(retrieveProperty);
		}
		else {
			propertyValue = null;
		}
		
		cursor.last();
		cursor.insertAfter("propertyValue",propertyValue);
		// --- <<IS-END>> ---

                
	}



	public static final void nsLookupThisServer (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(nsLookupThisServer)>> ---
		// @sigtype java 3.5
		// [o] field:0:required hostName
		// [o] field:0:required ipAddress
		// [o] field:0:optional error
		/***********************************************
		Retrieves the hostname and IP address of this server by perfoming a UNIX 'nslookup'
		command.
		Created:  2/20/2002  - Tony Foltz
		************************************************/
		
		IDataCursor cursor = pipeline.getCursor();
		String hostname 	= "";
		String nslookupStr 	= "";
		String thisLine 	= "";
		String fullHostName = ""; 
		String ipAddress 	= "";
		
		try {
			//Get the hostname
			Process theProcess = Runtime.getRuntime().exec("hostname");
			InputStream inStream = theProcess.getInputStream();
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));	
			hostname = bufferedReader.readLine();
		
			// Perform nslookup on hostname
			theProcess = Runtime.getRuntime().exec("nslookup " + hostname);
			inStream = theProcess.getInputStream();
		    bufferedReader = new BufferedReader(new InputStreamReader(inStream));	
		
			// Read in command output
			while((thisLine = bufferedReader.readLine()) != null ) {
				nslookupStr = nslookupStr + thisLine + "\n";
			}
		
			int nameIndex = nslookupStr.indexOf("Name:");
			nslookupStr = nslookupStr.substring(nameIndex);
			StringTokenizer tokenizer = new StringTokenizer(nslookupStr, "\n");
			String lineToken = "";
		
			while (tokenizer.hasMoreElements()) {
				lineToken = tokenizer.nextToken();
				if (lineToken.startsWith("Name")) {
					fullHostName = lineToken.substring(lineToken.indexOf(":")+1).trim();
				}
				if (lineToken.startsWith("Address")) {
					ipAddress = lineToken.substring(lineToken.indexOf(":")+1).trim();
				}
			}
			cursor.last();
			cursor.insertAfter("hostName", fullHostName);
			cursor.insertAfter("ipAddress", ipAddress);
		}
		catch (Exception e) {
		//	Debug.log(0, e.toString());
			cursor.last();
			cursor.insertAfter("error", e.toString());
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static String checkNull(String inputString)
	{
		if( inputString == null )
			return "";
		else
			return inputString;
	}
	// --- <<IS-END-SHARED>> ---
}

