package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubjectTopic repository implementation class. Used for unit testing only. */
public class FakeCategorySubjectTopicRepository implements CategorySubjectTopicRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectTopicRepository(){

    }

    @Override
    public int getCategorySubjectTopicID(int categorySubjectID, int topicID) {
        return 1;
    }

    @Override
    public List<CategorySubjectTopic> getCategorySubjectTopics(int categorySubjectID) {
        List<CategorySubjectTopic> mockCategorySubjectTopics = new ArrayList<>();
        mockCategorySubjectTopics.add(new CategorySubjectTopic(
                1, 1, 1, new Date()));
        mockCategorySubjectTopics.add(new CategorySubjectTopic(
                2, 1, 2, new Date()));

        return mockCategorySubjectTopics;
    }
}
