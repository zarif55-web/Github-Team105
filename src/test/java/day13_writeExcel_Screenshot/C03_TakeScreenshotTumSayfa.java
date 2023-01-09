package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utitlities.ReusabelMethods;
import utitlities.TestBase;

import java.io.IOException;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon'a gidip
        driver.get("https://www.amazon.com");
        // Nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuclarinin Nutella icerdigini test edin

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));


        // Tum sayfanin screenshot'ini alin

        ReusabelMethods.tumSayfaScreenshotCek(driver);

        ReusabelMethods.bekle(5);
    }
}
