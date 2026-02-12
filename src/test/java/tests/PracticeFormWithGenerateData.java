package tests;

import helpers.Attach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;
import static pages.PracticeFormPage.page;


public class PracticeFormWithGenerateData extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    FakerGenerateData fakerGenerateData = new FakerGenerateData();


    @Test
    @DisplayName("Проверка корректности заполнения формы automation-practice-form")
    void checkingCorrectFillingOfPracticeFormFields(){

        step("Открываем страницу "+baseUrl+page, () -> {
            practiceFormPage.openPage()
                            .removeBanners();
        });
        step("Заполняем поля формы "+page, () -> {
            practiceFormPage.setFirstName(fakerGenerateData.fakerFirstName)
                    .setLastName(fakerGenerateData.fakerLastName)
                    .setEmail(fakerGenerateData.fakerEmail)
                    .setGender(fakerGenerateData.fakerRandomGender)
                    .setUserNumber(fakerGenerateData.fakerPhoneNumber)
                    .setBirthDate(fakerGenerateData.fakerBirthDay, fakerGenerateData.fakerBirthMonth, fakerGenerateData.fakerBirthYear)
                    .setSubjects(fakerGenerateData.fakerRandomSubjects)
                    .setHobbies(fakerGenerateData.fakerRandomHobbies)
                    .uploadPicture(fakerGenerateData.fakerImage)
                    .currentAddress(fakerGenerateData.fakerCurAddress)
                    .scroll()
                    .setState(fakerGenerateData.fakerState)
                    .setCity(fakerGenerateData.fakerRandomCity)
                    .clickSubmit();
        });
        step("Проверяем результаты итоговой таблицы", () -> {
            practiceFormPage.checkResultTable("Student Name", fakerGenerateData.fakerFirstName + " " + fakerGenerateData.fakerLastName)
                    .checkResultTable("Student Email", fakerGenerateData.fakerEmail)
                    .checkResultTable("Gender", fakerGenerateData.fakerRandomGender)
                    .checkResultTable("Mobile", fakerGenerateData.fakerPhoneNumber)
                    .checkResultTable("Date of Birth", fakerGenerateData.fakerBirthDay + " " + fakerGenerateData.fakerBirthMonth + "," + fakerGenerateData.fakerBirthYear)
                    .checkResultTable("Subjects", fakerGenerateData.fakerRandomSubjects)
                    .checkResultTable("Hobbies", fakerGenerateData.fakerRandomHobbies)
                    .checkResultTable("Picture", fakerGenerateData.fakerImage)
                    .checkResultTable("Address", fakerGenerateData.fakerCurAddress)
                    .checkResultTable("State and City", fakerGenerateData.fakerState + " " + fakerGenerateData.fakerRandomCity);
            Attach.screenshotAs("Last screenshot");
            practiceFormPage.closeTable();
        });

    }

    @Test
    @DisplayName("Проверка обязательности ввода значения в поле FirstName")
    void checkThatFirstNameFieldIsRequired() {
        step("Открываем страницу "+baseUrl+page, () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });
        step("Заполняем поля формы кроме FirstName"+page, () -> {
        practiceFormPage
                .setLastName(fakerGenerateData.fakerLastName)
                .setEmail(fakerGenerateData.fakerEmail)
                .setGender(fakerGenerateData.fakerRandomGender)
                .setUserNumber(fakerGenerateData.fakerPhoneNumber)
                .setBirthDate(fakerGenerateData.fakerBirthDay, fakerGenerateData.fakerBirthMonth, fakerGenerateData.fakerBirthYear)
                .clickSubmit()
                .getModalDialog();

        });
    }
}

