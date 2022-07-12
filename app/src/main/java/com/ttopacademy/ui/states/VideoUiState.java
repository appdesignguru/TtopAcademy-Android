package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import java.util.List;

/** UI state for video list screen. */
public class VideoUiState {

    private final boolean fetchingVideos;
    private final List<Video> videos;
    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;

    public VideoUiState(boolean fetchingVideos, List<Video> videos, Category selectedCategory,
                        Subject selectedSubject, Topic selectedTopic) {
        this.fetchingVideos = fetchingVideos;
        this.videos = videos;
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
    }

    /** Checks whether videos are currently being fetched. */
    public boolean isFetchingVideos() {
        return fetchingVideos;
    }

    /** Returns all videos. */
    public List<Video> getVideos() {
        return videos;
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
