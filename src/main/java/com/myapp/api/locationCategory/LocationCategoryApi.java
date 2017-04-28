package com.myapp.api.locationCategory;

import com.myapp.domain.category.Category;
import com.myapp.domain.location.LocationCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tal on 16/04/2017.
 */
public interface LocationCategoryApi {


    public  List<LocationCategory> getCategoriesByLocation(String location) throws Exception;

    public void addLocationCategories(List<LocationCategory> locationCategories) throws Exception;


}
