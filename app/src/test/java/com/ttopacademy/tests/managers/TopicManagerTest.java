package com.ttopacademy.tests.managers;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.managers.interfaces.TopicManager;
import com.ttopacademy.managers.real.TopicManagerImpl;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicRepository;
import com.ttopacademy.repositories.fakes.FakeTopicRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TopicManagerTest {

    private TopicManager topicManager;

    @Before
    public void initializeBeforeEachTest() {
        CategorySubjectRepository fakeCategorySubjectRepository = new FakeCategorySubjectRepository();
        CategorySubjectTopicRepository fakeCategoryTopicSubjectRepository = new FakeCategorySubjectTopicRepository();
        TopicRepository fakeTopicRepository = new FakeTopicRepository();
        topicManager = new TopicManagerImpl(
                fakeCategorySubjectRepository, fakeCategoryTopicSubjectRepository,
                fakeTopicRepository, null, null
        );
    }

    @After
    public void cleanupAfterEachTest(){
        topicManager = null;
    }

    @Test
    public void getTopicsSync_ShouldReturnTopicsForGivenParameters(){
        int categoryID = 1;
        int subjectID = 1;
        List<Topic> result = topicManager.getTopicsSync(categoryID, subjectID);
        assertEquals(2, result.size());
    }
}
