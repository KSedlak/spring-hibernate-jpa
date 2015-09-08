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
        // given when
        List<PersonEntity> persons = personLambdaRepository.findAllPersons();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
    }

    
    @Test
    public void testShouldReturnAllAdultPersons() {
        // given when
        List<PersonEntity> persons = personLambdaRepository.findAdultPersons();
        int size=persons.size();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(2, size);
    }
   
    @Test
    public void testShouldReturnAllNotAdultPersons() {
        // given when
        List<PersonEntity> persons = personLambdaRepository.findNotAdultPersons();
        int size=persons.size();
        // then
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertEquals(1, size);
    }
   
}
