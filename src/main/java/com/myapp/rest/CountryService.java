package com.myapp.rest;

import com.myapp.api.location.CountriesApi;
import com.myapp.api.user.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tal on 16/04/2017.
 */
@Component
@Path("/countries")
public class CountryService {

    @Autowired
    CountriesApi countriesApi;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCountries() {
        try {
            Map<String,List<String>>  countries=countriesApi.getCountries();
            return Response
                    .ok(countries)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("error").build();
        }


    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCountries(HashMap<String, ArrayList<String>> countries) {
        try {
           countriesApi.addNewCountries(countries);
            return Response
                    .ok("")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity("error").build();
        }


    }
}
