package com.myapp.rest;


import com.myapp.api.activity.ActivityApi;

import com.myapp.domain.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Tal.
 * <p>
 */
@Component
@Path("/activities")
public class ActivityService {

    @Autowired
    private ActivityApi activityApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivities() {
        return null;
    }

    @GET
    @Path("/getActivitiesByLocation/{location}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivitiesByLocation(@PathParam("location") String location) {
        //List<Activity> activities=activityApi.getActivitiesByLocation(location);
        return null;
    }

//    @POST
//    @Path("/duplicate")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response duplicateFunnel(@NotNull IdListWS funnelIds) throws NotImplementedException {
//        return null;
//    }
}

