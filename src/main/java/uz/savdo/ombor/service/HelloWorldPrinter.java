package uz.savdo.ombor.service;

import java.awt.*;
import java.awt.event.*;

import java.awt.print.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class HelloWorldPrinter implements Printable{

	private List<String> name;
	private List<Integer> price;
	private List<Integer> quantity;
	private Integer overall_price ;
	
	
	
    public HelloWorldPrinter(List<String> name, List<Integer> price, List<Integer> quantity, Integer overall_price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.overall_price = overall_price;
		
	}

   
	public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
    	System.out.println("Inside print");
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        
        int i = 0;
        int j = 10;
        g2d.setFont(new Font("Consolas", Font.PLAIN, 16));
    	g2d.drawString("  Beno Market  ", 4, 12);
    	
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 10));
    	g2d.drawString("Optom salqin ichimliklar", 20, 22);
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 10));
    	g2d.drawString("va Oziq-ovqatlar", 4, 32);
    	
    	
    	
    	
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 42);
    	
        for (String n: name) {
        	g2d.setFont(new Font("Consolas", Font.PLAIN, 9));
        	g2d.drawString("   "+ n +" - ", 4, 42+j);
        	
        	g2d.setFont(new Font("Consolas", Font.PLAIN, 9));
        	g2d.drawString("   "+price.get(i)+" - "+quantity.get(i)+" ta",4, 52+j);
        	 
       	i++; j = j + 20; 
        }
        
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 32 + j+10);
    	
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  "+overall_price+" so'm", 0, 32 + j + 20);
    	
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 32 + j + 30);
    	
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 10));
    	g2d.drawString(LocalDate.now().toString()+" "+LocalTime.now().toString(), 4, 32 + j + 40);

        g2d.translate(pf.getImageableX(), pf.getImageableY());
        System.out.println("Inside print 2");
        
        
        return PAGE_EXISTS;
    }

    public void actionPerformed() {
         PageFormat pf = new PageFormat();
         Paper paper = new Paper();
         
         int width = 216;
 		int height = 1000;
 			
 		paper.setImageableArea(1, 1, width, height);
 		
 		
 		
 		PrinterJob job = PrinterJob.getPrinterJob();
 		 
    	
    	System.out.println("After printerjob");
    	
    	pf = job.defaultPage();
    	
    	pf.setPaper(paper);
		
		pf.setOrientation(PageFormat.PORTRAIT);
		job.setPrintable(this, pf);
		
    	job.setPrintable(this);
    	System.out.println("After printable");
    	
    	//boolean ok = job.printDialog();
     //    if (ok) {
             try {
                  job.print();
             } catch (Exception ex) {
              ex.printStackTrace();
             }
     //    }
             
          //   name.clear();price.clear();quantity.clear();
    }

//    public static void main(String args[]) {
//    	HelloWorldPrinter hello = new HelloWorldPrinter(null, null, null, null);
//    	
//    	hello.actionPerformed();
//    	
//    }
}