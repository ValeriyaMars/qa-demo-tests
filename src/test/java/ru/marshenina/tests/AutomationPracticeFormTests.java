package ru.marshenina.tests;

import org.junit.jupiter.api.Test;


public class AutomationPracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = "Valeriia",
                lastName = "Marshenina",
                email = "valeriia@marshenina.com",
                gender = "Female",
                phone = "1234567890",
                birthDay = "28",
                birthMonth = "August",
                birthYear = "1988",
                subject = "Maths",
                hobby = "Reading",
                picture = "file/photo.png",
                currentAddress = "Syzran",
                state = "NCR",
                city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city);

        registrationPage.clickSubmitButton();

        registrationPage.verifyModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city);

    }
}
