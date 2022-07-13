package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicVideoRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import com.ttopacademy.repositories.real.CategorySubjectTopicVideoRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CategorySubjectTopicVideoRepositoryTest {

    private CategorySubjectTopicVideoRepository categorySubjectTopicVideoRepository;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectTopicVideoLocalDataSource fakeCategorySubjectTopicVideoLocalDataSource
                = new FakeCategorySubjectTopicVideoLocalDataSource();
        CategorySubjectTopicVideoRemoteDataSource fakeCategorySubjectTopicVideoRemoteDataSource
                = new FakeCategorySubjectTopicVideoRemoteDataSource();
        categorySubjectTopicVideoRepository = new CategorySubjectTopicVideoRepositoryImpl(
                fakeCategorySubjectTopicVideoLocalDataSource, fakeCategorySubjectTopicVideoRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectTopicVideoRepository = null;
    }

    @Test
    public void getCategorySubjectTopicVideoID_ShouldReturnValueForGivenParameters(){
        int categorySubjectTopicID = 1;
        int videoID = 1;
        int result = categorySubjectTopicVideoRepository.getCategorySubjectTopicVideoID(categorySubjectTopicID, videoID);
        assertEquals(1, result);
    }

    @Test
    public void getCategorySubjectTopicVideos_ShouldReturnForGivenParameter(){
        int categorySubjectTopicID = 1;
        List<CategorySubjectTopicVideo> result
                = categorySubjectTopicVideoRepository.getCategorySubjectTopicVideos(categorySubjectTopicID);
        assertEquals(2, result.size());
    }
}
