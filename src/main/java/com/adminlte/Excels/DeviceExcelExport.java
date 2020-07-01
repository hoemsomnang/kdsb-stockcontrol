package com.adminlte.Excels;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adminlte.models.Devices;


public class DeviceExcelExport {
	public static ByteArrayInputStream exportExcel(List<Devices> devices) {
		try(Workbook workbook=new XSSFWorkbook()) {
			
			Sheet sheet=workbook.createSheet("List-Of-device");
			// Create row
			Row row=sheet.createRow(0);
			CellStyle headerCellStyle=workbook.createCellStyle();
			headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			//headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			//Create Header Cells
			Cell cell=row.createCell(0);
			cell.setCellValue("Device's Name");
			cell.setCellStyle(headerCellStyle);
			/*---Model--*/
			cell=row.createCell(1);
			cell.setCellValue("Device's Model");
			cell.setCellStyle(headerCellStyle);
			/*---Quantity--*/
			cell=row.createCell(2);
			cell.setCellValue("QTY");
			cell.setCellStyle(headerCellStyle);
			/*---Asset Number--*/
			cell=row.createCell(3);
			cell.setCellValue("Asset Number");
			cell.setCellStyle(headerCellStyle);
			/*---OS Version--*/
			cell=row.createCell(4);
			cell.setCellValue("OS Version");
			cell.setCellStyle(headerCellStyle);
			/*---RAM--*/
			cell=row.createCell(5);
			cell.setCellValue("Date Instock");
			cell.setCellStyle(headerCellStyle);
			/*---HHD--*/
			cell=row.createCell(6);
			cell.setCellValue("Date Using");
			cell.setCellStyle(headerCellStyle);
			/*---Display--*/
			cell=row.createCell(7);
			cell.setCellValue("Remark");
			cell.setCellStyle(headerCellStyle);
			/*---OS--*/
			cell=row.createCell(8);
			cell.setCellValue("Location1");
			cell.setCellStyle(headerCellStyle);
			/*---Serial Number--*/
			cell=row.createCell(9);
			cell.setCellValue("Branch");
			cell.setCellStyle(headerCellStyle);
			/*---Asset Number--*/
			cell=row.createCell(10);
			cell.setCellValue("Status");
			cell.setCellStyle(headerCellStyle);
			
			
			// Create Data Row 
			for (int i=0;i<devices.size();i++) {
				Row dataRow=sheet.createRow(i+1);
				dataRow.createCell(0).setCellValue(devices.get(i).getName());
				dataRow.createCell(1).setCellValue(devices.get(i).getModel());
				dataRow.createCell(2).setCellValue(devices.get(i).getQty());
				dataRow.createCell(3).setCellValue(devices.get(i).getAsset());
				dataRow.createCell(4).setCellValue(devices.get(i).getVersion());
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				//Covert Date
				Date indate=devices.get(i).getDatein();
				if(indate==null) {
					indate=format.parse ( "01-01-1998" );
				}
				String datein=format.format(indate);
				
				//Date using
				Date usingDate=devices.get(i).getDateusing();
				if(usingDate==null) {
					usingDate=format.parse ( "01-01-1998" );
				}
				String dateusing=format.format(usingDate);
				dataRow.createCell(5).setCellValue(datein);
				dataRow.createCell(6).setCellValue(dateusing);
				dataRow.createCell(7).setCellValue(devices.get(i).getRemark());
				dataRow.createCell(8).setCellValue(devices.get(i).getLocation1());
				dataRow.createCell(9).setCellValue(devices.get(i).getBrname());
				dataRow.createCell(10).setCellValue(devices.get(i).getStatus());
				
				
			}
			//Auto Resize to fill cell
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);
			sheet.autoSizeColumn(9);
			sheet.autoSizeColumn(10);
			
			ByteArrayOutputStream outputStram=new ByteArrayOutputStream();
			workbook.write(outputStram);
			
			return new ByteArrayInputStream(outputStram.toByteArray());
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
