package selenium.core.settings.framework;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestStatusListener extends ScreenManager implements ITestListener {

    final static Logger logger = Logger.getLogger(TestStatusListener.class);

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test case failed");
        try {

            FailedScreenshot(result.getName());

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
