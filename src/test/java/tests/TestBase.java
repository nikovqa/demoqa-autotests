package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.DemoqaPracticeFormPage;

public class TestBase {
    TestData testData = new TestData();

    DemoqaPracticeFormPage demoqaPracticeFormPage = new DemoqaPracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 50000;
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
    void addScreenshot() {Screenshots.screenshotAs();}
}
