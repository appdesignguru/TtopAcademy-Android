package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;

import java.util.List;

/** CategorySubjectTopicVideo remote data source interface. */
public interface CategorySubjectTopicVideoRemoteDataSource {

    /** Returns CategorySubjectTopicVideo responses for given parameter. */
    Result<List<CategorySubjectTopicResponse>> getCategorySubjectTopicVideos(int categorySubjectTopicID);
}
