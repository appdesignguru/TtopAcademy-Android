package com.ttopacademy.ui.states;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import java.util.List;

/** UI state for practice question list screen. */
public class PracticeQuestionUiState {

    private final boolean fetchingPracticeQuestions;
    private final List<PracticeQuestion> practiceQuestions;
    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;
    private final Video selectedVideo;

    /** Constructs a new instance. */
    public PracticeQuestionUiState(boolean fetchingPracticeQuestions,
                                   List<PracticeQuestion> practiceQuestions,
                                   Category selectedCategory, Subject selectedSubject,
                                   Topic selectedTopic, Video selectedVideo) {
        this.fetchingPracticeQuestions = fetchingPracticeQuestions;
        this.practiceQuestions = practiceQuestions;
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
        this.selectedVideo = selectedVideo;
    }

    /** Checks whether practice questions are currently being fetched. */
    public boolean isFetchingPracticeQuestions() {
        return fetchingPracticeQuestions;
    }

    /** Returns all practice questions. */
    public List<PracticeQuestion> getPracticeQuestions() {
        return practiceQuestions;
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
