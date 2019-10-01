package bandymas.pirmas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirmasApplicationTests {

	 @Autowired
	 private KnygaRepository knygaRepository;
	 
	 @Test
	 public void testSaveGetKnyga() {
	 
		 Knyga knyga = new Knyga("Saule", "romanas");
	     Knyga knyg = knygaRepository.save(knyga);
	     Knyga kny = knygaRepository.findByPavadinimas("Saule");
	        																			        
	     assertNotNull(knyga);
	        																			        
	     assertNotNull(kny);        
	        																			         
	     assertEquals(kny.getPavadinimas(), knyga.getPavadinimas());
	        																				
	     assertEquals(kny.getTipas(), knyga.getTipas());
	        																				     
	     knygaRepository.deleteById(knyg.getId());        					  
	     System.out.println (" ending here test ! ");
	 
	 }
	 
	 @Test
	 public void testFindAllKnyga() {
		 
	    assertNotNull(knygaRepository.findAll());
	    
	 }
	 
	 @Test    
	 public void deleteFoundedByName() {
	        																			       
		 Knyga knyga = new Knyga( "menulis", "apysaka");        
		 knygaRepository.delete(knyga);                  					  
	 }    

	 @Test
	 public void deletByKnygaIdTest() {
	    	
		 Knyga knyga = new Knyga( "sėklos", "sci-fi");    	
	     Knyga kny = knygaRepository.save(knyga);
	     knygaRepository.deleteById(kny.getId());
	     
	 }   
	 
}