package com.myapp.api.compute;

import com.myapp.api.category.CategoryApi;
import com.myapp.api.location.CountriesApi;
import com.myapp.api.locationCategory.LocationCategoryApi;
import com.myapp.api.user.UserApi;
import com.myapp.domain.location.LocationCategory;
import com.myapp.domain.user.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tal on 24/04/2017.
 */
@Component
public class ComputeImpl implements ComputeApi{

    @Autowired
    CountriesApi countriesApi;

    @Autowired
    UserApi userApi;

    @Autowired
    LocationCategoryApi locationCategoryApi;
    @Override
    public Map<String,Double> computeUserLocationsCategories(String loginName) throws Exception{
        List<UserCategory> userCategories=userApi.getUserCategories(loginName);

        Map<String,List<String>> countries= countriesApi.getCountries();

        Map<String,Double> resalts= new HashMap<String,Double>();

        for (Map.Entry<String, List<String>> entry : countries.entrySet())
        {
            List<String> locations=entry.getValue();
            for (String location :locations) {
                List<LocationCategory> locationCategories= locationCategoryApi.getCategoriesByLocation(location);
                double result=computeUserLocationRating(userCategories,locationCategories);
                resalts.put(location,result);
            }
        }
        return resalts;
    }

    private double computeUserLocationRating(List<UserCategory> userCategories,
                                             List<LocationCategory> locationCategories) {

        double sum=0;
        int common=0;
        for(UserCategory userCategory: userCategories){
            for(LocationCategory locationCategory: locationCategories){
                if(userCategory.getCategoryName().equals(locationCategory.getCategoryName())){
                    sum+=Math.abs(userCategory.getRating()-locationCategory.getRating());
                    common++;
                }
            }
        }
        if(common==0){
            return common;
        }
        double result=sum/common;
        return result;
    }
}
