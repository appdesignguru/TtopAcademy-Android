package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.SubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** SubjectRemoteDataSource Implementation class. */
public class SubjectRemoteDataSourceImpl implements SubjectRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public SubjectRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<SubjectResponse>> getAllSubjects() {
        Call<List<SubjectResponse>> apiCall = apiService.getAllSubjects();
        try{
            List<SubjectResponse> subjectResponses = apiCall.execute().body();
            return new Result.Success<>(subjectResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
