package com.ttopacademy.managers.interfaces;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Video;
import java.util.List;

/** Interface for managing videos. */
public interface VideoManager {

    /** Returns and posts the videos for given parameters to the callback.
     *  This should be called on the main thread.
     *  For other threads, call getVideosSync() instead. */
    void getVideos(int categoryID, int subjectID, int topicID,
                   ResultCallback<List<Video>> callback);

    /** Returns the videos for given parameters. */
    List<Video> getVideosSync(int categoryID, int subjectID, int topicID);
}
