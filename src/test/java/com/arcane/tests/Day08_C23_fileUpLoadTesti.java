package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.attribute.standard.Chromaticity;
import java.util.concurrent.TimeUnit;

public class Day08_C23_fileUpLoadTesti extends TestBase {
    /*
    1- Method : fileUploadTest
    2- https://the-internet.herokuapp.com/upload linkine git
    3- Kullanici masaustunden bir resim secer
    4- upload button'a tikla
    5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
     */
   /* @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //homePath i al
        Thread.sleep(20000);
        String homePath=System.getProperty("user.home");
        String cicekPath=homePath+"\\Desktop\\cicek.jpg";
        //  3- Kullanici masaustunden bir resim secer
        WebElement fileUpload= driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys(cicekPath);
        Thread.sleep(4000);
        //4- upload button'a tikla
        driver.findElement(By.id("file-submit")).click();
        //5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
        WebElement sonuc=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(sonuc.isDisplayed());
    }*/
    @Test
    public void fileUploadTest() throws InterruptedException {
        //    2- https://the-internet.herokuapp.com/upload linkine git
        driver.get("https://the-internet.herokuapp.com/upload");

        //Wait wait=new FluentWait(By.id(driver)).withTimeout(10, TimeUnit.SECONDS).
                //pollingEvery(2,TimeUnit.SECONDS);
        Thread.sleep(5000);
        WebDriverWait wait1=new WebDriverWait(driver,20);
        WebElement element=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-upload")));

        //    3- Kullanici masaustunden bir resim secer

        //homepath al
        String homePath = System.getProperty(("user.home"));
        String cicekPath=homePath+"\\Desktop\\cicek.jpg";

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        fileUpload.sendKeys(cicekPath);
        Thread.sleep(4000);
        //    4- upload button'a tikla
        driver.findElement(By.id("file-submit")).click();

        //    5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
        WebElement fileUploaded = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
    }

}
