package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectTopicRepository implementation class. */
public class CategorySubjectTopicRepositoryImpl implements CategorySubjectTopicRepository {

    private final CategorySubjectTopicLocalDataSource categorySubjectTopicLocalDataSource;
    private final CategorySubjectTopicRemoteDataSource categorySubjectTopicRemoteDataSource;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicRepositoryImpl(CategorySubjectTopicLocalDataSource categorySubjectTopicLocalDataSource,
                                              CategorySubjectTopicRemoteDataSource categorySubjectTopicRemoteDataSource) {
        this.categorySubjectTopicLocalDataSource = categorySubjectTopicLocalDataSource;
        this.categorySubjectTopicRemoteDataSource = categorySubjectTopicRemoteDataSource;
    }

    @Override
    public int getCategorySubjectTopicID(int categorySubjectID, int topicID) {
        if(categorySubjectTopicLocalDataSource.isOutdated()){
            refreshCategorySubjectTopics();
        }
        return categorySubjectTopicLocalDataSource.getCategorySubjectTopicID(categorySubjectID, topicID);
    }

    @Override
    public List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID) {
        if(categorySubjectTopicLocalDataSource.isOutdated()){
            refreshCategorySubjectTopics();
        }
        return categorySubjectTopicLocalDataSource.getCategorySubjectTopics(categorySubjectID);
    }

    private void refreshCategorySubjectTopics(){
        Result<List<CategorySubjectTopicResponse>> result
                = categorySubjectTopicRemoteDataSource.getAllCategorySubjectTopics();
        if (result instanceof Result.Success){
            List<CategorySubjectTopicResponse> categorySubjectTopicResponses
                    = ((Result.Success<List<CategorySubjectTopicResponse>>) result).data;
            updateCategorySubjectTopicLocalDataSource(categorySubjectTopicResponses);
        }
    }

    private void updateCategorySubjectTopicLocalDataSource(
            List<CategorySubjectTopicResponse> categorySubjectTopicResponses){
        categorySubjectTopicLocalDataSource.deleteAllCategorySubjectTopics();
        List<CategorySubjectTopic> categorySubjectTopics = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (CategorySubjectTopicResponse categorySubjectTopicResponse : categorySubjectTopicResponses){
            categorySubjectTopics.add(new CategorySubjectTopic(
                    categorySubjectTopicResponse.getCategorySubjectTopicID(),
                    categorySubjectTopicResponse.getCategorySUbjectID(),
                    categorySubjectTopicResponse.getTopicID(),
                    dateSavedToLocalDatabase));
        }
        categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics);
    }
}
