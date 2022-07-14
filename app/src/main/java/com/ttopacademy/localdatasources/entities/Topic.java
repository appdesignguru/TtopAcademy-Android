package com.ttopacademy.localdatasources.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/** Topic entity class. */
@Entity
public class Topic {

    @PrimaryKey
    private final int topicID;

    private final int number;
    private final String name;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public Topic(int topicID, int number, String name, Date dateSavedToLocalDatabase) {
        this.topicID = topicID;
        this.number = number;
        this.name = name;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns topicID. */
    public int getTopicID() {
        return topicID;
    }

    /** Returns topic number. */
    public int getNumber() {
        return number;
    }

    /** Returns topic name. */
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
