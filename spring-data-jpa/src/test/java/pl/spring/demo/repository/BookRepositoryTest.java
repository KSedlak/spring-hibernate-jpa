package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testShouldFindBookById() {
        // given
        final long bookId = 1;
        // when
        BookEntity bookEntity = bookRepository.findOne(bookId);
        // then
        assertNotNull(bookEntity);
    }
    
    @Autowired
   

    @Test
    public void testShouldFindBookByTitle() {
        // given
        final String title="Sample Book";
        // when
        List<BookEntity> books = bookRepository.findBookByTitle(title);
        // then
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(title,books.get(0).getTitle());
    }

    @Test
    public void testShouldFindBookNearPostCode() {
        // given
    	final String post="55-555";
        // when
        List<BookEntity> books = bookRepository.findBooksNearPostCode(post);
        // then
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals("Sample Book", books.get(0).getTitle());

    }
}
