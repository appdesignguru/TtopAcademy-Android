package com.ttopacademy.di;

import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory;
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceFactoryImpl;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects factory interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class FactoryModule {

    /** Injects PracticeQuestionLocalDataSourceFactory implementation with given parameter. */
    @Binds
    @Singleton
    public abstract PracticeQuestionLocalDataSourceFactory bindPracticeQuestionLocalDataSourceFactory(
            PracticeQuestionLocalDataSourceFactoryImpl practiceQuestionLocalDataSourceFactoryImpl
    );

}
