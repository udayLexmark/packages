/*************************************************************************************************** 
Copyright (c) 2001 Contivo, Inc. All Rights Reserved. 

This software is the confidential and proprietary information of Contivo, Inc. 
You shall not disclose such Confidential Information and shall use it only in accordance with the terms 
of the Non-Disclosure Agreement, Consultant Agreement, License Agreement, any other written, and/or any 
other oral agreement you entered into with Contivo, Inc. 

CONTIVO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE 
SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES 
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CONTIVO 
SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING 
THIS SOFTWARE OR ITS DERIVATIVES. 
***************************************************************************************************/ 

/* 
Class: LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical 
Date: 2014-10-26-05:00 
Author: Contivo Analyst Transform Writer Version 3.11.2.1.8 
Purpose: This service unit provides data transformation for the mapping matrix "LXK_Siebel_CPDServiceOrder_v1.0_to_LXK_SalesOrderRequest_v1.0_Canonical.cbm". 
*/ 

package LXKCPDSalesOrderRequestFromSiebel.Maps;




// --- <<B2B-START-IMPORTS>> --- 
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
// --- <<B2B-END-IMPORTS>> --- 



public final class LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical 
{ 


// --- <<B2B-START-SHARED>> --- 

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
m_mapper = new TMapper(LXK_Siebel_CPDServiceOrder_v10_to_LXK_SalesOrderRequest_v10_Canonical.class,TRANSFORM_NAME,"transform",259); 
m_mapper.setTimeStamp("2014-10-26 09:20:01 EDT"); 
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

m_mapper.addSourceRecord("_iA7kYZIWEeOnO6apKYSctA",11,"SiebelMessage",null,1,1); // SiebelMessage 
m_mapper.setXMLInputProcessing(true); 
{ 
m_mapper.addSourceField("_iA7kYpIWEeOnO6apKYSctA",14,"@MessageId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_iA8ygJIWEeOnO6apKYSctA",10,"ListOfLxkCOrderEntry",null,0,UNLIMITED); // ListOfLxkCOrderEntry 

m_mapper.addSourceRecord("_iA8ygZIWEeOnO6apKYSctA",9,"OrderEntry-Orders",null,0,UNLIMITED); // OrderEntry-Orders 

{ 
m_mapper.addSourceField("_iA8yhJIWEeOnO6apKYSctA",8,"LXKSDSRType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yhpIWEeOnO6apKYSctA",129,"LXKMPSWhiteGloveFlag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yh5IWEeOnO6apKYSctA",78,"LXKMPSStoreFrontName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yiJIWEeOnO6apKYSctA",125,"LXKMPSSpecialPartner",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yiZIWEeOnO6apKYSctA",43,"LXKMPSSoldTo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yi5IWEeOnO6apKYSctA",116,"LXKMPSSPHouseNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yjJIWEeOnO6apKYSctA",103,"LXKMPSSPDistrict",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA8yjpIWEeOnO6apKYSctA",115,"LXKMPSHouseNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA9ZkJIWEeOnO6apKYSctA",133,"LXKMPSFF",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA9ZkpIWEeOnO6apKYSctA",102,"LXKMPSDistrict",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA9Zk5IWEeOnO6apKYSctA",142,"LXKMPSDeliveryInstruc",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA9ZlZIWEeOnO6apKYSctA",193,"Id",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA-AopIWEeOnO6apKYSctA",61,"Account",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA_OyZIWEeOnO6apKYSctA",128,"CarrierPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA_OypIWEeOnO6apKYSctA",131,"CarrierType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA_OzJIWEeOnO6apKYSctA",187,"Comments",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA_OzZIWEeOnO6apKYSctA",136,"ContactFirstName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iA_10ZIWEeOnO6apKYSctA",135,"ContactLastName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBAc4JIWEeOnO6apKYSctA",72,"ContactWorkPhone",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBAc4ZIWEeOnO6apKYSctA",37,"CreatedByName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBBD_ZIWEeOnO6apKYSctA",40,"CurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBBrE5IWEeOnO6apKYSctA",53,"LXKCAccountServiceClassification",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBCSEZIWEeOnO6apKYSctA",67,"LXKCContactFullName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBCSE5IWEeOnO6apKYSctA",71,"LXKCSRContactPhoneNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBCSGJIWEeOnO6apKYSctA",83,"LXKCPrimaryShipToAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBCSGZIWEeOnO6apKYSctA",86,"LXKCPrimaryShipToAddress3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBCSHJIWEeOnO6apKYSctA",184,"LXKCServiceOverrideType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBC5KJIWEeOnO6apKYSctA",26,"OrderDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBC5KpIWEeOnO6apKYSctA",257,"OrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBC5LZIWEeOnO6apKYSctA",24,"OrderType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBEHU5IWEeOnO6apKYSctA",137,"LXKSDSPReferenceNo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBEHVZIWEeOnO6apKYSctA",138,"LXKSDOwnerTechnician",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVZJIWEeOnO6apKYSctA",19,"PrimaryOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVbpIWEeOnO6apKYSctA",63,"PrimaryShipToAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVcJIWEeOnO6apKYSctA",92,"PrimaryShipToCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVc5IWEeOnO6apKYSctA",76,"PrimaryShipToFirstName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVdJIWEeOnO6apKYSctA",77,"PrimaryShipToLastName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBFVdZIWEeOnO6apKYSctA",89,"PrimaryShipToPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBGjiZIWEeOnO6apKYSctA",230,"RequestedShipDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBGjjJIWEeOnO6apKYSctA",29,"ReturnReason",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBHxr5IWEeOnO6apKYSctA",255,"ServiceRequestNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_wpIWEeOnO6apKYSctA",56,"LXKSDPrimaryShipToJDENumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_w5IWEeOnO6apKYSctA",237,"LXKSDEntitlementType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_xJIWEeOnO6apKYSctA",59,"LXKSDCSSFlag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_yZIWEeOnO6apKYSctA",195,"LXKSDServiceProductName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_ypIWEeOnO6apKYSctA",200,"LXKSDServiceProductBusinessArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
m_mapper.addSourceField("_iBI_y5IWEeOnO6apKYSctA",66,"LXKSDServiceProviderPrimaryShipToAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_zpIWEeOnO6apKYSctA",90,"LXKSDSPPrimaryShipToPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_z5IWEeOnO6apKYSctA",57,"LXKSDSPPrimaryShipToJDENumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_0ZIWEeOnO6apKYSctA",93,"LXKSDSPPrimaryShipToCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_05IWEeOnO6apKYSctA",87,"LXKSDSPPrimaryShipToAddress3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBI_1JIWEeOnO6apKYSctA",84,"LXKSDSPPrimaryShipToAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm0JIWEeOnO6apKYSctA",144,"LXKSDLexmarkPaysPartsReturn",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm0pIWEeOnO6apKYSctA",62,"LXKSDShipToAddressName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm05IWEeOnO6apKYSctA",64,"LXKSDFunctionalClassification",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm1JIWEeOnO6apKYSctA",65,"LXKSDServiceProviderName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm15IWEeOnO6apKYSctA",140,"LXKMPSAssetIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm2JIWEeOnO6apKYSctA",80,"LXKMPSAttentionTo",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm2ZIWEeOnO6apKYSctA",166,"LXKMPSBillingModel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm2pIWEeOnO6apKYSctA",253,"LXKMPSCustomerPONumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm25IWEeOnO6apKYSctA",141,"LXKMPSInsideLocation",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm3ZIWEeOnO6apKYSctA",73,"LXKMPSSRArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm3pIWEeOnO6apKYSctA",58,"LXKMPSShipToNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm4JIWEeOnO6apKYSctA",139,"LXKMPSSpecialHandlingInstructions",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm4ZIWEeOnO6apKYSctA",48,"LXKMPSProject",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBJm4pIWEeOnO6apKYSctA",50,"LXKMPSProjectPhase",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN4JIWEeOnO6apKYSctA",154,"LXKMPSIPAddress2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN4ZIWEeOnO6apKYSctA",150,"LXKMPSIPAddressName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN4pIWEeOnO6apKYSctA",158,"LXKMPSIPCity",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN5ZIWEeOnO6apKYSctA",152,"LXKMPSInstallationPartnerAddress",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN55IWEeOnO6apKYSctA",147,"LXKMPSIPShipToNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN6ZIWEeOnO6apKYSctA",162,"LXKMPSIPCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN6pIWEeOnO6apKYSctA",160,"LXKMPSIPRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN7ZIWEeOnO6apKYSctA",98,"LXKSDSPPrimaryShipToCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN7pIWEeOnO6apKYSctA",96,"LXKSDSPPrimaryShipToRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN8ZIWEeOnO6apKYSctA",99,"PrimaryShipToCountryCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN8pIWEeOnO6apKYSctA",95,"PrimaryShipToRegion",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN85IWEeOnO6apKYSctA",188,"LXKSDWarningMessageDispatch",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBKN9JIWEeOnO6apKYSctA",156,"LXKMPSIPPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_JD5WQBZ0EeS3WNt7Tx7ghg",46,"LXKMPSSRSubArea",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_iBK08JIWEeOnO6apKYSctA",34,"ListOfOrderEntry-LineItems",null,0,1); // ListOfOrderEntry-LineItems 

m_mapper.addSourceRecord("_iBK08ZIWEeOnO6apKYSctA",33,"OrderEntry-LineItems",null,0,UNLIMITED); // OrderEntry-LineItems 

{ 
m_mapper.addSourceField("_iBK09ZIWEeOnO6apKYSctA",197,"LXKMPSVendorPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK09pIWEeOnO6apKYSctA",204,"LXKMPSSolutionPart",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK095IWEeOnO6apKYSctA",202,"LXKMPSSolutionLine",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK0-pIWEeOnO6apKYSctA",248,"LXKMPSParentSAPLine",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK0_5IWEeOnO6apKYSctA",240,"Id",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK1BZIWEeOnO6apKYSctA",247,"LXKMPSHWConfigId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBK1BpIWEeOnO6apKYSctA",245,"LXKMPSSAPContractNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBLcApIWEeOnO6apKYSctA",242,"ActivityId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBLcFpIWEeOnO6apKYSctA",234,"CarrierCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBMDH5IWEeOnO6apKYSctA",223,"DestinationInventoryLocation2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBOfVpIWEeOnO6apKYSctA",182,"LXKRLineType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBPGZpIWEeOnO6apKYSctA",180,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBPtdJIWEeOnO6apKYSctA",191,"Product",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
m_mapper.addSourceField("_iBPtgZIWEeOnO6apKYSctA",215,"QuantityRequested",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBQ7lpIWEeOnO6apKYSctA",207,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBQ7n5IWEeOnO6apKYSctA",232,"ShipMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBRippIWEeOnO6apKYSctA",32,"SourceInventoryLocation2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBRir5IWEeOnO6apKYSctA",213,"UnitofMeasure",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBTX3JIWEeOnO6apKYSctA",209,"LXKSDAssetRIDTag",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBTX3pIWEeOnO6apKYSctA",227,"LXKMPSFullfillmentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBTX35IWEeOnO6apKYSctA",250,"LXKMPSSendtoSAP",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBTX4JIWEeOnO6apKYSctA",225,"LXKMPSVendorNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // OrderEntry-LineItems 
m_mapper.makeParentTheCurrentRecord(); // ListOfOrderEntry-LineItems 

m_mapper.addSourceRecord("_iBTX45IWEeOnO6apKYSctA",170,"ListOfLXKMPSSRPayments",null,0,1); // ListOfLXKMPSSRPayments 

m_mapper.addSourceRecord("_iBTX5JIWEeOnO6apKYSctA",169,"ListOfLxkMpsSrPayments",null,0,UNLIMITED); // ListOfLxkMpsSrPayments 

{ 
m_mapper.addSourceField("_iBTX5ZIWEeOnO6apKYSctA",168,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBT-4ZIWEeOnO6apKYSctA",174,"AuthorizationCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBVNA5IWEeOnO6apKYSctA",172,"CardHolder",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBV0EJIWEeOnO6apKYSctA",176,"ExpirationMonth",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_iBV0EZIWEeOnO6apKYSctA",177,"ExpirationYear",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
m_mapper.makeParentTheCurrentRecord(); // LexmarkOrderInformation 

m_mapper.addTargetRecord("1716446",38,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 

{ 
int[] sourceFieldIDs = {40}; 
m_mapper.addTargetField("1716499",39,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(39)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("_MuDtfB8rEd6Iyv516O0vMA",41,"SoldToInformation",null,0,1); // SoldToInformation 

{ 
int[] sourceFieldIDs = {43}; 
m_mapper.addTargetField("_MuDtfx8rEd6Iyv516O0vMA",42,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // SoldToInformation 

m_mapper.addTargetRecord("_3_Kp8RZzEeS3WNt7Tx7ghg",44,"ProjectInformation",null,0,1); // ProjectInformation 

{ 
int[] sourceFieldIDs = {46}; 
m_mapper.addTargetField("_6LFu8BZzEeS3WNt7Tx7ghg",45,"RequestType",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {48}; 
m_mapper.addTargetField("_7zkIoBZzEeS3WNt7Tx7ghg",47,"ProjectNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {50}; 
m_mapper.addTargetField("__DscoBZzEeS3WNt7Tx7ghg",49,"ProjectPhase",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // ProjectInformation 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716473",51,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

{ 
int[] sourceFieldIDs = {53}; 
m_mapper.addTargetField("1716854",52,"CustomerOrderFullfillmentlPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(52)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("1716466",54,"ShipToInformation",null,0,1); // ShipToInformation 

{ 
int[] sourceFieldIDs = {56,57,8,58,19,59}; 
m_mapper.addTargetField("1716723",55,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(55)); 
} 

{ 
int[] sourceFieldIDs = {61,62,63,64,65,66,53,67}; 
m_mapper.addTargetField("1716725",60,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(60)); 
} 

m_mapper.addTargetRecord("1716459",68,"ContactInformation",null,0,1); // ContactInformation 

{ 
int[] sourceFieldIDs = {67}; 
m_mapper.addTargetField("1716647",69,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {71,72,8,73}; 
m_mapper.addTargetField("1716651",70,"TelephoneNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(70)); 
} 
m_mapper.makeParentTheCurrentRecord(); // ContactInformation 

m_mapper.addTargetRecord("1716467",74,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {76,77,65,61,53,67,63,66,62,64,8,78}; 
m_mapper.addTargetField("1716729",75,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(75)); 
} 

{ 
int[] sourceFieldIDs = {80,8,73,67}; 
m_mapper.addTargetField("1716731",79,"Name2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(79)); 
} 

{ 
int[] sourceFieldIDs = {63,66}; 
m_mapper.addTargetField("1716733",81,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(81)); 
} 

{ 
int[] sourceFieldIDs = {83,84}; 
m_mapper.addTargetField("1716735",82,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(82)); 
} 

{ 
int[] sourceFieldIDs = {86,87}; 
m_mapper.addTargetField("1716737",85,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(85)); 
} 

{ 
int[] sourceFieldIDs = {89,90}; 
m_mapper.addTargetField("1716741",88,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(88)); 
} 
createTargetStructure1(); 
} 


/*********************************************************************/ 
private static final void createTargetStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

{ 
int[] sourceFieldIDs = {92,93}; 
m_mapper.addTargetField("1716743",91,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(91)); 
} 

{ 
int[] sourceFieldIDs = {95,96}; 
m_mapper.addTargetField("1716745",94,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(94)); 
} 

{ 
int[] sourceFieldIDs = {98,99}; 
m_mapper.addTargetField("1716747",97,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(97)); 
} 

{ 
int[] sourceFieldIDs = {96,95}; 
m_mapper.addTargetField("1716752",100,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(100)); 
} 

{ 
int[] sourceFieldIDs = {102,103}; 
m_mapper.addTargetField("1716754",101,"District",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(101)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 

m_mapper.addTargetRecord("_T0Pa8BliEd6Nz-Od1HHEZQ",104,"EndUserShipToInformation",null,0,1); // EndUserShipToInformation 

{ 
int[] sourceFieldIDs = {56,57,8,19}; 
m_mapper.addTargetField("_T0Pa8xliEd6Nz-Od1HHEZQ",105,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(105)); 
} 

{ 
int[] sourceFieldIDs = {67,61,62,63,64,65,66,53,8,19}; 
m_mapper.addTargetField("_T0Pa9BliEd6Nz-Od1HHEZQ",106,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(106)); 
} 

m_mapper.addTargetRecord("_T0Pa8RliEd6Nz-Od1HHEZQ",107,"ContactInformation",null,0,1); // ContactInformation 

{ 
int[] sourceFieldIDs = {67,8,19}; 
m_mapper.addTargetField("_T0Pa9hliEd6Nz-Od1HHEZQ",108,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(108)); 
} 

{ 
int[] sourceFieldIDs = {8,71,19}; 
m_mapper.addTargetField("_T0Pa-BliEd6Nz-Od1HHEZQ",109,"TelephoneNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(109)); 
} 
m_mapper.makeParentTheCurrentRecord(); // ContactInformation 

m_mapper.addTargetRecord("_T0Pa8hliEd6Nz-Od1HHEZQ",110,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {64,76,77,65,61,53,67,63,66,62,8,19}; 
m_mapper.addTargetField("_T0Pa-xliEd6Nz-Od1HHEZQ",111,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(111)); 
} 

{ 
int[] sourceFieldIDs = {66,63,8,19}; 
m_mapper.addTargetField("_T0Pa_RliEd6Nz-Od1HHEZQ",112,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(112)); 
} 

{ 
int[] sourceFieldIDs = {84,83,8,19}; 
m_mapper.addTargetField("_T0Pa_hliEd6Nz-Od1HHEZQ",113,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(113)); 
} 

{ 
int[] sourceFieldIDs = {115,8,19,116}; 
m_mapper.addTargetField("_T0PbABliEd6Nz-Od1HHEZQ",114,"AddressLine4",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(114)); 
} 

{ 
int[] sourceFieldIDs = {90,89,8,19}; 
m_mapper.addTargetField("_T0PbARliEd6Nz-Od1HHEZQ",117,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(117)); 
} 

{ 
int[] sourceFieldIDs = {93,92,8,19}; 
m_mapper.addTargetField("_T0PbAhliEd6Nz-Od1HHEZQ",118,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(118)); 
} 

{ 
int[] sourceFieldIDs = {8,19,96,95}; 
m_mapper.addTargetField("_T0PbAxliEd6Nz-Od1HHEZQ",119,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(119)); 
} 

{ 
int[] sourceFieldIDs = {8,19,99,98}; 
m_mapper.addTargetField("_T0PbBBliEd6Nz-Od1HHEZQ",120,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(120)); 
} 

{ 
int[] sourceFieldIDs = {96,95,8,19}; 
m_mapper.addTargetField("_T0PbBhliEd6Nz-Od1HHEZQ",121,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(121)); 
} 

{ 
int[] sourceFieldIDs = {102,19,8,103}; 
m_mapper.addTargetField("_T0PbBxliEd6Nz-Od1HHEZQ",122,"District",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(122)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // EndUserShipToInformation 

m_mapper.addTargetRecord("1716482",123,"ShipmentInformation",null,0,1); // ShipmentInformation 

{ 
int[] sourceFieldIDs = {125}; 
m_mapper.addTargetField("_lJnawKK4EeOevobSY0eQ0Q",124,"FulfillmentPartnerId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(124)); 
} 
m_mapper.makeParentTheCurrentRecord(); // ShipmentInformation 

m_mapper.addTargetRecord("1716465",126,"DeliveryInformation",null,0,1); // DeliveryInformation 

{ 
int[] sourceFieldIDs = {128,8,129}; 
m_mapper.addTargetField("1716711",127,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(127)); 
} 

{ 
int[] sourceFieldIDs = {131}; 
m_mapper.addTargetField("1716713",130,"CarrierId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(130)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {133}; 
m_mapper.addTargetField("_7XlwoGEAEeOSzauxJkR34A",132,"FreightFowarderIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {135,136,137,138,8,139,140,141,142}; 
m_mapper.addTargetField("1716719",134,"DeliveryInstruction",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(134)); 
} 

{ 
int[] sourceFieldIDs = {144}; 
m_mapper.addTargetField("1716721",143,"DeliveryInstructionExtended",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("_34lTIGEAEeOSzauxJkR34A",145,"InstallationPartnerInformation",null,0,1); // InstallationPartnerInformation 

{ 
int[] sourceFieldIDs = {147}; 
m_mapper.addTargetField("_34lTI2EAEeOSzauxJkR34A",146,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("_34lTImEAEeOSzauxJkR34A",148,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {150}; 
m_mapper.addTargetField("_34lTK2EAEeOSzauxJkR34A",149,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {152}; 
m_mapper.addTargetField("_34lTLWEAEeOSzauxJkR34A",151,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {154}; 
m_mapper.addTargetField("_34lTLmEAEeOSzauxJkR34A",153,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {156}; 
m_mapper.addTargetField("_34lTMWEAEeOSzauxJkR34A",155,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {158}; 
m_mapper.addTargetField("_34lTMmEAEeOSzauxJkR34A",157,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {160}; 
m_mapper.addTargetField("_34lTM2EAEeOSzauxJkR34A",159,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {162}; 
m_mapper.addTargetField("_34lTNGEAEeOSzauxJkR34A",161,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {160}; 
m_mapper.addTargetField("_34lTNmEAEeOSzauxJkR34A",163,"Region",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // InstallationPartnerInformation 
m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716472",164,"PaymentInformation",null,0,1); // PaymentInformation 

{ 
int[] sourceFieldIDs = {166}; 
m_mapper.addTargetField("1716838",165,"PaymentMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
createTargetStructure2(); 
} 


/*********************************************************************/ 
private static final void createTargetStructure2() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

{ 
int[] sourceFieldIDs = {168}; 
m_mapper.addTargetField("6544890",167,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {172}; 
m_mapper.addTargetField("_HdsckEJREeOm9_rBwVbvMQ",171,"CreditCardHolderName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {174}; 
m_mapper.addTargetField("_T2pB8NLeEd6WyuKq4iZSZQ",173,"CreditCardNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {176,177}; 
m_mapper.addTargetField("1716842",175,"CardExpirationDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(175)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PaymentInformation 
m_mapper.makeParentTheCurrentRecord(); // Header 

int[][] loopAssociatedSourceIDs178 = {{10,33}}; 

m_mapper.addTargetRecord("1716474",178,"Detail",null,0,UNLIMITED,loopAssociatedSourceIDs178); // Detail 

{ 
int[] sourceFieldIDs = {180}; 
m_mapper.addTargetField("1716861",179,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {32,182}; 
m_mapper.addTargetField("6491337",181,"BusinessOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(181)); 
} 

{ 
int[] sourceFieldIDs = {184}; 
m_mapper.addTargetField("1716872",183,"ServiceLevel",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(183)); 
} 

{ 
int[] sourceFieldIDs = {59}; 
m_mapper.addTargetField("1716874",185,"CustomerOrderFullfillmentlPriority",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {187,188}; 
m_mapper.addTargetField("1716880",186,"LineComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(186)); 
} 

m_mapper.addTargetRecord("1716461",189,"BaseItemDetail",null,1,1); // BaseItemDetail 

{ 
int[] sourceFieldIDs = {191}; 
m_mapper.addTargetField("1716663",190,"LexmarkPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {193}; 
m_mapper.addTargetField("1716665",192,"BuyerLineItemNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {195}; 
m_mapper.addTargetField("1716669",194,"CustomerPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {197}; 
m_mapper.addTargetField("_OiBWYI29EeO4M7g7o-4nrw",196,"VendorPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {182}; 
m_mapper.addTargetField("5830661",198,"ReturnedItemIndicator",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {200}; 
m_mapper.addTargetField("_r_8EoDXXEd6xVIY_OIneBg",199,"MerchandiseTypeCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {202}; 
m_mapper.addTargetField("_TAWKoGEBEeOSzauxJkR34A",201,"ConfigurationItemNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {204}; 
m_mapper.addTargetField("_TAWKoWEBEeOSzauxJkR34A",203,"ConfigurationItemName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // BaseItemDetail 

m_mapper.addTargetRecord("_yAeEEFrAEd6fbbk7F5PhuA",205,"SerialNumbers",null,0,UNLIMITED); // SerialNumbers 

{ 
int[] sourceFieldIDs = {207}; 
m_mapper.addTargetField("_zQgIkFrAEd6fbbk7F5PhuA",206,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {209}; 
m_mapper.addTargetField("_0AvSsFrAEd6fbbk7F5PhuA",208,"RIDTagNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // SerialNumbers 

m_mapper.addTargetRecord("1716442",210,"OrderQuantities",null,1,1); // OrderQuantities 

m_mapper.addTargetRecord("1716452",211,"OrderedQuantity",null,0,1); // OrderedQuantity 

{ 
int[] sourceFieldIDs = {213}; 
m_mapper.addTargetField("1716548",212,"@unitOfMeasurement",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(212)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {215}; 
m_mapper.addTargetField("1716550",214,"*body",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // OrderedQuantity 
m_mapper.makeParentTheCurrentRecord(); // OrderQuantities 

m_mapper.addTargetRecord("1716454",216,"PricingDetail",null,0,1); // PricingDetail 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716558",217,"UnitPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(217)); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716562",218,"ExtendedPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(218)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PricingDetail 

m_mapper.addTargetRecord("1716479",219,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 

{ 
int[] sourceFieldIDs = {40}; 
m_mapper.addTargetField("1716913",220,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(220)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716458",221,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

{ 
int[] sourceFieldIDs = {32,182,223}; 
m_mapper.addTargetField("_yR7p8LWQEeGd6d-4WvXXGg",222,"VendorName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(222)); 
} 

{ 
int[] sourceFieldIDs = {225}; 
m_mapper.addTargetField("_zVfyEHhwEeOFBINMKD9lAw",224,"VendorContractNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {227}; 
m_mapper.addTargetField("_zP9_gLWQEeGd6d-4WvXXGg",226,"OrderFulFillmentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716447",228,"DeliveryInformation",null,0,1); // DeliveryInformation 

{ 
int[] sourceFieldIDs = {230}; 
m_mapper.addTargetField("1716502",229,"RequestedDeliveryDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(229)); 
} 

{ 
int[] sourceFieldIDs = {8,232}; 
m_mapper.addTargetField("1716511",231,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(231)); 
} 

{ 
int[] sourceFieldIDs = {8,234}; 
m_mapper.addTargetField("1716513",233,"CarrierId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(233)); 
} 
m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716477",235,"WarrantyInformation",null,0,1); // WarrantyInformation 

{ 
int[] sourceFieldIDs = {237}; 
m_mapper.addTargetField("1716902",236,"WarrantyType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // WarrantyInformation 

m_mapper.addTargetRecord("1716443",238,"RelatedObjectReference",null,0,1); // RelatedObjectReference 

{ 
int[] sourceFieldIDs = {240}; 
m_mapper.addTargetField("1716485",239,"SourceReferenceLineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {242}; 
m_mapper.addTargetField("_LWJC0LzQEeKTXfd_Z2X4Ow",241,"RelatedActivityId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {140}; 
m_mapper.addTargetField("_JY9EUMSaEeKDFeNYU6Fxlw",243,"RelatedAssetId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {245}; 
m_mapper.addTargetField("_w6_zYN9CEeK4lOjDEdGVfg",244,"RelatedContractNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
int[] sourceFieldIDs = {247,248}; 
m_mapper.addTargetField("_w6_zYd9CEeK4lOjDEdGVfg",246,"RelatedContractLineNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(246)); 
} 

{ 
int[] sourceFieldIDs = {250}; 
m_mapper.addTargetField("_iIOIsGEBEeOSzauxJkR34A",249,"PrimaryContractItem",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // RelatedObjectReference 
m_mapper.makeParentTheCurrentRecord(); // Detail 

m_mapper.addTargetRecord("1716451",251,"RelatedObjectReferences",null,0,1); // RelatedObjectReferences 

{ 
int[] sourceFieldIDs = {253}; 
m_mapper.addTargetField("1716538",252,"CustomerPurchaseOrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {255}; 
m_mapper.addTargetField("1716540",254,"CustomerRequisitionNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {257}; 
m_mapper.addTargetField("1716544",256,"SourceReferenceNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {24}; 
m_mapper.addTargetField("1716546",258,"SourceReferenceDocumentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
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

Move "YES" to Target 
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

Move "NO" to Target 
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

Move "NO" to Target 
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

If Source Exists 
Call "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
EndIf 
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
public static final void mappingRule_39(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_52(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_55(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(56))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(56), 55, 56)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 55, 57)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(58), 55, 58)); 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(56))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(56), 55, 56)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 55, 57)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(58), 55, 58)); 
} 
} 
else if (Compare.contains(transformControl.getSource(59), "M")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 55, 57)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(58), 55, 58)); 
} 
} 
else if (Compare.exists(transformControl.getSource(56))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(56), 55, 56)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 55, 57)); 
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
public static final void mappingRule_60(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 60, 65)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 60, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 60, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 60, 61)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 60, 62)); 
} 
} 


/*********************************************************************/ 
/* 
If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDSRType] = "Fleet Management" 
If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKMPSSRArea] = "HW Order" 
Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ContactWorkPhone] to Target 
Else 
Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCSRContactPhoneNum] to Target 
endif 
Else 
Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKCSRContactPhoneNum] to Target 
endif 
*/ 
public static final void mappingRule_70(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(73), "HW Order")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(72), 70, 72)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 70, 71)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 70, 71)); 
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
*/ 
public static final void mappingRule_75(TTransformControl transformControl) throws Exception 
{ 
//If [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|LXKSDServiceProviderName] Missing 
// Move PrimaryShipToFirstName to [LTF_ShipToFullName] 
// Append " " to [LTF_ShipToFullName] 
// Append PrimaryShipToLastName to [LTF_ShipToFullName] 
// Move [LTF_ShipToFullName] to Target 
//EndIf 
//Check if below logic works wonder for the issue 4950 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 75, 65)); 
} 
else if (Compare.exists(transformControl.getSource(78))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(78), 75, 78)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 75, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 75, 67)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Service - Admin Only")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 75, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 75, 61)); 
} 
else if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 75, 62)); 
} 
else if (Compare.missing(transformControl.getSource(65))) 
{ 
String LTF_ShipToFullName = ""; 
LTF_ShipToFullName = new String(transformControl.getSource(76)); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(" "); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(transformControl.getSource(77)); 
transformControl.setTarget(new String(LTF_ShipToFullName)); 
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
public static final void mappingRule_79(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(8), "Consumables Management")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 79, 80)); 
} 
else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(73), "HW Order")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 79, 67)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 79, 80)); 
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
public static final void mappingRule_81(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 81, 66)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(63), 81, 63)); 
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
public static final void mappingRule_82(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(84))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 82, 84)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(83), 82, 83)); 
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
public static final void mappingRule_85(TTransformControl transformControl) throws Exception 
{ 
//# Map phone number to the phone number field 
//# Then, concatenate this on the JDE side of the map. 
if (Compare.exists(transformControl.getSource(87))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 85, 87)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(86), 85, 86)); 
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
public static final void mappingRule_88(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 88, 90)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(89), 88, 89)); 
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
public static final void mappingRule_91(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(93))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 91, 93)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(92), 91, 92)); 
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
public static final void mappingRule_94(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 94, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 94, 95)); 
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
public static final void mappingRule_97(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(98))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(98), 97, 98)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 97, 99)); 
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
public static final void mappingRule_100(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 100, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 100, 95)); 
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
public static final void mappingRule_101(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(103))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 101, 103)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 101, 102)); 
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
endif 
*/ 
public static final void mappingRule_105(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget("DFMFD"); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 105, 57)); 
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
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 105, 57)); 
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
public static final void mappingRule_106(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 106, 65)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 106, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 106, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 106, 61)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 106, 62)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 106, 65)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 106, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 106, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 106, 61)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 106, 62)); 
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
public static final void mappingRule_108(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 108, 67)); 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 108, 67)); 
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
public static final void mappingRule_109(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 109, 71)); 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(71), 109, 71)); 
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
public static final void mappingRule_111(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 111, 65)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 111, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 111, 67)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Service - Admin Only")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 111, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 111, 61)); 
} 
else if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 111, 62)); 
} 
else if (Compare.missing(transformControl.getSource(65))) 
{ 
String LTF_ShipToFullName = ""; 
LTF_ShipToFullName = new String(transformControl.getSource(76)); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(" "); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(transformControl.getSource(77)); 
transformControl.setTarget(new String(LTF_ShipToFullName)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 111, 65)); 
} 
else if (Compare.equals(transformControl.getSource(64), "DFM")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 111, 61)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Customer")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 111, 67)); 
} 
else if (Compare.equals(transformControl.getSource(53), "Generic Service - Admin Only")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 111, 67)); 
} 
else if (Compare.contains(transformControl.getSource(62), transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 111, 61)); 
} 
else if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 111, 62)); 
} 
else if (Compare.missing(transformControl.getSource(65))) 
{ 
String LTF_ShipToFullName = ""; 
LTF_ShipToFullName = new String(transformControl.getSource(76)); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(" "); 
LTF_ShipToFullName = LTF_ShipToFullName.concat(transformControl.getSource(77)); 
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
public static final void mappingRule_112(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 112, 66)); 
} 
else 
{ 
if (Compare.exists(transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(63), 112, 63)); 
} 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(66))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(66), 112, 66)); 
} 
else 
{ 
if (Compare.exists(transformControl.getSource(63))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(63), 112, 63)); 
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
public static final void mappingRule_113(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(84))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 113, 84)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(83), 113, 83)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(84))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 113, 84)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(83), 113, 83)); 
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
public static final void mappingRule_114(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(115))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(115), 114, 115)); 
} 
else if (Compare.exists(transformControl.getSource(116))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(116), 114, 116)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(115))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(115), 114, 115)); 
} 
else if (Compare.exists(transformControl.getSource(116))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(116), 114, 116)); 
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
public static final void mappingRule_117(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 117, 90)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(89), 117, 89)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 117, 90)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(89), 117, 89)); 
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
public static final void mappingRule_118(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(93))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 118, 93)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(92), 118, 92)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(93))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 118, 93)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(92), 118, 92)); 
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
public static final void mappingRule_119(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 119, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 119, 95)); 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 119, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 119, 95)); 
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
public static final void mappingRule_120(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(98))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(98), 120, 98)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 120, 99)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(98))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(98), 120, 98)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(99), 120, 99)); 
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
public static final void mappingRule_121(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumables")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 121, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 121, 95)); 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(96), 121, 96)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(95), 121, 95)); 
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
public static final void mappingRule_122(TTransformControl transformControl) throws Exception 
{ 
if (Compare.contains(transformControl.getSource(8), "Consumable")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(103))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 122, 103)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 122, 102)); 
} 
} 
} 
else if (Compare.contains(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(19), "Lexmark - Brazil")) 
{ 
if (Compare.exists(transformControl.getSource(103))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(103), 122, 103)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 122, 102)); 
} 
} 
} 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Move Source to Target 
endif 
*/ 
public static final void mappingRule_124(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(125))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(125), 124, 125)); 
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
public static final void mappingRule_127(TTransformControl transformControl) throws Exception 
{ 
//# This field is mapped for EMEA. US does not need it at the header level. 
if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.equals(transformControl.getSource(129), "Y")) 
{ 
transformControl.setTarget("WhiteGlove"); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(128), 127, 128)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(128), 127, 128)); 
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
public static final void mappingRule_130(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_134(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(137))) 
{ 
String tmp_Instructions = ""; 
tmp_Instructions = ""; 
tmp_Instructions = new String(transformControl.getSource(137)); 
if (Compare.exists(transformControl.getSource(138))) 
{ 
tmp_Instructions = tmp_Instructions.concat(" "); 
tmp_Instructions = tmp_Instructions.concat(transformControl.getSource(138)); 
} 
transformControl.setTarget(new String(tmp_Instructions)); 
} 
else if (Compare.exists(transformControl.getSource(138))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(138), 134, 138)); 
} 
else if (Compare.equals(transformControl.getSource(8), "Consumables Management")) 
{ 
if (Compare.exists(transformControl.getSource(141))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(141)); 
if (Compare.exists(transformControl.getSource(140))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(140)); 
} 
if (Compare.exists(transformControl.getSource(142))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(142)); 
} 
transformControl.setTarget(new String(temp)); 
} 
else if (Compare.exists(transformControl.getSource(140))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(140)); 
if (Compare.exists(transformControl.getSource(142))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(142)); 
} 
transformControl.setTarget(new String(temp)); 
} 
else if (Compare.exists(transformControl.getSource(142))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(142)); 
transformControl.setTarget(new String(temp)); 
} 
} 
else if (Compare.equals(transformControl.getSource(8), "Fleet Management")) 
{ 
if (Compare.exists(transformControl.getSource(141))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(141)); 
if (Compare.exists(transformControl.getSource(140))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(140)); 
} 
if (Compare.exists(transformControl.getSource(142))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(142)); 
} 
transformControl.setTarget(new String(temp)); 
} 
else if (Compare.exists(transformControl.getSource(140))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(140)); 
if (Compare.exists(transformControl.getSource(142))) 
{ 
temp = temp.concat(","); 
temp = temp.concat(transformControl.getSource(142)); 
} 
transformControl.setTarget(new String(temp)); 
} 
else if (Compare.exists(transformControl.getSource(142))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(142)); 
transformControl.setTarget(new String(temp)); 
} 
} 
else if (Compare.exists(transformControl.getSource(141))) 
{ 
String temp = ""; 
temp = new String(transformControl.getSource(141)); 
temp = temp.concat(" "); 
temp = temp.concat(transformControl.getSource(136)); 
temp = temp.concat(" "); 
temp = temp.concat(transformControl.getSource(135)); 
transformControl.setTarget(new String(temp)); 
} 
else 
{ 
String LTF_ContactFullName = ""; 
LTF_ContactFullName = new String(transformControl.getSource(136)); 
LTF_ContactFullName = LTF_ContactFullName.concat(" "); 
LTF_ContactFullName = LTF_ContactFullName.concat(transformControl.getSource(135)); 
transformControl.setTarget(new String(LTF_ContactFullName)); 
} 
} 


/*********************************************************************/ 
/* 
Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfLXKMPSSRPayments|ListOfLxkMpsSrPayments|ExpirationMonth] to [temp_Month] 
Move [OrderOutboundDTD|SiebelMessage|ListOfLxkCOrderEntry|OrderEntry-Orders|ListOfLXKMPSSRPayments|ListOfLxkMpsSrPayments|ExpirationYear] to [temp_Year] 
Append [temp_Month] to [temp_Year] 
Move [temp_Year] to Target 
*/ 
public static final void mappingRule_175(TTransformControl transformControl) throws Exception 
{ 
String temp_Month = ""; 
temp_Month = new String(transformControl.getSource(176)); 
String temp_Year = ""; 
temp_Year = new String(transformControl.getSource(177)); 
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
public static final void mappingRule_181(TTransformControl transformControl) throws Exception 
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
transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 181, 32)); 
} 


/*********************************************************************/ 
/* 
Move Source to Target 
*/ 
public static final void mappingRule_183(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(184), 183, 184)); 
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
public static final void mappingRule_186(TTransformControl transformControl) throws Exception 
{ 
String tmpComments = ""; 
tmpComments = ""; 
if (Compare.exists(transformControl.getSource(187))) 
{ 
tmpComments = new String(transformControl.getSource(187)); 
tmpComments = tmpComments.concat(" "); 
} 
if (Compare.exists(transformControl.getSource(188))) 
{ 
tmpComments = tmpComments.concat(transformControl.getSource(188)); 
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
public static final void mappingRule_212(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_217(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("0.00"); 
} 


/*********************************************************************/ 
/* 
Move "0.00" to Target 
*/ 
public static final void mappingRule_218(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_220(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_222(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(182), "Ship")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 222, 32)); 
} 
else if (Compare.equals(transformControl.getSource(182), "RMA")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(223), 222, 223)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(32), 222, 32)); 
} 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Call "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
EndIf 
*/ 
public static final void mappingRule_229(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(230))) 
{ 
String sources [] = {transformControl.getSource(230),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
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
public static final void mappingRule_231(TTransformControl transformControl) throws Exception 
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
transformControl.setTarget(transformControl.convert(transformControl.getSource(232), 231, 232)); 
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
public static final void mappingRule_233(TTransformControl transformControl) throws Exception 
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
transformControl.setTarget(transformControl.convert(transformControl.getSource(234), 233, 234)); 
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
public static final void mappingRule_246(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(248))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(248), 246, 248)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(247), 246, 247)); 
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



// --- <<B2B-END-SHARED>> --- 


/*********************************************************************/ 
// B2B Developer requires the use of "in" and "out" for the Values names. 

public static final Values transform(Values in) 
{ 
Values out = in; 
// --- <<B2B-START(transform)>> --- 
TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, m_isWmEsourceObject, TARGETOBJECTNAME, ISWMETARGETOBJECT); 
webmethodsManager.runTransform(out); 
// --- <<B2B-END>> --- 
return out; 
} 

public static final Values transformToStream(Values in) 
{ 
Values out = in; 
// --- <<B2B-START(transformToStream)>> --- 
TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, TARGETOBJECTNAME); 
webmethodsManager.runTransformToStream(out); 
// --- <<B2B-END>> --- 
return out; 
} 

public static final Values transformToString(Values in) 
{ 
Values out = in; 
// --- <<B2B-START(transformToString)>> --- 
TWebmethodsManager webmethodsManager = new TWebmethodsManager(m_mapper, m_started, m_sourceObjectNames, TARGETOBJECTNAME); 
webmethodsManager.runTransformToString(out); 
// --- <<B2B-END>> --- 
return out; 
} 

} 

