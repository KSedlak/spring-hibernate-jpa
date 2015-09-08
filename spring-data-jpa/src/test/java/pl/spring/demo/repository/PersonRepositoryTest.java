
package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.PersonEntity;


import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

   @Test
    public void testShouldFindPersonByAgeLess() {
        // given
    	final int age=18;
        // when
        List<PersonEntity> PersonEntity =personRepository.findByAgeLessThan(age); 
        	int resultSize=PersonEntity.size();
        // the
        assertNotNull(PersonEntity);
        assertFalse(PersonEntity.isEmpty());
        assertEquals(1,resultSize);
    }
   

   @Test
   public void testShouldFindPersonByAgeGreater() {
       // given
   	final int age=18;
       // when
       List<PersonEntity> PersonEntity =personRepository.findByAgeGreaterThanEqual(age); 
       	int resultSize=PersonEntity.size();
       // the
       assertNotNull(PersonEntity);
       assertFalse(PersonEntity.isEmpty());
       assertEquals(2,resultSize);
   }
  

    
}
