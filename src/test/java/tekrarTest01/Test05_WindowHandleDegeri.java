package tekrarTest01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utitlities.TestBase;

public class Test05_WindowHandleDegeri extends TestBase {
    //1. Bir Class olusturalim YanlisEmailTesti

    @Test
    public void test01() {

        //2- Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //3- Sayfa’nin window handle degerini String bir degiskene atayin
        String windowHandleDegeri = driver.getWindowHandle();

        //4- Sayfa title’nin “Amazon” icerdigini test edin
        WebElement baslik = driver.findElement(By.id("nav-logo-sprites"));
        String expectedBaslik = "Amazon";
        String actualBaslik = driver.getTitle();

        Assert.assertTrue(actualBaslik.contains(expectedBaslik));

        //5- Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        //6- Sayfa title’nin “wisequarter” icerdigini test edin

        String expectedSayfaUrl="wisequarter";
        String actualSayfaUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualSayfaUrl.contains(expectedSayfaUrl));

        //7- Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //8- Sayfa title’nin “Walmart” icerdigini test edin
        WebElement sayfaTitle=driver.findElement(By.xpath("//a[@class='dn db-hdkp flex-none pa3 hover-bg-dark-blue pt2']"));
        String expectedSayfaTitle="Walmart";
        String actualSayfaTitle=driver.getTitle();

        Assert.assertTrue(actualSayfaTitle.contains(expectedSayfaTitle));

        //9- Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandleDegeri);
        String expectedBaslik1 = "Amazon";
        String actualBaslik1 = driver.getTitle();

        Assert.assertTrue(actualBaslik1.contains(expectedBaslik1));

    }
}
