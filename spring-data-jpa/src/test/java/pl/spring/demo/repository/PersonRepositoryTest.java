
package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.entity.PersonEntity;
import pl.spring.demo.enums.LibraryType;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

   @Test
    public void testShouldFindPersonByAge() {
        // given
    	final int age=18;
        // when
        List<PersonEntity> PersonEntity =personRepository.findByAgeLessThanEqual(age); 
        	int resultSize=PersonEntity.size();
        // the
        assertNotNull(PersonEntity);
        assertFalse(PersonEntity.isEmpty());
        assertEquals(2,resultSize);
    }
   


    
}
