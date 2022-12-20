package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day04_C8_RadioButton {
    /*
    Test method olusturun ve asagidaki task'i tamamlayin.
    https://www.facebook.com/ adresine gidin
    Create an Account button'una click edin
    Radio button'larin elementlerini locate edin
    Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
    Sing Up buttonuna click edip hesap olusturun
    */
    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void radioButton() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        driver.findElement(By.xpath("//input[@name='firstname']"))
                .sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']"))
                .sendKeys(faker.name().lastName());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());
        //Oct 10 1990
        //Locating the month
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(month);
        select.selectByVisibleText("Eki");
        //Locating the day
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        //driver.findElement(By.cssSelector("select#day"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");
        //Locating the year
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select yearDropdown = new Select(year);
        yearDropdown.selectByVisibleText("1990");

        //   Locate the elements of radio buttons
        WebElement maleOption = driver.findElement(By.xpath("(//input[@type='radio' and @value='2'])"));
//        WebElement femaleOption= driver.findElement(By.xpath("(//input[@type='radio' and @value='1'])"));

//        Then click on the radio buttons for your gender if they are not selected
        if (!maleOption.isSelected()) {
            maleOption.click();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }
    /*@Test
    public void dropDown(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        WebElement ayweb= driver.findElement(By.cssSelector("#month"));
        Select ay=new Select(ayweb);
       //ay.selectByVisibleText("Mar");
        WebElement ilkay=ay.getFirstSelectedOption();
        System.out.println("ilk ay: "+ilkay.getText());
        List<WebElement> aylar=ay.getOptions();
        for(WebElement w:aylar){
            System.out.println(w.getText());
        }
        int a=aylar.size();
        System.out.println("aylar usunluk: "+a);
    }*/

    @After
    public void tearDown() {
        driver.close();
    }
}



