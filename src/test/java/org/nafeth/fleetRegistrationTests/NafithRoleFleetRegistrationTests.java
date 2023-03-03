package org.nafeth.fleetRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.FleetRegistrationSteps;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NafithRoleFleetRegistrationTests extends Configurations {

    @Test(enabled = true)
    public void Trailers_NafithRole_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Trailers Registration Menu
        fleetRegistrationSteps.navigateToTrailersRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo_NafithRole();

        // Fill-In Trailer Registration Info
        fleetRegistrationSteps.fillInTrailersRegistrationInfo_NafithRole();

        // Fill-In Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadTrailersRegistrationAttachments();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Trucks_NafithRole_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Trucks Registration Menu
        fleetRegistrationSteps.navigateToTrucksRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo_NafithRole();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInTrucksRegistrationInfo_NafithRole();

        // Fill-In Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadTrucksRegistrationAttachments();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Equipments_NafithRole_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Equipments Registration Menu
        fleetRegistrationSteps.navigateToEquipmentsRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo_NafithRole();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInEquipmentsRegistrationInfo_NafithRole();

        // Fill-In Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadEquipmentsRegistrationAttachments();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Buses_NafithRole_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Buses Registration Menu
        fleetRegistrationSteps.navigateToBusesRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo_NafithRole();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInBusesRegistrationInfo_NafithRole();

        // Fill-In Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadBusesRegistrationAttachments();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

    @Test(enabled = true)
    public void Cars_NafithRole_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        GenericSteps genericSteps = new GenericSteps(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("systemUser"), dataLoader.credentialsData("systemPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Cars Registration Menu
        fleetRegistrationSteps.navigateToCarsRegistrationMenu();

        // Fill-In Issuance and Expiry Dates
        fleetRegistrationSteps.fillInLicenseInfo_NafithRole();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInCarsRegistrationInfo_NafithRole();

        // Fill-In Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadCarsRegistrationAttachments();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }

}
