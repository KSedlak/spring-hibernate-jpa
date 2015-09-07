package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	List<PersonEntity> findByAgeLessThanEqual(@Param("age") int age);
}