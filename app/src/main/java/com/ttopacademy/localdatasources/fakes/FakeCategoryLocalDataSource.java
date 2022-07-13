package com.ttopacademy.localdatasources.fakes;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/** Fake Category local data source implementation class. Used for unit testing only. */
public class FakeCategoryLocalDataSource implements CategoryLocalDataSource {

    private final List<Category> categories = new ArrayList<>();
    private boolean outdated = true;

    /** Constructs a new instance. */
    @Inject
    public FakeCategoryLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return outdated;
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public boolean saveCategories(List<Category> categories) {
        this.categories.addAll(categories);
        outdated = false;
        return true;
    }

    @Override
    public boolean deleteAllCategories() {
        categories.clear();
        outdated = true;
        return true;
    }
}
