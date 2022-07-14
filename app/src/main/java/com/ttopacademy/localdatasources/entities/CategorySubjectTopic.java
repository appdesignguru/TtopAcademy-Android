package com.ttopacademy.localdatasources.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/** CategorySubjectTopic entity class. */
@Entity
public class CategorySubjectTopic {

    @PrimaryKey
    private final int categorySubjectTopicID;

    private final int categorySubjectID;
    private final int topicID;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public CategorySubjectTopic(int categorySubjectTopicID, int categorySubjectID,
                                int topicID, Date dateSavedToLocalDatabase) {
        this.categorySubjectTopicID = categorySubjectTopicID;
        this.categorySubjectID = categorySubjectID;
        this.topicID = topicID;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns categorySubjectTopicID. */
    public int getCategorySubjectTopicID() {
        return categorySubjectTopicID;
    }

    /** Returns categorySubjectID. */
    public int getCategorySubjectID() {
        return categorySubjectID;
    }

    /** Returns topicID. */
    public int getTopicID() {
        return topicID;
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
