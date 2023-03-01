package org.nafeth;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.*;
import org.nafeth.helpers.Queries.DriversQueries;
import org.nafeth.helpers.Queries.OtherQueries;
import org.nafeth.helpers.Queries.ServiceProvidersQueries;
import org.nafeth.helpers.Queries.TruckingCompaniesQueries;
import org.nafeth.pageModels.*;
import org.nafeth.subscriptionsTests.SubscriptionsTests_Drivers;
import org.nafeth.subscriptionsTests.SubscriptionsTests_ServiceProviders;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class RerunSuite extends Configurations {

    // CREDIT CARD
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1", enabled = false,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1_FAILED(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(TruckingCompaniesQueries.MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1);
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userAndPassAndFleetArray.get(0));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(userAndPassAndFleetArray.get(1));

        Assert.assertTrue(!loginPage.getUserNameField().isDisplayed());
    }

    // CREDIT CARD
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1", enabled = false,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1_PASSED(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(TruckingCompaniesQueries.MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1);
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userAndPassAndFleetArray.get(0));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(userAndPassAndFleetArray.get(1));

        Assert.assertTrue(loginPage.getUserNameField().isDisplayed());
    }

    // CREDIT CARD
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_1", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_1(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests_ServiceProviders subscriptionsTests = new SubscriptionsTests_ServiceProviders();
        HomePage homePage = new HomePage(driver);
        DataLoader dataLoader = new DataLoader();

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_1);
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userAndPassAndFleetArray.get(0));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(userAndPassAndFleetArray.get(1));
        loginPage.clickOnLoginButton();

        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");

        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();

        commonLocators.clickOnFirstAvailablePackageChooseButtonSP();
        commonLocators.clickOnAccessServiceChooseButton();

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButtonSP();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        subscriptionsPage.clickOnSubscriptionsSectionButton();
        Thread.sleep(3000);

        subscriptionsPage.clickOnFirstPackageSubscribeButtonSP();
        Thread.sleep(3000);

        functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());

        subscriptionsPage.fillSearchVehiclesFieldWith(userAndPassAndFleetArray.get(2));
        subscriptionsPage.clickOnMoveSelectedFleetsButton();

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectCreditCardOption();
        commonLocators.checkAgreementCheckbox();
        subscriptionsPage.clickOnPayButton();
        subscriptionsPage.clickOnYesConfirmationButton();

        // Credit Card Payment
        creditPaymentPage.fillCreditCardNumberFieldWith(dataLoader.testData("CreditCardNumber"));
        creditPaymentPage.selectExpiryMonthDateAs(dataLoader.testData("ExpDateMonth"));
        creditPaymentPage.selectExpiryYearDateAs(dataLoader.testData("ExpDateYear"));
        creditPaymentPage.fillCardHolderNameFieldWith(dataLoader.testData("CardHoldersName"));
        creditPaymentPage.fillCvvNumberFieldWith(dataLoader.testData("CVV"));
        creditPaymentPage.clickOnPayButton();
        if (creditPaymentPage.getProceedAnyWayButton().isDisplayed()) {
            creditPaymentPage.clickOnProceedAnyWayButton();
        }

        // Assert that Success Message is showing
        Assert.assertTrue(subscriptionsPage.getSuccessfulMessageText().isDisplayed());
    }

    // POINT OF SALE
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_5", enabled = false,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_5(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        ArrayList<String> validRnnArray;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests_Drivers subscriptionsTests = new SubscriptionsTests_Drivers();
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(DriversQueries.MAMS_SUBSCRIPTION_PACKAGES_OO0001_PAY_35_5);
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userAndPassAndFleetArray.get(0));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(userAndPassAndFleetArray.get(1));
        loginPage.clickOnLoginButton();

        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");

        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();

        commonLocators.clickOnFirstAvailablePackageChooseButtonOO();
        commonLocators.clickOnAccessServiceChooseButton();

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButtonOO();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        subscriptionsPage.clickOnSubscriptionsSectionButton();
        Thread.sleep(3000);

        subscriptionsPage.clickOnFirstPackageSubscribeButtonOO();
        Thread.sleep(3000);

        functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());

        subscriptionsPage.fillSearchVehiclesFieldWith(userAndPassAndFleetArray.get(2));
        subscriptionsPage.clickOnMoveSelectedFleetsButton();

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectPOSoption();

        validRnnArray = databaseHandler.getValidRnnFromDataBase(OtherQueries.validRnnQuery);

        subscriptionsPage.fillReceiptNumberFieldWith(validRnnArray.get(0));
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();

        Thread.sleep(3000);
        subscriptionsPage.clickOnYesConfirmationButton();
        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());
    }

}
