package com.arcane;

import com.github.javafaker.Faker;
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

import java.util.concurrent.TimeUnit;

public class Day04_C10_HesapOlusturma {
/* Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma
2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */
    Faker faker=new Faker();
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void hesapOlusturma(){
    ///Create a class HesapOlusturma
    // Go to https://www.automationexercise.com/
    // Signup/Login link'ine click edin
    // Isim ve email adresinizi girin ardindan  Signup button"una click edin
        driver.get("https://www.automationexercise.com");
        //driver.findElement(By.linkText(" Signup / Login")).click();
        WebElement signElement = driver.findElement(By.xpath("//a[@href='/login']"));
        signElement.click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

       // 5. Text'i Verify et : ENTER ACCOUNT INFORMATION
        //6. Text'i Verify et : ADDRESS INFORMATION
        //7. Text'i Verify et : Title
        //8. title'i secin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Enter Account Information'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Address Information']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Title']")).isDisplayed());
        WebElement Mrs= driver.findElement(By.cssSelector("#id_gender2"));
        if(!Mrs.isSelected()){
            Mrs.click();
        }
       // 9. Name girin (var olani degistir)
        ///10. Password girin
        driver.findElement(By.cssSelector("#name")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("#password")).sendKeys(faker.internet().password());
       // Date of Birth (dogum tarihi) girin
        WebElement days=driver.findElement(By.cssSelector("#days"));
        Select daysDrop=new Select(days);
        daysDrop.selectByIndex(15);
        WebElement months= driver.findElement(By.cssSelector("#months"));
        Select monthsDrop=new Select(months);
        monthsDrop.selectByVisibleText("June");
        WebElement years= driver.findElement(By.cssSelector("#years"));
        Select yearsDrop=new Select(years);
        yearsDrop.selectByValue("2008");
        //12. Sign up for our newsletter! click edin
        driver.findElement(By.cssSelector("#newsletter")).click();
        /*WebElement newsletter = driver.findElement(By.xpath("//*[@for='newsletter']"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!newsletter.isSelected()){
            newsletter.click();
        }*/
        //13. Receive special offers from our partners! click edin
        driver.findElement(By.cssSelector("#optin")).click();
        //14. first name girin
        driver.findElement(By.cssSelector("#first_name")).sendKeys(faker.name().firstName());
        //15. last name girin
        driver.findElement(By.cssSelector("#last_name")).sendKeys(faker.name().lastName());
        //16. company girin
        driver.findElement(By.cssSelector("#company")).sendKeys(faker.company().name());
        //17. Address girin
        driver.findElement(By.xpath("//input[@type='text' and @id='address1']")).sendKeys(faker.address().fullAddress());
        //18. Country secin
        WebElement country= driver.findElement(By.cssSelector("#country"));
        Select countryDrop=new Select(country);
        countryDrop.selectByVisibleText("Canada");
        //19. State girin
        driver.findElement(By.cssSelector("#state")).sendKeys(faker.address().state());
        //20. City girin
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        //21. ZipCode girin
        driver.findElement(By.cssSelector("#zipcode")).sendKeys("123-123-000");
        //22. mobile phone girin
        driver.findElement(By.cssSelector("#mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());
        //23. Create Account'u Click edin
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]")).isDisplayed());

    }
    @After
    public void After() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
