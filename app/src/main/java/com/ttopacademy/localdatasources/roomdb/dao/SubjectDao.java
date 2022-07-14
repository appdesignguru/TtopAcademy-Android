package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.Subject;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for Subjects. */
@Dao
public interface SubjectDao {

    /** Returns subjects with given parameters. */
    @Query("SELECT * FROM subject WHERE subjectID IN (:subjectIDs)")
    List<Subject> getSubjects(List<Integer> subjectIDs);

    /** Saves the subjects.
     * If any subject already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubjects(List<Subject> subjects);

    /** Deletes all subjects in the database. */
    @Query("DELETE FROM subject")
    void deleteAllSubjects();

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM subject LIMIT 1")
    Date getDateOfLastUpdate();

}
