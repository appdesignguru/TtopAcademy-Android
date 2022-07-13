package com.ttopacademy.di;

import com.ttopacademy.localdatasources.fakes.FakeCategoryLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakePracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeSubjectLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeTopicLocalDataSource;
import com.ttopacademy.localdatasources.fakes.FakeVideoLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects local data sources interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class LocalDataSourceModule {

    /** Injects CategoryLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategoryLocalDataSource bindCategoryLocalDataSource(
            FakeCategoryLocalDataSource categoryLocalDataSourceImpl
    );

    /** Injects CategorySubjectLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectLocalDataSource bindCategorySubjectLocalDataSource(
            FakeCategorySubjectLocalDataSource categorySubjectLocalDataSourceImpl
    );

    /** Injects CategorySubjectTopicLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicLocalDataSource bindCategorySubjectTopicLocalDataSource(
            FakeCategorySubjectTopicLocalDataSource categorySubjectTopicLocalDataSourceImpl
    );

    /** Injects CategorySubjectTopicVideoLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicVideoLocalDataSource bindCategorySubjectTopicVideoLocalDataSource(
            FakeCategorySubjectTopicVideoLocalDataSource categorySubjectTopicVideoLocalDataSourceImpl
    );

    /** Injects PracticeQuestionLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract PracticeQuestionLocalDataSource bindPracticeQuestionLocalDataSource(
            FakePracticeQuestionLocalDataSource practiceQuestionLocalDataSourceImpl

    );

    /** Injects SubjectLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract SubjectLocalDataSource bindSubjectLocalDataSource(
            FakeSubjectLocalDataSource subjectLocalDataLocalSourceImpl
    );

    /** Injects TopicLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract TopicLocalDataSource bindTopicLocalDataSource(
            FakeTopicLocalDataSource topicLocalDataSourceImpl
    );

    /** Injects VideoLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract VideoLocalDataSource bindVideoLocalDataSource(
            FakeVideoLocalDataSource videoLocalDataSourceImpl
    );
}
