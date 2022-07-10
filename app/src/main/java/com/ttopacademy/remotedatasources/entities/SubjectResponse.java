package com.ttopacademy.remotedatasources.entities;

/** SubjectResponse entity class. */
public class SubjectResponse {

    private final int subjectID;
    private final int number;
    private final String name;

    /** Constructs a new instance. */
    public SubjectResponse(int subjectID, int number, String name) {
        this.subjectID = subjectID;
        this.number = number;
        this.name = name;
    }

    /** Returns subjectID. */
    public int getSubjectID() {
        return subjectID;
    }

    /** Returns subject number. */
    public int getNumber() {
        return number;
    }

    /** Returns subject name. */
    public String getName() {
        return name;
    }

}
