package com.ttopacademy.localdatasources.entities;

import java.util.Date;

/** Subject entity class. */
public class Subject {

    private final int subjectID;
    private final int number;
    private final String name;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public Subject(int subjectID, int number, String name, Date dateSavedToLocalDatabase) {
        this.subjectID = subjectID;
        this.number = number;
        this.name = name;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
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

    /** Returns dateSavedToLocalDatabase. */
    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    /** Sets dateSavedToLocalDatabase. */
    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
