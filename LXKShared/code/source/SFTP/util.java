package SFTP;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-12-07 05:11:57 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.jcraft.jsch.*;
import java.io.*;
import java.util.*;
import com.jcraft.jsch.ChannelSftp.LsEntry.*;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void cd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(cd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required path
		// [o] field:0:required status
		// pipeline 
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	path = IDataUtil.getString( pipelineCursor, "path" );
		pipelineCursor.destroy();
		String status = null;
		try {
		    c.cd(path);
		    status = "OK";
		}
		catch (SftpException e) {
		
		    throw new ServiceException("Failed to change directory to: "+path+ ", "+e.toString());
		   // status = e.toString();
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void get (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(get)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required localFile
		// [i] field:0:required remoteFile
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	localFile = IDataUtil.getString( pipelineCursor, "localFile" );
			String	remoteFile = IDataUtil.getString( pipelineCursor, "remoteFile" );
			
		pipelineCursor.destroy();
		
		String status = null;
		try {
			c.get(localFile, remoteFile);
			status = "OK";
			
		}
		catch (Exception e) {
		    // status = e.toString();
		     throw new ServiceException(e.toString());
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void lcd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(lcd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required localPath
		// [o] field:0:required status
		// pipeline 
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	localPath = IDataUtil.getString( pipelineCursor, "localPath" );
		pipelineCursor.destroy();
		String status = null;
		try {
		    c.lcd(localPath);
		    status = "OK";
		}
		catch (SftpException e) {
		    // status = e.toString();
		    throw new ServiceException(e.toString());
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void login (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(login)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required ftpHost
		// [i] field:0:required ftpPort
		// [i] field:0:required ftpUserName
		// [i] field:0:required ftpPassword
		// [i] field:0:required useSecure {&quot;true&quot;,&quot;false&quot;}
		// [i] field:0:required ftpPvtKey
		// [i] field:0:required ftpPassphase
		// [i] field:0:required ftpPubKey
		// [o] object:0:required ChannelSftp
		// [o] object:0:required SessionFactory
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ftpHost = IDataUtil.getString( pipelineCursor, "ftpHost" );
			int	ftpPort = Integer.parseInt(IDataUtil.getString( pipelineCursor, "ftpPort" ));
			String	ftpUserName = IDataUtil.getString( pipelineCursor, "ftpUserName" );
			String	ftpPassword = IDataUtil.getString( pipelineCursor, "ftpPassword" );
			String useSecure = IDataUtil.getString( pipelineCursor, "useSecure" );
			String ftpPvtKey = IDataUtil.getString( pipelineCursor, "ftpPvtKey" );
			String ftpPassphase = IDataUtil.getString( pipelineCursor, "ftpPassphase" );
			String ftpPubKey = IDataUtil.getString( pipelineCursor, "ftpPubKey" );
		pipelineCursor.destroy();
		
		String status = null;
		char pvtKeyChar[] = null;
		char pubKeyChar[] = null;
		
		
		    //First Create a JSch session
		    System.out.println("Creating session.");
		    JSch jsch = new JSch();
		    
		    Session session = null;
		    Channel channel = null;
		    ChannelSftp c = null;
		
		    //Now connect and SFTP to the SFTP Server
		    //
		    try {
			
			
			
			if(useSecure.equals("true"))
		    	{
				FileReader fr = new FileReader(ftpPvtKey);
			fr.read(pvtKeyChar);
			fr.close();
			FileReader frp = new FileReader(ftpPubKey);
			fr.read(pubKeyChar);
			fr.close();
			String prvKeyStr = new String(pvtKeyChar);
			String pubKeyStr = new String(pubKeyChar);
				byte[] pvtKey = prvKeyStr.getBytes();
				byte[] passPhase = ftpPassphase.getBytes();
				byte[] pubKey = pubKeyStr.getBytes();
				jsch.addIdentity(  ftpUserName, pvtKey, pubKey, passPhase); 
			        
		    	}
			//Create a session sending through our username and password
		        session = jsch.getSession(ftpUserName, ftpHost, ftpPort);    
		    	session.setPassword(ftpPassword);
		    	//Security.addProvider(new com.sun.crypto.provider.SunJCE());
		    
			//Setup Strict HostKeyChecking to no so we dont get the 
		    	//unknown host key exception
		    	//
		    	Properties config = new Properties();
		    	config.put("StrictHostKeyChecking", "no");
		    	session.setConfig(config);
		    	session.connect();
		    	//
		    	//Open the SFTP channel
		    	//
		    	channel = session.openChannel("sftp");
		    	channel.connect();
		    	c = (ChannelSftp)channel;
				status = "OK";
		    }
		    catch (Exception e) {
				// status = "Unable to connect to SFTP server. "+ftpHost+" "+e.toString();
		                throw new ServiceException("Unable to connect to SFTP server. "+ftpHost+" "+e.toString());
		    }
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
			IDataUtil.put( pipelineCursor_1, "ChannelSftp", c );
			IDataUtil.put( pipelineCursor_1, "SessionFactory", session );
			IDataUtil.put(pipelineCursor_1, "status", status);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void logout (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(logout)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] object:0:required SessionFactory
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			Session	session = (Session) IDataUtil.get( pipelineCursor, "SessionFactory" );
		pipelineCursor.destroy();
		
		String status = null;
		
		try {
		    c.quit();
		    session.disconnect();
		    status = "OK";
		} 
		catch (Exception exc) {
		    
		    throw new ServiceException("Unable to disconnect from FTP server. " + exc.toString());
		    // status = "Unable to disconnect from FTP server. " + exc.toString();
		}
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "status", status );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void lpwd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(lpwd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [o] field:0:required status
		// [o] field:0:required lpwd
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
		pipelineCursor.destroy();
		String status = null;
		String lpwd = null;
		try {
		    lpwd = c.lpwd();
		    status = "OK";
		}
		catch (Exception e) {
		    // status = e.toString();
		    throw new ServiceException(e.toString());
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		    IDataUtil.put(pipelineCursor_1,"status",status);
		    IDataUtil.put(pipelineCursor_1,"lpwd",lpwd);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void ls (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(ls)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:optional path
		// [i] field:0:required pattern
		// [o] field:0:required status
		// [o] field:1:required filenames
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp) IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String path = IDataUtil.getString( pipelineCursor, "path" );
			String pattern = IDataUtil.getString( pipelineCursor, "pattern" );
			//LsEntry ls = new LsEntry(c);
		pipelineCursor.destroy();
		
		Vector fn = new Vector();
		String status = null;
		try {
		    if(path == null && pattern == null) {
		    	fn = c.ls("/");
		    	status = "OK";
		    }
		    if(pattern != null) {
			fn = c.ls(pattern);
			status = "OK";
		    }
		    else {
			fn = c.ls(path);
		    	status = "OK";
		    }
		}
		catch (Exception e) {
		     
		     throw new ServiceException(e.toString());
		    // status = e.toString();
		}
		String[] filenames = new String[fn.size()];
		for(int i=0;i<fn.size();i++) {
		    //filenames[i] = (String)fn.get(i).toString().substring(56);
		    filenames[i] = ((ChannelSftp.LsEntry)fn.get(i)).getFilename();
		}
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "status", status );
		IDataUtil.put( pipelineCursor_1, "filenames", filenames );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void put (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(put)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required localFile
		// [i] field:0:required remoteFile
		// [i] object:0:required content
		// [i] field:0:required transferMode {&quot;OVERWRITE&quot;,&quot;APPEND&quot;,&quot;RESUME&quot;}
		// [i] field:0:required contentOrlocalFile {&quot;contents&quot;,&quot;localFile&quot;}
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	localFile = IDataUtil.getString( pipelineCursor, "localFile" );
			String	remoteFile = IDataUtil.getString( pipelineCursor, "remoteFile" );
			InputStream content = (InputStream)IDataUtil.get( pipelineCursor, "content");
			String transferMode = IDataUtil.getString( pipelineCursor, "transferMode");
			int trMode;
		
			
			String contentOrlocalFile = IDataUtil.getString( pipelineCursor, "contentOrlocalFile");
		
			if (transferMode.equals("APPEND"))
				trMode=2;
			else if(transferMode.equals("OVERWRITE"))
				trMode=0;
			else
				trMode=1;
		        
		        
		pipelineCursor.destroy();
		
		String status = null;
		try {
			if(contentOrlocalFile.equals("contents"))
		    	{
				c.put(content, remoteFile, trMode);
				status = "OK";
		    	}
			else
			{
				c.put(localFile,remoteFile);
		    		status = "OK";
			}
			
		}
		catch (Exception e) {
		 
		     throw new ServiceException("Unable to put file: "+remoteFile+" "+e.toString());
		    // status = "Unable to put file: "+remoteFile+" "+e.toString();
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void pwd (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(pwd)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [o] field:0:required status
		// [o] field:0:required pwd
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
		pipelineCursor.destroy();
		String status = null;
		String pwd = null;
		try {
		    pwd = c.pwd();
		    status = "OK";
		}
		catch (Exception e) {
		      
		     throw new ServiceException(e.toString());
		    // status = e.toString();
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		    IDataUtil.put(pipelineCursor_1,"status",status);
		    IDataUtil.put(pipelineCursor_1,"pwd",pwd);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void rename (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(rename)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required remoteFileOld
		// [i] field:0:required remoteFileNew
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	remoteFileOld = IDataUtil.getString( pipelineCursor, "remoteFileOld" );
			String	remoteFileNew = IDataUtil.getString( pipelineCursor, "remoteFileNew" );
			
		pipelineCursor.destroy();
		
		String status = null;
		try {
			
		    	c.rename(remoteFileOld, remoteFileNew);
			status = "OK";
		    
		}
		catch (Exception e) {
		
		       throw new ServiceException("Unable to rename file: "+remoteFileOld+" "+e.toString());
		    // status = "Unable to rename file: "+remoteFileOld+" "+e.toSring();
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void rm (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(rm)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required ChannelSftp
		// [i] field:0:required file
		// [o] field:0:required status
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			ChannelSftp c = (ChannelSftp)IDataUtil.get( pipelineCursor, "ChannelSftp" );
			String	file = IDataUtil.getString( pipelineCursor, "file" );
		pipelineCursor.destroy();
		String status = null;
		try {
		    c.rm(file);
		    status = "OK";
		}
		catch (SftpException e) {
		    // status = e.toString();
		    throw new ServiceException(e.toString());
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		     IDataUtil.put(pipelineCursor_1,"status",status);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

