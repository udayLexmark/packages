

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.*;
import java.io.*;
import com.wm.app.b2b.server.*;
// --- <<IS-END-IMPORTS>> ---

public final class Files

	extends Service
{
	// ---( internal utility methods )---

	final static Files _instance = new Files();

	static Files _newInstance() { return new Files(); }

	static Files _cast(Object o) { return (Files)o; }

	// ---( server methods )---




	public static final void appendToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [i] field:0:required data
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	filename = IDataUtil.getString( pipelineCursor, "fileName" );
			String	message = IDataUtil.getString( pipelineCursor, "data" );
		pipelineCursor.destroy();
		
		BufferedWriter bw = null;
		
		try 
		{
			bw = new BufferedWriter(new FileWriter(filename, true));
			bw.write(message);
			//bw.newLine();
			bw.flush();
		} 
		catch (IOException ioe) 
		{
			throw new ServiceException(ioe.toString());
		} 
		finally 
		{                       // always close the file
			if (bw != null) 
			try 
			{
				bw.close();
			} 
			catch (IOException ioe2) 
			{
				throw new ServiceException(ioe2.toString());
			}
		} // end try/catch/finally
			
		// --- <<IS-END>> ---

                
	}



	public static final void propertyFiletoRecordStructure (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(propertyFiletoRecordStructure)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional fileName
		// [i] field:0:optional inputString
		// [i] object:0:optional byteArray
		// [o] record:0:required properties
		// [o] field:0:required errorMessage
		IDataCursor cursor 	= pipeline.getCursor();
		String fileName 	= null;
		String inputString 	= null;
		String errorMessage = "";
		byte[] byteArray 	= null;
		Properties properties = new Properties();
		
		cursor.last("fileName");
		fileName = (String) cursor.getValue();
		
		cursor.last("inputString");
		inputString = (String) cursor.getValue();
		
		cursor.last("byteArray");
		byteArray = (byte[]) cursor.getValue();
		
		// Input = File
		if (fileName != null) {
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(fileName);
			}
			catch (Exception e) {
				errorMessage = "Error opening properties file: " + e.toString();
		
			}
		
			try {
				properties.load(fileInputStream);
			}
			catch (Exception e) {
				errorMessage = "Error opening properties input stream: " + e.toString();
			}
		}
		// Input = String
		else if (inputString != null) {
			String stringIn = new String(inputString);
			byte[] bytesIn = stringIn.getBytes();
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytesIn);
			try {
				properties.load(byteArrayInputStream);
			}
			catch (Exception e) {
				errorMessage = "Error opening properties input stream: " + e.toString();
			}
		}
		// Input = Byte Array
		else if (byteArray != null){
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
			try {
				properties.load(byteArrayInputStream);
			}
			catch (Exception e) {
				errorMessage = "Error opening properties input stream: " + e.toString();
			}
		}
		
		Values valuesOut = new Values(properties);
		
		cursor.last();
		cursor.insertAfter("properties",valuesOut);
		
		if ((errorMessage != null) && (errorMessage != "")) {
			cursor.last();
			cursor.insertAfter("errorMessage",errorMessage);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void writeToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fileName
		// [i] field:0:required filePath
		// [i] field:0:required text
		// [i] object:0:required content
		IDataCursor cursor = pipeline.getCursor();
		
		String fileName = null;
		String filePath = "";
		String text;
		InputStream is = null;
		
		if (cursor.first("fileName"))
		{
		    fileName = (String)cursor.getValue();
		}
		if (cursor.first("filePath"))
		{
		   	filePath = (String)cursor.getValue();
			fileName = filePath + fileName;
		}  
		
		try
		{
		    OutputStream os  = new FileOutputStream(fileName);
			Object obj = null;
		    if (cursor.first("content"))
		    {
			  obj = cursor.getValue();
			}
			else if (cursor.first("text"))
			{
		      obj = cursor.getValue();
			}
			else {
				return;
			}
		    if (obj instanceof InputStream)
		    {
		        is = (InputStream)obj;
				byte[] bytes = new byte[1024];
		        int numRead = 0;
		        while ((numRead = is.read(bytes)) >= 0)
		        {
		          os.write(bytes, 0, numRead);
		        }
		        is.close();
		   }
		   else if (obj instanceof byte[])
		   {
		        byte[] arr = (byte[])obj;
		        os.write(arr);
		   }
		   else if (obj instanceof String)
		   {
		        byte[] arr = ((String)obj).getBytes();
		        os.write(arr);
		   }
		   else
		   {
		        byte[] arr = (obj.toString()).getBytes();
		        os.write(arr);
		   }
		   
		   os.flush();
		   os.close();
		}
		catch (IOException ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}
}

