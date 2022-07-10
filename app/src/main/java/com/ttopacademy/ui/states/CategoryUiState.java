package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import java.util.List;

/** UI state for category list screen. */
public class CategoryUiState {

    private final boolean fetchingCategories;
    private final List<Category> categories;

    /** Constructs a new instance. */
    public CategoryUiState(boolean fetchingCategories, List<Category> categories) {
        this.fetchingCategories = fetchingCategories;
        this.categories = categories;
    }

    /** Checks whether categories are currently being fetched. */
    public boolean isFetchingCategories() {
        return fetchingCategories;
    }

    /** Returns all categories. */
    public List<Category> getCategories() {
        return categories;
    }
}
