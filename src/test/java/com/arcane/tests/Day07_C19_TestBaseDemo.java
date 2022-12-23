package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day07_C19_TestBaseDemo extends TestBase {
    /*
    test1 google'da “balik kizartma tavasi” ara
    Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    ——————————-
    test2 amazon'da “balik kizartma tavasi” ara
    Ardindan sayfanin “balik kizartma tavasi” icerdigini verify et
    */
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("balik kizartma tavasi"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("balik kizartma tavasi"));
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("balik kizartma tavasi"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("balik kizartma tavasi"));
        //System.out.println(driver.getPageSource());
    }



}
