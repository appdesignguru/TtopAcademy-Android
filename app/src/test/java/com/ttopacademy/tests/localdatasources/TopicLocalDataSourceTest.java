package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.TopicLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeTopicDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicLocalDataSourceTest {

    private TopicLocalDataSource topicLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        TopicDao fakeTopicDao = new FakeTopicDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        topicLocalDataSource = new TopicLocalDataSourceImpl(fakeTopicDao, fakeDateTimeUtility);

        // PreSave
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1, 1, "Title 1", new Date()));
        topics.add(new Topic(2, 2, "Title 2", new Date()));

        topicLocalDataSource.saveTopics(topics);
    }

    @After
    public void cleanupAfterEachTest(){
        topicLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        boolean result = topicLocalDataSource.isOutdated();
        assertTrue(result);
    }

    @Test
    public void getTopics_ShouldReturnAllForGivenParameters(){
        List<Integer> topicIDs = new ArrayList<>();
        topicIDs.add(1);
        topicIDs.add(2);
        List<Topic> result = topicLocalDataSource.getTopics(topicIDs);
        assertEquals(topicIDs.size(), result.size());
    }

    @Test
    public void saveTopics_ShouldReturnTrueAfterSaving(){
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(3, 3, "Topic 3", new Date()));

        boolean result = topicLocalDataSource.saveTopics(topics);
        assertTrue(result);
    }

    @Test
    public void deleteAllTopics_ShouldReturnTrueAfterDeleting(){
        boolean result = topicLocalDataSource.deleteAllTopics();
        assertTrue(result);
    }
}
