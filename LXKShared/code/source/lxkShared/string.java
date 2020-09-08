package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-07-11 09:51:04 EDT
// -----( ON-HOST: dashrwmis002.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.io.*;
import com.wm.util.*;
import com.wm.util.Debug;
// --- <<IS-END-IMPORTS>> ---

public final class string

	extends Service
{
	// ---( internal utility methods )---

	final static string _instance = new string();

	static string _newInstance() { return new string(); }

	static string _cast(Object o) { return (string)o; }

	// ---( server methods )---




	public static final void concatFields (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(concatFields)>> ---
		// @sigtype java 3.5
		// [i] record:0:required inRecord
		// [i] field:1:optional sortOrder
		// [i] field:0:optional separator
		// [o] field:0:required value
		IDataCursor cursor = pipeline.getCursor();
		
		StringBuffer buffer = new StringBuffer();
		String separator = null;
		String[] sortOrder = null;
		
		if (cursor.first("separator"))
		{
		  separator = (String)cursor.getValue();
		}
		
		if (cursor.first("sortOrder"))
		{
		  sortOrder = (String[])cursor.getValue();
		}
		
		if (cursor.first("inRecord"))
		{
		  IData inRecord = (IData)cursor.getValue();
		  IDataCursor inRecordCursor = inRecord.getCursor();
		  //If no sortOrder is specified, just concatenate the fields based on the defaukt order
		  if (sortOrder == null || sortOrder.length == 0)
		  {
		    for(;inRecordCursor.next();)
		    {
		      if (buffer.length() > 0 && separator != null)
		      {
		        buffer.append(separator);
		      }
		
		      String value = (String)inRecordCursor.getValue();
		      if (value == null)
		      {
		        value = "";
		      }
		 
		
		      buffer.append(value);
		    }
		  }
		  else
		  {
		    //When sortOrder is specified, use that to retrieve and concatenate fields.
		    for (int i=0; i < sortOrder.length; i++)
		    {
		      if (inRecordCursor.first(sortOrder[i]))
		      {
		        if (buffer.length() > 0 && separator != null)
		        {
		          buffer.append(separator);
		         }
		
		         String value = (String)inRecordCursor.getValue();
		         if (value == null)
		         {
		           value = "";
		         }
		 
		
		         buffer.append(value);
		      }
		      else
		      {
		        if (buffer.length() > 0 && separator != null)
		        {
		          buffer.append(separator);
		        }
		        buffer.append("");
		      }
		    }
		  }
		}
		
		if (buffer.length() > 0)
		{
		  if (cursor.first("value"))
		  {
		    cursor.setValue(buffer.toString());
		  }
		  else
		  {
		    cursor.insertAfter("value", buffer.toString());
		  }
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void convertIntToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertIntToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required inputNumber
		// [o] field:0:required numberAsString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			Object	inputNumber = IDataUtil.get( pipelineCursor, "inputNumber" );
		pipelineCursor.destroy();
		
		if (inputNumber != null)
		{
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "numberAsString", inputNumber.toString() );
		pipelineCursor_1.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void convertObjectToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertObjectToString)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inObject
		// [o] field:0:required outString
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			Object	inObject = (Object) IDataUtil.get( pipelineCursor, "inObject" );
		pipelineCursor.destroy();
		
		String outString = "";
		outString = inObject.toString();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outString", outString );
		pipelineCursor_1.destroy();
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void convertStringNewlines (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertStringNewlines)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		pipelineCursor.destroy();
		
		StringWriter sw = null;
		BufferedWriter bw = null;
		
		try 
		{
			sw = new StringWriter();
			bw = new BufferedWriter(sw);
			String delim = "\n";
			StringTokenizer tokenizer = new StringTokenizer(inputString, delim, true);
			String thisString = null;
			while (tokenizer.hasMoreTokens())
			{
				thisString = tokenizer.nextToken();
				if (thisString != null && thisString.equals(delim))
				{
					//Found a newline. These values represent newline on a Windows
					//system, which makes this request look like it comes from IE.
					//This should work for most (hopefully all) receiving web servers.
					bw.write(0x0D);
					bw.write(0x0A);
				}
				else
				{
					//Not a newline.
					bw.write(thisString);
				}
			}
			bw.write(0x0D);
			bw.write(0x0A);
			bw.flush();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		} 
		finally 
		{// always close the file
			if (bw != null) 
			try 
			{
				bw.close();
			} 
			catch (IOException ioe2) 
			{
				// just ignore it
			}
		} // end try/catch/finally
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outputString", sw.toString() );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void convertToCSVFormat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertToCSVFormat)>> ---
		// @sigtype java 3.5
		// [i] field:0:required rawValue
		// [o] field:0:required csvFormatValue
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("rawValue"))
		{
		  String rawValue = (String)cursor.getValue();
		  setValue(cursor, "csvFormattedValue", getCSVFormattedString(rawValue));
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void documentValuesToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(documentValuesToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required delimiter
		// [i] record:0:required document
		// [o] field:0:required outString
		
		// pipeline
		IDataCursor idc = pipeline.getCursor();
		
		String outString = null;
		String delimiter = null;
			
			if (idc.first("delimiter"))
				delimiter = (String)idc.getValue();
			else
				throw new ServiceException("no delimiter");
		
			if (idc.first("document"))
			idc = ((IData)idc.getValue()).getCursor();
		
			idc.first();
			
			if (idc.getValue() instanceof String)
			outString = ((idc.getValue()==null)?(""):((String)idc.getValue()));
		
			while(idc.next()) 
			{
				//outString = outString + delimiter + idc.getKey();
				if (idc.getValue() instanceof String)
				outString = outString + delimiter + ((idc.getValue()==null)?(""):((String)idc.getValue()));
			}
		
			idc = pipeline.getCursor();
		
			if (idc.first("outString"))
				idc.setValue(outString);
			else
				idc.insertAfter("outString", outString);
			
		idc.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void formatSchemaValidationErrors (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(formatSchemaValidationErrors)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required errors
		// [i] - field:0:required pathName
		// [i] - field:0:required errorCode
		// [i] - field:0:required errorMessage
		// [o] field:0:required FormattedSchemavalidationString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			String FormattedSchemavalidationString = null;
			// errors
			IData[]	errors = IDataUtil.getIDataArray( pipelineCursor, "errors" );
			if ( errors != null)
			{
				String tempStr = null;
			
				for ( int i = 0; i < errors.length; i++ )
				{
					IDataCursor errorsCursor = errors[i].getCursor();
						String	pathName = IDataUtil.getString( errorsCursor, "pathName" );
						String	errorCode = IDataUtil.getString( errorsCursor, "errorCode" );
						String	errorMessage = IDataUtil.getString( errorsCursor, "errorMessage" );
						
						tempStr = pathName+"\n"+errorMessage+"\n";
						
						if (errorsCursor != null)
						{
							
							if (i == 0)
								FormattedSchemavalidationString = tempStr;
							else
								FormattedSchemavalidationString = FormattedSchemavalidationString+tempStr;
						
							/*
							if (pathName != null && errorMessage != null)
							{
								if (i == 0)
									FormattedSchemavalidationString = tempStr;
								else
									FormattedSchemavalidationString = FormattedSchemavalidationString+tempStr;
							}
							*/
						}
						
					errorsCursor.destroy();
				}
				IDataUtil.put( pipelineCursor, "FormattedSchemavalidationString", FormattedSchemavalidationString );
			}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getCSVRecord (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getCSVRecord)>> ---
		// @sigtype java 3.5
		// [i] record:0:required record
		// [o] record:0:required csvRecord
		IDataCursor cursor = pipeline.getCursor();
		
		if (cursor.first("record"))
		{
		  IData csvRecord = IDataFactory.create();
		  IData record = (IData)cursor.getValue();
		  IDataCursor recordCursor = record.getCursor();
		  IDataCursor csvRecordCursor = csvRecord.getCursor();
		  while (recordCursor.next())
		  {
		    String key = recordCursor.getKey();
		    Object obj = recordCursor.getValue();
		    if (obj instanceof String)
		    {
		      csvRecordCursor.insertAfter(key, getCSVFormattedString((String)obj));
		    }
		    else
		    {
		      csvRecordCursor.insertAfter(key, obj);
		    }
		  }
		  recordCursor.destroy();
		  csvRecordCursor.destroy();
		  setValue(cursor, "csvRecord", csvRecord);
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getLastChar (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getLastChar)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required lastChar
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		pipelineCursor.destroy();
		
		//String lastChar = "";
		String lastChar = new String(inString.substring(inString.length() - 1, inString.length()));
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "lastChar", lastChar );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void makeStringFromObjectList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(makeStringFromObjectList)>> ---
		// @sigtype java 3.5
		// [i] object:1:required objectList
		// [i] field:0:required separator
		// [o] field:0:required outputString
		IDataCursor idc = pipeline.getCursor();
		Object [] obj = IDataUtil.getObjectArray(idc, "objectList");
		String sep = IDataUtil.getString(idc,"separator");
		idc.destroy();
		
		String outputString = "";
		if (obj != null){
			for(int i=0; i<obj.length;i++){
				outputString = outputString + obj[i].toString() + sep;
			}
			outputString = outputString.substring(0,outputString.length() - 1);
		}
		
		IDataCursor idc1 = pipeline.getCursor();
		IDataUtil.put(idc, "outputString", outputString);
		idc1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void multiConcat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(multiConcat)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inStr1
		// [i] field:0:required inStr2
		// [i] field:0:required inStr3
		// [i] field:0:required inStr4
		// [i] field:0:required inStr5
		// [i] field:0:required inStr6
		// [i] field:0:required inStr7
		// [i] field:0:required inStr8
		// [i] field:0:required inStr9
		// [i] field:0:required inStr10
		// [o] field:0:required outStr
		// pipeline
		// Based on the multiConcat logic from the PSUtilities package
		
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inStr1 = checkNull(IDataUtil.getString( pipelineCursor, "inStr1" ));
			String	inStr2 = checkNull(IDataUtil.getString( pipelineCursor, "inStr2" ));
			String	inStr3 = checkNull(IDataUtil.getString( pipelineCursor, "inStr3" ));
			String	inStr4 = checkNull(IDataUtil.getString( pipelineCursor, "inStr4" ));
			String	inStr5 = checkNull(IDataUtil.getString( pipelineCursor, "inStr5" ));
			String	inStr6 = checkNull(IDataUtil.getString( pipelineCursor, "inStr6" ));
			String	inStr7 = checkNull(IDataUtil.getString( pipelineCursor, "inStr7" ));
			String	inStr8 = checkNull(IDataUtil.getString( pipelineCursor, "inStr8" ));
			String	inStr9 = checkNull(IDataUtil.getString( pipelineCursor, "inStr9" ));
			String	inStr10 = checkNull(IDataUtil.getString( pipelineCursor, "inStr10" ));
		
		
		String outStr = inStr1 + inStr2 + inStr3 + inStr4 + inStr5 + inStr6 + inStr7 + inStr8 + inStr9 + inStr10;
		IDataUtil.put( pipelineCursor, "outStr", outStr );
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void multiConcatFromList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(multiConcatFromList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required StrList
		// [o] field:0:required outStr
		// pipeline
		// Index the input Strings to StrList array
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			String[] StrList = IDataUtil.getStringArray( pipelineCursor, "StrList" );
			if ( StrList != null)
			{
				String outStr = "";
				for ( int i = 0; i < StrList.length; i++ )
				{
					try
					{
						String	inStr = checkNull(StrList[i]);
						//Debug.log(4,"StrValue is ..."+inStr);
						outStr = outStr+inStr;
					}
					catch(Exception e)
					{ //Do Nothing 
					}
					//Debug.log(4,"Iteration number after"+i);				
				}
				IDataUtil.put( pipelineCursor, "outStr", outStr );
			}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void parse (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parse)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:optional outputRecord {"true","false"}
		// [i] field:0:optional maxLength
		// [i] field:0:optional delimitor
		// [i] record:1:optional fields
		// [i] - field:0:required name
		// [i] - field:0:optional startIndex
		// [i] - field:0:optional length
		// [i] field:0:optional ignoreWhitespace {"true","false"}
		// [o] record:0:optional record
		// [o] field:1:optional list
		IDataCursor cursor = pipeline.getCursor();
		
		String line = "";
		boolean outputRecord = true;
		boolean ignoreWhitespace = true;
		String delimitor = null;
		StringTokenizer tokenizer = null;
		String[] tokens = null;
		
		if (cursor.first("inString"))
		{
		  line = (String)cursor.getValue();
		  if (cursor.first("ignoreWhitespace"))
		  {
		    ignoreWhitespace = Boolean.valueOf((String)cursor.getValue()).booleanValue();
		  }
		
		  if (cursor.first("outputRecord"))
		  {
		    outputRecord = Boolean.valueOf((String)cursor.getValue()).booleanValue();
		  }
		
		  //Create an array of tokens from the String using the delimitor
		  if (cursor.first("delimitor"))
		  {
		    delimitor = (String)cursor.getValue();
		    if (delimitor != null && delimitor.length() > 0)
		    {
		      tokens = tokenize(line, delimitor);
		    }
		  }
		 
		  //If the output is to be in a record format
		  if (outputRecord)
		  {
		    //Create the output record to hold the fields
		    IData outRecord = IDataFactory.create();
		    IDataCursor outRecordCursor = outRecord.getCursor();
		
		    if (cursor.first("fields"))
		    {
		      //Get the fields list
		      IData[] fields = (IData[])cursor.getValue();
		      for (int i=0; i<fields.length; i++)
		      {
		        //Extract the name of the current field
		        IDataCursor fieldCursor = fields[i].getCursor();
		        try
		        {
		          if (delimitor != null && delimitor.length() > 0)
		          {
		             String name = null;
		             if (fieldCursor.first("name"))
		             {
		               name = (String)fieldCursor.getValue();
		             }
		             else
		             {
		               throw _instance.new BadFieldException("Field does not have a 'name' attribute");
		             }
		
		             String token = tokens[i];
		             outRecordCursor.insertAfter(name, ignoreWhitespace ? token.trim().length() > 0 ? token.trim() : null 
		                                                           : token);
		          }
		          else
		          {
		            //Create a field object from the input values
		            Field field = _instance.new Field(fieldCursor);
		            //Calculate the fixed length positions of this field
		            int startIndex = field.getStartIndex();
		            int endIndex = field.getStartIndex() + field.getLength();
		
		            if (startIndex > line.length())
		            {
		              outRecordCursor.insertAfter(field.getName(), null);
		            }
		            else if (endIndex >= line.length())
		            {
		              String value = line.substring(startIndex);
		              outRecordCursor.insertAfter(field.getName(), 
		                                          ignoreWhitespace ? value.trim().length() > 0 ? value.trim() : null 
		                                                           : value);
		            }
		            else
		            {
		              String value = line.substring(startIndex, endIndex);
		              outRecordCursor.insertAfter(field.getName(), 
		                                          ignoreWhitespace ? value.trim().length() > 0 ? value.trim() : null
		                                                           : value);
		            }
		          }
		        }
		        catch (BadFieldException bfe)
		        {
		          throw new ServiceException(bfe.getMessage());
		        }
		        fieldCursor.destroy();
		      }
		    }
		    else
		    {
		      throw new ServiceException("Input 'fields' must exist when outputRecord is set to 'true'");
		    }
		    
		    outRecordCursor.destroy();
		    if (cursor.first("record"))
		    {
		      cursor.setValue(outRecord);
		    }
		    else
		    {
		      cursor.insertAfter("record", outRecord);
		    }
		  }
		  else
		  {
		    //Simple String List needed
		    String[] array;
		
		    if (delimitor != null && delimitor.length() > 0)
		    {
		      array = new String[tokens.length];
		      for (int i=0; i < array.length; i++)
		      {
		        array[i] = ignoreWhitespace ? tokens[i].trim().length() > 0 ? tokens[i].trim() : null 
		                                      : tokens[i];
		      }
		    }
		    else
		    {
		      int maxLength = 0;
		
		      if (cursor.first("maxLength"))
		      {
		        maxLength = Integer.parseInt((String)cursor.getValue());
		      }
		
		      if (maxLength <= 0)
		      {
		        throw new ServiceException("Input 'maxLength' or 'delimitor' must exist when outputRecord is set to 'false'");
		      }
		
		      array = new String[line.length()/maxLength + 1];
		      for (int i=0; i < array.length; i++)
		      {
		        if ((i+1)*maxLength > line.length())
		        {
		          String value = line.substring(i*maxLength);
		          array[i] = ignoreWhitespace ? value.trim().length() > 0 ? value.trim() : null 
		                                      : value;
		        }
		        else
		        {
		          String value = line.substring(i*maxLength, (i+1)*maxLength);
		          array[i] = ignoreWhitespace ? value.trim().length() > 0 ? value.trim() : null 
		                                      : value;
		        }
		      }
		    }
		
		    if (cursor.first("list"))
		    {
		      cursor.setValue(array);
		    }
		    else
		    {
		      cursor.insertAfter("list", array);
		    }
		  }
		}
		else
		{
		  throw new ServiceException("Missing input 'inString'");
		}
		
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void parseDelimitedStringWithQuoteRemoval (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseDelimitedStringWithQuoteRemoval)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required delimitedString
		// [i] field:0:optional delimiter
		// [i] field:0:optional quote
		// [o] field:1:required stringValues
		//Get input values.
		IDataCursor pipelineCursor = pipeline.getCursor();
		String delimitedString = IDataUtil.getString( pipelineCursor, "delimitedString" );
		String delimiter = IDataUtil.getString( pipelineCursor, "delimiter" );
		String quote = IDataUtil.getString( pipelineCursor, "quote" );
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (delimitedString == null)
		{
			//Nothing to process.
			return;
		}
		if (delimiter == null || delimiter.equals(""))
		{
			//Default to a comma.
			delimiter = ",";
		}
		int quoteLength = 0;
		if (quote == null || quote.equals(""))
		{
			quoteLength = 0;
		}
		else
		{
			quoteLength = quote.length();
		}
		
		//Split the string based on the delimiter.
		String delimReplacer = System.getProperty("line.separator");
		String[] stringValues = null;
		int count = 0;
		int stringLength = 0;
		try
		{
			StringBuffer quotedDelimitedString = new StringBuffer();
			String thisString = "";
			if (quoteLength > 0)
			{
				//Convert any delimiter characters that appear inside the quotes to newlines.
				StringTokenizer quoteTokenizer = new StringTokenizer(delimitedString, quote, true);
				boolean insideQuote = false;
				while (quoteTokenizer.hasMoreTokens())
				{
					thisString = quoteTokenizer.nextToken();
					if (thisString.equals(quote))
					{
						insideQuote = !insideQuote;
					}
					else if (insideQuote)
					{
						int delimLoc = thisString.indexOf(delimiter);
						while (delimLoc > -1)
						{
							thisString = 
								thisString.substring(0, delimLoc) +
								delimReplacer +
								thisString.substring(delimLoc + delimiter.length());
							delimLoc = thisString.indexOf(delimiter);
						}
					}
					quotedDelimitedString.append(thisString);
				}
			}
			else
			{
				//No quotes, just use the whole string.
				quotedDelimitedString.append(delimitedString);
			}
			StringTokenizer tokenizer = 
				new StringTokenizer(quotedDelimitedString.toString(), delimiter, true);
			Vector stringVec = new Vector();
			boolean lastWasDelimiter = false;
			while (tokenizer.hasMoreTokens())
			{
				thisString = tokenizer.nextToken();
				if (thisString.equals(delimiter))
				{
					if (lastWasDelimiter)
					{
						//Two delimiters means this value is actually the empty string.
						stringVec.add("");
					}
					else
					{
						//Normal delimiter, set last flag and go on to next token.
						lastWasDelimiter = true;
					}
				}
				else
				{
					//Non-delimiter token.
					lastWasDelimiter = false;
					if (quoteLength == 0)
					{
						//No quote value, don't try to trim.
					}
					else
					{
						if (thisString != null && 
							thisString.length() >= (quoteLength * 2))
						{
							stringLength = thisString.length();
							//There's enough characters that we might have quotes.
							if (thisString.substring(0, quoteLength).equals(quote) &&
								thisString.substring(stringLength - quoteLength, stringLength).equals(quote))
							{
								//Quotes existed as the first and last thing in the string, so remove them.
								thisString = thisString.substring(quoteLength, stringLength - quoteLength);
							}
						}
					} //end else (quoteLength != 0)
		
					//Add the value to the string Vector.
					stringVec.add(thisString);
				} //end else (non-delimiter token)
			} //end while there are more tokens
		
			//Convert the Vector to an array for returning.
			stringValues = (String[]) stringVec.toArray(new String[1]);
		
			//Put any replaced delimiters back.
			for (int i = 0; i < stringValues.length; i++)
			{
				int delimLoc = stringValues[i].indexOf(delimReplacer);
				while (delimLoc > -1)
				{
					stringValues[i] = 
						stringValues[i].substring(0, delimLoc) +
						delimiter +
						stringValues[i].substring(delimLoc + delimReplacer.length());
					delimLoc = stringValues[i].indexOf(delimReplacer);
				}
			}
		}
		catch (Exception e)
		{
			throw new ServiceException("Error parsing string: " + e);
		}
		
		//Output the parsed value.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "stringValues", stringValues );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void removeAllLeadingZeroes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeAllLeadingZeroes)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required outString
		 /*
			Removing Leading Zeros from Alphanumeric String Utility
			Author:  Crowe Chizek
			Date:    12/16/03
			- If the input string is null then returns null
			- Else removes all the leading zeros.
		*/ 
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		
		char c;
		int count = 0;
		int strLength = 0; //inString.length();
		String outString ;
		
		if(inString == null){
			outString = null;
		}
		else {
			strLength = inString.length();
			for(int i=0; i < inString.length(); i++){
				c = inString.charAt(i);
		    	if(c == '0'){
		    	count++;
		    	}
		    	else{
		    		break;
		    	}
			}
			//str = new Integer(count).toString();
			outString = inString.substring(count,strLength);
		}
		
		
		pipelineCursor.insertAfter("outString", outString);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void replaceIfNull (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(replaceIfNull)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required checkValue
		// [i] field:0:required replaceWithValue
		// [o] field:0:required value
		IDataCursor cursor = pipeline.getCursor();
		String inputValue       = null;
		String replaceWithValue = null;
		
		if (cursor.last("checkValue")) 
		{	
			inputValue = (String) cursor.getValue();
		}
		
		if ((inputValue == null) || (inputValue.equals(""))) {
			if (cursor.last("replaceWithValue"))
			{
				cursor.insertAfter("value", (String) cursor.getValue());
			}
		}
		else {
				cursor.insertAfter("value", inputValue);
		}
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void replaceIfValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(replaceIfValue)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inputValue
		// [i] record:1:required checkReplaceValues
		// [i] - field:0:required checkValue
		// [i] - field:0:required replaceWithValue
		// [i] field:0:optional defaultValue
		// [o] field:0:required value
		IDataCursor cursor                 = pipeline.getCursor();
		String      inputValue             = null;
		IData[]     checkReplaceValues     = null;
		IData       checkReplaceValuesItem = null;
		IDataCursor itemCursor             = null;
		String      itemCheckValue         = null;
		String		itemReplaceValue	   = "";
		boolean		replacementFound	   = false;
		
		// Retrieve the input value.
		if (cursor.last("inputValue")) 
		{	
			inputValue = (String) cursor.getValue();
		}
		
		// Retrieve the default value.
		if (cursor.last("defaultValue")) 
		{	
			// Return the default value if no replacement found.
			itemReplaceValue = (String) cursor.getValue();
		}
		else {
			// Return the original value if no replacement found.
			itemReplaceValue = inputValue;
		}	
		
		
		
		// Retrieve the list of find/replace values.
		if (cursor.last("checkReplaceValues"))
		{
			checkReplaceValues = (IData[]) cursor.getValue();
		}
		
		
		//  Look for find/replace matches.
		for (int i=0; (i < checkReplaceValues.length) && !replacementFound; i++)
		{
			// Get this item from the list to check.
			checkReplaceValuesItem = checkReplaceValues[i];
			itemCursor = checkReplaceValuesItem.getCursor();
			if (itemCursor.last("checkValue")) 
			{
				itemCheckValue = (String) itemCursor.getValue();
			}
			else 
			{
				itemCheckValue = null;
			}
		
			// Check for null values.
			if (itemCheckValue == null)
			{
				if (inputValue == null) 
				{
					if (itemCursor.last("replaceWithValue")) 
					{
						itemReplaceValue = (String) itemCursor.getValue();
					}
					else 
					{
						itemReplaceValue = "";
					}
					replacementFound = true;
				}
			}
		
			// See if this check item matches the input.
			else if (itemCheckValue.equals(inputValue))   
			{
				// Found a match, get the replacement value.
				if (itemCursor.last("replaceWithValue"))
				{
					itemReplaceValue = (String) itemCursor.getValue();
				}
				else
				{
					itemReplaceValue = "";
				}
				replacementFound = true;
			}
		}
		
		
		// Return the result.
		cursor.last();
		cursor.insertAfter("value", itemReplaceValue);
		
		if (itemCursor != null)
		{
			itemCursor.destroy();
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void splitString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required delimeter
		// [o] field:1:required valueList
		IDataCursor pipelineCursorIn = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursorIn, "inString" );
		String delemiter = IDataUtil.getString( pipelineCursorIn, "delimeter" );
		pipelineCursorIn.destroy();
		
		String[] valueList = inString.split(delemiter, -1);
		IDataCursor pipelineCursorOut = pipeline.getCursor();
		pipelineCursorOut.insertAfter("valueList", valueList);		
		pipelineCursorOut.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void streamToString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(streamToString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required stream
		// [o] field:0:required string
		IDataCursor idhc = pipeline.getCursor();
		
		InputStream is=null;
		
		while (idhc.next() ) {
			if ( idhc.getKey().equals("stream") ) {
		
				is = (InputStream)idhc.getValue();
		
				break;
			}
		}
		
		if (is != null ) {
			byte b[] = new byte[8192];
		
			ByteOutputBuffer out = new ByteOutputBuffer();
		
			int read;
		
			try {
				while ( (read = is.read(b)) > 0 ) {
		
					//	System.err.print((char)read);
		
				   out.write(b, 0, read);
		
				}
		
				String string = out.toString();
		
				idhc.last();
		
				idhc.insertAfter("string", string);
		
			} catch ( IOException ioe ) {
		
				throw new ServiceException(ioe.getMessage() );
		
			}
		
			idhc.destroy();
		} else {
		
			throw new ServiceException("No content");
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void stringToStream (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToStream)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string
		// [o] object:0:required stream
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		pipelineCursor.first("string");
		
		String string = (String)pipelineCursor.getValue();
		
		pipelineCursor.destroy();
		
		StringBufferInputStream output = new StringBufferInputStream(string);
		
		pipelineCursor = pipeline.getCursor();
		
		while (pipelineCursor.first("stream")){
		
			pipelineCursor.delete();
		
		}
		
		pipelineCursor.last();
		
		Object inputStream = output;
		
		pipelineCursor.insertAfter("stream", inputStream );
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void subString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(subString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [i] field:0:required searchString
		// [o] field:0:required subString
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		String	searchString = IDataUtil.getString( pipelineCursor, "searchString" );
		pipelineCursor.destroy();
		String subString=null;
		
		if (inString != null)
		{
		subString = new String(inString.substring(inString.indexOf(searchString)));
		subString=subString.replace(" ","");
		}
		else
		{subString = "GMT";}
		
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		
		IDataUtil.put( pipelineCursor_1, "subString", subString );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void toProperCase (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(toProperCase)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required outString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		
		try
		{
			inString = (inString.substring(0, 1)).toUpperCase()	+ (inString.substring(1)).toLowerCase();
			int spacePos = 0;
			int startPos = 0;
		
			while (inString.length() > 1 && (spacePos = inString.indexOf(" ", startPos)) > -1 )
			{
				inString = inString.substring(0, spacePos + 1) 
							+ (inString.substring(spacePos + 1, spacePos + 2)).toUpperCase()
							+ inString.substring(spacePos+2);
				startPos = spacePos + 2;
			}
		}
		catch (Exception x)
		{
			System.out.println("Error while parsing string");
			inString = IDataUtil.getString( pipelineCursor, "inString" );
		}
		
		IDataUtil.put( pipelineCursor, "outString", inString);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static String getCSVFormattedString(String rawValue)
	{
	  StringBuffer csvFormattedValue = new StringBuffer();
	  if (rawValue != null && rawValue.length() > 0)
	  {
	    for (int i=0; i<rawValue.length(); i++)
	    {
	      char ch = rawValue.charAt(i);
	      if (ch == '"')
	      {
	        csvFormattedValue.append('"');
	      }
	      csvFormattedValue.append(ch);
	    }
	
	    if (csvFormattedValue.toString().indexOf(',') >=0 || 
	        csvFormattedValue.toString().indexOf('"') >=0)
	    {
	      return "\"" + csvFormattedValue + "\"";
	    }
	    else
	    {
	      return csvFormattedValue.toString();
	    }
	  }
	  return rawValue;
	}
	
	private static void setValue(IDataCursor cursor, String name, Object value)
	{
	  if (cursor.first(name))
	  {
	    cursor.setValue(value);
	  }
	  else
	  {
	    cursor.insertAfter(name, value);
	  }
	}
	
	private static String[] tokenize(String string, String delimitor)
	{
	  Vector vector = new Vector();
	  int index = 0;
	  int prevIndex =0;
	
	  while ((index = string.indexOf(delimitor, prevIndex)) >= 0)
	  {
	    vector.addElement(string.substring(prevIndex, index));
	    prevIndex = index + 1;
	  }
	  vector.addElement(string.substring(prevIndex));
	  String[] array = new String[vector.size()];
	  for (int i=0; i<array.length; i++)
	  {
	    array[i] = (String)vector.elementAt(i);
	  }
	
	  return array;
	}
	
	
	
	class BadFieldException extends Exception
	{
	  BadFieldException(String message)
	  {
	    super(message);
	  }
	}
	
	class Field
	{
	  private String name;
	  private int startIndex = 0;
	  private int length = 0;
	
	  Field(IDataCursor cursor) throws BadFieldException
	  {
	    if (cursor.first("name"))
	    {
	      setName((String)cursor.getValue());
	    }
	    else
	    {
	      throw new BadFieldException("Field does not have a 'name' attribute");
	    }
	
	    try
	    {
	      if (cursor.first("startIndex"))
	      {
	        setStartIndex(Integer.parseInt((String)cursor.getValue()));
	      }
	      else
	      {
	        throw new BadFieldException("Field '" + name + "' does not have a 'startIndex' attribute");
	      }
	    }
	    catch (NumberFormatException nfe)
	    {
	      throw new BadFieldException("Field '" + name + "' must have a numeric 'startIndex' attribute");
	    }
	    
	    try
	    {    
	
	      if (cursor.first("length"))
	      { 
	        setLength(Integer.parseInt((String)cursor.getValue()));
	      }
	      else
	      {
	        throw new BadFieldException("Field '" + name + "' does not have a 'length' attribute");
	      }
	    }
	    catch (NumberFormatException nfe)
	    {
	      throw new BadFieldException("Field '" + name + "' must have a numeric 'length' attribute");
	    }
	  }
	
	  Field(String name, int startIndex, int length)
	  {
	    this.name = name;
	    this.startIndex = startIndex;
	    this.length = length;
	  }
	
	  public void setName(String name)
	  {
	    this.name = name;
	  }
	
	  public void setStartIndex(int startIndex)
	  {
	    this.startIndex = startIndex;
	  }
	
	  public void setLength(int length)
	  {
	    this.length = length;
	  }
	
	  public String getName()
	  {
	    return this.name;
	  }
	
	  public int getStartIndex()
	  {
	    return this.startIndex;
	  }
	
	  public int getLength()
	  {
	    return this.length;
	  }
	}
	//Created on May 14 2009 
	private static String checkNull(String inputString)
	{
		if( inputString == null )
			return "";
		else
			return inputString;
	}
		
	// --- <<IS-END-SHARED>> ---
}

