package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopicVideo repository implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicVideoRepository implements CategorySubjectTopicVideoRepository {

    /** Constructs a new instance*/
    @Inject
    public FakeCategorySubjectTopicVideoRepository(){

    }

    @Override
    public int getCategorySubjectTopicVideoID(int categorySubjectTopicID, int videoID) {
        return 8;
    }

    @Override
    public List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        List<CategorySubjectTopicVideo> mockCategorySubjectTopicVideos = new ArrayList<>();
        mockCategorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                1, 1, 1, new Date()));
        mockCategorySubjectTopicVideos.add(new CategorySubjectTopicVideo(
                1, 1, 2, new Date()));

        return mockCategorySubjectTopicVideos;
    }
}
