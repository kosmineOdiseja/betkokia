package bandymas.pirmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller    
@RequestMapping(path="/restfull") 
public class MainController {
						
	@Autowired         	
	private KnygaRepository KnygaRepository;
	
	@Autowired
	private AutoriusRepository AutoriusRepository;

	// Knygos SQL
	
	@GetMapping(path="/all_knyga")
	public @ResponseBody Iterable<Knyga> getAllKnyga() {
		
		return KnygaRepository.findAll();
	}
	
	@GetMapping(path="/knyga")
	public @ResponseBody Optional<Knyga> Knyga(@RequestParam Integer id) {
		
		return KnygaRepository.findById (id);
	}
	
	@GetMapping(path="/trink_knyga") 
	public @ResponseBody String knyga (@RequestParam Integer id ) {
				
		Optional <Knyga> found = KnygaRepository.findById( id );
		
		String res = "Not done";
		Knyga n = found.get();
		n.setId(id);
		KnygaRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_knyga") 
	public @ResponseBody String redaguotiknyg (@RequestParam Integer id
			, @RequestParam String pavadinimas
			, @RequestParam String tipas
						
			) {
				
		Optional <Knyga> found = KnygaRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Knyga n = found.get();
			   n.setId(id);
			   n.setPavadinimas(pavadinimas);
			   n.setTipas(tipas);
			   				
			   KnygaRepository.save(n);	
			   res = "Saved"; 
			   			}
		return res;
	}
	
	@GetMapping(path="/add_knyga") 
	public @ResponseBody String addNewKnyga (@RequestParam String pavadinimas
			, @RequestParam String tipas
			, @RequestParam Integer autorius_id)
			 {
				
		Knyga n = new Knyga();
		n.setPavadinimas(pavadinimas);
		n.setTipas(tipas);
		n.setAutorius_id(autorius_id);
		KnygaRepository.save(n);
		return "Saved";
	}
	
	//---------------------- Autorius SQL --------------------------------------------
	
	@GetMapping(path="/all_autorius")
	public @ResponseBody Iterable<Autorius> getAllAutorius() {
		
		return AutoriusRepository.findAll();
	}
	
	@GetMapping(path="/autorius")
	public @ResponseBody Optional<Autorius> Autorius(@RequestParam Integer id) {
		
		return AutoriusRepository.findById (id);
	}
	
	@GetMapping(path="/trink_autorius") 
	public @ResponseBody String autorius (@RequestParam Integer id ) {
				
		Optional <Autorius> found = AutoriusRepository.findById( id );
		
		String res = "Not done";
		Autorius n = found.get();
		n.setId(id);
		AutoriusRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_autorius") 
	public @ResponseBody String redaguotiautoriu (@RequestParam Integer id
			, @RequestParam String vardas
			, @RequestParam String pavarde
						
			) {
				
		Optional <Autorius> found = AutoriusRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Autorius n = found.get();
			   n.setId(id);
			   n.setVardas(vardas);
			   n.setPavarde(pavarde);
			   				
			   AutoriusRepository.save(n);	
			   res = "Saved"; 
			   			}
		return res;
	}
	
	@GetMapping(path="/add_autorius")
	public @ResponseBody String addNewAutorius (@RequestParam String vardas
			, @RequestParam String pavarde )
			 {
				
		Autorius n = new Autorius();
		n.setVardas(vardas);
		n.setPavarde(pavarde);
		AutoriusRepository.save(n);
		return "Saved";
	}
	
}