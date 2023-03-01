package org.nafeth.helpers;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

// This listener class is to help in generating HTML reports
public class ExtentReporterNG implements IReporter, ITestListener {

    public ExtentReports extent;
    ExtentSparkReporter htmlReporter;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
        LocalDateTime now = LocalDateTime.now();

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "test-output"
                + File.separator + "ExtentReports" + File.separator + "NafithAutomationReport" + "_" + dtf.format(now) + ".html");
       /* try {
            htmlReporter.loadXMLConfig(
                    System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "org" + File.separator + "nafeth" + File.separator +
                            "helpers" + File.separator + "extent-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } */

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.setReportUsesManualConfiguration(true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildFailedTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        for (String s : Reporter.getOutput()) {
            extent.addTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void buildTestNodes(IResultMap tests, Status status) {

        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable().getMessage());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));

            }
        }
    }

    private void buildFailedTestNodes(IResultMap tests, Status status) {

        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {

                test = extent.createTest(result.getMethod().getMethodName());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    // Log Failure Cause of Failed Test
                    test.log(status, result.getThrowable().getMessage());
                    test.log(status, result.getThrowable());

                    // Get Test Name
                /*    String videoTestName = result.getName() + ".mov";
                    System.out.println("TEST NAME IS : " + videoTestName);
                    File videoFileSource = new File(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "AllTestsVideos" + File.separator + videoTestName);
                    File videoFileDestination = new File(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "FailedTestsVideos" + File.separator + videoTestName);

                    try {
                        FileUtils.copyFile(videoFileSource, videoFileDestination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } */

                    // Attach Screenshot of Failed Test
//                    test.addScreenCaptureFromBase64String(Functions.encodeFileToBase64Binary(result), "Failure Screenshot");

                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}