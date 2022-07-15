package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** CategorySubjectTopicVideoRemoteDataSource Implementation class. */
public class CategorySubjectTopicVideoRemoteDataSourceImpl implements CategorySubjectTopicVideoRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicVideoRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<CategorySubjectTopicVideoResponse>> getCategorySubjectTopicVideos(
            int categorySubjectTopicID) {
        Call<List<CategorySubjectTopicVideoResponse>> apiCall
                = apiService.getCategorySubjectTopicVideos(categorySubjectTopicID);
        try{
            List<CategorySubjectTopicVideoResponse> categorySubjectTopicVideoResponses
                    = apiCall.execute().body();
            return new Result.Success<>(categorySubjectTopicVideoResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
