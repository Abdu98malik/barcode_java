package uz.savdo.ombor.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uz.savdo.ombor.entity.Products;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("")
	public String main() {
		
		return "main";
	}
	
	@GetMapping("/saveOmbor")
	public String saveOmbor(@RequestParam Map<String, String> allParams) {
		
		int sum_final = Integer.parseInt(allParams.get("sum_final"));
		int product_type_count = Integer.parseInt(allParams.get("product_count"));
		int i = 0;
		
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
		i++;
			if(i>1) {//third loop
				String barcode = entry.getKey();
				int count = Integer.parseInt(entry.getValue());
				
				
				// get that product, 
				// remove count from ombor,
				// write to hisob 
			}
		}
		
		return "redirect:/";
	}
}
