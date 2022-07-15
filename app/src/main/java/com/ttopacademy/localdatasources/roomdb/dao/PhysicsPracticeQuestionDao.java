package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for PhysicsPracticeQuestions. */
@Dao
public interface PhysicsPracticeQuestionDao {

    /** Returns practice questions for given parameter. */
    @Query("SELECT * FROM physicsPracticeQuestion WHERE videoID == :videoID ORDER BY questionNumber")
    List<PracticeQuestion> getPracticeQuestions(int videoID);

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPracticeQuestions(List<PhysicsPracticeQuestion> physicsPracticeQuestions);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM physicsPracticeQuestion" +
            " WHERE videoID == :videoID LIMIT 1")
    Date getDateOfLastUpdate(int videoID);
}
