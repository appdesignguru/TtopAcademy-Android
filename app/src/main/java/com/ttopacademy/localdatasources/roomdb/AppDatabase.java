package com.ttopacademy.localdatasources.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic;
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo;
import com.ttopacademy.localdatasources.entities.Subject;
import com.ttopacademy.localdatasources.entities.Topic;
import com.ttopacademy.localdatasources.entities.Video;
import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion;
import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion;
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

/** Declares Room AppDatabase. */
@Database(entities = {Category.class, CategorySubject.class, CategorySubjectTopic.class,
        CategorySubjectTopicVideo.class, Subject.class, Topic.class, Video.class,
        ChemistryPracticeQuestion.class, MathPracticeQuestion.class, PhysicsPracticeQuestion.class,
        OtherPracticeQuestion.class}, version = 1)
@TypeConverters({DateTimeConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    /** Declares data access objects for categories. */
    public abstract CategoryDao categoryDao();

    /** Declares data access objects for categorySubjects. */
    public abstract CategorySubjectDao categorySubjectDao();

    /** Declares data access objects for categorySubjectTopics. */
    public abstract CategorySubjectTopicDao categorySubjectTopicDao();

    /** Declares data access objects for categorySubjectTopicVideos. */
    public abstract CategorySubjectTopicVideoDao categorySubjectTopicVideoDao();

    /** Declares data access objects for Subjects. */
    public abstract SubjectDao subjectDao();

    /** Declares data access objects for Topics. */
    public abstract TopicDao topicDao();

    /** Declares data access objects for Videos. */
    public abstract VideoDao videoDao();

    /** Declares data access objects for ChemistryPracticeQuestions. */
    public abstract ChemistryPracticeQuestionDao chemistryPracticeQuestionDao();

    /** Declares data access objects for PhysicsPracticeQuestions. */
    public abstract PhysicsPracticeQuestionDao physicsPracticeQuestionDao();

    /** Declares data access objects for MathPracticeQuestions. */
    public abstract MathPracticeQuestionDao mathPracticeQuestionDao();

    /** Declares data access objects for otherPracticeQuestions. */
    public abstract OtherPracticeQuestionDao otherPracticeQuestionDao();
}
