package com.ernadas.biblioteka;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
																						// import org.springframework.boot.test.autoconfigure.orm.jpa.*; - nereikia iš pvz. !
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
																					
public class bibliotekaRepositoryTest {
	
    @Autowired
    private KnygosRepository produktaiRepository;
   
    @Test
    public void testSaveGetKnygos() {

        																			     	
    	Knygos knygos = new Knygos("Benas", "Jonas Jonaitis", 2000);
        Knygos knyg = knygosRepository.save(knygos);
        Knygos Knyge = knygosRepository.findByPav("Benas");
        																			       
        assertNotNull(knygos);
        																			         
        assertNotNull(knyg);        
        																			          
        assertEquals(knyg.getKnygos_pav(), knygos.getKnygos_pav());
        																				
        assertEquals(knyg.getAutorius(), knygos.getIsleidimo_metai());
        																				   
        
        knygosRepository.deleteById(knyg.getId());				  
        																		       
    }
    
    @Test   
    public void testKnygos() {
        assertNotNull(knygosRepository.findAll());
    }
    
    @Test    
    public void deleteFoundedByName() {
        																		      
        Knygos knygos = new Knygos( "Jonas", "Jonas Jonaitis", 2000,); 
        Knygos knyg = knygosRepository.save( knygos );        
        knygosRepository.delete( prod );                  					  
        Knygos knygo = knygosRepository.findByKnygos_pav("Jonas");
        assertEquals( knygo, null );		
    }    

    @Test
    public void deletByKnygosIdTest() {
    	
		Knygos Knygo = null;
        Knygos knygos = new Knygos( "Jonas Sėkla", "Povilas Kupraintis", 2000.04.01,;    	
        Knygos Knyg = knygosRepository.save(knygos);
        Integer id = Knyg.getId();
        knygosRepository.deleteById(id);
        Optional <Knygos> found = produktaiRepository.findById ( id );
        
		if ( found.isPresent() ) {
			
			   Knygo = found.get();
		}
        assertEquals( Knygo, null );        
    }   
}