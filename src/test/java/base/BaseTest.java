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
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");   // IMPORTANT
        options.addArguments("--no-sandbox");     // REQUIRED in CI
        options.addArguments("--disable-dev-shm-usage"); // PREVENT CRASH
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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