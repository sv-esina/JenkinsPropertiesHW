package utils;

import com.github.javafaker.Faker;

import java.util.Locale;


public class FakerRandomUtils {

    private final Faker faker = new Faker(new Locale("ru"));
    private final Faker fakerEn = new Faker(new Locale("en-US"));

    public String fakerFirstName = faker.name().firstName(),
            fakerLastName = faker.name().lastName(),
            fakerEmail = fakerEn.internet().emailAddress(),
            fakerPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            fakerImage = faker.options().option("image1.png", "image2.png"),
            fakerBirthDay = String.format("%s", faker.number().numberBetween(10, 28)),
            fakerBirthMonth = String.format("%s", faker.options().option("January", "February",
                    "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")),
            fakerBirthYear = String.format("%s", faker.number().numberBetween(1990, 2010)),
            fakerCurAddress = faker.address().fullAddress(),
            fakerRandomGender = faker.options().option("Male", "Female", "Other"),
            fakerRandomSubjects= faker.options().option("Accounting",
                    "Arts", "Biology", "Business Studies", "Chemistry", "Civics", "Commerce", "Computer Science",
                    "Economics", "English", "Finance", "Hindi", "History", "Maths", "Physics", "Social Studies"),
            fakerRandomHobbies = faker.options().option("Sports", "Reading", "Music");
    public String fakerState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


    public String fakerRandomCity (String fakerState) {
        return switch (fakerState) {

            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
