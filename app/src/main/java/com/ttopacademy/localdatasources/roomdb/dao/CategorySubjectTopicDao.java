package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for CategorySubjectTopics. */
@Dao
public interface CategorySubjectTopicDao {

    /** Returns all CategorySubjectTopics. */
    @Query("SELECT * FROM CategorySubjectTopic WHERE categorySubjectID == :categorySubjectID")
    List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID);

    /** Returns categorySubjectTopicID for given parameters. */
    @Query("SELECT categorySubjectTopicID FROM categorysubjectTopic " +
            "WHERE categorySubjectID == :categorySubjectID AND topicID == :topicID")
    int getCategorySubjectTopicID(int categorySubjectID, int topicID);

    /** Saves the categorySubjectTopics.
     * If any categorySubjectTopic already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics);

    /** Deletes all categorySubjectTopics in the database. */
    @Query("DELETE FROM categorySubjectTopic")
    void deleteAllCategorySubjectTopics();

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM categorySubjectTopic LIMIT 1")
    Date getDateOfLastUpdate();
}
