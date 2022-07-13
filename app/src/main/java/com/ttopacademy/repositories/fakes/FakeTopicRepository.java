package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Topic repository implementation class. */
public class FakeTopicRepository implements TopicRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeTopicRepository(){

    }

    @Override
    public List<Topic> getTopics(List<Integer> topicIDs) {
        List<Topic> mockTopics = new ArrayList<>();
        mockTopics.add(new Topic(1, 1, "Topic 1", new Date()));
        mockTopics.add(new Topic(2, 2, "Topic 2", new Date()));

        return mockTopics;
    }
}
