package ernadaslinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ernadaslinks.Kategorijos;
import ernadaslinks.KategorijosRepository;

import ernadaslinks.Nuorodos;
import ernadaslinks.NuorodosRepository;

import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/ajax") // This means URL's start with /demo (after Application path)
public class AjaxController {
	
	@Autowired
	private KategorijosRepository kategorijosRepository; 
	
	@Autowired
	private NuorodosRepository nuorodosRepository; 	
	
	@Autowired
	private ZymosRepository zymosRepository; 	
	
	@GetMapping(path="/saugoti-kategorija") // Map ONLY GET Requests
	public @ResponseBody String saugotiTiekeja (@RequestParam Integer id 
			, @RequestParam String pav
			, @RequestParam Integer id_parent
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Kategorijos n = new Kategorijos();
		
		if (id > 0) {
		
			Optional <Kategorijos> found = kategorijosRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    
	    if (id_parent > 0 ) {
	    	
	    	n.setId_parent( id_parent );
	    }
			   			   
	    kategorijosRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-kategorija") // Map ONLY GET Requests
	public @ResponseBody String salintiTiekeja (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Kategorijos> found = kategorijosRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Kategorijos n = found.get();
			   kategorijosRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}		

	@GetMapping(path="/lst-kategorijos")
	public @ResponseBody Iterable<Kategorijos> getAllKategorijos() {
		// This returns a JSON or XML with the users
		return kategorijosRepository.findAll();
	}	
	
	@GetMapping(path="/saugoti-nuoroda") // Map ONLY GET Requests
	public @ResponseBody String saugotiNuoroda (@RequestParam Integer id 
			, @RequestParam String pav
			, @RequestParam String link	
			, @RequestParam Integer kategorijos_id	
			, @RequestParam String tipas	
			, @RequestParam Integer rating 
			, @RequestParam String flags	
			, @RequestParam String aprasymas
 			, @RequestParam String zymos			
 			, @RequestParam String zymosadd
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Nuorodos n = new Nuorodos();
		
		if (id > 0) {
		
			Optional <Nuorodos> found = nuorodosRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    n.setKategorijos_id(kategorijos_id);
	    n.setLink(link);
	    n.setTipas(tipas);
	    n.setRating(rating);
	    n.setFlags(flags);
	    n.setAprasymas(aprasymas);
			   			   
	    nuorodosRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-nuoroda") // Map ONLY GET Requests
	public @ResponseBody String salintiNuoroda (@RequestParam Integer id ) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Nuorodos> found = nuorodosRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Nuorodos n = found.get();
			   nuorodosRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}		

	@GetMapping(path="/lst-nuorodos")
	public @ResponseBody Iterable<Nuorodos> getAllNuorodos() {
		// This returns a JSON or XML with the users
		return nuorodosRepository.findAll();
	}	
	
	@GetMapping(path="/lst-zymos")
	public @ResponseBody Iterable<Zymos> getAllZymos() {
		// This returns a JSON or XML with the users
		return zymosRepository.findAll();
	}	
	
}
