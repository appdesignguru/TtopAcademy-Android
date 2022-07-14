package com.ttopacademy.localdatasources.entities.practicequestions;

import androidx.room.Entity;
import java.util.Date;

/** MathPracticeQuestion entity class. */
@Entity
public class MathPracticeQuestion extends PracticeQuestion{

    /** Constructs a new instance with given parameters. */
    public MathPracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                                String question, String optionA, String optionB, String optionC,
                                String optionD, Option correctOption, Date dateSavedToLocalDatabase) {
        super(practiceQuestionID, videoID, questionNumber, question, optionA, optionB, optionC,
                optionD, correctOption, dateSavedToLocalDatabase);
    }
}
