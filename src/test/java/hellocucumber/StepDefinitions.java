package hellocucumber;

import Objects.PageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumCommon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.time.Duration;


import static utils.SeleniumCommon.driver;


public class StepDefinitions {

    private String browserName = "Chrome";
    String mainwindow = "";

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
    public void i_should_close(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        Thread.sleep(5000);
        driver.quit();

    }


    @And("I click on Element 1")
    public void i_click_on_Element1() throws Exception {
        // Write code here that turns the phrase above into concrete actions

        List<WebElement> webElementsList = driver.findElements(By.xpath(PageObjects.element1_relative));

        if(webElementsList.size()>1){
            for (int i = 0; i < webElementsList.size(); i++) {
                if (i == 1) {
                    webElementsList.get(i).click();
                }
            }
        }else{
                throw new Exception("Element1 is still loading");

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


    @Then("I should see a new window")
    public void i_shouldSee_a_new_window() {
        mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageObjects.newBrowserWindow_mobile_menu)));

                driver.close();
                System.out.println("Child window closed");
            }
        }
    }

    @When("I click on the New window button")
    public void i_click_on_new_window() {
           driver.findElement(By.xpath(PageObjects.newBrowserWindow_button)).click();
    }

    @And("I come back to main window")
    public void i_come_back_to_window() {
        driver.switchTo().window(mainwindow);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageObjects.newBrowserWindow_button)));
    }

}
