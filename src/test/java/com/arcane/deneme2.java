package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class deneme2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
   /* @Test
    public void language() throws InterruptedException {
//    1- Given kullanici  https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");
        Thread.sleep(8000);

        //1. adim action objesi olustur
        Actions actions = new Actions(driver);
        //2. uzerine gidecegimiz ( hover over) elementi locate et
        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        //3.hover over yap
        actions.moveToElement(accountLists).perform();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Account")).click();
        Thread.sleep(4000);

//    2- When kullanici “Account” linkini click eder
        //1. adim action objesi olustur
        Actions actions2 = new Actions(driver);
        //2. uzerine gidecegimiz ( hover over) elementi locate et
        WebElement langs= driver.findElement(By.cssSelector("#icp-nav-flyout"));
        //3.hover over yap
        actions2.moveToElement(langs).perform();
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//span[.='español'])[1]")).click();

//    3- Then page title'in “Your Account” icerdigini verify et

        String pageSource= driver.getPageSource();
        System.out.println(pageSource.contains("Tu cuenta"));
        System.out.println(driver.findElement(By.xpath("//h1")).getText());

    }
   @Test
   public void keyUpDown(){
       driver.get("https://www.google.com");
       // if you see cokies then add this line
       //driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
       WebElement searchBox = driver.findElement(By.xpath("//input[@name ='q']"));
       //searchBox.SendKeys("iPhone X prices")
       Actions actions = new Actions(driver);

       actions.
               keyDown(searchBox, Keys.SHIFT).//press on shift button
               sendKeys("iPhone X prices").//type on in the element
               keyUp(searchBox,Keys.SHIFT).//unpress on the shift button
               sendKeys(" too expensive"+ Keys.ENTER).
               build().//build is optionally used to make perform stronger.Without build(), this will work
               perform();


   }*/
    @Test
    public void cookies(){
//        -Go to amazon  and automate the tasks
            driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
            // getCookies() returns all of the cookies in the browser
            Set<Cookie> allCookies = driver.manage().getCookies();
            int numOfCookies = allCookies.size();
            System.out.println("Number of Cookies => "+ numOfCookies);

//        2. Print all the cookies
            for (Cookie eachCookie : allCookies){
                System.out.println("Cookie Names => "+eachCookie.getName());
                System.out.println("Cookie Value => "+ eachCookie.getValue());
            }
    }

    }
