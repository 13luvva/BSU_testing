package by.rw;

import org.junit.Assert;
import org.junit.Test;

public class SecondTest extends WebDriverSettings {

    @Test
    public void SecondTest() {
        driver.get("https://www.rw.by");
        String title = driver.getTitle();

        Assert.assertTrue(title.equals("Официальный сайт - Белорусская железная дорога"));
    }


}
