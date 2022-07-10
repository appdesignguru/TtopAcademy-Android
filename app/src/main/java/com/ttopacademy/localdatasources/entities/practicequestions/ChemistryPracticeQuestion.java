package com.ttopacademy.localdatasources.entities.practicequestions;

import java.util.Date;

/** ChemistryPracticeQuestion entity class. */
public class ChemistryPracticeQuestion extends PracticeQuestion{

    /** Constructs a new instance with give parameters. */
    public ChemistryPracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                                     String question, String optionA, String optionB,
                                     String optionC, String optionD, Option correctOption,
                                     Date dateSavedToLocalDatabase) {
        super(practiceQuestionID, videoID, questionNumber, question, optionA, optionB, optionC,
                optionD, correctOption, dateSavedToLocalDatabase);
    }
}
