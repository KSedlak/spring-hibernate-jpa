package pl.spring.demo.dao;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.enums.TypesLibrary;

import java.util.List;

public interface LibraryDao extends Dao<LibraryEntity> {

    List<LibraryEntity> findByName(String name);
    List<LibraryEntity> findByType(TypesLibrary type);
    List<LibraryEntity> findByCity(String cityName);
    List<LibraryEntity> findLibrariesThatHaveBookByTitle(String bookTitle);
}
