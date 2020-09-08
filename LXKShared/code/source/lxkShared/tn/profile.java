package lxkShared.tn;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-05-05 01:49:24 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.tn.profile.*;
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class profile

	extends Service
{
	// ---( internal utility methods )---

	final static profile _instance = new profile();

	static profile _newInstance() { return new profile(); }

	static profile _cast(Object o) { return (profile)o; }

	// ---( server methods )---




	public static final void getAllDestinationInfo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getAllDestinationInfo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required partnerID
		// [o] record:1:required destination
		// [o] - field:0:required PartnerID
		// [o] - field:0:required Protocol
		// [o] - record:0:required PrimaryAddr
		// [o] -- field:0:required MBoolean
		// [o] - field:0:required Host
		// [o] - field:0:required Port
		// [o] - field:0:required Location
		// [o] - field:0:required UserName
		// [o] - field:0:required Password
		// [o] - field:0:required DestinationID
		IDataCursor cursor       = pipeline.getCursor();
		String partnerID         = null;
		IData[] iDataArray       = null;
		Profile profile          = null;
		Vector destinationVector = new Vector();
		Destination thisDestination = null;
		
		if (cursor.first("partnerID"))
		{
			partnerID = (String)cursor.getValue();  
		}
		else  
		{
			throw new ServiceException("Missing input 'partnerID'");
		}
		
		try
		{
			try 
			{
		  		profile = ProfileStore.getProfileStore().getProfile(partnerID);
			}
			catch (ProfileStoreException noProfileException) 
			{
				throw new ProfileStoreException("Profile not found.");
			}
		
		  	destinationVector = profile.getDestinationVector();
		
			if (destinationVector != null)
		 	{
				iDataArray = new IData[destinationVector.size()];
		
				for (int i=0; i<=destinationVector.size()-1; i++)
				{
					thisDestination = (Destination) destinationVector.elementAt(i);
		
					//  Add the primaryAddr as an IData to facilitate mapping.
					IDataCursor destCursor = thisDestination.getCursor();
					if (destCursor.last("PrimaryAddr"))
					{
						com.wm.data.MBoolean primaryAddr = (com.wm.data.MBoolean) destCursor.getValue();
						IData newPrimAddr = primaryAddr.getAsData();
						// Add the newPrimAddr to the Destination.
						destCursor.insertAfter("PrimaryAddr", newPrimAddr);
					}
					destCursor.destroy();
		
					iDataArray[i] = thisDestination;
				}
			}
		
			cursor.insertAfter("destination", iDataArray);
		
		  	cursor.destroy();
		}
		catch (Exception ex) {
				throw new ServiceException(ex.toString());	
		}
		
		// --- <<IS-END>> ---

                
	}



	public static final void getDestinationInfo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getDestinationInfo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required partnerID
		// [i] field:0:optional protocol {&quot;http&quot;,&quot;https&quot;}
		// [o] record:0:required destination
		// [o] - field:0:required PartnerID
		// [o] - field:0:required Protocol
		// [o] - record:0:required PrimaryAddr
		// [o] -- field:0:required MBoolean
		// [o] - field:0:required Host
		// [o] - field:0:required Port
		// [o] - field:0:required Location
		// [o] - field:0:required UserName
		// [o] - field:0:required Password
		// [o] - field:0:required DestinationID
		IDataCursor cursor = pipeline.getCursor();
		
		String partnerID = null;
		String protocol = null;
		
		if (cursor.first("partnerID"))
		{
		  partnerID = (String)cursor.getValue();  
		}
		else
		{
		  throw new ServiceException("Missing input 'partnerID'");
		}
		
		if (cursor.first("protocol"))
		{
		  protocol = (String)cursor.getValue();  
		}
		
		try
		{
		  Profile profile = ProfileStore.getProfileStore().getProfile(partnerID);
		  Destination destination = getDestination(profile, protocol, true);
		
		  if (destination == null || destination.getHost() == null)
		  {
		    destination = getDestination(profile, protocol, false);
		  }
		 
		  //  tfoltz - 4/9/04
		  //  This code was added to allow the PrimaryAddr/MBoolean parameter to be mapped from. 
		  //  Converts the PrimaryAddr/MBoolean to an mappable IData.
		  IDataCursor destCursor = destination.getCursor();
		  if (destCursor.last("PrimaryAddr"))
		  {
			  com.wm.data.MBoolean primaryAddr = (com.wm.data.MBoolean) destCursor.getValue();
			  IData newPrimAddr = primaryAddr.getAsData();
			  // Add the newPrimAddr to the Destination.
			  destCursor.insertAfter("PrimaryAddr", newPrimAddr);
		  }
		  destCursor.destroy();
		  //
		
		  IDataUtil.put(cursor, "destination", destination);
		  cursor.destroy();
		}
		catch (ProfileStoreException pse)
		{
		  throw new ServiceException(pse);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void getFormattedDestinationURL (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFormattedDestinationURL)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required partnerID
		// [i] field:0:required primary {&quot;true&quot;,&quot;false&quot;}
		// [i] field:0:optional protocol {&quot;preferred&quot;,&quot;http&quot;,&quot;https&quot;,&quot;ftp&quot;,&quot;smtp&quot;}
		// [o] field:0:required url
		// [o] field:0:required userName
		// [o] field:0:required password
		IDataCursor cursor            = pipeline.getCursor();
		Destination destination       = null;
		Destination outputDestination = null;
		Enumeration destinationEnum   = null;
		String partnerID              = null;
		String protocol               = null;  
		String primaryString          = null;
		String userName    			  = null;
		String password				  = null;
		String url					  = null;
		String host					  = null;
		String port					  = null;
		String location				  = null;
		boolean primary               = true; 
		 
		if (cursor.first("partnerID"))
		{
			partnerID = (String)cursor.getValue();  
		}
		else
		{
			throw new ServiceException("Missing input 'partnerID'");
		} 
		
		if (cursor.first("protocol"))
		{
			protocol = (String)cursor.getValue();  
		}
		
		if (cursor.first("primary"))
		{
			primaryString = (String)cursor.getValue();
			if (primaryString.equalsIgnoreCase("false"))
			{
				primary = false;
			}
		}
		
		try
		{ 
			Profile profile = ProfileStore.getProfileStore().getProfile(partnerID);
			
			// Preferred is the default.
			if ( (protocol == null) || (protocol.equalsIgnoreCase("preferred")) || (protocol.equals("")) ) 
			{
				// Get the preferred destination. 
				outputDestination = profile.getPreferredDestination();
			}
			// Retrieve the specific destination.
			else
			{
				// Get the destinations for this profile.
				destinationEnum = profile.getDestinations();
		
				// Search the list of destinatins for this profile.
				while ( (destinationEnum.hasMoreElements()) && (outputDestination == null) )
				{
					destination = (Destination) destinationEnum.nextElement();
		
					// Make sure the primary flag matches.			
					if (primary && destination.isPrimary() || !primary && !destination.isPrimary())
		    		{
						// See if the protocol matches
					    if (protocol.equalsIgnoreCase(destination.getProtocol()))
		    			{
							outputDestination = destination;
						}
		    		}
				}
			}
		
			if (outputDestination != null) {
				userName = outputDestination.getUser();
				password = outputDestination.getPassword();
				protocol = outputDestination.getProtocol();
				host     = outputDestination.getHost();
				port     = outputDestination.getPort();
				location = outputDestination.getLocation();
				
				if (host == null) host = "";
				if (port == null) port = "";
				if (location == null) location = "";
				
				if ( (protocol.equalsIgnoreCase("http")) 
					|| (protocol.equalsIgnoreCase("https")) )
				{
					if (!port.equals("")) 
					{
						port = ":" + port;  
					}
					url = protocol + "://" + host + port + location;
				}
				else if (protocol.equalsIgnoreCase("ftp"))
				{
					String userNamePasswordString = "";
				
					if (userName != null) 
					{
						userNamePasswordString = userNamePasswordString + userName;
					}
		
					if (password != null)
					{
						userNamePasswordString = userNamePasswordString + ":" + password;
					}
					
					if (!userNamePasswordString.equals("")) 
					{
						userNamePasswordString = userNamePasswordString + "@";
					}
						
					if (!port.equals("")) 
					{
						port = ":" + port;  
					}
		
					url = "ftp://" + userNamePasswordString + host + port + location;
				}
			}
		
			// Return the outputDestination
			cursor.last();
			cursor.insertAfter("url", url);
			cursor.insertAfter("password", password);
			cursor.insertAfter("userName", userName);
		
			cursor.destroy();
		}
		catch (ProfileStoreException pse)
		{
			throw new ServiceException(pse);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void getSpecificDestinationInfo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getSpecificDestinationInfo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required partnerID
		// [i] field:0:required primary {&quot;true&quot;,&quot;false&quot;}
		// [i] field:0:optional protocol {&quot;preferred&quot;,&quot;http&quot;,&quot;https&quot;,&quot;ftp&quot;,&quot;smtp&quot;}
		// [o] record:0:required destination
		// [o] - field:0:required PartnerID
		// [o] - field:0:required Protocol
		// [o] - record:0:required PrimaryAddr
		// [o] -- field:0:required MBoolean
		// [o] - field:0:required Host
		// [o] - field:0:required Port
		// [o] - field:0:required Location
		// [o] - field:0:required UserName
		// [o] - field:0:required Password
		// [o] - field:0:required DestinationID
		IDataCursor cursor = pipeline.getCursor();
		Destination destination = null;
		Destination outputDestination = null;
		Enumeration destinationEnum = null;
		String partnerID = null;
		String protocol = null;  
		String primaryString = null;
		boolean primary = true; 
		
		if (cursor.first("partnerID"))
		{
			partnerID = (String)cursor.getValue();  
		}
		else
		{
			throw new ServiceException("Missing input 'partnerID'");
		} 
		
		if (cursor.first("protocol"))
		{
			protocol = (String)cursor.getValue();  
		}
		
		if (cursor.first("primary"))
		{
			primaryString = (String)cursor.getValue();
			if (primaryString.equalsIgnoreCase("false"))
			{
				primary = false;
			}
		}
		
		try
		{ 
			Profile profile = ProfileStore.getProfileStore().getProfile(partnerID);
			
			// Preferred is the default.
			if ( (protocol == null) || (protocol.equalsIgnoreCase("preferred")) || (protocol.equals("")) ) 
			{
				// Get the preferred destination. 
				outputDestination = profile.getPreferredDestination();
			}
			else
			{
				// Get the destinations for this profile.
				destinationEnum = profile.getDestinations();
		
				// Search the list of destinatins for this profile.
				while ( (destinationEnum.hasMoreElements()) && (outputDestination == null) )
				{
					destination = (Destination) destinationEnum.nextElement();
		
					// Make sure the primary flag matches.			
					if (primary && destination.isPrimary() || !primary && !destination.isPrimary())
		    		{
						// See if the protocol matches
					    if (protocol.equalsIgnoreCase(destination.getProtocol()))
		    			{
							outputDestination = destination;
						}
		    		}
				}
			}
		
			//  Add the primaryAddr as an IData
			IDataCursor destCursor = outputDestination.getCursor();
			if (destCursor.last("PrimaryAddr"))
			{
				com.wm.data.MBoolean primaryAddr = (com.wm.data.MBoolean) destCursor.getValue();
				IData newPrimAddr = primaryAddr.getAsData();
				// Add the newPrimAddr to the Destination.
				destCursor.insertAfter("PrimaryAddr", newPrimAddr);
			}
			destCursor.destroy();
		
			// Return the outputDestination
			cursor.last();
			cursor.insertAfter("destination", outputDestination); 
		
			cursor.destroy();
		}
		catch (ProfileStoreException pse)
		{
			throw new ServiceException(pse);
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static Destination getDestination(Profile profile, String protocol, boolean primary)
	{
	  if (protocol == null || protocol.length() == 0)
	  {
	    return profile.getPreferredDestination();
	  }
	
	  Destination destination = null;
	
	  Enumeration enumeration = profile.getDestinations();
	  for (int i=0; enumeration.hasMoreElements(); i++) 
	  {
	    destination = (Destination)enumeration.nextElement();
	    if (primary && !destination.isPrimary() || !primary && destination.isPrimary())
	    {
	      destination = null;
	      continue;
	    }
	
	    if (protocol.equalsIgnoreCase(destination.getProtocol()))
	    {
	      System.out.println(protocol + "," +  destination.getProtocol());
	      break;
	    }
	    destination = null;
	  }
	  return destination;
	}
	// --- <<IS-END-SHARED>> ---
}

