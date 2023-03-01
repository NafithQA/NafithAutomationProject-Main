package org.nafeth.dynamicSolution;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.Functions;
import org.nafeth.pageModels.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RandomTest extends Configurations {

    @Test(enabled = false)
    public void randomTest() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Functions functions = new Functions();
        AddDepositsRequestPage addDepositsRequestPage = new AddDepositsRequestPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);

        functions.navigateToQaURL();
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("qaUserName1"));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("qaPassword1"));
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);

        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();
        homePage.clickOnDepositRequestsButton();
        homePage.clickOnAddDepositsRequestButton();
        addDepositsRequestPage.clickOnTransactionTypeDropDownList();
        addDepositsRequestPage.clickOnCashDepositOption();
        addDepositsRequestPage.clickOnBankNameDropDownList();
        addDepositsRequestPage.clickOnSecondOption();
        addDepositsRequestPage.fillDepositAmountFieldWith("100");
        addDepositsRequestPage.clickOnDepositDateCalendar();
        addDepositsRequestPage.clickOnCurrentCalendarDayButton();

        long randomReferenceNumber = functions.generateRandomNumber(5);
        String stringRandomReferenceNumber = Long.toString(randomReferenceNumber);
        addDepositsRequestPage.fillReferenceNumberFieldWith(stringRandomReferenceNumber);

        addDepositsRequestPage.clickOnAttachmentTab();
        addDepositsRequestPage.clickOnAttachmentIcon();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\lenovo\\Documents\\FileUploadScript.exe",null,new File("C:\\Users\\lenovo\\Documents\\"));
        functions.scrollIntoElement(commonLocators.getAgreementCheckbox());
        commonLocators.checkAgreementCheckbox();
        addDepositsRequestPage.clickOnCreateButton();
        subscriptionsPage.clickOnYesConfirmationButton();
        creditPaymentPage.clickOnCancelAddMoreButton();

        // New Tab Code - Admin Steps
//        ((JavascriptExecutor)driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));

        homePage.clickOnUserNameIcon();
        homePage.clickOnLogoutButton();

        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().clear();
        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("systemUser"));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().clear();
        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("qaPassword1"));
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);

        homePage.clickOnMainMenuButton();
        Thread.sleep(3000);
        homePage.clickOnFinancialSystemButton();


        Thread.sleep(5000);
        driver.quit();
    }

    @Test(enabled = true)
    public void randomTest1() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Functions functions = new Functions();
        AddDepositsRequestPage addDepositsRequestPage = new AddDepositsRequestPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);

        functions.navigateToQaURL();
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        loginPage.getUserNameField().sendKeys(dataLoader.credentialsData("qaUserName1"));
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        loginPage.getPasswordField().sendKeys(dataLoader.credentialsData("qaPassword1"));
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);




        Thread.sleep(5000);
        driver.quit();
    }
}
