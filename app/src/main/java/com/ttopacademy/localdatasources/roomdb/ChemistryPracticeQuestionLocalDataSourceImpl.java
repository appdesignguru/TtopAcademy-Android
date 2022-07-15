package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** ChemistryPracticeQuestionLocalDataSource implementation class. */
public class ChemistryPracticeQuestionLocalDataSourceImpl implements SpecificPracticeQuestionLocalDataSource {

    private final ChemistryPracticeQuestionDao chemistryPracticeQuestionDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public ChemistryPracticeQuestionLocalDataSourceImpl(
            ChemistryPracticeQuestionDao chemistryPracticeQuestionDao,
            DateTimeUtility dateTimeUtility) {
        this.chemistryPracticeQuestionDao = chemistryPracticeQuestionDao;
        this.dateTimeUtility = dateTimeUtility;
    }


    @Override
    public boolean hasOutdatedPracticeQuestions(int videoID) {
        Date todaysDate = new Date();
        Date lastUpdated = chemistryPracticeQuestionDao.getDateOfLastUpdate(videoID);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        return chemistryPracticeQuestionDao.getPracticeQuestions(videoID);
    }

    @Override
    public boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions) {
        List<ChemistryPracticeQuestion> chemistryPracticeQuestions = new ArrayList<>();
        for (PracticeQuestion practiceQuestion : practiceQuestions){
            chemistryPracticeQuestions.add(new ChemistryPracticeQuestion(
                    practiceQuestion.getPracticeQuestionID(), practiceQuestion.getVideoID(),
                    practiceQuestion.getQuestionNumber(), practiceQuestion.getQuestion(),
                    practiceQuestion.getOptionA(), practiceQuestion.getOptionB(),
                    practiceQuestion.getOptionC(), practiceQuestion.getOptionD(),
                    practiceQuestion.getCorrectOption(),
                    practiceQuestion.getDateSavedToLocalDatabase()
            ));
        }
        chemistryPracticeQuestionDao.insertPracticeQuestions(chemistryPracticeQuestions);
        return true;
    }
}
