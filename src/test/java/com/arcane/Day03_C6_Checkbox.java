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

import java.util.concurrent.TimeUnit;

public class Day03_C6_Checkbox {
   /*
  Test method olusturun ve asagidaki task'i tamamlayin.
  https://the-internet.herokuapp.com/checkboxes gidin
  checkbox elementlerini bulun
  Ardindan eger checkbox1 secilMemis ise click/check edin
  Ardindan eger checkbox2 secilMEmis ise click/check edin
  Ardindan checkbox1 ve checkbox2'nin checked oldugunu verify edin
   */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void Checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement kutu1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement kutu2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(2000);
        if(!kutu1.isSelected()){
            kutu1.click();
        }
        if(!kutu2.isSelected()){
            kutu2.click();
        }
        Assert.assertTrue(kutu1.isSelected());
        //Assert.assertTrue(!kutu2.isSelected());
    }

    @After
    public void after(){
        driver.close();
    }



}
