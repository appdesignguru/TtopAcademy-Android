package com.ttopacademy.remotedatasources.interfaces;

import com.ttopacademy.core.Result;
import com.ttopacademy.remotedatasources.entities.CategoryResponse;
import java.util.List;

/** Category remote data source interface. */
public interface CategoryRemoteDataSource {

    /** Returns category responses. */
    Result<List<CategoryResponse>> getAllCategories();
}
