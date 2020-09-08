package LXKRedShiftShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-11-20 17:01:32 UTC
// -----( ON-HOST: ip-10-146-24-49.ec2.internal

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.util.EC2MetadataUtils;
import com.amazonaws.util.EC2MetadataUtils.IAMSecurityCredential;
import com.wm.util.Debug;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void buildCopyCommand (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(buildCopyCommand)>> ---
		// @sigtype java 3.5
		// [i] field:0:required akey
		// [i] field:0:required skey
		// [i] field:0:required token
		// [i] field:0:required tableName
		// [i] field:0:required sourceKeyPrefix
		// [i] field:0:optional format
		// [i] field:0:optional delimeter
		// [i] field:0:optional timeFormat
		// [i] field:0:optional dateFormat
		// [i] field:0:optional compressionType
		// [i] field:0:optional optionalParameters
		// [o] field:0:required copyCommand
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		//	String bucketName = IDataUtil.getString( pipelineCursor, "bucketName" );
		String sourceKeyPrefix = IDataUtil.getString( pipelineCursor, "sourceKeyPrefix" );
		String tableName=IDataUtil.getString( pipelineCursor, "tableName" );
		String format=IDataUtil.getString( pipelineCursor, "format" );
		String delimeter=IDataUtil.getString( pipelineCursor, "delimeter" );
		String timeFormat=IDataUtil.getString( pipelineCursor, "timeFormat" );
		String dateFormat=IDataUtil.getString( pipelineCursor, "dateFormat" );
		String compressionType=IDataUtil.getString( pipelineCursor, "compressionType" );
		String optionalParameters=IDataUtil.getString( pipelineCursor, "optionalParameters" );
		String akey=IDataUtil.getString( pipelineCursor, "akey" );
		String skey=IDataUtil.getString( pipelineCursor, "skey" );
		String token=IDataUtil.getString( pipelineCursor, "token" );
			
		String copyCommand="";
		
		copyCommand="copy "+tableName+" from '"+sourceKeyPrefix+"' credentials 'aws_access_key_id="+akey+";aws_secret_access_key="+skey+";token="+token+"'";
		
		if(format!=null){
			copyCommand=copyCommand+" "+format;
		}
		if(delimeter!=null){
			copyCommand=copyCommand+" DELIMITER "+delimeter;
		}
		if(timeFormat!=null){
			copyCommand=copyCommand+" TIMEFORMAT "+timeFormat;
		}
		if(dateFormat!=null){
			copyCommand=copyCommand+" DATEFORMAT "+dateFormat;
		}
		if(compressionType!=null){
			copyCommand=copyCommand+" "+compressionType;
		}
		if(optionalParameters!=null){
			copyCommand=copyCommand+" "+optionalParameters;
		}
		IDataUtil.put( pipelineCursor, "copyCommand", copyCommand );
		// --- <<IS-END>> ---

                
	}
}

