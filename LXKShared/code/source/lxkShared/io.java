package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-06-12 07:00:15 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.nio.charset.Charset;
// --- <<IS-END-IMPORTS>> ---

public final class io

{
	// ---( internal utility methods )---

	final static io _instance = new io();

	static io _newInstance() { return new io(); }

	static io _cast(Object o) { return (io)o; }

	// ---( server methods )---




	public static final void closeStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeStream)>> ---
		// @sigtype java 3.5
		// [i] object:0:required stream
		IDataCursor cursor = pipeline.getCursor();
		
		Object stream;
		
		try
		{
		  if (cursor.first("stream"))
		  {
		    // If the input object is of type java.io.InputStream
		    stream = cursor.getValue();
		    if (stream instanceof InputStream)
		    {
		      ((InputStream)stream).close();
		    }
		    // If the input object is of type java.io.OutputStream
		    else if (stream instanceof OutputStream)
		    {
		      OutputStream os = (OutputStream)stream;
		      os.flush();
		      os.close();
		    }
		    // If the input object is of type java.io.Writer
		    else if (stream instanceof Writer)
		    {
		      Writer writer = (Writer)stream;
		      writer.flush();
		      writer.close();
		    }
		    // If the input object is of type java.io.Reader
		    else if (stream instanceof Reader)
		    {
		      ((Reader)stream).close();
		    }
		    else
		    {
		      throw new ServiceException("Incorrect object type 'stream'");
		    }
		  }
		}
		catch (IOException ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void createTempFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createTempFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:optional prefix
		// [i] field:0:required suffix
		// [i] field:0:optional folder
		// [o] field:0:required tempFile
		// [o] object:0:required tempWriter
		IDataCursor cursor = pipeline.getCursor();
		
		String prefix = null;
		String suffix = null;
		File folder = null;
		
		if (cursor.first("prefix"))
		{
		  prefix = (String)cursor.getValue();
		}
		
		if (prefix == null || prefix.length() < 3)
		{
		  throw new ServiceException("The field 'prefix' should be atleast 3 characters long");
		}
		
		if (cursor.first("suffix"))
		{
		  suffix = (String)cursor.getValue();
		}
		
		if (cursor.first("folder"))
		{
		  folder = new File((String)cursor.getValue());
		}
		try
		{
		  // Create the file from the input paramters 
		  File tempFile = File.createTempFile(prefix, suffix, folder);
		  //Save the full file path to output parameters.
		  setValue(cursor, "tempFile", tempFile.getCanonicalPath());
		  setValue(cursor, "tempWriter", new BufferedWriter(new FileWriter(tempFile)));
		}
		catch (IOException ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void deleteFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(deleteFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required filename
		// [o] field:0:required deleted {&quot;true&quot;,&quot;false&quot;}
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("filename"))
		{
		  File file = new File((String)cursor.getValue());
		  setValue(cursor, "deleted", String.valueOf(file.delete()));
		}
		cursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void getFileAttribute (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFileAttribute)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// --- <<IS-END>> ---

                
	}



	public static final void getReader (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getReader)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inputStream
		// [o] object:0:required reader
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("inputStream"))
		{
		  InputStream inputStream = (InputStream)cursor.getValue();
		  //Create a BufferedReader from the input stream
		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  if (cursor.first("reader"))
		  {
		    cursor.setValue(reader);
		  }
		  else
		  {
		    cursor.insertAfter("reader", reader);
		  }
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getStreamContent (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getStreamContent)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inputStream
		// [o] object:0:optional bytes
		// [o] object:0:optional storageRef
		// [o] field:0:required type
		IDataCursor cursor = pipeline.getCursor();
		InputStream is = null;
		
		//Get the input stream from the pipeline.
		if (cursor.first("inputStream"))
		{
		  is = (InputStream)cursor.getValue();  
		}
		
		if (is == null)
		{
		  throw new ServiceException("Missing input 'inputStream'");
		}
		
		try
		{
		  //Read from the stream and create a byte array or a storage reference from it.
		  /* 
		   Object object = streamToBytesOrReservation(is);
		
		  //If the created object is a byte array
		  if (object instanceof byte[])
		  {
		    setValue(cursor, "bytes", object);
		    setValue(cursor, "type", "byteArray");
		  }
		  //If the created object is a storage reference
		  else if (object instanceof Reservation)
		  {
		    setValue(cursor, "storageRef", object);
		    setValue(cursor, "type", "tspace");
		  }
		  */
		}
		catch (Exception e)
		{
		  throw new ServiceException(e);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void listFiles (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(listFiles)>> ---
		// @sigtype java 3.5
		// [i] field:0:required folder
		// [i] field:0:required filename
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("folder"))
		{
		  String folder = (String)cursor.getValue();
		  String[] files = new File(folder).list();
		  setValue(cursor, "files", files);
		/*  for (int i=0; i<files.length; i++)
		  {
		    try
		    {
		      new File(folder, files[i]).delete();
		    }
		    catch (Exception e)
		    {
		    } 
		  }*/
		}
		else
		{
		  throw new ServiceException("Missing input 'folder'");
		}
		/*
		String filename = null;
		
		if (cursor.first("filename"))
		{
		  filename = (String)cursor.getValue();
		}
		
		if (filename == null)
		{
		  throw new ServiceException("Missing input 'filename'");
		}
		setValue(cursor,"fileSize", String.valueOf(new File(filename).length()));
		Calendar cal = Calendar.getInstance();
		Date dt = new Date();
		dt.setTime(new File(filename).lastModified());
		cal.setTime(dt);
		String dts = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR) + "  " 
		+ cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		setValue(cursor, "lastModified", dts);
		*/
		cursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void readLine (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(readLine)>> ---
		// @sigtype java 3.5
		// [i] object:0:required reader
		// [o] field:0:required line
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("reader"))
		{
		  //Get the reader from the pipeline
		  BufferedReader reader = (BufferedReader)cursor.getValue();
		  String line = null;
		  try
		  {
		    // Read a line of data from the reader.
		    line = reader.readLine();
		  }
		  catch (IOException ioe)
		  {
		    throw new ServiceException(ioe);
		  }
		
		  if (cursor.first("line"))
		  {
		    cursor.setValue(line);
		  }
		  else
		  {
		    cursor.insertAfter("line", line);
		  }
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void writeBytesToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeBytesToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required fullFilePathString
		// [i] field:0:required appendFlag {&quot;false&quot;,&quot;true&quot;}
		// [i] object:0:required content
		IDataCursor cursor = pipeline.getCursor();
		
		String fullFilePathString = "";
		String contentConvertedString = "";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		String strAppendFlag = "false";
		boolean boolAppendFlag = false;
		
		if (cursor.first("fullFilePathString"))
		{
		    fullFilePathString = (String)cursor.getValue();
		}
		
		if (cursor.first("appendFlag"))
		{
		    strAppendFlag = (String)cursor.getValue();
		}
		
		if (strAppendFlag.equals("true"))
		{
			boolAppendFlag = true;
		}
		else
		{
			boolAppendFlag = false;
		}
		
		
		
		try
		{
		   Object obj = null;
		
		   if (cursor.first("content"))
		   {
				contentConvertedString = (String)cursor.getValue();
		
				try
				{
					fos = new FileOutputStream(fullFilePathString,boolAppendFlag);	// make a output byte stream, no append is default
					bos = new BufferedOutputStream(fos);		// attach a BufferedOutputStream to buffer the byte stream
					dos = new DataOutputStream(bos);		    // attach a DataOutputStream to it so we can write 
					if ( dos!=null )
					{
						dos.writeBytes(contentConvertedString);
						bos.flush();			// write all the bytes to the file (flush)
						dos.close();			// close and free up system resource.
						bos.close();			// close and free up system resource.
						fos.close(); 			// close in reverse order; FileOutputStream last
					}
				}
				catch (Exception exp)
				{
				  throw new ServiceException(exp);
				}
		
		   }
		
		}
		catch (Exception ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void writeDataBytesToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeDataBytesToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		IDataCursor cursor = pipeline.getCursor();
		
		String fullFilePathString = "";
		byte contentConvertedString[] = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		String strAppendFlag = "false";
		boolean boolAppendFlag = false;
		
		if (cursor.first("fullFilePathString"))
		{
		    fullFilePathString = (String)cursor.getValue();
		}
		
		if (cursor.first("appendFlag"))
		{
		    strAppendFlag = (String)cursor.getValue();
		}
		
		if (strAppendFlag.equals("true"))
		{
			boolAppendFlag = true;
		}
		else
		{
			boolAppendFlag = false;
		}
		
		
		
		try
		{
		   Object obj = null;
		
		   if (cursor.first("content"))
		   {
				contentConvertedString = (byte[])cursor.getValue();
		
				try
				{
					fos = new FileOutputStream(fullFilePathString,boolAppendFlag);	// make a output byte stream, no append is default
					bos = new BufferedOutputStream(fos);		// attach a BufferedOutputStream to buffer the byte stream
					dos = new DataOutputStream(bos);		    // attach a DataOutputStream to it so we can write 
					if ( dos!=null )
					{
						dos.write(contentConvertedString);
						bos.flush();			// write all the bytes to the file (flush)
						dos.close();			// close and free up system resource.
						bos.close();			// close and free up system resource.
						fos.close(); 			// close in reverse order; FileOutputStream last
					}
				}
				catch (Exception exp)
				{
				  throw new ServiceException(exp);
				}
		
		   }
		
		}
		catch (Exception ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void writeListToStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeListToStream)>> ---
		// @sigtype java 3.5
		// [i] object:0:required fileWriter
		// [i] record:1:required list
		// [i] field:0:optional fieldSeparator
		// [o] field:0:required recordCount
		IDataCursor cursor = pipeline.getCursor();
		
		Writer writer;
		String fieldSeparator ="|";
		
		if (cursor.first("fileWriter"))
		{
		  writer = (Writer)cursor.getValue();  
		}
		else
		{
		  throw new ServiceException("Missing input 'fileWriter'");
		}
		
		if (cursor.first("fieldSeparator"))
		{
		  fieldSeparator = (String)cursor.getValue();
		}
		
		try
		{
		  if (cursor.first("list"))
		  {
		    Object object = cursor.getValue();
		
		    IData[] list;
		    if (object instanceof Table)
		    {
		      list = ((Table)object).getValues();
		    }
		    else
		    {
		      list = (IData[])object;
		    }
		    if (cursor.first("recordCount"))
		    {
		      cursor.setValue(String.valueOf(list.length));
		    }
		    else
		    {
		      cursor.insertAfter("recordCount", String.valueOf(list.length));
		    }
		
		    //Loop over the recordlist, extracting each record and writing it.
		    for (int i=0; i<list.length; i++)
		    {
		      IDataCursor listCursor = list[i].getCursor();
		      //Loop over the fields in this record
		      for (int j=0; listCursor.next();j++)
		      {
		        if (j>0)
		        {
		          writer.write(fieldSeparator);
		        }
		
		        String value = (String)listCursor.getValue();
		        if (value != null)
		        {
		          writer.write(value);
		        }
		      }
		      //Write a newline string after each record.
		      writer.write(lineSeparator);
		      listCursor.destroy();
		    }
		  }
		}
		catch (IOException ioe)
		{
		  throw new ServiceException(ioe);
		}
		finally
		{
		  cursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void writeToStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeToStream)>> ---
		// @sigtype java 3.5
		// [i] object:0:required stream
		// [i] object:0:required content
		// [i] field:0:optional newline {&quot;true&quot;,&quot;false&quot;}
		IDataCursor cursor = pipeline.getCursor();
		
		boolean newline = false;
		Writer writer = null;
		Object object;
		Object content = null;
		
		if (cursor.first("stream"))
		{
		  object = cursor.getValue();
		  //If the input object is an instance of java.io.OutputStream, create a 
		  //java.io.BufferedWriter object from it.
		  if (object instanceof OutputStream)
		  {
		    writer = new BufferedWriter(new OutputStreamWriter((OutputStream)object));
		  }
		  else if (object instanceof Writer)
		  {
		    writer = (Writer)object;
		  }
		}
		
		if (writer == null)
		{
		  throw new ServiceException("Missing input 'stream'");
		}
		
		//Get the content to be written
		if (cursor.first("content"))
		{
		  content = cursor.getValue();
		}
		
		if (content == null)
		{
		   throw new ServiceException("Missing input 'content'");
		}
		
		//Create string reprentation of the content.
		String contentString = formatContent(content); 
		if (cursor.first("newline"))
		{
		  newline = Boolean.valueOf((String)cursor.getValue()).booleanValue();
		}
		
		try
		{
		   //write out the string
		   writer.write(contentString);
		   if (newline)
		   {
		     writer.write(lineSeparator);
		   }
		}
		catch (IOException ioe)
		{
		  throw new ServiceException(ioe.getMessage());
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
	private static String lineSeparator = System.getProperty("line.separator");
	
	//Method that creates a formatted string from an object.
	private static String formatContent(Object obj)
	{
	  //Return the same string
	  if (obj instanceof String)
	  {
	     return (String)obj;
	  }
	  //If the object is a byte array, create a string from it
	  else if (obj instanceof 
	byte[])
	  {
	    return new String((byte[])obj);
	  }
	
	  StringBuffer buffer = new StringBuffer();
	  //If the object is a string list, put each string in its own line.
	  if (obj instanceof String[])
	  {
	     String[] strArray = (String[])obj;
	     for (int i=0; i < strArray.length; i++)
	     {
	       buffer.append(strArray[i]);
	       buffer.append(lineSeparator);
	     }
	  }
	  //If the object is a recordlist, put each record on its own line
	  else if (obj instanceof IData[])
	  {
	     IData[] idataArray = (IData[])obj;
	     for (int i=0; i < idataArray.length; i++)
	     {
	       buffer.append(idataArray[i]);
	       buffer.append(lineSeparator);
	     }
	  }
	  //If the object is an inputstream, read from it and return the content
	  else if (obj instanceof InputStream)
	  {
	    try
	    {
	      InputStream is = (InputStream)obj;
	      byte[] bytes = new byte[1024];
	      int numRead = 0;
	      while ((numRead = is.read(bytes)) >= 0)
	      {
	        buffer.append(new String(bytes, 0, numRead));
	      }
	      is.close();
	    }
	    catch (IOException ioe)
	    {
	      buffer.append("Error : Could not read from input stream");
	    }
	  }
	  //assume that the object is a record and use its toString method.
	  else
	  {
	     buffer.append(((IData)obj).toString());
	  }
	
	  return buffer.toString();
	   
	}
	
	//Utility method to set a pipeline variable
	private static void setValue(IDataCursor cursor, String name, Object obj)
	{
	  if (cursor.first(name))
	  {
	    cursor.setValue(obj);
	  }
	  else
	  {
	    cursor.insertAfter(name, obj);
	  }
	}
	
	//Method that creates a byte array or a storage reference from it.
	/* private static Object streamToBytesOrReservation(InputStream is)
	throws IOException
	{
	  long count = 0L;
	  int numberRead = -1;
	  byte[] buffer = new byte[1024];
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();
	  //Get the large document threshold for the the Trading Networks config.
	  long largeDocThreshold = Config.getLargeDocThreshold();
	
	  try
	  {
	    numberRead = is.read(buffer);
	  }
	  catch (IOException ioe) 
	  { 
	  }
	
	  //Read from the stream
	  while (numberRead >= 0) 
	  {
	    count += numberRead;
	    bos.write(buffer, 0, numberRead);
	    //If large doc threshold is set and we have read more than the threshold
	    if (count > largeDocThreshold && largeDocThreshold > 0L)
	    {
	      break;
	    }
	    try
	    {
	      numberRead = -1;
	      numberRead = is.read(buffer);
	    }
	    catch (IOException ioe) 
	    { 
	    }
	  }
	  //if the large document threshold is not set or the content is small, 
	  //return a bytearray
	  if (largeDocThreshold < 0L || count <= largeDocThreshold)
	  {
	    return bos.toByteArray();
	  }
	  //if the large document threshold is set and the content is more than the
	  //the threshold, create a storage reference from it using the webMethods
	  //java API.
	  try
	  {
	    long arrayCount = bos.size();
	    ReservationAgent agent = ReservationAgent.current();
	    Reservation reservation = agent.createReservation(arrayCount);
	    OutputStream os = reservation.getOutputStream();
	    os.write(bos.toByteArray(), 0, bos.size());
	    int j = -1;
	    try
	    {
	      j = is.read(buffer);
	    }
	    catch (IOException _ex) { }
	    while (j >= 0) 
	    {
	      arrayCount += j;
	      agent.resizeReservation(reservation, arrayCount);
	      os.write(buffer, 0, j);
	      j = -1;
	      try
	      {
	        j = is.read(buffer);
	      }
	      catch (IOException _ex) { }
	    }
	    is.close();
	    os.flush();
	    os.close();
	    return reservation;
	  }
	  catch (ReservationException re)
	  {
	    throw new IOException(re.getMessage());
	  }
	} */
	// --- <<IS-END-SHARED>> ---
}

