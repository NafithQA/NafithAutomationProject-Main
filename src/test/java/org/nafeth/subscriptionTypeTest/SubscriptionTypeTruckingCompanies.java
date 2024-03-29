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
    public void SubscriptionType_TruckingCompanies_HeavyTruck_FromBalance() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Heavy Trucks Packages
        subscriptionTypeSteps.navigateToHeavyTrucksPackages();

        // Create  Fleet Subscription
        subscriptionTypeSteps.createHeavyFleetSubscription();

        // Pay By Balance
        subscriptionTypeSteps.payByBalance();

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();
         // Test Assertion
        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());

     }

    @Test(enabled = false)
    public void SubscriptionType_TruckingCompanies_Buses_POS() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Bus Packages
        subscriptionTypeSteps.navigateToBusPackages();

        // Create  Fleet Subscription
        subscriptionTypeSteps.createBusesFleetSubscription();

        // Pay By POS
        subscriptionTypeSteps.payByPOS("10");

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = false)
    public void SubscriptionType_TruckingCompanies_HeavyTruck_FromVISA() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("truckingCompanyUser"), dataLoader.credentialsData("truckingCompanyPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Heavy Trucks Packages
        subscriptionTypeSteps.navigateToHeavyTrucksPackages();

        // Create  Fleet Subscription
        subscriptionTypeSteps.createHeavyFleetSubscription();

        // Pay By VISA
          subscriptionTypeSteps.payByVISA();

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }
}
