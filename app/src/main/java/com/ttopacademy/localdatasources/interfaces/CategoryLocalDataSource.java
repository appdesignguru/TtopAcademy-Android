package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.Category;
import java.util.List;

/** Category local data source interface. */
public interface CategoryLocalDataSource {

    /** Checks whether category local data source is up-to-date. */
    boolean isOutdated();

    /** Returns all categories. */
    List<Category> getAllCategories();

    /** Returns true after saving successfully. */
    boolean saveCategories(List<Category> categories);

    /** Returns true after deleting successfully. */
    boolean deleteAllCategories();
}
