package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DemoqaPracticeFormWithPageObjects extends TestBase {

    //@Tag("my")
    @DisplayName( "FillFormPO" )
    @Test
    void fillPracticeForm() {
        demoqaPracticeFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .chooseHobbies(testData.hobby)
                .uploadPicture()
                .setCurrentAdress(testData.currentAddress)
                .chooseState(testData.state)
                .chooseCity(testData.city)
                .submitForm()
                .checkResult("Student Name", testData.firstName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", "persone.jpeg")
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " +  testData.city);
    }

}