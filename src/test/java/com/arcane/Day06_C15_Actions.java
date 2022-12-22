package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day06_C15_Actions {
    /*
    Test method olustur : contextClickMethod() ve scenario test et:
   1-  Given kullanici the https://the-internet.herokuapp.com/context_menu sayfasindadir
   2-  When box (kutucuk) Right clicks edilir
   3- Then “You selected a context menu” alert mesajini verify et
   4- Then alert'u accept et
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //2-  When box (kutucuk) Right clicks edilir
        Actions actions= new Actions(driver);
        WebElement kutu= driver.findElement(By.id("hot-spot"));

        actions.contextClick(kutu).perform();//kutu ya sağ tıkla

        // 3- Then “You selected a context menu” alert mesajini verify et
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // 4- Then alert'u accept et
        driver.switchTo().alert().accept();


    }

}
