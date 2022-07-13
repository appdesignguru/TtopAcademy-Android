package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject repository implementation class. */
public class FakeSubjectRepository implements SubjectRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeSubjectRepository(){

    }

    @Override
    public List<Subject> getSubjects(List<Integer> subjectIDs) {
        List<Subject> mockSubjects = new ArrayList<>();
        mockSubjects.add(new Subject(1, 1, "Physics", new Date()));
        mockSubjects.add(new Subject(2, 2, "Biology", new Date()));

        return mockSubjects;
    }
}
