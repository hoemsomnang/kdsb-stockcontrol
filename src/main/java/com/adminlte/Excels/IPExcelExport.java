package com.adminlte.Excels;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adminlte.models.IP;

public class IPExcelExport {
	public static ByteArrayInputStream exportExcel(List<IP> ips,String sheetname) {
		try(Workbook workbook=new XSSFWorkbook()) {
			
			Sheet sheet=workbook.createSheet(sheetname);
			// Create row
			Row row=sheet.createRow(0);
			CellStyle headerCellStyle=workbook.createCellStyle();
			headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			//headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			//Create Header Cells
			Cell cell=row.createCell(0);
			cell.setCellValue("IP Address");
			cell.setCellStyle(headerCellStyle);
			/*---Macaddress--*/
			cell=row.createCell(1);
			cell.setCellValue("Macaddress");
			cell.setCellStyle(headerCellStyle);
			/*---User Name--*/
			cell=row.createCell(2);
			cell.setCellValue("User Name");
			cell.setCellStyle(headerCellStyle);
			/*---Department--*/
			cell=row.createCell(3);
			cell.setCellValue("Department");
			cell.setCellStyle(headerCellStyle);
			/*---Serial Number--*/
			cell=row.createCell(4);
			cell.setCellValue("Serial Number");
			cell.setCellStyle(headerCellStyle);
			/*---Location--*/
			cell=row.createCell(5);
			cell.setCellValue("Location");
			cell.setCellStyle(headerCellStyle);
			/*---PC's Name--*/
			cell=row.createCell(6);
			cell.setCellValue("PC's Name");
			cell.setCellStyle(headerCellStyle);
			/*---Antivirus--*/
			cell=row.createCell(7);
			cell.setCellValue("Antivirus");
			cell.setCellStyle(headerCellStyle);
			/*---Remark--*/
			cell=row.createCell(8);
			cell.setCellValue("Remark");
			cell.setCellStyle(headerCellStyle);
			/*---Extension--*/
			cell=row.createCell(9);
			cell.setCellValue("Extension");
			cell.setCellStyle(headerCellStyle);
			
			// Create Data Row 
			for (int i=0;i<ips.size();i++) {
				Row dataRow=sheet.createRow(i+1);
				dataRow.createCell(0).setCellValue(ips.get(i).getIp());
				dataRow.createCell(1).setCellValue(ips.get(i).getMacaddress());
				dataRow.createCell(2).setCellValue(ips.get(i).getUsername());
				dataRow.createCell(3).setCellValue(ips.get(i).getDeptname());
				dataRow.createCell(4).setCellValue(ips.get(i).getSn());
				dataRow.createCell(5).setCellValue(ips.get(i).getLocation());
				dataRow.createCell(6).setCellValue(ips.get(i).getPcname());
				dataRow.createCell(7).setCellValue(ips.get(i).getAntivirus());
				dataRow.createCell(8).setCellValue(ips.get(i).getRamark());
				dataRow.createCell(9).setCellValue(ips.get(i).getExtension());
				
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
			ByteArrayOutputStream outputStram=new ByteArrayOutputStream();
			workbook.write(outputStram);
			
			return new ByteArrayInputStream(outputStram.toByteArray());
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
