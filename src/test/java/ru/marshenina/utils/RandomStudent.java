package ru.marshenina.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static java.lang.String.valueOf;

public class RandomStudent {

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return new Faker().options().option("Male", "Female", "Other");
    }

    public static String getRandomPhone() {
        return new Faker().number().digits(10);
    }

    static Date fakerDateOfBirthday = new Faker().date().birthday();

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
        return new Faker().options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    }

    public static String getRandomHobby() {
        return new Faker().options().option("Sports", "Reading", "Music");
    }

    public static String getFileName() {
        return "file/photo.png";
    }

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    static String state;

    public static String getRandomState() {
        state = new Faker().options().option(mapStateWithCity.keySet().toArray()).toString();
        return state;
    }

    public static String getRandomState(String state) {
        return new Faker().options().option(mapStateWithCity.get(state));
    }

}
