package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for OtherPracticeQuestions. */
@Dao
public interface OtherPracticeQuestionDao {

    /** Returns practice questions for given parameter. */
    @Query("SELECT * FROM otherPracticeQuestion WHERE videoID == :videoID")
    List<PracticeQuestion> getPracticeQuestions(int videoID);

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPracticeQuestions(List<OtherPracticeQuestion> otherPracticeQuestions);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM otherPracticeQuestion" +
            " WHERE videoID == :videoID LIMIT 1")
    Date getDateOfLastUpdate(int videoID);

}
