package LXKAmazonShared.S3;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-01-04 14:46:00 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.*;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.text.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void connectToS3Bucket (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(connectToS3Bucket)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required bucketName
		// [i] field:0:required secretKey
		// [i] field:0:required accessKey
		// [i] object:0:required credentials
		// [i] field:0:required flagAuth
		// [o] object:0:required conn
		// [o] field:0:required connFlag
		// [o] object:0:required credentials
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			String	secretKey = IDataUtil.getString( pipelineCursor, "secretKey" );
			String	accessKey = IDataUtil.getString( pipelineCursor, "accessKey" );
			String flagAuth = IDataUtil.getString( pipelineCursor, "flagAuth");
			AWSCredentials credentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialsObject");
			String endPointUrl="https://s3.amazonaws.com";
			AmazonS3 conn = null;
			String connFlag = "False"; 
		
			//AWSCredentials credentials = null;
			try
			{
				if(flagAuth.equalsIgnoreCase("False"))
					credentials = new BasicAWSCredentials(accessKey, secretKey);
				conn = new AmazonS3Client(credentials);
				conn.setEndpoint(endPointUrl);
				connFlag = "True";
			}
			catch(Exception e)
			{
				connFlag="Error";
		                throw new ServiceException(e.toString());
			}
		
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		//Object conn = new Object();
		IDataUtil.put( pipelineCursor, "conn", conn );
		IDataUtil.put( pipelineCursor, "connFlag", connFlag);
		IDataUtil.put(pipelineCursor, "credentials", credentials);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void connectToS3Bucket_1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(connectToS3Bucket_1)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required awsCredentialObject
		// [o] object:0:required conn
		// [o] field:0:required connFlag
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			//String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			//String	secretKey = IDataUtil.getString( pipelineCursor, "secretKey" );
			//String	accessKey = IDataUtil.getString( pipelineCursor, "accessKey" );
		   AWSCredentials credentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialObject");
			String endPointUrl="https://s3.amazonaws.com";
			AmazonS3 conn = null;
			String connFlag = "False"; 
		
			//AWSCredentials credentials = null;
			try
			{
				//credentials = new BasicAWSCredentials(accessKey, secretKey);
				conn = new AmazonS3Client(credentials);
				conn.setEndpoint(endPointUrl);
				connFlag = "True";
			}
			catch(Exception e)
			{
				connFlag="Error";
		                throw new ServiceException(e.toString());
			}
		
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		//Object conn = new Object();
		IDataUtil.put( pipelineCursor, "conn", conn );
		IDataUtil.put( pipelineCursor, "connFlag", connFlag);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void copyS3Objects (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(copyS3Objects)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required filekey
		// [i] field:0:required bucketName
		// [i] field:0:required destfileKey
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			
			String	destfileKey = IDataUtil.getString( pipelineCursor, "destfileKey" );
			String	filekey = IDataUtil.getString( pipelineCursor, "filekey" );
			
			String bucketName = IDataUtil.getString( pipelineCursor, "bucketName");
			
			//ObjectMetadata mobj = new ObjectMetadata();
			//mobj=null;
			
			String status = "False";
			
			try
			{
				CopyObjectRequest copyObjRequest = new CopyObjectRequest(bucketName, filekey, bucketName, destfileKey);
				ObjectMetadata objectMetadata = new ObjectMetadata();
				objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION); 
				copyObjRequest.setNewObjectMetadata(objectMetadata);
				conn.copyObject(copyObjRequest);
				status = "True";
			}
			catch(Exception e)
			{
		               // status=filenames + folder;
				throw new ServiceException(e.toString());
			}
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "status", status);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void deleteObjectFromBucket (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(deleteObjectFromBucket)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required bucketName
		// [i] field:0:required filekey
		// [o] field:0:required status
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			String filekey = IDataUtil.getString( pipelineCursor, "filekey");
			String status = "false";
			try
			{
				conn.deleteObject(bucketName, filekey);
				status = "true";
			}
			catch(Exception e)
			{
		                throw new ServiceException(e.toString());
			}		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "status", status );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getLatestObjectKeyFromS3BucketFolder (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLatestObjectKeyFromS3BucketFolder)>> ---
		// @sigtype java 3.5
		// [i] field:0:required bucketName
		// [i] field:0:required filePrefixString
		// [i] object:0:required conn
		// [o] field:0:required objectKey
		// [o] object:0:required lastModifieddate
		// [o] field:0:required count
		// [o] field:0:required e-message
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName");
		String	filePrefixString = IDataUtil.getString( pipelineCursor, "filePrefixString");
		
		//AWSCredentials	awsCredentialsObject = (AWSCredentials) IDataUtil.get( pipelineCursor, "conn" );	
		AmazonS3 s3 = (AmazonS3) IDataUtil.get( pipelineCursor, "conn");
		
		try {
			
			ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName).withPrefix(filePrefixString);
			ObjectListing objectListing;
			String objectKey=null;
			Date lastModifieddate=null;
			int count=0;
			    
			do {
		      objectListing = s3.listObjects(listObjectsRequest);
		       if (count==0){
		    	   lastModifieddate = objectListing.getObjectSummaries().get(0).getLastModified();
		    	   objectKey=objectListing.getObjectSummaries().get(0).getKey();
		       }
		        for (S3ObjectSummary objectSummary: objectListing.getObjectSummaries()) {
		
		        	if (lastModifieddate.compareTo(objectSummary.getLastModified())>0){	        		
		        		//do nothing		        		
		        	}else{		        		
		        		objectKey=objectSummary.getKey();
		        		lastModifieddate=objectSummary.getLastModified();		        		
		        	}		        	
		        	count++;
		        	}
		        	 
		        listObjectsRequest.setMarker(objectListing.getNextMarker());
		        
				}while(objectListing.isTruncated());
			IDataUtil.put( pipelineCursor, "objectKey", objectKey );
		    IDataUtil.put( pipelineCursor, "lastModifieddate", lastModifieddate );
		    IDataUtil.put( pipelineCursor, "count", count );
		}catch(Exception e){
			IDataUtil.put( pipelineCursor, "e-message", e.getMessage() );
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getObjectFromBucket (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getObjectFromBucket)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required bucketName
		// [i] field:0:required filekey
		// [i] field:0:required filenames
		// [i] field:0:required folder
		// [i] object:0:required conn
		// [i] field:0:required localFile
		// [i] field:0:required versionId
		// [o] field:0:required fileExists
		// [o] field:0:required S3objectContent
		// [o] field:0:required eMessage
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			String	filekey = IDataUtil.getString( pipelineCursor, "filekey" );
			String	filenames = IDataUtil.getString( pipelineCursor, "filenames" );
			String	folder = IDataUtil.getString( pipelineCursor, "folder" );
			String localFile = IDataUtil.getString( pipelineCursor, "localFile");
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			String VersionId = IDataUtil.getString( pipelineCursor, "versionId");
			String	fileExists = "False";
			String fileKey=filekey;
			S3Object sobj = new S3Object();
			ObjectMetadata ombj=null;
			String S3objectContent="";
			String eMessage="";
			try
			{
				if(filenames!="")
				{
					if(folder!="")
						fileKey=folder+"/"+filenames;
					else
						fileKey=filenames;
					
					ombj=conn.getObject(new GetObjectRequest(bucketName, fileKey, VersionId), new File(localFile));
				}
				else
				{
					
					sobj=conn.getObject(new GetObjectRequest(bucketName, fileKey));
					S3ObjectInputStream strm = sobj.getObjectContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(strm));
		    			StringBuilder out = new StringBuilder();
					String line;
				
		    			while ((line = reader.readLine()) != null) {
		       					 out.append(line);
		      			}
					S3objectContent=out.toString();
					
				}
				fileExists="True";
			}
			catch(Exception e)
			{
		               eMessage=e.toString();
				fileExists="False";
			}
		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "fileExists", fileExists );
		IDataUtil.put( pipelineCursor, "S3objectContent", S3objectContent );
		IDataUtil.put( pipelineCursor, "eMessage", eMessage );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void getS3ConnectionObject (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getS3ConnectionObject)>> ---
		// @sigtype java 3.5
		// [i] object:0:required awsCredentialsObject
		// [o] object:0:required s3Conn
		// [o] field:0:required connFlag
		IDataCursor pipelineCursor = pipeline.getCursor();
		AWSCredentials credentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialsObject");
		AmazonS3 connS3 = null;
		String connFlag = "False"; 
			try
		{
			connS3 = new AmazonS3Client(credentials);
				connFlag = "True"; 
		}
		catch(Exception e)
		{
			connFlag="Error";
		            throw new ServiceException(e.toString());
		}
		
			IDataUtil.put( pipelineCursor, "s3Conn", connS3 );
			IDataUtil.put( pipelineCursor, "connFlag", connFlag);
			pipelineCursor.destroy();
		
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void getS3DecompressdFileContentWithAttributes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getS3DecompressdFileContentWithAttributes)>> ---
		// @sigtype java 3.5
		// [i] object:0:required awsCredentialsObj
		// [i] object:0:required S3ConnectionObj
		// [i] field:0:required bucketName
		// [i] field:0:required filekey
		// [i] field:0:required versionId
		// [i] field:0:required contentFlag {"stream","string"}
		// [i] field:1:required metaDataAttributeName
		// [o] field:0:required decompressedString
		// [o] field:2:required metaDataAttributeTable
		// [o] field:0:required fileExists
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
		String	filekey = IDataUtil.getString( pipelineCursor, "filekey" );
		AWSCredentials credentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialsObj");
		AmazonS3 amazonS3ConnObj = (AmazonS3) IDataUtil.get( pipelineCursor, "S3ConnectionObj" );
		String versionId = IDataUtil.getString( pipelineCursor, "versionId");
		String contentFlag = IDataUtil.getString( pipelineCursor, "contentFlag");
		String[] metaDataAttributeNames = IDataUtil.getStringArray( pipelineCursor, "metaDataAttributeName" );
		
		String	fileExists = "False";
		S3Object s3Obj = null;
		ObjectMetadata ombj=null;
		String s3ObjContent="";
		String eMessage="";
		String unzippedString=null;
		 if(amazonS3ConnObj == null){
			 if (credentials !=null){
				 amazonS3ConnObj=    new AmazonS3Client(credentials);
			 } else 
				 throw new ServiceException("either of awsCredentialsObj or  amazonS3ConnObj has to be passed");
			    
		 } 
		// if("string".equalsIgnoreCase(loadAs))
		
		try{ 
			if(versionId!=null){
			 s3Obj = amazonS3ConnObj.getObject(new GetObjectRequest(bucketName, filekey,versionId));
			} else{
			  s3Obj = amazonS3ConnObj.getObject(new GetObjectRequest(bucketName, filekey));
			}
			
			InputStream s3ObjectData = s3Obj.getObjectContent();
			
			/*if(metaDataAttributeNames.length>0){
				status = "five";
				//Debug.log(4,"Content-Type: "  + object.getObjectMetadata().getContentType());
				//pipelineCursor.insertAfter("pigeon_processed_timestamp",s3Obj.getObjectMetadata().getUserMetaDataOf("pigeon_processed_timestamp"));
				}*/
			
			 unzippedString = unGunZipFileToString(s3ObjectData);
					//pipelineCursor.insertAfter("decompressedString", unzippedString);
			//pipelineCursor.insertAfter("status", status);
		}
		catch(Exception e)
		{
			fileExists="False";
			//e.printStackTrace();
			//throw new ServiceException("Exception in mail"+e.toString());
		}
		IDataUtil.put(pipelineCursor, "decompressedString", unzippedString);
		IDataUtil.put(pipelineCursor, "fileExists", fileExists);
			
			pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void isBucketExists (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isBucketExists)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required bucketName
		// [o] field:0:required bucketExists
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			boolean bucketExists = false;
			try
			{
				bucketExists=conn.doesBucketExist(bucketName);
			}
			catch(Exception e)
			{
		                throw new ServiceException(e.toString());
			}		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "bucketExists", bucketExists );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void listS3Objects (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(listS3Objects)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required bucketName
		// [i] field:0:required listAllFileAfterDate
		// [i] field:0:required folders
		// [i] field:0:required partOffileNameToMatch
		// [o] field:0:required status
		// [o] field:1:required fileKeyList
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			
			
			
			String bucketName = IDataUtil.getString( pipelineCursor, "bucketName");
			String inpDate = IDataUtil.getString(pipelineCursor, "listAllFileAfterDate");
			String folders = IDataUtil.getString(pipelineCursor, "folders");
			String partOffileNameToMatch = IDataUtil.getString(pipelineCursor, "partOffileNameToMatch");
			String foldSeq = "/"+folders+"/";
			//ObjectMetadata mobj = new ObjectMetadata();
			//mobj=null;
			
			String status = "False";
			String[]	fileKeyList = new String[1000];
			 int i=0;
			
			try
			{
				ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
				.withBucketName(bucketName)
				.withPrefix(folders);
				//.withDelimiter("/");
		        //.withPrefix(folder);
		        
				//ListObjectsRequest listObjectReq = listObjectsRequest.withDelimiter("/");
			
		       
		    ObjectListing objectListing; 
		   
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	Date date1 = sdf.parse(inpDate);
		        objectListing = conn.listObjects(listObjectsRequest);
		        for (S3ObjectSummary objectSummary : 
		        	objectListing.getObjectSummaries()) {
		            System.out.println(" - " + objectSummary.getKey() + "  " +
		                    "(size = " + objectSummary.getSize() + 
		                    ")");
		            Date date2 = objectSummary.getLastModified();
		            if(date1.compareTo(date2)<0){
		         if((objectSummary.getKey()).contains(partOffileNameToMatch))
		         {
		            	fileKeyList[i]=objectSummary.getKey();
		            	i=i+1;
		           }
		           }
		        }
		        listObjectsRequest.setMarker(objectListing.getNextMarker());
		    
				status = "True";
			}
			catch(Exception e)
			{
		               // status=filenames + folder;
				throw new ServiceException(e.toString());
			}
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "status", status);
		pipelineCursor.destroy();
		
		
		// pipeline
		
		//String[]	fileKeyList = new String[1];
		//String fileKeyList=Integer.toString(i);
		IDataUtil.put( pipelineCursor, "fileKeyList", fileKeyList );
		pipelineCursor.destroy();
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void putS3GZIPObject (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(putS3GZIPObject)>> ---
		// @sigtype java 3.5
		// [i] field:0:required bucketName
		// [i] object:0:required awsCredentialsObj
		// [i] object:0:required S3ConnectionObj
		// [i] field:0:required s3ContentStr
		// [i] field:0:required objectKey
		// [i] field:0:required pigeon_processed_timestamp
		// [o] field:0:required status
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
		String	s3ContentStr = IDataUtil.getString( pipelineCursor, "s3ContentStr" );
		String	objectKey = IDataUtil.getString( pipelineCursor, "objectKey" );
		AWSCredentials awsCredentialsObj = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialsObj");
		AmazonS3 amazonS3ConnObj = (AmazonS3) IDataUtil.get( pipelineCursor, "S3ConnectionObj" );
			String status;
		
			 if(amazonS3ConnObj == null){
				 if (awsCredentialsObj !=null){
					 amazonS3ConnObj=    new AmazonS3Client(awsCredentialsObj);
				 } else 
					 throw new ServiceException("either of awsCredentialsObj or  amazonS3ConnObj has to be passed");
				    
			 } 
			
		PutObjectRequest request;
		try 
		{
			
			ObjectMetadata objectMetadata = new ObjectMetadata();
			//objectMetadata.addUserMetadata("pigeon_processed_timestamp",pigeon_processed_timestamp);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gos = new GZIPOutputStream(baos);
			gos.write(s3ContentStr.getBytes("UTF-8"));
			gos.close();
			baos.close();
			
			byte[] bites = baos.toByteArray();
			
			request = new PutObjectRequest(bucketName, objectKey,new ByteArrayInputStream(bites),objectMetadata);
			objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);     
			request.setMetadata(objectMetadata);
		
			objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);     
			request.setMetadata(objectMetadata);
			amazonS3ConnObj.putObject(request);
			status="success";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//status=e1.getMessage().toString();
			throw new ServiceException(e.toString());
		}
		IDataUtil.put(pipelineCursor, "status", status);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void putToS3Bucket (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(putToS3Bucket)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required filenames
		// [i] field:0:required filekey
		// [i] object:0:required contentStream
		// [i] field:0:required folder
		// [i] object:0:required mobj
		// [i] field:0:required bucketName
		// [i] field:0:required encryptionFlag {"True","False"}
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			ObjectMetadata mobj = (ObjectMetadata) IDataUtil.get( pipelineCursor, "mobj");
			String	filenames = IDataUtil.getString( pipelineCursor, "filenames" );
			String	filekey = IDataUtil.getString( pipelineCursor, "filekey" );
			String folder = IDataUtil.getString( pipelineCursor, "folder");
			String bucketName = IDataUtil.getString( pipelineCursor, "bucketName");
			String encryptionFlag = IDataUtil.getString( pipelineCursor, "encryptionFlag");
			InputStream contentStream = (InputStream) IDataUtil.get( pipelineCursor, "contentStream" );
			 //  SecretKey secretKey = generateSecretKey();
			   
		        //SSECustomerKey sseKey = new SSECustomerKey(secretKey);
			//ObjectMetadata mobj = new ObjectMetadata();
			//mobj=null;
			
			String status = "False";
			String srResp="";
			String fileKey=filekey;
			try
			{
				//KeyGenerator generator = KeyGenerator.getInstance("AES");
		       // generator.init(256, new SecureRandom());
		       // SecretKey secretKy = generator.generateKey();
		        if(encryptionFlag==null || encryptionFlag.isEmpty() || encryptionFlag=="")
		        	encryptionFlag="False";
				if(filenames!="")
				{
		
					if(folder!="")
					{		
						if((filekey!="") && (filekey!=null)){
						  
						  fileKey=folder+"/"+filekey;
						  
					   }else{
						fileKey = folder+"/"+filenames;
					   }
						PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, new File(filenames));
						if(encryptionFlag.equals("True"))
						{
							ObjectMetadata objectMetadata = new ObjectMetadata();
						
						
							objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
						     
							putRequest.setMetadata(objectMetadata);
						}
						
						
						PutObjectResult response = conn.putObject(putRequest);
						//status="in proper";
						
						
					}
					else
					{
						fileKey = filenames;
						PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, new File(filenames));
						
						if(encryptionFlag.equals("True"))
						{
							ObjectMetadata objectMetadata = new ObjectMetadata();
						
							objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
						     
							putRequest.setMetadata(objectMetadata);
						}
						
						
						PutObjectResult response = conn.putObject(putRequest);
						
						GetObjectMetadataRequest request2 = 
				                new GetObjectMetadataRequest(bucketName, fileKey);
				         
				ObjectMetadata metadata = conn.getObjectMetadata(request2);
				srResp=response.getServerSideEncryption();
					}
				}
				else
				{
		
					PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, contentStream, mobj);
					
					if(encryptionFlag.equals("True"))
					{
						ObjectMetadata objectMetadata = new ObjectMetadata();
					
					
						objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
					     
						putRequest.setMetadata(objectMetadata);
					}
					
					
					PutObjectResult response = conn.putObject(putRequest);
					//status="after";
				}
				status = "True";
				
			}
			catch(Exception e)
			{
		               // status=filenames + folder;
				throw new ServiceException(e.toString());
			}
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "status", status);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void putToS3Bucket_1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(putToS3Bucket_1)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required conn
		// [i] field:0:required filenames
		// [i] field:0:required filekey
		// [i] object:0:required contentStream
		// [i] field:0:required folder
		// [i] object:0:required mobj
		// [i] field:0:required bucketName
		// [i] field:0:required encryptionFlag {"True","False"}
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			AmazonS3 conn = (AmazonS3) IDataUtil.get( pipelineCursor, "conn" );
			ObjectMetadata mobj = (ObjectMetadata) IDataUtil.get( pipelineCursor, "mobj");
			String	filenames = IDataUtil.getString( pipelineCursor, "filenames" );
			String	filekey = IDataUtil.getString( pipelineCursor, "filekey" );
			String folder = IDataUtil.getString( pipelineCursor, "folder");
			String bucketName = IDataUtil.getString( pipelineCursor, "bucketName");
			String encryptionFlag = IDataUtil.getString( pipelineCursor, "encryptionFlag");
			InputStream contentStream = (InputStream) IDataUtil.get( pipelineCursor, "contentStream" );
			 //  SecretKey secretKey = generateSecretKey();
			   
		        //SSECustomerKey sseKey = new SSECustomerKey(secretKey);
			//ObjectMetadata mobj = new ObjectMetadata();
			//mobj=null;
			
			String status = "False";
			String srResp="";
			String fileKey=filekey;
			try
			{
				//KeyGenerator generator = KeyGenerator.getInstance("AES");
		       // generator.init(256, new SecureRandom());
		       // SecretKey secretKy = generator.generateKey();
		        if(encryptionFlag==null || encryptionFlag.isEmpty() || encryptionFlag=="")
		        	encryptionFlag="False";
				if(filenames!="")
				{
		
					if(folder!="")
					{				
						fileKey = folder+"/"+filenames;
						PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, new File(filenames));
						if(encryptionFlag.equals("True"))
						{
							ObjectMetadata objectMetadata = new ObjectMetadata();
						
						
							objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
						     
							putRequest.setMetadata(objectMetadata);
						}
						
						
						PutObjectResult response = conn.putObject(putRequest);
						//status="in proper";
						
						
					}
					else
					{
						fileKey = filenames;
						PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, new File(filenames));
						
						if(encryptionFlag.equals("True"))
						{
							ObjectMetadata objectMetadata = new ObjectMetadata();
						
							objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
						     
							putRequest.setMetadata(objectMetadata);
						}
						
						
						PutObjectResult response = conn.putObject(putRequest);
						
						GetObjectMetadataRequest request2 = 
				                new GetObjectMetadataRequest(bucketName, fileKey);
				         
				ObjectMetadata metadata = conn.getObjectMetadata(request2);
				srResp=response.getServerSideEncryption();
					}
				}
				else
				{
		
					PutObjectRequest putRequest = new PutObjectRequest(bucketName, fileKey, contentStream, mobj);
					
					if(encryptionFlag.equals("True"))
					{
						ObjectMetadata objectMetadata = new ObjectMetadata();
					
					
						objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
					     
						putRequest.setMetadata(objectMetadata);
					}
					
					
					PutObjectResult response = conn.putObject(putRequest);
					//status="after";
				}
				status = "True";
				
			}
			catch(Exception e)
			{
		               // status=filenames + folder;
				throw new ServiceException(e.toString());
			}
		
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "status", status);
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void transferManager (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(transferManager)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required secretKey
		// [i] field:0:required accessKey
		// [i] field:0:required fileName
		// [i] field:0:required bucketName
		// [i] field:0:required folder
		// [i] field:0:required encryptionFlag
		// [i] object:0:required credentials
		// [i] field:0:required stsAuth
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	secretKey = IDataUtil.getString( pipelineCursor, "secretKey" );
			String	accessKey = IDataUtil.getString( pipelineCursor, "accessKey" );
			String	fileName = IDataUtil.getString( pipelineCursor, "fileName" );
			String folder=IDataUtil.getString(pipelineCursor, "folder");
			String	bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
			String encryptionFlag = IDataUtil.getString( pipelineCursor, "encryptionFlag");
			AWSCredentials credentials = (AWSCredentials) IDataUtil.get( pipelineCursor, "credentials" );
			String stsAuth = IDataUtil.getString(pipelineCursor, "stsAuth");
			TransferManager tx=null;
			Upload myUpload = null;
			String status="False";
			String filekey=folder+"/"+fileName;
		
			//AWSCredentials credentials = null;
			try
			{
				if(stsAuth=="False")
					credentials = new BasicAWSCredentials(accessKey, secretKey);
				tx = new TransferManager(credentials);
				PutObjectRequest putRequest = new PutObjectRequest(bucketName, filekey, new File(fileName));
				if(encryptionFlag=="True")
				{
					ObjectMetadata objectMetadata = new ObjectMetadata();
				
				
					objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
				     
					putRequest.setMetadata(objectMetadata);
				}
				myUpload = tx.upload(putRequest);
				myUpload.waitForCompletion();
				tx.shutdownNow();
				status="True";
			}
			catch(Exception e)
			{
				status=e.getLocalizedMessage();
				//throw new ServiceException(e.getMessage());
			
			}
		
		// pipeline
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "status", status );
		
		pipelineCursor.destroy();
		
		// pipeline
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static String unGunZipFileToString(InputStream is) throws ServiceException
	{
		GZIPInputStream gZIPInputStream;
		String decompressedString = null;
		try 
		{
			gZIPInputStream = new GZIPInputStream(is);
			decompressedString = new Scanner(gZIPInputStream,"UTF-8").useDelimiter("\\A").next();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new ServiceException("Error processing the gZIP stream .."+e.toString());
		}
		return decompressedString;
	}
	
	public static GZIPInputStream unGunZipFileToStream(InputStream is) throws ServiceException
	{
		GZIPInputStream gZIPInputStream;
		String decompressedString = null;
		try 
		{
			gZIPInputStream = new GZIPInputStream(is);
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new ServiceException("Error processing the gZIP stream .."+e.toString());
		}
		return gZIPInputStream;
	}
	// --- <<IS-END-SHARED>> ---
}

