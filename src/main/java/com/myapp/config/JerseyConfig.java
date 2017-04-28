package com.myapp.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.RequestContextFilter;

/**
 * Created by Tal on 16/04/2017.
 */
@ComponentScan
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.myapp.rest");
        register(LoggingFilter.class);
    }
}