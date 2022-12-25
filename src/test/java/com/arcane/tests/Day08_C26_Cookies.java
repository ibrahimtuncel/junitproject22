package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_C26_Cookies extends TestBase {
    /*
    Method: handleCookies
    -Amazon'a (https://www.amazon.com) git and tasks automate et
    1. Toplam cookies sayisini bul
    2. Tum cookies yazdir
    3. Cookies isimleriyle yazdir
    4. Yeni cookie ekle
    5. Cookie ismiyle sil
    6. Tum cookies sil
    */

    @Test
    public void handleCookies() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.amazon.com/");
        Thread.sleep(10000);
        //1. Toplam cookies sayisini bul
        Set<Cookie> tumCookies=driver.manage().getCookies();
        System.out.println(tumCookies);
        int cookiesSayisi=tumCookies.size();
        System.out.println(cookiesSayisi);
        //2. Tum cookies yazdir
        for(Cookie w:tumCookies){
            System.out.println("cookie ismi="+w.getName());
            System.out.println("cookie degeri="+w.getValue());}
            //3. Cookies isimleriyle yazdir
            System.out.println("cookie ismi session-id-time olan="+driver.manage().getCookieNamed("session-id-time"));
       // 4. Yeni cookie ekle
            Cookie cookiEkle=new Cookie("favori kek","havuclu");
            driver.manage().addCookie(cookiEkle);
            //tum cookileri bir daha al
            tumCookies=driver.manage().getCookies();
            System.out.println(tumCookies.size());

            //5. Cookie ismiyle sil
            driver.manage().deleteCookieNamed("session-id-time");
            tumCookies=driver.manage().getCookies();
            System.out.println(tumCookies.size());

            // 6. Tum cookies sil
            driver.manage().deleteAllCookies();
            tumCookies=driver.manage().getCookies();
            System.out.println(tumCookies.size());


        }
    }


