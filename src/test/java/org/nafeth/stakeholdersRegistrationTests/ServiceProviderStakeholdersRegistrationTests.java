package org.nafeth.stakeholdersRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.StakeholderRegistrationSteps;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class ServiceProviderStakeholdersRegistrationTests extends Configurations {
    @Test(enabled = false)
    public void ServiceProvider_External_Registration() throws IOException, InterruptedException {

        Functions functions = new Functions();
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);

        // Navigate To Qa URL
        functions.navigateToQaURL();

        // Sign Up Button
        stakeholdersRegistrationPage.clickOnSignUpButton();

        // click On Service Provider Register
        stakeholdersRegistrationPage.clickOnServiceProviderRegisterButton();

        // Fill-In Service Provider Registration Info
        stakeholderRegistrationSteps.fillInServiceProviderRegistrationInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadStakeholderRegistrationAttachments();

        // Check the Agreement
        stakeholdersRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getContinueRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void ServiceProvider_Internal_Registration() throws IOException, InterruptedException {

        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Stakeholder Registration Menu
        stakeholderRegistrationSteps.navigateToStakeholderRegistrationMenu();

        // Navigate to Service Provider Registration Menu
        stakeholderRegistrationSteps.navigateToServiceProviderRegistrationMenu();

        // Fill-In Service Provider Registration Info
        stakeholderRegistrationSteps.fillInServiceProviderRegistrationInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadStakeholderRegistrationAttachments();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getNoRingIcon().isDisplayed());
    }
}

