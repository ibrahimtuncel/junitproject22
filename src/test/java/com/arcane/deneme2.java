package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
    @Test
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

}
