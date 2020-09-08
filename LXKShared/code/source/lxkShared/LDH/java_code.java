package lxkShared.LDH;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-04 06:43:26 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import java.io.*;
import java.util.*;
import com.wm.util.*;
import com.wm.util.xform.StringDT;
// --- <<IS-END-IMPORTS>> ---

public final class java_code

{
	// ---( internal utility methods )---

	final static java_code _instance = new java_code();

	static java_code _newInstance() { return new java_code(); }

	static java_code _cast(Object o) { return (java_code)o; }

	// ---( server methods )---




	public static final void NodeToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(NodeToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required node
		// [i] field:0:required fileName
		// [i] field:0:required filePath
		// [i] field:0:optional encode {&quot;true&quot;,&quot;false&quot;}
		// [i] field:0:optional rootTag
		// [i] field:0:optional nodeHierarchy
		// [i] field:0:optional metaDataString
		IDataCursor cursor =  pipeline.getCursor(); 
		String serviceName1 = "pub.xml:xmlNodeToDocument";
		String serviceName2 = "pub.xml:documentToXMLString";
		String strFileName = null;
		String fp = null;
		String fn = null;
		String xmldata = null;
		String md = null;
		String rootTag = null;
		boolean hasRootTag = false;
		String nodeHierarchy = null;
		String reverseNodeHierarchyString = null;
		boolean hasHierarchy = false;
		
			// Retrieve input values from the pipeline
			if (cursor.first("filePath")) {
				fp = (String) cursor.getValue();
			}
		
			if (cursor.first("fileName")) {
				fn = (String) cursor.getValue();
			}
		
			if (cursor.first("rootTag")) {
				rootTag = (String) cursor.getValue();
			}
			if (cursor.first("nodeHierarchy")) {
				nodeHierarchy = (String) cursor.getValue();
			}
			if (cursor.first("metaDataString")) {
				md = (String) cursor.getValue();
			}
		
			// Create temp holder for XML string being assembled
			StringBuffer sb = new StringBuffer();
			
			// Add root tag if needed
			if (rootTag != null && !rootTag.equals(EMPTY_STRING)) {
				hasRootTag = true;
				sb.append(XML_OPEN_TAG);
				sb.append(rootTag);
				sb.append(XML_CLOSE_TAG);
			}
			
			// Add meta data if specified
			if (md != null && !md.equals(EMPTY_STRING)) {
				sb.append(md);
			}
			
			// Build the hierarchy tag list
			if (nodeHierarchy != null && !nodeHierarchy.equals(EMPTY_STRING)) {
				hasHierarchy = true;
				String[] nodeHierarchyList = StringDT.tokenize(nodeHierarchy,FORWARD_SLASH);
				int length = nodeHierarchyList.length;
				String[] reverseNodeHierarchy = new String[length];
				for (int i = 0; i<length; i++) {
					sb.append(XML_OPEN_TAG);
					sb.append(nodeHierarchyList[i]);
					sb.append(XML_CLOSE_TAG);
					reverseNodeHierarchy[length - i - 1] = nodeHierarchyList[i];
				}
				nodeHierarchyList = null;
				// Build end tags for the hierarchy
				StringBuffer rb = new StringBuffer();
				for (int i = 0; i<length; i++) {
					rb.append(XML_OPEN_END_TAG);
					rb.append(reverseNodeHierarchy[i]);
					rb.append(XML_CLOSE_TAG);
				}
				reverseNodeHierarchyString = rb.toString();
				rb = null;
				reverseNodeHierarchy = null;
			}
			
			// Generate XML string from node passed
			try {
				// Create service objects to invoke
				NSName functionalServerServiceName1 = NSName.create(serviceName1);
				NSName functionalServerServiceName2 = NSName.create(serviceName2);
				
		        //Invoke service to stream the node already in pipeline to document
		        Service.doInvoke(functionalServerServiceName1,pipeline);
				
				// drop node for memory utilization
				if (cursor.first("node")) {
					cursor.setValue(null);
				}
		  		
				// Ensure string generated from doc to string service doesn't have XML header tags
				cursor.last();
				cursor.insertAfter("addHeader", "false");
				
				// Invoke service to generate XML string from document - this will add the xmldata to pipeline
				Service.doInvoke(functionalServerServiceName2,pipeline); 
				if (cursor.first("xmldata")) {
					xmldata = (String) cursor.getValue();
					cursor.setValue(null);
				}
				
				// drop document and addHeader for memory utilization
				if (cursor.first("document")) {
					cursor.setValue(null);
				}
				if (cursor.first("addHeader")) {
					cursor.setValue(null);
				}
			}
			catch(Exception e) { 
		        cursor.destroy();
				throw new ServiceException(e.getMessage()); 
			}
			
			// add the xmldata for the node
			sb.append(xmldata);
			
			if (hasHierarchy) {
				sb.append(reverseNodeHierarchyString);
			}
			if (hasRootTag) {
				sb.append(XML_OPEN_END_TAG);
				sb.append(rootTag);
				sb.append(XML_CLOSE_TAG);
			}
			
			// override the xmldate retrived from the node
			xmldata = sb.toString();
			
			//Assembly the complete file name
			sb = new StringBuffer(fp);
			sb.append(fn);
			strFileName = sb.toString();
			sb = null;
		
			try {
				OutputStream os  = new FileOutputStream(strFileName);
		        StringBufferInputStream is = new StringBufferInputStream(xmldata);
				byte[] bytes = new byte[1024];
		     	int numRead = 0;
		        while ((numRead = is.read(bytes)) >= 0)
		 	    {
		     	  os.write(bytes, 0, numRead);
		        }
		   	    is.close();
		   		os.flush();
				os.close();
			}
			catch(Exception e) {
				throw new ServiceException("NodeToFile Error: " + e);
			}
			finally {
				cursor.destroy();
			}
		// --- <<IS-END>> ---

                
	}


    public static final Values checkFileSize (Values in)
    {
        Values out = in;
		// --- <<IS-START(checkFileSize)>> ---
		// @sigtype java 3.0
		// [i] field:0:required fileName
		// [i] field:0:required fileDirectory
		// [o] field:0:required fileSize
		// Get pipeline variables.
		String strFileName = in.getString("fileName");
		String strFileDirectory = in.getString("fileDirectory");
		
		// Get system file separator.
		String strFileSeparator = System.getProperty("file.separator", "/");
		
		// Determine last character of directory variable.
		String strFile = null;
		if ( strFileDirectory.endsWith(strFileSeparator) ) {
			strFile = strFileDirectory.concat(strFileName);
		} else {
			strFile = strFileDirectory.concat(strFileSeparator.concat(strFileName));
		}
		
		// Get file descriptor.
		File file = new File(strFile);
		
		// Get file size.
		long fileSize = file.length();
		
		// Set pipeline variable.
		out.put( "fileSize", Long.toString( fileSize ) ); 
		// --- <<IS-END>> ---
        return out;
                
	}



	public static final void closeStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(closeStream)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stream
	IDataCursor id = pipeline.getCursor();
    java.io.InputStream stream = null;

	if (id.first("stream"))
	{
		stream = (java.io.InputStream)id.getValue();
	}


    if(stream == null)
      throw new ServiceException("stream can not be null");
    try
    {
		stream.close(); 
    }
    catch(Exception e)
    {
        throw new ServiceException(e);
    }
		// --- <<IS-END>> ---

                
	}



	public static final void createLargeDocDirs (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createLargeDocDirs)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required packages
		IDataCursor cursor = pipeline.getCursor();
		String fileSep = System.getProperty("file.separator");
		String installDir= System.getProperty("user.dir");
		String[] packages = null;
		String Sourcedir = null;
		String WIPdir = null;
		String Archivedir = null;
		String Outputdir = null;
		String rootDir = null;
		
		if (cursor.first("packages"))
		{
		  packages = (String[]) cursor.getValue();
		}
		
		if (packages != null && packages.length > 0) 
		{
			for (int i = 0; i < packages.length; i++) 
			{
				rootDir = (installDir+fileSep+"packages"+fileSep+packages[i]+fileSep+"pub"+fileSep+"LDH");
				Sourcedir = (rootDir+fileSep+"Input"+fileSep);
				WIPdir = (rootDir+fileSep+"WIP"+fileSep);
				Archivedir = (rootDir+fileSep+"Archive"+fileSep);
				Outputdir = (rootDir+fileSep+"Output"+fileSep);
		
				File root = new File (rootDir);
				File a = new File (Sourcedir);
				File b = new File (WIPdir);
				File c = new File (Archivedir);
				File d = new File (Outputdir);
		
				if (!root.exists())
				{
					root.mkdirs();
				}
				if (!a.exists()) 
				{
				    a.mkdirs();
				}
				if (!b.exists()) 
				{
				    b.mkdirs();
				}
				if (!c.exists()) 
				{
				    c.mkdirs();
				}
				if (!d.exists()) 
				{
				    d.mkdirs();
				}
		
			}
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filename
		// [i] field:0:optional loadAs {&quot;bytes&quot;,&quot;stream&quot;}
		// [i] field:0:optional bufferSize
		// [o] record:0:required body
		// [o] - object:0:optional bytes
		// [o] - object:0:optional stream
	IDataCursor id = pipeline.getCursor();
    String filename = ValuesEmulator.getNonEmptyString(pipeline, "filename");
    if(filename == null)
	{
        throw new ServiceException("filename can not be null");
	}
    String loadAs = ValuesEmulator.getNonEmptyString(pipeline, "loadAs");
    if(loadAs == null)
	{
        loadAs = "bytes";
	}
    int bufferSize = 4096;
    if(id.first("bufferSize"))
	{
        bufferSize = IDataUtil.getInt(id, 4096);
	}

    java.io.InputStream stream = null;

    try
    {
    	File f = new File(filename);
        if(!f.exists())
		{
            throw new ServiceException("File Does not exist"+filename);
		}
        if(!f.canRead())
		{
            throw new ServiceException("File can not be read"+filename);
		}
        if(f.isDirectory())
		{
            throw new ServiceException("File is a directory"+filename);
		}
        Values body = new Values();
        IDataCursor idc = body.getCursor();
        if(loadAs.equalsIgnoreCase("stream"))
        {
            stream = new BufferedInputStream(new FileInputStream(f), bufferSize);
            mergeOutput(idc, "stream", stream);
        } 
		else
        {
            byte bytes[] = com.wm.util.Files.readFully(f);
            mergeOutput(idc, "bytes", bytes);
        }
        idc.destroy();
        mergeOutput(id, "body", body); 

	}
    catch(Exception e)
    {
        throw new ServiceException(e);
    }
		// --- <<IS-END>> ---

                
	}



	public static final void getLargeDocDirs (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLargeDocDirs)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required packages
		// [o] field:1:required inputDirList
		// [o] field:1:required wipDirList
		// [o] field:1:required archiveDirList
		// [o] field:1:required outputDirList
		IDataCursor cursor = pipeline.getCursor();
		String fileSep = System.getProperty("file.separator");
		String installDir= System.getProperty("user.dir");
		String[] packages = null;
		String Sourcedir = null;
		String WIPdir = null;
		String Archivedir = null;
		String Outputdir = null;
		String rootDir = null;
		
		String[] SList = null;
		String[] WList = null;
		String[] AList = null;
		String[] OList = null;
		
		if (cursor.first("packages"))
		{
		  packages = (String[]) cursor.getValue();
		}
		
		if (packages != null && packages.length > 0) 
		{
			SList = new String[packages.length];
			WList = new String[packages.length];
			AList = new String[packages.length];
			OList = new String[packages.length];
			
			for (int i = 0; i < packages.length; i++) 
			{
				rootDir = (installDir+fileSep+"packages"+fileSep+packages[i]+fileSep+"pub"+fileSep+"LDH"+fileSep);
				Sourcedir = (rootDir+"Input"+fileSep);
				WIPdir = (rootDir+"WIP"+fileSep);
				Archivedir = (rootDir+"Archive"+fileSep);
				Outputdir = (rootDir+"Output"+fileSep);
		
				SList[i] = (String)Sourcedir;
		
				WList[i] = (String)WIPdir;
		
				AList[i] = (String)Archivedir;
		
				OList[i] = (String)Outputdir;
			}
		}
		
		cursor.last();
		cursor.insertAfter("inputDirList",SList);
		cursor.last();
		cursor.insertAfter("wipDirList",WList);
		cursor.last();
		cursor.insertAfter("archiveDirList",AList);
		cursor.last();
		cursor.insertAfter("outputDirList",OList);
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void moveFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(moveFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required filename
		// [i] field:0:required sourceDirectory
		// [i] field:0:required targetDirectory
		// [o] field:0:required message

	IDataCursor idcPipeline = pipeline.getCursor();

	String strFilename = "";
	String strSourceDirectory = null;
	String strTargetDirectory = null;
	if (idcPipeline.first("filename"))
	{
		strFilename = (String)idcPipeline.getValue();
	}
	else
	{
		throw new ServiceException("Move Failed: Filename is null!");
	}
	if (idcPipeline.first("sourceDirectory"))
	{
		strSourceDirectory = (String)idcPipeline.getValue();
	}
	if (idcPipeline.first("targetDirectory"))
	{
		strTargetDirectory = (String)idcPipeline.getValue();
	}

	File sourceFile = null;
	File targetFile = null;

	try
	{
		
		sourceFile = new File(strSourceDirectory, strFilename);
		targetFile = new File(strTargetDirectory, strFilename);

		if (!sourceFile.exists() || sourceFile.isDirectory())
		{ 
			throw new ServiceException("MOVE ERROR: Source file not found (" + sourceFile.getAbsolutePath() + ")");
		} 

		if (strSourceDirectory != null && strTargetDirectory != null && strSourceDirectory.equals(strTargetDirectory))
		{
			//Trivial case - source=target - Move was successful
			idcPipeline.insertAfter("message", "Moved: " + sourceFile.getAbsolutePath() + " to " + strTargetDirectory);
			return;
		}

		if (targetFile.exists())
		{
			throw new ServiceException("MOVE ERROR: Target file already exists(" + targetFile.getAbsolutePath() + ")");
		} 

		// Move files
		sourceFile.renameTo(targetFile);

		//Check to ensure file was succesfully moved
		if (sourceFile.exists() || !targetFile.exists())
		{	
			throw new ServiceException("MOVE ERROR: Couldn't move file " + sourceFile.getAbsolutePath());
		}

		idcPipeline.insertAfter("message", "Moved: " + sourceFile.getAbsolutePath() + " to " + strTargetDirectory);

	}
	catch (Exception e)
	{
		throw new ServiceException(e.getMessage());
	}
	finally
	{
		sourceFile = null;
		targetFile = null;
	}

	//Move was successful
	idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static final String XML_OPEN_TAG = "<";
	private static final String XML_CLOSE_TAG = ">";
	private static final String XML_OPEN_END_TAG = "</";
	private static final String EMPTY_STRING = "";
	private static final String FORWARD_SLASH = "/";
	
	public class writeObjectToFile implements Serializable{}
	
	static FileComparator fileComparator = FileComparator.newInstance();
		
		static class FileComparator implements Comparator, Serializable 
		{
		
			static public FileComparator newInstance() 
			{
				return new FileComparator();
			}
		
		  public int compare(Object o1, Object o2) 
		  {
		    if(!(o1 instanceof File)) throw new ClassCastException();
		    if(!(o2 instanceof File)) throw new ClassCastException();
		    if(((File)o1).lastModified() < ((File)o2).lastModified()) return -1;
		    if(((File)o1).lastModified() > ((File)o2).lastModified()) return 1;
		    return 0;
		  }
		
		  public boolean equals(Object o)
		  {
		    if(!(o instanceof FileComparator))
		        return false;
		    else
		        return true;
		  }
	
		}
	
	static class SimpleFileFilter implements FileFilter 
	{
	
	  static public SimpleFileFilter newInstance(String ext, boolean ignore) 
	  {
	    return new SimpleFileFilter(ext, ignore);
	  }
	
	 String[] extensions;
	 String description;
	 boolean ignore;
	
	 public SimpleFileFilter (String ext, boolean ignore) 
	 {
	  this (new String[] {ext},null,ignore);
	 }
	
	 public SimpleFileFilter (String[] exts, String descr, boolean ignore) 
	 {
	
	  extensions=new String[exts.length];
	  for (int i=exts.length-1;i>=0;i--) 
	  {
	   extensions[i]=exts[i].toLowerCase();
	  }
	
	  description=(descr== null ?exts[0]+"files":descr);
	  this.ignore = ignore;
	 }
	
	 public boolean accept (File f) 
	{
	
	  if (f.isDirectory()) {return false;}
	
	  String name=f.getName().toLowerCase();
	  for (int i=extensions.length-1;i>=0;i--) 
	  {
	   if (name.endsWith(extensions[i])) 
	   {
	    if (ignore)
	      return false;
	    else
	      return true;
	   }
	  }
	  if (ignore)
	    return true;
	  else
	    return false;
	 }
	
	 public String getDescription() 
	 {
		return description;
	 }
	
	}
	
	    private static void mergeOutput(IDataCursor id, String key, Object value)
	    {
	        if(id.first(key))
	        {
	            id.setValue(value);
	        } else
	        {
	            id.last();
	            id.insertAfter(key, value);
	        }
	    }
	
	    public static final int BUFFER_SIZE = 4096;
	
	
	// --- <<IS-END-SHARED>> ---
}

