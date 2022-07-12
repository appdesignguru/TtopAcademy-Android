package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.entities.Topic;
import java.util.List;

public interface CategorySubjectTopicVideoLocalDataSource {

    /** Checks whether CategorySubjectTopicVideo local data source is up-to-date for given parameter. */
    boolean hasUpdatedCategorySubjectTopicVideos(int categorySubjectTopicID);

    /** Returns all CategorySubjectTopicVideos. */
    List<Topic> getCategorySubjectTopicVideos(int categorySubjectTopicID);

    /** Returns true after saving successfully. */
    boolean saveCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics);
}
