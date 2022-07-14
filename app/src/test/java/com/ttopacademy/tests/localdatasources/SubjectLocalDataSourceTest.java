package com.ttopacademy.tests.localdatasources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.SubjectLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao;
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeSubjectDao;
import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectLocalDataSourceTest {

    private SubjectLocalDataSource subjectLocalDataSource;

    @Before
    public void initializeBeforeEachTest(){
        SubjectDao fakeSubjectDao = new FakeSubjectDao();
        DateTimeUtility fakeDateTimeUtility = new FakeDateTimeUtility();
        subjectLocalDataSource = new SubjectLocalDataSourceImpl(fakeSubjectDao, fakeDateTimeUtility);

        // PreSave
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1, 1, "Physics", new Date()));
        subjects.add(new Subject(2, 2, "Chemistry", new Date()));

        subjectLocalDataSource.saveSubjects(subjects);
    }

    @After
    public void cleanupAfterEachTest(){
        subjectLocalDataSource = null;
    }

    @Test
    public void isOutdated_ShouldReturnTrue(){
        boolean result = subjectLocalDataSource.isOutdated();
        assertTrue(result);
    }

    @Test
    public void getSubjects_ShouldReturnAllForGivenParameters(){
        List<Integer> subjectIDs = new ArrayList<>();
        subjectIDs.add(1);
        subjectIDs.add(2);
        List<Subject> result = subjectLocalDataSource.getSubjects(subjectIDs);
        assertEquals(subjectIDs.size(), result.size());
    }

    @Test
    public void saveSubjects_ShouldReturnTrueAfterSaving(){
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(3, 3, "Biology", new Date()));

        boolean result = subjectLocalDataSource.saveSubjects(subjects);
        assertTrue(result);
    }

    @Test
    public void deleteAllSubjects_ShouldReturnTrueAfterDeleting(){
        boolean result = subjectLocalDataSource.deleteAllSubjects();
        assertTrue(result);
    }
}
