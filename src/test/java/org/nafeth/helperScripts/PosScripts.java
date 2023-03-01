package org.nafeth.helperScripts;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.LoginPage;
import org.nafeth.pageModels.PointOfSalesTransactionsPage;
import org.nafeth.pageModels.SubscriptionsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PosScripts extends Configurations {

    @Parameters("language")
    @BeforeMethod(enabled = true)
    public void testsPrerequisites(String languageChosen) throws IOException {

        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth With A System User
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("systemUser"));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("qaPassword1"));

        loginPage.clickOnLoginButton();

        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");

        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }
    }

    @Parameters({"noOfReceipts" , "receiptAmount"})
    @Test(description = "Add POS Balances", enabled = true,  alwaysRun = true, priority = 1)
    public void addPosBalancesForUsers(int noOfReceipts, int receiptAmount) throws InterruptedException {

        String stringReceiptAmount = String.valueOf(receiptAmount);

        HomePage homePage = new HomePage(driver);
        PointOfSalesTransactionsPage pointOfSalesTransactionsPage = new PointOfSalesTransactionsPage(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        Functions functions = new Functions();

        homePage.clickOnMainMenuButton();
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnPointOfSalesTransactionButton();
        homePage.clickOnCreatePointOfSalesTransactionButton();

        for (int i = 0; i < noOfReceipts; i++) {

            long longRandomNumber = functions.generateRandomNumber(12);
            String stringRandomNumber = Long.toString(longRandomNumber);
            pointOfSalesTransactionsPage.getReceiptNumberField().sendKeys(stringRandomNumber);
            pointOfSalesTransactionsPage.getReceiptAmountField().sendKeys(stringReceiptAmount);
            Thread.sleep(1000);
            pointOfSalesTransactionsPage.clickOnCreateButton();
            Thread.sleep(500);
            subscriptionsPage.clickOnYesConfirmationButton();
            Thread.sleep(500);
            subscriptionsPage.clickOnYesConfirmationButton();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
