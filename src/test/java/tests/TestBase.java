package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.DemoqaPracticeFormPage;

import java.util.Map;

public class TestBase {
    TestData testData = new TestData();

    DemoqaPracticeFormPage demoqaPracticeFormPage = new DemoqaPracticeFormPage();

    @BeforeAll
    static void setConfig() {
        Configuration.browser = System.getProperty( "browserName", "chrome" );
        Configuration.browserVersion = System.getProperty( "browserVersion", "100.0" );
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty( "baseUrl","https://demoqa.com" );
        Configuration.remote = "https://user1:1234@" + System.getProperty( "selenoidUrl","selenoid.autotests.cloud/wd/hub" );


//        Configuration.pageLoadTimeout = 50000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
                ));
        Configuration.browserCapabilities = capabilities;


/*      ChromeOptions options = new ChromeOptions();
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
    void addAttachments(){
        Attach.screenshotAs( "last screenshot" );
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
