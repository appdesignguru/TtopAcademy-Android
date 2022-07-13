package com.ttopacademy.repositories.fakes;

import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake CategorySubject repository implementation class. */
public class FakeCategorySubjectRepository implements CategorySubjectRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeCategorySubjectRepository(){

    }

    @Override
    public int getCategorySubjectID(int categoryID, int subjectID) {
        return 1;
    }

    @Override
    public List<CategorySubject> getCategorySubjects(int categoryID) {
        List<CategorySubject> mockCategorySubjects = new ArrayList<>();
        mockCategorySubjects.add(new CategorySubject(1, 1, 1, new Date()));
        mockCategorySubjects.add(new CategorySubject(1, 1, 2, new Date()));

        return mockCategorySubjects;
    }
}
