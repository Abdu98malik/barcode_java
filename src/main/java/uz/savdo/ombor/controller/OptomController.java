package uz.savdo.ombor.controller;

import java.time.LocalDate;
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
import uz.savdo.ombor.entity.Mahsulotpul;
import uz.savdo.ombor.entity.OptomProducts;
import uz.savdo.ombor.entity.Products;
import uz.savdo.ombor.service.AgentsService;
import uz.savdo.ombor.service.ClientsService;
import uz.savdo.ombor.service.MahsulotPulService;
import uz.savdo.ombor.service.OptomProductsService;
import uz.savdo.ombor.service.ProductsService;
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
	
	@Autowired 
	private MahsulotPulService mahservice;
	
	@Autowired
	private ProductsService proservice;
	
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
		
		Mahsulotpul pulli = new Mahsulotpul();
		pulli.setDate_time(LocalDate.now());
		pulli.setMoney(Integer.parseInt(mal.get("sum")));
		
		mahservice.addMahsulot(pulli);
		
		//minus from database using barcode
		int ci = 0;
		
		for(Map.Entry<String, ArrayList<String>> entry: tab.entrySet()) {
			
			//soni
			if(ci>0) {
			int son = Integer.parseInt(entry.getValue().get(2));
			
			//barcode
			String bar = entry.getValue().get(6);
			
			Products prod = proservice.getProductByBarcode(bar);
			
			
			
			int cur_son = prod.getQuantity();
			
			int new_son = cur_son - son ;
			
			prod.setQuantity(new_son);
			
			proservice.addProduct(prod);
			
			prod = null;
			}
			ci++;
			
		}
		
		
		ExcelView e1=new ExcelView();
		e1.excel(response,mal,tab);
		
		
	}
}
