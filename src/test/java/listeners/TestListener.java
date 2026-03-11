package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest test = (BaseTest) result.getInstance();

        ScreenshotUtil.attachScreenshot(
                test.getDriver(),
                result.getName() + " Failed Screenshot"
        );
    }
}