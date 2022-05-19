package Scenarios;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Action;
import utils.WebDriverContext;

import static utils.WebDriverContext.driver;

public class BeforeAndAfter extends WebDriverContext {
    private String browserName = "Chrome";

    public void i_open_sample_selenium_website_in() throws InterruptedException{
        getDriver(browserName);
        Thread.sleep(2000);
        Action.loadURL("http://www.seleniumframework.com/Practiceform/");
    }



    public void i_should_close(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        driver.quit();

    }
}
