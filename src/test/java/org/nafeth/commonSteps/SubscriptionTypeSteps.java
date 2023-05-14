package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.*;
import org.nafeth.helpers.Queries.OtherQueries;
import org.nafeth.helpers.DatabaseHandler;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class SubscriptionTypeSteps {


    WebDriver driver;


    String idDocumentNumber;

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
        Thread.sleep(750);
        String rnn = testData.get(0);
        subscriptionTypePage.getReceiptIdField().sendKeys(rnn);
        Thread.sleep(750);
    }
    public void payByPOSOneTimePermit() throws InterruptedException {
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();

        subscriptionTypePage.selectPOSOption();
        ArrayList<String> testData = (databaseHandler.getValidRnnFromDataBase(OtherQueries.dynamicRnnQuery("4")));
        Thread.sleep(750);
        String rnn = testData.get(0);
        subscriptionTypePage.getReceiptIdField().sendKeys(rnn);
        Thread.sleep(750);
        functions.scrollThePageDown();
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
        DatabaseHandler databaseHandler = new DatabaseHandler();

        ArrayList<String> approvalNumberList = databaseHandler.getValidApprovalNumber(OtherQueries.dynamicApprovalNumberQuery);
        String approvalNumber = approvalNumberList.get(0);
        subscriptionTypePage.fillApprovalNumbersField().sendKeys(approvalNumber);
        ArrayList<String> truckPlateNumberList = databaseHandler.getOwnedFleetData(OtherQueries.dynamicOwnedFleetQuery);
        String truckPlateNumber = truckPlateNumberList.get(0);
        subscriptionTypePage.fillTruckPlateNumber().sendKeys(truckPlateNumber);
        ArrayList<String> truckPlateCodeList = databaseHandler.getOwnedFleetData(OtherQueries.dynamicOwnedFleetQuery);
        String truckPlateCode = truckPlateCodeList.get(1);
        functions.dropDownPickerByValue(subscriptionTypePage.getTruckPlateCodeDropDownList(), truckPlateCode);
        ArrayList<String> trailerPlateNumberList = databaseHandler.getOwnedFleetData(OtherQueries.dynamicOwnedFleetQuery);
        String trailerPlateNumber = trailerPlateNumberList.get(0);
        subscriptionTypePage.fillTrailerPlateNumber().sendKeys(trailerPlateNumber);
        ArrayList<String> trailerPlateCodeList = databaseHandler.getOwnedFleetData(OtherQueries.dynamicOwnedFleetQuery);
        String trailerPlateCode = trailerPlateCodeList.get(1);
        functions.dropDownPickerByValue(subscriptionTypePage.getTrailerPlateCodeDropDownList(), trailerPlateCode);
        Thread.sleep(2000);
        functions.dropDownPickerByIndex(subscriptionTypePage.getTrailerTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(subscriptionTypePage.getCargoTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(subscriptionTypePage.getOperationTypeDropDownList(), 2);

    }


    public void FillDriverPermitSubscription() throws IOException, InterruptedException {

        Functions functions = new Functions();
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        subscriptionTypePage.clickOnDriverTabInfoTab();
        functions.dropDownPickerByIndex(subscriptionTypePage.getDocumentNationalityDropDownList(), 2);
        functions.dropDownPickerByIndex(subscriptionTypePage.getDocumentTypeDropDownList(), 2);
        idDocumentNumber = String.valueOf(functions.generateRandomNumber(15));
        subscriptionTypePage.getIdDocumentNumberField().sendKeys(idDocumentNumber);
        String DriverName = String.valueOf("Driver Automation test " + functions.getRandomName());
        subscriptionTypePage.fillDriverName(DriverName);
        functions.dropDownPickerByIndex(subscriptionTypePage.getDriverNationalityDropDownList(), 2);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        subscriptionTypePage.getMobileNumberField().sendKeys(mobileNumber);
        Thread.sleep(3000);
    }
   public void uploadPermitAttachments() throws InterruptedException, IOException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        Functions functions = new Functions();

        subscriptionTypePage.clickOnAttachmentsTabButton();
        // Attachment 1
       subscriptionTypePage.clickOnAuthorizationAttachmentButton1();

        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
       subscriptionTypePage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
       subscriptionTypePage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
       subscriptionTypePage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        functions.scrollThePageDown();
        subscriptionTypePage.clickOnOneTripAddTruckButton();
       Thread.sleep(750);
        subscriptionTypePage.clickOnNextButton();
       Thread.sleep(750);
       functions.scrollThePageDown();
    }
}
