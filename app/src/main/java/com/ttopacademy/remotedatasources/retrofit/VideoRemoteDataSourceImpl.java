package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.VideoResponse;
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** VideoRemoteDataSource Implementation class. */
public class VideoRemoteDataSourceImpl implements VideoRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public VideoRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<VideoResponse>> getVideos(int categorySubjectTopicID) {
        Call<List<VideoResponse>> apiCall = apiService.getVideos(categorySubjectTopicID);
        try{
            List<VideoResponse> videoResponses = apiCall.execute().body();
            return new Result.Success<>(videoResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
