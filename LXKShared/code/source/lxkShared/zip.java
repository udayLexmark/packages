package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-12-28 14:12:23 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.Debug;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
// --- <<IS-END-IMPORTS>> ---

public final class zip

{
	// ---( internal utility methods )---

	final static zip _instance = new zip();

	static zip _newInstance() { return new zip(); }

	static zip _cast(Object o) { return (zip)o; }

	// ---( server methods )---




	public static final void extractZipFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(extractZipFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inZipFile
		// [i] field:0:required rootDir
		// [o] field:0:required SuccessFlag
		// pipeline
		// Srinivas Akula
		IDataCursor cursor = pipeline.getCursor();
		
			String inZipFile = null;
			String rootDir = null;
			String SuccessFlag = "False";
			
			// Get Input Variables
			if (cursor.last("inZipFile")) 
			{
				inZipFile = (String) cursor.getValue();
			}
			else 
			{
				throw new ServiceException("Missing input paramter 'inZipFile'.");
			}
		
			if (cursor.last("rootDir")) 
			{
				rootDir = (String) cursor.getValue();
			}
			else 
			{
				throw new ServiceException("Missing input paramter 'rootDir'.");
			}
		
			int inBufSize = 2048;
			   try 
			   {
				   BufferedOutputStream dest = null;
				   BufferedInputStream is = null;
				   ZipEntry entry;
				   ZipFile zipfile = new ZipFile(inZipFile);
				   Enumeration eZip = zipfile.entries();
				   while(eZip.hasMoreElements()) 
				   {
				            entry = (ZipEntry) eZip.nextElement();
				   
				            //since I am assuming that the zip files I will be getting should not have any directory
				            //information - SKIP them
				            if(entry.isDirectory()) 
				            {
				                // Assume directories are stored parents first then children.
				                continue;
				            }
		
				            is = new BufferedInputStream (zipfile.getInputStream(entry));
				            int count;
					            
				            byte data[] = new byte[inBufSize];
					            
				            File out = new File(rootDir,entry.getName()); 
					            
				            FileOutputStream fos = new FileOutputStream(rootDir + File.separator +  out.getName());
				            dest = new BufferedOutputStream(fos, inBufSize);
				            while ((count = is.read(data, 0, inBufSize))!= -1) 
				            {
					    	dest.write(data, 0, count);
				            }
				            dest.flush();
				            dest.close();
				            is.close();
				   }//end while
				   zipfile.close();
				   cursor.insertAfter("SuccessFlag", "True");
			   	} 
			   	catch(Exception e) 
			   	{
					//e.printStackTrace();
					//Debug.log(4,"Zip Error....... " +e.toString());
					cursor.insertAfter("SuccessFlag", "False");
					cursor.insertAfter("ErrorMessage", e.toString());
					//throw new ServiceException("Exception: " + e.toString() );
		
				}
		cursor.destroy();
		
		// pipeline
			
		// --- <<IS-END>> ---

                
	}



	public static final void gZipCompressString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(gZipCompressString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required inBytes
		// [i] field:0:required mode {"decompress","compress"}
		// [o] object:0:required outBytes
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inString = IDataUtil.getString( pipelineCursor, "inString" ); 
		 byte[] inBytes = (byte[]) IDataUtil.get(pipelineCursor, "inBytes");
			
		String	mode = IDataUtil.getString( pipelineCursor, "mode" );
		try{
		if(mode.equals("compress")){
			IDataUtil.put(pipelineCursor, "outBytes", compress(inString));
		} else
			IDataUtil.put(pipelineCursor, "outString", decompress(inBytes));
		}catch(Exception e){
			
		}
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static byte[] compress(final String str) throws IOException {
	    if ((str == null) || (str.length() == 0)) {
	        return null;
	    }
	    ByteArrayOutputStream obj = new ByteArrayOutputStream();
	    GZIPOutputStream gzip = new GZIPOutputStream(obj);
	    gzip.write(str.getBytes("UTF-8"));
	    gzip.close();
	    return obj.toByteArray();
	}
	
	public static String decompress(final byte[] compressed) throws IOException {
	    String outStr = "";
	    if ((compressed == null) || (compressed.length == 0)) {
	        return "";
	    }
	    if (isCompressed(compressed)) {
	        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
	
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            outStr += line;
	        }
	    } else {
	        outStr = new String(compressed);
	    }
	    return outStr;
	}
	public static boolean isCompressed(final byte[] compressed) {
	    return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
	}
	// --- <<IS-END-SHARED>> ---
}

