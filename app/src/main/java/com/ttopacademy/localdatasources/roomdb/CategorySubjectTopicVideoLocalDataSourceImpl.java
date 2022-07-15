package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectTopicVideoLocalDataSource implementation class. */
public class CategorySubjectTopicVideoLocalDataSourceImpl implements CategorySubjectTopicVideoLocalDataSource {

    private final CategorySubjectTopicVideoDao categorySubjectTopicVideoDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicVideoLocalDataSourceImpl(
            CategorySubjectTopicVideoDao categorySubjectTopicVideoDao,
            DateTimeUtility dateTimeUtility) {
        this.categorySubjectTopicVideoDao = categorySubjectTopicVideoDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean hasOutdatedCategorySubjectTopicVideos(int categorySubjectTopicID) {
        Date todaysDate = new Date();
        Date lastUpdated = categorySubjectTopicVideoDao.getDateOfLastUpdate(categorySubjectTopicID);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID) {
        return categorySubjectTopicVideoDao.getCategorySubjectTopicVideoID(categorySubjectTopicID, videoID);
    }

    @Override
    public List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        return categorySubjectTopicVideoDao.getCategorySubjectTopicVideos(categorySubjectTopicID);
    }

    @Override
    public boolean saveCategorySubjectTopicVideos(List<CategorySubjectTopicVideo> categorySubjectTopicVideos) {
        categorySubjectTopicVideoDao.insertCategorySubjectTopicVideos(categorySubjectTopicVideos);
        return true;
    }
}
