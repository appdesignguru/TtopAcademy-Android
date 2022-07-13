package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Topic local data source implementation class. Used for unit testing only. */
public class FakeTopicLocalDataSource implements TopicLocalDataSource {

    private final List<Topic> topics = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeTopicLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public List<Topic> getTopics(List<Integer> topicIDs) {
        List<Topic> result = new ArrayList<>();
        Topic topic;
        for (int topicID : topicIDs){
            topic = getTopic(topicID);
            if (topic != null){
                result.add(topic);
            }
        }
        return result;
    }

    @Override
    public boolean saveTopics(List<Topic> topics) {
        this.topics.addAll(topics);
        outdated = false;
        return false;
    }

    @Override
    public boolean deleteAllTopics() {
        topics.clear();
        outdated = true;
        return true;
    }

    private Topic getTopic(int topicD){
        for (Topic topic : topics){
            if (topic.getTopicID() == topicD){
                return topic;
            }
        }
        return null;
    }
}
