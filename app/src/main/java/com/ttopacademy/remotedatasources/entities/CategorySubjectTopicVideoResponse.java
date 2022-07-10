package com.ttopacademy.remotedatasources.entities;

/** CategorySubjectTopicVideoResponse entity class. */
public class CategorySubjectTopicVideoResponse {

    private final int categorySubjectTopicVideoID;
    private final int categorySubjectTopicID;
    private final int videoID;

    /** Constructs a new instance. */
    public CategorySubjectTopicVideoResponse(int categorySubjectTopicVideoID,
                                             int categorySubjectTopicID, int videoID) {
        this.categorySubjectTopicVideoID = categorySubjectTopicVideoID;
        this.categorySubjectTopicID = categorySubjectTopicID;
        this.videoID = videoID;
    }

    /** Returns categorySubjectTopicVideoID. */
    public int getCategorySubjectTopicVideoID() {
        return categorySubjectTopicVideoID;
    }

    /** Returns categorySubjectTopicID. */
    public int getCategorySubjectTopicID() {
        return categorySubjectTopicID;
    }

    /** Returns videoID. */
    public int getVideoID() {
        return videoID;
    }

}
