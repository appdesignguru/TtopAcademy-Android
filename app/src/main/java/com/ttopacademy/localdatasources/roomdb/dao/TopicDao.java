package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.Topic;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for Topics. */
@Dao
public interface TopicDao {

    /** Returns topics with given parameters. */
    @Query("SELECT * FROM topic WHERE topicID IN (:topicIDs) ORDER BY number")
    List<Topic> getTopics(List<Integer> topicIDs);

    /** Saves the topics.
     * If any topic already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopics(List<Topic> topics);

    /** Deletes all topics in the database. */
    @Query("DELETE FROM topic")
    void deleteAllTopics();

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM topic LIMIT 1")
    Date getDateOfLastUpdate();
}
