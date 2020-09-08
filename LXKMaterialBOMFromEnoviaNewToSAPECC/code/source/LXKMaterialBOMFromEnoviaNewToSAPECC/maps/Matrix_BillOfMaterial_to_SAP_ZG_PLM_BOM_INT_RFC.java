package LXKMaterialBOMFromEnoviaNewToSAPECC.maps;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.lang.reflect.Method;
import java.util.Vector;
import java.util.Map;
import com.contivo.runtime.wm.*;
import com.contivo.runtime.core.*;
import com.contivo.runtime.common.messages.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServerAPI;
import java.math.BigDecimal;
import com.contivo.runtime.core.TDecimal;
import com.contivo.runtime.common.messages.*;
// --- <<IS-END-IMPORTS>> ---

public final class Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC

{
	// ---( internal utility methods )---

	final static Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC _instance = new Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC();

	static Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC _newInstance() { return new Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC(); }

	static Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC _cast(Object o) { return (Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC)o; }

	// ---( server methods )---



    public static final Values transform (Values in)
    {
        Values out = in;
		// --- <<IS-START(transform)>> ---
		// @sigtype java 3.0
		// [i] record:0:required BillOfMaterial
		// [i] record:0:required RuntimeConfiguration
		// [i] - field:0:required GenerateReports {"false","true"}
		// [i] - field:0:required GenerateTrace {"false","true"}
		// [i] - field:0:required GenerateRuleTrace {"false","true"}
		// [i] - field:0:required LogToFile
		// [i] - field:0:required LogDirectory
		// [i] - field:0:required MaxErrorMessages
		// [i] - field:0:required MaxWarningMessages
		// [i] - field:0:required IterationConstraintChecking {"true","false"}
		// [i] - field:0:required LoadXMLMetaDataOnParse {"false","true"}
		// [o] record:0:required ZG_PLM_BOM_INT
		TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, m_isWmEsourceObject, TARGETOBJECTNAME, ISWMETARGETOBJECT); 
		webmethodsManager.runTransform(out);
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values transformToStream (Values in)
    {
        Values out = in;
		// --- <<IS-START(transformToStream)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, TARGETOBJECTNAME); 
		webmethodsManager.runTransformToStream(out); 
		// --- <<IS-END>> ---
        return out;
                
	}


    public static final Values transformToString (Values in)
    {
        Values out = in;
		// --- <<IS-START(transformToString)>> ---
		// @subtype unknown
		// @sigtype java 3.0
		TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, TARGETOBJECTNAME); 
		webmethodsManager.runTransformToString(out); 
		// --- <<IS-END>> ---
        return out;
                
	}

	// --- <<IS-START-SHARED>> ---
	
	/*********************************************************************/ 
	private static boolean m_started; 
	private static TMapper m_mapper; 
	private static Vector m_sourceObjectNames; 
	private static Vector m_isWmEsourceObject; 
	private static final String TARGETOBJECTNAME = "ZG_PLM_BOM_INT"; 
	private static final boolean ISWMETARGETOBJECT = false; 
	private static final int UNLIMITED = Integer.MAX_VALUE; 
	private static final String EMPTY_STRING = ""; 
	private static final String TRANSFORM_NAME = "Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC"; 
	private static final Class[] PARAMETER_TYPES = {com.contivo.runtime.core.TTransformControl.class}; 
	
	
	static 
	{ 
	try 
	{ 
	m_mapper = new TMapper(Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC.class,TRANSFORM_NAME,"transform",34); 
	m_mapper.setTimeStamp("2009-06-17 01:50:13 EDT"); 
	m_mapper.setTargetEncoding("UTF-8"); 
	m_mapper.setBigDecimalProcessing(false); 
	m_sourceObjectNames = new Vector(); 
	m_isWmEsourceObject = new Vector(); 
	m_sourceObjectNames.add("BillOfMaterial"); 
	m_isWmEsourceObject.add(new Boolean("false")); 
	m_mapper.setSourceObjectNames(m_sourceObjectNames); 
	m_mapper.setTargetObjectName(TARGETOBJECTNAME); 
	createSourceStructure(); 
	createTargetStructure(); 
	createTemporaryFields(); 
	buildTargetNamespaceTable(); 
	m_mapper.initializationCleanup(); 
	boolean[] sourceAttrNSFixed = {true}; 
	m_mapper.setSourceAttrNSFixed(sourceAttrNSFixed); 
	m_mapper.setTargetAttrNSFixed(true); 
	m_started = true; 
	} 
	catch (Exception exception) 
	{ 
	ServerAPI.logError(exception); 
	String exceptionMsg = TMapper.formatException(exception, "Failed to start " + TRANSFORM_NAME); 
	if (m_mapper != null) 
	{ 
	m_mapper.saveStartupFailure(exceptionMsg, exception); 
	} 
	//System.out.println(exceptionMsg); 
	} 
	} 
	
	
	/*********************************************************************/ 
	private static final void createSourceStructure() throws NoSuchMethodException, TStructuredRuntimeException 
	{ 
	
	m_mapper.addSourceRecord("_Z8HOgUruEd6XKsw6DIjAcQ",8,"BillOfMaterial",null,1,1); // BillOfMaterial 
	m_mapper.setXMLInputProcessing(true); 
	m_mapper.addSourceRecord("_Z8HOgkruEd6XKsw6DIjAcQ",7,"results",null,1,UNLIMITED); // results 
	
	{ 
	m_mapper.addSourceField("_Z8HOg0ruEd6XKsw6DIjAcQ",11,"SAP_PLANT",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOhUruEd6XKsw6DIjAcQ",13,"PLANT_PROCURE",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOh0ruEd6XKsw6DIjAcQ",6,"PARENT_PART",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOiEruEd6XKsw6DIjAcQ",19,"CHILD_PART",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOiUruEd6XKsw6DIjAcQ",21,"FIND_NUMBER",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOikruEd6XKsw6DIjAcQ",23,"QUANTITY",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8HOi0ruEd6XKsw6DIjAcQ",26,"ALPGR",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8Q_gEruEd6XKsw6DIjAcQ",28,"ALPRF",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8Q_gUruEd6XKsw6DIjAcQ",30,"ECO_NAME",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8Q_gkruEd6XKsw6DIjAcQ",33,"COMPONENT_LOCATION",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_Z8Q_g0ruEd6XKsw6DIjAcQ",24,"UASAGE",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // results 
	m_mapper.makeParentTheCurrentRecord(); // BillOfMaterial 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTargetStructure() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	
	m_mapper.addTargetRecord("_a5Nv8UruEd6XKsw6DIjAcQ",2,"ZG_PLM_BOM_INT",null,1,1); // ZG_PLM_BOM_INT 
	m_mapper.setSubsecondDigits(-1); m_mapper.setXMLOutputProcessing(true); 
	m_mapper.addTargetRecord("_a5Nv8kruEd6XKsw6DIjAcQ",3,"IT_INTBOM_HDR",null,1,UNLIMITED); // IT_INTBOM_HDR 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("_a5Nv80ruEd6XKsw6DIjAcQ",4,"HEADER_NO",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(4)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {6}; 
	m_mapper.addTargetField("_a5Nv9EruEd6XKsw6DIjAcQ",5,"MATNR",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {11}; 
	m_mapper.addTargetField("_a5Nv9UruEd6XKsw6DIjAcQ",10,"WERKS",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {13}; 
	m_mapper.addTargetField("_a5Nv9kruEd6XKsw6DIjAcQ",12,"STLAN",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(12)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("_a5Nv90ruEd6XKsw6DIjAcQ",14,"STLAL",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(14)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // IT_INTBOM_HDR 
	
	int[][] loopAssociatedSourceIDs15 = {{7}}; 
	
	m_mapper.addTargetRecord("_a5Nv-UruEd6XKsw6DIjAcQ",15,"IT_INTBOM_ITM",null,1,UNLIMITED,loopAssociatedSourceIDs15); // IT_INTBOM_ITM 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("_a5Nv-kruEd6XKsw6DIjAcQ",16,"HEADER_NO",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(16)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("_a5Nv-0ruEd6XKsw6DIjAcQ",17,"ITEM_NO",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(17)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {19}; 
	m_mapper.addTargetField("_a5Nv_EruEd6XKsw6DIjAcQ",18,"IDNRK",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {21}; 
	m_mapper.addTargetField("_a5Nv_UruEd6XKsw6DIjAcQ",20,"SORTF",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {23,24}; 
	m_mapper.addTargetField("_a5Nv_kruEd6XKsw6DIjAcQ",22,"MENGE",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(22)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {26}; 
	m_mapper.addTargetField("_a5Nv_0ruEd6XKsw6DIjAcQ",25,"ALPGR",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {28}; 
	m_mapper.addTargetField("_a5NwAEruEd6XKsw6DIjAcQ",27,"ALPRF",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {30}; 
	m_mapper.addTargetField("_a5NwAUruEd6XKsw6DIjAcQ",29,"AETXT",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("_a5NwAkruEd6XKsw6DIjAcQ",31,"CHG_IND",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(31)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {33}; 
	m_mapper.addTargetField("_a5NwA0ruEd6XKsw6DIjAcQ",32,"POTX1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // IT_INTBOM_ITM 
	m_mapper.makeParentTheCurrentRecord(); // ZG_PLM_BOM_INT 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTemporaryFields() 
	{ 
	m_mapper.addTemporaryField(0,"ItemCount","0"); 
	} 
	
	
	/*********************************************************************/ 
	private static final Method buildMethodReflection(int targetFieldID) throws NoSuchMethodException, SecurityException 
	{ 
	return Matrix_BillOfMaterial_to_SAP_ZG_PLM_BOM_INT_RFC.class.getMethod("mappingRule_" + targetFieldID,PARAMETER_TYPES); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move 1 to Target 
	*/ 
	public static final void mappingRule_4(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget(transformControl.stringValue(1.0)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [BillOfMaterial|BillOfMaterial|results|PLANT_PROCURE] = "SAP SBOM" 
	Move "Z" to Target 
	Else 
	Move "1" to Target 
	Endif 
	*/ 
	public static final void mappingRule_12(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(13), "SAP SBOM")) 
	{ 
	transformControl.setTarget("Z"); 
	} 
	else 
	{ 
	transformControl.setTarget("1"); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "01" to Target 
	*/ 
	public static final void mappingRule_14(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("01"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move 1 to Target 
	*/ 
	public static final void mappingRule_16(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget(transformControl.stringValue(1.0)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Compute ItemCount = [ItemCount] + 1 
	move ItemCount to target 
	*/ 
	public static final void mappingRule_17(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTemporaryNumber(0,transformControl.getTemporaryNumber(0) + 1.0); 
	transformControl.setTarget(new String(transformControl.getTemporary(0))); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [BillOfMaterial|BillOfMaterial|results|UASAGE] = "Remove" 
	Compute Target = [BillOfMaterial|BillOfMaterial|results|QUANTITY] * -1 
	else If [BillOfMaterial|BillOfMaterial|results|UASAGE] = "Remove-Mfg" 
	Compute Target = [BillOfMaterial|BillOfMaterial|results|QUANTITY] * -1 
	else 
	Move [BillOfMaterial|BillOfMaterial|results|QUANTITY] to Target 
	Endif 
	*/ 
	public static final void mappingRule_22(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(24), "Remove")) 
	{ 
	transformControl.setTargetNumber(transformControl.getSourceNumber(23) * -1.0); 
	} 
	else if (Compare.equals(transformControl.getSource(24), "Remove-Mfg")) 
	{ 
	transformControl.setTargetNumber(transformControl.getSourceNumber(23) * -1.0); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(23), 22, 23)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move Empty_String to Target 
	*/ 
	public static final void mappingRule_31(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTargetEmpty(); 
	} 
	static { 
	buildTables(); 
	} 
	
	/*********************************************************************/ 
	private static final void buildTables() 
	{ 
	} 
	
	
	/*********************************************************************/ 
	private static final void buildTargetNamespaceTable() 
	{ 
	} 
	
	
	
	// --- <<IS-END-SHARED>> ---
}

