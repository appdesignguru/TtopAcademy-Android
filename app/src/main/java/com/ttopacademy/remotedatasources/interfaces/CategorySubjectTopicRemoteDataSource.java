package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;
import java.util.List;

/** CategorySubjectTopic remote data source interface. */
public interface CategorySubjectTopicRemoteDataSource {

    /** Returns CategorySubjectTopic responses. */
    Result<List<CategorySubjectTopicResponse>> getAllCategorySubjectTopics();
}
