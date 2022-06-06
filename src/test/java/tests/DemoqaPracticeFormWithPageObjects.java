package tests;

import org.junit.jupiter.api.Test;


public class DemoqaPracticeFormWithPageObjects extends TestBase {


    @Test
    void fillPracticeForm() {
        demoqaPracticeFormPage.openPage()
                .setFirstName("Gregor")
                .setLastName("Zamza")
                .setEmail("gregor@zamza.com")
                .setGender("Male")
                .setPhoneNumber("3817513812")
                .setDateOfBirth("11", "September", "1991")
                .setSubject("Physics")
                .chooseHobbies("Music").chooseHobbies("Sports")
                .uploadPicture()
                .setCurrentAdress("F 12/8, Basement, Malviya Nagar")
                .chooseState("NCR")
                .chooseCity("Delhi")
                .submitForm()
                .checkResult("Student Name", "Gregor Zamza")
                .checkResult("Student Email", "gregor@zamza.com")
                .checkResult("Date of Birth", "11 September,1991")
                .checkResult("Mobile", "3817513812");



    }

}