package org.nafeth.pageModels;

//import jdk.internal.net.http.common.Pair;

import org.nafeth.base.Configurations;
import org.nafeth.helpers.DataLoader;
import org.nafeth.helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPage extends Configurations {

    private Functions functions = new Functions();
    private DataLoader dataLoader = new DataLoader();

    public RegPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "USERNAME")
    private WebElement userNameField;

    public WebElement getUserNameField(){

        return userNameField;
    }
}
