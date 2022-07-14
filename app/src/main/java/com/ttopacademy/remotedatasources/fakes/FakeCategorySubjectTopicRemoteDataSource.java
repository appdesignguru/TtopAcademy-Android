package com.ttopacademy.remotedatasources.fakes;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopic remote data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicRemoteDataSource implements CategorySubjectTopicRemoteDataSource {

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicRemoteDataSource() {

    }

    @Override
    public Result<List<CategorySubjectTopicResponse>> getAllCategorySubjectTopics() {
        List<CategorySubjectTopicResponse> mockCategorySubjectTopicResponses = new ArrayList<>();
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(1, 1, 1));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(2, 1, 2));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(3, 2, 1));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(4, 2, 2));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(5, 3, 1));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(6, 3, 2));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(7, 4, 1));
        mockCategorySubjectTopicResponses.add(new CategorySubjectTopicResponse(8, 4, 2));

        return new Result.Success<>(mockCategorySubjectTopicResponses);
    }
}
