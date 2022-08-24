package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

    /*
    * This class contains the waiters
    * */
public class Waiters {

    private WebDriver driver;
    //Locators : Loader
    private By originLoaderLocator = By.xpath("//*[@class='loader']");
    public Waiters(){
        this.driver = driver;
    }
    public void waitLoader(WebDriver driver){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(originLoaderLocator)));
    }
    public void waitInSeconds(int time, int times, WebDriver driver){
        FluentWait wait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(times))
                .ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(time));
    }
    public void waitInSeconds(int time){
        FluentWait wait = new FluentWait(driver)
                .ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(time));
    }
    public void waitElementIsVisible(WebElement element, WebDriver driver){
        FluentWait wait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitPresenceOfElementLocated(By element, WebDriver driver) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
