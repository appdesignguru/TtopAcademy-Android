package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.practicequestions.Option;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory;
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceFactoryImpl;
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeChemistryPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeMathPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeOtherPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakePhysicsPracticeQuestionDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PracticeQuestionLocalDataSourceTest {

    private PracticeQuestionLocalDataSource practiceQuestionLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        MathPracticeQuestionDao fakeMathPracticeQuestionDao = new FakeMathPracticeQuestionDao();
        PhysicsPracticeQuestionDao fakePhysicsPracticeQuestionDao = new FakePhysicsPracticeQuestionDao();
        ChemistryPracticeQuestionDao fakeChemistryPracticeQuestionDao = new FakeChemistryPracticeQuestionDao();
        OtherPracticeQuestionDao fakeOtherPracticeQuestionDao = new FakeOtherPracticeQuestionDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();

        PracticeQuestionLocalDataSourceFactory practiceQuestionLocalDataSourceFactory =
                new PracticeQuestionLocalDataSourceFactoryImpl(
                        fakeMathPracticeQuestionDao, fakePhysicsPracticeQuestionDao,
                        fakeChemistryPracticeQuestionDao, fakeOtherPracticeQuestionDao,
                        fakeDateTimeUtility
                );

        practiceQuestionLocalDataSource = new PracticeQuestionLocalDataSourceImpl(
                practiceQuestionLocalDataSourceFactory
        );

        // PreSave
        String subjectName = "Geography";
        practiceQuestionLocalDataSource.savePracticeQuestions(subjectName, getMockPracticeQuestions());
    }

    @After
    public void cleanupAfterEachTest(){
        practiceQuestionLocalDataSource = null;
    }

    @Test
    public void hasOutdatedPracticeQuestions_ShouldReturnTrueForGivenParameters(){
        String subjectName = "Geography";
        int videoID = 1;
        boolean result = practiceQuestionLocalDataSource.hasOutdatedPracticeQuestions(subjectName, videoID);
        assertTrue(result);
    }

    @Test
    public void getPracticeQuestions_ShouldReturnAllForGivenParameters(){
        String subjectName = "Geography";
        int videoID = 1;
        List<PracticeQuestion> result
                = practiceQuestionLocalDataSource.getPracticeQuestions(subjectName, videoID);
        assertEquals(2, result.size());
    }

    @Test
    public void savePracticeQuestions__ShouldReturnTrueAfterSaving(){
        String subjectName = "Geography";
        List<PracticeQuestion> practiceQuestions = new ArrayList<>();
        practiceQuestions.add(new PracticeQuestion(1, 1, 1,
                "Capital of Turkey?", "Kabul", "Texas", "Ohio",
                "New York", Option.A, new Date()));

        boolean result = practiceQuestionLocalDataSource.savePracticeQuestions(subjectName, practiceQuestions);
        assertTrue(result);
    }

    private List<PracticeQuestion> getMockPracticeQuestions(){

        List<PracticeQuestion> practiceQuestions = new ArrayList<>();
        practiceQuestions.add(new PracticeQuestion(1, 1, 1,
                "Capital of USA?", "Washington DC", "Texas", "Ohio",
                "New York", Option.A, new Date()));
        practiceQuestions.add(new PracticeQuestion(2, 1, 2,
                "Capital of Nigeria?", "Lagos", "Abuja", "Kano",
                "Kaduna", Option.B, new Date()));

        return practiceQuestions;
    }
}
