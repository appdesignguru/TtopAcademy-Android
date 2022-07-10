package com.ttopacademy.remotedatasources.entities;

/** CategorySubjectReponse entity. */
public class CategorySubjectResponse {

    private final int categorySubjectID;
    private final int categoryID;
    private final int subjectID;

    /** Constructs a new instance. */
    public CategorySubjectResponse(int categorySubjectID, int categoryID, int subjectID) {
        this.categorySubjectID = categorySubjectID;
        this.categoryID = categoryID;
        this.subjectID = subjectID;
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

}
