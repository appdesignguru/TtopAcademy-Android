package com.ttopacademy.localdatasources.entities.practicequestions;

import androidx.room.Entity;
import java.util.Date;

/** PhysicsPracticeQuestion entity class. */
@Entity
public class PhysicsPracticeQuestion extends PracticeQuestion{

    /** Constructs a new instance with given parameters. */
    public PhysicsPracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                                   String question, String optionA, String optionB,
                                   String optionC, String optionD, Option correctOption,
                                   Date dateSavedToLocalDatabase) {
        super(practiceQuestionID, videoID, questionNumber, question, optionA, optionB, optionC,
                optionD, correctOption, dateSavedToLocalDatabase);
    }
}
