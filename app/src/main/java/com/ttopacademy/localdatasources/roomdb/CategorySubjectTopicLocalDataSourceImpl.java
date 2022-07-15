package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectTopicLocalDataSource implementation class. */
public class CategorySubjectTopicLocalDataSourceImpl implements CategorySubjectTopicLocalDataSource {

    private final CategorySubjectTopicDao categorySubjectTopicDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicLocalDataSourceImpl(CategorySubjectTopicDao categorySubjectTopicDao,
                                                   DateTimeUtility dateTimeUtility) {
        this.categorySubjectTopicDao = categorySubjectTopicDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = categorySubjectTopicDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public int getCategorySubjectTopicID(int categorySubjectID, int topicID) {
        return categorySubjectTopicDao.getCategorySubjectTopicID(categorySubjectID, topicID);
    }

    @Override
    public List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID) {
        return categorySubjectTopicDao.getCategorySubjectTopics(categorySubjectID);
    }

    @Override
    public boolean saveCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics) {
        categorySubjectTopicDao.insertCategorySubjectTopics(categorySubjectTopics);
        return true;
    }

    @Override
    public boolean deleteAllCategorySubjectTopics() {
        categorySubjectTopicDao.deleteAllCategorySubjectTopics();
        return true;
    }
}
