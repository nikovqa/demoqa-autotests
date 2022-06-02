package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeForm() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Gregor");
        $("#lastName").setValue("Zamza");
        $("#userEmail").setValue("gregor@zamza.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("3817513812");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label = 'Choose Wednesday, September 11th, 1991']").click();
        $(".subjects-auto-complete__input").click();

        $("#subjectsInput").sendKeys("Physics");
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("persone.jpeg");

        $("#currentAddress").setValue("F 12/8, Basement, Malviya Nagar");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("Gregor"),
                text("Zamza"),
                text("gregor@zamza.com"),
                text("Male"),
                text("11 September,1991"),
                text("Physics"),
                text("Music"),
                text("persone.jpeg"),
                text("F 12/8, Basement, Malviya Nagar"),
                text("NCR"),
                text("Delhi"));
    }

}