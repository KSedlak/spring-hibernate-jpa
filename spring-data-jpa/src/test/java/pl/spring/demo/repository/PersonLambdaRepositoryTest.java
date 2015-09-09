package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.PersonEntity;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class PersonLambdaRepositoryTest {

    @Autowired
    private PersonLambdaRepository personLambdaRepository;

    @Test
    public void testShouldReturnAllPersons() {
        // when  
        List<PersonEntity> persons = personLambdaRepository.findAllPersons();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
    }

    
    @Test
    public void testShouldReturnAllAdultPersons() {
        // when
        List<PersonEntity> persons = personLambdaRepository.findAdultPersons();
        int size=persons.size();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(2, size);
    }
   
    @Test
    public void testShouldReturnAllNotAdultPersons() {
        // when
        List<PersonEntity> persons = personLambdaRepository.findNotAdultPersons();
        int size=persons.size();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(1, size);
    }
    @Test
    public void testShouldReturnAllPersonsSorted() {
        // when  
        List<PersonEntity> persons = personLambdaRepository.findAllPersonsSortedByAge();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(44, persons.get(0).getAge());
    }
   
    @Test
    public void testShouldFindOldest() {
        // when
        List<PersonEntity> persons = personLambdaRepository.findTheOldestUser();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(44, persons.get(0).getAge());
    }
    @Test
    public void testShouldFindYoungest() {
        // when
        List<PersonEntity> persons = personLambdaRepository.findTheYoungestUser();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(17, persons.get(0).getAge());
    }
    @Test
    public void testAverageAge(){
    	   // when  
    	double result=personLambdaRepository.getAverageAge();
    	//then
        assertNotNull(result);
        assertEquals(26.33, result,0.1);
    }
}
