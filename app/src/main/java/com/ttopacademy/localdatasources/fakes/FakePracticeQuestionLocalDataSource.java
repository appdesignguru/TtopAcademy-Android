package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake PracticeQuestion local data source implementation class. Used for unit testing only. */
public class FakePracticeQuestionLocalDataSource implements PracticeQuestionLocalDataSource {

    private final List<PracticeQuestion> practiceQuestions = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakePracticeQuestionLocalDataSource() {

    }

    @Override
    public boolean hasOutdatedPracticeQuestions(String subjectName, int videoID) {
        return true;
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(String subjectName, int videoID) {
        List<PracticeQuestion> result = new ArrayList<>();
        for (PracticeQuestion practiceQuestion : practiceQuestions){
            if (practiceQuestion.getVideoID() == videoID){
                result.add(practiceQuestion);
            }
        }
        return result;
    }

    @Override
    public boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions) {
        this.practiceQuestions.clear();
        this.practiceQuestions.addAll(practiceQuestions);
        return true;
    }
}
