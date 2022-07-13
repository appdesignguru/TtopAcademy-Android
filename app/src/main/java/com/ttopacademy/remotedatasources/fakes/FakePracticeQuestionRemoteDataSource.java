package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.practicequestions.Option;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake PracticeQuestion remote data source implementation class. Used for unit testing only. */
public class FakePracticeQuestionRemoteDataSource implements PracticeQuestionRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakePracticeQuestionRemoteDataSource() {

    }

    @Override
    public Result<List<PracticeQuestionResponse>> getPracticeQuestions(String subjectName, int videoID) {
        List<PracticeQuestionResponse> mockPracticeQuestionResponses = new ArrayList<>();
        mockPracticeQuestionResponses.add(new PracticeQuestionResponse(1, 1, 1,
                "What is name of the president of USA?", "Donald Trump",
                "Barrack Obama", "Joe Biden", "Jack Gudh", Option.C));
        mockPracticeQuestionResponses.add(new PracticeQuestionResponse(2, 1, 1,
                "What is name of the president of Nigeria?", "Buhari",
                "Jonathan", "Obasanjo", "Yaradua", Option.C));

        return new Result.Success<>(mockPracticeQuestionResponses);
    }
}
