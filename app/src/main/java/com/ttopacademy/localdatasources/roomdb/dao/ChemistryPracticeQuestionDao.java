package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for ChemistryPracticeQuestions. */
@Dao
public interface ChemistryPracticeQuestionDao {

    /** Returns practice questions for given parameter. */
    @Query("SELECT * FROM chemistryPracticeQuestion WHERE videoID == :videoID")
    List<PracticeQuestion> getPracticeQuestions(int videoID);

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPracticeQuestions(List<ChemistryPracticeQuestion> chemistryPracticeQuestions);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM chemistryPracticeQuestion" +
            " WHERE videoID == :videoID LIMIT 1")
    Date getDateOfLastUpdate(int videoID);
}
