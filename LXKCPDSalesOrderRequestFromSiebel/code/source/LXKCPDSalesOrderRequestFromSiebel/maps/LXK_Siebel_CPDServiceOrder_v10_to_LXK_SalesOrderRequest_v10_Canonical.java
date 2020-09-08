package LXKCPDSalesOrderRequestFromSiebel.maps;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-04-19 16:06:07 EDT
// -----( ON-HOST: dashrwmis001.lex.lexmark.com

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
import com.wm.app.b2b.server.ServerAPI;
import java.math.BigDecimal;
import com.contivo.runtime.core.TDecimal;
// --- <<IS-END-IMPORTS>> ---

public final class LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical

{
	// ---( internal utility methods )---

	final static LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical _instance = new LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical();

	static LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical _newInstance() { return new LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical(); }

	static LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical _cast(Object o) { return (LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical)o; }

	// ---( server methods )---



    public static final Values transform (Values in)
    {
        Values out = in;
		// --- <<IS-START(transform)>> ---
		// @sigtype java 3.0
		// [i] record:0:required OrderOutboundDTD
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
		// [o] record:0:required SalesOrderRequest
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
	private static final String TARGETOBJECTNAME = "SalesOrderRequest"; 
	private static final boolean ISWMETARGETOBJECT = false; 
	private static final int UNLIMITED = Integer.MAX_VALUE; 
	private static final String EMPTY_STRING = ""; 
	private static final String TRANSFORM_NAME = "LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical"; 
	private static final Class[] PARAMETER_TYPES = {com.contivo.runtime.core.TTransformControl.class}; 
	
	
	static 
	{ 
	try 
	{ 
	m_mapper = new TMapper(LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical.class,TRANSFORM_NAME,"transform",268); 
	m_mapper.setTimeStamp("2016-04-19 03:58:09 EDT"); 
	m_mapper.setTargetEncoding("UTF-8"); 
	m_mapper.setBigDecimalProcessing(false); 
	m_sourceObjectNames = new Vector(); 
	m_isWmEsourceObject = new Vector(); 
	m_sourceObjectNames.add("OrderOutboundDTD"); 
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
	
	m_mapper.addSourceRecord("_98QFEQZeEeaXBLGJHoGSVQ",11,"SiebelMessage",null,1,1); // SiebelMessage 
	m_mapper.setXMLInputProcessing(true); 
	{ 
	m_mapper.addSourceField("_98QFEgZeEeaXBLGJHoGSVQ",14,"@MessageId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	m_mapper.addSourceRecord("_98QFFgZeEeaXBLGJHoGSVQ",10,"ListOfLxkCOrderEntry",null,0,UNLIMITED); // ListOfLxkCOrderEntry 
	
	m_mapper.addSourceRecord("_98QFFwZeEeaXBLGJHoGSVQ",9,"OrderEntry-Orders",null,0,UNLIMITED); // OrderEntry-Orders 
	
	{ 
	m_mapper.addSourceField("_98QFGgZeEeaXBLGJHoGSVQ",8,"LXKSDSRType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFHAZeEeaXBLGJHoGSVQ",133,"LXKMPSWhiteGloveFlag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFHQZeEeaXBLGJHoGSVQ",82,"LXKMPSStoreFrontName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFHgZeEeaXBLGJHoGSVQ",129,"LXKMPSSpecialPartner",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFHwZeEeaXBLGJHoGSVQ",47,"LXKMPSSoldTo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFIQZeEeaXBLGJHoGSVQ",120,"LXKMPSSPHouseNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFIgZeEeaXBLGJHoGSVQ",107,"LXKMPSSPDistrict",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFJAZeEeaXBLGJHoGSVQ",119,"LXKMPSHouseNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFJQZeEeaXBLGJHoGSVQ",137,"LXKMPSFF",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFJwZeEeaXBLGJHoGSVQ",106,"LXKMPSDistrict",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFKAZeEeaXBLGJHoGSVQ",146,"LXKMPSDeliveryInstruc",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFKgZeEeaXBLGJHoGSVQ",198,"Id",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFMgZeEeaXBLGJHoGSVQ",65,"Account",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFXQZeEeaXBLGJHoGSVQ",132,"CarrierPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFXgZeEeaXBLGJHoGSVQ",135,"CarrierType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFYAZeEeaXBLGJHoGSVQ",192,"Comments",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFYQZeEeaXBLGJHoGSVQ",140,"ContactFirstName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFZAZeEeaXBLGJHoGSVQ",139,"ContactLastName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFZQZeEeaXBLGJHoGSVQ",76,"ContactWorkPhone",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFZgZeEeaXBLGJHoGSVQ",37,"CreatedByName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98QFfwZeEeaXBLGJHoGSVQ",44,"CurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPCQZeEeaXBLGJHoGSVQ",57,"LXKCAccountServiceClassification",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPDAZeEeaXBLGJHoGSVQ",71,"LXKCContactFullName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPDgZeEeaXBLGJHoGSVQ",75,"LXKCSRContactPhoneNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPEwZeEeaXBLGJHoGSVQ",87,"LXKCPrimaryShipToAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPFAZeEeaXBLGJHoGSVQ",90,"LXKCPrimaryShipToAddress3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPFwZeEeaXBLGJHoGSVQ",189,"LXKCServiceOverrideType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPJgZeEeaXBLGJHoGSVQ",26,"OrderDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPKAZeEeaXBLGJHoGSVQ",264,"OrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPKwZeEeaXBLGJHoGSVQ",24,"OrderType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPQwZeEeaXBLGJHoGSVQ",141,"LXKSDSPReferenceNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPRQZeEeaXBLGJHoGSVQ",142,"LXKSDOwnerTechnician",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPYAZeEeaXBLGJHoGSVQ",19,"PrimaryOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPagZeEeaXBLGJHoGSVQ",67,"PrimaryShipToAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPbAZeEeaXBLGJHoGSVQ",96,"PrimaryShipToCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPbwZeEeaXBLGJHoGSVQ",80,"PrimaryShipToFirstName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPcAZeEeaXBLGJHoGSVQ",81,"PrimaryShipToLastName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPcQZeEeaXBLGJHoGSVQ",93,"PrimaryShipToPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPfQZeEeaXBLGJHoGSVQ",237,"RequestedShipDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPgAZeEeaXBLGJHoGSVQ",29,"ReturnReason",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPrAZeEeaXBLGJHoGSVQ",262,"ServiceRequestNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPygZeEeaXBLGJHoGSVQ",60,"LXKSDPrimaryShipToJDENumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPywZeEeaXBLGJHoGSVQ",244,"LXKSDEntitlementType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZPzAZeEeaXBLGJHoGSVQ",63,"LXKSDCSSFlag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP0QZeEeaXBLGJHoGSVQ",202,"LXKSDServiceProductName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP0gZeEeaXBLGJHoGSVQ",207,"LXKSDServiceProductBusinessArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	createSourceStructure1(); 
	} 
	
	
	/*********************************************************************/ 
	private static final void createSourceStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	{ 
	m_mapper.addSourceField("_98ZP0wZeEeaXBLGJHoGSVQ",70,"LXKSDServiceProviderPrimaryShipToAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP1gZeEeaXBLGJHoGSVQ",94,"LXKSDSPPrimaryShipToPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP1wZeEeaXBLGJHoGSVQ",61,"LXKSDSPPrimaryShipToJDENumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP2QZeEeaXBLGJHoGSVQ",97,"LXKSDSPPrimaryShipToCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP2wZeEeaXBLGJHoGSVQ",91,"LXKSDSPPrimaryShipToAddress3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP3AZeEeaXBLGJHoGSVQ",88,"LXKSDSPPrimaryShipToAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP3QZeEeaXBLGJHoGSVQ",148,"LXKSDLexmarkPaysPartsReturn",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP3wZeEeaXBLGJHoGSVQ",66,"LXKSDShipToAddressName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP4AZeEeaXBLGJHoGSVQ",68,"LXKSDFunctionalClassification",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP4QZeEeaXBLGJHoGSVQ",69,"LXKSDServiceProviderName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP5AZeEeaXBLGJHoGSVQ",144,"LXKMPSAssetIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP5QZeEeaXBLGJHoGSVQ",84,"LXKMPSAttentionTo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP5gZeEeaXBLGJHoGSVQ",171,"LXKMPSBillingModel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP5wZeEeaXBLGJHoGSVQ",260,"LXKMPSCustomerPONumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP6AZeEeaXBLGJHoGSVQ",145,"LXKMPSInsideLocation",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP6QZeEeaXBLGJHoGSVQ",267,"LXKMPSPLID",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP6gZeEeaXBLGJHoGSVQ",77,"LXKMPSSRArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP6wZeEeaXBLGJHoGSVQ",62,"LXKMPSShipToNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP7QZeEeaXBLGJHoGSVQ",143,"LXKMPSSpecialHandlingInstructions",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP7gZeEeaXBLGJHoGSVQ",50,"LXKMPSProject",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP7wZeEeaXBLGJHoGSVQ",52,"LXKMPSProjectPhase",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP8AZeEeaXBLGJHoGSVQ",159,"LXKMPSIPAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP8QZeEeaXBLGJHoGSVQ",155,"LXKMPSIPAddressName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP8gZeEeaXBLGJHoGSVQ",163,"LXKMPSIPCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP9QZeEeaXBLGJHoGSVQ",157,"LXKMPSInstallationPartnerAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP9wZeEeaXBLGJHoGSVQ",152,"LXKMPSIPShipToNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP-QZeEeaXBLGJHoGSVQ",167,"LXKMPSIPCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP-gZeEeaXBLGJHoGSVQ",165,"LXKMPSIPRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP_QZeEeaXBLGJHoGSVQ",102,"LXKSDSPPrimaryShipToCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZP_gZeEeaXBLGJHoGSVQ",100,"LXKSDSPPrimaryShipToRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQAQZeEeaXBLGJHoGSVQ",103,"PrimaryShipToCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQAgZeEeaXBLGJHoGSVQ",99,"PrimaryShipToRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQAwZeEeaXBLGJHoGSVQ",193,"LXKSDWarningMessageDispatch",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQBAZeEeaXBLGJHoGSVQ",161,"LXKMPSIPPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQBQZeEeaXBLGJHoGSVQ",54,"LXKMPSSRSubArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQBwZeEeaXBLGJHoGSVQ",39,"LXKMPSGSAScheduleCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQCAZeEeaXBLGJHoGSVQ",149,"LXK3PLReturnLabel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQCQZeEeaXBLGJHoGSVQ",41,"LXKMPSSIN",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	m_mapper.addSourceRecord("_98ZQCgZeEeaXBLGJHoGSVQ",34,"ListOfOrderEntry-LineItems",null,0,1); // ListOfOrderEntry-LineItems 
	
	m_mapper.addSourceRecord("_98ZQCwZeEeaXBLGJHoGSVQ",33,"OrderEntry-LineItems",null,0,UNLIMITED); // OrderEntry-LineItems 
	
	{ 
	m_mapper.addSourceField("_98ZQDwZeEeaXBLGJHoGSVQ",204,"LXKMPSVendorPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQEAZeEeaXBLGJHoGSVQ",211,"LXKMPSSolutionPart",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQEQZeEeaXBLGJHoGSVQ",209,"LXKMPSSolutionLine",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQFAZeEeaXBLGJHoGSVQ",255,"LXKMPSParentSAPLine",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQGQZeEeaXBLGJHoGSVQ",247,"Id",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQHwZeEeaXBLGJHoGSVQ",254,"LXKMPSHWConfigId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQIAZeEeaXBLGJHoGSVQ",252,"LXKMPSSAPContractNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQJAZeEeaXBLGJHoGSVQ",249,"ActivityId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQOAZeEeaXBLGJHoGSVQ",241,"CarrierCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	createSourceStructure2(); 
	} 
	
	
	/*********************************************************************/ 
	private static final void createSourceStructure2() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	{ 
	m_mapper.addSourceField("_98ZQSgZeEeaXBLGJHoGSVQ",230,"DestinationInventoryLocation2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQhwZeEeaXBLGJHoGSVQ",187,"LXKRLineType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQigZeEeaXBLGJHoGSVQ",200,"LXKRProductModel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQlgZeEeaXBLGJHoGSVQ",185,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQrQZeEeaXBLGJHoGSVQ",196,"Product",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQugZeEeaXBLGJHoGSVQ",222,"QuantityRequested",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQ3wZeEeaXBLGJHoGSVQ",214,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQ6AZeEeaXBLGJHoGSVQ",239,"ShipMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZQ9wZeEeaXBLGJHoGSVQ",32,"SourceInventoryLocation2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRAAZeEeaXBLGJHoGSVQ",220,"UnitofMeasure",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRFQZeEeaXBLGJHoGSVQ",216,"LXKSDAssetRIDTag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRFwZeEeaXBLGJHoGSVQ",234,"LXKMPSFullfillmentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRGAZeEeaXBLGJHoGSVQ",257,"LXKMPSSendtoSAP",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRGQZeEeaXBLGJHoGSVQ",232,"LXKMPSVendorNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // OrderEntry-LineItems 
	m_mapper.makeParentTheCurrentRecord(); // ListOfOrderEntry-LineItems 
	
	m_mapper.addSourceRecord("_98ZRHAZeEeaXBLGJHoGSVQ",175,"ListOfLXKMPSSRPayments",null,0,1); // ListOfLXKMPSSRPayments 
	
	m_mapper.addSourceRecord("_98ZRHQZeEeaXBLGJHoGSVQ",174,"ListOfLxkMpsSrPayments",null,0,UNLIMITED); // ListOfLxkMpsSrPayments 
	
	{ 
	m_mapper.addSourceField("_98ZRHgZeEeaXBLGJHoGSVQ",173,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRIQZeEeaXBLGJHoGSVQ",179,"AuthorizationCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRKQZeEeaXBLGJHoGSVQ",177,"CardHolder",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRKwZeEeaXBLGJHoGSVQ",181,"ExpirationMonth",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	
	{ 
	m_mapper.addSourceField("_98ZRLAZeEeaXBLGJHoGSVQ",182,"ExpirationYear",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // ListOfLxkMpsSrPayments 
	m_mapper.makeParentTheCurrentRecord(); // ListOfLXKMPSSRPayments 
	m_mapper.makeParentTheCurrentRecord(); // OrderEntry-Orders 
	m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCOrderEntry 
	m_mapper.makeParentTheCurrentRecord(); // SiebelMessage 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTargetStructure() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	
	m_mapper.addTargetRecord("1716440",1,"SalesOrderRequest",null,1,1); // SalesOrderRequest 
	m_mapper.setSubsecondDigits(-2); 
	m_mapper.addTargetRecord("1716457",2,"DocumentMetaData",null,0,1); // DocumentMetaData 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716618",3,"EnterpriseDocumentId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(3)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716620",4,"EnterpriseCanonicalName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(4)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716624",5,"SourceSystem",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(5)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716626",6,"SourceInterface",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(6)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8}; 
	m_mapper.addTargetField("_RHk8ABlEEd6Nz-Od1HHEZQ",7,"BusinessProcess",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(7)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {14}; 
	m_mapper.addTargetField("1716628",13,"SourceDocumentTrackingId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716632",15,"ObjectChangeActionType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(15)); 
	m_mapper.addTableToField(0); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716635",16,"IntegrationCreationDateTime",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(16)); 
	} 
	
	m_mapper.addTargetRecord("1716480",17,"RelevantGeographies",null,0,1); // RelevantGeographies 
	
	{ 
	int[] sourceFieldIDs = {19}; 
	m_mapper.addTargetField("1716918",18,"US",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(18)); 
	m_mapper.setDefaultValue("YES", false); 
	m_mapper.addTableToField(1); 
	} 
	
	{ 
	int[] sourceFieldIDs = {19}; 
	m_mapper.addTargetField("1716921",20,"EMEA",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(20)); 
	m_mapper.setDefaultValue("YES", false); 
	m_mapper.addTableToField(2); 
	} 
	
	{ 
	int[] sourceFieldIDs = {19}; 
	m_mapper.addTargetField("1716924",21,"APG",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(21)); 
	m_mapper.setDefaultValue("YES", false); 
	m_mapper.addTableToField(3); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // RelevantGeographies 
	m_mapper.makeParentTheCurrentRecord(); // DocumentMetaData 
	
	m_mapper.addTargetRecord("1716469",22,"Header",null,0,1); // Header 
	
	{ 
	int[] sourceFieldIDs = {24}; 
	m_mapper.addTargetField("1716768",23,"OrderType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {26}; 
	m_mapper.addTargetField("1716770",25,"OrderDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(25)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716782",27,"OrderTotalAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(27)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {29}; 
	m_mapper.addTargetField("1716795",28,"ReturnReason",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(28)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	m_mapper.addTargetRecord("1716468",30,"LexmarkOrderInformation",null,0,1); // LexmarkOrderInformation 
	
	{ 
	int[] sourceFieldIDs = {32}; 
	m_mapper.addTargetField("1716756",31,"BusinessOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(31)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	{ 
	int[] sourceFieldIDs = {19}; 
	m_mapper.addTargetField("1716758",35,"InternalCompanyId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(35)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	{ 
	int[] sourceFieldIDs = {37}; 
	m_mapper.addTargetField("1716762",36,"OrderEnteredBy",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {39}; 
	m_mapper.addTargetField("1716766",38,"AgreementNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {41}; 
	m_mapper.addTargetField("_moC-wAZeEeaLG9u_sli0tQ",40,"AgreementItemNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // LexmarkOrderInformation 
	
	m_mapper.addTargetRecord("1716446",42,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 
	
	{ 
	int[] sourceFieldIDs = {44}; 
	m_mapper.addTargetField("1716499",43,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(43)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	m_mapper.addTargetRecord("_MuDtfB8rEd6Iyv516O0vMA",45,"SoldToInformation",null,0,1); // SoldToInformation 
	
	{ 
	int[] sourceFieldIDs = {47}; 
	m_mapper.addTargetField("_MuDtfx8rEd6Iyv516O0vMA",46,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // SoldToInformation 
	
	m_mapper.addTargetRecord("_0330ARNhEeSGwJLQ2nYEaQ",48,"ProjectInformation",null,0,1); // ProjectInformation 
	
	{ 
	int[] sourceFieldIDs = {50}; 
	m_mapper.addTargetField("_13RbgBNhEeSGwJLQ2nYEaQ",49,"ProjectNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {52}; 
	m_mapper.addTargetField("_13SCkBNhEeSGwJLQ2nYEaQ",51,"ProjectPhase",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {54}; 
	m_mapper.addTargetField("_13SCkRNhEeSGwJLQ2nYEaQ",53,"RequestType",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // ProjectInformation 
	m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 
	
	m_mapper.addTargetRecord("1716473",55,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 
	
	{ 
	int[] sourceFieldIDs = {57}; 
	m_mapper.addTargetField("1716854",56,"CustomerOrderFullfillmentlPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(56)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	m_mapper.addTargetRecord("1716466",58,"ShipToInformation",null,0,1); // ShipToInformation 
	
	{ 
	int[] sourceFieldIDs = {60,61,8,62,19,63}; 
	m_mapper.addTargetField("1716723",59,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(59)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {65,66,67,68,69,70,57,71}; 
	m_mapper.addTargetField("1716725",64,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(64)); 
	} 
	
	m_mapper.addTargetRecord("1716459",72,"ContactInformation",null,0,1); // ContactInformation 
	
	{ 
	int[] sourceFieldIDs = {71}; 
	m_mapper.addTargetField("1716647",73,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {75,76,8,77}; 
	m_mapper.addTargetField("1716651",74,"TelephoneNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(74)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // ContactInformation 
	
	m_mapper.addTargetRecord("1716467",78,"PhysicalAddress",null,0,1); // PhysicalAddress 
	
	{ 
	int[] sourceFieldIDs = {80,81,69,65,57,71,67,70,66,68,8,82}; 
	m_mapper.addTargetField("1716729",79,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(79)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {84,8,77,71}; 
	m_mapper.addTargetField("1716731",83,"Name2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(83)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {67,70}; 
	m_mapper.addTargetField("1716733",85,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(85)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {87,88}; 
	m_mapper.addTargetField("1716735",86,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(86)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {90,91}; 
	m_mapper.addTargetField("1716737",89,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(89)); 
	} 
	createTargetStructure1(); 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTargetStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	{ 
	int[] sourceFieldIDs = {93,94}; 
	m_mapper.addTargetField("1716741",92,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(92)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {96,97}; 
	m_mapper.addTargetField("1716743",95,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(95)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {99,100}; 
	m_mapper.addTargetField("1716745",98,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(98)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {102,103}; 
	m_mapper.addTargetField("1716747",101,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(101)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {100,99}; 
	m_mapper.addTargetField("1716752",104,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(104)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {106,107}; 
	m_mapper.addTargetField("1716754",105,"District",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(105)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
	m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 
	
	m_mapper.addTargetRecord("_T0Pa8BliEd6Nz-Od1HHEZQ",108,"EndUserShipToInformation",null,0,1); // EndUserShipToInformation 
	
	{ 
	int[] sourceFieldIDs = {60,61,8,19,63,62}; 
	m_mapper.addTargetField("_T0Pa8xliEd6Nz-Od1HHEZQ",109,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(109)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {71,65,66,67,68,69,70,57,8,19}; 
	m_mapper.addTargetField("_T0Pa9BliEd6Nz-Od1HHEZQ",110,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(110)); 
	} 
	
	m_mapper.addTargetRecord("_T0Pa8RliEd6Nz-Od1HHEZQ",111,"ContactInformation",null,0,1); // ContactInformation 
	
	{ 
	int[] sourceFieldIDs = {71,8,19}; 
	m_mapper.addTargetField("_T0Pa9hliEd6Nz-Od1HHEZQ",112,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(112)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8,75,19}; 
	m_mapper.addTargetField("_T0Pa-BliEd6Nz-Od1HHEZQ",113,"TelephoneNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(113)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // ContactInformation 
	
	m_mapper.addTargetRecord("_T0Pa8hliEd6Nz-Od1HHEZQ",114,"PhysicalAddress",null,0,1); // PhysicalAddress 
	
	{ 
	int[] sourceFieldIDs = {68,80,81,69,65,57,71,67,70,66,8,19}; 
	m_mapper.addTargetField("_T0Pa-xliEd6Nz-Od1HHEZQ",115,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(115)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {70,67,8,19}; 
	m_mapper.addTargetField("_T0Pa_RliEd6Nz-Od1HHEZQ",116,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(116)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {88,87,8,19}; 
	m_mapper.addTargetField("_T0Pa_hliEd6Nz-Od1HHEZQ",117,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(117)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {119,8,19,120}; 
	m_mapper.addTargetField("_T0PbABliEd6Nz-Od1HHEZQ",118,"AddressLine4",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(118)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {94,93,8,19}; 
	m_mapper.addTargetField("_T0PbARliEd6Nz-Od1HHEZQ",121,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(121)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {97,96,8,19}; 
	m_mapper.addTargetField("_T0PbAhliEd6Nz-Od1HHEZQ",122,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(122)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8,19,100,99}; 
	m_mapper.addTargetField("_T0PbAxliEd6Nz-Od1HHEZQ",123,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(123)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8,19,103,102}; 
	m_mapper.addTargetField("_T0PbBBliEd6Nz-Od1HHEZQ",124,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(124)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {100,99,8,19}; 
	m_mapper.addTargetField("_T0PbBhliEd6Nz-Od1HHEZQ",125,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(125)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {106,19,8,107}; 
	m_mapper.addTargetField("_T0PbBxliEd6Nz-Od1HHEZQ",126,"District",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(126)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
	m_mapper.makeParentTheCurrentRecord(); // EndUserShipToInformation 
	
	m_mapper.addTargetRecord("1716482",127,"ShipmentInformation",null,0,1); // ShipmentInformation 
	
	{ 
	int[] sourceFieldIDs = {129}; 
	m_mapper.addTargetField("_w6V_wKCoEeOHYeBUlmWNPA",128,"FulfillmentPartnerId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(128)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // ShipmentInformation 
	
	m_mapper.addTargetRecord("1716465",130,"DeliveryInformation",null,0,1); // DeliveryInformation 
	
	{ 
	int[] sourceFieldIDs = {132,8,133}; 
	m_mapper.addTargetField("1716711",131,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(131)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {135}; 
	m_mapper.addTargetField("1716713",134,"CarrierId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(134)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	{ 
	int[] sourceFieldIDs = {137}; 
	m_mapper.addTargetField("_7XlwoGEAEeOSzauxJkR34A",136,"FreightFowarderIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {139,140,141,142,8,143,144,145,146}; 
	m_mapper.addTargetField("1716719",138,"DeliveryInstruction",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(138)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {148,149}; 
	m_mapper.addTargetField("1716721",147,"DeliveryInstructionExtended",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(147)); 
	} 
	
	m_mapper.addTargetRecord("_34lTIGEAEeOSzauxJkR34A",150,"InstallationPartnerInformation",null,0,1); // InstallationPartnerInformation 
	
	{ 
	int[] sourceFieldIDs = {152}; 
	m_mapper.addTargetField("_34lTI2EAEeOSzauxJkR34A",151,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	m_mapper.addTargetRecord("_34lTImEAEeOSzauxJkR34A",153,"PhysicalAddress",null,0,1); // PhysicalAddress 
	
	{ 
	int[] sourceFieldIDs = {155}; 
	m_mapper.addTargetField("_34lTK2EAEeOSzauxJkR34A",154,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {157}; 
	m_mapper.addTargetField("_34lTLWEAEeOSzauxJkR34A",156,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {159}; 
	m_mapper.addTargetField("_34lTLmEAEeOSzauxJkR34A",158,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {161}; 
	m_mapper.addTargetField("_34lTMWEAEeOSzauxJkR34A",160,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {163}; 
	m_mapper.addTargetField("_34lTMmEAEeOSzauxJkR34A",162,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {165}; 
	m_mapper.addTargetField("_34lTM2EAEeOSzauxJkR34A",164,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {167}; 
	m_mapper.addTargetField("_34lTNGEAEeOSzauxJkR34A",166,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {165}; 
	m_mapper.addTargetField("_34lTNmEAEeOSzauxJkR34A",168,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
	m_mapper.makeParentTheCurrentRecord(); // InstallationPartnerInformation 
	m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
	m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 
	
	m_mapper.addTargetRecord("1716472",169,"PaymentInformation",null,0,1); // PaymentInformation 
	createTargetStructure2(); 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTargetStructure2() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	{ 
	int[] sourceFieldIDs = {171}; 
	m_mapper.addTargetField("1716838",170,"PaymentMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {173}; 
	m_mapper.addTargetField("6544890",172,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {177}; 
	m_mapper.addTargetField("_HdsckEJREeOm9_rBwVbvMQ",176,"CreditCardHolderName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {179}; 
	m_mapper.addTargetField("_T2pB8NLeEd6WyuKq4iZSZQ",178,"CreditCardNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {181,182}; 
	m_mapper.addTargetField("1716842",180,"CardExpirationDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(180)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // PaymentInformation 
	m_mapper.makeParentTheCurrentRecord(); // Header 
	
	int[][] loopAssociatedSourceIDs183 = {{10,33}}; 
	
	m_mapper.addTargetRecord("1716474",183,"Detail",null,0,UNLIMITED,loopAssociatedSourceIDs183); // Detail 
	
	{ 
	int[] sourceFieldIDs = {185}; 
	m_mapper.addTargetField("1716861",184,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {32,187}; 
	m_mapper.addTargetField("6491337",186,"BusinessOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(186)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {189}; 
	m_mapper.addTargetField("1716872",188,"ServiceLevel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(188)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {63}; 
	m_mapper.addTargetField("1716874",190,"CustomerOrderFullfillmentlPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {192,193}; 
	m_mapper.addTargetField("1716880",191,"LineComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(191)); 
	} 
	
	m_mapper.addTargetRecord("1716461",194,"BaseItemDetail",null,1,1); // BaseItemDetail 
	
	{ 
	int[] sourceFieldIDs = {196}; 
	m_mapper.addTargetField("1716663",195,"LexmarkPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {198}; 
	m_mapper.addTargetField("1716665",197,"BuyerLineItemNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {200}; 
	m_mapper.addTargetField("1716667",199,"ParentItemNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {202}; 
	m_mapper.addTargetField("1716669",201,"CustomerPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {204}; 
	m_mapper.addTargetField("_OiBWYI29EeO4M7g7o-4nrw",203,"VendorPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {187}; 
	m_mapper.addTargetField("5830661",205,"ReturnedItemIndicator",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {207}; 
	m_mapper.addTargetField("_r_8EoDXXEd6xVIY_OIneBg",206,"MerchandiseTypeCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {209}; 
	m_mapper.addTargetField("_TAWKoGEBEeOSzauxJkR34A",208,"ConfigurationItemNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {211}; 
	m_mapper.addTargetField("_TAWKoWEBEeOSzauxJkR34A",210,"ConfigurationItemName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // BaseItemDetail 
	
	m_mapper.addTargetRecord("_yAeEEFrAEd6fbbk7F5PhuA",212,"SerialNumbers",null,0,UNLIMITED); // SerialNumbers 
	
	{ 
	int[] sourceFieldIDs = {214}; 
	m_mapper.addTargetField("_zQgIkFrAEd6fbbk7F5PhuA",213,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {216}; 
	m_mapper.addTargetField("_0AvSsFrAEd6fbbk7F5PhuA",215,"RIDTagNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // SerialNumbers 
	
	m_mapper.addTargetRecord("1716442",217,"OrderQuantities",null,1,1); // OrderQuantities 
	
	m_mapper.addTargetRecord("1716452",218,"OrderedQuantity",null,0,1); // OrderedQuantity 
	
	{ 
	int[] sourceFieldIDs = {220}; 
	m_mapper.addTargetField("1716548",219,"@unitOfMeasurement",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(219)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	
	{ 
	int[] sourceFieldIDs = {222}; 
	m_mapper.addTargetField("1716550",221,"*body",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	1,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // OrderedQuantity 
	m_mapper.makeParentTheCurrentRecord(); // OrderQuantities 
	
	m_mapper.addTargetRecord("1716454",223,"PricingDetail",null,0,1); // PricingDetail 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716558",224,"UnitPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(224)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {}; 
	m_mapper.addTargetField("1716562",225,"ExtendedPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(225)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // PricingDetail 
	
	m_mapper.addTargetRecord("1716479",226,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 
	
	{ 
	int[] sourceFieldIDs = {44}; 
	m_mapper.addTargetField("1716913",227,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(227)); 
	m_mapper.setRuleCommentOnly(); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 
	
	m_mapper.addTargetRecord("1716458",228,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 
	
	{ 
	int[] sourceFieldIDs = {32,187,230}; 
	m_mapper.addTargetField("_yR7p8LWQEeGd6d-4WvXXGg",229,"VendorName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(229)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {232}; 
	m_mapper.addTargetField("_zVfyEHhwEeOFBINMKD9lAw",231,"VendorContractNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {234}; 
	m_mapper.addTargetField("_zP9_gLWQEeGd6d-4WvXXGg",233,"OrderFulFillmentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	m_mapper.addTargetRecord("1716447",235,"DeliveryInformation",null,0,1); // DeliveryInformation 
	
	{ 
	int[] sourceFieldIDs = {237}; 
	m_mapper.addTargetField("1716502",236,"RequestedDeliveryDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(236)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8,239}; 
	m_mapper.addTargetField("1716511",238,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(238)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {8,241}; 
	m_mapper.addTargetField("1716513",240,"CarrierId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(240)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
	m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 
	
	m_mapper.addTargetRecord("1716477",242,"WarrantyInformation",null,0,1); // WarrantyInformation 
	
	{ 
	int[] sourceFieldIDs = {244}; 
	m_mapper.addTargetField("1716902",243,"WarrantyType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // WarrantyInformation 
	
	m_mapper.addTargetRecord("1716443",245,"RelatedObjectReference",null,0,1); // RelatedObjectReference 
	
	{ 
	int[] sourceFieldIDs = {247}; 
	m_mapper.addTargetField("1716485",246,"SourceReferenceLineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {249}; 
	m_mapper.addTargetField("_LWJC0LzQEeKTXfd_Z2X4Ow",248,"RelatedActivityId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	createTargetStructure3(); 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTargetStructure3() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
	{ 
	
	{ 
	int[] sourceFieldIDs = {144}; 
	m_mapper.addTargetField("_JY9EUMSaEeKDFeNYU6Fxlw",250,"RelatedAssetId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {252}; 
	m_mapper.addTargetField("_w6_zYN9CEeK4lOjDEdGVfg",251,"RelatedContractNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {254,255}; 
	m_mapper.addTargetField("_w6_zYd9CEeK4lOjDEdGVfg",253,"RelatedContractLineNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(253)); 
	} 
	
	{ 
	int[] sourceFieldIDs = {257}; 
	m_mapper.addTargetField("_iIOIsGEBEeOSzauxJkR34A",256,"PrimaryContractItem",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // RelatedObjectReference 
	m_mapper.makeParentTheCurrentRecord(); // Detail 
	
	m_mapper.addTargetRecord("1716451",258,"RelatedObjectReferences",null,0,1); // RelatedObjectReferences 
	
	{ 
	int[] sourceFieldIDs = {260}; 
	m_mapper.addTargetField("1716538",259,"CustomerPurchaseOrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {262}; 
	m_mapper.addTargetField("1716540",261,"CustomerRequisitionNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {264}; 
	m_mapper.addTargetField("1716544",263,"SourceReferenceNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {24}; 
	m_mapper.addTargetField("1716546",265,"SourceReferenceDocumentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,null); 
	} 
	
	{ 
	int[] sourceFieldIDs = {63,19,267}; 
	m_mapper.addTargetField("_ZgNSIDZUEd6xVIY_OIneBg",266,"EndUserShipToNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
	0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
	0,1, // Min, Max occur. 
	sourceFieldIDs,null,null,buildMethodReflection(266)); 
	} 
	m_mapper.makeParentTheCurrentRecord(); // RelatedObjectReferences 
	m_mapper.makeParentTheCurrentRecord(); // SalesOrderRequest 
	} 
	
	
	/*********************************************************************/ 
	private static final void createTemporaryFields() 
	{ 
	} 
	
	
	/*********************************************************************/ 
	private static final Method buildMethodReflection(int targetFieldID) throws NoSuchMethodException, SecurityException 
	{ 
	return LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical.class.getMethod("mappingRule_" + targetFieldID,PARAMETER_TYPES); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## WebMethods should generated a unique ID for this field 
	*/ 
	public static final void mappingRule_3(TTransformControl transformControl) throws Exception 
	{ 
	//# WebMethods should generated a unique ID for this field 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "SalesOrderRequest" to Target 
	*/ 
	public static final void mappingRule_4(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("SalesOrderRequest"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "SIEBEL" to Target 
	*/ 
	public static final void mappingRule_5(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("SIEBEL"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "Order" to Target 
	*/ 
	public static final void mappingRule_6(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("Order"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Consumables Management" 
	Move "Consumable Order" to Target 
	Elseif [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	Move "Hardware Order" to Target 
	else 
	Move "Service Sales Order Request" to Target 
	endIf 
	*/ 
	public static final void mappingRule_7(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(8), "Consumables Management")) 
	{ 
	transformControl.setTarget("Consumable Order"); 
	} 
	else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	transformControl.setTarget("Hardware Order"); 
	} 
	else 
	{ 
	transformControl.setTarget("Service Sales Order Request"); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "New" to Target 
	*/ 
	public static final void mappingRule_15(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("New"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move CurrentDateTime to [tempDate] 
	Call "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [tempDate] "yyyyMMddHHmmss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to [tempDate] with java 
	Call "com.lxk.utils.DateConverter.ContivoDateConverter.timeZoneConverter" [tempDate] "yyyy-MM-dd'T'HH:mm:ss.SSS" "" "GMT" to Target with java 
	*/ 
	public static final void mappingRule_16(TTransformControl transformControl) throws Exception 
	{ 
	String tempDate = ""; 
	tempDate = new String(transformControl.getCurrentDateTime()); 
	String sources [] = {tempDate,"yyyyMMddHHmmss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
	tempDate = Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0); 
	String sources1 [] = {tempDate,"yyyy-MM-dd'T'HH:mm:ss.SSS","","GMT"}; 
	transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","timeZoneConverter",transformControl,sources1,0)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the new field Mohan is adding to the XML as the organization. 
	## Do a BCM lookup to determine if this field should a YES or NO 
	## Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	## 
	## This service uses the BCM tables: 
	## BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	## BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	## 
	## Pass 'Siebel' as the application name parameter 
	## Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	## Leave the businessOrganization and BusinessLocation paramenters blank 
	## 
	## If the output of this service equals US then set this field to YES 
	## Else set this field to NO. 
	## 
	## Do this BCM lookup after calling the map and do not actually 
	## map the input field in the map 
	MOVE "YES" to Target 
	*/ 
	public static final void mappingRule_18(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the new field Mohan is adding to the XML as the organization. 
	//# Do a BCM lookup to determine if this field should a YES or NO 
	//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	//# 
	//# This service uses the BCM tables: 
	//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	//# 
	//# Pass 'Siebel' as the application name parameter 
	//# Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	//# Leave the businessOrganization and BusinessLocation paramenters blank 
	//# 
	//# If the output of this service equals US then set this field to YES 
	//# Else set this field to NO. 
	//# 
	//# Do this BCM lookup after calling the map and do not actually 
	//# map the input field in the map 
	transformControl.setTarget("YES"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Do a BCM lookup to determine if this field should a YES or NO 
	## Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	## 
	## This service uses the BCM tables: 
	## BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	## BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	## 
	## Pass 'Siebel' as the application name parameter 
	## Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	## Leave the businessOrganization and BusinessLocation paramenters blank 
	## 
	## If the output of this service equals EMEA then set this field to YES 
	## Else set this field to NO. 
	## 
	## Do this BCM lookup after calling the map and do not actually map the input field in the map 
	MOVE "NO" to Target 
	*/ 
	public static final void mappingRule_20(TTransformControl transformControl) throws Exception 
	{ 
	//# Do a BCM lookup to determine if this field should a YES or NO 
	//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	//# 
	//# This service uses the BCM tables: 
	//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	//# 
	//# Pass 'Siebel' as the application name parameter 
	//# Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	//# Leave the businessOrganization and BusinessLocation paramenters blank 
	//# 
	//# If the output of this service equals EMEA then set this field to YES 
	//# Else set this field to NO. 
	//# 
	//# Do this BCM lookup after calling the map and do not actually map the input field in the map 
	transformControl.setTarget("NO"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Do a BCM lookup to determine if this field should a YES or NO 
	## Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	## 
	## This service uses the BCM tables: 
	## BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	## BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	## 
	## Pass 'Siebel' as the application name parameter 
	## Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	## Leave the businessOrganization and BusinessLocation paramenters blank 
	## 
	## If the output of this service equals APG then set this field to YES 
	## Else set this field to NO. 
	## 
	## Do this BCM lookup after calling the map and do not actually map the input field in the map 
	MOVE "NO" to Target 
	*/ 
	public static final void mappingRule_21(TTransformControl transformControl) throws Exception 
	{ 
	//# Do a BCM lookup to determine if this field should a YES or NO 
	//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
	//# 
	//# This service uses the BCM tables: 
	//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
	//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
	//# 
	//# Pass 'Siebel' as the application name parameter 
	//# Pass the Siebel field PrimaryOrganization as the applicatonOrganization parameter 
	//# Leave the businessOrganization and BusinessLocation paramenters blank 
	//# 
	//# If the output of this service equals APG then set this field to YES 
	//# Else set this field to NO. 
	//# 
	//# Do this BCM lookup after calling the map and do not actually map the input field in the map 
	transformControl.setTarget("NO"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Will need to be translated to the Enterprise Document standard format. 
	## Siebel will send MM/DD/YYYY HH:mm:ss 
	IF Source Exists 
	CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
	ENDIF 
	*/ 
	public static final void mappingRule_25(TTransformControl transformControl) throws Exception 
	{ 
	//# Will need to be translated to the Enterprise Document standard format. 
	//# Siebel will send MM/DD/YYYY HH:mm:ss 
	if (Compare.exists(transformControl.getSource(26))) 
	{ 
	String sources [] = {transformControl.getSource(26),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
	transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move 0.00 to Target 
	*/ 
	public static final void mappingRule_27(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTargetNumber(0.0); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: REASON_CODE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_28(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: REASON_CODE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:getBusinessLocation in the LXKBCM package 
	## 
	## This service uses the BCM tables: 
	## BCMMGR.BCM_SUPPLIER_BUSNS_LOC_L 
	## 
	## Pass the following Parameters: 
	## APPLICATION NAME: SIEBEL 
	## SUPPLIER NAME: %SourceInventoryLocation2% 
	## 
	## Do this lookup prior to calling the map 
	## This BCM call will return a from and to business location 
	## Map the BUSINESS TARGET LOCATION to the %SourceInventoryLocation2% 
	*/ 
	public static final void mappingRule_31(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:getBusinessLocation in the LXKBCM package 
	//# 
	//# This service uses the BCM tables: 
	//# BCMMGR.BCM_SUPPLIER_BUSNS_LOC_L 
	//# 
	//# Pass the following Parameters: 
	//# APPLICATION NAME: SIEBEL 
	//# SUPPLIER NAME: %SourceInventoryLocation2% 
	//# 
	//# Do this lookup prior to calling the map 
	//# This BCM call will return a from and to business location 
	//# Map the BUSINESS TARGET LOCATION to the %SourceInventoryLocation2% 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: BUSINESS_ORGANIZATION 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup after calling the map 
	*/ 
	public static final void mappingRule_35(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: BUSINESS_ORGANIZATION 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup after calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: CURRENCY_CODE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_43(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: CURRENCY_CODE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## BCM lookup to translate a Siebel value of 'KEY' to a 
	## JDE value of a number. 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: ORDER_FULFILLMENT_PRIORITY 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_56(TTransformControl transformControl) throws Exception 
	{ 
	//# BCM lookup to translate a Siebel value of 'KEY' to a 
	//# JDE value of a number. 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: ORDER_FULFILLMENT_PRIORITY 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	EndIf 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSShipToNumber] to Target 
	Endif 
	
	Elseif [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	EndIf 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSShipToNumber] to Target 
	Endif 
	
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDCSSFlag] Contains "M" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSShipToNumber] to Target 
	Endif 
	
	
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDPrimaryShipToJDENumber] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_59(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(60))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(60), 59, 60)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 59, 61)); 
	} 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 59, 62)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(60))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(60), 59, 60)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 59, 61)); 
	} 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 59, 62)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(63), "M")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 59, 61)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 59, 62)); 
	} 
	} 
	else if (Compare.exists(transformControl.getSource(60))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(60), 59, 60)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 59, 61)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDFunctionalClassification] = "DFM" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Contains [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_64(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 64, 69)); 
	} 
	else if (Compare.equals(transformControl.getSource(68), "DFM")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 64, 65)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 64, 71)); 
	} 
	else if (Compare.contains(transformControl.getSource(66), transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 64, 65)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 64, 66)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSRArea] = "HW Order" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ContactWorkPhone] to Target 
	endif 
	Else 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ContactWorkPhone] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ContactWorkPhone] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCSRContactPhoneNum] to Target 
	endif 
	endif 
	*/ 
	public static final void mappingRule_74(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(77), "HW Order")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 74, 76)); 
	} 
	} 
	else 
	{ 
	if (Compare.exists(transformControl.getSource(76))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 74, 76)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(75), 74, 75)); 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	#If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] Missing 
	# Move PrimaryShipToFirstName to [LTF_ShipToFullName] 
	# Append " " to [LTF_ShipToFullName] 
	# Append PrimaryShipToLastName to [LTF_ShipToFullName] 
	# Move [LTF_ShipToFullName] to Target 
	#EndIf 
	
	#Check if below logic works wonder for the issue 4950 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSStoreFrontName] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSStoreFrontName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Service - Admin Only" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_79(TTransformControl transformControl) throws Exception 
	{ 
	//If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] Missing 
	// Move PrimaryShipToFirstName to [LTF_ShipToFullName] 
	// Append " " to [LTF_ShipToFullName] 
	// Append PrimaryShipToLastName to [LTF_ShipToFullName] 
	// Move [LTF_ShipToFullName] to Target 
	//EndIf 
	//Check if below logic works wonder for the issue 4950 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 79, 69)); 
	} 
	else if (Compare.exists(transformControl.getSource(82))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(82), 79, 82)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 79, 71)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Service - Admin Only")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 79, 71)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 79, 65)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Consumables Management" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAttentionTo] to Target 
	Elseif [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSRArea] = "HW Order" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAttentionTo] to Target 
	endif 
	endIf 
	*/ 
	public static final void mappingRule_83(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(8), "Consumables Management")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 83, 84)); 
	} 
	else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(77), "HW Order")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 83, 71)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 83, 84)); 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_85(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(70), 85, 70)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 85, 67)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCPrimaryShipToAddress2] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_86(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(88))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(88), 86, 88)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 86, 87)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Map phone number to the phone number field 
	## Then, concatenate this on the JDE side of the map. 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress3] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress3] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCPrimaryShipToAddress3] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_89(TTransformControl transformControl) throws Exception 
	{ 
	//# Map phone number to the phone number field 
	//# Then, concatenate this on the JDE side of the map. 
	if (Compare.exists(transformControl.getSource(91))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(91), 89, 91)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 89, 90)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToPostalCode] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_92(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(94))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(94), 92, 94)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 92, 93)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCity] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_95(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(97))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(97), 95, 97)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 95, 96)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	*/ 
	public static final void mappingRule_98(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 98, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 98, 99)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCountryCode] to Target 
	
	Endif 
	*/ 
	public static final void mappingRule_101(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(102))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 101, 102)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 101, 103)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	*/ 
	public static final void mappingRule_104(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 104, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 104, 99)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDistrict] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_105(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(107))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(107), 105, 107)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(106), 105, 106)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move "DFMFD" to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	EndIf 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move "DFMFD" to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToJDENumber] to Target 
	EndIf 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDCSSFlag] Contains "M" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSShipToNumber] to Target 
	Endif 
	endif 
	*/ 
	public static final void mappingRule_109(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget("DFMFD"); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 109, 61)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget("DFMFD"); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 109, 61)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(63), "M")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 109, 62)); 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDFunctionalClassification] = "DFM" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Contains [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] to Target 
	EndIf 
	endif 
	
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDFunctionalClassification] = "DFM" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Contains [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] to Target 
	EndIf 
	endif 
	endif 
	*/ 
	public static final void mappingRule_110(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 110, 69)); 
	} 
	else if (Compare.equals(transformControl.getSource(68), "DFM")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 110, 65)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 110, 71)); 
	} 
	else if (Compare.contains(transformControl.getSource(66), transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 110, 65)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 110, 66)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 110, 69)); 
	} 
	else if (Compare.equals(transformControl.getSource(68), "DFM")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 110, 65)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 110, 71)); 
	} 
	else if (Compare.contains(transformControl.getSource(66), transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 110, 65)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 110, 66)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	Endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	Endif 
	EndIf 
	*/ 
	public static final void mappingRule_112(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 112, 71)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 112, 71)); 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCSRContactPhoneNum] to Target 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCSRContactPhoneNum] to Target 
	endif 
	endif 
	*/ 
	public static final void mappingRule_113(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(75), 113, 75)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(75), 113, 75)); 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDFunctionalClassification] = "DFM" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Service - Admin Only" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Contains [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] Missing 
	Move PrimaryShipToFirstName to [LTF_ShipToFullName] 
	Append " " to [LTF_ShipToFullName] 
	Append PrimaryShipToLastName to [LTF_ShipToFullName] 
	Move [LTF_ShipToFullName] to Target 
	EndIf 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDFunctionalClassification] = "DFM" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Customer" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCAccountServiceClassification] = "Generic Service - Admin Only" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCContactFullName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Contains [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Account] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDShipToAddressName] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] Missing 
	Move PrimaryShipToFirstName to [LTF_ShipToFullName] 
	Append " " to [LTF_ShipToFullName] 
	Append PrimaryShipToLastName to [LTF_ShipToFullName] 
	Move [LTF_ShipToFullName] to Target 
	EndIf 
	endif 
	endif 
	*/ 
	public static final void mappingRule_115(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 115, 69)); 
	} 
	else if (Compare.equals(transformControl.getSource(68), "DFM")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 115, 65)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 115, 71)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Service - Admin Only")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 115, 71)); 
	} 
	else if (Compare.contains(transformControl.getSource(66), transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 115, 65)); 
	} 
	else if (Compare.exists(transformControl.getSource(66))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 115, 66)); 
	} 
	else if (Compare.missing(transformControl.getSource(69))) 
	{ 
	String LTF_ShipToFullName = ""; 
	LTF_ShipToFullName = new String(transformControl.getSource(80)); 
	LTF_ShipToFullName = LTF_ShipToFullName.concat(" "); 
	LTF_ShipToFullName = LTF_ShipToFullName.concat(transformControl.getSource(81)); 
	transformControl.setTarget(new String(LTF_ShipToFullName)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(69), 115, 69)); 
	} 
	else if (Compare.equals(transformControl.getSource(68), "DFM")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 115, 65)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Customer")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 115, 71)); 
	} 
	else if (Compare.equals(transformControl.getSource(57), "Generic Service - Admin Only")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 115, 71)); 
	} 
	else if (Compare.contains(transformControl.getSource(66), transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 115, 65)); 
	} 
	else if (Compare.exists(transformControl.getSource(66))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 115, 66)); 
	} 
	else if (Compare.missing(transformControl.getSource(69))) 
	{ 
	String LTF_ShipToFullName = ""; 
	LTF_ShipToFullName = new String(transformControl.getSource(80)); 
	LTF_ShipToFullName = LTF_ShipToFullName.concat(" "); 
	LTF_ShipToFullName = LTF_ShipToFullName.concat(transformControl.getSource(81)); 
	transformControl.setTarget(new String(LTF_ShipToFullName)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] to Target 
	Else 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] to Target 
	EndIf 
	endif 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderPrimaryShipToAddress] to Target 
	Else 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToAddress] to Target 
	EndIf 
	endif 
	endif 
	endif 
	*/ 
	public static final void mappingRule_116(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(70), 116, 70)); 
	} 
	else 
	{ 
	if (Compare.exists(transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 116, 67)); 
	} 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(70))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(70), 116, 70)); 
	} 
	else 
	{ 
	if (Compare.exists(transformControl.getSource(67))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 116, 67)); 
	} 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCPrimaryShipToAddress2] to Target 
	EndIf 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToAddress2] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCPrimaryShipToAddress2] to Target 
	EndIf 
	endif 
	endif 
	*/ 
	public static final void mappingRule_117(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(88))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(88), 117, 88)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 117, 87)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(88))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(88), 117, 88)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 117, 87)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSHouseNo] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSHouseNo] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPHouseNo] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPHouseNo] to Target 
	endif 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSHouseNo] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSHouseNo] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPHouseNo] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPHouseNo] to Target 
	endif 
	endif 
	endif 
	*/ 
	public static final void mappingRule_118(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(119))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(119), 118, 119)); 
	} 
	else if (Compare.exists(transformControl.getSource(120))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(120), 118, 120)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(119))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(119), 118, 119)); 
	} 
	else if (Compare.exists(transformControl.getSource(120))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(120), 118, 120)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToPostalCode] to Target 
	EndIf 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToPostalCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToPostalCode] to Target 
	EndIf 
	endif 
	endif 
	*/ 
	public static final void mappingRule_121(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(94))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(94), 121, 94)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 121, 93)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(94))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(94), 121, 94)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 121, 93)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCity] to Target 
	EndIf 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCity] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCity] to Target 
	EndIf 
	endif 
	endif 
	*/ 
	public static final void mappingRule_122(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(97))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(97), 122, 97)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 122, 96)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(97))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(97), 122, 97)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 122, 96)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	ELSEIF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	ENDIF 
	ENDIF 
	ENDIF 
	*/ 
	public static final void mappingRule_123(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 123, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 123, 99)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 123, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 123, 99)); 
	} 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCountryCode] to Target 
	Endif 
	endif 
	
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToCountryCode] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToCountryCode] to Target 
	Endif 
	endif 
	endif 
	*/ 
	public static final void mappingRule_124(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(102))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 124, 102)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 124, 103)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(102))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 124, 102)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 124, 103)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumables" 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	ELSEIF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	IF [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPPrimaryShipToRegion] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryShipToRegion] to Target 
	Endif 
	ENDIF 
	ENDIF 
	ENDIF 
	*/ 
	public static final void mappingRule_125(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumables")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 125, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 125, 99)); 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(100))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(100), 125, 100)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 125, 99)); 
	} 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDistrict] to Target 
	endif 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSPDistrict] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDistrict] to Target 
	endif 
	endif 
	endif 
	*/ 
	public static final void mappingRule_126(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(107))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(107), 126, 107)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(106), 126, 106)); 
	} 
	} 
	} 
	else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(107))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(107), 126, 107)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(106), 126, 106)); 
	} 
	} 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	IF Source Exists 
	MOVE Source to Target 
	ENDIF 
	*/ 
	public static final void mappingRule_128(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(129))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(129), 128, 129)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## This field is mapped for EMEA. US does not need it at the header level. 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSWhiteGloveFlag] = "Y" 
	Move "WhiteGlove" to Target 
	else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|CarrierPriority] to Target 
	endif 
	else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|CarrierPriority] to Target 
	endif 
	*/ 
	public static final void mappingRule_131(TTransformControl transformControl) throws Exception 
	{ 
	//# This field is mapped for EMEA. US does not need it at the header level. 
	if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.equals(transformControl.getSource(133), "Y")) 
	{ 
	transformControl.setTarget("WhiteGlove"); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(132), 131, 132)); 
	} 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(132), 131, 132)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Need a BCM lookup to translate a Siebel Alpha code 
	## to a JDE address book number 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: CARRIER_CODE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_134(TTransformControl transformControl) throws Exception 
	{ 
	//# Need a BCM lookup to translate a Siebel Alpha code 
	//# to a JDE address book number 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: CARRIER_CODE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPReferenceNo] Exists 
	Move "" to [tmp_Instructions] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSPReferenceNo] to [tmp_Instructions] 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDOwnerTechnician] Exists 
	Append " " to [tmp_Instructions] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDOwnerTechnician] to [tmp_Instructions] 
	EndIf 
	
	Move [tmp_Instructions] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDOwnerTechnician] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDOwnerTechnician] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Consumables Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] to [temp] 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] to [temp] 
	endif 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	endif 
	Move [temp] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] to [temp] 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	Endif 
	Move [temp] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	Move [temp] to Target 
	endif 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] to [temp] 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] to [temp] 
	endif 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	endif 
	Move [temp] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSAssetIdentifier] to [temp] 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Append "," to [temp] 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	Endif 
	Move [temp] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSDeliveryInstruc] to [temp] 
	Move [temp] to Target 
	endif 
	
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSInsideLocation] to [temp] 
	Append " " to [temp] 
	Append ContactFirstName to [temp] 
	Append " " to [temp] 
	Append ContactLastName to [temp] 
	Move [temp] to target 
	
	Else 
	Move ContactFirstName to [LTF_ContactFullName] 
	Append " " to [LTF_ContactFullName] 
	Append ContactLastName to [LTF_ContactFullName] 
	Move [LTF_ContactFullName] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_138(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(141))) 
	{ 
	String tmp_Instructions = ""; 
	tmp_Instructions = ""; 
	tmp_Instructions = new String(transformControl.getSource(141)); 
	if (Compare.exists(transformControl.getSource(142))) 
	{ 
	tmp_Instructions = tmp_Instructions.concat(" "); 
	tmp_Instructions = tmp_Instructions.concat(transformControl.getSource(142)); 
	} 
	transformControl.setTarget(new String(tmp_Instructions)); 
	} 
	else if (Compare.exists(transformControl.getSource(142))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(142), 138, 142)); 
	} 
	else if (Compare.equals(transformControl.getSource(8), "Consumables Management")) 
	{ 
	if (Compare.exists(transformControl.getSource(145))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(145)); 
	if (Compare.exists(transformControl.getSource(144))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(144)); 
	} 
	if (Compare.exists(transformControl.getSource(146))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(146)); 
	} 
	transformControl.setTarget(new String(temp)); 
	} 
	else if (Compare.exists(transformControl.getSource(144))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(144)); 
	if (Compare.exists(transformControl.getSource(146))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(146)); 
	} 
	transformControl.setTarget(new String(temp)); 
	} 
	else if (Compare.exists(transformControl.getSource(146))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(146)); 
	transformControl.setTarget(new String(temp)); 
	} 
	} 
	else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	if (Compare.exists(transformControl.getSource(145))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(145)); 
	if (Compare.exists(transformControl.getSource(144))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(144)); 
	} 
	if (Compare.exists(transformControl.getSource(146))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(146)); 
	} 
	transformControl.setTarget(new String(temp)); 
	} 
	else if (Compare.exists(transformControl.getSource(144))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(144)); 
	if (Compare.exists(transformControl.getSource(146))) 
	{ 
	temp = temp.concat(","); 
	temp = temp.concat(transformControl.getSource(146)); 
	} 
	transformControl.setTarget(new String(temp)); 
	} 
	else if (Compare.exists(transformControl.getSource(146))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(146)); 
	transformControl.setTarget(new String(temp)); 
	} 
	} 
	else if (Compare.exists(transformControl.getSource(145))) 
	{ 
	String temp = ""; 
	temp = new String(transformControl.getSource(145)); 
	temp = temp.concat(" "); 
	temp = temp.concat(transformControl.getSource(140)); 
	temp = temp.concat(" "); 
	temp = temp.concat(transformControl.getSource(139)); 
	transformControl.setTarget(new String(temp)); 
	} 
	else 
	{ 
	String LTF_ContactFullName = ""; 
	LTF_ContactFullName = new String(transformControl.getSource(140)); 
	LTF_ContactFullName = LTF_ContactFullName.concat(" "); 
	LTF_ContactFullName = LTF_ContactFullName.concat(transformControl.getSource(139)); 
	transformControl.setTarget(new String(LTF_ContactFullName)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXK3PLReturnLabel] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXK3PLReturnLabel] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDLexmarkPaysPartsReturn] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_147(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(149))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(149), 147, 149)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(148), 147, 148)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfLXKMPSSRPayments|ListOfLxkMpsSrPayments|ExpirationMonth] to [temp_Month] 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfLXKMPSSRPayments|ListOfLxkMpsSrPayments|ExpirationYear] to [temp_Year] 
	Append [temp_Month] to [temp_Year] 
	Move [temp_Year] to Target 
	*/ 
	public static final void mappingRule_180(TTransformControl transformControl) throws Exception 
	{ 
	String temp_Month = ""; 
	temp_Month = new String(transformControl.getSource(181)); 
	String temp_Year = ""; 
	temp_Year = new String(transformControl.getSource(182)); 
	temp_Year = temp_Year.concat(temp_Month); 
	transformControl.setTarget(new String(temp_Year)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:getBusinessLocation in the LXKBCM package 
	## 
	## This service uses the BCM tables: 
	## BCMMGR.BCM_SUPPLIER_BUSNS_LOC_L 
	## 
	## Pass the following Parameters: 
	## APPLICATION NAME: SIEBEL 
	## SUPPLIER NAME: %SourceInventoryLocation2% 
	## 
	## Do this lookup prior to calling the map 
	## This BCM call will return a from and to business location 
	
	## If LXKRLineType is RMA then 
	## Map the BUSINESS SOURCE LOCATION to the %SourceInventoryLocation2% 
	## If LXKRLineType is Ship then 
	## Map the BUSINESS TARGET LOCATION to the %SourceInventoryLocation2% 
	
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|SourceInventoryLocation2] to Target 
	*/ 
	public static final void mappingRule_186(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:getBusinessLocation in the LXKBCM package 
	//# 
	//# This service uses the BCM tables: 
	//# BCMMGR.BCM_SUPPLIER_BUSNS_LOC_L 
	//# 
	//# Pass the following Parameters: 
	//# APPLICATION NAME: SIEBEL 
	//# SUPPLIER NAME: %SourceInventoryLocation2% 
	//# 
	//# Do this lookup prior to calling the map 
	//# This BCM call will return a from and to business location 
	//# If LXKRLineType is RMA then 
	//# Map the BUSINESS SOURCE LOCATION to the %SourceInventoryLocation2% 
	//# If LXKRLineType is Ship then 
	//# Map the BUSINESS TARGET LOCATION to the %SourceInventoryLocation2% 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 186, 32)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	MOVE Source to Target 
	*/ 
	public static final void mappingRule_188(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(189), 188, 189)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "" to [tmpComments] 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Comments] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|Comments] to [tmpComments] 
	Append " " to [tmpComments] 
	EndIf 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDWarningMessageDispatch] Exists 
	Append [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDWarningMessageDispatch] to [tmpComments] 
	EndIf 
	
	Move [tmpComments] to Target 
	*/ 
	public static final void mappingRule_191(TTransformControl transformControl) throws Exception 
	{ 
	String tmpComments = ""; 
	tmpComments = ""; 
	if (Compare.exists(transformControl.getSource(192))) 
	{ 
	tmpComments = new String(transformControl.getSource(192)); 
	tmpComments = tmpComments.concat(" "); 
	} 
	if (Compare.exists(transformControl.getSource(193))) 
	{ 
	tmpComments = tmpComments.concat(transformControl.getSource(193)); 
	} 
	transformControl.setTarget(new String(tmpComments)); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: UNIT_OF_MEASURE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_219(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: UNIT_OF_MEASURE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "0.00" to Target 
	*/ 
	public static final void mappingRule_224(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("0.00"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	Move "0.00" to Target 
	*/ 
	public static final void mappingRule_225(TTransformControl transformControl) throws Exception 
	{ 
	transformControl.setTarget("0.00"); 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: CURRENCY_CODE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	*/ 
	public static final void mappingRule_227(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: CURRENCY_CODE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|LXKRLineType] = "Ship" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|SourceInventoryLocation2] to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|LXKRLineType] = "RMA" 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|DestinationInventoryLocation2] to Target 
	else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|SourceInventoryLocation2] to Target 
	endif 
	*/ 
	public static final void mappingRule_229(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.equals(transformControl.getSource(187), "Ship")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 229, 32)); 
	} 
	else if (Compare.equals(transformControl.getSource(187), "RMA")) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(230), 229, 230)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 229, 32)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	IF Source Exists 
	CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
	ENDIF 
	*/ 
	public static final void mappingRule_236(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(237))) 
	{ 
	String sources [] = {transformControl.getSource(237),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
	transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: SHIPMENT_METHOD 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	Move Empty_String to Target 
	else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|ShipMethod] to Target 
	endif 
	*/ 
	public static final void mappingRule_238(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: SHIPMENT_METHOD 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	transformControl.setTargetEmpty(); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(239), 238, 239)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	## 
	## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	## 
	## Pass the following Parameters: 
	## CATEGORY: UNIVERSAL 
	## FIELD TYPE CODE: CARRIER_CODE 
	## APPLICATION VALUE: Field mapped to this field 
	## APPLICATION NAME: SIEBEL 
	## GEOGRAPHY CODE: WW 
	## UNIVERSAL CODE: leave blank 
	## 
	## Do this lookup prior to calling the map 
	
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] Contains "Consumable" 
	Move Empty_String to Target 
	ElseIf [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
	Move Empty_String to Target 
	else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|CarrierCode] to Target 
	endif 
	*/ 
	public static final void mappingRule_240(TTransformControl transformControl) throws Exception 
	{ 
	//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
	//# 
	//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
	//# 
	//# Pass the following Parameters: 
	//# CATEGORY: UNIVERSAL 
	//# FIELD TYPE CODE: CARRIER_CODE 
	//# APPLICATION VALUE: Field mapped to this field 
	//# APPLICATION NAME: SIEBEL 
	//# GEOGRAPHY CODE: WW 
	//# UNIVERSAL CODE: leave blank 
	//# 
	//# Do this lookup prior to calling the map 
	if (Compare.contains(transformControl.getSource(8), "Consumable")) 
	{ 
	transformControl.setTargetEmpty(); 
	} 
	else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
	{ 
	transformControl.setTargetEmpty(); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(241), 240, 241)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|LXKMPSParentSAPLine] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|LXKMPSParentSAPLine] to Target 
	Else 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfOrderEntry-LineItems|OrderEntry-LineItems|LXKMPSHWConfigId] to Target 
	EndIf 
	*/ 
	public static final void mappingRule_253(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.exists(transformControl.getSource(255))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(255), 253, 255)); 
	} 
	else 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(254), 253, 254)); 
	} 
	} 
	
	
	/*********************************************************************/ 
	/* 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDCSSFlag] Contains "M" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|PrimaryOrganization] = "Lexmark - Brazil" 
	If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSPLID] Exists 
	Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSPLID] to Target 
	Endif 
	Endif 
	EndIf 
	*/ 
	public static final void mappingRule_266(TTransformControl transformControl) throws Exception 
	{ 
	if (Compare.contains(transformControl.getSource(63), "M")) 
	{ 
	if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
	{ 
	if (Compare.exists(transformControl.getSource(267))) 
	{ 
	transformControl.setTarget(transformControl.convert(transformControl.getSource(267), 266, 267)); 
	} 
	} 
	} 
	} 
	
	private static final String[] restTable0() 
	{ 
	return new String[] { 
	"New", "Change", "Delete"}; 
	} 
	
	private static final String[] restTable1() 
	{ 
	return new String[] { 
	"NO", "YES"}; 
	} 
	
	private static final String[] restTable2() 
	{ 
	return new String[] { 
	"NO", "YES"}; 
	} 
	
	private static final String[] restTable3() 
	{ 
	return new String[] { 
	"NO", "YES"}; 
	} 
	static { 
	buildTables(); 
	} 
	
	/*********************************************************************/ 
	private static final void buildTables() 
	{ 
	m_mapper.setTableValues(0, restTable0()); 
	m_mapper.setTableValues(1, restTable1()); 
	m_mapper.setTableValues(2, restTable2()); 
	m_mapper.setTableValues(3, restTable3()); 
	} 
	
	
	/*********************************************************************/ 
	private static final void buildTargetNamespaceTable() 
	{ 
	} 
	
	
	
		
	// --- <<IS-END-SHARED>> ---
}

