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

import com.adminlte.models.Desktop;

public class DesktopExcelExport {
	public static ByteArrayInputStream exportExcel(List<Desktop> desktops) {
		try(Workbook workbook=new XSSFWorkbook()) {
			
			Sheet sheet=workbook.createSheet("List-Of-Desktop");
			// Create row
			Row row=sheet.createRow(0);
			CellStyle headerCellStyle=workbook.createCellStyle();
			headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			//headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			//Create Header Cells
			Cell cell=row.createCell(0);
			cell.setCellValue("Employee's Name");
			cell.setCellStyle(headerCellStyle);
			/*---Department--*/
			cell=row.createCell(1);
			cell.setCellValue("Department");
			cell.setCellStyle(headerCellStyle);
			/*---Position--*/
			cell=row.createCell(2);
			cell.setCellValue("Position");
			cell.setCellStyle(headerCellStyle);
			/*---Laptop Model--*/
			cell=row.createCell(3);
			cell.setCellValue("Model");
			cell.setCellStyle(headerCellStyle);
			/*---CPU--*/
			cell=row.createCell(4);
			cell.setCellValue("CPU");
			cell.setCellStyle(headerCellStyle);
			/*---RAM--*/
			cell=row.createCell(5);
			cell.setCellValue("RAM");
			cell.setCellStyle(headerCellStyle);
			/*---HHD--*/
			cell=row.createCell(6);
			cell.setCellValue("HHD");
			cell.setCellStyle(headerCellStyle);
			/*---Display--*/
			cell=row.createCell(7);
			cell.setCellValue("Display");
			cell.setCellStyle(headerCellStyle);
			/*---OS--*/
			cell=row.createCell(8);
			cell.setCellValue("OS");
			cell.setCellStyle(headerCellStyle);
			/*---Serial Number--*/
			cell=row.createCell(9);
			cell.setCellValue("Serial Number");
			cell.setCellStyle(headerCellStyle);
			/*---Asset Number--*/
			cell=row.createCell(10);
			cell.setCellValue("Asset Number");
			cell.setCellStyle(headerCellStyle);
			/*---Date Instock--*/
			cell=row.createCell(11);
			cell.setCellValue("Date Instock");
			cell.setCellStyle(headerCellStyle);
			/*---Date Using--*/
			cell=row.createCell(12);
			cell.setCellValue("Date Using");
			cell.setCellStyle(headerCellStyle);
			/*---Remark--*/
			cell=row.createCell(13);
			cell.setCellValue("Remark");
			cell.setCellStyle(headerCellStyle);
			/*---Remark--*/
			cell=row.createCell(14);
			cell.setCellValue("Location");
			cell.setCellStyle(headerCellStyle);
			
			// Create Data Row 
			for (int i=0;i<desktops.size();i++) {
				Row dataRow=sheet.createRow(i+1);
				dataRow.createCell(0).setCellValue(desktops.get(i).getEmpname());
				dataRow.createCell(1).setCellValue(desktops.get(i).getDeptname());
				dataRow.createCell(2).setCellValue(desktops.get(i).getPosition());
				dataRow.createCell(3).setCellValue(desktops.get(i).getModel());
				dataRow.createCell(4).setCellValue(desktops.get(i).getCpu());
				dataRow.createCell(5).setCellValue(desktops.get(i).getRam());
				dataRow.createCell(6).setCellValue(desktops.get(i).getHhd());
				dataRow.createCell(7).setCellValue(desktops.get(i).getDisplay());
				dataRow.createCell(8).setCellValue(desktops.get(i).getOs());
				dataRow.createCell(9).setCellValue(desktops.get(i).getSn());
				dataRow.createCell(10).setCellValue(desktops.get(i).getAsset());
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				//Covert Date
				Date indate=desktops.get(i).getDatein();
				String datein=format.format(indate);
				//Date using
				Date usingDate=desktops.get(i).getDateusing();
				if(usingDate==null) {
					usingDate=format.parse ( "01-01-1998" );
				}
				String dateusing=format.format(usingDate);
				
				dataRow.createCell(11).setCellValue(datein);
				dataRow.createCell(12).setCellValue(dateusing);
				dataRow.createCell(13).setCellValue(desktops.get(i).getRemark());
				dataRow.createCell(14).setCellValue(desktops.get(i).getBrname());
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
			sheet.autoSizeColumn(11);
			sheet.autoSizeColumn(12);
			sheet.autoSizeColumn(13);
			sheet.autoSizeColumn(14);
			ByteArrayOutputStream outputStram=new ByteArrayOutputStream();
			workbook.write(outputStram);
			
			return new ByteArrayInputStream(outputStram.toByteArray());
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
