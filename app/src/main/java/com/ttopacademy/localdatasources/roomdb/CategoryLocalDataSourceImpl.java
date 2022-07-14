package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategoryLocalDataSource implementation class. */
public class CategoryLocalDataSourceImpl implements CategoryLocalDataSource {

    private final CategoryDao categoryDao;
    private final DateTimeUtility dateTimeUtitlity;

    /** Constructs a new instance. */
    @Inject
    public CategoryLocalDataSourceImpl(CategoryDao categoryDao, DateTimeUtility dateTimeUtitlity) {
        this.categoryDao = categoryDao;
        this.dateTimeUtitlity = dateTimeUtitlity;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = categoryDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtitlity.numberOfDaysbetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public boolean saveCategories(List<Category> categories) {
        categoryDao.insertCategories(categories);
        return true;
    }

    @Override
    public boolean deleteAllCategories() {
        categoryDao.deleteAllCategories();
        return true;
    }
}
