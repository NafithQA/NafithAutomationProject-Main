package org.nafeth.subscriptionTypeTest;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.StakeholderRegistrationSteps;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubscriptionTypeTruckingCompanies  extends Configurations {

    @Test(enabled = true)
    public void SubscriptionType_TruckingCompanies() throws IOException, InterruptedException {

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
