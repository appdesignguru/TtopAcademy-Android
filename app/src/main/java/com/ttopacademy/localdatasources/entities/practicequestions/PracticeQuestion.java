package com.ttopacademy.localdatasources.entities.practicequestions;

import java.util.Date;

/** PracticeQuestion entity class. */
public class PracticeQuestion {

    private final int practiceQuestionID;
    private final int videoID;
    private final int questionNumber;
    private final String question;
    private final String optionA;
    private final String optionB;
    private final String optionC;
    private final String optionD;
    private final Option correctOption;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public PracticeQuestion(int practiceQuestionID, int videoID, int questionNumber,
                            String question, String optionA, String optionB,
                            String optionC, String optionD, Option correctOption,
                            Date dateSavedToLocalDatabase) {
        this.practiceQuestionID = practiceQuestionID;
        this.videoID = videoID;
        this.questionNumber = questionNumber;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns practiceQuestionID. */
    public int getPracticeQuestionID() {
        return practiceQuestionID;
    }

    /** Returns videoID. */
    public int getVideoID() {
        return videoID;
    }

    /** Returns questionNumber. */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /** Returns question. */
    public String getQuestion() {
        return question;
    }

    /** Returns optionA. */
    public String getOptionA() {
        return optionA;
    }

    /** Returns optionB. */
    public String getOptionB() {
        return optionB;
    }

    /** Returns optionC. */
    public String getOptionC() {
        return optionC;
    }

    /** Returns optionD. */
    public String getOptionD() {
        return optionD;
    }

    /** Returns correctOption. */
    public Option getCorrectOption() {
        return correctOption;
    }

    /** Returns dateSavedToLocalDatabase. */
    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    /** Sets dateSavedToLocalDatabase. */
    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
