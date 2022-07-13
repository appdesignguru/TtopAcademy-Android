package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategoryResponse;
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Category remote data source implementation class. Used for unit testing only. */
public class FakeCategoryRemoteDataSource implements CategoryRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeCategoryRemoteDataSource(){

    }

    @Override
    public Result<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> mockCategoryResponses = new ArrayList<>();
        mockCategoryResponses.add(new CategoryResponse(1, 1, "JAMB"));
        mockCategoryResponses.add(new CategoryResponse(2, 2, "SS3"));

        return new Result.Success<>(mockCategoryResponses);
    }
}
