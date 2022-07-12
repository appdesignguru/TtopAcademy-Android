package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectTopicVideoRepository Implementation class. */
public class CategorySubjectTopicVideoRepositoryImpl implements CategorySubjectTopicVideoRepository {

    private final CategorySubjectTopicVideoLocalDataSource categorySubjectTopicVideoLocalDataSource;
    private final CategorySubjectTopicVideoRemoteDataSource categorySubjectTopicVideoRemoteDataSource;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectTopicVideoRepositoryImpl(
            CategorySubjectTopicVideoLocalDataSource categorySubjectTopicVideoLocalDataSource,
            CategorySubjectTopicVideoRemoteDataSource categorySubjectTopicVideoRemoteDataSource) {
        this.categorySubjectTopicVideoLocalDataSource = categorySubjectTopicVideoLocalDataSource;
        this.categorySubjectTopicVideoRemoteDataSource = categorySubjectTopicVideoRemoteDataSource;
    }

    @Override
    public int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID) {
        if (categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID)){
            refreshCategorySubjectTopicVideos(categorySubjectTopicID);
        }
        return categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideoID(categorySubjectTopicID, videoID);
    }

    @Override
    public List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        if (categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID)){
            refreshCategorySubjectTopicVideos(categorySubjectTopicID);
        }
        return categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideos(categorySubjectTopicID);
    }

    private void refreshCategorySubjectTopicVideos(int categorySubjectTopicID){
        Result<List<CategorySubjectTopicVideoResponse>> result
                = categorySubjectTopicVideoRemoteDataSource.getCategorySubjectTopicVideos(categorySubjectTopicID);
        if (result instanceof Result.Success){
            List<CategorySubjectTopicVideoResponse> categorySubjectTopicVideoResponses
                    = ((Result.Success<List<CategorySubjectTopicVideoResponse>>) result).data;
            updateCategorySubjectTopicVideoLocalDataSource(categorySubjectTopicVideoResponses);
        }
    }

    private void updateCategorySubjectTopicVideoLocalDataSource(
            List<CategorySubjectTopicVideoResponse> categorySubjectTopicVideoResponses){
        List<CategorySubjectTopicVideo> categorySubjectTopicVideos = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (CategorySubjectTopicVideoResponse categorySubjectTopicVideoResponse : categorySubjectTopicVideoResponses){
            categorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                    categorySubjectTopicVideoResponse.getCategorySubjectTopicVideoID(),
                    categorySubjectTopicVideoResponse.getCategorySubjectTopicID(),
                    categorySubjectTopicVideoResponse.getVideoID(),
                    dateSavedToLocalDatabase
            ));
        }
        categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(categorySubjectTopicVideos);
    }
}
