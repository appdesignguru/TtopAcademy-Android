package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import java.util.List;

/** UI state for topic list screen. */
public class TopicUiState {

    private final boolean fetchingTopics;
    private final List<Topic> topics;
    private final Category selectedCategory;
    private final Subject selectedSubject;

    /** Constructs a new instance. */
    public TopicUiState(boolean fetchingTopics, List<Topic> topics,
                        Category selectedCategory, Subject selectedSubject) {
        this.fetchingTopics = fetchingTopics;
        this.topics = topics;
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
    }

    /** Checks whether topics are currently being fetched. */
    public boolean isFetchingTopics() {
        return fetchingTopics;
    }

    /** Returns all topics. */
    public List<Topic> getTopics() {
        return topics;
    }

    /** Returns selected category. */
    public Category getSelectedCategory() {
        return selectedCategory;
    }

    /** Returns selected subject. */
    public Subject getSelectedSubject() {
        return selectedSubject;
    }
}
