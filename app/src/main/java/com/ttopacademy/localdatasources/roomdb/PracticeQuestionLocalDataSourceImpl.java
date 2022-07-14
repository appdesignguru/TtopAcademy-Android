package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;

import java.util.List;

import javax.inject.Inject;

public class PracticeQuestionLocalDataSourceImpl implements PracticeQuestionLocalDataSource {

    private final PracticeQuestionLocalDataSourceFactory practiceQuestionLocalDataSourceFactory;

    /** Constructs a new instance. */
    @Inject
    public PracticeQuestionLocalDataSourceImpl(
            PracticeQuestionLocalDataSourceFactory practiceQuestionLocalDataSourceFactory) {
        this.practiceQuestionLocalDataSourceFactory = practiceQuestionLocalDataSourceFactory;
    }

    @Override
    public boolean hasOutdatedPracticeQuestions(String subjectName, int videoID) {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).hasOutdatedPracticeQuestions(videoID);
    }

    @Override
    public List<PracticeQuestion> getPracticeQuestions(String subjectName, int videoID) {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).getPracticeQuestions(videoID);
    }

    @Override
    public boolean savePracticeQuestions(String subjectName, List<PracticeQuestion> practiceQuestions) {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).savePracticeQuestions(practiceQuestions);
    }

    private SpecificPracticeQuestionLocalDataSource getSpecificPracticeQuestionLocalDataSource(String subjectName){
        return practiceQuestionLocalDataSourceFactory.getSpecificPracticeQuestionLocalDataSource(subjectName);
    }
}
