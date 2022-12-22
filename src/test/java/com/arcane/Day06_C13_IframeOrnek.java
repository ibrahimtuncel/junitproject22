package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day06_C13_IframeOrnek {
    //bir web sayfası ıcerisinde toplam ifremaleri bulunus.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https:www.amazon.com");
    }
    @Test
    public void iframesayisi(){
      List<WebElement> iframes= driver.findElements(By.xpath("//iframe"));
      int iframeSayisi= iframes.size();
        System.out.println(iframeSayisi);

        driver.get("https://the-internet.herokuapp.com/iframe");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        System.out.println(driver.findElements(By.xpath("//iframe")).size());
    }
    @After
    public void after(){
        driver.close();
    }
}
