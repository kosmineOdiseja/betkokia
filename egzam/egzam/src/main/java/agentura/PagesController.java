package agentura;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PagesController {
	
	@RequestMapping("/")
	public String home (Model  model) {
		model.addAttribute("lst_meniu", Menu.values());
		
		return "index";
	}

	@GetMapping("/keliones")
	public String keliones() {
		return "keliones";
		
	}
	@GetMapping("/klientai")
	public String klientai( ) {
		return "klientai";

	}
	@GetMapping("/klientukeliones")
	public String klientuKeliones () {
		return "klientukeliones";
	}
}
