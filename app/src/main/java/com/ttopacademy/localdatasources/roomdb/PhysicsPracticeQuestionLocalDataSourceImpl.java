package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** PhysicsPracticeQuestionLocalDataSource implementation class. */
public class PhysicsPracticeQuestionLocalDataSourceImpl implements SpecificPracticeQuestionLocalDataSource {

    private final PhysicsPracticeQuestionDao physicsPracticeQuestionDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public PhysicsPracticeQuestionLocalDataSourceImpl(
            PhysicsPracticeQuestionDao physicsPracticeQuestionDao,
            DateTimeUtility dateTimeUtility) {
        this.physicsPracticeQuestionDao = physicsPracticeQuestionDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean hasOutdatedPracticeQuestions(int videoID) {
        Date todaysDate = new Date();
        Date lastUpdated = physicsPracticeQuestionDao.getDateOfLastUpdate(videoID);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        return physicsPracticeQuestionDao.getPracticeQuestions(videoID);
    }

    @Override
    public boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions) {
        List<PhysicsPracticeQuestion> physicsPracticeQuestions = new ArrayList<>();
        for (PracticeQuestion practiceQuestion : practiceQuestions){
            physicsPracticeQuestions.add(new PhysicsPracticeQuestion(
                    practiceQuestion.getPracticeQuestionID(), practiceQuestion.getVideoID(),
                    practiceQuestion.getQuestionNumber(), practiceQuestion.getQuestion(),
                    practiceQuestion.getOptionA(), practiceQuestion.getOptionB(),
                    practiceQuestion.getOptionC(), practiceQuestion.getOptionD(),
                    practiceQuestion.getCorrectOption(),
                    practiceQuestion.getDateSavedToLocalDatabase()
            ));
        }
        physicsPracticeQuestionDao.insertPracticeQuestions(physicsPracticeQuestions);
        return true;
    }
}
