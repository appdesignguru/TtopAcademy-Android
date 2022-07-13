package com.ttopacademy.managers.fakes;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.managers.interfaces.TopicManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject Manager implementation class. Used for unit testing only. */
public class FakeTopicManager implements TopicManager {

    /** Constructs a new instance. */
    @Inject
    public FakeTopicManager(){

    }

    @Override
    public void getTopics(int categoryID, int subjectID, ResultCallback<List<Topic>> callback) {
        callback.onComplete(getTopicsSync(categoryID, subjectID));
    }

    @Override
    public List<Topic> getTopicsSync(int categoryID, int subjectID) {
        List<Topic> mockTopics = new ArrayList<>();
        mockTopics.add(new Topic(1, 1, "Topic 1", new Date()));
        mockTopics.add(new Topic(2, 2, "Topic 2", new Date()));

        return mockTopics;
    }
}
