package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DemoqaPracticeFormPage {

    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    PageBase pageBase = new PageBase();

    SelenideElement firstNameInput = $( "#firstName" ),
            lastNameInput = $( "#lastName" );

    public DemoqaPracticeFormPage openPage() {
        step( "Open form", () -> {

            open( "/automation-practice-form" );
            pageBase.addRemove();
            pageBase.closeFooter();
        } );
        return this;
    }

    public DemoqaPracticeFormPage setFirstName(String value) {
        step( "Input Name", () -> {

            firstNameInput.setValue( value );
        } );


        return this;
    }

    public DemoqaPracticeFormPage setLastName(String value) {
        step( "Input Lastname", () -> {

            lastNameInput.setValue( value );
        } );

        return this;


    }

    public DemoqaPracticeFormPage setEmail(String value) {
        step( "Input e-mail", () -> {

            $( "#userEmail" ).setValue( value );
        } );

        return this;
    }

    public DemoqaPracticeFormPage setGender(String value) {
        step( "Choose gender", () -> {

            $( "#genterWrapper" ).$( byText( value ) ).click();
        } );

        return this;
    }

    public DemoqaPracticeFormPage setPhoneNumber(String value) {
        step( "Input phone", () -> {
            $( "#userNumber" ).setValue( value );

        } );

        return this;
    }

    public DemoqaPracticeFormPage setDateOfBirth(String day, String month, String year) {
        step( "Choose date of birth", () -> {

            $( "#dateOfBirthInput" ).click();
            calendarComponent.setDate( day, month, year );
        } );

        return this;
    }

    public DemoqaPracticeFormPage setSubject(String value) {
        step( "Input subject", () -> {
            $( "#subjectsInput" ).sendKeys( value );
            $( "#subjectsInput" ).pressEnter();

        } );

        return this;
    }

    public DemoqaPracticeFormPage chooseHobbies(String value) {
        step( "Input hobbies", () -> {
            $( "#hobbiesWrapper" ).$( byText( value ) ).click();

        } );

        return this;
    }

    public DemoqaPracticeFormPage uploadPicture() {
        step( "Upload picture", () -> {
            $( "#uploadPicture" ).uploadFromClasspath( "persone.jpeg" );

        } );

        return this;
    }

    public DemoqaPracticeFormPage setCurrentAddress(String value) {
        step( "Input address", () -> {
            $( "#currentAddress" ).setValue( value );

        } );

        return this;
    }

    public DemoqaPracticeFormPage chooseState(String value) {
        step( "Choose state", () -> {

        } );
        $( "#state" ).scrollTo().click();
        $( "#stateCity-wrapper" ).$( byText( value ) ).click();

        return this;
    }

    public DemoqaPracticeFormPage chooseCity(String value) {
        step( "Choose city", () -> {
            $( "#city" ).click();
            $( "#stateCity-wrapper" ).$( byText( value ) ).click();

        } );

        return this;
    }

    public DemoqaPracticeFormPage submitForm() {
        step( "Press submit", () -> {
            pageBase.clickSubmit();

        } );

        return this;
    }

    public DemoqaPracticeFormPage checkResult(String key, String value) {
        step( "Check results", () -> {
            resultsTableComponent.checkResult( key, value );

        } );

        return this;
    }
}