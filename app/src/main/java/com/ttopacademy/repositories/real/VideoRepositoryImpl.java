package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import com.ttopacademy.remotedatasources.entities.VideoResponse;
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** VideoRepository implementation class. */
public class VideoRepositoryImpl implements VideoRepository {

    private final VideoLocalDataSource videoLocalDataSource;
    private final VideoRemoteDataSource videoRemoteDataSource;

    /** Constructs a new instance. */
    @Inject
    public VideoRepositoryImpl(VideoLocalDataSource videoLocalDataSource,
                               VideoRemoteDataSource videoRemoteDataSource) {
        this.videoLocalDataSource = videoLocalDataSource;
        this.videoRemoteDataSource = videoRemoteDataSource;
    }

    @Override
    public List<Video> getVideos(int categorySubjectTopicID, List<Integer> videoIDs) {
        if (videoLocalDataSource.hasOutdatedVideos(videoIDs)){
            refreshVideos(categorySubjectTopicID);
        }
        return videoLocalDataSource.getVideos(videoIDs);
    }

    private void refreshVideos(int categorySubjectTopicID){
        Result<List<VideoResponse>> result = videoRemoteDataSource.getVideos(categorySubjectTopicID);
        if (result instanceof Result.Success){
            List<VideoResponse> videoResponses = ((Result.Success<List<VideoResponse>>) result).data;
            updateVideoLocalDataSource(videoResponses);
        }
    }

    private void updateVideoLocalDataSource(List<VideoResponse> videoResponses){
        List<Video> videos = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (VideoResponse videoResponse : videoResponses){
            videos.add(new Video(videoResponse.getVideoID(), videoResponse.getTitle(),
                    videoResponse.getYoutubeID(), videoResponse.getSize(),
                    videoResponse.getSolutionVideoYoutubeID(), videoResponse.getSolutionVideoSize(),
                    dateSavedToLocalDatabase));
        }
        videoLocalDataSource.saveVideos(videos);
    }
}
