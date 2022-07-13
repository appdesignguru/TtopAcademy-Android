package com.ttopacademy.tests.managers;

import static org.junit.Assert.assertEquals;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.managers.interfaces.SubjectManager;
import com.ttopacademy.managers.real.SubjectManagerImpl;
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository;
import com.ttopacademy.repositories.fakes.FakeSubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class SubjectManagerTest {

    private SubjectManager subjectManager;

    @Before
    public void initializeBeforeEachTest(){
        CategorySubjectRepository fakeCategorySubjectRepository = new FakeCategorySubjectRepository();
        SubjectRepository fakeSubjectRepository = new FakeSubjectRepository();
        subjectManager = new SubjectManagerImpl(
                fakeCategorySubjectRepository, fakeSubjectRepository, null, null
        );
    }

    @After
    public void cleanupAfterEachTest(){
        subjectManager = null;
    }

    @Test
    public void getSubjectsSync_ShouldReturnSubjectsForGivenParameter(){
        int categoryID = 1;
        List<Subject> result = subjectManager.getSubjectsSync(categoryID);
        assertEquals(2, result.size());
    }
}
