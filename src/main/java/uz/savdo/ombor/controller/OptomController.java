package uz.savdo.ombor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import uz.savdo.ombor.entity.Agents;
import uz.savdo.ombor.entity.Clients;
import uz.savdo.ombor.entity.OptomProducts;
import uz.savdo.ombor.service.AgentsService;
import uz.savdo.ombor.service.ClientsService;
import uz.savdo.ombor.service.OptomProductsService;
import uz.savdo.ombor.view.ExcelView;

@Controller
@RequestMapping("/optom")
public class OptomController {

	@Autowired
	private OptomProductsService service;
	
	@Autowired
	private AgentsService agents;
	
	@Autowired
	private ClientsService clients;
	
	@GetMapping("")
	public String optom(Model themodel) {
		List<OptomProducts> list = service.listProducts();
		List<Agents> agentlist = agents.list();
		List<Clients> clientlist = clients.list();
		
		themodel.addAttribute("list", list);
		themodel.addAttribute("agents", agentlist);
		themodel.addAttribute("clients", clientlist);
		
		return "optom";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		
		OptomProducts products = new OptomProducts();
		
		theModel.addAttribute("products",products);
		
		return "optom-product-add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("products") OptomProducts product) {
		service.addProduct(product);
		
		return "redirect:/optom/list";
	}
	
	@GetMapping("/list")
	public String list(Model theModel) {
		List<OptomProducts> pro = service.listProducts();
		theModel.addAttribute("products", pro);
		return "optom-list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("productId") int theId,
									Model theModel) {

		OptomProducts product = service.getProduct(theId);
		
		theModel.addAttribute("products", product);
			
		return "optom-product-add";
	}
	
	@RequestMapping("/json")
	public void json(HttpServletResponse response, @RequestParam(value="malumot") String str, @RequestParam(value="tablitsa") String tb) {
		
		Map<String, String> mal = null;
		Map<String, ArrayList<String>> tab = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		 mal = mapper.readValue(str, Map.class);
		
		//System.out.println(map);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ObjectMapper mappe = new ObjectMapper();
		try {
		tab = mappe.readValue(tb, Map.class);
		
		//System.out.println(map);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ExcelView e1=new ExcelView();
		e1.excel(response,mal,tab);
		
		
	}
}
