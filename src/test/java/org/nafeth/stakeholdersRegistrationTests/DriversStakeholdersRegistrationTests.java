package org.nafeth.stakeholdersRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.FleetRegistrationSteps;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.StakeholderRegistrationSteps;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DriversStakeholdersRegistrationTests extends Configurations {

    @Test(enabled = true)
    public void External_Drivers_Registration() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        functions.navigateToQaURL();
        stakeholdersRegistrationPage.clickOnSignUpButton();
        stakeholdersRegistrationPage.clickOnOwnersAndDriversRegisterButton();

        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getDocumentNationalityDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getIdDocumentTypeDropDownList(), 2);
        String idDocumentNumber = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.getIdDocumentNumberField().sendKeys(idDocumentNumber);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        stakeholdersRegistrationPage.getMobileNumberField().sendKeys(mobileNumber);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getAreaCodeDropDownList(), 2);
        Thread.sleep(3000);

        stakeholdersRegistrationPage.clickOnResumeButton();
        commonLocators.clickOnYesButton();
    }

    @Test(enabled = true)
    public void Internal_Drivers_Registration_Using_Service_Provider() throws IOException, InterruptedException {

        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToDriverOwnerRegistrationMenu();

        // Fill in Driver Registration Info
        stakeholderRegistrationSteps.fillInInternalDriverRegistrationInfo();

        // Fill in License Info
        stakeholderRegistrationSteps.fillInLicenseInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadDriversRegistrationAttachments();

        // Check the Agreement
        commonLocators.checkAgreementCheckbox();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());

        Thread.sleep(3000);
    }

    @Test(enabled = true)
    public void Internal_Drivers_Registration_Using_Trucking_Company() throws IOException, InterruptedException {

        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToDriverOwnerRegistrationMenu();

        // Fill in Driver Registration Info
        stakeholderRegistrationSteps.fillInInternalDriverRegistrationInfo();

        // Fill in License Info
        stakeholderRegistrationSteps.fillInLicenseInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadDriversRegistrationAttachments();

        // Check the Agreement
        commonLocators.checkAgreementCheckbox();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());

        Thread.sleep(3000);
    }

    @Test(enabled = true)
    public void Internal_Drivers_Registration_Using_Investor() throws IOException, InterruptedException {

        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("investorUser"), dataLoader.credentialsData("investorPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToDriverOwnerRegistrationMenu_Investor();

        // Fill in Driver Registration Info
        stakeholderRegistrationSteps.fillInInternalDriverRegistrationInfo();

        // Fill in License Info
        stakeholderRegistrationSteps.fillInLicenseInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadDriversRegistrationAttachments();

        // Check the Agreement
        commonLocators.checkAgreementCheckbox();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());

        Thread.sleep(3000);
    }
}

