package ru.marshenina.tests;

import org.junit.jupiter.api.Test;
import ru.marshenina.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

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
                .removeBanner()
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

        $(".modal-body").shouldHave(text("Student Name " + firstName + " " + lastName));
        $(".modal-body").shouldHave(text("Student Email " + email));
        $(".modal-body").shouldHave(text("Gender " + gender));
        $(".modal-body").shouldHave(text("Mobile " + phone));
        $(".modal-body").shouldHave(text("Date of Birth " + birthDay + " " + birthMonth + "," + birthYear));
        $(".modal-body").shouldHave(text("Subjects " + subject));
        $(".modal-body").shouldHave(text("Hobbies " + hobby));
        $(".modal-body").shouldHave(text("Picture photo.png"));
        $(".modal-body").shouldHave(text("Address " + currentAddress));
        $(".modal-body").shouldHave(text("State and City " + state + " " + city));

    }
}
