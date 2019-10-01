package agentura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
@RequestMapping(path="/ajax")
public class AjaxController {

	@Autowired
	private KelionesRepository kelionesRepository;
	
	@Autowired 
	private  KlientaiRepository klientaiRepository;
	
	@Autowired 
	private KlientuKelionesRepository klientuKelionesRepository;
	
	@GetMapping(path="/saugoti-klienta")
	public @ResponseBody String saugotiKlienta(@RequestParam Integer id
			, @RequestParam String vardas_pavarde
			, @RequestParam Integer flag_poilsines
			, @RequestParam Integer flag_pazintines
			, @RequestParam Integer flag_viskas_iskaic
			, @RequestParam Integer flag_laisv_pasir
			) {
		String res = " Not done";
		Klientai n = new Klientai();
		
		if (id > 0) {
			Optional<Klientai> found = klientaiRepository.findById(id);
			
			if(found.isPresent()) {
				n = found.get();
				n.setId(id);
			}
		}
		n.setVardasPavarde (vardas_pavarde);
		
		klientaiRepository.save(n);
		res = "Saved";
		return res;		
	}
		
	@GetMapping(path="/salinti-klienta")
	public @ResponseBody String salintiKlienta (@RequestParam Integer id
	) {
		Optional<Klientai> found = klientaiRepository.findById(id);
		
		String res = "Not done";
		
		if(found.isPresent()) {
			Klientai n = found.get();
			klientaiRepository.deleteById(id);
			res = "deleted";
			
			
		}
		return res;
	}
	
	@GetMapping (path="/lst-klientai")
	public@ResponseBody Iterable<Klientai> getAllKlientai() {
		return klientaiRepository.findAll();
		
	}
	
	@GetMapping(path="/saugoti-keliones")
	public@ResponseBody String saugotiKeliones ( @RequestParam Integer id
			,@RequestParam String pav
			,@RequestParam String aprasymas
			,@RequestParam String pozymiai
			,@RequestParam String kaina
			) {
		String res = "Not done";
		Keliones n = new Keliones();
		if (id > 0) {
			Optional<Keliones> found = kelionesRepository.findById(id);
			if (found.isPresent()) {
				n = found.get();
				n.setId(id);
			}
		}
		n.setPav(pav);
		n.setAprasymas(aprasymas);
		n.setPozymiai(pozymiai);
		n.setKaina(kaina);
				
		kelionesRepository.save(n);
		res = "Saved";
		 return res;
	}
	@GetMapping(path="/salinti-keliones")
	public@ResponseBody String salintiKeliones (@RequestParam Integer id) {
		Optional<Keliones> found = kelionesRepository.findById(id);
		String res = "Not done";
		
		if (found.isPresent()) {
			Keliones n = found.get();
			kelionesRepository.deleteById(id);
			res = "Deleted";
			
		}
		 return res;
	}
	@GetMapping(path="/lst-keliones")
	public @ResponseBody Iterable<Keliones> getAllKeliones(){
		return kelionesRepository.findAll();
		
	}
	@GetMapping(path="/lst-klientu-keliones")
	public @ResponseBody Iterable<KlientuKeliones> getAllKlientuKeliones () {
		return klientuKelionesRepository.findAll();
	}
}
