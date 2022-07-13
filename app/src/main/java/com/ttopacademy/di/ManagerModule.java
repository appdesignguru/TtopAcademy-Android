package com.ttopacademy.di;

import com.ttopacademy.managers.interfaces.SubjectManager;
import com.ttopacademy.managers.interfaces.TopicManager;
import com.ttopacademy.managers.interfaces.VideoManager;
import com.ttopacademy.managers.real.SubjectManagerImpl;
import com.ttopacademy.managers.real.TopicManagerImpl;
import com.ttopacademy.managers.real.VideoManagerImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects manager interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class ManagerModule {

    /** Injects SubjectManager implementation with given parameter. */
    @Binds
    @Singleton
    public abstract SubjectManager bindSubjectManager(
            SubjectManagerImpl subjectManagerImpl
    );

    /** Injects TopicManager implementation with given parameter. */
    @Binds
    @Singleton
    public abstract TopicManager bindTopicManager(
            TopicManagerImpl topicManagerImpl
    );

    /** Injects VideoManager implementation with given parameter. */
    @Binds
    @Singleton
    public abstract VideoManager bindVideoManager(
            VideoManagerImpl videoManagerImpl
    );
}
