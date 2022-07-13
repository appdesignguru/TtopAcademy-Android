package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/** Fake CategorySubjectTopic local data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicLocalDataSource implements CategorySubjectTopicLocalDataSource {

    private final List<CategorySubjectTopic> categorySubjectTopics = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public int getCategorySubjectTopicID(int categorySubjectID, int topicID) {
        for (CategorySubjectTopic categorySubjectTopic : categorySubjectTopics){
            if (categorySubjectTopic.getCategorySubjectID() == categorySubjectID
                    && categorySubjectTopic.getTopicID() == topicID){
                return categorySubjectTopic.getCategorySubjectTopicID();
            }
        }
        return 0;
    }

    @Override
    public List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID) {
        List<CategorySubjectTopic> result = new ArrayList<>();
        for (CategorySubjectTopic categorySubjectTopic : categorySubjectTopics){
            if (categorySubjectTopic.getCategorySubjectID() == categorySubjectID){
                result.add(categorySubjectTopic);
            }
        }
        return result;
    }

    @Override
    public boolean saveCategorySubjectTopics(List<CategorySubjectTopic> categorySubjectTopics) {
        this.categorySubjectTopics.clear();
        this.categorySubjectTopics.addAll(categorySubjectTopics);
        outdated = false;
        return true;
    }

    @Override
    public boolean deleteAllCategorySubjectTopics() {
        categorySubjectTopics.clear();
        outdated = true;
        return false;
    }
}
