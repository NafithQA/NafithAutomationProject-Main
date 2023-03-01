package org.nafeth.pageModels;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDepositsRequestPage {

    private Functions functions = new Functions();

    public AddDepositsRequestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "select2-TRANSACTION_TYPE-container")
    private WebElement transactionTypeDropDownList;

    @FindBy(xpath = "(//li[@role='option'])[1]")
    private WebElement cashDepositOption;

    @FindBy(id = "select2-BANK_ID-container")
    private WebElement bankNameDropDownList;

    @FindBy(xpath = "(//li[@role='option'])[2]")
    private WebElement secondOption;

    @FindBy(id = "DEPOSIT_AMOUNT")
    private WebElement depositAmountFiled;

    @FindBy(id = "DEPOSIT_DATE")
    private WebElement depositDateCalendar;

    @FindBy(xpath = "//div[@class='datepicker--cell datepicker--cell-day -current-']")
    private WebElement currentCalendarDayButton;

    @FindBy(id = "REFERENCE_NUMBER")
    private WebElement referenceNumberField;

    @FindBy(id = "CREATE")
    private WebElement createButton;

    @FindBy(id = "ATTACHMENT-TAB")
    private WebElement attachmentTab;

    @FindBy(xpath = "//div[@class='message dz-message']")
    private WebElement attachmentIcon;



    public void clickOnTransactionTypeDropDownList() {

        functions.waitForElementToBeClickable(transactionTypeDropDownList);
        transactionTypeDropDownList.click();
    }

    public void clickOnCashDepositOption() {

        functions.waitForElementToBeClickable(cashDepositOption);
        cashDepositOption.click();
    }

    public void clickOnBankNameDropDownList() {

        functions.waitForElementToBeClickable(bankNameDropDownList);
        bankNameDropDownList.click();
    }

    public void clickOnSecondOption() {

        functions.waitForElementToBeClickable(secondOption);
        secondOption.click();
    }

    public void fillDepositAmountFieldWith(String depositAmount) {

        functions.waitForElementToBeClickable(depositAmountFiled);
        depositAmountFiled.sendKeys(depositAmount);
    }

    public void clickOnDepositDateCalendar() {

        functions.waitForElementToBeClickable(depositDateCalendar);
        depositDateCalendar.click();
    }

    public void clickOnCurrentCalendarDayButton() {

        functions.waitForElementToBeClickable(currentCalendarDayButton);
        currentCalendarDayButton.click();
    }

    public void fillReferenceNumberFieldWith(String referenceNumber) {

        functions.waitForElementToBeClickable(referenceNumberField);
        referenceNumberField.sendKeys(referenceNumber);
    }

    public void clickOnCreateButton() {

        functions.waitForElementToBeClickable(createButton);
        createButton.click();
    }

    public void clickOnAttachmentTab() {

        functions.waitForElementToBeClickable(attachmentTab);
        attachmentTab.click();
    }

    public void clickOnAttachmentIcon() {

        functions.waitForElementToBeClickable(attachmentIcon);
        attachmentIcon.click();
    }
}
