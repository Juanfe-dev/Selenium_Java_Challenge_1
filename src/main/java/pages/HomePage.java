package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Waiters;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class HomePage extends Waiters {


    //Arraylist Origin Cities
    ArrayList originCities = new ArrayList();
    //Arraylist Destiny Cities
    ArrayList destinyCities = new ArrayList();
    //Arraylist Initial Trip Date
    ArrayList initialTripDays = new ArrayList();//Arraylist First Trip Date
    //Arraylist Final Trip Date
    ArrayList finalTripDays = new ArrayList();
    //WebDriver
    private WebDriver driver;
    //Waiters Object
    private Waiters waiter = new Waiters();
    //Locators : Loader
    private By loaderLocator = By.xpath("//*[@class='loader']");
    //Locators : Cookie
    private By acceptCookieLocator = By.xpath("//button[contains(.,\"Aceptar y continuar\")]");
    //Locators : Popup
    //private By xBtnPopUpLocator = By.xpath("//*[@class='bx-modal__btn-close-icon']");
    private By xBtnPopUpLocator = By.xpath("//*[@class='bx-modal__btn-close-icon']");
    //Locators : Trip Origin
    private By tripOriginLocator = By.cssSelector("#station");
    private By originLocator;
    //private By originLocator = By.xpath("//*[text()='Armenia']/..");
    //private By originNewRouteLocator = By.xpath("(//*[@class='station__name --with-new-route'])");
    //private By originOtherRoutesLocator = By.xpath("(//span[@class='station__name'])");
    //Locators : Trip Destiny
    private By tripDestinyLocator = By.xpath("//*[text()='Destino']");
    private By destinyLocator;
    private By AllDestinyContainerLocator = By.cssSelector("div .station__popover");
    //Locators : Trip Date
    private By firstDateInputLocator = By.id("date");

    //private By firstDateLocator;
    private By firstDateLocator = By.xpath("//*[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--mon']/div[text()=31]");
    private By lastDateLocator = By.xpath("//div[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--thu']/div[text()=30]");
    //private By lastDateLocator;
    //Locators : Passengers
    private By passengerLocator = By.xpath("//label[@for='passenger'][contains(.,'Adulto')]");
    private By adultBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[1]");
    private By childrenBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[2]");
    private By infantBtnLocator = By.xpath("(//*[@class='action__sign'][text()=\"+\"])[3]");
    private By closePassengerBtnLocator = By.cssSelector("button[class='close pull-right']");
    //Locators : Search Button
    private By searchBtnLocator = By.xpath("//button[@class='btn-blue ibe__button__desktop ibe__button']");

    //CONSTRUCTOR
        public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Should wait the loader
        public void waitHomePageLoader() {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loaderLocator)));
    }

    //Should Accept Cookies
        public void clickOnAcceptCookies() {
        driver.findElement(acceptCookieLocator).click();
    }

    //Should Close PopUp
        public void clickXBtnPopUp() {
        waitPresenceOfElementLocated(xBtnPopUpLocator, driver);
        waitElementIsVisible(driver.findElement(xBtnPopUpLocator), driver);
        driver.findElement(xBtnPopUpLocator).click();
    }

    //Should select Trip Origin
        public void saveOriginCities() {
            int i = 1;
            Boolean flag_1 = true;
            while (flag_1) {
                By originNewRouteLocator = By.xpath("(//*[@class='station__name --with-new-route'])" + "[" + i + "]");
                String originNewRouteLocatorString = originNewRouteLocator.toString();
                String originReformatNewRoutesLocator = originNewRouteLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(originNewRouteLocator).size() != 0)) {
                    originCities.add(originReformatNewRoutesLocator);
                    i++;
                } else {
                    flag_1 = false;
                }
            }
            int j = 1;
            Boolean flag_2 = true;
            while (flag_2) {
                By originOtherRoutesLocator = By.xpath("(//span[@class='station__name'])" + "[" + j + "]");
                String originOtherRoutesLocatorString = originOtherRoutesLocator.toString();
                String originReformatOtherRoutesLocator = originOtherRoutesLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(originOtherRoutesLocator).size() != 0)) {
                    originCities.add(originReformatOtherRoutesLocator);
                    j++;
                } else {
                    flag_2 = false;
                }
            }
        }
        public void clickOnTripOrigin() {
            waitPresenceOfElementLocated(tripOriginLocator, driver);
            waitElementIsVisible(driver.findElement(tripOriginLocator), driver);
            driver.findElement(tripOriginLocator).click();
        }
        public void clickTripPlaceOrigin() {
            //originLocator = By.xpath(setRandomLocator(originCities));
            originLocator = By.xpath("(//*[text()='Bucaramanga']/..)");
            waitPresenceOfElementLocated(originLocator, driver);
            waitElementIsVisible(driver.findElement(originLocator), driver);
            driver.findElement(originLocator).click();
        }

    //Should select Trip Destiny
        public void saveDestinyCities() {
            int i = 1;
            Boolean flag_1 = true;
            while (flag_1) {
                By destinyNewRouteLocator = By.xpath("(//*[@class='station__name --with-new-route'])" + "[" + i + "]");
                String destinyNewRouteLocatorString = destinyNewRouteLocator.toString();
                String destinyReformatNewRoutesLocator = destinyNewRouteLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(destinyNewRouteLocator).size() != 0)) {
                    destinyCities.add(destinyReformatNewRoutesLocator);
                    i++;
                } else {
                    flag_1 = false;
                }
            }
            int j = 1;
            Boolean flag_2 = true;
            while (flag_2) {
                By destinyOtherRoutesLocator = By.xpath("(//span[@class='station__name'])" + "[" + j + "]");
                String destinyOtherRoutesLocatorString = destinyOtherRoutesLocator.toString();
                String destinyReformatNewRoutesLocator = destinyOtherRoutesLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(destinyOtherRoutesLocator).size() != 0)) {
                    destinyCities.add(destinyReformatNewRoutesLocator);
                    j++;
                } else {
                    flag_2 = false;
                }
            }
        }
        public void clickOnTripDestiny() {
            waitPresenceOfElementLocated(tripDestinyLocator, driver);
            waitElementIsVisible(driver.findElement(tripDestinyLocator), driver);
            driver.findElement(tripDestinyLocator).click();
        }
        public void clickTripPlaceDestiny() {
            //destinyLocator = By.xpath(setRandomLocator(destinyCities));
            destinyLocator = By.xpath("(//*[text()='Cartagena']/..)");
            waitPresenceOfElementLocated(destinyLocator, driver);
            waitElementIsVisible(driver.findElement(destinyLocator), driver);
            driver.findElement(destinyLocator).click();
        }

    //Selecting Random Trip Date
        /*public void selectInicialDate() {
            waitPresenceOfElementLocated(firstDateLocator, driver);
            waitElementIsVisible(driver.findElement(firstDateLocator), driver);
            driver.findElement(firstDateLocator).click();
        }*/

        /*public void selectFinalDate() {
            waitPresenceOfElementLocated(lastDateLocator, driver);
            waitElementIsVisible(driver.findElement(lastDateLocator), driver);
            driver.findElement(lastDateLocator).click();
        }*/

    //should select initial and final trip days
        public void saveFinalDates() {
            /*int k = 1;
            Boolean flag_3 = true;
            while (flag_3) {
                By firstDayLocator = By.xpath("//*[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--mon']/div[text()=" + k + "]");
                String firstDayLocatorString = firstDayLocator.toString();
                String firstReformatDayLocator = firstDayLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(firstDayLocator).size() != 0)) {
                    initialTripDays.add(firstReformatDayLocator);
                    k++;
                } else {
                    flag_3 = false;
                }
            }
            int m = 1;
            Boolean flag_4 = true;
            while (flag_4) {
                By lastDayLocator = By.xpath("//div[@class='calendar__date_picker__container--grid calendar__date_picker__container__day--first--thu']/div[text()=" + m + "]");
                String lastDayLocatorString = lastDayLocator.toString();
                String lastReformatDayLocator = lastDayLocatorString.replaceAll("By.xpath: ", "");
                if ((driver.findElements(lastDayLocator).size() != 0)) {
                    finalTripDays.add(lastReformatDayLocator);
                    m++;
                } else {
                    flag_4 = false;
                }
            }*/
        }
        public void clickTripInitialDate() {
            waitPresenceOfElementLocated(firstDateLocator, driver);
            waitElementIsVisible(driver.findElement(firstDateLocator), driver);
            driver.findElement(firstDateLocator).click();
        }
        public void clickTripFinalDate() {
            waitPresenceOfElementLocated(lastDateLocator, driver);
            waitElementIsVisible(driver.findElement(lastDateLocator), driver);
            driver.findElement(lastDateLocator).click();
        }

    //Should select how many passengers
        public void clickOnPassengers() {
            waitPresenceOfElementLocated(passengerLocator, driver);
            waitElementIsVisible(driver.findElement(passengerLocator), driver);
            driver.findElement(passengerLocator).click();
        }
        public void clickAdultBtn() {
            waitPresenceOfElementLocated(adultBtnLocator, driver);
            waitElementIsVisible(driver.findElement(adultBtnLocator), driver);
            driver.findElement(adultBtnLocator).click();
        }
        public void clickChildrenBtn() {
            waitPresenceOfElementLocated(childrenBtnLocator, driver);
            waitElementIsVisible(driver.findElement(childrenBtnLocator), driver);
            driver.findElement(childrenBtnLocator).click();
        }
        public void clickInfantBtn() {
            waitPresenceOfElementLocated(infantBtnLocator, driver);
            waitElementIsVisible(driver.findElement(infantBtnLocator), driver);
            driver.findElement(infantBtnLocator).click();
        }
        public void clickClosePassengerBox() {
            waitPresenceOfElementLocated(closePassengerBtnLocator, driver);
            waitElementIsVisible(driver.findElement(closePassengerBtnLocator), driver);
            driver.findElement(closePassengerBtnLocator).click();
        }

    //Should select search button
        public WebElement getSearchBtnLocator(){
            return driver.findElement(searchBtnLocator);
        }
        public BookingPage clickSearchBtn() {
            waitPresenceOfElementLocated(searchBtnLocator, driver);
            waitElementIsVisible(driver.findElement(searchBtnLocator), driver);
            driver.findElement(searchBtnLocator).click();
            return new BookingPage(driver);
        }
        public String setRandomLocator(ArrayList dataArray) {
            Random random = new Random();
            int randomGenerated = random.nextInt(dataArray.size());
            return dataArray.get(randomGenerated).toString();
        }

    //Methods to data verify in console
        public void printAllCities() {
            for (int i = 0; originCities.size() > i; i++) {
                System.out.println(originCities.get(i));
            }
            for (int j = 0; destinyCities.size() > j; j++) {
                System.out.println(destinyCities.get(j));
            }
            System.out.println("Origin Random City: " + setRandomLocator(originCities));
            System.out.println("Destiny Random City: " + setRandomLocator(destinyCities));
        }
        public void printAllDays() {
            for (int i = 0; initialTripDays.size() > i; i++) {
                System.out.println(initialTripDays.get(i));
            }
            for (int j = 0; finalTripDays.size() > j; j++) {
                System.out.println(finalTripDays.get(j));
            }
            System.out.println("Initial Random Day: " + setRandomLocator(initialTripDays));
            System.out.println("Final Random Day: " + setRandomLocator(finalTripDays));
        }
}