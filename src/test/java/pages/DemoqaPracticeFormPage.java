package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaPracticeFormPage {

    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    PageBase pageBase = new PageBase();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public DemoqaPracticeFormPage openPage(){
        open("/automation-practice-form");
        pageBase.addRemove();
        pageBase.closeFooter();

        return this;
    }
    public DemoqaPracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);


        return this;
    }
    public DemoqaPracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;


    }
    public DemoqaPracticeFormPage setEmail(String value){
        $("#userEmail").setValue(value);

        return this;
    }
    public DemoqaPracticeFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }
    public DemoqaPracticeFormPage setPhoneNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
       calendarComponent.setDate(day,month,year);

        return this;
    }
    public DemoqaPracticeFormPage setSubject (String value){
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();

        return this;
    }
    public DemoqaPracticeFormPage chooseHobbies(String value ){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }
    public DemoqaPracticeFormPage uploadPicture(){
        $("#uploadPicture").uploadFromClasspath("persone.jpeg");

        return this;
    }
    public DemoqaPracticeFormPage setCurrentAdress (String value){
        $("#currentAddress").setValue(value);

        return this;
    }
    public DemoqaPracticeFormPage chooseState(String value ){
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public DemoqaPracticeFormPage chooseCity(String value ){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public DemoqaPracticeFormPage submitForm(){
        pageBase.clickSubmit();

        return this;
    }

    public DemoqaPracticeFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key,value);

        return this;
    }
}