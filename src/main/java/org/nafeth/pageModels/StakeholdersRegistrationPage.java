package org.nafeth.pageModels;

import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.ExcelHandler;
import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clickOnSignUpButton() {

        functions.waitForElementToBeClickable(signUpButton);
        signUpButton.click();
    }

    public void clickOnOwnersAndDriversRegisterButton() {

        functions.waitForElementToBeClickable(ownersAndDriversRegisterButton);
        ownersAndDriversRegisterButton.click();
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
}
