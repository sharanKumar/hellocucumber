package Scenarios;

import Objects.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.json.simple.JSONObject;
import utils.ApiSupport;

public class APIScenarios extends ApiSupport {

    private String requestURI = "https://reqres.in/api/users";

    @Given("I verify Get method")
    public void I_verify_GET() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        GET(requestURI);
    }

    @Given("I verify post method")
    public void I_verify_POST() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        JSONObject request = new JSONObject();

        request.put("name", "Ajeet");
        request.put("Job", "Teacher");

        POST(requestURI,request);
    }



}
