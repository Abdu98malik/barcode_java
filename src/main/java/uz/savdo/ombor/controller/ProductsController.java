package uz.savdo.ombor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uz.savdo.ombor.entity.Products;
import uz.savdo.ombor.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		List<Products> products = productsService.getProducts();
		
		theModel.addAttribute("products",products);
		
		return "products-list";
	}
	
	@GetMapping("/add-form")
	public String addForm(Model theModel) {
		Products products = new Products();
		
		theModel.addAttribute(products);
		
		return "/products-add-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("products") Products products) {
		productsService.addProduct(products);
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/edit-form")
	public String editForm(@RequestParam("productId") int theId,
									Model theModel) {

		Products product = productsService.getProductById(theId);
		
		theModel.addAttribute("products", product);
			
		return "products-add-form";
	}
	

	
}
