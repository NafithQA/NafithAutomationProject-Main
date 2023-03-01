package org.nafeth.dynamicSolution;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Random implements ITest {

    @Test(dataProvider = "dataProvider")
    public void myTestMethod(String val) {
        System.out.println(val);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dpMethod() {

        return new Object[][]{{"First-Value"}, {"Second-Value"}};
    }

    @BeforeMethod
    public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
        if (testData.length > 0) {
            testName.set(method.getName() + "_" + testData[0]);
            ctx.setAttribute("testName", testName.get());
        } else
            ctx.setAttribute("testName", method.getName());
    }

    @Override
    public String getTestName() {
        return testName.get();
    }

    private ThreadLocal<String> testName = new ThreadLocal<>();
}