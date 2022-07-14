package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake MathPracticeQuestionDao dao implementation class. Used for unit testing only. */
public class FakeMathPracticeQuestionDao implements MathPracticeQuestionDao {

    private final List<MathPracticeQuestion> mathPracticeQuestions = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeMathPracticeQuestionDao() {

    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        List<PracticeQuestion> result = new ArrayList<>();
        for (MathPracticeQuestion practiceQuestion : mathPracticeQuestions) {
            if (practiceQuestion.getVideoID() == videoID){
                result.add(practiceQuestion);
            }
        }
        return result;
    }

    @Override
    public void insertPracticeQuestions(List<MathPracticeQuestion> mathPracticeQuestions) {
        this.mathPracticeQuestions.clear();
        this.mathPracticeQuestions.addAll(mathPracticeQuestions);
    }

    @Override
    public Date getDateOfLastUpdate(int videoID) {
        return null;
    }
}
