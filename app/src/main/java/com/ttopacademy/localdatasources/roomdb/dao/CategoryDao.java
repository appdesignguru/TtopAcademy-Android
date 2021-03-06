package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.Category;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for categories. */
@Dao
public interface CategoryDao {

    /** Returns all categories. */
    @Query("SELECT * FROM category ORDER BY number")
    List<Category> getAllCategories();

    /** Saves the categories. If any category already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategories(List<Category> categories);

    /** Deletes all categories in the database. */
    @Query("DELETE FROM category")
    void deleteAllCategories();

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM category LIMIT 1")
    Date getDateOfLastUpdate();
}
