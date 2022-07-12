package com.ttopacademy.repositories.real;

import android.os.Handler;
import com.ttopacademy.core.Result;
import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import com.ttopacademy.remotedatasources.entities.CategoryResponse;
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource;
import com.ttopacademy.repositories.interfaces.CategoryRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/** CategoryRepository Implementation class. */
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryLocalDataSource categoryLocalDataSource;
    private final CategoryRemoteDataSource categoryRemoteDataSource;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public CategoryRepositoryImpl(CategoryLocalDataSource categoryLocalDataSource,
                                  CategoryRemoteDataSource categoryRemoteDataSource,
                                  Executor executor, Handler resultHandler) {
        this.categoryLocalDataSource = categoryLocalDataSource;
        this.categoryRemoteDataSource = categoryRemoteDataSource;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void getAllCategories(ResultCallback<List<Category>> callback) {
        executor.execute(() -> {
            List<Category> result = getAllCategoriesSync();
            postResultToMainThread(result, callback);
        });
    }

    @Override
    public List<Category> getAllCategoriesSync() {
        if (!categoryLocalDataSource.isUpdated()){
            refreshCategories();
        }
        return categoryLocalDataSource.getAllCategories();
    }

    private void refreshCategories(){
        Result<List<CategoryResponse>> result = categoryRemoteDataSource.getAllCategories();
        if (result instanceof Result.Success){
            List<CategoryResponse> categoryResponses = ((Result.Success<List<CategoryResponse>>) result).data;
            updateCategoryLocalDataSource(categoryResponses);
        }
    }

    private void updateCategoryLocalDataSource(List<CategoryResponse> categoryResponses){
        categoryLocalDataSource.deleteAllCategories();
        List<Category> categories = new ArrayList<>();
        Date dateSavedToLocalDatabase = new Date();
        for (CategoryResponse categoryResponse : categoryResponses) {
            categories.add(
                    new Category(categoryResponse.getCategoryID(), categoryResponse.getNumber(),
                            categoryResponse.getName(),dateSavedToLocalDatabase)
            );
        }
        categoryLocalDataSource.saveCategories(categories);
    }

    private void postResultToMainThread(final List<Category> result,
                                        final ResultCallback<List<Category>> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}
