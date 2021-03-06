package com.myapp.DB;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.myapp.domain.activity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tal on 16/04/2017.
 */
@Component
public class MongoActivityHelper {

    @Autowired
    MongoTemplate mongoTemplate;


    public  List<Activity> find(String tableName, String location) throws Exception{
        DBCollection table = mongoTemplate.getCollection(tableName);

        BasicDBObject searchQuery = new BasicDBObject();
        if(location!=null) {
            searchQuery.put("location", location);
        }

        DBCursor cursor = table.find(searchQuery);
        List<Activity> activities = new ArrayList<>();
        Gson gson = new Gson();

        while (cursor.hasNext()) {
            DBObject dBObject = cursor.next();
            Activity activity = gson.fromJson(dBObject.toString(),
                    Activity.class);
            activities.add(activity);

        }
        return activities;
    }

    public void save(String tableName,String jsonObj){
        DBCollection table = mongoTemplate.getCollection(tableName);
        // convert JSON to DBObject directly
        List<DBObject> dbObject = (List<DBObject>) JSON
                .parse(jsonObj);

        table.insert(dbObject);

    }
    public  void remove(String tableName)  {

        DBCollection table =mongoTemplate.getCollection(tableName);

        table.remove(new BasicDBObject());


    }
}
