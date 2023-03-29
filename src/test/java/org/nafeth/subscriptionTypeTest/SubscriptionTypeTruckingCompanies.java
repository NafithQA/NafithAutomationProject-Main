package org.nafeth.subscriptionTypeTest;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.SubscriptionTypeSteps;
import org.nafeth.pageModels.SubscriptionTypePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubscriptionTypeTruckingCompanies extends Configurations {

    @Test(enabled = true)
    public void SubscriptionType_TruckingCompanies() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Packages
        subscriptionTypeSteps.navigateToPackages();

        // Create  Fleet Subscription
        subscriptionTypeSteps.createFleetSubscription();

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }
}
