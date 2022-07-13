package com.ttopacademy.managers.fakes;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.managers.interfaces.SubjectManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject Manager implementation class. Used for unit testing only. */
public class FakeSubjectManager implements SubjectManager {

    /** Constructs a new instance. */
    @Inject
    public FakeSubjectManager(){

    }

    @Override
    public void getSubjects(int categoryID, ResultCallback<List<Subject>> callback) {
        callback.onComplete(getSubjectsSync(categoryID));
    }

    @Override
    public List<Subject> getSubjectsSync(int categoryID) {
        List<Subject> mockSubjects = new ArrayList<>();
        mockSubjects.add(new Subject(1, 1, "Physics", new Date()));
        mockSubjects.add(new Subject(2, 2, "Biology", new Date()));

        return mockSubjects;
    }
}
