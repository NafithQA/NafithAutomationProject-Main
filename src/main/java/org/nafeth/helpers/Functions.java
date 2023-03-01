package org.nafeth.helpers;

import com.google.common.base.CharMatcher;
import org.apache.commons.codec.binary.Base64;
import org.nafeth.base.Configurations;
import org.nafeth.pageModels.SubscriptionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Functions extends Configurations {

    public void navigateToQaURL() throws IOException {

        driver.navigate().to(dataLoader.urlsData("newQaURL"));
        driver.manage().window().maximize();
    }

    // This function waits for an element until it is clickable
    public void waitForElementToBeClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // This function waits for an element until it is visible
    public void waitForElementToBeVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // This function gets the first part of a text splitted with a dash
    public String getFirstPartOfTextSplittedWithDash(String text) {

        String[] parts = text.split("-");
        String splittedText = parts[0].trim();
        return splittedText;
    }

    // This function gets a specific part of a text based on given separator
    public String getPartOfTextAfterSeparator(String text, String separator) {

        String[] parts = text.split(separator);
        String splittedText = parts[0].trim();
        return splittedText;
    }

    // This function gets the text of an element
    public String getElementText(WebElement element) {

        String text = element.getText();
        return text;
    }

    // This function gets a trimmed text of an element
    public String getTrimmedElementText(WebElement element) {

        String text = element.getText().trim();
        return text;
    }

    // This function gets numbers out of a text String
    public String getNumbersOutOfText(WebElement element) {

        return CharMatcher.inRange('0', '9').retainFrom(element.getText());
    }

    // This function picks an option from a Drop Down by index
    public void dropDownPickerByIndex(WebElement element, int index) {

        Select dropDown = new Select(element);
        dropDown.selectByIndex(index);
    }

    // This function picks an option from a Drop Down by value
    public void dropDownPickerByValue(WebElement element, String value) {

        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    // This function picks an option from a Drop Down by value
    public void dropDownPickerByVisibleText(WebElement element, String text) {

        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    // This function Scrolls into an element
    public void scrollIntoElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollIntoElementAndClickOnIt(WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    // This function scroll using X,Y axis
    public void scrollUsingXYaxis(int x, int y) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    // This function scrolls the page all the way Up
    public void scrollThePageUp() throws InterruptedException {

        Thread.sleep(750);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(750);
    }

    // This function scrolls the page all the way Up
    public void scrollThePageDown() throws InterruptedException {

        Actions actions = new Actions(driver);
        Thread.sleep(750);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(750);
    }

    // This function Waits for the page until it is fully loaded
    public void waitForPageToLoad() {

        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // This function Refresh the current page
    public void refreshPage() {

        driver.navigate().refresh();
    }

    public void selectDropDownDataFromDataBaseDynamically(ArrayList<String> userAndPassAndFleetArray) {

        // Select fleet from UI based on DataBase
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(driver);

        String[] fleetNumberFromUI = null;
        String fleetNumberFromDataBase = userAndPassAndFleetArray.get(2);
        System.out.println("Fleet from DB : " + fleetNumberFromDataBase);

        List<WebElement> listElement = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_fleetdropdown']"));

        for (int i = 0; i < listElement.size(); i++) {
            fleetNumberFromUI = listElement.get(i).getText().split(" ");
            System.out.println("Fleet " + i + " : " + fleetNumberFromUI[0]);
            System.out.println("Fleet " + i + " EN CODE : " + fleetNumberFromUI[1] + fleetNumberFromUI[2]);
            System.out.println("Fleet " + i + " AR CODE : " + fleetNumberFromUI[3] + fleetNumberFromUI[4]);

            if (fleetNumberFromUI[0].contains(fleetNumberFromDataBase)) {
                System.out.println("Value " + fleetNumberFromUI[0] + " is found ... ");
                dropDownPickerByVisibleText(subscriptionsPage.getFleetDropDownList(), fleetNumberFromUI[0] + fleetNumberFromUI[1] + fleetNumberFromUI[2] + fleetNumberFromUI[3] + fleetNumberFromUI[4]);
//                break;
            }
        }
    }

    public long generateRandomNumber(int length) {

        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public String generateRandomDate(String dateTime) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date myCurrentDate = new Date(System.currentTimeMillis());
        Date twentyDaysBeforeToday = null;
        String finalFormattedDate;

        switch (dateTime) {
            case "PAST":
                twentyDaysBeforeToday = new Date(myCurrentDate.getTime() - (20 * 24 * 60 * 60 * 1000));
                break;

            case "FUTURE":
                twentyDaysBeforeToday = new Date(myCurrentDate.getTime() + (20 * 24 * 60 * 60 * 1000));
                break;
        }

        finalFormattedDate = dateFormat.format(twentyDaysBeforeToday);
        return finalFormattedDate;
    }

    public static String encodeFileToBase64Binary(ITestResult result) {

        Listeners listeners = new Listeners();
        String screenshotName = result.getName() + listeners.getTestNum() + ".png";

        File file = new File(System.getProperty("user.dir") + File.separator + "test-output"
                + File.separator + "FailedTestsScreenshots" + File.separator + screenshotName);

        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encodedfile;
    }

    public void moveToElement(WebElement element) throws InterruptedException {

        Thread.sleep(750);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void moveToElementAndClickOnIt(WebElement element) throws InterruptedException {

        Thread.sleep(750);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
}
