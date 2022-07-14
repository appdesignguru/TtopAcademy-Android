package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.VideoLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeVideoDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoLocalDataSourceTest {

    private VideoLocalDataSource videoLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        VideoDao fakeVideoDao = new FakeVideoDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        videoLocalDataSource = new VideoLocalDataSourceImpl(fakeVideoDao, fakeDateTimeUtility);

        // PreSave
        List<Video> videos = new ArrayList<>();
        videos.add(new Video(1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10", new Date()));
        videos.add(new Video(2, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10", new Date()));

        videoLocalDataSource.saveVideos(videos);
    }

    @After
    public void cleanupAfterEachTest(){
        videoLocalDataSource = null;
    }

    @Test
    public void hasOutdatedVideos_ShouldReturnTrueForGivenParameters(){
        List<Integer> videoIDs = new ArrayList<>();
        videoIDs.add(1);
        videoIDs.add(2);
        boolean result = videoLocalDataSource.hasOutdatedVideos(videoIDs);
        assertTrue(result);
    }

    @Test
    public void getVideos_ShouldReturnAllForGivenParameters(){
        List<Integer> videoIDs = new ArrayList<>();
        videoIDs.add(1);
        videoIDs.add(2);
        List<Video> result = videoLocalDataSource.getVideos(videoIDs);
        assertEquals(videoIDs.size(), result.size());
    }

    @Test
    public void saveVideos_ShouldReturnTrueAfterSaving(){
        List<Video> videos = new ArrayList<>();
        videos.add(new Video(3, "Video 3", "youtube 3", "10",
                "solution youtube 3", "10", new Date()));

        boolean result = videoLocalDataSource.saveVideos(videos);
        assertTrue(result);
    }
}
