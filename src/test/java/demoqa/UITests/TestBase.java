package demoqa.UITests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import demoqa.pages.DemoqaPracticeFormPage;

import java.util.Map;

public class TestBase {
    TestData testData = new TestData();

    DemoqaPracticeFormPage demoqaPracticeFormPage = new DemoqaPracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadTimeout = 50000;
//        Configuration.browserVersion = "100.0";

        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
                ));
        Configuration.browserCapabilities = capabilities;

/*

        Configuration.browserSize = System.getProperty("browser_size");
        Configuration.baseUrl = System.getProperty("base_url","https://demoqa.com");
        Configuration.browser =  System.getProperty ("browser","chrome");
        Configuration.browserVersion =  System.getProperty("browser_version");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url","selenoid.autotests.cloud/wd/hub");
*/


/*        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--remote-allow-origins=*" );
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);*/


    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    //void addScreenshot() {Screenshots.screenshotAs();}
    void addAttachments(){
        Attach.screenshotAs( "last screenshot" );
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
