package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.Video;
import java.util.List;

/** Repository interface for topics. */
public interface  VideoRepository {

    /** Returns videos with given parameters. */
    List<Video> getVideos(List<Integer> videoIDs);
}
