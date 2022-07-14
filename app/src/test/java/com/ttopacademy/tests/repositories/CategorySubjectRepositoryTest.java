package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.real.CategorySubjectRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CategorySubjectRepositoryTest {

    private CategorySubjectRepository categorySubjectRepository;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectLocalDataSource fakeCategorySubjectLocalDataSource
                = new FakeCategorySubjectLocalDataSource();
        CategorySubjectRemoteDataSource fakeCategorySubjectRemoteDataSource
                = new FakeCategorySubjectRemoteDataSource();
        categorySubjectRepository = new CategorySubjectRepositoryImpl(
                fakeCategorySubjectLocalDataSource, fakeCategorySubjectRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectRepository = null;
    }

    @Test
    public void getCategorySubjectID_ShouldReturnValueForGivenParameters(){
        int categoryID = 1;
        int subjectID = 2;
        int result = categorySubjectRepository.getCategorySubjectID(categoryID, subjectID);
        assertEquals(2, result);
    }

    @Test
    public void getCategorySubjects_ShouldReturnForGivenParameter(){
        int categoryID = 2;
        List<CategorySubject> result = categorySubjectRepository.getCategorySubjects(categoryID);
        assertEquals(2, result.size());
    }
}
