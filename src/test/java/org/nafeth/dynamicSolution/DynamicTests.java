package org.nafeth.dynamicSolution;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.*;
import org.nafeth.helpers.Queries.OtherQueries;
import org.nafeth.pageModels.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicTests extends Configurations {

    int testCounter = 0;

    // Dynamic Test Method
    @Test(dataProvider = "dataProvider", description = "DYNAMIC_SUBSCRIPTIONS_TEST", enabled = true)
    public void DYNAMIC_TEST(String query) throws IOException, InterruptedException {

        testCounter++;
        System.out.println("This is Test Number " + testCounter);

        ArrayList<String> testData;
        int remainingBalance = 0;
        int integerPaymentMethodFromDBInteger = 0;
        String secondQuery;
        String userName;
        String password;
        String packageCodeFromUI;
        String packageCodeFromDB = null;
        String packageServiceCodeFromUI;
        String packageServiceCodeFromDB;
        String paymentMethodFromDB;
        String selectedServiceCodeFromUI;
        String selectedServiceCodeFromDB;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Functions functions = new Functions();
        LoginPage loginPage = new LoginPage(driver);
        CommonLocators commonLocators = new CommonLocators(driver);
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);
        CreditPaymentPage creditPaymentPage = new CreditPaymentPage(driver);
        HomePage homePage = new HomePage(driver);
        DataLoader dataLoader = new DataLoader();

        System.out.println("Query is : " + query);

        // Navigate to Nafith Portal
        functions.navigateToQaURL();

        // Get Test Data from the Query
        secondQuery = query;
        testData = databaseHandler.getTestDataUsingQuery(secondQuery);
        System.out.println("Test Data is : " + testData);

        // Assert On Pulled Test Data
        if (testData.isEmpty()) {
            Assert.assertFalse(true, "There is no Test Data for Test Number " + testCounter);
        }

        // Get Payment Method and convert it into Integer
        paymentMethodFromDB = testData.get(6);
        integerPaymentMethodFromDBInteger = Integer.parseInt(paymentMethodFromDB);
        System.out.println("Payment Method from DB is : " + integerPaymentMethodFromDBInteger);

        // Login Steps
        functions.waitForElementToBeClickable(loginPage.getUserNameField());
        userName = testData.get(0);
        loginPage.getUserNameField().sendKeys(userName);
        functions.waitForElementToBeClickable(loginPage.getPasswordField());
        password = testData.get(1);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);

        String languageChosen = System.getProperty("language");

        // Language Setup
        String languageButtonValue = homePage.getSwitchLanguageButton().getAttribute("onclick");
        if (languageChosen.equalsIgnoreCase("english") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('EN')")) {
            homePage.clickOnSwitchLanguageButton();
        } else if (languageChosen.equalsIgnoreCase("arabic") && languageButtonValue.equalsIgnoreCase("ui.changeLanguage('AR')")) {
            homePage.clickOnSwitchLanguageButton();
        }

        // Get Remaining Balance
        if (integerPaymentMethodFromDBInteger == 5) {
            homePage.clickOnMainMenuButton();
            Thread.sleep(3000);
            homePage.clickOnFinancialSystemButton();
            homePage.clickOnAccountStatementButton();
            homePage.clickOnAccountStatementPageButton();
            homePage.waitForGridPager();
            Thread.sleep(3000);

            remainingBalance = Integer.parseInt(homePage.getRemainingBalance());
            System.out.println("Remaining Balance is : " + remainingBalance);
            functions.refreshPage();
        }

        homePage.clickOnMainMenuButton();
        homePage.clickOnSubscriptionsSectionButton();
        homePage.clickOnFleetSubscriptionsButton();
        homePage.clickOnCreateFleetSubscriptionsButton();

        Thread.sleep(5000);

        // Collecting Number of Cards in Available Services Section
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-outline-info round']")));
        List<WebElement> list1 = driver.findElements(By.xpath("//a[@class='btn btn-outline-info round']"));
        int availableServicesCardsCount = list1.size();
        System.out.println("Available Services Cards Count is " + availableServicesCardsCount);

        for (int i = 0; i < availableServicesCardsCount; i++) {
            int k = i + 1;
            System.out.println("Available Services Element " + k + " is " + list1.get(i).getAttribute("auto_id"));
            k++;
        }

        commonLocators.clickOnOwnedFleetChooseButton();

        // Collecting Number of Cards in Categories Section
        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='flaticon-truck pink font-large-2 float-right']")));
        functions.scrollUsingXYaxis(0, 200);
        List<WebElement> list2 = driver.findElements(By.xpath("//a[@class='btn btn-outline-info round']"));
        int cardsCountUntilCategoriesSection = list2.size();
        System.out.println("Cards Count Until Categories Section is " + cardsCountUntilCategoriesSection);

        for (int i = availableServicesCardsCount; i < list2.size(); i++) {
            int k = i + 1;
            System.out.println("Category Element " + k + " is " + list2.get(i).getAttribute("auto_id"));
            k++;
        }

        // Choosing a Registered Fleet Subscription Service based on Package Code
        for (int i = availableServicesCardsCount + 1; i <= cardsCountUntilCategoriesSection; i++) {

            packageCodeFromUI = driver.findElement(By.xpath("(//a[@class='btn btn-outline-info round'])[" + i + "]")).getAttribute("auto_id");
            packageCodeFromDB = testData.get(7).trim();
            System.out.println("Package Code From UI Is : " + packageCodeFromUI);
            System.out.println("Package Code From DB Is : " + packageCodeFromDB);

            if (packageCodeFromUI.equalsIgnoreCase(packageCodeFromDB)) {
                driver.findElement(By.xpath("//a[@auto_id='" + packageCodeFromUI + "']")).click();
                break;
            }
        }

        Thread.sleep(3000);

        // Collecting Number of Cards in Service Type Section
        WebDriverWait wait3 = new WebDriverWait(driver, 15);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='flaticon-industrial-scale pink font-large-2 float-right']")));
        List<WebElement> list3 = driver.findElements(By.xpath("//a[@class='btn btn-outline-info round']"));
        int cardsCountUntilServiceTypeSection = list3.size();
        System.out.println("Cards Count Until Service Type Section is " + cardsCountUntilServiceTypeSection);

        for (int i = cardsCountUntilCategoriesSection; i < list3.size(); i++) {
            int k = i + 1;
            System.out.println("Service Type Element " + k + " is " + list3.get(i).getAttribute("auto_id"));
            k++;
        }

        // Choosing Available Services based on Selected Service Code
        for (int i = cardsCountUntilCategoriesSection + 1; i <= cardsCountUntilServiceTypeSection; i++) {

            selectedServiceCodeFromUI = driver.findElement(By.xpath("(//a[@class='btn btn-outline-info round'])[" + i + "]")).getAttribute("auto_id");
            selectedServiceCodeFromDB = testData.get(9).trim();
            System.out.println("Selected Service Code From UI Is : " + selectedServiceCodeFromUI);
            System.out.println("Selected Service Code From DB Is : " + selectedServiceCodeFromDB);

            if (selectedServiceCodeFromUI.equalsIgnoreCase(selectedServiceCodeFromDB)) {
                driver.findElement(By.xpath("//a[@auto_id='" + selectedServiceCodeFromUI + "']")).click();
                break;
            }
        }

        Thread.sleep(3000);

        // Collecting Number of Cards in Service Type Section
        WebDriverWait wait4 = new WebDriverWait(driver, 15);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-industrialEstate-container")));
        List<WebElement> list4 = driver.findElements(By.xpath("//a[@class='btn btn-outline-info round']"));
        int cardsCountUntilSubscriptionsSection = list4.size();
        System.out.println("Cards Count Until Subscriptions Section is " + cardsCountUntilSubscriptionsSection);

        for (int i = cardsCountUntilCategoriesSection; i < list4.size(); i++) {
            int k = i + 1;
            System.out.println("Subscriptions Element " + k + " is " + list4.get(i).getAttribute("auto_id"));
            k++;
        }

        // Choosing Industrial Estate
        String industrialEstateValue = testData.get(10);
        subscriptionsPage.selectValueFromIndustrialEstateDropDown(industrialEstateValue);

        // Choosing Available Services based on Package Service Code
        for (int i = cardsCountUntilServiceTypeSection + 1; i <= cardsCountUntilSubscriptionsSection; i++) {

            packageServiceCodeFromUI = driver.findElement(By.xpath("(//a[@class='btn btn-outline-info round'])[" + i + "]")).getAttribute("auto_id");
            packageServiceCodeFromDB = testData.get(8).trim();
            System.out.println("Package Service Code From UI Is : " + packageServiceCodeFromUI);
            System.out.println("Package Service Code From DB Is : " + packageServiceCodeFromDB);

            if (packageServiceCodeFromUI.equalsIgnoreCase(packageServiceCodeFromDB)) {
                driver.findElement(By.xpath("//a[@auto_id='" + packageServiceCodeFromUI + "']")).click();
                break;
            }
        }

        Thread.sleep(3000);

        // Fleet Selection Section
        functions.waitForElementToBeClickable(subscriptionsPage.getFleetDropDownList());

        subscriptionsPage.fillSearchVehiclesFieldWith(testData.get(3));
        subscriptionsPage.clickOnMoveSelectedFleetsButton();

        subscriptionsPage.clickOnMoveSelectedFleetsButton();
        functions.scrollIntoElement(subscriptionsPage.getNextButton());
        subscriptionsPage.clickOnNextButton();
    
        Thread.sleep(2000);

        // Assert On Fleet Availability Validation
        try {
            driver.findElement(By.xpath("//span[@class='swal2-x-mark']"));
            Assert.assertFalse(true, "Fleet Being Searched For Was Not Found ... ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Select Related Shopping Carts
        List<WebElement> addServiceList = driver.findElements(By.xpath("//i[@title='Add service']"));
        for (int i = 0; i < addServiceList.size(); i++) {

            String autoIdAttribute = addServiceList.get(i).getAttribute("auto_id");
            if (autoIdAttribute.equalsIgnoreCase(packageCodeFromDB)) {
                driver.findElement(By.xpath("//i[@auto_id='" + packageCodeFromDB + "']")).click();
                break;
            }
        }

        // Get Total Price and Store it
        int totalPrice = (Integer.parseInt(dataLoader.testData("FirstSubscriptionAccessPrice"))
                + Integer.parseInt(dataLoader.testData("FirstSubscriptionWeighInPrice")))
                * subscriptionsPage.getNumberOfVehiclesForFirstOrder();
        System.out.println("Total Price is : " + totalPrice);

        functions.scrollIntoElement(subscriptionsPage.getPayButton());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Switch Payment Methods based on Payment Code from DB
        switch (integerPaymentMethodFromDBInteger) {

            // Invoice
            case 1:

                // Pre-Paid
            case 2:

                // Credit Card
            case 3:
                subscriptionsPage.selectCreditCardOption();
                commonLocators.checkAgreementCheckbox();
                subscriptionsPage.clickOnPayButton();
                Thread.sleep(3000);
                subscriptionsPage.clickOnYesConfirmationButton();

                creditPaymentPage.fillCreditCardNumberFieldWith(dataLoader.testData("CreditCardNumber"));
                creditPaymentPage.selectExpiryMonthDateAs(dataLoader.testData("ExpDateMonth"));
                creditPaymentPage.selectExpiryYearDateAs(dataLoader.testData("ExpDateYear"));
                creditPaymentPage.fillCardHolderNameFieldWith(dataLoader.testData("CardHoldersName"));
                creditPaymentPage.fillCvvNumberFieldWith(dataLoader.testData("CVV"));
                creditPaymentPage.clickOnPayButton();
                if (creditPaymentPage.getProceedAnyWayButton().isDisplayed()) {
                    creditPaymentPage.clickOnProceedAnyWayButton();
                }
                Assert.assertTrue(subscriptionsPage.getSuccessfulMessageText().isDisplayed());
                break;

            // Bank Deposit
            case 4:

                // From Balance
            case 5:
                subscriptionsPage.selectBalanceoption();
                commonLocators.checkAgreementCheckbox();
                functions.scrollIntoElement(subscriptionsPage.getPayButton());
                subscriptionsPage.clickOnPayButton();
                Thread.sleep(3000);
                subscriptionsPage.clickOnYesConfirmationButton();
                Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());

                // Verify remaining balance
                creditPaymentPage.clickOnCancelAddMoreButton();
                functions.refreshPage();
                homePage.clickOnMainMenuButton();
                homePage.clickOnFinancialSystemButton();
                homePage.clickOnAccountStatementButton();
                homePage.clickOnAccountStatementPageButton();
                homePage.waitForGridPager();
                int remainingBalanceAfterTransaction = Integer.parseInt(homePage.getRemainingBalance());
                System.out.println("Remaining Balance is : " + remainingBalance);
                System.out.println("Remaining Balance after Transaction is : " + remainingBalanceAfterTransaction);
                Assert.assertEquals(remainingBalance - totalPrice, remainingBalanceAfterTransaction);
                break;

            // Point of Sale
            case 6:
                subscriptionsPage.selectPOSoption();
                ArrayList<String> validRnnArray;
                validRnnArray = databaseHandler.getValidRnnFromDataBase(OtherQueries.validRnnQuery);

                subscriptionsPage.fillReceiptNumberFieldWith(validRnnArray.get(0));
                commonLocators.checkAgreementCheckbox();
                functions.scrollIntoElement(subscriptionsPage.getPayButton());
                subscriptionsPage.clickOnPayButton();
                Thread.sleep(3000);
                subscriptionsPage.clickOnYesConfirmationButton();
                Assert.assertTrue(commonLocators.getSuccessPaymentMessage().isDisplayed());
                break;
        }
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dpMethod() throws IOException {

        // Build sql server jdbc connection url use sql server account authentication.
        String host = "82.212.90.190";
        String dbName = "QA_MAMS";
        String connectionUserName = "omantcs";
        String connectionPassword = "123456";

        String sqlServerConnectionUrl = "jdbc:sqlserver://" + host + ";databaseName=" + dbName + ";user=" + connectionUserName + ";password=" + connectionPassword + "";

        // Declare the JDBC objects.
        Connection dbConnection = null;
        Connection dbConnection1 = null;
        Statement statement = null;
        Statement statement1 = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        ArrayList<String> testCaseQueryResultSet = null;

        List<String> returnedResultSet = new ArrayList<String>();

        String id = null;
        String testScenarioId = null;
        String testCaseId = null;
        String testCaseQuery = null;
        String testType = null;

        int rowCount = 0;
        int columnCount = 0;

        try {
            // Get connection.
            dbConnection = DriverManager.getConnection(sqlServerConnectionUrl);
            dbConnection1 = DriverManager.getConnection(sqlServerConnectionUrl);

            // Execute sql and return data result.
            String SQL = OtherQueries.testsInformationsQuery;
            statement = dbConnection.createStatement();
            statement1 = dbConnection1.createStatement();
            resultSet = statement.executeQuery(SQL);
            resultSet1 = statement1.executeQuery(SQL);

            ResultSetMetaData resultSet_metaData = resultSet1.getMetaData();
            columnCount = resultSet_metaData.getColumnCount();

            // Get Row Count
            while (resultSet1.next()) {
                rowCount++;
            }

            System.out.println("Column Count is : " + columnCount);
            System.out.println("Row Count is : " + rowCount);

            // ArrayLists to store column's results sets
            ArrayList<String> idResultSet = new ArrayList<String>();
            ArrayList<String> testScenarioIdResultSet = new ArrayList<String>();
            ArrayList<String> testCaseIdResultSet = new ArrayList<String>();
            testCaseQueryResultSet = new ArrayList<String>();
            ArrayList<String> testTypeResultSet = new ArrayList<String>();

            // Loop the data result and display the data.
            while (resultSet.next()) {

                // Storing results sets into ArrayLists
                id = String.valueOf(idResultSet.add(resultSet.getString("id")));
                testScenarioId = String.valueOf(testScenarioIdResultSet.add(resultSet.getString("test_scenario_id")));
                testCaseId = String.valueOf(testCaseIdResultSet.add(resultSet.getString("test_case_id")));
                testCaseQuery = String.valueOf(testCaseQueryResultSet.add(resultSet.getString("test_case_query")));
                testType = String.valueOf(testTypeResultSet.add(resultSet.getString("test_type")));
            }

            for (int i = rowCount - 1; i >= 0; i--) {

                returnedResultSet.add(testCaseQueryResultSet.get(i));
          /*      // Adding all results sets into the main returnedResultSet to be returned to the requester
                returnedResultSet.add(idResultSet.get(i));
                returnedResultSet.add(testScenarioIdResultSet.get(i));
                returnedResultSet.add(testCaseIdResultSet.get(i));

                returnedResultSet.add(testTypeResultSet.get(i));

                // Printing values of results sets
                System.out.println("ID : " + idResultSet.get(i));
                System.out.println("TEST_SCENARIO_ID : " + testScenarioIdResultSet.get(i));
                System.out.println("TEST_CASE_ID : " + testCaseIdResultSet.get(i));
                System.out.println("TEST_CASE_QUERY : " + testCaseQueryResultSet.get(i));
                System.out.println("TEST_TYPE : " + testTypeResultSet.get(i));
                queriesPrintedCount++;
                int size = returnedResultSet.size();
                System.out.println("Returned Result Set Size is : " + size); */
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (resultSet1 != null) {
                try {
                    resultSet1.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        ExcelHandler excelHandler = new ExcelHandler();
        excelHandler.clearDataFromExcel(testCaseQueryResultSet);
        excelHandler.writeDataOnExcel(testCaseQueryResultSet);

        Object[][] arrObj = excelHandler.getQueriesExcelData(
                System.getProperty("user.dir")
                        + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                        + File.separator + "testData" + File.separator + "queriesData.xlsx",
                "Sheet1");
        return arrObj;
    }

    // This is a logger method to log subscriptions information's during run time
    public void logSubscriptionsInformations() {

        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);

        System.out.println("1st Access period : " + subscriptionsPage.getFirstSubscriptionAccessPeriod());
        System.out.println("1st Access price : " + subscriptionsPage.getFirstSubscriptionAccessPrice());
        System.out.println("1st Weigh In period : " + subscriptionsPage.getFirstSubscriptionWeighInPeriod());
        System.out.println("1st Weigh In price : " + subscriptionsPage.getFirstSubscriptionWeighInPrice());

        System.out.println("2nd Access period : " + subscriptionsPage.getSecondSubscriptionAccessPeriod());
        System.out.println("2nd Access price : " + subscriptionsPage.getSecondSubscriptionAccessPrice());
        System.out.println("2nd Weigh In period : " + subscriptionsPage.getSecondSubscriptionWeighInPeriod());
        System.out.println("2nd Weigh In price : " + subscriptionsPage.getSecondSubscriptionWeighInPrice());

        System.out.println("3rd Access period : " + subscriptionsPage.getThirdSubscriptionAccessPeriod());
        System.out.println("3rd Access price : " + subscriptionsPage.getThirdSubscriptionAccessPrice());
        System.out.println("3rd Weigh In period : " + subscriptionsPage.getThirdSubscriptionWeighInPeriod());
        System.out.println("3rd Weigh In price : " + subscriptionsPage.getThirdSubscriptionWeighInPrice());

        System.out.println("4th Access period : " + subscriptionsPage.getForthSubscriptionAccessPeriod());
        System.out.println("4th Access price : " + subscriptionsPage.getForthSubscriptionAccessPrice());
        System.out.println("4th Weigh In period : " + subscriptionsPage.getForthSubscriptionWeighInPeriod());
        System.out.println("4th Weigh In price : " + subscriptionsPage.getForthSubscriptionWeighInPrice());
    }
}
