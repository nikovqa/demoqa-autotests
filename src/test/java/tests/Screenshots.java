package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Screenshots {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshotAs() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs( OutputType.BYTES );
    }
}
