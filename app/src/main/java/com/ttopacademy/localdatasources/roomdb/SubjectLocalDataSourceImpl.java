package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** SubjectLocalDataSource implementation class. */
public class SubjectLocalDataSourceImpl implements SubjectLocalDataSource {

    private final SubjectDao subjectDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public SubjectLocalDataSourceImpl(SubjectDao subjectDao, DateTimeUtility dateTimeUtility) {
        this.subjectDao = subjectDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    @Override
    public boolean isOutdated() {
        Date todaysDate = new Date();
        Date lastUpdated = subjectDao.getDateOfLastUpdate();
        if (lastUpdated == null){
            return true;
        }
        long dayDifference = dateTimeUtility.numberOfDaysbetween(todaysDate, lastUpdated);
        return dayDifference > 1;
    }

    @Override
    public List<Subject> getSubjects(List<Integer> subjectIDs) {
        return subjectDao.getSubjects(subjectIDs);
    }

    @Override
    public boolean saveSubjects(List<Subject> subjects) {
        subjectDao.insertSubjects(subjects);
        return true;
    }

    @Override
    public boolean deleteAllSubjects() {
        subjectDao.deleteAllSubjects();
        return true;
    }
}
