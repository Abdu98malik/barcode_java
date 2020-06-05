package uz.savdo.ombor.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uz.savdo.ombor.entity.Products;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("")
	public String main() {
		
		return "main";
	}
}
