package com.ttopacademy.localdatasources.entities.practicequestions;

import androidx.room.Entity;
import java.util.Date;

/** OtherPracticeQuestion entity class. */
@Entity
public class OtherPracticeQuestion extends PracticeQuestion{

    /** Constructs a new instance. */
    public OtherPracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                                 String question, String optionA, String optionB, String optionC,
                                 String optionD, Option correctOption,
                                 Date dateSavedToLocalDatabase) {
        super(practiceQuestionID, videoID, questionNumber, question, optionA, optionB, optionC,
                optionD, correctOption, dateSavedToLocalDatabase);
    }
}
