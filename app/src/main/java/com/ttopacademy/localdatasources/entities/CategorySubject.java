package com.ttopacademy.localdatasources.entities;

import java.util.Date;

/** CategorySubject entity class. */
public class CategorySubject {

    private final int categorySubjectID;
    private final int categoryID;
    private final int subjectID;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public CategorySubject(int categorySubjectID, int categoryID,
                           int subjectID, Date dateSavedToLocalDatabase) {
        this.categorySubjectID = categorySubjectID;
        this.categoryID = categoryID;
        this.subjectID = subjectID;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns categorySubjectID. */
    public int getCategorySubjectID() {
        return categorySubjectID;
    }

    /** Returns categoryID. */
    public int getCategoryID() {
        return categoryID;
    }

    /** Returns subjectID. */
    public int getSubjectID() {
        return subjectID;
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
