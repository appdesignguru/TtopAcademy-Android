package com.ttopacademy.tests.repositories;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.fakes.FakeSubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeSubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import com.ttopacademy.repositories.real.SubjectRepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryTest {

    private SubjectRepository subjectRepository;

    @Before
    public void initializeBeforeEachTest(){
        SubjectLocalDataSource fakeSubjectLocalDataSource = new FakeSubjectLocalDataSource();
        SubjectRemoteDataSource fakeSubjectRemoteDataSource = new FakeSubjectRemoteDataSource();
        subjectRepository = new SubjectRepositoryImpl(
                fakeSubjectLocalDataSource, fakeSubjectRemoteDataSource
        );
    }

    @After
    public void cleanupAfterEachTest(){
        subjectRepository = null;
    }

    @Test
    public void getSubjects_ShouldReturnForGivenParameters(){
        List<Integer> subjectIDs = new ArrayList<>();
        subjectIDs.add(1);
        subjectIDs.add(2);
        List<Subject> result = subjectRepository.getSubjects(subjectIDs);
        assertEquals(subjectIDs.size(), result.size());
    }
}
