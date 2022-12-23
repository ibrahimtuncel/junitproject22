package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day07_C20_synchronization1 extends TestBase {
    /*
    method olustur: synchronization1
    1- https://the-internet.herokuapp.com/dynamic_controls adresine git
    2- remove button'una tiklayin
    3- Mesajin “It's gone!” oldugunu verify edin
    4- Add button'una tiklayin
    5- Mesajin “It's back!” oldugunu verify edin
    */

    @Test
    public void synchronization1() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //   2- remove button'una tiklayin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //Thread.sleep(5000);
        //3- Mesajin “It's gone!” oldugunu verify edin
        //1 yol
        String mesaj1=driver.findElement(By.id("message")).getText();
        System.out.println(mesaj1);
        //Assert.assertEquals("It's gone!",mesaj1);

        //2. yol exicility wait ekle
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(mesaj1.contains("It's gone!"));
        // 4- Add button'una tiklayin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //Thread.sleep(5000);
        WebDriverWait wait2=new WebDriverWait(driver,10);
        WebElement waitElement2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //5- Mesajin “It's back!” oldugunu verify edin
        String mesaj2=driver.findElement(By.id("message")).getText();
        System.out.println(mesaj2);
        Assert.assertTrue(mesaj2.equals("It's back!"));

    }
}
