package demoqa.UITests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class DemoqaPracticeFormWithPageObjects extends TestBase {

    @Tag("remote")
    @DisplayName( "FillFormPO" )
    @Test
    void fillPracticeForm() {
        step( "Open form", () -> {
            demoqaPracticeFormPage.openPage();
                });
        step( "Fill form", () -> {
            demoqaPracticeFormPage
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setPhoneNumber(testData.phone)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSubject(testData.subject)
                    .chooseHobbies(testData.hobby)
                    .uploadPicture()
                    .setCurrentAddress(testData.currentAddress)
                    .chooseState(testData.state)
                    .chooseCity(testData.city)
                    .submitForm();
        });
        step( "Check results", () -> {
            demoqaPracticeFormPage
                    .checkResult("Student Name", testData.firstName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", "persone.jpeg")
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " +  testData.city);
        });
    }

}