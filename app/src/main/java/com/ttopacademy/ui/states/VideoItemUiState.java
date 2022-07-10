package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;

/** UI state for video item screen. */
public class VideoItemUiState {

    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;

    /** Constructs a new instance. */
    public VideoItemUiState(Category selectedCategory, Subject selectedSubject,
                            Topic selectedTopic) {
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
    }

    /** Returns selected category. */
    public Category getSelectedCategory() {
        return selectedCategory;
    }

    /** Returns selected subject. */
    public Subject getSelectedSubject() {
        return selectedSubject;
    }

    /** Returns selected topic. */
    public Topic getSelectedTopic() {
        return selectedTopic;
    }
}
