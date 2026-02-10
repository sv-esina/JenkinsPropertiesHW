package tests;

import utils.FakerRandomUtils;

public class FakerGenerateData extends FakerRandomUtils{

    FakerRandomUtils fakerRandomUtils = new FakerRandomUtils();

    public String fakerFirstName = fakerRandomUtils.fakerFirstName,
            fakerLastName = fakerRandomUtils.fakerLastName,
            fakerEmail = fakerRandomUtils.fakerEmail,
            fakerRandomGender = fakerRandomUtils.fakerRandomGender,
            fakerPhoneNumber = fakerRandomUtils.fakerPhoneNumber,
            fakerBirthDay = fakerRandomUtils.fakerBirthDay,
            fakerBirthMonth = fakerRandomUtils.fakerBirthMonth,
            fakerBirthYear = fakerRandomUtils.fakerBirthYear,
            fakerRandomSubjects = fakerRandomUtils.fakerRandomSubjects,
            fakerRandomHobbies = fakerRandomUtils.fakerRandomHobbies,
            fakerImage = fakerRandomUtils.fakerImage,
            fakerCurAddress = fakerRandomUtils.fakerCurAddress,
            fakerState = fakerRandomUtils.fakerState,
            fakerRandomCity = fakerRandomUtils.fakerRandomCity(fakerRandomUtils.fakerState);
}
