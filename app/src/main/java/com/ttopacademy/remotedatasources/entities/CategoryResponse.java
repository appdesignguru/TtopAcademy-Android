package com.ttopacademy.remotedatasources.entities;

/** CategoryResponse entity class. */
public class CategoryResponse {

    private final int categoryID;
    private final int number;
    private final String name;

    /** Constructs a new instance. */
    public CategoryResponse(int categoryID, int number, String name) {
        this.categoryID = categoryID;
        this.number = number;
        this.name = name;
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
}
