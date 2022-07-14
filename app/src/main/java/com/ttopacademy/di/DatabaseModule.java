package com.ttopacademy.di;

import android.content.Context;
import androidx.room.Room;
import com.ttopacademy.localdatasources.roomdb.AppDatabase;
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao;
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao;
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao;
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

/** Configures interfaces needed for configuring room database. */
@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    /** Configures AppDatabase. */
    @Provides
    @Singleton
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "TtopAcademy-Database").build();
    }

    /** Configures categoryDao. */
    @Provides
    @Singleton
    public static CategoryDao provideCategoryDao(AppDatabase appDatabase){
        return appDatabase.categoryDao();
    }

    /** Configures categorySubjectDao. */
    @Provides
    @Singleton
    public static CategorySubjectDao provideCategorySubjectDao(AppDatabase appDatabase){
        return appDatabase.categorySubjectDao();
    }

    /** Configures categorySubjectTopicDao. */
    @Provides
    @Singleton
    public static CategorySubjectTopicDao provideCategorySubjectTopicDao(AppDatabase appDatabase){
        return appDatabase.categorySubjectTopicDao();
    }

    /** Configures categorySubjectTopicVideoDao. */
    @Provides
    @Singleton
    public static CategorySubjectTopicVideoDao provideCategorySubjectTopicVideoDao(AppDatabase appDatabase){
        return appDatabase.categorySubjectTopicVideoDao();
    }

    /** Configures subjectDao. */
    @Provides
    @Singleton
    public static SubjectDao provideSubjectDao(AppDatabase appDatabase){
        return appDatabase.subjectDao();
    }

    /** Configures topicDao. */
    @Provides
    @Singleton
    public static TopicDao provideTopicDao(AppDatabase appDatabase){
        return appDatabase.topicDao();
    }

    /** Configures videoDao. */
    @Provides
    @Singleton
    public static VideoDao provideVideoDao(AppDatabase appDatabase){
        return appDatabase.videoDao();
    }

    /** Configures chemistryPracticeQuestionDao. */
    @Provides
    @Singleton
    public static ChemistryPracticeQuestionDao provideChemistryPracticeQuestionDao(AppDatabase appDatabase){
        return appDatabase.chemistryPracticeQuestionDao();
    }

    /** Configures physicsPracticeQuestionDao. */
    @Provides
    @Singleton
    public static PhysicsPracticeQuestionDao providePhysicsPracticeQuestionDao(AppDatabase appDatabase){
        return appDatabase.physicsPracticeQuestionDao();
    }

    /** Configures mathPracticeQuestionDao. */
    @Provides
    @Singleton
    public static MathPracticeQuestionDao provideMathPracticeQuestionDao(AppDatabase appDatabase){
        return appDatabase.mathPracticeQuestionDao();
    }

    /** Configures otherPracticeQuestionDao. */
    @Provides
    @Singleton
    public static OtherPracticeQuestionDao provideOtherPracticeQuestionDao(AppDatabase appDatabase){
        return appDatabase.otherPracticeQuestionDao();
    }
}
