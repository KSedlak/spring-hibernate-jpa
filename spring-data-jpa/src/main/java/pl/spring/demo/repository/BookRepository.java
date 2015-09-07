package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
	List<BookEntity> findBookByTitle(@Param("title") String title);
}
