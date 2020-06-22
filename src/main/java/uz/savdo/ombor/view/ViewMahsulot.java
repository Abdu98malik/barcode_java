package uz.savdo.ombor.view;

import java.io.IOException;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import uz.savdo.ombor.entity.Mahsulotpul;

public class ViewMahsulot {

	
	public void excel(HttpServletResponse response, List<Mahsulotpul> pul) {
		
		Workbook workbook=new HSSFWorkbook();;
		 
		
		Sheet sheet = workbook.createSheet("Excel sheet");
//		Row header = sheet.createRow(0);
//		header.createCell(0).setCellValue("Sana");
//		header.createCell(1).setCellValue("Ishchi ID");
//		header.createCell(2).setCellValue("Puli");
		
		int row = 1;
		for(Mahsulotpul pu: pul) {
			Row pulRow = sheet.createRow(row++);
			pulRow.createCell(0).setCellValue(pu.getDate_time().toString());
			pulRow.createCell(1).setCellValue(pu.getMoney());
			
		}
		response.setContentType("application/vnd.ms-excel"); //Tell the browser to expect an excel file
		response.setHeader("Content-Disposition", "attachment; filename=pullar.xls"); //Tell the browser it should be named as the custom file name

		try {
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
