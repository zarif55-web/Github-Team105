package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utitlities.ReusabelMethods;
import utitlities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01() {

        // amazon'a gidin
        driver.get("https://www.amazon.com");

        // amazon'a gittiginizi test edin

        String expectedKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReusabelMethods.bekle(3);
    }
}
