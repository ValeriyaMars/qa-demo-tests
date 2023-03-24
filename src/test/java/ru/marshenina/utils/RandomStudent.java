package ru.marshenina.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static java.lang.String.valueOf;

public class RandomStudent {
    private static Faker faker = new Faker();
    static Date fakerDateOfBirthday = faker.date().birthday();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomPhone() {
        return faker.number().digits(10);
    }

    public static String getRandomBirthMonth() {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomBirthYear() {
        return new SimpleDateFormat("y", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomBirthDay() {
    return new SimpleDateFormat("dd", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomSubject() {
        return faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    }

    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getFileName() {
        return "photo.png";
    }

    public static String getFullPath(String name) {
        return "file/" + name;
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static String getRandomState() {
        String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
        return state;
    }

    public static String getRandomState(String state) {
        return faker.options().option(mapStateWithCity.get(state));
    }

}
