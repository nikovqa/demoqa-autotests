package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.DemoqaPracticeFormPage;
import pages.components.ResultsTableComponent;

public class TestBase {

    DemoqaPracticeFormPage demoqaPracticeFormPage = new DemoqaPracticeFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}