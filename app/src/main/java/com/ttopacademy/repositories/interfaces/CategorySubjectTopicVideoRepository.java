package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import java.util.List;

/** Repository interface for CategorySubjectTopicVideos. */
public interface CategorySubjectTopicVideoRepository {

    /** Returns categorySubjectTopicVideoID. */
    int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID);

    /** Returns CategorySubjectTopicVideos. */
    List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID);
}
