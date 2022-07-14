package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Subject DAO implementation class. Used for unit testing only. */
public class FakeSubjectDao implements SubjectDao {

    private final List<Subject> subjects = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeSubjectDao() {

    }

    @Inject
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
    public void insertSubjects(List<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    @Override
    public void deleteAllSubjects() {
        this.subjects.clear();
    }

    @Override
    public Date getDateOfLastUpdate() {
        return null;
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
