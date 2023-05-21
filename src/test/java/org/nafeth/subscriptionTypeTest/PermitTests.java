package org.nafeth.subscriptionTypeTest;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.SubscriptionTypeSteps;
import org.nafeth.pageModels.CommonLocators;
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

        // Fill Vehicle  Information
        subscriptionTypeSteps.createOneTimePermitSubscription(1,11,11,1);

        // Fill Drivers  Information
        subscriptionTypeSteps.FillDriverPermitSubscription();

        // Upload Attachments
        subscriptionTypeSteps.uploadPermitAttachments();

        // Pay By Balance
        subscriptionTypeSteps.payByBalance();

       // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
         subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
       Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Permit_Investor_FromPOS() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("investorUser"), dataLoader.credentialsData("investorPass"));
        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Permit Packages
        subscriptionTypeSteps.navigateToPermitPackages();

        // Fill Vehicle  Information

        subscriptionTypeSteps.createOneTimePermitSubscription(28,7,7,28);

        // Fill Drivers  Information
        subscriptionTypeSteps.FillDriverPermitSubscription();

        // Upload Attachments
        subscriptionTypeSteps.uploadPermitAttachments();

        // Pay By Balance
        subscriptionTypeSteps.payByPOS("4");

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = false)
    public void Permit_Nafith_FromPOS() throws IOException, InterruptedException {

        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);
        SubscriptionTypeSteps subscriptionTypeSteps = new SubscriptionTypeSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Subscription Menu
        subscriptionTypeSteps.navigateToFleetSubscriptionMenu();

        // Navigate To Permit Packages
        subscriptionTypeSteps.navigateToPermitPackagesNafithRole();

        // Fill Vehicle  Information

        subscriptionTypeSteps.createOneTimePermitNafithSubscription(0,0);

        // Fill Drivers  Information
         subscriptionTypeSteps.FillDriverPermitSubscription();

        // Upload Attachments
        subscriptionTypeSteps.uploadPermitAttachments();

        // Pay By Balance
        subscriptionTypeSteps.payByPOS("6.1");

        // Check the Agreement
        subscriptionTypePage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
       subscriptionTypeSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
         Assert.assertTrue(subscriptionTypePage.getSuccessRingIcon().isDisplayed());
    }
}
