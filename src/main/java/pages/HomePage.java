package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HomePage {

    //WebDriver
    private WebDriver driver;
    //Locators : Cookie
    private By acceptCookieLocator = By.xpath("//button[contains(.,\"Aceptar y continuar\")]");
    //Locators : Popup
    //private By xBtnPopUpLocator = By.xpath("//*[@class='bx-modal__btn-close-icon']");
    private By xBtnPopUpLocator = By.xpath("//*[@class='bx-modal__btn-close-icon']");
    //private By popupBoxLocator = By.cssSelector("//img[@src=\"https://images.prismic.io/vivaair-cms-test/5603c099-d0ca-472d-b0b9-729a0d7b4f70_POP-UP-VIVA-ELEGIDO-MAYO-2022.png?auto=compress,format\"]");
    //Locators : Loader
    private By originLoaderLocator = By.xpath("//*[@class='loader']");
    //Locators : Trip Origin
    private By tripOriginLocator = By.cssSelector("#station");
    private By originLocator = By.xpath("//*[text()='Armenia']/..");
    //Locators : Trip Destiny
    private By tripDestinyLocator = By.xpath("//*[text()='Destino']");
    private By destinyLocator = By.xpath("//div[contains(text(),'Barranquilla')]");
    private By AllDestinyContainerLocator = By.cssSelector("div .station__popover");
    //Locators : Trip Date
    private By firstDateLocator = By.xpath("//*[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--mon']/div[text()=31]");
    private By lastDateLocator = By.xpath("//div[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--thu']/div[text()=11]");
    //Locators : Passengers
    private By passengerLocator = By.xpath("//label[@for='passenger'][contains(.,'Adulto')]");
    private By adultBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[1]");
    private By childrenBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[2]");
    private By infantBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[3]");
    private By closePassengerBtnLocator = By.cssSelector("button[class='close pull-right']");
    //Locators : Search Button
    private By searchBtnLocator = By.xpath("//button[@class='btn-blue ibe__button__desktop ibe__button']//span[@class='ibe__inputs-button'][contains(.,'Buscar')]");

    //CONSTRUCTOR
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //Waiters
    public void waitLoader(){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(originLoaderLocator)));
    }
    public void waitInSeconds(int time, int times){
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
    public void waitElementIsVisible(int time, WebElement element){
        FluentWait wait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //Should Accept Cookies
    public void clickOnAcceptCookies(){
        driver.findElement(acceptCookieLocator).click();
    }
    //Should Close PopUp
    public void clickXBtnPopUp(){
        waitElementIsVisible(10, driver.findElement(xBtnPopUpLocator));
            driver.findElement(xBtnPopUpLocator).click();
        }
    //Should select Trip Origin
    public void clickOnTripOrigin(){
        waitElementIsVisible(5, driver.findElement(tripOriginLocator));
        driver.findElement(tripOriginLocator).click();
    }
    public void clickTripPlaceOrigin(){
        waitElementIsVisible(5, driver.findElement(originLocator));
        driver.findElement(originLocator).click();
    }
    //Should select Trip Destiny
    public void clickOnTripDestiny(){
        waitElementIsVisible(5, driver.findElement(tripDestinyLocator));
        driver.findElement(tripDestinyLocator).click();
    }
    public void clickTripPlaceDestiny(){
        waitElementIsVisible(5, driver.findElement(destinyLocator));
        driver.findElement(destinyLocator).click();
    }
    //Selecting Trip Date
    public void selectInicialDate(){
        waitElementIsVisible(5, driver.findElement(firstDateLocator));
        driver.findElement(firstDateLocator).click();
    }
    public void selectFinalDate(){
        waitElementIsVisible(5, driver.findElement(lastDateLocator));
        driver.findElement(lastDateLocator).click();
    }
    //Should select how many passengers
    public void clickOnPassengers() {
        waitElementIsVisible(5, driver.findElement(passengerLocator));
        driver.findElement(passengerLocator).click();
    }
    public void clickAdultBtn() {
        waitElementIsVisible(5, driver.findElement(adultBtnLocator));
        driver.findElement(adultBtnLocator).click();
    }
    public void clickChildrenBtn() {
        waitElementIsVisible(5, driver.findElement(childrenBtnLocator));
        driver.findElement(childrenBtnLocator).click();
    }
    public void clickInfantBtn() {
        waitElementIsVisible(5, driver.findElement(infantBtnLocator));
        driver.findElement(infantBtnLocator).click();
    }
    public void clickClosePassengerBox(){
        waitElementIsVisible(5, driver.findElement(closePassengerBtnLocator));
        driver.findElement(closePassengerBtnLocator).click();
    }
    //Should select search button
    public void clickSearchBtn(){
        waitElementIsVisible(5, driver.findElement(searchBtnLocator));
        driver.findElement(searchBtnLocator).click();
    }




}
