package pl.spring.demo.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.entity.PersonEntity;
import pl.spring.demo.repository.PersonLambdaRepository;

public class PersonRepositoryImpl implements PersonLambdaRepository{
	
    @PersistenceContext(name = "hsql")
    private EntityManager entityManager;
    @Autowired
    private JinqJPAStreamProvider jinqJPAStreamProvider;

    
	@Override
	public List<PersonEntity> findAdultPersons() {
		return jinqJPAStreamProvider.streamAll(entityManager, PersonEntity.class).where(per->per.getAge()>=18).toList();
	}

	@Override
	public List<PersonEntity> findNotAdultPersons() {
		return jinqJPAStreamProvider.streamAll(entityManager, PersonEntity.class).where(per->per.getAge()<18).toList();
	}

	@Override
	public List<PersonEntity> findAllPersons() {
		return jinqJPAStreamProvider.streamAll(entityManager, PersonEntity.class).toList();
	}

}
