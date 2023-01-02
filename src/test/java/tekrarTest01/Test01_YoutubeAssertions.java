package tekrarTest01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01_YoutubeAssertions {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");

        String expectedBaslik="YouTube";
        String actualBaslik=driver.getTitle();

        Assert.assertEquals(actualBaslik, expectedBaslik);

    }
    @Test
    public void test02(){
        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeResim=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));

        Assert.assertTrue(youtubeResim.isDisplayed());
    }
    @Test
    public void test03(){
        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        WebElement searcBox=driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searcBox.isEnabled());
    }

    @Test
    public void test04(){
       // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedIcermeyeKelime="youtube";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedIcermeyeKelime));
    }

}
