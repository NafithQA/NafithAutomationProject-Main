package org.nafeth.pageModels;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SubscriptionTypePage {
    private Functions functions = new Functions();

    public SubscriptionTypePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "industrialEstate")
    private WebElement industrialEstateDropDownList;

    @FindBy(id = "PPH000041_btn")
    private WebElement packageOneMonth;

    @FindBy(xpath = "//select[@class='round border-warning']/option[1]")
    private WebElement chooseAnyVehicle;

    @FindBy(xpath = "//div[@class='btn-group buttons']/button[2]")
    private WebElement selectOneTruckToSubscribe;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

    @FindBy(id = "radio_5")
    private WebElement fromBalanceOption;

    @FindBy(id = "radio_3")
    private WebElement fromVISAOption;

    @FindBy(id = "checkAgree")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//i[@class='fa fa-thumbs-down']")
    private WebElement successRingIcon;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement payButton;

    @FindBy(id = "BU00021_btn")
    private WebElement packageBusOneWeek;

    @FindBy(id = "radio_6")
    private WebElement fromPOSOption;

    @FindBy(id = "RECEIPT_ID")
    private WebElement receiptIdField;

    @FindBy(id = "FLEET_APPROVAL_NUMBER")
    private WebElement approvalNumbersField;
    @FindBy(id = "TRUCK_PLATE_NUMBER")
    private WebElement truckPlateNumber;

    @FindBy(id = "TRUCK_PLATE_CODE")
    private WebElement truckPlateCode;

    @FindBy(id = "TRAILER_PLATE_NUMBER")
    private WebElement trailerPlateNumber;

    @FindBy(id = "TRAILER_PLATE_CODE")
    private WebElement trailerPlateCode;

    @FindBy(id = "TRAILER_TYPE")
    private WebElement trailerType;

    @FindBy(id = "CARGO_TYPE")
    private WebElement cargoType;

    @FindBy(id = "OPERATION_TYPE")
    private WebElement operationType;

    @FindBy(id = "ONETRIP_DRIVERINFO-TAB")
    private WebElement driverInfoTab;

    @FindBy(id = "PERSONAL_DOC_NATIONALITY")
    private WebElement personalDocNationality;

    @FindBy(id = "PERSONAL_DOC_TYPE")
    private WebElement personalDocType;

    @FindBy(id = "PERSONAL_DOC_NUMBER")
    private WebElement documentNumberField;


    @FindBy(id = "RESIDENT_CARD")
    private WebElement driverCard;

    @FindBy(id = "DRIVER_NAME")
    private WebElement driverNameField;

    @FindBy(id = "DRIVER_NATIONALITY")
    private WebElement driverNationalityField;

    @FindBy(id = "DRIVER_MOBILE")
    private WebElement driverMobileField;

    @FindBy(id = "ATTACHMENT-TAB")
    private WebElement attachmentsTabButton;
    @FindBy(id = "DRIVER_FRONT_PER_DOC_ATT")
    private WebElement authorizationAttachmentButton1;
    @FindBy(id = "DRIVER_BACK_PER_DOC_ATT")
    private WebElement authorizationAttachmentButton2;
    @FindBy(id = "DRIVER_FRONT_LIC_ATT")
    private WebElement authorizationAttachmentButton3;
    @FindBy(id = "DRIVER_BACK_LIC_ATT")
    private WebElement authorizationAttachmentButton4;

    @FindBy(id = "oneTripAddTruck")
    private WebElement oneTripAddTruckButton;

    public WebElement getIndustrialEstateDropDownList() {

        functions.waitForElementToBeVisible(industrialEstateDropDownList);
        functions.waitForElementToBeClickable(industrialEstateDropDownList);
        return industrialEstateDropDownList;
    }

    public void clickOnPackageOneMonthButton() {

        functions.waitForElementToBeClickable(packageOneMonth);
        packageOneMonth.click();
    }

    public void clickOnChooseAnyVehicle() {

        functions.waitForElementToBeClickable(chooseAnyVehicle);
        chooseAnyVehicle.click();
    }

    public void clickOnSelectOneTruckToSubscribe() {

        functions.waitForElementToBeClickable(selectOneTruckToSubscribe);
        selectOneTruckToSubscribe.click();
    }

    public WebElement getNextButton() {

        functions.waitForElementToBeClickable(nextButton);
        return nextButton;
    }

    public void clickOnNextButton() {

        functions.waitForElementToBeClickable(nextButton);
        nextButton.click();
        functions.waitForPageToLoad();
    }

    public void selectBalanceOption() {

        functions.waitForElementToBeClickable(fromBalanceOption);
        fromBalanceOption.click();
    }

    public void selectVISAOption() {

        functions.waitForElementToBeClickable(fromVISAOption);
        fromVISAOption.click();
    }

    public void clickOnAgreementCheckbox() {

        functions.waitForElementToBeClickable(agreementCheckbox);
        agreementCheckbox.click();
    }

    public WebElement getSuccessRingIcon() {

        functions.waitForElementToBeVisible(successRingIcon);
        functions.waitForElementToBeClickable(successRingIcon);
        return successRingIcon;
    }

    public void clickOnPayButton() {
        functions.waitForElementToBeClickable(payButton);
        payButton.click();
    }

    public void clickOnPackageBusOneWeekButton() {

        functions.waitForElementToBeClickable(packageBusOneWeek);
        packageBusOneWeek.click();
    }

    public void selectPOSOption() {

        functions.waitForElementToBeClickable(fromPOSOption);
        fromPOSOption.click();
    }

    public WebElement getReceiptIdField() {

        functions.waitForElementToBeVisible(receiptIdField);
        functions.waitForElementToBeClickable(receiptIdField);
        return receiptIdField;
    }

    public WebElement fillApprovalNumbersField() {

        functions.waitForElementToBeVisible(approvalNumbersField);
        functions.waitForElementToBeClickable(approvalNumbersField);
        return approvalNumbersField;
    }

    public WebElement fillTruckPlateNumber() {

        functions.waitForElementToBeVisible(truckPlateNumber);
        functions.waitForElementToBeClickable(truckPlateNumber);
        return truckPlateNumber;
    }

    public WebElement getTruckPlateCodeDropDownList() {

        functions.waitForElementToBeVisible(truckPlateCode);
        functions.waitForElementToBeClickable(truckPlateCode);
        return truckPlateCode;
    }

    public WebElement fillTrailerPlateNumber() {

        functions.waitForElementToBeVisible(trailerPlateNumber);
        functions.waitForElementToBeClickable(trailerPlateNumber);
        return trailerPlateNumber;
    }

    public WebElement getTrailerPlateCodeDropDownList() {

        functions.waitForElementToBeVisible(trailerPlateCode);
        functions.waitForElementToBeClickable(trailerPlateCode);
        return trailerPlateCode;
    }

    public WebElement getTrailerTypeDropDownList() {

        functions.waitForElementToBeVisible(trailerType);
        functions.waitForElementToBeClickable(trailerType);
        return trailerType;
    }

    public WebElement getCargoTypeDropDownList() {

        functions.waitForElementToBeVisible(cargoType);
        functions.waitForElementToBeClickable(cargoType);
        return cargoType;
    }

    public WebElement getOperationTypeDropDownList() {

        functions.waitForElementToBeVisible(operationType);
        functions.waitForElementToBeClickable(operationType);
        return operationType;
    }

    public void clickOnDriverTabInfoTab() {

        functions.waitForElementToBeClickable(driverInfoTab);
        driverInfoTab.click();
    }
    public void clickOnAttachmentsTabButton() {

        functions.waitForElementToBeClickable(attachmentsTabButton);
        attachmentsTabButton.click();
    }
    public WebElement getDocumentNationalityDropDownList() {

        functions.waitForElementToBeVisible(personalDocNationality);
        functions.waitForElementToBeClickable(personalDocNationality);
        return personalDocNationality;
    }
    public WebElement getDocumentTypeDropDownList() {

        functions.waitForElementToBeVisible(personalDocType);
        functions.waitForElementToBeClickable(personalDocType);
        return personalDocType;
    }
    public WebElement getIdDocumentNumberField() {

        functions.waitForElementToBeVisible(documentNumberField);
        functions.waitForElementToBeClickable(documentNumberField);
        return documentNumberField;
    }
    public void fillDriverName(String driverNameFields) throws IOException {

        functions.waitForElementToBeClickable(driverNameField);
        driverNameField.sendKeys(driverNameFields);
    }

    public WebElement getDriverNationalityDropDownList() {

        functions.waitForElementToBeVisible(driverNationalityField);
        functions.waitForElementToBeClickable(driverNationalityField);
        return driverNationalityField;
    }

    public WebElement getMobileNumberField(){

        functions.waitForElementToBeClickable(driverMobileField);
        return driverMobileField;
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

    public void clickOnOneTripAddTruckButton() {

        functions.waitForElementToBeClickable(oneTripAddTruckButton);
        oneTripAddTruckButton.click();
    }


}


