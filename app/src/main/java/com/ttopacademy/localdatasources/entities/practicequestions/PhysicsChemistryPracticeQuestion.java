package com.ttopacademy.localdatasources.entities.practicequestions;

import java.util.Date;

/** PhysicsPracticeQuestion entity class. */
public class PhysicsChemistryPracticeQuestion extends PracticeQuestion{

    /** Constructs a new instance with given parameters. */
    public PhysicsChemistryPracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                                            String question, String optionA, String optionB,
                                            String optionC, String optionD, Option correctOption,
                                            Date dateSavedToLocalDatabase) {
        super(practiceQuestionID, videoID, questionNumber, question, optionA, optionB, optionC,
                optionD, correctOption, dateSavedToLocalDatabase);
    }
}
