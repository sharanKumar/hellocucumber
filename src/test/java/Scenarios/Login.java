package Scenarios;

import Objects.PageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Action;

public class Login extends Action {

    @When("I enter my email id")
    public void i_enter_my_email_id() {
        // Write code here that turns the phrase above into concrete actions
        EnterKeys(PageObjects.email_id_field_absolute,"abc@xyz.com");
    }


    @Then("I should subscribe")
    public void i_should_subscribe() {
        // Write code here that turns the phrase above into concrete actions
        clickElement(PageObjects.subscribe);
    }

}
