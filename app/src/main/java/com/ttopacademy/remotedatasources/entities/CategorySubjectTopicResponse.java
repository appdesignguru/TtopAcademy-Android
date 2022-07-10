package com.ttopacademy.remotedatasources.entities;

/** CategorySubjectTopicResponse entity. */
public class CategorySubjectTopicResponse {

    private final int categorySubjectTopicID;
    private final int categorySubjectID;
    private final int topicID;

    /** Constructs a new instance. */
    public CategorySubjectTopicResponse(int categorySubjectTopicID, int categorySubjectID, int topicID) {
        this.categorySubjectTopicID = categorySubjectTopicID;
        this.categorySubjectID = categorySubjectID;
        this.topicID = topicID;
    }

    /** Returns categorySubjectTopicID. */
    public int getCategorySubjectTopicID() {
        return categorySubjectTopicID;
    }

    /** Returns categorySubjectID. */
    public int getCategorySUbjectID() {
        return categorySubjectID;
    }

    /** Returns topicID. */
    public int getTopicID() {
        return topicID;
    }
}
