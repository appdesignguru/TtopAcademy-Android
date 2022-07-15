package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.Video;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for Videos. */
@Dao
public interface VideoDao {

    /** Returns videos with given parameters. */
    @Query("SELECT * FROM video WHERE videoID IN (:videoIDs) ORDER BY number")
    List<Video> getVideos(List<Integer> videoIDs);

    /** Saves the videos.
     * If any video already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVideos(List<Video> videos);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM video WHERE videoID IN (:videoIDs) LIMIT 1")
    Date getDateOfLastUpdate(List<Integer> videoIDs);
}
