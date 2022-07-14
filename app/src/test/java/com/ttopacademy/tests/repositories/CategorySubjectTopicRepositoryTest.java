package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.real.CategorySubjectTopicRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CategorySubjectTopicRepositoryTest {

    private CategorySubjectTopicRepository categorySubjectTopicRepository;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectTopicLocalDataSource fakeCategorySubjectTopicLocalDataSource
                = new FakeCategorySubjectTopicLocalDataSource();
        CategorySubjectTopicRemoteDataSource fakeCategorySubjectTopicRemoteDataSource
                = new FakeCategorySubjectTopicRemoteDataSource();
        categorySubjectTopicRepository = new CategorySubjectTopicRepositoryImpl(
                fakeCategorySubjectTopicLocalDataSource, fakeCategorySubjectTopicRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectTopicRepository = null;
    }

    @Test
    public void getCategorySubjectTopicID_ShouldReturnValueForGivenParameters(){
        int categorySubjectID = 1;
        int topicID = 1;
        int result = categorySubjectTopicRepository.getCategorySubjectTopicID(categorySubjectID, topicID);
        assertEquals(1, result);
    }

    @Test
    public void getCategorySubjectTopics_ShouldReturnForGivenParameter(){
        int categorySubjectID = 4;
        List<CategorySubjectTopic> result = categorySubjectTopicRepository.getCategorySubjectTopics(categorySubjectID);
        assertEquals(2, result.size());
    }
}
