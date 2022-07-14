package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** TopicLocalDataSource implementation class. */
public class TopicLocalDataSourceImpl implements TopicLocalDataSource {

    private final TopicDao topicDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public TopicLocalDataSourceImpl(TopicDao topicDao, DateTimeUtility dateTimeUtility) {
        this.topicDao = topicDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = topicDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysbetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<Topic> getTopics(List<Integer> topicIDs) {
        return topicDao.getTopics(topicIDs);
    }

    @Override
    public boolean saveTopics(List<Topic> topics) {
        topicDao.insertTopics(topics);
        return true;
    }

    @Override
    public boolean deleteAllTopics() {
        topicDao.deleteAllTopics();
        return true;
    }
}
