package org.nafeth.stakeholdersRegistration;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExternalDriversRegistration extends Configurations {

    @Test(enabled = true)
    public void External_Drivers_Registration() throws IOException, InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        StakeholdersRegistrationPage stakeholdersRegistrationPage = new StakeholdersRegistrationPage(driver);

        functions.navigateToQaURL();
        stakeholdersRegistrationPage.clickOnSignUpButton();
        stakeholdersRegistrationPage.clickOnOwnersAndDriversRegisterButton();

        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getDocumentNationalityDropDownList(), 2);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getIdDocumentTypeDropDownList(), 2);
        String idDocumentNumber = String.valueOf(functions.generateRandomNumber(15));
        stakeholdersRegistrationPage.getIdDocumentNumberField().sendKeys(idDocumentNumber);
        String mobileNumber = String.valueOf(functions.generateRandomNumber(9));
        stakeholdersRegistrationPage.getMobileNumberField().sendKeys(mobileNumber);
        functions.dropDownPickerByIndex(stakeholdersRegistrationPage.getAreaCodeDropDownList(), 2);
        Thread.sleep(3000);

        stakeholdersRegistrationPage.clickOnResumeButton();
        commonLocators.clickOnYesButton();
    }
}
