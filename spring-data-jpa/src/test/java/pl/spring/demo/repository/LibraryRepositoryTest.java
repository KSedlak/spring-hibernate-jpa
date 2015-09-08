package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.enums.LibraryType;


import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void testShouldFindLibraryByName() {
        // given
        final String libraryName = "Biblioteka M";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByName(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
    }

    @Test
    public void testShouldFindLibraryByNameLike() {
        // given
        final String libraryName = "Biblioteka M%";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByNameLike(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
    }
    
    @Test
    public void testShouldFindLibrarariesByType_custom() {
        // given
    	final LibraryType type=LibraryType.academic;
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByType_custom(type);
        LibraryType result= libraryEntity.get(0).getTypeL();
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals(type.toString(),result.toString());
    }
    
   @Test
    public void testShouldFindLibrarariesByType() {
        // given
    	final LibraryType type=LibraryType.academic;
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findByTypeL(type);
        LibraryType result= libraryEntity.get(0).getTypeL();
        // the
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals(type.toString(),result.toString());
    }
   
   @Test
   public void testShouldFindLibrarariesByStreet() {
       // given
	   final String street = "Strzegomska";
       // when
       List<LibraryEntity> libraryEntity = libraryRepository.findByAddress_Street(street);
       String result= libraryEntity.get(0).getAddress().getStreet();
       // the
       assertNotNull(libraryEntity);
       assertFalse(libraryEntity.isEmpty());
       assertEquals(street,result);
   }
  

    
}
