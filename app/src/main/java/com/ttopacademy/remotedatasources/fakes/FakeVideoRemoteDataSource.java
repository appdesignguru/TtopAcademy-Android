package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.VideoResponse;
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Video remote data source implementation class. Used for unit testing only. */
public class FakeVideoRemoteDataSource implements VideoRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeVideoRemoteDataSource(){

    }

    @Override
    public Result<List<VideoResponse>> getVideos(int categorySubjectTopicID) {
        List<VideoResponse> mockVideoResponses = new ArrayList<>();
        mockVideoResponses.add(new VideoResponse(1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10"));
        mockVideoResponses.add(new VideoResponse(2, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10"));


        return new Result.Success<>(mockVideoResponses);
    }
}
