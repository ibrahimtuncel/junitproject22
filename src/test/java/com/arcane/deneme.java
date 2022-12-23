package com.arcane;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class deneme {

            @Test
    public void Test1() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                driver.get("https://www.youtube.com/");
                driver.manage().window().maximize();
                driver.findElement(By.cssSelector("input#search")).sendKeys("fas");
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

                //driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
                Thread.sleep(3000);
               // driver.findElement(By.xpath("//button[@title='Duraklat (k)']")).click();
                //Thread.sleep(2000);
                //driver.findElement(By.xpath("//button[@title='Oynat (k)']")).click();
                driver.findElement(By.linkText("TRT SPOR")).click();
                Thread.sleep(4000);
                driver.findElement(By.linkText("2022 Dünya Kupası'nda atılan en güzel goller X MediaMarkt")).click();
                Thread.sleep(4000);
                driver.findElement(By.xpath("//button[@title='Duraklat (k)']")).click();
                Thread.sleep(2000);

                Actions actions = new Actions(driver);
        /*
        Page_Down-> scroll down the page
        Arrow_Down -> scroll down the page
        Page_UP-> scroll up
        Arrow_Up -> scroll up
         */
                actions.
                        sendKeys(Keys.PAGE_DOWN).//Page_Down-> scroll down the page
                        perform();
                Thread.sleep(3000);
                actions.
                        sendKeys(Keys.PAGE_DOWN).
                        perform();// it does twice
                //Arrow_Down scrolls the page down less than Page_Down
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                Thread.sleep(3000);
                actions.sendKeys(Keys.PAGE_UP).perform();
                Thread.sleep(3000);
                /*ARROW_UP moves the page up a little bit*/
                actions.sendKeys(Keys.ARROW_UP).perform();
            }
            @Test
        public void Tyol() throws InterruptedException {
                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                driver.get("https://www.trendyol.com/");
                //String alert=driver.switchTo().alert().getText();
                //System.out.println(alert);
                Thread.sleep(3000);
                //driver.switchTo().alert().dismiss();
                driver.findElement(By.cssSelector("#Rating-Review")).click();

                Actions action=new Actions(driver);
                WebElement giris=driver.findElement(By.xpath("(//p[@class='link-text'])[1]"));
                action.moveToElement(giris).perform();
                Thread.sleep(2000);
                driver.findElement(By.cssSelector(".signup-button")).click();
            }

    }
