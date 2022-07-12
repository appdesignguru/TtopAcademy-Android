package com.ttopacademy.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.entities.practicequestions.Option;
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion;
import com.ttopacademy.ui.states.CategoryUiState;
import com.ttopacademy.ui.states.PracticeQuestionUiState;
import com.ttopacademy.ui.states.SubjectUiState;
import com.ttopacademy.ui.states.TopicUiState;
import com.ttopacademy.ui.states.VideoItemUiState;
import com.ttopacademy.ui.states.VideoUiState;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeMainViewModel extends ViewModel implements MainViewModel {

    private Category selectedCategory;
    private Subject selectedSubject;
    private Topic selectedTopic;
    private Video selectedVideo;

    /** Constructs a new instance. */
    @Inject
    public FakeMainViewModel(){

    }

    @Override
    public MutableLiveData<CategoryUiState> getCategoryUiState() {
        MutableLiveData<CategoryUiState> categoryUiState = new MutableLiveData<>();

        List<Category> testCategories = new ArrayList<>();
        testCategories.add(new Category(1, 1, "JAMB", new Date()));
        testCategories.add(new Category(2, 2, "SS3", new Date()));

        categoryUiState.setValue(new CategoryUiState(false, testCategories));

        return categoryUiState;
    }

    @Override
    public MutableLiveData<SubjectUiState> getSubjectUiState() {
        MutableLiveData<SubjectUiState> subjectUiState = new MutableLiveData<>();

        List<Subject> testSubjects = new ArrayList<>();
        testSubjects.add(new Subject(1, 1, "English", new Date()));
        testSubjects.add(new Subject(2, 2, "Physics", new Date()));

        subjectUiState.setValue(new SubjectUiState(false, testSubjects, selectedCategory));

        return subjectUiState;
    }

    @Override
    public MutableLiveData<TopicUiState> getTopicUiState() {
        MutableLiveData<TopicUiState> topicUiState = new MutableLiveData<>();

        List<Topic> testTopics = new ArrayList<>();
        testTopics.add(new Topic(1, 1, "Topic 1", new Date()));
        testTopics.add(new Topic(2, 2, "Topic 2", new Date()));

        topicUiState.setValue(
                new TopicUiState(false, testTopics, selectedCategory, selectedSubject)
        );

        return topicUiState;
    }

    @Override
    public MutableLiveData<VideoUiState> getVideoUiState() {
        MutableLiveData<VideoUiState> videoUiState = new MutableLiveData<>();

        List<Video> testVideos = new ArrayList<>();
        testVideos.add(
                new Video(1, "Video Title 1", "youtubeID 1", "10",
                        "solyoutubeID 1", "10", new Date())
        );
        testVideos.add(
                new Video(2, "Video Title 2", "youtubeID 2", "10",
                        "solyoutubeID 2", "10", new Date())
        );

        videoUiState.setValue(new VideoUiState(false, testVideos, selectedCategory,
                selectedSubject, selectedTopic));

        return videoUiState;
    }

    @Override
    public MutableLiveData<VideoItemUiState> getVideoItemUiState() {
        MutableLiveData<VideoItemUiState> videoItemUiState = new MutableLiveData<>();
        videoItemUiState.setValue(
                new VideoItemUiState(selectedCategory, selectedSubject, selectedTopic, selectedVideo)
        );
        return videoItemUiState;
    }

    @Override
    public MutableLiveData<PracticeQuestionUiState> getPracticeQuestionUiState() {
        MutableLiveData<PracticeQuestionUiState> practiceQuestionUiState = new MutableLiveData<>();

        List<PracticeQuestion> testPracticeQuestions = new ArrayList<>();
        testPracticeQuestions.add(
                new PracticeQuestion(1, 1, 1, "Question 1",
                    "Option A", "Option B", "Option C", "Option D",
                        Option.D, new Date())
        );
        testPracticeQuestions.add(
                new PracticeQuestion(2, 2, 2, "Question 2",
                        "Option A", "Option B", "Option C", "Option D",
                        Option.D, new Date())
        );

        practiceQuestionUiState.setValue(
                new PracticeQuestionUiState(false, testPracticeQuestions,
                        selectedCategory, selectedSubject, selectedTopic, selectedVideo)
        );

        return practiceQuestionUiState;
    }

    @Override
    public void setSelectedCategory(Category category) {
        this.selectedCategory = category;
    }

    @Override
    public void setSelectedSubject(Subject subject) {
        this.selectedSubject = subject;
    }

    @Override
    public void setSelectedTopic(Topic topic) {
        this.selectedTopic = topic;
    }

    @Override
    public void setSelectedVideo(Video video) {
        this.selectedVideo = video;
    }
}
