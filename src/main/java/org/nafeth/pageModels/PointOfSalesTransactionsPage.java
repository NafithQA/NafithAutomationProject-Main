package org.nafeth.pageModels;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointOfSalesTransactionsPage {

    private final Functions functions = new Functions();

    @FindBy(id = "RECEIPT_ID")
    private WebElement receiptNumberField;

    @FindBy(id = "RECEIPT_AMOUNT")
    private WebElement receiptAmount;

    @FindBy(id = "CREATE")
    private WebElement createButton;

    public PointOfSalesTransactionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    ///////////////// Receipt Number Field /////////////////

    public WebElement getReceiptNumberField() {

        functions.waitForElementToBeVisible(receiptNumberField);
        return receiptNumberField;
    }

    ///////////////// Receipt Number Field /////////////////

    public WebElement getReceiptAmountField() {

        functions.waitForElementToBeVisible(receiptAmount);
        return receiptAmount;
    }

    ///////////////// CLick on Create Button /////////////////

    public void clickOnCreateButton() {

        functions.waitForElementToBeClickable(createButton);
        createButton.click();
    }
}
