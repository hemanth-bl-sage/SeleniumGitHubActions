package runner;

import com.lowes.framework.utilities.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On Test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On Test Failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On Test Percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On Test Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On Test Finish");
        ExtentReport.flushReport();
    }
}
