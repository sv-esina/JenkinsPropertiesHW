package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    public static String page = "/automation-practice-form";

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            scroll = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            closeTable = $("#closeLargeModal"),
            modalDialog = $(".modal-dialog");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsive tableResponsive = new TableResponsive();



    public PracticeFormPage openPage() {
        open(page);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    @Step("Заполяем поле FirstName")
    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполяем поле LastName")
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполяем поле Email")
    public PracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбираем Gender")
    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Заполяем поле UserNumber")
    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Заполяем поле BirthDate")
    public PracticeFormPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Заполяем поле Subjects")
    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем чекбокс Hobbies")
    public PracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем фото")
    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполяем поле Address")
    public PracticeFormPage currentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }



    public PracticeFormPage scroll() {
        scroll.scrollTo();

        return this;
    }

    @Step("Заполяем поле State")
    public PracticeFormPage setState(String value) {
        state.click();
        $(byText(value)).click();

        return this;
    }

    @Step("Заполяем поле City")
    public PracticeFormPage setCity(String value) {
        city.click();
        $(byText(value)).click();

        return this;
    }

    public PracticeFormPage clickSubmit() {
        submit.click();

        return this;
    }

    @Step("Проверяем итоговую таблицу: поле {key} = {value}")
    public PracticeFormPage checkResultTable(String key, String value) {
        tableResponsive.setDataTable(key, value);

        return this;
    }

    public PracticeFormPage closeTable() {
        closeTable.click();

        return this;
    }

    public PracticeFormPage getModalDialog() {
        modalDialog.shouldNotBe(visible);

        return this;
    }

}
