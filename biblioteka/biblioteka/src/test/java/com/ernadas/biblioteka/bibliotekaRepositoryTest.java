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
public class BibliotekaRepositoryTest {
	
    @Autowired
    private KnygosRepository knygosRepository;
   
    @Test
    public void testSaveGetKnygos() {

        																			     	
    	Knygos knygos = new Knygos("Benas", "Jonas Jonaitis", "2000");
        Knygos knyg = knygosRepository.save(knygos);
        Knygos knyge = knygosRepository.findByKnygosPav("Benas");
        
        System.out.println (knyg.toString());        
        System.out.println (knyge.toString());        
       
        																			       
        assertNotNull(knygos);
        																			         
        assertNotNull(knyge);        
        																			          
        assertEquals(knyge.getKnygosPav(), knygos.getKnygosPav());
        																				
        assertEquals(knyge.getAutorius(), knygos.getAutorius());
        
        System.out.println (knyg.getId());
        																				   
        
        knygosRepository.deleteById(knyg.getId());				  
        																		       
    }
    
    @Test   
    public void testKnygos() {
        assertNotNull(knygosRepository.findAll());
    }
    
    @Test    
    public void deleteFoundedByName() {
        																		      
        Knygos knygos = new Knygos( "Jonas", "Jonas Jonaitis","2001");     
        knygosRepository.delete( knygos );                  					  
    }    

    @Test
    public void deletByKnygosIdTest() {
    	
		Knygos knyg = null;
        Knygos knygos = new Knygos( "Jonas Sėkla", "Povilas Kupraitis", "2002");    	
        Knygos knyge = knygosRepository.save(knygos);
        knygosRepository.deleteById(knyge.getId());     
    }   
}