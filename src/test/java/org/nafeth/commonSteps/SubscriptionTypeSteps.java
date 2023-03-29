package org.nafeth.commonSteps;

import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.CommonLocators;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.StakeholdersRegistrationPage;
import org.nafeth.pageModels.SubscriptionTypePage;
import org.openqa.selenium.WebDriver;

public class SubscriptionTypeSteps {

    WebDriver driver;

    public SubscriptionTypeSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFleetSubscriptionMenu() throws InterruptedException {

        Functions functions = new Functions();
        HomePage homePage = new HomePage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);

        homePage.clickOnMainMenuButton();
        functions.moveToElement(homePage.getMainNavigationMenu());
        homePage.clickOnSubscriptionsSectionButton();
        functions.scrollThePageDown();
        homePage.clickOnFleetSubscriptionsButton();
        functions.scrollThePageDown();
        homePage.clickOnCreateFleetSubscriptionsButton();
        Thread.sleep(8000);
        commonLocators.clickOnOwnedFleetChooseButton();
    }

    public void navigateToPackages() throws InterruptedException {

        CommonLocators commonLocators = new CommonLocators(driver);

        commonLocators.clickOnFirstAvailablePackageChooseButton();
        commonLocators.clickOnAccessServiceChooseButton();
        Thread.sleep(1000);
    }

    public void createFleetSubscription() throws InterruptedException {

        Functions functions = new Functions();
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        functions.dropDownPickerByIndex(subscriptionTypePage.getIndustrialEstateDropDownList(), 1);
        subscriptionTypePage.clickOnPackageOneMonthButton();
        subscriptionTypePage.clickOnchooseAnyTruck();
        subscriptionTypePage.clickOnSelectOneTruckToSubscribe();
        functions.scrollIntoElement(subscriptionTypePage.getNextButton());
        subscriptionTypePage.clickOnNextButton();
        Thread.sleep(750);
        functions.scrollThePageDown();
        subscriptionTypePage.selectBalanceoption();
        Thread.sleep(750);
    }
    public void proceedWithFinalRegistrationSteps() throws InterruptedException {

        Functions functions = new Functions();
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionTypePage subscriptionTypePage = new SubscriptionTypePage(driver);

        functions.scrollThePageDown();
        subscriptionTypePage.clickOnPayButton();
    }
}
