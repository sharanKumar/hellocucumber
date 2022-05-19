package Scenarios;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import io.cucumber.java.en.Given;
import org.bson.conversions.Bson;
import utils.MongoDBContext;

import java.util.Random;

import static com.mongodb.client.model.Filters.eq;

public class DbScenarios extends MongoDBContext {

    @Given("I add data to db")
    public void I_add_data() throws Exception {
        Random random = new Random();
        // Generates random integers 0 to 49
        int x = random.nextInt(100);

        insertOneData("name","Sharan"+ x);
    }

    @Given("I get data from db")
    public void I_get_data() throws Exception {
        Bson query = Filters.and(Filters.all("email_id","abc@xyz.com"));
        fetchAllData(query);
    }

    @Given("I update data in the db")
    public void I_update_data() throws Exception {
        Bson filter = eq("_id", 45);
        Bson update = Updates.set("email_id","a3@xyz.com");
        updateData(filter,update);
    }

    @Given("I delete data from db")
    public void I_delete_data() throws Exception {
        Bson query = eq("_id", 78);
        deleteData(query);
    }


}
