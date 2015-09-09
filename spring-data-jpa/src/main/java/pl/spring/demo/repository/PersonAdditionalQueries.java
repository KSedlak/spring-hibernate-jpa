package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.entity.PersonEntity;

public interface PersonAdditionalQueries {
	List<PersonEntity> findAllPersons();
	List<PersonEntity> findAdultPersons();
	List<PersonEntity> findAllPersonsSortedByAge();
	List<PersonEntity> findTheOldestUser();
	List<PersonEntity> findTheYoungestUser();
	double getAverageAge();
	List<PersonEntity> findByLastName(String lastName);
	List<PersonEntity> findNotAdultPersons();
}
