package org.nafeth.pageModels;

//import jdk.internal.net.http.common.Pair;
import org.nafeth.helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;

public class LoginPage {

    private Functions functions = new Functions();
    private DataLoader dataLoader = new DataLoader();
    private ExcelHandler excelHandler = new ExcelHandler();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "USERNAME")
    private WebElement userNameField;

    @FindBy(id = "PASSWORD")
    private WebElement passwordField;

    @FindBy(id = "Login_Btn")
    private WebElement loginButton;

    public WebElement getUserNameField(){
        return userNameField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

/*    public void fillUserNameFieldFromProperties(String userName) throws IOException {

        functions.waitForElementToBeClickable(userNameField);
        userNameField.sendKeys(dataLoader.credentialsData(userName));
    }

    public void fillPasswordFieldFromProperties(String password) throws IOException {

        functions.waitForElementToBeClickable(passwordField);
        passwordField.sendKeys(dataLoader.credentialsData(password));
    }

    public void fillUserAndPassFromDataBase(String query) {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        ArrayList<String> values = databaseHandler.getLoginDataFromDataBaseUsingQuery(query);

        System.out.println("UserName is " + values.get(0));
        System.out.println("Pass is " + values.get(1));
        System.out.println("PlateNo is " + values.get(2));
        System.out.println("PlateCodeEn is " + values.get(3));


    } */

/*    public void fillUserAndPassFromExcel(String hasTruck, String hasEquipment, String hasAffilication, String hasSubscription, String truckType) {

        functions.waitForElementToBeClickable(userNameField);
        Pair<String, Integer> credentials = excelHandler.getUserAndPass(hasTruck, hasEquipment, hasAffilication, hasSubscription, truckType);
        String userName = credentials.first;
        int password = credentials.second;

        userNameField.sendKeys(userName);
        passwordField.sendKeys(String.valueOf(password));
    } */

    public void clickOnLoginButton() {

        functions.waitForElementToBeClickable(loginButton);
        loginButton.click();
    }
}
