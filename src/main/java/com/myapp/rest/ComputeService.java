package com.myapp.rest;

import com.myapp.api.compute.ComputeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by Tal on 24/04/2017.
 */
@Component
@Path("/compute")
public class ComputeService {
    @Autowired
    ComputeApi computeApi;
    @GET
    @Path("/{loginName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response compute(@PathParam("loginName") String loginName) {
        try {
            Map<String,Double> computes =computeApi.computeUserLocationsCategories(loginName);
            return Response
                    .ok(computes)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("error").build();
        }


    }
}
