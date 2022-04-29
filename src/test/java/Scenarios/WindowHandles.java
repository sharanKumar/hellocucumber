package Scenarios;

import Objects.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Action;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static utils.WebDriverContext.driver;

public class WindowHandles extends Action {

    String parent = "";

    @When("I click on the New window button")
    public void i_click_on_new_window() {
        clickElement(PageObjects.newBrowserWindow_button);
    }

    @And("I come back to main window")
    public void i_come_back_to_window() {
        switchToWindow(parent);
        waitForElement(PageObjects.newBrowserWindow_button,10);
    }

    @Then("I should see a new window")
    public void i_shouldSee_a_new_window() {
        parent = getParentWindowHandle();
       waitForChildWindowElementAndClose(parent,PageObjects.newBrowserWindow_mobile_menu,10);
    }

}
