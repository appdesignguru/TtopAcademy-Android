package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategorySubjectLocalDataSourceTest {

    private CategorySubjectLocalDataSource categorySubjectLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectDao fakeCategorySubjectDao = new FakeCategorySubjectDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        categorySubjectLocalDataSource = new CategorySubjectLocalDataSourceImpl(
                fakeCategorySubjectDao, fakeDateTimeUtility
        );

        // PreSave
        List<CategorySubject> categorySubjects = new ArrayList<>();
        categorySubjects.add(new CategorySubject(1, 1, 1, new Date()));
        categorySubjects.add(new CategorySubject(2, 1, 2, new Date()));

        categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects);
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        boolean result = categorySubjectLocalDataSource.isOutdated();
        assertTrue(result);
    }

    @Test
    public void getCategorySubjects_ShouldReturnAllForGivenParameter(){
        int categoryID = 1;
        List<CategorySubject> result = categorySubjectLocalDataSource.getCategorySubjects(categoryID);
        assertEquals(2, result.size());
    }

    @Test
    public void getCategorySubjectID_ShouldReturnValue(){
        int categoryID =  1;
        int subjectID = 1;
        int result = categorySubjectLocalDataSource.getCategorySubjectID(categoryID, subjectID);
        assertEquals(1, result);
    }

    @Test
    public void saveCategorySubjects_ShouldReturnTrueAfterSaving(){
        List<CategorySubject> categorySubjects = new ArrayList<>();
        categorySubjects.add(new CategorySubject(3, 2, 1, new Date()));

        boolean result = categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects);
        assertTrue(result);
    }

    @Test
    public void deleteAllCategorySubjects_ShouldReturnTrueAfterDeleting(){
        boolean result = categorySubjectLocalDataSource.deleteAllCategorySubjects();
        assertTrue(result);
    }
}
