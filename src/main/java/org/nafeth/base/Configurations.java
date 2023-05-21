package org.nafeth.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.lang.reflect.Method;

public class Configurations {

    public static DataLoader dataLoader = new DataLoader();
    public static WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod()
    public void testSetup(String browserName, Method method) throws IOException, InterruptedException {

        // Browser Setup
        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {

            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Headless")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
//        LoginPage loginPage = new LoginPage(driver);
//        Functions functions = new Functions();
//
//        // Login to MAMS
//        functions.navigateToQaURL();
//        functions.waitForElementToBeClickable(loginPage.getUserNameField());
//        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("systemUser"));
//        functions.waitForElementToBeClickable(loginPage.getPasswordField());
//        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("systemPass"));
//        loginPage.clickOnLoginButton();
//        Thread.sleep(3000);
            // Recorder Start Setup
//        try {
//            Recorder.startRecord(method);
//        } catch (ATUTestRecorderException e) {
//            e.printStackTrace();
//        }
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown() {

        // Driver Close
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }

        // Recorder Stop Setup
//        try {
//            Recorder.stopRecord();
//        } catch (ATUTestRecorderException e) {
//            e.printStackTrace();
//        }
    }
//    @AfterSuite(alwaysRun = true)
//    public void suiteTearDown() {
//
//        // Driver Quit
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
