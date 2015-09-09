package pl.spring.demo.repository;
import java.util.List;

import pl.spring.demo.entity.LibraryEntity;


public interface LibraryAdditionalQueries {
	
List<LibraryEntity> filterLibrariesByCity(String city);
}
