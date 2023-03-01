package org.nafeth.subscriptionsTests;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.*;
import org.nafeth.helpers.Queries.TruckingCompaniesQueries;
import org.nafeth.pageModels.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionsTests extends Configurations {

    ArrayList<String> userAndPassAndFleetArray;

    @Parameters("language")
    @BeforeMethod(enabled = true)
    public void testsPrerequisites(String languageChosen) throws IOException {

        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        DatabaseHandler databaseHandler = new DatabaseHandler();

        functions.navigateToQaURL();

        // Login to Nafeth from DB
        userAndPassAndFleetArray = databaseHandler.getUserAndPassAndFleetFromDataBase(TruckingCompaniesQueries.MAMS_SUBSCRIPTION_PACKAGES_TC0001_PAY_10_1);
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(userAndPassAndFleetArray.get(0));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(userAndPassAndFleetArray.get(1));

        // Login to Nafeth from Excel
//        loginPage.fillUserAndPassFromExcel("yes","no","no","no","heavy");

        // Login to Nafeth from properties
//        loginPage.fillUserNameFieldFromProperties("qaUserName1");
//        loginPage.fillPasswordFieldFromProperties("qaPassword1");

        loginPage.clickOnLoginButton();

        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");

        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }
    }

    // Done
    @Test(description = "OAMS-5152, Create Subscription Flow using Credit Card And Verify Success Message", enabled = true,  alwaysRun = true, retryAnalyzer=RetryAnalyzer.class, priority = 1)
    public void verifyCreateSubscriptionFlow_CreditCard_SuccessMessage() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        subscriptionsPage.clickOnSubscriptionsSectionButton();
        Thread.sleep(3000);

        subscriptionsPage.clickOnFirstPackageSubscribeButton();
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

    // Done
    @Test(description = "OAMS-5152, Create Subscription Flow using Credit Card And Verify It Appears In Subscriptions Page", enabled = false,  alwaysRun = true, retryAnalyzer=RetryAnalyzer.class, priority = 2)
    public void verifyCreateSubscriptionFlow_CreditCard_SubscriptionsPage() throws IOException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();
        DatabaseHandler databaseHandler = new DatabaseHandler();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();
        subscriptionsPage.clickOnSubscriptionsSectionButton();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        subscriptionsPage.clickOnSubscriptionsSectionButton();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();
        functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());

        subscriptionsPage.fillSearchVehiclesFieldWith(userAndPassAndFleetArray.get(2));
        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        List<WebElement> selectedList = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-selected-list_fleetdropdown']/option"));
        System.out.println("Selected is : " + selectedList.get(0).getText());
        String[] selectedFleetArray = selectedList.get(0).getText().split(" ");
        String selectedFleet = selectedFleetArray[0];
        System.out.println("Selected Fleet is : " + selectedFleet);

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

        creditPaymentPage.clickOnCancelAddMoreButton();
        String[] firstWeighInServicePlateNumberArray = subscriptionsPage.getFirstWeighInServicePlateNumber().getText().split(" ");
        String firstWeighInServicePlateNumber = firstWeighInServicePlateNumberArray[0];
        System.out.println("First Weigh In Service Plate Number is : " + firstWeighInServicePlateNumber);

        // Assert that subscribed Fleet is added into Subscriptions Page
        Assert.assertTrue(selectedFleet.equals(firstWeighInServicePlateNumber));
    }


    // TBD
    @Test(description = "OAMS-5152, Create Subscription Flow using Credit Card And Verify It Appears In Account Statement Page", enabled = false,  alwaysRun = true, priority = 1)
    public void verifyCreateSubscriptionFlow_CreditCard_AccountStatementPage() throws IOException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();
        WebElement firstCardTitle;
        WebElement firstSubscriptionTitle;
        WebElement secondSubscriptionTitle;
        WebElement thirdSubscriptionTitle;
        WebElement forthSubscriptionTitle;

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();
        firstCardTitle = commonLocators.getFirstCardTitle();
        String cardInfo = functions.getElementText(firstCardTitle);
        String packageCodeString = functions.getFirstPartOfTextSplittedWithDash(cardInfo);

        Assert.assertEquals(packageCodeString, dataLoader.testData("packageCode"));

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        firstSubscriptionTitle = subscriptionsPage.getFirstSubscriptionTitle();
        String firstSubscriptionInfo = functions.getElementText(firstSubscriptionTitle);
        String firstSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(firstSubscriptionInfo);
        System.out.println("1st Subscription ID is : " + firstSubscriptionIdString);

        secondSubscriptionTitle = subscriptionsPage.getSecondSubscriptionTitle();
        String secondSubscriptionInfo = functions.getElementText(secondSubscriptionTitle);
        String secondSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(secondSubscriptionInfo);
        System.out.println("2nd Subscription ID is : " + secondSubscriptionIdString);

        thirdSubscriptionTitle = subscriptionsPage.getThirdSubscriptionTitle();
        String thirdSubscriptionInfo = functions.getElementText(thirdSubscriptionTitle);
        String thirdSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(thirdSubscriptionInfo);
        System.out.println("3rd Subscription ID is : " + thirdSubscriptionIdString);

        forthSubscriptionTitle = subscriptionsPage.getForthSubscriptionTitle();
        String forthSubscriptionInfo = functions.getElementText(forthSubscriptionTitle);
        String forthSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(forthSubscriptionInfo);
        System.out.println("4th Subscription ID is : " + forthSubscriptionIdString);

        Assert.assertEquals(firstSubscriptionIdString, dataLoader.testData("1stServiceCode"));
        Assert.assertEquals(secondSubscriptionIdString, dataLoader.testData("2ndServiceCode"));
        Assert.assertEquals(thirdSubscriptionIdString, dataLoader.testData("3rdServiceCode"));
        Assert.assertEquals(forthSubscriptionIdString, dataLoader.testData("4thServiceCode"));

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        if (!subscriptionsPage.getFleetDropDownList().isDisplayed()) {
            subscriptionsPage.clickOnSubscriptionsSectionButton();
            subscriptionsPage.clickOnFirstPackageSubscribeButton();
            functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());
        }

        // Select fleet from UI based on DataBase
      /*  String[] fleetNumberFromUI = null;
        String fleetNumberFromDataBase = userAndPassAndFleetArray.get(2);

        List<WebElement> listElement = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']/option"));
        for (int i = 0; i < listElement.size(); i++) {
            fleetNumberFromUI = listElement.get(i).getText().split(" ");
            System.out.println("Fleet " + i + " : " + fleetNumberFromUI[0]);

            if (fleetNumberFromUI[0].equalsIgnoreCase(fleetNumberFromDataBase)){
                System.out.println("Value " + fleetNumberFromUI[0] + " is found ... ");
                functions.dropDownPickerByValue(subscriptionsPage.getFleetDropDownList(), fleetNumberFromUI[0] + " " + fleetNumberFromUI[1] + " " + fleetNumberFromUI[2]);
                break;
            }
        }*/

        functions.dropDownPickerByIndex(subscriptionsPage.getFleetDropDownList(), 0);

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

//        Assert.assertEquals(totalPrice, "35");

        functions.scrollIntoElement(subscriptionsPage.getPayButton());
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
        creditPaymentPage.clickOnCancelAddMoreButton();
    }

    // TBD
    @Test(description = "OAMS-5152, Create Subscription Flow using POS And Verify POS Record Status Is Updated To Used", enabled = false,  alwaysRun = true, priority = 1)
    public void verifyCreateSubscriptionFlow_CreditCard_PosRecordStatus() throws IOException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();
        WebElement firstCardTitle;
        WebElement firstSubscriptionTitle;
        WebElement secondSubscriptionTitle;
        WebElement thirdSubscriptionTitle;
        WebElement forthSubscriptionTitle;

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();
        firstCardTitle = commonLocators.getFirstCardTitle();
        String cardInfo = functions.getElementText(firstCardTitle);
        String packageCodeString = functions.getFirstPartOfTextSplittedWithDash(cardInfo);

        Assert.assertEquals(packageCodeString, dataLoader.testData("packageCode"));

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        firstSubscriptionTitle = subscriptionsPage.getFirstSubscriptionTitle();
        String firstSubscriptionInfo = functions.getElementText(firstSubscriptionTitle);
        String firstSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(firstSubscriptionInfo);
        System.out.println("1st Subscription ID is : " + firstSubscriptionIdString);

        secondSubscriptionTitle = subscriptionsPage.getSecondSubscriptionTitle();
        String secondSubscriptionInfo = functions.getElementText(secondSubscriptionTitle);
        String secondSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(secondSubscriptionInfo);
        System.out.println("2nd Subscription ID is : " + secondSubscriptionIdString);

        thirdSubscriptionTitle = subscriptionsPage.getThirdSubscriptionTitle();
        String thirdSubscriptionInfo = functions.getElementText(thirdSubscriptionTitle);
        String thirdSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(thirdSubscriptionInfo);
        System.out.println("3rd Subscription ID is : " + thirdSubscriptionIdString);

        forthSubscriptionTitle = subscriptionsPage.getForthSubscriptionTitle();
        String forthSubscriptionInfo = functions.getElementText(forthSubscriptionTitle);
        String forthSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(forthSubscriptionInfo);
        System.out.println("4th Subscription ID is : " + forthSubscriptionIdString);

        Assert.assertEquals(firstSubscriptionIdString, dataLoader.testData("1stServiceCode"));
        Assert.assertEquals(secondSubscriptionIdString, dataLoader.testData("2ndServiceCode"));
        Assert.assertEquals(thirdSubscriptionIdString, dataLoader.testData("3rdServiceCode"));
        Assert.assertEquals(forthSubscriptionIdString, dataLoader.testData("4thServiceCode"));

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        if (!subscriptionsPage.getFleetDropDownList().isDisplayed()) {
            subscriptionsPage.clickOnSubscriptionsSectionButton();
            subscriptionsPage.clickOnFirstPackageSubscribeButton();
            functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());
        }

        // Select fleet from UI based on DataBase
      /*  String[] fleetNumberFromUI = null;
        String fleetNumberFromDataBase = userAndPassAndFleetArray.get(2);

        List<WebElement> listElement = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']/option"));
        for (int i = 0; i < listElement.size(); i++) {
            fleetNumberFromUI = listElement.get(i).getText().split(" ");
            System.out.println("Fleet " + i + " : " + fleetNumberFromUI[0]);

            if (fleetNumberFromUI[0].equalsIgnoreCase(fleetNumberFromDataBase)){
                System.out.println("Value " + fleetNumberFromUI[0] + " is found ... ");
                functions.dropDownPickerByValue(subscriptionsPage.getFleetDropDownList(), fleetNumberFromUI[0] + " " + fleetNumberFromUI[1] + " " + fleetNumberFromUI[2]);
                break;
            }
        }*/

        functions.dropDownPickerByIndex(subscriptionsPage.getFleetDropDownList(), 0);

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

//        Assert.assertEquals(totalPrice, "35");

        functions.scrollIntoElement(subscriptionsPage.getPayButton());
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
        creditPaymentPage.clickOnCancelAddMoreButton();
    }


    // Done
    @Test(description = "OAMS-5152, Create Subscription Flow using Credit Card ", enabled = true,  alwaysRun = true, priority = 1)
    public void verifyPackageServiceCodeAndPricesInSubscriptionCreditCardFlow() throws IOException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();
        WebElement firstCardTitle;
        WebElement firstSubscriptionTitle;
        WebElement secondSubscriptionTitle;
        WebElement thirdSubscriptionTitle;
        WebElement forthSubscriptionTitle;

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();
        firstCardTitle = commonLocators.getFirstCardTitle();
        String cardInfo = functions.getElementText(firstCardTitle);
        String packageCodeString = functions.getFirstPartOfTextSplittedWithDash(cardInfo);

        Assert.assertEquals(packageCodeString, dataLoader.testData("packageCode"));

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        firstSubscriptionTitle = subscriptionsPage.getFirstSubscriptionTitle();
        String firstSubscriptionInfo = functions.getElementText(firstSubscriptionTitle);
        String firstSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(firstSubscriptionInfo);
        System.out.println("1st Subscription ID is : " + firstSubscriptionIdString);

        secondSubscriptionTitle = subscriptionsPage.getSecondSubscriptionTitle();
        String secondSubscriptionInfo = functions.getElementText(secondSubscriptionTitle);
        String secondSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(secondSubscriptionInfo);
        System.out.println("2nd Subscription ID is : " + secondSubscriptionIdString);

        thirdSubscriptionTitle = subscriptionsPage.getThirdSubscriptionTitle();
        String thirdSubscriptionInfo = functions.getElementText(thirdSubscriptionTitle);
        String thirdSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(thirdSubscriptionInfo);
        System.out.println("3rd Subscription ID is : " + thirdSubscriptionIdString);

        forthSubscriptionTitle = subscriptionsPage.getForthSubscriptionTitle();
        String forthSubscriptionInfo = functions.getElementText(forthSubscriptionTitle);
        String forthSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(forthSubscriptionInfo);
        System.out.println("4th Subscription ID is : " + forthSubscriptionIdString);

        Assert.assertEquals(firstSubscriptionIdString, dataLoader.testData("1stServiceCode"));
        Assert.assertEquals(secondSubscriptionIdString, dataLoader.testData("2ndServiceCode"));
        Assert.assertEquals(thirdSubscriptionIdString, dataLoader.testData("3rdServiceCode"));
        Assert.assertEquals(forthSubscriptionIdString, dataLoader.testData("4thServiceCode"));

        subscriptionsTests.logSubscriptionsInformations();
        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        // Below function is to make sure fleet Drop-Down list is showing having elements
        if (!subscriptionsPage.getFleetDropDownList().isDisplayed()) {
            subscriptionsPage.clickOnSubscriptionsSectionButton();
            subscriptionsPage.clickOnFirstPackageSubscribeButton();
            functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());
        }

        // Select fleet from UI based on DataBase
      /*  String[] fleetNumberFromUI = null;
        String fleetNumberFromDataBase = userAndPassAndFleetArray.get(2);

        List<WebElement> listElement = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']/option"));
        for (int i = 0; i < listElement.size(); i++) {
            fleetNumberFromUI = listElement.get(i).getText().split(" ");
            System.out.println("Fleet " + i + " : " + fleetNumberFromUI[0]);

            if (fleetNumberFromUI[0].equalsIgnoreCase(fleetNumberFromDataBase)){
                System.out.println("Value " + fleetNumberFromUI[0] + " is found ... ");
                functions.dropDownPickerByValue(subscriptionsPage.getFleetDropDownList(), fleetNumberFromUI[0] + " " + fleetNumberFromUI[1] + " " + fleetNumberFromUI[2]);
                break;
            }
        }*/

        functions.dropDownPickerByIndex(subscriptionsPage.getFleetDropDownList(), 0);

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

//        Assert.assertEquals(totalPrice, "35");

        functions.scrollIntoElement(subscriptionsPage.getPayButton());
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
        creditPaymentPage.clickOnCancelAddMoreButton();
    }

    // Done
    @Test(description = "OAMS-5152, using POS payment method", enabled = false,  alwaysRun = true, priority = 3)
    public void verifyPackageServiceCodeAndPricesInSubscriptionPOSflow() throws IOException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();
        ExcelHandler excelHandler = new ExcelHandler();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();
        WebElement firstCardTitle;
        WebElement firstSubscriptionTitle;
        WebElement secondSubscriptionTitle;
        WebElement thirdSubscriptionTitle;
        WebElement forthSubscriptionTitle;

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();
        firstCardTitle = commonLocators.getFirstCardTitle();
        String cardInfo = functions.getElementText(firstCardTitle);
        String packageCodeString = functions.getFirstPartOfTextSplittedWithDash(cardInfo);

        Assert.assertEquals(packageCodeString, dataLoader.testData("packageCode"));

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        firstSubscriptionTitle = subscriptionsPage.getFirstSubscriptionTitle();
        String firstSubscriptionInfo = functions.getElementText(firstSubscriptionTitle);
        String firstSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(firstSubscriptionInfo);
        System.out.println("1st Subscription ID is : " + firstSubscriptionIdString);

        secondSubscriptionTitle = subscriptionsPage.getSecondSubscriptionTitle();
        String secondSubscriptionInfo = functions.getElementText(secondSubscriptionTitle);
        String secondSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(secondSubscriptionInfo);
        System.out.println("2nd Subscription ID is : " + secondSubscriptionIdString);

        thirdSubscriptionTitle = subscriptionsPage.getThirdSubscriptionTitle();
        String thirdSubscriptionInfo = functions.getElementText(thirdSubscriptionTitle);
        String thirdSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(thirdSubscriptionInfo);
        System.out.println("3rd Subscription ID is : " + thirdSubscriptionIdString);

        forthSubscriptionTitle = subscriptionsPage.getForthSubscriptionTitle();
        String forthSubscriptionInfo = functions.getElementText(forthSubscriptionTitle);
        String forthSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(forthSubscriptionInfo);
        System.out.println("4th Subscription ID is : " + forthSubscriptionIdString);

        Assert.assertEquals(firstSubscriptionIdString, dataLoader.testData("1stServiceCode"));
        Assert.assertEquals(secondSubscriptionIdString, dataLoader.testData("2ndServiceCode"));
        Assert.assertEquals(thirdSubscriptionIdString, dataLoader.testData("3rdServiceCode"));
        Assert.assertEquals(forthSubscriptionIdString, dataLoader.testData("4thServiceCode"));

        subscriptionsTests.logSubscriptionsInformations();

        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        if (!subscriptionsPage.getFleetDropDownList().isDisplayed()) {
            subscriptionsPage.clickOnSubscriptionsSectionButton();
            subscriptionsPage.clickOnFirstPackageSubscribeButton();
            functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());
        }
        functions.dropDownPickerByIndex(subscriptionsPage.getFleetDropDownList(), 0);

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        Assert.assertEquals(totalPrice, subscriptionsPage.getTotalPriceValue());

        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.selectPOSoption();
        String validRNN = excelHandler.getValidRNN();
        subscriptionsPage.fillReceiptNumberFieldWith(validRNN);
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
//        subscriptionsPage.clickOnYesConfirmationButton();
//        Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());
    }

    // Done
    @Test(description = "OAMS-5152, using Balance payment method", enabled = false,  alwaysRun = true, priority = 2)
    public void verifyPackageServiceCodeAndPricesInSubscriptionBalanceFlow() throws
            IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        SubscriptionsTests subscriptionsTests = new SubscriptionsTests();

        Functions functions = new Functions();
        DataLoader dataLoader = new DataLoader();
        WebElement firstCardTitle;
        WebElement firstSubscriptionTitle;
        WebElement secondSubscriptionTitle;
        WebElement thirdSubscriptionTitle;
        WebElement forthSubscriptionTitle;

        // Steps to get remaining balance
        Thread.sleep(5000);
        homePage.clickOnMainMenuButton();
        Thread.sleep(5000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnAccountStatementButton();
        homePage.clickOnAccountStatementPageButton();
        homePage.waitForGridPager();
        int remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
        System.out.println("Remaining Balance is : " + remainingBalance);

        functions.refreshPage();
        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();
        commonLocators.clickOnOwnedFleetChooseButton();
        firstCardTitle = commonLocators.getFirstCardTitle();
        String cardInfo = functions.getElementText(firstCardTitle);
        String packageCodeString = functions.getFirstPartOfTextSplittedWithDash(cardInfo);

        Assert.assertEquals(packageCodeString, dataLoader.testData("packageCode"));

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();

        firstSubscriptionTitle = subscriptionsPage.getFirstSubscriptionTitle();
        String firstSubscriptionInfo = functions.getElementText(firstSubscriptionTitle);
        String firstSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(firstSubscriptionInfo);
        System.out.println("1st Subscription ID is : " + firstSubscriptionIdString);

        secondSubscriptionTitle = subscriptionsPage.getSecondSubscriptionTitle();
        String secondSubscriptionInfo = functions.getElementText(secondSubscriptionTitle);
        String secondSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(secondSubscriptionInfo);
        System.out.println("2nd Subscription ID is : " + secondSubscriptionIdString);

        thirdSubscriptionTitle = subscriptionsPage.getThirdSubscriptionTitle();
        String thirdSubscriptionInfo = functions.getElementText(thirdSubscriptionTitle);
        String thirdSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(thirdSubscriptionInfo);
        System.out.println("3rd Subscription ID is : " + thirdSubscriptionIdString);

        forthSubscriptionTitle = subscriptionsPage.getForthSubscriptionTitle();
        String forthSubscriptionInfo = functions.getElementText(forthSubscriptionTitle);
        String forthSubscriptionIdString = functions.getFirstPartOfTextSplittedWithDash(forthSubscriptionInfo);
        System.out.println("4th Subscription ID is : " + forthSubscriptionIdString);

        Assert.assertEquals(firstSubscriptionIdString, dataLoader.testData("1stServiceCode"));
        Assert.assertEquals(secondSubscriptionIdString, dataLoader.testData("2ndServiceCode"));
        Assert.assertEquals(thirdSubscriptionIdString, dataLoader.testData("3rdServiceCode"));
        Assert.assertEquals(forthSubscriptionIdString, dataLoader.testData("4thServiceCode"));

        subscriptionsTests.logSubscriptionsInformations();

        subscriptionsPage.clickOnFirstPackageSubscribeButton();

        if (!subscriptionsPage.getFleetDropDownList().isDisplayed()) {
            subscriptionsPage.clickOnSubscriptionsSectionButton();
            subscriptionsPage.clickOnFirstPackageSubscribeButton();
            functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());
        }
        functions.dropDownPickerByIndex(subscriptionsPage.getFleetDropDownList(), 0);

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();

        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        Assert.assertEquals(totalPrice, subscriptionsPage.getTotalPriceValue());

        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.selectBalanceoption();
        commonLocators.checkAgreementCheckbox();
        functions.scrollIntoElement(subscriptionsPage.getPayButton());
        subscriptionsPage.clickOnPayButton();
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

    @Test(enabled = false)
    public void randomTest1() {

        HomePage homePage = new HomePage(driver);

        homePage.clickOnMainMenuButton();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
