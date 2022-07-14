package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectLocalDataSource implementation class. */
public class CategorySubjectLocalDataSourceImpl implements CategorySubjectLocalDataSource {

    private final CategorySubjectDao categorySubjectDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectLocalDataSourceImpl(CategorySubjectDao categorySubjectDao,
                                              DateTimeUtility dateTimeUtility) {
        this.categorySubjectDao = categorySubjectDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = categorySubjectDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysbetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<CategorySubject> getCategorySubjects(int categoryID) {
        return categorySubjectDao.getCategorySubjects(categoryID);
    }

    @Override
    public int getCategorySubjectID(int categoryID, int subjectID) {
        return categorySubjectDao.getCategorySubjectID(categoryID, subjectID);
    }

    @Override
    public boolean saveCategorySubjects(List<CategorySubject> categorySubjects) {
        categorySubjectDao.insertCategorySubjects(categorySubjects);
        return true;
    }

    @Override
    public boolean deleteAllCategorySubjects() {
        categorySubjectDao.deleteAllCategorySubjects();
        return true;
    }
}
