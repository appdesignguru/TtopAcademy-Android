package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for MathPracticeQuestions. */
@Dao
public interface MathPracticeQuestionDao {

    /** Returns practice questions for given parameter. */
    @Query("SELECT * FROM mathPracticeQuestion WHERE videoID == :videoID")
    List<PracticeQuestion> getPracticeQuestions(int videoID);

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPracticeQuestions(List<MathPracticeQuestion> mathPracticeQuestions);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM mathPracticeQuestion" +
            " WHERE videoID == :videoID LIMIT 1")
    Date getDateOfLastUpdate(int videoID);
}
