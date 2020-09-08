package LXKAmazonShared.SQS;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-07-14 07:27:12 EDT
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.sns.*;
import com.amazonaws.services.sns.model.transform.*;
import com.amazonaws.services.sns.util.*;
import com.amazonaws.services.sns.model.*;
import com.amazonaws.services.sqs.buffered.*;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.services.sqs.model.transform.*;
import com.amazonaws.services.sqs.internal.*;
import com.amazonaws.services.sqs.*;
import com.amazonaws.auth.*;
import org.joda.time.*;
import java.io.File;
import java.io.IOException;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void getSQSConnectionObject (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSQSConnectionObject)>> ---
		// @sigtype java 3.5
		// [i] object:0:required awsCredentialsObject
		// [o] object:0:required connSQS
		// [o] field:0:required connFlag
		IDataCursor pipelineCursor = pipeline.getCursor();
		AWSCredentials awscredentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentialsObject");
		AmazonSQS connSQS = null;
		String connFlag = "false";
			try
		{
				connSQS =  new AmazonSQSClient(awscredentials);
				connFlag = "true";
		}
			catch(Exception e)
			{
				connFlag="Error";
			            throw new ServiceException(e.toString());
			}
			
				IDataUtil.put( pipelineCursor, "connSQS", connSQS );
				IDataUtil.put( pipelineCursor, "connFlag", connFlag);
				pipelineCursor.destroy();		
		// --- <<IS-END>> ---

                
	}



	public static final void putMessageToSQS (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(putMessageToSQS)>> ---
		// @sigtype java 3.5
		// [i] field:0:required connSQS
		// [i] field:0:required queueName
		// [i] field:0:required jsonMessage
		// [o] field:0:required messageStatus
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	queueName = IDataUtil.getString( pipelineCursor, "queueName" );
		AmazonSQS sqsClient = (AmazonSQS) IDataUtil.get(pipelineCursor, "connSQS");
		String jsonMessage = IDataUtil.getString(pipelineCursor, "jsonMessage");
		String messageStatus="False";
		try
		{
			String quote="\"";
			String comma=",";
						String sqsMessage=jsonMessage;
						GetQueueUrlRequest qURL = new GetQueueUrlRequest(queueName);
						String myQURL = sqsClient.getQueueUrl(qURL).getQueueUrl();
			
					messageStatus="befoateQueueRequest";
					  CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
			messageStatus="beforecreateQuee";
			String queueUrl=sqsClient.createQueue(createQueueRequest).getQueueUrl();
				messageStatus="beforecreateURLReq";
		     GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
		 	messageStatus="beforesendMessage";
		    SendMessageResult messageResult =  sqsClient.sendMessage(new SendMessageRequest(queueUrl,sqsMessage));
			messageStatus="afterSEndMessage"; 
		
			//messageStatus="True"; 
			
			}
		catch(Exception e)
		{ 
			messageStatus="False";
			throw new ServiceException(e.getMessage());
		}
		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "messageStatus", messageStatus );
		pipelineCursor.destroy();
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void putSQSMessageInQueue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(putSQSMessageInQueue)>> ---
		// @sigtype java 3.5
		// [i] field:0:required queueName
		// [i] field:0:required accessKey
		// [i] field:0:required secretKey
		// [i] field:0:required jsonMessage
		// [i] object:0:required awsCredentials
		// [i] field:0:required flagAuth
		// [o] field:0:required messageStatus
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	queueName = IDataUtil.getString( pipelineCursor, "queueName" );
			String	accessKey = IDataUtil.getString( pipelineCursor, "accessKey" );
			String	secretKey = IDataUtil.getString( pipelineCursor, "secretKey" );
			String jsonMessage = IDataUtil.getString(pipelineCursor, "jsonMessage");
			String flagAuth = IDataUtil.getString(pipelineCursor, "flagAuth");
			AWSCredentials awsCredentials = (AWSCredentials) IDataUtil.get(pipelineCursor, "awsCredentials");
			String messageStatus="False";
			try
			{
				
				
				if(flagAuth.equalsIgnoreCase("False"))
					awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
				
				
				AmazonSQS sqsClient = new AmazonSQSClient(awsCredentials);
				
			GetQueueUrlRequest qURL = new GetQueueUrlRequest(queueName);
				String myQURL = sqsClient.getQueueUrl(qURL).getQueueUrl();
				   
				String sqsMessage=jsonMessage;
				SendMessageRequest sqsMsgReq = new SendMessageRequest(myQURL, sqsMessage);
		SendMessageResult sqsMsgResult = sqsClient.sendMessage(sqsMsgReq);
			   
		messageStatus="True";  
			}
			catch(Exception e)
			{ 
				messageStatus="False";
				throw new ServiceException(e.getMessage());
			}
		
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "messageStatus", messageStatus );
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

