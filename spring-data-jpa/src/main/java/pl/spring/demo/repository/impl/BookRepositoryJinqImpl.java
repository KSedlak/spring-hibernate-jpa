package pl.spring.demo.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.jinq.JinqSource;
import pl.spring.demo.repository.BookAdditionalQueries;

public class BookRepositoryJinqImpl  implements BookAdditionalQueries{
	
    @Autowired
    private JinqSource jinqSource;
    
    public List<BookEntity> findBooksNearPostCode(String post) {
    	
    	return jinqSource.books().where(a->a.getLibrary().getAddress().getPostalCode().equals(post)).toList();
    }
}
