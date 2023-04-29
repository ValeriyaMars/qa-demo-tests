package ru.marshenina.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.marshenina.pages.RegistrationPage;

import static ru.marshenina.utils.RandomStudent.*;

@Tag("registration_form")
public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Feature("Регистрационная форма")
    @Owner("ValeriyaMars")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Student Registration Form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение всех полей в форме регистрации")
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
                .uploadPicture(getFullPath(getFileName()))
                .setCurrentAddress(userCurrentAddress)
                .setState(userState)
                .setCity(userCity);

        registrationPage.clickSubmitButton();

        registrationPage.verifyResult("Student Name " + userFirstName + " " + userLastName)
                .verifyResult("Student Email " + userEmail)
                .verifyResult("Gender " + userGender)
                .verifyResult("Mobile " + userPhone)
                .verifyResult("Date of Birth " + userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects " + userSubject)
                .verifyResult("Hobbies " + userHobby)
                .verifyResult(getFileName())
                .verifyResult("Address " + userCurrentAddress)
                .verifyResult("State and City " + userState + " " + userCity);
    }
}
