package LXKWMAMSupport.LXKWMCertCheck;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-01-07 10:47:20 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import iaik.x509.X509Certificate;
import java.security.cert.*;
import com.wm.app.b2b.server.Server;
import java.util.Calendar;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.*;
import java.text.*;
import com.wm.util.Config;
import com.wm.util.*;
import java.sql.*;
import com.wm.app.tn.db.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void calculateDateDifference (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calculateDateDifference)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required startDateTime
		// [i] field:0:required endDateTime
		// [i] field:0:required startDateFormat {&quot;yyyy-MM-dd HH:mm:ss.S&quot;}
		// [i] field:0:required endDateFormat {&quot;yyyy-MM-dd HH:mm:ss.S&quot;}
		// [o] field:0:required dateDifferenceSec
		// [o] field:0:required dateDifferenceMin
		// [o] field:0:required dateDifferenceHr
		// [o] field:0:required dateDifferenceDay
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	startDateTime = "";
		String	endDateTime = "";
		String startDateFormat = "";
		String endDateFormat = "";
		if (pipelineCursor.first("startDateTime"))
		{
			startDateTime = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("endDateTime"))
		{
			endDateTime = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("startDateFormat"))
		{
			startDateFormat = (String) pipelineCursor.getValue();
		}
		if (pipelineCursor.first("endDateFormat"))
		{
			endDateFormat = (String) pipelineCursor.getValue();
		}
		
		if (startDateTime.equals("") || endDateTime.equals(""))
			throw new ServiceException("Dates cannot be null");
		if (startDateFormat.equals("") || endDateFormat.equals(""))
			throw new ServiceException("Date formats cannot be null");
		
		pipelineCursor.destroy();
		
		try {
				SimpleDateFormat sdf = new SimpleDateFormat(startDateFormat);
				Date sdt = sdf.parse(startDateTime);
				SimpleDateFormat edf = new SimpleDateFormat(endDateFormat);
				Date edt = edf.parse(endDateTime);
				long  timediff = edt.getTime() - sdt.getTime();
		
		//		SimpleDateFormat ssdf = new SimpleDateFormat("HH:mm:ss");
		//		Calendar cal = Calendar.getInstance();
		//		cal.clear();
		//		cal.set(Calendar.SECOND, (int) timediff /1000);
		
		//		Date newDateTime = cal.getTime();
		//		String displayTime=null;
		
		//		if (cal.get(Calendar.DAY_OF_YEAR) > 1 )
		//		    displayTime = ssdf.format(newDateTime) + " and " + (cal.get(Calendar.DAY_OF_YEAR)-1) + " Day(s)" ;
		//		else 
		//		    displayTime = ssdf.format(newDateTime);
		
				String displayTimeSec = Long.toString(timediff/1000);
				String displayTimeMin = Long.toString(timediff/60000);
				String displayTimeHr = Long.toString(timediff/3600000);
				String displayTimeDay = Long.toString(timediff/86400000);
		
				// pipeline
				IDataCursor pipelineCursor_1 = pipeline.getCursor();
				pipelineCursor_1.last();
				pipelineCursor_1.insertAfter( "dateDifferenceSec", displayTimeSec);
				pipelineCursor_1.insertAfter( "dateDifferenceMin", displayTimeMin);
				pipelineCursor_1.insertAfter( "dateDifferenceHr", displayTimeHr);
				pipelineCursor_1.insertAfter( "dateDifferenceDay", displayTimeDay);
				pipelineCursor_1.destroy();
			} catch (ParseException e) {
				throw new ServiceException("Error parsing the date time: " + e);
			}
		// --- <<IS-END>> ---

                
	}



	public static final void checkCert (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkCert)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required dirPath
		// [i] field:0:required certFilePath
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	dirPath = IDataUtil.getString( pipelineCursor, "dirPath" );
			String	certFilePath = IDataUtil.getString( pipelineCursor, "certFilePath" );
		
		
		X509Certificate cert = null;
		long daysLeft = 0;
		Properties p = new Properties();
		String fileName = null;
		try {
			File f;
			if (dirPath!= null) {
			f = new File(dirPath, certFilePath);
			} else {
			   f = new File(certFilePath);
			}
			cert = new X509Certificate(new FileInputStream(f));
			Date expiredDate = cert.getNotAfter();	
		   	daysLeft = (expiredDate.getTime() - System.currentTimeMillis()) / 86400000; // number of ms in a day	
			p.put("expiresOn", DateFormat.getDateTimeInstance().format(expiredDate));
			p.put("daysLeft", ""+daysLeft);
			p.put("subject", cert.getSubjectDN().getName());
			String serial = iaik.utils.Util.toString(cert.getSerialNumber().toByteArray());
			p.put("serial", "decimal = " + cert.getSerialNumber().toString() + " / hex = " + serial);
			
			StringTokenizer st = new StringTokenizer(certFilePath, "/");
			while(st.hasMoreTokens()){
			fileName = st.nextToken();
			if(fileName.endsWith(".der")) 
			p.put("certName", fileName);
			} 	
			cert.checkValidity();
			p.put("status", "ok");
		
		} catch(FileNotFoundException fnfe) {
			p.put("status", "file not found: " + certFilePath + "::" + dirPath);
		} catch (IOException ioe) {
		        p.put("status", "I/O Exception reading cert: " + ioe.getMessage());
		} catch (CertificateExpiredException cee) {
			p.put("status", "expired");	
		} catch (CertificateException ce) {
			p.put("status", "CertificateException: " + ce.getMessage().toString());
		} catch (Exception e) {
		        p.put("status", e.toString());	
		} 
		
		pipelineCursor.insertAfter("certInfo", new Values(p));
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void checkTNCerts (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkTNCerts)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required sqlQuery
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	sqlQuery = IDataUtil.getString( pipelineCursor, "sqlQuery" );
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		ArrayList certs = new ArrayList();
		try{
			conn = Datastore.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			while(rs.next()) {
			IData data = IDataFactory.create();
			ValuesEmulator.put(data, "partnerName", rs.getString(1));
			ValuesEmulator.put(data, "status", rs.getString(2));
			ValuesEmulator.put(data, "expiresOn", rs.getString(3));
			certs.add(data);
			}
			rs.close();
			stmt.close();
		}catch (Exception ex) {
			throw new ServiceException(ex);
		}
		finally {
			if (conn != null) Datastore.releaseConnection(conn);
		}
		
		// Populate output pipeline.
		
		if (certs.size() > 0)
			ValuesEmulator.put(pipeline, "TNCertInfo", certs.toArray(new IData[1]));
		else
			ValuesEmulator.put(pipeline, "TNCertInfo", new IData[0]);
		// --- <<IS-END>> ---

                
	}



	public static final void getFilesInDir (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFilesInDir)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required dir
		// [o] field:1:required files
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	caDir = IDataUtil.getString( pipelineCursor, "dir" );
		String [] files = null;
			if (caDir == null) {
				files = new String[0];
			} else {
			     File dir = new File(caDir);
			     if(dir.isDirectory()) {
			     files = dir.list();
			     } else {
			        files = new String[0];
			     }
			}
		IDataUtil.put(pipelineCursor, "files", files);
		pipelineCursor.destroy();
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void getSystemProperty (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSystemProperty)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required key
		// [o] field:0:required value
		// pipeline
		IDataCursor cursor = pipeline.getCursor();
			String	key = IDataUtil.getString( cursor, "key" );
		IDataUtil.put( cursor, "value", Config.getProperty(key) );
		cursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void moveSourceIfExists (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(moveSourceIfExists)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required Source
		// [i] field:0:required Other
		// [o] field:0:required Target
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	Source = IDataUtil.getString( pipelineCursor, "Source" );
			String	Other = IDataUtil.getString( pipelineCursor, "Other" );
		
			if(Source != null) {
				if(Other == null) 
					IDataUtil.put(pipelineCursor, "Target", Source);
				 else						
					IDataUtil.put(pipelineCursor, "Target", Source);		
			} else {
				if(Other != null)
					IDataUtil.put(pipelineCursor, "Target", Other);
				else
					IDataUtil.put(pipelineCursor, "Target", "");		
			}
		pipelineCursor.destroy();
		
		
		// --- <<IS-END>> ---

                
	}
}

