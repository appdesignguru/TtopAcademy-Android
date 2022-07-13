package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/** Fake CategorySubjectTopicVideo remote data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicVideoRemoteDataSource implements CategorySubjectTopicVideoRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicVideoRemoteDataSource() {

    }

    @Override
    public Result<List<CategorySubjectTopicVideoResponse>> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        List<CategorySubjectTopicVideoResponse> mockCategorySubjectTopicVideoResponses = new ArrayList<>();
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(1, 1, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(2, 1, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(3, 2, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(4, 2, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(5, 3, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(6, 3, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(7, 4, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(8, 4, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(9, 5, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(10, 5, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(11, 6, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(12, 6, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(13, 7, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(14, 7, 2));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(15, 8, 1));
        mockCategorySubjectTopicVideoResponses.add(new CategorySubjectTopicVideoResponse(16, 8, 2));

        return new Result.Success<>(mockCategorySubjectTopicVideoResponses);
    }
}
