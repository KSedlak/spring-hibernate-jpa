package pl.spring.demo.repository;

import java.util.List;
import pl.spring.demo.entity.BookEntity;



public interface BookAdditionalQueries {
	public List<BookEntity> findBooksNearPostCode(String post);
}
