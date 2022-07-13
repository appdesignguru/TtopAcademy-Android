package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject local data source implementation class. Used for unit testing only. */
public class FakeSubjectLocalDataSource implements SubjectLocalDataSource {

    private final List<Subject> subjects = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeSubjectLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public List<Subject> getSubjects(List<Integer> subjectIDs) {
        List<Subject> result = new ArrayList<>();
        Subject subject;
        for (int subjectID : subjectIDs){
            subject = getSubject(subjectID);
            if (subject != null){
                result.add(subject);
            }
        }
        return result;
    }

    @Override
    public boolean saveSubjects(List<Subject> subjects) {
        this.subjects.addAll(subjects);
        outdated = false;
        return true;
    }

    @Override
    public boolean deleteAllSubjects() {
        subjects.clear();
        outdated = true;
        return true;
    }

    private Subject getSubject(int subjectID){
        for (Subject subject : subjects){
            if (subject.getSubjectID() == subjectID){
                return subject;
            }
        }
        return null;
    }
}
