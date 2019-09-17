package com.ernadas.biblioteka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GreetingController {
	
	@GetMapping("/knygos")
	public String greeting() {
		return "knygos";
	}
	@GetMapping("/autorius")
	public String papildomas() {
		return "autorius";
	}
}
