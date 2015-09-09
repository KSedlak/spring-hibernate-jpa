package pl.spring.demo.repository;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.enums.LibraryType;
import pl.spring.demo.searchcriteria.LibrarySearchCriteria;

import java.util.List;

/**
 * http://www.jinq.org/docs/jpa.html
 */
public interface LibraryAdditionalQueries {

    List<LibraryEntity> findAllLibraries();
    LibraryEntity findLibraryById(long id);
    List<LibraryEntity> findLibraryByType(LibraryType type);
    LibraryEntity findLibraryByStreet(String streetName);
    List<LibraryEntity> findLibrariesBySearchCriteria(LibrarySearchCriteria librarySearchCriteria);
    List<BookEntity> findAllBooksInLibrary(long id);
}
