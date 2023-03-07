package org.nafeth.pageModels;

import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private Functions functions = new Functions();
    private DataLoader dataLoader = new DataLoader();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='ft-menu']")
    private WebElement mainMenuButton;

    @FindBy(xpath = "//i[@class='icon-present']")
    private WebElement subscriptionsSectionButton;

    @FindBy(xpath = "//i[@class='ft-edit']")
    private WebElement registrationSectionButton;

    @FindBy(xpath = "//i[@class='la la-cc-visa']")
    private WebElement financialSystemButton;

    @FindBy(xpath = "//ul[@class='menu-content']/li[@class='has-sub level-2 is-shown']/a/span")
    private WebElement fleetSubscriptionsButton;

    @FindBy(xpath = "(//ul[@class='menu-content']/li[@class='is-shown'])[1]")
    private WebElement fleetSubscriptionsPageButton;

    @FindBy(xpath = "(//ul[@class='menu-content']/li[@class='is-shown'])[2]")
    private WebElement createFleetSubscriptionsButton;

    @FindBy(xpath = "//li[@class='is-shown open']")
    private WebElement openedCreateFleetSubscriptionsButton;

    @FindBy(id = "dropdown-flag")
    private WebElement switchLanguageButton;

    @FindBy(xpath = "(//li[@class='has-sub level-2 is-shown'])[3]")
    private WebElement accountStatementButton;

    @FindBy(xpath = "(//ul[@class='menu-content']/li[@class='is-shown'])[1]")
    private WebElement accountStatementPageButton;

    @FindBy(id = "REMAINING_BALANCE")
    private WebElement remainingBalanceText;

    @FindBy(id = "input_GridPager")
    private WebElement gridPager;

    @FindBy(xpath = "//span[normalize-space()='Point Of Sales Transaction']")
    private WebElement pointOfSalesTransactionButton;

    @FindBy(xpath = "//span[normalize-space()='Create Point Of Sales Transaction']")
    private WebElement createPointOfSalesTransaction;

    @FindBy(xpath = "(//li[@class='nav-item has-sub open']/ul/li)[2]")
    private WebElement depositRequestsButton;

    @FindBy(xpath = "//li[@class='nav-item has-sub open']/ul/li/ul/li[@class='is-shown']")
    private WebElement depositRequestsPageButton;

    @FindBy(xpath = "(//li[@class='has-sub level-2 is-shown open']/ul/li)[2]")
    private WebElement addDepositsRequestButton;

    @FindBy(id = "user_name")
    private WebElement userNameIcon;

    @FindBy(id = "logOut_Btn")
    private WebElement logoutButton;

    @FindBy(xpath = "(//li[@class='has-sub level-2 is-shown'])[3]")
    private WebElement userRegistrationSectionButton;

    @FindBy(xpath = "//a[@href=\"javascript:ui.loadPage('USERS' , 'CREATE');\"]")
    private WebElement addUserRegistrationSectionButton;

    @FindBy(xpath = "//i[@class='ft-edit']")
    private WebElement registrationSystemMenu;

    @FindBy(xpath = "//i[@class='la la-truck menu-text-margin']")
    private WebElement registrationFleetMenu;

    @FindBy(xpath = "(//i[@class='fas fa-circle fa-xs'])[1]")
    private WebElement truckRegistrationMenu;

    @FindBy(xpath = "(//i[@class='fas fa-circle fa-xs'])[2]")
    private WebElement trailerRegistrationMenu;
    @FindBy(xpath = "(//i[@class='fas fa-circle fa-xs'])[3]")
    private WebElement equipmentsRegistrationMenu;

    @FindBy(xpath = "(//i[@class='fas fa-circle fa-xs'])[4]")
    private WebElement busesRegistrationMenu;

    @FindBy(xpath = "(//i[@class='fas fa-circle fa-xs'])[5]")
    private WebElement carsRegistrationMenu;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement trucksRegistrationPageButton;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement trailersRegistrationPageButton;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement equipmentsRegistrationPageButton;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement busesRegistrationPageButton;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement carsRegistrationPageButton;

    @FindBy(id = "main-menu-navigation")
    private WebElement mainNavigationMenu;

    @FindBy(xpath = "//div[@class='app-content content']")
    private WebElement mainAppContent;

    @FindBy(xpath = "//i[@class='ft-shuffle menu-text-margin']")
    private WebElement registrationStakeholderMenu;

    @FindBy(xpath = "(//li[@class='has-sub level-3 is-shown'])[2]")
    private WebElement truckingCompaniesRegistrationMenu;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement truckingCompaniesRegistrationPageButton;

    @FindBy(xpath = "(//li[@class='has-sub level-3 is-shown'])[1]")
    private WebElement investorsRegistrationMenu;

    @FindBy(xpath = "(//li[@class='is-shown'])[2]")
    private WebElement investorsRegistrationPageButton;


    public void clickOnMainMenuButton() {

        functions.waitForElementToBeVisible(mainMenuButton);
        functions.waitForElementToBeClickable(mainMenuButton);
        mainMenuButton.click();
    }

    public void clickOnSubscriptionsSectionButton() {

        functions.waitForElementToBeClickable(subscriptionsSectionButton);
        subscriptionsSectionButton.click();
    }

    public void clickOnFleetSubscriptionsButton() {

        functions.waitForElementToBeVisible(fleetSubscriptionsButton);
        functions.waitForElementToBeClickable(fleetSubscriptionsButton);
        fleetSubscriptionsButton.click();
    }

    public void clickOnFleetSubscriptionsPageButton() {

        functions.waitForElementToBeClickable(fleetSubscriptionsPageButton);
        fleetSubscriptionsPageButton.click();
    }

    public void clickOnCreateFleetSubscriptionsButton() {

        functions.waitForElementToBeClickable(createFleetSubscriptionsButton);
        createFleetSubscriptionsButton.click();
    }

    public void clickOnSwitchLanguageButton() {

        functions.waitForElementToBeClickable(switchLanguageButton);
        switchLanguageButton.click();
    }

    public WebElement getSwitchLanguageButton() {

        functions.waitForElementToBeClickable(switchLanguageButton);
        return switchLanguageButton;
    }

    public void clickOnFinancialSystemButton() {

        functions.waitForElementToBeVisible(financialSystemButton);
        functions.waitForElementToBeClickable(financialSystemButton);
        financialSystemButton.click();
    }

    public void clickOnAccountStatementButton() {

        functions.waitForElementToBeClickable(accountStatementButton);
        accountStatementButton.click();
    }

    public void clickOnAccountStatementPageButton() {

        functions.waitForElementToBeClickable(accountStatementPageButton);
        accountStatementPageButton.click();
    }

    public String getRemainingBalanceText() {

        functions.waitForElementToBeClickable(remainingBalanceText);
        functions.waitForPageToLoad();
        return remainingBalanceText.getText();
    }

    public String getRemainingBalance() {

        functions.waitForElementToBeClickable(remainingBalanceText);
        return functions.getNumbersOutOfText(remainingBalanceText);
    }

    public void clickOnPointOfSalesTransactionButton() {

        functions.waitForElementToBeClickable(pointOfSalesTransactionButton);
        pointOfSalesTransactionButton.click();
    }

    public void clickOnCreatePointOfSalesTransactionButton() {

        functions.waitForElementToBeClickable(createPointOfSalesTransaction);
        createPointOfSalesTransaction.click();
    }

    public void clickOnOpenedCreateFleetSubscriptionsButton() {

        functions.waitForElementToBeClickable(openedCreateFleetSubscriptionsButton);
        openedCreateFleetSubscriptionsButton.click();
    }

    public void clickOnDepositRequestsButton() {

        functions.waitForElementToBeClickable(depositRequestsButton);
        depositRequestsButton.click();
    }

    public void clickOnDepositRequestsPageButton() {

        functions.waitForElementToBeClickable(depositRequestsPageButton);
        depositRequestsPageButton.click();
    }

    public void clickOnAddDepositsRequestButton() {

        functions.waitForElementToBeClickable(addDepositsRequestButton);
        addDepositsRequestButton.click();
    }

    public void clickOnUserNameIcon() {

        functions.waitForElementToBeClickable(userNameIcon);
        userNameIcon.click();
    }

    public void clickOnLogoutButton() {

        functions.waitForElementToBeClickable(logoutButton);
        logoutButton.click();
    }

    public void clickOnRegistrationSectionButton() {

        functions.waitForElementToBeClickable(registrationSectionButton);
        registrationSectionButton.click();
    }

    public WebElement getRegistrationSectionButton() {

        functions.waitForElementToBeVisible(registrationSectionButton);
        return registrationSectionButton;
    }

    public void clickOnUsersRegistrationSectionButton() {

        functions.waitForElementToBeClickable(userRegistrationSectionButton);
        userRegistrationSectionButton.click();
    }

    public WebElement getUserRegistrationSectionButton() {

        functions.waitForElementToBeVisible(userRegistrationSectionButton);
        return userRegistrationSectionButton;
    }

    public void clickOnAddUsersRegistrationSectionButton() {

        functions.waitForElementToBeClickable(addUserRegistrationSectionButton);
        addUserRegistrationSectionButton.click();
    }

    public WebElement getAddUserRegistrationSectionButton() {

        functions.waitForElementToBeVisible(addUserRegistrationSectionButton);
        return addUserRegistrationSectionButton;
    }


    public void clickOnRegistrationSystemMenu() {

        functions.waitForElementToBeClickable(registrationSystemMenu);
        registrationSystemMenu.click();
    }
    public void clickOnRegistrationFleetMenu() {

        functions.waitForElementToBeClickable(registrationFleetMenu);
        registrationFleetMenu.click();
    }

    public void clickOnRegistrationTruckMenu() {

        functions.waitForElementToBeClickable(truckRegistrationMenu);
        truckRegistrationMenu.click();
    }

    public void clickOnTrucksRegistrationPageButton() {

        functions.waitForElementToBeClickable(trucksRegistrationPageButton);
        trucksRegistrationPageButton.click();
    }

    public void clickOnTrailersRegistrationMenu() {

        functions.waitForElementToBeClickable(trailerRegistrationMenu);
        trailerRegistrationMenu.click();
    }

    public void clickOnTrailersRegistrationPageButton() {

        functions.waitForElementToBeVisible(trailersRegistrationPageButton);
        trailersRegistrationPageButton.click();
    }

    public WebElement getTrailersRegistrationPageButton() {

        functions.waitForElementToBeVisible(trailersRegistrationPageButton);
        return trailersRegistrationPageButton;
    }
    public WebElement getMainNavigationMenu() {

        functions.waitForElementToBeVisible(mainNavigationMenu);
        return mainNavigationMenu;
    }

    public WebElement getMainAppContent() {

        functions.waitForElementToBeVisible(mainAppContent);
        return mainAppContent;
    }

    public void clickOnEquipmentsRegistrationMenu() {

        functions.waitForElementToBeClickable(equipmentsRegistrationMenu);
        equipmentsRegistrationMenu.click();
    }

    public void clickOnEquipmentsRegistrationPageButton() {

        functions.waitForElementToBeClickable(equipmentsRegistrationPageButton);
        equipmentsRegistrationPageButton.click();
    }
    public void clickOnBusesRegistrationMenu() {

        functions.waitForElementToBeClickable(busesRegistrationMenu);
        busesRegistrationMenu.click();
    }
    public void clickOnBusesRegistrationPageButton() {

        functions.waitForElementToBeClickable(busesRegistrationPageButton);
        busesRegistrationPageButton.click();
    }
    public void clickOnCarsRegistrationMenu() {
        functions.waitForElementToBeClickable(carsRegistrationMenu);
        carsRegistrationMenu.click();
    }
    public void clickOnCarsRegistrationPageButton() {
        functions.waitForElementToBeClickable(carsRegistrationPageButton);
        carsRegistrationPageButton.click();
    }

    public void waitForGridPager(){

        functions.waitForElementToBeVisible(gridPager);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnRegistrationStakeholderMenu() {

        functions.waitForElementToBeClickable(registrationStakeholderMenu);
        registrationStakeholderMenu.click();
    }
    public void clickOnTruckingCompaniesRegistrationMenu() {
        functions.waitForElementToBeClickable(truckingCompaniesRegistrationMenu);
        truckingCompaniesRegistrationMenu.click();
    }
    public void clickOnInvestorsRegistrationMenu() {
        functions.waitForElementToBeClickable(investorsRegistrationMenu);
        investorsRegistrationMenu.click();
    }
    public void clickOnTruckingCompaniesRegistrationPageButton() {

        functions.waitForElementToBeVisible(truckingCompaniesRegistrationPageButton);
        truckingCompaniesRegistrationPageButton.click();
    }
    public void clickOnInvestorsRegistrationPageButton() {

        functions.waitForElementToBeVisible(investorsRegistrationPageButton);
        investorsRegistrationPageButton.click();
    }

}
