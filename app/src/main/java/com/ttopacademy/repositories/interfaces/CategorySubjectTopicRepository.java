package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import java.util.List;

/** Repository interface for CategorySubjectTopics. */
public interface CategorySubjectTopicRepository {

    /** Returns categorySubjectTopicID. */
    int getCategorySubjectTopicID(int categorySubjectID, int topicID);

    /** Returns categorySubjectTopics for given parameter. */
    List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID);
}
