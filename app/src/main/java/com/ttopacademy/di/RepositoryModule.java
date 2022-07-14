package com.ttopacademy.di;

import com.ttopacademy.repositories.interfaces.CategoryRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository;
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository;
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository;
import com.ttopacademy.repositories.interfaces.SubjectRepository;
import com.ttopacademy.repositories.interfaces.TopicRepository;
import com.ttopacademy.repositories.interfaces.VideoRepository;
import com.ttopacademy.repositories.real.CategoryRepositoryImpl;
import com.ttopacademy.repositories.real.CategorySubjectRepositoryImpl;
import com.ttopacademy.repositories.real.CategorySubjectTopicRepositoryImpl;
import com.ttopacademy.repositories.real.CategorySubjectTopicVideoRepositoryImpl;
import com.ttopacademy.repositories.real.PracticeQuestionRepositoryImpl;
import com.ttopacademy.repositories.real.SubjectRepositoryImpl;
import com.ttopacademy.repositories.real.TopicRepositoryImpl;
import com.ttopacademy.repositories.real.VideoRepositoryImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects repository interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {

    /** Injects CategoryRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategoryRepository bindCategoryRepository(
            CategoryRepositoryImpl categoryRepositoryImpl
    );

    /** Injects SubjectRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract SubjectRepository bindSubjectRepository(
            SubjectRepositoryImpl subjectRepositoryImpl
    );

    /** Injects CategorySubjectRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectRepository bindCategorySubjectRepository(
            CategorySubjectRepositoryImpl categorySubjectRepositoryImpl
    );

    /** Injects CategorySubjectTopicRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicRepository bindCategorySubjectTopicRepository(
            CategorySubjectTopicRepositoryImpl categorySubjectTopicRepositoryImpl
    );

    /** Injects CategorySubjectTopicVideoRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract CategorySubjectTopicVideoRepository bindCategorySubjectTopicVideoRepository(
            CategorySubjectTopicVideoRepositoryImpl categorySubjectTopicVideoRepositoryImpl
    );

    /** Injects TopicRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract TopicRepository bindTopicRepository(
            TopicRepositoryImpl topicRepositoryImpl
    );

    /** Injects VideoRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract VideoRepository bindVideoRepository(
            VideoRepositoryImpl videoRepositoryImpl
    );

    /** Injects PracticeQuestionRepository implementation with given parameter. */
    @Binds
    @Singleton
    public abstract PracticeQuestionRepository bindPracticeQuestionRepository(
            PracticeQuestionRepositoryImpl practiceQuestionRepositoryImpl
    );
}

