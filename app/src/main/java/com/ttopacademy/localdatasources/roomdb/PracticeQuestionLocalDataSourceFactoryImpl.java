package com.ttopacademy.localdatasources.roomdb;

import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory;
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource;
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao;
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao;
import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import javax.inject.Inject;

/** PracticeQuestionLocalDataSourceFactory implementation class. */
public class PracticeQuestionLocalDataSourceFactoryImpl implements PracticeQuestionLocalDataSourceFactory {

    private final MathPracticeQuestionDao mathPracticeQuestionDao;
    private final PhysicsPracticeQuestionDao physicsPracticeQuestionDao;
    private final ChemistryPracticeQuestionDao chemistryPracticeQuestionDao;
    private final OtherPracticeQuestionDao otherPracticeQuestionDao;
    private final DateTimeUtility dateTimeUtility;

    /** Constructs a new instance. */
    @Inject
    public PracticeQuestionLocalDataSourceFactoryImpl(
            MathPracticeQuestionDao mathPracticeQuestionDao,
            PhysicsPracticeQuestionDao physicsPracticeQuestionDao,
            ChemistryPracticeQuestionDao chemistryPracticeQuestionDao,
            OtherPracticeQuestionDao otherPracticeQuestionDao,
            DateTimeUtility dateTimeUtility) {
        this.mathPracticeQuestionDao = mathPracticeQuestionDao;
        this.physicsPracticeQuestionDao = physicsPracticeQuestionDao;
        this.chemistryPracticeQuestionDao = chemistryPracticeQuestionDao;
        this.otherPracticeQuestionDao = otherPracticeQuestionDao;
        this.dateTimeUtility = dateTimeUtility;
    }

    public SpecificPracticeQuestionLocalDataSource getSpecificPracticeQuestionLocalDataSource(String subjectName){
        switch (subjectName){
            case "Mathematics":
                return new MathPracticeQuestionLocalDataSourceImpl(mathPracticeQuestionDao, dateTimeUtility);
            case "Physics":
                return new PhysicsPracticeQuestionLocalDataSourceImpl(physicsPracticeQuestionDao, dateTimeUtility);
            case "Chemistry":
                return new ChemistryPracticeQuestionLocalDataSourceImpl(chemistryPracticeQuestionDao, dateTimeUtility);
            default:
                return new OtherPracticeQuestionLocalDataSourceImpl(otherPracticeQuestionDao, dateTimeUtility);
        }
    }
}
