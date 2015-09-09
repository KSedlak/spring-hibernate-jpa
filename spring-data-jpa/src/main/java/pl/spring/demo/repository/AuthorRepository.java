package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.AuthorEntity;


public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>, AuthorAdditionalQueries {
	
	List<AuthorEntity> findByPublicationsNumberGreaterThanEqual(@Param("publicationsNumber") int publicationsNumber);//autoGenerated
}
