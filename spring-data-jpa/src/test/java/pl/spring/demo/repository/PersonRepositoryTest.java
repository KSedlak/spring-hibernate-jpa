
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
   @Test
   public void testShouldReturnAllPersons() {
       // when  
       List<PersonEntity> persons = personRepository.findAllPersons();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
   }

   
   @Test
   public void testShouldReturnAllAdultPersons() {
       // when
       List<PersonEntity> persons = personRepository.findAdultPersons();
       int size=persons.size();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(2, size);
   }
  
   @Test
   public void testShouldReturnAllNotAdultPersons() {
       // when
       List<PersonEntity> persons = personRepository.findNotAdultPersons();
       int size=persons.size();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(1, size);
   }
   @Test
   public void testShouldReturnAllPersonsSorted() {
       // when  
       List<PersonEntity> persons = personRepository.findAllPersonsSortedByAge();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(44, persons.get(0).getAge());
   }
  
   @Test
   public void testShouldFindOldest() {
       // when
       List<PersonEntity> persons = personRepository.findTheOldestUser();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(44, persons.get(0).getAge());
   }
   @Test
   public void testShouldFindYoungest() {
       // when
       List<PersonEntity> persons = personRepository.findTheYoungestUser();
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(17, persons.get(0).getAge());
   }
   @Test
   public void testAverageAge(){
   	   // when  
   	double result=personRepository.getAverageAge();
   	//then
       assertNotNull(result);
       assertEquals(26.33, result,0.1);
   }
   
   @Test
   public void testFindByLastName() {
	final String name="Nowak";
	   // when
       List<PersonEntity> persons = personRepository.findByLastName(name);
       // then
       assertNotNull(persons);
       assertFalse(persons.isEmpty());
       assertEquals(name, persons.get(0).getLastName());
   }
    
}
