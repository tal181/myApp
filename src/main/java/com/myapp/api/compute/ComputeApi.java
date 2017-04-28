package com.myapp.api.compute;

import java.util.Map;

/**
 * Created by Tal on 24/04/2017.
 */
public interface ComputeApi {
    Map<String,Double> computeUserLocationsCategories(String loginName) throws Exception;
}
