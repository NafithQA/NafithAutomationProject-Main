package org.nafeth.fleetRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.FleetRegistrationSteps;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DriverOwnerFleetRegistrationTests extends Configurations {

    @Test(enabled = true)
    public void Trailers_DriverOwner_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("driverUser"), dataLoader.credentialsData("driverPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Trailers Registration Menu
        fleetRegistrationSteps.navigateToTrailersRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo();

        // Fill-In Trailer Registration Info
        fleetRegistrationSteps.fillInTrailersRegistrationInfo();

        // Fill in Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadTrailersRegistrationAttachments();

        // Check the Agreement
        fleetRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Trucks_DriverOwner_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("driverUser"), dataLoader.credentialsData("driverPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Trucks Registration Menu
        fleetRegistrationSteps.navigateToTrucksRegistrationMenu();

        // Fill-In License Info
        fleetRegistrationSteps.fillInLicenseInfo();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInTrucksRegistrationInfo();

        // Fill in Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadTrucksRegistrationAttachments();

        // Check the Agreement
        fleetRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Equipment_DriverOwner_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("driverUser"), dataLoader.credentialsData("driverPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Equipment Registration Menu
        fleetRegistrationSteps.navigateToEquipmentsRegistrationMenu();

        // Fill-In License Info
        fleetRegistrationSteps.fillInLicenseInfo();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInEquipmentRegistrationInfo();

        // Fill in Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadEquipmentsRegistrationAttachments();

        // Check the Agreement
        fleetRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }
}
