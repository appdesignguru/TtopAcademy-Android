package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.CategoryLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategoryDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryLocalDataSourceTest {

    private CategoryLocalDataSource categoryLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        CategoryDao fakeCategoryDao = new FakeCategoryDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        categoryLocalDataSource = new CategoryLocalDataSourceImpl(fakeCategoryDao, fakeDateTimeUtility);

        // PreSave
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, 1, "JAMB", new Date()));
        categories.add(new Category(2, 2, "SS3", new Date()));

        categoryLocalDataSource.saveCategories(categories);
    }

    @After
    public void cleanupAfterEachTest(){
        categoryLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        boolean result = categoryLocalDataSource.isOutdated();
        assertTrue(result);
    }

    @Test
    public void getAllCategories_ShouldReturnEmpty(){
        List<Category> result = categoryLocalDataSource.getAllCategories();
        assertEquals(2, result.size());
    }

    @Test
    public void saveCategories_ShouldReturnTrueAfterSaving(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(3, 3, "SS2", new Date()));

        boolean result = categoryLocalDataSource.saveCategories(categories);
        assertTrue(result);
    }

    @Test
    public void deleteAllCategories_ShouldReturnTrueAfterDeleting(){
        boolean result = categoryLocalDataSource.deleteAllCategories();
        assertTrue(result);
    }
}
