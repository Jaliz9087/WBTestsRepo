package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ForFaker {
    Faker faker = new Faker((new Locale("en-GB")));

    public String UserNumber = faker.phoneNumber().subscriberNumber(9);

}
