package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.fakes.FakeCategoryLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategoryRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategoryRepository;
import com.ttopacademy.repositories.real.CategoryRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CategoryRepositoryTest {

    private CategoryRepository categoryRepository;

    @Before
    public void initializeBeforeEachTest(){
        CategoryLocalDataSource fakeCategoryLocalDataSource = new FakeCategoryLocalDataSource();
        CategoryRemoteDataSource fakeCategoryRemoteDataSource = new FakeCategoryRemoteDataSource();
        categoryRepository = new CategoryRepositoryImpl(
                fakeCategoryLocalDataSource, fakeCategoryRemoteDataSource, null, null
        );
    }

    @After
    public void cleanupAfterEachTest(){
        categoryRepository = null;
    }

    @Test
    public void getAllCategoriesSync_ShouldReturnAllCategories(){
        List<Category> result = categoryRepository.getAllCategoriesSync();
        assertEquals(2, result.size());
    }
}
