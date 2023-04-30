package ru.marshenina.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.marshenina.pages.components.CalendarComponent;
import ru.marshenina.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends TestBase {
    CalendarComponent calendarComponent = new CalendarComponent();

    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-body");

    @Step("Открываем страницу с формой регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    @Step("Убираем баннер")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя '{value}'")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим фамилию '{value}'")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим email '{value}'")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол '{value}'")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Вводим номер телефона '{value}'")
    public RegistrationPage setPhone(String value) {
        numberInput.setValue(value);
        return this;
    }

    @Step("Вводим дату рождения '{day} {month} {year}'")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем предмет '{value}'")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби '{value}'")
    public RegistrationPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем фото '{value}'")
    public RegistrationPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    @Step("Вводим адреc '{value}'")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбираем штат '{value}'")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step("Выбираем город '{value}'")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    @Step("Нажимаем кнопку 'Submit'")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Проверяем введенные данные '{text}'")
    public RegistrationPage verifyResult(String text) {
        modalWindow.shouldHave(text(text));
        return this;
    }
}
