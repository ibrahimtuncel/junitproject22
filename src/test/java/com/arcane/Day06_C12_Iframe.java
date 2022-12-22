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

public class Day06_C12_Iframe {
    /*
Create a class: IFrameTest
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page
 */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        //Verify the Bolded text contains “Editor”
       WebElement editorweb=driver.findElement(By.xpath("//h3"));
       String editor= editorweb.getText();
        System.out.println(editor);
        Assert.assertTrue(editor.contains("Editor"));

        //Locate the text box
        //1 yol iframe e geciş icin indeks kullannımı- 0 dan baslar
        //driver.switchTo().frame(1);
        //2.yol iframe gecis icin id/value kullanma
        //driver.switchTo().frame("mce_0_ifr");
        //3. yol frame icerisine -webelement olarak yasma
        WebElement idweb=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(idweb);

        //Delete the text in the text box
        WebElement paragraf=driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba buraya yası yasıldi...");

        //ic iframeden cıkmak icin
        driver.switchTo().parentFrame();
       // driver.switchTo().defaultContent(); en üst sayfaya cıkarır.

        //Verify the text Elemental Selenium text is displayed on the page
        WebElement sayfaelement=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        WebElement sfelement=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(sayfaelement.isDisplayed());
        Assert.assertTrue(sfelement.isDisplayed());

    }
    @After
    public void after(){
        driver.close();
    }

}
