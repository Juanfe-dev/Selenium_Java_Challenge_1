package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Waiters;

import java.time.Duration;

public class BookingPage extends Waiters {

    private WebDriver driver;
    private By loaderLocator = By.xpath("//*[@class='loader']");
    private By bookingPageTextLocator = By.xpath("//p[contains(.,\"Recuerda, nuestros mejores\")]");
    private By lowerToHigherPriceFilterLocator = By.xpath("//button[@class='content-style btn btn-primary btn-lg'][text()='Menor a mayor']");
    private By lowerOptionLocator = By.xpath("(//*[@class='lowest-fare__price'])[1]");
    private By buyComboContinueBtnLocator = By.xpath("//*[@class='booking__action-btn__text'][text()='Continuar']");
    public BookingPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitBookingPageLoader() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loaderLocator)));
    }

    public String getBookingPageText(){
        waitPresenceOfElementLocated(bookingPageTextLocator, driver);
        waitElementIsVisible(driver.findElement(bookingPageTextLocator), driver);
        return driver.findElement(bookingPageTextLocator).getText().toString();
    }

    public void clickOnLowerPriceFilter(){
        waitPresenceOfElementLocated(lowerToHigherPriceFilterLocator, driver);
        waitElementIsVisible(driver.findElement(lowerToHigherPriceFilterLocator), driver);
        driver.findElement(lowerToHigherPriceFilterLocator).click();
    }
    public Boolean isLowerHigherFilterBtnExisting(){
        if(driver.findElements(lowerToHigherPriceFilterLocator).size() != 0){
            return true;
        } else return false;
    }

    public void clickOnLowerPriceItem(){
        waitPresenceOfElementLocated(lowerOptionLocator, driver);
        waitElementIsVisible(driver.findElement(lowerOptionLocator), driver);
        driver.findElement(lowerOptionLocator).click();
    }
    public void clickContinueBuyCombo(){
        waitPresenceOfElementLocated(buyComboContinueBtnLocator, driver);
        waitElementIsVisible(driver.findElement(buyComboContinueBtnLocator), driver);
        driver.findElement(buyComboContinueBtnLocator).click();
    }

}

