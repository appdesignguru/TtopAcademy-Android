package com.ttopacademy.di;

import com.ttopacademy.utitlities.fakes.FakeDateTimeUtility;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects utility interfaces. */
@Module
@InstallIn(SingletonComponent.class)
public abstract class UtilityModule {

    /** Injects DateTimeUtility implementation with given parameter. */
    @Binds
    @Singleton
    public abstract DateTimeUtility bindDateTimeUtility(
            FakeDateTimeUtility dateTimeUtilityImpl
    );
}
