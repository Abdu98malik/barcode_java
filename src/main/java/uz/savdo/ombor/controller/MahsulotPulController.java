package uz.savdo.ombor.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uz.savdo.ombor.entity.Mahsulotpul;
import uz.savdo.ombor.service.MahsulotPulService;

@Controller
@RequestMapping("/mahsulot-pul")
public class MahsulotPulController {

	@Autowired
	private MahsulotPulService mps;

	@GetMapping("/list")
	public String listMahsulot(Model theModel){
		List<Mahsulotpul> list = mps.getMahsulot();
		theModel.addAttribute("list", list);
		
		return "mahsulot-pul-list";
	}
	
	// for ajax
	@GetMapping("/by-date")
	public String byDate( @RequestParam("bydate") String bydate, Model theModel) {
		
		// parse(bydate);
		LocalDate day = LocalDate.parse(bydate);
		
		Mahsulotpul pul = mps.getMahsulotByDate(day);
		
		theModel.addAttribute("pul", pul); 	
		
		return "mahsulot-pul-list"; // temp I will write AJAX for that
	}
}
