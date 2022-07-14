package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Fake PhysicsPracticeQuestionDao dao implementation class. Used for unit testing only. */
public class FakePhysicsPracticeQuestionDao implements PhysicsPracticeQuestionDao {

    private final List<PhysicsPracticeQuestion> physicsPracticeQuestions = new ArrayList<>();

    /** Constructs a new instance. */
    public FakePhysicsPracticeQuestionDao() {

    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        List<PracticeQuestion> result = new ArrayList<>();
        for (PhysicsPracticeQuestion practiceQuestion : physicsPracticeQuestions) {
            if (practiceQuestion.getVideoID() == videoID){
                result.add(practiceQuestion);
            }
        }
        return result;
    }

    @Override
    public void insertPracticeQuestions(List<PhysicsPracticeQuestion> physicsPracticeQuestions) {
        this.physicsPracticeQuestions.clear();
        this.physicsPracticeQuestions.addAll(physicsPracticeQuestions);
    }

    @Override
    public Date getDateOfLastUpdate(int videoID) {
        return null;
    }
}
