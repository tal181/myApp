package com.myapp.api.activity;

import com.myapp.domain.activity.Activity;

import java.util.List;

/**
 * Created by tal on 26/04/2017.
 */
public interface ActivityApi {
    List<Activity> getActivitiesByLocation(String location)  throws Exception;

    void addActivities(List<Activity> activities)  throws Exception;

    void deleteAllRecords();
}
