package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {

    @Test
    public void fakerTest(){
        //faker data type obje olustur
        Faker faker=new Faker();

        //fake datayı kullanabiliris
        String fname=faker.name().firstName();
        System.out.println(fname);
        String lname=faker.name().lastName();
        System.out.println(lname);
        String fullname=faker.name().fullName();
        System.out.println(fullname);
        //title
        System.out.println(faker.name().title());
        //city
        System.out.println(faker.address().city());
        //state
        System.out.println(faker.address().state());
        //phone number
        System.out.println(faker.phoneNumber().cellPhone());
        //post code
        System.out.println(faker.address().zipCode());
        //email
        System.out.println(faker.internet().emailAddress());
        //rastgele rakam
        System.out.println(faker.number().digits(6));

        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.animal().name());
       // System.out.println(faker.howIMetYourMother().catchPhrase());
        System.out.println(faker.avatar().image());

        System.out.println(faker.ancient().hero());

        System.out.println(faker.artist().name());
        System.out.println(faker.date().birthday());
        System.out.println(faker.weather().description());
        System.out.println(faker.pokemon().name());
        System.out.println(faker.country().name());
        System.out.println(faker.job().title());

    }
}
