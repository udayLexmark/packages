/***************************************************************************
**  Class: recordToNVP
**
**  Author: Tony Foltz              Date: 2/26/02
**
**  Description: Converts a webMethods IData object to a NVP String
**  Input: 
**
***************************************************************************/

import java.io.*;
import java.util.*;
import com.wm.*;
import com.wm.data.*;


public class recordToNVP {

	public recordToNVP () {
	}


	public IData parseObject (Object inObject, String baseKey) throws Exception {
		String className = "";
		String nvpString = "";
		Class thisClass  = null;
		IData outputIData = IDataFactory.create();
		IDataCursor outputCursor = outputIData.getCursor();
		
		thisClass = inObject.getClass();
		className = thisClass.getName();

		if (thisClass.isArray()) { // Array
			outputIData = parseArrayParameters(inObject);
			if ((baseKey != null) && (baseKey != "")) {
				outputIData = addPrefixToKeys(outputIData, baseKey);
			}
		}
		else if (className.equals("com.wm.data.BasicData")) {
			outputIData = parseRecord((IData) inObject);	
			if ((baseKey != null) && (baseKey != "")) {
				outputIData = addPrefixToKeys(outputIData, baseKey + ".");
			}
		}
		else if (className.equals("com.wm.data.IData")) {
			outputIData = parseRecord((IData) inObject);
			if ((baseKey != null) && (baseKey != "")) {
				outputIData = addPrefixToKeys(outputIData, baseKey + ".");
			}
		}	
		else if (className.equals("com.wm.lang.xml.Document")) {
			com.wm.lang.xml.Document doc = (com.wm.lang.xml.Document) inObject;
			outputCursor.insertAfter(baseKey, doc.getText());
		}	
		else if (className.equals("com.wm.util.Values")) {
			outputIData = parseRecord((IData) inObject);
			if ((baseKey != null) && (baseKey != "")) {
				outputIData = addPrefixToKeys(outputIData, baseKey + ".");
			}
		}	
		else if (className.equals("java.lang.String")) {
			String value = (String) inObject;
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Byte")) {
			Byte object = (Byte) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Character")) {
			Character object = (Character) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Double")) {
			Double object = (Double) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Float")) {
			Float object = (Float) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Integer")) {
			Integer object = (Integer) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Long")) {
			Long object = (Long) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Short")) {
			Short object = (Short) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else if (className.equals("java.lang.Boolean")) {
			Boolean object = (Boolean) inObject;
			String value = object.toString();
			outputCursor.insertAfter(baseKey, value);
		}
		else {  
			Exception thisException = new Exception("Unknown datatype of " + className + " for value '" + baseKey + "'.");
			throw(thisException);
		}
		
		return (outputIData);
	}


	public IData parseRecord (IData inRecord) throws Exception {
		IDataCursor inCursor = inRecord.getCursor();
		IData outputIData = IDataFactory.create();
		IData tempIData = null;
		String className = "";
		String key	 = "";

		while (inCursor.next()) {
			className = inCursor.getValue().getClass().getName();
				
			key = inCursor.getKey();
			
			// Try to cast to an Object 
			Object thisObject = null;
			thisObject = inCursor.getValue();

			tempIData = parseObject(thisObject, key); 
			outputIData = appendToIData(tempIData, outputIData);
		}
		return (outputIData);
	}


	private IData parseArrayParameters(Object inObject) throws Exception {
		IData outputIData = IDataFactory.create();
		IDataCursor cursor = outputIData.getCursor();
		IData tempIData = IDataFactory.create();

		Class thisClass = inObject.getClass();
		String className = thisClass.getName();
		String arrayIndex = "";
		int bracketIndex = className.indexOf("[");
		className = className.substring(bracketIndex+1);

		if (className.startsWith("[")) { // Multi-dimensional Array
			Object[] objectArray = (Object[]) inObject;
			for (int i=0; i<objectArray.length; i++) {
				arrayIndex = "[" + i + "]";
				tempIData = parseObject(objectArray[i], arrayIndex); 
				outputIData = appendToIData(tempIData, outputIData);
			}
		}
		else if (className.equals("B")) {
			byte[] byteArray = (byte[]) inObject;
			String outStr = new String(byteArray);
			cursor.insertAfter("", outStr);

			return (outputIData);
		}
		else if (className.equals("C")) {
			char[] charArray = (char[]) inObject;
			Character charObj = null;

			for (int i=0; i<charArray.length; i++) {
				arrayIndex = "[" + i + "]";
				charObj = new Character(charArray[i]);
				tempIData = parseObject(charObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("D")) {
			double[] doubleArray = (double[]) inObject;
			Double doubleObj = null;

			for (int i=0; i<doubleArray.length; i++) {
				arrayIndex = "[" + i + "]";
				doubleObj = new Double(doubleArray[i]);
				tempIData = parseObject(doubleObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("F")) {
			float[] floatArray = (float[]) inObject;
			Float floatObj = null;

			for (int i=0; i<floatArray.length; i++) {
				arrayIndex = "[" + i + "]";
				floatObj = new Float(floatArray[i]);
				tempIData = parseObject(floatObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("I")) {
			int[] intArray = (int[]) inObject;
			Integer intObj = null;

			for (int i=0; i<intArray.length; i++) {
				arrayIndex = "[" + i + "]";
				intObj = new Integer(intArray[i]);
				tempIData = parseObject(intObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("J")) {
			long[] longArray = (long[]) inObject;
			Long longObj = null;

			for (int i=0; i<longArray.length; i++) {
				arrayIndex = "[" + i + "]";
				longObj = new Long(longArray[i]);
				tempIData = parseObject(longObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("S")) {
			short[] shortArray = (short[]) inObject;
			Short shortObj = null;

			for (int i=0; i<shortArray.length; i++) {
				arrayIndex = "[" + i + "]";
				shortObj = new Short(shortArray[i]);
				tempIData = parseObject(shortObj, arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if (className.equals("Z")) {
			boolean[] booleanArray = (boolean[]) inObject;
			Boolean booleanObj = null;

			for (int i=0; i<booleanArray.length; i++) {
				arrayIndex = "[" + i + "]";
				booleanObj = new Boolean(booleanArray[i]);
				tempIData = parseObject(booleanObj, arrayIndex);

				appendArrayIndices(tempIData);
				outputIData = appendToIData(tempIData, outputIData);
			}	
		}
		else if ((className.startsWith("L")) && (className.endsWith(";"))) {
			Object[] objectArray = (Object[]) inObject;

			for (int i=0; i<objectArray.length; i++) {
				arrayIndex = "[" + i + "]";
				tempIData = parseObject(objectArray[i], arrayIndex);
				outputIData = appendToIData(tempIData, outputIData);
			}
		}
		
		return (outputIData);
	}


	private IData appendArrayIndices(IData outputIData) {
		int counter = 0;
		IDataCursor cursor = outputIData.getCursor(); // Reset cursor
		String key = "";
		while (cursor.next()) {
			key = cursor.getKey();	
			cursor.setKey(key +"[" + Integer.toString(counter) + "]");
			counter++;
		}
		
		return (outputIData);
	}


	private IData appendToIData(IData insertIData, IData outputIData) {
		IDataCursor fromCursor = insertIData.getCursor();
		IDataCursor toCursor   = outputIData.getCursor();
		String key = "";
		Object value = null;

		toCursor.last();

		while (fromCursor.next()) {
			key = fromCursor.getKey();
			value = fromCursor.getValue();
			toCursor.insertAfter(key, value);
		}
		
		return (outputIData);
	}


	private IData addPrefixToKeys(IData inIData, String addString) {
		IDataCursor cursor = inIData.getCursor();
		String key = "";
		while (cursor.next()) {
			key = cursor.getKey();
			key = addString + key; 
			cursor.setKey(key);
		}
		
		return (inIData);
	}


	private IData addSuffixToKeys(IData inIData, String addString) {
		IDataCursor cursor = inIData.getCursor();
		String key = "";
		while (cursor.next()) {
			key = cursor.getKey();
			key = key + addString; 
			cursor.setKey(key);
		}
		
		return (inIData);
	}

}
