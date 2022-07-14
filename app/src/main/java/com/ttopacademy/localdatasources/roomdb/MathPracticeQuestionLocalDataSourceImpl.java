package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** MathPracticeQuestionLocalDataSource implementation class. */
public class MathPracticeQuestionLocalDataSourceImpl implements SpecificPracticeQuestionLocalDataSource {

    private final MathPracticeQuestionDao mathPracticeQuestionDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public MathPracticeQuestionLocalDataSourceImpl(MathPracticeQuestionDao mathPracticeQuestionDao,
                                                   DateTimeUtility dateTimeUtility) {
        this.mathPracticeQuestionDao = mathPracticeQuestionDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean hasOutdatedPracticeQuestions(int videoID) {
        Date todaysDate = new Date();
        Date lastUpdated = mathPracticeQuestionDao.getDateOfLastUpdate(videoID);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysbetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(int videoID) {
        return mathPracticeQuestionDao.getPracticeQuestions(videoID);
    }

    @Override
    public boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions) {
        List<MathPracticeQuestion> mathPracticeQuestions = new ArrayList<>();
        for (PracticeQuestion practiceQuestion : practiceQuestions){
            mathPracticeQuestions.add(new MathPracticeQuestion(
                    practiceQuestion.getPracticeQuestionID(), practiceQuestion.getVideoID(),
                    practiceQuestion.getQuestionNumber(), practiceQuestion.getQuestion(),
                    practiceQuestion.getOptionA(), practiceQuestion.getOptionB(),
                    practiceQuestion.getOptionC(), practiceQuestion.getOptionD(),
                    practiceQuestion.getCorrectOption(),
                    practiceQuestion.getDateSavedToLocalDatabase()
            ));
        }
        mathPracticeQuestionDao.insertPracticeQuestions(mathPracticeQuestions);
        return true;
    }
}
