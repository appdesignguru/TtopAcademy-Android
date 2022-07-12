package com.ttopacademy.managers.interfaces;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import java.util.List;

/** Interface for managing topics. */
public interface TopicManager {

    /** Returns and posts the topics for given parameters to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getTopicsSync() instead. */
    void getTopics(int categoryID, int subjectID, ResultCallback<List<Topic>> callback);

    /** Returns the topics for given parameters. */
    List<Topic> getTopicsSync(int categoryID, int subjectID);
}
