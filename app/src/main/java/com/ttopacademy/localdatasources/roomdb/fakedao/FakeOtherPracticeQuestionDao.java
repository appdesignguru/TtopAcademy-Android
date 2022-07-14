package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake OtherPracticeQuestionDao dao implementation class. Used for unit testing only. */
public class FakeOtherPracticeQuestionDao implements OtherPracticeQuestionDao {

    private final List<OtherPracticeQuestion> otherPracticeQuestions = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeOtherPracticeQuestionDao() {

    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        List<PracticeQuestion> result = new ArrayList<>();
        for (OtherPracticeQuestion practiceQuestion : otherPracticeQuestions) {
            if (practiceQuestion.getVideoID() == videoID){
                result.add(practiceQuestion);
            }
        }
        return result;
    }

    @Override
    public void insertPracticeQuestions(List<OtherPracticeQuestion> otherPracticeQuestions) {
        this.otherPracticeQuestions.clear();
        this.otherPracticeQuestions.addAll(otherPracticeQuestions);
    }

    @Override
    public Date getDateOfLastUpdate(int videoID) {
        return null;
    }
}
