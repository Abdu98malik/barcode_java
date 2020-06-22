package uz.savdo.ombor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import uz.savdo.ombor.entity.Products;
import uz.savdo.ombor.service.ProductsService;
import uz.savdo.ombor.view.ExcelView;

@RestController
public class AjaxController {

	@Autowired
	private ProductsService productService;
	
	
	@PostMapping("/get-product-by-barcode")
	@CrossOrigin(origins = "http://localhost:8080")
	public Products getProductByBarcode(@RequestParam(value="barcode") String barcode ) {
		Products product;
		
		try{
			product = productService.getProductByBarcode(barcode);
		}catch(Exception e) {
			return null;
		}
		
		
		return product;
		
	}
	
	@PostMapping("jsontable")
	@CrossOrigin(origins = "http://localhost:8080")
	public void jsontable(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="result") String str, @RequestParam(value="table") String tb) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		Map<String, String> map = mapper.readValue(str, Map.class);
		
	//	System.out.println(map);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ObjectMapper mappe = new ObjectMapper();
		try {
		Map<String, String> map = mappe.readValue(tb, Map.class);
		
		//System.out.println(map);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		//ExcelView e1=new ExcelView();
		//e1.excel(response);
		
	}
	
	
	
}









