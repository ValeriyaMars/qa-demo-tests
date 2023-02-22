package ru.marshenina;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Valeriia");
        $("#lastName").setValue("Marshenina");
        $("#userEmail").setValue("valeriia@marshenina.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("August")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1988")).click();
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture")
                .uploadFromClasspath("file/photo.png");
        $("#currentAddress").setValue("Syzran");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();



        $(".modal-body").shouldHave(text("Student Name " + "Valeriia" + " " + "Marshenina"));
        $(".modal-body").shouldHave(text("Student Email " + "valeriia@marshenina.com"));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + "1234567890"));
        $(".modal-body").shouldHave(text("Date of Birth 28 August,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("photo.png"));
        $(".modal-body").shouldHave(text("Address " + "Syzran"));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }
}
