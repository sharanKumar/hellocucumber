package hellocucumber;

import Objects.PageObjects;
import Objects.Person;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumCommon;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.SeleniumCommon.driver;


public class StepDefinitions {

    private String browserName = "Chrome";

    @Before
    public void i_open_sample_selenium_website_in() {
        // Write code here that turns the phrase above into concrete actions
        SeleniumCommon.getDriver(browserName).get("http://www.seleniumframework.com/Practiceform/");

    }

    @When("I enter my email id")
    public void i_enter_my_email_id() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(PageObjects.email_id_field_absolute)).sendKeys("abc@xyz.com");
    }

    @Then("I should subscribe")
    public void i_should_subscribe() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(PageObjects.subscribe)).click();
    }

    @After
    public void i_should_close() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        //SeleniumCommon.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //SeleniumCommon.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(5000);

        driver.quit();

    }


    @And("I click on Element 1")
    public void i_click_on_Element1() {
        // Write code here that turns the phrase above into concrete actions

        List<WebElement> webElementsList = driver.findElements(By.xpath(PageObjects.element1_relative));

        for (int i = 0; i < webElementsList.size(); i++) {
            if (i == 1) {
                webElementsList.get(i).click();
            }
        }

    }


    @When("I Scroll down to the bottom")
    public void i_scroll_down_toBottom() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(5000);
    }

    @Then("I should see element 1 webpage")
    public void i_shouldSee_element1_webpage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageObjects.homePage_heading)));

    }

}
