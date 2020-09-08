package LXKMaterialFullFileFromMDGToAWSS3;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.zip.GZIPOutputStream;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void gzipFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(gzipFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filePathAndName
		// [i] field:0:required content
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	filePathAndName = IDataUtil.getString( pipelineCursor, "filePathAndName" );
			String content = IDataUtil.getString(pipelineCursor, "content");
			String status="false";
			BufferedWriter out, ot;
			GZIPOutputStream gStream;
			FileOutputStream fstream;
		        //String[] fileSplit = filePathAndName.split(".");
			//String fileName = filePathAndName+"."+"txt";
			//String gzfilePathName = filePathAndName+"."+"gz";
			byte[] buffer = new byte[100000];  
		
		        try {   
		        	File file = new File(filePathAndName);
		        	fstream = new FileOutputStream( file );
		  			  gStream = new GZIPOutputStream(fstream);
		  			  ot = new BufferedWriter(new OutputStreamWriter(gStream, "UTF-8"));
		                
		  			  ot.write(content);
		  			  ot.flush();
		  			  ot.close();
		  			  
		
		  			  status="true";
		
		             System.out.println("The file was compressed successfully!");  
		
		    
		
		         } catch (Exception ex) {  
		
		             throw new ServiceException(ex.getMessage()) ;
		
		         }  
		
		
		
		// pipeline
		
		
		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "status", status );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

