package commons;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).driver;

            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Screenshot on Failure",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );
            }
        }
    }
}
