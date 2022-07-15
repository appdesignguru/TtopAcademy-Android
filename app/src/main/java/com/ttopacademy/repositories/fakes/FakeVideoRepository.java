package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Video repository implementation class. Used for unit testing only. */
public class FakeVideoRepository implements VideoRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeVideoRepository(){

    }

    @Override
    public List<Video> getVideos(int categorySubjectTopicID, List<Integer> videoIDs) {
        List<Video> mockVideos = new ArrayList<>();
        mockVideos.add(new Video(1,  1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10", new Date()));
        mockVideos.add(new Video(2,  1, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10", new Date()));

        return mockVideos;
    }
}
