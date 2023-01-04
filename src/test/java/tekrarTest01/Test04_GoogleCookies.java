package tekrarTest01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utitlities.TestBase;

public class Test04_GoogleCookies extends TestBase {
    //1- C01_TekrarTesti isimli bir class olusturun


    @Test
    public void test01(){
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");


        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedBaslik="Google";
        String actualBaslik=driver.getTitle();

        Assert.assertTrue(expectedBaslik.contains(actualBaslik));

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.findElement(By.id("result-stats"));
        String sonucSayiYazi=sonucSayisi.getText();

        String[] sonucArr=sonucSayiYazi.split(" ");
        String sonucAdedi=sonucArr[1];
        System.out.println(sonucAdedi);



        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       double actualSonuc=Double.parseDouble(sonucAdedi);
       double expectedSonuc=10000000;

       Assert.assertTrue(actualSonuc>expectedSonuc);

    }
}
