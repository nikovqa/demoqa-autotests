package demoqa.UITests;

import com.github.javafaker.Faker;
import demoqa.utils.RandomDataGenerator;

import java.util.Locale;


public class TestData {

    Faker faker = new Faker(new Locale("eng"));
    String firstName = faker.address().firstName(),
            lastName = faker.address().lastName(),
            email = faker.internet().emailAddress(),
            gender = RandomDataGenerator.randomGender(),
            phone = String.valueOf(faker.number().randomNumber(10, true)),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = RandomDataGenerator.randomMonth(),
            year = String.valueOf(faker.number().numberBetween(1970, 2022)),
            subject = RandomDataGenerator.randomSubjects(),
            hobby = RandomDataGenerator.randomHobbies(),
            hobby2 = RandomDataGenerator.randomHobbies(),
            hobby3 = RandomDataGenerator.randomHobbies(),
            hobby4 = RandomDataGenerator.randomHobbies(),
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

}
