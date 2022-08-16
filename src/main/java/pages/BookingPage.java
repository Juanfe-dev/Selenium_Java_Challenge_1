package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Waiters;

import java.time.Duration;

public class BookingPage extends Waiters {

    private WebDriver driver;
    private By randomLocator = By.xpath("//p[contains(.,\"Recuerda, nuestros mejores\")]");

    public BookingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSomething(){
        waitPresenceOfElementLocated(randomLocator, driver);
        waitElementIsVisible(driver.findElement(randomLocator), driver);
        driver.findElement(randomLocator).isDisplayed();
    }

}

