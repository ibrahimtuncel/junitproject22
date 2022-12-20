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

import java.util.List;

public class Day02_C2_LocatorsGiris {
    /*Bir class olustur : LocatorsGiris
    Main method olustur ve asagidaki gorevi (task) yap.
    Kullanici "https://www.testyou.in/Login.aspx" gider
    username textbox, password textbox, and signin button icin locator bul
    Kullanici adi and password'i gir ve sign in button click et
    Username : aykut.arcanedata@gmail.com
    Password : Aykut123!
    Kullanici adini verify et (USE getText() method to get the text from the page)
    Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
    Sayfada bulunan toplam link sayisini bul
    Sayfadan log out yapiniz
    Logged out basarili oldugunu verify edin
 */
    WebDriver chrome;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    @Test
    public void locatorGiris() {
        chrome.get("https://www.testyou.in/Login.aspx");
        //WebElement emailBox=chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
        // emailBox.sendKeys("aykut.arcanedata@gmail.com");
        chrome.
                findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
                sendKeys("aykut.arcanedata@gmail.com");
        //password gir
        chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).
                sendKeys("Aykut123!");

        //sign in butonuna click yap
        chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

        //kullanıcı adını verify et-dogrula
        WebElement kullaniciAdi = chrome.findElement(By.id("ctl00_headerTopStudent_username"));
        String kullaniciAdiTeks = kullaniciAdi.getText();
        //getText() metodu elementin kendisini string olraka döndürür.
        System.out.println(kullaniciAdi);
        System.out.println(kullaniciAdiTeks);
        String ekspectedAd = "Aykutsaglam ,";
        Assert.assertEquals(ekspectedAd, kullaniciAdiTeks);

        //Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
        WebElement homeElement = chrome.findElement(By.linkText("Home"));
        //WebElement home2=chrome.findElement(By.partialLinkText("Hom"));
        //elementin sf da varlığını test eder.boolean döner.
        Assert.assertTrue(homeElement.isDisplayed());

        //chrome.findElement(By.className("signout")).isDisplayed();
        WebElement logOutElement = chrome.findElement(By.className("signout"));
        Assert.assertTrue(logOutElement.isDisplayed());

        //sayfadaki toplam link sayısını bul-"a" tagleri sayılmalı.
        List<WebElement> tumLinkler = chrome.findElements(By.tagName("a"));
        int linkSayisi = tumLinkler.size();
        System.out.println("Toplam link sayisi: " + linkSayisi);
        //System.out.println(tumLinkler);

        //sayfadan logout yap
        chrome.findElement(By.className("signout")).click();

        //logout yapıldıgını check et-verify
        Boolean loggedeout = chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");
        Assert.assertTrue(loggedeout);
    }
        @After
        public void tearDown(){
            chrome.close();
        }
    }


