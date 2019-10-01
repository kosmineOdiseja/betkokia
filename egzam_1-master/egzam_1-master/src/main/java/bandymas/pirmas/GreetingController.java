package bandymas.pirmas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/autorius")
	public String autoriai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "autorius";
	    
	}
	 
	@GetMapping("/knyga")
	public String knygos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "knyga";
	    
	}
	
}