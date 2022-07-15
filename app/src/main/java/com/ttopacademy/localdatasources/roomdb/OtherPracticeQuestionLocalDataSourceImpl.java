package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** OtherPracticeQuestionLocalDataSource implementation class. */
public class OtherPracticeQuestionLocalDataSourceImpl implements SpecificPracticeQuestionLocalDataSource {

    private final OtherPracticeQuestionDao otherPracticeQuestionDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public OtherPracticeQuestionLocalDataSourceImpl(
            OtherPracticeQuestionDao otherPracticeQuestionDao,
            DateTimeUtility dateTimeUtility) {
        this.otherPracticeQuestionDao = otherPracticeQuestionDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean hasOutdatedPracticeQuestions(int videoID) {
        Date todaysDate = new Date();
        Date lastUpdated = otherPracticeQuestionDao.getDateOfLastUpdate(videoID);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        return otherPracticeQuestionDao.getPracticeQuestions(videoID);
    }

    @Override
    public boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions) {
        List<OtherPracticeQuestion> otherPracticeQuestions = new ArrayList<>();
        for (PracticeQuestion practiceQuestion : practiceQuestions){
            otherPracticeQuestions.add(new OtherPracticeQuestion(
                    practiceQuestion.getPracticeQuestionID(), practiceQuestion.getVideoID(),
                    practiceQuestion.getQuestionNumber(), practiceQuestion.getQuestion(),
                    practiceQuestion.getOptionA(), practiceQuestion.getOptionB(),
                    practiceQuestion.getOptionC(), practiceQuestion.getOptionD(),
                    practiceQuestion.getCorrectOption(),
                    practiceQuestion.getDateSavedToLocalDatabase()
            ));
        }
        otherPracticeQuestionDao.insertPracticeQuestions(otherPracticeQuestions);
        return true;
    }
}
