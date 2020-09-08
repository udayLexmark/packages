package lxkShared;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-08-09 02:49:47 EDT
// -----( ON-HOST: dlxkswmis1.lex.lexmark.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.zip.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.*;
import java.math.*;
import org.apache.poi.hssf.util.HSSFColor;
// --- <<IS-END-IMPORTS>> ---

public final class xls

{
	// ---( internal utility methods )---

	final static xls _instance = new xls();

	static xls _newInstance() { return new xls(); }

	static xls _cast(Object o) { return (xls)o; }

	// ---( server methods )---




	public static final void recordToXls (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(recordToXls)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:optional filename
		// [i] record:0:required xlsFormat
		// [i] - field:0:required includeHeader {&quot;true&quot;,&quot;false&quot;}
		// [i] - field:0:required sheetName
		// [i] - field:0:required startRow
		// [i] - field:0:required startColumn
		// [i] - field:0:optional dateTimeFormat {&quot;m/d/yy&quot;,&quot;m/d/yy h:mm&quot;,&quot;d-mmm-yy&quot;,&quot;d-mmm&quot;,&quot;mmm-yy&quot;,&quot;h:mm AM/PM&quot;,&quot;h:mm:ss AM/PM&quot;,&quot;h:mm&quot;,&quot;h:mm:ss&quot;}
		// [i] record:1:required records
		// [o] object:0:optional xlsBytes
		// Srinivas Akula
		// To Parse an Idata object to an xls template and vice versa
		IDataCursor idc = pipeline.getCursor();
		
		String filename = null;
		OutputStream os = null;
		FileOutputStream fos = null;
		ByteArrayOutputStream bos = null;
		IData xlsFormat = null;
		IData[] records = null;
		String sheetName = null; 
		int startRow = 0;
		short startColumn = 0;
		boolean includeHeader = true;
		String dateTimeFormat = null; 
		
		if (idc.first("filename"))
			filename = (String)idc.getValue();
		
		if (idc.first("xlsFormat"))
			xlsFormat = (IData)idc.getValue();
		
		if (xlsFormat == null)
			throw new ServiceException ("missing xlsFormat in pipeline.");
		
		if (idc.first("records"))
			records = (IData[])idc.getValue();
		
		if (records == null)
			throw new ServiceException ("missing records in pipeline.");
		
		IDataCursor xf = xlsFormat.getCursor();
		sheetName = IDataUtil.getString(xf, "sheetName");
		if (sheetName == null)
			sheetName = "Sheet1";
		
		startRow = Integer.parseInt(IDataUtil.getString(xf, "startRow"));
		startColumn = Short.parseShort(IDataUtil.getString(xf, "startColumn"));
		includeHeader = (new Boolean(IDataUtil.getString(xf, "includeHeader"))).booleanValue();
		dateTimeFormat = IDataUtil.getString(xf, "dateTimeFormat");
		
		xf.destroy();
		
		/*
		System.out.println( " sheetName=" + sheetName + 
							"\n startRow=" + startRow + 
							"\n startColumn=" + startColumn + 
							"\n includeHeader=" + includeHeader +
							"\n dateTimeFormat=" + dateTimeFormat + 
							"\n records=" + records);
		*/
		
		try {
			// -1- open a work book
		    HSSFWorkbook wb = new HSSFWorkbook();
			if (filename != null) {
			    fos = new FileOutputStream(filename);
				os = fos;
			} else {
				bos = new ByteArrayOutputStream();
				os = bos;
			}
		
			// -2- open a sheet
			HSSFSheet sheet = wb.createSheet(sheetName);
		
			HSSFRow row = null;
			HSSFCell cell = null;
			HSSFCellStyle style = null;
		
			HSSFCellStyle cellStyle = wb.createCellStyle();
			//cellStyle.setDataFormat(HSSFDataFormat.getFormat(dateTimeFormat));
		
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLUE.index);
			HSSFCellStyle boldStyle = wb.createCellStyle();
			boldStyle.setFont(font);
			
			
		  	HSSFCellStyle styleC = wb.createCellStyle();
			styleC.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			styleC.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			styleC.setFont(font);
		
		
			Object v = null;
			short col = 0;
			
			// -3- add header if needed
			if (includeHeader) {
				row = sheet.createRow(startRow);
				short cw = 40;
				sheet.setDefaultColumnWidth(cw);
				// TO DO: insert header row
				IDataCursor r = records[0].getCursor();
		//System.out.println("\tinserting header row[" + startRow + "]");
				r.first();
				col = startColumn;
				do {
					cell = row.createCell(col);
					v = (String)r.getKey();
					cell.setCellValue((String)v);
					
					cell.setCellStyle(boldStyle);
					cell.setCellStyle(styleC);
					
					
		//System.out.println("\t\tinserting column header [" + col + "] " + v);
					col++;
					r.next();
				} 
				while(r.hasMoreData());
				cell = row.createCell(col);
				v = (String)r.getKey();
				cell.setCellValue((String)v);
				cell.setCellStyle(boldStyle);
				cell.setCellStyle(styleC);
				
		//System.out.println("\t\tinserting column header [" + col + "] " + v);
				r.destroy();
				startRow++;
			}
		
			// -4- insert all rows ...
			for (int i=0; i<records.length; i++) {
				row = sheet.createRow((int)(startRow+i));
				IDataCursor r = records[i].getCursor();
		//System.out.println("\tinserting row[" + (i+startRow) + "]");
				r.first();
				col = startColumn;
				do {
					cell = row.createCell(col);
					v = r.getValue();
					if (v instanceof java.math.BigDecimal) {
						cell.setCellValue(((BigDecimal)v).doubleValue());
					} else if (v instanceof java.sql.Timestamp) {
						cell.setCellValue((Date)v);
						cell.setCellStyle(cellStyle);
					} else if (v instanceof String) {
						cell.setCellValue((String)v);
					}
		//System.out.println("\t\tinserting column[" + col + "] " + v);
					col++;
					r.next();
				} while(r.hasMoreData());
				cell = row.createCell(col);
				v = r.getValue();
				if (v instanceof java.math.BigDecimal) {
					cell.setCellValue(((BigDecimal)v).doubleValue());
				} else if (v instanceof java.sql.Timestamp) {
					cell.setCellValue((Date)v);
					cell.setCellStyle(cellStyle);
				} else if (v instanceof String) {
					cell.setCellValue((String)v);
				}
		//System.out.println("\t\tinserting column[" + col + "] " + v);
				r.destroy();
			}
		
		    wb.write(os);
			os.flush();
		
			if (filename == null) {
				if(idc.first("xlsBytes"))
					idc.setValue(bos.toByteArray());
				else
					idc.insertAfter("xlsBytes", bos.toByteArray());
			}
			idc.destroy();
		} catch (Exception e) { 
			e.printStackTrace();
			throw new ServiceException(e);
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (Exception ioex) {
					ioex.printStackTrace();
				} 
		} 
		// --- <<IS-END>> ---

                
	}
}

