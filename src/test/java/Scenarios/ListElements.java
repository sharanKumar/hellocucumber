package Scenarios;

import Objects.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Action;

import java.time.Duration;
import java.util.List;

import static utils.WebDriverContext.driver;

public class ListElements extends Action {

    @And("I click on Element 1")
    public void i_click_on_Element1() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        clickFirstElement(PageObjects.element1_relative);
    }


    @When("I Scroll down to the bottom")
    public void i_scroll_down_toBottom() throws InterruptedException {
        scrollDown();
        Thread.sleep(5000);
    }

    @Then("I should see element 1 webpage")
    public void i_shouldSee_element1_webpage() {
        waitForElement(PageObjects.homePage_heading,10);
    }

}
