package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.Subject;
import java.util.List;

/** Repository interface for subjects. */
public interface SubjectRepository {

    /** Returns subjects with given parameters. */
    List<Subject> getSubjects(List<Integer> subjectIDs);
}
