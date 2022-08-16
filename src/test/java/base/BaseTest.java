package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;


public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    private int option;

    @BeforeClass //WebDriver SetUp
    public void setUp() {

        //Request the browser where the test will run
        option = 1;
        //Choose the option
        try {
            switch (option){
                case 1:
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                    driver = new ChromeDriver(getChromeOptions());
                    goHome();
                    break;
                case 2:
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe" );
                    driver = new FirefoxDriver(getFirefoxOptions());
                    break;
                case 3:
                    System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                    driver = new EdgeDriver(getEdgeOptions());
                    goHome();
                    break;
            }
        } catch (InputMismatchException ie){
            System.out.println("Invalid option, try again.");
        }
    }

    @BeforeMethod //Initiating the homepage
    public void goHome(){
        driver.get("https://www.vivaair.com/co/es/");
        homePage = new HomePage(driver);
    }
    @AfterMethod //Taking a screenshot
    public void takeScreenshot(ITestResult result){
        //Cast
        var camera = (TakesScreenshot)driver;
        //Screenshots con JavaIO
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try { //Capturamos la excepcion
            Files.move(screenshot, new File("resources/screenshots/passes/"+result.getName()+"Passed.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod //Failure tests report
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/failures/"+result.getName()+"Failed.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass //Close the browser
    public void tearDown(){
       // driver.quit();
    }

    //Chrome Browser Properties
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false); //Show the browser? -> true[NO]/false[YES]
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        return options;
    }
    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false); //Show the browser? -> true[NO]/false[YES]
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        return options;
    }
    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(false); //Show the browser? -> true[NO]/false[YES]
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        return options;
    }

}
