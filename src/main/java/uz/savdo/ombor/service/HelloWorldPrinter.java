package uz.savdo.ombor.service;

import java.awt.*;
import java.awt.event.*;

import java.awt.print.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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

        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        int i = 0;
        int j = 10;
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  Ichimlik do'koni  ", 4, 12);
    	
    	
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 22);
    	
        for (String n: name) {
        	g2d.setFont(new Font("Consolas", Font.PLAIN, 9));
        	g2d.drawString("   "+ n +" - ", 4, 22+j);
        	
        	g2d.setFont(new Font("Consolas", Font.PLAIN, 9));
        	g2d.drawString("   "+price.get(i)+" - "+quantity.get(i)+" ta",4, 32+j);
        	 
       	i++; j = j + 20; 
        }
        
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 22 + j+10);
    	
        g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  "+overall_price+" so'm", 0, 22 + j + 20);
    	
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 12));
    	g2d.drawString("  ----------------  ", 0, 22 + j + 30);
    	
    	g2d.setFont(new Font("Consolas", Font.PLAIN, 10));
    	g2d.drawString(LocalDate.now().toString()+" "+LocalTime.now().toString(), 4, 22 + j + 40);

        g2d.translate(pf.getImageableX(), pf.getImageableY());
    
        
        
        return PAGE_EXISTS;
    }

    public void actionPerformed() {
         PageFormat pf = new PageFormat();
         Paper paper = new Paper();
         
         int width = 216;
 		int height = 1000;
 			
 		paper.setImageableArea(1, 1, width, height);
 		
    	PrinterJob job = PrinterJob.getPrinterJob();
    	pf = job.defaultPage();
    	
    	pf.setPaper(paper);
		
		pf.setOrientation(PageFormat.PORTRAIT);
		job.setPrintable(this, pf);
		
    	job.setPrintable(this);
      
    	//boolean ok = job.printDialog();
     //    if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              
             }
     //    }
             
             name.clear();price.clear();quantity.clear();
    }

//    public static void main(String args[]) {
//    	HelloWorldPrinter hello = new HelloWorldPrinter();
//    	
//    	hello.actionPerformed();
//    	
//    }
}