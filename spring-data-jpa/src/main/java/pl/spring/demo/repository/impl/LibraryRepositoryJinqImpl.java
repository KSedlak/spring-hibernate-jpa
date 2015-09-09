package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.jinq.JinqSource;
import pl.spring.demo.repository.LibraryAdditionalQueries;

//Implements custom queries using Jinq
public class LibraryRepositoryJinqImpl  implements LibraryAdditionalQueries {


    @PersistenceContext(name = "hsql")
    private EntityManager entityManager;
    @Autowired
    private JinqSource source; 
	@Override
	public List<LibraryEntity> filterLibrariesByCity(String city) {

		   return source.libraries().where(l->l.getAddress().getCity().equals(city)).toList();
	}


}