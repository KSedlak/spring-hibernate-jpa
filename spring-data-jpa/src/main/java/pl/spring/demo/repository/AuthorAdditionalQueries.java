package pl.spring.demo.repository;

import java.util.List;
import pl.spring.demo.entity.AuthorEntity;

public interface AuthorAdditionalQueries {
List<AuthorEntity> findAutorsWithBiggestPublicationsNumber();

}
