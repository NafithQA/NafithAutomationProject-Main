package org.nafeth.commonSteps;

import org.nafeth.helpers.DatabaseHandler;
import org.nafeth.helpers.Functions;
import org.nafeth.helpers.Queries.OtherQueries;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.SubscriptionTypePage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SubscriptionTypeSteps {

    WebDriver driver;

    public SubscriptionTypeSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFleetSubscriptionMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnSubscriptionsSectionButton();
        functions.scrollThePageDown();
        homePage.clickOnFleetSubscriptionsButton();
        functions.scrollThePageDown();
        homePage.clickOnCreateFleetSubscriptionsButton();
        Thread.sleep(8000);
    }

    public void navigateToPermitPackages() throws InterruptedException {

        CommonLocators commonLocators = new CommonLocators(driver);

        commonLocators.clickOnOneTimePermitButton();
        commonLocators.clickOnOneTimePermitForHeavyTrucksButton();
        commonLocators.clickOnAccessServiceChooseButton();
        commonLocators.clickOnOneTimePermitAccess();
        Thread.sleep(1000);
    }

    public void navigateToHeavyTrucksPackages() throws InterruptedException {

        CommonLocators commonLocators = new CommonLocators(driver);

        commonLocators.clickOnOwnedFleetChooseButton();
        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();
        Thread.sleep(1000);
    }

    public void navigateToBusPackages() throws InterruptedException {

        CommonLocators commonLocators = new CommonLocators(driver);

        commonLocators.clickOnOwnedFleetChooseButton();
        commonLocators.clickOnBusPackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();
        Thread.sleep(1000);
    }

    public void createHeavyFleetSubscription() throws InterruptedException {

        Functions functions = new Functions();
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        functions.dropDownPickerByIndex(subscriptionTypePage.getIndustrialEstateDropDownList(), 1);
        subscriptionTypePage.clickOnPackageOneMonthButton();
        subscriptionTypePage.clickOnChooseAnyVehicle();
        subscriptionTypePage.clickOnSelectOneTruckToSubscribe();
        functions.scrollIntoElement(subscriptionTypePage.getNextButton());
        subscriptionTypePage.clickOnNextButton();
        Thread.sleep(750);
        functions.scrollThePageDown();
    }

    public void payByVISA() throws InterruptedException {
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        subscriptionTypePage.selectVISAOption();
        Thread.sleep(750);
    }

    public void payByPOS() throws InterruptedException {
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        DatabaseHandler databaseHandler = new DatabaseHandler();

        subscriptionTypePage.selectPOSOption();
        ArrayList<String> testData = (databaseHandler.getValidRnnFromDataBase(OtherQueries.dynamicRnnQuery("10")));
        String rnn = testData.get(0);
        subscriptionTypePage.getReceiptIdField().sendKeys(rnn);
        Thread.sleep(750);
    }

    public void payByBalance() throws InterruptedException {
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        subscriptionTypePage.selectBalanceOption();
        Thread.sleep(750);
    }

    public void createBusesFleetSubscription() throws InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        Functions functions = new Functions();

        functions.dropDownPickerByIndex(subscriptionTypePage.getIndustrialEstateDropDownList(), 1);
        subscriptionTypePage.clickOnPackageBusOneWeekButton();
        subscriptionTypePage.clickOnChooseAnyVehicle();
        subscriptionTypePage.clickOnSelectOneTruckToSubscribe();
        functions.scrollIntoElement(subscriptionTypePage.getNextButton());
        subscriptionTypePage.clickOnNextButton();
        Thread.sleep(750);
        functions.scrollThePageDown();
    }

    public void proceedWithFinalRegistrationSteps() throws InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);

        functions.scrollThePageDown();
        functions.scrollIntoElementAndClickOnIt(commonLocators.getPayButton());
        Thread.sleep(750);
        commonLocators.clickOnYesButton();

    }

    public void createOneTimePermitSubscription() throws InterruptedException {

        Functions functions = new Functions();
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);


        String ApprovalNumber = String.valueOf("FLEET_APPROVAL_NUMBER" + functions.getRandomInvestorName());
        //  subscriptionTypePage.fillArabicName(ApprovalNumber);
        functions.dropDownPickerByIndex(subscriptionTypePage.getIndustrialEstateDropDownList(), 1);
        subscriptionTypePage.clickOnPackageOneMonthButton();
        subscriptionTypePage.clickOnChooseAnyVehicle();
        subscriptionTypePage.clickOnSelectOneTruckToSubscribe();
        functions.scrollIntoElement(subscriptionTypePage.getNextButton());
        subscriptionTypePage.clickOnNextButton();
        Thread.sleep(750);
        functions.scrollThePageDown();
    }

    public void ApprovalNumber() throws InterruptedException {
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        DatabaseHandler databaseHandler = new DatabaseHandler();

        subscriptionTypePage.fillApprovalNumber();
        ArrayList<String> testData = (databaseHandler.getValidRnnFromDataBase(OtherQueries.dynamicRnnQuery("10")));
        String rnn = testData.get(0);
        subscriptionTypePage.getReceiptIdField().sendKeys(rnn);
        Thread.sleep(750);
    }
}
