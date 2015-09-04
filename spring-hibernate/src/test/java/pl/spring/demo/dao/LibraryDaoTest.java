package pl.spring.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.enums.TypesLibrary;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoTest {

    @Autowired
    private LibraryDao libraryDao;

    @Test
    public void testShouldFindLibraryByName() {
        // given
        final String libraryName = "Biblioteka M";
        // when
        List<LibraryEntity> libraryEntity = libraryDao.findByName(libraryName);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
    }
    
    @Test
    public void testShouldFindLibrariesByType() {
        // given
        final TypesLibrary type=TypesLibrary.academic;
        // when
        List<LibraryEntity> libraryEntity = libraryDao.findByType(type);
        TypesLibrary res=libraryEntity.get(0).getTypeL();
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals(type.toString(),res.toString());
    }
}