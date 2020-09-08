package LXKD365Shared;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONStyle;
import net.minidev.json.parser.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void createAccessRefreshFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createAccessRefreshFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required accessToken
		// [i] field:0:required refreshToken
		// [i] field:0:required filePath
		IDataCursor pipelinecursor=pipeline.getCursor();
		 
		String accessToken=IDataUtil.getString(pipelinecursor, "accessToken");
		String refreshToken=IDataUtil.getString(pipelinecursor, "refreshToken");
		pipelinecursor.destroy();
		String serverRoot = System.getProperty("user.dir"); //get server root
		
		
				JSONObject obj = new JSONObject();
				obj.put("accessToken", accessToken);
				obj.put("refreshToken", refreshToken);
				
				
				try (FileWriter file = new FileWriter(serverRoot+"/packages/LXKD365Shared/config/D365_AccessRefreshToken.json")) {
				
				    file.write(obj.toJSONString());
				    file.flush();
				
				} catch (IOException e) {
				    throw new ServiceException(e.toString()); 
				}
			
		// --- <<IS-END>> ---

                
	}



	public static final void readAccessRefreshToken (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(readAccessRefreshToken)>> ---
		// @sigtype java 3.5
		// [i] field:0:required filePath
		// [o] field:0:required accessToken
		// [o] field:0:required refreshToken
		String serverRoot = System.getProperty("user.dir"); //get server root
		String accessToken=null;
		String refreshToken=null; 
		
		JSONParser parser = new JSONParser();
		
		
		try {
			
		    Object obj = parser.parse(new FileReader(serverRoot+"/packages/LXKD365Shared/config/D365_AccessRefreshToken.json"));
		
		    JSONObject jsonObject = (JSONObject) obj;
		    System.out.println(jsonObject);
		
		    accessToken = (String) jsonObject.get("accessToken");
		    refreshToken = (String) jsonObject.get("refreshToken");
		
		} catch (FileNotFoundException e) {
			throw new ServiceException(e.toString());
		} catch (IOException e) {
			throw new ServiceException(e.toString());
		} catch (ParseException e) {
			throw new ServiceException(e.toString());
		}
		
		IDataCursor pipelineCursor=pipeline.getCursor();
		IDataUtil.put(pipelineCursor, "accessToken", accessToken);
		IDataUtil.put(pipelineCursor, "refreshToken", refreshToken);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

