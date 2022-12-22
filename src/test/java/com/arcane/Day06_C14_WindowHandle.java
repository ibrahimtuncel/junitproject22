package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day06_C14_WindowHandle {
    /*
    1- Given kullanici the https://the-internet.herokuapp.com/windows sayfasindadir
    2- Then kullanici text : “Opening a new window” text'i verify eder
    3- Then kullanici sayfanin title (baslik)'i “The Internet” oldugunu verify eder
    4- When kullanici  “Click Here” button'una click eder
    5- Then kullanici yeni pencere basliginin (window title) “New Window” oldugunu verify eder
    6- Then kullanic text : “New Window” oldugunu verify eder
    7- When kullanici onceki window'a gider ve title : “The Internet” oldugunu verify eder
    */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        //2- Then kullanici text : “Opening a new window” text'i verify eder
        WebElement baslık = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", baslık.getText());

        // 3- Then kullanici sayfanin title (baslik)'i “The Internet” oldugunu verify eder
        String title1 = driver.getTitle();
        System.out.println(title1);
        Assert.assertEquals("The Internet", title1);

        // 4- When kullanici  “Click Here” button'una click eder
        driver.findElement(By.linkText("Click Here")).click();

        //5- Then kullanici yeni pencere basliginin (window title) “New Window” oldugunu verify eder
        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        System.out.println(driver.getWindowHandle());

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        for (String w : windows) {
            if (!w.equals(window1)) {
                driver.switchTo().window(w);
                break;
                //driver window1 den cıktı diğerine girdi.
            }
        }
        String title2=driver.getTitle();
        System.out.println(title2);
        Assert.assertEquals("New Window",title2);
        String window2=driver.getWindowHandle();
        System.out.println(window2);
        //6- Then kullanic text : “New Window” oldugunu verify eder
        driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());
        Thread.sleep(3000);
        //7- When kullanici onceki window'a gider ve title : “The Internet” oldugunu verify eder
        driver.switchTo().window(window1);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.switchTo().window(window2);
        System.out.println(driver.getTitle());

    }
    @After
    public void after(){
        //driver.close();
        driver.quit();
    }
}
