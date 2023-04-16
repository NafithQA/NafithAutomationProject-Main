package org.nafeth.pageModels;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
