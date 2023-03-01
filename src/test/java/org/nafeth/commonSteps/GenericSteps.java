package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.nafeth.base.Configurations.dataLoader;

public class GenericSteps {

    WebDriver driver;

    public GenericSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToMAMS(String userName, String password) throws IOException, InterruptedException {

        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);

        // Login to MAMS
        functions.navigateToQaURL();
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userName);
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(password);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
    }
}
