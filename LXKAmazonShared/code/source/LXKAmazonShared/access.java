package LXKAmazonShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2017-02-27 21:03:14 EST
// -----( ON-HOST: dashrsagis01.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.util.EC2MetadataUtils;
import com.amazonaws.util.EC2MetadataUtils.IAMSecurityCredential;
// --- <<IS-END-IMPORTS>> ---

public final class access

{
	// ---( internal utility methods )---

	final static access _instance = new access();

	static access _newInstance() { return new access(); }

	static access _cast(Object o) { return (access)o; }

	// ---( server methods )---




	public static final void loginUsingSTS (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(loginUsingSTS)>> ---
		// @sigtype java 3.5
		// [i] field:0:required awsProfileName
		// [i] field:0:required roleARN
		// [i] field:0:required roleSessionTimeInSeconds
		// [i] field:0:required roleSessionName
		// [o] object:0:required awsCredentialsObject
		IDataCursor idc = pipeline.getCursor();
		String	roleARN = IDataUtil.getString( idc, "roleARN" );
		String	roleSessionTimeInSeconds = IDataUtil.getString( idc, "roleSessionTimeInSeconds" );
		String	roleSessionName = IDataUtil.getString( idc, "roleSessionName" );
		String awsProfileName = IDataUtil.getString(idc,"awsProfileName");
		
		AWSSecurityTokenServiceClient stsClient =  new AWSSecurityTokenServiceClient(new ProfileCredentialsProvider(awsProfileName));
		
		AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest()
		.withRoleArn(roleARN)
		.withDurationSeconds(Integer.parseInt(roleSessionTimeInSeconds))
		.withRoleSessionName(roleSessionName);
		
		AssumeRoleResult assumeResult = stsClient.assumeRole(assumeRoleRequest);
		
		AWSCredentials awsCredentialsObject = new BasicSessionCredentials
				(
		        assumeResult.getCredentials().getAccessKeyId(),
		        assumeResult.getCredentials().getSecretAccessKey(),
		        assumeResult.getCredentials().getSessionToken()
		        );
		
		//com.wm.util.Debug.log(4,"Access Key "+assumeResult.getCredentials().getAccessKeyId());
		
		IDataUtil.put( idc, "awsCredentialsObject", awsCredentialsObject );
			
		idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

