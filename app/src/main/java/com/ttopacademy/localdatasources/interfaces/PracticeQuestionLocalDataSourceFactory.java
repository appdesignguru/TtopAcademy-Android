package com.ttopacademy.localdatasources.interfaces;

/** PracticeQuestionLocalDataSourceFactory interface. */
public interface PracticeQuestionLocalDataSourceFactory {

    /** Returns the appropriate practice question local data source for the given subject name. */
    SpecificPracticeQuestionLocalDataSource getSpecificPracticeQuestionLocalDataSource(String subjectName);
}
