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
	

	 @GetMapping (path="pasalinti-knyga")
	 public @ResponseBody String knygos (@RequestParam Integer id) {
		 Optional<Knygos> found = knygosRepository.findById(id);
		 
		 String rez = "Nebaigta";
		 Knygos n = found.get();
		 n.setId(id);
		 knygosRepository.deleteById(id);
		 rez = "Istrintas";
		 
		 return rez;
		 
	 }
	 
	 @GetMapping(path="prideti-knyga")
	 public @ResponseBody String redaguotiKnyga (@RequestParam Integer id
			 , @RequestParam String knygos_pav
			 , @RequestParam String autorius
			 , @RequestParam String isleidimo_metai	
			 ) {
		 
			String res = "Not done";
			Knygos n = new Knygos();
			 System.out.println ( "id: " + id );
			if (id > 0) {
				
				Optional<Knygos> rasta = knygosRepository.findById(id);
		 
		 
			 if (rasta.isPresent()) {
				   n = rasta.get();

					 System.out.println (n.toString());				   
				   // n.setId(id);
			 	}
			}
			
		 n.setKnygosPav(knygos_pav);
		 n.setAutorius(autorius);
		 n.setIsleidimo_metai(isleidimo_metai);
		 System.out.println (n.toString());
		 knygosRepository.save(n);
		 res = "Issaugota";
	 	return res; 
		 }
	 }
	
