package com.ttopacademy.localdatasources.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/** Category entity class. */
@Entity
public class Category {

    @PrimaryKey
    private final int categoryID;

    private final int number;
    private final String name;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public Category(int categoryID, int number, String name, Date dateSavedToLocalDatabase) {
        this.categoryID = categoryID;
        this.number = number;
        this.name = name;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns categoryID. */
    public int getCategoryID() {
        return categoryID;
    }

    /** Returns category number. */
    public int getNumber() {
        return number;
    }

    /** Returns category name. */
    public String getName() {
        return name;
    }

    /** Returns dateSavedToLocalDatabase. */
    public Date getDateSavedToLocalDatabase(){
        return dateSavedToLocalDatabase;
    }

    /** Sets dateSavedToLocalDatabase. */
    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
