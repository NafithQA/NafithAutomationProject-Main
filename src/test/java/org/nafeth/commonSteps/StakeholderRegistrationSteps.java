package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StakeholderRegistrationSteps {

    WebDriver driver;

    public StakeholderRegistrationSteps(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToStakeholderRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnRegistrationSystemMenu();
        functions.scrollThePageDown();
        Thread.sleep(1000);
        homePage.clickOnRegistrationStakeholderMenu();
        functions.scrollThePageDown();
    }

    public void navigateToTruckingCompaniesRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnTruckingCompaniesRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnTruckingCompaniesRegistrationPageButton();
        Thread.sleep(1000);
    }
    public void navigateToInvestorsRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnInvestorsRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnInvestorsRegistrationPageButton();
        Thread.sleep(1000);
    }
    public void navigateToServiceProviderRegistrationMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);

        homePage.clickOnServiceProviderRegistrationMenu();
        functions.scrollThePageDown();
        functions.moveToElement(homePage.getMainAppContent());
        homePage.clickOnServiceProviderRegistrationPageButton();
        Thread.sleep(1000);
    }

    public void fillInTruckingCompaniesRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        Thread.sleep(750);
        String CRN = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillCRNNum(CRN);
        String ArabicName = String.valueOf(" شركة نقل أتوميشن بالعربي" + functions.getRandomName());
        stakeholdersRegistrationPage.fillArabicName(ArabicName);
        String EnglishName = String.valueOf("Automation Trucking Companies EN " + functions.getRandomName());
        stakeholdersRegistrationPage.fillEnglishName(EnglishName);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        stakeholdersRegistrationPage.getMobileNumberField().sendKeys(mobileNumber);
        String Email = String.valueOf(functions.getRandomEmailString()+"@gmail.com");
        stakeholdersRegistrationPage.fillEmail(Email);
        Thread.sleep(1000);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        functions.scrollThePageUp();
    }

    public void fillInInvestorsRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        Thread.sleep(750);
        String CRN = String.valueOf(functions.generateRandomNumber(8));
        stakeholdersRegistrationPage.fillCRNInvestor(CRN);
        String ArabicName = String.valueOf("مستثمر أتوميشن بالعربي" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillArabicName(ArabicName);
        String EnglishName = String.valueOf("AutoInvestorsEN_" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillEnglishName(EnglishName);
        Thread.sleep(750);
        String activityLicenseNo  = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillActivityLicenseNo(activityLicenseNo);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getTypeOfActivityLicenseDropDownList(), 1);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getWorkingHoursDropDownList(), 2);
        Thread.sleep(1000);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getIndustrialAreaDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getGovernorateDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getStateDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getCityDropDownList(), 2);
        String Address = String.valueOf("Address" + functions.getRandomName());
        stakeholdersRegistrationPage.fillAddress(Address);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getDocumentTypeDropDownList(), 2);
        String nN = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillNn(nN);
        Thread.sleep(1000);
        String FirstName = String.valueOf("First" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFirstName(FirstName);
        String FatherName = String.valueOf("Second" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFatherName(FatherName);
        String Grandfather = String.valueOf("Third" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillGrandfatherName(Grandfather);
        String FamilyName = String.valueOf("Family" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFamilyName(FamilyName);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        stakeholdersRegistrationPage.getMobileNumberField().sendKeys(mobileNumber);
        Thread.sleep(1000);
        String Email = String.valueOf(functions.getRandomEmailString()+"@gmail.com");
        stakeholdersRegistrationPage.fillEmail(Email);
        Thread.sleep(1000);
        functions.scrollThePageUp();
    }

    public void fillInServiceProviderRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        Thread.sleep(750);
        String CRN = String.valueOf(functions.generateRandomNumber(8));
        stakeholdersRegistrationPage.fillCRNInvestor(CRN);
        String ArabicName = String.valueOf("مزود خدمة أتوميشن بالعربي" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillArabicName(ArabicName);
        String EnglishName = String.valueOf("AutoServiceProviderEN_" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillEnglishName(EnglishName);
        Thread.sleep(750);
        String workPermitNo  = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillWorkPermitNo(workPermitNo);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getWorkPermitTypeDropDownList(), 1);
        Thread.sleep(1000);
        functions.scrollIntoElement(commonLocators.getCreateButton());
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getIndustrialAreaDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getGovernorateDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getStateDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getCityDropDownList(), 2);
        String Address = String.valueOf("Address" + functions.getRandomName());
        stakeholdersRegistrationPage.fillAddress(Address);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getPersonalDocumentTypeDropDownList(), 2);
        String nN = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillNn(nN);
        Thread.sleep(1000);
        String FirstName = String.valueOf("First" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFirstName(FirstName);
        String FatherName = String.valueOf("Second" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFatherName(FatherName);
        String Grandfather = String.valueOf("Third" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillGrandfatherName(Grandfather);
        String FamilyName = String.valueOf("Family" + functions.getRandomInvestorName());
        stakeholdersRegistrationPage.fillFamilyName(FamilyName);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        stakeholdersRegistrationPage.getMobileNumberField().sendKeys(mobileNumber);
        Thread.sleep(1000);
        String Email = String.valueOf(functions.getRandomEmailString()+"@gmail.com");
        stakeholdersRegistrationPage.fillEmail(Email);
        Thread.sleep(1000);
        functions.scrollThePageUp();
    }

    public void fillParkingCapacityRegistrationInfo() {

            Functions functions = new Functions();
            StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

            stakeholdersRegistrationPage.clickOnParkingCapacityInfoTab();
            String trucksAvailableParkingCapacity = String.valueOf(functions.generateRandomNumber(4));
            stakeholdersRegistrationPage.getTrucksAvailableParkingCapacityField().sendKeys(trucksAvailableParkingCapacity);

            String CarsParkingCapacity = String.valueOf(functions.generateRandomNumber(4));
            stakeholdersRegistrationPage.getCarsParkingCapacityField().sendKeys(CarsParkingCapacity);

        }
    public void uploadStakeholderRegistrationAttachments() throws InterruptedException, IOException {

        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        Functions functions = new Functions();

        stakeholdersRegistrationPage.clickOnAttachmentsTabButton();
        // Attachment 1
        stakeholdersRegistrationPage.clickOnAttachmentsTabButton1();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 2
        stakeholdersRegistrationPage.clickOnAuthorizationFrontAttachmentButton2();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        // Attachment 3
        stakeholdersRegistrationPage.clickOnAuthorizationBackAttachmentButton3();
        Thread.sleep(750);
        Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");

        Thread.sleep(7000);
        functions.scrollThePageDown();
    }
    public void proceedWithFinalRegistrationSteps() throws InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        functions.scrollThePageDown();
        functions.scrollIntoElementAndClickOnIt(commonLocators.getCreateButton());
        Thread.sleep(750);
        stakeholdersRegistrationPage.clickOnYesButton();
    }
}
