package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopicVideo local data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicVideoLocalDataSource implements CategorySubjectTopicVideoLocalDataSource {

    private final List<CategorySubjectTopicVideo> categorySubjectTopicVideos = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicVideoLocalDataSource() {

    }

    @Override
    public boolean hasOutdatedCategorySubjectTopicVideos(int categorySubjectTopicID) {
        return true;
    }

    @Override
    public int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID) {
        for (CategorySubjectTopicVideo categorySubjectTopicVideo : categorySubjectTopicVideos){
            if (categorySubjectTopicVideo.getCategorySubjectTopicID() == categorySubjectTopicID
                    && categorySubjectTopicVideo.getVideoID() == videoID){
                return categorySubjectTopicVideo.getCategorySubjectTopicVideoID();
            }
        }
        return 0;
    }

    @Override
    public List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        return categorySubjectTopicVideos;
    }

    @Override
    public boolean saveCategorySubjectTopicVideos(List<CategorySubjectTopicVideo> categorySubjectTopicVideos) {
        this.categorySubjectTopicVideos.clear();
        this.categorySubjectTopicVideos.addAll(categorySubjectTopicVideos);
        return true;
    }
}
