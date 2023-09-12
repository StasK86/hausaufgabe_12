package krigersv.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class FormTest extends TestBase {

        @Test
        @Tag("demo")
        @DisplayName("RegistrationTest")
        void fillFormTest() {
            step("Open Form", () -> {
                        open("/automation-practice-form");
                        executeJavaScript("$('#fixedban').remove()");
                        executeJavaScript("$('footer').remove()");
                    });
            step("Fill form", () -> {
            $("#firstName").setValue("Britney");
            $("#lastName").setValue("Spears");
            $("#userEmail").setValue("britneyspears@gmail.com");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("7234567890");
            $("#dateOfBirthInput").click();
            $("select.react-datepicker__month-select").click();
            $("select.react-datepicker__month-select").selectOption("December");
            $("select.react-datepicker__year-select").click();
            $("select.react-datepicker__year-select").selectOption("1981");
            $("div.react-datepicker__day.react-datepicker__day--002").click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#currentAddress").setValue("Las Vegas");
            $("#uploadPicture").uploadFromClasspath("britney.jpg");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
            step("Verify results", () -> {
                $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Britney Spears"));
                $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("britneyspears@gmail.com"));
                $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Female"));
                $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("7234567890"));
                $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("02 December,1981"));
                $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Arts"));
                $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Music"));
                $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("britney.jpg"));
                $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Las Vegas"));
                $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
            });
        }
    }

