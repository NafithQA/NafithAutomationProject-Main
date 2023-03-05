package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
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

    public void fillInTruckingCompaniesRegistrationInfo() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        Thread.sleep(750);
        String CRN = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.fillCRNNum(CRN);
        Thread.sleep(750);

        Thread.sleep(1000);


        functions.scrollIntoElement(commonLocators.getCreateButton());

        functions.scrollThePageUp();

    }


    public void uploadTruckingCompaniesRegistrationAttachments() throws InterruptedException, IOException {

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
