package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategoryResponse;
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** CategoryRemoteDataSource Implementation class. */
public class CategoryRemoteDataSourceImpl implements CategoryRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public CategoryRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<CategoryResponse>> getAllCategories() {
        Call<List<CategoryResponse>> apiCall = apiService.getAllCategories();
        try{
            List<CategoryResponse> categoryResponses = apiCall.execute().body();
            return new Result.Success<>(categoryResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
