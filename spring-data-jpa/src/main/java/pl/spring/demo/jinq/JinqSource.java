package pl.spring.demo.jinq;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Component;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

@Component
public class JinqSource {
  private JinqJPAStreamProvider streams;
  
  @PersistenceUnit
  public void setEntityManagerFactory(
      EntityManagerFactory emf) throws Exception {
    streams = new JinqJPAStreamProvider(emf);
    // Do any additional Jinq initialization needed here.
  }

  // Wrapper that passes through Jinq requests to Jinq
  public <U> JPAJinqStream<U> streamAll(
      EntityManager em, Class<U>entity) {
    return streams.streamAll(em, entity);
  }
  
  public JPAJinqStream<LibraryEntity> libraries(EntityManager em) {
	    return streams.streamAll(em, LibraryEntity.class);
}
  
  public JPAJinqStream<BookEntity> books(EntityManager em) {
	    return streams.streamAll(em, BookEntity.class);
}
}