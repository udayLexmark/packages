package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 04:43:51 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class encryption

{
	// ---( internal utility methods )---

	final static encryption _instance = new encryption();

	static encryption _newInstance() { return new encryption(); }

	static encryption _cast(Object o) { return (encryption)o; }

	// ---( server methods )---




	public static final void decryptDataCBC (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(decryptDataCBC)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required DecodeBytes
		// [i] object:0:required KeyBytes
		// [i] object:0:required IVBytes
		// [o] field:0:required DecryptedString
		// SriniVas Akula
		// Decrypt the bytes using javax.crypto and in Cipher-block chaining (CBC) mode.
		IDataCursor idc = pipeline.getCursor();
			
			String DecryptedString = null;
		
			byte[] EncryptionStringBytes = null;
		
			idc.first("DecodeBytes");
				byte[] DecodeBytes = (byte[])idc.getValue();
			if(DecodeBytes.length==0)
				throw new ServiceException("The Decoded bytes cannot be empty!");
		
			idc.first("KeyBytes");
				byte[] KeyBytes = (byte[])idc.getValue();
			if(KeyBytes == null || KeyBytes.length == 0)
				throw new ServiceException("Empty Encrypt KeyBytes");
			idc.first("IVBytes");
				byte[] IVBytes = (byte[])idc.getValue();
			if(IVBytes == null || IVBytes.length == 0)
				throw new ServiceException("Empty InitializationVector Bytes");
		
			//Debug.log(4,"The EncodeEncString (Object) is ... "+new String(DecodeBytes));
			
			/*	
			String	EncryptKey = IDataUtil.getString( idc, "EncryptKey" );
			if(EncryptKey == null || EncryptKey.trim().length() == 0)
				throw new ServiceException("Empty Encrypt Key");
		
			String	InitializationVector = IDataUtil.getString( idc, "InitializationVector" );
			if(InitializationVector == null || InitializationVector.trim().length() == 0)
				throw new ServiceException("Empty InitializationVector");
			*/
		
			try
			{
				/*
				// Create an array to hold the Encrypt Key
				byte[] encryptKey = null;
		
				// Convert the EncryptKey in HEX characters into a ByteArray
				char[] HexKeyArray = EncryptKey.toCharArray();
				encryptKey = hexToBytes(HexKeyArray);
				*/
				// Create a DESede key spec from the key
		      		DESedeKeySpec spec = new DESedeKeySpec(KeyBytes);
		
				// Get the secret key factor for generating DESede keys
		      		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		
				// Generate a DESede SecretKey object
		      		SecretKey theKey = keyFactory.generateSecret(spec);
		
				// Create a DESede Cipher
		      		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
				
				/*
				// Create an initialization vector (necessary for CBC mode)
				byte[] ivBytes = null;
		
				// Convert the EncryptKey in HEX characters into a ByteArray
				char[] HexIVArray = InitializationVector.toCharArray();
				ivBytes = hexToBytes(HexIVArray);
				*/
			
				// Initialize IvParameterSpec
				IvParameterSpec IvParameters = new IvParameterSpec(IVBytes);
		
				// Initialize the cipher and put it in decrypt mode
		      		cipher.init(Cipher.DECRYPT_MODE, theKey, IvParameters);
		
				// Decrypt the data
		      		byte[] plaintextbytes = cipher.doFinal(DecodeBytes);
				IDataUtil.put( idc, "DecryptedString", new String(plaintextbytes) );
			}	
			catch(Exception de)
			{
				throw new ServiceException("Unable to perform the Decryption. The error message is: "+de);
			}
		
		idc.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void encryptDataCBC (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(encryptDataCBC)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required PlainText
		// [i] object:0:required KeyBytes
		// [i] object:0:required IVBytes
		// [o] object:0:required EncryptBytes
		// SriniVas Akula
		// Encrypt the PlainText using javax.crypto and in Cipher-block chaining (CBC) mode.
		IDataCursor idc = pipeline.getCursor();
			
			byte[] EncryptBytes = null; // Initialize EncryptBytes
		
			idc.first("KeyBytes");
				byte[] KeyBytes = (byte[])idc.getValue();
			if(KeyBytes == null || KeyBytes.length == 0)
				throw new ServiceException("Empty Encrypt KeyBytes");
			idc.first("IVBytes");
				byte[] IVBytes = (byte[])idc.getValue();
			if(IVBytes == null || IVBytes.length == 0)
				throw new ServiceException("Empty InitializationVector Bytes");
			/*
			String	EncryptKey = IDataUtil.getString( idc, "EncryptKey" );
			if(EncryptKey == null || EncryptKey.trim().length() == 0)
				throw new ServiceException("Empty Encrypt Key");
		
			String	InitializationVector = IDataUtil.getString( idc, "InitializationVector" );
			if(InitializationVector == null || InitializationVector.trim().length() == 0)
				throw new ServiceException("Empty InitializationVector");
			*/
			String	PlainText = IDataUtil.getString( idc, "PlainText" );
			if(PlainText == null || PlainText.trim().length() == 0)
				throw new ServiceException("Empty Input String: Please have the Plaintext to be encrypted");
			
			try
			{
				/*
				// Create an array to hold the Encrypt Key
				byte[] encryptKey = null;
		
				// Convert the EncryptKey in HEX characters into a ByteArray
				char[] HexKeyArray = EncryptKey.toCharArray();
				encryptKey = hexToBytes(HexKeyArray);
				*/
				// Create a DESede key spec from the key
		      		DESedeKeySpec spec = new DESedeKeySpec(KeyBytes);
		
				// Get the secret key factor for generating DESede keys
		      		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		
				// Generate a DESede SecretKey object
		      		SecretKey theKey = keyFactory.generateSecret(spec);
		
				// Create a DESede Cipher
		      		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
				
				/*
				// Create an initialization vector (necessary for CBC mode)
				byte[] ivBytes = null;
				
				// Convert the EncryptKey in HEX characters into a ByteArray
				char[] HexIVArray = InitializationVector.toCharArray();
				ivBytes = hexToBytes(HexIVArray);
				*/
		
				// Initialize IvParameterSpec
				IvParameterSpec IvParameters = new IvParameterSpec(IVBytes);
			
				// Initialize the cipher and put it into encrypt mode
		     		cipher.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);
		
				// Encrypt the data
				EncryptBytes = cipher.doFinal(PlainText.getBytes());
				//com.wm.util.Debug.log(4,"The encrypted string is:  "+new String(EncryptBytes));
				IDataUtil.put( idc, "EncryptBytes", (Object)EncryptBytes );
			}	
			catch(Exception ee)
			{
				throw new ServiceException("Unable to perform the Encryption. The error message is: "+ee);
			}
		
		
		
		idc.destroy();
		// --- <<IS-END>> ---

                
	}
}

