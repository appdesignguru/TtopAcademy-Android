package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.fakes.FakeVideoLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeVideoRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import com.ttopacademy.repositories.real.VideoRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @Before
    public void initializeBeforeEachTest(){
        VideoLocalDataSource fakeVideoLocalDataSource = new FakeVideoLocalDataSource();
        VideoRemoteDataSource fakeVideoRemoteDataSource = new FakeVideoRemoteDataSource();
        videoRepository = new VideoRepositoryImpl(
                fakeVideoLocalDataSource, fakeVideoRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        videoRepository = null;
    }

    @Test
    public void getVideos_ShouldReturnForGivenParameters(){
        int categorySubjectTopicID = 1;
        List<Integer> videoIDs = new ArrayList<>();
        videoIDs.add(1);
        videoIDs.add(2);
        List<Video> result = videoRepository.getVideos(categorySubjectTopicID, videoIDs);
        assertEquals(videoIDs.size(), result.size());
    }
}
