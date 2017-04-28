package com.myapp.api.locationCategory;

import com.google.gson.Gson;
import com.myapp.DB.MongoCategoryHelper;
import com.myapp.DB.MongoLocationCategoryHelper;
import com.myapp.api.category.CategoryApi;
import com.myapp.api.location.CountriesApi;
import com.myapp.config.TablesScheme;
import com.myapp.domain.category.Category;
import com.myapp.domain.location.LocationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tal on 16/04/2017.
 */
@Component
public class LocationCategoryApiImpl implements LocationCategoryApi {

    @Autowired
    MongoLocationCategoryHelper mongoLocationCategoryHelper;

    public  List<LocationCategory> getCategoriesByLocation(String location) throws Exception{
        List<LocationCategory> categoriesByLocation=mongoLocationCategoryHelper.
                find(TablesScheme.LOCATION_CATEGORY_RATING_TABLE,location);

        return categoriesByLocation;

    }

    public void addLocationCategories( List<LocationCategory> locationCategories) throws Exception{

        Gson gson = new Gson();
        String locationCategoriesJson = gson.toJson(locationCategories);

        mongoLocationCategoryHelper.save(TablesScheme.LOCATION_CATEGORY_RATING_TABLE,
                locationCategoriesJson);

    }



}
