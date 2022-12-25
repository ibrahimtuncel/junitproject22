package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_C27_Javascript_Executor extends TestBase {//uygulayıcı demek
    /*
    Kullanici aplicasyonun Url (websayfasi)'ine gider
    Sayfada "Have a Questions?" text'ini verify et
    driver.get("http://www.carettahotel.com/");
     */
    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        Thread.sleep(2000);
        WebElement ctr=driver.findElement(By.xpath("//h2[.='Have a Questions?']"));
        //Assert.assertTrue(ctr.isDisplayed());
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ctr);
        Assert.assertEquals(ctr.getText(),"Have a Questions?");
    }


}
