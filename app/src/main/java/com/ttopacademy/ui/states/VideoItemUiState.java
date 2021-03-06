package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;

/** UI state for video item screen. */
public class VideoItemUiState {

    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;
    private final Video selectedVideo;


    /** Constructs a new instance. */
    public VideoItemUiState(Category selectedCategory, Subject selectedSubject,
                            Topic selectedTopic, Video selectedVideo) {
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
        this.selectedVideo = selectedVideo;
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

    /** Returns selected video. */
    public Video getSelectedVideo() {
        return selectedVideo;
    }
}
