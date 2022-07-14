package com.ttopacademy.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import java.util.Date;
import java.util.List;

/** Room database data access object interface for CategorySubjectTopicVideos. */
@Dao
public interface CategorySubjectTopicVideoDao {

    /** Returns all CategorySubjectTopicVideos. */
    @Query("SELECT * FROM CategorySubjectTopicVideo " +
            "WHERE categorySubjectTopicID == :categorySubjectTopicID")
    List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID);

    /** Returns CategorySubjectTopicVideoID for given parameters. */
    @Query("SELECT categorySubjectTopicVideoID FROM CategorySubjectTopicVideo " +
            "WHERE categorySubjectTopicID == :categorySubjectTopicID AND videoID == :videoID")
    int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID);

    /** Saves the categorySubjectTopicVideos.
     * If any categorySubjectTopicVideo already exists in the database, it replaces it. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategorySubjectTopicVideos(List<CategorySubjectTopicVideo> categorySubjectTopicVideos);

    /** Returns date of last update. */
    @Query("SELECT dateSavedToLocalDatabase FROM CategorySubjectTopicVideo" +
            " WHERE categorySubjectTopicID == :categorySubjectTopicID LIMIT 1")
    Date getDateOfLastUpdate(int categorySubjectTopicID);
}
