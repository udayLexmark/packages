package lxkShared.io;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 05:05:47 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.lang.SecurityException;
import java.util.Properties;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void closeFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables 
		BufferedWriter fileWriter = null;
		IDataCursor idcPipeline = pipeline.getCursor();
					
		//Output Variables
		String successFlag = "false";
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			successFlag = "false";	
		
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);
		
			//Always destroy cursurs that you created
			idcPipeline.destroy();	
			
			throw new ServiceException("Error executing lxkshared.io.utils:closeFileWriter: Required parameter 'fileWriter' missing.");
		}
		
		// Try to flush the fileWriter object.  Handle the exception if it fails.
		try			
		{
			fileWriter.close();
			successFlag = "true";						
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
			//Print the exception out to standard output
		  throw new ServiceException("Error executing lxkshared.io.utils:closeFileWriter:" + e.toString());	
		}
		
			//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);
		
		//Always destroy cursors that you created
		idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void flushFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(flushFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables 
		BufferedWriter fileWriter = null;
		IDataCursor idcPipeline = pipeline.getCursor();
					
		//Output Variables 
		String successFlag = "false";
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			successFlag = "false";	
		
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);
		
			//Always destroy cursurs that you created
			idcPipeline.destroy();	
		
			throw new ServiceException("Error executing lxkshared.io.utils:flushFileWriter: Required parameter 'fileWriter' missing.");
		}
		
		// Try to flush the fileWriter object.  Handle the exception if it fails.
		try			
		{
			fileWriter.flush();
			successFlag = "true";						
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		
			//Print the exception out to standard output
			throw new ServiceException("Error executing lxkshared.io.utils:flushFileWriter:" + e.toString());	
		}
		
		//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void openFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(openFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filename
		// [i] field:0:required overwriteFlag {&quot;overwrite&quot;,&quot;append&quot;}
		// [o] object:0:required fileWriter
		// [o] field:0:required successFlag
			//define input variables 
		IDataCursor idcPipeline = pipeline.getCursor();
		String strFilename = null;
		String strOverwriteFlag = null;
		
		//Output Variables 
		String successFlag = "false";
		BufferedWriter fileWriter = null;
		
		// Check to see if the filename object is in the pipeline
		if (idcPipeline.first("filename"))
		{
				//get the filename out of the pipeline						
				strFilename = (String)idcPipeline.getValue();	
		
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			successFlag="false";
				
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);	
		
			//Always destroy cursors that you created
			idcPipeline.destroy();	
		
			throw new ServiceException("Error executing lxkshared.io.utils:openFileWriter: required parameter 'filename' missing.");
		}
		
		
		// Check to see if the overwriteFlag object is in the pipeline
		if (idcPipeline.first("overwriteFlag"))	
		{
				//get the overwriteFlag out of the pipeline						
				strOverwriteFlag = (String)idcPipeline.getValue();	 
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			successFlag="false";
				
			//insert the successFlag into the pipeline
			idcPipeline.insertAfter("successFlag", successFlag);	
		
			//Always destroy cursors that you created
			idcPipeline.destroy();	
		
			throw new ServiceException("Error executing sample.io.utils.fileWriter:openFileWriter: required parameter 'overwriteFlag' missing.");
		}
		
		// Try to create a BufferedWriter object.  Handle the exception if it fails.
		try
		{
				// Check to see if the overwriteFlag was set to overwrite
				if (strOverwriteFlag.equals("overwrite")) 			
				{
					//Create a new BufferedWriter object that will overwrite the old file
					fileWriter = new BufferedWriter(new FileWriter(strFilename, false));
				}
				// Check to see if the overwriteFlag was set to append
				else
				{
				//Create a new BufferedWriter object that will append to the old file
				fileWriter = new BufferedWriter(new FileWriter(strFilename, true));
				}
			//Set the success flag because the service was successful
				successFlag = "true";
		
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		
			//Print the exception out to standard output
			throw new ServiceException("Error executing sample.io.utils.fileWriter:openFileWriter:" + e.toString());	
		}
		
		//insert the fileWriter into the pipeline
		idcPipeline.insertAfter("fileWriter", fileWriter);	
		
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);	
		
		//Always destroy cursors that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void writeFileWriter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeFileWriter)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [i] field:0:required fileContent
		// [o] object:0:required fileWriter
		// [o] field:0:required successFlag
		//define input variables 
		IDataCursor idcPipeline = pipeline.getCursor();
		String 	strFileContent = null;
		
		//Output Variables 
		String successFlag = "false";
		BufferedWriter fileWriter = null;
		
		// Check to see if the fileWriter object is in the pipeline
		if (idcPipeline.first("fileWriter"))
		{	
			//get the BufferedWriter stream out of the pipeline					
			fileWriter = (BufferedWriter) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			throw new ServiceException("Error:  fileWriter object is not in the pipeline!");
		}
		// Check to see if the fileContent object is in the pipeline
		if (idcPipeline.first("fileContent"))	
		{
				//get the fileContent out of the pipeline						
				strFileContent = (String) idcPipeline.getValue();
		}
		//if it is not in the pipeline, then handle the error
		else
		{
			throw new ServiceException("Error:  fileContent object is not in the pipeline!!");
		}
		
		// Try to write to the BufferedWriter object.  Handle the exception if it fails.
		try
		{
			fileWriter.write(strFileContent);
		
			//Set the success flag because the service was successful
			successFlag = "true";
		}
		catch (Exception e)
		{
			//Set the success flag because the service failed
			successFlag = "false";
		}
		
		//remove any other successFlags from pipline
		if(idcPipeline.first("successFlag"))
		{
				idcPipeline.delete();
		}
		//insert the successFlag into the pipeline
		idcPipeline.insertAfter("successFlag", successFlag);	
		
		//Always destroy cursurs that you created
		idcPipeline.destroy();	
		// --- <<IS-END>> ---

                
	}
}

