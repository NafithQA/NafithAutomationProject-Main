package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.RegistrationPage;
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
        RegistrationPage registrationPage = new RegistrationPage(driver);

        if (registrationPage.getDocumentNationalityDropDownList().isDisplayed()) {
            functions.dropDownPickerByIndex(registrationPage.getDocumentNationalityDropDownList(), 2);
        }
        registrationPage.getLicenseIssuingDatePicker().sendKeys(functions.generateRandomDate("PAST"));
        registrationPage.getLicenseExpiryDatePicker().sendKeys(functions.generateRandomDate("FUTURE"));
        Thread.sleep(1000);
    }
    public void fillInLicenseInfo_NafithRole() throws InterruptedException {

        Functions functions = new Functions();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        if (registrationPage.getDocumentNationalityDropDownList().isDisplayed()) {
            functions.dropDownPickerByIndex(registrationPage.getDocumentNationalityDropDownList(), 1);
        }
        registrationPage.getLicenseIssuingDatePicker().sendKeys(functions.generateRandomDate("PAST"));
        registrationPage.getLicenseExpiryDatePicker().sendKeys(functions.generateRandomDate("FUTURE"));
        Thread.sleep(1000);
    }

    public void fillInTrucksRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        functions.dropDownPickerByValue(registrationPage.getStakeholderTypeDropDownList(), "10");
        Thread.sleep(10000);
        functions.dropDownPickerByIndex(registrationPage.getStakeholderNameDropDownList(), 2);
        functions.scrollIntoElement(registrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getPlateCodeDropDownList(), 5);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getVehicleClassDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInTrailersRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        functions.dropDownPickerByValue(registrationPage.getStakeholderTypeDropDownList(), "10");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(registrationPage.getStakeholderNameDropDownList(), 2);
        functions.scrollIntoElement(registrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getPlateCodeDropDownList(), 8);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        registrationPage.getEmptyWeightField().sendKeys("5000");
        registrationPage.getMaximumLoadField().sendKeys("15000");
        registrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInEquipmentsRegistrationInfo_NafithRole() throws InterruptedException, IOException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        functions.dropDownPickerByValue(registrationPage.getStakeholderTypeDropDownList(), "11");
        Thread.sleep(7000);
        functions.dropDownPickerByValue(registrationPage.getStakeholderNameDropDownList(), "1243");
        functions.scrollIntoElement(registrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getPlateCodeDropDownList(), 5);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getVehicleClassTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        registrationPage.getEmptyWeightField().sendKeys("5000");
        registrationPage.getMaximumLoadField().sendKeys("15000");
        registrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInBusesRegistrationInfo_NafithRole() throws InterruptedException, IOException {
        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        functions.dropDownPickerByValue(registrationPage.getStakeholderTypeDropDownList(), "7");
        functions.dropDownPickerByValue(registrationPage.getIndustrialEstateDropDownList(), "4");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(registrationPage.getStakeholderNameDropDownList(), 6);
        functions.scrollIntoElement(registrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getPlateCodeDropDownList(), 6);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        registrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }
    public void fillInCarsRegistrationInfo_NafithRole() throws InterruptedException, IOException {
        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        functions.dropDownPickerByValue(registrationPage.getStakeholderTypeDropDownList(), "7");
        functions.dropDownPickerByValue(registrationPage.getIndustrialEstateDropDownList(), "4");
        Thread.sleep(7000);
        functions.dropDownPickerByIndex(registrationPage.getStakeholderNameDropDownList(), 5);
        functions.scrollIntoElement(registrationPage.getStakeholderTypeDropDownList());
        Thread.sleep(750);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getPlateCodeDropDownList(), 8);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        functions.scrollThePageUp();

    }

    public void fillInTrucksRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        Thread.sleep(2000);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        Thread.sleep(1000);
        functions.dropDownPickerByIndex(registrationPage.getVehicleClassDropDownList(), 2);
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        Thread.sleep(1000);
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }

    public void fillInTrailersRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        registrationPage.getEmptyWeightField().sendKeys("5000");
        registrationPage.getMaximumLoadField().sendKeys("15000");
        registrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        Thread.sleep(1000);
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInEquipmentRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getVehicleClassTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        registrationPage.getEmptyWeightField().sendKeys("5000");
        registrationPage.getMaximumLoadField().sendKeys("15000");
        registrationPage.getNumberOfAxesField().sendKeys("5");
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        Thread.sleep(1000);
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        functions.scrollThePageUp();
    }
    public void fillInBusesRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getUsageDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        registrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }

    public void fillInCarsRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String plateNumber = String.valueOf(functions.generateRandomNumber(6));
        registrationPage.fillplateNum(plateNumber);
        functions.dropDownPickerByIndex(registrationPage.getVehicleColorDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getPlateTypeDropDownList(), 2);
        functions.dropDownPickerByIndex(registrationPage.getVehicleTypeDropDownList(),  2);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        String chassesNumber = String.valueOf(functions.generateRandomNumber(17));
        functions.scrollIntoElement(registrationPage.getChassesNumberField());
        registrationPage.getChassesNumberField().sendKeys(chassesNumber);
        registrationPage.getNumPassengersField().sendKeys("2");
        functions.scrollThePageUp();
    }

    public void fillInInsuranceInfo() {

        Functions functions = new Functions();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickOnInsuranceCompanyInfoTab();
        String insurancePolicyNumber = String.valueOf(functions.generateRandomNumber(10));
        registrationPage.getInsurancePolicyNumberField().sendKeys(insurancePolicyNumber);
    }

    public void uploadTrucksRegistrationAttachments() throws InterruptedException, IOException {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Functions functions = new Functions();

        registrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        registrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        registrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        registrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        registrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        registrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 6
        registrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 7
        registrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadTrailersRegistrationAttachments() throws InterruptedException, IOException {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Functions functions = new Functions();

        registrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        registrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        registrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        registrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        registrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        registrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadEquipmentsRegistrationAttachments() throws InterruptedException, IOException {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Functions functions = new Functions();

        registrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        registrationPage.clickOnAuthorizationAttachmentButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        registrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        registrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 6
        registrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 7
        registrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void uploadBusesRegistrationAttachments() throws InterruptedException, IOException {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Functions functions = new Functions();

        registrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        registrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        registrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        registrationPage.clickOnAuthorizationAttachmentButton6();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        registrationPage.clickOnAuthorizationAttachmentButton7();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
        Thread.sleep(7000);
        functions.scrollThePageDown();
    }
    public void uploadCarsRegistrationAttachments() throws InterruptedException, IOException {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        Functions functions = new Functions();

        registrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        registrationPage.clickOnAuthorizationAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        registrationPage.clickOnAuthorizationAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 4
        registrationPage.clickOnAuthorizationAttachmentButton4();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 5
        registrationPage.clickOnAuthorizationAttachmentButton5();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        Thread.sleep(7000);
        functions.scrollThePageDown();
    }

    public void proceedWithFinalRegistrationSteps() throws InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        functions.scrollThePageDown();
        functions.scrollIntoElementAndClickOnIt(commonLocators.getCreateButton());
        Thread.sleep(750);
        registrationPage.clickOnYesButton();
    }
}
