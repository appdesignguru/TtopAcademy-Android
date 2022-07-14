package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Topic DAO implementation class. Used for unit testing only. */
public class FakeTopicDao implements TopicDao {

    private final List<Topic> topics = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeTopicDao() {

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
    public void insertTopics(List<Topic> topics) {
        this.topics.addAll(topics);
    }

    @Override
    public void deleteAllTopics() {
        this.topics.clear();
    }

    @Override
    public Date getDateOfLastUpdate() {
        return null;
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
