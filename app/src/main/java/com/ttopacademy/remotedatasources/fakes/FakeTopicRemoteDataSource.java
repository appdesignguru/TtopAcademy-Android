package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.TopicResponse;
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Topic remote data source implementation class. Used for unit testing only. */
public class FakeTopicRemoteDataSource implements TopicRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeTopicRemoteDataSource() {
    }

    @Override
    public Result<List<TopicResponse>> getAllTopics() {
        List<TopicResponse> mockTopicResponses = new ArrayList<>();
        mockTopicResponses.add(new TopicResponse(1, 1, "Motion"));
        mockTopicResponses.add(new TopicResponse(2, 2, "Machines"));
        mockTopicResponses.add(new TopicResponse(3, 3, "Gas Laws"));
        mockTopicResponses.add(new TopicResponse(4, 4, "Chemical bonding"));

        return new Result.Success<>(mockTopicResponses);
    }
}
