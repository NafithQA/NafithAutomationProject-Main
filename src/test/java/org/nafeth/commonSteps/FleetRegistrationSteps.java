package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FleetRegistrationSteps {

    WebDriver driver;

    public FleetRegistrationSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFleetRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnRegistrationSystemMenu();
        functions.scrollThePageDown();
        Thread.sleep(1000);
        homePage.clickOnRegistrationFleetMenu();
        functions.scrollThePageDown();
    }

    public void navigateToDriverOwnerRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnRegistrationSystemMenu();
        functions.scrollThePageDown();
        Thread.sleep(1000);
        homePage.clickOnDriverOwnerRegistrationMenu();
        homePage.clickOnDriversRegistrationPageButton();
        Thread.sleep(2000);
    }

    public void navigateToDriverOwnerRegistrationMenu_Investor() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnRegistrationSystemMenu();
        functions.scrollThePageDown();
        Thread.sleep(1000);
        homePage.clickOnDriverOwnerRegistrationMenu_Investor();
        homePage.clickOnDriversRegistrationPageButton();
        Thread.sleep(2000);
    }

    public void navigateToTrucksRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnRegistrationTruckMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnTrucksRegistrationPageButton();
        Thread.sleep(2000);
    }

    public void navigateToTrailersRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnTrailersRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnTrailersRegistrationPageButton();
        Thread.sleep(2000);
    }
    public void navigateToEquipmentsRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnEquipmentsRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnEquipmentsRegistrationPageButton();
        Thread.sleep(2000);
    }
    public void navigateToBusesRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnBusesRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnBusesRegistrationPageButton();
        Thread.sleep(2000);
    }
    public void navigateToCarsRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnCarsRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnCarsRegistrationPageButton();
        Thread.sleep(2000);
    }

    public void fillInLicenseInfo() throws InterruptedException {

        Functions functions = new Functions();
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        if (fleetRegistrationPage.getDocumentNationalityDropDownList().isDisplayed()) {
            functions.dropDownPickerByIndex(fleetRegistrationPage.getDocumentNationalityDropDownList(), 2);
        }
        fleetRegistrationPage.getLicenseIssuingDatePicker().sendKeys(functions.generateRandomDate("PAST"));
        fleetRegistrationPage.getLicenseExpiryDatePicker().sendKeys(functions.generateRandomDate("FUTURE"));
        Thread.sleep(1000);
    }
    public void fillInLicenseInfo_NafithRole() throws InterruptedException {

        Functions functions = new Functions();
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        if (fleetRegistrationPage.getDocumentNationalityDropDownList().isDisplayed()) {
            functions.dropDownPickerByIndex(fleetRegistrationPage.getDocumentNationalityDropDownList(), 1);
        }
        fleetRegistrationPage.getLicenseIssuingDatePicker().sendKeys(functions.generateRandomDate("PAST"));
        fleetRegistrationPage.getLicenseExpiryDatePicker().sendKeys(functions.generateRandomDate("FUTURE"));
        Thread.sleep(1000);
    }

    public void fillInTrucksRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderTypeDropDownList(), "10");
        Thread.sleep(10000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getStakeholderNameDropDownList(), 2);
        functions.scrollIntoElement(fleetRegistrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateCodeDropDownList(), 5);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleClassDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInTrailersRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderTypeDropDownList(), "10");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getStakeholderNameDropDownList(), 2);
        functions.scrollIntoElement(fleetRegistrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateCodeDropDownList(), 8);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        fleetRegistrationPage.getEmptyWeightField().sendKeys("5000");
        fleetRegistrationPage.getMaximumLoadField().sendKeys("15000");
        fleetRegistrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInEquipmentsRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderTypeDropDownList(), "11");
        Thread.sleep(7000);
        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderNameDropDownList(), "1243");
        functions.scrollIntoElement(fleetRegistrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateCodeDropDownList(), 5);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleClassTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        fleetRegistrationPage.getEmptyWeightField().sendKeys("5000");
        fleetRegistrationPage.getMaximumLoadField().sendKeys("15000");
        fleetRegistrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInBusesRegistrationInfo_NafithRole() throws InterruptedException, IOException {
        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderTypeDropDownList(), "7");
        functions.dropDownPickerByValue(fleetRegistrationPage.getIndustrialEstateDropDownList(), "4");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getStakeholderNameDropDownList(), 6);
        functions.scrollIntoElement(fleetRegistrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateCodeDropDownList(), 6);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        fleetRegistrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }
    public void fillInCarsRegistrationInfo_NafithRole() throws InterruptedException, IOException {
        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        functions.dropDownPickerByValue(fleetRegistrationPage.getStakeholderTypeDropDownList(), "7");
        functions.dropDownPickerByValue(fleetRegistrationPage.getIndustrialEstateDropDownList(), "4");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getStakeholderNameDropDownList(), 5);
        functions.scrollIntoElement(fleetRegistrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateCodeDropDownList(), 8);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        functions.scrollThePageUp();

    }

    public void fillInTrucksRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        Thread.sleep(2000);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleClassDropDownList(), 2);
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        Thread.sleep(1000);
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInTrailersRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        fleetRegistrationPage.getEmptyWeightField().sendKeys("5000");
        fleetRegistrationPage.getMaximumLoadField().sendKeys("15000");
        fleetRegistrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        Thread.sleep(1000);
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInEquipmentRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleClassTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        fleetRegistrationPage.getEmptyWeightField().sendKeys("5000");
        fleetRegistrationPage.getMaximumLoadField().sendKeys("15000");
        fleetRegistrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        Thread.sleep(1000);
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInBusesRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        fleetRegistrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }

    public void fillInCarsRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        fleetRegistrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleColorDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(fleetRegistrationPage.getVehicleTypeDropDownList(),  2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(fleetRegistrationPage.getChassesNumberField());
        fleetRegistrationPage.getChassesNumberField().sendKeys(chassesNumber);
        fleetRegistrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }

    public void fillInInsuranceInfo() {

        Functions functions = new Functions();
        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);

        fleetRegistrationPage.clickOnInsuranceCompanyInfoTab();
        String insurancePolicyNumber = String.valueOf(functions.generateRandomNumber(10));
        fleetRegistrationPage.getInsurancePolicyNumberField().sendKeys(insurancePolicyNumber);
    }

    public void uploadTrucksRegistrationAttachments() throws InterruptedException, IOException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        Functions functions = new Functions();

        fleetRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 6
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 7
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadTrailersRegistrationAttachments() throws InterruptedException, IOException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        Functions functions = new Functions();

        fleetRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadEquipmentsRegistrationAttachments() throws InterruptedException, IOException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        Functions functions = new Functions();

        fleetRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 6
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 7
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadBusesRegistrationAttachments() throws InterruptedException, IOException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        Functions functions = new Functions();

        fleetRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }
    public void uploadCarsRegistrationAttachments() throws InterruptedException, IOException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        Functions functions = new Functions();

        fleetRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        fleetRegistrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void proceedWithFinalRegistrationSteps() throws InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);

        functions.scrollThePageDown();
        functions.scrollIntoElementAndClickOnIt(commonLocators.getCreateButton());
        Thread.sleep(750);
        commonLocators.clickOnYesButton();
        Thread.sleep(60000);
    }
}
