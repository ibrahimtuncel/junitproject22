package com.arcane.tests;

import com.arcane.utulities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_C22_dosyaVarmiTesti {
    /*
    Method: dosyaVarmi
    1- Masaustundeki bir dosyayi secin
    2- Bu dosyanin bilgisayarinizda bulunup bulunmadigini verify edin
    */
    @Test
    public void dosyaVarMi(){
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);//C:\Users\lenovo
        //C:\Users\lenovo\Desktop\cicek.jpg
        String cicekPath=homePath+"\\Desktop\\cicek.jpg";
        System.out.println(cicekPath);
        Boolean varMi=Files.exists(Paths.get(cicekPath));
        Assert.assertTrue(varMi);
    }
    @Test
    public void dosyaCheck(){
        String klasör=System.getProperty("user.dir");
        System.out.println(klasör);//C:\Users\lenovo\IdeaProjects\junitproject22
        String home=System.getProperty("user.home");
        System.out.println(home);//C:\Users\lenovo
        String pdf=home+"\\Desktop\\SE Ders 1.pptx";
        System.out.println(pdf);//C:\Users\lenovo\Desktop\SE Ders 1.pptx
        Boolean varMı=Files.exists(Paths.get(pdf));
        System.out.println(varMı);//true
        Assert.assertTrue(varMı);
        String dosya="D:\\YAZILIM\\API";
        System.out.println(dosya);
        Boolean dosyaSor=Files.exists(Paths.get(dosya));
        System.out.println(dosyaSor);
        Assert.assertTrue(dosyaSor);

    }
    

}
