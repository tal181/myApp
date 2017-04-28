package com.myapp.api.category;

import com.myapp.domain.category.Category;
import com.myapp.domain.location.LocationCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tal on 16/04/2017.
 */
public interface CategoryApi {
    public List<Category> getCategories() throws Exception;

    public Map<String,Category> getCategoriesMap() throws Exception;

    void addNewCategories(List<Category> categories);

    void deleteAllRecords();

    void updateCategory(Category key);
}
