package ru.marshenina.tests;

import com.github.javafaker.Faker;

import java.util.Map;

import static java.lang.String.valueOf;

public class TestData {

    static Faker faker = new Faker();

    public static String getRandomBirthDay() {
        int birthDay = new Faker().number().numberBetween(1, 28);
        if (birthDay < 10) {
            return ("0" + birthDay);
        } else {
            return valueOf(birthDay);
        }
    }

    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    public static String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userPhone = faker.number().digits(10),
            userBirthDay = getRandomBirthDay(),
            userBirthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2023)),
            userSubject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                    "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"),
            userHobby = faker.options().option("Sports", "Reading", "Music"),
            userPicture = "file/photo.png",
            userCurrentAddress = faker.address().fullAddress(),
            userState = faker.options().option(mapStateWithCity.keySet().toArray()).toString(),
            userCity = faker.options().option(mapStateWithCity.get(userState));

}
