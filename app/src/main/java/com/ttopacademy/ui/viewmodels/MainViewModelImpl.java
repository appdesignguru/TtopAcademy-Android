package com.ttopacademy.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.managers.interfaces.SubjectManager;
import com.ttopacademy.managers.interfaces.TopicManager;
import com.ttopacademy.managers.interfaces.VideoManager;
import com.ttopacademy.repositories.interfaces.CategoryRepository;
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository;
import com.ttopacademy.ui.states.CategoryUiState;
import com.ttopacademy.ui.states.PracticeQuestionUiState;
import com.ttopacademy.ui.states.SubjectUiState;
import com.ttopacademy.ui.states.TopicUiState;
import com.ttopacademy.ui.states.VideoItemUiState;
import com.ttopacademy.ui.states.VideoUiState;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/** MainViewModel implementation class. */
@HiltViewModel
public class MainViewModelImpl extends ViewModel implements MainViewModel {

    private final CategoryRepository categoryRepository;
    private final SubjectManager subjectManager;
    private final TopicManager topicManager;
    private final VideoManager videoManager;
    private final PracticeQuestionRepository practiceQuestionRepository;
    private final MutableLiveData<CategoryUiState> categoryUiState;
    private final MutableLiveData<SubjectUiState> subjectUiState;
    private final MutableLiveData<TopicUiState> topicUiState;
    private final MutableLiveData<VideoUiState> videoUiState;
    private final MutableLiveData<VideoItemUiState> videoItemUiState;
    private final MutableLiveData<PracticeQuestionUiState> practiceQuestionUiState;
    private Category selectedCategory;
    private Subject selectedSubject;
    private Topic selectedTopic;
    private Video selectedVideo;

    /** Constructs a new instance. */
    @Inject
    public MainViewModelImpl(CategoryRepository categoryRepository, SubjectManager subjectManager,
                             TopicManager topicManager, VideoManager videoManager,
                             PracticeQuestionRepository practiceQuestionRepository) {
        this.categoryRepository = categoryRepository;
        this.subjectManager = subjectManager;
        this.topicManager = topicManager;
        this.videoManager = videoManager;
        this.practiceQuestionRepository = practiceQuestionRepository;
        categoryUiState = new MutableLiveData<>();
        subjectUiState = new MutableLiveData<>();
        topicUiState = new MutableLiveData<>();
        videoUiState = new MutableLiveData<>();
        videoItemUiState = new MutableLiveData<>();
        practiceQuestionUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<CategoryUiState> getCategoryUiState() {
        categoryUiState.setValue(new CategoryUiState(true, new ArrayList<>()));
        getAllCategories();
        return categoryUiState;
    }

    @Override
    public MutableLiveData<SubjectUiState> getSubjectUiState() {
        subjectUiState.setValue(
                new SubjectUiState(true, new ArrayList<>(), selectedCategory)
        );
        getSubjects();
        return subjectUiState;
    }

    @Override
    public MutableLiveData<TopicUiState> getTopicUiState() {
        topicUiState.setValue(
                new TopicUiState(true, new ArrayList<>(), selectedCategory, selectedSubject)
        );
        getTopics();
        return topicUiState;
    }

    @Override
    public MutableLiveData<VideoUiState> getVideoUiState() {
        videoUiState.setValue(new VideoUiState(
                true, new ArrayList<>(), selectedCategory, selectedSubject, selectedTopic)
        );
        getVideos();
        return videoUiState;
    }

    @Override
    public MutableLiveData<VideoItemUiState> getVideoItemUiState() {
        videoItemUiState.setValue(
                new VideoItemUiState(selectedCategory, selectedSubject, selectedTopic, selectedVideo)
        );
        return videoItemUiState;
    }

    @Override
    public MutableLiveData<PracticeQuestionUiState> getPracticeQuestionUiState() {
        practiceQuestionUiState.setValue(
                new PracticeQuestionUiState(true, new ArrayList<>(), selectedCategory,
                        selectedSubject, selectedTopic, selectedVideo)
        );
        getPracticeQuestions();
        return practiceQuestionUiState;
    }

    @Override
    public void setSelectedCategory(Category category) {
        selectedCategory = category;
    }

    @Override
    public void setSelectedSubject(Subject subject) {
        selectedSubject = subject;
    }

    @Override
    public void setSelectedTopic(Topic topic) {
        selectedTopic = topic;
    }

    @Override
    public void setSelectedVideo(Video video) {
        selectedVideo = video;
    }

    private void getAllCategories(){
        categoryRepository.getAllCategories(
                result -> categoryUiState.setValue(new CategoryUiState(false, result))
        );
    }

    private void getSubjects(){
        subjectManager.getSubjects(selectedCategory.getCategoryID(), result ->
                subjectUiState.setValue(new SubjectUiState(false, result, selectedCategory))
        );
    }

    private void getTopics(){
        topicManager.getTopics(selectedCategory.getCategoryID(), selectedSubject.getSubjectID(),
                result -> topicUiState.setValue(
                        new TopicUiState(false, result, selectedCategory, selectedSubject)
                )
        );
    }

    private void getVideos(){
        videoManager.getVideos(
                selectedCategory.getCategoryID(), selectedSubject.getSubjectID(),selectedTopic.getTopicID(),
                result -> videoUiState.setValue(
                        new VideoUiState(false, result, selectedCategory, selectedSubject,
                                selectedTopic
                        ))
        );
    }

    private void getPracticeQuestions(){
        practiceQuestionRepository.getPracticeQuestions(
                selectedSubject.getName(), selectedVideo.getVideoID(),
                result -> practiceQuestionUiState.setValue(
                        new PracticeQuestionUiState(false, result, selectedCategory,
                                selectedSubject, selectedTopic, selectedVideo)
                )
        );
    }
}
