package org.nafeth.subscriptionTypeTest;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.SubscriptionTypeSteps;
import org.nafeth.pageModels.SubscriptionTypePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PermitTests extends Configurations {

    @Test(enabled = true)
    public void Permit_TruckingCompanies_FromBalance() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Permit Packages
        subscriptionTypeSteps.navigateToPermitPackages();

         // Create  Permit
        subscriptionTypeSteps.createOneTimePermitSubscription();

         // Pay By Balance
//        subscriptionTypeSteps.payByBalance();
//
//        // Check the Agreement
//        subscriptionTypePage.clickOnAgreementCheckbox();
//
//        // Proceed with Final Registration Steps
//        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();
//        // Test Assertion
//        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }
}
