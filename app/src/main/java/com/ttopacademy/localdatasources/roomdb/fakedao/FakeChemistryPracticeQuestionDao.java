package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake ChemistryPracticeQuestionDao dao implementation class. Used for unit testing only. */
public class FakeChemistryPracticeQuestionDao implements ChemistryPracticeQuestionDao {

    private final List<ChemistryPracticeQuestion> chemistryPracticeQuestions = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeChemistryPracticeQuestionDao(){

    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        List<PracticeQuestion> result = new ArrayList<>();
        for (ChemistryPracticeQuestion practiceQuestion : chemistryPracticeQuestions) {
            if (practiceQuestion.getVideoID() == videoID){
                result.add(practiceQuestion);
            }
        }
        return result;
    }

    @Override
    public void insertPracticeQuestions(List<ChemistryPracticeQuestion> chemistryPracticeQuestions) {
        this.chemistryPracticeQuestions.clear();
        this.chemistryPracticeQuestions.addAll(chemistryPracticeQuestions);
    }

    @Override
    public Date getDateOfLastUpdate(int videoID) {
        return null;
    }
}
