package lxkShared.as400;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2008-04-01 10:12:59 EST
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.ibm.as400.access.ProgramParameter;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.rpg.util.AS400RPGHelper;
// --- <<IS-END-IMPORTS>> ---

public final class as400RPGHelper

{
	// ---( internal utility methods )---

	final static as400RPGHelper _instance = new as400RPGHelper();

	static as400RPGHelper _newInstance() { return new as400RPGHelper(); }

	static as400RPGHelper _cast(Object o) { return (as400RPGHelper)o; }

	// ---( server methods )---




	public static final void callRPGProgram (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(callRPGProgram)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required host
		// [i] field:0:required user
		// [i] field:0:required password
		// [i] field:0:required fullyQualifiedProgramName
	IDataCursor pipelineCursor = pipeline.getCursor();

	// Get inputs values
	String	host = IDataUtil.getString( pipelineCursor, CALLRPGPROGRAM_INPUTPARM_HOST );
	String	user = IDataUtil.getString( pipelineCursor, CALLRPGPROGRAM_INPUTPARM_USER );
	String	password = IDataUtil.getString( pipelineCursor, CALLRPGPROGRAM_INPUTPARM_PASSWORD );
	String	progName = IDataUtil.getString( pipelineCursor, CALLRPGPROGRAM_INPUTPARM_PROGNAME );

	// make sure we have valid input so far
	if (host == null || user == null || password == null || progName == null) {
			throw new ServiceException(ERROR_INVALID_INPUT);
	}

	// get the parameters list from the input
	IData[]	parameters = IDataUtil.getIDataArray( pipelineCursor, CALLRPGPROGRAM_INPUTPARM_PARAMETERS );

	// extract the parameter values and create valid RPG parameters
	ProgramParameter[] parms = null;
	int numParms = 0;
	if (parameters != null) {
		numParms = parameters.length;
		parms = new ProgramParameter[numParms];
		IDataCursor parametersCursor = null;
		String value = null;
		StringBuffer paddedValue = null;
		String maxByteSizeString = null;
		int maxByteSize = 0;
		int stringLength = 0;
		int bufferSize = 0;
		AS400Text tempAS400TextIn = null;

		// loop through parameter list and create individual RPG parameters
		for ( int i = 0; i < numParms; i++ ) {
			parametersCursor = parameters[i].getCursor();

			// retrieve paramter values from the pipeline
			value = IDataUtil.getString( parametersCursor, CALLRPGPROGRAM_PARM_PARAMETERS_VALUE );
			maxByteSize = IDataUtil.getInt( parametersCursor, CALLRPGPROGRAM_PARM_PARAMETERS_MAXBYTESIZE, 0 );

			// determine size of the value
			if (value != null) {
				stringLength = value.length();
			} else {
				stringLength = 1;
				value = SINGLE_SPACE;
			}

			// deterime the left padding needed and pad the value
			bufferSize = maxByteSize - stringLength;
			paddedValue = new StringBuffer();
			for (int j=0; j<bufferSize;j++) {
				paddedValue.append(SINGLE_SPACE);
			}
			if (value != null) {
				paddedValue.append(value);
			}

			// Enforce the max length size
			paddedValue.setLength(maxByteSize);
			
			// Convert the string into bytes and create RPG friendly parm
			tempAS400TextIn = new AS400Text(maxByteSize);
			parms[i] = new ProgramParameter(tempAS400TextIn.toBytes(paddedValue.toString()),maxByteSize);

			parametersCursor.destroy();
		}
	}

	try {
		// Call the RPG program
		if (parms == null) {
			AS400RPGHelper.callRPGProgram(host, user, password, progName);
		} else {
			AS400RPGHelper.callRPGProgram(host, user, password, progName, parms);
		}
	}
	catch (Exception e) {
		StringBuffer message = new StringBuffer(ERROR_RPG_CALL_FAILED);
		message.append(e.toString());
		throw new ServiceException(message.toString());
	}

	// place the output parameters values into the pipeline
	if (parameters != null) {
		IData[] postCallParms = new IData[numParms];
		IDataCursor inParmCursor = null;
		IData outParm = null;
		IDataCursor outParmCursor = null;
		int maxByteSize = 0;
		AS400Text tempAS400TextOut = null;

		// loop through the output parameters, the same number will exist that we sent in
		for (int i=0; i<numParms; i++) {
			inParmCursor = parameters[i].getCursor();
			outParm = IDataFactory.create();
			outParmCursor = outParm.getCursor();
			
			// retrieve the max byte size value from the RPG parameter
			maxByteSize = IDataUtil.getInt(inParmCursor,CALLRPGPROGRAM_PARM_PARAMETERS_MAXBYTESIZE,0);
			
			// retrieve the return value from the RPG parameter and put in pipeline along with max byte size
			tempAS400TextOut = new AS400Text(maxByteSize);
			outParmCursor.insertAfter(CALLRPGPROGRAM_PARM_PARAMETERS_VALUE,((String)(tempAS400TextOut.toObject(parms[i].getOutputData()))).trim());
			outParmCursor.insertAfter(CALLRPGPROGRAM_PARM_PARAMETERS_MAXBYTESIZE,String.valueOf(maxByteSize));
			outParmCursor.destroy();
			inParmCursor.destroy();
			postCallParms[i] = outParm;
		}
		IDataUtil.put(pipelineCursor,CALLRPGPROGRAM_OUTPUTPARM_PARAMETERS,postCallParms);
	}
	pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	//*************************************************************************************
	//* INPUT PARAMETER NAMES
	//*************************************************************************************
	private static final String CALLRPGPROGRAM_INPUTPARM_HOST = "host";
	private static final String CALLRPGPROGRAM_INPUTPARM_USER = "user";
	private static final String CALLRPGPROGRAM_INPUTPARM_PASSWORD = "password";
	private static final String CALLRPGPROGRAM_INPUTPARM_PROGNAME = "fullyQualifiedProgramName";
	private static final String CALLRPGPROGRAM_INPUTPARM_PARAMETERS = "parameters";
	private static final String CALLRPGPROGRAM_OUTPUTPARM_PARAMETERS = "postCallParameters";
	private static final String CALLRPGPROGRAM_PARM_PARAMETERS_VALUE = "value";
	private static final String CALLRPGPROGRAM_PARM_PARAMETERS_MAXBYTESIZE = "maxByteSize";
	
	//*************************************************************************************
	//* MISC CONSTANTS
	//*************************************************************************************
	private static final String ERROR_INVALID_INPUT = "Invalid input.";
	private static final String ERROR_RPG_CALL_FAILED = "An error occurred while calling the RPG program: ";
	private static final String SINGLE_SPACE = " ";
	// --- <<IS-END-SHARED>> ---
}

