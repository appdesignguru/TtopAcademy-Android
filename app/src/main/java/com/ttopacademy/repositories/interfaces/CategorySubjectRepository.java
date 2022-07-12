package com.ttopacademy.repositories.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import java.util.List;

/** Repository interface for CategorySubjects. */
public interface CategorySubjectRepository {

    /** Returns categorySubjectID. */
    int getCategorySubjectID(int categoryID, int subjectID);

    /** Returns categorySubjects for given parameter. */
    List<CategorySubject> getCategorySubjects(int categoryID);
}
