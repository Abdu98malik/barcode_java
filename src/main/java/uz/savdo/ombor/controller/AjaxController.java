package uz.savdo.ombor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uz.savdo.ombor.entity.Products;
import uz.savdo.ombor.service.ProductsService;

@RestController
public class AjaxController {

	@Autowired
	private ProductsService productService;
	
	
	@PostMapping("/get-product-by-barcode")
	public Products getProductByBarcode(@RequestParam(value="barcode") String barcode ) {
		Products product = productService.getProductByBarcode(barcode);
		
		return product;
		
	}
	
}