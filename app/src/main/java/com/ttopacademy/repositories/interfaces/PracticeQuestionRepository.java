package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;

import java.util.List;

/** Repository interface for practice questions. */
public interface PracticeQuestionRepository {

    /** Returns and posts practice questions for given parameters to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getPracticeQuestionsSync() instead. */
    void getPracticeQuestions(String subjectName, int videoID,
                              ResultCallback<List<PracticeQuestion>> callback);

    /** Returns the practice questions for given parameters. */
    List<PracticeQuestion> getPracticeQuestionsSync(String subjectName, int videoID);
}
