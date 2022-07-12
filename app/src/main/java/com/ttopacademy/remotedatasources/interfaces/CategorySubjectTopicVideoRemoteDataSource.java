package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse;
import java.util.List;

/** CategorySubjectTopicVideo remote data source interface. */
public interface CategorySubjectTopicVideoRemoteDataSource {

    /** Returns CategorySubjectTopicVideo responses for given parameter. */
    Result<List<CategorySubjectTopicVideoResponse>> getCategorySubjectTopicVideos(int categorySubjectTopicID);
}
