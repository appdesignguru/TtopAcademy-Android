package com.ttopacademy.localdatasources.roomdb.fakedao;

import com.ttopacademy.localdatasources.entities.Category;
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake Category dao implementation class. Used for unit testing only. */
public class FakeCategoryDao implements CategoryDao {

    private final List<Category> categories = new ArrayList<>();

    /** Constructs a new instance. */
    @Inject
    public FakeCategoryDao() {

    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void insertCategories(List<Category> categories) {
        this.categories.addAll(categories);
    }

    @Override
    public void deleteAllCategories() {
        categories.clear();
    }

    @Override
    public Date getDateOfLastUpdate() {
        return null;
    }
}
