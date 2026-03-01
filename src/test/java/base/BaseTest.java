package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Attachment;
import org.testng.annotations.Listeners;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

//    @Attachment(value = "Screenshot on Failure", type = "image/png")
//    public byte[]  takeScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
//
    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Screenshot on Failure",
                    new ByteArrayInputStream(screenshot)
            );
        }

        if (driver != null) {
            driver.quit();
        }
    }
}