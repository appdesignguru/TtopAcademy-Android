package com.ttopacademy.managers.fakes;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.managers.interfaces.VideoManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/** Fake Video Manager implementation class. Used for unit testing only. */
public class FakeVideoManager implements VideoManager {

    /** Constructs a new instance. */
    @Inject
    public FakeVideoManager(){

    }

    @Override
    public void getVideos(int categoryID, int subjectID, int topicID, ResultCallback<List<Video>> callback) {
        callback.onComplete(getVideosSync(categoryID, subjectID, topicID));
    }

    @Override
    public List<Video> getVideosSync(int categoryID, int subjectID, int topicID) {
        List<Video> mockVideos = new ArrayList<>();
        mockVideos.add(new Video(1, 1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10", new Date()));
        mockVideos.add(new Video(2,  1, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10", new Date()));

        return mockVideos;
    }
}
