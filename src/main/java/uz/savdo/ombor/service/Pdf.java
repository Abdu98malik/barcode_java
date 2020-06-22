package uz.savdo.ombor.service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 

public class Pdf {
	 public static void main(String[] args)
	   {
	      Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Abdulmalik\\Desktop\\temp\\Table.pdf"));
	         document.open();
	        
	         PdfPTable table = new PdfPTable(7);
	         table.setWidthPercentage(100); //Width 100%
	         table.setSpacingBefore(10f); //Space before table
	         table.setSpacingAfter(10f); //Space after table
	  
	         //Set Column widths
	         float[] columnWidths = {1f, 1f, 1f,1f, 1f, 1f, 1f};
	         table.setWidths(columnWidths);
	  
	         PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
	        // cell1.setBorderColor(BaseColor.BLACK);
	         //cell1.setPaddingLeft(10);
	         //cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         //cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
	        
	  
	         PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
	      
	         PdfPCell cell4 = new PdfPCell(new Paragraph("Cell 3"));
	         
	         PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 3"));
	         
	         PdfPCell cell6 = new PdfPCell(new Paragraph("Cell 3"));
	        
	         PdfPCell cell7 = new PdfPCell(new Paragraph("Cell 3"));
	     
	         table.addCell(cell1);
	         table.addCell(cell2);
	         table.addCell(cell3);
	         table.addCell(cell4);
	         table.addCell(cell5);
	         table.addCell(cell6);
	         table.addCell(cell7);
	         
	         document.add(table);
	         
	         document.close();
	         writer.close();
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      } 
	   }
}
