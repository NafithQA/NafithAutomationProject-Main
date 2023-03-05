package org.nafeth.stakeholdersRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.StakeholderRegistrationSteps;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TruckingCompaniesStakeholdersRegistrationTests extends Configurations {

    @Test(enabled = false)
    public void TruckingCompanies_External_Registration() {
    }

    @Test(enabled = true)
    public void TruckingCompanies_Internal_Registration() throws IOException, InterruptedException {

        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);
        StakeholderRegistrationSteps stakeholderRegistrationSteps = new StakeholderRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

         // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Stakeholder Registration Menu
        stakeholderRegistrationSteps.navigateToStakeholderRegistrationMenu();


        // Navigate to Trucking Companies Registration Menu
        stakeholderRegistrationSteps.navigateToTruckingCompaniesRegistrationMenu();


        // Fill-In Trucking Companies Registration Info
        stakeholderRegistrationSteps.fillInTruckingCompaniesRegistrationInfo();

         // Upload Attachments
        stakeholderRegistrationSteps.uploadTruckingCompaniesRegistrationAttachments();

         // Check the Agreement
        //registrationStakeholderPage.clickOnAgreementCheckbox();

         // Proceed with Final Registration Steps
        stakeholderRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(stakeholdersRegistrationPage.getSuccessRingIcon().isDisplayed());

    }
}
