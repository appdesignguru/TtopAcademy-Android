package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import java.util.List;

public interface VideoLocalDataSource {

    /** Checks whether Video local data source is up-to-date for given parameter. */
    boolean hasUpdatedVideos(int categorySubjectTopicVideoID);
    /** Returns videos with given parameters. */
    List<Topic> getVideos(List<Integer> videoIDs);

    /** Returns true after saving successfully. */
    boolean saveVideos(List<Video> videos);

}
