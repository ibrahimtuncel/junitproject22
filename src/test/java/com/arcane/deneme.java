package com.arcane;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class deneme {

            @Test
    public void Test1() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                //driver.get("https://www.youtube.com/");
                driver.manage().window().maximize();
               // driver.findElement(By.cssSelector("input#search")).sendKeys("fas");
                //Thread.sleep(2000);
                driver.get("https://www.youtube.com/watch?v=qQ2DZKUljhw");
               /* driver.findElement(By.xpath("(//button[@aria-label='Ara'])[1]")).click();
                WebElement fas=driver.findElement(By.xpath("(//a[@id='video-title'])[10]"));
                System.out.println(fas.getText());
                fas.click();*/
                //driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
                Thread.sleep(3000);
               // driver.findElement(By.xpath("//button[@title='Duraklat (k)']")).click();
                //Thread.sleep(2000);
                //driver.findElement(By.xpath("//button[@title='Oynat (k)']")).click();
                driver.findElement(By.linkText("TRT SPOR")).click();
                Thread.sleep(4000);
                driver.findElement(By.xpath("(//*[contains(text(),'2022 Dünya Kupası Üçüncülük Maçı')])[3]"))
                        .click();
            }

    }
