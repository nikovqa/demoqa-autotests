package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.DemoqaPracticeFormPage;
import pages.components.ResultsTableComponent;

public class TestBase {
    TestData testData = new TestData();

    DemoqaPracticeFormPage demoqaPracticeFormPage = new DemoqaPracticeFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addScreenshot() {Screenshots.screenshotAs();}
}