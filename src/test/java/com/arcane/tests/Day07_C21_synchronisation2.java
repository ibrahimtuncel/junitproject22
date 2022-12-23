package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day07_C21_synchronisation2 extends TestBase {
    /*
Method olustur: isEnabled
https://the-internet.herokuapp.com/dynamic_controls adresine git
enable Button'una tikla
Mesajin "It's enabled!" oldugunu verify et
Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
Disable button'una tikla
Mesajin "It's disabled!" oldugunu verify et
Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)

NOTE: .isEnabled(); bir elementin enabled olup olmadigini check eder
 */
    @Test
    public void isEnabled() throws InterruptedException {
        //https://the-internet.herokuapp.com/dynamic_controls adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //enable Button'una tikla
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        WebDriverWait wait1=new WebDriverWait(driver,10);
        WebElement element=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //Mesajin "It's enabled!" oldugunu verify et
        WebElement mesaj1=driver.findElement(By.id("message"));
        Assert.assertTrue(mesaj1.getText().contains("It's enabled!"));
        //Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
        WebElement teks= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(teks.isEnabled());
        //Disable button'una tikla
        driver.findElement(By.xpath("//button[.='Disable']")).click();
        WebDriverWait wait2=new WebDriverWait(driver,10);
        WebElement element2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //Mesajin "It's disabled!" oldugunu verify et
        WebElement mesaj2=driver.findElement(By.id("message"));
        Assert.assertTrue(mesaj2.getText().contains("It's disabled!"));
        //Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)
        WebElement teks2= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!teks2.isEnabled());


    }
}