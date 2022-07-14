package com.ttopacademy.localdatasources.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/** Video entity class. */
@Entity
public class Video {

    @PrimaryKey
    private final int videoID;

    private final String title;
    private final String youtubeID;
    private final String size;
    private final String solutionVideoYoutubeID;
    private final String solutionVideoSize;
    private Date dateSavedToLocalDatabase;

    /** Constructs a new instance. */
    public Video(int videoID, String title, String youtubeID, String size,
                 String solutionVideoYoutubeID, String solutionVideoSize,
                 Date dateSavedToLocalDatabase) {
        this.videoID = videoID;
        this.title = title;
        this.youtubeID = youtubeID;
        this.size = size;
        this.solutionVideoYoutubeID = solutionVideoYoutubeID;
        this.solutionVideoSize = solutionVideoSize;
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }

    /** Returns videoID. */
    public int getVideoID() {
        return videoID;
    }

    /** Returns video title. */
    public String getTitle() {
        return title;
    }

    /** Returns video youtubeID. */
    public String getYoutubeID() {
        return youtubeID;
    }

    /** Returns video size in MB. */
    public String getSize() {
        return size;
    }

    /** Returns solution video youtubeID. */
    public String getSolutionVideoYoutubeID() {
        return solutionVideoYoutubeID;
    }

    /** Returns solution video size in MB. */
    public String getSolutionVideoSize() {
        return solutionVideoSize;
    }

    /** Returns dateSavedToLocalDatabase. */
    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    /** Sets dateSavedToLocalDatabase. */
    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
