package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.Video;
import java.util.List;

/** Video local data source interface. */
public interface VideoLocalDataSource {

    /** Checks whether Video local data source is NOT up-to-date for given parameter. */
    boolean hasOutdatedVideos(int categorySubjectTopicVideoID);
    /** Returns videos with given parameters. */
    List<Video> getVideos(List<Integer> videoIDs);

    /** Returns true after saving successfully. */
    boolean saveVideos(List<Video> videos);

}
