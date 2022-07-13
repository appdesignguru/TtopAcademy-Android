package com.ttopacademy.tests.managers;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.managers.interfaces.VideoManager;
import com.ttopacademy.managers.real.VideoManagerImpl;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicRepository;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicVideoRepository;
import com.ttopacademy.repositories.fakes.FakeVideoRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class VideoManagerTest {

    private VideoManager videoManager;

    @Before
    public void initializeBeforeEachTest() {
        CategorySubjectRepository fakeCategorySubjectRepository = new FakeCategorySubjectRepository();
        CategorySubjectTopicRepository fakeCategoryTopicSubjectRepository = new FakeCategorySubjectTopicRepository();
        CategorySubjectTopicVideoRepository fakeCategorySubjectTopicVideoRepository
                = new FakeCategorySubjectTopicVideoRepository();
        VideoRepository fakeVideoRepository = new FakeVideoRepository();
        videoManager = new VideoManagerImpl(
                fakeCategorySubjectRepository, fakeCategoryTopicSubjectRepository,
                fakeCategorySubjectTopicVideoRepository, fakeVideoRepository,
                null, null
        );
    }

    @After
    public void cleanupAfterEachTest(){
        videoManager = null;
    }

    @Test
    public void getTopicsSync_ShouldReturnTopicsForGivenParameters(){
        int categoryID = 1;
        int subjectID = 1;
        int topicID = 1;
        List<Video> result = videoManager.getVideosSync(categoryID, subjectID, topicID);
        assertEquals(2, result.size());
    }
}
