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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day04_C9_DropDown {
    //Go to https://the-internet.herokuapp.com/dropdown
//1.selectByIndexTest methodu olustur ve selectByIndex() kullanarak Select Option 1 yapin
//2.selectByValueTest methodu olustur ve selectByValue() kullanarak Select Option 2 yapin
//3.selectByVisibleTextTest  methodu olustur ve visibleText() kullanarak Select Option 1 yapin
//4.printAllTest methodu olusturun ve tum dropdown value (degerlerini) yazdirin
//5.printFirstSelectedOptionTest methodu olusturun ve birinci secilen option'i yazdirin
    // Secili option'in "Please select an Option" oldugunu verify et
//6.sizeTest methodu olusturun ve dropdown size'ini bulun
    // dropdown size'ini bulun, eger dropdown'da 4 element yok ise "Beklenen Acutual'a esit degildir" yazdirin.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void selectByIndexTest() {
        //dropdown elemanlarını bul
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //driver.findElement(By.cssSelector("select#dropdown"));

        //select obje olustur.
        Select select = new Select(dropDown);
        //3 methottan birini kullanarak elementi bulma
        //1.selectByIndexTest
        //2.selectByValueTest
        //3.selectByVisibleTextTest
        select.selectByIndex(1);
        //select.ByValueTest();
        //select.ByVisibleTextTest();
    }
        @Test
        public void selectByValueTest(){
            //dropdown elemanlarını bul
            WebElement dropDown= driver.findElement(By.cssSelector("select#dropdown"));
            //select obje olustur.
            Select select=new Select(dropDown);
            select.selectByValue("2");
        }

        @Test
    public void selectByVisibleTextTest(){
            //dropdown elemanlarını bul
            WebElement dropDown= driver.findElement(By.id("dropdown"));
            //select obje olustur.
            Select select=new Select(dropDown);
            select.selectByVisibleText("Option 2");
        }

        @Test
    public void printAllTest(){
            //dropdown elemanlarını bul
            WebElement dropDown= driver.findElement(By.id("dropdown"));
           Select select=new Select(dropDown);
           //getOptions()  dropdowndaki tum secenekleri List e atar. List<WebElement> döner
            List<WebElement> tumSecenekler=select.getOptions();

            // her bir element for loop ile yasdirilir.
            for(WebElement w:tumSecenekler){
                System.out.println(w.getText());
            }
        }
    //5.printFirstSelectedOptionTest methodu olusturun ve birinci secilen option'i yazdirin
    // Secili option'in "Please select an Option" oldugunu verify et
        @Test
        public void printFirstSelectedOptionTest(){
            //dropdown elemanlarını bul
            WebElement dropDown= driver.findElement(By.id("dropdown"));
            Select select=new Select(dropDown);
           WebElement ilkSecenek= select.getFirstSelectedOption();
            System.out.println(ilkSecenek.getText());
            Assert.assertEquals("Please select an option",ilkSecenek.getText());
        }

    //6.sizeTest methodu olusturun ve dropdown size'ini bulun
    // dropdown size'ini bulun, eger dropdown'da 4 element yok ise "Beklenen Acutual'a esit
    // degildir" yazdirin.
    @Test
    public void sizeTest(){
        //dropdown elemanlarını bul
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropDown);
        List<WebElement>tumSecenekler= select.getOptions();
        int a= tumSecenekler.size();
        Assert.assertEquals("Beklenen Acutual'a esit degildir",3,a);
    }

    @After
    public void After(){
        driver.close();
    }

    }




