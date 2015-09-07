package pl.spring.demo.service;

import pl.spring.demo.enums.LibraryType;
import pl.spring.demo.to.LibraryTo;

import java.util.List;

public interface LibraryService {

    List<LibraryTo> findAllLibraries();
    List<LibraryTo> findAllLibrariesByName(String name);
    List<LibraryTo> findAllLibrariesInCity(String cityName);
    List<LibraryTo> findAllLibrariesByType_custom(LibraryType type);
    List<LibraryTo> findLibrariesThatHaveBookByTitle(String bookTitle);
    LibraryTo saveOrUpdateLibrary(LibraryTo library);
	List<LibraryTo> findAllLibrariesByType(LibraryType type);
}
