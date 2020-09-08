package lxkShared.tn;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-05 01:46:40 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.tn.profile.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class dictionary

{
	// ---( internal utility methods )---

	final static dictionary _instance = new dictionary();

	static dictionary _newInstance() { return new dictionary(); }

	static dictionary _cast(Object o) { return (dictionary)o; }

	// ---( server methods )---




	public static final void createExtendedFields (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createExtendedFields)>> ---
		// @sigtype java 3.5
		// [i] field:0:required group
		// [i] field:1:required fields
		IDataCursor cursor = pipeline.getCursor();
		
		String group = null;
		
		if (cursor.first("group"))
		{
		  group = (String)cursor.getValue();  
		}
		else
		{
		  throw new ServiceException("Missing input 'group'");
		}
		
		String[] fields = null;
		
		if (cursor.first("fields"))
		{
		  fields = (String[])cursor.getValue();
		}
		
		Short groupId = null;
		try
		{  
		  //Get the ProfileDictionary object
		  ProfileDictionary dict = ProfileDictionary.getProfileDictionary();
		  //Extract the list of groups
		  Hashtable groups = LookupStore.getFieldGroups();
		  groupId = (Short)groups.get(group);
		  if (groupId == null)
		  {
		    //Create the groups first, when it does not exist
		    groupId = new Short(LookupStore.addFieldGroup(group));
		  }
		
		  //Now loop over all the fields and add them to the group
		  for (int i=0; fields != null && i < fields.length; i++)
		  {
		    try
		    {
		      ProfileFieldMetaData metaData = dict.getExtendedFieldDefinition(fields[i]);
		      if (metaData == null || metaData.getGroupID() != groupId.shortValue())
		      {
		        metaData = new ProfileFieldMetaData();
		        metaData.setExtended(true);
		        metaData.setRegistration(false);
		        metaData.setRequired(false);
		        metaData.setDisplayable(true);
		        metaData.setGroupID(groupId.shortValue());
		        metaData.setFieldName(fields[i]);
		        metaData.setDatatype("String");
		        dict.addExtendedFieldDefinition(metaData);
		      }
		     }
		     catch (ProfileStoreException pfe)
		     {
		     }  
		  } 
		
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
}

