package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** VideoLocalDataSource implementation class. */
public class VideoLocalDataSourceImpl implements VideoLocalDataSource {

    private final VideoDao videoDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public VideoLocalDataSourceImpl(VideoDao videoDao, DateTimeUtility dateTimeUtility) {
        this.videoDao = videoDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean hasOutdatedVideos(List<Integer> videoIDs) {
        Date todaysDate = new Date();
        Date lastUpdated = videoDao.getDateOfLastUpdate(videoIDs);
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<Video> getVideos(List<Integer> videoIDs) {
        return videoDao.getVideos(videoIDs);
    }

    @Override
    public boolean saveVideos(List<Video> videos) {
        videoDao.insertVideos(videos);
        return true;
    }
}
