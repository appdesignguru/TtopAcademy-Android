package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** CategorySubjectTopicRemoteDataSource Implementation class. */
public class CategorySubjectTopicRemoteDataSourceImpl implements CategorySubjectTopicRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<CategorySubjectTopicResponse>> getAllCategorySubjectTopics() {
        Call<List<CategorySubjectTopicResponse>> apiCall = apiService.getAllCategorySubjectTopics();
        try{
            List<CategorySubjectTopicResponse> categorySubjectTopicResponses = apiCall.execute().body();
            return new Result.Success<>(categorySubjectTopicResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
