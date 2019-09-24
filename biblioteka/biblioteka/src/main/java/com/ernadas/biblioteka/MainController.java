package com.ernadas.biblioteka;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/restfull")
public class MainController {

	@Autowired
	private KnygosRepository knygosRepository;
	
	@Autowired
	private AutoriusRepository autoriusRepository;
	
	@GetMapping(path="/visos-knygos")
	public @ResponseBody Iterable<Knygos> getAllKnyga() {
	return knygosRepository.findAll();
	}
	
	@GetMapping(path="/autorius")
	public @ResponseBody Optional<Autorius> Knygos(@RequestParam Integer id) {
		return autoriusRepository.findById(id);
				
		}
	
	@GetMapping(path="/prideti_knyga?") 
	public @ResponseBody String naujaKnyga ( 
			@RequestParam String knygos_pav  
			, @RequestParam String autorius  
			, @RequestParam String isleidimo_metai 
			) {
		Knygos k = new Knygos();
		k.setKnygos_pav(knygos_pav);
		k.setAutorius(autorius);
		k.setIsleidimo_metai(isleidimo_metai);
		System.out.println (k.toString() );
		knygosRepository.save(k);
		return "Issaugotas";
	}
	
	 @GetMapping (path="pasalinti_knyga")
	 public @ResponseBody String knygos (@RequestParam Integer id) {
		 Optional<Knygos> rasta = knygosRepository.findById(id);
		 
		 String rez = "Nebaigta";
		 Knygos n = rasta.get();
		 n.setId(id);
		 knygosRepository.deleteById(id);
		 rez = "Istrintas";
		 
		 return rez;
		 
	 }
	 
	 @GetMapping(path="redaguoti_knyga")
	 public @ResponseBody String redaguotiKnyga (@RequestParam Integer id
			 , @RequestParam String knygos_pav
			 , @RequestParam String autorius
			 , @RequestParam String isleidimo_metai	
			 ) {
		 Optional<Knygos> rasta = knygosRepository.findById(id);
		 String rez =" Nebaigta ";
		 
		 if (rasta.isPresent()) {
			 Knygos n = rasta.get();
			 n.setId(id);
			 n.setKnygos_pav(knygos_pav);
			 n.setAutorius(autorius);
			 n.setIsleidimo_metai(isleidimo_metai);
			 
			 knygosRepository.save(n);
			 rez = "Issaugota";
		 	}
		 return rez; 
		 }
 	 	
	 }
	
