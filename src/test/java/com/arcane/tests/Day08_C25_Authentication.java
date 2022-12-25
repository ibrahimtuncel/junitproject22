package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_C25_Authentication extends TestBase {
    /*
  driver.get("https://the-internet.herokuapp.com/basic_auth")
  https://username:password@URL
  username : admin
  password: admin
  url : the-internet.herokuapp.com/basic_auth
    //sayfanin Congratulations! icerdigini verify et
   */
    @Test
    public void authTest() throws InterruptedException {
        Thread.sleep(15000);
        //  driver.get("https://the-internet.herokuapp.com/basic_auth")
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(15000);
        //sayfanin "Congratulations!" icerdigini verify et
        boolean gosteriliyorMu = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations!')]")).isDisplayed();
//        Assert.assertTrue(gosteriliyorMu);
        Assert.assertEquals(gosteriliyorMu, true);

    }
}
