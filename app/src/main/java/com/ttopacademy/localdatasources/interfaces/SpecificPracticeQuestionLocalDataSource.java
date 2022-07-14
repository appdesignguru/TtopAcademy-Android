package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.List;

/** PracticeQuestion local data source interface for specific subject. */
public interface SpecificPracticeQuestionLocalDataSource {

    /** Checks whether the practice questions for given parameter is NOT up-to-date. */
    boolean hasOutdatedPracticeQuestions(int videoID);

    /** Returns practice questions for given parameter. */
    List<PracticeQuestion> getPracticeQuestions(int videoID);

    /** Returns true after saving successfully. */
    boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions);
}
