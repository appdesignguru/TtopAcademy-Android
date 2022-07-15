package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import java.util.List;

/** Practice question remote data source interface. */
public interface PracticeQuestionRemoteDataSource {

    /** Returns practice questions for given parameters. */
    Result<List<PracticeQuestionResponse>> getPracticeQuestions(String subjectName, int videoID);
}
