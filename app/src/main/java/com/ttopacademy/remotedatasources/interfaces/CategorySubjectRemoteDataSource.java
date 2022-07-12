package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse;
import java.util.List;

/** CategorySubject remote data source interface. */
public interface CategorySubjectRemoteDataSource {

    /** Returns CategorySubject responses. */
    Result<List<CategorySubjectResponse>> getAllCategorySubjects();
}
