package utils;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDBContext {

    private MongoCollection connect(){
        MongoClient mongoClient = MongoClients.create("mongodb+srv://testuser:Test#0103@cluster0.wd1ql.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("SmileDB");
        return mongoDatabase.getCollection("users");
    }

    protected void insertOneData(String field , String Value){
        //generate random numbers between 5 to 100
        int random_int = (int)Math.floor(Math.random()*(100-5+1)+5);

        Document sampleDoc = new Document("_id",random_int).append(field,Value).append("email_id","abc@xyz.com");
        System.out.println("record number"+random_int);
        connect().insertOne(sampleDoc);

    }

    protected void fetchAllData(Bson query){
        //query documents which has email id as abc@xyz.com and print
        connect().find(query).forEach(doc -> System.out.println(doc.toString()));

    }

    protected void updateData(Bson filter,Bson update){
        UpdateOptions options = new UpdateOptions().upsert(true);
        System.out.println(connect().updateOne(filter, update, options));
    }

    protected void deleteData(Bson query){
        try {
            DeleteResult result = connect().deleteOne(query);
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }
    }

}
