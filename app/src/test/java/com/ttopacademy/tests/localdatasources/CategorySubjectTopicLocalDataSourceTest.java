package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectTopicDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategorySubjectTopicLocalDataSourceTest {

    private CategorySubjectTopicLocalDataSource categorySubjectTopicLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectTopicDao fakeCategorySubjectTopicDao = new FakeCategorySubjectTopicDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        categorySubjectTopicLocalDataSource = new CategorySubjectTopicLocalDataSourceImpl(
                fakeCategorySubjectTopicDao, fakeDateTimeUtility
        );

        // PreSave
        List<CategorySubjectTopic> categorySubjectTopics = new ArrayList<>();
        categorySubjectTopics.add(new CategorySubjectTopic(
                1, 1, 1, new Date()));
        categorySubjectTopics.add(new CategorySubjectTopic(
                2, 1, 2, new Date()));

        categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics);
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectTopicLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        boolean result = categorySubjectTopicLocalDataSource.isOutdated();
        assertTrue(result);
    }

    @Test
    public void getCategorySubjectTopics_ShouldReturnAllForGivenParameter(){
        int categorySubjectID = 1;
        List<CategorySubjectTopic> result
                = categorySubjectTopicLocalDataSource.getCategorySubjectTopics(categorySubjectID);
        assertEquals(2, result.size());
    }

    @Test
    public void getCategorySubjectTopicID_ShouldReturnValue(){
        int categorySubjectID = 1;
        int topicID = 1;
        int result = categorySubjectTopicLocalDataSource.getCategorySubjectTopicID(categorySubjectID, topicID);
        assertEquals(1, result);
    }

    @Test
    public void saveCategorySubjectTopics_ShouldReturnTrueAfterSaving(){
        List<CategorySubjectTopic> categorySubjectTopics = new ArrayList<>();
        categorySubjectTopics.add(new CategorySubjectTopic(
                3, 2, 1, new Date()));

        boolean result = categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics);
        assertTrue(result);
    }

    @Test
    public void deleteAllCategorySubjectTopics_ShouldReturnTrueAfterDeleting(){
        boolean result = categorySubjectTopicLocalDataSource.deleteAllCategorySubjectTopics();
        assertTrue(result);
    }
}
