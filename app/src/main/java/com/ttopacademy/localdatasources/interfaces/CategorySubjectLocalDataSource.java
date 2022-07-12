package com.ttopacademy.localdatasources.interfaces;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import java.util.List;

/** CategorySubject local data source interface. */
public interface CategorySubjectLocalDataSource {

    /** Checks whether categorySubject local data source is NOT up-to-date. */
    boolean isOutdated();

    /** Returns categorySubjects for given parameter. */
    List<CategorySubject> getCategorySubjects(int categoryID);

    /** Returns categorySubjectID for given parameters. */
    int getCategorySubjectID(int categoryID, int subjectID);

    /** Returns true after saving successfully. */
    boolean saveCategorySubjects(List<CategorySubject> categorySubjects);

    /** Returns true after deleting successfully. */
    boolean deleteAllCategorySubjects();
}
