package org.nafeth.helperScripts;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.HomePage;
import org.nafeth.pageModels.LoginPage;
import org.nafeth.pageModels.PointOfSalesTransactionsPage;
import org.nafeth.pageModels.SubscriptionsPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PosScripts extends Configurations {

    @BeforeMethod(enabled = true)
    public void testsPrerequisites() throws IOException {

        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);

        functions.navigateToQaURL();

        // Login to Nafeth With A System User
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("systemUser"));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("systemPass"));

        loginPage.clickOnLoginButton();
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

            functions.dropDownPickerByIndex(pointOfSalesTransactionsPage.getIndustrialAreaDropDownList(), 2);
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
