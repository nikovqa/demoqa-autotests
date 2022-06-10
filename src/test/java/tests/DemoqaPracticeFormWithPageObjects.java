package tests;

import org.junit.jupiter.api.Test;


public class DemoqaPracticeFormWithPageObjects extends TestBase {


    @Test
    void fillPracticeForm() {
        demoqaPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .chooseHobbies(hobby)
                .uploadPicture()
                .setCurrentAdress(currentAddress)
                .chooseState(state)
                .chooseCity(city)
                .submitForm()
                .checkResult("Student Name", firstName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "persone.jpeg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " +  city);
    }

}