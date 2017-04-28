package com.myapp.api.tripAdvisor;

import com.myapp.domain.activity.Activity;
import com.myapp.domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tal on 26/04/2017.
 */
@Component
public class TAImpl implements TAApi{
    @Autowired
    ManageTA manageTA;

    public  void getData() throws Exception{

//        manageTA.setLocation("London,United Kingdom");
//        Thread thread = new Thread(manageTA);
//        thread.start();
//
//        manageTA.setLocation("Tel Aviv, Israel");
//        Thread thread2 = new Thread(manageTA);
//        thread2.start();

        manageTA.setLocation("New York City, New York");
        Thread thread3 = new Thread(manageTA);
        thread3.start();


    }

}
