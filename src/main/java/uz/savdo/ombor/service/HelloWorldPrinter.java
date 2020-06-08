package uz.savdo.ombor.service;

import java.awt.*;
import java.awt.event.*;

import java.awt.print.*;

public class HelloWorldPrinter implements Printable{


    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

    	
    	///
    	 // Getting the page format.

		 // Create a new paper..
		
		// If you are working on printer rather than Thermal printers
		// then change the width and height accordingly.
		
		// I set them to 1000 value because that was for 
		// receipt which will not be larger than 1000 points
		// actually this height does not mean the height of 
		// paper get out from the printer, this is the height
		// of the printable area which you can use.
		
		
		///
		
		
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        
        /* Now we perform our rendering */
        //g.drawString("poiuy", 0,0);
        g2d.setFont(new Font("Consolas", Font.PLAIN, 8));
        g2d.drawString("    "+"Pepsi - 2000 1-ta 2000", 0, 12);
        
        g2d.setFont(new Font("Consolas", Font.PLAIN, 8));
        g2d.drawString("    "+"Cola-cola 3000 2-ta 6000", 0, 22);
       
        g2d.setFont(new Font("Consolas", Font.PLAIN, 8));
        g2d.drawString("    "+"Fant 4000 4-ta 16000", 0, 32);
        
        
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed() {
         PageFormat pf = new PageFormat();
         Paper paper = new Paper();
         
         int width = 216;
 		int height = 1000;
 		
 		// width = totalWidthOfPage - (MARGIN * 2);
 		// height = numberOfLines * 10 - (MARGIN * 2);
 		
 		paper.setImageableArea(1, 1, width, height);
 		
    	PrinterJob job = PrinterJob.getPrinterJob();
    	pf = job.defaultPage();
    	
    	pf.setPaper(paper);
		
		pf.setOrientation(PageFormat.PORTRAIT);
		job.setPrintable(this, pf);
		
    	job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }

    public static void main(String args[]) {
    	HelloWorldPrinter hello = new HelloWorldPrinter();
    	
    	hello.actionPerformed();
    	
    }
}