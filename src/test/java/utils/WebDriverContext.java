package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverContext {

    public static WebDriver driver;

    public static WebDriver getDriver(String browserName) {

        switch(browserName){

            case "Chrome":
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

        }

        return driver;
    }
}
