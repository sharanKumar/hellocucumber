package hellocucumber;

import Objects.PageObjects;
import Objects.Person;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import utils.SeleniumCommon;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {

   private String browserName = "chrome";

    @Given("I open sample selenium website in {string}")
    public void i_open_sample_selenium_website_in(String browser) {
        // Write code here that turns the phrase above into concrete actions
        SeleniumCommon.getDriver(browser).get("http://www.seleniumframework.com/Practiceform/");

    }

    @When("I enter my email id")
    public void i_enter_my_email_id() {
        // Write code here that turns the phrase above into concrete actions
     SeleniumCommon.driver.findElement(By.xpath(PageObjects.email_id_field_absolute)).sendKeys("abc@xyz.com");
    }

    @Then("I should subscribe")
    public void i_should_subscribe() {
        // Write code here that turns the phrase above into concrete actions
     SeleniumCommon.driver.findElement(By.xpath(PageObjects.subscribe)).click();
    }

 @And("I should close")
 public void i_should_close() throws  InterruptedException {
  // Write code here that turns the phrase above into concrete actions

  //SeleniumCommon.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  //SeleniumCommon.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  Thread.sleep(5000);

  SeleniumCommon.driver.quit();

 }




}
