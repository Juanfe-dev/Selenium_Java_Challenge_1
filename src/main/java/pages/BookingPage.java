package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Waiters;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class BookingPage extends Waiters {

    private ArrayList bornMonthDays = new ArrayList();
    private WebDriver driver;
    private By loaderLocator = By.xpath("//*[@class='loader']");
    private By bookingPageTextLocator = By.xpath("//p[contains(.,\"Recuerda, nuestros mejores\")]");
    private By lowerToHigherPriceFilterLocator = By.xpath("//button[@class='content-style btn btn-primary btn-lg'][text()='Menor a mayor']");
    private By lowerOptionLocator = By.xpath("(//*[@class='lowest-fare__price'])[1]");
    private By buyComboContinueBtnLocator = By.xpath("//*[@class='booking__action-btn__text'][text()='Continuar']");
    private By adultNameInputLocator = By.xpath("//*[@id='nombre1ADT']");
    private By adultLastNameInputLocator = By.xpath("//*[@id='apellido1ADT']");
    private By adultIdInputLocator = By.xpath("//*[@id='identificacion1ADT']");
    private By adultEmailInputLocator = By.xpath("//input[@id='correo-electronico1ADT']");
    private By adultContactNumberInputLocator = By.xpath("//input[@id='telefono']");
    private By adultCountryExpeditionInputLocator = By.xpath("(//input[@name='paisExpedicionPass'])[1]");


    private By childrenNameInputLocator = By.xpath("//input[@id='nombre1CHD']");
    private By childrenLastNameInputLocator = By.xpath("//input[@id='apellido1CHD']");
    private By childrenIdInputLocator = By.xpath("//input[@id='identificacion1CHD']");
    private By childrenCountryExpeditionInputLocator = By.xpath("(//input[@name='paisExpedicionPass'])[2]");

    private By infantnNameInputLocator = By.xpath("//input[@id='nombre_infant0']");
    private By infantLastNameInputLocator = By.xpath("//input[@id='apellido_infant0']");
    private By infantBornDateInputLocator = By.xpath("//input[@id='fechaNacimiento0inf']");
    private By infantBornDateOptionLocator;

    private By generalCountryExpeditionOptionLocator = By.xpath("//ul/li[text()='Colombia']");

    public BookingPage(WebDriver driver){
        this.driver = driver;
    }
    Faker faker = new Faker();

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

    public void completeAdultForm(){
        waitPresenceOfElementLocated(adultNameInputLocator, driver);
        waitElementIsVisible(driver.findElement(adultNameInputLocator), driver);
        driver.findElement(adultNameInputLocator).sendKeys(firstName());

        driver.findElement(adultLastNameInputLocator).sendKeys(lastName());

        driver.findElement(adultIdInputLocator).sendKeys(idNumber());

        driver.findElement(adultEmailInputLocator).sendKeys(emailAddress());

        driver.findElement(adultContactNumberInputLocator).sendKeys(contactNumber());

        clickAdultCountryInput();

        clickGeneralCountryOption();
    }
    public void completeChildrenForm(){
        waitPresenceOfElementLocated(childrenNameInputLocator, driver);
        waitElementIsVisible(driver.findElement(childrenNameInputLocator), driver);
        driver.findElement(childrenNameInputLocator).sendKeys(firstName());

        driver.findElement(childrenLastNameInputLocator).sendKeys(lastName());

        driver.findElement(childrenIdInputLocator).sendKeys(idNumber());

        clickChildrenCountryInput();

        clickGeneralCountryOption();
    }
    public void completeInfantForm(){
        waitPresenceOfElementLocated(infantnNameInputLocator, driver);
        waitElementIsVisible(driver.findElement(infantnNameInputLocator), driver);
        driver.findElement(infantnNameInputLocator).sendKeys(firstName());

        driver.findElement(infantLastNameInputLocator).sendKeys(lastName());

        driver.findElement(infantBornDateInputLocator).sendKeys("2022-07-28");

        //saveBornDays();
        //printAllDays();
        //clickRandomBornDay();
    }
    public String firstName() {
        return faker.name().firstName();
    }
    public String lastName() {
        return faker.name().lastName();
    }
   public String idNumber(){
        return faker.numerify("1#########");
   }

   public String emailAddress(){
        return faker.internet().emailAddress();
   }

   public String contactNumber(){
        return faker.numerify("3#########");
   }



   public void clickAdultCountryInput(){
       waitPresenceOfElementLocated(adultCountryExpeditionInputLocator, driver);
       waitElementIsVisible(driver.findElement(adultCountryExpeditionInputLocator), driver);
        driver.findElement(adultCountryExpeditionInputLocator).click();
   }
   public void clickChildrenCountryInput(){
       waitPresenceOfElementLocated(childrenCountryExpeditionInputLocator, driver);
       waitElementIsVisible(driver.findElement(childrenCountryExpeditionInputLocator), driver);
        driver.findElement(childrenCountryExpeditionInputLocator).click();
   }
   public void clickGeneralCountryOption(){
       waitPresenceOfElementLocated(generalCountryExpeditionOptionLocator, driver);
       waitElementIsVisible(driver.findElement(generalCountryExpeditionOptionLocator), driver);
        driver.findElement(generalCountryExpeditionOptionLocator).click();
   }



   public void saveBornDays(){
       int n = 1;
       Boolean flag_5 = true;
       while (flag_5) {
           By infantBornDateOptionLocator = By.xpath("(//td[@class='form-date-picker__day'])["+n+"]/div");
           String bornDateLocatorString = infantBornDateOptionLocator.toString();
           String bornDateReformatDayLocator = bornDateLocatorString.replaceAll("By.xpath: ", "");
           if ((driver.findElements(infantBornDateOptionLocator).size() != 0)) {
               bornMonthDays.add(infantBornDateOptionLocator);
               n++;
           } else {
               flag_5 = false;
           }
       }
   }
   public String getRandomOnArray(ArrayList dataArray){
       Random random = new Random();
       int randomGenerated = random.nextInt(dataArray.size());
       return dataArray.get(randomGenerated).toString();
   }

   public void clickRandomBornDay(){
       infantBornDateOptionLocator = By.xpath(getRandomOnArray(bornMonthDays));
       waitPresenceOfElementLocated(infantBornDateOptionLocator, driver);
       waitElementIsVisible(driver.findElement(infantBornDateOptionLocator), driver);
       driver.findElement(infantBornDateOptionLocator).click();
       //WebElement figure = driver.findElement(infantBornDateOptionLocator);
       //Actions actions = new Actions(driver);
       //actions.moveToElement(figure).perform();
       //actions.scrollToElement(figure);
       //actions.click(figure).perform();

   }

    public void printAllDays() {
        for (int i = 0; bornMonthDays.size() > i; i++) {
            System.out.println(bornMonthDays.get(i));
        }
        System.out.println("Random born date: " + getRandomOnArray(bornMonthDays));

    }



}

