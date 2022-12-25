package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_C24_fileDownLoadTesti extends TestBase {
    /*
    FileDownloadTest() olustur
    1- https://the-internet.herokuapp.com/download adresine git
    2- flower.png download et
    Screenshot (6).png indir-download et
    3- Dosyanin download edildigini verify et
     */
    @Test
    public void FileDownloadTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://the-internet.herokuapp.com/download");
        //Screenshot (6).png indir-download et
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='images.jpg']")).click();
        //driver.findElement(By.linkText("Screenshot (6).png")).click();
        //download yapınca hardwait-Thread.sleep(1000) eklenmeli
        //
        Thread.sleep(5000);
        //  3- Dosyanin download edildigini verify et
        String homePath=System.getProperty("user.home");
        String down1=homePath+"\\Downloads\\images.jpg";
        boolean varMi=Files.exists(Paths.get(down1));
        Assert.assertTrue(varMi);



    }

}
