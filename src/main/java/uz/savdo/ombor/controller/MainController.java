package uz.savdo.ombor.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uz.savdo.ombor.entity.Mahsulotpul;
import uz.savdo.ombor.entity.Products;
import uz.savdo.ombor.service.HelloWorldPrinter;
import uz.savdo.ombor.service.MahsulotPulService;
import uz.savdo.ombor.service.ProductsService;

@Controller
@RequestMapping("/")
public class MainController {

	private List<String> name_ = new ArrayList<String>();
	private List<Integer> price_ = new ArrayList<Integer>();
	private List<Integer> quantity_  =  new ArrayList<Integer>();
	private Integer overall_price_ = 0;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private MahsulotPulService mahsulotPulService;
	
	


	@GetMapping("")
	public String main() {
		
		return "main";
	}
	
	@GetMapping("menu")
	public String menu() {
		return "menu";
	}
	
	
	@GetMapping("/saveHisob")
	public String saveHisob(@RequestParam Map<String, String> allParams) {
		
		int sum_final = Integer.parseInt(allParams.get("sum_final"));
		int product_type_count = Integer.parseInt(allParams.get("product_count"));
		int i = 0;
		
		int price_sum = 0;
		
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
		
		i++;
			if(i>2) {//third loop
				String barcode = entry.getKey();
				int count = Integer.parseInt(entry.getValue());
				
				Products product = productsService.getProductByBarcode(barcode);
				
				
				
				int price = product.getPrice();
				
				price_sum = price_sum + (price * count);
				
				int current = product.getQuantity();
				
				int new_quantity = current - count ;
				product.setQuantity(new_quantity);
				
				//System.out.println(product.getQuantity());
				
				
				name_.add(product.getName());
				price_.add(product.getPrice());
				quantity_.add(count);
				
				productsService.addProduct(product);
				

		
			
			}
		}
		
		overall_price_ = price_sum;
		
		LocalDate today = LocalDate.now();
		
		Mahsulotpul mahsulot = new Mahsulotpul();
		
		mahsulot.setDate_time(today);
		
		mahsulot.setMoney(price_sum);
		
		mahsulotPulService.addMahsulot(mahsulot);
		
		
		HelloWorldPrinter hello = new HelloWorldPrinter(name_, price_, quantity_, overall_price_);
    	
    	hello.actionPerformed();
    	
    	name_.clear();
    	price_.clear();
    	quantity_.clear();
    	
    	
		return "redirect:/";
	}
}
