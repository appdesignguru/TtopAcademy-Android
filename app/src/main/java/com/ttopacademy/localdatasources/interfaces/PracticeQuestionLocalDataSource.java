package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.List;

/** PracticeQuestion local data source interface. */
public interface PracticeQuestionLocalDataSource {

    /** Checks whether the practice questions for given parameter is NOT up-to-date. */
    boolean hasOutdatedPracticeQuestions(String subjectName, int videoID);

    /** Returns practice questions for given parameter. */
    List<PracticeQuestion> getPracticeQuestions(String subjectName, int videoID);

    /** Returns true after saving successfully. */
    boolean savePracticeQuestions(List<PracticeQuestion> practiceQuestions);

}
