package utitlities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusabelMethods {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver)  {

        // 1- TakeScreenshot objesi olustur
        TakesScreenshot tss= (TakesScreenshot) driver;
        // 2- resmi son olarak kaydedecegimiz dosyayi olustur
        // her resim cektiğinde ustuste kaydetmemesi icin
        //resim dosya yoluna tarih ve saat içeren bir yol eklemeliyim
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/tumEkranSS"+tarih+".jpeg";
        File tumSayfaScreenshot= new File(dosyaYolu);
       // 3- tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File geciciDopsya= tss.getScreenshotAs(OutputType.FILE);
        // 4- gecici dosyayi ana dosyaya kopyala

        try {
            FileUtils.copyFile(geciciDopsya,tumSayfaScreenshot);
        } catch (IOException e) {

        }
    }
    public static void elementSSCek(WebElement element){
        // 1- screenshot alacagimiz elementi locate et
        // 2- kaydedecegimiz dosyayi olustur

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/istenenElementSS"+tarih+".jpeg";
        File elementSS= element.getScreenshotAs(OutputType.FILE);


       // 3- gecici dosyayi olusturup, element uzerinden screenshot yapalim

        File gecici= new File(dosyaYolu);

       // 4- gecici dosyayi, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }
    }

}
