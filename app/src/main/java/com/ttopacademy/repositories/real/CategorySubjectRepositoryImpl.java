package com.ttopacademy.repositories.real;

import com.ttopacademy.core.Result;
import com.ttopacademy.localdatasources.entities.CategorySubject;
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource;
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse;
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** CategorySubjectRepository Implementation class. */
public class CategorySubjectRepositoryImpl implements CategorySubjectRepository {

    private final CategorySubjectLocalDataSource categorySubjectLocalDataSource;
    private final CategorySubjectRemoteDataSource categorySubjectRemoteDataSource;

    /** Constructs a new instance. */
    @Inject
    public CategorySubjectRepositoryImpl(CategorySubjectLocalDataSource categorySubjectLocalDataSource,
                                         CategorySubjectRemoteDataSource categorySubjectRemoteDataSource) {
        this.categorySubjectLocalDataSource = categorySubjectLocalDataSource;
        this.categorySubjectRemoteDataSource = categorySubjectRemoteDataSource;
    }

    @Override
    public int getCategorySubjectID(int categoryID, int subjectID) {
        if (!categorySubjectLocalDataSource.isUpdated()){
            refreshCategorySubjects();
        }
        return categorySubjectLocalDataSource.getCategorySubjectID(categoryID, subjectID);
    }

    @Override
    public List<CategorySubject> getCategorySubjects(int categoryID) {
        if (!categorySubjectLocalDataSource.isUpdated()){
            refreshCategorySubjects();
        }
        return categorySubjectLocalDataSource.getCategorySubjects(categoryID);
    }

    private void refreshCategorySubjects(){
        Result<List<CategorySubjectResponse>> result = categorySubjectRemoteDataSource.getAllCategorySubjects();
        if (result instanceof Result.Success){
            List<CategorySubjectResponse> categorySubjectResponses = ((Result.Success<List<CategorySubjectResponse>>) result).data;
            updateCategorySubjectLocalDataSource(categorySubjectResponses);
        }
    }

    private void updateCategorySubjectLocalDataSource(List<CategorySubjectResponse> categorySubjectResponses){
        categorySubjectLocalDataSource.deleteAllCategorySubjects();
        List<CategorySubject> categorySubjects = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (CategorySubjectResponse categorySubjectResponse : categorySubjectResponses){
            categorySubjects.add(new CategorySubject(categorySubjectResponse.getCategorySubjectID(),
                    categorySubjectResponse.getCategoryID(), categorySubjectResponse.getSubjectID(),
                    dateSavedToLocalDatabase));
        }
        categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects);
    }
}
