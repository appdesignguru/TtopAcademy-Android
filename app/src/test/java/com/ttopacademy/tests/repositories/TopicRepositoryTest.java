package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.fakes.FakeTopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeTopicRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import com.ttopacademy.repositories.real.TopicRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TopicRepositoryTest {

    private TopicRepository topicRepository;

    @Before
    public void initializeBeforeEachTest(){
        TopicLocalDataSource fakeTopicLocalDataSource = new FakeTopicLocalDataSource();
        TopicRemoteDataSource fakeTopicRemoteDataSource = new FakeTopicRemoteDataSource();
        topicRepository = new TopicRepositoryImpl(
                fakeTopicLocalDataSource, fakeTopicRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        topicRepository = null;
    }

    @Test
    public void getTopics_ShouldReturnForGivenParameters(){
        List<Integer> topicIDs = new ArrayList<>();
        topicIDs.add(1);
        topicIDs.add(2);
        List<Topic> result = topicRepository.getTopics(topicIDs);
        assertEquals(topicIDs.size(), result.size());
    }
}
