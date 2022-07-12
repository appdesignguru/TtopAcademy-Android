package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.TopicResponse;
import java.util.List;

/** Topic remote data source interface. */
public interface TopicRemoteDataSource {

    /** Returns topic responses. */
    Result<List<TopicResponse>> getAllTopics();
}
