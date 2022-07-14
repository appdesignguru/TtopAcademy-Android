package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for CategorySubjects. */
@Dao
public interface CategorySubjectDao {

    /** Returns all CategorySubjects. */
    @Query("SELECT * FROM categorySubject WHERE categoryID == :categoryID")
    List<CategorySubject> getCategorySubjects(int categoryID);

    /** Returns categorySubjectID for given parameters. */
    @Query("SELECT categorySubjectID FROM categorysubject " +
            "WHERE categoryID == :categoryID AND subjectID == :subjectID")
    int getCategorySubjectID(int categoryID, int subjectID);

    /** Saves the categorySubjects. If any categorySubject already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategorySubjects(List<CategorySubject> categorySubjects);

    /** Deletes all categorySubjects in the database. */
    @Query("DELETE FROM categorySubject")
    void deleteAllCategorySubjects();

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM categorySubject LIMIT 1")
    Date getDateOfLastUpdate();
}
