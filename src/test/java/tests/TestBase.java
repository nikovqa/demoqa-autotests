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
        Configuration.baseUrl = System.getProperty( "base_url","https://demoqa.com" );
        Configuration.browserSize = System.getProperty("browser_size");
        Configuration.browser = System.getProperty( "browser", "opera" );
        Configuration.browserVersion = System.getProperty( "browser_version" );
        Configuration.remote = "https://user1:1234@" + System.getProperty( "selenoid_url","selenoid.autotests.cloud/wd/hub" );


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
