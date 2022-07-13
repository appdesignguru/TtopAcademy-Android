package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubject remote data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectRemoteDataSource implements CategorySubjectRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectRemoteDataSource(){

    }

    @Override
    public Result<List<CategorySubjectResponse>> getAllCategorySubjects() {
        List<CategorySubjectResponse> mockCategorySubjectResponses = new ArrayList<>();
        mockCategorySubjectResponses.add(new CategorySubjectResponse(1, 1, 1));
        mockCategorySubjectResponses.add(new CategorySubjectResponse(2, 1, 2));
        mockCategorySubjectResponses.add(new CategorySubjectResponse(3, 2, 1));
        mockCategorySubjectResponses.add(new CategorySubjectResponse(4, 2, 2));

        return new Result.Success<>(mockCategorySubjectResponses);
    }
}
