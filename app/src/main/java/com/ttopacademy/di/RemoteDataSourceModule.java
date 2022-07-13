package com.ttopacademy.di;

import com.ttopacademy.remotedatasources.fakes.FakeCategoryRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicVideoRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakePracticeQuestionRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeSubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeTopicRemoteDataSource;
import com.ttopacademy.remotedatasources.fakes.FakeVideoRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource;
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects remote data sources interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RemoteDataSourceModule {

    /** Injects CategoryRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategoryRemoteDataSource bindCategoryRemoteDataSource(
            FakeCategoryRemoteDataSource categoryRemoteDataSourceImpl
    );

    /** Injects CategorySubjectRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectRemoteDataSource bindCategorySubjectRemoteDataSource(
            FakeCategorySubjectRemoteDataSource categorySubjectRemoteDataSourceImpl
    );

    /** Injects CategorySubjectTopicRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicRemoteDataSource bindCategorySubjectTopicRemoteDataSource(
            FakeCategorySubjectTopicRemoteDataSource categorySubjectTopicRemoteDataSourceImpl
    );

    /** Injects CategorySubjectTopicVideoRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicVideoRemoteDataSource bindCategorySubjectTopicVideoRemoteDataSource(
            FakeCategorySubjectTopicVideoRemoteDataSource categorySubjectTopicVideoRemoteDataSourceImpl
    );

    /** Injects PracticeQuestionRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract PracticeQuestionRemoteDataSource bindPracticeQuestionRemoteDataSource(
            FakePracticeQuestionRemoteDataSource practiceQuestionRemoteDataSourceImpl
    );

    /** Injects SubjectRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract SubjectRemoteDataSource bindSubjectRemoteDataSource(
            FakeSubjectRemoteDataSource subjectLocalDataRemoteSourceImpl
    );

    /** Injects TopicRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract TopicRemoteDataSource bindTopicRemoteDataSource(
            FakeTopicRemoteDataSource topicRemoteDataSourceImpl
    );

    /** Injects VideoRemoteDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract VideoRemoteDataSource bindVideoRemoteDataSource(
            FakeVideoRemoteDataSource videoRemoteDataSourceImpl
    );
}

