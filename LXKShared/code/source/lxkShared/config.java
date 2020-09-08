package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-03 03:33:38 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.*;
import java.io.*;
import com.wm.lang.ns.NSName;
// --- <<IS-END-IMPORTS>> ---

public final class config

{
	// ---( internal utility methods )---

	final static config _instance = new config();

	static config _newInstance() { return new config(); }

	static config _cast(Object o) { return (config)o; }

	// ---( server methods )---




	public static final void getConfigurationParameters (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getConfigurationParameters)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required configId
		// [i] field:0:optional buildStructure {&quot;true&quot;,&quot;false&quot;}
		// [o] record:0:required propertiesDocument
		// [o] field:0:required errorMessage
		//Get input from pipeline.
		IDataCursor pipelineCursor = pipeline.getCursor();
		String configId = IDataUtil.getString( pipelineCursor, "configId" );
		String buildStructure = IDataUtil.getString( pipelineCursor, "buildStructure" );
		pipelineCursor.destroy();
		
		//Set up inputs and new variables.
		boolean processStructure = false;
		if (buildStructure == null || !(buildStructure.equals("true")))
		{
			processStructure = false;
		}
		else
		{
			processStructure = true;
		}
		String errorMessage = "";
		Properties properties = null;
		Hashtable storage = configStorage.getConfigStorage();
		IData valuesOut = null;
		
		//Check for valid filename.
		if (configId == null || configId.trim().equals("")) 
		{
			errorMessage = "No configId specified";
		}
		else
		{
			//Get the current environment.
			String env = null;
			try
			{
				NSName functionalServerServiceName = NSName.create("Server:getServerFunctionalType");
				IData envReturn = 
					Service.doInvoke(functionalServerServiceName, IDataFactory.create());
				IDataCursor envCursor = envReturn.getCursor();
				envCursor.next("functionalType");
				env = (String) envCursor.getValue();
			}
			catch (Exception e)
			{
				throw new ServiceException ("Unable to get environment value due to: " + e);
			}
			//The configId needs to have the environment appended.
			configId += "_" + env + ".properties";
			
			//See if we already have the object.
			boolean propertiesFound = false;
			try
			{
				valuesOut = (IData) storage.get(configId);
				if (valuesOut == null)
				{
					propertiesFound = false;
				}
				else
				{
					propertiesFound = true;
				}
			}
			catch (Exception e)
			{
				//Something wrong with the internals, re-read it.
				propertiesFound = false;
			}
			if (propertiesFound)
			{
				//Already have the properties, no need to read the actual file.
			}
			else
			{
				properties = new Properties();
				//Read the file.
				FileInputStream fileInputStream = null;
				try 
				{
					fileInputStream = new FileInputStream(configId);
				}
				catch (Exception e) 
				{
					errorMessage = "Error opening properties file: " + e.toString();
				}
		
				try 
				{
					properties.load(fileInputStream);
				}
				catch (Exception e) 
				{
					errorMessage = "Error opening properties input stream: " + e.toString();
				}
		
				//Get all the keys from the properties object.
				valuesOut = IDataFactory.create();
				IDataCursor valuesOutCursor = valuesOut.getCursor();
				IDataCursor thisLevelCursor = null;
				Iterator keyIterator = (new TreeSet(properties.keySet())).iterator();
				String thisKey = null;
				String thisValue = null;
				int dotPosition = 0;
				String thisLevel = null;
				String remainingLevels = null;
				Object thisLevelDataObj = null;
				IData thisLevelData = null;
				String keyListName = "__keyList";
				String keyListFieldName = "__keyName";
				IData[] thisKeyList = null;
				Object thisKeyListObj = null;
				Object thisPositionValueObj = null;
				IData[] newKeyList = null;
				IDataCursor listElementCursor = null;
				String thisPositionKey = null;
		
				//Loop over each key and place it in the output structure.
				while (keyIterator.hasNext())
				{
					//Get the current key and value.
					thisKey = (String) keyIterator.next();
					thisValue = properties.getProperty(thisKey);
		
					//Check if this value is a structure value.
					dotPosition = thisKey.indexOf('.');
					if (!processStructure || dotPosition == -1)
					{
						//No dot in this string, or we aren't processing structure.
						//Just insert the value.
						valuesOutCursor.last();
						valuesOutCursor.insertAfter(thisKey, thisValue);
					}
					else
					{
						//Set up a string to keep track of what we haven't processed yet.
						remainingLevels = thisKey;
						//We'll need a IData cursor to use for each level, starting at the top.
						thisLevelCursor = valuesOutCursor;
						//Loop through all levels in this key.
						while (dotPosition != -1)
						{
							//Get the first level from the key.
							thisLevel = remainingLevels.substring(0, dotPosition);
							//Store the remaining level(s) from the key, and reset the next dot position.
							remainingLevels = remainingLevels.substring(dotPosition + 1, remainingLevels.length());
							dotPosition = remainingLevels.indexOf('.');
							//Look for a keyList at this level.
							thisLevelCursor.first();
							boolean haveMoreValuesInCursor = true;
							while (thisKeyList == null && haveMoreValuesInCursor)
							{
								thisPositionKey = thisLevelCursor.getKey();
								if (thisPositionKey != null && thisPositionKey.equals(keyListName))
								{
									//This is the key list.
									thisKeyListObj = thisLevelCursor.getValue();
									if (thisKeyListObj != null && (thisKeyListObj instanceof IData[]))
									{
										//This is the right object, move on.
										thisKeyList = (IData[]) thisKeyListObj;
									}
								}
								//In case we need it, position the cursor at the next item with the right name.
								haveMoreValuesInCursor = thisLevelCursor.next(keyListName);
							}
							if (thisKeyList == null)
							{
								//Couldn't find an existing key list, create it and add this key.
								thisLevelCursor.last();
								thisKeyList = new IData[1];
								thisKeyList[0] = IDataFactory.create();
								thisLevelData = thisKeyList[0];
								listElementCursor = thisKeyList[0].getCursor();
								listElementCursor.first();
								listElementCursor.insertAfter(keyListFieldName, thisLevel);
								thisLevelCursor.insertAfter(keyListName, thisKeyList);
							}
							else
							{
								//Key list exists, try to find an existing level with this name.
								levelLoop:
								for (int i = 0; i < thisKeyList.length; i++)
								{
									thisLevelData = thisKeyList[i];
									if (thisLevelData != null)
									{
										//Look for the name of this level.
										listElementCursor = thisLevelData.getCursor();
										listElementCursor.first();
										haveMoreValuesInCursor = true;
										while (haveMoreValuesInCursor)
										{
											thisPositionKey = listElementCursor.getKey();
											if (thisPositionKey != null && 
												thisPositionKey.equals(keyListFieldName))
											{
												//This is the name field.
												thisPositionValueObj = listElementCursor.getValue();
												if (thisPositionValueObj != null && 
													thisPositionValueObj.equals(thisLevel))
												{
													//This is the right object, move on.
													break levelLoop;
												}
												else
												{
													//Wrong level, reset and try again.
													thisLevelData = null;
												}
											}
											//In case we need it, position the cursor at the next item 
											//with the right name.
											haveMoreValuesInCursor = listElementCursor.next(keyListFieldName);
										}
									}
									//If we get to this point, then we didn't find the level name. Try again.
									thisLevelData = null;
								}
								if (thisLevelData == null)
								{
									//Need to create a new level.
									newKeyList = new IData[thisKeyList.length + 1];
									System.arraycopy(thisKeyList, 0, newKeyList, 0, thisKeyList.length);
									thisLevelData = IDataFactory.create();
									listElementCursor = thisLevelData.getCursor();
									listElementCursor.first();
									listElementCursor.insertAfter(keyListFieldName, thisLevel);
									newKeyList[thisKeyList.length] = thisLevelData;
									thisLevelCursor.setValue(newKeyList);
								}
							}
		
							//Get rid of the old cursor if it isn't the top-level one.
							if (thisLevelCursor != null && thisLevelCursor != valuesOutCursor)
							{
								thisLevelCursor.destroy();
							}
							//Get a cursor for this new level and repeat the loop.
							thisLevelCursor = thisLevelData.getCursor();
							thisLevelData = null;
							thisKeyList = null;
						}
		
						//At this point, we should have the last level's cursor and be ready to
						//insert the actual value.
						thisLevelCursor.last();
						thisLevelCursor.insertAfter(remainingLevels, thisValue);
						//Get rid of the old cursor if it isn't the top-level one.
						if (thisLevelCursor != valuesOutCursor)
						{
							thisLevelCursor.destroy();
						}
						thisLevelCursor = null;
					}
				}
		
				//Store the IData object for later retrieval.
				storage.put(configId, valuesOut);
				configStorage.setConfigStorage(storage);
			}
		}
		
		//Set outputs in pipeline.
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put(pipelineCursor_1, "propertiesDocument", valuesOut);
		if ((errorMessage != null) && !(errorMessage.trim().equals(""))) 
		{
			IDataUtil.put(pipelineCursor_1, "errorMessage", errorMessage);
		}
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void resetConfigurationParameters (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(resetConfigurationParameters)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required configId
		IDataCursor cursor = pipeline.getCursor();
		String configId = null;
		
		cursor.last("configId");
		configId = (String) cursor.getValue();
		
		Hashtable storage = configStorage.getConfigStorage();
		
		if (configId == null || configId.trim().equals(""))
		{
			//No config Id specified, drop everything.
			storage.clear();
		}
		else
		{
			//Drop all properties files for the specified config Id.
			storage.remove(configId + "_DEVELOPMENT.properties");
			storage.remove(configId + "_TEST.properties");
			storage.remove(configId + "_PRODUCTION.properties");
		}
		
		configStorage.setConfigStorage(storage);
		// --- <<IS-END>> ---

                
	}
}

