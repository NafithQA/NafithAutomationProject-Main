package org.nafeth.helpers;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listeners implements ITestListener {

    int testNumberInt = 0;

    public String getTestNum() {
        return testNum;
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    String testNum;

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailure(result);

        // Below code is to take screenshots on Failure
        String s = result.getName() + getTestNum(); // To know test case name and put it as the screenshot name
        try {
            Screenshots screenshots = new Screenshots();
            screenshots.getScreenshot(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestStart(result);
        testNumberInt++;
        testNum = String.valueOf(testNumberInt);
        setTestNum(testNum);
    }
}
