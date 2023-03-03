package org.nafeth.pageModels;

//import jdk.internal.net.http.common.Pair;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FleetRegistrationPage {

    private Functions functions = new Functions();

    public FleetRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "RELATED_ENTITY_ID")
    private WebElement stakeholderTypeDropDownList;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--selectable select2-results__option--highlighted']")
    private WebElement stakeholderTypeDDLInvestor;

    @FindBy(id = "LOCATION_IDS")
    private WebElement industrialAreaDropDownList;

    @FindBy(xpath = "//select[@id='RELATED_ENTITY_RECORD_ID']")
    private WebElement stakeholderNameDropDownList;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--selectable select2-results__option--highlighted']")
    private WebElement investorNameDDL;

    @FindBy(id = "PLATE_NUMBER")
    private WebElement plateNumField;

    @FindBy(id = "FLEET_PLATE_CODE")
    private WebElement plateCodeDropDownList;

    @FindBy(xpath = "(//li[@class='select2-results__option select2-results__option--selectable'])[1]")
    private WebElement firstPlateCodeOption;

    @FindBy(id = "FLEET_PLATE_CODE")
    private WebElement choosePlateCodeDropDownList;

    @FindBy(id = "ATTACHMENT-TAB")
    private WebElement attachmentsTabButton;

    @FindBy(xpath = "(//div[@class='message dz-message'])[1]")
    private WebElement authorizationAttachmentButton1;

    @FindBy(xpath = "(//div[@class='message dz-message'])[2]")
    private WebElement authorizationAttachmentButton2;

    @FindBy(xpath = "(//div[@class='message dz-message'])[3]")
    private WebElement authorizationAttachmentButton3;

    @FindBy(xpath = "(//div[@class='message dz-message'])[4]")
    private WebElement authorizationAttachmentButton4;

    @FindBy(xpath = "(//div[@class='message dz-message'])[5]")
    private WebElement authorizationAttachmentButton5;

    @FindBy(xpath = "(//div[@class='message dz-message'])[6]")
    private WebElement authorizationAttachmentButton6;

    @FindBy(xpath = "(//div[@class='message dz-message'])[7]")
    private WebElement authorizationAttachmentButton7;

    @FindBy(id = "INSURANCE_DOCUMENT_NUMBER")
    private WebElement insurancePolicyNumberField;

    @FindBy(id = "INSURANCEINFO-TAB")
    private WebElement insuranceCompanyInfoTab;

    @FindBy(id = "TRUCK_TYPE")
    private WebElement vehicleClassDropDownList;

    @FindBy(id = "USE_DESCRIPTION")
    private WebElement usageDropDownList;

    @FindBy(id = "CHASSES_NUMBER")
    private WebElement chassesNumberField;

    @FindBy(xpath = "//div[@class='swal2-success-ring']")
    private WebElement successRingIcon;

    @FindBy(id = "LICENSE_EXPIRY_FROM")
    private WebElement licenseIssuingDatePicker;

    @FindBy(id = "LICENSE_EXPIRY_TO")
    private WebElement licenseExpiryDatePicker;

    @FindBy(id = "PLATE_TYPE_CODE")
    private WebElement plateTypeDropDownList;

    @FindBy(id = "COLOR_CODE")
    private WebElement vehicleColorDropDownList;

    @FindBy(id = "EMPTY_WEIGHT")
    private WebElement emptyWeightField;

    @FindBy(id = "EXTREME_CAPACITY")
    private WebElement maximumLoadField;

    @FindBy(id = "AXES_NUMBER")
    private WebElement numberOfAxesField;

    @FindBy(id = "//div[@class='dz-success-mark']")
    private WebElement uploadSuccessMark;

    @FindBy(id = "LICENCE_NATIONALITY")
    private WebElement documentNationalityDropDownList;

    @FindBy(id = "checkAgree")
    private WebElement agreementCheckbox;


    @FindBy(id = "EQUIPMENT_TYPE")
    private WebElement vehicleClassTypeDropDownList;

    @FindBy(id = "VEHICLE_TYPE")
    private WebElement vehicleTypeDropDownList;
    @FindBy(id = "PASSENGER_NUMBER")
    private WebElement NumPassengersField;


    public void clickOnStakeholderTypeDDL() {

        functions.waitForElementToBeClickable(stakeholderTypeDropDownList);
        stakeholderTypeDropDownList.click();
    }

    public WebElement getStakeholderTypeDropDownList() {

        functions.waitForElementToBeVisible(stakeholderTypeDropDownList);
        functions.waitForElementToBeClickable(stakeholderTypeDropDownList);
        return stakeholderTypeDropDownList;
    }

    public void clickOnStakeholderTypeDDLInvestor() {
        functions.waitForElementToBeVisible(stakeholderTypeDDLInvestor);
        functions.waitForElementToBeClickable(stakeholderTypeDDLInvestor);
        stakeholderTypeDDLInvestor.click();
    }

//    public void clickOnIndustrialEstateDDL() {
//
//        functions.waitForElementToBeClickable(industrialAreaDropDownList);
//        industrialAreaDropDownList.click();
//    }

    public WebElement getIndustrialEstateDropDownList() {

        functions.waitForElementToBeVisible(industrialAreaDropDownList);
        functions.waitForElementToBeClickable(industrialAreaDropDownList);
        return industrialAreaDropDownList;
    }



    public void clickOnStakeholderNameDDL() {

        functions.waitForElementToBeClickable(stakeholderNameDropDownList);
        stakeholderNameDropDownList.click();
    }

    public WebElement getStakeholderNameDropDownList() {

        functions.waitForElementToBeVisible(stakeholderNameDropDownList);
        functions.waitForElementToBeClickable(stakeholderNameDropDownList);
        return stakeholderNameDropDownList;
    }

    public void clickOnInvestorNameDDL() {
        functions.waitForElementToBeVisible(investorNameDDL);
        functions.waitForElementToBeClickable(investorNameDDL);
        investorNameDDL.click();
    }

    public void fillplateNum(String plateNum) throws IOException {

        functions.waitForElementToBeClickable(plateNumField);
        plateNumField.sendKeys(plateNum);
    }

    public void clickOnPlateCodeDDL() {

        functions.waitForElementToBeClickable(plateCodeDropDownList);
        plateCodeDropDownList.click();
    }

    public void clickOnFirstPlateCodeOption() {

        functions.waitForElementToBeClickable(firstPlateCodeOption);
        firstPlateCodeOption.click();
    }

    public WebElement getPlateCodeDropDownList() {

        functions.waitForElementToBeVisible(plateCodeDropDownList);
        functions.waitForElementToBeClickable(plateCodeDropDownList);
        return plateCodeDropDownList;
    }

    public void clickOnchooseplateCodeDDL() {
        functions.waitForElementToBeVisible(choosePlateCodeDropDownList);
        functions.waitForElementToBeClickable(choosePlateCodeDropDownList);
        choosePlateCodeDropDownList.click();
    }


    public void clickOnAttachmentsTabButton() {

        functions.waitForElementToBeClickable(attachmentsTabButton);
        attachmentsTabButton.click();
    }


    public void clickOnAuthorizationAttachmentButton1() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton1);
        authorizationAttachmentButton1.click();
    }

    public void clickOnAuthorizationAttachmentButton2() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton2);
        authorizationAttachmentButton2.click();
    }

    public void clickOnAuthorizationAttachmentButton3() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton3);
        authorizationAttachmentButton3.click();
    }

    public void clickOnAuthorizationAttachmentButton4() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton4);
        authorizationAttachmentButton4.click();
    }

    public void clickOnAuthorizationAttachmentButton5() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton5);
        authorizationAttachmentButton5.click();
    }

    public void clickOnAuthorizationAttachmentButton6() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton6);
        authorizationAttachmentButton6.click();
    }

    public void clickOnAuthorizationAttachmentButton7() {

        functions.waitForElementToBeClickable(authorizationAttachmentButton7);
        authorizationAttachmentButton7.click();
    }

    public WebElement getInsurancePolicyNumberField() {

        functions.waitForElementToBeVisible(insurancePolicyNumberField);
        functions.waitForElementToBeClickable(insurancePolicyNumberField);
        return insurancePolicyNumberField;
    }

    public void clickOnInsuranceCompanyInfoTab() {

        functions.waitForElementToBeClickable(insuranceCompanyInfoTab);
        insuranceCompanyInfoTab.click();
    }

    public WebElement getInsuranceCompanyInfoTab() {

        functions.waitForElementToBeVisible(insuranceCompanyInfoTab);
        functions.waitForElementToBeClickable(insuranceCompanyInfoTab);
        return insuranceCompanyInfoTab;
    }

    public WebElement getVehicleClassDropDownList() {

        functions.waitForElementToBeVisible(vehicleClassDropDownList);
        functions.waitForElementToBeClickable(vehicleClassDropDownList);
        return vehicleClassDropDownList;
    }

    public WebElement getUsageDropDownList() {

        functions.waitForElementToBeVisible(usageDropDownList);
        functions.waitForElementToBeClickable(usageDropDownList);
        return usageDropDownList;
    }

    public WebElement getChassesNumberField() {

        functions.waitForElementToBeVisible(chassesNumberField);
        functions.waitForElementToBeClickable(chassesNumberField);
        return chassesNumberField;
    }

    public WebElement getSuccessRingIcon() {

        functions.waitForElementToBeVisible(successRingIcon);
        functions.waitForElementToBeClickable(successRingIcon);
        return successRingIcon;
    }

    public WebElement getLicenseIssuingDatePicker() {

        functions.waitForElementToBeVisible(licenseIssuingDatePicker);
        functions.waitForElementToBeClickable(licenseIssuingDatePicker);
        return licenseIssuingDatePicker;
    }

    public WebElement getLicenseExpiryDatePicker() {

        functions.waitForElementToBeVisible(licenseExpiryDatePicker);
        functions.waitForElementToBeClickable(licenseExpiryDatePicker);
        return licenseExpiryDatePicker;
    }

    public WebElement getPlateTypeDropDownList() {

        functions.waitForElementToBeVisible(plateTypeDropDownList);
        functions.waitForElementToBeClickable(plateTypeDropDownList);
        return plateTypeDropDownList;
    }

    public WebElement getVehicleColorDropDownList() {

        functions.waitForElementToBeVisible(vehicleColorDropDownList);
        functions.waitForElementToBeClickable(vehicleColorDropDownList);
        return vehicleColorDropDownList;
    }

    public WebElement getEmptyWeightField() {

        functions.waitForElementToBeVisible(emptyWeightField);
        functions.waitForElementToBeClickable(emptyWeightField);
        return emptyWeightField;
    }

    public WebElement getMaximumLoadField() {

        functions.waitForElementToBeVisible(maximumLoadField);
        functions.waitForElementToBeClickable(maximumLoadField);
        return maximumLoadField;
    }

    public WebElement getNumberOfAxesField() {

        functions.waitForElementToBeVisible(numberOfAxesField);
        functions.waitForElementToBeClickable(numberOfAxesField);
        return numberOfAxesField;
    }

    public WebElement getUploadSuccessMark() {

        functions.waitForElementToBeVisible(uploadSuccessMark);
        return uploadSuccessMark;
    }

    public WebElement getDocumentNationalityDropDownList() {

        functions.waitForElementToBeVisible(documentNationalityDropDownList);
        return documentNationalityDropDownList;
    }

    public void clickOnAgreementCheckbox() {

        functions.waitForElementToBeClickable(agreementCheckbox);
        agreementCheckbox.click();
    }

    public WebElement getVehicleClassTypeDropDownList() {

        functions.waitForElementToBeVisible(vehicleClassTypeDropDownList);
        functions.waitForElementToBeClickable(vehicleClassTypeDropDownList);
        return vehicleClassTypeDropDownList;
    }

    public WebElement getVehicleTypeDropDownList() {

        functions.waitForElementToBeVisible(vehicleTypeDropDownList);
        functions.waitForElementToBeClickable(vehicleTypeDropDownList);
        return vehicleTypeDropDownList;
    }
    public WebElement getNumPassengersField() {

        functions.waitForElementToBeVisible(NumPassengersField);
        functions.waitForElementToBeClickable(NumPassengersField);
        return NumPassengersField;
    }

}
