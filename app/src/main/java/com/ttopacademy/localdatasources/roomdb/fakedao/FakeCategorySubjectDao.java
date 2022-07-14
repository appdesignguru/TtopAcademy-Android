package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubject dao implementation class. Used for unit testing only. */
public class FakeCategorySubjectDao implements CategorySubjectDao {

    private final List<CategorySubject> categorySubjects = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectDao() {

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
        for (CategorySubject categorySubject : categorySubjects){
            if (categorySubject.getCategoryID() == categoryID
                    && categorySubject.getSubjectID() == subjectID){
                return categorySubject.getCategorySubjectID();
            }
        }
        return 0;
    }

    @Override
    public void insertCategorySubjects(List<CategorySubject> categorySubjects) {
        this.categorySubjects.addAll(categorySubjects);
    }

    @Override
    public void deleteAllCategorySubjects() {
        categorySubjects.clear();
    }

    @Override
    public Date getDateOfLastUpdate() {
        return null;
    }
}
