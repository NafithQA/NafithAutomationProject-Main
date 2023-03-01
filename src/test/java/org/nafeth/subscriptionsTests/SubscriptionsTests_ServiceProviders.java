package org.nafeth.subscriptionsTests;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.*;
import org.nafeth.helpers.Queries.OtherQueries;
import org.nafeth.helpers.Queries.ServiceProvidersQueries;
import org.nafeth.pageModels.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SubscriptionsTests_ServiceProviders extends Configurations {

    // CREDIT CARD
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_1", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 1)
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
        Thread.sleep(3000);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_2", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_2(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_2);
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
        Thread.sleep(3000);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_3", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_3(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_3);
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
        Thread.sleep(3000);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_4", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_4(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_4);
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
        Thread.sleep(3000);
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
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_5", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_5(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        ArrayList<String> validRnnArray;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests_ServiceProviders subscriptionsTests = new SubscriptionsTests_ServiceProviders();
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_5);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_6", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_6(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        ArrayList<String> validRnnArray;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests_ServiceProviders subscriptionsTests = new SubscriptionsTests_ServiceProviders();
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_6);
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
        Thread.sleep(5000);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_7", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_7(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        ArrayList<String> validRnnArray;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests_ServiceProviders subscriptionsTests = new SubscriptionsTests_ServiceProviders();
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_7);
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

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_8", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 8)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_8(String languageChosen) throws IOException, InterruptedException {

        ArrayList<String> userAndPassAndFleetArray;
        ArrayList<String> validRnnArray;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests_ServiceProviders subscriptionsTests = new SubscriptionsTests_ServiceProviders();
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_8);
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


    // BALANCE
    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_9", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_9(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_9);
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

        // Steps to get remaining balance
        Thread.sleep(3000);
        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        Thread.sleep(3000);

        int remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);

        functions.refreshPage();
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

        Thread.sleep(3000);

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectBalanceoption();
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
        Thread.sleep(3000);
        subscriptionsPage.clickOnYesConfirmationButton();
        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());

        // Verify remaining balance
        creditPaymentPage.clickOnCancelAddMoreButton();
        functions.refreshPage();
        homePage.clickOnMainMenuButton();
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        int remainingBalanceAfterTransaction = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);
        System.out.println("Remaining Balance after Transaction is : " + remainingBalanceAfterTransaction);

        Assert.assertEquals(remainingBalance - totalPrice, remainingBalanceAfterTransaction);
    }

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_10", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_10(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_10);
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

        // Steps to get remaining balance
        Thread.sleep(3000);
        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        Thread.sleep(3000);

        int remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);

        functions.refreshPage();
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

        Thread.sleep(3000);

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectBalanceoption();
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
        Thread.sleep(3000);
        subscriptionsPage.clickOnYesConfirmationButton();
        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());

        // Verify remaining balance
        creditPaymentPage.clickOnCancelAddMoreButton();
        functions.refreshPage();
        homePage.clickOnMainMenuButton();
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        int remainingBalanceAfterTransaction = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);
        System.out.println("Remaining Balance after Transaction is : " + remainingBalanceAfterTransaction);

        Assert.assertEquals(remainingBalance - totalPrice, remainingBalanceAfterTransaction);
    }

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_11", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 11)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_11(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_11);
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

        // Steps to get remaining balance
        Thread.sleep(3000);
        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        Thread.sleep(3000);

        int remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);

        functions.refreshPage();
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

        Thread.sleep(3000);

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectBalanceoption();
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
        Thread.sleep(3000);
        subscriptionsPage.clickOnYesConfirmationButton();
        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());

        // Verify remaining balance
        creditPaymentPage.clickOnCancelAddMoreButton();
        functions.refreshPage();
        homePage.clickOnMainMenuButton();
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        int remainingBalanceAfterTransaction = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);
        System.out.println("Remaining Balance after Transaction is : " + remainingBalanceAfterTransaction);

        Assert.assertEquals(remainingBalance - totalPrice, remainingBalanceAfterTransaction);
    }

    @Parameters("language")
    @Test(description = "MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_12", enabled = true,  alwaysRun = true, retryAnalyzer = RetryAnalyzer.class, priority = 12)
    public void MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_12(String languageChosen) throws IOException, InterruptedException {

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
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(ServiceProvidersQueries.MAMS_SUBSCRIPTION_PACKAGES_SP0001_PAY_36_12);
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

        // Steps to get remaining balance
        Thread.sleep(3000);
        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        Thread.sleep(3000);

        int remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);

        functions.refreshPage();
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

        Thread.sleep(3000);

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subscriptionsPage.selectBalanceoption();
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
        Thread.sleep(3000);
        subscriptionsPage.clickOnYesConfirmationButton();
        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());

        // Verify remaining balance
        creditPaymentPage.clickOnCancelAddMoreButton();
        functions.refreshPage();
        homePage.clickOnMainMenuButton();
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        int remainingBalanceAfterTransaction = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);
        System.out.println("Remaining Balance after Transaction is : " + remainingBalanceAfterTransaction);

        Assert.assertEquals(remainingBalance - totalPrice, remainingBalanceAfterTransaction);
    }

    // This is a logger method to log subscriptions information's during run time
    public void logSubscriptionsInformations() {

        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);

        System.out.println("1st Access period : " + subscriptionsPage.getFirstSubscriptionAccessPeriod());
        System.out.println("1st Access price : " + subscriptionsPage.getFirstSubscriptionAccessPrice());
        System.out.println("1st Weigh In period : " + subscriptionsPage.getFirstSubscriptionWeighInPeriod());
        System.out.println("1st Weigh In price : " + subscriptionsPage.getFirstSubscriptionWeighInPrice());

        System.out.println("2nd Access period : " + subscriptionsPage.getSecondSubscriptionAccessPeriod());
        System.out.println("2nd Access price : " + subscriptionsPage.getSecondSubscriptionAccessPrice());
        System.out.println("2nd Weigh In period : " + subscriptionsPage.getSecondSubscriptionWeighInPeriod());
        System.out.println("2nd Weigh In price : " + subscriptionsPage.getSecondSubscriptionWeighInPrice());

        System.out.println("3rd Access period : " + subscriptionsPage.getThirdSubscriptionAccessPeriod());
        System.out.println("3rd Access price : " + subscriptionsPage.getThirdSubscriptionAccessPrice());
        System.out.println("3rd Weigh In period : " + subscriptionsPage.getThirdSubscriptionWeighInPeriod());
        System.out.println("3rd Weigh In price : " + subscriptionsPage.getThirdSubscriptionWeighInPrice());

        System.out.println("4th Access period : " + subscriptionsPage.getForthSubscriptionAccessPeriod());
        System.out.println("4th Access price : " + subscriptionsPage.getForthSubscriptionAccessPrice());
        System.out.println("4th Weigh In period : " + subscriptionsPage.getForthSubscriptionWeighInPeriod());
        System.out.println("4th Weigh In price : " + subscriptionsPage.getForthSubscriptionWeighInPrice());
    }
}
