package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.TopicResponse;
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** TopicRemoteDataSource Implementation class. */
public class TopicRemoteDataSourceImpl implements TopicRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public TopicRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<TopicResponse>> getAllTopics() {
        Call<List<TopicResponse>> apiCall = apiService.getAllTopics();
        try{
            List<TopicResponse> topicResponses = apiCall.execute().body();
            return new Result.Success<>(topicResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
