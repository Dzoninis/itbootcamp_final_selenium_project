package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public abstract class Basic_Test {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected Nav_Page nav_page;
    protected Login_Page loginPage;
    protected Message_Pop_Up_Page message_pop_up_page;
    protected Signup_Page signup_page;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        nav_page = new Nav_Page(driver, wait);
        loginPage = new Login_Page(driver, wait);
        message_pop_up_page = new Message_Pop_Up_Page(driver, wait);
        signup_page = new Signup_Page(driver, wait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);

    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshotWithDateTimeFormat(driver, testResult.getName());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

}