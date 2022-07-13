package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import java.util.List;

public interface PracticeQuestionRemoteDataSource {

    Result<List<PracticeQuestionResponse>> getPracticeQuestions(String subjectName, int videoID);
}
