package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.LoginPage;
import org.openqa.selenium.WebDriver;


import java.io.IOException;


public class GenericSteps {

    WebDriver driver;

    public GenericSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToMAMS(String userName, String password) throws IOException, InterruptedException {

        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login to MAMS
        functions.navigateToQaURL();
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userName);
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(password);
        loginPage.clickOnLoginButton();

        Thread.sleep(5000);
        genericSteps.changeLanguage("english");
        Thread.sleep(3000);
    }

    public void changeLanguage(String languageChosen) {
        HomePage homePage = new HomePage(driver);
        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");
        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }
    }
}
