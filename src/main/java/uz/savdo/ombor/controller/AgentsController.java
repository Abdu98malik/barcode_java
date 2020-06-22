package uz.savdo.ombor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uz.savdo.ombor.entity.Agents;
import uz.savdo.ombor.service.AgentsService;

@Controller
@RequestMapping("/agents")
public class AgentsController {

	@Autowired
	private AgentsService service;
	
	@GetMapping("/add")
	public String add(Model theModel) {
		Agents agent = new Agents();
		
		theModel.addAttribute("agent", agent);
		
		return "agents-add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("agent") Agents agent) {
		service.add(agent);
		return "redirect:/optom";
	}
}
