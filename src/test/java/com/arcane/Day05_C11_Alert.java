package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_C11_Alert {

    /*
    Go to https://the-internet.herokuapp.com/javascript_alerts
    setUp method olustur
    3 test methodu olustur:
    acceptAlert() => birinci alert'e tikla, Text'in “I am a JS Alert” oldugunu verify et ve OK'ye tikla , sonra “You successfully clicked an alert” metnini verify et
    dismissAlert()=> ikinci alert'e tikla,  Text'in "I am a JS Confirm” oldugunu verify et, cancel'i tikla, sonra “You clicked: Cancel” verify et
    sendKeysAlert()=> ucuncu alert'e tikla,  Text'in“I am a JS prompt” oldugunu verify et, “Hello Word” Text'i yaz, OK'ye tikla, and “You entered: Hello Word” Text'ini verify et
 */
    Faker faker=new Faker();
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        String ekspected="I am a JS Alert";
        Thread.sleep(3000);
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals(ekspected,actual);

        driver.switchTo().alert().accept();

        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",result);
        System.out.println(result);
    }
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",actual);
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",result);
        System.out.println(result);
    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actual);
        System.out.println(actual);
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello World");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",result);
        System.out.println(result);

    }


}
