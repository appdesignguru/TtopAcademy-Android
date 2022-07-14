package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicVideoLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectTopicVideoDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategorySubjectTopicVideoLocalDataSourceTest {

    private CategorySubjectTopicVideoLocalDataSource categorySubjectTopicVideoLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectTopicVideoDao fakeCategorySubjectTopicVideoDao
                = new FakeCategorySubjectTopicVideoDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        categorySubjectTopicVideoLocalDataSource = new CategorySubjectTopicVideoLocalDataSourceImpl(
                fakeCategorySubjectTopicVideoDao, fakeDateTimeUtility
        );

        // PreSave
        List<CategorySubjectTopicVideo> categorySubjectTopicVideos = new ArrayList<>();
        categorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                1, 1, 1, new Date()));
        categorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                2, 1, 2, new Date()));

        categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(categorySubjectTopicVideos);
    }

    @After
    public void cleanupAfterEachTest(){
        categorySubjectTopicVideoLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        int categorySubjectTopicID = 1;
        boolean result = categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(
                categorySubjectTopicID);
        assertTrue(result);
    }

    @Test
    public void getCategorySubjectTopicVideos_ShouldReturnAllForGivenParameter(){
        int categorySubjectTopicID = 1;
        List<CategorySubjectTopicVideo> result
                = categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideos(categorySubjectTopicID);
        assertEquals(2, result.size());
    }

    @Test
    public void getCategorySubjectTopicVideoID_ShouldReturnValue(){
        int categorySubjectTopicID = 1;
        int videoID = 1;
        int result = categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideoID(
                categorySubjectTopicID, videoID);
        assertEquals(1, result);
    }

    @Test
    public void saveCategorySubjectTopicVideos_ShouldReturnTrueAfterSaving(){
        List<CategorySubjectTopicVideo> categorySubjectTopicVideos = new ArrayList<>();
        categorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                3, 2, 1, new Date()));

        boolean result = categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(
                categorySubjectTopicVideos);
        assertTrue(result);
    }
}
