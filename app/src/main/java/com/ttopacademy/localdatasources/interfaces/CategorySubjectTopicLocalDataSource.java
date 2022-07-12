package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import java.util.List;

/** CategorySubjectTopic local data source interface. */
public interface CategorySubjectTopicLocalDataSource {

    /** Checks whether categorySubjectTopic local data source is up-to-date. */
    boolean isUpdated();

    /** Returns all categorySubjectTopics. */
    List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID);

    /** Returns true after saving successfully. */
    boolean saveCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics);

    /** Returns true after deleting successfully. */
    boolean deleteAllCategorySubjectTopics();
}
