package LXKMaterialFromEnoviaNewToSAPECC;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.*;
import java.text.*;
import com.wm.util.Debug;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void appendUniqueListToStringList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(appendUniqueListToStringList)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:1:required inList
		// [i] field:1:required keyList
		// [o] field:1:required outList
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String[]	inList = IDataUtil.getStringArray( pipelineCursor, "inList" );
			String[]	keyList = IDataUtil.getStringArray( pipelineCursor, "keyList" );
			if(inList != null)
			{
				if(keyList != null)
				{
					Set set= new HashSet(Arrays.asList(keyList));
					keyList = (String[])set.toArray(new String[set.size()]);
					IDataUtil.put( pipelineCursor, "keyList", keyList);
		
					for (int i=0;i<inList.length;i++)
					{
						keyList = removeStr(keyList,inList[i]);
					}
					IDataUtil.put(pipelineCursor, "keyListOut", keyList);
		
					String[] outList = new String[inList.length + keyList.length];
					System.arraycopy(inList, 0, outList, 0, inList.length);
		     			System.arraycopy(keyList, 0, outList, inList.length, keyList.length);
		
		      			IDataUtil.put(pipelineCursor, "outList", outList);
				}
				else
				{
					IDataUtil.put(pipelineCursor, "outList", inList);
				}
			}
			else
			{
				if(keyList != null)
				{
					IDataUtil.put(pipelineCursor, "outList", keyList);
				}
			}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void compareProfCenterAndValClass (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(compareProfCenterAndValClass)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:1:required GT_OUT
		// [i] - field:0:required MATNR
		// [i] - field:0:required WERKS
		// [i] - field:0:required BKLAS
		// [i] - field:0:required PRCTR
		// [i] - field:0:required MMSTA
		// [i] field:0:required derivedProfitCenter
		// [i] field:0:required derivedValuationClass
		// [o] field:0:required isProfitCenterVary
		// [o] field:0:required isValuationClassVary
		// [o] field:0:required isStatusVary
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		String	derivedProfitCenter = IDataUtil.getString( pipelineCursor, "derivedProfitCenter" );
		String	derivedValuationClass = IDataUtil.getString( pipelineCursor, "derivedValuationClass" );
		String isProfitCenterVary = "N";
		String isValuationClassVary = "N";
		String isStatusVary = "N";
			// GT_OUT
			IData[]	GT_OUT = IDataUtil.getIDataArray( pipelineCursor, "GT_OUT" );
			if ( GT_OUT != null)
			{
				for ( int i = 0; i < GT_OUT.length; i++ )
				{
					IDataCursor GT_OUTCursor = GT_OUT[i].getCursor();
						String	BKLAS = IDataUtil.getString( GT_OUTCursor, "BKLAS" );
						String	PRCTR = IDataUtil.getString( GT_OUTCursor, "PRCTR" );
						String	MMSTA = IDataUtil.getString( GT_OUTCursor, "MMSTA" );
						
						if(derivedProfitCenter != null)
						{
						if(!derivedProfitCenter.equals(PRCTR))
							isProfitCenterVary = "Y";
						}
						if(derivedValuationClass != null)
						{
						if(!derivedValuationClass.equals(BKLAS))
							isValuationClassVary = "Y";
						}
						if(!MMSTA.equals("01") && !MMSTA.equals("35") && !MMSTA.equals("40") && !MMSTA.equals("45") && !MMSTA.equals("46") && !MMSTA.equals("97"))
							isStatusVary = "Y";
					GT_OUTCursor.destroy();
				}
				IDataUtil.put( pipelineCursor, "isProfitCenterVary", isProfitCenterVary );
				IDataUtil.put( pipelineCursor, "isValuationClassVary", isValuationClassVary );
				IDataUtil.put( pipelineCursor, "isStatusVary", isStatusVary );
			}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void computeUOMVolume (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(computeUOMVolume)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required length
		// [i] field:0:required width
		// [i] field:0:required height
		// [i] field:0:required unit_of_dimension
		// [o] field:0:required volume
		// [o] field:0:required dimension
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	length = IDataUtil.getString( pipelineCursor, "length" );
			String	width = IDataUtil.getString( pipelineCursor, "width" );
			String	height = IDataUtil.getString( pipelineCursor, "height" );
			String	unit_of_dimension = IDataUtil.getString( pipelineCursor, "unit_of_dimension" );
		
			Double fLength = Double.valueOf(length).doubleValue();
			Double fWidth = Double.valueOf(width).doubleValue();
			Double fHeight = Double.valueOf(height).doubleValue();
		
			//Double volumeCubicMeter = null;
			Double FinalVolume = null;
			String dimension = "MTQ"; // In Meters
			if(unit_of_dimension.equals("MMT")) // if input dims are in millimeters
			{
				FinalVolume = (fLength*0.001)*(fWidth*0.001)*(fHeight*0.001);	
			}
			else if (unit_of_dimension.equals("CMT")) // if input dims are in centimeters
			{
				FinalVolume = (fLength*0.01)*(fWidth*0.01)*(fHeight*0.01);
			}
			else // if input dims are in meters
			{
				FinalVolume = fLength*fWidth*fHeight;
			}
			
			//com.wm.util.Debug.log(4,"before check.." +FinalVolume);
			if(FinalVolume < 0.001)
			{
				dimension = "CMQ";
				FinalVolume = FinalVolume * 1000000; // cubic meters to cubic cms
				//com.wm.util.Debug.log(4,"into cms" +FinalVolume);
				if(FinalVolume < 0.001)
				{
					dimension = "MMQ";
					FinalVolume = FinalVolume * 1000; // cubic cms to cubic mm
					//com.wm.util.Debug.log(4,"into mms" +FinalVolume);
					if(FinalVolume < 0.001)
					{
						dimension = "MMQ";
						FinalVolume = 0.001; // default to MMQ and 0.001
						//com.wm.util.Debug.log(4,"into mms(default)" +FinalVolume);
					}
				}
				
			}
		
			DecimalFormat myFormatter = new DecimalFormat("0.000");
			
			//pipelineCursor.insertAfter("volume",Double.toString(FinalVolume));
			pipelineCursor.insertAfter("volume",myFormatter.format(FinalVolume));
		
			pipelineCursor.insertAfter("dimension",dimension);
				
		pipelineCursor.destroy();
		
		
		
		
		//
		
		// --- <<IS-END>> ---

                
	}



	public static final void getFutureDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getFutureDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required yearIncremental
		// [o] field:0:required incrementedDate
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			int YI = Integer.parseInt(IDataUtil.getString( pipelineCursor, "yearIncremental" ));
			//String	YearIncremental = IDataUtil.getString( pipelineCursor, "yearIncremental" );
		
		Calendar date = Calendar.getInstance();   
		    date.setTime(new Date());   
		    Format f = new SimpleDateFormat("yyyy-MM-dd");   
		    date.add(Calendar.YEAR,YI);   
		
		pipelineCursor.insertAfter("incrementedDate", f.format(date.getTime()));
		// --- <<IS-END>> ---

                
	}



	public static final void parsePLM_ISO_Codes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parsePLM_ISO_Codes)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required PLM_COUNTRY_ISO_CODE
		// [o] field:0:required strClause
		// [o] field:1:required iso_code_list
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	PLM_COUNTRY_ISO_CODE = IDataUtil.getString( pipelineCursor, "PLM_COUNTRY_ISO_CODE" );
			if(PLM_COUNTRY_ISO_CODE != null)
			{
		
			String tokens[] = PLM_COUNTRY_ISO_CODE.split("\\|");
			String iso_code_list[] = PLM_COUNTRY_ISO_CODE.split("\\|");
			String strClause = "";
			StringBuilder arTostr = new StringBuilder();
			for (int i = 0; i < tokens.length; i++)
		        {
				//strClause = strClause+"'"+tokens[i]+"'";
				tokens[i] = "'"+tokens[i]+"'";
				if(i !=0)
				{
					arTostr.append(",");
					arTostr.append(tokens[i]);
				}
				else
				{
					arTostr.append(tokens[i]);
				}
			}
			
		
			pipelineCursor.insertAfter("strClause",arTostr.toString());
			//pipelineCursor.insertAfter("countryCodeList",tokens);
			pipelineCursor.insertAfter("iso_code_list",iso_code_list);
			}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//private static final String zeroes = "0000000000";   
	
	// Srini Akula
	// Remove a string from a list
	public static String[] removeStr(String[] symbols, String rm)
	{
		for (int i = 0; i < symbols.length; i++) 
		{
			if(symbols[i].equals(rm))
			{	
				String[] copy = new String[symbols.length-1]; 
				System.arraycopy(symbols, 0, copy, 0, i); 
				System.arraycopy(symbols, i+1, copy, i, symbols.length-i-1); 
				return copy;
			}
		}
		return symbols;
	}
	// --- <<IS-END-SHARED>> ---
}

