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
Class: LXK_Siebel_CSSAgreementInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical 
Date: 2012-10-26-05:00 
Author: Contivo Analyst Transform Writer Version 3.11.2.1.8a 
Purpose: This service unit provides data transformation for the mapping matrix "LXK_Siebel_CSSAgreementInvoice_v1.0_to_LXK_SalesOrderRequest_v1.0_Canonical". 
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



public final class LXK_Siebel_CSSAgreementInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical 
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
private static final String TRANSFORM_NAME = "LXK_Siebel_CSSAgreementInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical"; 
private static final Class[] PARAMETER_TYPES = {com.contivo.runtime.core.TTransformControl.class}; 


static 
{ 
try 
{ 
m_mapper = new TMapper(LXK_Siebel_CSSAgreementInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical.class,TRANSFORM_NAME,"transform",207); 
m_mapper.setTimeStamp("2012-10-26 10:02:33 EDT"); 
m_mapper.setTargetEncoding("UTF-8"); 
m_mapper.setBigDecimalProcessing(false); 
m_sourceObjectNames = new Vector(); 
m_isWmEsourceObject = new Vector(); 
m_sourceObjectNames.add("ScheduledInvoiceOutboundDTD"); 
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

m_mapper.addSourceRecord("_3XRb4F6WEd--1tNnGJL5Cw",10,"SiebelMessage",null,0,1); // SiebelMessage 
m_mapper.setXMLInputProcessing(true); 
{ 
m_mapper.addSourceField("_3XRb716WEd--1tNnGJL5Cw",9,"@MessageId",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_3XRb4V6WEd--1tNnGJL5Cw",20,"ListOfLxkCServiceAgreementEai",null,1,UNLIMITED); // ListOfLxkCServiceAgreementEai 

m_mapper.addSourceRecord("_3XRb4l6WEd--1tNnGJL5Cw",19,"LxkCServiceAgreementEai",null,0,UNLIMITED); // LxkCServiceAgreementEai 

{ 
m_mapper.addSourceField("_3XRcAF6WEd--1tNnGJL5Cw",96,"LXKCMinimumStartDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XRcAV6WEd--1tNnGJL5Cw",98,"LXKCMaximumEndDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

m_mapper.addSourceRecord("_3XRb416WEd--1tNnGJL5Cw",18,"ListOfLxkCFsInvoice",null,0,1); // ListOfLxkCFsInvoice 

m_mapper.addSourceRecord("_3XRb5F6WEd--1tNnGJL5Cw",17,"LxkCFsInvoice",null,0,UNLIMITED); // LxkCFsInvoice 

{ 
m_mapper.addSourceField("_3XRcBl6WEd--1tNnGJL5Cw",122,"Id",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XRcD16WEd--1tNnGJL5Cw",55,"AccountName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XRcEl6WEd--1tNnGJL5Cw",76,"LXKUPAgreementAccountName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XRcGV6WEd--1tNnGJL5Cw",16,"AgreementOrganizationName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM4l6WEd--1tNnGJL5Cw",51,"BillToFirstName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM416WEd--1tNnGJL5Cw",52,"BillToLastName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM6l6WEd--1tNnGJL5Cw",40,"CreatedByName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM7F6WEd--1tNnGJL5Cw",110,"CreditCardAuthorizationCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM916WEd--1tNnGJL5Cw",108,"CreditCardNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbM-l6WEd--1tNnGJL5Cw",45,"CurrencyCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNAF6WEd--1tNnGJL5Cw",27,"InvoiceDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNBl6WEd--1tNnGJL5Cw",42,"LXKCAgreementNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNB16WEd--1tNnGJL5Cw",29,"LXKCAgreementPrintComments",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNCl6WEd--1tNnGJL5Cw",48,"LXKCBillToAddressJDENumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNDV6WEd--1tNnGJL5Cw",74,"LXKCShipToAddressJDENumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbND16WEd--1tNnGJL5Cw",115,"LXKCALILineNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNEF6WEd--1tNnGJL5Cw",35,"LXKCCancelReason",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNEl6WEd--1tNnGJL5Cw",117,"LXKCALIComments",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNFF6WEd--1tNnGJL5Cw",141,"LXKCInvoiceDayCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNFl6WEd--1tNnGJL5Cw",204,"LXKCPONumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNF16WEd--1tNnGJL5Cw",104,"LXKCPaymentMethod",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNGV6WEd--1tNnGJL5Cw",206,"LXKCSpecialBidNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNI16WEd--1tNnGJL5Cw",102,"LXKCPaymentTerm",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNMl6WEd--1tNnGJL5Cw",31,"TotalAmount",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNNF6WEd--1tNnGJL5Cw",25,"TypeCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNNV6WEd--1tNnGJL5Cw",33,"LXKSDCancelDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNNl6WEd--1tNnGJL5Cw",57,"LXKSDBillToAddress",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNN16WEd--1tNnGJL5Cw",59,"LXKSDBillToAddress2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNOF6WEd--1tNnGJL5Cw",61,"LXKSDBillToAddress3",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNOV6WEd--1tNnGJL5Cw",65,"LXKSDBillToCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNOl6WEd--1tNnGJL5Cw",70,"LXKSDBillToCountry",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNO16WEd--1tNnGJL5Cw",63,"LXKSDBillToPostalCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNPF6WEd--1tNnGJL5Cw",67,"LXKSDBillToProvince",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNPV6WEd--1tNnGJL5Cw",68,"LXKSDBillToState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNPl6WEd--1tNnGJL5Cw",80,"LXKSDAgreementAcctShipToAddress",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNP16WEd--1tNnGJL5Cw",82,"LXKSDAgreementAcctShipToAddress2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNQF6WEd--1tNnGJL5Cw",84,"LXKSDAgreementAcctShipToAddress3",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNQV6WEd--1tNnGJL5Cw",88,"LXKSDAgreementAcctShipToCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNQl6WEd--1tNnGJL5Cw",93,"LXKSDAgreementAcctShipToCountry",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNQ16WEd--1tNnGJL5Cw",86,"LXKSDAgreementAcctShipToPostalCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNRF6WEd--1tNnGJL5Cw",90,"LXKSDAgreementAcctShipToProvince",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNRV6WEd--1tNnGJL5Cw",91,"LXKSDAgreementAcctShipToState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNRl6WEd--1tNnGJL5Cw",106,"LXKSDPaymentType",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 
createSourceStructure1(); 
} 


/*********************************************************************/ 
private static final void createSourceStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

m_mapper.addSourceRecord("_3XRb5V6WEd--1tNnGJL5Cw",113,"ListOfLxkCFsInvoiceLineItems",null,0,1); // ListOfLxkCFsInvoiceLineItems 

m_mapper.addSourceRecord("_3XRb5l6WEd--1tNnGJL5Cw",112,"LxkCFsInvoiceLineItems",null,0,UNLIMITED); // LxkCFsInvoiceLineItems 

{ 
m_mapper.addSourceField("_3XbNS16WEd--1tNnGJL5Cw",201,"Id",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNUl6WEd--1tNnGJL5Cw",136,"Amount2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNWV6WEd--1tNnGJL5Cw",138,"LXKCItemPrice",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNWl6WEd--1tNnGJL5Cw",137,"LXKCJDEExtAmount",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNXF6WEd--1tNnGJL5Cw",142,"LXKCNRCLineAmount",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNX16WEd--1tNnGJL5Cw",131,"LXKCProductUnitofMeasure",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNYF6WEd--1tNnGJL5Cw",127,"LXKCSerialNumber",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNYV6WEd--1tNnGJL5Cw",153,"LXKCTaxCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNYl6WEd--1tNnGJL5Cw",194,"LXKSDAgreementItemEndDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNY16WEd--1tNnGJL5Cw",196,"LXKSDAgreementItemStartDate",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNZF6WEd--1tNnGJL5Cw",177,"LXKSDAssetInstalledAtAddr1",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNZV6WEd--1tNnGJL5Cw",180,"LXKSDAssetInstalledAtAddr2",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNZ16WEd--1tNnGJL5Cw",182,"LXKSDAssetInstalledAtCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNaF6WEd--1tNnGJL5Cw",189,"LXKSDAssetInstalledAtCountry",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNaV6WEd--1tNnGJL5Cw",191,"LXKSDAssetInstalledAtCounty",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNal6WEd--1tNnGJL5Cw",187,"LXKSDAssetInstalledAtZipCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNa16WEd--1tNnGJL5Cw",184,"LXKSDAssetInstalledAtProvince",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNbF6WEd--1tNnGJL5Cw",185,"LXKSDAssetInstalledAtState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNbV6WEd--1tNnGJL5Cw",157,"LXKCTaxCounty",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNbl6WEd--1tNnGJL5Cw",147,"LXKCTaxFederal",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNb16WEd--1tNnGJL5Cw",155,"LXKCTaxSecondaryCity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNcF6WEd--1tNnGJL5Cw",159,"LXKCTaxSecondaryCounty",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNcV6WEd--1tNnGJL5Cw",151,"LXKCTaxSecondaryState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNcl6WEd--1tNnGJL5Cw",149,"LXKCTaxState",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNdV6WEd--1tNnGJL5Cw",133,"LineQuantity",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNeF6WEd--1tNnGJL5Cw",120,"ProductName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNfl6WEd--1tNnGJL5Cw",124,"LXKSDCoveredAssetProductName",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNf16WEd--1tNnGJL5Cw",169,"LXKSDAssetInstalledAtPostalCode",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNgF6WEd--1tNnGJL5Cw",161,"LXKSDTaxGST",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNgV6WEd--1tNnGJL5Cw",163,"LXKSDTaxHST",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNgl6WEd--1tNnGJL5Cw",165,"LXKSDTaxPST",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 

{ 
m_mapper.addSourceField("_3XbNg16WEd--1tNnGJL5Cw",167,"LXKSDTaxVAT",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,9,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // LxkCFsInvoiceLineItems 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCFsInvoiceLineItems 
m_mapper.makeParentTheCurrentRecord(); // LxkCFsInvoice 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCFsInvoice 
m_mapper.makeParentTheCurrentRecord(); // LxkCServiceAgreementEai 
m_mapper.makeParentTheCurrentRecord(); // ListOfLxkCServiceAgreementEai 
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
m_mapper.addTargetField("1716921",21,"EMEA",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(21)); 
m_mapper.setDefaultValue("YES", false); 
m_mapper.addTableToField(2); 
} 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716924",22,"APG",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(22)); 
m_mapper.setDefaultValue("YES", false); 
m_mapper.addTableToField(3); 
} 
m_mapper.makeParentTheCurrentRecord(); // RelevantGeographies 
m_mapper.makeParentTheCurrentRecord(); // DocumentMetaData 

m_mapper.addTargetRecord("1716469",23,"Header",null,0,1); // Header 

{ 
int[] sourceFieldIDs = {25}; 
m_mapper.addTargetField("1716768",24,"OrderType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(24)); 
} 

{ 
int[] sourceFieldIDs = {27}; 
m_mapper.addTargetField("1716770",26,"OrderDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(26)); 
} 

{ 
int[] sourceFieldIDs = {29}; 
m_mapper.addTargetField("1716780",28,"OrderComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {31}; 
m_mapper.addTargetField("1716782",30,"OrderTotalAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {33}; 
m_mapper.addTargetField("1716792",32,"CanceledDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(32)); 
} 

{ 
int[] sourceFieldIDs = {35}; 
m_mapper.addTargetField("1716795",34,"ReturnReason",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(34)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("1716468",36,"LexmarkOrderInformation",null,0,1); // LexmarkOrderInformation 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716756",37,"BusinessOrganization",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(37)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {16}; 
m_mapper.addTargetField("1716758",38,"InternalCompanyId",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(38)); 
} 

{ 
int[] sourceFieldIDs = {40}; 
m_mapper.addTargetField("1716762",39,"OrderEnteredBy",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {42}; 
m_mapper.addTargetField("1716766",41,"AgreementNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // LexmarkOrderInformation 

m_mapper.addTargetRecord("1716446",43,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 

{ 
int[] sourceFieldIDs = {45}; 
m_mapper.addTargetField("1716499",44,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(44)); 
m_mapper.setRuleCommentOnly(); 
} 

m_mapper.addTargetRecord("1716453",46,"BillToInformation",null,0,1); // BillToInformation 

{ 
int[] sourceFieldIDs = {48}; 
m_mapper.addTargetField("1716552",47,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716444",49,"ContactInformation",null,0,1); // ContactInformation 

{ 
int[] sourceFieldIDs = {51,52}; 
m_mapper.addTargetField("1716487",50,"ContactName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(50)); 
} 
m_mapper.makeParentTheCurrentRecord(); // ContactInformation 

m_mapper.addTargetRecord("1716471",53,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {55}; 
m_mapper.addTargetField("1716809",54,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {57}; 
m_mapper.addTargetField("1716813",56,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {59}; 
m_mapper.addTargetField("1716815",58,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {61}; 
m_mapper.addTargetField("1716817",60,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {63}; 
m_mapper.addTargetField("1716821",62,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {65}; 
m_mapper.addTargetField("1716823",64,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {67,68}; 
m_mapper.addTargetField("1716825",66,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(66)); 
} 

{ 
int[] sourceFieldIDs = {70}; 
m_mapper.addTargetField("1716827",69,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(69)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // BillToInformation 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716473",71,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716466",72,"ShipToInformation",null,0,1); // ShipToInformation 

{ 
int[] sourceFieldIDs = {74}; 
m_mapper.addTargetField("1716723",73,"PartyIdentifier",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {76}; 
m_mapper.addTargetField("1716725",75,"PartyName",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716467",77,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {76}; 
m_mapper.addTargetField("1716729",78,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {80}; 
m_mapper.addTargetField("1716733",79,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(79)); 
m_mapper.setRuleCommentOnly(); 
} 
createTargetStructure1(); 
} 


/*********************************************************************/ 
private static final void createTargetStructure1() throws NoSuchMethodException, SecurityException, TStructuredRuntimeException 
{ 

{ 
int[] sourceFieldIDs = {82}; 
m_mapper.addTargetField("1716735",81,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(81)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {84}; 
m_mapper.addTargetField("1716737",83,"AddressLine3",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(83)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {86}; 
m_mapper.addTargetField("1716741",85,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(85)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {88}; 
m_mapper.addTargetField("1716743",87,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(87)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {90,91}; 
m_mapper.addTargetField("1716745",89,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(89)); 
} 

{ 
int[] sourceFieldIDs = {93}; 
m_mapper.addTargetField("1716747",92,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(92)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 

m_mapper.addTargetRecord("1716465",94,"DeliveryInformation",null,0,1); // DeliveryInformation 

{ 
int[] sourceFieldIDs = {96}; 
m_mapper.addTargetField("1716705",95,"EarliestDeliveryDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(95)); 
} 

{ 
int[] sourceFieldIDs = {98}; 
m_mapper.addTargetField("1716708",97,"LatestDeliveryDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(97)); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716711",99,"DeliveryMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(99)); 
} 
m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716472",100,"PaymentInformation",null,0,1); // PaymentInformation 

{ 
int[] sourceFieldIDs = {25,102}; 
m_mapper.addTargetField("1716836",101,"PaymentTerms",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(101)); 
} 

{ 
int[] sourceFieldIDs = {104}; 
m_mapper.addTargetField("1716838",103,"PaymentMethod",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(103)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {106}; 
m_mapper.addTargetField("6544890",105,"PaymentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {108}; 
m_mapper.addTargetField("1716840",107,"CardLast4Digits",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {110}; 
m_mapper.addTargetField("1716848",109,"CardAuthorizationCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // PaymentInformation 
m_mapper.makeParentTheCurrentRecord(); // Header 

int[][] loopAssociatedSourceIDs111 = {{17,112}}; 

m_mapper.addTargetRecord("1716474",111,"Detail",null,0,UNLIMITED,loopAssociatedSourceIDs111); // Detail 

{ 
int[] sourceFieldIDs = {115}; 
m_mapper.addTargetField("1716861",114,"LineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {117}; 
m_mapper.addTargetField("1716880",116,"LineComment",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

m_mapper.addTargetRecord("1716461",118,"BaseItemDetail",null,1,1); // BaseItemDetail 

{ 
int[] sourceFieldIDs = {120}; 
m_mapper.addTargetField("1716663",119,"LexmarkPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {122}; 
m_mapper.addTargetField("1716665",121,"BuyerLineItemNum",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {124}; 
m_mapper.addTargetField("1716669",123,"CustomerPartNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // BaseItemDetail 

m_mapper.addTargetRecord("_yAeEEFrAEd6fbbk7F5PhuA",125,"SerialNumbers",null,0,UNLIMITED); // SerialNumbers 

{ 
int[] sourceFieldIDs = {127}; 
m_mapper.addTargetField("_zQgIkFrAEd6fbbk7F5PhuA",126,"SerialNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // SerialNumbers 

m_mapper.addTargetRecord("1716442",128,"OrderQuantities",null,1,1); // OrderQuantities 

m_mapper.addTargetRecord("1716452",129,"OrderedQuantity",null,0,1); // OrderedQuantity 

{ 
int[] sourceFieldIDs = {131}; 
m_mapper.addTargetField("1716548",130,"@unitOfMeasurement",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(130)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {133,25}; 
m_mapper.addTargetField("1716550",132,"*body",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(132)); 
} 
m_mapper.makeParentTheCurrentRecord(); // OrderedQuantity 
m_mapper.makeParentTheCurrentRecord(); // OrderQuantities 

m_mapper.addTargetRecord("1716454",134,"PricingDetail",null,0,1); // PricingDetail 

{ 
int[] sourceFieldIDs = {25,136,137,138,133}; 
m_mapper.addTargetField("1716558",135,"UnitPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(135)); 
} 

{ 
int[] sourceFieldIDs = {45}; 
m_mapper.addTargetField("1716560",139,"UnitPriceCurrency",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(139)); 
m_mapper.setRuleCommentOnly(); 
} 

{ 
int[] sourceFieldIDs = {141,25,137,142,136}; 
m_mapper.addTargetField("1716562",140,"ExtendedPrice",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(140)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PricingDetail 

m_mapper.addTargetRecord("1716481",143,"TaxInformation",null,0,1); // TaxInformation 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716927",144,"TaxRateArea",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(144)); 
} 

{ 
int[] sourceFieldIDs = {}; 
m_mapper.addTargetField("1716929",145,"TaxExplanation",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(145)); 
} 

{ 
int[] sourceFieldIDs = {147}; 
m_mapper.addTargetField("1716935",146,"TaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {149}; 
m_mapper.addTargetField("1716937",148,"StateTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {151}; 
m_mapper.addTargetField("1716939",150,"SecondaryStateTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {153}; 
m_mapper.addTargetField("1716941",152,"CityTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {155}; 
m_mapper.addTargetField("1716943",154,"SecondaryCityTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {157}; 
m_mapper.addTargetField("1716945",156,"CountyTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {159}; 
m_mapper.addTargetField("1716947",158,"SecondaryCountyTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {161}; 
m_mapper.addTargetField("1716949",160,"GSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {163}; 
m_mapper.addTargetField("1716951",162,"HSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
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
int[] sourceFieldIDs = {165}; 
m_mapper.addTargetField("1716953",164,"PSTTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {167}; 
m_mapper.addTargetField("1716955",166,"VATTaxAmount",null,2,25, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 

{ 
int[] sourceFieldIDs = {169}; 
m_mapper.addTargetField("1716961",168,"TaxPostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // TaxInformation 

m_mapper.addTargetRecord("1716479",170,"CustomerOrderInformation",null,0,1); // CustomerOrderInformation 

{ 
int[] sourceFieldIDs = {45}; 
m_mapper.addTargetField("1716913",171,"CustomerCurrencyCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(171)); 
m_mapper.setRuleCommentOnly(); 
} 
m_mapper.makeParentTheCurrentRecord(); // CustomerOrderInformation 

m_mapper.addTargetRecord("1716458",172,"OrderFulfillmentInformation",null,0,1); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716470",173,"ShipmentInformation",null,0,1); // ShipmentInformation 

m_mapper.addTargetRecord("1716450",174,"ShipToInformation",null,0,1); // ShipToInformation 

m_mapper.addTargetRecord("1716456",175,"PhysicalAddress",null,0,1); // PhysicalAddress 

{ 
int[] sourceFieldIDs = {177,76,80,55,16}; 
m_mapper.addTargetField("1716591",176,"Name1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(176)); 
} 

{ 
int[] sourceFieldIDs = {177,80,55,76,57,16}; 
m_mapper.addTargetField("1716595",178,"AddressLine1",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(178)); 
} 

{ 
int[] sourceFieldIDs = {180,82,55,76,59,16}; 
m_mapper.addTargetField("1716597",179,"AddressLine2",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(179)); 
} 

{ 
int[] sourceFieldIDs = {182,88,55,76,65,16}; 
m_mapper.addTargetField("1716603",181,"City",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
1,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(181)); 
} 

{ 
int[] sourceFieldIDs = {184,185,90,91,55,76,67,68,16}; 
m_mapper.addTargetField("1716605",183,"StateOrProvince",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(183)); 
} 

{ 
int[] sourceFieldIDs = {187,86,55,76,63,16}; 
m_mapper.addTargetField("1716607",186,"PostalCode",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(186)); 
} 

{ 
int[] sourceFieldIDs = {189,93,55,76,70,16}; 
m_mapper.addTargetField("1716609",188,"Country",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(188)); 
} 

{ 
int[] sourceFieldIDs = {191,16,55,76}; 
m_mapper.addTargetField("1716611",190,"County",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
1,3,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(190)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PhysicalAddress 
m_mapper.makeParentTheCurrentRecord(); // ShipToInformation 
m_mapper.makeParentTheCurrentRecord(); // ShipmentInformation 

m_mapper.addTargetRecord("1716447",192,"DeliveryInformation",null,0,1); // DeliveryInformation 

{ 
int[] sourceFieldIDs = {194,98}; 
m_mapper.addTargetField("1716505",193,"OriginalCustomerRequestedDeliveryToDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(193)); 
} 

{ 
int[] sourceFieldIDs = {196,96}; 
m_mapper.addTargetField("1716508",195,"OriginalCustomerRequestedDeliveryFromDate",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(195)); 
} 
m_mapper.makeParentTheCurrentRecord(); // DeliveryInformation 
m_mapper.makeParentTheCurrentRecord(); // OrderFulfillmentInformation 

m_mapper.addTargetRecord("1716464",197,"PaymentInformation",null,0,1); // PaymentInformation 

{ 
int[] sourceFieldIDs = {141}; 
m_mapper.addTargetField("304552",198,"PaymentScheduleIndicator",null,1,203, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(198)); 
} 
m_mapper.makeParentTheCurrentRecord(); // PaymentInformation 

m_mapper.addTargetRecord("1716443",199,"RelatedObjectReference",null,0,1); // RelatedObjectReference 

{ 
int[] sourceFieldIDs = {201}; 
m_mapper.addTargetField("1716485",200,"SourceReferenceLineNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,null); 
} 
m_mapper.makeParentTheCurrentRecord(); // RelatedObjectReference 
m_mapper.makeParentTheCurrentRecord(); // Detail 

m_mapper.addTargetRecord("1716451",202,"RelatedObjectReferences",null,0,1); // RelatedObjectReferences 

{ 
int[] sourceFieldIDs = {204,104}; 
m_mapper.addTargetField("1716538",203,"CustomerPurchaseOrderNumber",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(203)); 
} 

{ 
int[] sourceFieldIDs = {206}; 
m_mapper.addTargetField("1716546",205,"SourceReferenceDocumentType",null,1,200, // groupID, ID, Name, Namespace, Interpretation, Presentation 
0,UNLIMITED,1,' ',0, // minSize, maxSize, whitespaceProcessing, padCharacter, decimalPlaces 
0,1, // Min, Max occur. 
sourceFieldIDs,null,null,buildMethodReflection(205)); 
m_mapper.setRuleCommentOnly(); 
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
return LXK_Siebel_CSSAgreementInvoice_v10_to_LXK_SalesOrderRequest_v10_Canonical.class.getMethod("mappingRule_" + targetFieldID,PARAMETER_TYPES); 
} 


/*********************************************************************/ 
/* 
## WebMethods should generate this unique ID 
*/ 
public static final void mappingRule_3(TTransformControl transformControl) throws Exception 
{ 
//# WebMethods should generate this unique ID 
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
Move "CSS Agreement" to Target 
*/ 
public static final void mappingRule_6(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("CSS Agreement"); 
} 


/*********************************************************************/ 
/* 
Move "Agreement Invoice Sales Order Request" to Target 
*/ 
public static final void mappingRule_7(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("Agreement Invoice Sales Order Request"); 
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
## Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals US then set this field to YES 
## Else set this field to NO. 
## 
## Do this BCM lookup after calling the map and do not actually map the input field in the map 
MOVE "NO" to Target 
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
//# Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
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
## Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals EMEA then set this field to YES 
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
//# Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
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
## Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
## Leave the businessOrganization and BusinessLocation paramenters blank 
## 
## If the output of this service equals APG then set this field to YES 
## Else set this field to NO. 
## 
## Do this BCM lookup after calling the map and do not actually map the input field in the map 
MOVE "NO" to Target 
*/ 
public static final void mappingRule_22(TTransformControl transformControl) throws Exception 
{ 
//# Do a BCM lookup to determine if this field should a YES or NO 
//# Call the BCM adapter service LXKBCM.pub:getGeography in LXKBCM package 
//# 
//# This service uses the BCM tables: 
//# BCMMGR.BCM_UNVRSL_VALUES_LKUP_L and 
//# BCMMGR.BCM_BUSNS_ORG_GEOGRAPHY_L 
//# 
//# Pass 'Siebel' as the application name parameter 
//# Pass the Siebel field AgreementOrganizationName as the applicatonOrganization parameter 
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
public static final void mappingRule_24(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(25), 24, 25)); 
} 


/*********************************************************************/ 
/* 
IF Source Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_26(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(27))) 
{ 
String sources [] = {transformControl.getSource(27),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
} 
} 


/*********************************************************************/ 
/* 
IF Source Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_32(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(33))) 
{ 
String sources [] = {transformControl.getSource(33),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
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
public static final void mappingRule_34(TTransformControl transformControl) throws Exception 
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
## Map the result field Business Location from the 
## getDocumentRoutingInfo service to this field. 
*/ 
public static final void mappingRule_37(TTransformControl transformControl) throws Exception 
{ 
//# Map the result field Business Location from the 
//# getDocumentRoutingInfo service to this field. 
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
public static final void mappingRule_38(TTransformControl transformControl) throws Exception 
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
transformControl.setTarget(transformControl.convert(transformControl.getSource(16), 38, 16)); 
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
public static final void mappingRule_44(TTransformControl transformControl) throws Exception 
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
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|BillToFirstName] to [LTF_FullName] 
APPEND " " to [LTF_FullName] 
APPEND [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|BillToLastName] to [LTF_FullName] 
MOVE [LTF_FullName] to Target 
*/ 
public static final void mappingRule_50(TTransformControl transformControl) throws Exception 
{ 
String LTF_FullName = ""; 
LTF_FullName = new String(transformControl.getSource(51)); 
LTF_FullName = LTF_FullName.concat(" "); 
LTF_FullName = LTF_FullName.concat(transformControl.getSource(52)); 
transformControl.setTarget(new String(LTF_FullName)); 
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

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] to Target 
Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] to Target 
EndIf 
*/ 
public static final void mappingRule_66(TTransformControl transformControl) throws Exception 
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
if (Compare.exists(transformControl.getSource(67))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 66, 67)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(68), 66, 68)); 
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
public static final void mappingRule_69(TTransformControl transformControl) throws Exception 
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
#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 
#Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] to Target 
#EndIf 
*/ 
public static final void mappingRule_79(TTransformControl transformControl) throws Exception 
{ 
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 
//Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] to Target 
//EndIf 
} 


/*********************************************************************/ 
/* 
#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
#Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] to Target 
#EndIf 
*/ 
public static final void mappingRule_81(TTransformControl transformControl) throws Exception 
{ 
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
//Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] to Target 
//EndIf 
} 


/*********************************************************************/ 
/* 
#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress3] to Target 
#Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress3] to Target 
#EndIf 
*/ 
public static final void mappingRule_83(TTransformControl transformControl) throws Exception 
{ 
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress3] to Target 
//Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress3] to Target 
//EndIf 
} 


/*********************************************************************/ 
/* 
#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
#Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] to Target 
#EndIf 
*/ 
public static final void mappingRule_85(TTransformControl transformControl) throws Exception 
{ 
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
//Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] to Target 
//EndIf 
} 


/*********************************************************************/ 
/* 
#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
# Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] to Target 
#EndIf 
*/ 
public static final void mappingRule_87(TTransformControl transformControl) throws Exception 
{ 
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
// Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] to Target 
//EndIf 
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



#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] To Target 
# Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] To Target 
# EndIf 
#Else 
# If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] Exists 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] to Target 
# Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] to Target 
# EndIf 
#EndIf 


If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] to Target 
Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] to Target 
EndIf 
*/ 
public static final void mappingRule_89(TTransformControl transformControl) throws Exception 
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
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] To Target 
// Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] To Target 
// EndIf 
//Else 
// If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] Exists 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] to Target 
// Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] to Target 
// EndIf 
//EndIf 
if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 89, 90)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(91), 89, 91)); 
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


#If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 
#Else 
# Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] to Target 
#EndIf 
*/ 
public static final void mappingRule_92(TTransformControl transformControl) throws Exception 
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
//If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 
//Else 
// Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] to Target 
//EndIf 
} 


/*********************************************************************/ 
/* 
IF Source Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_95(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(96))) 
{ 
String sources [] = {transformControl.getSource(96),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
} 
} 


/*********************************************************************/ 
/* 
IF Source Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" Source "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_97(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(98))) 
{ 
String sources [] = {transformControl.getSource(98),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
} 
} 


/*********************************************************************/ 
/* 
Move " " to Target 
*/ 
public static final void mappingRule_99(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget(" "); 
} 


/*********************************************************************/ 
/* 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|TypeCode] = "Credit" 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCPaymentTerm] Exists 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCPaymentTerm] to Target 
ELSE 
MOVE "Net 30 Days" to Target 
ENDIF 
ELSE 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCPaymentTerm] to Target 
ENDIF 
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
public static final void mappingRule_101(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(25), "Credit")) 
{ 
if (Compare.exists(transformControl.getSource(102))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 101, 102)); 
} 
else 
{ 
transformControl.setTarget("Net 30 Days"); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(102), 101, 102)); 
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
public static final void mappingRule_103(TTransformControl transformControl) throws Exception 
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
public static final void mappingRule_130(TTransformControl transformControl) throws Exception 
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
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|TypeCode] = "Credit" 
COMPUTE Target = -1 * [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LineQuantity] 
ELSE 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LineQuantity] to Target 
ENDIF 
*/ 
public static final void mappingRule_132(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(25), "Credit")) 
{ 
transformControl.setTargetNumber(-1.0 * transformControl.getSourceNumber(133)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(133), 132, 133)); 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|TypeCode] = "Credit" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|Amount2] = [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKCJDEExtAmount] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKCItemPrice] to Target 
Else 
Compute Target = [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|Amount2] / [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LineQuantity] 
EndIf 
Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKCItemPrice] to Target 
EndIf 
*/ 
public static final void mappingRule_135(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(25), "Credit")) 
{ 
if (Compare.equals(transformControl.getSource(136), transformControl.getSource(137))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(138), 135, 138)); 
} 
else 
{ 
transformControl.setTargetNumber(transformControl.getSourceNumber(136) / transformControl.getSourceNumber(133)); 
} 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(138), 135, 138)); 
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
## FIELD TYPE CODE: CURRENCY_CODE 
## APPLICATION VALUE: Field mapped to this field 
## APPLICATION NAME: SIEBEL 
## GEOGRAPHY CODE: WW 
## UNIVERSAL CODE: leave blank 
## 
## Do this lookup prior to calling the map 
*/ 
public static final void mappingRule_139(TTransformControl transformControl) throws Exception 
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
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|TypeCode] = "Credit" 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|Amount2] to Target 
ELSE 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCInvoiceDayCode] Exists 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKCNRCLineAmount] to Target 
ELSE 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKCJDEExtAmount] to Target 
ENDIF 
## Dave is following up with Ted Hardy 
## Periodic Billing Field in Siebel. 
ENDIF 
*/ 
public static final void mappingRule_140(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(25), "Credit")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(136), 140, 136)); 
} 
else 
{ 
if (Compare.exists(transformControl.getSource(141))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(142), 140, 142)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(137), 140, 137)); 
} 
//# Dave is following up with Ted Hardy 
//# Periodic Billing Field in Siebel. 
} 
} 


/*********************************************************************/ 
/* 
Move "EXEMPT" To Target 
*/ 
public static final void mappingRule_144(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("EXEMPT"); 
} 


/*********************************************************************/ 
/* 
Move "ZZ" To Target 
*/ 
public static final void mappingRule_145(TTransformControl transformControl) throws Exception 
{ 
transformControl.setTarget("ZZ"); 
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
public static final void mappingRule_171(TTransformControl transformControl) throws Exception 
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
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
EndIf 

Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] to Target 
EndIf 
EndIf 
*/ 
public static final void mappingRule_176(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(177))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
else if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
else if (Compare.exists(transformControl.getSource(177))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
else if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(76), 176, 76)); 
} 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] to Target 
EndIf 

Else 

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr1] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress] to Target 

EndIf 

EndIf 
*/ 
public static final void mappingRule_178(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(177))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(177), 178, 177)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 178, 57)); 
} 
else if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 178, 80)); 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(57), 178, 57)); 
} 
else if (Compare.exists(transformControl.getSource(177))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(177), 178, 177)); 
} 
else if (Compare.exists(transformControl.getSource(80))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(80), 178, 80)); 
} 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr2] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr2] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] to Target 
EndIf 

Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToAddress2] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr2] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtAddr2] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToAddress2] to Target 
EndIf 
EndIf 
*/ 
public static final void mappingRule_179(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(180))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(180), 179, 180)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(59), 179, 59)); 
} 
else if (Compare.exists(transformControl.getSource(82))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(82), 179, 82)); 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(59), 179, 59)); 
} 
else if (Compare.exists(transformControl.getSource(180))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(180), 179, 180)); 
} 
else if (Compare.exists(transformControl.getSource(82))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(82), 179, 82)); 
} 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCity] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCity] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] to Target 
EndIf 
Else 

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCity] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCity] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCity] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCity] to Target 
EndIf 
EndIf 
*/ 
public static final void mappingRule_181(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(182))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(182), 181, 182)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 181, 65)); 
} 
else if (Compare.exists(transformControl.getSource(88))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(88), 181, 88)); 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(65), 181, 65)); 
} 
else if (Compare.exists(transformControl.getSource(182))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(182), 181, 182)); 
} 
else if (Compare.exists(transformControl.getSource(88))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(88), 181, 88)); 
} 
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

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtProvince] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtState] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtState] to Target 

Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] To Target 

Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] To Target 
EndIf 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] to Target 
EndIf 
EndIf 
Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToProvince] To Target 
Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToState] To Target 
EndIf 
Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtProvince] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtState] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtState] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToProvince] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToState] to Target 
EndIf 
EndIf 

EndIf 
*/ 
public static final void mappingRule_183(TTransformControl transformControl) throws Exception 
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
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(184))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(184), 183, 184)); 
} 
else if (Compare.exists(transformControl.getSource(185))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(185), 183, 185)); 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
if (Compare.exists(transformControl.getSource(67))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 183, 67)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(68), 183, 68)); 
} 
} 
else if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 183, 90)); 
} 
else if (Compare.exists(transformControl.getSource(91))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(91), 183, 91)); 
} 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
if (Compare.exists(transformControl.getSource(67))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(67), 183, 67)); 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(68), 183, 68)); 
} 
} 
else 
{ 
if (Compare.exists(transformControl.getSource(184))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(184), 183, 184)); 
} 
else if (Compare.exists(transformControl.getSource(185))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(185), 183, 185)); 
} 
else if (Compare.exists(transformControl.getSource(90))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(90), 183, 90)); 
} 
else if (Compare.exists(transformControl.getSource(91))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(91), 183, 91)); 
} 
} 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtZipCode] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtZipCode] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] to Target 
EndIf 
Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToPostalCode] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtZipCode] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtZipCode] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToPostalCode] to Target 
EndIf 
EndIf 
*/ 
public static final void mappingRule_186(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(187))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(187), 186, 187)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(63), 186, 63)); 
} 
else if (Compare.exists(transformControl.getSource(86))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(86), 186, 86)); 
} 
} 
else 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(63), 186, 63)); 
} 
else if (Compare.exists(transformControl.getSource(187))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(187), 186, 187)); 
} 
else if (Compare.exists(transformControl.getSource(86))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(86), 186, 86)); 
} 
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

If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AgreementOrganizationName] = "Lexmark - United States" 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCountry] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCountry] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 

ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] to Target 
EndIf 
EndIf 
Else 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDBillToCountry] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCountry] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCountry] to Target 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] Exists 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKSDAgreementAcctShipToCountry] to Target 
EndIf 
EndIf 
*/ 
public static final void mappingRule_188(TTransformControl transformControl) throws Exception 
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
if (Compare.equals(transformControl.getSource(16), "Lexmark - United States")) 
{ 
if (Compare.exists(transformControl.getSource(189))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(189), 188, 189)); 
} 
else if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(70), 188, 70)); 
} 
else if (Compare.exists(transformControl.getSource(93))) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(93), 188, 93)); 
} 
} 
} 


/*********************************************************************/ 
/* 
If [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|AccountName] <> [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKUPAgreementAccountName] 
# Don't map 
Else 
Move [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAssetInstalledAtCounty] to Target 
EndIf 
*/ 
public static final void mappingRule_190(TTransformControl transformControl) throws Exception 
{ 
if (Compare.notEqual(transformControl.getSource(55), transformControl.getSource(76))) 
{ 
// Don't map 
} 
else 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(191), 190, 191)); 
} 
} 


/*********************************************************************/ 
/* 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAgreementItemEndDate] Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAgreementItemEndDate] "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|LXKCMaximumEndDate] Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|LXKCMaximumEndDate] "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_193(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(194))) 
{ 
String sources [] = {transformControl.getSource(194),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
} 
else if (Compare.exists(transformControl.getSource(98))) 
{ 
String sources1 [] = {transformControl.getSource(98),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources1,0)); 
} 
} 


/*********************************************************************/ 
/* 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAgreementItemStartDate] Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|ListOfLxkCFsInvoiceLineItems|LxkCFsInvoiceLineItems|LXKSDAgreementItemStartDate] "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ElseIf [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|LXKCMinimumStartDate] Exists 
CALL "com.lxk.utils.DateConverter.ContivoDateConverter.reformatDate" [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|LXKCMinimumStartDate] "MM/dd/yyyy HH:mm:ss" "yyyy-MM-dd'T'HH:mm:ss.SSS" to Target with java 
ENDIF 
*/ 
public static final void mappingRule_195(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(196))) 
{ 
String sources [] = {transformControl.getSource(196),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources,0)); 
} 
else if (Compare.exists(transformControl.getSource(96))) 
{ 
String sources1 [] = {transformControl.getSource(96),"MM/dd/yyyy HH:mm:ss","yyyy-MM-dd'T'HH:mm:ss.SSS"}; 
transformControl.setTarget(Call.execNativeJavaCommand("com.lxk.utils.DateConverter.ContivoDateConverter","reformatDate",transformControl,sources1,0)); 
} 
} 


/*********************************************************************/ 
/* 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCInvoiceDayCode] Exists 
MOVE "SCH" to Target 
ENDIF 
*/ 
public static final void mappingRule_198(TTransformControl transformControl) throws Exception 
{ 
if (Compare.exists(transformControl.getSource(141))) 
{ 
transformControl.setTarget("SCH"); 
} 
} 


/*********************************************************************/ 
/* 
IF [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCPaymentMethod] = "Purchase Order" 
MOVE [ScheduledInvoiceOutboundDTD|SiebelMessage|ListOfLxkCServiceAgreementEai|LxkCServiceAgreementEai|ListOfLxkCFsInvoice|LxkCFsInvoice|LXKCPONumber] to Target 
ELSE 
MOVE "" to Target 
ENDIF 
*/ 
public static final void mappingRule_203(TTransformControl transformControl) throws Exception 
{ 
if (Compare.equals(transformControl.getSource(104), "Purchase Order")) 
{ 
transformControl.setTarget(transformControl.convert(transformControl.getSource(204), 203, 204)); 
} 
else 
{ 
transformControl.setTarget(""); 
} 
} 


/*********************************************************************/ 
/* 
## This is a bad mapping 
## This should end up in JDE in the ASN field for EMEA 
*/ 
public static final void mappingRule_205(TTransformControl transformControl) throws Exception 
{ 
//# This is a bad mapping 
//# This should end up in JDE in the ASN field for EMEA 
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

