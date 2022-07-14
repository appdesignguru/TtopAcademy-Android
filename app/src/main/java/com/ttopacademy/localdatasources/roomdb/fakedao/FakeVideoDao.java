package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Video DAO implementation class. Used for unit testing only. */
public class FakeVideoDao implements VideoDao {

    private final List<Video> videos = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeVideoDao() {

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
    public void insertVideos(List<Video> videos) {
        this.videos.addAll(videos);
    }

    @Override
    public Date getDateOfLastUpdate(List<Integer> videoIDs) {
        return null;
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
