package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Day03_C5_GoogleAramaTesti {
    /*
Yeni class olustur : GoogleAramaTest
Test method'u  olustur ve asagidaki task'i tamamlayin.
Kullanici https://www.google.com gider
"porselen caydanlik" aransin
Bununla baglantili Google'da kac tane sonuc gosteriliyor test edin
*/
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //Thread.sleep(1000);
        /*    Implicitly wait ekleme
     - 30 saniye kadar bekle eger IHTIYAC duyarsan ===bu Java'da Thread.sleap() gibi degildir
     - Eger driver 1 saniyeye ihtiyac duyarsa. SADECE 1 saniye bekler (implicitlyWait => dinamik bir beklemedir)
     - Neden beklemeye ihtiyac duyariz:
        >   Internet yavas olabilir
        >   Bilgisayarimizin ozeliklerinden dolayi yavas olabilir
        >   Database yavas olabilir
        >   Sayfadaki resim, video ve iframe'lerden dolayi sayfa yavas olabilir
        */
        driver.manage().window().maximize();
    }
    @Test
    public void caydanlik(){
        driver.get("https://www.google.com");
       // driver.findElement(By.xpath("//input[@name='q']"))
        //.sendKeys("porselen çaydanlık"+ Keys.ENTER);
        //driver.findElement(By.xpath("//input[@class='gLFyf']"))
              //  .sendKeys("araba"+ Keys.ENTER);
        driver.findElement(By.xpath("(//input[@type='text'])[1]"))
                .sendKeys("futbol"+Keys.ENTER);

        String sonuc=driver.findElement(By.xpath("//div[@id='result-stats']")).getText()
                .substring(9,18);
        System.out.println(sonuc);
        String []sonuc2=driver.findElement(By.xpath("//div[@id='result-stats']")).getText()
                .split(" ");
        System.out.println(sonuc2[0]);
        System.out.println(sonuc2[1]);
           }

    @After
    public void caydanlık(){
        driver.close();
           }

}
