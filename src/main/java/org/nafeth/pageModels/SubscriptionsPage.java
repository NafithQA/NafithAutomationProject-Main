package org.nafeth.pageModels;

import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionsPage {

    private final Functions functions = new Functions();

    @FindBy(xpath = "(//div[@id='step_4_row']/div/div/div/div/h4)[1]")
    private WebElement firstSubscriptionTitle;

    @FindBy(xpath = "(//div[@id='step_4_row']/div/div/div/div/h4)[3]")
    private WebElement secondSubscriptionTitle;

    @FindBy(xpath = "(//div[@id='step_4_row']/div/div/div/div/h4)[4]")
    private WebElement thirdSubscriptionTitle;

    @FindBy(xpath = "(//div[@id='step_4_row']/div/div/div/div/h4)[2]")
    private WebElement forthSubscriptionTitle;

    // Access periods
    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[1]/div/div/p)[2]")
    private WebElement firstSubscriptionAccessPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_2']/div)[1]/div/div/p)[2]")
    private WebElement secondSubscriptionAccessPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_3']/div)[1]/div/div/p)[2]")
    private WebElement thirdSubscriptionAccessPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[2]/div/div/p)[2]")
    private WebElement forthSubscriptionAccessPeriod;

    // Weigh In periods
    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[1]/div/div/p)[6]")
    private WebElement firstSubscriptionWeighInPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_2']/div)[1]/div/div/p)[6]")
    private WebElement secondSubscriptionWeighInPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_3']/div)[1]/div/div/p)[6]")
    private WebElement thirdSubscriptionWeighInPeriod;

    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[2]/div/div/p)[6]")
    private WebElement forthSubscriptionWeighInPeriod;

    // Access prices
    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[1]/div/div/p)[3]")
    private WebElement firstSubscriptionAccessPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_2']/div)[1]/div/div/p)[3]")
    private WebElement secondSubscriptionAccessPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_3']/div)[1]/div/div/p)[3]")
    private WebElement thirdSubscriptionAccessPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[2]/div/div/p)[3]")
    private WebElement forthSubscriptionAccessPrice;

    // Weigh In prices
    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[1]/div/div/p)[7]")
    private WebElement firstSubscriptionWeighInPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_2']/div)[1]/div/div/p)[7]")
    private WebElement secondSubscriptionWeighInPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_3']/div)[1]/div/div/p)[7]")
    private WebElement thirdSubscriptionWeighInPrice;

    @FindBy(xpath = "((//div[@id='step_4_col_1']/div)[2]/div/div/p)[7]")
    private WebElement forthSubscriptionWeighInPrice;

    // Subscribe Buttons
    @FindBy(id = "PPH000041_btn")
    private WebElement firstPackageSubscribeButton;

    @FindBy(id = "PPH000041_btn")
    private WebElement firstPackageSubscribeButtonSP;

    @FindBy(id = "PPH000041_btn")
    private WebElement firstPackageSubscribeButtonOO;

    @FindBy(id = "TC0002_btn")
    private WebElement secondPackageSubscribeButton;

    @FindBy(id = "TC0003_btn")
    private WebElement thirdPackageSubscribeButton;

    @FindBy(id = "TC0004_btn")
    private WebElement forthPackageSubscribeButton;

    // Fleet Selection section
    @FindBy(id = "bootstrap-duallistbox-nonselected-list_fleetdropdown")
    private WebElement fleetDropDownList;

    @FindBy(xpath = "//button[@id='moveSelected']/label")
    private WebElement moveSelectedFleetButton;

    @FindBy(xpath = "//button[@class='btn moveall border-warning round']")
    private WebElement moveSelectedFleetsButton;

    // Next Button
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

    // Number of vehicles for First Order
    @FindBy(xpath = "(//div[@class='col-xl-6 col-lg-6 col-sm-12']/div/h1[@class='pink'])[1]")
    private WebElement numberOfVehiclesForFirstOrder;

    // Total Price Value
    @FindBy(id = "totalPriceValue")
    private WebElement totalPriceValue;

    // Credit Card Option
    @FindBy(id = "radio_3")
    private WebElement creditCardOption;

    // POS Button
    @FindBy(id = "radio_6")
    private WebElement posOption;

    // Balance Button
    @FindBy(id = "radio_5")
    private WebElement balanceOption;

    // Pay Button
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement payButton;

    // Yes Payment Confirmation Button
    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-success swal2-styled']")
    private WebElement yesConfirmationButton;

    // Receipt Number Field
    @FindBy(id = "RECEIPT_ID")
    private WebElement receiptNumberField;

    // Receipt Number Field
    @FindBy(xpath = "(//i[@class='step-icon la la-shopping-cart font-large-1'])[1]")
    private WebElement subscriptionsSectionButton;

    // Plates Available
    @FindBy(xpath = "//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']/option")
    private WebElement listedPlates;

    // Searched Plate
    @FindBy(xpath = "(//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']/option)[1]")
    private WebElement searchedPlate;

    // Successful subscription creation process message
    @FindBy(id = "swal2-title")
    private WebElement successMessage;

    // First Weigh In Service Subscription Plate NUmber
    @FindBy(xpath = "(//td[@aria-describedby='SUBSCRIPTIONS_GRID_PLATE_NUMBER_GRID_AR'])[1]")
    private WebElement firstWeighInServicePlateNumber;

    // First Access Service Subscription Plate NUmber
    @FindBy(xpath = "(//td[@aria-describedby='SUBSCRIPTIONS_GRID_PLATE_NUMBER_GRID_AR'])[2]")
    private WebElement firstAccessServicePlateNumber;

    // Selected Fleet Option
    @FindBy(xpath = "//select[@id='bootstrap-duallistbox-selected-list_fleetdropdown']/option")
    private WebElement selectedFleetOption;

    // Vehicles Search Box
    @FindBy(xpath = "//input[@class='form-control filter round border-warning']")
    private WebElement vehiclesSearchBox;

    // X Mark Inside Truck Choosing Validation
    @FindBy(xpath = "//span[@class='swal2-x-mark']")
    private WebElement truckChoosingValidation;

    @FindBy(id = "industrialEstate")
    private WebElement industrialEstateDropDownList;

    // X Mark Inside Truck Choosing Validation
    @FindBy(xpath = "//a[@class='btn btn-outline-info round']")
    private WebElement genericCardsLocator;

    public SubscriptionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    ///////////////// Subscriptions Titles /////////////////

    public WebElement getFirstSubscriptionTitle() {

        functions.waitForElementToBeVisible(firstSubscriptionTitle);
        return firstSubscriptionTitle;
    }

    public WebElement getSecondSubscriptionTitle() {

        functions.waitForElementToBeVisible(secondSubscriptionTitle);
        return secondSubscriptionTitle;
    }

    public WebElement getThirdSubscriptionTitle() {

        functions.waitForElementToBeVisible(thirdSubscriptionTitle);
        return thirdSubscriptionTitle;
    }

    public WebElement getForthSubscriptionTitle() {

        functions.waitForElementToBeVisible(forthSubscriptionTitle);
        return forthSubscriptionTitle;
    }

    ///////////////// Access Periods /////////////////

    public String getFirstSubscriptionAccessPeriod() {

        functions.waitForElementToBeVisible(firstSubscriptionAccessPeriod);
        return functions.getTrimmedElementText(firstSubscriptionAccessPeriod);
    }

    public String getSecondSubscriptionAccessPeriod() {

        functions.waitForElementToBeVisible(secondSubscriptionAccessPeriod);
        return functions.getTrimmedElementText(secondSubscriptionAccessPeriod);
    }

    public String getThirdSubscriptionAccessPeriod() {

        functions.waitForElementToBeVisible(thirdSubscriptionAccessPeriod);
        return functions.getTrimmedElementText(thirdSubscriptionAccessPeriod);
    }

    public String getForthSubscriptionAccessPeriod() {

        functions.waitForElementToBeVisible(forthSubscriptionAccessPeriod);
        return functions.getTrimmedElementText(forthSubscriptionAccessPeriod);
    }

    ///////////////// Weigh In Periods /////////////////

    public String getFirstSubscriptionWeighInPeriod() {

        functions.waitForElementToBeVisible(firstSubscriptionWeighInPeriod);
        return functions.getTrimmedElementText(firstSubscriptionWeighInPeriod);
    }

    public String getSecondSubscriptionWeighInPeriod() {

        functions.waitForElementToBeVisible(secondSubscriptionWeighInPeriod);
        return functions.getTrimmedElementText(secondSubscriptionWeighInPeriod);
    }

    public String getThirdSubscriptionWeighInPeriod() {

        functions.waitForElementToBeVisible(thirdSubscriptionWeighInPeriod);
        return functions.getTrimmedElementText(thirdSubscriptionWeighInPeriod);
    }

    public String getForthSubscriptionWeighInPeriod() {

        functions.waitForElementToBeVisible(forthSubscriptionWeighInPeriod);
        return functions.getTrimmedElementText(forthSubscriptionWeighInPeriod);
    }

    ///////////////// Access Prices /////////////////

    public String getFirstSubscriptionAccessPrice() {

        functions.waitForElementToBeVisible(firstSubscriptionAccessPrice);
        return functions.getNumbersOutOfText(firstSubscriptionAccessPrice);
    }

    public String getSecondSubscriptionAccessPrice() {

        functions.waitForElementToBeVisible(secondSubscriptionAccessPrice);
        return functions.getNumbersOutOfText(secondSubscriptionAccessPrice);
    }

    public String getThirdSubscriptionAccessPrice() {

        functions.waitForElementToBeVisible(thirdSubscriptionAccessPrice);
        return functions.getNumbersOutOfText(thirdSubscriptionAccessPrice);
    }

    public String getForthSubscriptionAccessPrice() {

        functions.waitForElementToBeVisible(forthSubscriptionAccessPrice);
        return functions.getNumbersOutOfText(forthSubscriptionAccessPrice);
    }

    ///////////////// Weigh In Prices /////////////////

    public String getFirstSubscriptionWeighInPrice() {

        functions.waitForElementToBeVisible(firstSubscriptionWeighInPrice);
        return functions.getNumbersOutOfText(firstSubscriptionWeighInPrice);
    }

    public String getSecondSubscriptionWeighInPrice() {

        functions.waitForElementToBeVisible(secondSubscriptionWeighInPrice);
        return functions.getNumbersOutOfText(secondSubscriptionWeighInPrice);
    }

    public String getThirdSubscriptionWeighInPrice() {

        functions.waitForElementToBeVisible(thirdSubscriptionWeighInPrice);
        return functions.getNumbersOutOfText(thirdSubscriptionWeighInPrice);
    }

    public String getForthSubscriptionWeighInPrice() {

        functions.waitForElementToBeVisible(forthSubscriptionWeighInPrice);
        return functions.getNumbersOutOfText(forthSubscriptionWeighInPrice);
    }

    ///////////////// Subscribe Buttons /////////////////

    public void clickOnFirstPackageSubscribeButton() {

        functions.waitForElementToBeClickable(firstPackageSubscribeButton);
        functions.waitForElementToBeVisible(firstPackageSubscribeButton);
        firstPackageSubscribeButton.click();
        functions.waitForPageToLoad();
    }

    public void clickOnSecondPackageSubscribeButton() {

        functions.waitForElementToBeClickable(secondPackageSubscribeButton);
        secondPackageSubscribeButton.click();
    }

    public void clickOnThirdPackageSubscribeButton() {

        functions.waitForElementToBeClickable(thirdPackageSubscribeButton);
        thirdPackageSubscribeButton.click();
    }

    public void clickOnForthPackageSubscribeButton() {

        functions.waitForElementToBeClickable(forthPackageSubscribeButton);
        forthPackageSubscribeButton.click();
    }

    ///////////////// Select Value from Fleet Drop Down /////////////////

    public void selectValueFromFleetDropDown(int index) {

        functions.waitForElementToBeClickable(fleetDropDownList);
        functions.dropDownPickerByIndex(fleetDropDownList, index);
    }

    ///////////////// Move Selected Fleet Button /////////////////

    public void clickOnMoveSelectedFleetButton() {

        functions.waitForElementToBeClickable(moveSelectedFleetButton);
        moveSelectedFleetButton.click();
    }

    ///////////////// Move Selected Fleets Button /////////////////

    public void clickOnMoveSelectedFleetsButton() {

        functions.waitForElementToBeClickable(moveSelectedFleetsButton);
        moveSelectedFleetsButton.click();
    }

    ///////////////// Get Next Button /////////////////

    public WebElement getNextButton() {

        functions.waitForElementToBeClickable(nextButton);
        return nextButton;
    }

    ///////////////// Click on Next Button /////////////////

    public void clickOnNextButton() {

        functions.waitForElementToBeClickable(nextButton);
        nextButton.click();
        functions.waitForPageToLoad();
    }

    ///////////////// Number Of Vehicles Of First Order  /////////////////

    public int getNumberOfVehiclesForFirstOrder() {

        System.out.println("Looking for numberOfVehiclesForFirstOrder element .. ");
        functions.waitForElementToBeClickable(numberOfVehiclesForFirstOrder);
        int value = Integer.parseInt(functions.getNumbersOutOfText(numberOfVehiclesForFirstOrder));
        return value;
    }

    ///////////////// Get Total Price Value  /////////////////

    public int getTotalPriceValue() {

        functions.waitForElementToBeClickable(totalPriceValue);
        int value = Integer.parseInt(functions.getNumbersOutOfText(totalPriceValue));
        return value;
    }

    ///////////////// Credit Card Option  /////////////////

    public void selectCreditCardOption() {

        functions.waitForElementToBeClickable(creditCardOption);
        functions.waitForElementToBeVisible(creditCardOption);
        functions.waitForPageToLoad();
        creditCardOption.click();
    }

    ///////////////// Get Pay Button /////////////////

    public WebElement getPayButton() {

        System.out.println("Looking for payButton element .. ");
        functions.waitForElementToBeClickable(payButton);
        functions.waitForPageToLoad();
        return payButton;
    }

    ///////////////// Click on Pay Button /////////////////

    public void clickOnPayButton() {

        functions.waitForElementToBeClickable(payButton);
        payButton.click();
    }

    ///////////////// Click on Yes Confirmation Button /////////////////

    public void clickOnYesConfirmationButton() {

        functions.waitForElementToBeVisible(yesConfirmationButton);
        functions.waitForElementToBeClickable(yesConfirmationButton);
        yesConfirmationButton.click();
    }

    ///////////////// Click on POS Payment Option /////////////////

    public void selectPOSoption() {

        functions.waitForElementToBeClickable(posOption);
        posOption.click();
    }

    ///////////////// Fill Receipt Number Field /////////////////

    public void fillReceiptNumberFieldWith(String receiptNumberValue) {

        functions.waitForElementToBeClickable(receiptNumberField);
        receiptNumberField.sendKeys(receiptNumberValue);
    }

    ///////////////// Click on Balance Payment Option /////////////////

    public void selectBalanceoption() {

        functions.waitForElementToBeClickable(balanceOption);
        balanceOption.click();
    }

    ///////////////// Click on Subscriptions Section Button /////////////////

    public void clickOnSubscriptionsSectionButton() {

        functions.waitForElementToBeClickable(subscriptionsSectionButton);
        subscriptionsSectionButton.click();
        functions.waitForPageToLoad();
    }

    ///////////////// Get Fleet Drop-Down List /////////////////

    public WebElement getFleetDropDownList() {

        functions.waitForElementToBeVisible(fleetDropDownList);
        return fleetDropDownList;
    }

    ///////////////// Get Plates List /////////////////

    public WebElement getListedPlates() {

        functions.waitForElementToBeVisible(listedPlates);
        return listedPlates;
    }

    ///////////////// Click on Listed Plates /////////////////

    public void clickOnListedPlates() {

        functions.waitForElementToBeClickable(listedPlates);
        listedPlates.click();
    }

    ///////////////// Get Successful Message Text /////////////////

    public WebElement getSuccessfulMessageText() {

        functions.waitForElementToBeVisible(successMessage);
        return successMessage;
    }

    ///////////////// Get First Weigh In Service Plate Number /////////////////
    public WebElement getFirstWeighInServicePlateNumber() {

        functions.waitForElementToBeVisible(firstWeighInServicePlateNumber);
        return firstWeighInServicePlateNumber;
    }

    ///////////////// Get First Access Service Plate Number /////////////////
    public WebElement getFirstAccessServicePlateNumber() {

        functions.waitForElementToBeVisible(firstAccessServicePlateNumber);
        return firstAccessServicePlateNumber;
    }

    ///////////////// Get Selected Fleet Option /////////////////
    public WebElement getSelectedFleetList() {

        functions.waitForElementToBeVisible(selectedFleetOption);
        return selectedFleetOption;
    }

    ///////////////// Fill Search Vehicles Field /////////////////

    public void fillSearchVehiclesFieldWith(String vehicleNumber) {

        functions.waitForElementToBeClickable(vehiclesSearchBox);
        vehiclesSearchBox.sendKeys(vehicleNumber);
    }

    ///////////////// Click on Searched Plate /////////////////

    public void clickOnSearchedPlate() {

        functions.waitForElementToBeClickable(searchedPlate);
        searchedPlate.click();
    }

    ///////////////// Click on Searched Plate /////////////////

    public void clickOnFirstPackageSubscribeButtonOO() {

        functions.waitForElementToBeClickable(firstPackageSubscribeButtonOO);
        firstPackageSubscribeButtonOO.click();
    }

    ///////////////// Click on Searched Plate /////////////////

    public void clickOnFirstPackageSubscribeButtonSP() {

        functions.waitForElementToBeClickable(firstPackageSubscribeButtonSP);
        firstPackageSubscribeButtonSP.click();
    }

    ///////////////// Get Truck Choosing Validation /////////////////

    public WebElement getFleetChoosingValidation() {

        System.out.println("Looking for truckChoosingValidation element .. ");
        functions.waitForElementToBeVisible(truckChoosingValidation);
        return truckChoosingValidation;
    }

    public WebElement getIndustrialEstateDropDownList() {

        System.out.println("Looking for industrialEstateDropDownList element .. ");
        functions.waitForElementToBeVisible(industrialEstateDropDownList);
        functions.waitForElementToBeClickable(industrialEstateDropDownList);
        return industrialEstateDropDownList;
    }

    public void selectValueFromIndustrialEstateDropDown(String value) {

        functions.waitForElementToBeVisible(industrialEstateDropDownList);
        functions.waitForElementToBeClickable(industrialEstateDropDownList);
        functions.dropDownPickerByValue(industrialEstateDropDownList, value);
    }

    public WebElement getGenericCardsLocator() {

        System.out.println("Looking for genericCardsLocator element .. ");
        functions.waitForElementToBeVisible(genericCardsLocator);
        functions.waitForElementToBeClickable(genericCardsLocator);
        return genericCardsLocator;
    }
}
