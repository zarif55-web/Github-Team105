package tekrarTest01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Test02_DropDownAmazon {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //        - Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
    //         -Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin

        WebElement dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropDownElementi);

        List<WebElement> optionsWebElementListesi =select.getOptions();

        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        Thread.sleep(5000);
    }
    @Test
    public void test02(){
        //1. Kategori menusunden Books secenegini secin

        WebElement dropDownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropDownElementi);
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucSayiStr=sonucSayi.getText();


        String[] sonucYazisiArr=sonucSayiStr.split(" ");
        String sonucAdeti=sonucYazisiArr[3];
        System.out.println(sonucAdeti);

        //4. Sonucun Java kelimesini icerdigini test edin

        String expectedKelime="Java";
        String actualKelime=sonucSayi.getText();

       if (actualKelime.contains(expectedKelime)){
           System.out.println("test PASSED");
       }else System.out.println("test FAILED");


    }
}
