package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopic dao implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicDao implements CategorySubjectTopicDao {

    private final List<CategorySubjectTopic> categorySubjectTopics = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicDao() {
    }

    @Override
    public List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID) {
        List<CategorySubjectTopic> result = new ArrayList<>();
        for(CategorySubjectTopic categorySubjectTopic : categorySubjectTopics){
            if (categorySubjectTopic.getCategorySubjectID() == categorySubjectID){
                result.add(categorySubjectTopic);
            }
        }
        return result;
    }

    @Override
    public int getCategorySubjectTopicID(int categorySubjectID, int topicID) {
        for(CategorySubjectTopic categorySubjectTopic : categorySubjectTopics){
            if (categorySubjectTopic.getCategorySubjectID() == categorySubjectID
                    && categorySubjectTopic.getTopicID() == topicID){
                return categorySubjectTopic.getCategorySubjectTopicID();
            }
        }
        return 0;
    }

    @Override
    public void insertCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics) {
        this.categorySubjectTopics.addAll(categorySubjectTopics);
    }

    @Override
    public void deleteAllCategorySubjectTopics() {
        categorySubjectTopics.clear();
    }

    @Override
    public Date getDateOfLastUpdate() {
        return null;
    }
}
