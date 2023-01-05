package tekrarTest02;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utitlities.ReusabelMethods;
import utitlities.TestBase;

import java.util.List;

public class Tekrar03_GenelTekrar extends TestBase {
    @Test
    public void test01() {

        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> dropdownKutusu = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        for (WebElement each:dropdownKutusu
             ) {
            System.out.println(each.getText());
        }

        //3- dropdown menude 28 eleman olduğunu doğrulayın
        int expectedArama = 28;
        int actualArama =dropdownKutusu.size();
        Assert.assertFalse(actualArama==expectedArama);
        ReusabelMethods.bekle(3);

    }
    @Test
    public void test02() {
        //1- dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement dropdownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownWebElementi);
        select.selectByIndex(10);


        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);
        ReusabelMethods.bekle(3);

        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazi = sonucYazisi.getText();

        String[] sonucAdedi = sonucYazi.split(" ");
        String sonuc = sonucAdedi[3];
        System.out.println(sonuc);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedKelime = "iphone";
        String actualKelime = sonucYazisi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        ikinciUrun.click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement urunTitle = driver.findElement(By.tagName("h1"));
        WebElement urunFiyat = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]"));
        WebElement sepetteUrun = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]"));
        sepetteUrun.click();
    }


    @Test
    public void test03(){
        //1- yeni bir sekme açarak amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);
        ReusabelMethods.bekle(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        WebElement dropdownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownWebElementi);
        select.selectByIndex(3);
        ReusabelMethods.bekle(3);

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutu.sendKeys("bebek puseti" + Keys.ENTER);
        ReusabelMethods.bekle(3);

        //4-sonuç yazsının puset içerdiğini test edin
        WebElement sonucPuset=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime = "bebek puseti";
        String actualKelime = sonucPuset.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ucuncuUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[3]"));
        ucuncuUrun.click();
        ReusabelMethods.bekle(3);



    }

}
