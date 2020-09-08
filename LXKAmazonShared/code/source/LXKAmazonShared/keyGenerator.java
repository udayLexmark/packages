package LXKAmazonShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2014-07-15 17:14:34 EDT
// -----( ON-HOST: dlexrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.lang.*;
import java.nio.*;
// --- <<IS-END-IMPORTS>> ---

public final class keyGenerator

{
	// ---( internal utility methods )---

	final static keyGenerator _instance = new keyGenerator();

	static keyGenerator _newInstance() { return new keyGenerator(); }

	static keyGenerator _cast(Object o) { return (keyGenerator)o; }

	// ---( server methods )---




	public static final void generateUniqueKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(generateUniqueKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required skeyNumb
		
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		        Cipher encryptCipher;   
		        Cipher decryptCipher;
			byte[] dataToEncrypt;
		        long hint=0;
		String result = "";
		        try {   
		   KeyGenerator keygenerator = KeyGenerator.getInstance("DES");   
		   SecretKey secretKey = keygenerator.generateKey();  
		  
		   encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");   
		   encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);   
		   dataToEncrypt = encryptCipher.doFinal(inputString.getBytes("utf-8")); 
		   //result=dataToEncrypt.toString();
		  // hint = Integer.parseInt(result);
		   hint=ByteBuffer.wrap(dataToEncrypt).getLong();
		  // hint=BigInteger(dataToEncrypt).intValue;
		    //result=dataToEncrypt+"";
		   //hint=Integer.parseInt(result);
		   // hint=hint+128;
		   //char[] numbers = dataToEncrypt.toCharArray();
		
		   //for(int i=dataToEncrypt.length;i==0;i--){
		    //    if(numbers[i]=='1')result+=(numbers.length-i+1)*2;
		    //}
		
		   
		   
		   //decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");   
		   //decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);   
		   //decryptData(encryptedData);   
		  
		  } 
		  catch(Exception e)
		  {
		    e.printStackTrace();
		  }
		
		// pipeline
		//IDataCursor pipelineCursor = pipeline.getCursor();
		IDataUtil.put( pipelineCursor, "skeyNumb", hint );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

