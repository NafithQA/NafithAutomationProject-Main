package org.nafeth.pageModels;

import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.ExcelHandler;
import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class StakeholdersRegistrationPage {

    private Functions functions = new Functions();

    public StakeholdersRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Login_Btn")
    private WebElement loginButton;

    @FindBy(id = "Register_Btn")
    private WebElement signUpButton;

    @FindBy(xpath = "(//a[@class='col btn btn-outline-pink round'])[3]")
    private WebElement ownersAndDriversRegisterButton;

    @FindBy(xpath = "(//a[@class='col btn btn-outline-pink round'])[2]")
    private WebElement truckingCompaniesRegisterButton;

    @FindBy(id = "LICENSE_NATIONALITY_CODE_POPUP")
    private WebElement documentNationalityDropDownList;

    @FindBy(id = "PERSONAL_DOCUMENT_TYPE_POPUP")
    private WebElement idDocumentTypeDropDownList;

    @FindBy(id = "AREA_CODE_POPUP")
    private WebElement areaCodeDropDownList;

    @FindBy(id = "CN")
    private WebElement idDocumentNumberField;

    @FindBy(id = "MOBILE_NUMBER")
    private WebElement mobileNumberField;

    @FindBy(id = "registerNewOwner")
    private WebElement resumeButton;

    @FindBy(id = "closebtn1")
    private WebElement closeButton;

    @FindBy(id = "ATTACHMENT-TAB")
    private WebElement attachmentsTabButton;
    @FindBy(id = "CR")
    private WebElement crAttachmentsTabButton1;
    @FindBy(id = "MANAGER_AUTHORIZATION_FRONT")
    private WebElement authorizationFrontAttachmentButton2;

    @FindBy(id = "MANAGER_AUTHORIZATION_BACK")
    private WebElement authorizationBackAttachmentButton3;

    @FindBy(xpath = "//i[@class='fa fa-thumbs-up']")
    private WebElement yesButton;
    @FindBy(xpath = "//div[@class='swal2-success-ring']")
    private WebElement successRingIcon;
    @FindBy(id = "CN")
    private WebElement CN;

    @FindBy(id = "checkAgree")
    private WebElement agreementCheckbox;
    @FindBy(id = "NAME")
    private WebElement arabicNameField;
    @FindBy(id = "NAME_EN")
    private WebElement englishNameField;

    @FindBy(id = "PRIMARY_EMAIL")
    private WebElement emailField;



    public void clickOnSignUpButton() {

        functions.waitForElementToBeClickable(signUpButton);
        signUpButton.click();
    }

    public void clickOnOwnersAndDriversRegisterButton() {

        functions.waitForElementToBeClickable(ownersAndDriversRegisterButton);
        ownersAndDriversRegisterButton.click();
    }

    public void clickOnTruckingCompaniesRegisterButton() {

        functions.waitForElementToBeClickable(truckingCompaniesRegisterButton);
        truckingCompaniesRegisterButton.click();
    }

    public WebElement getDocumentNationalityDropDownList(){

        functions.waitForElementToBeVisible(documentNationalityDropDownList);
        functions.waitForElementToBeClickable(documentNationalityDropDownList);
        return documentNationalityDropDownList;
    }

    public WebElement getIdDocumentTypeDropDownList(){

        functions.waitForElementToBeClickable(idDocumentTypeDropDownList);
        return idDocumentTypeDropDownList;
    }

    public WebElement getAreaCodeDropDownList(){

        functions.waitForElementToBeClickable(areaCodeDropDownList);
        return areaCodeDropDownList;
    }

    public WebElement getIdDocumentNumberField(){

        functions.waitForElementToBeClickable(idDocumentNumberField);
        return idDocumentNumberField;
    }

    public WebElement getMobileNumberField(){

        functions.waitForElementToBeClickable(mobileNumberField);
        return mobileNumberField;
    }

    public void clickOnResumeButton() {

        functions.waitForElementToBeClickable(resumeButton);
        resumeButton.click();
    }

    public void clickOnCloseButton() {

        functions.waitForElementToBeClickable(closeButton);
        closeButton.click();
    }

    public void clickOnAttachmentsTabButton() {

        functions.waitForElementToBeClickable(attachmentsTabButton);
        attachmentsTabButton.click();
    }

    public void clickOnAttachmentsTabButton1() {

        functions.waitForElementToBeClickable(crAttachmentsTabButton1);
        crAttachmentsTabButton1.click();
    }
    public void clickOnAuthorizationFrontAttachmentButton2() {

        functions.waitForElementToBeClickable(authorizationFrontAttachmentButton2);
        authorizationFrontAttachmentButton2.click();
    }
    public void clickOnAuthorizationBackAttachmentButton3() {

        functions.waitForElementToBeClickable(authorizationBackAttachmentButton3);
        authorizationBackAttachmentButton3.click();
    }
    public void fillCRNNum(String CRNNum) throws IOException {

        functions.waitForElementToBeClickable(CN);
        CN.sendKeys(CRNNum);
    }
    public WebElement getSuccessRingIcon() {

        functions.waitForElementToBeVisible(successRingIcon);
        functions.waitForElementToBeClickable(successRingIcon);
        return successRingIcon;
    }
    public void clickOnYesButton() {
        functions.waitForElementToBeClickable(yesButton);
        yesButton.click();
    }
    public void clickOnAgreementCheckbox() {
        functions.waitForElementToBeClickable(agreementCheckbox);
        agreementCheckbox.click();
    }
     public void fillEmail(String emailFields) throws IOException {

        functions.waitForElementToBeClickable(emailField);
        emailField.sendKeys(emailFields);
    }
    public void fillArabicName(String arabicNameFields) throws IOException {

        functions.waitForElementToBeClickable(arabicNameField);
        arabicNameField.sendKeys(arabicNameFields);
    }
    public void fillEnglishName(String englishNameFields) throws IOException {

        functions.waitForElementToBeClickable(englishNameField);
        englishNameField.sendKeys(englishNameFields);
    }
}
