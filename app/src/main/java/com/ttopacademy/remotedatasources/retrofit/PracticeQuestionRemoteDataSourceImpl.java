package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;

/** PracticeQuestionRemoteDataSource Implementation class. */
public class PracticeQuestionRemoteDataSourceImpl implements PracticeQuestionRemoteDataSource {

    private final ApiService apiService;

    /** Constructs a new instance. */
    @Inject
    public PracticeQuestionRemoteDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Result<List<PracticeQuestionResponse>> getPracticeQuestions(String subjectName, int videoID) {
        String hyphenConcatenatedSubjectNameAndVideoID = subjectName + "-" + videoID;
        Call<List<PracticeQuestionResponse>> apiCall
                = apiService.getPracticeQuestions(hyphenConcatenatedSubjectNameAndVideoID);
        try{
            List<PracticeQuestionResponse> practiceQuestionResponses = apiCall.execute().body();
            return new Result.Success<>(practiceQuestionResponses);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return new Result.Error<>(exception);
        }
    }
}
