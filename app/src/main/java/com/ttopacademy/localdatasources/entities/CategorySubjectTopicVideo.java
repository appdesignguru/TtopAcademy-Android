package com.ttopacademy.localdatasources.entities;

import java.util.Date;

/** CategorySubjectTopicVideo entity class. */
public class CategorySubjectTopicVideo {

    private final int categorySubjectTopicVideoID;
    private final int categorySubjectTopicID;
    private final int videoID;
    public Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public CategorySubjectTopicVideo(int categorySubjectTopicVideoID, int categorySubjectTopicID,
                                     int videoID, Date dateSavedToLocalDatabase) {
        this.categorySubjectTopicVideoID = categorySubjectTopicVideoID;
        this.categorySubjectTopicID = categorySubjectTopicID;
        this.videoID = videoID;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
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

    /** Returns dateSavedToLocalDatabase. */
    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    /** Sets dateSavedToLocalDatabase. */
    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
