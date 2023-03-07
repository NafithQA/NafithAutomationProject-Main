package org.nafeth.stakeholdersRegistrationTests;


import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.StakeholderRegistrationSteps;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class InvestorsStakeholdersRegistrationTests  extends Configurations {


    @Test(enabled = false)
    public void Investors_External_Registration() throws IOException, InterruptedException {

        Functions functions = new Functions();
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);

        // Navigate To Qa URL
        functions.navigateToQaURL();

        // Sign Up Button
        stakeholdersRegistrationPage.clickOnSignUpButton();

        // click On Investors Register
        stakeholdersRegistrationPage.clickOnInvestorsRegisterButton();

        // Fill-In Investors Registration Info
        stakeholderRegistrationSteps.fillInInvestorsRegistrationInfo();

        // Fill-In  Parking Capacity tab
        stakeholderRegistrationSteps.fillParkingCapacityRegistrationInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadStakeholderRegistrationAttachments();

        // Check the Agreement
        stakeholdersRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Investors_Internal_Registration() throws IOException, InterruptedException {

        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Stakeholder Registration Menu
        stakeholderRegistrationSteps.navigateToStakeholderRegistrationMenu();

        // Navigate to Investors Registration Menu
        stakeholderRegistrationSteps.navigateToInvestorsRegistrationMenu();

        // Fill-In Investors Registration Info
        stakeholderRegistrationSteps.fillInInvestorsRegistrationInfo();

        // Fill-In  Parking Capacity tab
        stakeholderRegistrationSteps.fillParkingCapacityRegistrationInfo();

        // Upload Attachments
        stakeholderRegistrationSteps.uploadStakeholderRegistrationAttachments();

        // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());
    }
}
