package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopicVideo dao implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicVideoDao implements CategorySubjectTopicVideoDao {

    private final List<CategorySubjectTopicVideo> categorySubjectTopicVideos = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicVideoDao(){

    }

    @Override
    public List<CategorySubjectTopicVideo> getCategorySubjectTopicVideos(int categorySubjectTopicID) {
        List<CategorySubjectTopicVideo> result = new ArrayList<>();
        for (CategorySubjectTopicVideo categorySubjectTopicVideo : categorySubjectTopicVideos){
            if (categorySubjectTopicVideo.getCategorySubjectTopicID() == categorySubjectTopicID){
                result.add(categorySubjectTopicVideo);
            }
        }
        return result;
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
    public void insertCategorySubjectTopicVideos(List<CategorySubjectTopicVideo> categorySubjectTopicVideos) {
        this.categorySubjectTopicVideos.clear();
        this.categorySubjectTopicVideos.addAll(categorySubjectTopicVideos);
    }

    @Override
    public Date getDateOfLastUpdate(int categorySubjectTopicID) {
        return null;
    }
}
