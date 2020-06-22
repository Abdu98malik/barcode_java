package uz.savdo.ombor.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelView {

	public void excel(HttpServletResponse response, Map<String,String> mal, Map<String,ArrayList<String>> tab){
		Workbook workbook=new HSSFWorkbook();;
	 
		LocalDateTime time = LocalDateTime.now();
		
		Sheet sheet = workbook.createSheet("Excel sheet");
		
		Font font = workbook.createFont();
		font.setBold(true);
		
		CellStyle style = workbook.createCellStyle();  
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(BorderStyle.THIN);
		
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
		style.setBorderLeft(BorderStyle.THIN);
		
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());  
		style.setBorderRight(BorderStyle.THIN);
		
		//		Row header = sheet.createRow(0);
//		header.createCell(0).setCellValue("Sana");
//		header.createCell(1).setCellValue("Ishchi ID");
//		header.createCell(2).setCellValue("Puli");
		
		int row = 1;
		
			Row pulRow = sheet.createRow(row++);
			pulRow.createCell(0).setCellValue("Klient: ");
			pulRow.createCell(1).setCellValue(mal.get("client"));
			Row pulRow2 = sheet.createRow(row++);
			pulRow2.createCell(0).setCellValue("Agent: ");
			pulRow2.createCell(1).setCellValue(mal.get("agent"));
				
			
			for(Map.Entry<String, ArrayList<String>> entry: tab.entrySet()) {
			
				Row pulRow3 = sheet.createRow(row++);
				pulRow3.createCell(0).setCellStyle(style); pulRow3.getCell(0).setCellValue(entry.getValue().get(0));
				
				pulRow3.createCell(1).setCellValue(entry.getValue().get(1)); pulRow3.getCell(1).setCellStyle(style);
				pulRow3.createCell(2).setCellStyle(style); pulRow3.getCell(2).setCellValue(entry.getValue().get(2));
				pulRow3.createCell(3).setCellStyle(style); pulRow3.getCell(3).setCellValue(entry.getValue().get(3));
				pulRow3.createCell(4).setCellStyle(style); pulRow3.getCell(4).setCellValue(entry.getValue().get(4));
				pulRow3.createCell(5).setCellStyle(style); pulRow3.getCell(5).setCellValue(entry.getValue().get(5));
				//pulRow.createCell(1).setCellValue(mal.get("client"));
			}
			Row pulRow4 = sheet.createRow(row++);
			pulRow4.createCell(0).setCellValue("Jami");
			pulRow4.createCell(1).setCellValue(mal.get("pachka"));
			pulRow4.createCell(2).setCellValue(mal.get("soni"));
			pulRow4.createCell(4).setCellValue(mal.get("sum"));
			pulRow4.createCell(5).setCellValue(mal.get("kilo"));
			sheet.autoSizeColumn(0);
			Row pulRow5 = sheet.createRow(row++);
			pulRow5.createCell(3).setCellValue("Summa: ");
			pulRow5.createCell(4).setCellValue(mal.get("sum"));
			
			
		response.setContentType("application/vnd.ms-excel"); //Tell the browser to expect an excel file
		response.setHeader("Content-Disposition", "attachment; filename="+time+".xls"); //Tell the browser it should be named as the custom file name

		try {
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
