package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.fakes.FakePracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakePracticeQuestionRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource;
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository;
import com.ttopacademy.repositories.real.PracticeQuestionRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class PracticeQuestionRepositoryTest {

    private PracticeQuestionRepository practiceQuestionRepository;

    @Before
    public void initializeBeforeEachTest(){
        PracticeQuestionLocalDataSource fakePracticeQuestionLocalDataSource
                = new FakePracticeQuestionLocalDataSource();
        PracticeQuestionRemoteDataSource fakePracticeQuestionRemoteDataSource
                = new FakePracticeQuestionRemoteDataSource();
        practiceQuestionRepository = new PracticeQuestionRepositoryImpl(
                fakePracticeQuestionLocalDataSource, fakePracticeQuestionRemoteDataSource,
                null, null
        );
    }

    @After
    public void cleanupAfterEachTest(){
        practiceQuestionRepository = null;
    }

    @Test
    public void getPracticeQuestionsSync_ShouldReturnForGivenParameters(){
        String subjectName = "Biology";
        int videoID = 1;
        List<PracticeQuestion> result = practiceQuestionRepository.getPracticeQuestionsSync(subjectName, videoID);
        assertEquals(2, result.size());
    }
}
