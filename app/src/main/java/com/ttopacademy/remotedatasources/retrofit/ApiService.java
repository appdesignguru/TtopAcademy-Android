package com.ttopacademy.remotedatasources.retrofit;

import com.ttopacademy.remotedatasources.entities.CategoryResponse;
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse;
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse;
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse;
import com.ttopacademy.remotedatasources.entities.SubjectResponse;
import com.ttopacademy.remotedatasources.entities.TopicResponse;
import com.ttopacademy.remotedatasources.entities.VideoResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/** Retrofit interface for making api calls. */
public interface ApiService {

    /** Returns all categories. */
    @GET("categories")
    Call<List<CategoryResponse>> getAllCategories();

    /** Returns all CategorySubjects. */
    @GET("CategorySubjects")
    Call<List<CategorySubjectResponse>> getAllCategorySubjects();

    /** Returns all CategorySubjectTopics. */
    @GET("CategorySubjectTopics")
    Call<List<CategorySubjectTopicResponse>> getAllCategorySubjectTopics();

    /** Returns all CategorySubjectTopicVideos. */
    @GET("CategorySubjectTopicVideo/{id}")
    Call<List<CategorySubjectTopicVideoResponse>> getCategorySubjectTopicVideos(
            @Path("id") int categorySubjectTopicID
    );

    /** Returns all subjects. */
    @GET("subjects")
    Call<List<SubjectResponse>> getAllSubjects();

    /** Returns all topics. */
    @GET("topics")
    Call<List<TopicResponse>> getAllTopics();

    /** Returns all CategorySubjectTopicVideos. */
    @GET("Video/{id}")
    Call<List<VideoResponse>> getVideos(@Path("id") int categorySubjectTopicID);

    /** Returns all CategorySubjectTopicVideos. */
    @GET("PracticeQuestions/{id}")
    Call<List<PracticeQuestionResponse>> getPracticeQuestions(
            @Path("id") String hyphenConcatenatedSubjectNameAndVideoID
    );
}
