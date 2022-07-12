package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.Topic;
import java.util.List;

public interface TopicLocalDataSource {

    /** Checks whether topic local data source is up-to-date. */
    boolean isOutdated();

    /** Returns topics with given parameters. */
    List<Topic> getTopics(List<Integer> topicIDs);

    /** Returns true after saving successfully. */
    boolean saveTopics(List<Topic> topics);

    /** Returns true after deleting successfully. */
    boolean deleteAllTopics();
}
