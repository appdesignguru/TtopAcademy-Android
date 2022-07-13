package com.ttopacademy.repositories.fakes;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.practicequestions.Option;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake PracticeQuestion repository implementation class. */
public class FakePracticeQuestionRepository implements PracticeQuestionRepository {

    /** Constructs a new instance. */
    @Inject
    public FakePracticeQuestionRepository(){

    }

    @Override
    public void getPracticeQuestions(String subjectName, int videoID, ResultCallback<List<PracticeQuestion>> callback) {
        callback.onComplete(getPracticeQuestionsSync(subjectName, videoID));
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestionsSync(String subjectName, int videoID) {
        List<PracticeQuestion> mockPracticeQuestions = new ArrayList<>();
        mockPracticeQuestions.add(new PracticeQuestion(1, 1, 1,
                "What is name of the president of USA?", "Donald Trump",
                "Barrack Obama", "Joe Biden", "Jack Gudh", Option.C, new Date()));
        mockPracticeQuestions.add(new PracticeQuestion(2, 1, 1,
                "What is name of the president of Nigeria?", "Buhari",
                "Jonathan", "Obasanjo", "Yaradua", Option.C, new Date()));

        return mockPracticeQuestions;
    }
}
