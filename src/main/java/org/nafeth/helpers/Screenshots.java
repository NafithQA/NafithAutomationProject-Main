package org.nafeth.helpers;

import org.apache.commons.io.FileUtils;
import org.nafeth.base.Configurations;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    WebDriver SsObject = Configurations.driver;

    public void getScreenshot(String s) throws IOException {

        File screenShot = ((TakesScreenshot) SsObject).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(
                System.getProperty("user.dir") + File.separator + "test-output"  + File.separator + "FailedTestsScreenshots"  + File.separator + s + ".png"));
    }
}
