package com.ttopacademy.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.ui.states.CategoryUiState;
import com.ttopacademy.ui.states.PracticeQuestionUiState;
import com.ttopacademy.ui.states.SubjectUiState;
import com.ttopacademy.ui.states.TopicUiState;
import com.ttopacademy.ui.states.VideoItemUiState;
import com.ttopacademy.ui.states.VideoUiState;

/** State holder interface for the UI screens. */
public interface MainViewModel {

    /** Returns CategoryUiState. */
    MutableLiveData<CategoryUiState> getCategoryUiState();

    /** Returns SubjectUiState. */
    MutableLiveData<SubjectUiState> getSubjectUiState();

    /** Returns TopicUiState. */
    MutableLiveData<TopicUiState> getTopicUiState();

    /** Returns VideoUiState. */
    MutableLiveData<VideoUiState> getVideoUiState();

    /** Returns VideoItemUiState. */
    MutableLiveData<VideoItemUiState> getVideoItemUiState();

    /** Returns PracticeQuestionUiState. */
    MutableLiveData<PracticeQuestionUiState> getPracticeQuestionUiState();

    /** Sets selected category. */
    void setSelectedCategory(Category category);

    /** Sets selected subject. */
    void setSelectedSubject(Subject subject);

    /** Sets selected topic. */
    void setSelectedTopic(Topic topic);

    /** Sets selected video. */
    void setSelectedVideo(Video video);
}
