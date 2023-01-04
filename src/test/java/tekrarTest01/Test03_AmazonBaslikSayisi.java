package tekrarTest01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utitlities.TestBase;

public class Test03_AmazonBaslikSayisi extends TestBase {





    @Test
    public void test01(){
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucSayisiYazisi=sonucSayisi.getText();

        String[] sonucSayisiArr=sonucSayisiYazisi.split(" ");
        String sonucAdeti=sonucSayisiArr[2];
        System.out.println(sonucAdeti);

        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // 6- Sayfadaki tum basliklari yazdiralim
        WebElement basliklar=driver.findElement(By.tagName("h1"));
        System.out.print(basliklar.getText());


    }
}
