package com.myapp.rest.TA;

import com.myapp.api.activity.ActivityApi;
import com.myapp.api.category.CategoryApi;
import com.myapp.api.tripAdvisor.TAApi;
import com.myapp.domain.activity.Activity;
import com.myapp.domain.category.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Scope;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//todo make it sigelton
@Component
@org.springframework.context.annotation.Scope("prototype")
@Path("/fetchTaData")
public class TAService {
    @Autowired
    TAApi taApi;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        try {
            taApi.getData();

            return Response
                    .ok()
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("error").build();
        }
    }


}
