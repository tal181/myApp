package com.myapp.DB;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.myapp.domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tal on 16/04/2017.
 */
@Component
public class MongoCategoryHelper {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Category>  find(String tableName) throws Exception{
        DBCollection table = mongoTemplate.getCollection(tableName);

        BasicDBObject searchQuery = new BasicDBObject();

        DBCursor cursor = table.find(searchQuery);
        List<Category> categories = new ArrayList<>();

        while (cursor.hasNext()) {
            DBObject dbobj = cursor.next();
            Gson gson = new Gson();

            Category category = gson.fromJson(dbobj.toString(),
                    Category.class);

            categories.add(category);

        }
        return categories;
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

    public void update(String tableName, Category key) {
        DBCollection table =mongoTemplate.getCollection(tableName);

        BasicDBObject updateQuery = new BasicDBObject();
        updateQuery.append("$set",
                new BasicDBObject().append("rating", key.getRating()));

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.append("categoryName", key.getCategoryName());

        table.update(searchQuery, updateQuery);
    }
}
