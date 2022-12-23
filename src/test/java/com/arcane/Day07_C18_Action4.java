package com.arcane;

import com.arcane.utulities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day07_C18_Action4 extends TestBase {
    /*
    Create a class: ActionClass4
    Create test method : scrollUpDown()
    Go to amazon
    Scroll the page down
    Scroll the page up
 */

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        //arrowdown-pagedowm-scrolldown
        Actions action=new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();//daha as kaydırır.
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).perform();//arrow downa göre daha fasla kaydırır
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);


    }
}
