

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-02-26 06:16:34 EST
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.util.Vector;
// --- <<IS-END-IMPORTS>> ---

public final class list

	extends Service
{
	// ---( internal utility methods )---

	final static list _instance = new list();

	static list _newInstance() { return new list(); }

	static list _cast(Object o) { return (list)o; }

	// ---( server methods )---




	public static final void addItemToList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(addItemToList)>> ---
		// @sigtype java 3.5
		// [i] object:0:required itemIn
		// [i] object:1:required list
		// [o] object:1:required list
		IDataCursor cursor = pipeline.getCursor();
		Object listOut[];
		
		cursor.last("itemIn");
		Object itemIn = cursor.getValue();
		
		cursor.last("list");
		Object[] listIn = (Object[]) cursor.getValue();
		
		if (listIn == null) {
			listOut = new Object[1];
			listOut[0] = itemIn;
		}
		else {
			listOut = new Object[listIn.length + 1];
		
			System.arraycopy(listIn, 0, listOut, 0, listIn.length);
			listOut[listOut.length-1] = itemIn;
		}
		
		if (cursor.last("list")) {
			cursor.setValue(listOut);
		
		}
		else {
			cursor.last();
			cursor.insertAfter("list",listOut);
		}
		// --- <<IS-END>> ---

                
	}



	public static final void convertObjToStrList (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertObjToStrList)>> ---
		// @sigtype java 3.5
		// [i] object:0:required inObj
		// [o] field:1:required outStrList
		IDataCursor idc = pipeline.getCursor();
		String [] inStrArr = (String[]) IDataUtil.get(idc,"inObj");
		
		IDataUtil.put(idc, "outStrList", inStrArr);
		idc.destroy();
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void splitStrListIntoChunks (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitStrListIntoChunks)>> ---
		// @sigtype java 3.5
		// [i] field:1:required inStrList
		// [i] object:0:required chunkSize
		// [o] object:1:required listOfChunks
		IDataCursor idc = pipeline.getCursor();
		String [] inStrArr = IDataUtil.getStringArray(idc,"inStrList");
		Integer chunkSizeObj = (Integer)IDataUtil.get(idc,"chunkSize");
		idc.destroy();
		
		int chunkSize = 0;
		
		Object [] outChunkList;
		
		if(inStrArr == null){
			throw new ServiceException("inStrArr cannot be null");
		}
		
		if (chunkSizeObj != null){
			chunkSize = chunkSizeObj.intValue();
		}
		
		if(chunkSize == 0){
			// return input string list as single chunk
			
			outChunkList = new Object[1];
			outChunkList[0] = inStrArr;
		}else{
			
			// calculate no of chunks required
			int noOfChunks = inStrArr.length / chunkSize;
			
			if((inStrArr.length - (noOfChunks * chunkSize))>0){
				noOfChunks = noOfChunks + 1;
			}
			
		//	com.wm.util.Debug.log(4, "ChunkSize: "+noOfChunks);
			//create chunks
			int startIndex = 0;
			int endIndex = 0;
			
			outChunkList = new Object[noOfChunks];
			
			for(int i=0; i<noOfChunks; i++){
				startIndex = endIndex;
				endIndex = startIndex+chunkSize;
				
				if(endIndex > inStrArr.length){
					endIndex = inStrArr.length;
				}
				
				String [] tempArr = Arrays.copyOfRange(inStrArr, startIndex, endIndex);
			//	com.wm.util.Debug.log(4, "tempArr: "+tempArr+"length: "+tempArr.length);
				outChunkList[i] = tempArr;
			//	com.wm.util.Debug.log(4, "outChunkList: "+outChunkList+"length: "+outChunkList.length);
				startIndex = endIndex + 1;
			}
		}
		
		IDataCursor idc1 = pipeline.getCursor();
		IDataUtil.put(idc1, "listOfChunks", outChunkList);
		idc1.destroy();
				
		// --- <<IS-END>> ---

                
	}
}

