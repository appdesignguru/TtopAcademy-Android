package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubject local data source implementation class. Used for unit testing only. */
public class FakeCategorySubjectLocalDataSource implements CategorySubjectLocalDataSource {

    private final List<CategorySubject> categorySubjects = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public List<CategorySubject> getCategorySubjects(int categoryID) {
        List<CategorySubject> result = new ArrayList<>();
        for (CategorySubject categorySubject : categorySubjects){
            if (categorySubject.getCategoryID() == categoryID){
                result.add(categorySubject);
            }
        }
        return result;
    }

    @Override
    public int getCategorySubjectID(int categoryID, int subjectID) {
        for (CategorySubject categorySubject : categorySubjects) {
            if (categorySubject.getCategoryID() == categoryID
                    && categorySubject.getSubjectID() == subjectID){
                return  categorySubject.getCategorySubjectID();
            }
        }
        return 0;
    }

    @Override
    public boolean saveCategorySubjects(List<CategorySubject> categorySubjects) {
        this.categorySubjects.clear();
        this.categorySubjects.addAll(categorySubjects);
        outdated = false;
        return true;
    }

    @Override
    public boolean deleteAllCategorySubjects() {
        categorySubjects.clear();
        outdated = true;
        return true;
    }
}
