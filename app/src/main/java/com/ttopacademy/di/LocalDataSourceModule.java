package com.ttopacademy.di;

import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource;
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.CategoryLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicVideoLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.SubjectLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.TopicLocalDataSourceImpl;
import com.ttopacademy.localdatasources.roomdb.VideoLocalDataSourceImpl;
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
            CategoryLocalDataSourceImpl categoryLocalDataSourceImpl
    );

    /** Injects CategorySubjectLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectLocalDataSource bindCategorySubjectLocalDataSource(
            CategorySubjectLocalDataSourceImpl categorySubjectLocalDataSourceImpl
    );

    /** Injects CategorySubjectTopicLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicLocalDataSource bindCategorySubjectTopicLocalDataSource(
            CategorySubjectTopicLocalDataSourceImpl categorySubjectTopicLocalDataSourceImpl
    );

    /** Injects CategorySubjectTopicVideoLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicVideoLocalDataSource bindCategorySubjectTopicVideoLocalDataSource(
            CategorySubjectTopicVideoLocalDataSourceImpl categorySubjectTopicVideoLocalDataSourceImpl
    );

    /** Injects PracticeQuestionLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract PracticeQuestionLocalDataSource bindPracticeQuestionLocalDataSource(
            PracticeQuestionLocalDataSourceImpl practiceQuestionLocalDataSourceImpl

    );

    /** Injects SubjectLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract SubjectLocalDataSource bindSubjectLocalDataSource(
            SubjectLocalDataSourceImpl subjectLocalDataLocalSourceImpl
    );

    /** Injects TopicLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract TopicLocalDataSource bindTopicLocalDataSource(
            TopicLocalDataSourceImpl topicLocalDataSourceImpl
    );

    /** Injects VideoLocalDataSource implementation with given parameter. */
    @Binds
    @Singleton
    public abstract VideoLocalDataSource bindVideoLocalDataSource(
            VideoLocalDataSourceImpl videoLocalDataSourceImpl
    );
}
