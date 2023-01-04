package TekrarTest02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlities.ReusabelMethods;
import utitlities.TestBase;

public class Test01_ActionsClassHomework extends TestBase {
    //Yeni Class olusturun ActionsClassHomeWork

    @Test
    public void test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- "Hover over Me First!" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement secilecekKutu=driver.findElement(By.xpath("//div[@class='dropdown hover']"));

        actions.moveToElement(secilecekKutu).perform();
        ReusabelMethods.bekle(2);

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        ReusabelMethods.bekle(2);

        //4- Popup mesajini yazdirin

        //5- Popup'i tamam diyerek kapatin

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickKutusu=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickKutusu).perform();
        ReusabelMethods.bekle(2);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        //8- “Double click me" butonunu cift tiklayin
        WebElement butonKutusu=driver.findElement(By.id("double-click"));
        actions.doubleClick(butonKutusu).perform();

    }

}
