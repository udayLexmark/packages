package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-02-26 07:04:42 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Vector;
import java.util.Hashtable;
import java.util.Iterator;
// --- <<IS-END-IMPORTS>> ---

public final class list

{
	// ---( internal utility methods )---

	final static list _instance = new list();

	static list _newInstance() { return new list(); }

	static list _cast(Object o) { return (list)o; }

	// ---( server methods )---




	public static final void appendDocumentToVectorList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendDocumentToVectorList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required inputVector
		// [i] record:0:required inputDoc
		// [o] object:0:required vector
		//Get inputs from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object inputVector = IDataUtil.get(pipelineCursor, "inputVector");
		IData inputDoc = IDataUtil.getIData(pipelineCursor, "inputDoc");
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (inputVector == null || !(inputVector instanceof Vector))
		{
			//No input Vector.
			throw new ServiceException("The inputVector must be a Vector object.");
		}
		
		//The return value will start with the input Vector.
		Vector returnVal = (Vector) inputVector;
		if (inputDoc != null)
		{
			//Add the document to the Vector.
			returnVal.add(inputDoc);
		}
		
		//Return the Vector.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_1, "vector", returnVal);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void appendUniqueToDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendUniqueToDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:optional documentList
		// [i] record:0:required document
		// [i] field:0:required keyField
		// [i] field:0:optional ignoreCase {"true","false"}
		// [o] record:1:required documentList
		IDataCursor cursor = pipeline.getCursor();
				
		IData item = null;
		IData[] items = null;
		IData[] newItems;
		boolean added = false;
		String keyField = null;
		boolean ignoreCase = false;
				
		if (cursor.first("document"))
		{
		  item = (IData)cursor.getValue();
		}
				
		if (item == null)
		{
		  throw new ServiceException("Missing input 'document'");
		}
		
		if (cursor.first("ignoreCase"))
		{
		  ignoreCase = Boolean.valueOf((String)cursor.getValue()).booleanValue();
		}
		
		if (cursor.first("keyField"))
		{
		  keyField = (String)cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'keyField'");
		}
		
		IDataCursor itemCursor = item.getCursor();
		String keyValue = null;
		if (itemCursor.first())
		{
		  keyValue = (String)itemCursor.getValue();
		}
		itemCursor.destroy();
		
		if (keyValue == null || keyValue.length() == 0)
		{
		  added = false;
		}
		else
		{
				
		  if (cursor.first("documentList"))
		  {
		    items = (IData[])cursor.getValue();
		  }
				
		  if (items == null)
		  {
		    newItems = new IData[]{item};
		    added = true;  
		  }
		  else
		  {
		    if (!findKeyInList(keyField, keyValue, items, ignoreCase))
		    {
			  newItems = new IData[items.length + 1];
			  for (int i=0; i<items.length; i++)
		      {
		        newItems[i] = items[i];
		      }
			  newItems[newItems.length - 1] = item;
			  added = true;
		    }
		    else
		    {
		      newItems = items;
		    }
		  }
		  IDataUtil.put(cursor, "documentList", newItems);
		}
			
		IDataUtil.put(cursor, "itemAdded", String.valueOf(added));
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void appendUniqueToStringList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendUniqueToStringList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:optional stringList
		// [i] field:0:required item
		// [i] field:0:optional ignoreCase {"true","false"}
		// [o] field:1:required stringList
		IDataCursor cursor = pipeline.getCursor();
				
		String item = null;
		String[] items = null;
		String[] newItems;
		boolean added = false;
		boolean ignoreCase = false;
				
		if (cursor.first("ignoreCase"))
		{
		  ignoreCase = Boolean.valueOf((String)cursor.getValue()).booleanValue();
		}
				
		if (cursor.first("item"))
		{
		  item = (String)cursor.getValue();
		}
				
		if (item == null || item.length() == 0)
		{
		  throw new ServiceException("Missing input 'item'");
		}
				
		if (cursor.first("stringList"))
		{
		  items = (String[])cursor.getValue();
		}
				
		if (items == null)
		{
		  newItems = new String[]{item};
		  added = true;  
		}
		else
		{
		  if (!findInStringList(item, items, ignoreCase))
		  {
			newItems = new String[items.length + 1];
			System.arraycopy(items, 0, newItems, 0, items.length);
			newItems[newItems.length - 1] = item;
			added = true;
		  }
		  else
		  {
		    newItems = items;
		  }
		}
				
		IDataUtil.put(cursor, "stringList", newItems);
		IDataUtil.put(cursor, "itemAdded", String.valueOf(added));
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void createDocumentListFromVector (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createDocumentListFromVector)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required vector
		// [o] record:1:required outputList
		//Get inputs from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object inputVector = IDataUtil.get( pipelineCursor, "vector" );
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (inputVector == null || !(inputVector instanceof Vector))
		{
			//No input Vector.
			throw new ServiceException("The input vector must be a Vector object.");
		}
		Vector inVector = (Vector) inputVector;
		if (inVector.size() < 1)
		{
			//Empty vector - return nothing.
			return;
		}
		
		//Create an array from the Vector.
		IData[] outputList = new IData[1];
		try
		{
			outputList = (IData[]) inVector.toArray(outputList);
		}
		catch (Exception e)
		{
			throw new ServiceException("Unable to convert Vector to document list: " + e);
		}
		
		//Return the output list.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_1, "outputList", outputList);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void createHashtableFromDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createHashtableFromDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required inputList
		// [i] field:0:required keyField
		// [o] object:0:required hashtable
		
		//Get inputs from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[] inputList = IDataUtil.getIDataArray( pipelineCursor, "inputList" );
		String keyField = IDataUtil.getString( pipelineCursor, "keyField" );
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (inputList == null || inputList.length < 1)
		{
			//No input list - return an empty Hashtable.
			IDataCursor pipelineCursor_2 = pipeline.getCursor();
			IDataUtil.put(pipelineCursor_2, "hashtable", new Hashtable());
			pipelineCursor_2.destroy();
			return;
		}
		if (keyField == null || keyField.trim().equals(""))
		{
			//No key field to use. Invalid input.
			throw new ServiceException ("No key field value provided to generate Hashtable");
		}
		
		//Create the Hashtable.
		Hashtable hashtable = new Hashtable();
		
		//Loop through the input list, adding each record to the Hashtable.
		IDataCursor inputListCursor = null;
		String keyVal = null;
		Object oldVal = null;
		Vector dupes = new Vector();
		for (int i = 0; i < inputList.length; i++)
		{
			inputListCursor = inputList[i].getCursor();
			keyVal = IDataUtil.getString(inputListCursor, keyField);
			if (keyVal == null)
			{
				throw new ServiceException ("Found list element (" + i + ") with no key value");
			}
			oldVal = hashtable.put(keyVal, inputList[i]);
			if (oldVal != null)
			{
				dupes.add(keyVal);
				oldVal = null;
			}
		}
		
		//Remove any duplicates.
		Iterator dupeIterator = dupes.iterator();
		while (dupeIterator.hasNext())
		{
			hashtable.remove(dupeIterator.next());
		}
		
		//Return the hashtable.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "hashtable", hashtable );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void createUniqueHashtableFromDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createUniqueHashtableFromDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required inputList
		// [i] field:0:required keyField
		// [o] object:0:required hashtable
		
		//Get inputs from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[] inputList = IDataUtil.getIDataArray( pipelineCursor, "inputList" );
		String keyField = IDataUtil.getString( pipelineCursor, "keyField" );
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (inputList == null || inputList.length < 1)
		{
			//No input list - return an empty Hashtable.
			IDataCursor pipelineCursor_2 = pipeline.getCursor();
			IDataUtil.put(pipelineCursor_2, "hashtable", new Hashtable());
			pipelineCursor_2.destroy();
			return;
		}
		if (keyField == null || keyField.trim().equals(""))
		{
			//No key field to use. Invalid input.
			throw new ServiceException ("No key field value provided to generate Hashtable");
		}
		
		//Create the Hashtable.
		Hashtable hashtable = new Hashtable();
		
		//Loop through the input list, adding each record to the Hashtable.
		IDataCursor inputListCursor = null;
		String keyVal = null;
		Object oldVal = null;
		Vector dupes = new Vector();
		for (int i = 0; i < inputList.length; i++)
		{
			inputListCursor = inputList[i].getCursor();
			keyVal = IDataUtil.getString(inputListCursor, keyField);
			if (keyVal == null)
			{
				throw new ServiceException ("Found list element (" + i + ") with no key value");
			}
			oldVal = hashtable.put(keyVal, inputList[i]);
			if (oldVal != null)
			{
				dupes.add(keyVal);
				oldVal = null;
			}
		}
		
		//Remove any duplicates.
		/*Iterator dupeIterator = dupes.iterator();
		while (dupeIterator.hasNext())
		{
			hashtable.remove(dupeIterator.next());
		}
		*/
		//Return the hashtable.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "hashtable", hashtable );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void createVectorFromDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createVectorFromDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required inputList
		// [o] object:0:required vector
		
		//Get inputs from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData[] inputList = IDataUtil.getIDataArray( pipelineCursor, "inputList" );
		pipelineCursor.destroy();
		
		Vector returnVal = null;
		
		//Check the inputs.
		if (inputList == null || inputList.length < 1)
		{
			//No input list - make an empty Vector.
			returnVal = new Vector();
		}
		else
		{
			//Create the Vector.
			returnVal = new Vector();
		
			//Loop through the input list, adding each record to the Vector.
			IDataCursor inputListCursor = null;
			for (int i = 0; i < inputList.length; i++)
			{
				returnVal.add(inputList[i]);
			}
		}
		
		//Return the Vector.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_1, "vector", returnVal);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getListElementByKey (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getListElementByKey)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required hashtable
		// [i] field:0:required keyValue
		// [o] record:0:required listElement
		
		//Get input values.
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object hashtable = IDataUtil.get( pipelineCursor, "hashtable" );
		String keyValue = IDataUtil.getString( pipelineCursor, "keyValue" );
		pipelineCursor.destroy();
		
		//Check the inputs.
		if (keyValue == null)
		{
			//Nothing to look up.
			return;
		}
		if (!(hashtable instanceof Hashtable))
		{
			//Wrong type of object to work with.
			throw new ServiceException ("The hashtable instance must be a java.util.Hashtable");
		}
		
		//Get the value.
		IData listElement = null;
		Hashtable hash = (Hashtable) hashtable;
		Object storedObj = hash.get(keyValue);
		if (storedObj == null)
		{
			//Found nothing.
			return;
		}
		else if (!(storedObj instanceof IData))
		{
			//Hashtable was invalid.
			throw new ServiceException ("Found a non-IData object in the Hashtable");
		}
		else
		{
			listElement = (IData) storedObj;
		}
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "listElement", listElement );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getListSize (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getListSize)>> ---
		// @sigtype java 3.5
		// [i] object:1:required list
		// [o] field:0:required size
		IDataCursor cursor = pipeline.getCursor();
		int size = 0;
		Object[] objectArray = null;
		
		//Get the list object from the pipeline
		if (cursor.first("list"))
		{
		  objectArray = (Object[])cursor.getValue();
		  //Get the length of the list
		  if (objectArray != null)
		  {
		    size = objectArray.length;
		  }
		  else
		  {
		    size = -1;
		  }
		}
		
		if (cursor.first("size"))
		{
		  cursor.setValue(String.valueOf(size));
		}
		else
		{
		  cursor.insertAfter("size",String.valueOf(size));
		}
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void insertIntoSortedStringList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(insertIntoSortedStringList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required sortedListInput
		// [i] field:0:required newString
		// [i] field:0:optional allowDuplicates
		// [o] field:1:required sortedListOutput
		//Get input from the pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[] sortedListInput = IDataUtil.getStringArray(pipelineCursor, "sortedListInput");
		String newString = IDataUtil.getString(pipelineCursor, "newString");
		String allowDuplicates = IDataUtil.getString(pipelineCursor, "allowDuplicates");
		pipelineCursor.destroy();
		
		String[] sortedListOutput = null;
		boolean checkDupe = false;
		
		//Check inputs.
		if (allowDuplicates != null && allowDuplicates.equals("false"))
		{
			checkDupe = true;
		}
		if (newString == null)
		{
			//No input string - return the input list.
			sortedListOutput = sortedListInput;
		}
		else if (sortedListInput == null || sortedListInput.length < 1)
		{
			//Nothing in the input list. Ouput a single element list.
			sortedListOutput = new String[1];
			sortedListOutput[0] = newString;
		}
		//Insert the new element.
		else
		{
			sortedListOutput = new String[sortedListInput.length + 1];
			boolean insertedValue = false;
			String thisString = null;
		listLoop:
			for (int i = 0; i < sortedListInput.length; i++)
			{
				if (insertedValue)
				{
					//We've already inserted the new value.
					sortedListOutput[i+1] = sortedListInput[i];
				}
				else
				{
					thisString = sortedListInput[i];
					if (thisString == null || thisString.compareTo(newString) < 0)
					{
						//This value is less than the new value.
						sortedListOutput[i] = sortedListInput[i];
					}
					else if (checkDupe && thisString.compareTo(newString) == 0)
					{
						//This value is the same as the new value, and we aren't doing duplicates.
						sortedListOutput = sortedListInput;
						insertedValue = true;
						break listLoop;
					}
					else
					{
						//This value is greater than the new value. Insert.
						sortedListOutput[i] = newString;
						sortedListOutput[i+1] = sortedListInput[i];
						insertedValue = true;
					}
				}
			}
			if (!insertedValue)
			{
				//This value belongs at the end of the list.
				sortedListOutput[sortedListInput.length] = newString;
			}
		}
		
		//Output the new list.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "sortedListOutput", sortedListOutput );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void insertRecordIntoHashtable (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(insertRecordIntoHashtable)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required inputRecord
		// [i] field:0:required keyField
		// [i] object:0:required hashtable
		// [o] object:0:required hashtable
		
		//Get values from pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		IData inputRecord = IDataUtil.getIData(pipelineCursor, "inputRecord");
		String keyField = IDataUtil.getString(pipelineCursor, "keyField");
		Object hashtable = IDataUtil.get(pipelineCursor, "hashtable");
		pipelineCursor.destroy();
		
		//Check inputs.
		Hashtable outputHash = null;
		if (hashtable == null || !(hashtable instanceof Hashtable))
		{
			throw new ServiceException ("The hashtable input must be a Java hashtable.");
		}
		else
		{
			outputHash = (Hashtable) hashtable;
		}
		if (keyField == null || keyField.trim().equals(""))
		{
			//No key field to use. Invalid input.
			throw new ServiceException ("No key field value provided to insert into Hashtable");
		}
		if (inputRecord == null)
		{
			//No input record - just return the original hashtable.
		}
		else
		{
			//Insert the value.
			IDataCursor inputListCursor = inputRecord.getCursor();
			String keyVal = IDataUtil.getString(inputListCursor, keyField);
			if (keyVal == null)
			{
				throw new ServiceException ("The key value field did not exist in the input record.");
			}
			if (outputHash.containsKey(keyVal))
			{
				//This is a duplicate. Do nothing.
			}
			else
			{
				outputHash.put(keyVal, inputRecord);
			}
		}
		
		//Put output values in the pipeline.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_1, "hashtable", outputHash);
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void objListToStringListWithRange (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(objListToStringListWithRange)>> ---
		// @sigtype java 3.5
		// [i] object:1:required objList
		// [i] field:0:required start
		// [i] field:0:required end
		// [o] field:1:required stringList
		IDataCursor idc = pipeline.getCursor();
		
		Object [] objlist = (Object[]) IDataUtil.getObjectArray(idc, "objList");
		String start = IDataUtil.getString(idc,"start");
		String end = IDataUtil.getString(idc,"end");
		
		if(objlist == null){
			throw new ServiceException(" Input parameter objList cannot be null");
		}
		
		if ((start == null) || (start.equalsIgnoreCase(""))){
			start = "0";
		}
		
		if ((end == null) || (end.equalsIgnoreCase(""))){
			end = new Integer(objlist.length).toString();
		}
		
		String [] strlist = Arrays.copyOfRange(objlist, Integer.parseInt(start),Integer.parseInt(end), String[].class);
		
		IDataUtil.put(idc, "stringList", strlist);
			
		// --- <<IS-END>> ---

                
	}



	public static final void removeLastDocumentListItem (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(removeLastDocumentListItem)>> ---
		// @sigtype java 3.5
		// [i] record:1:required list
		// [o] record:1:required listOut
		// [o] record:0:required item
		IDataCursor cursor = pipeline.getCursor();
		IData listIn[] = null; 
		IData listOut[];
		IData itemOut = null;
		
		if (cursor.last("list"))
		{
			listIn = (IData[]) cursor.getValue();
		}
		
		itemOut = listIn[listIn.length-1];
		
		listIn[listIn.length-1] = null;
		
		listOut = new IData[listIn.length-1];
		
		System.arraycopy(listIn, 0, listOut, 0, listIn.length-1);
		
		cursor.last();
		cursor.insertAfter("listOut", listOut );
		cursor.insertAfter("item", itemOut);
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void stringTableToDocumentList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringTableToDocumentList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:2:required stringTable
		// [o] record:1:required documentList
		/*
			Description:	String Table to Document List Utility
			Author:			Crowe Chizek
			Date:			08/25/04
			Details:		Takes a String Table (String[][]) and converts it to a document list.
		*/
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[][]	stringTable = IDataUtil.getStringTable( pipelineCursor, "stringTable" );
		
		// make sure we have input and the table has at least one entry
		if (stringTable != null && stringTable.length > 0) {
			 
			String value = "value";
			IData[] documentList = null;
			documentList = new IData[stringTable.length];
			IDataCursor documentCursor = null;
			for (int i=0; i<stringTable.length; i++) {
				// add all values to record in the list, assign field name of value plus order in list
				documentList[i] = IDataFactory.create();
				documentCursor = documentList[i].getCursor();
				for (int j=0; j<stringTable[i].length; j++) {
					IDataUtil.put( documentCursor, value+j, stringTable[i][j] );
				}
				documentCursor.destroy();
			}
			IDataUtil.put( pipelineCursor, "documentList", documentList );
			pipelineCursor.destroy();
		} else {
			pipelineCursor.destroy();
			throw new ServiceException("Unable to generate document list from string table: Input parameter 'stringTable' must contain a table with at least 1 row.");
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static boolean findKeyInList(String keyField, String keyValue, IData[] list, boolean ignoreCase)
	{
	  for (int i=0; i<list.length; i++)
	  {
	    IDataCursor cursor = list[i].getCursor();
	    if (cursor.first(keyField))
	    {
	      if ((ignoreCase && keyValue.equalsIgnoreCase((String)cursor.getValue()))
	       || (!ignoreCase && keyValue.equals((String)cursor.getValue())))
	      {
	        return true;
	      }
	    }
	  }
	  return false;
	}
	
	static boolean findInStringList(String value, String[] list, boolean ignoreCase)
	{
	  for (int i=0; i<list.length; i++)
	  {
	    if ((ignoreCase && value.equalsIgnoreCase(list[i]))
	     || (!ignoreCase && value.equals(list[i])))
	    {
	      return true;
	    }
	  }
	  return false;
	}
	// --- <<IS-END-SHARED>> ---
}

