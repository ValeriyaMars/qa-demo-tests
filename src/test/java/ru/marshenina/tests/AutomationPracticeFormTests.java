package ru.marshenina.tests;

import org.junit.jupiter.api.Test;
import ru.marshenina.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ru.marshenina.utils.RandomStudent.*;


public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        String userFirstName = getRandomFirstName(),
                userLastName = getRandomLastName(),
                userEmail = getRandomEmail(),
                userGender = getRandomGender(),
                userPhone = getRandomPhone(),
                userBirthMonth = getRandomBirthMonth(),
                userBirthYear = getRandomBirthYear(),
                userBirthDay = getRandomBirthDay(),
                userSubject = getRandomSubject(),
                userHobby = getRandomHobby(),
                userPicture = getFileName(),
                userCurrentAddress = getRandomAddress(),
                userState = getRandomState(),
                userCity = getRandomState(userState);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPicture)
                .setCurrentAddress(userCurrentAddress)
                .setState(userState)
                .setCity(userCity);

        registrationPage.clickSubmitButton();

        $(".modal-body").shouldHave(text("Student Name " + userFirstName + " " + userLastName));
        $(".modal-body").shouldHave(text("Student Email " + userEmail));
        $(".modal-body").shouldHave(text("Gender " + userGender));
        $(".modal-body").shouldHave(text("Mobile " + userPhone));
        $(".modal-body").shouldHave(text("Date of Birth " + userBirthDay + " " + userBirthMonth + "," + userBirthYear));
        $(".modal-body").shouldHave(text("Subjects " + userSubject));
        $(".modal-body").shouldHave(text("Hobbies " + userHobby));
        $(".modal-body").shouldHave(text("Picture photo.png"));
        $(".modal-body").shouldHave(text("Address " + userCurrentAddress));
        $(".modal-body").shouldHave(text("State and City " + userState + " " + userCity));
    }
}
