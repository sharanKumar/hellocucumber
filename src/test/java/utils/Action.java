package utils;

import Objects.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Action extends WebDriverContext{

    public static void EnterKeys(By path,String value){
        driver.findElement(path).sendKeys(value);
    }

    public static void clickElement(By path){
        driver.findElement(path).click();
    }

    public static void loadURL(String url){
      driver.get(url);
    }

    public static void clickFirstElement(By path) throws Exception{
        List<WebElement> webElementsList = driver.findElements(path);

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

    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void waitForElement (By path,int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(path));
    }

    public static String getParentWindowHandle(){
        return driver.getWindowHandle();
    }

    public static void waitForChildWindowElementAndClose(String parent , By path,int seconds){
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!parent.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
                wait.until(ExpectedConditions.presenceOfElementLocated(path));

                driver.close();

            }
        }
    }

    public static void switchToWindow(String window){
        driver.switchTo().window(window);
    }



}
