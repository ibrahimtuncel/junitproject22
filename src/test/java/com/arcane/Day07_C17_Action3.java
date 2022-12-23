package com.arcane;

import com.arcane.utulities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_C17_Action3 extends TestBase {
    /*
    1- test method olustur : keysUpDown()
    2- https://www.google.com sayfasina git
    3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
    4- cift tiklayarak search box'i etkilestir
 */

    @Test
    public void keysUpDown() {
        driver.navigate().to("https://www.google.com");
        WebElement searchboks = driver.findElement(By.xpath("//input[@name='q']"));
        //searchboks.sendKeys("iPhone Pro Max");
        Actions actions = new Actions(driver);
        actions.keyDown(searchboks, Keys.SHIFT).//shift e bas kal
                sendKeys("iPhone Pro Max").//metin harfleri büyük yasılır
                keyUp(searchboks, Keys.SHIFT).//shift i bırak
                sendKeys("iphonE cok Pahali" + Keys.ENTER).
                build().perform();
            }
}