package uz.savdo.ombor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uz.savdo.ombor.entity.Clients;
//import uz.savdo.ombor.service.AgentsService;
import uz.savdo.ombor.service.ClientsService;

@Controller
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	private ClientsService service;
	
	@GetMapping("/add")
	public String add(Model theModel) {
		Clients client = new Clients();
		
		theModel.addAttribute("client", client);
		
		return "clients-add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("client") Clients client) {
		service.add(client);
		return "redirect:/optom";
	}
}
