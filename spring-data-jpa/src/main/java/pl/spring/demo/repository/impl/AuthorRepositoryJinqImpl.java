package pl.spring.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.jinq.JinqSource;
import pl.spring.demo.repository.AuthorAdditionalQueries;

public class AuthorRepositoryJinqImpl implements AuthorAdditionalQueries {

    @Autowired
    private JinqSource jinqSource;
    
    
	@Override
	public List<AuthorEntity> findAutorsWithBiggestPublicationsNumber() {
		int max= jinqSource.authors().max(a->a.getPublicationsNumber());
		return jinqSource.authors().where(a->a.getPublicationsNumber()==max).toList();
	}
	
	
}
