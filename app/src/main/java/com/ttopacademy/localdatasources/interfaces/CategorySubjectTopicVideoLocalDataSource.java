package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import java.util.List;

/** CategorySubjectTopicVideo local data source interface. */
public interface CategorySubjectTopicVideoLocalDataSource {

    /** Checks whether CategorySubjectTopicVideo local data source is NOT up-to-date for given parameter. */
    boolean hasOutdatedCategorySubjectTopicVideos(int categorySubjectTopicID);

    /** Returns CategorySubjectTopicVideoID for given parameters. */
    int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID);

    /** Returns all CategorySubjectTopicVideos. */
    List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID);

    /** Returns true after saving successfully. */
    boolean saveCategorySubjectTopicVideos(List<CategorySubjectTopicVideo> categorySubjectTopicVideos);
}
