package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {

    public static void main(String[]args){
        //System.setProperty("driver type", "driver path"); kullanılmayacak
        //chrome driver i set et
        WebDriverManager.chromedriver().setup();

        //driver objesi olustur
        WebDriver driver= new ChromeDriver();
        //otomasyon script
        //ekrani kapla
        driver.manage().window().maximize();
        // amasona git
        driver.get("https://www.amazon.com");
        //browseri kapat driver.quit tum safları close mevcut sf
        //kapatır.
        driver.close();

    }
}
