package org.nafeth.fleetRegistrationTests;

import org.nafeth.base.Configurations;
import org.nafeth.commonSteps.GenericSteps;
import org.nafeth.commonSteps.FleetRegistrationSteps;
import org.nafeth.pageModels.FleetRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ServiceProviderFleetRegistrationTests extends Configurations {

    @Test(enabled = true)
    public void Trailers_ServiceProvider_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

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
    public void Trucks_ServiceProvider_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

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
    public void Equipments_ServiceProvider_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Equipments Registration Menu
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
    @Test(enabled = true)
    public void Buses_ServiceProvider_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Buses Registration Menu
        fleetRegistrationSteps.navigateToBusesRegistrationMenu();

        // Fill-In License Info
        fleetRegistrationSteps.fillInLicenseInfo();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInBusesRegistrationInfo();

        // Fill in Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadBusesRegistrationAttachments();

        // Check the Agreement
        fleetRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }
    @Test(enabled = true)
    public void Cars_ServiceProvider_Registration() throws IOException, InterruptedException {

        FleetRegistrationPage fleetRegistrationPage = new FleetRegistrationPage(driver);
        FleetRegistrationSteps fleetRegistrationSteps = new FleetRegistrationSteps(driver);
        GenericSteps genericSteps = new GenericSteps(driver);

        // Login
        genericSteps.loginToMAMS(dataLoader.credentialsData("serviceProviderUser"), dataLoader.credentialsData("serviceProviderPass"));

        // Navigate to Fleet Registration Menu
        fleetRegistrationSteps.navigateToFleetRegistrationMenu();

        // Navigate to Cars Registration Menu
        fleetRegistrationSteps.navigateToCarsRegistrationMenu();

        // Fill-In License Info
        fleetRegistrationSteps.fillInLicenseInfo();

        // Fill-In Truck Registration Info
        fleetRegistrationSteps.fillInCarsRegistrationInfo();

        // Fill in Insurance Info
        fleetRegistrationSteps.fillInInsuranceInfo();

        // Upload Attachments
        fleetRegistrationSteps.uploadCarsRegistrationAttachments();

        // Check the Agreement
        fleetRegistrationPage.clickOnAgreementCheckbox();

        // Proceed with Final Registration Steps
        fleetRegistrationSteps.proceedWithFinalRegistrationSteps();

        // Test Assertion
        Assert.assertTrue(fleetRegistrationPage.getSuccessRingIcon().isDisplayed());
    }
}
