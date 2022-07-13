package com.ttopacademy.repositories.fakes;

import com.ttopacademy.core.ResultCallback;
import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.repositories.interfaces.CategoryRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Category repository implementation class. Used for unit testing only. */
public class FakeCategoryRepository implements CategoryRepository {

    /** Constructs a new instance. */
    @Inject
    public FakeCategoryRepository(){

    }

    @Override
    public void getAllCategories(ResultCallback<List<Category>> callback) {
        callback.onComplete(getAllCategoriesSync());
    }

    @Override
    public List<Category> getAllCategoriesSync() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, 1, "JAMB", new Date()));
        categories.add(new Category(2, 2, "SS3", new Date()));

        return categories;
    }
}
