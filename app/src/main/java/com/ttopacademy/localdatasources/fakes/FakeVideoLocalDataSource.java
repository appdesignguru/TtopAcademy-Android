package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Video local data source implementation class. Used for unit testing only. */
public class FakeVideoLocalDataSource implements VideoLocalDataSource {

    private final List<Video> videos = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeVideoLocalDataSource() {

    }

    @Override
    public boolean hasOutdatedVideos(List<Integer> videoIDs) {
        return true;
    }

    @Override
    public List<Video> getVideos(List<Integer> videoIDs) {
        List<Video> result = new ArrayList<>();
        Video video;
        for (int videoID : videoIDs){
            video = getVideo(videoID);
            if (video != null){
                result.add(video);
            }
        }
        return result;
    }

    @Override
    public boolean saveVideos(List<Video> videos) {
        this.videos.clear();
        this.videos.addAll(videos);
        return true;
    }

    private Video getVideo(int videoID){
        for (Video video : videos){
            if (video.getVideoID() == videoID){
                return video;
            }
        }
        return null;
    }
}
