package LXKMaterialBOMFromEnoviaNewToSAPECC;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void assignNewGroupsAndPriorities (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(assignNewGroupsAndPriorities)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required results
		// [i] - field:0:required SAP_PLANT
		// [i] - field:0:required PART_NAME
		// [i] - field:0:required PLANT_PROCURE
		// [i] - field:0:required TRANS_ID
		// [i] - field:0:required PARENT_PART
		// [i] - field:0:required CHILD_PART
		// [i] - field:0:required FIND_NUMBER
		// [i] - field:0:required QUANTITY
		// [i] - field:0:required ALPGR
		// [i] - field:0:required ALPRF
		// [i] - field:0:required ECO_NAME
		// [i] - field:0:required COMPONENT_LOCATION
		// [i] - field:0:required UASAGE
		// [i] - field:0:required ALTERNATE_FOR
		// [o] record:1:required results
		// [o] - field:0:required SAP_PLANT
		// [o] - field:0:required PART_NAME
		// [o] - field:0:required PLANT_PROCURE
		// [o] - field:0:required TRANS_ID
		// [o] - field:0:required PARENT_PART
		// [o] - field:0:required CHILD_PART
		// [o] - field:0:required FIND_NUMBER
		// [o] - field:0:required QUANTITY
		// [o] - field:0:required ALPGR
		// [o] - field:0:required ALPRF
		// [o] - field:0:required ECO_NAME
		// [o] - field:0:required COMPONENT_LOCATION
		// [o] - field:0:required UASAGE
		// [o] - field:0:required ALTERNATE_FOR
		// pipeline 
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// results
			IData[]	results = IDataUtil.getIDataArray( pipelineCursor, "results" );
		        grpAndPri = new HashMap();
			univGrpSet = new HashSet();
			altAndGrp = new HashMap();
			int univLoop = 0;
		
			try{	
		
			if ( results != null)
			{
			    for ( int i = 0; i < results.length; i++ )
				{
					IDataCursor resultsCursor = results[i].getCursor();
					String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
			
					   if ( ALTERNATE_FOR != null ) 
						{ 
						  String	ALPGR = IDataUtil.getString( resultsCursor, "ALPGR" );
						  String	ALPRF = IDataUtil.getString( resultsCursor, "ALPRF" );
						 if ( ALPGR != null  )
						  {
						    if ( ALPGR.length() != 0 )
							{
		                                           setUnivGrp(ALPGR);
						           setHashMap (  ALTERNATE_FOR,ALPGR );
							}
						  }
						}
					resultsCursor.destroy();
				}
		
		
			     for ( int i = 0; i < results.length; i++ )
				{
					IDataCursor resultsCursor = results[i].getCursor();
					String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
					if ( ALTERNATE_FOR != null ) 
					    {
						String	ALPGR = IDataUtil.getString( resultsCursor, "ALPGR" );
						String	ALPRF = IDataUtil.getString( resultsCursor, "ALPRF" );
		                                if ( ALPGR == null || ALPGR.length() == 0 )
						{
						  String retVal = setHashMapForNulls (ALTERNATE_FOR,ALPGR );
						  IDataUtil.put( resultsCursor, "ALPGR", retVal ); 
						}
					     }
					resultsCursor.destroy(); 
				}
		
			
			for ( int i = 0; i < results.length; i++ )
				{
				IDataCursor resultsCursor = results[i].getCursor();	
			        univLoop = i;
				String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
			     		
				if ( ALTERNATE_FOR != null )
					{
					  String	ALPGR = IDataUtil.getString( resultsCursor, "ALPGR" );
					  String	ALPRF = IDataUtil.getString( resultsCursor, "ALPRF" );
					     
					 setHashMapPri (altAndGrp,ALTERNATE_FOR,ALPGR, ALPRF );
					
					          
				        }
				resultsCursor.destroy(); 
				}
			
		
		// if ( 1==1) { throw new ServiceException ("here"); }if ( 1==1) { throw new ServiceException ("here"); }
		
			for ( int i = 0; i < results.length; i++ )
				{
					IDataCursor resultsCursor = results[i].getCursor();
					String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
				        if ( ALTERNATE_FOR != null )
					   {
						String	ALPGR = IDataUtil.getString( resultsCursor, "ALPGR" );
						String	ALPRF = IDataUtil.getString( resultsCursor, "ALPRF" );
						if ( ALPRF == null || ALPRF.length() == 0 )
					  	 {
					     	    String retVal = setHashMapPriForNull (altAndGrp,ALTERNATE_FOR,ALPGR, ALPRF );
					            IDataUtil.put( resultsCursor, "ALPRF",  retVal ); 
		     			         }
					   }
					resultsCursor.destroy(); 
				  }
			} 
		
		
		}
		
		catch(Exception e ) { throw new ServiceException(e.toString()); }
		pipelineCursor.destroy();
		
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "results", results );
		
		// --- <<IS-END>> ---

                
	}



	public static final void currentAlternateGroups (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(currentAlternateGroups)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required CHILD_PART
		// [i] field:0:required ALPGR
		// [i] field:0:required ALPGR_ALL
		// [o] field:0:required ALPGR_ALL
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	CHILD_PART = IDataUtil.getString( pipelineCursor, "CHILD_PART" );
			String	ALPGR = IDataUtil.getString( pipelineCursor, "ALPGR" );
			String	ALPGR_ALL = IDataUtil.getString( pipelineCursor, "ALPGR_ALL" );
		pipelineCursor.destroy();
		
			if (ALPGR_ALL == null)
				ALPGR_ALL = ALPGR + ":" + CHILD_PART;
			else {
				String [] tokens = null;
				StringTokenizer stALPGR = new StringTokenizer(ALPGR_ALL,"|");
				String [] stALPGRTokens = new String[stALPGR.countTokens()];
				int iteration = 0;
				boolean matchGroupFlag = false;
				while(stALPGR.hasMoreTokens()){
					stALPGRTokens[iteration] = stALPGR.nextToken();
					if(stALPGRTokens[iteration].indexOf(ALPGR+":") != -1){				
						matchGroupFlag = true;
						StringTokenizer st = new StringTokenizer(stALPGRTokens[iteration],":");
						tokens = new String[st.countTokens()];
						int innerIteration = 0;
						while(st.hasMoreTokens()){
							tokens[innerIteration] = st.nextToken();
							innerIteration++;
						}
						if (tokens[1].indexOf(CHILD_PART) == -1)
							tokens[1] = tokens[1] + "," + CHILD_PART;
						stALPGRTokens[iteration] = ALPGR + ":" + tokens[1];				
					}				
					iteration++;
				}
				if(!matchGroupFlag)
					ALPGR_ALL = ALPGR_ALL + "|" + ALPGR + ":" + CHILD_PART;
				else{
					StringBuffer sbALPGR_ALL = new StringBuffer();
					for(int i=1;i<=stALPGRTokens.length;i++)
						if ( i != stALPGRTokens.length)
							sbALPGR_ALL.append(stALPGRTokens[i-1]).append("|");
						else
							sbALPGR_ALL.append(stALPGRTokens[i-1]);
					
					ALPGR_ALL = sbALPGR_ALL.toString();
				}
					
			}
		
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "ALPGR_ALL", ALPGR_ALL );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void currentPriorities (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(currentPriorities)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required ALPGR
		// [i] field:0:required ALPRF
		// [i] field:0:required ALPRF_ALL
		// [o] field:0:required ALPRF_ALL
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	ALPGR = IDataUtil.getString( pipelineCursor, "ALPGR" );
			String	ALPRF = IDataUtil.getString( pipelineCursor, "ALPRF" );
			String	ALPRF_ALL = IDataUtil.getString( pipelineCursor, "ALPRF_ALL" );
		
		
			if (ALPRF_ALL == null)
				ALPRF_ALL = ALPGR + ":" + ALPRF;
			else {
				String [] tokens = null;
				StringTokenizer stALPGR = new StringTokenizer(ALPRF_ALL,"|");
				String [] stALPGRTokens = new String[stALPGR.countTokens()];
				int iteration = 0;
				boolean matchGroupFlag = false;
				while(stALPGR.hasMoreTokens()){
					stALPGRTokens[iteration] = stALPGR.nextToken();
					if(stALPGRTokens[iteration].indexOf(ALPGR+":") != -1){				
						matchGroupFlag = true;
						StringTokenizer st = new StringTokenizer(stALPGRTokens[iteration],":");
						tokens = new String[st.countTokens()];
						int innerIteration = 0;
						while(st.hasMoreTokens()){
							tokens[innerIteration] = st.nextToken();
							innerIteration++;
						}
						if (tokens[1].indexOf(ALPRF) == -1)
							tokens[1] = tokens[1] + "," + ALPRF;
						stALPGRTokens[iteration] = ALPGR + ":" + tokens[1];				
					}				
					iteration++;
				}
				if(!matchGroupFlag)
					ALPRF_ALL = ALPRF_ALL + "|" + ALPGR + ":" + ALPRF;
				else{
					StringBuffer sbALPRF_ALL = new StringBuffer();
					for(int i=1;i<=stALPGRTokens.length;i++)
						if ( i != stALPGRTokens.length)
							sbALPRF_ALL.append(stALPGRTokens[i-1]).append("|");
						else
							sbALPRF_ALL.append(stALPGRTokens[i-1]);
					
					ALPRF_ALL = sbALPRF_ALL.toString();
				}
					
			}	
					
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "ALPRF_ALL", ALPRF_ALL );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void findPriorityOneChildren (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(findPriorityOneChildren)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required results
		// [i] - field:0:required SAP_PLANT
		// [i] - field:0:required PART_NAME
		// [i] - field:0:required PLANT_PROCURE
		// [i] - field:0:required TRANS_ID
		// [i] - field:0:required PARENT_PART
		// [i] - field:0:required CHILD_PART
		// [i] - field:0:required FIND_NUMBER
		// [i] - field:0:required QUANTITY
		// [i] - field:0:required ALPGR
		// [i] - field:0:required ALPRF
		// [i] - field:0:required ECO_NAME
		// [i] - field:0:required COMPONENT_LOCATION
		// [i] - field:0:required UASAGE
		// [i] - field:0:required ALTERNATE_FOR
		// [o] record:1:required results
		// [o] - field:0:required SAP_PLANT
		// [o] - field:0:required PART_NAME
		// [o] - field:0:required PLANT_PROCURE
		// [o] - field:0:required TRANS_ID
		// [o] - field:0:required PARENT_PART
		// [o] - field:0:required CHILD_PART
		// [o] - field:0:required FIND_NUMBER
		// [o] - field:0:required QUANTITY
		// [o] - field:0:required ALPGR
		// [o] - field:0:required ALPRF
		// [o] - field:0:required ECO_NAME
		// [o] - field:0:required COMPONENT_LOCATION
		// [o] - field:0:required UASAGE
		// [o] - field:0:required ALTERNATE_FOR
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		Vector priorityOneChildren = new Vector();
		
		IData[]	results = IDataUtil.getIDataArray( pipelineCursor, "results" );
		
		try {
		 
			if ( results != null) {
				for ( int i = 0; i < results.length; i++ ){
					IDataCursor resultsCursor = results[i].getCursor();
					String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
		
					if ( ALTERNATE_FOR == null || ALTERNATE_FOR.equals("")) {
							priorityOneChildren.add((IData)results[i]);
					  }
					resultsCursor.destroy();		
				  }
			}
		}catch(Exception e){
			throw new ServiceException (e.toString() );
		}		
		
		 IDataCursor pipelineCursor_1 = pipeline.getCursor();
		 IDataUtil.put( pipelineCursor_1, "results",priorityOneChildren.toArray(new IData[priorityOneChildren.size()]) );
		 pipelineCursor_1.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void formatInput (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(formatInput)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required results
		// [i] - field:0:required SAP_PLANT
		// [i] - field:0:required PART_NAME
		// [i] - field:0:required PLANT_PROCURE
		// [i] - field:0:required TRANS_ID
		// [i] - field:0:required PARENT_PART
		// [i] - field:0:required CHILD_PART
		// [i] - field:0:required FIND_NUMBER
		// [i] - field:0:required QUANTITY
		// [i] - field:0:required ALPGR
		// [i] - field:0:required ALPRF
		// [i] - field:0:required ECO_NAME
		// [i] - field:0:required COMPONENT_LOCATION
		// [i] - field:0:required UASAGE
		// [i] - field:0:required ALTERNATE_FOR
		// [o] record:1:required outArray
		// [o] - field:0:required SAP_PLANT
		// [o] - field:0:required PART_NAME
		// [o] - field:0:required PLANT_PROCURE
		// [o] - field:0:required TRANS_ID
		// [o] - field:0:required PARENT_PART
		// [o] - field:0:required CHILD_PART
		// [o] - field:0:required FIND_NUMBER
		// [o] - field:0:required QUANTITY
		// [o] - field:0:required ALPGR
		// [o] - field:0:required ALPRF
		// [o] - field:0:required ECO_NAME
		// [o] - field:0:required COMPONENT_LOCATION
		// [o] - field:0:required UASAGE
		// [o] - field:0:required ALTERNATE_FOR
		// [o] field:1:required nonUniqList
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		Vector uniqResults = new Vector();
		
		Iterator it = null;
		
		HashSet uniqChildrenWithAlts = new HashSet();
		IDataCursor resultsCursor;
		Vector dupResults = new Vector();
		IData[] outArray = null ;
		
		IData[]	results = IDataUtil.getIDataArray( pipelineCursor, "results" );
		
		try {
		 
			if ( results != null)
			{
				for ( int i = 0; i < results.length; i++ )
				{
				resultsCursor = results[i].getCursor();
		
				String	ALTERNATE_FOR = IDataUtil.getString( resultsCursor, "ALTERNATE_FOR" );
				if ( ALTERNATE_FOR != null )
				  {
				    if ( ALTERNATE_FOR.length() != 0)
					uniqChildrenWithAlts.add(ALTERNATE_FOR);
				  }
				resultsCursor.destroy();
				
				}
		
				for ( int i = 0; i < results.length; i++ )
		
				{
		
				IData temp 		      = IDataUtil.deepClone( results[i] ) ;
			        IDataCursor uniqResultsCursor = temp.getCursor();		
			        String	CHILD_PART       = IDataUtil.getString( uniqResultsCursor, "CHILD_PART" );
			        String ALTERNATE_FOR    = IDataUtil.getString( uniqResultsCursor, "ALTERNATE_FOR" );
		
			if ( uniqChildrenWithAlts.contains(CHILD_PART) && ( ALTERNATE_FOR == null || ALTERNATE_FOR.length() == 0) )
					{
						IDataUtil.put (uniqResultsCursor, "ALTERNATE_FOR",CHILD_PART );
					}
		
			uniqResultsCursor.destroy();
			uniqResults.add( temp );
			
		     }
		
		outArray = new IData[uniqResults.size()];
		
			}
		
		 
		for (int i =0; i<uniqResults.size(); i++){
		outArray[i] = (IData)uniqResults.elementAt(i);
		}
		
		
			IDataUtil.sortIDataArrayByKey( outArray,"FIND_NUMBER",IDataUtil.COMPARE_TYPE_COLLATION,null, false);
		
		} // End try block
		
		catch(Exception e)
		{throw new ServiceException (e.toString() );}	
		
		
		 IDataCursor pipelineCursor_1 = pipeline.getCursor();
		 IDataUtil.put( pipelineCursor_1, "outArray",outArray );
		 pipelineCursor_1.destroy();
		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	private static  HashMap grpAndPri;
	private static  HashMap altAndGrp ;
	private static  HashSet univGrpSet;
	
	// This method maintains a running list of unique group id's used so far
	
	
	public static  void setUnivGrp (String grp ){
	if ( grp != null )  {
			univGrpSet.add(grp);
			}
	}
	
	
	// This method maintains a data structure that update a map with alternate part as the key and the group as value
	
	
	public static synchronized void setHashMap (String alt,String grp ){
	
	// Fill the hash map with the exsting values
	
	if ( grpAndPri.get (alt) == null )
		{
	      if ( grp != null )
			{
			    grpAndPri.put (alt,grp );
			}
		}
	
	}
	
	public static synchronized String setHashMapForNulls  ( String alt,String grp )
	throws ServiceException
	{
	
	HashSet grpSet;
	String retVal = null;
	
	if ( grpAndPri.get (alt) == null )
		{
			retVal = getNextNumber(univGrpSet,1);
			grpAndPri.put (alt,retVal );
		}
	else retVal = (String ) grpAndPri.get (alt);
	return retVal;
	
	}
	
	
	public static synchronized void setHashMapPri (HashMap altAndGrp, String alt,String grp, String pri ){
	
	HashSet grpSet;
	
	// Fill the hash map with the exsting values
	
	if ( altAndGrp.get (alt+grp) == null )
		{
	      if ( pri != null )
			{
			  if ( pri.length() != 0 )
				{
			  		grpSet = new HashSet();
			  		grpSet.add(pri);
			  		altAndGrp.put (alt+grp,grpSet );
				}
			}
		}
	else
		{
		  if ( pri != null )
			{
			  if ( pri.length() != 0 )
				{
			  		 grpSet = (HashSet)grpAndPri.get(alt+grp);
			   		grpSet.add ( pri );
			   		grpAndPri.put (alt+grp,grpSet); 
				}
			}
		}
	
	}
	
	public static synchronized String setHashMapPriForNull  (HashMap grpAndPri, String alt,String grp, String pri ) throws ServiceException
	{
	
	HashSet grpSet;
	String retVal;
	
	// Fill the hash map with the exsting values
	
	if ( altAndGrp.get (alt+grp) == null ) 
		{
			 
			grpSet = new HashSet();
			retVal = getNextNumber(grpSet,2);
			grpSet.add(retVal );
			grpAndPri.put (alt + grp,grpSet );
		}
	else
		{
			grpSet = (HashSet)grpAndPri.get(alt+grp);
			retVal = getNextNumber(grpSet,2);
			grpSet.add(retVal );
			grpAndPri.put (alt+grp,grpSet); 
		}
	
	return retVal;
	
	}
	
	public static String getNextNumber   (HashSet grp, int hashFlag ) throws ServiceException {
	
	HashSet hs = null;
	
	if ( hashFlag == 1 )
		hs = univGrpSet;
	else
		hs = grp; 
		
	boolean 	flag = false;
	int 		tempVal=1;
	String 		newTempVal;
	String 		temp;
	
	while ( flag == false )
	   {
			if ( tempVal < 10 )
				 {
					temp = "0" + new Integer(tempVal).toString() ;
					if (  hs.contains (temp) )
				      	tempVal++;
					else { flag = true; }
				 }
			else {
				    temp = new Integer(tempVal).toString() ;
				    if ( hs.contains (temp ) )
				      	tempVal++;
					else { flag = true; }
				 }
	    }
	
	if ( tempVal < 10 )
		newTempVal = "0" + (new Integer (tempVal) ).toString();
	else
		newTempVal = (new Integer (tempVal) ).toString();
	
		hs.add(newTempVal);
		return newTempVal;
	
	}
	// --- <<IS-END-SHARED>> ---
}

