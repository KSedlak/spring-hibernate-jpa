package pl.spring.demo.repository.impl;

import java.util.List;
import org.jinq.orm.stream.JinqStream;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.entity.PersonEntity;
import pl.spring.demo.jinq.JinqSource;
import pl.spring.demo.repository.PersonLambdaRepository;

public class PersonRepositoryJinqImpl implements PersonLambdaRepository{
	
   @Autowired
   private JinqSource jinqSource;

    
	@Override
	public List<PersonEntity> findAdultPersons() {
		return jinqSource.persons().where(per->per.getAge()>=18).toList();
	}

	@Override
	public List<PersonEntity> findNotAdultPersons() {
		return jinqSource.persons().where(per->per.getAge()<18).toList();
	}

	@Override
	public List<PersonEntity> findAllPersons() {
		return jinqSource.persons().toList();
	}

	@Override
	public List<PersonEntity> findAllPersonsSortedByAge() {
		return jinqSource.persons().sortedDescendingBy(per->per.getAge()).toList();
	}

	@Override
	public List<PersonEntity> findTheOldestUser() {
		JinqStream<PersonEntity> stream =jinqSource.persons();
		int max=stream.max(p->p.getAge()).intValue();
		return stream.where(per->per.getAge()==max).toList();

	}

	@Override
	public List<PersonEntity> findTheYoungestUser() {
		JinqStream<PersonEntity> stream = jinqSource.persons();
		int max=stream.min(p->p.getAge()).intValue();
		return stream.where(per->per.getAge()==max).toList();
	}

	@Override
	public double getAverageAge() {
		return jinqSource.persons().avg(p->p.getAge());
	}
	


}
