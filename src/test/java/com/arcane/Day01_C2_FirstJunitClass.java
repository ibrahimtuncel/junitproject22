package com.arcane;

import org.junit.*;

public class Day01_C2_FirstJunitClass {
    //@Test : test case olustur. Bu test cases olusturma ve kosturmaya yardimci olur
    // @Before : Runs before each @Test annotation. tekrarlanan pre condition icin kullanilir
    // @After : Runs after each @Test annotation. tekrarlanan post conditions icin kullanilir
    // @AfterClass, @BeforeClass
    // @Ignore: test case atlatmak icin kullanilir

    @Before
    public void setUp(){
        System.out.println("Bu bit setUp metodurur");
    }
    @Test
    public void test01(){
        System.out.println("Test case 1");
    }
    @Ignore
    @Test
    public void test02(){
        System.out.println("Test case 2");
    }
    @Test
    public void test03(){
        System.out.println("Test case 3");
    }
    @After
    public void tearDown(){
        System.out.println("Bu bir tear down metodudur.");
    }

    //*Junit assertion ekpscted=actual assertion yapılır
    @Test
    public void assertion(){
          //1.Assert.assertTrue()
        Assert.assertTrue(3==3);//pass

        //2.Assert.assertFalse()
        //Assert.assertFalse(3==3);//fails
        Assert.assertFalse(4==5);//pass
        Assert.assertFalse("Selenium".contains("a"));//pass

        //3.Assert.assertEquals()
        Assert.assertEquals("java", "java");//pass
        //Assert.assertEquals("Java", "javascript");//fail*/
    }

}
