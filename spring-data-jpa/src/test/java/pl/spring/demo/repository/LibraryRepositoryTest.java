package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.enums.LibraryType;
import pl.spring.demo.searchcriteria.LibrarySearchCriteria;

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
        LibraryType result= libraryEntity.get(0).getLibraryType();
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
        List<LibraryEntity> libraryEntity = libraryRepository.findByLibraryType(type);
        LibraryType result= libraryEntity.get(0).getLibraryType();
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
   @Test
   public void testShouldReturnAllLibraries() {
       // given when
       List<LibraryEntity> allLibraries = libraryRepository.findAllLibraries();
       // then
       assertNotNull(allLibraries);
       assertFalse(allLibraries.isEmpty());
   }

   @Test
   public void testShouldFindLibraryById() {
       // given
       final long id = 1;
       // when
       LibraryEntity library = libraryRepository.findLibraryById(id);
       // then
       assertNotNull(library);
       assertEquals(id, library.getId().longValue());
   }

   @Test
   public void testShouldNotFindLibraryById() {
       // given
       final long id = -1;
       // when
       LibraryEntity library = libraryRepository.findLibraryById(id);
       // then
       assertNull(library);
   }

   @Test
   public void testShouldReturnLibraryByBookSearchCriteria() {
       // given
       String bookTitle = "Sample Book";
       LibrarySearchCriteria searchCriteria = new LibrarySearchCriteria.LibrarySearchCriteriaBuilder().withBook(bookTitle).build();
       // when
       List<LibraryEntity> libraries = libraryRepository.findLibrariesBySearchCriteria(searchCriteria);
       // then
       assertNotNull(libraries);
       assertFalse(libraries.isEmpty());
       assertEquals(1, libraries.size());
   }
   @Test
   
   public void testShouldFindLibraryByTypeSearchCriteria() {
       // given
       final LibraryType type=LibraryType.academic;
       LibrarySearchCriteria searchCriteria = new LibrarySearchCriteria.LibrarySearchCriteriaBuilder().withType(type).build();
       // when
       List<LibraryEntity> libraries = libraryRepository.findLibrariesBySearchCriteria(searchCriteria);
       LibraryType res=libraries.get(0).getLibraryType();
       // then
       assertNotNull(libraries);
       assertEquals(type, res);
   }
   
   @Test   
   public void testShouldFindLibraryByType() {
       // given
       final LibraryType type=LibraryType.academic;
       // when
       List<LibraryEntity> libraries = libraryRepository.findLibraryByType(type);
       LibraryType res=libraries.get(0).getLibraryType();
       // then
       assertNotNull(libraries);
       assertEquals(type, res);
   }
       @Test   
       public void testShouldFindLibraryByStreet() {
           // given
           final String street="Strzegomska";
           // when
           LibraryEntity library = libraryRepository.findLibraryByStreet(street);
           String res=library.getAddress().getStreet();
           // then
           assertNotNull(library);
           assertEquals(street, res);
       }
       
       @Test   
       public void testShouldFindBooksInLibraryById() {
           // given
           final long id=1;
           // when
           List<BookEntity> books = libraryRepository.findAllBooksInLibrary(id);
          String res=books.get(0).getTitle();
           // then
           assertNotNull(books);
           assertEquals("Sample Book", res);
       }

    
}
