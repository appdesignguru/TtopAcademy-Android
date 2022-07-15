package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** CategorySubjectRemoteDataSource Implementation class. */
public class CategorySubjectRemoteDataSourceImpl implements CategorySubjectRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<CategorySubjectResponse>> getAllCategorySubjects() {
        Call<List<CategorySubjectResponse>> apiCall = apiService.getAllCategorySubjects();
        try{
            List<CategorySubjectResponse> categorySubjectResponses = apiCall.execute().body();
            return new Result.Success<>(categorySubjectResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
