package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.VideoResponse;
import java.util.List;

/** Video remote data source interface. */
public interface VideoRemoteDataSource {

    /** Returns video responses for given parameter. */
    Result<List<VideoResponse>> getVideos(int categorySubjectTopicID);
}
