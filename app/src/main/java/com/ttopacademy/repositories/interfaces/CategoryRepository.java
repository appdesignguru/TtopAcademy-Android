package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Category;
import java.util.List;

/** Repository interface for categories. */
public interface CategoryRepository {

    /** Returns and posts all categories to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getAllCategoriesSync() instead. */
    void getAllCategories(ResultCallback<List<Category>> callback);

    /** Returns all categories. */
    List<Category> getAllCategoriesSync();
}
