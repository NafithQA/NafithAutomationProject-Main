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
    private WebElement chooseAnyTruck;

    @FindBy(xpath = "//div[@class='btn-group buttons']/button[2]")
    private WebElement selectOneTruckToSubscribe;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

    @FindBy(id = "radio_5")
    private WebElement frombalanceOption;

    @FindBy(id = "checkAgree")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//div[@class='swal2-actions']/button[1]")
    private WebElement successRingIcon;

    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement payButton;

    public WebElement getIndustrialEstateDropDownList() {

        functions.waitForElementToBeVisible(industrialEstateDropDownList);
        functions.waitForElementToBeClickable(industrialEstateDropDownList);
        return industrialEstateDropDownList;
    }

    public void clickOnPackageOneMonthButton() {

        functions.waitForElementToBeClickable(packageOneMonth);
        packageOneMonth.click();
    }

    public void clickOnchooseAnyTruck() {

        functions.waitForElementToBeClickable(chooseAnyTruck);
        chooseAnyTruck.click();
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

    public void selectBalanceoption() {

        functions.waitForElementToBeClickable(frombalanceOption);
        frombalanceOption.click();
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
}
