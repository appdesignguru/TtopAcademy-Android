package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.Subject;
import java.util.List;

/** Subject local data source interface. */
public interface SubjectLocalDataSource {

    /** Checks whether subject local data source is up-to-date. */
    boolean isUpdated();

    /** Returns subjects with given parameters. */
    List<Subject> getSubjects(List<Integer> subjectIDs);

    /** Returns true after saving successfully. */
    boolean saveSubjects(List<Subject> subjects);

    /** Returns true after deleting successfully. */
    boolean deleteAllSubjects();
}
