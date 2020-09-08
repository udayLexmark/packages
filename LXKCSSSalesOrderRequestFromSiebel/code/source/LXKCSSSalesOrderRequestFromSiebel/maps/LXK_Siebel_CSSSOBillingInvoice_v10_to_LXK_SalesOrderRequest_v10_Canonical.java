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
Class: LXK_Siebel_CSSSOBillingInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical 
Date: 2013-03-19-04:00 
Author: Contivo Analyst Transform Writer Version 3.11.2.1.8 
Purpose: This service unit provides data transformation for the mapping matrix "LXK_Siebel_CSSSOBillingInvoice_v1.0_to_LXK_SalesOrderRequest_v1.0_Canonical". 
*/ 

package LXKCSSSalesOrderRequestFromSiebel.maps;




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



public final class LXK_Siebel_CSSSOBillingInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical 
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
private static final String TRANSFORM_NAME = "LXK_Siebel_CSSSOBillingInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical"; 
private static final Class[] PARAMETER_TYPES = {com.contivo.runtime.core.TTransformControl.class}; 


static 
{ 
try 
{ 
m_mapper = new TMapper(LXK_Siebel_CSSSOBillingInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical.class,TRANSFORM_NAME,"transform",187); 
m_mapper.setTimeStamp("2013-03-19 09:05:04 ADT"); 
m_mapper.setTargetEncoding("UTF-8"); 
m_mapper.setBigDecimalProcessing(false); 
m_sourceObjectNames = new Vector(); 
m_isWmEsourceObject = new Vector(); 
m_sourceObjectNames.add("BillingInvoiceOutboundDTD"); 
m_isWmEsourceObject.add(new Boolean("false")); 
m_mapper.setSourceObjectNames(m_sourceObjectNames); 
m_mapper.setTargetObjectName(TARGETOBJECTNAME); 
createSourceStructure(); 
createTargetStructure(); 
createTemporaryFields(); 
buildTargetNamespaceTable(); 
m_mapper.initializationCleanup(); 
boolean[] sourceAttrNSFixed = {false}; 
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

m_mapper.addSourceRecord("_6v_SEKelEd63quZlKtMRzQ",10,"SiebelMessage",null,0,1); // SiebelMessage 
m_mapper.setXMLInputProcessing(true); 
{ 
m_mapper.addSourceField("_6v_SGqelEd63quZlKtMRzQ",9,"@MessageId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_6v_SEaelEd63quZlKtMRzQ",18,"ListOfLxkCFsInvoice",null,1,UNLIMITED); // ListOfLxkCFsInvoice 

m_mapper.addSourceRecord("_6v_SEqelEd63quZlKtMRzQ",17,"LxkCFsInvoice",null,0,UNLIMITED); // LxkCFsInvoice 

{ 
m_mapper.addSourceField("_6v_SH6elEd63quZlKtMRzQ",114,"Id",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SJ6elEd63quZlKtMRzQ",49,"AccountName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SKKelEd63quZlKtMRzQ",16,"AccountOrganizationName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SLKelEd63quZlKtMRzQ",45,"BillToFirstName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SLaelEd63quZlKtMRzQ",46,"BillToLastName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SM6elEd63quZlKtMRzQ",36,"CreatedByName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SNKelEd63quZlKtMRzQ",100,"CreditCardAuthorizationCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SP6elEd63quZlKtMRzQ",98,"CreditCardNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SQqelEd63quZlKtMRzQ",39,"CurrencyCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SR6elEd63quZlKtMRzQ",25,"InvoiceDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_ST6elEd63quZlKtMRzQ",42,"LXKCBillToAddressJDENumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SUqelEd63quZlKtMRzQ",68,"LXKCShipToAddressJDENumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SVKelEd63quZlKtMRzQ",27,"LXKCComments-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SV6elEd63quZlKtMRzQ",180,"LXKCPONumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SWKelEd63quZlKtMRzQ",31,"LXKCRefundReason-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SWqelEd63quZlKtMRzQ",118,"LXKCSerialNumber-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SW6elEd63quZlKtMRzQ",94,"LXKCPaymentMethod",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SYqelEd63quZlKtMRzQ",184,"OrderNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SZaelEd63quZlKtMRzQ",186,"OrderType",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_Sa6elEd63quZlKtMRzQ",92,"PaymentTerm",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SdKelEd63quZlKtMRzQ",182,"SRNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SgaelEd63quZlKtMRzQ",29,"TotalAmount",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_ShKelEd63quZlKtMRzQ",23,"TypeCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_ShaelEd63quZlKtMRzQ",61,"LXKSDBillToState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_ShqelEd63quZlKtMRzQ",57,"LXKSDBillToPostalCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_Sh6elEd63quZlKtMRzQ",64,"LXKSDBillToCountry",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SiKelEd63quZlKtMRzQ",59,"LXKSDBillToCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SiaelEd63quZlKtMRzQ",51,"LXKSDBillToAddress",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SiqelEd63quZlKtMRzQ",62,"LXKSDBillToProvince",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_Si6elEd63quZlKtMRzQ",55,"LXKSDBillToAddress3",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SjKelEd63quZlKtMRzQ",53,"LXKSDBillToAddress2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SjaelEd63quZlKtMRzQ",84,"LXKSDOrderSRShipToState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SjqelEd63quZlKtMRzQ",80,"LXKSDOrderSRShipToPostalCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_Sj6elEd63quZlKtMRzQ",87,"LXKSDOrderSRShipToCountry",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SkKelEd63quZlKtMRzQ",82,"LXKSDOrderSRShipToCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SkaelEd63quZlKtMRzQ",74,"LXKSDOrderSRShipToAddress",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SkqelEd63quZlKtMRzQ",85,"LXKSDOrderSRShipToProvince",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_Sk6elEd63quZlKtMRzQ",78,"LXKSDOrderSRShipToAddress3",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SlKelEd63quZlKtMRzQ",76,"LXKSDOrderSRShipToAddress2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SlqelEd63quZlKtMRzQ",158,"LXKSDAssetPostalCodeSO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SmKelEd63quZlKtMRzQ",96,"LXKSDPaymentType",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6v_SmaelEd63quZlKtMRzQ",72,"LXKUPOrderShipToAccountName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_6v_SE6elEd63quZlKtMRzQ",103,"ListOfLxkCFsInvoiceLineItems",null,0,1); // ListOfLxkCFsInvoiceLineItems 

m_mapper.addSourceRecord("_6v_SFKelEd63quZlKtMRzQ",102,"LxkCFsInvoiceLineItems",null,0,UNLIMITED); // LxkCFsInvoiceLineItems 

m_mapper.addSourceRecord("_6v_SFaelEd63quZlKtMRzQ",105,"ListOfLxkCFsInvoiceLineItemDetails",null,0,1); // ListOfLxkCFsInvoiceLineItemDetails 

m_mapper.addSourceRecord("_6v_SFqelEd63quZlKtMRzQ",104,"LxkCFsInvoiceLineItemDetails",null,0,UNLIMITED); // LxkCFsInvoiceLineItemDetails 

{ 
m_mapper.addSourceField("_6wJDG6elEd63quZlKtMRzQ",177,"Id",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDHqelEd63quZlKtMRzQ",127,"Amount",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
m_mapper.addSourceField("_6wJDIqelEd63quZlKtMRzQ",142,"LXKCCityTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDJKelEd63quZlKtMRzQ",146,"LXKCCountyTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDJaelEd63quZlKtMRzQ",150,"LXKCGSTTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDJqelEd63quZlKtMRzQ",129,"LXKCItemPrice-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDJ6elEd63quZlKtMRzQ",128,"LXKCJDEExtAmt-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDKKelEd63quZlKtMRzQ",109,"LXKCOrderLineComments-SO",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDKaelEd63quZlKtMRzQ",152,"LXKCHSTTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDKqelEd63quZlKtMRzQ",154,"LXKCPSTTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDK6elEd63quZlKtMRzQ",144,"LXKCSecondaryCityTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDLKelEd63quZlKtMRzQ",122,"LXKCProductUOM",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDLaelEd63quZlKtMRzQ",148,"LXKCSecondaryCountyTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDLqelEd63quZlKtMRzQ",140,"LXKCSecondaryStateTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDL6elEd63quZlKtMRzQ",138,"LXKCStateTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDMKelEd63quZlKtMRzQ",156,"LXKCVATTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDMqelEd63quZlKtMRzQ",107,"LineNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDNKelEd63quZlKtMRzQ",112,"ProductName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDNaelEd63quZlKtMRzQ",124,"Quantity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_6wJDN6elEd63quZlKtMRzQ",136,"LXKSDFederalTax",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // LxkCFsInvoiceLineItemDetails 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCFsInvoiceLineItemDetails 
m_mapper.makeParentTheCurrentRecord(); // LxkCFsInvoiceLineItems 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCFsInvoiceLineItems 
m_mapper.makeParentTheCurrentRecord(); // LxkCFsInvoice 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCFsInvoice 
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
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("_RHk8ABlEEd6Nz-Od1HHEZQ",7,"BusinessProcess",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(7)); 
} 

{ 
int[] sourceFieldIDs = {9}; 
m_mapper.addTargetField("1716628",8,"SourceDocumentTrackingId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716632",12,"ObjectChangeActionType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(12)); 
m_mapper.addTableToField(0); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716635",13,"IntegrationCreationDateTime",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(13)); 
} 

m_mapper.addTargetRecord("1716480",14,"RelevantGeographies",null,0,1); // RelevantGeographies 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716918",15,"US",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(15)); 
m_mapper.setDefaultValue("YES", false); 
m_mapper.addTableToField(1); 
} 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716921",19,"EMEA",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(19)); 
m_mapper.setDefaultValue("YES", false); 
m_mapper.addTableToField(2); 
} 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716924",20,"APG",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(20)); 
m_mapper.setDefaultValue("YES", false); 
m_mapper.addTableToField(3); 
} 
m_mapper.makeParentTheCurrentRecord(); // RelevantGeographies 
m_mapper.makeParentTheCurrentRecord(); // DocumentMetaData 

m_mapper.addTargetRecord("1716469",21,"Header",null,0,1); // Header 

{ 
int[] sourceFieldIDs = {23}; 
m_mapper.addTargetField("1716768",22,"OrderType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(22)); 
} 

{ 
int[] sourceFieldIDs = {25}; 
m_mapper.addTargetField("1716770",24,"OrderDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(24)); 
} 

{ 
int[] sourceFieldIDs = {27}; 
m_mapper.addTargetField("1716780",26,"OrderComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {29}; 
m_mapper.addTargetField("1716782",28,"OrderTotalAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {31}; 
m_mapper.addTargetField("1716795",30,"ReturnReason",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(30)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("1716468",32,"LexmarkOrderInformation",null,0,1); // LexmarkOrderInformation 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716756",33,"BusinessOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(33)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716758",34,"InternalCompanyId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(34)); 
} 

{ 
int[] sourceFieldIDs = {36}; 
m_mapper.addTargetField("1716762",35,"OrderEnteredBy",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // LexmarkOrderInformation 

m_mapper.addTargetRecord("1716446",37,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 

{ 
int[] sourceFieldIDs = {39}; 
m_mapper.addTargetField("1716499",38,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(38)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("1716453",40,"BillToInformation",null,0,1); // BillToInformation 

{ 
int[] sourceFieldIDs = {42}; 
m_mapper.addTargetField("1716552",41,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716444",43,"ContactInformation",null,0,1); // ContactInformation 

{ 
int[] sourceFieldIDs = {45,46}; 
m_mapper.addTargetField("1716487",44,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(44)); 
} 
m_mapper.makeParentTheCurrentRecord(); // ContactInformation 

m_mapper.addTargetRecord("1716471",47,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {49}; 
m_mapper.addTargetField("1716809",48,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(48)); 
} 

{ 
int[] sourceFieldIDs = {51}; 
m_mapper.addTargetField("1716813",50,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {53}; 
m_mapper.addTargetField("1716815",52,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {55}; 
m_mapper.addTargetField("1716817",54,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {57}; 
m_mapper.addTargetField("1716821",56,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {59}; 
m_mapper.addTargetField("1716823",58,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {61,62}; 
m_mapper.addTargetField("1716825",60,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(60)); 
} 

{ 
int[] sourceFieldIDs = {64}; 
m_mapper.addTargetField("1716827",63,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(63)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // BillToInformation 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716473",65,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716466",66,"ShipToInformation",null,0,1); // ShipToInformation 

{ 
int[] sourceFieldIDs = {68}; 
m_mapper.addTargetField("1716723",67,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {49}; 
m_mapper.addTargetField("1716725",69,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(69)); 
} 

m_mapper.addTargetRecord("1716467",70,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {72}; 
m_mapper.addTargetField("1716729",71,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(71)); 
} 

{ 
int[] sourceFieldIDs = {74,51}; 
m_mapper.addTargetField("1716733",73,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(73)); 
} 

{ 
int[] sourceFieldIDs = {76,53,74}; 
m_mapper.addTargetField("1716735",75,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(75)); 
} 
createTargetStructure1(); 
} 


/*********************************************************************/ 
private static final void createTargetStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

{ 
int[] sourceFieldIDs = {78,55,74}; 
m_mapper.addTargetField("1716737",77,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(77)); 
} 

{ 
int[] sourceFieldIDs = {80,57}; 
m_mapper.addTargetField("1716741",79,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(79)); 
} 

{ 
int[] sourceFieldIDs = {82,59}; 
m_mapper.addTargetField("1716743",81,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(81)); 
} 

{ 
int[] sourceFieldIDs = {84,85,61,62}; 
m_mapper.addTargetField("1716745",83,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(83)); 
} 

{ 
int[] sourceFieldIDs = {87,64}; 
m_mapper.addTargetField("1716747",86,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(86)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 

m_mapper.addTargetRecord("1716465",88,"DeliveryInformation",null,0,1); // DeliveryInformation 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716711",89,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(89)); 
} 
m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716472",90,"PaymentInformation",null,0,1); // PaymentInformation 

{ 
int[] sourceFieldIDs = {92,23}; 
m_mapper.addTargetField("1716836",91,"PaymentTerms",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(91)); 
} 

{ 
int[] sourceFieldIDs = {94}; 
m_mapper.addTargetField("1716838",93,"PaymentMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(93)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {96}; 
m_mapper.addTargetField("6544890",95,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {98}; 
m_mapper.addTargetField("1716840",97,"CardLast4Digits",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {100}; 
m_mapper.addTargetField("1716848",99,"CardAuthorizationCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // PaymentInformation 
m_mapper.makeParentTheCurrentRecord(); // Header 

int[][] loopAssociatedSourceIDs101 = {{17,102,104}}; 

m_mapper.addTargetRecord("1716474",101,"Detail",null,0,UNLIMITED,loopAssociatedSourceIDs101); // Detail 

{ 
int[] sourceFieldIDs = {107}; 
m_mapper.addTargetField("1716861",106,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {109}; 
m_mapper.addTargetField("1716880",108,"LineComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716461",110,"BaseItemDetail",null,1,1); // BaseItemDetail 

{ 
int[] sourceFieldIDs = {112}; 
m_mapper.addTargetField("1716663",111,"LexmarkPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {114}; 
m_mapper.addTargetField("1716665",113,"BuyerLineItemNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {112}; 
m_mapper.addTargetField("1716669",115,"CustomerPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // BaseItemDetail 

m_mapper.addTargetRecord("_yAeEEFrAEd6fbbk7F5PhuA",116,"SerialNumbers",null,0,UNLIMITED); // SerialNumbers 

{ 
int[] sourceFieldIDs = {118}; 
m_mapper.addTargetField("_zQgIkFrAEd6fbbk7F5PhuA",117,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // SerialNumbers 

m_mapper.addTargetRecord("1716442",119,"OrderQuantities",null,1,1); // OrderQuantities 

m_mapper.addTargetRecord("1716452",120,"OrderedQuantity",null,0,1); // OrderedQuantity 

{ 
int[] sourceFieldIDs = {122}; 
m_mapper.addTargetField("1716548",121,"@unitOfMeasurement",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(121)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {124,23}; 
m_mapper.addTargetField("1716550",123,"*body",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(123)); 
} 
m_mapper.makeParentTheCurrentRecord(); // OrderedQuantity 
m_mapper.makeParentTheCurrentRecord(); // OrderQuantities 

m_mapper.addTargetRecord("1716454",125,"PricingDetail",null,0,1); // PricingDetail 

{ 
int[] sourceFieldIDs = {23,127,128,129,124}; 
m_mapper.addTargetField("1716558",126,"UnitPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(126)); 
} 

{ 
int[] sourceFieldIDs = {39}; 
m_mapper.addTargetField("1716560",130,"UnitPriceCurrency",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {23,128,127}; 
m_mapper.addTargetField("1716562",131,"ExtendedPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(131)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PricingDetail 

m_mapper.addTargetRecord("1716481",132,"TaxInformation",null,0,1); // TaxInformation 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716927",133,"TaxRateArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(133)); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716929",134,"TaxExplanation",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(134)); 
} 

{ 
int[] sourceFieldIDs = {136}; 
m_mapper.addTargetField("1716935",135,"TaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {138}; 
m_mapper.addTargetField("1716937",137,"StateTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {140}; 
m_mapper.addTargetField("1716939",139,"SecondaryStateTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {142}; 
m_mapper.addTargetField("1716941",141,"CityTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {144}; 
m_mapper.addTargetField("1716943",143,"SecondaryCityTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {146}; 
m_mapper.addTargetField("1716945",145,"CountyTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {148}; 
m_mapper.addTargetField("1716947",147,"SecondaryCountyTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {150}; 
m_mapper.addTargetField("1716949",149,"GSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {152}; 
m_mapper.addTargetField("1716951",151,"HSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {154}; 
m_mapper.addTargetField("1716953",153,"PSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {156}; 
m_mapper.addTargetField("1716955",155,"VATTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {158}; 
m_mapper.addTargetField("1716961",157,"TaxPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(157)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // TaxInformation 

m_mapper.addTargetRecord("1716479",159,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 
createTargetStructure2(); 
} 


/*********************************************************************/ 
private static final void createTargetStructure2() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

{ 
int[] sourceFieldIDs = {39}; 
m_mapper.addTargetField("1716913",160,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716458",161,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716470",162,"ShipmentInformation",null,0,1); // ShipmentInformation 

m_mapper.addTargetRecord("1716450",163,"ShipToInformation",null,0,1); // ShipToInformation 

{ 
int[] sourceFieldIDs = {68}; 
m_mapper.addTargetField("1716531",164,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {49}; 
m_mapper.addTargetField("1716533",165,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716456",166,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {72}; 
m_mapper.addTargetField("1716591",167,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {51,74}; 
m_mapper.addTargetField("1716595",168,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(168)); 
} 

{ 
int[] sourceFieldIDs = {53,76,74}; 
m_mapper.addTargetField("1716597",169,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(169)); 
} 

{ 
int[] sourceFieldIDs = {55,78,74}; 
m_mapper.addTargetField("1716599",170,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(170)); 
} 

{ 
int[] sourceFieldIDs = {82,59}; 
m_mapper.addTargetField("1716603",171,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(171)); 
} 

{ 
int[] sourceFieldIDs = {84,85,61,62}; 
m_mapper.addTargetField("1716605",172,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(172)); 
} 

{ 
int[] sourceFieldIDs = {80,57}; 
m_mapper.addTargetField("1716607",173,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(173)); 
} 

{ 
int[] sourceFieldIDs = {87,64}; 
m_mapper.addTargetField("1716609",174,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(174)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 
m_mapper.makeParentTheCurrentRecord(); // ShipmentInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716443",175,"RelatedObjectReference",null,0,1); // RelatedObjectReference 

{ 
int[] sourceFieldIDs = {177}; 
m_mapper.addTargetField("1716485",176,"SourceReferenceLineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // RelatedObjectReference 
m_mapper.makeParentTheCurrentRecord(); // Detail 

m_mapper.addTargetRecord("1716451",178,"RelatedObjectReferences",null,0,1); // RelatedObjectReferences 

{ 
int[] sourceFieldIDs = {180,94}; 
m_mapper.addTargetField("1716538",179,"CustomerPurchaseOrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(179)); 
} 

{ 
int[] sourceFieldIDs = {182,114}; 
m_mapper.addTargetField("1716540",181,"CustomerRequisitionNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(181)); 
} 

{ 
int[] sourceFieldIDs = {184}; 
m_mapper.addTargetField("1716544",183,"SourceReferenceNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {186}; 
m_mapper.addTargetField("1716546",185,"SourceReferenceDocumentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
return LXK_Siebel_CSSSOBillingInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical.class.getMethod("mappingRule_" + targetFieldID,PARAMETER_TYPES); 
} 


/*********************************************************************/ 
/* 
## WebMethods should generated a unique number for this field 
*/ 
public static final void mappingRule_3(TTransformControl transformControl) throws Exception 
{ 
//# WebMethods should generated a unique number for this field 
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
Move "Billing Invoice" to Target 
*/ 
public static final void mappingRule_6(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("Billing Invoice"); 
} 


/*********************************************************************/ 
/* 
Move "Billing Invoice Sales Order Request" to Target 
*/ 
public static final void mappingRule_7(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("Billing Invoice Sales Order Request"); 
} 


/*********************************************************************/ 
/* 
Move "New" to Target 
*/ 
public static final void mappingRule_12(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("New"); 
} 


/*********************************************************************/ 
/* 
Move CurrentDateTime to [tempDate] 
Call "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [tempDate] "yyyyMMddHHmmss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to [tempDate] with java 
Call "com.lxk.utils.DateConverter.ContivoDateConverter.timeZoneConverter" [tempDate] "yyyy-MM-dd'T'HH:mm:ss.SSS" "" "GMT" to Target with java 
*/ 
public static final void mappingRule_13(TTransformControl transformControl) throws Exception 
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
## Do a BCM lookup to determine if this field should a YES or NO 
## Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
## 
## This service uses the BCM tables: 
## BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
## BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
## 
## Pass 'Siebel' as the application name parameter 
## Pass the Siebel field AccountOrganizationName as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals US then set this field to YES 
## Else set this field to NO. 
## 
## Do this BCM lookup after calling the map and do not actually map the input field in the map 

Move "NO" to Target 
*/ 
public static final void mappingRule_15(TTransformControl transformControl) throws Exception 
{ 
//# Do a BCM lookup to determine if this field should a YES or NO 
//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
//# 
//# This service uses the BCM tables: 
//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
//# 
//# Pass 'Siebel' as the application name parameter 
//# Pass the Siebel field AccountOrganizationName as the applicatonOrganization parameter 
//# Leave the businessOrganization and BusinessLocation paramenters blank 
//# 
//# If the output of this service equals US then set this field to YES 
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
## Pass the Siebel field AccountOrganizationName as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals EMEA then set this field to YES 
## Else set this field to NO. 
## 
## Do this BCM lookup after calling the map and do not actually map the input field in the map 

Move "NO" to Target 
*/ 
public static final void mappingRule_19(TTransformControl transformControl) throws Exception 
{ 
//# Do a BCM lookup to determine if this field should a YES or NO 
//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
//# 
//# This service uses the BCM tables: 
//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
//# 
//# Pass 'Siebel' as the application name parameter 
//# Pass the Siebel field AccountOrganizationName as the applicatonOrganization parameter 
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
## Pass the Siebel field LXKSDSRPrimaryOrganization as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals APG then set this field to YES 
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
//# Pass the Siebel field LXKSDSRPrimaryOrganization as the applicatonOrganization parameter 
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
Move Source to Target 
*/ 
public static final void mappingRule_22(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(23), 22, 23)); 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Call "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
EndIf 
*/ 
public static final void mappingRule_24(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(25))) 
{ 
String sources [] = {transformControl.getSource(25),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
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
## FIELD TYPE CODE: REASON_CODE 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
*/ 
public static final void mappingRule_30(TTransformControl transformControl) throws Exception 
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
## From the getDocumentRoutingInfo service 
## map the BusinessLocation field to this field. 
## This service is called after the Contivo map is executed. 
*/ 
public static final void mappingRule_33(TTransformControl transformControl) throws Exception 
{ 
//# From the getDocumentRoutingInfo service 
//# map the BusinessLocation field to this field. 
//# This service is called after the Contivo map is executed. 
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
## Do this lookup prior to calling the map 

Move Source to Target 
*/ 
public static final void mappingRule_34(TTransformControl transformControl) throws Exception 
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
//# Do this lookup prior to calling the map 
transformControl.setTarget(transformControl.convert(transformControl.getSource(16), 34, 16)); 
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
public static final void mappingRule_38(TTransformControl transformControl) throws Exception 
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
Move BillToFirstName to [LTF_FullName] 
Append " " to [LTF_FullName] 
Append BillToLastName to [LTF_FullName] 
Move [LTF_FullName] to Target 
*/ 
public static final void mappingRule_44(TTransformControl transformControl) throws Exception 
{ 
String LTF_FullName = ""; 
LTF_FullName = new String(transformControl.getSource(45)); 
LTF_FullName = LTF_FullName.concat(" "); 
LTF_FullName = LTF_FullName.concat(transformControl.getSource(46)); 
transformControl.setTarget(new String(LTF_FullName)); 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Move Source to Target 
Else 
Move " " to Target 
EndIf 
*/ 
public static final void mappingRule_48(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(49))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(49), 48, 49)); 
} 
else 
{ 
transformControl.setTarget(" "); 
} 
} 


/*********************************************************************/ 
/* 
## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
## 
## Pass the following Parameters: 
## CATEGORY: UNIVERSAL 
## FIELD TYPE CODE: PROVINCE or STATE 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
## First lookup PROVINCE if the lookup returns nothing 
## Then loopkup based on STATE. 

If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] to Target 
EndIf 
*/ 
public static final void mappingRule_60(TTransformControl transformControl) throws Exception 
{ 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: PROVINCE or STATE 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
//# First lookup PROVINCE if the lookup returns nothing 
//# Then loopkup based on STATE. 
if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 60, 62)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 60, 61)); 
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
## FIELD TYPE CODE: COUNTRY 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
*/ 
public static final void mappingRule_63(TTransformControl transformControl) throws Exception 
{ 
//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
//# 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: COUNTRY 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Move Source to Target 
Else 
Move " " to Target 
EndIf 
*/ 
public static final void mappingRule_69(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(49))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(49), 69, 49)); 
} 
else 
{ 
transformControl.setTarget(" "); 
} 
} 


/*********************************************************************/ 
/* 
If Source Exists 
Move Source to Target 
Else 
Move " " to Target 
EndIf 
*/ 
public static final void mappingRule_71(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(72))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(72), 71, 72)); 
} 
else 
{ 
transformControl.setTarget(" "); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 
EndIf 
*/ 
public static final void mappingRule_73(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(74), 73, 74)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(51), 73, 51)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress2] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
EndIf 
*/ 
public static final void mappingRule_75(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 75, 76)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(53), 75, 53)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress3] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress3] to Target 
EndIf 
*/ 
public static final void mappingRule_77(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(78), 77, 78)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(55), 77, 55)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToPostalCode] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToPostalCode] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
EndIf 
*/ 
public static final void mappingRule_79(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 79, 80)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 79, 57)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCity] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCity] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
EndIf 
*/ 
public static final void mappingRule_81(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(82))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(82), 81, 82)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(59), 81, 59)); 
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
## FIELD TYPE CODE: PROVINCE or STATE 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
## First lookup PROVINCE if the lookup returns nothing 
## Then loopkup based on STATE. 

If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToProvince] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToProvince] to Target 
Else If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToState] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToState] to Target 
Else If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] to Target 
EndIf 
*/ 
public static final void mappingRule_83(TTransformControl transformControl) throws Exception 
{ 
//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
//# 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: PROVINCE or STATE 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
//# First lookup PROVINCE if the lookup returns nothing 
//# Then loopkup based on STATE. 
if (Compare.exists(transformControl.getSource(85))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(85), 83, 85)); 
} 
else if (Compare.exists(transformControl.getSource(84))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 83, 84)); 
} 
else if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 83, 62)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 83, 61)); 
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
## FIELD TYPE CODE: COUNTRY 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 

If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCountry] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCountry] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 
EndIf 
*/ 
public static final void mappingRule_86(TTransformControl transformControl) throws Exception 
{ 
//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
//# 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: COUNTRY 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
if (Compare.exists(transformControl.getSource(87))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 86, 87)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(64), 86, 64)); 
} 
} 


/*********************************************************************/ 
/* 
Move " " To Target 
*/ 
public static final void mappingRule_89(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget(" "); 
} 


/*********************************************************************/ 
/* 
If TypeCode = "Credit" 
If PaymentTerm Exists 
Move PaymentTerm to Target 
Else 
Move "Net 30 Days" to Target 
EndIf 
Else 
Move PaymentTerm to Target 
EndIf 

## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
## 
## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
## 
## Pass the following Parameters: 
## CATEGORY: UNIVERSAL 
## FIELD TYPE CODE: PAYMENT_TERMS 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
*/ 
public static final void mappingRule_91(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(23), "Credit")) 
{ 
if (Compare.exists(transformControl.getSource(92))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(92), 91, 92)); 
} 
else 
{ 
transformControl.setTarget("Net 30 Days"); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(92), 91, 92)); 
} 
//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
//# 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: PAYMENT_TERMS 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
} 


/*********************************************************************/ 
/* 
## Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
## 
## This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
## 
## Pass the following Parameters: 
## CATEGORY: UNIVERSAL 
## FIELD TYPE CODE: PAYMENT_METHOD 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
*/ 
public static final void mappingRule_93(TTransformControl transformControl) throws Exception 
{ 
//# Use the BCM adapter service LXKBCM.pub:translate in the LXKBCM package 
//# 
//# This service uses the BCM table BCMMGR.BCM_UNVRSL_VALUES_LKUP_L 
//# 
//# Pass the following Parameters: 
//# CATEGORY: UNIVERSAL 
//# FIELD TYPE CODE: PAYMENT_METHOD 
//# APPLICATION VALUE: Field mapped to this field 
//# APPLICATION NAME: SIEBEL 
//# GEOGRAPHY CODE: WW 
//# UNIVERSAL CODE: leave blank 
//# 
//# Do this lookup prior to calling the map 
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
public static final void mappingRule_121(TTransformControl transformControl) throws Exception 
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
If TypeCode = "Credit" 
Compute Target = -1 * Quantity 
Else 
Move Quantity to Target 
EndIf 
*/ 
public static final void mappingRule_123(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(23), "Credit")) 
{ 
transformControl.setTargetNumber(-1.0 * transformControl.getSourceNumber(124)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(124), 123, 124)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|TypeCode] = "Credit" 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|Amount] = [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|LXKCJDEExtAmt-SO] 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|LXKCItemPrice-SO] to Target 
Else 
Compute Target = [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|Amount] / [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|Quantity] 
EndIf 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|ListOfLxkCFsInvoiceLineItemDetails|LxkCFsInvoiceLineItemDetails|LXKCItemPrice-SO] to Target 
EndIf 
*/ 
public static final void mappingRule_126(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(23), "Credit")) 
{ 
if (Compare.equals(transformControl.getSource(127), transformControl.getSource(128))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(129), 126, 129)); 
} 
else 
{ 
transformControl.setTargetNumber(transformControl.getSourceNumber(127) / transformControl.getSourceNumber(124)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(129), 126, 129)); 
} 
} 


/*********************************************************************/ 
/* 
If TypeCode = "Credit" 
Move Amount to Target 
Else 
Move LXKCJDEExtAmt-SO to Target 
EndIf 
*/ 
public static final void mappingRule_131(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(23), "Credit")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(127), 131, 127)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(128), 131, 128)); 
} 
} 


/*********************************************************************/ 
/* 
Move "EXEMPT" to Target 
*/ 
public static final void mappingRule_133(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("EXEMPT"); 
} 


/*********************************************************************/ 
/* 
Move "ZZ" to Target 
*/ 
public static final void mappingRule_134(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("ZZ"); 
} 


/*********************************************************************/ 
/* 
## Verify with Tim that this is the correct field 
*/ 
public static final void mappingRule_157(TTransformControl transformControl) throws Exception 
{ 
//# Verify with Tim that this is the correct field 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 
EndIf 
*/ 
public static final void mappingRule_168(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(74), 168, 74)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(51), 168, 51)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress2] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
EndIf 
*/ 
public static final void mappingRule_169(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 169, 76)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(53), 169, 53)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToAddress3] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress3] to Target 
EndIf 
*/ 
public static final void mappingRule_170(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(74))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(78), 170, 78)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(55), 170, 55)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCity] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCity] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
EndIf 
*/ 
public static final void mappingRule_171(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(82))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(82), 171, 82)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(59), 171, 59)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToProvince] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToProvince] to Target 
Else If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToState] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToState] to Target 
Else If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] to Target 
EndIf 
*/ 
public static final void mappingRule_172(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(85))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(85), 172, 85)); 
} 
else if (Compare.exists(transformControl.getSource(84))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(84), 172, 84)); 
} 
else if (Compare.exists(transformControl.getSource(62))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(62), 172, 62)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(61), 172, 61)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToPostalCode] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToPostalCode] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
EndIf 
*/ 
public static final void mappingRule_173(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 173, 80)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 173, 57)); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCountry] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDOrderSRShipToCountry] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 
EndIf 
*/ 
public static final void mappingRule_174(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(87))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(87), 174, 87)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(64), 174, 64)); 
} 
} 


/*********************************************************************/ 
/* 
If LXKCPaymentMethod = "Purchase Order" 
Move LXKCPONumber to Target 
Else 
Move "" to Target 
EndIf 
*/ 
public static final void mappingRule_179(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(94), "Purchase Order")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(180), 179, 180)); 
} 
else 
{ 
transformControl.setTarget(""); 
} 
} 


/*********************************************************************/ 
/* 
If [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|SRNumber] Exists 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|SRNumber] to Target 
Else 
Move [BillingInvoiceOutboundDTD|SiebelMessage|ListOfLxkCFsInvoice|LxkCFsInvoice|Id] to Target 
EndIf 
*/ 
public static final void mappingRule_181(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(182))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(182), 181, 182)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(114), 181, 114)); 
} 
} 

private static final String[] restTable0() 
{ 
return new String[] { 
"Change", "New", "Delete"}; 
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

