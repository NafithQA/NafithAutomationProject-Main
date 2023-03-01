package org.nafeth.pageModels;

import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreditPaymentPage {

	private Functions functions = new Functions();
	private DataLoader dataLoader = new DataLoader();

	public CreditPaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "creditCardNumber")
	private WebElement creditCardNumberField;

	@FindBy(id = "creditMonthSelect")
	private WebElement expiryDateMonthOption;

	@FindBy(id = "creditYearSelect")
	private WebElement expiryDateYearOption;

	@FindBy(id = "creditCardholderName")
	private WebElement cardHolderNameField;

	@FindBy(id = "cardCvv")
	private WebElement cvvNumberField;

	@FindBy(id = "proceed_button")
	private WebElement payButton;

	@FindBy(id = "proceed-button")
	private WebElement proceedAnyWayButton;

	@FindBy(xpath = "//button[@class='swal2-confirm btn btn-success swal2-styled']")
	private WebElement confirmAddMoreButton;

	@FindBy(xpath = "//button[@class='swal2-cancel btn btn-blue-grey swal2-styled']")
	private WebElement cancelAddMoreButton;

	public void fillCreditCardNumberFieldWith(String creditCardNumber) throws IOException {

		functions.waitForElementToBeClickable(creditCardNumberField);
		creditCardNumberField.sendKeys(creditCardNumber);
	}

	public void selectExpiryMonthDateAs(String expiryDateMonthValue) {

		functions.waitForElementToBeClickable(expiryDateMonthOption);
		functions.dropDownPickerByValue(expiryDateMonthOption, expiryDateMonthValue);
	}

	public void selectExpiryYearDateAs(String expiryDateYearValue) {

		functions.waitForElementToBeClickable(expiryDateYearOption);
		functions.dropDownPickerByValue(expiryDateYearOption, expiryDateYearValue);
	}

	public void fillCardHolderNameFieldWith(String cardHolderNameValue) throws IOException {

		functions.waitForElementToBeClickable(cardHolderNameField);
		cardHolderNameField.sendKeys(cardHolderNameValue);
	}

	public void fillCvvNumberFieldWith(String cvvNumber) throws IOException {

		functions.waitForElementToBeClickable(cvvNumberField);
		cvvNumberField.sendKeys(cvvNumber);
	}

	public void clickOnPayButton() {

		functions.waitForElementToBeClickable(payButton);
		payButton.click();
	}

	public WebElement getProceedAnyWayButton() {

		return proceedAnyWayButton;
	}

	public void clickOnProceedAnyWayButton() {

		functions.waitForElementToBeClickable(proceedAnyWayButton);
		proceedAnyWayButton.click();
	}

	public void clickOnConfirmAddMoreButton() {

		functions.waitForElementToBeClickable(confirmAddMoreButton);
		confirmAddMoreButton.click();
	}

	public void clickOnCancelAddMoreButton() {

		functions.waitForElementToBeClickable(cancelAddMoreButton);
		cancelAddMoreButton.click();
	}
}
