package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.entity.PersonEntity;

public interface PersonLambdaRepository {
	List<PersonEntity> findAllPersons();
	List<PersonEntity> findAdultPersons();
	List<PersonEntity> findNotAdultPersons();
	List<PersonEntity> findAllPersonsSortedByAge();
	
}
