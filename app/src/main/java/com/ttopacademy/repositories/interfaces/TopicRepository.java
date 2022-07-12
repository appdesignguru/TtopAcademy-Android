package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.Topic;
import java.util.List;

/** Repository interface for topics. */
public interface TopicRepository {

    /** Returns topics with given parameters. */
    List<Topic> getTopics(List<Integer> topicIDs);
}
