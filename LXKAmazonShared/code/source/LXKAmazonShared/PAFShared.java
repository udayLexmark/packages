package LXKAmazonShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-07-25 13:17:20 EDT
// -----( ON-HOST: dlexrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.security.*;
import java.io.*;
import java.util.zip.CRC32;
import java.util.Formatter;
// --- <<IS-END-IMPORTS>> ---

public final class PAFShared

{
	// ---( internal utility methods )---

	final static PAFShared _instance = new PAFShared();

	static PAFShared _newInstance() { return new PAFShared(); }

	static PAFShared _cast(Object o) { return (PAFShared)o; }

	// ---( server methods )---




	public static final void shaHasKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(shaHasKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inputStr
		// [i] field:0:required algorithmV {"MD5","SHA256","SHA1"}
		// [o] field:0:required outputInt
		// [o] field:0:required outputStr
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inputStr = IDataUtil.getString( pipelineCursor, "inputStr" );
		        String	algorithmV = IDataUtil.getString( pipelineCursor, "algorithmV" );
		        int hint=0;
		        int kint=0;
		        String outStr1="";
		        long hashLong=0;
			String outputInt="";
		        long lv=0x7FFFFFFFFFFFFFFFL;
		        String byteStr="";
		        int lnth=0;
		        
		
		try{
		       MessageDigest digest = MessageDigest.getInstance(algorithmV);
		       byte[] hash = digest.digest(inputStr.getBytes());
		      // byteStr = new String(hash, "UTF-8");
		      byte[] crc = inputStr.getBytes();
		       //StringBuffer hexString = new StringBuffer();
		       StringBuilder sb = new StringBuilder(hash.length*2);
		       Formatter formatter = new Formatter(sb);
		       lnth=hash.length;
		       for(byte b:hash)
		       {
		           formatter.format("%02x", b);
		          // hint=((hint*31)+b) & 0xFFFFFFFF;
		          // System.out.println(b);
		       }
		               outStr1=sb.toString();
		       for(int i=0;i<outStr1.length(); i++)
		       {
		           hint = ((hint*31) + outStr1.charAt(i)) & 0xFFFFFFFF;
		       }
		       		
		      
		   /*    for (int i = 0; i < hash.length; i++) {
		           hint = ((hint*31) + hash[i]) & 0xFFFFFFFF;
		
		        }*/
		    
		//       hint=hint&0x0
		
		        CRC32 crc32 = new CRC32();
		        crc32.update(crc);
		       kint=crc32.getValue();
		        
			hashLong = ((kint << 31) & 0x7FFFFFFFFFFFFFFFL)| hint;
		
		        outputInt=Long.toString(hashLong);
		
		    } catch(Exception ex){
		       throw new ServiceException(ex);
		    }
		
		// pipeline
		
		
		
		IDataUtil.put( pipelineCursor, "outputInt", outStr1 );
		IDataUtil.put( pipelineCursor, "outputStr", hint );
		
		
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}
}

